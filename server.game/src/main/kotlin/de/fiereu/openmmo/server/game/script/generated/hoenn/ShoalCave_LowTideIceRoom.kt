package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM_HAIL
 * end
 * ```
 */
internal object ShoalCave_LowTideIceRoom_EventScript_ItemTMHail : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ShoalCave_LowTideIceRoom_EventScript_ItemTMHail")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NEVER_MELT_ICE
 * end
 * ```
 */
internal object ShoalCave_LowTideIceRoom_EventScript_ItemNeverMeltIce : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NEVER_MELT_ICE, HoennFlags.FLAG_ITEM_SHOAL_CAVE_ICE_ROOM_NEVER_MELT_ICE, 1)
  }
}

internal val ShoalCave_LowTideIceRoomScripts: Map<String, Script> =
    mapOf(
        "ShoalCave_LowTideIceRoom_EventScript_ItemTMHail" to
            ShoalCave_LowTideIceRoom_EventScript_ItemTMHail,
        "ShoalCave_LowTideIceRoom_EventScript_ItemNeverMeltIce" to
            ShoalCave_LowTideIceRoom_EventScript_ItemNeverMeltIce,
    )
