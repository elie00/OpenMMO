package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route128
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_ISAIAH_1, Route128_Text_IsaiahIntro, Route128_Text_IsaiahDefeat, Route128_EventScript_RegisterIsaiah
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route128_EventScript_RematchIsaiah
 * msgbox Route128_Text_IsaiahPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route128_EventScript_Isaiah : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route128_EventScript_Isaiah")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_KATELYN_1, Route128_Text_KatelynIntro, Route128_Text_KatelynDefeat, Route128_EventScript_RegisterKatelyn
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route128_EventScript_RematchKatelyn
 * msgbox Route128_Text_KatelynPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route128_EventScript_Katelyn : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route128_EventScript_Katelyn")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_WAYNE, Route128_Text_WayneIntro, Route128_Text_WayneDefeat
 * msgbox Route128_Text_WaynePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_Wayne : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_WAYNE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route128.WaynePostBattle)
    }
    ctx.say(Route128.WayneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route128.WayneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUBEN, Route128_Text_RubenIntro, Route128_Text_RubenDefeat
 * msgbox Route128_Text_RubenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_Ruben : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RUBEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route128.RubenPostBattle)
    }
    ctx.say(Route128.RubenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route128.RubenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALEXA, Route128_Text_AlexaIntro, Route128_Text_AlexaDefeat
 * msgbox Route128_Text_AlexaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_Alexa : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALEXA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route128.AlexaPostBattle)
    }
    ctx.say(Route128.AlexaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route128.AlexaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CARLEE, Route128_Text_CarleeIntro, Route128_Text_CarleeDefeat
 * msgbox Route128_Text_CarleePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_Carlee : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CARLEE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route128.CarleePostBattle)
    }
    ctx.say(Route128.CarleeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route128.CarleeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HARRISON, Route128_Text_HarrisonIntro, Route128_Text_HarrisonDefeat
 * msgbox Route128_Text_HarrisonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_Harrison : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HARRISON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route128.HarrisonPostBattle)
    }
    ctx.say(Route128.HarrisonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route128.HarrisonDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_ISAIAH_1, Route128_Text_IsaiahRematchIntro, Route128_Text_IsaiahRematchDefeat
 * msgbox Route128_Text_IsaiahPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_RematchIsaiah : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route128_EventScript_RematchIsaiah")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_KATELYN_1, Route128_Text_KatelynRematchIntro, Route128_Text_KatelynRematchDefeat
 * msgbox Route128_Text_KatelynPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route128_EventScript_RematchKatelyn : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route128_EventScript_RematchKatelyn")
}

internal val Route128Scripts: Map<String, Script> =
    mapOf(
        "Route128_EventScript_Isaiah" to Route128_EventScript_Isaiah,
        "Route128_EventScript_Katelyn" to Route128_EventScript_Katelyn,
        "Route128_EventScript_Wayne" to Route128_EventScript_Wayne,
        "Route128_EventScript_Ruben" to Route128_EventScript_Ruben,
        "Route128_EventScript_Alexa" to Route128_EventScript_Alexa,
        "Route128_EventScript_Carlee" to Route128_EventScript_Carlee,
        "Route128_EventScript_Harrison" to Route128_EventScript_Harrison,
        "Route128_EventScript_RematchIsaiah" to Route128_EventScript_RematchIsaiah,
        "Route128_EventScript_RematchKatelyn" to Route128_EventScript_RematchKatelyn,
    )
