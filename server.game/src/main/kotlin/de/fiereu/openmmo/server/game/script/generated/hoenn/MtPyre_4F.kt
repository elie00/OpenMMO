package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MtPyre_4F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TASHA, MtPyre_4F_Text_TashaIntro, MtPyre_4F_Text_TashaDefeat
 * msgbox MtPyre_4F_Text_TashaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_4F_EventScript_Tasha : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TASHA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_4F.TashaPostBattle)
    }
    ctx.say(MtPyre_4F.TashaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_4F.TashaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_SEA_INCENSE
 * end
 * ```
 */
internal object MtPyre_4F_EventScript_ItemSeaIncense : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_4F_EventScript_ItemSeaIncense")
}

internal val MtPyre_4FScripts: Map<String, Script> =
    mapOf(
        "MtPyre_4F_EventScript_Tasha" to MtPyre_4F_EventScript_Tasha,
        "MtPyre_4F_EventScript_ItemSeaIncense" to MtPyre_4F_EventScript_ItemSeaIncense,
    )
