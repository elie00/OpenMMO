package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REPEL
 * end
 * ```
 */
internal object GraniteCave_B2F_EventScript_ItemRepel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REPEL, HoennFlags.FLAG_ITEM_GRANITE_CAVE_B2F_REPEL, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object GraniteCave_B2F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.RARE_CANDY, HoennFlags.FLAG_ITEM_GRANITE_CAVE_B2F_RARE_CANDY, 1)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_unset FLAG_BADGE03_GET, EventScript_CantSmashRock
 * checkpartymove MOVE_ROCK_SMASH
 * goto_if_eq VAR_RESULT, PARTY_SIZE, EventScript_CantSmashRock
 * setfieldeffectargument 0, VAR_RESULT
 * bufferpartymonnick STR_VAR_1, VAR_RESULT
 * buffermovename STR_VAR_2, MOVE_ROCK_SMASH
 * msgbox Text_WantToSmash, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_CancelSmash
 * msgbox Text_MonUsedFieldMove, MSGBOX_DEFAULT
 * closemessage
 * dofieldeffect FLDEFF_USE_ROCK_SMASH
 * waitstate
 * goto EventScript_SmashRock
 * end
 * ```
 */
internal object EventScript_RockSmash : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RockSmash")
}

internal val GraniteCave_B2FScripts: Map<String, Script> =
    mapOf(
        "GraniteCave_B2F_EventScript_ItemRepel" to GraniteCave_B2F_EventScript_ItemRepel,
        "GraniteCave_B2F_EventScript_ItemRareCandy" to GraniteCave_B2F_EventScript_ItemRareCandy,
        "EventScript_RockSmash" to EventScript_RockSmash,
    )
