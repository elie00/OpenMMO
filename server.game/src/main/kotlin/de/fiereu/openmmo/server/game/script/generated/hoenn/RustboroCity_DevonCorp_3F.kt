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
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_DevonCorp_3F_Text_RepeatAndTimerHugelyPopular, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_3F_EventScript_EmployeeBalls")
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
    )
