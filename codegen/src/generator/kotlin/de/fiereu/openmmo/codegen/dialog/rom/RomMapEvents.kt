package de.fiereu.openmmo.codegen.dialog.rom

/** The script pointers a map's three event tables hold, each in table order. */
data class RomMapEvents(
    val objects: List<Int>,
    val coords: List<Int>,
    val backgrounds: List<Int>,
)

/** One entry of a map's script table: the moment it runs and what it points at. */
data class RomMapScript(val type: Int, val pointer: Int)

/**
 * Reads a map's headers and event tables out of a ROM, following the same layout the game's
 * `MapHeader`, `MapEvents`, `ObjectEventTemplate`, `CoordEvent` and `BgEvent` structs describe.
 */
class RomMapReader(private val rom: GbaRom, private val bankTable: Int) {

  /** The file offset of the header for map [num] of group [group], or null when out of range. */
  fun headerOffset(group: Int, num: Int): Int? {
    val groupPointer = rom.u32(bankTable + 4 * group)
    if (!rom.isPointer(groupPointer)) return null
    val headerPointer = rom.offsetOf(groupPointer) + 4 * num
    if (!rom.has(headerPointer, 4)) return null
    val header = rom.u32(headerPointer)
    return if (rom.isPointer(header)) rom.offsetOf(header) else null
  }

  /** The map's event script pointers, or null when it has no event table. */
  fun events(header: Int): RomMapEvents? {
    if (!rom.has(header, MAP_HEADER_SIZE)) return null
    val eventsPointer = rom.u32(header + HEADER_EVENTS)
    if (!rom.isPointer(eventsPointer)) return null
    val events = rom.offsetOf(eventsPointer)
    if (!rom.has(events, MAP_EVENTS_SIZE)) return null
    return RomMapEvents(
        scripts(
            rom.u8(events + EVENTS_OBJECT_COUNT),
            rom.u32(events + EVENTS_OBJECTS),
            OBJECT_SIZE,
            OBJECT_SCRIPT),
        scripts(
            rom.u8(events + EVENTS_COORD_COUNT),
            rom.u32(events + EVENTS_COORDS),
            COORD_SIZE,
            COORD_SCRIPT),
        scripts(rom.u8(events + EVENTS_BG_COUNT), rom.u32(events + EVENTS_BGS), BG_SIZE, BG_SCRIPT),
    )
  }

  /** The map's script table, terminated by a zero type byte. */
  fun mapScripts(header: Int): List<RomMapScript> {
    if (!rom.has(header, MAP_HEADER_SIZE)) return emptyList()
    val tablePointer = rom.u32(header + HEADER_MAP_SCRIPTS)
    if (!rom.isPointer(tablePointer)) return emptyList()
    var offset = rom.offsetOf(tablePointer)
    val out = ArrayList<RomMapScript>()
    while (rom.has(offset, 5) && rom.u8(offset) != 0) {
      out.add(RomMapScript(rom.u8(offset), rom.u32(offset + 1)))
      offset += 5
    }
    return out
  }

  /**
   * The script pointers of a var driven sub table, the shape the ON_FRAME_TABLE and
   * ON_WARP_INTO_MAP_TABLE script types point at, terminated by a zero var.
   */
  fun mapScriptSubTable(pointer: Int): List<Int> {
    if (!rom.isPointer(pointer)) return emptyList()
    var offset = rom.offsetOf(pointer)
    val out = ArrayList<Int>()
    while (rom.has(offset, 8) && rom.u16(offset) != 0) {
      out.add(rom.u32(offset + 4))
      offset += 8
    }
    return out
  }

  private fun scripts(count: Int, tablePointer: Int, stride: Int, scriptOffset: Int): List<Int> {
    if (count == 0) return emptyList()
    if (!rom.isPointer(tablePointer)) return emptyList()
    val table = rom.offsetOf(tablePointer)
    val out = ArrayList<Int>(count)
    for (i in 0 until count) {
      val at = table + stride * i + scriptOffset
      out.add(if (rom.has(at, 4)) rom.u32(at) else 0)
    }
    return out
  }

  companion object {
    /** Script table types whose pointer is a var driven sub table rather than a script. */
    val TABLE_TYPES: Set<Int> = setOf(2, 4)

    private const val MAP_HEADER_SIZE = 0x1C
    private const val HEADER_EVENTS = 0x04
    private const val HEADER_MAP_SCRIPTS = 0x08

    private const val MAP_EVENTS_SIZE = 0x14
    private const val EVENTS_OBJECT_COUNT = 0x00
    private const val EVENTS_COORD_COUNT = 0x02
    private const val EVENTS_BG_COUNT = 0x03
    private const val EVENTS_OBJECTS = 0x04
    private const val EVENTS_COORDS = 0x0C
    private const val EVENTS_BGS = 0x10

    private const val OBJECT_SIZE = 0x18
    private const val OBJECT_SCRIPT = 0x10
    private const val COORD_SIZE = 0x10
    private const val COORD_SCRIPT = 0x0C
    private const val BG_SIZE = 0x0C
    private const val BG_SCRIPT = 0x08
  }
}
