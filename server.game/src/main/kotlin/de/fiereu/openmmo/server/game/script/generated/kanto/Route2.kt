package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route2
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

private const val LOCALID_ETHER_BALL = 4
private const val LOCALID_PARALYZE_HEAL_BALL = 5

internal object Route2_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ETHER)) return
    ctx.removeNpc(LOCALID_ETHER_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE2_ETHER)
  }
}

internal object Route2_EventScript_ItemParalyzeHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PARALYZE_HEAL)) return
    ctx.removeNpc(LOCALID_PARALYZE_HEAL_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE2_PARALYZE_HEAL)
  }
}

internal object Route2_EventScript_DiglettsCaveSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route2.DiglettsCave)
}

internal object Route2_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route2.RouteSign)
}

internal val Route2Scripts: Map<String, Script> =
    mapOf(
        "Route2_EventScript_ItemEther" to Route2_EventScript_ItemEther,
        "Route2_EventScript_ItemParalyzeHeal" to Route2_EventScript_ItemParalyzeHeal,
        "Route2_EventScript_DiglettsCaveSign" to Route2_EventScript_DiglettsCaveSign,
        "Route2_EventScript_RouteSign" to Route2_EventScript_RouteSign,
    )
