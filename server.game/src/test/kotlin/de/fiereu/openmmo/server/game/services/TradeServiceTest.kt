package de.fiereu.openmmo.server.game.services

import de.fiereu.network.PacketEvent
import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.EVs
import de.fiereu.openmmo.common.enums.IVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.net.game.packets.TradeActionPacket
import de.fiereu.openmmo.net.game.packets.TradeListEntryPacket
import de.fiereu.openmmo.net.game.packets.TradeSelectMonPacket
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.session.PlayerState
import de.fiereu.openmmo.server.game.session.SessionRegistry
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class TradeServiceTest :
    FunSpec({
      test("Two players can initiate a trade, offer Pokémon, and execute atomic swap") {
        val repo = FakeCharacterRepository()
        val ids = EntityIdService()
        val store = CharacterStore(repo, ids, CoroutineScope(Dispatchers.Unconfined))
        val sessions = SessionRegistry()
        val service = TradeService(store, sessions)

        // Create player 1 (Red)
        val p1 = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO)
        val s1 = FakeSession(101L)
        s1.attributes[PLAYER_STATE] = PlayerState(1, p1.info.id)
        sessions.bindCharacter(s1, p1.info.id)

        val pikachu =
            Pokemon(
                id = 1001L,
                ownerId = p1.info.id,
                container = PokemonContainer.PARTY,
                containerSlot = 0,
                dexId = 25,
                seed = 0,
                ot = "Red",
                nickname = "Pikachu",
                level = 25,
                hp = 60,
                xp = 0,
                eVs = EVs(),
                iVs = IVs(),
                moves = listOf(PokemonMove(33, 35)),
                isShiny = false,
                hasHiddenAbility = false,
                isAlpha = false,
                isSecret = false,
                isFatefulEncounter = false,
                isRaidEncounter = false,
                caughtAt = LocalDateTime.now(),
            )
        store.addPokemon(p1.info.id, pikachu)

        // Create player 2 (Blue)
        val p2 = store.createCharacter(2, "Blue", CharacterGender.MALE, Region.KANTO)
        val s2 = FakeSession(102L)
        s2.attributes[PLAYER_STATE] = PlayerState(2, p2.info.id)
        sessions.bindCharacter(s2, p2.info.id)

        val eevee =
            Pokemon(
                id = 1002L,
                ownerId = p2.info.id,
                container = PokemonContainer.PARTY,
                containerSlot = 0,
                dexId = 133,
                seed = 0,
                ot = "Blue",
                nickname = "Eevee",
                level = 25,
                hp = 65,
                xp = 0,
                eVs = EVs(),
                iVs = IVs(),
                moves = listOf(PokemonMove(33, 35)),
                isShiny = false,
                hasHiddenAbility = false,
                isAlpha = false,
                isSecret = false,
                isFatefulEncounter = false,
                isRaidEncounter = false,
                caughtAt = LocalDateTime.now(),
            )
        store.addPokemon(p2.info.id, eevee)

        // Red requests trade with Blue, Blue accepts
        service.requestTrade(s1, "Blue")
        service.requestTrade(s2, "Red")

        // Red selects Pikachu (slot 0)
        service.onTradeSelectMon(PacketEvent(TradeSelectMonPacket(slotIndex = 0), s1))
        // Blue should have received Pikachu packet
        s2.sent.filterIsInstance<TradeListEntryPacket>().first().pokemon.dexId shouldBe 25

        // Blue selects Eevee (slot 0)
        service.onTradeSelectMon(PacketEvent(TradeSelectMonPacket(slotIndex = 0), s2))
        // Red should have received Eevee packet
        s1.sent.filterIsInstance<TradeListEntryPacket>().first().pokemon.dexId shouldBe 133

        // Both lock offer (action 1)
        service.onTradeAction(PacketEvent(TradeActionPacket(action = 1), s1))
        service.onTradeAction(PacketEvent(TradeActionPacket(action = 1), s2))

        // Both accept trade (action 2)
        service.onTradeAction(PacketEvent(TradeActionPacket(action = 2), s1))
        service.onTradeAction(PacketEvent(TradeActionPacket(action = 2), s2))

        // Check ownership swap
        val p1Updated = store.getCharacter(p1.info.id)!!
        val p2Updated = store.getCharacter(p2.info.id)!!

        p1Updated.pokemon.first().dexId shouldBe 133 // Red now has Eevee
        p1Updated.pokemon.first().ownerId shouldBe p1.info.id

        p2Updated.pokemon.first().dexId shouldBe 25 // Blue now has Pikachu
        p2Updated.pokemon.first().ownerId shouldBe p2.info.id
      }

      test("Trade cancellation resets trade session cleanly") {
        val repo = FakeCharacterRepository()
        val ids = EntityIdService()
        val store = CharacterStore(repo, ids, CoroutineScope(Dispatchers.Unconfined))
        val sessions = SessionRegistry()
        val service = TradeService(store, sessions)

        val p1 = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO)
        val s1 = FakeSession(101L)
        s1.attributes[PLAYER_STATE] = PlayerState(1, p1.info.id)
        sessions.bindCharacter(s1, p1.info.id)

        val p2 = store.createCharacter(2, "Blue", CharacterGender.MALE, Region.KANTO)
        val s2 = FakeSession(102L)
        s2.attributes[PLAYER_STATE] = PlayerState(2, p2.info.id)
        sessions.bindCharacter(s2, p2.info.id)

        service.requestTrade(s1, "Blue")
        service.requestTrade(s2, "Red")

        // Red cancels trade (action 0)
        service.onTradeAction(PacketEvent(TradeActionPacket(action = 0), s1))

        // Can start new trade afterwards without busy error
        service.requestTrade(s1, "Blue")
      }
    })
