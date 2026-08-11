package de.fiereu.openmmo.server.game.script

import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.maps.MapManager
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.net.game.packets.NpcUpdatePacket
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.script.generated.kanto.PalletTown_OnTransition
import de.fiereu.openmmo.server.game.script.generated.kanto.PalletTown_ProfessorOaksLab_OnTransition
import de.fiereu.openmmo.server.game.script.generated.kanto.PalletTown_RivalsHouse_OnTransition
import de.fiereu.openmmo.server.game.script.generated.kanto.PewterCity_Gym_EventScript_DefeatedBrock
import de.fiereu.openmmo.server.game.script.generated.kanto.ViridianCity_OnTransition
import de.fiereu.openmmo.server.game.services.DialogService
import de.fiereu.openmmo.server.game.services.NpcService
import de.fiereu.openmmo.server.game.services.ScriptMovementService
import de.fiereu.openmmo.server.game.services.StoryPlayerService
import de.fiereu.openmmo.server.game.services.StoryService
import de.fiereu.openmmo.server.game.session.PENDING_DIALOG
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

private const val KANTO = 0
private const val PALLET_TOWN_BANK = 3
private const val PALLET_TOWN_MAP = 0
private const val INDOOR_PALLET_BANK = 4
private const val OAKS_LAB_MAP = 3
private const val RIVALS_HOUSE_MAP = 2
private const val VIRIDIAN_CITY_MAP = 1
private const val PEWTER_GYM_BANK = 6
private const val PEWTER_GYM_MAP = 2

@OptIn(ExperimentalCoroutinesApi::class)
class KantoStoryScriptTest :
    FunSpec({

      /** Builds a context for a fresh Kanto character standing on one map. */
      suspend fun context(
          store: CharacterStore,
          story: StoryService,
          bankId: Int,
          mapId: Int,
      ): Pair<FakeSession, ScriptContext> {
        val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
        store.updatePosition(charId, 0, 0, bankId.toByte(), mapId.toByte())
        val session =
            FakeSession(characterId = charId, regionId = KANTO, bankId = bankId, mapId = mapId)
        val state = session.attributes[PLAYER_STATE]!!
        val mapManager = MapManager()
        val movement = ScriptMovementService(mapManager, NpcService(mapManager, store), store)
        val species = SpeciesRegistry()
        val moves = MoveRegistry()
        return session to
            ScriptContext(
                session,
                state,
                entityId = -1,
                DialogService(),
                story,
                movement,
                player =
                    StoryPlayerService(
                        store,
                        WildMonFactory(species, moves, LearnsetRegistry(), EntityIdService()),
                        species,
                        moves,
                    ),
            )
      }

      test("entering Oak's lab records the visit") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val story = StoryService(store)
          val (_, ctx) = context(store, story, INDOOR_PALLET_BANK, OAKS_LAB_MAP)

          PalletTown_ProfessorOaksLab_OnTransition.run(ctx)

          ctx.isFlagSet(KantoFlags.FLAG_VISITED_OAKS_LAB) shouldBe true
        }
      }

      test("Pallet Town marks the sign lady done once she has shown her sign") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val story = StoryService(store)
          val (_, ctx) = context(store, story, PALLET_TOWN_BANK, PALLET_TOWN_MAP)
          ctx.setVar(KantoVars.VAR_MAP_SCENE_PALLET_TOWN_SIGN_LADY, 1)

          PalletTown_OnTransition.run(ctx)

          ctx.isFlagSet(KantoFlags.FLAG_WORLD_MAP_PALLET_TOWN) shouldBe true
          ctx.getVar(KantoVars.VAR_MAP_SCENE_PALLET_TOWN_SIGN_LADY) shouldBe 2
        }
      }

      test("Pallet Town keeps the sign lady in front of the sign before the starter") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val story = StoryService(store)
          val (session, ctx) = context(store, story, PALLET_TOWN_BANK, PALLET_TOWN_MAP)

          PalletTown_OnTransition.run(ctx)

          val moves = session.sent.filterIsInstance<NpcUpdatePacket>()
          moves.map { it.x to it.y } shouldBe listOf(5 to 15)
          moves.map { it.regionId } shouldBe listOf(KANTO)
        }
      }

      test("Daisy sits at the table until she has handed over the town map") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val story = StoryService(store)
          val (session, ctx) = context(store, story, INDOOR_PALLET_BANK, RIVALS_HOUSE_MAP)

          PalletTown_RivalsHouse_OnTransition.run(ctx)
          ctx.setVar(KantoVars.VAR_MAP_SCENE_PALLET_TOWN_RIVALS_HOUSE, 2)
          PalletTown_RivalsHouse_OnTransition.run(ctx)

          session.sent.filterIsInstance<NpcUpdatePacket>().map { it.x to it.y } shouldBe
              listOf(5 to 4)
        }
      }

      test("the Viridian tutorial man steps aside once Oak's errand is running") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val story = StoryService(store)
          val (session, ctx) = context(store, story, PALLET_TOWN_BANK, VIRIDIAN_CITY_MAP)

          ViridianCity_OnTransition.run(ctx)
          ctx.setVar(KantoVars.VAR_MAP_SCENE_VIRIDIAN_CITY_OLD_MAN, 1)
          ViridianCity_OnTransition.run(ctx)

          ctx.isFlagSet(KantoFlags.FLAG_WORLD_MAP_VIRIDIAN_CITY) shouldBe true
          session.sent.filterIsInstance<NpcUpdatePacket>().map { it.x to it.y } shouldBe
              listOf(21 to 11, 21 to 8)
        }
      }

      test("beating Brock hands out the first badge, TM39 and the running shoes errand") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val story = StoryService(store)
          val (session, ctx) = context(store, story, PEWTER_GYM_BANK, PEWTER_GYM_MAP)

          val scene = launch { PewterCity_Gym_EventScript_DefeatedBrock.run(ctx) }
          // Every line of the reward waits on the player closing its box.
          var boxes = 0
          while (!scene.isCompleted && boxes++ < 10) {
            advanceUntilIdle()
            session.attributes[PENDING_DIALOG]?.complete(Unit)
          }
          advanceUntilIdle()
          scene.join()

          ctx.isFlagSet(KantoFlags.FLAG_BADGE01_GET) shouldBe true
          ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_BROCK) shouldBe true
          ctx.getVar(KantoVars.VAR_MAP_SCENE_PEWTER_CITY) shouldBe 1
          ctx.isFlagSet(KantoFlags.FLAG_GOT_TM39_FROM_BROCK) shouldBe true
          // The gym's own trainer is retired with its leader, and the guide outside is replaced by
          // Oak's aide with the running shoes.
          ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_CAMPER_LIAM) shouldBe true
          ctx.isFlagSet(KantoFlags.FLAG_HIDE_PEWTER_CITY_GYM_GUIDE) shouldBe true
          ctx.isFlagSet(KantoFlags.FLAG_HIDE_PEWTER_CITY_RUNNING_SHOES_GUY) shouldBe false
        }
      }
    })
