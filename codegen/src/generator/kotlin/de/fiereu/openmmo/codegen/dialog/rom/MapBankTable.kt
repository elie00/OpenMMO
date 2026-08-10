package de.fiereu.openmmo.codegen.dialog.rom

/**
 * Locates `gMapGroups`, the table of one pointer per map group that every map lookup starts from.
 *
 * The groups are emitted back to back, so each pointer sits exactly `4 * (previous group's map
 * count)` bytes after the one before it. Those counts come from the decomp, so the table is found
 * by its shape rather than by a per ROM offset, and the same code works on any localised build of
 * the same game.
 */
object MapBankTable {

  /**
   * The file offset of the map group table. Throws when the ROM does not hold exactly one table
   * matching [groupSizes]: a build whose map counts differ is not the build the decomp describes,
   * and pairing anything against it would silently produce wrong offsets.
   */
  fun locate(rom: GbaRom, groupSizes: List<Int>): Int {
    require(groupSizes.size >= 2) { "need at least two map groups to match a table shape" }
    val span = 4 * groupSizes.size
    val hits = ArrayList<Int>(2)
    var offset = 0
    while (offset + span <= rom.size) {
      if (matches(rom, offset, groupSizes)) hits.add(offset)
      offset += 4
    }
    if (hits.size != 1) {
      error(
          "expected exactly one map group table matching the decomp's ${groupSizes.size} group sizes, found ${hits.size}")
    }
    return hits[0]
  }

  private fun matches(rom: GbaRom, offset: Int, groupSizes: List<Int>): Boolean {
    var previous = rom.u32(offset)
    if (!rom.isPointer(previous)) return false
    for (i in 0 until groupSizes.size - 1) {
      val next = rom.u32(offset + 4 * (i + 1))
      if (next - previous != 4 * groupSizes[i]) return false
      if (!rom.isPointer(next)) return false
      previous = next
    }
    return true
  }
}
