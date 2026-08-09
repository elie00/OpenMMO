package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 6, SootopolisCity_EventScript_ExpertPostLegendaries
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_ExpertLegendaries
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 2, SootopolisCity_EventScript_ExpertLeadToCave
 * msgbox SootopolisCity_Text_CaveOfOriginPleaseLeave, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_CaveOfOriginExpert : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_CaveOfOriginExpert")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_WOMAN_2, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_Woman2Rayquaza
 * msgbox SootopolisCity_Text_WeatherWentWild, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_WOMAN_2, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Woman2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Woman2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_le VAR_SOOTOPOLIS_CITY_STATE, 1, SootopolisCity_EventScript_KiriGiveBerry
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 6, SootopolisCity_EventScript_KiriGiveBerry
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_KiriRayquaza
 * msgbox SootopolisCity_Text_BigPokemonFighting, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_KIRI, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Kiri : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Kiri")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_NINJA_BOY, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_NinjaBoyRayquaza
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 6, SootopolisCity_EventScript_NinjaBoyNormal
 * goto_if_le VAR_SOOTOPOLIS_CITY_STATE, 1, SootopolisCity_EventScript_NinjaBoyNormal
 * msgbox SootopolisCity_Text_ThisIsWicked, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_NINJA_BOY, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_NinjaBoy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_NinjaBoy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_BOY_1, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_Boy1Rayquaza
 * goto_if_set FLAG_SYS_GAME_CLEAR, SootopolisCity_EventScript_Boy1GameClear
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 6, SootopolisCity_EventScript_Boy1Normal
 * goto_if_le VAR_SOOTOPOLIS_CITY_STATE, 1, SootopolisCity_EventScript_Boy1Normal
 * msgbox SootopolisCity_Text_GiantPokemonSuddenlyAppeared, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_BOY_1, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Boy1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Boy1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 6, SootopolisCity_EventScript_ManPostLegendaries
 * msgbox SootopolisCity_Text_NoOrdinaryTourist, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Man")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_STEVEN, Common_Movement_FacePlayer
 * waitmovement 0
 * call_if_unset FLAG_STEVEN_GUIDES_TO_CAVE_OF_ORIGIN, SootopolisCity_EventScript_StevenLeadPlayerCaveOfOrigin
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 2, SootopolisCity_EventScript_StevenHelpWallace
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 3, SootopolisCity_EventScript_StevenHelpedWallace
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 4, SootopolisCity_EventScript_StevenHelpedWallace
 * goto_if_set FLAG_SOOTOPOLIS_ARCHIE_MAXIE_LEAVE, SootopolisCity_EventScript_StevenMaxieArchieLeft
 * msgbox SootopolisCity_Text_SoThatsRayquaza, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Steven : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Steven")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 6, SootopolisCity_EventScript_Woman1PostLegendaries
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_Woman1Rayquaza
 * goto_if_ge VAR_SOOTOPOLIS_CITY_STATE, 2, SootopolisCity_EventScript_Woman1Legendaries
 * msgbox SootopolisCity_Text_SootopolisSkyBeautiful, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Woman1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Woman1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_MANIAC, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_ManiacRayquaza
 * msgbox SootopolisCity_Text_SeeingLegendWithOwnEyes, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_MANIAC, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Maniac : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Maniac")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_GIRL, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_GirlRayquaza
 * msgbox SootopolisCity_Text_SootopolisWillBeWrecked, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_GIRL, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Girl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_BlackBeltRayquaza
 * msgbox SootopolisCity_Text_GoRedAndBlueMon, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_BLACK_BELT, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox SootopolisCity_Text_DoYouKnowMonNames, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_BLACK_BELT, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_BlackBelt")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_SOOTOPOLIS_BOY_2, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_Boy2Rayquaza
 * msgbox SootopolisCity_Text_TwoPokemonArentAngry, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_BOY_2, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Boy2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_EventScript_Boy2")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_MaxieRayquaza
 * msgbox SootopolisCity_Text_GroudonPleaseStop, MSGBOX_DEFAULT
 * closemessage
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Maxie : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_SOOTOPOLIS_CITY_STATE) == 5)
        return SootopolisCity_EventScript_MaxieRayquaza.run(ctx)
    ctx.say(SootopolisCity.GroudonPleaseStop)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 5, SootopolisCity_EventScript_ArchieRayquaza
 * msgbox SootopolisCity_Text_KyogreCalmDown, MSGBOX_DEFAULT
 * closemessage
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Archie : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_SOOTOPOLIS_CITY_STATE) == 5)
        return SootopolisCity_EventScript_ArchieRayquaza.run(ctx)
    ctx.say(SootopolisCity.KyogreCalmDown)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_SOOTOPOLIS_CITY_STATE, 4, SootopolisCity_EventScript_GoToSkyPillar
 * goto_if_set FLAG_RECEIVED_HM_WATERFALL, SootopolisCity_EventScript_GoToGym
 * goto_if_set FLAG_SOOTOPOLIS_ARCHIE_MAXIE_LEAVE, SootopolisCity_EventScript_GiveWaterfall
 * msgbox SootopolisCity_Text_AquaMagmaDidntMeanHarm, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Wallace : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_SOOTOPOLIS_CITY_STATE) == 4)
        return SootopolisCity_EventScript_GoToSkyPillar.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_HM_WATERFALL))
        return SootopolisCity_EventScript_GoToGym.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_SOOTOPOLIS_ARCHIE_MAXIE_LEAVE))
        return SootopolisCity_EventScript_GiveWaterfall.run(ctx)
    ctx.say(SootopolisCity.AquaMagmaDidntMeanHarm)
  }
}

