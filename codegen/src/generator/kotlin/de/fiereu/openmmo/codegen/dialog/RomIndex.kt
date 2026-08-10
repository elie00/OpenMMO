package de.fiereu.openmmo.codegen.dialog

import java.io.File

/** The ROM that was found and the game code it turned out to carry. */
data class RomMatch(val gameCode: String, val index: RomIndex)

/**
 * A retail GBA ROM located by its header game code, used to resolve a text's file offset. An
 * English ROM is byte-identical to the pret decomp, so the offset of an encoded string is the value
 * PokeMMO packs into a dialog textId; a localised ROM shares the offsets' meaning but not the
 * strings, and is read through the map navigation instead.
 */
class RomIndex private constructor(val bytes: ByteArray) {

  private val latin1 by lazy { String(bytes, Charsets.ISO_8859_1) }

  /** The first offset of [bytes] in the ROM, or -1 if absent. */
  fun offsetOf(bytes: ByteArray): Int = latin1.indexOf(String(bytes, Charsets.ISO_8859_1))

  companion object {
    private const val GAME_CODE_OFFSET = 0xAC

    /**
     * Finds the ROM in [romsDir] whose header game code is one of [gameCodes]. The codes are tried
     * in order, so a machine holding several localisations gets the first one listed.
     */
    fun find(romsDir: File, gameCodes: List<String>): RomMatch? {
      val files = romsDir.listFiles { f -> f.isFile }?.sortedBy { it.name } ?: return null
      for (gameCode in gameCodes) {
        val rom =
            files.firstOrNull { f ->
              f.length() > GAME_CODE_OFFSET + 4 && readGameCode(f) == gameCode
            } ?: continue
        return RomMatch(gameCode, RomIndex(rom.readBytes()))
      }
      return null
    }

    private fun readGameCode(file: File): String =
        file.inputStream().use { s ->
          s.skip(GAME_CODE_OFFSET.toLong())
          val b = ByteArray(4)
          if (s.read(b) != 4) "" else String(b, Charsets.US_ASCII)
        }
  }
}
