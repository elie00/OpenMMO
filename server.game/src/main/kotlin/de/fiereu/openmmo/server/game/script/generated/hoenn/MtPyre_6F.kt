package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MtPyre_6F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_VALERIE_1, MtPyre_6F_Text_ValerieIntro, MtPyre_6F_Text_ValerieDefeat, MtPyre_6F_EventScript_RegisterValerie
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, MtPyre_6F_EventScript_RematchValerie
 * msgbox MtPyre_6F_Text_ValeriePostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MtPyre_6F_EventScript_Valerie : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_6F_EventScript_Valerie")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM_SHADOW_BALL
 * end
 * ```
 */
internal object MtPyre_6F_EventScript_ItemTMShadowBall : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_6F_EventScript_ItemTMShadowBall")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CEDRIC, MtPyre_6F_Text_CedricIntro, MtPyre_6F_Text_CedricDefeat
 * msgbox MtPyre_6F_Text_CedricPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_6F_EventScript_Cedric : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CEDRIC
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_6F.CedricPostBattle)
    }
    ctx.say(MtPyre_6F.CedricIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_6F.CedricDefeat)
  }
}

internal val MtPyre_6FScripts: Map<String, Script> =
    mapOf(
        "MtPyre_6F_EventScript_Valerie" to MtPyre_6F_EventScript_Valerie,
        "MtPyre_6F_EventScript_ItemTMShadowBall" to MtPyre_6F_EventScript_ItemTMShadowBall,
        "MtPyre_6F_EventScript_Cedric" to MtPyre_6F_EventScript_Cedric,
    )
