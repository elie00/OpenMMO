package de.fiereu.openmmo.server.game.services

import de.fiereu.network.PacketEvent
import de.fiereu.network.SessionContext
import de.fiereu.openmmo.common.enums.ChatType
import de.fiereu.openmmo.common.enums.Language
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.net.game.packets.ChatMessagePacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlCreateListingPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlListKind
import de.fiereu.openmmo.net.game.packets.gtl.GtlListingCancelPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlListingsPagePacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlListingsPageRequestPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlOpenSessionPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlPurchaseListingPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlSearchPagePacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlSearchPageRequestPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlTradeLogRequestPacket
import de.fiereu.openmmo.net.game.packets.gtl.TradeListing
import de.fiereu.openmmo.net.game.packets.gtl.TradeListingEntry
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.session.SessionRegistry
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.GtlListingRecord
import de.fiereu.openmmo.server.game.storage.GtlStore
import de.fiereu.openmmo.server.game.storage.GtlTradeLogRecord
import de.fiereu.openmmo.server.game.storage.InMemoryGtlStore
import io.github.oshai.kotlinlogging.KotlinLogging
import javax.inject.Inject
import javax.inject.Singleton

private val log = KotlinLogging.logger {}
private const val PAGE_SIZE = 50

@Singleton
class GtlService
@Inject
constructor(
    private val gtlStore: GtlStore,
    private val characterStore: CharacterStore,
    private val sessionRegistry: SessionRegistry,
) {

  fun onOpenSession(event: PacketEvent<GtlOpenSessionPacket>) {
    log.info { "GTL session opened for ${event.session.remoteAddress}" }
  }

  fun onListingsPageRequest(event: PacketEvent<GtlListingsPageRequestPacket>) {
    val req = event.packet
    val (total, records) =
        gtlStore.getListings(
            kind = req.listKind,
            categoryId = req.categoryId,
            page = req.page.toInt(),
            pageSize = PAGE_SIZE,
        )

    val tradeListings =
        records.map { record ->
          TradeListing(
              typeId = if (record.listKind == GtlListKind.ITEM) 1 else 0,
              price = record.price,
              fieldB = record.quantity.toInt(),
              fieldC = record.listingId.toInt(),
              fieldD = 0,
              entries = listOf(TradeListingEntry(record.listingId.toInt(), record.price, 0)),
          )
        }

    val reply =
        GtlListingsPagePacket(
            requestId = req.requestId,
            listKind = req.listKind,
            page = req.page,
            totalCount = total,
            listings = tradeListings,
        )
    event.session.send(reply)
  }

  fun onSearchPageRequest(event: PacketEvent<GtlSearchPageRequestPacket>) {
    val req = event.packet
    val (total, records) =
        gtlStore.getListings(
            kind = req.listKind,
            categoryId = req.categoryId,
            page = req.page.toInt(),
            pageSize = PAGE_SIZE,
        )

    val searchListings = records.map { it.toSearchListing() }

    val reply =
        GtlSearchPagePacket(
            requestId = req.requestId,
            listKind = req.listKind,
            page = req.page,
            totalMatches = total,
            listings = searchListings,
            quotes = null,
        )
    event.session.send(reply)
  }

  fun onCreateListing(event: PacketEvent<GtlCreateListingPacket>) {
    val session = event.session
    val charId = session.attributes[PLAYER_STATE]?.characterId ?: return
    val stored = characterStore.getCharacter(charId) ?: return
    val req = event.packet

    val price = req.priceShort.toInt().coerceAtLeast(1)
    val qty = req.listingCount.toInt().coerceAtLeast(1)
    val itemId = req.itemKind.toInt()

    if (itemId != 0) {
      val ownedQty = stored.items[itemId] ?: 0
      if (ownedQty < qty) {
        session.send(notice("You don't have enough items to list."))
        return
      }

      // Deduct items from bag
      characterStore.addItem(charId, itemId, -qty)
      characterStore.flushCharacterAsync(charId)

      val listingId =
          if (gtlStore is InMemoryGtlStore) gtlStore.newListingId()
          else System.currentTimeMillis()

      val nowSec = (System.currentTimeMillis() / 1000).toInt()
      val record =
          GtlListingRecord(
              listingId = listingId,
              sellerCharId = charId,
              sellerName = stored.info.name,
              listKind = GtlListKind.ITEM,
              categoryId = req.categoryIndex,
              price = price,
              listedAt = nowSec,
              expiresAt = nowSec + 86400 * 7,
              quantity = qty.toShort(),
              itemId = itemId,
              itemState = 0,
          )

      gtlStore.addListing(record)
      session.send(notice("Item listed on GTL for $$price!"))
      log.info { "char=$charId listed item $itemId x$qty for $$price on GTL" }
    }
  }

  fun onPurchaseListing(event: PacketEvent<GtlPurchaseListingPacket>) {
    val session = event.session
    val buyerCharId = session.attributes[PLAYER_STATE]?.characterId ?: return
    val buyer = characterStore.getCharacter(buyerCharId) ?: return
    val listingId = event.packet.listingId.toLong()

    val listing = gtlStore.getListing(listingId)
    if (listing == null) {
      session.send(notice("This listing is no longer available."))
      return
    }

    if (listing.sellerCharId == buyerCharId) {
      session.send(notice("You cannot buy your own listing."))
      return
    }

    val cost = listing.price
    if (buyer.info.money < cost) {
      session.send(notice("You don't have enough money to buy this (need $$cost)."))
      return
    }

    // Deduct money from buyer
    if (!characterStore.addMoney(buyerCharId, -cost)) {
      session.send(notice("Transaction failed."))
      return
    }

    // Credit money to seller
    characterStore.addMoney(listing.sellerCharId, cost)

    // Deliver asset to buyer
    if (listing.listKind == GtlListKind.ITEM) {
      characterStore.addItem(buyerCharId, listing.itemId, listing.quantity.toInt())
    } else if (listing.pokemon != null) {
      val nextSlot = ((buyer.pokemon.maxOfOrNull { it.containerSlot } ?: -1) + 1).toShort()
      val deliveredMon =
          listing.pokemon.copy(
              ownerId = buyerCharId,
              container = PokemonContainer.PARTY,
              containerSlot = nextSlot,
          )
      characterStore.addPokemon(buyerCharId, deliveredMon)
    }

    // Remove listing from store
    gtlStore.removeListing(listingId)

    // Flush both
    characterStore.flushCharacterAsync(buyerCharId)
    characterStore.flushCharacterAsync(listing.sellerCharId)

    // Log transaction
    val nowSec = System.currentTimeMillis()
    gtlStore.addTradeLog(
        GtlTradeLogRecord(
            id = nowSec,
            charId = buyerCharId,
            isBuyer = true,
            counterpartyName = listing.sellerName,
            itemName = if (listing.listKind == GtlListKind.ITEM) "Item #${listing.itemId}" else (listing.pokemon?.nickname ?: "Pokemon"),
            price = cost,
            timestamp = nowSec,
        )
    )

    session.send(notice("Successfully purchased for $$cost!"))
    log.info { "char=$buyerCharId bought listing $listingId from char=${listing.sellerCharId} for $$cost" }

    // Notify seller if online
    val sellerSession = sessionRegistry.getByCharacterId(listing.sellerCharId)
    sellerSession?.send(notice("Your GTL listing was sold for $$cost!"))
  }

  fun onListingCancel(event: PacketEvent<GtlListingCancelPacket>) {
    val session = event.session
    val charId = session.attributes[PLAYER_STATE]?.characterId ?: return
    val listingId = event.packet.listingId.toLongOrNull() ?: return

    val listing = gtlStore.getListing(listingId)
    if (listing == null || listing.sellerCharId != charId) {
      session.send(notice("Listing not found or not owned by you."))
      return
    }

    gtlStore.removeListing(listingId)

    // Return items or Pokemon back to seller
    if (listing.listKind == GtlListKind.ITEM) {
      characterStore.addItem(charId, listing.itemId, listing.quantity.toInt())
    } else if (listing.pokemon != null) {
      val stored = characterStore.getCharacter(charId)
      val nextSlot = (((stored?.pokemon?.maxOfOrNull { it.containerSlot } ?: -1)) + 1).toShort()
      val returnedMon = listing.pokemon.copy(containerSlot = nextSlot)
      characterStore.addPokemon(charId, returnedMon)
    }

    characterStore.flushCharacterAsync(charId)
    session.send(notice("Listing cancelled. Items returned to your bag."))
    log.info { "char=$charId cancelled GTL listing $listingId" }
  }

  fun onTradeLogRequest(event: PacketEvent<GtlTradeLogRequestPacket>) {
    log.info { "char trade log requested" }
  }

  private fun notice(msg: String): ChatMessagePacket =
      ChatMessagePacket(
          type = ChatType.TRADE,
          language = Language.EN,
          message = msg,
          sender = "GTL",
      )
}
