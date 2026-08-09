package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route15
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_YAZMIN, Route15_Text_YazminIntro, Route15_Text_YazminDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_YazminRematch
 * msgbox Route15_Text_YazminPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Yazmin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_YAZMIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_YazminRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.YazminPostBattle)
    }
    ctx.say(Route15.YazminIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.YazminDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_EDWIN, Route15_Text_EdwinIntro, Route15_Text_EdwinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_EdwinRematch
 * msgbox Route15_Text_EdwinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Edwin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_EDWIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_EdwinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.EdwinPostBattle)
    }
    ctx.say(Route15.EdwinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.EdwinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_CHESTER, Route15_Text_ChesterIntro, Route15_Text_ChesterDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_ChesterRematch
 * msgbox Route15_Text_ChesterPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Chester : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_CHESTER
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_ChesterRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.ChesterPostBattle)
    }
    ctx.say(Route15.ChesterIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.ChesterDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_KINDRA, Route15_Text_KindraIntro, Route15_Text_KindraDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_KindraRematch
 * msgbox Route15_Text_KindraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Kindra : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_KINDRA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_KindraRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.KindraPostBattle)
    }
    ctx.say(Route15.KindraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.KindraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_OLIVIA, Route15_Text_OliviaIntro, Route15_Text_OliviaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_OliviaRematch
 * msgbox Route15_Text_OliviaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Olivia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BEAUTY_OLIVIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_OliviaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.OliviaPostBattle)
    }
    ctx.say(Route15.OliviaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.OliviaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIKER_ALEX, Route15_Text_AlexIntro, Route15_Text_AlexDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_AlexRematch
 * msgbox Route15_Text_AlexPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Alex : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIKER_ALEX
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_AlexRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.AlexPostBattle)
    }
    ctx.say(Route15.AlexIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.AlexDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIKER_ERNEST, Route15_Text_ErnestIntro, Route15_Text_ErnestDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_ErnestRematch
 * msgbox Route15_Text_ErnestPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Ernest : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIKER_ERNEST
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_ErnestRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.ErnestPostBattle)
    }
    ctx.say(Route15.ErnestIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.ErnestDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_BECKY, Route15_Text_BeckyIntro, Route15_Text_BeckyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_BeckyRematch
 * msgbox Route15_Text_BeckyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Becky : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_BECKY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_BeckyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.BeckyPostBattle)
    }
    ctx.say(Route15.BeckyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.BeckyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_GRACE, Route15_Text_GraceIntro, Route15_Text_GraceDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_GraceRematch
 * msgbox Route15_Text_GracePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Grace : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BEAUTY_GRACE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_GraceRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.GracePostBattle)
    }
    ctx.say(Route15.GraceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.GraceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_CELIA, Route15_Text_CeliaIntro, Route15_Text_CeliaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_CeliaRematch
 * msgbox Route15_Text_CeliaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Celia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_CELIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route15_EventScript_CeliaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route15.CeliaPostBattle)
    }
    ctx.say(Route15.CeliaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route15.CeliaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM18
 * end
 * ```
 */
internal object Route15_EventScript_ItemTM18 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM18, KantoFlags.FLAG_HIDE_ROUTE15_TM18, 10)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_RON_MYA, Route15_Text_RonIntro, Route15_Text_RonDefeat, Route15_Text_RonNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_RonRematch
 * msgbox Route15_Text_RonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Ron : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route15_EventScript_Ron")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_RON_MYA, Route15_Text_MyaIntro, Route15_Text_MyaDefeat, Route15_Text_MyaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_MyaRematch
 * msgbox Route15_Text_MyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Mya : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route15_EventScript_Mya")
}

internal object Route15_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route15.RouteSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_CRUSH_KIN_RON_MYA, Route15_Text_RonRematchIntro, Route15_Text_RonDefeat, Route15_Text_RonNotEnoughMons
 * msgbox Route15_Text_RonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_RonRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route15_EventScript_RonRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_CRUSH_KIN_RON_MYA, Route15_Text_MyaRematchIntro, Route15_Text_MyaDefeat, Route15_Text_MyaNotEnoughMons
 * msgbox Route15_Text_MyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_MyaRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route15_EventScript_MyaRematch")
}

internal val Route15Scripts: Map<String, Script> =
    mapOf(
        "Route15_EventScript_Yazmin" to Route15_EventScript_Yazmin,
        "Route15_EventScript_Edwin" to Route15_EventScript_Edwin,
        "Route15_EventScript_Chester" to Route15_EventScript_Chester,
        "Route15_EventScript_Kindra" to Route15_EventScript_Kindra,
        "Route15_EventScript_Olivia" to Route15_EventScript_Olivia,
        "Route15_EventScript_Alex" to Route15_EventScript_Alex,
        "Route15_EventScript_Ernest" to Route15_EventScript_Ernest,
        "Route15_EventScript_Becky" to Route15_EventScript_Becky,
        "Route15_EventScript_Grace" to Route15_EventScript_Grace,
        "Route15_EventScript_Celia" to Route15_EventScript_Celia,
        "Route15_EventScript_ItemTM18" to Route15_EventScript_ItemTM18,
        "Route15_EventScript_Ron" to Route15_EventScript_Ron,
        "Route15_EventScript_Mya" to Route15_EventScript_Mya,
        "Route15_EventScript_RouteSign" to Route15_EventScript_RouteSign,
        "Route15_EventScript_RonRematch" to Route15_EventScript_RonRematch,
        "Route15_EventScript_MyaRematch" to Route15_EventScript_MyaRematch,
    )
