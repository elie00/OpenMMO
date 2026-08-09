package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FallarborTown_MoveRelearnersHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_MOVE_RELEARNER, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_set FLAG_TEMP_1, FallarborTown_MoveRelearnersHouse_EventScript_AskTeachMove
 * msgbox FallarborTown_MoveRelearnersHouse_Text_ImTheMoveTutor, MSGBOX_DEFAULT
 * setflag FLAG_TEMP_1
 * goto FallarborTown_MoveRelearnersHouse_EventScript_AskTeachMove
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_MoveRelearner : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_MoveRelearnersHouse_EventScript_MoveRelearner")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_HEART_SCALE
 * goto_if_eq VAR_RESULT, FALSE, FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale
 * msgbox FallarborTown_MoveRelearnersHouse_Text_ThatsAHeartScaleWantMeToTeachMove, MSGBOX_YESNO
 * switch VAR_RESULT
 * case NO, FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale
 * goto FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_AskTeachMove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_MoveRelearnersHouse_EventScript_AskTeachMove")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FallarborTown_MoveRelearnersHouse_Text_TutorWhichMon, MSGBOX_DEFAULT
 * special ChooseMonForMoveRelearner
 * goto_if_eq VAR_0x8004, PARTY_NOTHING_CHOSEN, FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale
 * special IsSelectedMonEgg
 * goto_if_eq VAR_RESULT, TRUE, FallarborTown_MoveRelearnersHouse_EventScript_CantTeachEgg
 * goto_if_eq VAR_0x8005, 0, FallarborTown_MoveRelearnersHouse_EventScript_NoMoveToTeachMon
 * goto FallarborTown_MoveRelearnersHouse_EventScript_ChooseMove
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_MoveRelearnersHouse_Text_ComeBackWithHeartScale, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown_MoveRelearnersHouse.ComeBackWithHeartScale)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_MoveRelearnersHouse_Text_CantTeachEgg, MSGBOX_DEFAULT
 * goto FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_CantTeachEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown_MoveRelearnersHouse.CantTeachEgg)
    return FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FallarborTown_MoveRelearnersHouse_Text_TeachWhichMove, MSGBOX_DEFAULT
 * special TeachMoveRelearnerMove
 * goto_if_eq VAR_0x8004, 0, FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon
 * msgbox FallarborTown_MoveRelearnersHouse_Text_HandedOverHeartScale, MSGBOX_DEFAULT
 * removeitem ITEM_HEART_SCALE
 * goto FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_ChooseMove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_MoveRelearnersHouse_EventScript_ChooseMove")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_MoveRelearnersHouse_Text_DontHaveMoveToTeachPokemon, MSGBOX_DEFAULT
 * goto FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon
 * end
 * ```
 */
internal object FallarborTown_MoveRelearnersHouse_EventScript_NoMoveToTeachMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown_MoveRelearnersHouse.DontHaveMoveToTeachPokemon)
    return FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon.run(ctx)
  }
}

internal val FallarborTown_MoveRelearnersHouseScripts: Map<String, Script> =
    mapOf(
        "FallarborTown_MoveRelearnersHouse_EventScript_MoveRelearner" to
            FallarborTown_MoveRelearnersHouse_EventScript_MoveRelearner,
        "FallarborTown_MoveRelearnersHouse_EventScript_AskTeachMove" to
            FallarborTown_MoveRelearnersHouse_EventScript_AskTeachMove,
        "FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon" to
            FallarborTown_MoveRelearnersHouse_EventScript_ChooseMon,
        "FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale" to
            FallarborTown_MoveRelearnersHouse_EventScript_ComeBackWithHeartScale,
        "FallarborTown_MoveRelearnersHouse_EventScript_CantTeachEgg" to
            FallarborTown_MoveRelearnersHouse_EventScript_CantTeachEgg,
        "FallarborTown_MoveRelearnersHouse_EventScript_ChooseMove" to
            FallarborTown_MoveRelearnersHouse_EventScript_ChooseMove,
        "FallarborTown_MoveRelearnersHouse_EventScript_NoMoveToTeachMon" to
            FallarborTown_MoveRelearnersHouse_EventScript_NoMoveToTeachMon,
    )
