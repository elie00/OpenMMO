package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.enums.EVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.common.utils.hexToBytes
import de.fiereu.openmmo.net.game.packets.EntityMovePpPacket
import de.fiereu.openmmo.net.game.packets.EntityPresencePacket
import de.fiereu.openmmo.net.game.packets.PokemonContainerPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleActionEvent
import de.fiereu.openmmo.net.game.packets.battle.BattleBulkStatePacket
import de.fiereu.openmmo.net.game.packets.battle.BattleEffectTarget
import de.fiereu.openmmo.net.game.packets.battle.BattleEntityDeltaPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleEntityMoveEventPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleEventBody
import de.fiereu.openmmo.net.game.packets.battle.BattleFieldStatePacket
import de.fiereu.openmmo.net.game.packets.battle.BattleOpponentBlock
import de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleQueuedEventPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleSidePacket
import de.fiereu.openmmo.net.game.packets.battle.BattleSlotEventEnumPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleSlotFlagEventPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleStatCountersPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleSwitchInPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleTileMapPacket
import de.fiereu.openmmo.net.game.packets.battle.Experience
import de.fiereu.openmmo.net.game.packets.battle.MoveSlots
import de.fiereu.openmmo.net.game.packets.battle.OpposingSide
import de.fiereu.openmmo.server.game.services.notice
import de.fiereu.openmmo.server.game.world.interest.InterestManager
import de.fiereu.openmmo.typechart.TypeChart
import javax.inject.Inject
import javax.inject.Singleton

private const val ACTION_PROMPT: Byte = -128 // 0x80
private const val MOVE_EVENT_KIND: Byte = 1
private const val FLED_EVENT: Byte = 0

private const val PRESENCE_IN_BATTLE: Byte = 1
private const val PRESENCE_OVERWORLD: Byte = 0

private const val PLAYER_SIDE: Byte = 1
private const val OPPONENT_SIDE: Byte = 1

private val CAPTURED_APPEARANCE = "00024c031aac0f00038001a40004".hexToBytes()

private const val HP_TARGET_MOVE: Short = 0x0200
private const val MISSED_TARGET_MOVE: Short = 1
private const val FAILED_TARGET_MOVE: Short = 4
private const val DEFAULT_TARGET_MOVE: Short = 0
private const val SUPER_EFFECTIVE_BIT = 0x20
private const val NOT_VERY_EFFECTIVE_BIT = 0x10

@Singleton
class BattlePacketEmitter @Inject constructor(private val interestManager: InterestManager) {

  fun sendStart(battle: BattleInstance, playerName: String) {
    battle.session.send(EntityPresencePacket(entityId = battle.charId, status = PRESENCE_IN_BATTLE))
    battle.session.send(BattleSidePacket(side = PLAYER_SIDE))
    broadcast(
        battle,
        BattleFieldStatePacket(
            playerName = playerName,
            playerId = battle.charId,
            playerAppearance = CAPTURED_APPEARANCE,
            background = 0,
            opposing = if (battle.trainer == null) OpposingSide.WILD else OpposingSide.TRAINER,
            trainerId = (battle.trainer?.id ?: 0).toShort(),
            playerParty = battle.party.mapIndexed { slot, mon -> mon.toBlock(slot, true) },
            activeSlot = battle.activeSlot,
            opponentParty =
                battle.opponent.mapIndexed { slot, mon ->
                  if (slot in battle.opponentSeen) mon.toOpponentBlock(slot)
                  else BattleOpponentBlock(slot = slot, revealed = false)
                },
            opponentActiveSlot = battle.opponentSlot,
        ),
    )
    sendPrompt(battle)
  }

