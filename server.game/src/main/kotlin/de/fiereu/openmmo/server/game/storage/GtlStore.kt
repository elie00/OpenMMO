package de.fiereu.openmmo.server.game.storage

import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.net.game.packets.gtl.GtlItemListing
import de.fiereu.openmmo.net.game.packets.gtl.GtlListKind
import de.fiereu.openmmo.net.game.packets.gtl.GtlPokemonListing
import de.fiereu.openmmo.net.game.packets.gtl.GtlSearchListing
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton

data class GtlListingRecord(
    val listingId: Long,
    val sellerCharId: Long,
    val sellerName: String,
    val listKind: GtlListKind,
    val categoryId: Byte,
    val price: Int,
    val listedAt: Int,
    val expiresAt: Int,
    val quantity: Short,
    val pokemon: Pokemon? = null,
    val itemId: Int = 0,
    val itemState: Byte = 0,
) {
  fun toSearchListing(): GtlSearchListing =
      when (listKind) {
        GtlListKind.ITEM ->
            GtlItemListing(
                listingId = listingId,
                price = price,
                listedAt = listedAt,
                expiresAt = expiresAt,
                quantity = quantity,
                itemId = itemId.toShort(),
                itemState = itemState,
            )
        else ->
            GtlPokemonListing(
                listingId = listingId,
                price = price,
                listedAt = listedAt,
                expiresAt = expiresAt,
                quantity = quantity,
                pokemon = pokemon,
                stats =
                    pokemon?.let {
                      listOf(it.hp, 0.toShort(), 0.toShort(), 0.toShort(), 0.toShort(), 0.toShort())
                    } ?: emptyList(),
            )
      }
}

data class GtlTradeLogRecord(
    val id: Long,
    val charId: Long,
    val isBuyer: Boolean,
    val counterpartyName: String,
    val itemName: String,
    val price: Int,
    val timestamp: Long,
)

interface GtlStore {
  fun addListing(listing: GtlListingRecord): GtlListingRecord

  fun getListing(listingId: Long): GtlListingRecord?

  fun removeListing(listingId: Long): GtlListingRecord?

  fun getListings(
      kind: GtlListKind?,
      categoryId: Byte,
      page: Int,
      pageSize: Int
  ): Pair<Int, List<GtlListingRecord>>

  fun getListingsBySeller(sellerCharId: Long): List<GtlListingRecord>

  fun addTradeLog(log: GtlTradeLogRecord)

  fun getTradeLogs(charId: Long): List<GtlTradeLogRecord>
}

@Singleton
class InMemoryGtlStore @Inject constructor() : GtlStore {
  private val listings = ConcurrentHashMap<Long, GtlListingRecord>()
  private val tradeLogs = ConcurrentHashMap<Long, CopyOnWriteArrayList<GtlTradeLogRecord>>()
  private val nextId = AtomicLong(1000L)

  fun newListingId(): Long = nextId.incrementAndGet()

  override fun addListing(listing: GtlListingRecord): GtlListingRecord {
    listings[listing.listingId] = listing
    return listing
  }

  override fun getListing(listingId: Long): GtlListingRecord? = listings[listingId]

  override fun removeListing(listingId: Long): GtlListingRecord? = listings.remove(listingId)

  override fun getListings(
      kind: GtlListKind?,
      categoryId: Byte,
      page: Int,
      pageSize: Int,
  ): Pair<Int, List<GtlListingRecord>> {
    val filtered =
        listings.values.filter { kind == null || it.listKind == kind }.sortedBy { it.price }
    val totalCount = filtered.size
    val offset = (page * pageSize).coerceAtMost(totalCount)
    val pageListings = filtered.drop(offset).take(pageSize)
    return totalCount to pageListings
  }

  override fun getListingsBySeller(sellerCharId: Long): List<GtlListingRecord> =
      listings.values.filter { it.sellerCharId == sellerCharId }

  override fun addTradeLog(log: GtlTradeLogRecord) {
    tradeLogs.getOrPut(log.charId) { CopyOnWriteArrayList() }.add(log)
  }

  override fun getTradeLogs(charId: Long): List<GtlTradeLogRecord> =
      tradeLogs[charId]?.toList() ?: emptyList()
}
