package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route119_WeatherInstitute_2F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_WEATHER_INST_2, Route119_WeatherInstitute_2F_Text_Grunt2Intro, Route119_WeatherInstitute_2F_Text_Grunt2Defeat
 * msgbox Route119_WeatherInstitute_2F_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_WEATHER_INST_2
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119_WeatherInstitute_2F.Grunt2PostBattle)
    }
    ctx.say(Route119_WeatherInstitute_2F.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119_WeatherInstitute_2F.Grunt2Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_WEATHER_INST_3, Route119_WeatherInstitute_2F_Text_Grunt3Intro, Route119_WeatherInstitute_2F_Text_Grunt3Defeat
 * msgbox Route119_WeatherInstitute_2F_Text_Grunt3PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_WEATHER_INST_3
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119_WeatherInstitute_2F.Grunt3PostBattle)
    }
    ctx.say(Route119_WeatherInstitute_2F.Grunt3Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119_WeatherInstitute_2F.Grunt3Defeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SHELLY_WEATHER_INSTITUTE, Route119_WeatherInstitute_2F_Text_ShellyIntro, Route119_WeatherInstitute_2F_Text_ShellyDefeat, Route119_WeatherInstitute_2F_EventScript_ShellyDefeated
 * msgbox Route119_WeatherInstitute_2F_Text_ShellyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_Shelly : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_Shelly")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_CASTFORM, Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather
 * goto Route119_WeatherInstitute_2F_EventScript_ReceiveCastform
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_WeatherScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_WeatherScientist")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_WEATHER_INST_5, Route119_WeatherInstitute_2F_Text_Grunt5Intro, Route119_WeatherInstitute_2F_Text_Grunt5Defeat
 * msgbox Route119_WeatherInstitute_2F_Text_Grunt5PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_Grunt5 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_WEATHER_INST_5
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119_WeatherInstitute_2F.Grunt5PostBattle)
    }
    ctx.say(Route119_WeatherInstitute_2F.Grunt5Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119_WeatherInstitute_2F.Grunt5Defeat)
  }
}

internal val Route119_WeatherInstitute_2FScripts: Map<String, Script> =
    mapOf(
        "Route119_WeatherInstitute_2F_EventScript_Grunt2" to
            Route119_WeatherInstitute_2F_EventScript_Grunt2,
        "Route119_WeatherInstitute_2F_EventScript_Grunt3" to
            Route119_WeatherInstitute_2F_EventScript_Grunt3,
        "Route119_WeatherInstitute_2F_EventScript_Shelly" to
            Route119_WeatherInstitute_2F_EventScript_Shelly,
        "Route119_WeatherInstitute_2F_EventScript_WeatherScientist" to
            Route119_WeatherInstitute_2F_EventScript_WeatherScientist,
        "Route119_WeatherInstitute_2F_EventScript_Grunt5" to
            Route119_WeatherInstitute_2F_EventScript_Grunt5,
    )
