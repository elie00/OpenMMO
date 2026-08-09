package de.fiereu.openmmo.codegen.port

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class TrainerBattleFormTest :
    FunSpec({
      val canonical =
          listOf(
              "trainerbattle_single TRAINER_LASS_KAY, Route3_Text_KayIntro, Route3_Text_KayDefeat",
              "msgbox Route3_Text_KayPostBattle, MSGBOX_AUTOCLOSE",
              "end",
          )

      test("reads the trainer and its three texts in order") {
        val form = TrainerBattleForm.parse(canonical).shouldNotBeNull()

        form.trainer shouldBe "TRAINER_LASS_KAY"
        form.textLabels shouldBe
            listOf("Route3_Text_KayIntro", "Route3_Text_KayDefeat", "Route3_Text_KayPostBattle")
      }

      test("accepts the rematch shape and records the branch it drops") {
        val form =
            TrainerBattleForm.parse(
                    canonical.take(1) +
                        listOf(
                            "specialvar VAR_RESULT, ShouldTryRematchBattle",
                            "goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_KayRematch",
                            "msgbox Route3_Text_KayPostBattle, MSGBOX_AUTOCLOSE",
                            "end"))
                .shouldNotBeNull()

        form.trainer shouldBe "TRAINER_LASS_KAY"
        form.skippedRematch shouldBe "Route3_EventScript_KayRematch"
      }

      test("ignores framing and takes the non autoclose message type too") {
        val form =
            TrainerBattleForm.parse(
                    listOf("lock", "faceplayer") +
                        canonical.take(1) +
                        listOf(
                            "msgbox Route3_Text_KayPostBattle, MSGBOX_DEFAULT", "release", "end"))
                .shouldNotBeNull()

        form.textLabels.last() shouldBe "Route3_Text_KayPostBattle"
        form.skippedRematch shouldBe null
      }

      test("refuses a rematch check it does not recognise") {
        TrainerBattleForm.parse(
            canonical.take(1) +
                listOf(
                    "specialvar VAR_RESULT, SomeOtherSpecial",
                    "goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_Other",
                    "msgbox Route3_Text_KayPostBattle, MSGBOX_AUTOCLOSE",
                    "end")) shouldBe null
      }

      test("refuses everything outside the exact three line shape") {
        // A fourth argument is a continuation script whose body would be dropped on the floor.
        TrainerBattleForm.parse(
            listOf(
                "trainerbattle_single TRAINER_A, A_Text_I, A_Text_D, A_EventScript_After",
                "msgbox A_Text_P, MSGBOX_AUTOCLOSE",
                "end")) shouldBe null

        TrainerBattleForm.parse(
            listOf(
                "trainerbattle_double TRAINER_A, A_Text_I, A_Text_D, A_Text_NotEnough",
                "msgbox A_Text_P, MSGBOX_AUTOCLOSE",
                "end")) shouldBe null

        TrainerBattleForm.parse(
            listOf("trainerbattle_no_intro TRAINER_A, A_Text_D", "msgbox A_Text_P", "end")) shouldBe
            null

        // The rematch check is only accepted as the exact three command sequence.
        TrainerBattleForm.parse(
            canonical.take(1) +
                listOf(
                    "specialvar VAR_RESULT, ShouldTryRematchBattle",
                    "msgbox Route3_Text_KayPostBattle, MSGBOX_AUTOCLOSE",
                    "end")) shouldBe null

        // A battle with no message at all, and a message type that is neither of the two known.
        TrainerBattleForm.parse(canonical.take(1) + listOf("end")) shouldBe null
        TrainerBattleForm.parse(
            canonical.take(1) +
                listOf("msgbox Route3_Text_KayPostBattle, MSGBOX_YESNO", "end")) shouldBe null

        // Any command that is neither framing nor part of the shape.
        TrainerBattleForm.parse(canonical + "setflag FLAG_X") shouldBe null
        TrainerBattleForm.parse(emptyList()) shouldBe null
      }

      test("reads a message followed by the npc turning back, and nothing else") {
        FacingDialogueForm.parse(
                listOf(
                    "msgbox ViridianCity_School_Text_ReadBlackboardCarefully",
                    "applymovement LOCALID_SCHOOL_WOMAN, Common_Movement_FaceOriginalDirection",
                    "waitmovement 0"))
            ?.textLabel shouldBe "ViridianCity_School_Text_ReadBlackboardCarefully"

        // Any other movement template is a real cutscene step, not a cosmetic turn back.
        FacingDialogueForm.parse(
            listOf(
                "msgbox A_Text_X",
                "applymovement LOCALID_A, Common_Movement_WalkInPlaceFasterUp",
                "waitmovement 0")) shouldBe null

        FacingDialogueForm.parse(
            listOf(
                "msgbox A_Text_X",
                "applymovement LOCALID_A, Common_Movement_FaceOriginalDirection")) shouldBe null
      }

      test("reads a bare finditem and refuses every richer form") {
        FindItemForm.parse(listOf("finditem ITEM_PP_UP", "end"))?.item shouldBe "ITEM_PP_UP"

        // The quantity form and the hidden item form both branch on bag space.
        FindItemForm.parse(listOf("finditem ITEM_NUGGET, 5", "end")) shouldBe null
        FindItemForm.parse(listOf("finditem ITEM_PP_UP", "setflag FLAG_X", "end")) shouldBe null
        FindItemForm.parse(listOf("finditem ITEM_PP_UP")) shouldBe null
        FindItemForm.parse(listOf("finditem gSpecialVar_0x8000", "end")) shouldBe null
      }
    })
