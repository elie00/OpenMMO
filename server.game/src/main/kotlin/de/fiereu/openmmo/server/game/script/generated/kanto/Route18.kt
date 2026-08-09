package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route18
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_JACOB, Route18_Text_JacobIntro, Route18_Text_JacobDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route18_EventScript_JacobRematch
 * msgbox Route18_Text_JacobPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route18_EventScript_Jacob : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_JACOB
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route18_EventScript_JacobRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route18.JacobPostBattle)
    }
    ctx.say(Route18.JacobIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route18.JacobDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_RAMIRO, Route18_Text_RamiroIntro, Route18_Text_RamiroDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route18_EventScript_RamiroRematch
 * msgbox Route18_Text_RamiroPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route18_EventScript_Ramiro : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_RAMIRO
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route18_EventScript_RamiroRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route18.RamiroPostBattle)
    }
    ctx.say(Route18.RamiroIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route18.RamiroDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_WILTON, Route18_Text_WiltonIntro, Route18_Text_WiltonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route18_EventScript_WiltonRematch
 * msgbox Route18_Text_WiltonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route18_EventScript_Wilton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_WILTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route18_EventScript_WiltonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route18.WiltonPostBattle)
    }
    ctx.say(Route18.WiltonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route18.WiltonDefeat)
  }
}

internal object Route18_EventScript_CyclingRoadSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route18.CyclingRoadSign)
}

internal object Route18_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route18.RouteSign)
}

internal val Route18Scripts: Map<String, Script> =
    mapOf(
        "Route18_EventScript_Jacob" to Route18_EventScript_Jacob,
        "Route18_EventScript_Ramiro" to Route18_EventScript_Ramiro,
        "Route18_EventScript_Wilton" to Route18_EventScript_Wilton,
        "Route18_EventScript_CyclingRoadSign" to Route18_EventScript_CyclingRoadSign,
        "Route18_EventScript_RouteSign" to Route18_EventScript_RouteSign,
    )
