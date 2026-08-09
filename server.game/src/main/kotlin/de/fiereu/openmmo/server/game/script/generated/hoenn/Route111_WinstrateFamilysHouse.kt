package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route111_WinstrateFamilysHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, LOCALID_WINSTRATE_HOUSE_VIVI
 * msgbox Route111_WinstrateFamilysHouse_Text_StrongerFamilyMembers, MSGBOX_DEFAULT
 * goto Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_Vivi : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_WinstrateFamilysHouse_EventScript_Vivi")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, LOCALID_WINSTRATE_HOUSE_VICTOR
 * msgbox Route111_WinstrateFamilysHouse_Text_MySonIsStrongerThanYou, MSGBOX_DEFAULT
 * goto Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_Victor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_WinstrateFamilysHouse_EventScript_Victor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, LOCALID_WINSTRATE_HOUSE_VICTORIA
 * goto_if_set FLAG_RECEIVED_MACHO_BRACE, Route111_WinstrateFamilysHouse_EventScript_ReceivedMachoBrace
 * msgbox Route111_WinstrateFamilysHouse_Text_LikeYouToHaveMachoBrace, MSGBOX_DEFAULT
 * giveitem ITEM_MACHO_BRACE
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_MACHO_BRACE
 * goto Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_Victoria : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_WinstrateFamilysHouse_EventScript_Victoria")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, LOCALID_WINSTRATE_HOUSE_VICKY
 * goto_if_set FLAG_TEMP_4, Route111_WinstrateFamilysHouse_EventScript_AlreadySpokenTo
 * msgbox Route111_WinstrateFamilysHouse_Text_GrandsonStrong, MSGBOX_DEFAULT
 * setflag FLAG_TEMP_4
 * goto Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_Vicky : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_WinstrateFamilysHouse_EventScript_Vicky")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route111_WinstrateFamilysHouse_Text_GrandsonStrongShort, MSGBOX_DEFAULT
 * goto Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_AlreadySpokenTo : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route111_WinstrateFamilysHouse.GrandsonStrongShort)
    return Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * applymovement VAR_0x8008, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route111_WinstrateFamilysHouse_Text_PassionateAboutBattles, MSGBOX_DEFAULT
 * goto Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object Route111_WinstrateFamilysHouse_EventScript_ReceivedMachoBrace : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route111_WinstrateFamilysHouse.PassionateAboutBattles)
    return Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection.run(ctx)
  }
}

internal val Route111_WinstrateFamilysHouseScripts: Map<String, Script> =
    mapOf(
        "Route111_WinstrateFamilysHouse_EventScript_Vivi" to
            Route111_WinstrateFamilysHouse_EventScript_Vivi,
        "Route111_WinstrateFamilysHouse_EventScript_Victor" to
            Route111_WinstrateFamilysHouse_EventScript_Victor,
        "Route111_WinstrateFamilysHouse_EventScript_Victoria" to
            Route111_WinstrateFamilysHouse_EventScript_Victoria,
        "Route111_WinstrateFamilysHouse_EventScript_Vicky" to
            Route111_WinstrateFamilysHouse_EventScript_Vicky,
        "Route111_WinstrateFamilysHouse_EventScript_AlreadySpokenTo" to
            Route111_WinstrateFamilysHouse_EventScript_AlreadySpokenTo,
        "Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection" to
            Route111_WinstrateFamilysHouse_EventScript_FaceOriginalDirection,
        "Route111_WinstrateFamilysHouse_EventScript_ReceivedMachoBrace" to
            Route111_WinstrateFamilysHouse_EventScript_ReceivedMachoBrace,
    )