  fun sendEvents(battle: BattleInstance, events: List<BattleEvent>) {
    var i = 0
    while (i < events.size) {
      val event = events[i]
      when (event) {
        is BattleEvent.MoveUsed -> {
          if (battle.isPlayerSide(event.attackerId)) {
            battle.session.send(
                EntityMovePpPacket(
                    event.attackerId, event.moveSlot.toByte(), event.ppLeft.toByte()))
          }
          val targets =
              when (val next = events.getOrNull(i + 1)) {
                is BattleEvent.DamageDealt -> {
                  i++
                  val subEvents =
                      mutableListOf(
                          BattleActionEvent(
                              null, null, BattleEventBody.HpUpdate(next.newHp.toShort())))
                  var elsewhere = emptyList<BattleEffectTarget>()
                  val secondary = events.getOrNull(i + 1)
                  if (secondary is BattleEvent.StageChanged && !secondary.failed) {
                    i++
                    val body =
                        BattleEventBody.StatChange(
                            statIndex(secondary.stat), secondary.delta.toShort())
                    if (secondary.targetId == next.targetId) {
                      subEvents += BattleActionEvent(null, null, body)
                    } else {
                      elsewhere = listOf(target(secondary.targetId, DEFAULT_TARGET_MOVE, body))
                    }
                  }
                  val outcome = HP_TARGET_MOVE.toInt() or effectivenessBit(next.effectiveness)
                  listOf(BattleEffectTarget(next.targetId, outcome.toShort(), subEvents)) +
                      elsewhere
                }
                is BattleEvent.StageChanged ->
                    if (!next.failed) {
                      i++
                      listOf(
                          target(
                              next.targetId,
                              DEFAULT_TARGET_MOVE,
                              BattleEventBody.StatChange(
                                  statIndex(next.stat), next.delta.toShort())))
                    } else {
                      emptyList()
                    }
                is BattleEvent.MoveWithoutTarget -> {
                  i++
                  listOf(failTarget(battle, event.attackerId, next))
                }
                else -> emptyList()
              }
          broadcast(
              battle,
              BattleEntityMoveEventPacket(event.attackerId, event.moveId, MOVE_EVENT_KIND, targets))
        }
        is BattleEvent.StatusInflicted -> {
          broadcast(battle, BattlePokemonStatusPacket(event.targetId, event.status.id, null))
          sendNotice(battle, "${monName(battle, event.targetId)} is ${event.status.displayName.lowercase()}!")
        }
        is BattleEvent.StatusCured -> {
          broadcast(battle, BattlePokemonStatusPacket(event.targetId, PrimaryStatus.NONE.id, null))
          sendNotice(battle, "${monName(battle, event.targetId)} was cured of its status!")
        }
        is BattleEvent.StatusDamage -> {
          broadcast(battle, BattleEntityDeltaPacket(entityId = event.targetId, currentHp = event.newHp.toShort()))
          sendNotice(battle, "${monName(battle, event.targetId)} took ${event.damage} damage from ${event.status.displayName.lowercase()}!")
        }
        is BattleEvent.Sleeping -> {
          sendNotice(battle, "${monName(battle, event.attackerId)} is fast asleep!")
        }
        is BattleEvent.WokeUp -> {
          broadcast(battle, BattlePokemonStatusPacket(event.attackerId, PrimaryStatus.NONE.id, null))
          sendNotice(battle, "${monName(battle, event.attackerId)} woke up!")
        }
        is BattleEvent.FullyParalyzed -> {
          sendNotice(battle, "${monName(battle, event.attackerId)} is paralyzed! It can't move!")
        }
        is BattleEvent.Thawed -> {
          broadcast(battle, BattlePokemonStatusPacket(event.attackerId, PrimaryStatus.NONE.id, null))
          sendNotice(battle, "${monName(battle, event.attackerId)} thawed out!")
        }
        is BattleEvent.Confused -> {
          sendNotice(battle, "${monName(battle, event.attackerId)} is confused!")
        }
        is BattleEvent.ConfusionSnappedOut -> {
          sendNotice(battle, "${monName(battle, event.attackerId)} snapped out of confusion!")
        }
        is BattleEvent.ConfusedSelfHit -> {
          broadcast(battle, BattleEntityDeltaPacket(entityId = event.attackerId, currentHp = event.newHp.toShort()))
          sendNotice(battle, "It hurt itself in its confusion!")
        }
        is BattleEvent.Flinched -> {
          sendNotice(battle, "${monName(battle, event.attackerId)} flinched and couldn't move!")
        }
        is BattleEvent.AbsorbHealed -> {
          broadcast(battle, BattleEntityDeltaPacket(entityId = event.attackerId, currentHp = event.newHp.toShort()))
          sendNotice(battle, "${monName(battle, event.attackerId)} regained ${event.healed} HP!")
        }
        is BattleEvent.RecoilDamage -> {
          broadcast(battle, BattleEntityDeltaPacket(entityId = event.attackerId, currentHp = event.newHp.toShort()))
          sendNotice(battle, "${monName(battle, event.attackerId)} was hit with recoil!")
        }
        is BattleEvent.HpRestored -> {
          broadcast(battle, BattleEntityDeltaPacket(entityId = event.targetId, currentHp = event.newHp.toShort()))
          sendNotice(battle, "${monName(battle, event.targetId)} restored ${event.healed} HP!")
        }
        is BattleEvent.AbilityTriggered -> {
          sendNotice(battle, "[${event.ability.name}] ${event.description}")
        }
        is BattleEvent.DamageDealt -> Unit
        is BattleEvent.StageChanged -> Unit
        is BattleEvent.Fainted -> Unit
        is BattleEvent.MoveWithoutTarget -> Unit
      }
      i++
    }
  }

