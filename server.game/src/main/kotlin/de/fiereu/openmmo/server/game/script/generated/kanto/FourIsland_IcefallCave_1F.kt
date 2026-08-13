package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object FourIsland_IcefallCave_1F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ULTRA_BALL)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_1F_ULTRA_BALL)
  }
}

internal object FourIsland_IcefallCave_1F_EventScript_ItemHM07 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.HM07)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_FOUR_ISLAND_ICEFALL_CAVE_1F_HM07)
  }
}

internal val FourIsland_IcefallCave_1FScripts: Map<String, Script> =
    mapOf(
        "FourIsland_IcefallCave_1F_EventScript_ItemUltraBall" to
            FourIsland_IcefallCave_1F_EventScript_ItemUltraBall,
        "FourIsland_IcefallCave_1F_EventScript_ItemHM07" to
            FourIsland_IcefallCave_1F_EventScript_ItemHM07,
    )