internal object SootopolisCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SootopolisCity.GymSign)
}

internal object SootopolisCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SootopolisCity.CitySign)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_AfterAllOurScheming, MSGBOX_DEFAULT
 * setflag FLAG_MET_MAXIE_SOOTOPOLIS
 * goto_if_set FLAG_MET_ARCHIE_SOOTOPOLIS, SootopolisCity_EventScript_MaxieArchieLeave
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_MaxieRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.AfterAllOurScheming)
    ctx.setFlag(HoennFlags.FLAG_MET_MAXIE_SOOTOPOLIS)
    if (ctx.isFlagSet(HoennFlags.FLAG_MET_ARCHIE_SOOTOPOLIS))
        return SootopolisCity_EventScript_MaxieArchieLeave.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_TryingMeaninglessToPokemon, MSGBOX_DEFAULT
 * setflag FLAG_MET_ARCHIE_SOOTOPOLIS
 * goto_if_set FLAG_MET_MAXIE_SOOTOPOLIS, SootopolisCity_EventScript_MaxieArchieLeave
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_ArchieRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.TryingMeaninglessToPokemon)
    ctx.setFlag(HoennFlags.FLAG_MET_ARCHIE_SOOTOPOLIS)
    if (ctx.isFlagSet(HoennFlags.FLAG_MET_MAXIE_SOOTOPOLIS))
        return SootopolisCity_EventScript_MaxieArchieLeave.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SOOTOPOLIS_BLACK_BELT, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox SootopolisCity_Text_GreenOneSettlesThings, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_BlackBeltRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_BlackBeltRayquaza")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_WhatIsThatGreenPokemon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Boy1Rayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.WhatIsThatGreenPokemon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_FearedWorstWhenPokemonFlewDown, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Woman1Rayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.FearedWorstWhenPokemonFlewDown)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_HaventYouScaledSkyPillar, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_GoToSkyPillar : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.HaventYouScaledSkyPillar)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_AwakenedPokemonClash, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_ExpertLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.AwakenedPokemonClash)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_MaxieArchieLeft, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_StevenMaxieArchieLeft : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.MaxieArchieLeft)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_FlyingMonStoppedRampage, MSGBOX_DEFAULT
 * closemessage
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Boy2Rayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.FlyingMonStoppedRampage)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_CaveOfOriginSleepsToo, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_ExpertPostLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.CaveOfOriginSleepsToo)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_NeverBeenToSkyPillar, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_StevenHelpedWallace : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.NeverBeenToSkyPillar)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_HIDE_SOOTOPOLIS_CITY_MAXIE
 * setflag FLAG_HIDE_SOOTOPOLIS_CITY_ARCHIE
 * setflag FLAG_SOOTOPOLIS_ARCHIE_MAXIE_LEAVE
 * clearflag FLAG_HIDE_MT_PYRE_SUMMIT_MAXIE
 * clearflag FLAG_HIDE_MT_PYRE_SUMMIT_ARCHIE
 * setvar VAR_MT_PYRE_STATE, 2
 * warpsilent MAP_SOOTOPOLIS_CITY, 31, 34
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_MaxieArchieLeave : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_MaxieArchieLeave")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_LeadSuperiorTrainerToCave, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_ExpertLeadToCave : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.LeadSuperiorTrainerToCave)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_WhereDidLegendariesGo, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Boy1GameClear : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.WhereDidLegendariesGo)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_YouBroughtFlyingMon, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Woman2Rayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.YouBroughtFlyingMon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_SootopolisDidntGetWrecked, MSGBOX_DEFAULT
 * closemessage
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_GirlRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.SootopolisDidntGetWrecked)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_ThatWasWicked, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_NinjaBoyRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.ThatWasWicked)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_Text_InvolvedWithCrisisComeWithMe, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_WEST, SootopolisCity_EventScript_StartWalkToCaveOfOriginWest
 * call_if_eq VAR_FACING, DIR_NORTH, SootopolisCity_EventScript_StartWalkToCaveOfOriginNorth
 * msgbox SootopolisCity_Text_DoesThisMakeYourFearPokemon, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_STEVEN, SootopolisCity_Movement_StevenWalkToCaveOfOrigin
 * applymovement LOCALID_PLAYER, SootopolisCity_Movement_PlayerWalkToCaveOfOrigin
 * waitmovement 0
 * delay 120
 * applymovement LOCALID_SOOTOPOLIS_EXPERT, SootopolisCity_Movement_ExpertMoveAside
 * waitmovement 0
 * applymovement LOCALID_SOOTOPOLIS_STEVEN, SootopolisCity_Movement_StevenArriveCaveEntrance
 * applymovement LOCALID_PLAYER, SootopolisCity_Movement_PlayerArriveCaveEntrance
 * waitmovement 0
 * msgbox SootopolisCity_Text_HereWereAreHelpWallace, MSGBOX_DEFAULT
 * closemessage
 * setflag FLAG_STEVEN_GUIDES_TO_CAVE_OF_ORIGIN
 * applymovement LOCALID_PLAYER, SootopolisCity_Movement_PlayerEnterCaveOfOrigin
 * waitmovement 0
 * warp MAP_CAVE_OF_ORIGIN_ENTRANCE, 9, 20
 * waitstate
 * end
 * ```
 */
internal object SootopolisCity_EventScript_StevenLeadPlayerCaveOfOrigin : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_StevenLeadPlayerCaveOfOrigin")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_SawLegendWithOwnEyes, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_ManiacRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.SawLegendWithOwnEyes)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_CityRegainedCalm, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_ManPostLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.CityRegainedCalm)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_PrettyMonCameFromSky, MSGBOX_DEFAULT
 * closemessage
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_KiriRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.PrettyMonCameFromSky)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_NightSkyFavoriteScenery, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Woman1PostLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.NightSkyFavoriteScenery)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_Text_ThankYouForHelpAcceptThis, MSGBOX_DEFAULT
 * giveitem ITEM_HM_WATERFALL
 * setflag FLAG_RECEIVED_HM_WATERFALL
 * msgbox SootopolisCity_Text_ExplainWaterfallGoToGym, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, SootopolisCity_EventScript_WallaceMoveFromGym
 * call_if_eq VAR_FACING, DIR_EAST, SootopolisCity_EventScript_WallaceMoveFromGym
 * call_if_eq VAR_FACING, DIR_WEST, SootopolisCity_EventScript_WallaceMoveFromGymWest
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_GiveWaterfall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_GiveWaterfall")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_DazzledByMentor, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_GoToGym : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.DazzledByMentor)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_GiganticPokemonFight, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SOOTOPOLIS_WOMAN_1, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Woman1Legendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.GiganticPokemonFight)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * dotimebasedevents
 * special GetPlayerBigGuyGirlString
 * goto_if_set FLAG_DAILY_SOOTOPOLIS_RECEIVED_BERRY, SootopolisCity_EventScript_KiriReceivedBerry
 * msgbox SootopolisCity_Text_NameIsKiriHaveOneOfThese, MSGBOX_DEFAULT
 * random NUM_KIRI_BERRIES
 * addvar VAR_RESULT, NUM_KIRI_BERRIES_SKIPPED
 * addvar VAR_RESULT, FIRST_BERRY_INDEX
 * giveitem VAR_RESULT
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_DAILY_SOOTOPOLIS_RECEIVED_BERRY
 * msgbox SootopolisCity_Text_GiveYouThisBerryToo, MSGBOX_DEFAULT
 * random 2
 * goto_if_eq VAR_RESULT, 0, SootopolisCity_EventScript_GiveFigyBerry
 * goto_if_eq VAR_RESULT, 1, SootopolisCity_EventScript_GiveIapapaBerry
 * end
 * ```
 */
