package de.fiereu.openmmo.server.game.script

import de.fiereu.network.PacketEvent
import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.BattleAction
import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.EVs
import de.fiereu.openmmo.common.enums.IVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.maps.MapManager
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.net.game.packets.MapLoadedAckPacket
import de.fiereu.openmmo.net.game.packets.StoryFlagUpdatePacket
import de.fiereu.openmmo.net.game.packets.battle.BattleActionSelectPacket
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.BattlePacketEmitter
import de.fiereu.openmmo.server.game.battle.BattleRegistry
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.battle.BattleRewards
import de.fiereu.openmmo.server.game.battle.MoveLearner
import de.fiereu.openmmo.server.game.battle.TurnEngine
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.services.BattleService
import de.fiereu.openmmo.server.game.services.DialogService
import de.fiereu.openmmo.server.game.services.NpcService
import de.fiereu.openmmo.server.game.services.ScriptMovementService
import de.fiereu.openmmo.server.game.services.StoryService
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import de.fiereu.openmmo.server.game.world.interest.InterestManager
import de.fiereu.openmmo.trainer.TrainerRegistry
import de.fiereu.openmmo.typechart.TypeChart
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest

private const val BULBASAUR = 1
private const val TACKLE: Short = 33

private fun bulbasaur(ownerId: Long, level: Byte, hp: Short): Pokemon =
    Pokemon(
        id = EntityIdService().newMonsterId(),
        ownerId = ownerId,
        container = PokemonContainer.PARTY,
        containerSlot = 0,
        dexId = BULBASAUR,
        seed = 0,
        ot = "Ash",
        nickname = "",
        level = level,
        hp = hp,
        xp = 0,
        eVs = EVs(),
        iVs = IVs(),
        moves =
            listOf(
                PokemonMove(TACKLE, 35), PokemonMove(0, 0), PokemonMove(0, 0), PokemonMove(0, 0)),
        isShiny = false,
        hasHiddenAbility = false,
        isAlpha = false,
        isSecret = false,
        isFatefulEncounter = false,
        isRaidEncounter = false,
        caughtAt = LocalDateTime.now(),
    )

private class Fixture(scope: CoroutineScope) {
  val store = CharacterStore(FakeCharacterRepository(), EntityIdService(), scope)
  val interestManager = InterestManager()
  val registry = BattleRegistry()
  val trainers = TrainerRegistry()
  val service =
      BattleService(
          characterStore = store,
          battles = registry,
          engine = TurnEngine(MoveRegistry(), TypeChart()),
          wildMons =
              WildMonFactory(
                  SpeciesRegistry(), MoveRegistry(), LearnsetRegistry(), EntityIdService()),
          emitter = BattlePacketEmitter(interestManager),
          rewards = BattleRewards(),
          moveLearner = MoveLearner(LearnsetRegistry(), MoveRegistry()),
          interestManager = interestManager,
          speciesRegistry = SpeciesRegistry(),
          moveRegistry = MoveRegistry(),
          trainers = trainers,
      )

  fun context(session: FakeSession, story: StoryService): ScriptContext {
    val state = session.attributes[PLAYER_STATE]!!
    val maps = MapManager()
    return ScriptContext(
        session,
        state,
        entityId = -1,
        DialogService(),
        story,
        ScriptMovementService(maps, NpcService(maps, store), store),
        battles = service,
    )
  }
}

@OptIn(ExperimentalCoroutinesApi::class)
class TrainerBattleFlagTest :
    FunSpec({
      test("hasBeatenTrainer reads the region namespaced story key") {
        runTest {
          val fx = Fixture(backgroundScope)
          val created = fx.store.createCharacter(1, "Ash", CharacterGender.MALE, Region.KANTO)
          val story = StoryService(fx.store)
          // The key follows the region the player stands in, not the one they were created in.
          val ctx = fx.context(FakeSession(created.info.id, regionId = 0), story)

          ctx.hasBeatenTrainer(118) shouldBe false

          story.setFlag(created.info.id, "kanto/trainer/118")

          ctx.hasBeatenTrainer(118) shouldBe true
          // The neighbouring id is a different key, so one win does not clear the route.
          ctx.hasBeatenTrainer(119) shouldBe false
        }
      }

      test("the same trainer id in another region is a different key") {
        runTest {
          val fx = Fixture(backgroundScope)
          val created = fx.store.createCharacter(1, "May", CharacterGender.FEMALE, Region.HOENN)
          val story = StoryService(fx.store)
          // regionId 1 is Hoenn, so the Kanto key must not answer for it.
          val session = FakeSession(created.info.id).also { it.attributes[PLAYER_STATE]!! }
          story.setFlag(created.info.id, "kanto/trainer/118")

          fx.context(session, story).hasBeatenTrainer(118) shouldBe false
        }
      }

      test("a trainer the registry does not hold is never marked beaten") {
        runTest {
          val fx = Fixture(backgroundScope)
          val created = fx.store.createCharacter(1, "Ash", CharacterGender.MALE, Region.KANTO)
          val story = StoryService(fx.store)
          val ctx = fx.context(FakeSession(created.info.id, regionId = 0), story)

          ctx.trainerBattle(4242) shouldBe BattleResult.FAILED

          ctx.hasBeatenTrainer(4242) shouldBe false
        }
      }

      test("winning marks the trainer beaten and sends the client no flag packet") {
        runTest {
          val fx = Fixture(backgroundScope)
          val created = fx.store.createCharacter(1, "Ash", CharacterGender.MALE, Region.KANTO)
          fx.store.addPokemon(created.info.id, bulbasaur(created.info.id, 50, 999))
          // Kanto trainer 1 comes from the generated registry with a single level 5 monster, so a
          // level 50 starter closes it out in a few turns.
          fx.trainers.get(Region.KANTO, 1).shouldNotBeNull().party.size shouldBe 1
          val story = StoryService(fx.store)
          val session = FakeSession(created.info.id, regionId = 0)
          val ctx = fx.context(session, story)

          val outcome = CompletableDeferred<BattleResult>()
          backgroundScope.launch { outcome.complete(ctx.trainerBattle(1)) }
          runCurrent()

          var rounds = 0
          while (fx.registry.byChar(created.info.id)?.pendingResult == null && rounds < 20) {
            fx.service.onBattleAction(
                PacketEvent(BattleActionSelectPacket(0, BattleAction.MOVE, TACKLE, 0L, 0), session))
            runCurrent()
            rounds += 1
          }
          // The battle only completes once the client acknowledges the transition out of it.
          fx.service.onClientReady(PacketEvent(MapLoadedAckPacket(), session))
          advanceUntilIdle()

          outcome.await() shouldBe BattleResult.VICTORY
          ctx.hasBeatenTrainer(1) shouldBe true
          // The key is ours, not a decomp flag, so the client is told nothing about it.
          session.sent.filterIsInstance<StoryFlagUpdatePacket>() shouldBe emptyList()
        }
      }
    })
