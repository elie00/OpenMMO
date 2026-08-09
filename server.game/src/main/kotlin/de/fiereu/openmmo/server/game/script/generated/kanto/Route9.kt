package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route9
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_ALICIA, Route9_Text_AliciaIntro, Route9_Text_AliciaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_AliciaRematch
 * msgbox Route9_Text_AliciaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Alicia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_ALICIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_AliciaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.AliciaPostBattle)
    }
    ctx.say(Route9.AliciaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.AliciaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_JEREMY, Route9_Text_JeremyIntro, Route9_Text_JeremyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_JeremyRematch
 * msgbox Route9_Text_JeremyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Jeremy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_JEREMY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_JeremyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.JeremyPostBattle)
    }
    ctx.say(Route9.JeremyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.JeremyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_ALAN, Route9_Text_AlanIntro, Route9_Text_AlanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_AlanRematch
 * msgbox Route9_Text_AlanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Alan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_ALAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_AlanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.AlanPostBattle)
    }
    ctx.say(Route9.AlanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.AlanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_CHRIS, Route9_Text_ChrisIntro, Route9_Text_ChrisDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_ChrisRematch
 * msgbox Route9_Text_ChrisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Chris : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_CHRIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_ChrisRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.ChrisPostBattle)
    }
    ctx.say(Route9.ChrisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.ChrisDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_BRENT, Route9_Text_BrentIntro, Route9_Text_BrentDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_BrentRematch
 * msgbox Route9_Text_BrentPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Brent : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_BRENT
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_BrentRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.BrentPostBattle)
    }
    ctx.say(Route9.BrentIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.BrentDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_CONNER, Route9_Text_ConnerIntro, Route9_Text_ConnerDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_ConnerRematch
 * msgbox Route9_Text_ConnerPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Conner : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_CONNER
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_ConnerRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.ConnerPostBattle)
    }
    ctx.say(Route9.ConnerIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.ConnerDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_BRICE, Route9_Text_BriceIntro, Route9_Text_BriceDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_BriceRematch
 * msgbox Route9_Text_BricePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Brice : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_BRICE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_BriceRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.BricePostBattle)
    }
    ctx.say(Route9.BriceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.BriceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_CAITLIN, Route9_Text_CaitlinIntro, Route9_Text_CaitlinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_CaitlinRematch
 * msgbox Route9_Text_CaitlinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Caitlin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_CAITLIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_CaitlinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.CaitlinPostBattle)
    }
    ctx.say(Route9.CaitlinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.CaitlinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_DREW, Route9_Text_DrewIntro, Route9_Text_DrewDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route9_EventScript_DrewRematch
 * msgbox Route9_Text_DrewPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route9_EventScript_Drew : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_DREW
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route9_EventScript_DrewRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route9.DrewPostBattle)
    }
    ctx.say(Route9.DrewIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route9.DrewDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM40
 * end
 * ```
 */
internal object Route9_EventScript_ItemTM40 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM40, KantoFlags.FLAG_HIDE_ROUTE9_TM40, 10)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BURN_HEAL
 * end
 * ```
 */
internal object Route9_EventScript_ItemBurnHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BURN_HEAL, KantoFlags.FLAG_HIDE_ROUTE9_BURN_HEAL, 11)
  }
}

internal object Route9_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route9.RouteSign)
}

internal val Route9Scripts: Map<String, Script> =
    mapOf(
        "Route9_EventScript_Alicia" to Route9_EventScript_Alicia,
        "Route9_EventScript_Jeremy" to Route9_EventScript_Jeremy,
        "Route9_EventScript_Alan" to Route9_EventScript_Alan,
        "Route9_EventScript_Chris" to Route9_EventScript_Chris,
        "Route9_EventScript_Brent" to Route9_EventScript_Brent,
        "Route9_EventScript_Conner" to Route9_EventScript_Conner,
        "Route9_EventScript_Brice" to Route9_EventScript_Brice,
        "Route9_EventScript_Caitlin" to Route9_EventScript_Caitlin,
        "Route9_EventScript_Drew" to Route9_EventScript_Drew,
        "Route9_EventScript_ItemTM40" to Route9_EventScript_ItemTM40,
        "Route9_EventScript_ItemBurnHeal" to Route9_EventScript_ItemBurnHeal,
        "Route9_EventScript_RouteSign" to Route9_EventScript_RouteSign,
    )
