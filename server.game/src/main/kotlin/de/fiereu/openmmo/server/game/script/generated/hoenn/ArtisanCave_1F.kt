package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARBOS
 * end
 * ```
 */
internal object ArtisanCave_1F_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARBOS, HoennFlags.FLAG_ITEM_ARTISAN_CAVE_1F_CARBOS, 0)
  }
}

internal val ArtisanCave_1FScripts: Map<String, Script> =
    mapOf(
        "ArtisanCave_1F_EventScript_ItemCarbos" to ArtisanCave_1F_EventScript_ItemCarbos,
    )
