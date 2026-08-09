package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CinnabarIsland_PokemonLab_ExperimentRoom
import de.fiereu.openmmo.dialog.generated.kanto.Trade
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, INGAME_TRADE_SEEL
 * call EventScript_GetInGameTradeSpeciesInfo
 * goto_if_set FLAG_DID_SEELOR_TRADE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_AlreadyTraded
 * msgbox Trade_Text_LookingForMonWannaTradeForMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DeclineTrade
 * call EventScript_ChooseMonForInGameTrade
 * goto_if_ge VAR_0x8004, PARTY_SIZE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DeclineTrade
 * call EventScript_GetInGameTradeSpecies
 * goto_if_ne VAR_RESULT, VAR_0x8009, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NotRequestedMon
 * call EventScript_DoInGameTrade
 * msgbox Trade_Text_HeyThanks
 * setflag FLAG_DID_SEELOR_TRADE
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_Garett : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_Garett")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_RESULT, FALSE
 * call_if_set FLAG_REVIVED_AMBER, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedMtMoonFossil
 * goto_if_eq VAR_RESULT, TRUE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_RevivedAllFossils
 * goto_if_eq VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_REVIVE_STATE, 2, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveRevivedMon
 * goto_if_eq VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_REVIVE_STATE, 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilStillReviving
 * call CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddHelixFossilToList
 * goto_if_eq VAR_RESULT, TRUE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelix
 * call CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddDomeFossilToList
 * goto_if_eq VAR_RESULT, TRUE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDome
 * call CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList
 * goto_if_eq VAR_RESULT, TRUE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilAmber
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_HaveYouAFossilForMe
 * goto CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilScientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_GOT_HELIX_FOSSIL, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * goto_if_set FLAG_REVIVED_HELIX, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * setvar VAR_RESULT, TRUE
 * return
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddHelixFossilToList :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddHelixFossilToList")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_GOT_DOME_FOSSIL, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * goto_if_set FLAG_REVIVED_DOME, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * setvar VAR_RESULT, TRUE
 * return
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddDomeFossilToList :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddDomeFossilToList")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Trade_Text_IsntMyOldMonGreat
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_AlreadyTraded : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Trade.IsntMyOldMonGreat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_TakesTimeGoForWalk
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilStillReviving : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_PokemonLab_ExperimentRoom.TakesTimeGoForWalk)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_WHICH_FOSSIL, HELIX_FOSSIL, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveOmanyte
 * goto_if_eq VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_WHICH_FOSSIL, DOME_FOSSIL, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveKabuto
 * goto_if_eq VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_WHICH_FOSSIL, OLD_AMBER, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveAerodactyl
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveRevivedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveRevivedMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, VAR_0x8009
 * msgbox Trade_Text_WhatThatsNoMon
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NotRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NotRequestedMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CinnabarIsland_PokemonLab_ExperimentRoom_Text_HaveYouAFossilForMe
 * waitmessage
 * call CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList
 * goto_if_eq VAR_RESULT, TRUE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelixAmber
 * multichoice 0, 0, MULTICHOICE_HELIX, FALSE
 * switch VAR_RESULT
 * case 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowHelixFossil
 * case 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * case 127, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelix : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelix")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_GOT_OLD_AMBER, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * goto_if_set FLAG_REVIVED_AMBER, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * setvar VAR_RESULT, TRUE
 * return
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CinnabarIsland_PokemonLab_ExperimentRoom_Text_HaveYouAFossilForMe
 * waitmessage
 * multichoice 0, 0, MULTICHOICE_AMBER, FALSE
 * switch VAR_RESULT
 * case 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowOldAmber
 * case 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * case 127, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilAmber : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilAmber")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_NoIsTooBad
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_PokemonLab_ExperimentRoom.NoIsTooBad)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_YouComeAgain
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_RevivedAllFossils : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_PokemonLab_ExperimentRoom.YouComeAgain)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_GOT_HELIX_FOSSIL, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedHelix
 * goto_if_set FLAG_GOT_DOME_FOSSIL, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedDome
 * goto CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedMtMoonFossil :
    Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_HELIX_FOSSIL))
        return CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedHelix.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_DOME_FOSSIL))
        return CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedDome.run(ctx)
    return CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Trade_Text_AwwOhWell
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DeclineTrade : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Trade.AwwOhWell)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CinnabarIsland_PokemonLab_ExperimentRoom_Text_HaveYouAFossilForMe
 * waitmessage
 * call CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList
 * goto_if_eq VAR_RESULT, TRUE, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDomeAmber
 * multichoice 0, 0, MULTICHOICE_DOME, FALSE
 * switch VAR_RESULT
 * case 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowDomeFossil
 * case 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * case 127, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDome : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDome")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 0, 0, MULTICHOICE_DOME_AMBER, FALSE
 * switch VAR_RESULT
 * case 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowDomeFossil
 * case 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowOldAmber
 * case 2, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * case 127, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDomeAmber :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDomeAmber")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_RESULT, FALSE
 * return
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, SPECIES_KABUTO
 * bufferspeciesname STR_VAR_1, SPECIES_KABUTO
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_FossilMonBackToLife
 * givemon SPECIES_KABUTO, 5
 * goto_if_eq VAR_RESULT, 2, EventScript_NoMoreRoomForPokemon
 * setflag FLAG_REVIVED_DOME
 * goto_if_eq VAR_RESULT, 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty
 * goto_if_eq VAR_RESULT, 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveKabuto : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveKabuto")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 0, 0, MULTICHOICE_HELIX_AMBER, FALSE
 * switch VAR_RESULT
 * case 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowHelixFossil
 * case 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ShowOldAmber
 * case 2, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * case 127, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelixAmber :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelixAmber")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_REVIVED_DOME, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * setvar VAR_RESULT, TRUE
 * return
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedDome : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedDome")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, SPECIES_AERODACTYL
 * bufferspeciesname STR_VAR_1, SPECIES_AERODACTYL
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_FossilMonBackToLife
 * givemon SPECIES_AERODACTYL, 5
 * goto_if_eq VAR_RESULT, 2, EventScript_NoMoreRoomForPokemon
 * setflag FLAG_REVIVED_AMBER
 * goto_if_eq VAR_RESULT, 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty
 * goto_if_eq VAR_RESULT, 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveAerodactyl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveAerodactyl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_REVIVED_HELIX, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse
 * setvar VAR_RESULT, TRUE
 * return
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedHelix : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedHelix")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, SPECIES_OMANYTE
 * bufferspeciesname STR_VAR_1, SPECIES_OMANYTE
 * msgbox CinnabarIsland_PokemonLab_ExperimentRoom_Text_FossilMonBackToLife
 * givemon SPECIES_OMANYTE, 5
 * goto_if_eq VAR_RESULT, 2, EventScript_NoMoreRoomForPokemon
 * setflag FLAG_REVIVED_HELIX
 * goto_if_eq VAR_RESULT, 0, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty
 * goto_if_eq VAR_RESULT, 1, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveOmanyte : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveOmanyte")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_LEVEL_UP
 * message CinnabarIsland_PokemonLab_ExperimentRoom_Text_ReceivedMonFromDoctor
 * waitmessage
 * waitfanfare
 * setvar VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_REVIVE_STATE, 0
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon
 * call EventScript_GetGiftMonPartySlot
 * call EventScript_ChangePokemonNickname
 * goto CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_LEVEL_UP
 * message CinnabarIsland_PokemonLab_ExperimentRoom_Text_ReceivedMonFromDoctor
 * waitmessage
 * waitfanfare
 * setvar VAR_MAP_SCENE_CINNABAR_ISLAND_POKEMON_LAB_EXPERIMENT_ROOM_REVIVE_STATE, 0
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_MonSentToPC
 * call EventScript_NameReceivedBoxMon
 * goto CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_MonSentToPC
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon")
}

