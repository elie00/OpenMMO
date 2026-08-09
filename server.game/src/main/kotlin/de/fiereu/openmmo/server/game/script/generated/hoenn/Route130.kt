package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route130
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RODNEY, Route130_Text_RodneyIntro, Route130_Text_RodneyDefeat
 * msgbox Route130_Text_RodneyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route130_EventScript_Rodney : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RODNEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route130.RodneyPostBattle)
    }
    ctx.say(Route130.RodneyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route130.RodneyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KATIE, Route130_Text_KatieIntro, Route130_Text_KatieDefeat
 * msgbox Route130_Text_KatiePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route130_EventScript_Katie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KATIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route130.KatiePostBattle)
    }
    ctx.say(Route130.KatieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route130.KatieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SANTIAGO, Route130_Text_SantiagoIntro, Route130_Text_SantiagoDefeat
 * msgbox Route130_Text_SantiagoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route130_EventScript_Santiago : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SANTIAGO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route130.SantiagoPostBattle)
    }
    ctx.say(Route130.SantiagoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route130.SantiagoDefeat)
  }
}

internal val Route130Scripts: Map<String, Script> =
    mapOf(
        "Route130_EventScript_Rodney" to Route130_EventScript_Rodney,
        "Route130_EventScript_Katie" to Route130_EventScript_Katie,
        "Route130_EventScript_Santiago" to Route130_EventScript_Santiago,
    )
