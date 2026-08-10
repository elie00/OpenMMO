@file:JvmName("Main")

package de.fiereu.openmmo.codegen.dialog

import de.fiereu.openmmo.common.enums.Region
import java.io.File

// A GBA dialog id is the retail ROM file offset with the region on top, which is how the client
// knows the ROM to resolve it in. Captured Kanto ids carry 0 there and Hoenn ids carry 1.
private const val REGION_SHIFT = 28

private fun regionMode(region: String): Int {
  val known =
      Region.entries.find { it.name.equals(region, ignoreCase = true) }
          ?: error("unknown region '$region', its dialog ids cannot be built")
  return known.wireValue.toInt() shl REGION_SHIFT
}

fun main(args: Array<String>) {
  require(args.size >= 5) {
    "Usage: <output-dir> <templates-dir> <class-cache-dir> <roms-dir> <region|gameCodes|decomp>... got ${args.toList()}"
  }
  val outputDir = File(args[0])
  val templatesDir = File(args[1])
  val classCacheDir = File(args[2])
  val romsDir = File(args[3])

  for (spec in args.drop(4)) {
    val (region, gameCodes, decomp) = spec.split("|")
    generateRegion(
        region, gameCodes.split(","), File(decomp), romsDir, outputDir, templatesDir, classCacheDir)
  }
}

private fun generateRegion(
    region: String,
    gameCodes: List<String>,
    decompDir: File,
    romsDir: File,
    outputDir: File,
    templatesDir: File,
    classCacheDir: File,
) {
  val renderer = DialogRenderer(region, templatesDir, outputDir, classCacheDir)
  val rom = RomIndex.find(romsDir, gameCodes)

  val texts = TextParser(decompDir).parseAll()
  println("[dialog] $region: parsed ${texts.size} text labels from $decompDir")

  // Without a ROM we cannot resolve textIds, but the enums must still exist so code that
  // references them compiles (for example in CI, where ROMs are never present). Emit every
  // label with a placeholder textId so the build works, just without real dialog ids.
  if (rom == null) {
    println(
        "[dialog] no ${gameCodes.joinToString("/")} ROM found in $romsDir, generating $region labels without textIds")
    renderer.render(texts.map { DialogLine(it.label, 0, RenderUtil.preview(it.content)) })
    return
  }

  val source = TextOffsetSources.create(rom.gameCode, decompDir, rom.index)
  val mode = regionMode(region)

  val resolved = texts.map { it to source.offsetOf(it) }
  val kept = if (source.keepsUnresolved) resolved else resolved.filter { it.second >= 0 }
  val lines =
      kept
          // A location can hold two labels with the same entry name and the renderer keeps the
          // first, so the resolved ones go first and a real id always wins over a zero.
          .sortedBy { if (it.second >= 0) 0 else 1 }
          .map { (text, offset) ->
            DialogLine(
                text.label,
                if (offset >= 0) mode or offset else 0,
                RenderUtil.preview(text.content))
          }

  println(
      "[dialog] $region: ${rom.gameCode} ROM, resolved ${resolved.count { it.second >= 0 }} of ${texts.size} lines")
  report(region, source, resolved)
  renderer.render(lines)
}

/** Says what could not be resolved and where it lives, so a zero textId is never a silent one. */
private fun report(
    region: String,
    source: TextOffsetSource,
    resolved: List<Pair<DecompText, Int>>,
) {
  if (source is ScriptNavTextSource) println("[dialog] $region: navigation ${source.stats}")
  if (!source.keepsUnresolved) return
  val unresolved = resolved.filter { it.second < 0 }
  if (unresolved.isEmpty()) return
  println("[dialog] $region: ${unresolved.size} labels left at textId 0, they are unreachable")
  unresolved
      .groupingBy { RenderUtil.location(it.first.label) }
      .eachCount()
      .entries
      .sortedByDescending { it.value }
      .take(10)
      .forEach { println("[dialog]   ${it.value} in ${it.key}") }
}
