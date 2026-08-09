package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object FiveIsland_LostCave_Room14_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.RARE_CANDY, KantoFlags.FLAG_HIDE_FIVE_ISLAND_LOST_CAVE_ROOM14_RARE_CANDY, 0)
  }
}

internal val FiveIsland_LostCave_Room14Scripts: Map<String, Script> =
    mapOf(
        "FiveIsland_LostCave_Room14_EventScript_ItemRareCandy" to
            FiveIsland_LostCave_Room14_EventScript_ItemRareCandy,
    )
