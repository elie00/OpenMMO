package de.fiereu.openmmo.codegen.port

/**
 * Translates a decomp script body command by command, instead of matching whole shapes.
 *
 * The shape matchers each recognise one fixed sequence, so a body of the same commands in another
 * order, or with one extra line, falls through however simple it is. This walks the body instead
 * and emits Kotlin per command, which covers any length and any order as long as every command is
 * one it knows.
 *
 * It is all or nothing: one unknown command and the whole body is refused. That is what keeps it
 * honest, since a body half translated would silently lose whatever it skipped.
 */
class ScriptTranslator(
    private val region: String,
    private val flagNames: Set<String>,
    private val varNames: Set<String>,
    private val resolveText: (String) -> Pair<String, String>?,
) {
  private val flagsObject = "${region.replaceFirstChar { it.uppercase() }}Flags"
  private val varsObject = "${region.replaceFirstChar { it.uppercase() }}Vars"
  private val storyPackage = "de.fiereu.openmmo.story.generated.$region"

  /**
   * The Kotlin body for [core], or null when any command is unsupported or any name unresolvable.
   * [defined] is the set of script objects the file has, since a jump can only target one of those.
   */
  fun translate(
      core: List<String>,
      defined: Set<String>,
      imports: MutableSet<String>,
  ): List<String>? {
    val out = mutableListOf<String>()
    val needed = mutableSetOf<String>()
    for (line in core) {
      val emitted = translateLine(line, defined, needed) ?: return null
      out += emitted
    }
    if (out.isEmpty()) return null
    imports += needed
    return out
  }

  private fun translateLine(
      line: String,
      defined: Set<String>,
      imports: MutableSet<String>,
  ): List<String>? {
    val command = line.substringBefore(' ')
    val rest = line.substringAfter(' ', "")
    return when (command) {
      "msgbox",
      "message" -> message(rest, imports)
      "setflag" -> flag(rest, imports)?.let { listOf("    ctx.setFlag($it)") }
      "clearflag" -> flag(rest, imports)?.let { listOf("    ctx.clearFlag($it)") }
      "setvar" -> setVar(rest, imports)
      "goto" -> jump(rest, defined)?.let { listOf("    return $it.run(ctx)") }
      // call comes back, so it is a plain call and whatever follows still runs.
      "call" -> jump(rest, defined)?.let { listOf("    $it.run(ctx)") }
      "goto_if_set",
      "goto_if_unset" -> flagBranch(command, rest, defined, imports)
      "goto_if_eq",
      "goto_if_ne" -> varBranch(command, rest, defined, imports)
      else -> null
    }
  }

  private fun message(rest: String, imports: MutableSet<String>): List<String>? {
    val label = rest.substringBefore(',').trim()
    val type = rest.substringAfter(',', "").trim()
    if (type.isNotEmpty() && type !in KNOWN_MESSAGE_TYPES) return null
    val (import, reference) = resolveText(label) ?: return null
    imports += import
    // A sign box has no speaker, everything else is addressed by the entity that was interacted
    // with, which is what ctx.say already does.
    val verb = if (type == "MSGBOX_SIGN") "sign" else "say"
    return listOf("    ctx.$verb($reference)")
  }

  private fun flag(name: String, imports: MutableSet<String>): String? {
    val flag = name.trim()
    if (flag !in flagNames) return null
    imports += "$storyPackage.$flagsObject"
    return "$flagsObject.$flag"
  }

  private fun setVar(rest: String, imports: MutableSet<String>): List<String>? {
    val name = rest.substringBefore(',').trim()
    val value = rest.substringAfter(',', "").trim()
    if (name !in varNames || !value.isInteger()) return null
    imports += "$storyPackage.$varsObject"
    return listOf("    ctx.setVar($varsObject.$name, $value)")
  }

  private fun jump(target: String, defined: Set<String>): String? =
      target.trim().takeIf { it.matches(LABEL) && it in defined }

  private fun flagBranch(
      command: String,
      rest: String,
      defined: Set<String>,
      imports: MutableSet<String>,
  ): List<String>? {
    val flag = flag(rest.substringBefore(',').trim(), imports) ?: return null
    val target = jump(rest.substringAfter(',', ""), defined) ?: return null
    val condition =
        if (command == "goto_if_unset") "!ctx.isFlagSet($flag)" else "ctx.isFlagSet($flag)"
    return listOf("    if ($condition) return $target.run(ctx)")
  }

  private fun varBranch(
      command: String,
      rest: String,
      defined: Set<String>,
      imports: MutableSet<String>,
  ): List<String>? {
    val parts = rest.split(',').map { it.trim() }
    if (parts.size != 3) return null
    val (name, value, label) = parts
    if (name !in varNames || !value.isInteger()) return null
    val target = jump(label, defined) ?: return null
    imports += "$storyPackage.$varsObject"
    val op = if (command == "goto_if_ne") "!=" else "=="
    return listOf("    if (ctx.getVar($varsObject.$name) $op $value) return $target.run(ctx)")
  }

  private fun String.isInteger(): Boolean = isNotEmpty() && (toIntOrNull() != null)

  private companion object {
    val LABEL = Regex("""^[A-Za-z]\w*$""")
    val KNOWN_MESSAGE_TYPES =
        setOf("MSGBOX_DEFAULT", "MSGBOX_AUTOCLOSE", "MSGBOX_NPC", "MSGBOX_SIGN")
  }
}
