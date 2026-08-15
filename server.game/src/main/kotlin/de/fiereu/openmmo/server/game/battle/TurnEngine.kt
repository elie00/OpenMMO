package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.enums.Ability
import de.fiereu.openmmo.common.enums.MoveEffect
import de.fiereu.openmmo.common.enums.PokemonType
import de.fiereu.openmmo.moves.MoveDef
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.typechart.TypeChart
import javax.inject.Inject
import javax.inject.Singleton

private const val CRIT_DENOMINATOR = 16
private const val TACKLE_ID = 33

sealed interface BattleEvent {
  data class MoveUsed(val attackerId: Long, val moveId: Short, val moveSlot: Int, val ppLeft: Int) :
      BattleEvent

  sealed interface MoveWithoutTarget : BattleEvent {
    val attackerId: Long
    val moveId: Short
  }

  data class MoveMissed(override val attackerId: Long, override val moveId: Short) :
      MoveWithoutTarget

  data class MoveFailed(override val attackerId: Long, override val moveId: Short) :
      MoveWithoutTarget

  data class DamageDealt(
      val targetId: Long,
      val newHp: Int,
      val crit: Boolean,
      val effectiveness: Int,
  ) : BattleEvent

  data class StageChanged(
      val targetId: Long,
      val stat: BattleStat,
      val stage: Int,
      val effectiveValue: Int,
      val delta: Int,
      val failed: Boolean,
  ) : BattleEvent

  data class Fainted(val targetId: Long) : BattleEvent

  data class StatusInflicted(val targetId: Long, val status: PrimaryStatus) : BattleEvent

  data class StatusCured(val targetId: Long, val status: PrimaryStatus) : BattleEvent

  data class StatusDamage(
      val targetId: Long,
      val damage: Int,
      val newHp: Int,
      val status: PrimaryStatus,
  ) : BattleEvent

  data class Sleeping(val attackerId: Long) : BattleEvent

  data class WokeUp(val attackerId: Long) : BattleEvent

  data class FullyParalyzed(val attackerId: Long) : BattleEvent

  data class Thawed(val attackerId: Long) : BattleEvent

  data class Confused(val attackerId: Long) : BattleEvent

  data class ConfusionSnappedOut(val attackerId: Long) : BattleEvent

  data class ConfusedSelfHit(val attackerId: Long, val damage: Int, val newHp: Int) : BattleEvent

  data class Flinched(val attackerId: Long) : BattleEvent

  data class AbsorbHealed(val attackerId: Long, val healed: Int, val newHp: Int) : BattleEvent

  data class RecoilDamage(val attackerId: Long, val damage: Int, val newHp: Int) : BattleEvent

  data class HpRestored(val targetId: Long, val healed: Int, val newHp: Int) : BattleEvent

  data class AbilityTriggered(val entityId: Long, val ability: Ability, val description: String) :
      BattleEvent
}

private data class TurnAction(
    val attacker: BattleMonState,
    val defender: BattleMonState,
    val move: MoveDef?,
)

private data class StageEffect(val stat: BattleStat, val delta: Int, val onSelf: Boolean)

