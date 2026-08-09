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

        // A rematch check means the script has a second path this porter does not model.
        TrainerBattleForm.parse(
            canonical.take(1) +
                listOf(
                    "specialvar VAR_RESULT, ShouldTryRematchBattle",
                    "msgbox Route3_Text_KayPostBattle, MSGBOX_AUTOCLOSE",
                    "end")) shouldBe null

        // Any message type other than autoclose has different exit semantics.
        TrainerBattleForm.parse(
            canonical.take(1) +
                listOf("msgbox Route3_Text_KayPostBattle, MSGBOX_DEFAULT", "end")) shouldBe null

        TrainerBattleForm.parse(canonical.take(1) + listOf("end")) shouldBe null
        TrainerBattleForm.parse(canonical.dropLast(1)) shouldBe null
        TrainerBattleForm.parse(canonical + "release") shouldBe null
        TrainerBattleForm.parse(emptyList()) shouldBe null
      }
    })
