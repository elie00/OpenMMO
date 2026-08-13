package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object FiveIsland_LostCave_Room10_EventScript_ItemSilkScarf : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.SILK_SCARF)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_FIVE_ISLAND_LOST_CAVE_ROOM10_SILK_SCARF)
  }
}

internal val FiveIsland_LostCave_Room10Scripts: Map<String, Script> =
    mapOf(
        "FiveIsland_LostCave_Room10_EventScript_ItemSilkScarf" to
            FiveIsland_LostCave_Room10_EventScript_ItemSilkScarf,
    )
