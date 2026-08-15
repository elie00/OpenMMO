package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.Ability
import de.fiereu.openmmo.common.enums.EVs
import de.fiereu.openmmo.common.enums.IVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import de.fiereu.openmmo.typechart.TypeChart
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

private const val PLAYER_ID = 0x1C000L
private const val WILD_ID = 0x3C000L

private const val EARTHQUAKE: Short = 89
private const val SURF: Short = 57
private const val FLAMETHROWER: Short = 53
private const val TACKLE: Short = 33
private const val VINE_WHIP: Short = 22
private const val SHADOW_BALL: Short = 247
private const val GROWL: Short = 45

private val speciesRegistry = SpeciesRegistry()

private fun makeMon(
    dexId: Int,
    level: Int,
    moves: List<Short>,
    id: Long,
    customAbility: Ability? = null
): BattleMonState {
  val moveRegistry = MoveRegistry()
  val padded = List(4) { i -> moves.getOrNull(i) ?: 0 }
  val def = speciesRegistry.get(dexId)!!
  val p =
      Pokemon(
          id = id,
          ownerId = 0,
          container = PokemonContainer.PARTY,
          containerSlot = 0,
          dexId = dexId,
          seed = 0,
          ot = "Blue",
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
  val state =
      BattleMonState(
          id, def, if (id == PLAYER_ID) 0 else null, p, StatCalculator.computeAll(def, p))
  if (customAbility != null) {
    state.ability = customAbility
  }
  return state
}

private fun testBattle(
    player: BattleMonState,
    wild: BattleMonState,
    seed: Long = 1L
): BattleInstance =
    BattleInstance(1L, 100L, FakeSession(100L), listOf(player), listOf(wild), BattleRng(seed))

class BattleAbilitiesTest :
    FunSpec({
      val engine = TurnEngine(MoveRegistry(), TypeChart())

      test("Levitate makes Pokémon immune to Ground moves") {
        val player = makeMon(143, 40, listOf(EARTHQUAKE), PLAYER_ID)
        val wild =
            makeMon(
                94,
                40,
                listOf(TACKLE),
                WILD_ID,
                customAbility = Ability.LEVITATE) // Gengar with Levitate

        val beforeHp = wild.currentHp
        val events = engine.resolveTurn(testBattle(player, wild, seed = 5), EARTHQUAKE)

        wild.currentHp shouldBe beforeHp
        events.filterIsInstance<BattleEvent.MoveFailed>().shouldNotBeEmpty()
      }

      test("Water Absorb heals the Pokémon when hit by Water moves") {
        val player = makeMon(130, 40, listOf(SURF), PLAYER_ID) // Gyarados
        val wild =
            makeMon(
                134, 40, listOf(TACKLE), WILD_ID, customAbility = Ability.WATER_ABSORB) // Vaporeon
        wild.currentHp = 50

        val events = engine.resolveTurn(testBattle(player, wild, seed = 7), SURF)

        wild.currentHp shouldBeGreaterThan 50
        events.filterIsInstance<BattleEvent.AbsorbHealed>().shouldNotBeEmpty()
      }

      test("Flash Fire grants immunity to Fire moves") {
        val player = makeMon(6, 40, listOf(FLAMETHROWER), PLAYER_ID)
        val wild =
            makeMon(59, 40, listOf(TACKLE), WILD_ID, customAbility = Ability.FLASH_FIRE) // Arcanine

        val beforeHp = wild.currentHp
        val events = engine.resolveTurn(testBattle(player, wild, seed = 2), FLAMETHROWER)

        wild.currentHp shouldBe beforeHp
        events.filterIsInstance<BattleEvent.MoveFailed>().shouldNotBeEmpty()
      }

      test("Wonder Guard only allows super-effective attacks") {
        val player = makeMon(143, 30, listOf(TACKLE, SHADOW_BALL), PLAYER_ID)
        val wild =
            makeMon(
                292,
                30,
                listOf(TACKLE),
                WILD_ID,
                customAbility = Ability.WONDER_GUARD) // Shedinja (Bug/Ghost)

        // Tackle is Normal -> immune
        val events1 = engine.resolveTurn(testBattle(player, wild, seed = 1), TACKLE)
        events1.filterIsInstance<BattleEvent.MoveFailed>().shouldNotBeEmpty()

        // Shadow Ball is Ghost -> super effective -> hits Shedinja
        val events2 = engine.resolveTurn(testBattle(player, wild, seed = 1), SHADOW_BALL)
        events2.filterIsInstance<BattleEvent.DamageDealt>().shouldNotBeEmpty()
      }

      test("Overgrow boosts Grass move damage when HP is below 1/3") {
        val playerNormal =
            makeMon(1, 30, listOf(VINE_WHIP), PLAYER_ID, customAbility = Ability.OVERGROW)
        val wild = makeMon(143, 30, listOf(TACKLE), WILD_ID)
        val before1 = wild.currentHp
        engine.resolveTurn(testBattle(playerNormal, wild, seed = 1), VINE_WHIP)
        val normalDmg = before1 - wild.currentHp

        val playerLowHp =
            makeMon(1, 30, listOf(VINE_WHIP), PLAYER_ID, customAbility = Ability.OVERGROW)
        playerLowHp.currentHp = playerLowHp.stats.hp / 4 // < 1/3 HP
        val wild2 = makeMon(143, 30, listOf(TACKLE), WILD_ID)
        val before2 = wild2.currentHp
        engine.resolveTurn(testBattle(playerLowHp, wild2, seed = 1), VINE_WHIP)
        val boostDmg = before2 - wild2.currentHp

        boostDmg shouldBeGreaterThan normalDmg
      }

      test("Clear Body prevents stat stage reduction from opponent moves") {
        val player = makeMon(1, 10, listOf(GROWL), PLAYER_ID)
        val wild =
            makeMon(
                376, 50, listOf(TACKLE), WILD_ID, customAbility = Ability.CLEAR_BODY) // Metagross

        engine.resolveTurn(testBattle(player, wild, seed = 1), GROWL)

        wild.stage(BattleStat.ATTACK) shouldBe 0
      }
    })
