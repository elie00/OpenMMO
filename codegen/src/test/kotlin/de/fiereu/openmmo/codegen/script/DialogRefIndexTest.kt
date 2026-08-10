package de.fiereu.openmmo.codegen.script

import de.fiereu.openmmo.codegen.dialog.DecompText
import de.fiereu.openmmo.codegen.dialog.TextOffsetSource
import io.kotest.core.spec.style.FunSpec
import io.kotest.engine.spec.tempdir
import io.kotest.matchers.shouldBe
import java.io.File

class DialogRefIndexTest :
    FunSpec({
      test("gives a shared entry name to the label that actually resolved") {
        // Both labels become the same enum entry, since an identifier cannot start with a digit,
        // and the enum only keeps one of them. Whichever the dialog generator kept has to be the
        // one this index points at, or a script would reference an entry that is not there.
        val decompDir = tempdir()
        val texts = File(decompDir, "data/text")
        texts.mkdirs()
        File(texts, "shared.inc")
            .writeText(
                """
                |Loc_Text__1Sign::
                |	.string "unreachable${'$'}"
                |
                |Loc_Text_1Sign::
                |	.string "reachable${'$'}"
                |"""
                    .trimMargin())

        val source =
            object : TextOffsetSource {
              override val keepsUnresolved = true

              override fun offsetOf(text: DecompText) =
                  if (text.label == "Loc_Text_1Sign") 0x1234 else -1
            }

        val refs = DialogRefIndex.build(decompDir, source)
        refs["Loc_Text_1Sign"] shouldBe DialogRef("Loc", "_1Sign")
        refs["Loc_Text__1Sign"] shouldBe null
      }
    })
