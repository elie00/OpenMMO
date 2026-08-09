package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PewterCity
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_DOWN
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_UP
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object PewterCity_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(PewterCity.ClefairyCameFromMoon)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox PewterCity_Text_DidYouCheckOutMuseum, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, PewterCity_EventScript_CheckedOutMuseum
 * msgbox PewterCity_Text_ReallyYouHaveToGo
 * closemessage
 * delay 10
 * playbgm MUS_FOLLOW_ME, 0
 * call_if_eq VAR_FACING, DIR_NORTH, PewterCity_EventScript_LeadToMuseumNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, PewterCity_EventScript_LeadToMuseumSouth
 * call_if_eq VAR_FACING, DIR_WEST, PewterCity_EventScript_LeadToMuseumWest
 * call_if_eq VAR_FACING, DIR_EAST, PewterCity_EventScript_LeadToMuseumEast
 * msgbox PewterCity_Text_ThisIsTheMuseum
 * closemessage
 * delay 10
 * applymovement LOCALID_PEWTER_MUSEUM_GUIDE, PewterCity_Movement_MuseumGuideExit
 * waitmovement 0
 * fadedefaultbgm
 * removeobject LOCALID_PEWTER_MUSEUM_GUIDE
 * clearflag FLAG_HIDE_PEWTER_MUSEUM_GUIDE
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_MuseumGuide : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_MuseumGuide")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_BROCK, 2
 * msgbox PewterCity_Text_BrockOnlySeriousTrainerHere
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_FatMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox PewterCity_Text_DoYouKnowWhatImDoing, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, PewterCity_EventScript_KnowWhatTheyreDoing
 * msgbox PewterCity_Text_SprayingRepelToKeepWildMonsOut
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_BugCatcher : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_BugCatcher")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox PewterCity_Text_BrocksLookingForChallengersFollowMe
 * closemessage
 * playbgm MUS_FOLLOW_ME, 0
 * call_if_eq VAR_FACING, DIR_EAST, PewterCity_EventScript_WalkToGymEast
 * msgbox PewterCity_Text_GoTakeOnBrock
 * closemessage
 * applymovement LOCALID_PEWTER_GYM_GUIDE, PewterCity_Movement_GymGuideExit
 * waitmovement 0
 * fadedefaultbgm
 * removeobject LOCALID_PEWTER_GYM_GUIDE
 * clearflag FLAG_HIDE_PEWTER_CITY_GYM_GUIDE
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_GymGuide : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_GymGuide")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 0
 * call PewterCity_EventScript_AideGiveRunningShoes
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_RunningShoesAide : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_RunningShoesAide")
}

internal object PewterCity_EventScript_MuseumSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.MuseumOfScience)
}

