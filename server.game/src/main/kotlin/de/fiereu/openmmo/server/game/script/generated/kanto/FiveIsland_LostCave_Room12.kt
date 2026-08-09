package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SEA_INCENSE
 * end
 * ```
 */
internal object FiveIsland_LostCave_Room12_EventScript_ItemSeaIncense : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(
        Items.SEA_INCENSE, KantoFlags.FLAG_HIDE_FIVE_ISLAND_LOST_CAVE_ROOM12_SEA_INCENSE, 0)
  }
}

internal val FiveIsland_LostCave_Room12Scripts: Map<String, Script> =
    mapOf(
        "FiveIsland_LostCave_Room12_EventScript_ItemSeaIncense" to
            FiveIsland_LostCave_Room12_EventScript_ItemSeaIncense,
    )
