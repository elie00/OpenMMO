package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_WATER_STONE
 * end
 * ```
 */
internal object SeafoamIslands_B1F_EventScript_ItemWaterStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.WATER_STONE, KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B1F_WATER_STONE, 2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVE
 * end
 * ```
 */
internal object SeafoamIslands_B1F_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVE, KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B1F_REVIVE, 3)
  }
}

internal val SeafoamIslands_B1FScripts: Map<String, Script> =
    mapOf(
        "SeafoamIslands_B1F_EventScript_ItemWaterStone" to
            SeafoamIslands_B1F_EventScript_ItemWaterStone,
        "SeafoamIslands_B1F_EventScript_ItemRevive" to SeafoamIslands_B1F_EventScript_ItemRevive,
    )
