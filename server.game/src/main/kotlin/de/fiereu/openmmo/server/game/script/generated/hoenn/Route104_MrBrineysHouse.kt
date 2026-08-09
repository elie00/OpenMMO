package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route104_MrBrineysHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_unset FLAG_MR_BRINEY_SAILING_INTRO, Route104_MrBrineysHouse_EventScript_SailingIntro
 * goto_if_unset FLAG_DELIVERED_STEVEN_LETTER, Route104_MrBrineysHouse_EventScript_SailBothDeliveries
 * goto_if_unset FLAG_DELIVERED_DEVON_GOODS, Route104_MrBrineysHouse_EventScript_SailDeliverPackage
 * goto Route104_MrBrineysHouse_EventScript_WhereAreWeBound
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_Briney : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_Briney")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_WINGULL, CRY_MODE_NORMAL
 * msgbox Route104_MrBrineysHouse_Text_Peeko, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_Peeko : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_Peeko")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_MrBrineysHouse_Text_NeedToMakeDeliveriesSailToDewford, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route104_MrBrineysHouse_EventScript_DeclineDeliverySailing
 * goto Route104_MrBrineysHouse_EventScript_SailToDewford
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_SailBothDeliveries : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_SailBothDeliveries")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Route104_MrBrineysHouse_Text_WhereAreWeBound
 * waitmessage
 * multichoicedefault 20, 8, MULTI_BRINEY_OFF_DEWFORD, 1, FALSE
 * switch VAR_RESULT
 * case 0, Route104_MrBrineysHouse_EventScript_SailToDewford
 * case 1, Route104_MrBrineysHouse_EventScript_DeclineSailing
 * case MULTI_B_PRESSED, Route104_MrBrineysHouse_EventScript_DeclineSailing
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_WhereAreWeBound : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_WhereAreWeBound")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_MrBrineysHouse_Text_NeedToDeliverPackageSailToDewford, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route104_MrBrineysHouse_EventScript_DeclineDeliverySailing
 * goto Route104_MrBrineysHouse_EventScript_SailToDewford
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_SailDeliverPackage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_SailDeliverPackage")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_MR_BRINEY_SAILING_INTRO
 * msgbox Route104_MrBrineysHouse_Text_WaitUpPeeko, MSGBOX_DEFAULT
 * msgbox Route104_MrBrineysHouse_Text_ItsYouLetsSailToDewford, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route104_MrBrineysHouse_EventScript_DeclineDeliverySailing
 * goto Route104_MrBrineysHouse_EventScript_SailToDewford
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_SailingIntro : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_SailingIntro")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route104_MrBrineysHouse_Text_DeclineDeliverySail, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_DeclineDeliverySailing : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route104_MrBrineysHouse.DeclineDeliverySail)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_MrBrineysHouse_Text_SetSailForDewford, MSGBOX_DEFAULT
 * call EventScript_BackupMrBrineyLocation
 * setvar VAR_BOARD_BRINEY_BOAT_STATE, 1
 * clearflag FLAG_HIDE_ROUTE_104_MR_BRINEY
 * setflag FLAG_HIDE_BRINEYS_HOUSE_MR_BRINEY
 * setflag FLAG_HIDE_BRINEYS_HOUSE_PEEKO
 * setvar VAR_RUSTBORO_CITY_STATE, 8
 * setvar VAR_ROUTE104_STATE, 2
 * setflag FLAG_HIDE_RUSTBORO_CITY_RIVAL
 * setflag FLAG_HIDE_ROUTE_104_RIVAL
 * warp MAP_ROUTE104, 13, 51
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object Route104_MrBrineysHouse_EventScript_SailToDewford : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_MrBrineysHouse_EventScript_SailToDewford")
}

internal val Route104_MrBrineysHouseScripts: Map<String, Script> =
    mapOf(
        "Route104_MrBrineysHouse_EventScript_Briney" to Route104_MrBrineysHouse_EventScript_Briney,
        "Route104_MrBrineysHouse_EventScript_Peeko" to Route104_MrBrineysHouse_EventScript_Peeko,
        "Route104_MrBrineysHouse_EventScript_SailBothDeliveries" to
            Route104_MrBrineysHouse_EventScript_SailBothDeliveries,
        "Route104_MrBrineysHouse_EventScript_WhereAreWeBound" to
            Route104_MrBrineysHouse_EventScript_WhereAreWeBound,
        "Route104_MrBrineysHouse_EventScript_SailDeliverPackage" to
            Route104_MrBrineysHouse_EventScript_SailDeliverPackage,
        "Route104_MrBrineysHouse_EventScript_SailingIntro" to
            Route104_MrBrineysHouse_EventScript_SailingIntro,
        "Route104_MrBrineysHouse_EventScript_DeclineDeliverySailing" to
            Route104_MrBrineysHouse_EventScript_DeclineDeliverySailing,
        "Route104_MrBrineysHouse_EventScript_SailToDewford" to
            Route104_MrBrineysHouse_EventScript_SailToDewford,
    )
