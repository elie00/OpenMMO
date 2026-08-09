package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route111_OldLadysRestStop
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox Route111_OldLadysRestStop_Text_RestUpHere, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route111_OldLadysRestStop_EventScript_Rest
 * goto_if_eq VAR_RESULT, NO, Route111_OldLadysRestStop_EventScript_DeclineRest
 * end
 * ```
 */
internal object Route111_OldLadysRestStop_EventScript_OldLady : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_OldLadysRestStop_EventScript_OldLady")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route111_OldLadysRestStop_Text_DontNeedToBeShy, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route111_OldLadysRestStop_EventScript_DeclineRest : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route111_OldLadysRestStop.DontNeedToBeShy)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route111_OldLadysRestStop_Text_TakeYourTimeRestUp, MSGBOX_DEFAULT
 * closemessage
 * call Common_EventScript_OutOfCenterPartyHeal
 * msgbox Route111_OldLadysRestStop_Text_StillTiredTakeAnotherRest, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route111_OldLadysRestStop_EventScript_Rest
 * goto_if_eq VAR_RESULT, NO, Route111_OldLadysRestStop_EventScript_DeclineRest
 * end
 * ```
 */
internal object Route111_OldLadysRestStop_EventScript_Rest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_OldLadysRestStop_EventScript_Rest")
}

internal val Route111_OldLadysRestStopScripts: Map<String, Script> =
    mapOf(
        "Route111_OldLadysRestStop_EventScript_OldLady" to
            Route111_OldLadysRestStop_EventScript_OldLady,
        "Route111_OldLadysRestStop_EventScript_DeclineRest" to
            Route111_OldLadysRestStop_EventScript_DeclineRest,
        "Route111_OldLadysRestStop_EventScript_Rest" to Route111_OldLadysRestStop_EventScript_Rest,
    )
