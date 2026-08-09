package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RustboroCity_DevonCorp_3F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_EXP_SHARE, RustboroCity_DevonCorp_3F_EventScript_MrStoneAfterFavor
 * goto_if_set FLAG_DELIVERED_STEVEN_LETTER, RustboroCity_DevonCorp_3F_EventScript_GiveExpShare
 * msgbox RustboroCity_DevonCorp_3F_Text_CountingOnYou, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_3F_EventScript_MrStone : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_3F_EventScript_MrStone")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_REPEAT_BALL, RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls
 * msgbox RustboroCity_DevonCorp_3F_Text_VisitCaptSternShipyard, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_3F_EventScript_Employee : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_REPEAT_BALL))
        return RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls.run(ctx)
    ctx.say(RustboroCity_DevonCorp_3F.VisitCaptSternShipyard)
  }
}

internal object RustboroCity_DevonCorp_3F_EventScript_RareRocksDisplay : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(RustboroCity_DevonCorp_3F.RareRocksDisplay)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_3F_Text_RepeatAndTimerHugelyPopular, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_3F.RepeatAndTimerHugelyPopular)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_3F_Text_NotFamiliarWithTrends, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_3F_EventScript_MrStoneAfterFavor : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_3F.NotFamiliarWithTrends)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_DevonCorp_3F_Text_ThankYouForDeliveringLetter, MSGBOX_DEFAULT
 * giveitem ITEM_EXP_SHARE
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_EXP_SHARE
 * msgbox RustboroCity_DevonCorp_3F_Text_ExplainExpShare, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_3F_EventScript_GiveExpShare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_3F_EventScript_GiveExpShare")
}

internal val RustboroCity_DevonCorp_3FScripts: Map<String, Script> =
    mapOf(
        "RustboroCity_DevonCorp_3F_EventScript_MrStone" to
            RustboroCity_DevonCorp_3F_EventScript_MrStone,
        "RustboroCity_DevonCorp_3F_EventScript_Employee" to
            RustboroCity_DevonCorp_3F_EventScript_Employee,
        "RustboroCity_DevonCorp_3F_EventScript_RareRocksDisplay" to
            RustboroCity_DevonCorp_3F_EventScript_RareRocksDisplay,
        "RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls" to
            RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls,
        "RustboroCity_DevonCorp_3F_EventScript_MrStoneAfterFavor" to
            RustboroCity_DevonCorp_3F_EventScript_MrStoneAfterFavor,
        "RustboroCity_DevonCorp_3F_EventScript_GiveExpShare" to
            RustboroCity_DevonCorp_3F_EventScript_GiveExpShare,
    )
