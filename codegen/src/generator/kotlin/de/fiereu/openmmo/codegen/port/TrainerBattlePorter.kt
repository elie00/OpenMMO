package de.fiereu.openmmo.codegen.port

import de.fiereu.openmmo.codegen.defineTable
import de.fiereu.openmmo.codegen.dialog.RenderUtil
import de.fiereu.openmmo.codegen.dialog.TextParser
import de.fiereu.openmmo.codegen.script.ScriptIndex
import de.fiereu.openmmo.codegen.trainer.TrainerParser
import java.io.File

/**
 * Ports the decomp shapes that map cleanly onto the runtime we have: a single trainer battle
 * followed by one message, and an item lying on the map.
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
  private val itemIds = defineTable(File(decompDir, "include/constants/items.h"), "ITEM_")
  private val flagNames = defineTable(File(decompDir, "include/constants/flags.h"), "FLAG_").keys
  private val varNames = defineTable(File(decompDir, "include/constants/vars.h"), "VAR_").keys
  private val mapObjects = MapObjectIndex(decompDir)
  private val subScripts = SubScriptEmitter(ScriptIndex.build(decompDir))
  private val translator =
      ScriptTranslator(region, flagNames, varNames, MovementTemplates(decompDir)) { label ->
        resolveText(label)?.let { it.import to it.reference }
      }
  private val trainersObject = "${region.replaceFirstChar { it.uppercase() }}Trainers"
  private val flagsObject = "${region.replaceFirstChar { it.uppercase() }}Flags"
  private val varsObject = "${region.replaceFirstChar { it.uppercase() }}Vars"

  /** Counts of what happened, so a run can report what it declined instead of failing silently. */
  data class Report(
      var ported: Int = 0,
      var skippedShape: Int = 0,
      var skippedTrainer: Int = 0,
      var skippedText: Int = 0,
      var skippedItem: Int = 0,
      var skippedJump: Int = 0,
      var translated: Int = 0,
      var emitted: Int = 0,
      var filesChanged: Int = 0,
      var filesRefused: Int = 0,
  )

  fun portDirectory(dir: File, write: Boolean, report: Report = Report()): Report {
    val files = dir.listFiles { f -> f.isFile && f.extension == "kt" }?.sorted().orEmpty()
    // Generated scripts are top level objects in one package per region, so a label emitted into
    // two files is a redeclaration. The set of what exists has to span the region, not the file.
    val definedInRegion =
        files.flatMapTo(HashSet()) { f -> DEFINED.findAll(f.readText()).map { it.groupValues[1] } }
    files.forEach { portFile(it, write, report, definedInRegion) }
    return report
  }

  private fun portFile(
      file: File,
      write: Boolean,
      report: Report,
      definedInRegion: MutableSet<String>,
  ) {
    val lines = file.readText().split("\n").toMutableList()
    var stubs = findStubs(lines)
    if (stubs.isEmpty()) return

    // Emit the jump targets first, so the stubs that reach into them become portable in this same
    // run rather than needing a second one. An emitted script can itself be a jump whose target is
    // missing, so keep going until the file stops growing, otherwise a second run would still have
    // work to do and the task would not be idempotent.
    var added = 0
    while (true) {
      val referenced = stubs.flatMapTo(HashSet()) { subScripts.jumpTargets(it.coreLines) }
      val round = subScripts.emitInto(lines, referenced, definedInRegion)
      if (round == 0) break
      added += round
      report.emitted += round
      stubs = findStubs(lines)
    }

    val defined = definedInRegion
    val splices = mutableListOf<Splice>()
    val imports = sortedSetOf<String>()
    for (stub in stubs) {
      val battle = TrainerBattleForm.parse(stub.decompLines)
      val item = if (battle == null) FindItemForm.parse(stub.decompLines) else null
      val facing =
          if (battle == null && item == null) FacingDialogueForm.parse(stub.coreLines) else null
      val jump =
          if (battle == null && item == null && facing == null) JumpForm.parse(stub.coreLines)
          else null
      val rendered =
          when {
            battle != null -> renderTrainerBattle(stub, battle, imports, report)
            item != null -> renderFindItem(stub, item, imports, report)
            facing != null -> renderFacingDialogue(stub, facing, imports, report)
            jump != null -> renderJump(stub, jump, defined, imports, report)
            else -> renderTranslated(stub, defined, imports, report)
          }
      if (rendered == null) continue
      splices += Splice(stub.from, stub.toExclusive, rendered)
      report.ported++
    }
    if (splices.isEmpty()) {
      if (added > 0) {
        report.filesChanged++
        if (write) file.writeText(lines.joinToString("\n"))
      }
      return
    }

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

  private fun renderTrainerBattle(
      stub: Stub,
      form: TrainerBattleForm,
      imports: MutableSet<String>,
      report: Report,
  ): List<String>? {
    val trainerId = trainerIds[form.trainer]
    if (trainerId == null || trainerId !in registeredIds) {
      report.skippedTrainer++
      return null
    }
    val refs = form.textLabels.map(::resolveText)
    if (refs.any { it == null }) {
      report.skippedText++
      return null
    }
    @Suppress("UNCHECKED_CAST") val texts = refs as List<TextRef>
    val (intro, defeat, post) = texts
    texts.mapTo(imports) { it.import }
    imports += "de.fiereu.openmmo.server.game.battle.BattleResult"
    imports += "de.fiereu.openmmo.trainer.generated.$trainersObject"
    return body(stub) {
      add("    val trainerId = $trainersObject.${form.trainer}")
      add("    if (ctx.hasBeatenTrainer(trainerId)) {")
      form.skippedRematch?.let {
        add("      // TODO Offer the rematch ($it)")
        add("      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and")
        add("      //  no VS Seeker, so this takes the branch a fresh save takes.")
      }
      add("      return ctx.say(${post.reference})")
      add("    }")
      add("    ctx.say(${intro.reference})")
      add("    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return")
      add("    ctx.say(${defeat.reference})")
    }
  }

  private fun renderFindItem(
      stub: Stub,
      form: FindItemForm,
      imports: MutableSet<String>,
      report: Report,
  ): List<String>? {
    val item = form.item.removePrefix("ITEM_")
    if (form.item !in itemIds) {
      report.skippedItem++
      return null
    }
    // Without the object event there is no hide flag, and picking the item up would leave the ball
    // on the map for the player to take again on every reload.
    val obj = mapObjects.forScript(stub.label)
    if (obj == null || obj.hideFlag !in flagNames) {
      report.skippedItem++
      return null
    }
    imports += "de.fiereu.openmmo.items.generated.Items"
    imports += "de.fiereu.openmmo.story.generated.$region.$flagsObject"
    return body(stub) {
      add("    ctx.findItem(Items.$item, $flagsObject.${obj.hideFlag}, ${obj.localId})")
    }
  }

  private fun renderFacingDialogue(
      stub: Stub,
      form: FacingDialogueForm,
      imports: MutableSet<String>,
      report: Report,
  ): List<String>? {
    val text = resolveText(form.textLabel)
    if (text == null) {
      report.skippedText++
      return null
    }
    imports += text.import
    return body(stub) {
      add("    ctx.say(${text.reference})")
      add("    // TODO Turn the npc back to the way it was facing")
      add("    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb")
      add("    //  for an object event's original facing, so it keeps looking at the player.")
    }
  }

  private fun renderJump(
      stub: Stub,
      form: JumpForm,
      defined: Set<String>,
      imports: MutableSet<String>,
      report: Report,
  ): List<String>? {
    // The target has to be an object in this file, otherwise the call does not compile.
    if (form.target !in defined) {
      report.skippedJump++
      return null
    }
    val text =
        when (form) {
          is JumpForm.BranchOnFlag -> resolveText(form.textLabel)
          is JumpForm.MessageThenJump -> resolveText(form.textLabel)
          is JumpForm.BranchOnVar -> resolveText(form.textLabel)
          is JumpForm.CallAndMessage -> resolveText(form.textLabel)
          is JumpForm.SetVarThenJump -> null
        }
    val body =
        when (form) {
          is JumpForm.SetVarThenJump -> {
            if (form.varName !in varNames || !form.value.all { it.isDigit() || it == '-' }) {
              report.skippedJump++
              return null
            }
            imports += "de.fiereu.openmmo.story.generated.$region.$varsObject"
            listOf(
                "    ctx.setVar($varsObject.${form.varName}, ${form.value})",
                "    return ${form.target}.run(ctx)",
            )
          }
          is JumpForm.BranchOnFlag -> {
            if (form.flag !in flagNames || text == null) {
              report.skippedJump++
              return null
            }
            imports += "de.fiereu.openmmo.story.generated.$region.$flagsObject"
            imports += text.import
            val condition =
                if (form.negated) "!ctx.isFlagSet($flagsObject.${form.flag})"
                else "ctx.isFlagSet($flagsObject.${form.flag})"
            listOf(
                "    if ($condition) return ${form.target}.run(ctx)",
                "    ctx.say(${text.reference})",
            )
          }
          is JumpForm.MessageThenJump -> {
            if (text == null) {
              report.skippedJump++
              return null
            }
            imports += text.import
            listOf("    ctx.say(${text.reference})", "    return ${form.target}.run(ctx)")
          }
          is JumpForm.BranchOnVar -> {
            if (form.varName !in varNames || text == null) {
              report.skippedJump++
              return null
            }
            imports += "de.fiereu.openmmo.story.generated.$region.$varsObject"
            imports += text.import
            val op = if (form.negated) "!=" else "=="
            listOf(
                "    if (ctx.getVar($varsObject.${form.varName}) $op ${form.value})" +
                    " return ${form.target}.run(ctx)",
                "    ctx.say(${text.reference})",
            )
          }
          is JumpForm.CallAndMessage -> {
            if (text == null) {
              report.skippedJump++
              return null
            }
            imports += text.import
            // call comes back, so this is a plain call and the message still runs.
            if (form.callFirst)
                listOf("    ${form.target}.run(ctx)", "    ctx.say(${text.reference})")
            else listOf("    ctx.say(${text.reference})", "    ${form.target}.run(ctx)")
          }
        }
    return body(stub) { addAll(body) }
  }

  /** Last resort: walk the body command by command instead of matching a whole shape. */
  private fun renderTranslated(
      stub: Stub,
      defined: Set<String>,
      imports: MutableSet<String>,
      report: Report,
  ): List<String>? {
    val translated = translator.translate(stub.coreLines, defined, imports)
    if (translated == null) {
      report.skippedShape++
      return null
    }
    report.translated++
    return body(stub) { addAll(translated) }
  }

  /** The shared shell: provenance KDoc, object header, and the run body the caller fills in. */
  private fun body(stub: Stub, lines: MutableList<String>.() -> Unit): List<String> = buildList {
    add("/**")
    add(" * Ported from the decomp:")
    add(FENCE)
    stub.decompLines.forEach { add(" * $it") }
    add(FENCE)
    add(" */")
    add("internal object ${stub.label} : Script {")
    add("  override suspend fun run(ctx: ScriptContext) {")
    lines()
    add("  }")
    add("}")
  }

  /**
   * True when [required] can be merged into the file's import block. False when the block is not a
   * single contiguous run, or when an import would shadow a different type of the same simple name,
   * because either case would make an inserted reference mean something else.
   */
  private fun canInsertImports(lines: List<String>, required: Set<String>): Boolean {
    val first = lines.indexOfFirst { it.startsWith(IMPORT) }
    if (first < 0) return false
    val last = lines.indexOfLast { it.startsWith(IMPORT) }
    val existing = lines.subList(first, last + 1)
    if (existing.any { !it.startsWith(IMPORT) }) return false

    val bySimpleName = existing.associateBy { it.substringAfterLast('.') }
    return required.none { import ->
      val clash = bySimpleName[import.substringAfterLast('.')]
      clash != null && clash != IMPORT + import
    }
  }

  /** Merges [required] into the import block, keeping it sorted the way ktfmt wants it. */
  private fun insertImports(lines: MutableList<String>, required: Set<String>): Boolean {
    if (!canInsertImports(lines, required)) return false
    val first = lines.indexOfFirst { it.startsWith(IMPORT) }
    val last = lines.indexOfLast { it.startsWith(IMPORT) }
    val existing = lines.subList(first, last + 1)
    val merged = (existing.toSet() + required.map { IMPORT + it }).sorted()
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
  ) {
    /** The decomp body without the commands the runtime already handles. */
    val coreLines: List<String>
      get() = decompLines.filter { it.substringBefore(' ') !in FRAMING_COMMANDS }
  }

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
    if (lines.getOrNull(start + 2) != FENCE) return null
    var end = start + 3
    while (end < lines.size && lines[end] != FENCE) end++
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
    val FRAMING_COMMANDS =
        setOf(
            "lock",
            "lockall",
            "faceplayer",
            "release",
            "releaseall",
            "closemessage",
            "waitmessage",
            "waitbuttonpress",
            "end",
            "return",
        )
    const val FENCE = " * ```"
    const val IMPORT = "import "
    val DEFINED = Regex("""internal object (\w+)\s*:\s*Script \{""")
    val OBJECT = Regex("""^internal object (\w+) : Script \{$""")
    val BODY_INLINE =
        Regex("""^ {2}override suspend fun run\(ctx: ScriptContext\) = TODO\("port (\w+)"\)$""")
    const val BODY_WRAPPED_HEAD = "  override suspend fun run(ctx: ScriptContext) ="
    val BODY_WRAPPED_TAIL = Regex("""^ {6}TODO\("port (\w+)"\)$""")
  }
}

