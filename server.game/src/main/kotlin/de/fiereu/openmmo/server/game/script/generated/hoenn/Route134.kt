package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route134
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JACK, Route134_Text_JackIntro, Route134_Text_JackDefeat
 * msgbox Route134_Text_JackPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Jack : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JACK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.JackPostBattle)
    }
    ctx.say(Route134.JackIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.JackDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LAUREL, Route134_Text_LaurelIntro, Route134_Text_LaurelDefeat
 * msgbox Route134_Text_LaurelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Laurel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LAUREL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.LaurelPostBattle)
    }
    ctx.say(Route134.LaurelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.LaurelDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AARON, Route134_Text_AaronIntro, Route134_Text_AaronDefeat
 * msgbox Route134_Text_AaronPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Aaron : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_AARON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.AaronPostBattle)
    }
    ctx.say(Route134.AaronIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.AaronDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALEX, Route134_Text_AlexIntro, Route134_Text_AlexDefeat
 * msgbox Route134_Text_AlexPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Alex : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALEX
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.AlexPostBattle)
    }
    ctx.say(Route134.AlexIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.AlexDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HITOSHI, Route134_Text_HitoshiIntro, Route134_Text_HitoshiDefeat
 * msgbox Route134_Text_HitoshiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Hitoshi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HITOSHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.HitoshiPostBattle)
    }
    ctx.say(Route134.HitoshiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.HitoshiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MARLEY, Route134_Text_MarleyIntro, Route134_Text_MarleyDefeat
 * msgbox Route134_Text_MarleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Marley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MARLEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.MarleyPostBattle)
    }
    ctx.say(Route134.MarleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.MarleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KELVIN, Route134_Text_KelvinIntro, Route134_Text_KelvinDefeat
 * msgbox Route134_Text_KelvinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Kelvin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KELVIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.KelvinPostBattle)
    }
    ctx.say(Route134.KelvinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.KelvinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_REYNA, Route134_Text_ReynaIntro, Route134_Text_ReynaDefeat
 * msgbox Route134_Text_ReynaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Reyna : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_REYNA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.ReynaPostBattle)
    }
    ctx.say(Route134.ReynaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.ReynaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HUDSON, Route134_Text_HudsonIntro, Route134_Text_HudsonDefeat
 * msgbox Route134_Text_HudsonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route134_EventScript_Hudson : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HUDSON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route134.HudsonPostBattle)
    }
    ctx.say(Route134.HudsonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route134.HudsonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARBOS
 * end
 * ```
 */
internal object Route134_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARBOS, HoennFlags.FLAG_ITEM_ROUTE_134_CARBOS, 9)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_STAR_PIECE
 * end
 * ```
 */
internal object Route134_EventScript_ItemStarPiece : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.STAR_PIECE, HoennFlags.FLAG_ITEM_ROUTE_134_STAR_PIECE, 10)
  }
}

internal val Route134Scripts: Map<String, Script> =
    mapOf(
        "Route134_EventScript_Jack" to Route134_EventScript_Jack,
        "Route134_EventScript_Laurel" to Route134_EventScript_Laurel,
        "Route134_EventScript_Aaron" to Route134_EventScript_Aaron,
        "Route134_EventScript_Alex" to Route134_EventScript_Alex,
        "Route134_EventScript_Hitoshi" to Route134_EventScript_Hitoshi,
        "Route134_EventScript_Marley" to Route134_EventScript_Marley,
        "Route134_EventScript_Kelvin" to Route134_EventScript_Kelvin,
        "Route134_EventScript_Reyna" to Route134_EventScript_Reyna,
        "Route134_EventScript_Hudson" to Route134_EventScript_Hudson,
        "Route134_EventScript_ItemCarbos" to Route134_EventScript_ItemCarbos,
        "Route134_EventScript_ItemStarPiece" to Route134_EventScript_ItemStarPiece,
    )
