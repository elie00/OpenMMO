package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MtPyre_5F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ATSUSHI, MtPyre_5F_Text_AtsushiIntro, MtPyre_5F_Text_AtsushiDefeat
 * msgbox MtPyre_5F_Text_AtsushiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_5F_EventScript_Atsushi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ATSUSHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_5F.AtsushiPostBattle)
    }
    ctx.say(MtPyre_5F.AtsushiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_5F.AtsushiDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_LAX_INCENSE
 * end
 * ```
 */
internal object MtPyre_5F_EventScript_ItemLaxIncense : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_5F_EventScript_ItemLaxIncense")
}

internal val MtPyre_5FScripts: Map<String, Script> =
    mapOf(
        "MtPyre_5F_EventScript_Atsushi" to MtPyre_5F_EventScript_Atsushi,
        "MtPyre_5F_EventScript_ItemLaxIncense" to MtPyre_5F_EventScript_ItemLaxIncense,
    )
