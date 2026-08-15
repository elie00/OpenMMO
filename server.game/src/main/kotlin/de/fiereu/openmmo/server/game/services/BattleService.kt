package de.fiereu.openmmo.server.game.services

import de.fiereu.network.PacketEvent
import de.fiereu.network.SessionContext
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.Ability
import de.fiereu.openmmo.common.enums.BattleAction
import de.fiereu.openmmo.common.enums.IVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.moves.MoveRegistry
import de.fiereu.openmmo.net.game.packets.MapLoadedAckPacket
import de.fiereu.openmmo.net.game.packets.SocialListEntryAddPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleActionSelectPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleEntityDeltaPacket
import de.fiereu.openmmo.net.game.packets.battle.BattleListEventDetail
import de.fiereu.openmmo.net.game.packets.battle.BattleListEventPacket
import de.fiereu.openmmo.net.game.packets.battle.moves.MoveLearnPromptPacket
import de.fiereu.openmmo.net.game.packets.battle.moves.MoveLearnReplyPacket
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.battle.BattleEvent
import de.fiereu.openmmo.server.game.battle.BattleInstance
import de.fiereu.openmmo.server.game.battle.BattleMonState
import de.fiereu.openmmo.server.game.battle.BattlePacketEmitter
import de.fiereu.openmmo.server.game.battle.BattleRegistry
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.battle.BattleRewards
import de.fiereu.openmmo.server.game.battle.BattleRng
import de.fiereu.openmmo.server.game.battle.BattleRules
import de.fiereu.openmmo.server.game.battle.BattleStat
import de.fiereu.openmmo.server.game.battle.CatchCalculator
import de.fiereu.openmmo.server.game.battle.MoveLearner
import de.fiereu.openmmo.server.game.battle.PrimaryStatus
import de.fiereu.openmmo.server.game.battle.StatCalculator
import de.fiereu.openmmo.server.game.battle.TurnEngine
import de.fiereu.openmmo.server.game.battle.WildMonFactory
import de.fiereu.openmmo.server.game.battle.acquiredMonsterDelta
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.world.interest.InterestManager
import de.fiereu.openmmo.trainer.TrainerDef
import de.fiereu.openmmo.trainer.TrainerRegistry
import io.github.oshai.kotlinlogging.KotlinLogging
import java.time.LocalDateTime
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

private val log = KotlinLogging.logger {}

private val POKE_BALL_ITEM: Short = Items.POKE_BALL.toShort()

/**
 * A prompt waiting for its answer, kept after the battle ends. A trainer battle can raise one
 * monster past a level more than once, so these are held per monster rather than per player.
 */
private data class PendingMoveLearn(
    val charId: Long,
    val entityId: Long,
    val offered: List<Short>,
)

/**
 * Orchestrates battles: builds the battle state from the party and the opposing side, routes client
 * actions through the [TurnEngine], and persists the outcome. Packets go out through the
 * [BattlePacketEmitter] over the battle's interest key.
 */
