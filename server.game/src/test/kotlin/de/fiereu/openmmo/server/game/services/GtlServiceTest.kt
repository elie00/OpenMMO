package de.fiereu.openmmo.server.game.services

import de.fiereu.network.PacketEvent
import de.fiereu.openmmo.common.enums.CharacterGender
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.net.game.packets.gtl.GtlCreateListingPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlListKind
import de.fiereu.openmmo.net.game.packets.gtl.GtlListingCancelPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlListingsPagePacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlListingsPageRequestPacket
import de.fiereu.openmmo.net.game.packets.gtl.GtlPurchaseListingPacket
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.session.PlayerState
import de.fiereu.openmmo.server.game.session.SessionRegistry
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.EntityIdService
import de.fiereu.openmmo.server.game.storage.InMemoryGtlStore
import de.fiereu.openmmo.server.game.testsupport.FakeCharacterRepository
import de.fiereu.openmmo.server.game.testsupport.FakeSession
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class GtlServiceTest :
    FunSpec({
      test("Player can list an item on GTL and another player can purchase it") {
        val repo = FakeCharacterRepository()
        val ids = EntityIdService()
        val store = CharacterStore(repo, ids, CoroutineScope(Dispatchers.Unconfined))
        val sessions = SessionRegistry()
        val gtlStore = InMemoryGtlStore()
        val gtlService = GtlService(gtlStore, store, sessions)

        // Seller
        val seller = store.createCharacter(1, "Seller", CharacterGender.MALE, Region.KANTO)
        store.addItem(seller.info.id, Items.POTION, 5)
        val sSession = FakeSession(201L)
        sSession.attributes[PLAYER_STATE] = PlayerState(1, seller.info.id)
        sessions.bindCharacter(sSession, seller.info.id)

        // Buyer with 10,000 money
        val buyer = store.createCharacter(2, "Buyer", CharacterGender.MALE, Region.KANTO)
        store.addMoney(buyer.info.id, 10000)
        val initialBuyerMoney = store.getCharacter(buyer.info.id)!!.info.money
        val initialSellerMoney = store.getCharacter(seller.info.id)!!.info.money
        val bSession = FakeSession(202L)
        bSession.attributes[PLAYER_STATE] = PlayerState(2, buyer.info.id)
        sessions.bindCharacter(bSession, buyer.info.id)

        // Seller creates listing for 2 Potions at 500 money
        val createPacket =
            GtlCreateListingPacket(
                categoryIndex = 0,
                listingCount = 2,
                itemKind = Items.POTION.toByte(),
                priceShort = 500,
                filterCriteria = byteArrayOf(),
            )
        gtlService.onCreateListing(PacketEvent(createPacket, sSession))

        // Check seller bag decremented (5 - 2 = 3)
        store.getCharacter(seller.info.id)!!.items[Items.POTION] shouldBe 3

        // Buyer queries GTL listings
        val reqPacket =
            GtlListingsPageRequestPacket(
                requestId = 1,
                listKind = GtlListKind.ITEM,
                categoryId = 0,
                page = 0,
            )
        gtlService.onListingsPageRequest(PacketEvent(reqPacket, bSession))
        val pageReply = bSession.sent.filterIsInstance<GtlListingsPagePacket>().first()
        pageReply.listings.shouldNotBeEmpty()
        val listingId = pageReply.listings.first().entries.first().a

        // Buyer purchases the listing
        val buyPacket =
            GtlPurchaseListingPacket(
                listingId = listingId,
                price = 500,
                action = 1,
            )
        gtlService.onPurchaseListing(PacketEvent(buyPacket, bSession))

        // Check buyer received 2 Potions and spent 500
        store.getCharacter(buyer.info.id)!!.items[Items.POTION] shouldBe 2
        store.getCharacter(buyer.info.id)!!.info.money shouldBe initialBuyerMoney - 500

        // Check seller received 500 money
        store.getCharacter(seller.info.id)!!.info.money shouldBe initialSellerMoney + 500

        // Check listing is removed from marketplace
        gtlStore.getListing(listingId.toLong()) shouldBe null
      }

      test("Seller can cancel listing and retrieve items") {
        val repo = FakeCharacterRepository()
        val ids = EntityIdService()
        val store = CharacterStore(repo, ids, CoroutineScope(Dispatchers.Unconfined))
        val sessions = SessionRegistry()
        val gtlStore = InMemoryGtlStore()
        val gtlService = GtlService(gtlStore, store, sessions)

        val seller = store.createCharacter(1, "Seller", CharacterGender.MALE, Region.KANTO)
        store.addItem(seller.info.id, Items.SUPER_POTION, 3)
        val sSession = FakeSession(201L)
        sSession.attributes[PLAYER_STATE] = PlayerState(1, seller.info.id)
        sessions.bindCharacter(sSession, seller.info.id)

        val createPacket =
            GtlCreateListingPacket(
                categoryIndex = 0,
                listingCount = 2,
                itemKind = Items.SUPER_POTION.toByte(),
                priceShort = 800,
                filterCriteria = byteArrayOf(),
            )
        gtlService.onCreateListing(PacketEvent(createPacket, sSession))
        store.getCharacter(seller.info.id)!!.items[Items.SUPER_POTION] shouldBe 1

        val listing = gtlStore.getListingsBySeller(seller.info.id).first()

        // Cancel listing
        gtlService.onListingCancel(PacketEvent(GtlListingCancelPacket(listingId = listing.listingId.toString()), sSession))

        // Items returned to bag (1 + 2 = 3)
        store.getCharacter(seller.info.id)!!.items[Items.SUPER_POTION] shouldBe 3
        gtlStore.getListing(listing.listingId) shouldBe null
      }
    })