internal object SootopolisCity_EventScript_KiriGiveBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_KiriGiveBerry")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_PhysicallyFitLivingHere, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_Boy1Normal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.PhysicallyFitLivingHere)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_WonderWhatWorldIsLike, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_NinjaBoyNormal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.WonderWhatWorldIsLike)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_KnowWhatsNeededToHelpHim, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_EventScript_StevenHelpWallace : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.KnowWhatsNeededToHelpHim)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SOOTOPOLIS_WALLACE, SootopolisCity_Movement_WallaceMoveFromGymWest
 * waitmovement 0
 * copyobjectxytoperm LOCALID_SOOTOPOLIS_WALLACE
 * setvar VAR_SOOTOPOLIS_WALLACE_STATE, 2
 * return
 * ```
 */
internal object SootopolisCity_EventScript_WallaceMoveFromGymWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_WallaceMoveFromGymWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_Text_LikeSeasonBornIn, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, SootopolisCity_EventScript_KiriLikeSeasonBornIn
 * msgbox SootopolisCity_Text_OhDoesntMatter, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_KiriReceivedBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_KiriReceivedBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * giveitem ITEM_FIGY_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * msgbox SootopolisCity_Text_WhatKindOfWishInYourName, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_GiveFigyBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_GiveFigyBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SOOTOPOLIS_STEVEN, SootopolisCity_Movement_StevenStartWalkToCaveOfOrigin
 * applymovement LOCALID_PLAYER, SootopolisCity_Movement_PlayerStartWalkToCaveOfOriginWest
 * waitmovement 0
 * return
 * ```
 */
