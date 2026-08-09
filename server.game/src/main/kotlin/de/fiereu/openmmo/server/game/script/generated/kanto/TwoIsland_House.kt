package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.TwoIsland_House
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * clearflag HAS_BIG_MUSHROOM
 * clearflag HAS_TINY_MUSHROOMS
 * clearflag HAS_BOTH_MUSHROOMS
 * goto_if_set CHECKED_MUSHROOMS, TwoIsland_House_EventScript_CheckPlayerHasMushrooms
 * msgbox TwoIsland_House_Text_TeachMonMoveForMushroom
 * setflag CHECKED_MUSHROOMS
 * goto TwoIsland_House_EventScript_CheckPlayerHasMushrooms
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_MoveManiac : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_House_EventScript_MoveManiac")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_BIG_MUSHROOM
 * call_if_eq VAR_RESULT, TRUE, TwoIsland_House_EventScript_SetHasBigMushroom
 * checkitem ITEM_TINY_MUSHROOM, 2
 * call_if_eq VAR_RESULT, TRUE, TwoIsland_House_EventScript_SetHasTinyMushrooms
 * goto_if_set HAS_BIG_MUSHROOM, TwoIsland_House_EventScript_CheckAlsoHasTinyMushrooms
 * goto_if_set HAS_TINY_MUSHROOMS, TwoIsland_House_EventScript_CheckAlsoHasBigMushroom
 * goto TwoIsland_House_EventScript_EndTutorMove
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_CheckPlayerHasMushrooms : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_CheckPlayerHasMushrooms")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox TwoIsland_House_Text_NeedMushroomOrTwoToLearnMove
 * release
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_EndTutorMove : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TwoIsland_House.NeedMushroomOrTwoToLearnMove)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_set HAS_TINY_MUSHROOMS, TwoIsland_House_EventScript_SetHasBothMushrooms
 * goto TwoIsland_House_EventScript_AskTutorMon
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_CheckAlsoHasTinyMushrooms : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_CheckAlsoHasTinyMushrooms")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag HAS_BIG_MUSHROOM
 * return
 * ```
 */
internal object TwoIsland_House_EventScript_SetHasBigMushroom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_SetHasBigMushroom")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag HAS_TINY_MUSHROOMS
 * return
 * ```
 */
internal object TwoIsland_House_EventScript_SetHasTinyMushrooms : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_SetHasTinyMushrooms")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_set HAS_BIG_MUSHROOM, TwoIsland_House_EventScript_SetHasBothMushrooms
 * goto TwoIsland_House_EventScript_AskTutorMon
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_CheckAlsoHasBigMushroom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_CheckAlsoHasBigMushroom")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag HAS_BOTH_MUSHROOMS
 * return
 * ```
 */
internal object TwoIsland_House_EventScript_SetHasBothMushrooms : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_SetHasBothMushrooms")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox TwoIsland_House_Text_WantMeToTeachMove, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, TwoIsland_House_EventScript_EndTutorMove
 * goto TwoIsland_House_EventScript_ChooseMonToTutor
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_AskTutorMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_AskTutorMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox TwoIsland_House_Text_TutorWhichMon
 * special ChooseMonForMoveRelearner
 * waitstate
 * goto_if_ge VAR_0x8004, PARTY_SIZE, TwoIsland_House_EventScript_EndTutorMove
 * special IsSelectedMonEgg
 * goto_if_eq VAR_RESULT, TRUE, TwoIsland_House_EventScript_CantTutorEgg
 * goto_if_eq VAR_0x8005, 0, TwoIsland_House_EventScript_NoMoveToTutorMon
 * goto TwoIsland_House_EventScript_ChooseMoveToTeach
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_ChooseMonToTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_ChooseMonToTutor")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox TwoIsland_House_Text_CantTeachAnEgg
 * goto TwoIsland_House_EventScript_ChooseMonToTutor
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_CantTutorEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TwoIsland_House.CantTeachAnEgg)
    return TwoIsland_House_EventScript_ChooseMonToTutor.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox TwoIsland_House_Text_NoMoveICanTeachThatMon
 * goto TwoIsland_House_EventScript_ChooseMonToTutor
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_NoMoveToTutorMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TwoIsland_House.NoMoveICanTeachThatMon)
    return TwoIsland_House_EventScript_ChooseMonToTutor.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox TwoIsland_House_Text_TeachWhichMove
 * special TeachMoveRelearnerMove
 * waitstate
 * goto_if_eq VAR_0x8004, 0, TwoIsland_House_EventScript_ChooseMonToTutor
 * goto_if_set HAS_BOTH_MUSHROOMS, TwoIsland_House_EventScript_ChooseMushroom
 * goto_if_set HAS_BIG_MUSHROOM, TwoIsland_House_EventScript_GiveBigMushroom
 * goto_if_set HAS_TINY_MUSHROOMS, TwoIsland_House_EventScript_GiveTinyMushrooms
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_ChooseMoveToTeach : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_ChooseMoveToTeach")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message TwoIsland_House_Text_IllNeedMushroomOrTwo
 * waitmessage
 * multichoice 0, 0, MULTICHOICE_MUSHROOMS, TRUE
 * switch VAR_RESULT
 * case 0, TwoIsland_House_EventScript_GiveTinyMushrooms
 * case 1, TwoIsland_House_EventScript_GiveBigMushroom
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_ChooseMushroom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_ChooseMushroom")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removeitem ITEM_TINY_MUSHROOM, 2
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox TwoIsland_House_Text_HandedOverTwoTinyMushrooms
 * call EventScript_RestorePrevTextColor
 * goto TwoIsland_House_EventScript_EndTutorMove
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_GiveTinyMushrooms : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_GiveTinyMushrooms")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removeitem ITEM_BIG_MUSHROOM
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox TwoIsland_House_Text_HandedOverOneBigMushroom
 * call EventScript_RestorePrevTextColor
 * goto TwoIsland_House_EventScript_EndTutorMove
 * end
 * ```
 */