/**
 * One message, then the npc turning back to the way it was facing.
 *
 * The turn is dropped: there is no verb for an object event's original facing, and the npc simply
 * stays looking at the player. That is cosmetic, and the alternative is a script that does nothing
 * at all, so the guide's rule applies: port what you can and name what you left.
 */
data class FacingDialogueForm(val textLabel: String) {
  companion object {
    private val MESSAGE = Regex("""^msgbox ([A-Za-z0-9_]+)(?:, (MSGBOX_[A-Z_]+))?$""")
    private val TURN_BACK =
        Regex("""^applymovement ([A-Za-z0-9_]+), Common_Movement_FaceOriginalDirection$""")

    fun parse(core: List<String>): FacingDialogueForm? {
      if (core.size != 3 || core[2] != "waitmovement 0") return null
      val message = MESSAGE.matchEntire(core[0]) ?: return null
      TURN_BACK.matchEntire(core[1]) ?: return null
      return FacingDialogueForm(message.groupValues[1])
    }
  }
}

/** An item lying on the map, picked up by walking into it. */
data class FindItemForm(val item: String) {
  companion object {
    private val FIND = Regex("""^finditem (ITEM_[A-Z0-9_]+)$""")

    /**
     * Only the bare two line body. The quantity taking form and anything with extra commands are
     * left alone, because those decide bag-full messages and follow up state this cannot model.
     */
    fun parse(decompLines: List<String>): FindItemForm? {
      if (decompLines.size != 2 || decompLines[1] != "end") return null
      return FIND.matchEntire(decompLines[0])?.let { FindItemForm(it.groupValues[1]) }
    }
  }
}

