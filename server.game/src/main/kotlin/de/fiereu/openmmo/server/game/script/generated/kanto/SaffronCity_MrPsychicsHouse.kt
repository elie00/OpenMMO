package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_MrPsychicsHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_TM29_FROM_MR_PSYCHIC, SaffronCity_MrPsychicsHouse_EventScript_AlreadyGotTM29
 * msgbox SaffronCity_MrPsychicsHouse_Text_YouWantedThis
 * checkitemspace ITEM_TM29
 * goto_if_eq VAR_RESULT, FALSE, SaffronCity_MrPsychicsHouse_EventScript_NoRoomForTM29
 * giveitem_msg SaffronCity_MrPsychicsHouse_Text_ReceivedTM29FromMrPsychic, ITEM_TM29
 * msgbox SaffronCity_MrPsychicsHouse_Text_ExplainTM29
 * setflag FLAG_GOT_TM29_FROM_MR_PSYCHIC
 * release
 * end
 * ```
 */
internal object SaffronCity_MrPsychicsHouse_EventScript_MrPsychic : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_MrPsychicsHouse_EventScript_MrPsychic")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_MrPsychicsHouse_Text_YouveNoRoom
 * release
 * end
 * ```
 */
internal object SaffronCity_MrPsychicsHouse_EventScript_NoRoomForTM29 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_MrPsychicsHouse.YouveNoRoom)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_MrPsychicsHouse_Text_ExplainTM29
 * release
 * end
 * ```
 */
internal object SaffronCity_MrPsychicsHouse_EventScript_AlreadyGotTM29 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_MrPsychicsHouse.ExplainTM29)
  }
}

internal val SaffronCity_MrPsychicsHouseScripts: Map<String, Script> =
    mapOf(
        "SaffronCity_MrPsychicsHouse_EventScript_MrPsychic" to
            SaffronCity_MrPsychicsHouse_EventScript_MrPsychic,
        "SaffronCity_MrPsychicsHouse_EventScript_NoRoomForTM29" to
            SaffronCity_MrPsychicsHouse_EventScript_NoRoomForTM29,
        "SaffronCity_MrPsychicsHouse_EventScript_AlreadyGotTM29" to
            SaffronCity_MrPsychicsHouse_EventScript_AlreadyGotTM29,
    )
