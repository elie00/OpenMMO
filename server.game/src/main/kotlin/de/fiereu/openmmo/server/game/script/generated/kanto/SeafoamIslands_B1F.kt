package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object SeafoamIslands_B1F_EventScript_ItemWaterStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.WATER_STONE)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B1F_WATER_STONE)
  }
}

internal object SeafoamIslands_B1F_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.REVIVE)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B1F_REVIVE)
  }
}

internal val SeafoamIslands_B1FScripts: Map<String, Script> =
    mapOf(
        "SeafoamIslands_B1F_EventScript_ItemWaterStone" to
            SeafoamIslands_B1F_EventScript_ItemWaterStone,
        "SeafoamIslands_B1F_EventScript_ItemRevive" to SeafoamIslands_B1F_EventScript_ItemRevive,
    )
