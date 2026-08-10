package de.fiereu.openmmo.codegen.dialog.decomp

import de.fiereu.openmmo.codegen.dialog.rom.ScriptOpcodes

/**
 * Walks the decomp assembly the way [de.fiereu.openmmo.codegen.dialog.rom.RomScriptWalker] walks
 * the bytecode, and reports the text labels it would show in the same order.
 *
 * Every rule here mirrors one there: the same branches are followed, the same commands stop a run,
 * and the composite macros that hide a text pointer (`msgbox`, `giveitem_msg`, the trainer battle
 * family) contribute exactly as many slots as the bytes they assemble into.
 */
/** Where a `trainerbattle` shorthand macro keeps its texts and its optional event script. */
private data class TrainerBattleMacro(
    val firstText: Int,
    val textCount: Int,
    val eventScript: Int? = null,
)

class DecompScriptWalker(private val stream: DecompScriptStream) {

  /** The text labels reachable from [entry], or null when the decomp does not define it. */
  fun textLabels(entry: String): List<String>? {
    val start = stream.positionOf(entry) ?: return null
    val worklist = ArrayDeque<Int>()
    val seen = HashSet<Int>()
    val texts = ArrayList<String>()
    worklist.add(start)
    var steps = 0

    while (worklist.isNotEmpty()) {
      var index = worklist.removeFirst()
      if (!seen.add(index)) continue
      while (index < stream.size) {
        if (++steps > STEP_LIMIT) return null
        val command = stream.commandAt(index)
        val name = command.name
        val args = command.args

        when {
          name in TEXT_FIRST_ARG && args.isNotEmpty() -> texts.add(args[0])
          // Assembles into braillemessage plus getbraillestringwidth on the same text.
          name == "braillemessage_wait" && args.isNotEmpty() -> {
            texts.add(args[0])
            texts.add(args[0])
          }
          name in TEXT_SECOND_ARG && args.size > 1 -> texts.add(args[1])
          name == "loadword" && args.size > 1 && args[0] == "0" -> texts.add(args[1])
          name == "trainerbattle" && args.size >= 4 -> {
            val type = TRAINER_BATTLE_TYPES.indexOf(args[0]).takeIf { it >= 0 } ?: return null
            trainerBattle(type, args.drop(3), texts, worklist)
          }
          name in TRAINER_BATTLE_MACROS ->
              trainerBattleMacro(TRAINER_BATTLE_MACROS.getValue(name), args, texts, worklist)
        }

        val target =
            when {
              name in BRANCH_FIRST_ARG -> args.firstOrNull()
              name in BRANCH_LAST_ARG -> args.lastOrNull()
              else -> null
            }
        if (target != null) stream.positionOf(target)?.let { worklist.add(it) }

        if (name in STOPS) break
        index++
      }
    }
    return texts
  }

  private fun trainerBattle(
      type: Int,
      pointers: List<String>,
      texts: MutableList<String>,
      worklist: ArrayDeque<Int>,
  ) {
    val textCount = ScriptOpcodes.TRAINER_BATTLE_TEXTS[type]
    for (i in 0 until textCount) texts.add(pointers.getOrElse(i) { UNKNOWN })
    for (i in textCount until ScriptOpcodes.TRAINER_BATTLE_POINTERS[type]) {
      val script = pointers.getOrNull(i) ?: continue
      stream.positionOf(script)?.let { worklist.add(it) }
    }
  }

  private fun trainerBattleMacro(
      shape: TrainerBattleMacro,
      args: List<String>,
      texts: MutableList<String>,
      worklist: ArrayDeque<Int>,
  ) {
    for (i in 0 until shape.textCount) texts.add(args.getOrElse(shape.firstText + i) { UNKNOWN })
    val script = shape.eventScript?.let { args.getOrNull(it) } ?: return
    // The optional event script argument is what turns the macro into a CONTINUE_SCRIPT battle,
    // which is the only form carrying a pointer past its texts.
    if (script == "FALSE" || script == "0") return
    stream.positionOf(script)?.let { worklist.add(it) }
  }

