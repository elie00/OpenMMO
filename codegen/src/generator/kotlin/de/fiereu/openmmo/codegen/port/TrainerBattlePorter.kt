package de.fiereu.openmmo.codegen.port

import de.fiereu.openmmo.codegen.defineTable
import de.fiereu.openmmo.codegen.dialog.RenderUtil
import de.fiereu.openmmo.codegen.dialog.TextParser
import de.fiereu.openmmo.codegen.trainer.TrainerParser
import java.io.File

/**
 * Ports the one decomp shape that maps cleanly onto the runtime we have: a single trainer battle
 * followed by one autoclose message.
 *
 * This is deliberately not the stub generator. That one deletes a region package and re-emits it,
 * which destroys hand written ports. This one only ever replaces `TODO("port X")` blocks whose
 * decomp body it recognises with certainty, and leaves every other byte of the file alone, so it is
 * safe to run over source that people have been editing by hand.
 */
class TrainerBattlePorter(private val region: String, decompDir: File) {

  private val trainerIds = defineTable(File(decompDir, "include/constants/opponents.h"), "TRAINER_")
  private val registeredIds = TrainerParser(decompDir).parseAll().mapTo(HashSet()) { it.id }
  private val textLabels = TextParser(decompDir).parseAll().mapTo(HashSet()) { it.label }
  private val trainersObject = "${region.replaceFirstChar { it.uppercase() }}Trainers"

  /** Counts of what happened, so a run can report what it declined instead of failing silently. */
  data class Report(
      var ported: Int = 0,
      var skippedShape: Int = 0,
      var skippedTrainer: Int = 0,
      var skippedText: Int = 0,
      var filesChanged: Int = 0,
      var filesRefused: Int = 0,
  )

  fun portDirectory(dir: File, write: Boolean, report: Report = Report()): Report {
    dir.listFiles { f -> f.isFile && f.extension == "kt" }
        ?.sorted()
        ?.forEach { portFile(it, write, report) }
    return report
  }

  private fun portFile(file: File, write: Boolean, report: Report) {
    val lines = file.readText().split("\n").toMutableList()
    val stubs = findStubs(lines)
    if (stubs.isEmpty()) return

    val splices = mutableListOf<Splice>()
    val imports = sortedSetOf<String>()
    for (stub in stubs) {
      val form = TrainerBattleForm.parse(stub.decompLines)
      if (form == null) {
        report.skippedShape++
        continue
      }
      val trainerId = trainerIds[form.trainer]
      if (trainerId == null || trainerId !in registeredIds) {
        report.skippedTrainer++
        continue
      }
      val refs = form.textLabels.map(::resolveText)
      if (refs.any { it == null }) {
        report.skippedText++
        continue
      }
      @Suppress("UNCHECKED_CAST") val resolved = refs as List<TextRef>
      splices += Splice(stub.from, stub.toExclusive, render(stub, form, resolved))
      resolved.mapTo(imports) { it.import }
      imports += "de.fiereu.openmmo.server.game.battle.BattleResult"
      imports += "de.fiereu.openmmo.trainer.generated.$trainersObject"
      report.ported++
    }
    if (splices.isEmpty()) return

    // A file whose import block cannot be edited safely keeps every one of its stubs.
    if (!canInsertImports(lines, imports)) {
      report.filesRefused++
      report.ported -= splices.size
      return
    }
    // Splices first, from the bottom up so the earlier offsets stay valid, and only then the
    // imports: inserting them shifts every line below and would misplace every splice.
    splices
        .sortedByDescending { it.from }
        .forEach {
          lines.subList(it.from, it.toExclusive).clear()
          lines.addAll(it.from, it.replacement)
        }
    check(insertImports(lines, imports)) { "Import block became uneditable in ${file.name}" }
    report.filesChanged++
    if (write) file.writeText(lines.joinToString("\n"))
  }

  private data class TextRef(val import: String, val reference: String)

  /** A decomp text label resolved to the Kotlin the dialog generator emitted for it. */
  private fun resolveText(label: String): TextRef? {
    if (label !in textLabels) return null
    val location = RenderUtil.location(label)
    // "Misc" is the dialog generator's bucket for labels with no map, and those are the ones whose
    // Kotlin identity is least certain. Never guess at one.
    if (location == "Misc") return null
    val entry = RenderUtil.entryName(label)
    if (!entry.matches(Regex("^[A-Za-z][A-Za-z0-9_]*$"))) return null
    val className = RenderUtil.className(location)
    if (className.startsWith("`")) return null
    return TextRef("de.fiereu.openmmo.dialog.generated.$region.$className", "$className.$entry")
  }

  private fun render(stub: Stub, form: TrainerBattleForm, texts: List<TextRef>): List<String> {
    val (intro, defeat, post) = texts
    return buildList {
      add("/**")
      add(" * Ported from the decomp:")
      add(" * ```")
      stub.decompLines.forEach { add(" * $it") }
      add(" * ```")
      add(" */")
      add("internal object ${stub.label} : Script {")
      add("  override suspend fun run(ctx: ScriptContext) {")
      add("    val trainerId = $trainersObject.${form.trainer}")
      add("    if (ctx.hasBeatenTrainer(trainerId)) {")
      add("      return ctx.say(${post.reference})")
      add("    }")
      add("    ctx.say(${intro.reference})")
      add("    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return")
      add("    ctx.say(${defeat.reference})")
      add("  }")
      add("}")
    }
  }

