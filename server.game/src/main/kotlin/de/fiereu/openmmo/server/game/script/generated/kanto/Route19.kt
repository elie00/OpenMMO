package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route19
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_REECE, Route19_Text_ReeceIntro, Route19_Text_ReeceDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_ReeceRematch
 * msgbox Route19_Text_ReecePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Reece : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_REECE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_ReeceRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.ReecePostBattle)
    }
    ctx.say(Route19.ReeceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.ReeceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_RICHARD, Route19_Text_RichardIntro, Route19_Text_RichardDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_RichardRematch
 * msgbox Route19_Text_RichardPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Richard : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_RICHARD
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_RichardRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.RichardPostBattle)
    }
    ctx.say(Route19.RichardIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.RichardDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_TONY, Route19_Text_TonyIntro, Route19_Text_TonyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_TonyRematch
 * msgbox Route19_Text_TonyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Tony : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_TONY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_TonyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.TonyPostBattle)
    }
    ctx.say(Route19.TonyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.TonyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_MATTHEW, Route19_Text_MatthewIntro, Route19_Text_MatthewDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_MatthewRematch
 * msgbox Route19_Text_MatthewPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Matthew : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_MATTHEW
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_MatthewRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.MatthewPostBattle)
    }
    ctx.say(Route19.MatthewIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.MatthewDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_DOUGLAS, Route19_Text_DouglasIntro, Route19_Text_DouglasDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_DouglasRematch
 * msgbox Route19_Text_DouglasPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Douglas : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_DOUGLAS
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_DouglasRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.DouglasPostBattle)
    }
    ctx.say(Route19.DouglasIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.DouglasDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_DAVID, Route19_Text_DavidIntro, Route19_Text_DavidDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_DavidRematch
 * msgbox Route19_Text_DavidPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_David : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_DAVID
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_DavidRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.DavidPostBattle)
    }
    ctx.say(Route19.DavidIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.DavidDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_AXLE, Route19_Text_AxleIntro, Route19_Text_AxleDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_AxleRematch
 * msgbox Route19_Text_AxlePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Axle : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_AXLE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_AxleRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.AxlePostBattle)
    }
    ctx.say(Route19.AxleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.AxleDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_ALICE, Route19_Text_AliceIntro, Route19_Text_AliceDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_AliceRematch
 * msgbox Route19_Text_AlicePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Alice : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_ALICE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_AliceRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.AlicePostBattle)
    }
    ctx.say(Route19.AliceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.AliceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_CONNIE, Route19_Text_ConnieIntro, Route19_Text_ConnieDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_ConnieRematch
 * msgbox Route19_Text_ConniePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Connie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_CONNIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_ConnieRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.ConniePostBattle)
    }
    ctx.say(Route19.ConnieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.ConnieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_ANYA, Route19_Text_AnyaIntro, Route19_Text_AnyaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_AnyaRematch
 * msgbox Route19_Text_AnyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Anya : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_ANYA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route19_EventScript_AnyaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route19.AnyaPostBattle)
    }
    ctx.say(Route19.AnyaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route19.AnyaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_LIA_LUC, Route19_Text_LiaIntro, Route19_Text_LiaDefeat, Route19_Text_LiaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_LiaRematch
 * msgbox Route19_Text_LiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Lia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route19_EventScript_Lia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_LIA_LUC, Route19_Text_LucIntro, Route19_Text_LucDefeat, Route19_Text_LucNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route19_EventScript_LucRematch
 * msgbox Route19_Text_LucPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_Luc : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route19_EventScript_Luc")
}

internal object Route19_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route19.RouteSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_SIS_AND_BRO_LIA_LUC, Route19_Text_LucRematchIntro, Route19_Text_LucDefeat, Route19_Text_LucNotEnoughMons
 * msgbox Route19_Text_LucPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_LucRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route19_EventScript_LucRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_SIS_AND_BRO_LIA_LUC, Route19_Text_LiaRematchIntro, Route19_Text_LiaDefeat, Route19_Text_LiaNotEnoughMons
 * msgbox Route19_Text_LiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route19_EventScript_LiaRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route19_EventScript_LiaRematch")
}

internal val Route19Scripts: Map<String, Script> =
    mapOf(
        "Route19_EventScript_Reece" to Route19_EventScript_Reece,
        "Route19_EventScript_Richard" to Route19_EventScript_Richard,
        "Route19_EventScript_Tony" to Route19_EventScript_Tony,
        "Route19_EventScript_Matthew" to Route19_EventScript_Matthew,
        "Route19_EventScript_Douglas" to Route19_EventScript_Douglas,
        "Route19_EventScript_David" to Route19_EventScript_David,
        "Route19_EventScript_Axle" to Route19_EventScript_Axle,
        "Route19_EventScript_Alice" to Route19_EventScript_Alice,
        "Route19_EventScript_Connie" to Route19_EventScript_Connie,
        "Route19_EventScript_Anya" to Route19_EventScript_Anya,
        "Route19_EventScript_Lia" to Route19_EventScript_Lia,
        "Route19_EventScript_Luc" to Route19_EventScript_Luc,
        "Route19_EventScript_RouteSign" to Route19_EventScript_RouteSign,
        "Route19_EventScript_LucRematch" to Route19_EventScript_LucRematch,
        "Route19_EventScript_LiaRematch" to Route19_EventScript_LiaRematch,
    )
