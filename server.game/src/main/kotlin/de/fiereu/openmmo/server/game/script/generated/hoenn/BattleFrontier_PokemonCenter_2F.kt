package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * script body not found
 * ```
 */
internal object Common_EventScript_UnionRoomAttendant : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_UnionRoomAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * script body not found
 * ```
 */
internal object Common_EventScript_WirelessClubAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Common_EventScript_WirelessClubAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * script body not found
 * ```
 */
internal object Common_EventScript_DirectCornerAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Common_EventScript_DirectCornerAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ShouldDistributeEonTicket
 * goto_if_eq VAR_RESULT, TRUE, CableClub_EventScript_DistributeEonTicket
 * goto CableClub_EventScript_TryWonderCardScript
 * end
 * ```
 */
internal object CableClub_EventScript_MysteryGiftMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CableClub_EventScript_MysteryGiftMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trywondercardscript
 * msgbox gText_ThankYouForAccessingMysteryGift, MSGBOX_NPC
 * end
 * ```
 */
internal object CableClub_EventScript_TryWonderCardScript : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CableClub_EventScript_TryWonderCardScript")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_EON_TICKET
 * goto_if_eq VAR_RESULT, TRUE, CableClub_EventScript_TryWonderCardScript
 * goto_if_set FLAG_ENABLE_SHIP_SOUTHERN_ISLAND, CableClub_EventScript_TryWonderCardScript
 * msgbox MysteryGift_Text_TheresATicketForYou, MSGBOX_DEFAULT
 * giveitem ITEM_EON_TICKET
 * setflag FLAG_ENABLE_SHIP_SOUTHERN_ISLAND
 * setvar VAR_DISTRIBUTE_EON_TICKET, 0
 * msgbox MysteryGift_Text_TryUsingItAtLilycovePort, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object CableClub_EventScript_DistributeEonTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CableClub_EventScript_DistributeEonTicket")
}

internal val BattleFrontier_PokemonCenter_2FScripts: Map<String, Script> =
    mapOf(
        "Common_EventScript_UnionRoomAttendant" to Common_EventScript_UnionRoomAttendant,
        "Common_EventScript_WirelessClubAttendant" to Common_EventScript_WirelessClubAttendant,
        "Common_EventScript_DirectCornerAttendant" to Common_EventScript_DirectCornerAttendant,
        "CableClub_EventScript_MysteryGiftMan" to CableClub_EventScript_MysteryGiftMan,
        "CableClub_EventScript_TryWonderCardScript" to CableClub_EventScript_TryWonderCardScript,
        "CableClub_EventScript_DistributeEonTicket" to CableClub_EventScript_DistributeEonTicket,
    )
