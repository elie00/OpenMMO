package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.dialog.generated.kanto.SeafoamIslands_B4F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

private const val ARTICUNO = 144
private const val ARTICUNO_LEVEL = 50
private const val LOCALID_ARTICUNO = 2

/** The legendary standing here, which the player may catch or run from. Either way it leaves. */
internal object SeafoamIslands_B4F_EventScript_Articuno : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.sign(Misc.Text_Gyaoo)
    val outcome = ctx.legendaryBattle(ARTICUNO, ARTICUNO_LEVEL)
    ctx.removeNpc(LOCALID_ARTICUNO)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ARTICUNO)
    if (outcome == BattleResult.VICTORY || outcome == BattleResult.CAUGHT) {
      return ctx.setFlag(KantoFlags.FLAG_FOUGHT_ARTICUNO)
    }
    ctx.sign(Misc.Text_MonFlewAway)
  }
}

internal object SeafoamIslands_B4F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ULTRA_BALL)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEAFOAM_ISLANDS_B4F_ULTRA_BALL)
  }
}

internal object SeafoamIslands_B4F_EventScript_FastCurrentSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SeafoamIslands_B4F.DangerFastCurrent)
}

internal object SeafoamIslands_B4F_EventScript_BoulderHintSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SeafoamIslands_B4F.BouldersMightChangeWaterFlow)
}

internal val SeafoamIslands_B4FScripts: Map<String, Script> =
    mapOf(
        "SeafoamIslands_B4F_EventScript_Articuno" to SeafoamIslands_B4F_EventScript_Articuno,
        "SeafoamIslands_B4F_EventScript_ItemUltraBall" to
            SeafoamIslands_B4F_EventScript_ItemUltraBall,
        "SeafoamIslands_B4F_EventScript_FastCurrentSign" to
            SeafoamIslands_B4F_EventScript_FastCurrentSign,
        "SeafoamIslands_B4F_EventScript_BoulderHintSign" to
            SeafoamIslands_B4F_EventScript_BoulderHintSign,
    )
