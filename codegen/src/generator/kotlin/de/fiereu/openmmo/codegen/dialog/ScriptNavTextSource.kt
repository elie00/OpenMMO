package de.fiereu.openmmo.codegen.dialog

import de.fiereu.openmmo.codegen.dialog.decomp.DecompMapEntries
import de.fiereu.openmmo.codegen.dialog.decomp.DecompScriptStream
import de.fiereu.openmmo.codegen.dialog.decomp.DecompScriptWalker
import de.fiereu.openmmo.codegen.dialog.rom.GbaRom
import de.fiereu.openmmo.codegen.dialog.rom.MapBankTable
import de.fiereu.openmmo.codegen.dialog.rom.RomMapReader
import de.fiereu.openmmo.codegen.dialog.rom.RomScriptWalker
import de.fiereu.openmmo.codegen.dialog.rom.ScriptOpcodes
import java.io.File

/**
 * Resolves text offsets by navigating the ROM the way the game does: from the map group table to a
 * map, to its event tables, to the script a given event runs, through that script's bytecode to the
 * text pointers it shows.
 *
 * That path never reads a single character of text, so it works on a localised ROM whose text
 * shares nothing with the decomp. What it needs instead is that the decomp and the ROM describe the
 * same maps, which is what lets a script label be paired with the pointer sitting at the same event
 * index, and then a text label with the pointer sitting at the same slot of the same script.
 *
 * The pairing is only ever done for a whole script at a time. If either walk fails, or the two
 * produce a different number of text slots, the script is dropped entirely rather than paired up to
 * the point they diverge: a partial pairing would attach real labels to wrong offsets, which is far
 * worse than leaving them unresolved.
 */
class ScriptNavTextSource(private val decompDir: File, romBytes: ByteArray) : TextOffsetSource {

  private val rom = GbaRom(romBytes)

  /** Labels the navigation cannot reach are real, so they must still get an enum entry. */
  override val keepsUnresolved: Boolean
    get() = true

  /** How the navigation went, for the generator to report. */
  data class Stats(
      val entries: Int,
      val paired: Int,
      val walkFailures: Int,
      val slotMismatches: Int,
      val countMismatches: Int,
      val resolved: Int,
  )

  lateinit var stats: Stats
    private set

  private val offsets: Map<String, Int> by lazy { resolve() }

  override fun offsetOf(text: DecompText): Int = offsets[text.label] ?: -1

  private fun resolve(): Map<String, Int> {
    val stream = DecompScriptStream(decompDir)
    val decompWalker = DecompScriptWalker(stream)
    val romWalker = RomScriptWalker(rom, ScriptOpcodes.load(decompDir))
    val entriesByMap = DecompMapEntries(decompDir)
    val reader = RomMapReader(rom, MapBankTable.locate(rom, entriesByMap.groupSizes))

    val pairs = HashMap<String, Int>()
    var entries = 0
    var paired = 0
    var walkFailures = 0
    var slotMismatches = 0
    var countMismatches = 0

    for (map in entriesByMap.maps) {
      val header = reader.headerOffset(map.group, map.number) ?: continue
      val events = reader.events(header) ?: continue
      val candidates = ArrayList<Pair<String, Int>>()

      for ((declared, actual) in
          listOf(
              map.objects to events.objects,
              map.coords to events.coords,
              map.backgrounds to events.backgrounds)) {
        if (declared.size != actual.size) {
          countMismatches++
          continue
        }
        declared.forEachIndexed { index, label ->
          if (label != null && rom.isPointer(actual[index])) candidates.add(label to actual[index])
        }
      }
      candidates.addAll(mapScriptEntries(map.name, header, stream, reader))

      for ((label, pointer) in candidates) {
        entries++
        val expected = decompWalker.textLabels(label)
        val found = romWalker.textPointers(pointer)
        if (expected == null || found == null) {
          walkFailures++
          continue
        }
        if (expected.size != found.size) {
          slotMismatches++
          continue
        }
        paired++
        for (i in expected.indices) {
          val text = expected[i]
          val target = found[i]
          if (!stream.isText(text) || !rom.isPointer(target)) continue
          val offset = rom.offsetOf(target)
          val previous = pairs.put(text, offset)
          check(previous == null || previous == offset) {
            "text label $text was navigated to two different offsets, the walkers disagree"
          }
        }
      }
    }

    stats = Stats(entries, paired, walkFailures, slotMismatches, countMismatches, pairs.size)
    return pairs
  }

  /**
   * The scripts a map runs by itself rather than through an event, which is how a handful of texts
   * already referenced by ported scripts are reached. Two of the table types point at a var driven
   * sub table instead of a script, so those are zipped one level deeper.
   */
  private fun mapScriptEntries(
      mapName: String,
      header: Int,
      stream: DecompScriptStream,
      reader: RomMapReader,
  ): List<Pair<String, Int>> {
    val declared = stream.mapScriptEntries("${mapName}_MapScripts")
    val actual = reader.mapScripts(header)
    if (declared.isEmpty() || declared.size != actual.size) return emptyList()

    val out = ArrayList<Pair<String, Int>>()
    for (i in declared.indices) {
      val label = declared[i].second
      val entry = actual[i]
      if (entry.type in RomMapReader.TABLE_TYPES) {
        val subLabels = stream.mapScriptSubEntries(label)
        val subPointers = reader.mapScriptSubTable(entry.pointer)
        if (subLabels.size != subPointers.size) continue
        for (j in subLabels.indices) {
          if (rom.isPointer(subPointers[j])) out.add(subLabels[j] to subPointers[j])
        }
      } else if (rom.isPointer(entry.pointer)) {
        out.add(label to entry.pointer)
      }
    }
    return out
  }
}