@Singleton
class BattleService
@Inject
constructor(
    private val characterStore: CharacterStore,
    private val battles: BattleRegistry,
    private val engine: TurnEngine,
    private val wildMons: WildMonFactory,
    private val emitter: BattlePacketEmitter,
    private val rewards: BattleRewards,
    private val moveLearner: MoveLearner,
    private val interestManager: InterestManager,
    private val speciesRegistry: SpeciesRegistry,
    private val moveRegistry: MoveRegistry,
    private val trainers: TrainerRegistry,
) {

  private val pendingLearns = ConcurrentHashMap<Long, PendingMoveLearn>()

  fun onBattlePacket(event: PacketEvent<*>) {
    log.info { "Battle packet ${event.packet::class.simpleName} received: ${event.packet}" }
  }

  fun onBattleAction(event: PacketEvent<BattleActionSelectPacket>) {
    val charId = event.session.attributes[PLAYER_STATE]?.characterId ?: return
    val battle = battles.byChar(charId) ?: return
    if (battle.pendingResult != null) return
    val action = event.packet
    log.info { "Battle action char=$charId: $action" }
    // While the active mon is fainted the player owes a replacement and may only switch.
    if (battle.activeMon().fainted && action.action != BattleAction.SWITCH) return
    when (action.action) {
      BattleAction.MOVE -> resolveTurn(battle, action.moveOrItemId)
      BattleAction.ITEM -> useItem(battle, action.moveOrItemId.toInt(), action.targetEntityId)
      BattleAction.SWITCH -> switchMon(battle, action.moveOrItemId)
      BattleAction.RUN -> flee(battle)
    }
  }

  /** Applies the moveset the player picked after a level up. */
  fun onMoveLearnReply(event: PacketEvent<MoveLearnReplyPacket>) {
    val charId = event.session.attributes[PLAYER_STATE]?.characterId ?: return
    val reply = event.packet
    val pending = pendingLearns[reply.entityId] ?: return
    if (pending.charId != charId) return
    pendingLearns.remove(reply.entityId)
    val stored =
        characterStore.getCharacter(charId)?.pokemon?.firstOrNull { it.id == reply.entityId }
            ?: return
    val moves = stored.moves.toMutableList()
    if (!moveLearner.apply(moves, reply.moveIds, pending.offered)) {
      log.warn { "char=$charId picked an invalid moveset for ${reply.entityId}: ${reply.moveIds}" }
      return
    }
    if (moves == stored.moves) return
    characterStore.updatePokemon(charId, stored.copy(moves = moves))
    characterStore.flushCharacterAsync(charId)
    // A battle still running holds its own copy, and the next reward writes that copy back over
    // the store. Move the live one across so the pick survives the rest of the battle.
    battles
        .byChar(charId)
        ?.party
        ?.firstOrNull { it.entityId == reply.entityId }
        ?.let { live ->
          live.moves.clear()
          live.moves.addAll(moves.map { PokemonMove(it.id, it.pp) })
          live.source = live.source.copy(moves = moves)
        }
    event.session.send(emitter.moveSlotsDelta(reply.entityId, moves.map { it.id to it.pp }, 0))
  }

  /** Throws a ball at the monster. False when the character is not in a battle. */
  fun catchActiveWild(charId: Long): Boolean {
    val battle = battles.byChar(charId) ?: return false
    useItem(battle, Items.POKE_BALL, 0L)
    return true
  }

  /** Ends a running battle when the player disconnects, keeping the last hp and pp state. */
  fun onDisconnect(session: SessionContext) {
    val charId = session.attributes[PLAYER_STATE]?.characterId ?: return
    pendingLearns.values.removeIf { it.charId == charId }
    val battle = battles.byChar(charId) ?: return
    persistParty(battle)
    finishBattle(battle, BattleResult.DISCONNECTED)
  }

  /** Resumes scripts after returning to the overworld. */
  fun onClientReady(event: PacketEvent<MapLoadedAckPacket>) {
    if (event.packet.data.isNotEmpty()) return
    val charId = event.session.attributes[PLAYER_STATE]?.characterId ?: return
    val battle = battles.byChar(charId) ?: return
    val result = battle.pendingResult ?: return
    finishBattle(battle, result)
  }

  /** True while the character has a battle running, so callers can skip starting another. */
  fun inBattle(charId: Long): Boolean = battles.byChar(charId) != null

  fun startWildBattle(session: SessionContext, dexId: Int, level: Int) {
    createWildBattle(session, dexId, level, catchable = true, escapable = true)
  }

  /** Runs a story battle and waits for its scene. */
  suspend fun startScriptedBattle(
      session: SessionContext,
      dexId: Int,
      level: Int,
      moveIds: List<Int> = emptyList(),
  ): BattleResult {
    val battle =
        createWildBattle(
            session,
            dexId,
            level,
            catchable = false,
            escapable = false,
            moveIds = moveIds,
        ) ?: return BattleResult.FAILED
    return battle.completion.await()
  }

  /** Runs a battle against the decomp trainer with this id and waits for its scene. */
  suspend fun startTrainerBattle(
      session: SessionContext,
      region: Region,
      trainerId: Int,
  ): BattleResult {
    val trainer = trainers.get(region, trainerId)
    if (trainer == null) {
      log.warn { "No $region trainer with id $trainerId" }
      return BattleResult.FAILED
    }
    return startTrainerBattle(session, trainer)
  }

  /** Runs a battle against a trainer's whole team and waits for its scene. */
  suspend fun startTrainerBattle(session: SessionContext, trainer: TrainerDef): BattleResult {
    val battle =
        createBattle(
            session,
            trainer.party.map { OpponentSpec(it.dexId, it.level, it.moveIds, it.iv) },
            catchable = false,
            escapable = false,
            trainer = trainer,
        ) ?: return BattleResult.FAILED
    return battle.completion.await()
  }

  /** Empty [moveIds] keeps the level up moveset, a null [iv] rolls one like a wild encounter. */
  private data class OpponentSpec(
      val dexId: Int,
      val level: Int,
      val moveIds: List<Int>,
      val iv: Int? = null,
  )

  private fun createWildBattle(
      session: SessionContext,
      dexId: Int,
      level: Int,
      catchable: Boolean,
      escapable: Boolean,
      moveIds: List<Int> = emptyList(),
  ): BattleInstance? =
      createBattle(session, listOf(OpponentSpec(dexId, level, moveIds)), catchable, escapable)

  private fun createBattle(
      session: SessionContext,
      opponents: List<OpponentSpec>,
      catchable: Boolean,
      escapable: Boolean,
      trainer: TrainerDef? = null,
  ): BattleInstance? {
    val charId = session.attributes[PLAYER_STATE]?.characterId ?: return null
    if (battles.byChar(charId) != null) {
      session.send(notice("You are already in a battle."))
      return null
    }
    val stored = characterStore.getCharacter(charId) ?: return null
    if (stored.pokemon.isEmpty()) {
      session.send(notice("You need a monster in your party to battle."))
      return null
    }
    val party = mutableListOf<BattleMonState>()
    for ((index, mon) in stored.pokemon.withIndex()) {
      val def = speciesRegistry.get(mon.dexId)
      if (def == null) {
        session.send(notice("Your party has a species the battle data does not cover yet."))
        return null
      }
      party += BattleMonState(mon.id, def, index, mon, StatCalculator.computeAll(def, mon))
    }
    if (party.all { it.fainted }) {
      session.send(notice("All of your monsters have fainted."))
      return null
    }
    val rng = BattleRng()
    val enemies = mutableListOf<BattleMonState>()
    for (spec in opponents) {
      var rolled = wildMons.create(spec.dexId, spec.level, rng)
      if (rolled == null) {
        session.send(notice("Unknown species ${spec.dexId}."))
        return null
      }
      if (spec.moveIds.isNotEmpty()) {
        rolled =
            rolled.copy(
                moves =
                    spec.moveIds.take(4).map { id ->
                      PokemonMove(id.toShort(), (moveRegistry.get(id)?.pp ?: 0).toByte())
                    } + List((4 - spec.moveIds.size).coerceAtLeast(0)) { PokemonMove(0, 0) })
      }
      val def = speciesRegistry.get(spec.dexId)!!
      if (spec.iv != null) {
        val ivs =
            IVs().apply {
              hp = spec.iv
              atk = spec.iv
              this.def = spec.iv
              spAtk = spec.iv
              spDef = spec.iv
              spd = spec.iv
            }
        val fixed = rolled.copy(iVs = ivs)
        rolled = fixed.copy(hp = StatCalculator.computeAll(def, fixed).hp.toShort())
      }
      enemies +=
          BattleMonState(rolled.id, def, null, rolled, StatCalculator.computeAll(def, rolled))
    }
    log.info {
      "Starting battle for char=$charId (${stored.info.name}) against " +
          enemies.joinToString { "${it.species.name} level ${it.level}" }
    }
    val battle =
        battles.create(
            charId, session, party, enemies, rng, BattleRules(catchable, escapable, trainer))
    val firstAlive = party.indexOfFirst { !it.fainted }
    battle.activeSlot = firstAlive
    battle.seenActive.clear()
    battle.seenActive.add(firstAlive)
    interestManager.join(session, battle.key)
    emitter.sendStart(battle, stored.info.name)

    // Trigger Intimidate on initial battle start
    checkIntimidateOnEntry(battle, battle.activeMon(), battle.opponentMon())
    checkIntimidateOnEntry(battle, battle.opponentMon(), battle.activeMon())

    return battle
  }

  private fun resolveTurn(battle: BattleInstance, moveId: Short) {
    val events = engine.resolveTurn(battle, moveId)
    emitter.sendEvents(battle, events)
    afterTurn(battle)
  }

  private fun afterTurn(battle: BattleInstance) {
    when {
      battle.opponent.all { it.fainted } -> endVictory(battle)
      battle.party.all { it.fainted } -> endDefeat(battle)
      else -> {
        if (battle.opponentMon().fainted) {
          awardXp(battle, battle.opponentMon())
          sendOutNextOpponent(battle)
        }
        if (battle.activeMon().fainted) {
          emitter.sendSwitchPrompt(battle)
        } else {
          battle.turn += 1
          emitter.sendPrompt(battle)
        }
      }
    }
  }

  private fun useItem(battle: BattleInstance, itemId: Int, targetEntityId: Long) {
    val stored = characterStore.getCharacter(battle.charId) ?: return
    val qty = stored.items[itemId] ?: 0
    if (qty <= 0) {
      emitter.sendNotice(battle, "You don't have any left.")
      emitter.sendPrompt(battle)
      return
    }

    if (CatchCalculator.isPokeBall(itemId)) {
      if (!battle.catchable) {
        emitter.sendNotice(battle, "You can't catch this monster.")
        emitter.sendPrompt(battle)
        return
      }

      // Consume 1 Pokéball
      characterStore.addItem(battle.charId, itemId, -1)

      val target = battle.opponentMon()
      val caught = CatchCalculator.attemptCatch(itemId, target, battle.turn, battle.rng)

      if (caught) {
        val nextSlot = ((stored.pokemon.maxOfOrNull { it.containerSlot } ?: -1) + 1).toShort()
        val caughtMon =
            target.source.copy(
                ownerId = battle.charId,
                container = PokemonContainer.PARTY,
                containerSlot = nextSlot,
                ot = stored.info.name,
                hp = target.currentHp.toShort(),
                moves = target.moves.map { PokemonMove(it.id, it.pp) },
                caughtAt = LocalDateTime.now(),
            )
        log.info {
          "Caught wild ${target.species.name} for char=${battle.charId} with item $itemId"
        }
        battle.session.send(SocialListEntryAddPacket(caughtMon))
        battle.session.send(acquiredMonsterDelta(caughtMon, target.species))
        battle.session.send(
            BattleListEventPacket(
                kind = 0,
                value = itemId.toShort(),
                subKind = 4,
                detail = BattleListEventDetail(listType = 1, value = 1),
            ),
        )
        characterStore.addPokemon(battle.charId, caughtMon)
        endBattle(battle, BattleResult.CAUGHT)
      } else {
        emitter.sendNotice(battle, "Oh no! The Pokémon broke free!")
        battle.session.send(
            BattleListEventPacket(
                kind = 0,
                value = itemId.toShort(),
                subKind = 4,
                detail = BattleListEventDetail(listType = 1, value = 1),
            ),
        )
        val events = engine.resolveItemTurn(battle)
        emitter.sendEvents(battle, events)
        afterTurn(battle)
      }
      return
    }

    // Healing / Status / Revive / Stat booster items
    val targetMon =
        if (targetEntityId != 0L)
            battle.party.firstOrNull { it.entityId == targetEntityId } ?: battle.activeMon()
        else battle.activeMon()

    val used = applyHealingItem(battle, itemId, targetMon)
    if (!used) {
      emitter.sendNotice(battle, "It won't have any effect.")
      emitter.sendPrompt(battle)
      return
    }

    characterStore.addItem(battle.charId, itemId, -1)

    // Item uses player's turn, opponent attacks
    val events = engine.resolveItemTurn(battle)
    emitter.sendEvents(battle, events)
    afterTurn(battle)
  }

  private fun applyHealingItem(
      battle: BattleInstance,
      itemId: Int,
      target: BattleMonState
  ): Boolean {
    when (itemId) {
      Items.POTION -> {
        if (target.fainted || target.currentHp >= target.stats.hp) return false
        val healed = 20
        target.currentHp = (target.currentHp + healed).coerceAtMost(target.stats.hp)
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.sendNotice(battle, "${target.species.name} recovered $healed HP!")
        return true
      }
      Items.SUPER_POTION -> {
        if (target.fainted || target.currentHp >= target.stats.hp) return false
        val healed = 50
        target.currentHp = (target.currentHp + healed).coerceAtMost(target.stats.hp)
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.sendNotice(battle, "${target.species.name} recovered $healed HP!")
        return true
      }
      Items.HYPER_POTION -> {
        if (target.fainted || target.currentHp >= target.stats.hp) return false
        val healed = 200
        target.currentHp = (target.currentHp + healed).coerceAtMost(target.stats.hp)
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.sendNotice(battle, "${target.species.name} recovered $healed HP!")
        return true
      }
      Items.MAX_POTION -> {
        if (target.fainted || target.currentHp >= target.stats.hp) return false
        target.currentHp = target.stats.hp
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.sendNotice(battle, "${target.species.name} fully restored its HP!")
        return true
      }
      Items.FULL_RESTORE -> {
        if (target.fainted ||
            (target.currentHp >= target.stats.hp &&
                target.primaryStatus == PrimaryStatus.NONE &&
                !target.isConfused))
            return false
        target.currentHp = target.stats.hp
        target.cureStatus()
        target.cureVolatiles()
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} fully restored HP and cured all status!")
        return true
      }
      Items.ANTIDOTE -> {
        if (target.primaryStatus != PrimaryStatus.POISON &&
            target.primaryStatus != PrimaryStatus.TOXIC)
            return false
        target.cureStatus()
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} was cured of poison!")
        return true
      }
      Items.BURN_HEAL -> {
        if (target.primaryStatus != PrimaryStatus.BURN) return false
        target.cureStatus()
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} was cured of its burn!")
        return true
      }
      Items.ICE_HEAL -> {
        if (target.primaryStatus != PrimaryStatus.FREEZE) return false
        target.cureStatus()
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} thawed out!")
        return true
      }
      Items.AWAKENING -> {
        if (target.primaryStatus != PrimaryStatus.SLEEP) return false
        target.cureStatus()
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} woke up!")
        return true
      }
      Items.PARALYZE_HEAL -> {
        if (target.primaryStatus != PrimaryStatus.PARALYSIS) return false
        target.cureStatus()
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} was cured of paralysis!")
        return true
      }
      Items.FULL_HEAL -> {
        if (target.primaryStatus == PrimaryStatus.NONE && !target.isConfused) return false
        target.cureStatus()
        target.cureVolatiles()
        emitter.broadcast(
            battle,
            de.fiereu.openmmo.net.game.packets.battle.BattlePokemonStatusPacket(
                target.entityId, PrimaryStatus.NONE.id, null))
        emitter.sendNotice(battle, "${target.species.name} was cured of all status conditions!")
        return true
      }
      Items.REVIVE -> {
        if (!target.fainted) return false
        target.currentHp = target.stats.hp / 2
        target.cureStatus()
        target.cureVolatiles()
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.sendNotice(battle, "${target.species.name} was revived!")
        return true
      }
      Items.MAX_REVIVE -> {
        if (!target.fainted) return false
        target.currentHp = target.stats.hp
        target.cureStatus()
        target.cureVolatiles()
        emitter.broadcast(
            battle,
            BattleEntityDeltaPacket(
                entityId = target.entityId, currentHp = target.currentHp.toShort()))
        emitter.sendNotice(battle, "${target.species.name} was fully revived!")
        return true
      }
      Items.X_ATTACK -> {
        if (target.fainted) return false
        target.changeStage(BattleStat.ATTACK, 1)
        emitter.sendNotice(battle, "X Attack boosted ${target.species.name}'s Attack!")
        return true
      }
      Items.X_DEFEND -> {
        if (target.fainted) return false
        target.changeStage(BattleStat.DEFENSE, 1)
        emitter.sendNotice(battle, "X Defend boosted ${target.species.name}'s Defense!")
        return true
      }
      Items.X_SPEED -> {
        if (target.fainted) return false
        target.changeStage(BattleStat.SPEED, 1)
        emitter.sendNotice(battle, "X Speed boosted ${target.species.name}'s Speed!")
        return true
      }
      Items.X_SPECIAL -> {
        if (target.fainted) return false
        target.changeStage(BattleStat.SP_ATTACK, 1)
        emitter.sendNotice(battle, "X Special boosted ${target.species.name}'s Sp. Atk!")
        return true
      }
      Items.X_ACCURACY -> {
        if (target.fainted) return false
        target.changeStage(BattleStat.ACCURACY, 1)
        emitter.sendNotice(battle, "X Accuracy boosted ${target.species.name}'s Accuracy!")
        return true
      }
      else -> return false
    }
  }

  private fun switchMon(battle: BattleInstance, partyIndex: Short) {
    val target = partyIndex.toInt()
    val mon = battle.party.getOrNull(target)
    val forced = battle.activeMon().fainted
    if (mon == null || mon.fainted || target == battle.activeSlot) {
      if (forced) {
        emitter.sendSwitchPrompt(battle)
      } else {
        battle.turn += 1
        emitter.sendPrompt(battle)
      }
      return
    }

    val outgoing = battle.activeMon()
    if (outgoing.ability == Ability.NATURAL_CURE && outgoing.primaryStatus != PrimaryStatus.NONE) {
      outgoing.cureStatus()
    }

    if (forced) emitter.sendSwitchConfirm(battle)
    performSwitch(battle, target)

    checkIntimidateOnEntry(battle, battle.activeMon(), battle.opponentMon())

    if (forced) {
      battle.turn += 1
      emitter.sendPrompt(battle)
    } else {
      emitter.sendEvents(battle, engine.resolveSwitchTurn(battle))
      afterTurn(battle)
    }
  }

  private fun checkIntimidateOnEntry(
      battle: BattleInstance,
      incoming: BattleMonState,
      opponent: BattleMonState
  ) {
    if (incoming.ability == Ability.INTIMIDATE && !opponent.fainted) {
      if (opponent.ability != Ability.CLEAR_BODY && opponent.ability != Ability.WHITE_SMOKE) {
        val delta = opponent.changeStage(BattleStat.ATTACK, -1)
        emitter.sendEvents(
            battle,
            listOf(
                BattleEvent.AbilityTriggered(
                    incoming.entityId,
                    Ability.INTIMIDATE,
                    "Intimidate cut ${opponent.species.name}'s Attack!"),
                BattleEvent.StageChanged(
                    opponent.entityId,
                    BattleStat.ATTACK,
                    opponent.stage(BattleStat.ATTACK),
                    opponent.effective(BattleStat.ATTACK),
                    -1,
                    delta == 0)))
      }
    }
  }

  private fun sendOutNextOpponent(battle: BattleInstance) {
    val next = battle.opponent.indexOfFirst { !it.fainted }
    if (next < 0) return
    val fullBlock = next !in battle.opponentSeen
    val oldSlot = battle.opponentSlot
    battle.opponentSlot = next
    battle.opponentSeen.add(next)
    log.info { "Opponent sends out slot $next for char=${battle.charId}" }
    emitter.sendOpponentSwitchIn(battle, oldSlot, fullBlock)

    checkIntimidateOnEntry(battle, battle.opponentMon(), battle.activeMon())
  }

  private fun performSwitch(battle: BattleInstance, target: Int) {
    val oldSlot = battle.activeSlot
    val fullBlock = target !in battle.seenActive
    battle.activeSlot = target
    battle.seenActive.add(target)
    log.info { "Switch char=${battle.charId} slot $oldSlot -> $target (fullBlock=$fullBlock)" }
    emitter.sendSwitchIn(battle, oldSlot, fullBlock)
  }

  private fun flee(battle: BattleInstance) {
    if (!battle.escapable) {
      emitter.sendNotice(battle, "You can't run from this battle.")
      emitter.sendPrompt(battle)
      return
    }
    emitter.sendFled(battle)
    persistParty(battle)
    battle.pendingResult = BattleResult.FLED
  }

  private fun endVictory(battle: BattleInstance) {
    awardXp(battle, battle.opponentMon())
    val prize = battle.trainer?.let { rewards.trainerPrize(it, battle.opponent.last().level) } ?: 0
    if (prize > 0) {
      characterStore.addMoney(battle.charId, prize)
      log.info { "char=${battle.charId} won $prize from ${battle.trainer?.name}" }
    }
    endBattle(battle, BattleResult.VICTORY, battle.activeMon().entityId, prize)
  }

  private fun awardXp(battle: BattleInstance, defeated: BattleMonState) {
    val winner = battle.activeMon()
    val reward = rewards.apply(winner, defeated.species, defeated.level, battle.trainer != null)
    log.info {
      "char=${battle.charId} won: +${reward.xpGained} xp, level ${winner.level} -> ${reward.newLevel}"
    }
    winner.currentHp = reward.newCurrentHp
    val outcome =
        moveLearner.learn(winner.moves, winner.source.dexId, winner.level, reward.newLevel)
    emitter.sendVictoryDelta(battle, winner.entityId, reward)
    for (move in outcome.learned) {
      emitter.sendNotice(battle, "${winner.species.name} learned ${move.name}!")
    }
    if (outcome.offered.isNotEmpty()) {
      val offered = outcome.offered.map { it.moveId.toShort() }
      pendingLearns[winner.entityId] = PendingMoveLearn(battle.charId, winner.entityId, offered)
      battle.session.send(MoveLearnPromptPacket(winner.entityId, offered))
    }
    val grown =
        winner.source.copy(
            level = reward.newLevel.toByte(),
            xp = reward.newXp,
            hp = reward.newCurrentHp.toShort(),
            eVs = reward.newEvs,
            moves = winner.moves.map { PokemonMove(it.id, it.pp) },
        )
    winner.source = grown
    winner.stats = reward.newStats
    characterStore.updatePokemon(battle.charId, grown)
  }

  private fun endDefeat(battle: BattleInstance) {
    endBattle(battle, BattleResult.DEFEAT)
  }

  private fun endBattle(
      battle: BattleInstance,
      result: BattleResult,
      skip: Long? = null,
      prizeMoney: Int = 0,
  ) {
    persistParty(battle, skip)
    val party = characterStore.getCharacter(battle.charId)?.pokemon ?: emptyList()
    emitter.sendBattleEnd(battle, party, prizeMoney)
    battle.pendingResult = result
  }

  private fun persistParty(battle: BattleInstance, skip: Long? = null) {
    for (state in battle.party) {
      if (state.entityId == skip) continue
      val updated =
          state.source.copy(
              hp = state.currentHp.toShort(),
              moves = state.moves.map { PokemonMove(it.id, it.pp) },
          )
      characterStore.updatePokemon(battle.charId, updated)
    }
    characterStore.flushCharacterAsync(battle.charId)
  }

  private fun finishBattle(battle: BattleInstance, result: BattleResult) {
    interestManager.leave(battle.session, battle.key)
    battles.remove(battle.charId)
    battle.completion.complete(result)
  }
}