internal object SootopolisCity_EventScript_StartWalkToCaveOfOriginWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_StartWalkToCaveOfOriginWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * giveitem ITEM_IAPAPA_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * msgbox SootopolisCity_Text_WhatKindOfWishInYourName, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_GiveIapapaBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_GiveIapapaBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SOOTOPOLIS_STEVEN, SootopolisCity_Movement_StevenStartWalkToCaveOfOrigin
 * applymovement LOCALID_PLAYER, SootopolisCity_Movement_PlayerStartWalkToCaveOfOriginNorth
 * waitmovement 0
 * return
 * ```
 */
internal object SootopolisCity_EventScript_StartWalkToCaveOfOriginNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_StartWalkToCaveOfOriginNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SOOTOPOLIS_WALLACE, SootopolisCity_Movement_WallaceMoveFromGym
 * waitmovement 0
 * copyobjectxytoperm LOCALID_SOOTOPOLIS_WALLACE
 * setvar VAR_SOOTOPOLIS_WALLACE_STATE, 1
 * return
 * ```
 */
internal object SootopolisCity_EventScript_WallaceMoveFromGym : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_EventScript_WallaceMoveFromGym")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Text_ThenILoveAutumn, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_EventScript_KiriLikeSeasonBornIn : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity.ThenILoveAutumn)
  }
}

