package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FiveIsland_ResortGorgeous
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAINTER_DAISY, FiveIsland_ResortGorgeous_Text_DaisyIntro, FiveIsland_ResortGorgeous_Text_DaisyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_DaisyRematch
 * msgbox FiveIsland_ResortGorgeous_Text_DaisyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Daisy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PAINTER_DAISY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_DaisyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.DaisyPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.DaisyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.DaisyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAINTER_CELINA, FiveIsland_ResortGorgeous_Text_CelinaIntro, FiveIsland_ResortGorgeous_Text_CelinaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_CelinaRematch
 * msgbox FiveIsland_ResortGorgeous_Text_CelinaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Celina : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PAINTER_CELINA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_CelinaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.CelinaPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.CelinaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.CelinaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAINTER_RAYNA, FiveIsland_ResortGorgeous_Text_RaynaIntro, FiveIsland_ResortGorgeous_Text_RaynaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_RaynaRematch
 * msgbox FiveIsland_ResortGorgeous_Text_RaynaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Rayna : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PAINTER_RAYNA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_RaynaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.RaynaPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.RaynaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.RaynaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LADY_JACKI, FiveIsland_ResortGorgeous_Text_JackiIntro, FiveIsland_ResortGorgeous_Text_JackiDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_JackiRematch
 * msgbox FiveIsland_ResortGorgeous_Text_JackiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Jacki : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LADY_JACKI
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_JackiRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.JackiPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.JackiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.JackiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LADY_GILLIAN, FiveIsland_ResortGorgeous_Text_GillianIntro, FiveIsland_ResortGorgeous_Text_GillianDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_GillianRematch
 * msgbox FiveIsland_ResortGorgeous_Text_GillianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Gillian : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LADY_GILLIAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_GillianRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.GillianPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.GillianIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.GillianDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_DESTIN, FiveIsland_ResortGorgeous_Text_DestinIntro, FiveIsland_ResortGorgeous_Text_DestinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_DestinRematch
 * msgbox FiveIsland_ResortGorgeous_Text_DestinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Destin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_DESTIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_DestinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.DestinPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.DestinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.DestinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_TOBY, FiveIsland_ResortGorgeous_Text_TobyIntro, FiveIsland_ResortGorgeous_Text_TobyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_EventScript_TobyRematch
 * msgbox FiveIsland_ResortGorgeous_Text_TobyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_EventScript_Toby : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_TOBY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_ResortGorgeous_EventScript_TobyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_ResortGorgeous.TobyPostBattle)
    }
    ctx.say(FiveIsland_ResortGorgeous.TobyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_ResortGorgeous.TobyDefeat)
  }
}

internal object FiveIsland_ResortGorgeous_EventScript_SelphysHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FiveIsland_ResortGorgeous.SelphysHouse)
}

internal val FiveIsland_ResortGorgeousScripts: Map<String, Script> =
    mapOf(
        "FiveIsland_ResortGorgeous_EventScript_Daisy" to
            FiveIsland_ResortGorgeous_EventScript_Daisy,
        "FiveIsland_ResortGorgeous_EventScript_Celina" to
            FiveIsland_ResortGorgeous_EventScript_Celina,
        "FiveIsland_ResortGorgeous_EventScript_Rayna" to
            FiveIsland_ResortGorgeous_EventScript_Rayna,
        "FiveIsland_ResortGorgeous_EventScript_Jacki" to
            FiveIsland_ResortGorgeous_EventScript_Jacki,
        "FiveIsland_ResortGorgeous_EventScript_Gillian" to
            FiveIsland_ResortGorgeous_EventScript_Gillian,
        "FiveIsland_ResortGorgeous_EventScript_Destin" to
            FiveIsland_ResortGorgeous_EventScript_Destin,
        "FiveIsland_ResortGorgeous_EventScript_Toby" to FiveIsland_ResortGorgeous_EventScript_Toby,
        "FiveIsland_ResortGorgeous_EventScript_SelphysHouseSign" to
            FiveIsland_ResortGorgeous_EventScript_SelphysHouseSign,
    )