/**
 * Ported from the decomp:
 * ```
 * call EventScript_TransferredToPC
 * goto CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_MonSentToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_TransferredToPC.run(ctx)
    return CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon.run(ctx)
  }
}

internal val CinnabarIsland_PokemonLab_ExperimentRoomScripts: Map<String, Script> =
    mapOf(
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_Garett" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_Garett,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilScientist" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilScientist,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddHelixFossilToList" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddHelixFossilToList,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddDomeFossilToList" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddDomeFossilToList,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_AlreadyTraded" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_AlreadyTraded,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilStillReviving" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_FossilStillReviving,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveRevivedMon" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveRevivedMon,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NotRequestedMon" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NotRequestedMon,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelix" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelix,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckAddOldAmberToList,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilAmber" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilAmber,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DontShowFossil,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_RevivedAllFossils" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_RevivedAllFossils,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedMtMoonFossil" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedMtMoonFossil,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DeclineTrade" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_DeclineTrade,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDome" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDome,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDomeAmber" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilDomeAmber,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_SetResultFalse,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveKabuto" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveKabuto,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelixAmber" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_ChooseFossilHelixAmber,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedDome" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedDome,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveAerodactyl" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveAerodactyl,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedHelix" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_CheckRevivedHelix,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveOmanyte" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_GiveOmanyte,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonParty,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_NicknameMonPC,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_EndGiveMon,
        "CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_MonSentToPC" to
            CinnabarIsland_PokemonLab_ExperimentRoom_EventScript_MonSentToPC,
    )
