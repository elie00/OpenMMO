package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route110_TrickHousePuzzle5
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_MECHADOLL_1, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_TEMP_1, 1, Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough
 * setvar VAR_TEMP_9, 0
 * goto Route110_TrickHousePuzzle5_EventScript_Mechadoll1Activate
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_MECHADOLL_2, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_TEMP_2, 1, Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough
 * setvar VAR_TEMP_9, 0
 * goto Route110_TrickHousePuzzle5_EventScript_Mechadoll2Activate
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_MECHADOLL_3, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_TEMP_3, 1, Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough
 * setvar VAR_TEMP_9, 0
 * goto Route110_TrickHousePuzzle5_EventScript_Mechadoll3Activate
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_MECHADOLL_4, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_TEMP_4, 1, Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough
 * setvar VAR_TEMP_9, 0
 * goto Route110_TrickHousePuzzle5_EventScript_Mechadoll4Activate
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_MECHADOLL_5, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_TEMP_5, 1, Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough
 * setvar VAR_TEMP_9, 0
 * goto Route110_TrickHousePuzzle5_EventScript_Mechadoll5Activate
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_eq VAR_TRICK_HOUSE_PUZZLE_5_STATE, 0, Route110_TrickHousePuzzle5_EventScript_FoundScroll
 * goto Route110_TrickHousePuzzle_EventScript_ReadScrollAgain
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Scroll : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_TRICK_HOUSE_PUZZLE_5_STATE) == 0)
        return Route110_TrickHousePuzzle5_EventScript_FoundScroll.run(ctx)
    return Route110_TrickHousePuzzle_EventScript_ReadScrollAgain.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, 1
 * setvar VAR_TEMP_8, LOCALID_MECHADOLL_1
 * playse SE_PIN
 * applymovement LOCALID_MECHADOLL_1, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_MECHADOLL_1, Common_Movement_Delay48
 * waitmovement 0
 * call_if_eq VAR_TEMP_9, 1, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1
 * call_if_eq VAR_TEMP_9, 2, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2
 * call_if_eq VAR_TEMP_9, 3, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3
 * call_if_eq VAR_TEMP_9, 4, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4
 * msgbox Route110_TrickHousePuzzle5_Text_Mechadoll1Intro, MSGBOX_DEFAULT
 * random 3
 * switch VAR_RESULT
 * case 0, Route110_TrickHousePuzzle5_EventScript_Mechadoll1Quiz1
 * case 1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1Quiz2
 * case 2, Route110_TrickHousePuzzle5_EventScript_Mechadoll1Quiz3
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1Activate : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1Activate")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route110_TrickHousePuzzle5_Text_CorrectGoThrough, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route110_TrickHousePuzzle5.CorrectGoThrough)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_4, 1
 * setvar VAR_TEMP_8, LOCALID_MECHADOLL_4
 * playse SE_PIN
 * applymovement LOCALID_MECHADOLL_4, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_MECHADOLL_4, Common_Movement_Delay48
 * waitmovement 0
 * call_if_eq VAR_TEMP_9, 1, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1
 * call_if_eq VAR_TEMP_9, 2, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2
 * call_if_eq VAR_TEMP_9, 3, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3
 * call_if_eq VAR_TEMP_9, 4, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4
 * msgbox Route110_TrickHousePuzzle5_Text_Mechadoll4Intro, MSGBOX_DEFAULT
 * random 3
 * switch VAR_RESULT
 * case 0, Route110_TrickHousePuzzle5_EventScript_Mechadoll4Quiz1
 * case 1, Route110_TrickHousePuzzle5_EventScript_Mechadoll4Quiz2
 * case 2, Route110_TrickHousePuzzle5_EventScript_Mechadoll4Quiz3
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4Activate : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4Activate")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_3, 1
 * setvar VAR_TEMP_8, LOCALID_MECHADOLL_3
 * playse SE_PIN
 * applymovement LOCALID_MECHADOLL_3, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_MECHADOLL_3, Common_Movement_Delay48
 * waitmovement 0
 * call_if_eq VAR_TEMP_9, 1, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1
 * call_if_eq VAR_TEMP_9, 2, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2
 * call_if_eq VAR_TEMP_9, 3, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3
 * call_if_eq VAR_TEMP_9, 4, Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4
 * msgbox Route110_TrickHousePuzzle5_Text_Mechadoll3Intro, MSGBOX_DEFAULT
 * random 3
 * switch VAR_RESULT
 * case 0, Route110_TrickHousePuzzle5_EventScript_Mechadoll3Quiz1
 * case 1, Route110_TrickHousePuzzle5_EventScript_Mechadoll3Quiz2
 * case 2, Route110_TrickHousePuzzle5_EventScript_Mechadoll3Quiz3
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3Activate : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3Activate")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_TRICK_HOUSE_PUZZLE_5_STATE, 1
 * goto Route110_TrickHousePuzzle_EventScript_FoundScroll
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_FoundScroll : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_TRICK_HOUSE_PUZZLE_5_STATE, 1)
    return Route110_TrickHousePuzzle_EventScript_FoundScroll.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_2, 1
 * setvar VAR_TEMP_8, LOCALID_MECHADOLL_2
 * playse SE_PIN
 * applymovement LOCALID_MECHADOLL_2, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_MECHADOLL_2, Common_Movement_Delay48
 * waitmovement 0
 * call_if_eq VAR_TEMP_9, 1, Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight1
 * call_if_eq VAR_TEMP_9, 2, Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight2
 * call_if_eq VAR_TEMP_9, 3, Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight3
 * call_if_eq VAR_TEMP_9, 4, Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight4
 * call_if_eq VAR_TEMP_9, 5, Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight5
 * msgbox Route110_TrickHousePuzzle5_Text_Mechadoll2Intro, MSGBOX_DEFAULT
 * random 3
 * switch VAR_RESULT
 * case 0, Route110_TrickHousePuzzle5_EventScript_Mechadoll2Quiz1
 * case 1, Route110_TrickHousePuzzle5_EventScript_Mechadoll2Quiz2
 * case 2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2Quiz3
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2Activate : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2Activate")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_5, 1
 * setvar VAR_TEMP_8, LOCALID_MECHADOLL_5
 * playse SE_PIN
 * applymovement LOCALID_MECHADOLL_5, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_MECHADOLL_5, Common_Movement_Delay48
 * waitmovement 0
 * msgbox Route110_TrickHousePuzzle5_Text_Mechadoll5Intro, MSGBOX_DEFAULT
 * random 3
 * switch VAR_RESULT
 * case 0, Route110_TrickHousePuzzle5_EventScript_Mechadoll5Quiz1
 * case 1, Route110_TrickHousePuzzle5_EventScript_Mechadoll5Quiz2
 * case 2, Route110_TrickHousePuzzle5_EventScript_Mechadoll5Quiz3
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5Activate : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5Activate")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight5
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight5
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight5
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight5
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight5
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight3
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight4
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft4
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft4
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft2
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight1
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft3
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft3
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight2
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight2
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft1
 * call_if_eq VAR_TEMP_8, LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft1
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkLeft1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkLeft2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkLeft3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkLeft4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkRight2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkRight1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkRight4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkLeft4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkRight3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkRight5
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkLeft1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkLeft2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_4, Route110_TrickHousePuzzle5_Movement_WalkLeft3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkLeft3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkLeft2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkLeft4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkLeft1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkLeft2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkLeft1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkRight5
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkRight4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkLeft4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkLeft3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkRight1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkRight3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_3, Route110_TrickHousePuzzle5_Movement_WalkRight2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkRight1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkRight2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkRight3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkRight4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_2, Route110_TrickHousePuzzle5_Movement_WalkRight5
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkRight5
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkLeft2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkRight4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkLeft1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkRight3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkLeft4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkLeft3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkRight2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_1, Route110_TrickHousePuzzle5_Movement_WalkRight1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkRight4
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkRight5
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkRight2
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkRight3
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MECHADOLL_5, Route110_TrickHousePuzzle5_Movement_WalkRight1
 * waitmovement 0
 * return
 * ```
 */
internal object Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight1")
}

internal val Route110_TrickHousePuzzle5Scripts: Map<String, Script> =
    mapOf(
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5,
        "Route110_TrickHousePuzzle5_EventScript_Scroll" to
            Route110_TrickHousePuzzle5_EventScript_Scroll,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1Activate" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1Activate,
        "Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough" to
            Route110_TrickHousePuzzle5_EventScript_CorrectGoThrough,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4Activate" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4Activate,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3Activate" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3Activate,
        "Route110_TrickHousePuzzle5_EventScript_FoundScroll" to
            Route110_TrickHousePuzzle5_EventScript_FoundScroll,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2Activate" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2Activate,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5Activate" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5Activate,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight5" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight5,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight3" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight3,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight4" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight4,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft4,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft2,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight1" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight1,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft3,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight2" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkRight2,
        "Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1" to
            Route110_TrickHousePuzzle5_EventScript_MechadollWalkLeft1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkLeft4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight5" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkRight5,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll4WalkLeft3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkLeft1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight5" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight5,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkLeft3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll3WalkRight2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight5" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll2WalkRight5,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight5" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight5,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkLeft3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll1WalkRight1,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight4" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight4,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight5" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight5,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight2" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight2,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight3" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight3,
        "Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight1" to
            Route110_TrickHousePuzzle5_EventScript_Mechadoll5WalkRight1,
    )
