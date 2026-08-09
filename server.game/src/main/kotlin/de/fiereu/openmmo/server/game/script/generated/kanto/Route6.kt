package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route6
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_KEIGO, Route6_Text_KeigoIntro, Route6_Text_KeigoDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route6_EventScript_KeigoRematch
 * msgbox Route6_Text_KeigoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route6_EventScript_Keigo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_KEIGO
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route6_EventScript_KeigoRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route6.KeigoPostBattle)
    }
    ctx.say(Route6.KeigoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route6.KeigoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_RICKY, Route6_Text_RickyIntro, Route6_Text_RickyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route6_EventScript_RickyRematch
 * msgbox Route6_Text_RickyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route6_EventScript_Ricky : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_RICKY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route6_EventScript_RickyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route6.RickyPostBattle)
    }
    ctx.say(Route6.RickyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route6.RickyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_NANCY, Route6_Text_NancyIntro, Route6_Text_NancyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route6_EventScript_NancyRematch
 * msgbox Route6_Text_NancyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route6_EventScript_Nancy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_NANCY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route6_EventScript_NancyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route6.NancyPostBattle)
    }
    ctx.say(Route6.NancyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route6.NancyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_ELIJAH, Route6_Text_ElijahIntro, Route6_Text_ElijahDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route6_EventScript_ElijahRematch
 * msgbox Route6_Text_ElijahPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route6_EventScript_Elijah : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_ELIJAH
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route6_EventScript_ElijahRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route6.ElijahPostBattle)
    }
    ctx.say(Route6.ElijahIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route6.ElijahDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_ISABELLE, Route6_Text_IsabelleIntro, Route6_Text_IsabelleDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route6_EventScript_IsabelleRematch
 * msgbox Route6_Text_IsabellePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route6_EventScript_Isabelle : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_ISABELLE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route6_EventScript_IsabelleRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route6.IsabellePostBattle)
    }
    ctx.say(Route6.IsabelleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route6.IsabelleDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_JEFF, Route6_Text_JeffIntro, Route6_Text_JeffDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route6_EventScript_JeffRematch
 * msgbox Route6_Text_JeffPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route6_EventScript_Jeff : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_JEFF
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route6_EventScript_JeffRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route6.JeffPostBattle)
    }
    ctx.say(Route6.JeffIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route6.JeffDefeat)
  }
}

internal object Route6_EventScript_UndergroundPathSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route6.UndergroundPathSign)
}

internal val Route6Scripts: Map<String, Script> =
    mapOf(
        "Route6_EventScript_Keigo" to Route6_EventScript_Keigo,
        "Route6_EventScript_Ricky" to Route6_EventScript_Ricky,
        "Route6_EventScript_Nancy" to Route6_EventScript_Nancy,
        "Route6_EventScript_Elijah" to Route6_EventScript_Elijah,
        "Route6_EventScript_Isabelle" to Route6_EventScript_Isabelle,
        "Route6_EventScript_Jeff" to Route6_EventScript_Jeff,
        "Route6_EventScript_UndergroundPathSign" to Route6_EventScript_UndergroundPathSign,
    )
