package de.fiereu.openmmo.server.game.script

import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.maps.MapManager
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.script.generated.kanto.CeladonCity_Gym_EventScript_DefeatedErika
import de.fiereu.openmmo.server.game.script.generated.kanto.CeruleanCity_Gym_EventScript_MistyDefeated
import de.fiereu.openmmo.server.game.script.generated.kanto.CinnabarIsland_Gym_EventScript_DefeatedBlaine
import de.fiereu.openmmo.server.game.script.generated.kanto.FuchsiaCity_Gym_EventScript_DefeatedKoga
import de.fiereu.openmmo.server.game.script.generated.kanto.PewterCity_Gym_EventScript_DefeatedBrock
import de.fiereu.openmmo.server.game.script.generated.kanto.SaffronCity_Gym_EventScript_DefeatedSabrina
import de.fiereu.openmmo.server.game.script.generated.kanto.VermilionCity_Gym_EventScript_DefeatedLtSurge
import de.fiereu.openmmo.server.game.script.generated.kanto.ViridianCity_Gym_EventScript_DefeatedGiovanni
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
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

private const val KANTO = 0

/** Every gym's "leader beaten" script, paired with the badge it is supposed to raise. */
private val GYMS =
    listOf(
        Triple("Brock", PewterCity_Gym_EventScript_DefeatedBrock, KantoFlags.FLAG_BADGE01_GET),
        Triple("Misty", CeruleanCity_Gym_EventScript_MistyDefeated, KantoFlags.FLAG_BADGE02_GET),
        Triple(
            "Lt. Surge",
            VermilionCity_Gym_EventScript_DefeatedLtSurge,
            KantoFlags.FLAG_BADGE03_GET,
        ),
        Triple("Erika", CeladonCity_Gym_EventScript_DefeatedErika, KantoFlags.FLAG_BADGE04_GET),
        Triple("Koga", FuchsiaCity_Gym_EventScript_DefeatedKoga, KantoFlags.FLAG_BADGE05_GET),
        Triple("Sabrina", SaffronCity_Gym_EventScript_DefeatedSabrina, KantoFlags.FLAG_BADGE06_GET),
        Triple(
            "Blaine",
            CinnabarIsland_Gym_EventScript_DefeatedBlaine,
            KantoFlags.FLAG_BADGE07_GET,
        ),
        Triple(
            "Giovanni",
            ViridianCity_Gym_EventScript_DefeatedGiovanni,
            KantoFlags.FLAG_BADGE08_GET,
        ),
    )

@OptIn(ExperimentalCoroutinesApi::class)
class KantoBadgeChainTest :
    FunSpec({
      suspend fun context(store: CharacterStore): Pair<FakeSession, ScriptContext> {
        val charId = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
        val session = FakeSession(characterId = charId, regionId = KANTO)
        val maps = MapManager()
        val species = SpeciesRegistry()
        val moves = MoveRegistry()
        return session to
            ScriptContext(
                session,
                session.attributes[PLAYER_STATE]!!,
                entityId = -1,
                DialogService(),
                StoryService(store),
                ScriptMovementService(maps, NpcService(maps, store), store),
                player =
                    StoryPlayerService(
                        store,
                        WildMonFactory(species, moves, LearnsetRegistry(), EntityIdService()),
                        species,
                        moves,
                    ),
            )
      }

      /** Runs a reward scene, closing every box it puts up. */
      suspend fun TestScope.play(session: FakeSession, script: Script, ctx: ScriptContext) {
        val scene = launch { script.run(ctx) }
        var boxes = 0
        while (!scene.isCompleted && boxes++ < 20) {
          advanceUntilIdle()
          session.attributes[PENDING_DIALOG]?.complete(Unit)
        }
        advanceUntilIdle()
        scene.join()
      }

      test("every gym raises its own badge and no other") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val (session, ctx) = context(store)

          GYMS.forEachIndexed { index, (leader, script, badge) ->
            play(session, script, ctx)
            withClue(leader) {
              ctx.isFlagSet(badge) shouldBe true
              // The badges only ever move forward, one gym at a time.
              GYMS.drop(index + 1).forEach { (_, _, later) -> ctx.isFlagSet(later) shouldBe false }
            }
          }
        }
      }

      test("the Viridian gym stays shut until the six badges its leader asks for are in") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val (session, ctx) = context(store)
          val gymDoor = KantoVars.VAR_MAP_SCENE_VIRIDIAN_CITY_GYM_DOOR

          // Brock's badge is not one of the six, so it alone changes nothing.
          play(session, PewterCity_Gym_EventScript_DefeatedBrock, ctx)
          ViridianCity_OnTransition.run(ctx)
          ctx.getVar(gymDoor) shouldBe 0

          // Every gym from Cerulean to Cinnabar, stopping one short each time.
          GYMS.subList(1, 7).dropLast(1).forEach { (_, script, _) -> play(session, script, ctx) }
          ViridianCity_OnTransition.run(ctx)
          withClue("five of the six badges") { ctx.getVar(gymDoor) shouldBe 0 }

          play(session, GYMS[6].second, ctx)
          ViridianCity_OnTransition.run(ctx)
          ctx.getVar(gymDoor) shouldBe 1
        }
      }
    })