/** The one decomp shape this porter understands. */
data class TrainerBattleForm(
    val trainer: String,
    /** Intro, defeat, and post battle labels, in that order. */
    val textLabels: List<String>,
    /** The rematch script this skips, when the decomp offered one. */
    val skippedRematch: String? = null,
) {
  companion object {
    /** Commands that only frame a script; the runtime already does what they do. */
    private val FRAMING =
        setOf(
            "lock",
            "lockall",
            "faceplayer",
            "release",
            "releaseall",
            "closemessage",
            "waitmessage",
            "waitbuttonpress",
            "end",
            "return",
        )
    private val SINGLE =
        Regex("""^trainerbattle_single (TRAINER_[A-Z0-9_]+), ([A-Za-z0-9_]+), ([A-Za-z0-9_]+)$""")
    // Both types wait for the player here. Autoclose closes the box itself in the source game,
    // which the runtime has no verb for, and the guide already maps every other type onto ctx.say.
    private val MESSAGE = Regex("""^msgbox ([A-Za-z0-9_]+), (MSGBOX_AUTOCLOSE|MSGBOX_DEFAULT)$""")
    private const val REMATCH_CHECK = "specialvar VAR_RESULT, ShouldTryRematchBattle"
    private val REMATCH_JUMP = Regex("""^goto_if_eq VAR_RESULT, TRUE, ([A-Za-z0-9_]+)$""")

    /**
     * Matches a single trainer battle followed by one message, with or without the rematch check in
     * between. Anything else, a fourth argument, a double battle, any other command, is left to a
     * human: a wrong port silently rewrites game content, a skipped one costs nothing.
     *
     * The rematch branch is dropped on purpose. It asks `ShouldTryRematchBattle`, which the server
     * has no model for and which is false on a save without the VS Seeker, so taking the other
     * branch is what a fresh game does.
     */
    fun parse(decompLines: List<String>): TrainerBattleForm? {
      val core = decompLines.filter { it.substringBefore(' ') !in FRAMING }
      val battle = SINGLE.matchEntire(core.firstOrNull() ?: return null) ?: return null
      val (rest, rematch) =
          when (core.size) {
            2 -> core.drop(1) to null
            4 -> {
              if (core[1] != REMATCH_CHECK) return null
              val jump = REMATCH_JUMP.matchEntire(core[2]) ?: return null
              core.drop(3) to jump.groupValues[1]
            }
            else -> return null
          }
      val message = MESSAGE.matchEntire(rest.single()) ?: return null
      return TrainerBattleForm(
          battle.groupValues[1],
          listOf(battle.groupValues[2], battle.groupValues[3], message.groupValues[1]),
          rematch,
      )
    }
  }
}

