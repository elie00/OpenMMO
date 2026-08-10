package de.fiereu.openmmo.codegen.dialog

import de.fiereu.openmmo.codegen.dialog.decomp.DecompScriptStream
import de.fiereu.openmmo.codegen.dialog.decomp.DecompScriptWalker
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.File

class DecompScriptWalkerTest :
    FunSpec({
      val walker = DecompScriptWalker(DecompScriptStream(File("../decomp/pokefirered")))

      test("reads the one text of a single msgbox script") {
        walker.textLabels("PalletTown_EventScript_FatMan") shouldBe
            listOf("PalletTown_Text_CanStoreItemsAndMonsInPC")
      }

      test("follows every branch of a script, breadth first in encounter order") {
        // The four goto_if targets are queued before the two call_if ones, and the call inside
        // SignLadyStartShowSign only comes up once that branch is reached.
        walker.textLabels("PalletTown_EventScript_SignLady") shouldBe
            listOf(
                "PalletTown_Text_HmmIsThatRight",
                "PalletTown_Text_OhLookLook",
                "PalletTown_Text_RaisingMonsToo",
                "PalletTown_Text_SignsAreUsefulArentThey",
                "PalletTown_Text_ReadItReadIt",
                "PalletTown_Text_LookCopiedTrainerTipsSign",
                "PalletTown_Text_PressStartToOpenMenuCopy",
            )
      }

      test("sees the text hidden in a giveitem_msg") {
        walker.textLabels("ViridianCity_Mart_EventScript_ParcelScene") shouldBe
            listOf(
                "ViridianCity_Mart_Text_YouCameFromPallet",
                "ViridianCity_Mart_Text_TakeThisToProfOak",
                "ViridianCity_Mart_Text_ReceivedOaksParcelFromClerk",
            )
      }

      test("gives a trainerbattle_single its two texts") {
        walker.textLabels("PewterCity_Gym_EventScript_Liam") shouldBe
            listOf(
                "PewterCity_Gym_Text_LiamIntro",
                "PewterCity_Gym_Text_LiamDefeat",
                "PewterCity_Gym_Text_LiamPostBattle",
            )
      }

      test("follows the event script a trainerbattle_single names last") {
        val labels = walker.textLabels("PewterCity_Gym_EventScript_Brock")!!
        labels.take(2) shouldBe
            listOf("PewterCity_Gym_Text_BrockIntro", "PewterCity_Gym_Text_BrockDefeat")
        // Only reachable through the battle's event script pointer, which leads to GiveTM39.
        labels.contains("PewterCity_Gym_Text_ReceivedTM39FromBrock") shouldBe true
      }

      test("counts braillemessage_wait as the two commands it assembles into") {
        // Seven waits, two slots each, then one plain braillemessage.
        walker.textLabels("MtEmber_RubyPath_B5F_EventScript_BrailleMessage")!!.size shouldBe 15
      }

      test("does not know a label the decomp never defines") {
        walker.textLabels("PalletTown_EventScript_NotAScript") shouldBe null
      }
    })
