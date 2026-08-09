package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.GraniteCave_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_HM_FLASH, GraniteCave_1F_EventScript_ReceivedFlash
 * msgbox GraniteCave_1F_Text_GetsDarkAheadHereYouGo, MSGBOX_DEFAULT
 * giveitem ITEM_HM_FLASH
 * setflag FLAG_RECEIVED_HM_FLASH
 * msgbox GraniteCave_1F_Text_ExplainFlash, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object GraniteCave_1F_EventScript_Hiker : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port GraniteCave_1F_EventScript_Hiker")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ESCAPE_ROPE
 * end
 * ```
 */
internal object GraniteCave_1F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ESCAPE_ROPE, HoennFlags.FLAG_ITEM_GRANITE_CAVE_1F_ESCAPE_ROPE, 1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox GraniteCave_1F_Text_ExplainFlash, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object GraniteCave_1F_EventScript_ReceivedFlash : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(GraniteCave_1F.ExplainFlash)
  }
}

internal val GraniteCave_1FScripts: Map<String, Script> =
    mapOf(
        "GraniteCave_1F_EventScript_Hiker" to GraniteCave_1F_EventScript_Hiker,
        "GraniteCave_1F_EventScript_ItemEscapeRope" to GraniteCave_1F_EventScript_ItemEscapeRope,
        "GraniteCave_1F_EventScript_ReceivedFlash" to GraniteCave_1F_EventScript_ReceivedFlash,
    )
