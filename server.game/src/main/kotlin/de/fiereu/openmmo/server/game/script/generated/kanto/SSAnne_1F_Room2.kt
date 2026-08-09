package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room2
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_ANN, SSAnne_1F_Room2_Text_AnnIntro, SSAnne_1F_Room2_Text_AnnDefeat
 * msgbox SSAnne_1F_Room2_Text_AnnPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_1F_Room2_EventScript_Ann : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_ANN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_1F_Room2.AnnPostBattle)
    }
    ctx.say(SSAnne_1F_Room2.AnnIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_1F_Room2.AnnDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_TYLER, SSAnne_1F_Room2_Text_TylerIntro, SSAnne_1F_Room2_Text_TylerDefeat
 * msgbox SSAnne_1F_Room2_Text_TylerPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_1F_Room2_EventScript_Tyler : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_TYLER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_1F_Room2.TylerPostBattle)
    }
    ctx.say(SSAnne_1F_Room2.TylerIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_1F_Room2.TylerDefeat)
  }
}

internal object SSAnne_1F_Room2_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_1F_Room2.CruisingAroundWorld)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM31
 * end
 * ```
 */
internal object SSAnne_1F_Room2_EventScript_ItemTM31 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SSAnne_1F_Room2_EventScript_ItemTM31")
}

internal val SSAnne_1F_Room2Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room2_EventScript_Ann" to SSAnne_1F_Room2_EventScript_Ann,
        "SSAnne_1F_Room2_EventScript_Tyler" to SSAnne_1F_Room2_EventScript_Tyler,
        "SSAnne_1F_Room2_EventScript_Woman" to SSAnne_1F_Room2_EventScript_Woman,
        "SSAnne_1F_Room2_EventScript_ItemTM31" to SSAnne_1F_Room2_EventScript_ItemTM31,
    )
