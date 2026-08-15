package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.net.game.packets.ChatMessagePacket
import de.fiereu.openmmo.net.game.packets.LocalCharacterDeltaPacket
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.BattleRng
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.services.StoryPlayerService
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
class AdminCommandsTest :
    FunSpec({
      fun FakeSession.replies() = sent.filterIsInstance<ChatMessagePacket>().map { it.message }

      test("heal command restores HP and PP of party Pokemon") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val info = store.getCharacter(charId)!!.info
          store.updateCharacter(
              info.copy(permissions = info.permissions or CharacterPermissions.DEVELOPER))

          val species = SpeciesRegistry()
          val moves = MoveRegistry()
          val learnsets = LearnsetRegistry()
          val entityIdService = EntityIdService()
          val monFactory = WildMonFactory(species, moves, learnsets, entityIdService)
          val storyService = StoryPlayerService(store, monFactory, species, moves)

          // Add a damaged Pokemon
          val base = monFactory.create(1, 5, BattleRng())!!
          val p =
              base.copy(
                  ownerId = charId,
                  container = PokemonContainer.PARTY,
                  containerSlot = 0,
                  hp = 1,
                  moves =
                      listOf(
                          PokemonMove(33, 0),
                          PokemonMove(45, 0),
                          PokemonMove(0, 0),
                          PokemonMove(0, 0)),
              )
          store.addPokemon(charId, p)

          val session = FakeSession(characterId = charId)
          val healCommand = HealCommand(storyService)
          val service = ChatCommandService(store, setOf(healCommand))

          service.tryHandle(session, "/heal") shouldBe true
          session.replies().single() shouldContain "Party fully healed!"

          val updated = store.getCharacter(charId)!!.pokemon.first()
          val maxHp =
              de.fiereu.openmmo.server.game.battle.StatCalculator.computeAll(
                      species.get(1)!!, updated)
                  .hp
                  .toShort()
          updated.hp shouldBe maxHp
          updated.moves[0].pp shouldBe 35
          updated.moves[1].pp shouldBe 40
        }
      }

      test("item command grants items by ID and by name") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val info = store.getCharacter(charId)!!.info
          store.updateCharacter(
              info.copy(permissions = info.permissions or CharacterPermissions.DEVELOPER))

          val species = SpeciesRegistry()
          val moves = MoveRegistry()
          val learnsets = LearnsetRegistry()
          val entityIdService = EntityIdService()
          val monFactory = WildMonFactory(species, moves, learnsets, entityIdService)
          val storyService = StoryPlayerService(store, monFactory, species, moves)

          val session = FakeSession(characterId = charId)
          val itemCommand = ItemCommand(storyService)
          val service = ChatCommandService(store, setOf(itemCommand))

          service.tryHandle(session, "/item master_ball 5") shouldBe true
          session.replies().last() shouldContain "Added 5 x item"
          store.getCharacter(charId)!!.items[Items.MASTER_BALL] shouldBe 5

          service.tryHandle(session, "/item rare_candy 10") shouldBe true
          session.replies().last() shouldContain "Added 10 x item"
          store.getCharacter(charId)!!.items[Items.RARE_CANDY] shouldBe 10
        }
      }

      test("givepkmn adds a valid species to party") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val info = store.getCharacter(charId)!!.info
          store.updateCharacter(
              info.copy(permissions = info.permissions or CharacterPermissions.DEVELOPER))

          val species = SpeciesRegistry()
          val moves = MoveRegistry()
          val learnsets = LearnsetRegistry()
          val entityIdService = EntityIdService()
          val monFactory = WildMonFactory(species, moves, learnsets, entityIdService)
          val storyService = StoryPlayerService(store, monFactory, species, moves)

          val session = FakeSession(characterId = charId)
          val givePkmn = GivePkmnCommand(storyService, species, learnsets)
          val service = ChatCommandService(store, setOf(givePkmn))

          service.tryHandle(session, "/givepkmn pikachu 25") shouldBe true
          session.replies().single() shouldContain "Added Lv.25"
          val mon = store.getCharacter(charId)!!.pokemon.single()
          mon.dexId shouldBe 25
          mon.level shouldBe 25
        }
      }

      test("money command updates money and sends delta packet") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val info = store.getCharacter(charId)!!.info
          store.updateCharacter(
              info.copy(
                  permissions = info.permissions or CharacterPermissions.DEVELOPER, money = 1000))

          val session = FakeSession(characterId = charId)
          val moneyCommand = MoneyCommand(store)
          val service = ChatCommandService(store, setOf(moneyCommand))

          service.tryHandle(session, "/money 5000") shouldBe true
          session.replies().single() shouldContain "¥6000"
          store.getCharacter(charId)!!.info.money shouldBe 6000
          session.sent.filterIsInstance<LocalCharacterDeltaPacket>().single().money shouldBe 6000
        }
      }

      test("flag and var commands manipulate story state") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
          val info = store.getCharacter(charId)!!.info
          store.updateCharacter(
              info.copy(permissions = info.permissions or CharacterPermissions.DEVELOPER))

          val session = FakeSession(characterId = charId)
          val setFlag = SetFlagCommand(store)
          val clearFlag = ClearFlagCommand(store)
          val setVar = SetVarCommand(store)
          val service = ChatCommandService(store, setOf(setFlag, clearFlag, setVar))

          service.tryHandle(session, "/setflag FLAG_TEST") shouldBe true
          store.getCharacter(charId)!!.storyFlags shouldContain "FLAG_TEST"

          service.tryHandle(session, "/clearflag FLAG_TEST") shouldBe true
          ("FLAG_TEST" in store.getCharacter(charId)!!.storyFlags) shouldBe false

          service.tryHandle(session, "/setvar VAR_TEST 42") shouldBe true
          store.getCharacter(charId)!!.storyVars["VAR_TEST"] shouldBe 42
        }
      }
    })
