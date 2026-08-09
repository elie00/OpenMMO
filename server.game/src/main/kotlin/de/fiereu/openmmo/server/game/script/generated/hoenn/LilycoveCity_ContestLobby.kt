package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BerryBlender
import de.fiereu.openmmo.dialog.generated.hoenn.LilycoveCity_ContestLobby
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * special ClearLinkContestFlags
 * specialvar VAR_RESULT, IsContestDebugActive  @ Always FALSE
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_ContestLobby_EventScript_SetDebug
 * call LilycoveCity_ContestLobby_EventScript_SpeakToContestReceptionist
 * call LilycoveCity_ContestLobby_EventScript_LeadToContestHall
 * special SetContestTrainerGfxIds
 * call LilycoveCity_ContestLobby_EventScript_SetPlayerGfx
 * call LilycoveCity_ContestLobby_EventScript_SetContestType
 * call LilycoveCity_ContestLobby_EventScript_WarpToContestHall
 * waitstate
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestReceptionist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestReceptionist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special ClearLinkContestFlags
 * lock
 * faceplayer
 * msgbox LilycoveCity_ContestLobby_Text_LinkContestReception, MSGBOX_DEFAULT
 * goto LilycoveCity_ContestLobby_EventScript_AskEnterLinkContest
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_LinkContestReceptionist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_LinkContestReceptionist")
}

internal object BerryBlender_EventScript_Blender2Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BerryBlender.SetNewBlenderRecord)
}

internal object LilycoveCity_ContestLobby_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_ContestLobby.MasterRankHereICome)
}

internal object LilycoveCity_ContestLobby_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_ContestLobby.WholeVarietyOfPokemonHere)
}

internal object LilycoveCity_ContestLobby_EventScript_Artist : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_ContestLobby.ContestFeastForEyes)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TEMP_2, LilycoveCity_ContestLobby_EventScript_AlreadyInterviewed
 * setvar VAR_0x8005, TVSHOW_BRAVO_TRAINER_POKEMON_PROFILE
 * special InterviewBefore
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_ContestLobby_EventScript_AlreadyInterviewed
 * copyvar VAR_0x8009, VAR_0x8006
 * msgbox LilycoveCity_ContestLobby_Text_InterviewRequest, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, LilycoveCity_ContestLobby_EventScript_AcceptInterview
 * goto_if_eq VAR_RESULT, NO, LilycoveCity_ContestLobby_EventScript_DeclineInterview
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_Reporter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_Reporter")
}

internal object LilycoveCity_ContestLobby_EventScript_Blender3Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BerryBlender.LetsGetBlendingAlready)
}

internal object BerryBlender_EventScript_Blender2Twin : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BerryBlender.MakeDeliciousPokeblocks)
}

internal object LilycoveCity_ContestLobby_EventScript_Fisherman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_ContestLobby.LavishedCareOnMon)
}

internal object LilycoveCity_ContestLobby_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_ContestLobby.ToughContestIsExtreme)
}

internal object LilycoveCity_ContestLobby_EventScript_NinjaBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_ContestLobby.MadePokeblocksWithFamily)
}

