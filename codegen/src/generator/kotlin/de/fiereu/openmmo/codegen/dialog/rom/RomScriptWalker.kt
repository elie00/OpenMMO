package de.fiereu.openmmo.codegen.dialog.rom

/**
 * Decodes overworld script bytecode and reports the text pointers it would show, in the order it
 * would show them.
 *
 * The traversal is deliberately simple and must stay identical to the decomp side walker: run
 * linearly until a command that does not fall through, queue every branch target in encounter
 * order, and visit each target once. What matters is not that this is how the game runs a script,
 * but that both walkers produce the same number of text slots in the same order.
 */
class RomScriptWalker(private val rom: GbaRom, private val opcodes: ScriptOpcodes) {

  /** The text pointers reachable from [entryPointer], or null when the bytecode does not decode. */
  fun textPointers(entryPointer: Int): List<Int>? {
    if (!rom.isPointer(entryPointer)) return null
    val worklist = ArrayDeque<Int>()
    val seen = HashSet<Int>()
    val texts = ArrayList<Int>()
    worklist.add(rom.offsetOf(entryPointer))
    var steps = 0

    while (worklist.isNotEmpty()) {
      var offset = worklist.removeFirst()
      if (!seen.add(offset)) continue
      while (true) {
        if (++steps > STEP_LIMIT) return null
        if (!rom.has(offset, 1)) return null
        val opcode = rom.u8(offset)
        val size = opcodes.sizeAt(rom, offset) ?: return null
        if (!rom.has(offset, size)) return null

        when {
          opcode == ScriptOpcodes.LOADWORD ->
              // Only slot 0 is a text; msgbox is the only thing that loads one.
              if (rom.u8(offset + 1) == 0) texts.add(rom.u32(offset + 2))
          opcode == ScriptOpcodes.TRAINER_BATTLE -> {
            val type = rom.u8(offset + 1)
            val textCount = ScriptOpcodes.TRAINER_BATTLE_TEXTS[type]
            for (i in 0 until textCount) texts.add(rom.u32(offset + 6 + 4 * i))
            for (i in textCount until ScriptOpcodes.TRAINER_BATTLE_POINTERS[type]) {
              val target = rom.u32(offset + 6 + 4 * i)
              if (rom.isPointer(target)) worklist.add(rom.offsetOf(target))
            }
          }
          else -> ScriptOpcodes.TEXT_POINTER_AT[opcode]?.let { texts.add(rom.u32(offset + it)) }
        }

        ScriptOpcodes.BRANCH_POINTER_AT[opcode]?.let {
          val target = rom.u32(offset + it)
          if (rom.isPointer(target)) worklist.add(rom.offsetOf(target))
        }

        if (opcode in ScriptOpcodes.STOPS) break
        offset += size
      }
    }
    return texts
  }

  private companion object {
    /** A script this long is not a script, it is a runaway decode. */
    const val STEP_LIMIT = 20_000
  }
}