internal object PewterCity_EventScript_PoliceNotice : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.CallPoliceIfInfoOnThieves)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_BROCK, 0
 * msgbox PewterCity_Text_GymSign
 * releaseall
 * end
 * ```
 */
internal object PewterCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_GymSign")
}

internal object PewterCity_EventScript_TrainerTips : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.TrainerTipsEarningEXP)
}

internal object PewterCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.CitySign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_MALE
 * call_if_eq VAR_TEMP_1, 1, PewterCity_EventScript_AideNoticePlayer
 * call_if_eq VAR_TEMP_1, 2, PewterCity_EventScript_AideNoticePlayer
 * call_if_eq VAR_TEMP_1, 3, PewterCity_EventScript_AideNoticePlayer
 * waitse
 * playse SE_PIN
 * applymovement LOCALID_PEWTER_AIDE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_PEWTER_AIDE, Common_Movement_Delay48
 * waitmovement 0
 * msgbox PewterCity_Text_OhPlayer
 * call_if_eq VAR_TEMP_1, 0, PewterCity_EventScript_AideApproachPlayer0
 * call_if_eq VAR_TEMP_1, 1, PewterCity_EventScript_AideApproachPlayer1
 * call_if_eq VAR_TEMP_1, 2, PewterCity_EventScript_AideApproachPlayer2
 * call_if_eq VAR_TEMP_1, 3, PewterCity_EventScript_AideApproachPlayer3
 * msgbox PewterCity_Text_AskedToDeliverThis
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_KEY_ITEM
 * message PewterCity_Text_ReceivedRunningShoesFromAide
 * waitmessage
 * waitfanfare
 * msgbox PewterCity_Text_SwitchedShoesWithRunningShoes
 * special DisableMsgBoxWalkaway
 * signmsg
 * msgbox PewterCity_Text_ExplainRunningShoes
 * normalmsg
 * call EventScript_RestorePrevTextColor
 * msgbox PewterCity_Text_MustBeGoingBackToLab
 * closemessage
 * call_if_eq VAR_TEMP_1, 0, PewterCity_EventScript_AideExit0
 * call_if_eq VAR_TEMP_1, 1, PewterCity_EventScript_AideExit1
 * call_if_eq VAR_TEMP_1, 2, PewterCity_EventScript_AideExit2
 * call_if_eq VAR_TEMP_1, 3, PewterCity_EventScript_AideExit3
 * delay 30
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PewterCity_Text_RunningShoesLetterFromMom
 * closemessage
 * removeobject LOCALID_PEWTER_AIDE
 * setflag FLAG_SYS_B_DASH
 * setvar VAR_MAP_SCENE_PEWTER_CITY, 2
 * return
 * ```
 */
internal object PewterCity_EventScript_AideGiveRunningShoes : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_AideGiveRunningShoes")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PewterCity_Text_ThatsRightItsHardWork
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_KnowWhatTheyreDoing : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity.ThatsRightItsHardWork)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_MUSEUM_GUIDE, PewterCity_Movement_GuideWalkToMuseumEast
 * applymovement LOCALID_PLAYER, PewterCity_Movement_PlayerWalkToMuseumEast
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_LeadToMuseumEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_LeadToMuseumEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_MUSEUM_GUIDE, PewterCity_Movement_GuideWalkToMuseumSouth
 * applymovement LOCALID_PLAYER, PewterCity_Movement_PlayerWalkToMuseumSouth
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_LeadToMuseumSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_LeadToMuseumSouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_MUSEUM_GUIDE, PewterCity_Movement_GuideWalkToMuseumNorth
 * applymovement LOCALID_PLAYER, PewterCity_Movement_PlayerWalkToMuseumNorth
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_LeadToMuseumNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_LeadToMuseumNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, PewterCity_Movement_PlayerWaitForGuideEast
 * applymovement LOCALID_PEWTER_GYM_GUIDE, PewterCity_Movement_GuideMoveToLeadEast
 * waitmovement 0
 * applymovement LOCALID_PLAYER, PewterCity_Movement_PlayerWalkToGymEast
 * applymovement LOCALID_PEWTER_GYM_GUIDE, PewterCity_Movement_GuideWalkToGymEast
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_WalkToGymEast : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_WalkToGymEast")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PewterCity_Text_WerentThoseFossilsAmazing
 * release
 * end
 * ```
 */
internal object PewterCity_EventScript_CheckedOutMuseum : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity.WerentThoseFossilsAmazing)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_MUSEUM_GUIDE, PewterCity_Movement_GuideWalkToMuseumWest
 * applymovement LOCALID_PLAYER, PewterCity_Movement_PlayerWalkToMuseumWest
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_LeadToMuseumWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_LeadToMuseumWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * applymovement LOCALID_PEWTER_AIDE, PewterCity_Movement_AideApproachPlayerBottom
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideApproachPlayer3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_AideApproachPlayer3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * applymovement LOCALID_PEWTER_AIDE, PewterCity_Movement_AideApproachPlayerMid
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideApproachPlayer2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_AideApproachPlayer2")
}

/**
 * Ported from the decomp:
 * ```
 * closemessage
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideApproachPlayer1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.moveSelf(FACE_UP)
  }
}

