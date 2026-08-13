package de.fiereu.openmmo.server.game.services

import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.maps.MapManager
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import de.fiereu.openmmo.server.game.world.interest.InterestManager
import de.fiereu.openmmo.server.game.world.interest.PassThroughInterestPolicy
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

private const val CHARMANDER = 4

/** Pallet Town, where a new character's respawn point points until a gym moves it. */
private const val PALLET_TOWN_BANK = 3
private const val PALLET_TOWN_MAP = 0

@OptIn(ExperimentalCoroutinesApi::class)
class WhiteoutServiceTest :
    FunSpec({
      class Fixture(store: CharacterStore) {
        private val mapManager = MapManager()
        private val mapLoad = MapLoadService(mapManager)
        private val species = SpeciesRegistry()
        private val moves = MoveRegistry()
        val story = StoryService(store)
        val player =
            StoryPlayerService(
                store,
                WildMonFactory(species, moves, LearnsetRegistry(), EntityIdService()),
                species,
                moves,
            )
        val whiteout =
            WhiteoutService(
                story,
                player,
                ScriptWarpService(
                    mapManager,
                    mapLoad,
                    store,
                    PresenceService(InterestManager(), PassThroughInterestPolicy(), mapLoad, store),
                ),
                store,
            )
      }

      /** A beaten trainer standing somewhere other than their heal location. */
      suspend fun beatenPlayer(
          store: CharacterStore,
          f: Fixture,
          level: Int = 20,
      ): Pair<FakeSession, Long> {
        val id = store.createCharacter(1, "Red", CharacterGender.MALE, Region.KANTO).info.id
        val session = FakeSession(characterId = id, bankId = 3, mapId = 1)
        val state = session.attributes[PLAYER_STATE]!!
        state.regionId = Region.KANTO.wireValue.toInt()
        f.player.givePokemon(session, state, CHARMANDER, level, listOf(33))
        val fainted = store.getCharacter(id)!!.pokemon.single().copy(hp = 0)
        store.updatePokemon(id, fainted)
        return session to id
      }

      test(
          "a whiteout costs four times the top level, wakes the player up at their heal location") {
            runTest {
              val store =
                  CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
              val f = Fixture(store)
              val (session, id) = beatenPlayer(store, f)
              val state = session.attributes[PLAYER_STATE]!!
              val before = f.player.money(state)

              f.whiteout.whiteout(session, state)

              // No badge yet, so the multiplier is the lowest of the nine.
              f.player.money(state) shouldBe before - 20 * 4 * 2
              state.bankId shouldBe PALLET_TOWN_BANK
              state.mapId shouldBe PALLET_TOWN_MAP
              state.x.toInt() shouldBe 6
              state.y.toInt() shouldBe 8
              store.getCharacter(id)!!.pokemon.single().hp.toInt() shouldBeGreaterThan 0
            }
          }

      test("every badge makes the loss steeper") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val f = Fixture(store)
          val (session, id) = beatenPlayer(store, f)
          val state = session.attributes[PLAYER_STATE]!!
          f.story.setFlag(id, KantoFlags.FLAG_BADGE01_GET)
          f.story.setFlag(id, KantoFlags.FLAG_BADGE02_GET)
          val before = f.player.money(state)

          f.whiteout.whiteout(session, state)

          f.player.money(state) shouldBe before - 20 * 4 * 6
        }
      }

      test("a player who cannot pay hands over what they have and no more") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val f = Fixture(store)
          val (session, _) = beatenPlayer(store, f, level = 100)
          val state = session.attributes[PLAYER_STATE]!!
          // A hundredth level party would cost 800, far past a starting purse.
          f.player.changeMoney(session, state, -(f.player.money(state) - 100))

          f.whiteout.whiteout(session, state)

          f.player.money(state) shouldBe 0
        }
      }

      test("a character with no heal location stays where they fell") {
        runTest {
          val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), backgroundScope)
          val f = Fixture(store)
          val (session, id) = beatenPlayer(store, f)
          val state = session.attributes[PLAYER_STATE]!!
          store
              .getCharacter(id)!!
              .storyVars
              .keys
              .filter { it.startsWith("RESPAWN_") }
              .forEach { store.setStoryVar(id, it, 0) }
          val before = f.player.money(state)

          f.whiteout.whiteout(session, state)

          f.player.money(state) shouldBe before
          state.mapId shouldBe 1
        }
      }
    })
