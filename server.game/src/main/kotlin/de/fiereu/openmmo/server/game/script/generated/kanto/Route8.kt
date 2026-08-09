package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route8
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_JULIA, Route8_Text_JuliaIntro, Route8_Text_JuliaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_JuliaRematch
 * msgbox Route8_Text_JuliaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Julia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_JULIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_JuliaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.JuliaPostBattle)
    }
    ctx.say(Route8.JuliaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.JuliaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GAMER_RICH, Route8_Text_RichIntro, Route8_Text_RichDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_RichRematch
 * msgbox Route8_Text_RichPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Rich : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GAMER_RICH
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_RichRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.RichPostBattle)
    }
    ctx.say(Route8.RichIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.RichDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_GLENN, Route8_Text_GlennIntro, Route8_Text_GlennDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_GlennRematch
 * msgbox Route8_Text_GlennPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Glenn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SUPER_NERD_GLENN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_GlennRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.GlennPostBattle)
    }
    ctx.say(Route8.GlennIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.GlennDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_PAIGE, Route8_Text_PaigeIntro, Route8_Text_PaigeDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_PaigeRematch
 * msgbox Route8_Text_PaigePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Paige : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_PAIGE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_PaigeRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.PaigePostBattle)
    }
    ctx.say(Route8.PaigeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.PaigeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_LESLIE, Route8_Text_LeslieIntro, Route8_Text_LeslieDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_LeslieRematch
 * msgbox Route8_Text_LesliePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Leslie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SUPER_NERD_LESLIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_LeslieRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.LesliePostBattle)
    }
    ctx.say(Route8.LeslieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.LeslieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_ANDREA, Route8_Text_AndreaIntro, Route8_Text_AndreaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_AndreaRematch
 * msgbox Route8_Text_AndreaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Andrea : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_ANDREA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_AndreaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.AndreaPostBattle)
    }
    ctx.say(Route8.AndreaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.AndreaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_MEGAN, Route8_Text_MeganIntro, Route8_Text_MeganDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_MeganRematch
 * msgbox Route8_Text_MeganPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Megan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_MEGAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_MeganRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.MeganPostBattle)
    }
    ctx.say(Route8.MeganIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.MeganDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GAMER_STAN, Route8_Text_StanIntro, Route8_Text_StanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_StanRematch
 * msgbox Route8_Text_StanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Stan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GAMER_STAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_StanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.StanPostBattle)
    }
    ctx.say(Route8.StanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.StanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_AIDAN, Route8_Text_AidanIntro, Route8_Text_AidanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_AidanRematch
 * msgbox Route8_Text_AidanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Aidan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SUPER_NERD_AIDAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_AidanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.AidanPostBattle)
    }
    ctx.say(Route8.AidanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.AidanDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_ELI_ANNE, Route8_Text_EliIntro, Route8_Text_EliDefeat, Route8_Text_EliNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_EliRematch
 * msgbox Route8_Text_EliPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Eli : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route8_EventScript_Eli")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_ELI_ANNE, Route8_Text_AnneIntro, Route8_Text_AnneDefeat, Route8_Text_AnneNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_AnneRematch
 * msgbox Route8_Text_AnnePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Anne : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route8_EventScript_Anne")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIKER_RICARDO, Route8_Text_RicardoIntro, Route8_Text_RicardoDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_RicardoRematch
 * msgbox Route8_Text_RicardoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Ricardo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIKER_RICARDO
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_RicardoRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.RicardoPostBattle)
    }
    ctx.say(Route8.RicardoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.RicardoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIKER_JAREN, Route8_Text_JarenIntro, Route8_Text_JarenDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route8_EventScript_JarenRematch
 * msgbox Route8_Text_JarenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route8_EventScript_Jaren : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIKER_JAREN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route8_EventScript_JarenRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route8.JarenPostBattle)
    }
    ctx.say(Route8.JarenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route8.JarenDefeat)
  }
}

internal object Route8_EventScript_UndergroundPathSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route8.UndergroundPathSign)
}

internal val Route8Scripts: Map<String, Script> =
    mapOf(
        "Route8_EventScript_Julia" to Route8_EventScript_Julia,
        "Route8_EventScript_Rich" to Route8_EventScript_Rich,
        "Route8_EventScript_Glenn" to Route8_EventScript_Glenn,
        "Route8_EventScript_Paige" to Route8_EventScript_Paige,
        "Route8_EventScript_Leslie" to Route8_EventScript_Leslie,
        "Route8_EventScript_Andrea" to Route8_EventScript_Andrea,
        "Route8_EventScript_Megan" to Route8_EventScript_Megan,
        "Route8_EventScript_Stan" to Route8_EventScript_Stan,
        "Route8_EventScript_Aidan" to Route8_EventScript_Aidan,
        "Route8_EventScript_Eli" to Route8_EventScript_Eli,
        "Route8_EventScript_Anne" to Route8_EventScript_Anne,
        "Route8_EventScript_Ricardo" to Route8_EventScript_Ricardo,
        "Route8_EventScript_Jaren" to Route8_EventScript_Jaren,
        "Route8_EventScript_UndergroundPathSign" to Route8_EventScript_UndergroundPathSign,
    )
