package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object CeruleanCave_1F_EventScript_ItemNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.NUGGET)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_1F_NUGGET)
  }
}

internal object CeruleanCave_1F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_RESTORE)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_1F_FULL_RESTORE)
  }
}

internal object CeruleanCave_1F_EventScript_ItemMaxElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_ELIXIR)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_1F_MAX_ELIXIR)
  }
}

internal val CeruleanCave_1FScripts: Map<String, Script> =
    mapOf(
        "CeruleanCave_1F_EventScript_ItemNugget" to CeruleanCave_1F_EventScript_ItemNugget,
        "CeruleanCave_1F_EventScript_ItemFullRestore" to
            CeruleanCave_1F_EventScript_ItemFullRestore,
        "CeruleanCave_1F_EventScript_ItemMaxElixir" to CeruleanCave_1F_EventScript_ItemMaxElixir,
    )
