package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object FiveIsland_LostCave_Room11_EventScript_ItemLaxIncense : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.LAX_INCENSE)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_FIVE_ISLAND_LOST_CAVE_ROOM11_LAX_INCENSE)
  }
}

internal val FiveIsland_LostCave_Room11Scripts: Map<String, Script> =
    mapOf(
        "FiveIsland_LostCave_Room11_EventScript_ItemLaxIncense" to
            FiveIsland_LostCave_Room11_EventScript_ItemLaxIncense,
    )