/**
 * A body that ends by handing over to another script in the same map.
 *
 * Every generated script is an object with one `run`, so the decomp's `goto` is a tail call and its
 * `call` is a plain one, exactly as the porting guide describes. The target has to exist as an
 * object, which is what [SubScriptEmitter] is for.
 */
sealed interface JumpForm {
  val target: String

  /** `setvar VAR, n` then `goto Label`. */
  data class SetVarThenJump(val varName: String, val value: String, override val target: String) :
      JumpForm

  /** `goto_if_set FLAG, Label` then a message for the other branch. */
  data class BranchOnFlag(
      val flag: String,
      override val target: String,
      val textLabel: String,
      val negated: Boolean,
  ) : JumpForm

  /** A message then `goto Label`. */
  data class MessageThenJump(val textLabel: String, override val target: String) : JumpForm

  /** `goto_if_eq VAR, n, Label` (or `goto_if_ne`) then a message for the other branch. */
  data class BranchOnVar(
      val varName: String,
      val value: String,
      override val target: String,
      val textLabel: String,
      val negated: Boolean,
  ) : JumpForm

  /** `call Label` then a message, or a message then `call Label`. The call comes back. */
  data class CallAndMessage(
      override val target: String,
      val textLabel: String,
      val callFirst: Boolean,
  ) : JumpForm

