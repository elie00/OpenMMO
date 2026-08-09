package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SafariZone_SecretHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_HM03, SafariZone_SecretHouse_EventScript_ExplainSurf
 * msgbox SafariZone_SecretHouse_Text_CongratsYouveWon
 * checkitemspace ITEM_HM03
 * goto_if_eq VAR_RESULT, FALSE, SafariZone_SecretHouse_EventScript_NoRoomForHM03
 * giveitem_msg SafariZone_SecretHouse_Text_ReceivedHM03FromAttendant, ITEM_HM03
 * msgbox SafariZone_SecretHouse_Text_ExplainSurf
 * setflag FLAG_GOT_HM03
 * release
 * end
 * ```
 */
internal object SafariZone_SecretHouse_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SafariZone_SecretHouse_EventScript_Attendant")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SafariZone_SecretHouse_Text_DontHaveRoomForPrize
 * release
 * end
 * ```
 */
internal object SafariZone_SecretHouse_EventScript_NoRoomForHM03 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SafariZone_SecretHouse.DontHaveRoomForPrize)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SafariZone_SecretHouse_Text_ExplainSurf
 * release
 * end
 * ```
 */
internal object SafariZone_SecretHouse_EventScript_ExplainSurf : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SafariZone_SecretHouse.ExplainSurf)
  }
}

internal val SafariZone_SecretHouseScripts: Map<String, Script> =
    mapOf(
        "SafariZone_SecretHouse_EventScript_Attendant" to
            SafariZone_SecretHouse_EventScript_Attendant,
        "SafariZone_SecretHouse_EventScript_NoRoomForHM03" to
            SafariZone_SecretHouse_EventScript_NoRoomForHM03,
        "SafariZone_SecretHouse_EventScript_ExplainSurf" to
            SafariZone_SecretHouse_EventScript_ExplainSurf,
    )
