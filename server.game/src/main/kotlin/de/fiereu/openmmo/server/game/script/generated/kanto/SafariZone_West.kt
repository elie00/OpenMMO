package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SafariZone_West
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object SafariZone_West_EventScript_ItemGoldTeeth : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.GOLD_TEETH)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_WEST_GOLD_TEETH)
  }
}

internal object SafariZone_West_EventScript_ItemTM32 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM32)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_WEST_TM32)
  }
}

internal object SafariZone_West_EventScript_ItemMaxPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_POTION)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_WEST_MAX_POTION)
  }
}

internal object SafariZone_West_EventScript_ItemMaxRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_REVIVE)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFARI_ZONE_WEST_MAX_REVIVE)
  }
}

internal object SafariZone_West_EventScript_LostTeethNotice : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SafariZone_West.PleaseFindWardensLostTeeth)
}

internal object SafariZone_West_EventScript_TrainerTips : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_West.SearchForSecretHouse)
}

internal object SafariZone_West_EventScript_AreaSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_West.AreaSign)
}

internal object SafariZone_West_EventScript_RestHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_West.RestHouse)
}

internal val SafariZone_WestScripts: Map<String, Script> =
    mapOf(
        "SafariZone_West_EventScript_ItemGoldTeeth" to SafariZone_West_EventScript_ItemGoldTeeth,
        "SafariZone_West_EventScript_ItemTM32" to SafariZone_West_EventScript_ItemTM32,
        "SafariZone_West_EventScript_ItemMaxPotion" to SafariZone_West_EventScript_ItemMaxPotion,
        "SafariZone_West_EventScript_ItemMaxRevive" to SafariZone_West_EventScript_ItemMaxRevive,
        "SafariZone_West_EventScript_LostTeethNotice" to
            SafariZone_West_EventScript_LostTeethNotice,
        "SafariZone_West_EventScript_TrainerTips" to SafariZone_West_EventScript_TrainerTips,
        "SafariZone_West_EventScript_AreaSign" to SafariZone_West_EventScript_AreaSign,
        "SafariZone_West_EventScript_RestHouseSign" to SafariZone_West_EventScript_RestHouseSign,
    )
