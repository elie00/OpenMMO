package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

private const val MEWTWO = 150
private const val MEWTWO_LEVEL = 70
private const val LOCALID_MEWTWO = 2

internal object CeruleanCave_B1F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ULTRA_BALL)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_B1F_ULTRA_BALL)
  }
}

internal object CeruleanCave_B1F_EventScript_ItemMaxRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_REVIVE)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CERULEAN_CAVE_B1F_MAX_REVIVE)
  }
}

/** The legendary standing here, which the player may catch or run from. Either way it leaves. */
internal object CeruleanCave_B1F_EventScript_Mewtwo : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.sign(Misc.Text_Gyaoo)
    val outcome = ctx.legendaryBattle(MEWTWO, MEWTWO_LEVEL)
    ctx.removeNpc(LOCALID_MEWTWO)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MEWTWO)
    if (outcome == BattleResult.VICTORY || outcome == BattleResult.CAUGHT) {
      return ctx.setFlag(KantoFlags.FLAG_FOUGHT_MEWTWO)
    }
    ctx.sign(Misc.Text_MonFlewAway)
  }
}

internal val CeruleanCave_B1FScripts: Map<String, Script> =
    mapOf(
        "CeruleanCave_B1F_EventScript_ItemUltraBall" to CeruleanCave_B1F_EventScript_ItemUltraBall,
        "CeruleanCave_B1F_EventScript_ItemMaxRevive" to CeruleanCave_B1F_EventScript_ItemMaxRevive,
        "CeruleanCave_B1F_EventScript_Mewtwo" to CeruleanCave_B1F_EventScript_Mewtwo,
    )
