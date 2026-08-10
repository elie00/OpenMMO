package de.fiereu.openmmo.codegen.dialog.rom

/**
 * A GBA ROM image read the way the game reads it: little endian words, and cartridge pointers in
 * the 0x08000000 window that map straight onto file offsets.
 */
class GbaRom(private val data: ByteArray) {

  val size: Int
    get() = data.size

  /** Whether [length] bytes can be read at [offset]. */
  fun has(offset: Int, length: Int): Boolean = offset >= 0 && offset + length <= data.size

  fun u8(offset: Int): Int = data[offset].toInt() and 0xFF

  fun u16(offset: Int): Int = u8(offset) or (u8(offset + 1) shl 8)

  fun u32(offset: Int): Int =
      u8(offset) or (u8(offset + 1) shl 8) or (u8(offset + 2) shl 16) or (u8(offset + 3) shl 24)

  /** Whether [pointer] is a cartridge pointer landing inside this image. */
  fun isPointer(pointer: Int): Boolean =
      (pointer ushr 24) == 0x08 && (pointer and ROM_MASK) < data.size

  /** The file offset [pointer] addresses. Only meaningful when [isPointer] holds. */
  fun offsetOf(pointer: Int): Int = pointer and ROM_MASK

  /** The header game code, "BPRE" for English FireRed and "BPRF" for French. */
  val gameCode: String
    get() = String(data, GAME_CODE_OFFSET, 4, Charsets.US_ASCII)

  companion object {
    const val GAME_CODE_OFFSET: Int = 0xAC
    private const val ROM_MASK = 0x1FFFFFF
  }
}
