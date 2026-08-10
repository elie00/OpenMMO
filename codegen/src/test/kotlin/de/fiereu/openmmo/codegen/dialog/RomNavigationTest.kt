package de.fiereu.openmmo.codegen.dialog

import de.fiereu.openmmo.codegen.dialog.rom.GbaRom
import de.fiereu.openmmo.codegen.dialog.rom.MapBankTable
import de.fiereu.openmmo.codegen.dialog.rom.RomMapReader
import de.fiereu.openmmo.codegen.dialog.rom.RomScriptWalker
import de.fiereu.openmmo.codegen.dialog.rom.ScriptOpcodes
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.File

/** A ROM sized image the readers can be pointed at, so they can be tested without owning a ROM. */
private class FakeRom(size: Int = 0x4000) {
  val bytes = ByteArray(size)

  fun pointerTo(offset: Int): Int = 0x08000000 or offset

  fun write(offset: Int, vararg values: Int): Int {
    values.forEachIndexed { i, v -> bytes[offset + i] = v.toByte() }
    return offset
  }

  fun writeWord(offset: Int, value: Int): Int =
      write(
          offset,
          value and 0xFF,
          (value ushr 8) and 0xFF,
          (value ushr 16) and 0xFF,
          (value ushr 24) and 0xFF)

  fun writeHalf(offset: Int, value: Int): Int =
      write(offset, value and 0xFF, (value ushr 8) and 0xFF)

  fun rom() = GbaRom(bytes)
}