  private fun monName(battle: BattleInstance, entityId: Long): String {
    val mon = battle.party.firstOrNull { it.entityId == entityId }
        ?: battle.opponent.firstOrNull { it.entityId == entityId }
    return mon?.species?.name ?: "Pokémon"
  }

  fun sendSwitchIn(battle: BattleInstance, oldSlot: Int, fullBlock: Boolean) {
    broadcast(
        battle,
        BattleSwitchInPacket(
            newSlot = battle.activeSlot,
            oldSlot = oldSlot,
            mon = battle.activeMon().toBlock(slot = battle.activeSlot, movesPresent = true),
            fullBlock = fullBlock,
        ),
    )
  }

  fun sendOpponentSwitchIn(battle: BattleInstance, oldSlot: Int, fullBlock: Boolean) {
    broadcast(
        battle,
        BattleSwitchInPacket(
            newSlot = battle.opponentSlot,
            oldSlot = oldSlot,
            mon = battle.opponentMon().toBlock(battle.opponentSlot, movesPresent = false),
            fullBlock = fullBlock,
            side = OPPONENT_SIDE,
        ),
    )
  }

  fun sendPrompt(battle: BattleInstance) {
    broadcast(battle, BattleTileMapPacket(groupId = battle.turn.toShort(), slotTiles = null))
    broadcast(battle, BattleQueuedEventPacket(packed = ACTION_PROMPT))
  }

  fun sendSwitchPrompt(battle: BattleInstance) {
    broadcast(battle, BattleSlotFlagEventPacket(slot = 0, flag = false, immediate = false))
  }

  fun sendSwitchConfirm(battle: BattleInstance) {
    broadcast(battle, BattleSlotFlagEventPacket(slot = 0, flag = false, immediate = true))
  }

  fun sendFled(battle: BattleInstance) {
    broadcast(battle, BattleSlotEventEnumPacket(slot = 0, eventType = FLED_EVENT))
    broadcast(battle, BattleBulkStatePacket.fled())
    battle.session.send(EntityPresencePacket(entityId = battle.charId, status = PRESENCE_OVERWORLD))
  }

