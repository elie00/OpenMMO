package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route119_WeatherInstitute_2F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
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
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_CASTFORM, Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather
 * goto Route119_WeatherInstitute_2F_EventScript_ReceiveCastform
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_WeatherScientist : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_CASTFORM))
        return Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather.run(ctx)
    return Route119_WeatherInstitute_2F_EventScript_ReceiveCastform.run(ctx)
  }
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

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route119_WeatherInstitute_2F_Text_ThanksPleaseTakePokemon, MSGBOX_DEFAULT
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_CASTFORM
 * givemon SPECIES_CASTFORM, 25, ITEM_MYSTIC_WATER
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, Route119_WeatherInstitute_2F_EventScript_ReceiveCastformParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, Route119_WeatherInstitute_2F_EventScript_ReceiveCastformPC
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_ReceiveCastform : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_ReceiveCastform")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_SYS_GAME_CLEAR, Route119_WeatherInstitute_2F_EventScript_TryStartAbnormalWeather
 * msgbox Route119_WeatherInstitute_2F_Text_ChangingWeatherRidiculous, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * call_if_set FLAG_DEFEATED_KYOGRE, Route119_WeatherInstitute_2F_EventScript_LegendaryDefeated
 * call_if_set FLAG_DEFEATED_GROUDON, Route119_WeatherInstitute_2F_EventScript_LegendaryDefeated
 * goto_if_eq VAR_0x8004, 2, Route119_WeatherInstitute_2F_EventScript_NoAbnormalWeather  @ Both defeated
 * call_if_unset FLAG_TEMP_2, Route119_WeatherInstitute_2F_EventScript_CreateAbnormalWeather
 * specialvar VAR_RESULT, GetAbnormalWeatherMapNameAndType
 * goto_if_eq VAR_RESULT, 1, Route119_WeatherInstitute_2F_EventScript_KyogreWeather
 * msgbox Route119_WeatherInstitute_2F_Text_GroudonWeather, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_TryStartAbnormalWeather : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_TryStartAbnormalWeather")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call Route119_WeatherInstitute_2F_EventScript_ReceivedCastformFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route119_WeatherInstitute_2F_EventScript_SendCastformToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto Route119_WeatherInstitute_2F_EventScript_SendCastformToPC
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_ReceiveCastformPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_ReceiveCastformPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call Route119_WeatherInstitute_2F_EventScript_ReceivedCastformFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route119_WeatherInstitute_2F_EventScript_ExplainCastform
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto Route119_WeatherInstitute_2F_EventScript_ExplainCastform
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_ReceiveCastformParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_ReceiveCastformParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special CreateAbnormalWeatherEvent
 * setflag FLAG_TEMP_2
 * return
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_CreateAbnormalWeather : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_CreateAbnormalWeather")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route119_WeatherInstitute_2F_Text_PokemonChangesWithWeather, MSGBOX_DEFAULT
 * setflag FLAG_RECEIVED_CASTFORM
 * release
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_ExplainCastform : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route119_WeatherInstitute_2F.PokemonChangesWithWeather)
    ctx.setFlag(HoennFlags.FLAG_RECEIVED_CASTFORM)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_0x8004, 1
 * return
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_LegendaryDefeated : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_LegendaryDefeated")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route119_WeatherInstitute_2F_Text_KyogreWeather, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_KyogreWeather : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route119_WeatherInstitute_2F.KyogreWeather)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto Route119_WeatherInstitute_2F_EventScript_ExplainCastform
 * end
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_SendCastformToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return Route119_WeatherInstitute_2F_EventScript_ExplainCastform.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playfanfare MUS_OBTAIN_ITEM
 * message Route119_WeatherInstitute_2F_Text_PlayerReceivedCastform
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_CASTFORM
 * return
 * ```
 */
internal object Route119_WeatherInstitute_2F_EventScript_ReceivedCastformFanfare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route119_WeatherInstitute_2F_EventScript_ReceivedCastformFanfare")
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
        "Route119_WeatherInstitute_2F_EventScript_ReceiveCastform" to
            Route119_WeatherInstitute_2F_EventScript_ReceiveCastform,
        "Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather" to
            Route119_WeatherInstitute_2F_EventScript_ScientistMentionWeather,
        "Route119_WeatherInstitute_2F_EventScript_TryStartAbnormalWeather" to
            Route119_WeatherInstitute_2F_EventScript_TryStartAbnormalWeather,
        "Route119_WeatherInstitute_2F_EventScript_ReceiveCastformPC" to
            Route119_WeatherInstitute_2F_EventScript_ReceiveCastformPC,
        "Route119_WeatherInstitute_2F_EventScript_ReceiveCastformParty" to
            Route119_WeatherInstitute_2F_EventScript_ReceiveCastformParty,
        "Route119_WeatherInstitute_2F_EventScript_CreateAbnormalWeather" to
            Route119_WeatherInstitute_2F_EventScript_CreateAbnormalWeather,
        "Route119_WeatherInstitute_2F_EventScript_ExplainCastform" to
            Route119_WeatherInstitute_2F_EventScript_ExplainCastform,
        "Route119_WeatherInstitute_2F_EventScript_LegendaryDefeated" to
            Route119_WeatherInstitute_2F_EventScript_LegendaryDefeated,
        "Route119_WeatherInstitute_2F_EventScript_KyogreWeather" to
            Route119_WeatherInstitute_2F_EventScript_KyogreWeather,
        "Route119_WeatherInstitute_2F_EventScript_SendCastformToPC" to
            Route119_WeatherInstitute_2F_EventScript_SendCastformToPC,
        "Route119_WeatherInstitute_2F_EventScript_ReceivedCastformFanfare" to
            Route119_WeatherInstitute_2F_EventScript_ReceivedCastformFanfare,
    )
