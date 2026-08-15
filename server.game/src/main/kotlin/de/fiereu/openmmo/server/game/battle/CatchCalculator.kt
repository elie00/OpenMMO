package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.enums.PokemonType
import de.fiereu.openmmo.items.generated.Items
import kotlin.math.pow

object CatchCalculator {

  fun isPokeBall(itemId: Int): Boolean =
      itemId in
          listOf(
              Items.MASTER_BALL,
              Items.ULTRA_BALL,
              Items.GREAT_BALL,
              Items.POKE_BALL,
              Items.SAFARI_BALL,
              Items.NET_BALL,
              Items.DIVE_BALL,
              Items.NEST_BALL,
              Items.REPEAT_BALL,
              Items.TIMER_BALL,
              Items.LUXURY_BALL,
              Items.PREMIER_BALL,
          )

  fun ballMultiplier(itemId: Int, target: BattleMonState, turn: Int): Double =
      when (itemId) {
        Items.MASTER_BALL -> 255.0
        Items.ULTRA_BALL -> 2.0
        Items.GREAT_BALL,
        Items.SAFARI_BALL -> 1.5
        Items.NET_BALL -> {
          if (target.species.hasType(PokemonType.WATER) || target.species.hasType(PokemonType.BUG))
              3.0
          else 1.0
        }
        Items.NEST_BALL -> {
          val lvl = target.level
          if (lvl in 1..29) ((40.0 - lvl) / 10.0).coerceAtLeast(1.0) else 1.0
        }
        Items.TIMER_BALL -> (1.0 + turn * 0.1).coerceAtMost(4.0)
        else -> 1.0
      }

  fun statusMultiplier(status: PrimaryStatus): Double =
      when (status) {
        PrimaryStatus.SLEEP,
        PrimaryStatus.FREEZE -> 2.0
        PrimaryStatus.PARALYSIS,
        PrimaryStatus.POISON,
        PrimaryStatus.TOXIC,
        PrimaryStatus.BURN -> 1.5
        PrimaryStatus.NONE -> 1.0
      }

  /** Evaluates whether a throw succeeds. Returns true if caught, false if broken out. */
  fun attemptCatch(
      itemId: Int,
      target: BattleMonState,
      turn: Int,
      rng: BattleRng,
  ): Boolean {
    if (itemId == Items.MASTER_BALL) return true

    val maxHp = target.stats.hp.toDouble().coerceAtLeast(1.0)
    val curHp = target.currentHp.toDouble().coerceAtLeast(1.0)
    val catchRate = target.species.catchRate.toDouble()
    val ballBonus = ballMultiplier(itemId, target, turn)
    val statusBonus = statusMultiplier(target.primaryStatus)

    val a = (((3.0 * maxHp - 2.0 * curHp) * catchRate * ballBonus) / (3.0 * maxHp)) * statusBonus
    if (a >= 255.0) return true

    // Gen 3 / Gen 4 4-shake check formula:
    // b = 65536 * (a / 255) ^ 0.75
    // Each of the 4 shakes must succeed: shakeRoll <= b
    val b = 65536.0 * (a / 255.0).pow(0.75)
    val bInt = b.toInt().coerceIn(1, 65535)

    // 4 independent rolls
    for (i in 0 until 4) {
      val roll = (rng.accuracyRoll() * 65535 / 100).coerceIn(0, 65535)
      if (roll > bInt) return false
    }
    return true
  }
}
