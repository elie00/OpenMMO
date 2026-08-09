package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route13
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_ALMA, Route13_Text_AlmaIntro, Route13_Text_AlmaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_AlmaRematch
 * msgbox Route13_Text_AlmaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Alma : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_ALMA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_AlmaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.AlmaPostBattle)
    }
    ctx.say(Route13.AlmaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.AlmaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_SEBASTIAN, Route13_Text_SebastianIntro, Route13_Text_SebastianDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_SebastianRematch
 * msgbox Route13_Text_SebastianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Sebastian : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_SEBASTIAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_SebastianRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.SebastianPostBattle)
    }
    ctx.say(Route13.SebastianIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.SebastianDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_SUSIE, Route13_Text_SusieIntro, Route13_Text_SusieDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_SusieRematch
 * msgbox Route13_Text_SusiePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Susie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_SUSIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_SusieRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.SusiePostBattle)
    }
    ctx.say(Route13.SusieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.SusieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_SHEILA, Route13_Text_SheilaIntro, Route13_Text_SheilaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_SheilaRematch
 * msgbox Route13_Text_SheilaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Sheila : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BEAUTY_SHEILA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_SheilaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.SheilaPostBattle)
    }
    ctx.say(Route13.SheilaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.SheilaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_LOLA, Route13_Text_LolaIntro, Route13_Text_LolaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_LolaRematch
 * msgbox Route13_Text_LolaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Lola : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BEAUTY_LOLA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_LolaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.LolaPostBattle)
    }
    ctx.say(Route13.LolaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.LolaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_VALERIE, Route13_Text_ValerieIntro, Route13_Text_ValerieDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_ValerieRematch
 * msgbox Route13_Text_ValeriePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Valerie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_VALERIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_ValerieRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.ValeriePostBattle)
    }
    ctx.say(Route13.ValerieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.ValerieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_GWEN, Route13_Text_GwenIntro, Route13_Text_GwenDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_GwenRematch
 * msgbox Route13_Text_GwenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Gwen : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_GWEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_GwenRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.GwenPostBattle)
    }
    ctx.say(Route13.GwenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.GwenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_ROBERT, Route13_Text_RobertIntro, Route13_Text_RobertDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_RobertRematch
 * msgbox Route13_Text_RobertPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Robert : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_ROBERT
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_RobertRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.RobertPostBattle)
    }
    ctx.say(Route13.RobertIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.RobertDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_PERRY, Route13_Text_PerryIntro, Route13_Text_PerryDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_PerryRematch
 * msgbox Route13_Text_PerryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Perry : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_PERRY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_PerryRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.PerryPostBattle)
    }
    ctx.say(Route13.PerryIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.PerryDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIKER_JARED, Route13_Text_JaredIntro, Route13_Text_JaredDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route13_EventScript_JaredRematch
 * msgbox Route13_Text_JaredPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route13_EventScript_Jared : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIKER_JARED
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route13_EventScript_JaredRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route13.JaredPostBattle)
    }
    ctx.say(Route13.JaredIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route13.JaredDefeat)
  }
}

internal object Route13_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route13.RouteSign)
}

internal object Route13_EventScript_TrainerTips2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route13.SelectToSwitchItems)
}

internal object Route13_EventScript_TrainerTips1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route13.LookToLeftOfThatPost)
}

internal val Route13Scripts: Map<String, Script> =
    mapOf(
        "Route13_EventScript_Alma" to Route13_EventScript_Alma,
        "Route13_EventScript_Sebastian" to Route13_EventScript_Sebastian,
        "Route13_EventScript_Susie" to Route13_EventScript_Susie,
        "Route13_EventScript_Sheila" to Route13_EventScript_Sheila,
        "Route13_EventScript_Lola" to Route13_EventScript_Lola,
        "Route13_EventScript_Valerie" to Route13_EventScript_Valerie,
        "Route13_EventScript_Gwen" to Route13_EventScript_Gwen,
        "Route13_EventScript_Robert" to Route13_EventScript_Robert,
        "Route13_EventScript_Perry" to Route13_EventScript_Perry,
        "Route13_EventScript_Jared" to Route13_EventScript_Jared,
        "Route13_EventScript_RouteSign" to Route13_EventScript_RouteSign,
        "Route13_EventScript_TrainerTips2" to Route13_EventScript_TrainerTips2,
        "Route13_EventScript_TrainerTips1" to Route13_EventScript_TrainerTips1,
    )
