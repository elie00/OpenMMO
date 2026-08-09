package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route105
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LUIS, Route105_Text_LuisIntro, Route105_Text_LuisDefeated
 * msgbox Route105_Text_LuisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route105_EventScript_Luis : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LUIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route105.LuisPostBattle)
    }
    ctx.say(Route105.LuisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route105.LuisDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DOMINIK, Route105_Text_DominikIntro, Route105_Text_DominikDefeated
 * msgbox Route105_Text_DominikPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route105_EventScript_Dominik : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DOMINIK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route105.DominikPostBattle)
    }
    ctx.say(Route105.DominikIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route105.DominikDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEVERLY, Route105_Text_BeverlyIntro, Route105_Text_BeverlyDefeated
 * msgbox Route105_Text_PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route105_EventScript_Beverly : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BEVERLY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route105.PostBattle)
    }
    ctx.say(Route105.BeverlyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route105.BeverlyDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_IMANI, Route105_Text_ImaniIntro, Route105_Text_ImaniDefeated
 * msgbox Route105_Text_ImaniPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route105_EventScript_Imani : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_IMANI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route105.ImaniPostBattle)
    }
    ctx.say(Route105.ImaniIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route105.ImaniDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_IRON
 * end
 * ```
 */
internal object Route105_EventScript_ItemIron : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route105_EventScript_ItemIron")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FOSTER, Route105_Text_FosterIntro, Route105_Text_FosterDefeated
 * msgbox Route105_Text_FosterPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route105_EventScript_Foster : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_FOSTER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route105.FosterPostBattle)
    }
    ctx.say(Route105.FosterIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route105.FosterDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JOSUE, Route105_Text_JosueIntro, Route105_Text_JosueDefeated
 * msgbox Route105_Text_JosuePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route105_EventScript_Josue : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JOSUE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route105.JosuePostBattle)
    }
    ctx.say(Route105.JosueIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route105.JosueDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_ANDRES_1, Route105_Text_AndresIntro, Route105_Text_AndresDefeated, Route105_EventScript_AndresRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route105_EventScript_AndresRematch
 * msgbox Route105_Text_AndresPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route105_EventScript_Andres : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route105_EventScript_Andres")
}

internal val Route105Scripts: Map<String, Script> =
    mapOf(
        "Route105_EventScript_Luis" to Route105_EventScript_Luis,
        "Route105_EventScript_Dominik" to Route105_EventScript_Dominik,
        "Route105_EventScript_Beverly" to Route105_EventScript_Beverly,
        "Route105_EventScript_Imani" to Route105_EventScript_Imani,
        "Route105_EventScript_ItemIron" to Route105_EventScript_ItemIron,
        "Route105_EventScript_Foster" to Route105_EventScript_Foster,
        "Route105_EventScript_Josue" to Route105_EventScript_Josue,
        "Route105_EventScript_Andres" to Route105_EventScript_Andres,
    )