internal object BerryBlender_EventScript_Blender3PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BerryBlender.LookGoodAtBlendingJoinUs)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8008, 15
 * goto BerryBlender_EventScript_ExpertMCheckGiveBerry
 * end
 * ```
 */
internal object BerryBlender_EventScript_Blender1ExpertM : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BerryBlender_EventScript_Blender1ExpertM")
}

internal object LilycoveCity_ContestLobby_EventScript_Blender3Girl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BerryBlender.WhatKindOfPokeblockWillIGet)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * msgbox BerryBlender_Text_WickedlyFast, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.WickedlyFast)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * msgbox BerryBlender_Text_WhatAnExpert, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.WhatAnExpert)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BerryBlender_Text_MadeAmazingPokeblocksWithMaster, MSGBOX_DEFAULT
 * goto LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.MadeAmazingPokeblocksWithMaster)
    return LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BerryBlender_Text_QualitiesOfBlendMaster, MSGBOX_DEFAULT
 * goto LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker5 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.QualitiesOfBlendMaster)
    return LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BerryBlender_Text_MasterWorksOnSkillsInMountains, MSGBOX_DEFAULT
 * goto LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker6 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.MasterWorksOnSkillsInMountains)
    return LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * msgbox BerryBlender_Text_WhoaAwesome, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.WhoaAwesome)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BerryBlender_Text_BlendWithTheBlendMaster, MSGBOX_DEFAULT
 * goto LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BlendMaster : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BerryBlender.BlendWithTheBlendMaster)
    return LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_POKEBLOCK_CASE, LilycoveCity_ContestLobby_EventScript_LittleGirlHaveCase
 * msgbox LilycoveCity_ContestLobby_Text_LadyGaveMePokeblockCase, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_POKEBLOCK_CASE))
        return LilycoveCity_ContestLobby_EventScript_LittleGirlHaveCase.run(ctx)
    ctx.say(LilycoveCity_ContestLobby.LadyGaveMePokeblockCase)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * specialvar VAR_RESULT, PlayerHasBerries
 * goto_if_eq VAR_RESULT, FALSE, BerryBlender_EventScript_LinkBlenderNoBerries
 * checkitem ITEM_POKEBLOCK_CASE
 * goto_if_eq VAR_RESULT, FALSE, BerryBlender_EventScript_LinkBlenderNoCase
 * specialvar VAR_RESULT, GetFirstFreePokeblockSlot
 * goto_if_ne VAR_RESULT, 65535, BerryBlender_EventScript_LinkBlenderSaveGame
 * goto_if_eq VAR_RESULT, 65535, BerryBlender_EventScript_LinkBlenderCaseFull
 * end
 * ```
 */
internal object BerryBlender_EventScript_BerryBlenderLink : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BerryBlender_EventScript_BerryBlenderLink")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8008, LOCALID_CONTEST_LOBBY_BLENDER_3_LEADER
 * setvar NUM_OPPONENTS, 3
 * applymovement LOCALID_CONTEST_LOBBY_BLENDER_3_PARTICIPANT_1, Common_Movement_FaceOriginalDirection
 * applymovement LOCALID_CONTEST_LOBBY_BLENDER_3_PARTICIPANT_2, Common_Movement_FaceOriginalDirection
 * applymovement VAR_0x8008, BerryBlender_Movement_BlendLeaderWalkInPlace
 * waitmovement 0
 * msgbox BerryBlender_Text_LookGoodAtBlendingJoinUs, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, BerryBlender_EventScript_TryUseBlender3
 * goto BerryBlender_EventScript_DeclineBlender3
 * end
 * ```
 */
internal object BerryBlender_EventScript_BerryBlender3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port BerryBlender_EventScript_BerryBlender3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_HALL_4
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestWinner4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestWinner4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_HALL_5
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestWinner5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestWinner5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_HALL_6
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestWinner6 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestWinner6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * special ShowBerryBlenderRecordWindow
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_BerryBlenderSpeedRecords : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_BerryBlenderSpeedRecords")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_HALL_1
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestWinner1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestWinner1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_HALL_2
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestWinner2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestWinner2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_HALL_3
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ContestWinner3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_ContestWinner3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_unset FLAG_HIDE_LILYCOVE_CONTEST_HALL_BLEND_MASTER, BerryBlender_EventScript_BlendMasterPresent
 * setvar NUM_OPPONENTS, 1
 * applymovement LOCALID_BLEND_MASTER, BerryBlender_Movement_BlendLeaderWalkInPlace
 * waitmovement 0
 * msgbox BerryBlender_Text_WantToMakePokeblocks, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, BerryBlender_EventScript_TryUseBerryBlender1
 * goto BerryBlender_EventScript_DeclineBlender1
 * end
 * ```
 */
