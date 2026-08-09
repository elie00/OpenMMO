package de.fiereu.openmmo.codegen.port

import de.fiereu.openmmo.codegen.script.ScriptIndex

/**
 * Adds the scripts a stub jumps to but that were never emitted.
 *
 * The stub generator only emits the labels a map json points at: npcs, signs, map scripts. A `goto`
 * or `call` inside one of those bodies names a label that exists in the decomp and has no Kotlin
 * object at all, so those stubs cannot be ported however simple their body is. This fills that gap
 * by appending the missing objects, as stubs carrying their own decomp body, and registering them
 * in the file's script map.
 *
 * It only ever appends. Existing objects, their order, and every other byte of the file are left
 * alone.
 */
class SubScriptEmitter(private val scripts: ScriptIndex) {

  /**
   * Appends the objects [referenced] names that [lines] does not already define. Returns how many
   * were added; the list is edited in place.
   */
  fun emitInto(lines: MutableList<String>, referenced: Set<String>): Int {
    // ktfmt wraps a long declaration onto two lines, so match the joined text: a line by line
    // regex misses those and the emitter would append an object the file already has.
    val defined = OBJECT.findAll(lines.joinToString("\n")).mapTo(HashSet()) { it.groupValues[1] }
    val mapEnd = lines.indexOfLast { it == "    )" }
    val mapStart = lines.indexOfFirst { MAP_HEADER.containsMatchIn(it) }
    if (mapEnd < 0 || mapStart < 0 || mapEnd < mapStart) return 0

    // Only what the file's own stubs reach for, not the transitive closure. Following every jump
    // out of an emitted body pulls in thousands of labels that nothing can call yet, which buries
    // the ports under stubs instead of enabling them. An emitted script that jumps somewhere
    // unemitted stays a stub, and a later run picks it up once its caller is worth porting.
    val missing =
        (referenced - defined).filterTo(LinkedHashSet()) { scripts.commandsFor(it) != null }
    if (missing.isEmpty()) return 0

    val objects = missing.flatMap { renderStub(it, scripts.commandsFor(it).orEmpty()) }
    val entries = missing.map { "        \"$it\" to $it," }
    // Map entries first: inserting the objects above would move the map's own line numbers.
    lines.addAll(mapEnd, entries)
    lines.addAll(mapStart, objects + "")
    return missing.size
  }

  /** Every label a body jumps or calls into. */
  fun jumpTargets(body: List<String>): List<String> =
      body.mapNotNull { line ->
        val command = line.substringBefore(' ')
        if (!command.startsWith("goto") && !command.startsWith("call")) return@mapNotNull null
        val target = line.substringAfterLast(',', "").trim().ifEmpty { line.substringAfter(' ') }
        target.trim().takeIf { it.matches(LABEL) }
      }

  private fun renderStub(label: String, body: List<String>): List<String> = buildList {
    add("/**")
    add(" * Not ported yet. Decomp body:")
    add(" * ```")
    body.forEach { add(" * ${it.replace("*/", "* /")}") }
    add(" * ```")
    add(" */")
    add("internal object $label : Script {")
    add("  override suspend fun run(ctx: ScriptContext) = TODO(\"port $label\")")
    add("}")
    add("")
  }

  private companion object {
    val OBJECT = Regex("""internal object (\w+)\s*:\s*Script \{""")
    val MAP_HEADER = Regex("""^internal val \w+Scripts: Map<String, Script> =$""")
    val LABEL = Regex("""^[A-Za-z]\w*$""")
  }
}
