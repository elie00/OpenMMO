package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object FourIsland_IcefallCave_B1F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(
        Items.FULL_RESTORE, KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_B1F_FULL_RESTORE, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NEVER_MELT_ICE
 * end
 * ```
 */
internal object FourIsland_IcefallCave_B1F_EventScript_ItemNeverMeltIce : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(
        Items.NEVER_MELT_ICE, KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_B1F_NEVER_MELT_ICE, 1)
  }
}

internal val FourIsland_IcefallCave_B1FScripts: Map<String, Script> =
    mapOf(
        "FourIsland_IcefallCave_B1F_EventScript_ItemFullRestore" to
            FourIsland_IcefallCave_B1F_EventScript_ItemFullRestore,
        "FourIsland_IcefallCave_B1F_EventScript_ItemNeverMeltIce" to
            FourIsland_IcefallCave_B1F_EventScript_ItemNeverMeltIce,
    )