internal object BerryBlender_EventScript_BerryBlender1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port BerryBlender_EventScript_BerryBlender1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar NUM_OPPONENTS, 2
 * applymovement LOCALID_CONTEST_LOBBY_BLENDER_2_PARTICIPANT, Common_Movement_FaceOriginalDirection
 * applymovement LOCALID_CONTEST_LOBBY_BLENDER_2_LEADER, BerryBlender_Movement_BlendLeaderWalkInPlace
 * waitmovement 0
 * msgbox BerryBlender_Text_WantToBlendPokeblocksWithUs, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, BerryBlender_EventScript_TryUseBerryBlender2
 * goto BerryBlender_EventScript_DeclineBlender2
 * end
 * ```
 */
internal object BerryBlender_EventScript_BerryBlender2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port BerryBlender_EventScript_BerryBlender2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FACILITY_LINK_CONTEST
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_LinkContestResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_LinkContestResults")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_MakePokeblocksDifferentBerries, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_LittleGirlHaveCase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_ContestLobby.MakePokeblocksDifferentBerries)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ne VAR_CONTEST_PRIZE_PICKUP, 0, LilycoveCity_ContestLobby_EventScript_PickUpPrize
 * call_if_set FLAG_RECEIVED_POKEBLOCK_CASE, LilycoveCity_ContestLobby_EventScript_ReceptionWelcome
 * call_if_unset FLAG_RECEIVED_POKEBLOCK_CASE, LilycoveCity_ContestLobby_EventScript_GivePokeblockCase
 * goto LilycoveCity_ContestLobby_EventScript_AskEnterContest
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SpeakToContestReceptionist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SpeakToContestReceptionist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * switch VAR_CONTEST_RANK
 * case CONTEST_RANK_NORMAL, LilycoveCity_ContestLobby_EventScript_SetNormalContestType
 * case CONTEST_RANK_SUPER, LilycoveCity_ContestLobby_EventScript_SetSuperContestType
 * case CONTEST_RANK_HYPER, LilycoveCity_ContestLobby_EventScript_SetHyperContestType
 * case CONTEST_RANK_MASTER, LilycoveCity_ContestLobby_EventScript_SetMasterContestType
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SetContestType : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SetContestType")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_HIDE_LILYCOVE_MUSEUM_CURATOR
 * #ifdef UBFIX
 * setvar VAR_LILYCOVE_MUSEUM_2F_STATE, 1
 * #else
 * copyvar VAR_LILYCOVE_MUSEUM_2F_STATE, 1, warn=FALSE
 * #endif
 * additem ITEM_CONTEST_PASS
 * setvar VAR_0x800B, 8
 * setvar VAR_CONTEST_RANK, CONTEST_RANK_MASTER
 * setvar VAR_LILYCOVE_CONTEST_LOBBY_STATE, 1
 * setflag FLAG_SYS_RIBBON_GET
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SetDebug : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SetDebug")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message LilycoveCity_ContestLobby_Text_EnterContest3
 * waitmessage
 * multichoice 0, 0, MULTI_ENTERINFO, FALSE
 * switch VAR_RESULT
 * case 0, LilycoveCity_ContestLobby_EventScript_TryEnterLinkContest
 * case 1, LilycoveCity_ContestLobby_EventScript_LinkContestInfo
 * case 2, LilycoveCity_ContestLobby_EventScript_CancelLinkContest
 * case MULTI_B_PRESSED, LilycoveCity_ContestLobby_EventScript_CancelLinkContest
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_AskEnterLinkContest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_AskEnterLinkContest")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_LookingForwardToNextContest, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_AlreadyInterviewed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_ContestLobby.LookingForwardToNextContest)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_PleaseDoShareStoryWithMe, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_DeclineInterview : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_ContestLobby.PleaseDoShareStoryWithMe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_ENTERED_CONTEST
 * switch VAR_CONTEST_CATEGORY
 * case CONTEST_CATEGORY_COOL, LilycoveCity_ContestLobby_EventScript_WarpToCoolContestHall
 * case CONTEST_CATEGORY_BEAUTY, LilycoveCity_ContestLobby_EventScript_WarpToBeautyContestHall
 * case CONTEST_CATEGORY_CUTE, LilycoveCity_ContestLobby_EventScript_WarpToCuteContestHall
 * case CONTEST_CATEGORY_SMART, LilycoveCity_ContestLobby_EventScript_WarpToSmartContestHall
 * case CONTEST_CATEGORY_TOUGH, LilycoveCity_ContestLobby_EventScript_WarpToToughContestHall
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_WarpToContestHall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_WarpToContestHall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_DescribeContest, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_CONTEST_INTERVIEW
 * copyvar VAR_0x8005, VAR_0x8009
 * setvar VAR_0x8006, 0
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_ContestLobby_EventScript_SubmitResponse
 * goto_if_eq VAR_RESULT, 0, LilycoveCity_ContestLobby_EventScript_DeclineInterview
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_AcceptInterview : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_AcceptInterview")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_CONTEST_LOBBY_RECEPTIONIST, LilycoveCity_ContestLobby_Movement_ReceptionistApproachCounter
 * waitmovement 0
 * playse SE_BRIDGE_WALK
 * setmetatile 12, 2, METATILE_Contest_WallShadow, TRUE
 * setmetatile 12, 3, METATILE_Contest_FloorShadow, TRUE
 * special DrawWholeMapView
 * applymovement LOCALID_CONTEST_LOBBY_RECEPTIONIST, LilycoveCity_ContestLobby_Movement_ReceptionistExitCounter
 * waitmovement 0
 * playse SE_BRIDGE_WALK
 * setmetatile 12, 2, METATILE_Contest_CounterFlap_Top, TRUE
 * setmetatile 12, 3, METATILE_Contest_CounterFlap_Bottom, TRUE
 * special DrawWholeMapView
 * delay 20
 * applymovement LOCALID_CONTEST_LOBBY_RECEPTIONIST, LilycoveCity_ContestLobby_Movement_ReceptionistFacePlayer
 * waitmovement 0
 * applymovement LOCALID_PLAYER, LilycoveCity_ContestLobby_Movement_PlayerApproachReceptionist
 * waitmovement 0
 * msgbox LilycoveCity_ContestLobby_Text_ComeThroughHere, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_CONTEST_LOBBY_RECEPTIONIST, LilycoveCity_ContestLobby_Movement_ReceptionistWalkToContestHall
 * applymovement LOCALID_PLAYER, LilycoveCity_ContestLobby_Movement_PlayerWalkToContestHall
 * waitmovement 0
 * releaseall
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_LeadToContestHall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_LeadToContestHall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * goto_if_eq VAR_RESULT, MALE, LilycoveCity_ContestLobby_EventScript_SetPlayerGfxBrendan
 * goto_if_eq VAR_RESULT, FEMALE, LilycoveCity_ContestLobby_EventScript_SetPlayerGfxMay
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SetPlayerGfx : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SetPlayerGfx")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_OBJ_GFX_ID_3, OBJ_EVENT_GFX_RIVAL_MAY_NORMAL
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SetPlayerGfxMay : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SetPlayerGfxMay")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_ContestReception, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_ReceptionWelcome : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_ContestLobby.ContestReception)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message LilycoveCity_ContestLobby_Text_EnterContest1
 * waitmessage
 * multichoice 0, 0, MULTI_ENTERINFO, FALSE
 * switch VAR_RESULT
 * case 0, LilycoveCity_ContestLobby_EventScript_ChooseContestRank
 * case 1, LilycoveCity_ContestLobby_EventScript_ContestInfo
 * case 2, LilycoveCity_ContestLobby_EventScript_CancelEnterContest
 * case MULTI_B_PRESSED, LilycoveCity_ContestLobby_EventScript_CancelEnterContest
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_AskEnterContest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_AskEnterContest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_PokemonWonWeHavePrize, MSGBOX_DEFAULT
 * switch VAR_CONTEST_PRIZE_PICKUP
 * case 4, LilycoveCity_ContestLobby_EventScript_GiveLuxuryBallAtCounter
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_PickUpPrize : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_PickUpPrize")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_ContestLobby_Text_ReceptionDontHavePokeblockCase, MSGBOX_DEFAULT
 * giveitem ITEM_POKEBLOCK_CASE
 * setflag FLAG_RECEIVED_POKEBLOCK_CASE
 * msgbox LilycoveCity_ContestLobby_Text_NowThatWeveClearedThatUp, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_GivePokeblockCase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_GivePokeblockCase")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_OBJ_GFX_ID_3, OBJ_EVENT_GFX_RIVAL_BRENDAN_NORMAL
 * return
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SetPlayerGfxBrendan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SetPlayerGfxBrendan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 24
 * special SetContestCategoryStringVarForInterview
 * msgbox LilycoveCity_ContestLobby_Text_WhatImageWhenYouHearX, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_CONTEST_INTERVIEW
 * copyvar VAR_0x8005, VAR_0x8009
 * setvar VAR_0x8006, 1
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, 0, LilycoveCity_ContestLobby_EventScript_DeclineInterview
 * msgbox LilycoveCity_ContestLobby_Text_ThatsAllForInterview, MSGBOX_DEFAULT
 * setflag FLAG_TEMP_2
 * setvar VAR_0x8005, TVSHOW_BRAVO_TRAINER_POKEMON_PROFILE
 * goto Interview_EventScript_EndInterview
 * end
 * ```
 */