  private companion object {
    const val STEP_LIMIT = 20_000

    /** Stands in for a macro argument the source left out, so slot counts still line up. */
    const val UNKNOWN = "?"

    /** Macros whose first argument is a text label. */
    val TEXT_FIRST_ARG =
        setOf(
            "msgbox",
            "message",
            "messageautoscroll",
            "vmessage",
            "vbuffermessage",
            "braillemessage",
            "getbraillestringwidth",
            "loadhelp",
            "msgreceiveditem",
            "giveitem_msg",
        )

    /** Macros whose second argument is a text label. */
    val TEXT_SECOND_ARG = setOf("bufferstring", "vbufferstring")

    /** Branch macros naming their destination first. */
    val BRANCH_FIRST_ARG = setOf("goto", "call", "vgoto", "vcall")

    /** Branch macros naming their destination last, after the condition they test. */
    val BRANCH_LAST_ARG =
        setOf(
            "goto_if",
            "call_if",
            "vgoto_if",
            "vcall_if",
            "goto_if_unset",
            "goto_if_set",
            "call_if_unset",
            "call_if_set",
            "goto_if_lt",
            "goto_if_eq",
            "goto_if_gt",
            "goto_if_le",
            "goto_if_ge",
            "goto_if_ne",
            "call_if_lt",
            "call_if_eq",
            "call_if_gt",
            "call_if_le",
            "call_if_ge",
            "call_if_ne",
            "vgoto_if_eq",
            "vgoto_if_ne",
            "vgoto_if_set",
            "vgoto_if_unset",
            "goto_if_defeated",
            "goto_if_not_defeated",
            "call_if_defeated",
            "call_if_not_defeated",
            "case",
            "goto_if_questlog",
            "trycompare",
        )

    /** Commands after which execution does not fall through, plus the end of a source file. */
    val STOPS =
        setOf(
            "end",
            "return",
            "goto",
            "gotostd",
            "returnram",
            "endram",
            "vgoto",
            DecompScriptStream.END_OF_FILE,
        )

    /** `trainerbattle` type constants in opcode order. */
    val TRAINER_BATTLE_TYPES =
        listOf(
            "TRAINER_BATTLE_SINGLE",
            "TRAINER_BATTLE_CONTINUE_SCRIPT_NO_MUSIC",
            "TRAINER_BATTLE_CONTINUE_SCRIPT",
            "TRAINER_BATTLE_SINGLE_NO_INTRO_TEXT",
            "TRAINER_BATTLE_DOUBLE",
            "TRAINER_BATTLE_REMATCH",
            "TRAINER_BATTLE_CONTINUE_SCRIPT_DOUBLE",
            "TRAINER_BATTLE_REMATCH_DOUBLE",
            "TRAINER_BATTLE_CONTINUE_SCRIPT_DOUBLE_NO_MUSIC",
            "TRAINER_BATTLE_EARLY_RIVAL",
        )

    /**
     * The shorthand macros, which pick their `trainerbattle` type from their own arguments rather
     * than naming it, so their slots are described directly: where the texts start, how many there
     * are, and which argument (if any) is the event script to branch into.
     */
    val TRAINER_BATTLE_MACROS =
        mapOf(
            "trainerbattle_single" to TrainerBattleMacro(1, 2, eventScript = 3),
            "trainerbattle_double" to TrainerBattleMacro(1, 3, eventScript = 4),
            "trainerbattle_rematch" to TrainerBattleMacro(1, 2),
            "trainerbattle_rematch_double" to TrainerBattleMacro(1, 3),
            "trainerbattle_no_intro" to TrainerBattleMacro(1, 1),
            "trainerbattle_earlyrival" to TrainerBattleMacro(2, 2),
        )
  }
}
