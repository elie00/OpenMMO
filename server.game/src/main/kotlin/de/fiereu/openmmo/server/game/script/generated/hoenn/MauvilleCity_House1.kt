package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MauvilleCity_House1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_HM_ROCK_SMASH, MauvilleCity_House1_EventScript_ReceivedRockSmash
 * msgbox MauvilleCity_House1_Text_ImRockSmashDudeTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_HM_ROCK_SMASH
 * setflag FLAG_RECEIVED_HM_ROCK_SMASH
 * setflag FLAG_HIDE_ROUTE_111_ROCK_SMASH_TIP_GUY
 * msgbox MauvilleCity_House1_Text_ExplainRockSmash, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_House1_EventScript_RockSmashDude : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_House1_EventScript_RockSmashDude")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_House1_Text_MonCanFlyOutOfSmashedRock, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_House1_EventScript_ReceivedRockSmash : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_House1.MonCanFlyOutOfSmashedRock)
  }
}

internal val MauvilleCity_House1Scripts: Map<String, Script> =
    mapOf(
        "MauvilleCity_House1_EventScript_RockSmashDude" to
            MauvilleCity_House1_EventScript_RockSmashDude,
        "MauvilleCity_House1_EventScript_ReceivedRockSmash" to
            MauvilleCity_House1_EventScript_ReceivedRockSmash,
    )