internal object LilycoveCity_ContestLobby_EventScript_SubmitResponse : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_ContestLobby_EventScript_SubmitResponse")
}

internal val LilycoveCity_ContestLobbyScripts: Map<String, Script> =
    mapOf(
        "LilycoveCity_ContestLobby_EventScript_ContestReceptionist" to
            LilycoveCity_ContestLobby_EventScript_ContestReceptionist,
        "LilycoveCity_ContestLobby_EventScript_LinkContestReceptionist" to
            LilycoveCity_ContestLobby_EventScript_LinkContestReceptionist,
        "BerryBlender_EventScript_Blender2Man" to BerryBlender_EventScript_Blender2Man,
        "LilycoveCity_ContestLobby_EventScript_BlackBelt" to
            LilycoveCity_ContestLobby_EventScript_BlackBelt,
        "LilycoveCity_ContestLobby_EventScript_Girl" to LilycoveCity_ContestLobby_EventScript_Girl,
        "LilycoveCity_ContestLobby_EventScript_Artist" to
            LilycoveCity_ContestLobby_EventScript_Artist,
        "LilycoveCity_ContestLobby_EventScript_Reporter" to
            LilycoveCity_ContestLobby_EventScript_Reporter,
        "LilycoveCity_ContestLobby_EventScript_Blender3Boy" to
            LilycoveCity_ContestLobby_EventScript_Blender3Boy,
        "BerryBlender_EventScript_Blender2Twin" to BerryBlender_EventScript_Blender2Twin,
        "LilycoveCity_ContestLobby_EventScript_Fisherman" to
            LilycoveCity_ContestLobby_EventScript_Fisherman,
        "LilycoveCity_ContestLobby_EventScript_FatMan" to
            LilycoveCity_ContestLobby_EventScript_FatMan,
        "LilycoveCity_ContestLobby_EventScript_NinjaBoy" to
            LilycoveCity_ContestLobby_EventScript_NinjaBoy,
        "BerryBlender_EventScript_Blender3PokefanF" to BerryBlender_EventScript_Blender3PokefanF,
        "BerryBlender_EventScript_Blender1ExpertM" to BerryBlender_EventScript_Blender1ExpertM,
        "LilycoveCity_ContestLobby_EventScript_Blender3Girl" to
            LilycoveCity_ContestLobby_EventScript_Blender3Girl,
        "LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker2" to
            LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker2,
        "LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker3" to
            LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker3,
        "LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker4" to
            LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker4,
        "LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker5" to
            LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker5,
        "LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker6" to
            LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker6,
        "LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker1" to
            LilycoveCity_ContestLobby_EventScript_BlendMasterOnlooker1,
        "LilycoveCity_ContestLobby_EventScript_BlendMaster" to
            LilycoveCity_ContestLobby_EventScript_BlendMaster,
        "LilycoveCity_ContestLobby_EventScript_LittleGirl" to
            LilycoveCity_ContestLobby_EventScript_LittleGirl,
        "BerryBlender_EventScript_BerryBlenderLink" to BerryBlender_EventScript_BerryBlenderLink,
        "BerryBlender_EventScript_BerryBlender3" to BerryBlender_EventScript_BerryBlender3,
        "LilycoveCity_ContestLobby_EventScript_ContestWinner4" to
            LilycoveCity_ContestLobby_EventScript_ContestWinner4,
        "LilycoveCity_ContestLobby_EventScript_ContestWinner5" to
            LilycoveCity_ContestLobby_EventScript_ContestWinner5,
        "LilycoveCity_ContestLobby_EventScript_ContestWinner6" to
            LilycoveCity_ContestLobby_EventScript_ContestWinner6,
        "LilycoveCity_ContestLobby_EventScript_BerryBlenderSpeedRecords" to
            LilycoveCity_ContestLobby_EventScript_BerryBlenderSpeedRecords,
        "LilycoveCity_ContestLobby_EventScript_ContestWinner1" to
            LilycoveCity_ContestLobby_EventScript_ContestWinner1,
        "LilycoveCity_ContestLobby_EventScript_ContestWinner2" to
            LilycoveCity_ContestLobby_EventScript_ContestWinner2,
        "LilycoveCity_ContestLobby_EventScript_ContestWinner3" to
            LilycoveCity_ContestLobby_EventScript_ContestWinner3,
        "BerryBlender_EventScript_BerryBlender1" to BerryBlender_EventScript_BerryBlender1,
        "BerryBlender_EventScript_BerryBlender2" to BerryBlender_EventScript_BerryBlender2,
        "LilycoveCity_ContestLobby_EventScript_LinkContestResults" to
            LilycoveCity_ContestLobby_EventScript_LinkContestResults,
        "LilycoveCity_ContestLobby_EventScript_LittleGirlHaveCase" to
            LilycoveCity_ContestLobby_EventScript_LittleGirlHaveCase,
        "LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection" to
            LilycoveCity_ContestLobby_EventScript_FaceOriginalDirection,
        "LilycoveCity_ContestLobby_EventScript_SpeakToContestReceptionist" to
            LilycoveCity_ContestLobby_EventScript_SpeakToContestReceptionist,
        "LilycoveCity_ContestLobby_EventScript_SetContestType" to
            LilycoveCity_ContestLobby_EventScript_SetContestType,
        "LilycoveCity_ContestLobby_EventScript_SetDebug" to
            LilycoveCity_ContestLobby_EventScript_SetDebug,
        "LilycoveCity_ContestLobby_EventScript_AskEnterLinkContest" to
            LilycoveCity_ContestLobby_EventScript_AskEnterLinkContest,
        "LilycoveCity_ContestLobby_EventScript_AlreadyInterviewed" to
            LilycoveCity_ContestLobby_EventScript_AlreadyInterviewed,
        "LilycoveCity_ContestLobby_EventScript_DeclineInterview" to
            LilycoveCity_ContestLobby_EventScript_DeclineInterview,
        "LilycoveCity_ContestLobby_EventScript_WarpToContestHall" to
            LilycoveCity_ContestLobby_EventScript_WarpToContestHall,
        "LilycoveCity_ContestLobby_EventScript_AcceptInterview" to
            LilycoveCity_ContestLobby_EventScript_AcceptInterview,
        "LilycoveCity_ContestLobby_EventScript_LeadToContestHall" to
            LilycoveCity_ContestLobby_EventScript_LeadToContestHall,
        "LilycoveCity_ContestLobby_EventScript_SetPlayerGfx" to
            LilycoveCity_ContestLobby_EventScript_SetPlayerGfx,
        "LilycoveCity_ContestLobby_EventScript_SetPlayerGfxMay" to
            LilycoveCity_ContestLobby_EventScript_SetPlayerGfxMay,
        "LilycoveCity_ContestLobby_EventScript_ReceptionWelcome" to
            LilycoveCity_ContestLobby_EventScript_ReceptionWelcome,
        "LilycoveCity_ContestLobby_EventScript_AskEnterContest" to
            LilycoveCity_ContestLobby_EventScript_AskEnterContest,
        "LilycoveCity_ContestLobby_EventScript_PickUpPrize" to
            LilycoveCity_ContestLobby_EventScript_PickUpPrize,
        "LilycoveCity_ContestLobby_EventScript_GivePokeblockCase" to
            LilycoveCity_ContestLobby_EventScript_GivePokeblockCase,
        "LilycoveCity_ContestLobby_EventScript_SetPlayerGfxBrendan" to
            LilycoveCity_ContestLobby_EventScript_SetPlayerGfxBrendan,
        "LilycoveCity_ContestLobby_EventScript_SubmitResponse" to
            LilycoveCity_ContestLobby_EventScript_SubmitResponse,
    )
