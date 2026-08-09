package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SlateportCity_Harbor
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_SYS_GAME_CLEAR, SlateportCity_Harbor_EventScript_AskForTicket
 * msgbox SlateportCity_Harbor_Text_FerryServiceUnavailable, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_FerryAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_FerryAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SlateportCity_Harbor_EventScript_SailorNoAbnormalWeather
 * setvar VAR_0x8004, 0
 * call_if_set FLAG_DEFEATED_KYOGRE, SlateportCity_Harbor_EventScript_CountDefeatedLegendary
 * call_if_set FLAG_DEFEATED_GROUDON, SlateportCity_Harbor_EventScript_CountDefeatedLegendary
 * goto_if_eq VAR_0x8004, 2, SlateportCity_Harbor_EventScript_SailorNoAbnormalWeather  @ Defeated both
 * msgbox SlateportCity_Harbor_Text_AbnormalWeather, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_Sailor")
}

internal object SlateportCity_Harbor_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SlateportCity_Harbor.SubTooSmallForMe)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_BADGE07_GET, SlateportCity_Harbor_EventScript_CaptSternFerryOrScannerComment
 * goto_if_set FLAG_EVIL_TEAM_ESCAPED_STERN_SPOKE, SlateportCity_Harbor_EventScript_NeedDive
 * goto_if_set FLAG_TEAM_AQUA_ESCAPED_IN_SUBMARINE, SlateportCity_Harbor_EventScript_TeamAquaLeftNeedDive
 * goto_if_eq VAR_SLATEPORT_HARBOR_STATE, 2, SlateportCity_Harbor_EventScript_WhyStealSubmarine
 * msgbox SlateportCity_Harbor_Text_SameThugsTriedToRobAtMuseum, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_CaptStern : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_CaptStern")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_Harbor_Text_MayISeeYourTicket, MSGBOX_DEFAULT
 * message SlateportCity_Harbor_Text_FlashedTicketWhereTo
 * waitmessage
 * goto SlateportCity_Harbor_EventScript_ChooseDestination
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_AskForTicket : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_Harbor.MayISeeYourTicket)
    ctx.say(SlateportCity_Harbor.FlashedTicketWhereTo)
    return SlateportCity_Harbor_EventScript_ChooseDestination.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_Harbor_Text_NeedDiveToCatchSub, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_NeedDive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_Harbor.NeedDiveToCatchSub)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_EVIL_TEAM_ESCAPED_STERN_SPOKE
 * msgbox SlateportCity_Harbor_Text_TeamAquaLeftNeedDive, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_TeamAquaLeftNeedDive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_EVIL_TEAM_ESCAPED_STERN_SPOKE)
    ctx.say(SlateportCity_Harbor.TeamAquaLeftNeedDive)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_0x8004, 1
 * return
 * ```
 */
internal object SlateportCity_Harbor_EventScript_CountDefeatedLegendary : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_CountDefeatedLegendary")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_Harbor_Text_CaptSternWhyStealMySubmarine, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_WhyStealSubmarine : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_Harbor.CaptSternWhyStealMySubmarine)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_TEMP_1, 1, SlateportCity_Harbor_EventScript_TradedScanner
 * checkitem ITEM_SCANNER
 * goto_if_eq VAR_RESULT, TRUE, SlateportCity_Harbor_EventScript_AskToTradeScanner
 * goto_if_set FLAG_SYS_GAME_CLEAR, SlateportCity_Harbor_EventScript_FerryFinished
 * msgbox SlateportCity_Harbor_Text_WontBeLongBeforeWeFinishFerry, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_CaptSternFerryOrScannerComment : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_CaptSternFerryOrScannerComment")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_MET_SCOTT_ON_SS_TIDAL, SlateportCity_Harbor_EventScript_ChooseDestinationWithBattleFrontier
 * multichoicedefault 18, 8, MULTI_SSTIDAL_SLATEPORT_NO_BF, 2, FALSE
 * switch VAR_RESULT
 * case 0, SlateportCity_Harbor_EventScript_Lilycove
 * case 1, SlateportCity_Harbor_EventScript_CancelDestinationSelect
 * case MULTI_B_PRESSED, SlateportCity_Harbor_EventScript_CancelDestinationSelect
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_ChooseDestination : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_ChooseDestination")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_Harbor_Text_LoveToGoDeepUnderwaterSomeday, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_SailorNoAbnormalWeather : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_Harbor.LoveToGoDeepUnderwaterSomeday)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoicedefault 17, 6, MULTI_SSTIDAL_SLATEPORT_WITH_BF, 2, FALSE
 * switch VAR_RESULT
 * case 0, SlateportCity_Harbor_EventScript_Lilycove
 * case 1, SlateportCity_Harbor_EventScript_BattleFrontier
 * case 2, SlateportCity_Harbor_EventScript_CancelDestinationSelect
 * case MULTI_B_PRESSED, SlateportCity_Harbor_EventScript_CancelDestinationSelect
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_ChooseDestinationWithBattleFrontier : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_ChooseDestinationWithBattleFrontier")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_Harbor_Text_FinishedMakingFerry, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_FerryFinished : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_Harbor.FinishedMakingFerry)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message SlateportCity_Harbor_Text_WouldYouTradeScanner
 * waitmessage
 * goto SlateportCity_Harbor_EventScript_ChooseScannerTrade
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_AskToTradeScanner : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_Harbor.WouldYouTradeScanner)
    return SlateportCity_Harbor_EventScript_ChooseScannerTrade.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, 1
 * msgbox SlateportCity_Harbor_Text_ThisWillHelpResearch, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_TradedScanner : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_TradedScanner")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 0, 0, MULTI_STERN_DEEPSEA, FALSE
 * switch VAR_RESULT
 * case 0, SlateportCity_Harbor_EventScript_DeepSeaTooth
 * case 1, SlateportCity_Harbor_EventScript_DeepSeaScale
 * case 2, SlateportCity_Harbor_EventScript_DeclineTrade
 * case MULTI_B_PRESSED, SlateportCity_Harbor_EventScript_DeclineTrade
 * end
 * ```
 */
