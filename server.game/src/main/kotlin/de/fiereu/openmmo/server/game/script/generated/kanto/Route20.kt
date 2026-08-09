package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route20
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_MELISSA, Route20_Text_MelissaIntro, Route20_Text_MelissaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_MelissaRematch
 * msgbox Route20_Text_MelissaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Melissa : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_MELISSA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_MelissaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.MelissaPostBattle)
    }
    ctx.say(Route20.MelissaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.MelissaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_MISSY, Route20_Text_MissyIntro, Route20_Text_MissyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_MissyRematch
 * msgbox Route20_Text_MissyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Missy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_MISSY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_MissyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.MissyPostBattle)
    }
    ctx.say(Route20.MissyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.MissyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_NORA, Route20_Text_NoraIntro, Route20_Text_NoraDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_NoraRematch
 * msgbox Route20_Text_NoraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Nora : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_NORA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_NoraRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.NoraPostBattle)
    }
    ctx.say(Route20.NoraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.NoraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BIRD_KEEPER_ROGER, Route20_Text_RogerIntro, Route20_Text_RogerDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_RogerRematch
 * msgbox Route20_Text_RogerPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Roger : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BIRD_KEEPER_ROGER
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_RogerRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.RogerPostBattle)
    }
    ctx.say(Route20.RogerIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.RogerDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_DEAN, Route20_Text_DeanIntro, Route20_Text_DeanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_DeanRematch
 * msgbox Route20_Text_DeanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Dean : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_DEAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_DeanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.DeanPostBattle)
    }
    ctx.say(Route20.DeanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.DeanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_IRENE, Route20_Text_IreneIntro, Route20_Text_IreneDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_IreneRematch
 * msgbox Route20_Text_IrenePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Irene : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_IRENE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_IreneRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.IrenePostBattle)
    }
    ctx.say(Route20.IreneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.IreneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_BARRY, Route20_Text_BarryIntro, Route20_Text_BarryDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_BarryRematch
 * msgbox Route20_Text_BarryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Barry : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_BARRY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_BarryRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.BarryPostBattle)
    }
    ctx.say(Route20.BarryIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.BarryDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_DARRIN, Route20_Text_DarrinIntro, Route20_Text_DarrinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_DarrinRematch
 * msgbox Route20_Text_DarrinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Darrin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_DARRIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_DarrinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.DarrinPostBattle)
    }
    ctx.say(Route20.DarrinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.DarrinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_SHIRLEY, Route20_Text_ShirleyIntro, Route20_Text_ShirleyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_ShirleyRematch
 * msgbox Route20_Text_ShirleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Shirley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_SHIRLEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_ShirleyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.ShirleyPostBattle)
    }
    ctx.say(Route20.ShirleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.ShirleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_TIFFANY, Route20_Text_TiffanyIntro, Route20_Text_TiffanyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route20_EventScript_TiffanyRematch
 * msgbox Route20_Text_TiffanyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route20_EventScript_Tiffany : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_TIFFANY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route20_EventScript_TiffanyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route20.TiffanyPostBattle)
    }
    ctx.say(Route20.TiffanyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route20.TiffanyDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_MISTY, 3
 * msgbox Route20_Text_MistyTrainsHere
 * release
 * end
 * ```
 */
internal object Route20_EventScript_Camper : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route20_EventScript_Camper")
}

internal object Route20_EventScript_SeafoamIslandsSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route20.SeafoamIslands)
}

internal val Route20Scripts: Map<String, Script> =
    mapOf(
        "Route20_EventScript_Melissa" to Route20_EventScript_Melissa,
        "Route20_EventScript_Missy" to Route20_EventScript_Missy,
        "Route20_EventScript_Nora" to Route20_EventScript_Nora,
        "Route20_EventScript_Roger" to Route20_EventScript_Roger,
        "Route20_EventScript_Dean" to Route20_EventScript_Dean,
        "Route20_EventScript_Irene" to Route20_EventScript_Irene,
        "Route20_EventScript_Barry" to Route20_EventScript_Barry,
        "Route20_EventScript_Darrin" to Route20_EventScript_Darrin,
        "Route20_EventScript_Shirley" to Route20_EventScript_Shirley,
        "Route20_EventScript_Tiffany" to Route20_EventScript_Tiffany,
        "Route20_EventScript_Camper" to Route20_EventScript_Camper,
        "Route20_EventScript_SeafoamIslandsSign" to Route20_EventScript_SeafoamIslandsSign,
    )