class RomNavigationTest :
    FunSpec({
      val opcodes = ScriptOpcodes.load(File("../decomp/pokefirered"))

      context("map bank table") {
        test("finds the table by the gaps its group sizes leave") {
          val fake = FakeRom()
          val sizes = listOf(2, 3, 1)
          var pointer = fake.pointerTo(0x800)
          fake.writeWord(0x100, pointer)
          pointer += 4 * sizes[0]
          fake.writeWord(0x104, pointer)
          pointer += 4 * sizes[1]
          fake.writeWord(0x108, pointer)

          MapBankTable.locate(fake.rom(), sizes) shouldBe 0x100
        }

        test("refuses to guess when no table matches the decomp's map counts") {
          val fake = FakeRom()
          fake.writeWord(0x100, fake.pointerTo(0x800))
          fake.writeWord(0x104, fake.pointerTo(0x808))
          fake.writeWord(0x108, fake.pointerTo(0x814))

          shouldThrow<IllegalStateException> { MapBankTable.locate(fake.rom(), listOf(9, 9, 9)) }
        }

        test("refuses to guess when two tables match") {
          val fake = FakeRom()
          for (base in listOf(0x100, 0x200)) {
            fake.writeWord(base, fake.pointerTo(0x800))
            fake.writeWord(base + 4, fake.pointerTo(0x808))
            fake.writeWord(base + 8, fake.pointerTo(0x814))
          }

          shouldThrow<IllegalStateException> { MapBankTable.locate(fake.rom(), listOf(2, 3, 1)) }
        }
      }

      context("map reader") {
        test("reads a map's object, coord and bg event scripts by index") {
          val fake = FakeRom()
          // One group of one map, whose header sits at 0x400.
          fake.writeWord(0x100, fake.pointerTo(0x200))
          fake.writeWord(0x200, fake.pointerTo(0x400))
          fake.writeWord(0x404, fake.pointerTo(0x500)) // header -> events

          fake.write(0x500, 2) // two object events
          fake.write(0x502, 1) // one coord event
          fake.write(0x503, 1) // one bg event
          fake.writeWord(0x504, fake.pointerTo(0x600))
          fake.writeWord(0x50C, fake.pointerTo(0x700))
          fake.writeWord(0x510, fake.pointerTo(0x780))
          fake.writeWord(0x600 + 0x10, fake.pointerTo(0xA00))
          fake.writeWord(0x600 + 0x18 + 0x10, fake.pointerTo(0xA10))
          fake.writeWord(0x700 + 0x0C, fake.pointerTo(0xA20))
          fake.writeWord(0x780 + 0x08, fake.pointerTo(0xA30))

          val reader = RomMapReader(fake.rom(), 0x100)
          val header = reader.headerOffset(0, 0)
          header shouldBe 0x400
          val events = reader.events(header!!)!!
          events.objects shouldBe listOf(fake.pointerTo(0xA00), fake.pointerTo(0xA10))
          events.coords shouldBe listOf(fake.pointerTo(0xA20))
          events.backgrounds shouldBe listOf(fake.pointerTo(0xA30))
        }

        test("reads the map script table and its var driven sub tables") {
          val fake = FakeRom()
          fake.writeWord(0x408, fake.pointerTo(0x900)) // header -> map scripts
          fake.write(0x900, 2)
          fake.writeWord(0x901, fake.pointerTo(0x950))
          fake.write(0x905, 1)
          fake.writeWord(0x906, fake.pointerTo(0xB00))
          fake.write(0x90A, 0)
          fake.writeHalf(0x950, 0x4001)
          fake.writeHalf(0x952, 1)
          fake.writeWord(0x954, fake.pointerTo(0xB10))
          fake.writeHalf(0x958, 0)

          val reader = RomMapReader(fake.rom(), 0x100)
          val scripts = reader.mapScripts(0x400)
          scripts.map { it.type } shouldBe listOf(2, 1)
          (scripts[0].type in RomMapReader.TABLE_TYPES) shouldBe true
          reader.mapScriptSubTable(scripts[0].pointer) shouldBe listOf(fake.pointerTo(0xB10))
          scripts[1].pointer shouldBe fake.pointerTo(0xB00)
        }
      }

      context("script walker") {
        test("reads the text a msgbox loads and stops at end") {
          val fake = FakeRom()
          fake.write(0x800, 0x0F, 0x00)
          fake.writeWord(0x802, fake.pointerTo(0xC00))
          fake.write(0x806, 0x09, 0x04) // callstd MSGBOX_DEFAULT
          fake.write(0x808, 0x02) // end

          RomScriptWalker(fake.rom(), opcodes).textPointers(fake.pointerTo(0x800)) shouldBe
              listOf(fake.pointerTo(0xC00))
        }

        test("ignores a loadword that is not loading a text") {
          val fake = FakeRom()
          fake.write(0x800, 0x0F, 0x01)
          fake.writeWord(0x802, fake.pointerTo(0xC00))
          fake.write(0x806, 0x02)

          RomScriptWalker(fake.rom(), opcodes).textPointers(fake.pointerTo(0x800)) shouldBe
              emptyList<Int>()
        }

        test("takes a trainerbattle's texts and follows its event script") {
          val fake = FakeRom()
          // type 2 is CONTINUE_SCRIPT: two texts then an event script.
          fake.write(0x800, 0x5C, 0x02)
          fake.writeHalf(0x802, 7) // trainer
          fake.writeHalf(0x804, 0) // local id
          fake.writeWord(0x806, fake.pointerTo(0xC00))
          fake.writeWord(0x80A, fake.pointerTo(0xC10))
          fake.writeWord(0x80E, fake.pointerTo(0x880))
          fake.write(0x812, 0x02)
          fake.write(0x880, 0x67) // message
          fake.writeWord(0x881, fake.pointerTo(0xC20))
          fake.write(0x885, 0x02)

          RomScriptWalker(fake.rom(), opcodes).textPointers(fake.pointerTo(0x800)) shouldBe
              listOf(fake.pointerTo(0xC00), fake.pointerTo(0xC10), fake.pointerTo(0xC20))
        }

        test("does not loop on a script that jumps back into itself") {
          val fake = FakeRom()
          fake.write(0x800, 0x67)
          fake.writeWord(0x801, fake.pointerTo(0xC00))
          fake.write(0x805, 0x05) // goto
          fake.writeWord(0x806, fake.pointerTo(0x800))

          RomScriptWalker(fake.rom(), opcodes).textPointers(fake.pointerTo(0x800)) shouldBe
              listOf(fake.pointerTo(0xC00))
        }

        test("gives up rather than decode a byte that is not a command") {
          val fake = FakeRom()
          fake.write(0x800, 0xFF)

          RomScriptWalker(fake.rom(), opcodes).textPointers(fake.pointerTo(0x800)) shouldBe null
        }
      }
    })
