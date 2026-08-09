package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ICE_HEAL
 * end
 * ```
 */
internal object SeafoamIslands_1F_EventScript_ItemIceHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ICE_HEAL, KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_1F_ICE_HEAL, 2)
  }
}

internal val SeafoamIslands_1FScripts: Map<String, Script> =
    mapOf(
        "SeafoamIslands_1F_EventScript_ItemIceHeal" to SeafoamIslands_1F_EventScript_ItemIceHeal,
    )