internal object TwoIsland_House_EventScript_GiveBigMushroom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_House_EventScript_GiveBigMushroom")
}

internal val TwoIsland_HouseScripts: Map<String, Script> =
    mapOf(
        "TwoIsland_House_EventScript_MoveManiac" to TwoIsland_House_EventScript_MoveManiac,
        "TwoIsland_House_EventScript_CheckPlayerHasMushrooms" to
            TwoIsland_House_EventScript_CheckPlayerHasMushrooms,
        "TwoIsland_House_EventScript_EndTutorMove" to TwoIsland_House_EventScript_EndTutorMove,
        "TwoIsland_House_EventScript_CheckAlsoHasTinyMushrooms" to
            TwoIsland_House_EventScript_CheckAlsoHasTinyMushrooms,
        "TwoIsland_House_EventScript_SetHasBigMushroom" to
            TwoIsland_House_EventScript_SetHasBigMushroom,
        "TwoIsland_House_EventScript_SetHasTinyMushrooms" to
            TwoIsland_House_EventScript_SetHasTinyMushrooms,
        "TwoIsland_House_EventScript_CheckAlsoHasBigMushroom" to
            TwoIsland_House_EventScript_CheckAlsoHasBigMushroom,
        "TwoIsland_House_EventScript_SetHasBothMushrooms" to
            TwoIsland_House_EventScript_SetHasBothMushrooms,
        "TwoIsland_House_EventScript_AskTutorMon" to TwoIsland_House_EventScript_AskTutorMon,
        "TwoIsland_House_EventScript_ChooseMonToTutor" to
            TwoIsland_House_EventScript_ChooseMonToTutor,
        "TwoIsland_House_EventScript_CantTutorEgg" to TwoIsland_House_EventScript_CantTutorEgg,
        "TwoIsland_House_EventScript_NoMoveToTutorMon" to
            TwoIsland_House_EventScript_NoMoveToTutorMon,
        "TwoIsland_House_EventScript_ChooseMoveToTeach" to
            TwoIsland_House_EventScript_ChooseMoveToTeach,
        "TwoIsland_House_EventScript_ChooseMushroom" to TwoIsland_House_EventScript_ChooseMushroom,
        "TwoIsland_House_EventScript_GiveTinyMushrooms" to
            TwoIsland_House_EventScript_GiveTinyMushrooms,
        "TwoIsland_House_EventScript_GiveBigMushroom" to
            TwoIsland_House_EventScript_GiveBigMushroom,
    )
