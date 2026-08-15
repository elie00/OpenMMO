package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.EVs
import de.fiereu.openmmo.common.enums.IVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import de.fiereu.openmmo.typechart.TypeChart
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

private const val PLAYER_ID = 0x1C000L
private const val WILD_ID = 0x3C000L

private const val TACKLE: Short = 33
private const val THUNDER_WAVE: Short = 86
private const val WILL_O_WISP: Short = 261
private const val TOXIC_MOVE: Short = 92
private const val ABSORB_MOVE: Short = 71
private const val DOUBLE_EDGE_MOVE: Short = 38

private val speciesRegistry = SpeciesRegistry()

private fun createTestMon(dexId: Int, level: Int, moves: List<Short>, id: Long): BattleMonState {
  val moveRegistry = MoveRegistry()
  val padded = List(4) { i -> moves.getOrNull(i) ?: 0 }
  val def = speciesRegistry.get(dexId)!!
  val p = Pokemon(
      id = id,
      ownerId = 0,
      container = PokemonContainer.PARTY,
      containerSlot = 0,
      dexId = dexId,
      seed = 0,
      ot = "Ash",
      nickname = "",
      level = level.toByte(),
      hp = Short.MAX_VALUE,
      xp = 0,
      eVs = EVs(),
      iVs = IVs(),
      moves = padded.map { PokemonMove(it, (moveRegistry.get(it.toInt())?.pp ?: 0).toByte()) },
      isShiny = false,
      hasHiddenAbility = false,
      isAlpha = false,
      isSecret = false,
      isFatefulEncounter = false,
      isRaidEncounter = false,
      caughtAt = LocalDateTime.now(),
  )
  return BattleMonState(id, def, if (id == PLAYER_ID) 0 else null, p, StatCalculator.computeAll(def, p))
}

private fun testBattle(player: BattleMonState, wild: BattleMonState, seed: Long = 1L): BattleInstance =
    BattleInstance(1L, 100L, FakeSession(100L), listOf(player), listOf(wild), BattleRng(seed))

class StatusEngineTest :
    FunSpec({
      val engine = TurnEngine(MoveRegistry(), TypeChart())

      test("Thunder Wave inflicts paralysis on the opponent and halves speed") {
        val player = createTestMon(25, 20, listOf(THUNDER_WAVE), PLAYER_ID) // Pikachu
        val wild = createTestMon(19, 20, listOf(TACKLE), WILD_ID) // Rattata
        val initialSpeed = wild.effective(BattleStat.SPEED)

        val events = engine.resolveTurn(testBattle(player, wild, seed = 4), THUNDER_WAVE)

        wild.primaryStatus shouldBe PrimaryStatus.PARALYSIS
        wild.effective(BattleStat.SPEED) shouldBe initialSpeed / 2
        events.filterIsInstance<BattleEvent.StatusInflicted>().first().status shouldBe PrimaryStatus.PARALYSIS
      }

      test("Will-O-Wisp inflicts burn and deals end of turn burn damage") {
        val player = createTestMon(6, 30, listOf(WILL_O_WISP), PLAYER_ID) // Charizard
        val wild = createTestMon(143, 30, listOf(TACKLE), WILD_ID) // Snorlax
        val beforeHp = wild.currentHp

        val events = engine.resolveTurn(testBattle(player, wild, seed = 5), WILL_O_WISP)

        wild.primaryStatus shouldBe PrimaryStatus.BURN
        wild.currentHp shouldBeLessThan beforeHp
        events.filterIsInstance<BattleEvent.StatusDamage>().first().status shouldBe PrimaryStatus.BURN
      }

      test("Toxic deals damage that increases progressively each turn") {
        val player = createTestMon(1, 30, listOf(TACKLE), PLAYER_ID)
        val wild = createTestMon(143, 30, listOf(TACKLE), WILD_ID)
        wild.primaryStatus = PrimaryStatus.TOXIC
        wild.toxicCounter = 0

        engine.resolveTurn(testBattle(player, wild, seed = 1), TACKLE)
        wild.toxicCounter shouldBe 2

        engine.resolveTurn(testBattle(player, wild, seed = 1), TACKLE)
        wild.toxicCounter shouldBe 3
      }

      test("Sleep condition prevents Pokémon from executing moves until waking up") {
        val player = createTestMon(1, 30, listOf(TACKLE), PLAYER_ID)
        val wild = createTestMon(143, 30, listOf(TACKLE), WILD_ID)
        wild.primaryStatus = PrimaryStatus.SLEEP
        wild.statusTurns = 2
        val beforePlayerHp = player.currentHp

        val events = engine.resolveTurn(testBattle(player, wild, seed = 1), TACKLE)

        events.filterIsInstance<BattleEvent.Sleeping>().shouldNotBeEmpty()
        player.currentHp shouldBe beforePlayerHp // Wild couldn't attack while asleep
        wild.statusTurns shouldBe 1
      }

      test("Absorb heals the attacker for half the damage dealt") {
        val player = createTestMon(1, 30, listOf(ABSORB_MOVE), PLAYER_ID)
        player.currentHp = 10
        val wild = createTestMon(129, 5, listOf(TACKLE), WILD_ID) // Slower Magikarp

        val events = engine.resolveTurn(testBattle(player, wild, seed = 2), ABSORB_MOVE)

        events.filterIsInstance<BattleEvent.AbsorbHealed>().shouldNotBeEmpty()
        player.currentHp shouldBeGreaterThan 10
      }

      test("Double-Edge inflicts recoil damage to the attacker") {
        val player = createTestMon(143, 30, listOf(DOUBLE_EDGE_MOVE), PLAYER_ID)
        val wild = createTestMon(143, 30, listOf(TACKLE), WILD_ID)
        val beforeHp = player.currentHp

        val events = engine.resolveTurn(testBattle(player, wild, seed = 3), DOUBLE_EDGE_MOVE)

        events.filterIsInstance<BattleEvent.RecoilDamage>().shouldNotBeEmpty()
        player.currentHp shouldBeLessThan beforeHp
      }

      test("Poison types are immune to poison status") {
        val player = createTestMon(1, 20, listOf(TOXIC_MOVE), PLAYER_ID)
        val wild = createTestMon(92, 20, listOf(TACKLE), WILD_ID) // Gastly is Poison type

        val events = engine.resolveTurn(testBattle(player, wild, seed = 3), TOXIC_MOVE)

        wild.primaryStatus shouldBe PrimaryStatus.NONE
      }

      test("Fire types are immune to burn status") {
        val player = createTestMon(6, 30, listOf(WILL_O_WISP), PLAYER_ID)
        val wild = createTestMon(6, 30, listOf(TACKLE), WILD_ID) // Charizard is Fire type

        val events = engine.resolveTurn(testBattle(player, wild, seed = 3), WILL_O_WISP)

        wild.primaryStatus shouldBe PrimaryStatus.NONE
      }
    })
