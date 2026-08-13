package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object CeruleanCave_2F_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PP_UP)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_PP_UP)
  }
}

internal object CeruleanCave_2F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ULTRA_BALL)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_ULTRA_BALL)
  }
}

internal object CeruleanCave_2F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_RESTORE)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_FULL_RESTORE)
  }
}

internal val CeruleanCave_2FScripts: Map<String, Script> =
    mapOf(
        "CeruleanCave_2F_EventScript_ItemPPUp" to CeruleanCave_2F_EventScript_ItemPPUp,
        "CeruleanCave_2F_EventScript_ItemUltraBall" to CeruleanCave_2F_EventScript_ItemUltraBall,
        "CeruleanCave_2F_EventScript_ItemFullRestore" to
            CeruleanCave_2F_EventScript_ItemFullRestore,
    )
