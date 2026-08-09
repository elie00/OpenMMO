package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route107
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DARRIN, Route107_Text_DarrinIntro, Route107_Text_DarrinDefeated
 * msgbox Route107_Text_DarrinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_Darrin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DARRIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route107.DarrinPostBattle)
    }
    ctx.say(Route107.DarrinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route107.DarrinDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_TONY_1, Route107_Text_TonyIntro, Route107_Text_TonyDefeated, Route107_EventScript_TonyRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route107_EventScript_TonyRematch
 * msgbox Route107_Text_TonyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route107_EventScript_Tony : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route107_EventScript_Tony")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DENISE, Route107_Text_DeniseIntro, Route107_Text_DeniseDefeated
 * msgbox Route107_Text_DenisePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_Denise : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DENISE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route107.DenisePostBattle)
    }
    ctx.say(Route107.DeniseIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route107.DeniseDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BETH, Route107_Text_BethIntro, Route107_Text_BethDefeated
 * msgbox Route107_Text_BethPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_Beth : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BETH
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route107.BethPostBattle)
    }
    ctx.say(Route107.BethIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route107.BethDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_LISA_AND_RAY, Route107_Text_LisaIntro, Route107_Text_LisaDefeated, Route107_Text_LisaNotEnoughPokemon
 * msgbox Route107_Text_LisaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_Lisa : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route107_EventScript_Lisa")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_LISA_AND_RAY, Route107_Text_RayIntro, Route107_Text_RayDefeated, Route107_Text_RayNotEnoughPokemon
 * msgbox Route107_Text_RayPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_Ray : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route107_EventScript_Ray")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMRON, Route107_Text_CamronIntro, Route107_Text_CamronDefeated
 * msgbox Route107_Text_CamronPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_Camron : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CAMRON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route107.CamronPostBattle)
    }
    ctx.say(Route107.CamronIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route107.CamronDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_TONY_1, Route107_Text_TonyRematchIntro, Route107_Text_TonyRematchDefeated
 * msgbox Route107_Text_TonyRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route107_EventScript_TonyRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route107_EventScript_TonyRematch")
}

internal val Route107Scripts: Map<String, Script> =
    mapOf(
        "Route107_EventScript_Darrin" to Route107_EventScript_Darrin,
        "Route107_EventScript_Tony" to Route107_EventScript_Tony,
        "Route107_EventScript_Denise" to Route107_EventScript_Denise,
        "Route107_EventScript_Beth" to Route107_EventScript_Beth,
        "Route107_EventScript_Lisa" to Route107_EventScript_Lisa,
        "Route107_EventScript_Ray" to Route107_EventScript_Ray,
        "Route107_EventScript_Camron" to Route107_EventScript_Camron,
        "Route107_EventScript_TonyRematch" to Route107_EventScript_TonyRematch,
    )
