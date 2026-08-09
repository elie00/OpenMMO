package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.EventTicket
import de.fiereu.openmmo.dialog.generated.hoenn.LilycoveCity_Harbor
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, LilycoveCity_Harbor_EventScript_FerryUnavailable
 * call LilycoveCity_Harbor_EventScript_GetEonTicketState
 * call LilycoveCity_Harbor_EventScript_GetAuroraTicketState
 * call LilycoveCity_Harbor_EventScript_GetOldSeaMapState
 * call LilycoveCity_Harbor_EventScript_GetMysticTicketState
 * call LilycoveCity_Harbor_EventScript_GetFirstTimeShowingTicket
 * call LilycoveCity_Harbor_EventScript_GetHasTicketsState
 * goto_if_eq VAR_TEMP_C, 2, LilycoveCity_Harbor_EventScript_OldSeaMapFirstTime
 * goto_if_eq VAR_TEMP_B, 1, LilycoveCity_Harbor_EventScript_EonTicketFirstTime
 * goto_if_eq VAR_TEMP_B, 2, LilycoveCity_Harbor_EventScript_AuroraTicketFirstTime
 * goto_if_eq VAR_TEMP_B, 4, LilycoveCity_Harbor_EventScript_OldSeaMapFirstTime
 * goto_if_eq VAR_TEMP_B, 8, LilycoveCity_Harbor_EventScript_MysticTicketFirstTime
 * goto_if_ne VAR_TEMP_B, 0, LilycoveCity_Harbor_EventScript_MultipleEventTicketsFirstTime
 * goto LilycoveCity_Harbor_EventScript_NoFirstTimeEventTickets
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_FerryAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_FerryAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_SYS_GAME_CLEAR, LilycoveCity_Harbor_EventScript_SailorFerryAvailable
 * msgbox LilycoveCity_Harbor_Text_SailorFerryUnavailable, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port LilycoveCity_Harbor_EventScript_Sailor")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_Harbor_Text_SailorFerryAvailable, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SailorFerryAvailable : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_Harbor.SailorFerryAvailable)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_TEMP_A, 0, LilycoveCity_Harbor_EventScript_NoEventTickets
 * msgbox LilycoveCity_Harbor_Text_MayISeeYourTicket, MSGBOX_DEFAULT
 * message LilycoveCity_Harbor_Text_FlashTicketWhereTo
 * waitmessage
 * goto LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_NoFirstTimeEventTickets : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_NoFirstTimeEventTickets")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_SHOWN_MYSTIC_TICKET
 * msgbox EventTicket_Text_ThatPass, MSGBOX_DEFAULT
 * closemessage
 * call LilycoveCity_Harbor_EventScript_GetEventTicketSailor
 * msgbox EventTicket_Text_OddTicketGetOnBoard, MSGBOX_DEFAULT
 * goto LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_MysticTicketFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_SHOWN_MYSTIC_TICKET)
    ctx.say(EventTicket.ThatPass)
    LilycoveCity_Harbor_EventScript_GetEventTicketSailor.run(ctx)
    ctx.say(EventTicket.OddTicketGetOnBoard)
    return LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_D, 0
 * goto_if_unset FLAG_ENABLE_SHIP_BIRTH_ISLAND, Common_EventScript_NopReturn
 * checkitem ITEM_AURORA_TICKET
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_NopReturn
 * setvar VAR_TEMP_D, 1
 * goto_if_set FLAG_SHOWN_AURORA_TICKET, Common_EventScript_NopReturn
 * setvar VAR_TEMP_D, 2
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetAuroraTicketState : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetAuroraTicketState")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_E, 0
 * goto_if_unset FLAG_ENABLE_SHIP_SOUTHERN_ISLAND, Common_EventScript_NopReturn
 * checkitem ITEM_EON_TICKET
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_NopReturn
 * setvar VAR_TEMP_E, 1
 * goto_if_set FLAG_SHOWN_EON_TICKET, Common_EventScript_NopReturn
 * setvar VAR_TEMP_E, 2
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetEonTicketState : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetEonTicketState")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_A, 0
 * call_if_eq VAR_TEMP_E, 1, LilycoveCity_Harbor_EventScript_SetHasEonTicket
 * call_if_eq VAR_TEMP_D, 1, LilycoveCity_Harbor_EventScript_SetHasAuroraTicket
 * call_if_eq VAR_TEMP_C, 1, LilycoveCity_Harbor_EventScript_SetHasOldSeaMap
 * call_if_eq VAR_TEMP_9, 1, LilycoveCity_Harbor_EventScript_SetHasMysticTicket
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetHasTicketsState : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetHasTicketsState")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_C, 0
 * goto_if_unset FLAG_ENABLE_SHIP_FARAWAY_ISLAND, Common_EventScript_NopReturn
 * checkitem ITEM_OLD_SEA_MAP
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_NopReturn
 * setvar VAR_TEMP_C, 1
 * goto_if_set FLAG_SHOWN_OLD_SEA_MAP, Common_EventScript_NopReturn
 * setvar VAR_TEMP_C, 2
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetOldSeaMapState : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetOldSeaMapState")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_9, 0
 * goto_if_unset FLAG_ENABLE_SHIP_NAVEL_ROCK, Common_EventScript_NopReturn
 * checkitem ITEM_MYSTIC_TICKET
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_NopReturn
 * setvar VAR_TEMP_9, 1
 * goto_if_set FLAG_SHOWN_MYSTIC_TICKET, Common_EventScript_NopReturn
 * setvar VAR_TEMP_9, 2
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetMysticTicketState : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetMysticTicketState")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_B, 0
 * call_if_eq VAR_TEMP_E, 2, LilycoveCity_Harbor_EventScript_SetFirstTimeShowingEonTicket
 * call_if_eq VAR_TEMP_D, 2, LilycoveCity_Harbor_EventScript_SetFirstTimeShowingAuroraTicket
 * call_if_eq VAR_TEMP_C, 2, LilycoveCity_Harbor_EventScript_SetFirstTimeShowingOldSeaMap
 * call_if_eq VAR_TEMP_9, 2, LilycoveCity_Harbor_EventScript_SetFirstTimeShowingMysticTicket
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetFirstTimeShowingTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetFirstTimeShowingTicket")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_SHOWN_EON_TICKET
 * msgbox EventTicket_Text_ThatPass, MSGBOX_DEFAULT
 * closemessage
 * call LilycoveCity_Harbor_EventScript_GetEventTicketSailor
 * msgbox EventTicket_Text_ShowEonTicket, MSGBOX_DEFAULT
 * goto LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_EonTicketFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_SHOWN_EON_TICKET)
    ctx.say(EventTicket.ThatPass)
    LilycoveCity_Harbor_EventScript_GetEventTicketSailor.run(ctx)
    ctx.say(EventTicket.ShowEonTicket)
    return LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_Harbor_Text_FerryUnavailable, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_FerryUnavailable : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_Harbor.FerryUnavailable)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_SHOWN_AURORA_TICKET
 * msgbox EventTicket_Text_ThatPass, MSGBOX_DEFAULT
 * closemessage
 * call LilycoveCity_Harbor_EventScript_GetEventTicketSailor
 * msgbox EventTicket_Text_OddTicketGetOnBoard, MSGBOX_DEFAULT
 * goto LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_AuroraTicketFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_SHOWN_AURORA_TICKET)
    ctx.say(EventTicket.ThatPass)
    LilycoveCity_Harbor_EventScript_GetEventTicketSailor.run(ctx)
    ctx.say(EventTicket.OddTicketGetOnBoard)
    return LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox EventTicket_Text_ThatPass, MSGBOX_DEFAULT
 * closemessage
 * call LilycoveCity_Harbor_EventScript_GetEventTicketSailor
 * message EventTicket_Text_OddTicketsWhereTo
 * waitmessage
 * setvar VAR_0x8004, 1
 * special ScriptMenu_CreateLilycoveSSTidalMultichoice
 * special GetLilycoveSSTidalSelection
 * switch VAR_RESULT
 * case 2, LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime
 * case 3, LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime
 * case 4, LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime
 * case 5, LilycoveCity_Harbor_EventScript_GoToFarawayIslandFirstTime
 * case 6, LilycoveCity_Harbor_EventScript_ExitFirstTimeTicketSailSelect
 * case MULTI_B_PRESSED, LilycoveCity_Harbor_EventScript_ExitFirstTimeTicketSailSelect
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_MultipleEventTicketsFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_MultipleEventTicketsFirstTime")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_SHOWN_OLD_SEA_MAP
 * msgbox EventTicket_Text_ShowOldSeaMap, MSGBOX_DEFAULT
 * closemessage
 * call LilycoveCity_Harbor_EventScript_GetEventTicketSailor
 * msgbox EventTicket_Text_OldSeaMapTooFar, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, Common_Movement_Delay48
 * waitmovement 0
 * call_if_eq VAR_FACING, DIR_NORTH, LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayNorth
 * call_if_eq VAR_FACING, DIR_EAST, LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayEast
 * addobject LOCALID_LILYCOVE_HARBOR_BRINEY
 * call_if_eq VAR_FACING, DIR_NORTH, LilycoveCity_Harbor_EventScript_BrineyFaceSailorNorth
 * call_if_eq VAR_FACING, DIR_EAST, LilycoveCity_Harbor_EventScript_BrineyFaceSailorEast
 * msgbox EventTicket_Text_BrineyHoldOnASecond, MSGBOX_DEFAULT
 * call_if_eq VAR_FACING, DIR_NORTH, LilycoveCity_Harbor_EventScript_BrineyFacePlayerNorth
 * call_if_eq VAR_FACING, DIR_EAST, LilycoveCity_Harbor_EventScript_BrineyFacePlayerEast
 * msgbox EventTicket_Text_BrineyLetsSail, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorNorth
 * call_if_eq VAR_FACING, DIR_EAST, LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorEast
 * setvar VAR_0x8004, LOCALID_LILYCOVE_HARBOR_SS_TIDAL
 * call Common_EventScript_FerryDepart
 * warp MAP_FARAWAY_ISLAND_ENTRANCE, 13, 38
 * waitstate
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_OldSeaMapFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_OldSeaMapFirstTime")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_A, 2
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetHasAuroraTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetHasAuroraTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_B, 8
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetFirstTimeShowingMysticTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetFirstTimeShowingMysticTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_BRINEY, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BrineyFacePlayerEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BrineyFacePlayerEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * call LilycoveCity_Harbor_EventScript_BoardFerryWithSailor
 * warp MAP_SOUTHERN_ISLAND_EXTERIOR, 13, 22
 * waitstate
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_BRINEY, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BrineyFaceSailorNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BrineyFaceSailorNorth")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_Harbor_Text_MayISeeYourTicket, MSGBOX_DEFAULT
 * message LilycoveCity_Harbor_Text_FlashTicketWhereTo
 * waitmessage
 * goto LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_NoEventTickets : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_Harbor.MayISeeYourTicket)
    ctx.say(LilycoveCity_Harbor.FlashTicketWhereTo)
    return LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * delay 30
 * hideobjectat VAR_LAST_TALKED, MAP_LILYCOVE_CITY_HARBOR
 * delay 60
 * addobject LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR
 * delay 30
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, Common_Movement_FacePlayer
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GetEventTicketSailor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GetEventTicketSailor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_B, 4
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetFirstTimeShowingOldSeaMap : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetFirstTimeShowingOldSeaMap")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * call LilycoveCity_Harbor_EventScript_BoardFerryWithSailor
 * warp MAP_NAVEL_ROCK_HARBOR, 8, 4
 * waitstate
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_B, 1
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetFirstTimeShowingEonTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetFirstTimeShowingEonTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * call LilycoveCity_Harbor_EventScript_BoardFerryWithSailor
 * warp MAP_BIRTH_ISLAND_HARBOR, 8, 4
 * waitstate
 * release
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_A, 8
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetHasMysticTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetHasMysticTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, LilycoveCity_Harbor_Movement_SailorOutOfWayNorth
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_BRINEY, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BrineyFacePlayerNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BrineyFacePlayerNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_B, 2
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetFirstTimeShowingAuroraTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetFirstTimeShowingAuroraTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_BRINEY, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BrineyFaceSailorEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BrineyFaceSailorEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_BRINEY, LilycoveCity_Harbor_Movement_BrineyBoardFerry
 * applymovement LOCALID_PLAYER, LilycoveCity_Harbor_Movement_PlayerBoardWithBrineyNorth
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, LilycoveCity_Harbor_Movement_SailorBoardWithBrineyNorth
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_BRINEY, LilycoveCity_Harbor_Movement_BrineyBoardFerry
 * applymovement LOCALID_PLAYER, LilycoveCity_Harbor_Movement_PlayerBoardWithBrineyEast
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, LilycoveCity_Harbor_Movement_SailorBoardWithBrineyEast
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_A, 1
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetHasEonTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetHasEonTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_A, 4
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_SetHasOldSeaMap : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_SetHasOldSeaMap")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * special ScriptMenu_CreateLilycoveSSTidalMultichoice
 * special GetLilycoveSSTidalSelection
 * switch VAR_RESULT
 * case 0, LilycoveCity_Harbor_EventScript_GoToSlateport
 * case 1, LilycoveCity_Harbor_EventScript_GoToBattleFrontier
 * case 2, LilycoveCity_Harbor_EventScript_GoToSouthernIsland
 * case 3, LilycoveCity_Harbor_EventScript_GoToNavelRock
 * case 4, LilycoveCity_Harbor_EventScript_GoToBirthIsland
 * case 5, LilycoveCity_Harbor_EventScript_GoToFarawayIsland
 * case 6, LilycoveCity_Harbor_EventScript_ExitSailSelect
 * case MULTI_B_PRESSED, LilycoveCity_Harbor_EventScript_ExitSailSelect
 * end
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, LilycoveCity_Harbor_Movement_SailorOutOfWayEast
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * delay 30
 * removeobject LOCALID_LILYCOVE_HARBOR_FERRY_SAILOR
 * call_if_eq VAR_FACING, DIR_NORTH, LilycoveCity_Harbor_EventScript_PlayerBoardFerryNorth
 * call_if_eq VAR_FACING, DIR_EAST, LilycoveCity_Harbor_EventScript_PlayerBoardFerryEast
 * delay 30
 * hideplayer
 * setvar VAR_0x8004, LOCALID_LILYCOVE_HARBOR_SS_TIDAL
 * call Common_EventScript_FerryDepart
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_BoardFerryWithSailor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_BoardFerryWithSailor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, LilycoveCity_Harbor_Movement_PlayerBoardFerryEast
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_PlayerBoardFerryEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_PlayerBoardFerryEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, LilycoveCity_Harbor_Movement_PlayerBoardFerryNorth
 * waitmovement 0
 * return
 * ```
 */
internal object LilycoveCity_Harbor_EventScript_PlayerBoardFerryNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_Harbor_EventScript_PlayerBoardFerryNorth")
}

internal val LilycoveCity_HarborScripts: Map<String, Script> =
    mapOf(
        "LilycoveCity_Harbor_EventScript_FerryAttendant" to
            LilycoveCity_Harbor_EventScript_FerryAttendant,
        "LilycoveCity_Harbor_EventScript_Sailor" to LilycoveCity_Harbor_EventScript_Sailor,
        "LilycoveCity_Harbor_EventScript_SailorFerryAvailable" to
            LilycoveCity_Harbor_EventScript_SailorFerryAvailable,
        "LilycoveCity_Harbor_EventScript_NoFirstTimeEventTickets" to
            LilycoveCity_Harbor_EventScript_NoFirstTimeEventTickets,
        "LilycoveCity_Harbor_EventScript_MysticTicketFirstTime" to
            LilycoveCity_Harbor_EventScript_MysticTicketFirstTime,
        "LilycoveCity_Harbor_EventScript_GetAuroraTicketState" to
            LilycoveCity_Harbor_EventScript_GetAuroraTicketState,
        "LilycoveCity_Harbor_EventScript_GetEonTicketState" to
            LilycoveCity_Harbor_EventScript_GetEonTicketState,
        "LilycoveCity_Harbor_EventScript_GetHasTicketsState" to
            LilycoveCity_Harbor_EventScript_GetHasTicketsState,
        "LilycoveCity_Harbor_EventScript_GetOldSeaMapState" to
            LilycoveCity_Harbor_EventScript_GetOldSeaMapState,
        "LilycoveCity_Harbor_EventScript_GetMysticTicketState" to
            LilycoveCity_Harbor_EventScript_GetMysticTicketState,
        "LilycoveCity_Harbor_EventScript_GetFirstTimeShowingTicket" to
            LilycoveCity_Harbor_EventScript_GetFirstTimeShowingTicket,
        "LilycoveCity_Harbor_EventScript_EonTicketFirstTime" to
            LilycoveCity_Harbor_EventScript_EonTicketFirstTime,
        "LilycoveCity_Harbor_EventScript_FerryUnavailable" to
            LilycoveCity_Harbor_EventScript_FerryUnavailable,
        "LilycoveCity_Harbor_EventScript_AuroraTicketFirstTime" to
            LilycoveCity_Harbor_EventScript_AuroraTicketFirstTime,
        "LilycoveCity_Harbor_EventScript_MultipleEventTicketsFirstTime" to
            LilycoveCity_Harbor_EventScript_MultipleEventTicketsFirstTime,
        "LilycoveCity_Harbor_EventScript_OldSeaMapFirstTime" to
            LilycoveCity_Harbor_EventScript_OldSeaMapFirstTime,
        "LilycoveCity_Harbor_EventScript_SetHasAuroraTicket" to
            LilycoveCity_Harbor_EventScript_SetHasAuroraTicket,
        "LilycoveCity_Harbor_EventScript_SetFirstTimeShowingMysticTicket" to
            LilycoveCity_Harbor_EventScript_SetFirstTimeShowingMysticTicket,
        "LilycoveCity_Harbor_EventScript_BrineyFacePlayerEast" to
            LilycoveCity_Harbor_EventScript_BrineyFacePlayerEast,
        "LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime" to
            LilycoveCity_Harbor_EventScript_GoToSouthernIslandFirstTime,
        "LilycoveCity_Harbor_EventScript_BrineyFaceSailorNorth" to
            LilycoveCity_Harbor_EventScript_BrineyFaceSailorNorth,
        "LilycoveCity_Harbor_EventScript_NoEventTickets" to
            LilycoveCity_Harbor_EventScript_NoEventTickets,
        "LilycoveCity_Harbor_EventScript_GetEventTicketSailor" to
            LilycoveCity_Harbor_EventScript_GetEventTicketSailor,
        "LilycoveCity_Harbor_EventScript_SetFirstTimeShowingOldSeaMap" to
            LilycoveCity_Harbor_EventScript_SetFirstTimeShowingOldSeaMap,
        "LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime" to
            LilycoveCity_Harbor_EventScript_GoToNavelRockFirstTime,
        "LilycoveCity_Harbor_EventScript_SetFirstTimeShowingEonTicket" to
            LilycoveCity_Harbor_EventScript_SetFirstTimeShowingEonTicket,
        "LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime" to
            LilycoveCity_Harbor_EventScript_GoToBirthIslandFirstTime,
        "LilycoveCity_Harbor_EventScript_SetHasMysticTicket" to
            LilycoveCity_Harbor_EventScript_SetHasMysticTicket,
        "LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayNorth" to
            LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayNorth,
        "LilycoveCity_Harbor_EventScript_BrineyFacePlayerNorth" to
            LilycoveCity_Harbor_EventScript_BrineyFacePlayerNorth,
        "LilycoveCity_Harbor_EventScript_SetFirstTimeShowingAuroraTicket" to
            LilycoveCity_Harbor_EventScript_SetFirstTimeShowingAuroraTicket,
        "LilycoveCity_Harbor_EventScript_BrineyFaceSailorEast" to
            LilycoveCity_Harbor_EventScript_BrineyFaceSailorEast,
        "LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorNorth" to
            LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorNorth,
        "LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorEast" to
            LilycoveCity_Harbor_EventScript_BoardFerryWithBrineyAndSailorEast,
        "LilycoveCity_Harbor_EventScript_SetHasEonTicket" to
            LilycoveCity_Harbor_EventScript_SetHasEonTicket,
        "LilycoveCity_Harbor_EventScript_SetHasOldSeaMap" to
            LilycoveCity_Harbor_EventScript_SetHasOldSeaMap,
        "LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect" to
            LilycoveCity_Harbor_EventScript_FerryRegularLocationSelect,
        "LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayEast" to
            LilycoveCity_Harbor_EventScript_MoveSailorOutOfWayEast,
        "LilycoveCity_Harbor_EventScript_BoardFerryWithSailor" to
            LilycoveCity_Harbor_EventScript_BoardFerryWithSailor,
        "LilycoveCity_Harbor_EventScript_PlayerBoardFerryEast" to
            LilycoveCity_Harbor_EventScript_PlayerBoardFerryEast,
        "LilycoveCity_Harbor_EventScript_PlayerBoardFerryNorth" to
            LilycoveCity_Harbor_EventScript_PlayerBoardFerryNorth,
    )