  fun sendBattleEnd(battle: BattleInstance, party: List<Pokemon>, prizeMoney: Int = 0) {
    broadcast(battle, BattleBulkStatePacket.battleEnd(prizeMoney))
    battle.session.send(EntityPresencePacket(entityId = battle.charId, status = PRESENCE_OVERWORLD))
    battle.session.send(
        PokemonContainerPacket(
            container = PokemonContainer.PARTY,
            hasChange = true,
            delete = false,
            pokemon = party,
        ),
    )
  }

  fun sendVictoryDelta(battle: BattleInstance, entityId: Long, reward: RewardResult) {
    broadcast(
        battle,
        BattleEntityDeltaPacket(
            entityId = entityId,
            experience = Experience(reward.newLevel.toByte(), reward.newXp),
        ),
    )
    broadcast(battle, experienceReward(entityId, reward.xpGained))
    if (!reward.leveled) return
    broadcast(
        battle,
        BattleEntityDeltaPacket(
            entityId = entityId,
            statValues = reward.newStats.asWireList(),
            currentHp = reward.newCurrentHp.toShort(),
            evValues = reward.newEvs.asWireList(),
        ),
    )
  }

  private fun experienceReward(entityId: Long, gained: Int): BattleStatCountersPacket =
      BattleStatCountersPacket(
          entityId = entityId,
          baseCounter = gained,
          counter1 = null,
          counter2 = null,
          counter3 = null,
          counter4 = null,
          counter5 = null,
          counter6 = null,
      )

  fun sendNotice(battle: BattleInstance, message: String) {
    battle.session.send(notice(message))
  }

  private fun target(entityId: Long, targetMove: Short, body: BattleEventBody): BattleEffectTarget =
      BattleEffectTarget(entityId, targetMove, listOf(BattleActionEvent(null, null, body)))

  private fun failTarget(
      battle: BattleInstance,
      attackerId: Long,
      event: BattleEvent.MoveWithoutTarget,
  ): BattleEffectTarget {
    val defender =
        if (battle.isPlayerSide(attackerId)) battle.opponentMon().entityId
        else battle.activeMon().entityId
    return when (event) {
      is BattleEvent.MoveMissed -> BattleEffectTarget(defender, MISSED_TARGET_MOVE, emptyList())
      is BattleEvent.MoveFailed -> BattleEffectTarget(defender, FAILED_TARGET_MOVE, emptyList())
    }
  }

  private fun effectivenessBit(effectiveness: Int): Int =
      when {
        effectiveness > TypeChart.NEUTRAL -> SUPER_EFFECTIVE_BIT
        effectiveness in 1..<TypeChart.NEUTRAL -> NOT_VERY_EFFECTIVE_BIT
        else -> 0
      }

  fun broadcast(battle: BattleInstance, packet: Any) {
    interestManager.broadcast(battle.key, packet)
  }

  fun moveSlotsDelta(
      entityId: Long,
      moveSlots: List<Pair<Short, Byte>>,
      ppUps: Byte,
  ): BattleEntityDeltaPacket =
      BattleEntityDeltaPacket(entityId = entityId, moves = MoveSlots(moveSlots, ppUps))

  private fun statIndex(stat: BattleStat): Byte =
      when (stat) {
        BattleStat.ATTACK -> 1
        BattleStat.DEFENSE -> 2
        BattleStat.SPEED -> 3
        BattleStat.SP_ATTACK -> 4
        BattleStat.SP_DEFENSE -> 5
        BattleStat.ACCURACY -> 6
        BattleStat.EVASION -> 7
      }
}

private fun statOrder(hp: Int, atk: Int, def: Int, spd: Int, spAtk: Int, spDef: Int): List<Short> =
    listOf(
        hp.toShort(), atk.toShort(), def.toShort(), spd.toShort(), spAtk.toShort(), spDef.toShort())

internal fun ComputedStats.asWireList(): List<Short> = statOrder(hp, atk, def, spd, spAtk, spDef)

private fun EVs.asWireList(): List<Short> = statOrder(hp, atk, def, spd, spAtk, spDef)
