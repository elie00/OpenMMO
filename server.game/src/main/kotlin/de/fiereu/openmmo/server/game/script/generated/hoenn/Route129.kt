package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route129
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHASE, Route129_Text_ChaseIntro, Route129_Text_ChaseDefeat
 * msgbox Route129_Text_ChasePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route129_EventScript_Chase : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CHASE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route129.ChasePostBattle)
    }
    ctx.say(Route129.ChaseIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route129.ChaseDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALLISON, Route129_Text_AllisonIntro, Route129_Text_AllisonDefeat
 * msgbox Route129_Text_AllisonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route129_EventScript_Allison : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALLISON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route129.AllisonPostBattle)
    }
    ctx.say(Route129.AllisonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route129.AllisonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TISHA, Route129_Text_TishaIntro, Route129_Text_TishaDefeat
 * msgbox Route129_Text_TishaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route129_EventScript_Tisha : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TISHA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route129.TishaPostBattle)
    }
    ctx.say(Route129.TishaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route129.TishaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_REED, Route129_Text_ReedIntro, Route129_Text_ReedDefeat
 * msgbox Route129_Text_ReedPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route129_EventScript_Reed : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_REED
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route129.ReedPostBattle)
    }
    ctx.say(Route129.ReedIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route129.ReedDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CLARENCE, Route129_Text_ClarenceIntro, Route129_Text_ClarenceDefeat
 * msgbox Route129_Text_ClarencePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route129_EventScript_Clarence : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CLARENCE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route129.ClarencePostBattle)
    }
    ctx.say(Route129.ClarenceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route129.ClarenceDefeat)
  }
}

internal val Route129Scripts: Map<String, Script> =
    mapOf(
        "Route129_EventScript_Chase" to Route129_EventScript_Chase,
        "Route129_EventScript_Allison" to Route129_EventScript_Allison,
        "Route129_EventScript_Tisha" to Route129_EventScript_Tisha,
        "Route129_EventScript_Reed" to Route129_EventScript_Reed,
        "Route129_EventScript_Clarence" to Route129_EventScript_Clarence,
    )