@Singleton
class TurnEngine
@Inject
constructor(
    private val moves: MoveRegistry,
    private val typeChart: TypeChart,
) {

  fun resolveTurn(battle: BattleInstance, playerMoveId: Short): List<BattleEvent> {
    val events = mutableListOf<BattleEvent>()
    val player = battle.activeMon()
    val enemy = battle.opponentMon()

    val playerAction = TurnAction(player, enemy, moves.get(playerMoveId.toInt()))
    val enemyAction = TurnAction(enemy, player, pickEnemyMove(battle, enemy))

    for (action in order(battle, playerAction, enemyAction)) {
      if (action.attacker.fainted) continue
      execute(battle, action, events)
      if (player.fainted || enemy.fainted) break
    }

    if (!player.fainted && !enemy.fainted) {
      endOfTurn(battle, events)
    }

    return events
  }

  fun resolveSwitchTurn(battle: BattleInstance): List<BattleEvent> {
    val events = mutableListOf<BattleEvent>()
    val enemy = battle.opponentMon()
    if (enemy.fainted) return events
    execute(battle, TurnAction(enemy, battle.activeMon(), pickEnemyMove(battle, enemy)), events)
    if (!battle.activeMon().fainted && !enemy.fainted) {
      endOfTurn(battle, events)
    }
    return events
  }

  fun resolveItemTurn(battle: BattleInstance): List<BattleEvent> = resolveSwitchTurn(battle)

  private fun pickEnemyMove(battle: BattleInstance, enemy: BattleMonState): MoveDef? {
    val usable = enemy.moves.filter { it.id.toInt() != 0 && it.pp > 0 }
    if (usable.isEmpty()) return moves.get(TACKLE_ID)
    return moves.get(usable[battle.rng.pick(usable.size)].id.toInt())
  }

  private fun order(
      battle: BattleInstance,
      a: TurnAction,
      b: TurnAction,
  ): List<TurnAction> {
    val pa = a.move?.priority ?: 0
    val pb = b.move?.priority ?: 0
    if (pa != pb) return if (pa > pb) listOf(a, b) else listOf(b, a)
    val sa = a.attacker.effective(BattleStat.SPEED)
    val sb = b.attacker.effective(BattleStat.SPEED)
    if (sa != sb) return if (sa > sb) listOf(a, b) else listOf(b, a)
    return if (battle.rng.coinFlip()) listOf(a, b) else listOf(b, a)
  }

  private fun execute(
      battle: BattleInstance,
      action: TurnAction,
      events: MutableList<BattleEvent>
  ) {
    val attacker = action.attacker
    val defender = action.defender
    val move = action.move

    if (move == null) {
      events += BattleEvent.MoveFailed(attacker.entityId, 0)
      return
    }

    // 1. Status checks before executing the move
    if (!checkStatusBeforeMove(battle, attacker, move, events)) {
      return
    }

    val moveId = move.id.toShort()
    val slot = attacker.moves.indexOfFirst { it.id == moveId }
    if (slot >= 0 && attacker.moves[slot].pp > 0) {
      attacker.moves[slot].pp = (attacker.moves[slot].pp - 1).toByte()
    }
    events +=
        BattleEvent.MoveUsed(
            attacker.entityId,
            moveId,
            slot.coerceAtLeast(0),
            attacker.moves.getOrNull(slot)?.pp?.toInt() ?: 0)

    // 2. Accuracy Check (Hustle reduces physical accuracy by 20%)
    if (!accuracyCheck(battle, action, move)) {
      events += BattleEvent.MoveMissed(attacker.entityId, moveId)
      return
    }

    // 3. Ability Immunities / Absorptions
    if (checkAbilityImmunity(action, move, events)) {
      return
    }

    // 4. Wonder Guard check
    if (defender.ability == Ability.WONDER_GUARD && move.power > 0) {
      val eff = typeChart.effectiveness(move.type, defender.species.type1, defender.species.type2)
      if (eff <= TypeChart.NEUTRAL) {
        events += BattleEvent.MoveFailed(attacker.entityId, moveId)
        return
      }
    }

    // 5. Execute move effect
    val stage = stageEffect(move.effect)
    when {
      move.power > 0 -> damage(battle, action, move, events)
      stage != null -> applyStage(action, stage, events)
      isHealingMove(move.effect) -> applyHeal(action, move, events)
      isStatusInflictingMove(move.effect) -> applyStatusMove(battle, action, move, events)
      else -> events += BattleEvent.MoveFailed(attacker.entityId, moveId)
    }
  }

  private fun checkStatusBeforeMove(
      battle: BattleInstance,
      attacker: BattleMonState,
      move: MoveDef,
      events: MutableList<BattleEvent>,
  ): Boolean {
    // Flinch check
    if (attacker.flinching) {
      attacker.flinching = false
      events += BattleEvent.Flinched(attacker.entityId)
      return false
    }

    // Sleep check
    if (attacker.primaryStatus == PrimaryStatus.SLEEP) {
      attacker.statusTurns--
      if (attacker.statusTurns <= 0) {
        attacker.cureStatus()
        events += BattleEvent.WokeUp(attacker.entityId)
      } else {
        events += BattleEvent.Sleeping(attacker.entityId)
        return false
      }
    }

    // Freeze check
    if (attacker.primaryStatus == PrimaryStatus.FREEZE) {
      if (move.type == PokemonType.FIRE || battle.rng.accuracyRoll() <= 20) {
        attacker.cureStatus()
        events += BattleEvent.Thawed(attacker.entityId)
      } else {
        return false
      }
    }

    // Paralysis check
    if (attacker.primaryStatus == PrimaryStatus.PARALYSIS && battle.rng.accuracyRoll() <= 25) {
      events += BattleEvent.FullyParalyzed(attacker.entityId)
      return false
    }

    // Confusion check
    if (attacker.isConfused) {
      attacker.confusionTurns--
      if (attacker.confusionTurns <= 0) {
        attacker.isConfused = false
        events += BattleEvent.ConfusionSnappedOut(attacker.entityId)
      } else {
        events += BattleEvent.Confused(attacker.entityId)
        if (battle.rng.coinFlip()) {
          // Self-inflicted confusion damage (40 power physical attack against own defense)
          val atk = attacker.effective(BattleStat.ATTACK)
          val def = attacker.effective(BattleStat.DEFENSE)
          var selfDmg = ((2 * attacker.level / 5 + 2) * 40 * atk / def / 50 + 2).coerceAtLeast(1)
          attacker.currentHp = (attacker.currentHp - selfDmg).coerceAtLeast(0)
          events += BattleEvent.ConfusedSelfHit(attacker.entityId, selfDmg, attacker.currentHp)
          if (attacker.fainted) {
            events += BattleEvent.Fainted(attacker.entityId)
          }
          return false
        }
      }
    }

    return true
  }

  private fun checkAbilityImmunity(
      action: TurnAction,
      move: MoveDef,
      events: MutableList<BattleEvent>,
  ): Boolean {
    val defender = action.defender
    val attacker = action.attacker
    val moveId = move.id.toShort()

    // Levitate: immune to ground moves
    if (defender.ability == Ability.LEVITATE && move.type == PokemonType.GROUND) {
      events +=
          BattleEvent.AbilityTriggered(
              defender.entityId, Ability.LEVITATE, "Levitate avoids Ground moves!")
      events += BattleEvent.MoveFailed(attacker.entityId, moveId)
      return true
    }

    // Water Absorb: absorbs water moves and heals 25% max HP
    if (defender.ability == Ability.WATER_ABSORB && move.type == PokemonType.WATER) {
      val heal = defender.stats.hp / 4
      defender.currentHp = (defender.currentHp + heal).coerceAtMost(defender.stats.hp)
      events +=
          BattleEvent.AbilityTriggered(
              defender.entityId, Ability.WATER_ABSORB, "Water Absorb restored HP!")
      events += BattleEvent.AbsorbHealed(defender.entityId, heal, defender.currentHp)
      return true
    }

    // Volt Absorb: absorbs electric moves and heals 25% max HP
    if (defender.ability == Ability.VOLT_ABSORB && move.type == PokemonType.ELECTRIC) {
      val heal = defender.stats.hp / 4
      defender.currentHp = (defender.currentHp + heal).coerceAtMost(defender.stats.hp)
      events +=
          BattleEvent.AbilityTriggered(
              defender.entityId, Ability.VOLT_ABSORB, "Volt Absorb restored HP!")
      events += BattleEvent.AbsorbHealed(defender.entityId, heal, defender.currentHp)
      return true
    }

    // Flash Fire: immune to fire moves
    if (defender.ability == Ability.FLASH_FIRE && move.type == PokemonType.FIRE) {
      events +=
          BattleEvent.AbilityTriggered(
              defender.entityId, Ability.FLASH_FIRE, "Flash Fire absorbed the fire!")
      events += BattleEvent.MoveFailed(attacker.entityId, moveId)
      return true
    }

    return false
  }

  private fun accuracyCheck(battle: BattleInstance, action: TurnAction, move: MoveDef): Boolean {
    if (move.accuracy == 0) return true
    val stage =
        action.attacker.stage(BattleStat.ACCURACY) - action.defender.stage(BattleStat.EVASION)
    var threshold = StatStages.scaleAccuracy(move.accuracy, stage)
    if (action.attacker.ability == Ability.HUSTLE && MoveCategory.isPhysical(move.type)) {
      threshold = threshold * 80 / 100
    }
    return battle.rng.accuracyRoll() <= threshold
  }

  private fun damage(
      battle: BattleInstance,
      action: TurnAction,
      move: MoveDef,
      events: MutableList<BattleEvent>,
  ) {
    val attacker = action.attacker
    val defender = action.defender
    val eff = typeChart.effectiveness(move.type, defender.species.type1, defender.species.type2)
    if (eff == 0) {
      events += BattleEvent.MoveFailed(attacker.entityId, move.id.toShort())
      return
    }
    val physical = MoveCategory.isPhysical(move.type)
    val atkStat = if (physical) BattleStat.ATTACK else BattleStat.SP_ATTACK
    val defStat = if (physical) BattleStat.DEFENSE else BattleStat.SP_DEFENSE
    val crit = battle.rng.critRoll(CRIT_DENOMINATOR)

    val atk =
        if (crit && attacker.stage(atkStat) < 0) attacker.unstaged(atkStat)
        else attacker.effective(atkStat)
    val def =
        if (crit && defender.stage(defStat) > 0) defender.unstaged(defStat)
        else defender.effective(defStat)

    var dmg = (2 * attacker.level / 5 + 2) * move.power * atk / def / 50 + 2

    // Overgrow / Blaze / Torrent / Swarm boosts (1.5x power when HP <= 1/3)
    val lowHp = attacker.currentHp <= attacker.stats.hp / 3
    if (lowHp &&
        ((attacker.ability == Ability.OVERGROW && move.type == PokemonType.GRASS) ||
            (attacker.ability == Ability.BLAZE && move.type == PokemonType.FIRE) ||
            (attacker.ability == Ability.TORRENT && move.type == PokemonType.WATER) ||
            (attacker.ability == Ability.SWARM && move.type == PokemonType.BUG))) {
      dmg = dmg * 3 / 2
    }

    // Thick Fat ability on defender
    if (defender.ability == Ability.THICK_FAT &&
        (move.type == PokemonType.FIRE || move.type == PokemonType.ICE)) {
      dmg /= 2
    }

    if (crit) dmg *= 2
    if (attacker.species.hasType(move.type)) dmg = dmg * 3 / 2
    dmg = dmg * eff / TypeChart.NEUTRAL
    dmg = dmg * battle.rng.damageRoll() / 100
    if (dmg < 1) dmg = 1

    // Sturdy check: if defender has full HP and damage would faint it
    if (defender.ability == Ability.STURDY &&
        defender.currentHp == defender.stats.hp &&
        dmg >= defender.currentHp) {
      dmg = defender.currentHp - 1
    }

    val actualDamage = dmg.coerceAtMost(defender.currentHp)
    defender.currentHp = (defender.currentHp - actualDamage).coerceAtLeast(0)
    events += BattleEvent.DamageDealt(defender.entityId, defender.currentHp, crit, eff)

    // Drain moves (e.g. Absorb, Giga Drain, Leech Life)
    if (move.effect == MoveEffect.ABSORB) {
      val heal = (actualDamage / 2).coerceAtLeast(1)
      attacker.currentHp = (attacker.currentHp + heal).coerceAtMost(attacker.stats.hp)
      events += BattleEvent.AbsorbHealed(attacker.entityId, heal, attacker.currentHp)
    }

    // Recoil damage (e.g. Double-Edge, Take Down)
    if ((move.effect == MoveEffect.RECOIL || move.effect == MoveEffect.DOUBLE_EDGE) &&
        attacker.ability != Ability.ROCK_HEAD) {
      val recoil = (actualDamage / 3).coerceAtLeast(1)
      attacker.currentHp = (attacker.currentHp - recoil).coerceAtLeast(0)
      events += BattleEvent.RecoilDamage(attacker.entityId, recoil, attacker.currentHp)
      if (attacker.fainted) {
        events += BattleEvent.Fainted(attacker.entityId)
      }
    }

    if (defender.fainted) {
      events += BattleEvent.Fainted(defender.entityId)
      return
    }

    // Contact ability triggers on defender (Static, Poison Point, Flame Body, Rough Skin)
    if (physical) {
      checkDefensiveContactAbilities(battle, attacker, defender, events)
    }

    // Secondary stat changes
    secondaryEffect(move.effect)?.let { secondary ->
      if (move.secondaryEffectChance > 0 &&
          battle.rng.accuracyRoll() <= move.secondaryEffectChance) {
        applyStage(action, secondary, events)
      }
    }

    // Secondary status effects (e.g. Flamethrower 10% burn, Thunderbolt 10% paralyze, Ice Beam 10%
    // freeze)
    applySecondaryStatus(battle, defender, move, events)
  }

  private fun checkDefensiveContactAbilities(
      battle: BattleInstance,
      attacker: BattleMonState,
      defender: BattleMonState,
      events: MutableList<BattleEvent>,
  ) {
    if (defender.ability == Ability.ROUGH_SKIN) {
      val recoil = (attacker.stats.hp / 16).coerceAtLeast(1)
      attacker.currentHp = (attacker.currentHp - recoil).coerceAtLeast(0)
      events +=
          BattleEvent.AbilityTriggered(
              defender.entityId, Ability.ROUGH_SKIN, "Rough Skin hurt the attacker!")
      events += BattleEvent.RecoilDamage(attacker.entityId, recoil, attacker.currentHp)
      if (attacker.fainted) {
        events += BattleEvent.Fainted(attacker.entityId)
        return
      }
    }

    if (attacker.primaryStatus == PrimaryStatus.NONE && battle.rng.accuracyRoll() <= 30) {
      when (defender.ability) {
        Ability.STATIC -> {
          if (attacker.ability != Ability.LIMBER) {
            attacker.primaryStatus = PrimaryStatus.PARALYSIS
            events +=
                BattleEvent.AbilityTriggered(
                    defender.entityId, Ability.STATIC, "Static paralyzed the attacker!")
            events += BattleEvent.StatusInflicted(attacker.entityId, PrimaryStatus.PARALYSIS)
          }
        }
        Ability.FLAME_BODY -> {
          if (attacker.ability != Ability.WATER_VEIL &&
              !attacker.species.hasType(PokemonType.FIRE)) {
            attacker.primaryStatus = PrimaryStatus.BURN
            events +=
                BattleEvent.AbilityTriggered(
                    defender.entityId, Ability.FLAME_BODY, "Flame Body burned the attacker!")
            events += BattleEvent.StatusInflicted(attacker.entityId, PrimaryStatus.BURN)
          }
        }
        Ability.POISON_POINT -> {
          if (attacker.ability != Ability.IMMUNITY &&
              !attacker.species.hasType(PokemonType.POISON) &&
              !attacker.species.hasType(PokemonType.STEEL)) {
            attacker.primaryStatus = PrimaryStatus.POISON
            events +=
                BattleEvent.AbilityTriggered(
                    defender.entityId, Ability.POISON_POINT, "Poison Point poisoned the attacker!")
            events += BattleEvent.StatusInflicted(attacker.entityId, PrimaryStatus.POISON)
          }
        }
        else -> Unit
      }
    }
  }

  private fun applySecondaryStatus(
      battle: BattleInstance,
      defender: BattleMonState,
      move: MoveDef,
      events: MutableList<BattleEvent>,
  ) {
    if (defender.fainted) return
    val chance = move.secondaryEffectChance
    if (chance <= 0 || battle.rng.accuracyRoll() > chance) return

    when (move.effect) {
      MoveEffect.BURN_HIT -> inflictStatus(defender, PrimaryStatus.BURN, events)
      MoveEffect.FREEZE_HIT -> inflictStatus(defender, PrimaryStatus.FREEZE, events)
      MoveEffect.PARALYZE_HIT -> inflictStatus(defender, PrimaryStatus.PARALYSIS, events)
      MoveEffect.POISON_HIT -> inflictStatus(defender, PrimaryStatus.POISON, events)
      MoveEffect.CONFUSE_HIT -> {
        if (!defender.isConfused && defender.ability != Ability.OWN_TEMPO) {
          defender.isConfused = true
          defender.confusionTurns = battle.rng.pick(4) + 1
          events += BattleEvent.StatusInflicted(defender.entityId, PrimaryStatus.NONE)
        }
      }
      MoveEffect.FLINCH_HIT -> {
        if (defender.ability != Ability.INNER_FOCUS) {
          defender.flinching = true
        }
      }
      else -> Unit
    }
  }

  private fun applyStatusMove(
      battle: BattleInstance,
      action: TurnAction,
      move: MoveDef,
      events: MutableList<BattleEvent>,
  ) {
    val defender = action.defender
    when (move.effect) {
      MoveEffect.SLEEP -> {
        if (inflictStatus(defender, PrimaryStatus.SLEEP, events)) {
          defender.statusTurns = battle.rng.pick(3) + 1
        }
      }
      MoveEffect.POISON -> inflictStatus(defender, PrimaryStatus.POISON, events)
      MoveEffect.TOXIC -> inflictStatus(defender, PrimaryStatus.TOXIC, events)
      MoveEffect.PARALYZE -> inflictStatus(defender, PrimaryStatus.PARALYSIS, events)
      MoveEffect.WILL_O_WISP -> inflictStatus(defender, PrimaryStatus.BURN, events)
      MoveEffect.CONFUSE -> {
        if (!defender.isConfused && defender.ability != Ability.OWN_TEMPO) {
          defender.isConfused = true
          defender.confusionTurns = battle.rng.pick(4) + 1
          events += BattleEvent.StatusInflicted(defender.entityId, PrimaryStatus.NONE)
        } else {
          events += BattleEvent.MoveFailed(action.attacker.entityId, move.id.toShort())
        }
      }
      else -> events += BattleEvent.MoveFailed(action.attacker.entityId, move.id.toShort())
    }
  }

  fun inflictStatus(
      target: BattleMonState,
      status: PrimaryStatus,
      events: MutableList<BattleEvent>,
  ): Boolean {
    if (target.primaryStatus != PrimaryStatus.NONE || target.fainted) return false

    when (status) {
      PrimaryStatus.SLEEP -> {
        if (target.ability == Ability.INSOMNIA || target.ability == Ability.VITAL_SPIRIT)
            return false
      }
      PrimaryStatus.POISON,
      PrimaryStatus.TOXIC -> {
        if (target.ability == Ability.IMMUNITY ||
            target.species.hasType(PokemonType.POISON) ||
            target.species.hasType(PokemonType.STEEL))
            return false
      }
      PrimaryStatus.BURN -> {
        if (target.ability == Ability.WATER_VEIL || target.species.hasType(PokemonType.FIRE))
            return false
      }
      PrimaryStatus.FREEZE -> {
        if (target.ability == Ability.MAGMA_ARMOR || target.species.hasType(PokemonType.ICE))
            return false
      }
      PrimaryStatus.PARALYSIS -> {
        if (target.ability == Ability.LIMBER) return false
      }
      PrimaryStatus.NONE -> return false
    }

    target.primaryStatus = status
    if (status == PrimaryStatus.TOXIC) target.toxicCounter = 1
    events += BattleEvent.StatusInflicted(target.entityId, status)
    return true
  }

  private fun isHealingMove(effect: MoveEffect): Boolean =
      effect == MoveEffect.RESTORE_HP ||
          effect == MoveEffect.SOFTBOILED ||
          effect == MoveEffect.SYNTHESIS

  private fun isStatusInflictingMove(effect: MoveEffect): Boolean =
      effect in
          listOf(
              MoveEffect.SLEEP,
              MoveEffect.POISON,
              MoveEffect.TOXIC,
              MoveEffect.PARALYZE,
              MoveEffect.WILL_O_WISP,
              MoveEffect.CONFUSE,
          )

  private fun applyHeal(
      action: TurnAction,
      move: MoveDef,
      events: MutableList<BattleEvent>,
  ) {
    val attacker = action.attacker
    if (attacker.currentHp >= attacker.stats.hp) {
      events += BattleEvent.MoveFailed(attacker.entityId, move.id.toShort())
      return
    }
    val heal = attacker.stats.hp / 2
    attacker.currentHp = (attacker.currentHp + heal).coerceAtMost(attacker.stats.hp)
    events += BattleEvent.HpRestored(attacker.entityId, heal, attacker.currentHp)
  }

  private fun applyStage(
      action: TurnAction,
      effect: StageEffect,
      events: MutableList<BattleEvent>,
  ) {
    val target = if (effect.onSelf) action.attacker else action.defender

    // Clear Body / White Smoke protects from stat drops caused by the opponent
    if (!effect.onSelf &&
        effect.delta < 0 &&
        (target.ability == Ability.CLEAR_BODY || target.ability == Ability.WHITE_SMOKE)) {
      events +=
          BattleEvent.AbilityTriggered(
              target.entityId, target.ability, "${target.ability.name} prevents stat loss!")
      events +=
          BattleEvent.StageChanged(
              target.entityId,
              effect.stat,
              target.stage(effect.stat),
              target.effective(effect.stat),
              0,
              true)
      return
    }

    val applied = target.changeStage(effect.stat, effect.delta)
    val value =
        when (effect.stat) {
          BattleStat.ACCURACY,
          BattleStat.EVASION -> 0
          else -> target.effective(effect.stat)
        }
    events +=
        BattleEvent.StageChanged(
            target.entityId,
            effect.stat,
            target.stage(effect.stat),
            value,
            effect.delta,
            applied == 0)
  }

  private fun endOfTurn(battle: BattleInstance, events: MutableList<BattleEvent>) {
    val active = listOf(battle.activeMon(), battle.opponentMon())
    for (mon in active) {
      if (mon.fainted) continue

      // Shed Skin ability (33% chance to cure status at end of turn)
      if (mon.ability == Ability.SHED_SKIN &&
          mon.primaryStatus != PrimaryStatus.NONE &&
          battle.rng.accuracyRoll() <= 33) {
        val old = mon.primaryStatus
        mon.cureStatus()
        events +=
            BattleEvent.AbilityTriggered(
                mon.entityId, Ability.SHED_SKIN, "Shed Skin cured the status!")
        events += BattleEvent.StatusCured(mon.entityId, old)
      }

      // Speed Boost ability (+1 Speed at end of turn)
      if (mon.ability == Ability.SPEED_BOOST) {
        val applied = mon.changeStage(BattleStat.SPEED, 1)
        if (applied != 0) {
          events +=
              BattleEvent.AbilityTriggered(
                  mon.entityId, Ability.SPEED_BOOST, "Speed Boost increased Speed!")
          events +=
              BattleEvent.StageChanged(
                  mon.entityId,
                  BattleStat.SPEED,
                  mon.stage(BattleStat.SPEED),
                  mon.effective(BattleStat.SPEED),
                  1,
                  false)
        }
      }

      // Residual status damage
      when (mon.primaryStatus) {
        PrimaryStatus.BURN -> {
          val dmg = (mon.stats.hp / 16).coerceAtLeast(1)
          mon.currentHp = (mon.currentHp - dmg).coerceAtLeast(0)
          events += BattleEvent.StatusDamage(mon.entityId, dmg, mon.currentHp, PrimaryStatus.BURN)
          if (mon.fainted) events += BattleEvent.Fainted(mon.entityId)
        }
        PrimaryStatus.POISON -> {
          val dmg = (mon.stats.hp / 8).coerceAtLeast(1)
          mon.currentHp = (mon.currentHp - dmg).coerceAtLeast(0)
          events += BattleEvent.StatusDamage(mon.entityId, dmg, mon.currentHp, PrimaryStatus.POISON)
          if (mon.fainted) events += BattleEvent.Fainted(mon.entityId)
        }
        PrimaryStatus.TOXIC -> {
          val count = mon.toxicCounter.coerceAtLeast(1)
          val dmg = (mon.stats.hp * count / 16).coerceAtLeast(1)
          mon.toxicCounter = count + 1
          mon.currentHp = (mon.currentHp - dmg).coerceAtLeast(0)
          events += BattleEvent.StatusDamage(mon.entityId, dmg, mon.currentHp, PrimaryStatus.TOXIC)
          if (mon.fainted) events += BattleEvent.Fainted(mon.entityId)
        }
        else -> Unit
      }
    }
  }

  private fun stageEffect(effect: MoveEffect): StageEffect? =
      when (effect) {
        MoveEffect.ATTACK_UP -> StageEffect(BattleStat.ATTACK, 1, true)
        MoveEffect.DEFENSE_UP -> StageEffect(BattleStat.DEFENSE, 1, true)
        MoveEffect.SPEED_UP -> StageEffect(BattleStat.SPEED, 1, true)
        MoveEffect.SPECIAL_ATTACK_UP -> StageEffect(BattleStat.SP_ATTACK, 1, true)
        MoveEffect.SPECIAL_DEFENSE_UP -> StageEffect(BattleStat.SP_DEFENSE, 1, true)
        MoveEffect.ACCURACY_UP -> StageEffect(BattleStat.ACCURACY, 1, true)
        MoveEffect.EVASION_UP -> StageEffect(BattleStat.EVASION, 1, true)
        MoveEffect.ATTACK_UP_2 -> StageEffect(BattleStat.ATTACK, 2, true)
        MoveEffect.DEFENSE_UP_2 -> StageEffect(BattleStat.DEFENSE, 2, true)
        MoveEffect.SPEED_UP_2 -> StageEffect(BattleStat.SPEED, 2, true)
        MoveEffect.SPECIAL_ATTACK_UP_2 -> StageEffect(BattleStat.SP_ATTACK, 2, true)
        MoveEffect.SPECIAL_DEFENSE_UP_2 -> StageEffect(BattleStat.SP_DEFENSE, 2, true)
        MoveEffect.ACCURACY_UP_2 -> StageEffect(BattleStat.ACCURACY, 2, true)
        MoveEffect.EVASION_UP_2 -> StageEffect(BattleStat.EVASION, 2, true)
        MoveEffect.ATTACK_DOWN -> StageEffect(BattleStat.ATTACK, -1, false)
        MoveEffect.DEFENSE_DOWN -> StageEffect(BattleStat.DEFENSE, -1, false)
        MoveEffect.SPEED_DOWN -> StageEffect(BattleStat.SPEED, -1, false)
        MoveEffect.SPECIAL_ATTACK_DOWN -> StageEffect(BattleStat.SP_ATTACK, -1, false)
        MoveEffect.SPECIAL_DEFENSE_DOWN -> StageEffect(BattleStat.SP_DEFENSE, -1, false)
        MoveEffect.ACCURACY_DOWN -> StageEffect(BattleStat.ACCURACY, -1, false)
        MoveEffect.EVASION_DOWN -> StageEffect(BattleStat.EVASION, -1, false)
        MoveEffect.ATTACK_DOWN_2 -> StageEffect(BattleStat.ATTACK, -2, false)
        MoveEffect.DEFENSE_DOWN_2 -> StageEffect(BattleStat.DEFENSE, -2, false)
        MoveEffect.SPEED_DOWN_2 -> StageEffect(BattleStat.SPEED, -2, false)
        MoveEffect.SPECIAL_ATTACK_DOWN_2 -> StageEffect(BattleStat.SP_ATTACK, -2, false)
        MoveEffect.SPECIAL_DEFENSE_DOWN_2 -> StageEffect(BattleStat.SP_DEFENSE, -2, false)
        MoveEffect.ACCURACY_DOWN_2 -> StageEffect(BattleStat.ACCURACY, -2, false)
        MoveEffect.EVASION_DOWN_2 -> StageEffect(BattleStat.EVASION, -2, false)
        else -> null
      }

  private fun secondaryEffect(effect: MoveEffect): StageEffect? =
      when (effect) {
        MoveEffect.ATTACK_DOWN_HIT -> StageEffect(BattleStat.ATTACK, -1, false)
        MoveEffect.DEFENSE_DOWN_HIT -> StageEffect(BattleStat.DEFENSE, -1, false)
        MoveEffect.SPEED_DOWN_HIT -> StageEffect(BattleStat.SPEED, -1, false)
        MoveEffect.SPECIAL_ATTACK_DOWN_HIT -> StageEffect(BattleStat.SP_ATTACK, -1, false)
        MoveEffect.SPECIAL_DEFENSE_DOWN_HIT -> StageEffect(BattleStat.SP_DEFENSE, -1, false)
        MoveEffect.ACCURACY_DOWN_HIT -> StageEffect(BattleStat.ACCURACY, -1, false)
        MoveEffect.EVASION_DOWN_HIT -> StageEffect(BattleStat.EVASION, -1, false)
        MoveEffect.ATTACK_UP_HIT -> StageEffect(BattleStat.ATTACK, 1, true)
        MoveEffect.DEFENSE_UP_HIT -> StageEffect(BattleStat.DEFENSE, 1, true)
        else -> null
      }
}
