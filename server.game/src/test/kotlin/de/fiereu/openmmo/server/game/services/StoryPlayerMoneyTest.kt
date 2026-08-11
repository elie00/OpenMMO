package de.fiereu.openmmo.server.game.services

import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.net.game.packets.LocalCharacterDeltaPacket
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
class StoryPlayerMoneyTest :
    FunSpec({
      fun service(store: CharacterStore): StoryPlayerService {
        val species = SpeciesRegistry()
        val moves = MoveRegistry()
        return StoryPlayerService(
            store,
            WildMonFactory(species, moves, LearnsetRegistry(), EntityIdService()),
            species,
            moves,
        )
      }

      test("paying takes the money and tells the client the new balance") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val id = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val session = FakeSession(characterId = id)
          val state = session.attributes[PLAYER_STATE]!!
          val player = service(store)
          val before = player.money(state)

          player.changeMoney(session, state, -500) shouldBe true

          player.money(state) shouldBe before - 500
          session.sent.filterIsInstance<LocalCharacterDeltaPacket>().single().money shouldBe
              before - 500
        }
      }

      test("a purchase the player cannot afford changes nothing") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val id = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val session = FakeSession(characterId = id)
          val state = session.attributes[PLAYER_STATE]!!
          val player = service(store)
          val before = player.money(state)

          player.changeMoney(session, state, -(before + 1)) shouldBe false

          player.money(state) shouldBe before
          session.sent.filterIsInstance<LocalCharacterDeltaPacket>().shouldBeEmpty()
        }
      }
    })
