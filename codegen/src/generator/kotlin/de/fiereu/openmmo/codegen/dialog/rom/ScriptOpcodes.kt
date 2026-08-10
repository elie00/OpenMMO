package de.fiereu.openmmo.codegen.dialog.rom

import java.io.File

/**
 * How long every overworld script command is and where it keeps its pointers, read from the
 * decomp's own macro definitions so the table cannot drift away from the assembly it describes.
 *
 * Most macros are a plain run of `.byte`, `.2byte` and `.4byte` directives whose widths add up to
 * the command size. The ones that are not (they call another macro, or pick a body with `.ifb`) are
 * listed in [FIXED_SIZES] instead, and every command named by `data/script_cmd_table.inc` must end
 * up with a size, so a decomp bump that adds one fails the build rather than desynchronising a
 * walk.
 */
class ScriptOpcodes private constructor(private val sizes: Map<Int, Int>) {

  /** The size in bytes of [opcode], or null when it has none (only [TRAINER_BATTLE]). */
  fun size(opcode: Int): Int? = sizes[opcode]

  companion object {
    /** `trainerbattle`, whose size and pointer count depend on its type byte. */
    const val TRAINER_BATTLE = 0x5C

    /** `loadword`, a text pointer only when it loads into slot 0, which is what `msgbox` emits. */
    const val LOADWORD = 0x0F

    /** Pointers a `trainerbattle` of each type carries, text ones first. */
    val TRAINER_BATTLE_POINTERS: IntArray = intArrayOf(2, 3, 3, 1, 3, 2, 4, 3, 4, 2)

    /** How many of those pointers are texts; the rest are event scripts to branch into. */
    val TRAINER_BATTLE_TEXTS: IntArray = intArrayOf(2, 2, 2, 1, 3, 2, 3, 3, 3, 2)

    /** Commands holding a text pointer, and where that pointer sits after the opcode byte. */
    val TEXT_POINTER_AT: Map<Int, Int> =
        mapOf(
            0x67 to 1, // message
            0x78 to 1, // braillemessage
            0x85 to 2, // bufferstring
            0x9B to 1, // messageautoscroll
            0xBD to 1, // vmessage
            0xBE to 1, // vbuffermessage
            0xBF to 2, // vbufferstring
            0xC8 to 1, // loadhelp
            0xD3 to 1, // getbraillestringwidth
        )

    /**
     * Commands whose pointer is another script to walk, and where it sits. `gotostd` and `callstd`
     * are deliberately absent: the std scripts live in their own table, and a `msgbox`'s text is
     * already captured by the `loadword` before the `callstd`.
     */
    val BRANCH_POINTER_AT: Map<Int, Int> =
        mapOf(
            0x04 to 1, // call
            0x05 to 1, // goto
            0x06 to 2, // goto_if
            0x07 to 2, // call_if
            0xB9 to 1, // vgoto
            0xBA to 1, // vcall
            0xBB to 2, // vgoto_if
            0xBC to 2, // vcall_if
        )

    /** Commands after which execution does not fall through to the next one. */
    val STOPS: Set<Int> =
        setOf(
            0x02, // end
            0x03, // return
            0x05, // goto
            0x08, // gotostd
            0x0C, // returnram
            0x0D, // endram
            0xB9, // vgoto
        )

    /**
     * Sizes the macro bodies do not spell out. The warp family and `setescapewarp` end in a `map`
     * macro call, `bufferstring` and friends mix in a `.string`, and the `applymovement` family
     * picks its body with `.ifb`, which leaves no `.byte` opcode on the first line at all.
     */
    private val FIXED_SIZES: Map<Int, Int> =
        mapOf(
            0x39 to 8, // warp
            0x3A to 8, // warpsilent
            0x3B to 8, // warpdoor
            0x3C to 3, // warphole
            0x3D to 8, // warpteleport
            0x3E to 8, // setwarp
            0x3F to 8, // setdynamicwarp
            0x40 to 8, // setdivewarp
            0x41 to 8, // setholewarp
            0x4F to 7, // applymovement
            0x50 to 9, // applymovementat
            0x51 to 3, // waitmovement
            0x52 to 5, // waitmovementat
            0x53 to 3, // removeobject
            0x54 to 5, // removeobjectat
            0x55 to 3, // addobject
            0x56 to 5, // addobjectat
            0x58 to 5, // showobjectat
            0x59 to 5, // hideobjectat
            0x7D to 4,
            0x7E to 2,
            0x7F to 4,
            0x80 to 4,
            0x81 to 4,
            0x82 to 4,
            0x83 to 4,
            0x84 to 4,
            0x85 to 6, // bufferstring
            0xA8 to 6,
            0xA9 to 5,
            0xBF to 6, // vbufferstring
            0xC4 to 8, // setescapewarp
            0xC6 to 4,
            0xD1 to 8, // warpspinenter
            0xD4 to 6,
        )

    private val macro =
        Regex("\\.macro\\s+(\\w+)([^\\n]*)\\n(.*?)\\n\\s*\\.endm", RegexOption.DOT_MATCHES_ALL)
    private val opcodeLine = Regex("\\.byte\\s+(0x[0-9a-fA-F]+)")
    private val tableEntry = Regex("\\.4byte\\s+(\\w+)\\s*@\\s*(0x[0-9a-fA-F]+)")
    private val widths =
        mapOf(".byte" to 1, ".2byte" to 2, ".4byte" to 4, ".short" to 2, ".word" to 4)

    fun load(decompDir: File): ScriptOpcodes {
      val sizes = HashMap<Int, Int>()
      scrape(File(decompDir, "asm/macros/event.inc").readText(), sizes)
      for ((opcode, size) in FIXED_SIZES) {
        val scraped = sizes[opcode]
        check(scraped == null || scraped == size) {
          "opcode 0x%02X is %d bytes in event.inc but %d in the hard coded table"
              .format(opcode, scraped, size)
        }
        sizes[opcode] = size
      }
      assertComplete(File(decompDir, "data/script_cmd_table.inc").readText(), sizes)
      return ScriptOpcodes(sizes)
    }

    private fun scrape(source: String, sizes: MutableMap<Int, Int>) {
      for (match in macro.findAll(source)) {
        val body =
            match.groupValues[3]
                .lineSequence()
                .map { it.substringBefore('@').trim() }
                .filter { it.isNotEmpty() }
        val lines = body.toList()
        val opcode = lines.firstOrNull()?.let { opcodeLine.matchEntire(it) } ?: continue
        var size = 1
        var known = true
        for (line in lines.drop(1)) {
          val width = widths[line.substringBefore(' ').trim()]
          if (width == null) {
            known = false
            break
          }
          size += width
        }
        if (known) sizes.putIfAbsent(opcode.groupValues[1].removePrefix("0x").toInt(16), size)
      }
    }

    private fun assertComplete(cmdTable: String, sizes: Map<Int, Int>) {
      val missing =
          tableEntry
              .findAll(cmdTable)
              .map { it.groupValues[1] to it.groupValues[2].removePrefix("0x").toInt(16) }
              .filter { (_, opcode) -> opcode != TRAINER_BATTLE && opcode !in sizes }
              .map { (name, opcode) -> "0x%02X %s".format(opcode, name) }
              .toList()
      check(missing.isEmpty()) {
        "script commands with no known size, the walker would desynchronise on them: $missing"
      }
    }
  }

  /** The size of a command, taking the variable [TRAINER_BATTLE] into account. */
  fun sizeAt(rom: GbaRom, offset: Int): Int? {
    val opcode = rom.u8(offset)
    if (opcode == TRAINER_BATTLE) {
      val type = rom.u8(offset + 1)
      if (type !in TRAINER_BATTLE_POINTERS.indices) return null
      return 6 + 4 * TRAINER_BATTLE_POINTERS[type]
    }
    return size(opcode)
  }
}
