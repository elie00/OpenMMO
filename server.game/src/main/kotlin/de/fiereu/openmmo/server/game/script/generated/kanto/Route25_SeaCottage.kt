package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route25_SeaCottage
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set RETURN_AFTER_SS_TICKET, Route25_SeaCottage_EventScript_BillGoLookAtPC
 * goto_if_set FLAG_GOT_SS_TICKET, Route25_SeaCottage_EventScript_BillGoToSSAnne
 * goto_if_set FLAG_HELPED_BILL_IN_SEA_COTTAGE, Route25_SeaCottage_EventScript_BillGiveSSTicket
 * checkplayergender
 * goto_if_eq VAR_RESULT, MALE, Route25_SeaCottage_EventScript_BillAskForHelpMale
 * goto_if_eq VAR_RESULT, FEMALE, Route25_SeaCottage_EventScript_BillAskForHelpFemale
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_Bill : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route25_SeaCottage_EventScript_Bill")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set RETURN_AFTER_SS_TICKET, Route25_SeaCottage_EventScript_OpenBillsMonList
 * goto_if_set BILL_IN_TELEPORTER, Route25_SeaCottage_EventScript_RunCellSeparator
 * msgbox Route25_SeaCottage_Text_TeleporterIsDisplayed
 * releaseall
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_Computer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_Computer")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_ImBillHelpMeOutPal, MSGBOX_YESNO
 * goto Route25_SeaCottage_EventScript_BillAskForHelp
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillAskForHelpMale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.ImBillHelpMeOutPal)
    return Route25_SeaCottage_EventScript_BillAskForHelp.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadeoutbgm 0
 * msgbox Route25_SeaCottage_Text_InitiatedTeleportersCellSeparator
 * closemessage
 * clearflag BILL_IN_TELEPORTER
 * setflag FLAG_HELPED_BILL_IN_SEA_COTTAGE
 * special SpawnCameraObject
 * applymovement LOCALID_CAMERA, Route25_SeaCottage_Movement_CameraPanToTeleporters
 * waitmovement 0
 * delay 35
 * playse SE_PIN
 * waitse
 * setvar VAR_0x8004, 0
 * special AnimateTeleporterHousing
 * delay 10
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * setvar VAR_0x8004, 1
 * special AnimateTeleporterHousing
 * playse SE_WARP_IN
 * special AnimateTeleporterCable
 * waitse
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * call Route25_SeaCottage_EventScript_PlayTeleporterBeepSE
 * opendoor 3, 3
 * waitdooranim
 * fadeinbgm 0
 * addobject LOCALID_BILL_HUMAN
 * clearflag FLAG_HIDE_BILL_HUMAN_SEA_COTTAGE
 * delay 50
 * playfanfare MUS_LEVEL_UP
 * applymovement LOCALID_BILL_HUMAN, Route25_SeaCottage_Movement_BillExitTeleporter
 * waitmovement 0
 * waitfanfare
 * applymovement LOCALID_CAMERA, Route25_SeaCottage_Movement_CameraPanBackFromTeleporters
 * waitmovement 0
 * playse SE_CONTEST_CURTAIN_FALL
 * closedoor 3, 3
 * waitdooranim
 * applymovement LOCALID_BILL_HUMAN, Route25_SeaCottage_Movement_BillWalkToMiddleOfRoom
 * waitmovement 0
 * special RemoveCameraObject
 * releaseall
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_RunCellSeparator : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_RunCellSeparator")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_SSAnnePartyYouGoInstead
 * release
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillGoToSSAnne : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.SSAnnePartyYouGoInstead)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_BILL, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, Route25_SeaCottage_EventScript_BillThanksMale
 * call_if_eq VAR_RESULT, FEMALE, Route25_SeaCottage_EventScript_BillThanksFemale
 * checkitemspace ITEM_SS_TICKET
 * goto_if_eq VAR_RESULT, FALSE, Route25_SeaCottage_EventScript_NoRoomForSSTicket
 * giveitem_msg Route25_SeaCottage_Text_ReceivedSSTicketFromBill, ITEM_SS_TICKET, 1, MUS_OBTAIN_KEY_ITEM
 * setflag FLAG_GOT_SS_TICKET_DUP
 * setflag FLAG_HIDE_NUGGET_BRIDGE_ROCKET
 * setflag FLAG_GOT_SS_TICKET
 * setflag FLAG_SYS_NOT_SOMEONES_PC
 * goto Route25_SeaCottage_EventScript_BillGoToSSAnne
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillGiveSSTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_BillGiveSSTicket")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_BillsFavoriteMonList
 * goto Route25_SeaCottage_EventScript_BillsMonList
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_OpenBillsMonList : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.BillsFavoriteMonList)
    return Route25_SeaCottage_EventScript_BillsMonList.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_ImBillHelpMeOutLady, MSGBOX_YESNO
 * goto Route25_SeaCottage_EventScript_BillAskForHelp
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillAskForHelpFemale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.ImBillHelpMeOutLady)
    return Route25_SeaCottage_EventScript_BillAskForHelp.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_CheckOutRareMonsOnPC
 * release
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillGoLookAtPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.CheckOutRareMonsOnPC)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_ThanksBudTakeThis
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillThanksMale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.ThanksBudTakeThis)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Route25_SeaCottage_Text_SeeWhichMon
 * waitmessage
 * multichoice 0, 0, MULTICHOICE_EEVEELUTIONS, FALSE
 * switch VAR_RESULT
 * case 0, Route25_SeaCottage_EventScript_ViewEevee
 * case 1, Route25_SeaCottage_EventScript_ViewFlareon
 * case 2, Route25_SeaCottage_EventScript_ViewJolteon
 * case 3, Route25_SeaCottage_EventScript_ViewVaporeon
 * case 4, Route25_SeaCottage_EventScript_ExitBillsMonList
 * case 127, Route25_SeaCottage_EventScript_ExitBillsMonList
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillsMonList : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_BillsMonList")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_ThanksLadyTakeThis
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillThanksFemale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.ThanksLadyTakeThis)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_BALL
 * waitse
 * delay 20
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_PlayTeleporterBeepSE : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_PlayTeleporterBeepSE")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_RESULT, NO, Route25_SeaCottage_EventScript_DeclineHelpBill
 * msgbox Route25_SeaCottage_Text_RunCellSeparationOnPC
 * closemessage
 * delay 10
 * call_if_eq VAR_FACING, DIR_SOUTH, Route25_SeaCottage_EventScript_BillWalkToTeleporterSouth
 * call_if_eq VAR_FACING, DIR_NORTH, Route25_SeaCottage_EventScript_BillWalkToTeleporter
 * call_if_eq VAR_FACING, DIR_WEST, Route25_SeaCottage_EventScript_BillWalkToTeleporter
 * call_if_eq VAR_FACING, DIR_EAST, Route25_SeaCottage_EventScript_BillWalkToTeleporter
 * opendoor 10, 3
 * waitdooranim
 * applymovement LOCALID_BILL_CLEFAIRY, Route25_SeaCottage_Movement_BillEnterTeleporter
 * waitmovement 0
 * removeobject LOCALID_BILL_CLEFAIRY
 * playse SE_CONTEST_CURTAIN_FALL
 * closedoor 10, 3
 * waitdooranim
 * setflag BILL_IN_TELEPORTER
 * release
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillAskForHelp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_BillAskForHelp")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_YouveGotTooMuchStuff
 * release
 * end
 * ```
 */
internal object Route25_SeaCottage_EventScript_NoRoomForSSTicket : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.YouveGotTooMuchStuff)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_BILL_CLEFAIRY, Route25_SeaCottage_Movement_BillWalkToTeleporterSouth
 * waitmovement 0
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillWalkToTeleporterSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_BillWalkToTeleporterSouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_BILL_CLEFAIRY, Route25_SeaCottage_Movement_BillWalkToTeleporter
 * waitmovement 0
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_BillWalkToTeleporter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_BillWalkToTeleporter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, Route25_SeaCottage_EventScript_DeclineHelpBillMale
 * call_if_eq VAR_RESULT, FEMALE, Route25_SeaCottage_EventScript_DeclineHelpBillFemale
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_DeclineHelpBill : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route25_SeaCottage_EventScript_DeclineHelpBill")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_NoPleaseBeautiful
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_DeclineHelpBillFemale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.NoPleaseBeautiful)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route25_SeaCottage_Text_NoPleaseChief
 * return
 * ```
 */