internal val SootopolisCityScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_EventScript_CaveOfOriginExpert" to
            SootopolisCity_EventScript_CaveOfOriginExpert,
        "SootopolisCity_EventScript_Woman2" to SootopolisCity_EventScript_Woman2,
        "SootopolisCity_EventScript_Kiri" to SootopolisCity_EventScript_Kiri,
        "SootopolisCity_EventScript_NinjaBoy" to SootopolisCity_EventScript_NinjaBoy,
        "SootopolisCity_EventScript_Boy1" to SootopolisCity_EventScript_Boy1,
        "SootopolisCity_EventScript_Man" to SootopolisCity_EventScript_Man,
        "SootopolisCity_EventScript_Steven" to SootopolisCity_EventScript_Steven,
        "SootopolisCity_EventScript_Woman1" to SootopolisCity_EventScript_Woman1,
        "SootopolisCity_EventScript_Maniac" to SootopolisCity_EventScript_Maniac,
        "SootopolisCity_EventScript_Girl" to SootopolisCity_EventScript_Girl,
        "SootopolisCity_EventScript_BlackBelt" to SootopolisCity_EventScript_BlackBelt,
        "SootopolisCity_EventScript_Boy2" to SootopolisCity_EventScript_Boy2,
        "SootopolisCity_EventScript_Maxie" to SootopolisCity_EventScript_Maxie,
        "SootopolisCity_EventScript_Archie" to SootopolisCity_EventScript_Archie,
        "SootopolisCity_EventScript_Wallace" to SootopolisCity_EventScript_Wallace,
        "SootopolisCity_EventScript_GymSign" to SootopolisCity_EventScript_GymSign,
        "SootopolisCity_EventScript_CitySign" to SootopolisCity_EventScript_CitySign,
        "SootopolisCity_EventScript_MaxieRayquaza" to SootopolisCity_EventScript_MaxieRayquaza,
        "SootopolisCity_EventScript_ArchieRayquaza" to SootopolisCity_EventScript_ArchieRayquaza,
        "SootopolisCity_EventScript_BlackBeltRayquaza" to
            SootopolisCity_EventScript_BlackBeltRayquaza,
        "SootopolisCity_EventScript_Boy1Rayquaza" to SootopolisCity_EventScript_Boy1Rayquaza,
        "SootopolisCity_EventScript_Woman1Rayquaza" to SootopolisCity_EventScript_Woman1Rayquaza,
        "SootopolisCity_EventScript_GoToSkyPillar" to SootopolisCity_EventScript_GoToSkyPillar,
        "SootopolisCity_EventScript_ExpertLegendaries" to
            SootopolisCity_EventScript_ExpertLegendaries,
        "SootopolisCity_EventScript_StevenMaxieArchieLeft" to
            SootopolisCity_EventScript_StevenMaxieArchieLeft,
        "SootopolisCity_EventScript_Boy2Rayquaza" to SootopolisCity_EventScript_Boy2Rayquaza,
        "SootopolisCity_EventScript_ExpertPostLegendaries" to
            SootopolisCity_EventScript_ExpertPostLegendaries,
        "SootopolisCity_EventScript_StevenHelpedWallace" to
            SootopolisCity_EventScript_StevenHelpedWallace,
        "SootopolisCity_EventScript_MaxieArchieLeave" to
            SootopolisCity_EventScript_MaxieArchieLeave,
        "SootopolisCity_EventScript_ExpertLeadToCave" to
            SootopolisCity_EventScript_ExpertLeadToCave,
        "SootopolisCity_EventScript_Boy1GameClear" to SootopolisCity_EventScript_Boy1GameClear,
        "SootopolisCity_EventScript_Woman2Rayquaza" to SootopolisCity_EventScript_Woman2Rayquaza,
        "SootopolisCity_EventScript_GirlRayquaza" to SootopolisCity_EventScript_GirlRayquaza,
        "SootopolisCity_EventScript_NinjaBoyRayquaza" to
            SootopolisCity_EventScript_NinjaBoyRayquaza,
        "SootopolisCity_EventScript_StevenLeadPlayerCaveOfOrigin" to
            SootopolisCity_EventScript_StevenLeadPlayerCaveOfOrigin,
        "SootopolisCity_EventScript_ManiacRayquaza" to SootopolisCity_EventScript_ManiacRayquaza,
        "SootopolisCity_EventScript_ManPostLegendaries" to
            SootopolisCity_EventScript_ManPostLegendaries,
        "SootopolisCity_EventScript_KiriRayquaza" to SootopolisCity_EventScript_KiriRayquaza,
        "SootopolisCity_EventScript_Woman1PostLegendaries" to
            SootopolisCity_EventScript_Woman1PostLegendaries,
        "SootopolisCity_EventScript_GiveWaterfall" to SootopolisCity_EventScript_GiveWaterfall,
        "SootopolisCity_EventScript_GoToGym" to SootopolisCity_EventScript_GoToGym,
        "SootopolisCity_EventScript_Woman1Legendaries" to
            SootopolisCity_EventScript_Woman1Legendaries,
        "SootopolisCity_EventScript_KiriGiveBerry" to SootopolisCity_EventScript_KiriGiveBerry,
        "SootopolisCity_EventScript_Boy1Normal" to SootopolisCity_EventScript_Boy1Normal,
        "SootopolisCity_EventScript_NinjaBoyNormal" to SootopolisCity_EventScript_NinjaBoyNormal,
        "SootopolisCity_EventScript_StevenHelpWallace" to
            SootopolisCity_EventScript_StevenHelpWallace,
        "SootopolisCity_EventScript_WallaceMoveFromGymWest" to
            SootopolisCity_EventScript_WallaceMoveFromGymWest,
        "SootopolisCity_EventScript_KiriReceivedBerry" to
            SootopolisCity_EventScript_KiriReceivedBerry,
        "SootopolisCity_EventScript_GiveFigyBerry" to SootopolisCity_EventScript_GiveFigyBerry,
        "SootopolisCity_EventScript_StartWalkToCaveOfOriginWest" to
            SootopolisCity_EventScript_StartWalkToCaveOfOriginWest,
        "SootopolisCity_EventScript_GiveIapapaBerry" to SootopolisCity_EventScript_GiveIapapaBerry,
        "SootopolisCity_EventScript_StartWalkToCaveOfOriginNorth" to
            SootopolisCity_EventScript_StartWalkToCaveOfOriginNorth,
        "SootopolisCity_EventScript_WallaceMoveFromGym" to
            SootopolisCity_EventScript_WallaceMoveFromGym,
        "SootopolisCity_EventScript_KiriLikeSeasonBornIn" to
            SootopolisCity_EventScript_KiriLikeSeasonBornIn,
    )