  companion object {
    private val SETVAR = Regex("""^setvar (VAR_[A-Z0-9_]+), (-?\d+|[A-Z][A-Z0-9_]*)$""")
    private val GOTO = Regex("""^goto ([A-Za-z]\w*)$""")
    private val GOTO_IF_FLAG = Regex("""^goto_if_(set|unset) (FLAG_[A-Z0-9_]+), ([A-Za-z]\w*)$""")
    private val MESSAGE = Regex("""^msgbox ([A-Za-z0-9_]+)(?:, (MSGBOX_[A-Z_]+))?$""")
    private val GOTO_IF_VAR =
        Regex("""^goto_if_(eq|ne) (VAR_[A-Z0-9_]+), (-?\d+), ([A-Za-z]\w*)$""")
    private val CALL = Regex("""^call ([A-Za-z]\w*)$""")

    fun parse(core: List<String>): JumpForm? {
      if (core.size != 2) return null
      SETVAR.matchEntire(core[0])?.let { set ->
        val jump = GOTO.matchEntire(core[1]) ?: return null
        return SetVarThenJump(set.groupValues[1], set.groupValues[2], jump.groupValues[1])
      }
      GOTO_IF_FLAG.matchEntire(core[0])?.let { branch ->
        val message = MESSAGE.matchEntire(core[1]) ?: return null
        return BranchOnFlag(
            branch.groupValues[2],
            branch.groupValues[3],
            message.groupValues[1],
            negated = branch.groupValues[1] == "unset",
        )
      }
      GOTO_IF_VAR.matchEntire(core[0])?.let { branch ->
        val message = MESSAGE.matchEntire(core[1]) ?: return null
        return BranchOnVar(
            branch.groupValues[2],
            branch.groupValues[3],
            branch.groupValues[4],
            message.groupValues[1],
            negated = branch.groupValues[1] == "ne",
        )
      }
      CALL.matchEntire(core[0])?.let { call ->
        val message = MESSAGE.matchEntire(core[1]) ?: return null
        return CallAndMessage(call.groupValues[1], message.groupValues[1], callFirst = true)
      }
      MESSAGE.matchEntire(core[0])?.let { message ->
        GOTO.matchEntire(core[1])?.let {
          return MessageThenJump(message.groupValues[1], it.groupValues[1])
        }
        CALL.matchEntire(core[1])?.let {
          return CallAndMessage(it.groupValues[1], message.groupValues[1], callFirst = false)
        }
      }
      return null
    }
  }
}
