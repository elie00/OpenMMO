package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SafariZone_North
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object SafariZone_North_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PROTEIN)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_NORTH_PROTEIN)
  }
}

internal object SafariZone_North_EventScript_ItemTM47 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM47)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_NORTH_TM47)
  }
}

internal object SafariZone_North_EventScript_ItemQuickClaw : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.QUICK_CLAW)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_NORTH_QUICK_CLAW)
  }
}

internal object SafariZone_North_EventScript_TrainerTips1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_North.SecretHouseStillAhead)
}

internal object SafariZone_North_EventScript_AreaSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_North.Area2)
}

internal object SafariZone_North_EventScript_TrainerTips2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_North.ZigzagThroughTallGrass)
}

internal object SafariZone_North_EventScript_TrainerTips3 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_North.WinFreeHMFindSecretHouse)
}

internal object SafariZone_North_EventScript_RestHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_North.RestHouse)
}

internal val SafariZone_NorthScripts: Map<String, Script> =
    mapOf(
        "SafariZone_North_EventScript_ItemProtein" to SafariZone_North_EventScript_ItemProtein,
        "SafariZone_North_EventScript_ItemTM47" to SafariZone_North_EventScript_ItemTM47,
        "SafariZone_North_EventScript_ItemQuickClaw" to SafariZone_North_EventScript_ItemQuickClaw,
        "SafariZone_North_EventScript_TrainerTips1" to SafariZone_North_EventScript_TrainerTips1,
        "SafariZone_North_EventScript_AreaSign" to SafariZone_North_EventScript_AreaSign,
        "SafariZone_North_EventScript_TrainerTips2" to SafariZone_North_EventScript_TrainerTips2,
        "SafariZone_North_EventScript_TrainerTips3" to SafariZone_North_EventScript_TrainerTips3,
        "SafariZone_North_EventScript_RestHouseSign" to SafariZone_North_EventScript_RestHouseSign,
    )