/**
 * Ported from the decomp:
 * ```
 * applymovement LOCALID_PEWTER_AIDE, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideNoticePlayer : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.moveNpc(6, FACE_DOWN)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_AIDE, PewterCity_Movement_AideExit3
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideExit3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_AideExit3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_AIDE, PewterCity_Movement_AideExit2
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideExit2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_AideExit2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * delay 20
 * return
 * ```
 */
internal object PewterCity_EventScript_AideApproachPlayer0 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_EventScript_AideApproachPlayer0")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_AIDE, PewterCity_Movement_AideExit1
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideExit1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_AideExit1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PEWTER_AIDE, PewterCity_Movement_AideExit0
 * waitmovement 0
 * return
 * ```
 */
internal object PewterCity_EventScript_AideExit0 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_EventScript_AideExit0")
}

internal val PewterCityScripts: Map<String, Script> =
    mapOf(
        "PewterCity_EventScript_Lass" to PewterCity_EventScript_Lass,
        "PewterCity_EventScript_MuseumGuide" to PewterCity_EventScript_MuseumGuide,
        "PewterCity_EventScript_FatMan" to PewterCity_EventScript_FatMan,
        "PewterCity_EventScript_BugCatcher" to PewterCity_EventScript_BugCatcher,
        "PewterCity_EventScript_GymGuide" to PewterCity_EventScript_GymGuide,
        "PewterCity_EventScript_RunningShoesAide" to PewterCity_EventScript_RunningShoesAide,
        "PewterCity_EventScript_MuseumSign" to PewterCity_EventScript_MuseumSign,
        "PewterCity_EventScript_PoliceNotice" to PewterCity_EventScript_PoliceNotice,
        "PewterCity_EventScript_GymSign" to PewterCity_EventScript_GymSign,
        "PewterCity_EventScript_TrainerTips" to PewterCity_EventScript_TrainerTips,
        "PewterCity_EventScript_CitySign" to PewterCity_EventScript_CitySign,
        "PewterCity_EventScript_AideGiveRunningShoes" to
            PewterCity_EventScript_AideGiveRunningShoes,
        "PewterCity_EventScript_KnowWhatTheyreDoing" to PewterCity_EventScript_KnowWhatTheyreDoing,
        "PewterCity_EventScript_LeadToMuseumEast" to PewterCity_EventScript_LeadToMuseumEast,
        "PewterCity_EventScript_LeadToMuseumSouth" to PewterCity_EventScript_LeadToMuseumSouth,
        "PewterCity_EventScript_LeadToMuseumNorth" to PewterCity_EventScript_LeadToMuseumNorth,
        "PewterCity_EventScript_WalkToGymEast" to PewterCity_EventScript_WalkToGymEast,
        "PewterCity_EventScript_CheckedOutMuseum" to PewterCity_EventScript_CheckedOutMuseum,
        "PewterCity_EventScript_LeadToMuseumWest" to PewterCity_EventScript_LeadToMuseumWest,
        "PewterCity_EventScript_AideApproachPlayer3" to PewterCity_EventScript_AideApproachPlayer3,
        "PewterCity_EventScript_AideApproachPlayer2" to PewterCity_EventScript_AideApproachPlayer2,
        "PewterCity_EventScript_AideApproachPlayer1" to PewterCity_EventScript_AideApproachPlayer1,
        "PewterCity_EventScript_AideNoticePlayer" to PewterCity_EventScript_AideNoticePlayer,
        "PewterCity_EventScript_AideExit3" to PewterCity_EventScript_AideExit3,
        "PewterCity_EventScript_AideExit2" to PewterCity_EventScript_AideExit2,
        "PewterCity_EventScript_AideApproachPlayer0" to PewterCity_EventScript_AideApproachPlayer0,
        "PewterCity_EventScript_AideExit1" to PewterCity_EventScript_AideExit1,
        "PewterCity_EventScript_AideExit0" to PewterCity_EventScript_AideExit0,
    )
