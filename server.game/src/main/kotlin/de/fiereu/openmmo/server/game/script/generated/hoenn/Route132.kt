package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route132
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GILBERT, Route132_Text_GilbertIntro, Route132_Text_GilbertDefeat
 * msgbox Route132_Text_GilbertPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Gilbert : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GILBERT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.GilbertPostBattle)
    }
    ctx.say(Route132.GilbertIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.GilbertDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DANA, Route132_Text_DanaIntro, Route132_Text_DanaDefeat
 * msgbox Route132_Text_DanaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Dana : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DANA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.DanaPostBattle)
    }
    ctx.say(Route132.DanaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.DanaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object Route132_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route132_EventScript_ItemRareCandy")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KIYO, Route132_Text_KiyoIntro, Route132_Text_KiyoDefeat
 * msgbox Route132_Text_KiyoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Kiyo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KIYO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.KiyoPostBattle)
    }
    ctx.say(Route132.KiyoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.KiyoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RONALD, Route132_Text_RonaldIntro, Route132_Text_RonaldDefeat
 * msgbox Route132_Text_RonaldPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Ronald : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RONALD
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.RonaldPostBattle)
    }
    ctx.say(Route132.RonaldIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.RonaldDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAXTON, Route132_Text_PaxtonIntro, Route132_Text_PaxtonDefeat
 * msgbox Route132_Text_PaxtonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Paxton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PAXTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.PaxtonPostBattle)
    }
    ctx.say(Route132.PaxtonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.PaxtonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DARCY, Route132_Text_DarcyIntro, Route132_Text_DarcyDefeat
 * msgbox Route132_Text_DarcyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Darcy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DARCY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.DarcyPostBattle)
    }
    ctx.say(Route132.DarcyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.DarcyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MAKAYLA, Route132_Text_MakaylaIntro, Route132_Text_MakaylaDefeat
 * msgbox Route132_Text_MakaylaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Makayla : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MAKAYLA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.MakaylaPostBattle)
    }
    ctx.say(Route132.MakaylaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.MakaylaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JONATHAN, Route132_Text_JonathanIntro, Route132_Text_JonathanDefeat
 * msgbox Route132_Text_JonathanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route132_EventScript_Jonathan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JONATHAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route132.JonathanPostBattle)
    }
    ctx.say(Route132.JonathanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route132.JonathanDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_PROTEIN
 * end
 * ```
 */
internal object Route132_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route132_EventScript_ItemProtein")
}

internal val Route132Scripts: Map<String, Script> =
    mapOf(
        "Route132_EventScript_Gilbert" to Route132_EventScript_Gilbert,
        "Route132_EventScript_Dana" to Route132_EventScript_Dana,
        "Route132_EventScript_ItemRareCandy" to Route132_EventScript_ItemRareCandy,
        "Route132_EventScript_Kiyo" to Route132_EventScript_Kiyo,
        "Route132_EventScript_Ronald" to Route132_EventScript_Ronald,
        "Route132_EventScript_Paxton" to Route132_EventScript_Paxton,
        "Route132_EventScript_Darcy" to Route132_EventScript_Darcy,
        "Route132_EventScript_Makayla" to Route132_EventScript_Makayla,
        "Route132_EventScript_Jonathan" to Route132_EventScript_Jonathan,
        "Route132_EventScript_ItemProtein" to Route132_EventScript_ItemProtein,
    )
