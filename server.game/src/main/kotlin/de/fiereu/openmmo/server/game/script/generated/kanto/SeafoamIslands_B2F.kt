package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object SeafoamIslands_B2F_EventScript_ItemBigPearl : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.BIG_PEARL)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B2F_BIG_PEARL)
  }
}

internal val SeafoamIslands_B2FScripts: Map<String, Script> =
    mapOf(
        "SeafoamIslands_B2F_EventScript_ItemBigPearl" to
            SeafoamIslands_B2F_EventScript_ItemBigPearl,
    )
