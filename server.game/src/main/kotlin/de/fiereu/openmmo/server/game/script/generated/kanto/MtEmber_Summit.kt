package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

private const val MOLTRES = 146
private const val MOLTRES_LEVEL = 50
private const val LOCALID_MOLTRES = 0

/** The legendary standing here, which the player may catch or run from. Either way it leaves. */
internal object MtEmber_Summit_EventScript_Moltres : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.sign(Misc.Text_Gyaoo)
    val outcome = ctx.legendaryBattle(MOLTRES, MOLTRES_LEVEL)
    ctx.removeNpc(LOCALID_MOLTRES)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MOLTRES)
    if (outcome == BattleResult.VICTORY || outcome == BattleResult.CAUGHT) {
      return ctx.setFlag(KantoFlags.FLAG_FOUGHT_MOLTRES)
    }
    ctx.sign(Misc.Text_MonFlewAway)
  }
}

internal val MtEmber_SummitScripts: Map<String, Script> =
    mapOf(
        "MtEmber_Summit_EventScript_Moltres" to MtEmber_Summit_EventScript_Moltres,
    )