  /**
   * True when [required] can be merged into the file's import block. False when the block is not a
   * single contiguous run, or when an import would shadow a different type of the same simple name,
   * because either case would make an inserted reference mean something else.
   */
  private fun canInsertImports(lines: List<String>, required: Set<String>): Boolean {
    val first = lines.indexOfFirst { it.startsWith("import ") }
    if (first < 0) return false
    val last = lines.indexOfLast { it.startsWith("import ") }
    val existing = lines.subList(first, last + 1)
    if (existing.any { !it.startsWith("import ") }) return false

    val bySimpleName = existing.associateBy { it.substringAfterLast('.') }
    return required.none { import ->
      val clash = bySimpleName[import.substringAfterLast('.')]
      clash != null && clash != "import $import"
    }
  }

  /** Merges [required] into the import block, keeping it sorted the way ktfmt wants it. */
  private fun insertImports(lines: MutableList<String>, required: Set<String>): Boolean {
    if (!canInsertImports(lines, required)) return false
    val first = lines.indexOfFirst { it.startsWith("import ") }
    val last = lines.indexOfLast { it.startsWith("import ") }
    val existing = lines.subList(first, last + 1)
    val merged = (existing.toSet() + required.map { "import $it" }).sorted()
    if (merged != existing.toList()) {
      existing.clear()
      existing.addAll(merged)
    }
    return true
  }

  private data class Splice(val from: Int, val toExclusive: Int, val replacement: List<String>)

  private data class Stub(
      val label: String,
      val from: Int,
      val toExclusive: Int,
      val decompLines: List<String>,
  )

  /**
   * Finds every block that is both a "not ported yet" KDoc and a `TODO("port X")` body. Requiring
   * both is deliberate: a hand written port keeps neither, and a stale KDoc left above real code
   * has no TODO, so neither can be mistaken for a stub.
   */
  private fun findStubs(lines: List<String>): List<Stub> = buildList {
    var i = 0
    while (i < lines.size) {
      val stub = stubAt(lines, i)
      if (stub != null) {
        add(stub)
        i = stub.toExclusive
      } else {
        i++
      }
    }
  }

  private fun stubAt(lines: List<String>, start: Int): Stub? {
    if (lines.getOrNull(start) != "/**") return null
    if (lines.getOrNull(start + 1) != " * Not ported yet. Decomp body:") return null
    if (lines.getOrNull(start + 2) != " * ```") return null
    var end = start + 3
    while (end < lines.size && lines[end] != " * ```") end++
    if (end >= lines.size || lines.getOrNull(end + 1) != " */") return null

    val objLine = end + 2
    val header = OBJECT.matchEntire(lines.getOrNull(objLine) ?: return null) ?: return null
    val label = header.groupValues[1]

    // ktfmt wraps the body onto its own line once the label makes it too long, so both shapes are
    // real and a matcher that knows only the inline one silently skips the long labelled scripts.
    val bodyEnd =
        when {
          BODY_INLINE.matchEntire(lines.getOrNull(objLine + 1) ?: "")?.groupValues?.get(1) ==
              label -> objLine + 1
          lines.getOrNull(objLine + 1) == BODY_WRAPPED_HEAD &&
              BODY_WRAPPED_TAIL.matchEntire(lines.getOrNull(objLine + 2) ?: "")
                  ?.groupValues
                  ?.get(1) == label -> objLine + 2
          else -> return null
        }
    if (lines.getOrNull(bodyEnd + 1) != "}") return null

    val decomp =
        lines
            .subList(start + 3, end)
            .map { it.removePrefix(" *").trim() }
            .filter { it.isNotEmpty() }
    return Stub(label, start, bodyEnd + 2, decomp)
  }

  private companion object {
    val OBJECT = Regex("""^internal object (\w+) : Script \{$""")
    val BODY_INLINE =
        Regex("""^ {2}override suspend fun run\(ctx: ScriptContext\) = TODO\("port (\w+)"\)$""")
    const val BODY_WRAPPED_HEAD = "  override suspend fun run(ctx: ScriptContext) ="
    val BODY_WRAPPED_TAIL = Regex("""^ {6}TODO\("port (\w+)"\)$""")
  }
}

/** The one decomp shape this porter understands. */
data class TrainerBattleForm(
    val trainer: String,
    /** Intro, defeat, and post battle labels, in that order. */
    val textLabels: List<String>,
) {
  companion object {
    private val SINGLE =
        Regex("""^trainerbattle_single (TRAINER_[A-Z0-9_]+), ([A-Za-z0-9_]+), ([A-Za-z0-9_]+)$""")
    private val AUTOCLOSE = Regex("""^msgbox ([A-Za-z0-9_]+), MSGBOX_AUTOCLOSE$""")

    /**
     * Matches only the exact three line body. Anything else, a fourth argument, a rematch check, a
     * double battle, an extra command, is left to a human: a wrong port silently rewrites game
     * content, while a skipped one costs nothing.
     */
    fun parse(decompLines: List<String>): TrainerBattleForm? {
      if (decompLines.size != 3 || decompLines[2] != "end") return null
      val battle = SINGLE.matchEntire(decompLines[0]) ?: return null
      val message = AUTOCLOSE.matchEntire(decompLines[1]) ?: return null
      return TrainerBattleForm(
          battle.groupValues[1],
          listOf(battle.groupValues[2], battle.groupValues[3], message.groupValues[1]),
      )
    }
  }
}
