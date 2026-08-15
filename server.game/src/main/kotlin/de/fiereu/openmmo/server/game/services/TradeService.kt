package de.fiereu.openmmo.server.game.services

import de.fiereu.network.PacketEvent
import de.fiereu.network.SessionContext
import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.enums.ChatType
import de.fiereu.openmmo.common.enums.Language
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.net.game.packets.ChatMessagePacket
import de.fiereu.openmmo.net.game.packets.TradeActionPacket
import de.fiereu.openmmo.net.game.packets.TradeListEntryPacket
import de.fiereu.openmmo.net.game.packets.TradeSelectMonPacket
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.session.SessionRegistry
import de.fiereu.openmmo.server.game.storage.CharacterStore
import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

private val log = KotlinLogging.logger {}

data class TradeParticipant(
    val charId: Long,
    val session: SessionContext,
    var offeredMon: Pokemon? = null,
    var confirmed: Boolean = false,
    var accepted: Boolean = false,
)

data class ActiveTradeSession(
    val id: Long,
    val participant1: TradeParticipant,
    val participant2: TradeParticipant,
) {
  fun other(charId: Long): TradeParticipant =
      if (participant1.charId == charId) participant2 else participant1

  fun self(charId: Long): TradeParticipant =
      if (participant1.charId == charId) participant1 else participant2

  fun contains(charId: Long): Boolean =
      participant1.charId == charId || participant2.charId == charId
}

