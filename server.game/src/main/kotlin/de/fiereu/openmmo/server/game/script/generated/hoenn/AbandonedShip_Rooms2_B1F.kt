package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip_Rooms2_B1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object AbandonedShip_Rooms2_B1F_EventScript_Camper : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(AbandonedShip_Rooms2_B1F.PerfectPlaceToGoExploring)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_DIVE_BALL
 * end
 * ```
 */
internal object AbandonedShip_Rooms2_B1F_EventScript_ItemDiveBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.DIVE_BALL, HoennFlags.FLAG_ITEM_ABANDONED_SHIP_ROOMS_2_B1F_DIVE_BALL, 1)
  }
}

internal val AbandonedShip_Rooms2_B1FScripts: Map<String, Script> =
    mapOf(
        "AbandonedShip_Rooms2_B1F_EventScript_Camper" to
            AbandonedShip_Rooms2_B1F_EventScript_Camper,
        "AbandonedShip_Rooms2_B1F_EventScript_ItemDiveBall" to
            AbandonedShip_Rooms2_B1F_EventScript_ItemDiveBall,
    )
