package de.fiereu.openmmo.codegen.port

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.File

class MovementTemplatesTest :
    FunSpec({
      val templates = MovementTemplates(File("../decomp/pokefirered"))

      test("walking in place turns the npc without moving it") {
        // The name says walk, but the npc stays on its tile: WALK_UP would move it a tile.
        templates.stepsOf("Common_Movement_WalkInPlaceFasterUp") shouldBe listOf("FACE_UP")
      }

      test("refuses a template holding a step with no equivalent") {
        // face_original_direction needs the object event's starting facing, which is not modelled.
        templates.stepsOf("Common_Movement_FaceOriginalDirection") shouldBe null
        templates.stepsOf("Common_Movement_NoSuchTemplate") shouldBe null
      }
    })
