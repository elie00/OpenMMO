package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route125
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_NOLEN, Route125_Text_NolenIntro, Route125_Text_NolenDefeat
 * msgbox Route125_Text_NolenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Nolen : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_NOLEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route125.NolenPostBattle)
    }
    ctx.say(Route125.NolenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route125.NolenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_STAN, Route125_Text_StanIntro, Route125_Text_StanDefeat
 * msgbox Route125_Text_StanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Stan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_STAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route125.StanPostBattle)
    }
    ctx.say(Route125.StanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route125.StanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TANYA, Route125_Text_TanyaIntro, Route125_Text_TanyaDefeat
 * msgbox Route125_Text_TanyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Tanya : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TANYA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route125.TanyaPostBattle)
    }
    ctx.say(Route125.TanyaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route125.TanyaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SHARON, Route125_Text_SharonIntro, Route125_Text_SharonDefeat
 * msgbox Route125_Text_SharonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Sharon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SHARON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route125.SharonPostBattle)
    }
    ctx.say(Route125.SharonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route125.SharonDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_ERNEST_1, Route125_Text_ErnestIntro, Route125_Text_ErnestDefeat, Route125_EventScript_RegisterErnest
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route125_EventScript_RematchErnest
 * msgbox Route125_Text_ErnestPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route125_EventScript_Ernest : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route125_EventScript_Ernest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_KIM_AND_IRIS, Route125_Text_KimIntro, Route125_Text_KimDefeat, Route125_Text_KimNotEnoughMons
 * msgbox Route125_Text_KimPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Kim : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route125_EventScript_Kim")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_KIM_AND_IRIS, Route125_Text_IrisIntro, Route125_Text_IrisDefeat, Route125_Text_IrisNotEnoughMons
 * msgbox Route125_Text_IrisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Iris : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route125_EventScript_Iris")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PRESLEY, Route125_Text_PresleyIntro, Route125_Text_PresleyDefeat
 * msgbox Route125_Text_PresleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Presley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PRESLEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route125.PresleyPostBattle)
    }
    ctx.say(Route125.PresleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route125.PresleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AURON, Route125_Text_AuronIntro, Route125_Text_AuronDefeat
 * msgbox Route125_Text_AuronPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route125_EventScript_Auron : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_AURON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route125.AuronPostBattle)
    }
    ctx.say(Route125.AuronIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route125.AuronDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BIG_PEARL
 * end
 * ```
 */
internal object Route125_EventScript_ItemBigPearl : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BIG_PEARL, HoennFlags.FLAG_ITEM_ROUTE_125_BIG_PEARL, 9)
  }
}

internal val Route125Scripts: Map<String, Script> =
    mapOf(
        "Route125_EventScript_Nolen" to Route125_EventScript_Nolen,
        "Route125_EventScript_Stan" to Route125_EventScript_Stan,
        "Route125_EventScript_Tanya" to Route125_EventScript_Tanya,
        "Route125_EventScript_Sharon" to Route125_EventScript_Sharon,
        "Route125_EventScript_Ernest" to Route125_EventScript_Ernest,
        "Route125_EventScript_Kim" to Route125_EventScript_Kim,
        "Route125_EventScript_Iris" to Route125_EventScript_Iris,
        "Route125_EventScript_Presley" to Route125_EventScript_Presley,
        "Route125_EventScript_Auron" to Route125_EventScript_Auron,
        "Route125_EventScript_ItemBigPearl" to Route125_EventScript_ItemBigPearl,
    )
