package de.fiereu.openmmo.codegen.port

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.io.File

class MapObjectIndexTest :
    FunSpec({
      val index = MapObjectIndex(File("../decomp/pokefirered"))

      test("resolves a local id symbol to the object event's index") {
        // ViridianCity_School lists the woman second in its object_events.
        index.localId("LOCALID_SCHOOL_WOMAN").shouldNotBeNull()
      }

      test("refuses a symbol it does not know") {
        index.localId("LOCALID_NOT_A_REAL_NPC") shouldBe null
      }
    })
