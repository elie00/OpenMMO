package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object FourIsland_IcefallCave_B1F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_RESTORE)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_B1F_FULL_RESTORE)
  }
}

internal object FourIsland_IcefallCave_B1F_EventScript_ItemNeverMeltIce : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.NEVER_MELT_ICE)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_B1F_NEVER_MELT_ICE)
  }
}

internal val FourIsland_IcefallCave_B1FScripts: Map<String, Script> =
    mapOf(
        "FourIsland_IcefallCave_B1F_EventScript_ItemFullRestore" to
            FourIsland_IcefallCave_B1F_EventScript_ItemFullRestore,
        "FourIsland_IcefallCave_B1F_EventScript_ItemNeverMeltIce" to
            FourIsland_IcefallCave_B1F_EventScript_ItemNeverMeltIce,
    )
