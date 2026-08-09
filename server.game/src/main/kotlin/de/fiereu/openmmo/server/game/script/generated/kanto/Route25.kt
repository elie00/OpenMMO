package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route25
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_FRANKLIN, Route25_Text_FranklinIntro, Route25_Text_FranklinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_FranklinRematch
 * msgbox Route25_Text_FranklinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Franklin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_FRANKLIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_FranklinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.FranklinPostBattle)
    }
    ctx.say(Route25.FranklinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.FranklinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_JOEY, Route25_Text_JoeyIntro, Route25_Text_JoeyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_JoeyRematch
 * msgbox Route25_Text_JoeyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Joey : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_JOEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_JoeyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.JoeyPostBattle)
    }
    ctx.say(Route25.JoeyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.JoeyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_WAYNE, Route25_Text_WayneIntro, Route25_Text_WayneDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_WayneRematch
 * msgbox Route25_Text_WaynePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Wayne : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_WAYNE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_WayneRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.WaynePostBattle)
    }
    ctx.say(Route25.WayneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.WayneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_DAN, Route25_Text_DanIntro, Route25_Text_DanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_DanRematch
 * msgbox Route25_Text_DanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Dan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_DAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_DanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.DanPostBattle)
    }
    ctx.say(Route25.DanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.DanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_KELSEY, Route25_Text_KelseyIntro, Route25_Text_KelseyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_KelseyRematch
 * msgbox Route25_Text_KelseyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Kelsey : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_KELSEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_KelseyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.KelseyPostBattle)
    }
    ctx.say(Route25.KelseyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.KelseyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_NOB, Route25_Text_NobIntro, Route25_Text_NobDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_NobRematch
 * msgbox Route25_Text_NobPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Nob : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_NOB
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_NobRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.NobPostBattle)
    }
    ctx.say(Route25.NobIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.NobDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_FLINT, Route25_Text_FlintIntro, Route25_Text_FlintDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_FlintRematch
 * msgbox Route25_Text_FlintPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Flint : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_FLINT
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_FlintRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.FlintPostBattle)
    }
    ctx.say(Route25.FlintIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.FlintDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_CHAD, Route25_Text_ChadIntro, Route25_Text_ChadDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_ChadRematch
 * msgbox Route25_Text_ChadPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Chad : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_CHAD
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_ChadRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.ChadPostBattle)
    }
    ctx.say(Route25.ChadIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.ChadDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_HALEY, Route25_Text_HaleyIntro, Route25_Text_HaleyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route25_EventScript_HaleyRematch
 * msgbox Route25_Text_HaleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route25_EventScript_Haley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_HALEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route25_EventScript_HaleyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route25.HaleyPostBattle)
    }
    ctx.say(Route25.HaleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route25.HaleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM43
 * end
 * ```
 */
internal object Route25_EventScript_ItemTM43 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM43, KantoFlags.FLAG_HIDE_ROUTE25_TM43, 9)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_MISTY, 4
 * msgbox Route25_Text_MistyHighHopesAboutThisPlace
 * release
 * end
 * ```
 */
internal object Route25_EventScript_Beauty : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route25_EventScript_Beauty")
}

internal object Route25_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route25.AreYouHereAlone)
}

internal object Route25_EventScript_SeaCottageSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route25.SeaCottageSign)
}

internal val Route25Scripts: Map<String, Script> =
    mapOf(
        "Route25_EventScript_Franklin" to Route25_EventScript_Franklin,
        "Route25_EventScript_Joey" to Route25_EventScript_Joey,
        "Route25_EventScript_Wayne" to Route25_EventScript_Wayne,
        "Route25_EventScript_Dan" to Route25_EventScript_Dan,
        "Route25_EventScript_Kelsey" to Route25_EventScript_Kelsey,
        "Route25_EventScript_Nob" to Route25_EventScript_Nob,
        "Route25_EventScript_Flint" to Route25_EventScript_Flint,
        "Route25_EventScript_Chad" to Route25_EventScript_Chad,
        "Route25_EventScript_Haley" to Route25_EventScript_Haley,
        "Route25_EventScript_ItemTM43" to Route25_EventScript_ItemTM43,
        "Route25_EventScript_Beauty" to Route25_EventScript_Beauty,
        "Route25_EventScript_Man" to Route25_EventScript_Man,
        "Route25_EventScript_SeaCottageSign" to Route25_EventScript_SeaCottageSign,
    )