internal object Route25_SeaCottage_EventScript_DeclineHelpBillMale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route25_SeaCottage.NoPleaseChief)
  }
}

internal val Route25_SeaCottageScripts: Map<String, Script> =
    mapOf(
        "Route25_SeaCottage_EventScript_Bill" to Route25_SeaCottage_EventScript_Bill,
        "Route25_SeaCottage_EventScript_Computer" to Route25_SeaCottage_EventScript_Computer,
        "Route25_SeaCottage_EventScript_BillAskForHelpMale" to
            Route25_SeaCottage_EventScript_BillAskForHelpMale,
        "Route25_SeaCottage_EventScript_RunCellSeparator" to
            Route25_SeaCottage_EventScript_RunCellSeparator,
        "Route25_SeaCottage_EventScript_BillGoToSSAnne" to
            Route25_SeaCottage_EventScript_BillGoToSSAnne,
        "Route25_SeaCottage_EventScript_BillGiveSSTicket" to
            Route25_SeaCottage_EventScript_BillGiveSSTicket,
        "Route25_SeaCottage_EventScript_OpenBillsMonList" to
            Route25_SeaCottage_EventScript_OpenBillsMonList,
        "Route25_SeaCottage_EventScript_BillAskForHelpFemale" to
            Route25_SeaCottage_EventScript_BillAskForHelpFemale,
        "Route25_SeaCottage_EventScript_BillGoLookAtPC" to
            Route25_SeaCottage_EventScript_BillGoLookAtPC,
        "Route25_SeaCottage_EventScript_BillThanksMale" to
            Route25_SeaCottage_EventScript_BillThanksMale,
        "Route25_SeaCottage_EventScript_BillsMonList" to
            Route25_SeaCottage_EventScript_BillsMonList,
        "Route25_SeaCottage_EventScript_BillThanksFemale" to
            Route25_SeaCottage_EventScript_BillThanksFemale,
        "Route25_SeaCottage_EventScript_PlayTeleporterBeepSE" to
            Route25_SeaCottage_EventScript_PlayTeleporterBeepSE,
        "Route25_SeaCottage_EventScript_BillAskForHelp" to
            Route25_SeaCottage_EventScript_BillAskForHelp,
        "Route25_SeaCottage_EventScript_NoRoomForSSTicket" to
            Route25_SeaCottage_EventScript_NoRoomForSSTicket,
        "Route25_SeaCottage_EventScript_BillWalkToTeleporterSouth" to
            Route25_SeaCottage_EventScript_BillWalkToTeleporterSouth,
        "Route25_SeaCottage_EventScript_BillWalkToTeleporter" to
            Route25_SeaCottage_EventScript_BillWalkToTeleporter,
        "Route25_SeaCottage_EventScript_DeclineHelpBill" to
            Route25_SeaCottage_EventScript_DeclineHelpBill,
        "Route25_SeaCottage_EventScript_DeclineHelpBillFemale" to
            Route25_SeaCottage_EventScript_DeclineHelpBillFemale,
        "Route25_SeaCottage_EventScript_DeclineHelpBillMale" to
            Route25_SeaCottage_EventScript_DeclineHelpBillMale,
    )
