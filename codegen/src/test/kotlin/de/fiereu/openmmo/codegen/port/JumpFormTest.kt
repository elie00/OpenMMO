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
        // goto_if_eq compares a var to a value, which is a different shape.
        JumpForm.parse(listOf("goto_if_eq VAR_X, 1, Route1_EventScript_A", "msgbox T")) shouldBe
            null
        JumpForm.parse(listOf("setvar VAR_X, 1", "goto Route1_EventScript_A", "end")) shouldBe null
      }
    })
