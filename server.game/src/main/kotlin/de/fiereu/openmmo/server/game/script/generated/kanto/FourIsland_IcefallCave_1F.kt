package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ULTRA_BALL
 * end
 * ```
 */
internal object FourIsland_IcefallCave_1F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ULTRA_BALL, KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_1F_ULTRA_BALL, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HM07
 * end
 * ```
 */
internal object FourIsland_IcefallCave_1F_EventScript_ItemHM07 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HM07, KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_1F_HM07, 1)
  }
}

internal val FourIsland_IcefallCave_1FScripts: Map<String, Script> =
    mapOf(
        "FourIsland_IcefallCave_1F_EventScript_ItemUltraBall" to
            FourIsland_IcefallCave_1F_EventScript_ItemUltraBall,
        "FourIsland_IcefallCave_1F_EventScript_ItemHM07" to
            FourIsland_IcefallCave_1F_EventScript_ItemHM07,
    )