internal object SlateportCity_Harbor_EventScript_ChooseScannerTrade : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_Harbor_EventScript_ChooseScannerTrade")
}

internal val SlateportCity_HarborScripts: Map<String, Script> =
    mapOf(
        "SlateportCity_Harbor_EventScript_FerryAttendant" to
            SlateportCity_Harbor_EventScript_FerryAttendant,
        "SlateportCity_Harbor_EventScript_Sailor" to SlateportCity_Harbor_EventScript_Sailor,
        "SlateportCity_Harbor_EventScript_FatMan" to SlateportCity_Harbor_EventScript_FatMan,
        "SlateportCity_Harbor_EventScript_CaptStern" to SlateportCity_Harbor_EventScript_CaptStern,
        "SlateportCity_Harbor_EventScript_AskForTicket" to
            SlateportCity_Harbor_EventScript_AskForTicket,
        "SlateportCity_Harbor_EventScript_NeedDive" to SlateportCity_Harbor_EventScript_NeedDive,
        "SlateportCity_Harbor_EventScript_TeamAquaLeftNeedDive" to
            SlateportCity_Harbor_EventScript_TeamAquaLeftNeedDive,
        "SlateportCity_Harbor_EventScript_CountDefeatedLegendary" to
            SlateportCity_Harbor_EventScript_CountDefeatedLegendary,
        "SlateportCity_Harbor_EventScript_WhyStealSubmarine" to
            SlateportCity_Harbor_EventScript_WhyStealSubmarine,
        "SlateportCity_Harbor_EventScript_CaptSternFerryOrScannerComment" to
            SlateportCity_Harbor_EventScript_CaptSternFerryOrScannerComment,
        "SlateportCity_Harbor_EventScript_ChooseDestination" to
            SlateportCity_Harbor_EventScript_ChooseDestination,
        "SlateportCity_Harbor_EventScript_SailorNoAbnormalWeather" to
            SlateportCity_Harbor_EventScript_SailorNoAbnormalWeather,
        "SlateportCity_Harbor_EventScript_ChooseDestinationWithBattleFrontier" to
            SlateportCity_Harbor_EventScript_ChooseDestinationWithBattleFrontier,
        "SlateportCity_Harbor_EventScript_FerryFinished" to
            SlateportCity_Harbor_EventScript_FerryFinished,
        "SlateportCity_Harbor_EventScript_AskToTradeScanner" to
            SlateportCity_Harbor_EventScript_AskToTradeScanner,
        "SlateportCity_Harbor_EventScript_TradedScanner" to
            SlateportCity_Harbor_EventScript_TradedScanner,
        "SlateportCity_Harbor_EventScript_ChooseScannerTrade" to
            SlateportCity_Harbor_EventScript_ChooseScannerTrade,
    )
