package de.fiereu.openmmo.codegen.dialog

import de.fiereu.openmmo.codegen.dialog.rom.ScriptOpcodes
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.File

class ScriptOpcodesTest :
    FunSpec({
      // Loading asserts that every command the decomp's dispatch table names has a known size.
      // A decomp bump that adds one has to fail here rather than silently desynchronise a walk.
      val opcodes = ScriptOpcodes.load(File("../decomp/pokefirered"))

      test("reads the sizes the macro bodies spell out") {
        opcodes.size(0x02) shouldBe 1 // end
        opcodes.size(0x05) shouldBe 5 // goto
        opcodes.size(0x06) shouldBe 6 // goto_if
        opcodes.size(0x0F) shouldBe 6 // loadword
        opcodes.size(0x67) shouldBe 5 // message
      }

      test("knows the sizes no macro body spells out") {
        // applymovement picks its body with .ifb, so it has no leading .byte to scrape at all.
        opcodes.size(0x4F) shouldBe 7
        opcodes.size(0x50) shouldBe 9
        opcodes.size(0x51) shouldBe 3
        // The warp family ends in a `map` macro call.
        opcodes.size(0x39) shouldBe 8
      }

      test("leaves trainerbattle without a fixed size") {
        opcodes.size(ScriptOpcodes.TRAINER_BATTLE) shouldBe null
      }

      test("counts trainerbattle pointers with its texts first") {
        ScriptOpcodes.TRAINER_BATTLE_POINTERS.toList() shouldBe listOf(2, 3, 3, 1, 3, 2, 4, 3, 4, 2)
        ScriptOpcodes.TRAINER_BATTLE_TEXTS.toList() shouldBe listOf(2, 2, 2, 1, 3, 2, 3, 3, 3, 2)
      }
    })
