package de.fiereu.openmmo.server.game.script

import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.maps.MapManager
import de.fiereu.openmmo.server.game.script.generated.kanto.VAR_SWITCH_1
import de.fiereu.openmmo.server.game.script.generated.kanto.VAR_SWITCH_2
import de.fiereu.openmmo.server.game.script.generated.kanto.VermilionCity_GymScripts
import de.fiereu.openmmo.server.game.script.generated.kanto.VermilionCity_Gym_OnTransition
import de.fiereu.openmmo.server.game.services.DialogService
import de.fiereu.openmmo.server.game.services.NpcService
import de.fiereu.openmmo.server.game.services.ScriptMovementService
import de.fiereu.openmmo.server.game.services.StoryService
import de.fiereu.openmmo.server.game.session.PENDING_DIALOG
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

private const val KANTO = 0
private const val GYM_BANK = 9
private const val GYM_MAP = 6
private const val CANS = 15
private const val CANS_PER_ROW = 5

@OptIn(ExperimentalCoroutinesApi::class)
class VermilionGymPuzzleTest :
    FunSpec({
      suspend fun context(store: CharacterStore): Pair<FakeSession, ScriptContext> {
        val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
        val session =
            FakeSession(characterId = charId, regionId = KANTO, bankId = GYM_BANK, mapId = GYM_MAP)
        val state = session.attributes[PLAYER_STATE]!!
        val maps = MapManager()
        return session to
            ScriptContext(
                session,
                state,
                entityId = -1,
                DialogService(),
                StoryService(store),
                ScriptMovementService(maps, NpcService(maps, store), store),
            )
      }

      /** Searches one can and closes every box it puts up. */
      suspend fun TestScope.search(session: FakeSession, ctx: ScriptContext, can: Int) {
        val script = VermilionCity_GymScripts["VermilionCity_Gym_EventScript_TrashCan$can"]!!
        val scene = launch { script.run(ctx) }
        var boxes = 0
        while (!scene.isCompleted && boxes++ < 5) {
          advanceUntilIdle()
          session.attributes[PENDING_DIALOG]?.complete(Unit)
        }
        advanceUntilIdle()
        scene.join()
      }

      test("the second switch is always next to the first") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val (_, ctx) = context(store)

          // Random placement, so check the invariant over many rounds rather than one.
          repeat(200) {
            VermilionCity_Gym_OnTransition.run(ctx)
            val first = ctx.getVar(VAR_SWITCH_1)
            val second = ctx.getVar(VAR_SWITCH_2)
            first shouldBeInRange 1..CANS
            second shouldBeInRange 1..CANS
            val neighbours = buildList {
              if (first % CANS_PER_ROW != 0) add(first + 1)
              if (first % CANS_PER_ROW != 1) add(first - 1)
              if (first + CANS_PER_ROW <= CANS) add(first + CANS_PER_ROW)
              if (first - CANS_PER_ROW >= 1) add(first - CANS_PER_ROW)
            }
            neighbours shouldContain second
          }
        }
      }

      test("a wrong second guess resets the first lock and moves both switches") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val (session, ctx) = context(store)
          VermilionCity_Gym_OnTransition.run(ctx)

          search(session, ctx, ctx.getVar(VAR_SWITCH_1))
          ctx.isFlagSet(KantoFlags.FLAG_TEMP_1) shouldBe true

          val wrong = (1..CANS).first { it != ctx.getVar(VAR_SWITCH_2) }
          search(session, ctx, wrong)

          ctx.isFlagSet(KantoFlags.FLAG_TEMP_1) shouldBe false
          ctx.isFlagSet(KantoFlags.FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES) shouldBe false
        }
      }

      test("both switches in order open the locks for good") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val (session, ctx) = context(store)
          VermilionCity_Gym_OnTransition.run(ctx)

          search(session, ctx, ctx.getVar(VAR_SWITCH_1))
          search(session, ctx, ctx.getVar(VAR_SWITCH_2))

          ctx.isFlagSet(KantoFlags.FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES) shouldBe true
          // Re-entering the gym leaves an opened barrier alone.
          val opened = ctx.getVar(VAR_SWITCH_1)
          VermilionCity_Gym_OnTransition.run(ctx)
          ctx.getVar(VAR_SWITCH_1) shouldBe opened
        }
      }
    })
