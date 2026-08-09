package de.fiereu.openmmo.codegen.port

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class JumpFormTest :
    FunSpec({
      test("reads the three shapes that end in another script") {
        JumpForm.parse(
            listOf("setvar VAR_MAP_SCENE_X, 1", "goto Route1_EventScript_After")) shouldBe
            JumpForm.SetVarThenJump("VAR_MAP_SCENE_X", "1", "Route1_EventScript_After")

        JumpForm.parse(
            listOf(
                "goto_if_set FLAG_DEFEATED_X, Route1_EventScript_Post",
                "msgbox Route1_Text_Y")) shouldBe
            JumpForm.BranchOnFlag(
                "FLAG_DEFEATED_X", "Route1_EventScript_Post", "Route1_Text_Y", negated = false)

        JumpForm.parse(
                listOf("goto_if_unset FLAG_X, Route1_EventScript_Post", "msgbox Route1_Text_Y"))
            ?.let { (it as JumpForm.BranchOnFlag).negated } shouldBe true

        JumpForm.parse(
            listOf(
                "msgbox Route1_Text_Y, MSGBOX_DEFAULT", "goto Route1_EventScript_After")) shouldBe
            JumpForm.MessageThenJump("Route1_Text_Y", "Route1_EventScript_After")
      }

      test("refuses anything with a different command or arity") {
        JumpForm.parse(listOf("goto Route1_EventScript_After")) shouldBe null
        JumpForm.parse(listOf("setvar VAR_X, 1", "call Route1_EventScript_After")) shouldBe null
        // goto_if_eq without the message branch is not one of the shapes.
        JumpForm.parse(listOf("goto_if_eq VAR_X, 1, Route1_EventScript_A", "end")) shouldBe null
        JumpForm.parse(listOf("setvar VAR_X, 1", "goto Route1_EventScript_A", "end")) shouldBe null
      }
    })

class JumpFormVarAndCallTest :
    FunSpec({
      test("reads a var comparison and both call orders") {
        JumpForm.parse(
            listOf(
                "goto_if_eq VAR_MAP_SCENE_X, 3, Route1_EventScript_A",
                "msgbox Route1_Text_B")) shouldBe
            JumpForm.BranchOnVar(
                "VAR_MAP_SCENE_X", "3", "Route1_EventScript_A", "Route1_Text_B", negated = false)

        JumpForm.parse(listOf("goto_if_ne VAR_X, 1, Route1_EventScript_A", "msgbox Route1_Text_B"))
            ?.let { (it as JumpForm.BranchOnVar).negated } shouldBe true

        JumpForm.parse(listOf("call Route1_EventScript_Cry", "msgbox Route1_Text_B")) shouldBe
            JumpForm.CallAndMessage("Route1_EventScript_Cry", "Route1_Text_B", callFirst = true)

        JumpForm.parse(listOf("msgbox Route1_Text_B", "call Route1_EventScript_Cry")) shouldBe
            JumpForm.CallAndMessage("Route1_EventScript_Cry", "Route1_Text_B", callFirst = false)
      }

      test("refuses a var comparison against a symbol it cannot read as a number") {
        JumpForm.parse(
            listOf("goto_if_eq VAR_X, SOME_CONSTANT, Route1_EventScript_A", "msgbox T")) shouldBe
            null
      }
    })
