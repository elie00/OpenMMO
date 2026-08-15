package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.Ability
import de.fiereu.openmmo.net.game.packets.battle.BattleMonBlock
import de.fiereu.openmmo.net.game.packets.battle.BattleOpponentBlock
import de.fiereu.openmmo.pokemon.SpeciesDef
import java.util.EnumMap

/**
 * One monster's live state inside a battle. [source] is the snapshot the battle started from.
 * [currentHp] and the move PP are the live values written back when the battle ends.
 */
class BattleMonState(
    val entityId: Long,
    val species: SpeciesDef,
    val partyIndex: Int?,
    // Both move on when a reward lands, so a second reward in the same battle builds on the first.
    var source: Pokemon,
    var stats: ComputedStats,
    val gender: Byte = 0,
) {
  var currentHp: Int = source.hp.toInt().coerceIn(0, stats.hp)
  val moves: MutableList<PokemonMove> =
      source.moves.map { PokemonMove(it.id, it.pp) }.toMutableList()

  var ability: Ability =
      if (species.ability2 == Ability.NONE || (source.seed and 1) == 0) species.ability1
      else species.ability2

  var primaryStatus: PrimaryStatus = PrimaryStatus.NONE
  var statusTurns: Int = 0
  var toxicCounter: Int = 0

  var isConfused: Boolean = false
  var confusionTurns: Int = 0
  var flinching: Boolean = false

  private val stages = EnumMap<BattleStat, Int>(BattleStat::class.java)

  val level: Int
    get() = source.level.toInt()

  val fainted: Boolean
    get() = currentHp <= 0

  fun stage(stat: BattleStat): Int = stages[stat] ?: 0

  /** Clamp to the stage limits and return the delta that was actually applied. */
  fun changeStage(stat: BattleStat, delta: Int): Int {
    val old = stage(stat)
    val new = (old + delta).coerceIn(StatStages.MIN, StatStages.MAX)
    stages[stat] = new
    return new - old
  }

  fun unstaged(stat: BattleStat): Int {
    val base =
        when (stat) {
          BattleStat.ATTACK -> stats.atk
          BattleStat.DEFENSE -> stats.def
          BattleStat.SP_ATTACK -> stats.spAtk
          BattleStat.SP_DEFENSE -> stats.spDef
          BattleStat.SPEED -> stats.spd
          BattleStat.ACCURACY,
          BattleStat.EVASION -> error("$this has no base stat to stage")
        }

    return when (stat) {
      BattleStat.ATTACK -> {
        var atk = base
        if (ability == Ability.HUGE_POWER || ability == Ability.PURE_POWER) {
          atk *= 2
        }
        if (ability == Ability.GUTS && primaryStatus != PrimaryStatus.NONE) {
          atk = atk * 3 / 2
        } else if (primaryStatus == PrimaryStatus.BURN) {
          atk /= 2
        }
        atk.coerceAtLeast(1)
      }
      BattleStat.SPEED -> {
        var spd = base
        if (primaryStatus == PrimaryStatus.PARALYSIS) {
          spd /= 2
        }
        spd.coerceAtLeast(1)
      }
      else -> base
    }
  }

  fun effective(stat: BattleStat): Int = StatStages.scaleStat(unstaged(stat), stage(stat))

  fun cureStatus() {
    primaryStatus = PrimaryStatus.NONE
    statusTurns = 0
    toxicCounter = 0
  }

  fun cureVolatiles() {
    isConfused = false
    confusionTurns = 0
    flinching = false
  }

  fun toOpponentBlock(slot: Int): BattleOpponentBlock =
      BattleOpponentBlock(
          slot = slot,
          revealed = true,
          entityId = entityId,
          species = species.id.toShort(),
          level = source.level,
          gender = gender,
          maxHp = stats.hp.toShort(),
          currentHp = currentHp.toShort(),
      )

  fun toBlock(slot: Int, movesPresent: Boolean): BattleMonBlock =
      BattleMonBlock(
          slot = slot,
          entityId = entityId,
          species = species.id.toShort(),
          level = source.level,
          gender = gender,
          abilityId = ability.ordinal.toShort(),
          maxHp = stats.hp.toShort(),
          currentHp = currentHp.toShort(),
          movesPresent = movesPresent,
          moveIds = List(BattleMonBlock.MOVE_SLOTS) { moves.getOrNull(it)?.id ?: 0 },
      )
}
