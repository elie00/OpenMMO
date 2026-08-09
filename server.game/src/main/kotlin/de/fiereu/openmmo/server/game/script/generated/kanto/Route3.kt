package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route3
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

internal object Route3_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route3.TunnelFromCeruleanTiring)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_ROBIN, Route3_Text_RobinIntro, Route3_Text_RobinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_RobinRematch
 * msgbox Route3_Text_RobinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Robin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_ROBIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_RobinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.RobinPostBattle)
    }
    ctx.say(Route3.RobinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.RobinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_JAMES, Route3_Text_JamesIntro, Route3_Text_JamesDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_JamesRematch
 * msgbox Route3_Text_JamesPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_James : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_JAMES
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_JamesRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.JamesPostBattle)
    }
    ctx.say(Route3.JamesIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.JamesDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_SALLY, Route3_Text_SallyIntro, Route3_Text_SallyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_SallyRematch
 * msgbox Route3_Text_SallyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Sally : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_SALLY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_SallyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.SallyPostBattle)
    }
    ctx.say(Route3.SallyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.SallyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_GREG, Route3_Text_GregIntro, Route3_Text_GregDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_GregRematch
 * msgbox Route3_Text_GregPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Greg : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_GREG
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_GregRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.GregPostBattle)
    }
    ctx.say(Route3.GregIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.GregDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_CALVIN, Route3_Text_CalvinIntro, Route3_Text_CalvinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_CalvinRematch
 * msgbox Route3_Text_CalvinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Calvin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_CALVIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_CalvinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.CalvinPostBattle)
    }
    ctx.say(Route3.CalvinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.CalvinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_JANICE, Route3_Text_JaniceIntro, Route3_Text_JaniceDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_JaniceRematch
 * msgbox Route3_Text_JanicePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Janice : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_JANICE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_JaniceRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.JanicePostBattle)
    }
    ctx.say(Route3.JaniceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.JaniceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_COLTON, Route3_Text_ColtonIntro, Route3_Text_ColtonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_ColtonRematch
 * msgbox Route3_Text_ColtonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Colton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_COLTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_ColtonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.ColtonPostBattle)
    }
    ctx.say(Route3.ColtonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.ColtonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_BEN, Route3_Text_BenIntro, Route3_Text_BenDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route3_EventScript_BenRematch
 * msgbox Route3_Text_BenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route3_EventScript_Ben : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_BEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route3_EventScript_BenRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route3.BenPostBattle)
    }
    ctx.say(Route3.BenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route3.BenDefeat)
  }
}

internal object Route3_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route3.RouteSign)
}

internal val Route3Scripts: Map<String, Script> =
    mapOf(
        "Route3_EventScript_Youngster" to Route3_EventScript_Youngster,
        "Route3_EventScript_Robin" to Route3_EventScript_Robin,
        "Route3_EventScript_James" to Route3_EventScript_James,
        "Route3_EventScript_Sally" to Route3_EventScript_Sally,
        "Route3_EventScript_Greg" to Route3_EventScript_Greg,
        "Route3_EventScript_Calvin" to Route3_EventScript_Calvin,
        "Route3_EventScript_Janice" to Route3_EventScript_Janice,
        "Route3_EventScript_Colton" to Route3_EventScript_Colton,
        "Route3_EventScript_Ben" to Route3_EventScript_Ben,
        "Route3_EventScript_RouteSign" to Route3_EventScript_RouteSign,
    )
