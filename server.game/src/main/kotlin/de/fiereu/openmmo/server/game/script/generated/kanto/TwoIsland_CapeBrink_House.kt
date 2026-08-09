package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * goto_if_set FLAG_LEARNED_ALL_MOVES_AT_CAPE_BRINK, CapeBrinkTutor_EventScript_TaughtAllMoves
 * goto_if_set FLAG_TEMP_2, CapeBrinkTutor_EventScript_MoveJustTaught
 * bufferleadmonspeciesname STR_VAR_1
 * msgbox Text_UltimateMoveThatMon
 * specialvar VAR_RESULT, CapeBrinkGetMoveToTeachLeadPokemon
 * goto_if_eq VAR_RESULT, FALSE, CapeBrinkTutor_EventScript_NoLeadStarter
 * copyvar VAR_0x8009, VAR_0x8005
 * call_if_eq VAR_FACING, DIR_NORTH, CapeBrinkTutor_EventScript_JumpInPlaceDown
 * call_if_eq VAR_FACING, DIR_SOUTH, CapeBrinkTutor_EventScript_JumpInPlaceUp
 * call_if_eq VAR_FACING, DIR_EAST, CapeBrinkTutor_EventScript_JumpInPlaceLeft
 * call_if_eq VAR_FACING, DIR_WEST, CapeBrinkTutor_EventScript_JumpInPlaceRight
 * msgbox Text_AllowMeToTeachMonUltimateMove, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CapeBrinkTutor_EventScript_DeclineMove
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, CapeBrinkTutor_EventScript_DeclineMove
 * msgbox Text_LetMeConferUltimateMove
 * closemessage
 * fadescreen FADE_TO_BLACK
 * goto CapeBrinkTutor_EventScript_ChooseMon
 * ```
 */
internal object TwoIsland_CapeBrink_House_EventScript_StarterTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_CapeBrink_House_EventScript_StarterTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_JustMistaken
 * release
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_NoLeadStarter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_NoLeadStarter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_YouRejectIt
 * release
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_DeclineMove : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CapeBrinkTutor_EventScript_DeclineMove")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MakeBestUseOfMove
 * release
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_MoveJustTaught : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_MoveJustTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, CapeBrinkTutor_EventScript_DeclineMove
 * goto CapeBrinkTutor_EventScript_TaughtMove
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_ChooseMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CapeBrinkTutor_EventScript_ChooseMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_CAPE_BRINK_TUTOR, Movement_JumpInPlaceUp
 * waitmovement 0
 * return
 * ```
 */
internal object CapeBrinkTutor_EventScript_JumpInPlaceUp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_JumpInPlaceUp")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_CAPE_BRINK_TUTOR, Movement_JumpInPlaceDown
 * waitmovement 0
 * return
 * ```
 */
internal object CapeBrinkTutor_EventScript_JumpInPlaceDown : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_JumpInPlaceDown")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_CAPE_BRINK_TUTOR, Movement_JumpInPlaceLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CapeBrinkTutor_EventScript_JumpInPlaceLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_JumpInPlaceLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_FeelRejuvenated
 * release
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_TaughtAllMoves : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_TaughtAllMoves")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_CAPE_BRINK_TUTOR, Movement_JumpInPlaceRight
 * waitmovement 0
 * return
 * ```
 */
internal object CapeBrinkTutor_EventScript_JumpInPlaceRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_JumpInPlaceRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_0x8005, VAR_0x8009
 * specialvar VAR_RESULT, HasLearnedAllMovesFromCapeBrinkTutor
 * goto_if_eq VAR_RESULT, TRUE, CapeBrinkTutor_EventScript_LearnedAllMoves
 * msgbox Text_TaughtMove
 * setflag FLAG_TEMP_2
 * release
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_TaughtMove : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CapeBrinkTutor_EventScript_TaughtMove")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_PassedOnEverythingIKnow
 * setflag FLAG_LEARNED_ALL_MOVES_AT_CAPE_BRINK
 * release
 * end
 * ```
 */
internal object CapeBrinkTutor_EventScript_LearnedAllMoves : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CapeBrinkTutor_EventScript_LearnedAllMoves")
}

internal val TwoIsland_CapeBrink_HouseScripts: Map<String, Script> =
    mapOf(
        "TwoIsland_CapeBrink_House_EventScript_StarterTutor" to
            TwoIsland_CapeBrink_House_EventScript_StarterTutor,
        "CapeBrinkTutor_EventScript_NoLeadStarter" to CapeBrinkTutor_EventScript_NoLeadStarter,
        "CapeBrinkTutor_EventScript_DeclineMove" to CapeBrinkTutor_EventScript_DeclineMove,
        "CapeBrinkTutor_EventScript_MoveJustTaught" to CapeBrinkTutor_EventScript_MoveJustTaught,
        "CapeBrinkTutor_EventScript_ChooseMon" to CapeBrinkTutor_EventScript_ChooseMon,
        "CapeBrinkTutor_EventScript_JumpInPlaceUp" to CapeBrinkTutor_EventScript_JumpInPlaceUp,
        "CapeBrinkTutor_EventScript_JumpInPlaceDown" to CapeBrinkTutor_EventScript_JumpInPlaceDown,
        "CapeBrinkTutor_EventScript_JumpInPlaceLeft" to CapeBrinkTutor_EventScript_JumpInPlaceLeft,
        "CapeBrinkTutor_EventScript_TaughtAllMoves" to CapeBrinkTutor_EventScript_TaughtAllMoves,
        "CapeBrinkTutor_EventScript_JumpInPlaceRight" to
            CapeBrinkTutor_EventScript_JumpInPlaceRight,
        "CapeBrinkTutor_EventScript_TaughtMove" to CapeBrinkTutor_EventScript_TaughtMove,
        "CapeBrinkTutor_EventScript_LearnedAllMoves" to CapeBrinkTutor_EventScript_LearnedAllMoves,
    )
