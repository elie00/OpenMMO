package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BIG_PEARL
 * end
 * ```
 */
internal object SeafoamIslands_B2F_EventScript_ItemBigPearl : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BIG_PEARL, KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B2F_BIG_PEARL, 2)
  }
}

internal val SeafoamIslands_B2FScripts: Map<String, Script> =
    mapOf(
        "SeafoamIslands_B2F_EventScript_ItemBigPearl" to
            SeafoamIslands_B2F_EventScript_ItemBigPearl,
    )
