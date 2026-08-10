package de.fiereu.openmmo.codegen.dialog

import java.io.File

/** Picks the way texts are located in a ROM from the language its game code says it speaks. */
object TextOffsetSources {

  fun create(gameCode: String, decompDir: File, rom: RomIndex): TextOffsetSource =
      when (gameCode) {
        // The decomp holds the English text, so its encoded bytes are in an English ROM verbatim.
        "BPRE",
        "BPEE" -> EncodedTextSource(Charmap.load(File(decompDir, "charmap.txt")), rom)
        // A localised ROM shares every structure with the decomp but no text, so the only way in
        // is the one the game itself takes: map -> event -> script -> msgbox -> text.
        "BPRF" -> ScriptNavTextSource(decompDir, rom.bytes)
        else -> error("no dialog id source for game code '$gameCode'")
      }
}