@Singleton
class TradeService
@Inject
constructor(
    private val characterStore: CharacterStore,
    private val sessionRegistry: SessionRegistry,
) {
  private val activeTrades = ConcurrentHashMap<Long, ActiveTradeSession>()
  private val charToTrade = ConcurrentHashMap<Long, Long>()
  private val pendingRequests = ConcurrentHashMap<Long, Long>() // targetCharId -> sourceCharId
  private var nextTradeId = 1L

  /** Player sends a trade request or accepts an incoming trade request. */
  fun requestTrade(sourceSession: SessionContext, targetName: String) {
    val sourceState = sourceSession.attributes[PLAYER_STATE] ?: return
    val sourceCharId = sourceState.characterId ?: return
    val sourceChar = characterStore.getCharacter(sourceCharId) ?: return

    if (charToTrade.containsKey(sourceCharId)) {
      sourceSession.send(notice("You are already in a trade."))
      return
    }

    val targetId =
        sessionRegistry.onlineCharacterIds().firstOrNull { id ->
          characterStore.getCharacter(id)?.info?.name?.equals(targetName, ignoreCase = true) == true
        }

    val targetChar = targetId?.let { characterStore.getCharacter(it) }

    if (targetChar == null || targetId == null) {
      sourceSession.send(notice("Player '$targetName' is not online."))
      return
    }

    if (targetId == sourceCharId) {
      sourceSession.send(notice("You cannot trade with yourself."))
      return
    }

    if (charToTrade.containsKey(targetId)) {
      sourceSession.send(notice("Player '$targetName' is already busy trading."))
      return
    }

    val targetSession = sessionRegistry.getByCharacterId(targetId)
    if (targetSession == null) {
      sourceSession.send(notice("Player '$targetName' is not online."))
      return
    }

    // Check if target already sent a trade request to source (mutual accept)
    if (pendingRequests[sourceCharId] == targetId) {
      pendingRequests.remove(sourceCharId)
      startTradeSession(sourceCharId, sourceSession, targetId, targetSession)
      return
    }

    // Register pending trade request
    pendingRequests[targetId] = sourceCharId
    sourceSession.send(notice("Trade request sent to ${targetChar.info.name}."))
    targetSession.send(notice("${sourceChar.info.name} wants to trade with you. Type /trade ${sourceChar.info.name} to accept."))
  }

  fun onTradeSelectMon(event: PacketEvent<TradeSelectMonPacket>) {
    val session = event.session
    val charId = session.attributes[PLAYER_STATE]?.characterId ?: return
    val tradeId = charToTrade[charId] ?: return
    val trade = activeTrades[tradeId] ?: return

    val self = trade.self(charId)
    val other = trade.other(charId)

    val stored = characterStore.getCharacter(charId) ?: return
    val slot = event.packet.slotIndex
    val mon = stored.pokemon.getOrNull(slot) ?: return

    self.offeredMon = mon
    self.confirmed = false
    self.accepted = false
    other.accepted = false

    log.info { "char=$charId offered ${mon.nickname.ifEmpty { "mon" }} in trade $tradeId" }

    // Send offered mon to trading partner
    other.session.send(TradeListEntryPacket(pokemon = mon))
  }

  fun onTradeAction(event: PacketEvent<TradeActionPacket>) {
    val session = event.session
    val charId = session.attributes[PLAYER_STATE]?.characterId ?: return
    val tradeId = charToTrade[charId] ?: return
    val trade = activeTrades[tradeId] ?: return

    val self = trade.self(charId)
    val other = trade.other(charId)

    when (event.packet.action.toInt()) {
      0 -> { // Cancel / Exit trade
        cancelTrade(trade, "Trade cancelled by ${characterStore.getCharacter(charId)?.info?.name ?: "player"}.")
      }
      1 -> { // Lock offer / Confirm
        self.confirmed = true
        self.session.send(notice("Offer locked."))
        other.session.send(notice("Partner locked their offer."))
      }
      2 -> { // Accept trade
        if (!self.confirmed || !other.confirmed) {
          self.session.send(notice("Both players must lock their offers first."))
          return
        }
        self.accepted = true
        if (other.accepted) {
          executeTrade(trade)
        } else {
          self.session.send(notice("Waiting for partner to accept..."))
          other.session.send(notice("Partner accepted the trade!"))
        }
      }
      else -> {
        log.warn { "Unknown trade action: ${event.packet.action}" }
      }
    }
  }

  private fun startTradeSession(
      p1Id: Long,
      p1Session: SessionContext,
      p2Id: Long,
      p2Session: SessionContext,
  ) {
    val tradeId = synchronized(this) { nextTradeId++ }
    val session =
        ActiveTradeSession(
            id = tradeId,
            participant1 = TradeParticipant(p1Id, p1Session),
            participant2 = TradeParticipant(p2Id, p2Session),
        )
    activeTrades[tradeId] = session
    charToTrade[p1Id] = tradeId
    charToTrade[p2Id] = tradeId

    val p1Name = characterStore.getCharacter(p1Id)?.info?.name ?: "Player 1"
    val p2Name = characterStore.getCharacter(p2Id)?.info?.name ?: "Player 2"

    p1Session.send(notice("Trade session started with $p2Name."))
    p2Session.send(notice("Trade session started with $p1Name."))
    log.info { "Started trade $tradeId between $p1Name ($p1Id) and $p2Name ($p2Id)" }
  }

  private fun executeTrade(trade: ActiveTradeSession) {
    val p1 = trade.participant1
    val p2 = trade.participant2

    val mon1 = p1.offeredMon
    val mon2 = p2.offeredMon

    val char1 = characterStore.getCharacter(p1.charId)
    val char2 = characterStore.getCharacter(p2.charId)

    if (char1 == null || char2 == null) {
      cancelTrade(trade, "Trade failed: player state missing.")
      return
    }

    if (mon1 != null && mon2 != null) {
      // Swap mon1 to char2, and mon2 to char1
      val p1Party = char1.pokemon.toMutableList()
      val p2Party = char2.pokemon.toMutableList()

      p1Party.removeIf { it.id == mon1.id }
      p2Party.removeIf { it.id == mon2.id }

      val transferred1 = mon1.copy(ownerId = p2.charId, container = PokemonContainer.PARTY, containerSlot = p2Party.size.toShort())
      val transferred2 = mon2.copy(ownerId = p1.charId, container = PokemonContainer.PARTY, containerSlot = p1Party.size.toShort())

      p1Party.add(transferred2)
      p2Party.add(transferred1)

      characterStore.replaceProgress(p1.charId, p1Party, char1.items, char1.storyFlags, char1.storyVars)
      characterStore.replaceProgress(p2.charId, p2Party, char2.items, char2.storyFlags, char2.storyVars)

      characterStore.flushCharacterAsync(p1.charId)
      characterStore.flushCharacterAsync(p2.charId)

      p1.session.send(notice("Trade completed! Received ${mon2.nickname.ifEmpty { "Pokemon" }}."))
      p2.session.send(notice("Trade completed! Received ${mon1.nickname.ifEmpty { "Pokemon" }}."))
      log.info { "Trade ${trade.id} successful: swapped ${mon1.id} <-> ${mon2.id}" }
    } else {
      p1.session.send(notice("Trade completed."))
      p2.session.send(notice("Trade completed."))
    }

    cleanupTrade(trade)
  }

  fun cancelTrade(trade: ActiveTradeSession, reason: String) {
    trade.participant1.session.send(notice(reason))
    trade.participant2.session.send(notice(reason))
    cleanupTrade(trade)
  }

  fun onDisconnect(charId: Long) {
    pendingRequests.remove(charId)
    pendingRequests.values.removeIf { it == charId }
    val tradeId = charToTrade[charId] ?: return
    val trade = activeTrades[tradeId] ?: return
    cancelTrade(trade, "Trade cancelled: partner disconnected.")
  }

  private fun cleanupTrade(trade: ActiveTradeSession) {
    activeTrades.remove(trade.id)
    charToTrade.remove(trade.participant1.charId)
    charToTrade.remove(trade.participant2.charId)
  }

  private fun notice(msg: String): ChatMessagePacket =
      ChatMessagePacket(
          type = ChatType.TRADE,
          language = Language.EN,
          message = msg,
          sender = "Trade",
      )
}
