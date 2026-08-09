package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HP_UP
 * end
 * ```
 */
internal object ArtisanCave_B1F_EventScript_ItemHPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HP_UP, HoennFlags.FLAG_ITEM_ARTISAN_CAVE_B1F_HP_UP, 0)
  }
}

internal val ArtisanCave_B1FScripts: Map<String, Script> =
    mapOf(
        "ArtisanCave_B1F_EventScript_ItemHPUp" to ArtisanCave_B1F_EventScript_ItemHPUp,
    )
