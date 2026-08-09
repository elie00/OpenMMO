package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.LilycoveCity_DepartmentStore_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object LilycoveCity_DepartmentStore_1F_EventScript_Greeter : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_DepartmentStore_1F.WelcomeToDeptStore)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * goto_if_ne VAR_POKELOT_PRIZE_ITEM, ITEM_NONE, LilycoveCity_DepartmentStore_1F_EventScript_GivePrizeFromEarlier
 * goto_if_set FLAG_DAILY_PICKED_LOTO_TICKET, LilycoveCity_DepartmentStore_1F_EventScript_ComeBackTomorrow
 * msgbox LilycoveCity_DepartmentStore_1F_Text_LotteryCornerDrawTicket, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain
 * setflag FLAG_DAILY_PICKED_LOTO_TICKET
 * message LilycoveCity_DepartmentStore_1F_Text_PleasePickTicket
 * waitmessage
 * special RetrieveLotteryNumber
 * copyvar VAR_0x8008, VAR_RESULT
 * special BufferLottoTicketNumber
 * msgbox LilycoveCity_DepartmentStore_1F_Text_TicketNumberIsXPleaseWait, MSGBOX_DEFAULT
 * applymovement LOCALID_LOTTERY_CLERK, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * playse SE_PC_ON
 * special DoLotteryCornerComputerEffect
 * special PickLotteryCornerTicket
 * delay 220
 * special EndLotteryCornerComputerEffect
 * delay 10
 * applymovement LOCALID_LOTTERY_CLERK, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_eq VAR_0x8004, 0, LilycoveCity_DepartmentStore_1F_EventScript_NoMatch
 * incrementgamestat GAME_STAT_WON_POKEMON_LOTTERY
 * call_if_eq VAR_0x8006, 0, LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPartyMon
 * call_if_eq VAR_0x8006, 1, LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPCMon
 * bufferitemname STR_VAR_1, VAR_0x8005
 * call_if_eq VAR_0x8004, 1, LilycoveCity_DepartmentStore_1F_EventScript_TwoDigitMatch
 * call_if_eq VAR_0x8004, 2, LilycoveCity_DepartmentStore_1F_EventScript_ThreeDigitMatch
 * call_if_eq VAR_0x8004, 3, LilycoveCity_DepartmentStore_1F_EventScript_FourDigitMatch
 * call_if_eq VAR_0x8004, 4, LilycoveCity_DepartmentStore_1F_EventScript_FullMatch
 * giveitem VAR_0x8005
 * goto_if_eq VAR_RESULT, FALSE, LilycoveCity_DepartmentStore_1F_EventScript_RecordPrizeNoRoom
 * special TryPutLotteryWinnerReportOnAir
 * goto LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain2
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_LotteryClerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_DepartmentStore_1F_EventScript_LotteryClerk")
}

internal object LilycoveCity_DepartmentStore_1F_EventScript_PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_DepartmentStore_1F.IBuyAllSortsOfThings)
}

internal object LilycoveCity_DepartmentStore_1F_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_DepartmentStore_1F.MomBuyingMeFurniture)
}

internal object LilycoveCity_DepartmentStore_1F_EventScript_PokefanM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_DepartmentStore_1F.BuyingSomethingForAzumarill)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_AZUMARILL, CRY_MODE_NORMAL
 * msgbox LilycoveCity_DepartmentStore_1F_Text_Azumarill, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_Azumarill : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_DepartmentStore_1F_EventScript_Azumarill")
}

internal object LilycoveCity_DepartmentStore_1F_EventScript_FloorNamesSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LilycoveCity_DepartmentStore_1F.FloorNamesSign)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_PleaseVisitAgain2, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.PleaseVisitAgain2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_ComeBackTomorrow, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_ComeBackTomorrow : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.ComeBackTomorrow)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_PleaseVisitAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.PleaseVisitAgain)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_ThreeDigitsMatched, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_ThreeDigitMatch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.ThreeDigitsMatched)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_TicketMatchesPCMon, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPCMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.TicketMatchesPCMon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_PrizeWeveBeenHolding, MSGBOX_DEFAULT
 * giveitem VAR_POKELOT_PRIZE_ITEM
 * goto_if_eq VAR_RESULT, FALSE, LilycoveCity_DepartmentStore_1F_EventScript_NoRoomForPrize
 * copyvar VAR_0x8004, VAR_POKELOT_PRIZE_PLACE
 * copyvar VAR_0x8005, VAR_POKELOT_PRIZE_ITEM
 * special TryPutLotteryWinnerReportOnAir
 * setvar VAR_POKELOT_PRIZE_ITEM, ITEM_NONE
 * setvar VAR_POKELOT_PRIZE_PLACE, 0
 * release
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_GivePrizeFromEarlier : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_DepartmentStore_1F_EventScript_GivePrizeFromEarlier")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_TwoDigitsMatched, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_TwoDigitMatch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.TwoDigitsMatched)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_AllFiveDigitsMatched, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_FullMatch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.AllFiveDigitsMatched)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_NoNumbersMatched, MSGBOX_DEFAULT
 * goto LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain2
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_NoMatch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.NoNumbersMatched)
    return LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain2.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_TicketMatchesPartyMon, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPartyMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.TicketMatchesPartyMon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_FourDigitsMatched, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_FourDigitMatch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.FourDigitsMatched)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_POKELOT_PRIZE_PLACE, VAR_0x8004
 * copyvar VAR_POKELOT_PRIZE_ITEM, VAR_0x8005
 * goto LilycoveCity_DepartmentStore_1F_EventScript_NoRoomForPrize
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_RecordPrizeNoRoom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_DepartmentStore_1F_EventScript_RecordPrizeNoRoom")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_DepartmentStore_1F_Text_NoRoomForThis, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_DepartmentStore_1F_EventScript_NoRoomForPrize : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_DepartmentStore_1F.NoRoomForThis)
  }
}

internal val LilycoveCity_DepartmentStore_1FScripts: Map<String, Script> =
    mapOf(
        "LilycoveCity_DepartmentStore_1F_EventScript_Greeter" to
            LilycoveCity_DepartmentStore_1F_EventScript_Greeter,
        "LilycoveCity_DepartmentStore_1F_EventScript_LotteryClerk" to
            LilycoveCity_DepartmentStore_1F_EventScript_LotteryClerk,
        "LilycoveCity_DepartmentStore_1F_EventScript_PokefanF" to
            LilycoveCity_DepartmentStore_1F_EventScript_PokefanF,
        "LilycoveCity_DepartmentStore_1F_EventScript_LittleGirl" to
            LilycoveCity_DepartmentStore_1F_EventScript_LittleGirl,
        "LilycoveCity_DepartmentStore_1F_EventScript_PokefanM" to
            LilycoveCity_DepartmentStore_1F_EventScript_PokefanM,
        "LilycoveCity_DepartmentStore_1F_EventScript_Azumarill" to
            LilycoveCity_DepartmentStore_1F_EventScript_Azumarill,
        "LilycoveCity_DepartmentStore_1F_EventScript_FloorNamesSign" to
            LilycoveCity_DepartmentStore_1F_EventScript_FloorNamesSign,
        "LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain2" to
            LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain2,
        "LilycoveCity_DepartmentStore_1F_EventScript_ComeBackTomorrow" to
            LilycoveCity_DepartmentStore_1F_EventScript_ComeBackTomorrow,
        "LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain" to
            LilycoveCity_DepartmentStore_1F_EventScript_PleaseVisitAgain,
        "LilycoveCity_DepartmentStore_1F_EventScript_ThreeDigitMatch" to
            LilycoveCity_DepartmentStore_1F_EventScript_ThreeDigitMatch,
        "LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPCMon" to
            LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPCMon,
        "LilycoveCity_DepartmentStore_1F_EventScript_GivePrizeFromEarlier" to
            LilycoveCity_DepartmentStore_1F_EventScript_GivePrizeFromEarlier,
        "LilycoveCity_DepartmentStore_1F_EventScript_TwoDigitMatch" to
            LilycoveCity_DepartmentStore_1F_EventScript_TwoDigitMatch,
        "LilycoveCity_DepartmentStore_1F_EventScript_FullMatch" to
            LilycoveCity_DepartmentStore_1F_EventScript_FullMatch,
        "LilycoveCity_DepartmentStore_1F_EventScript_NoMatch" to
            LilycoveCity_DepartmentStore_1F_EventScript_NoMatch,
        "LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPartyMon" to
            LilycoveCity_DepartmentStore_1F_EventScript_TicketMatchPartyMon,
        "LilycoveCity_DepartmentStore_1F_EventScript_FourDigitMatch" to
            LilycoveCity_DepartmentStore_1F_EventScript_FourDigitMatch,
        "LilycoveCity_DepartmentStore_1F_EventScript_RecordPrizeNoRoom" to
            LilycoveCity_DepartmentStore_1F_EventScript_RecordPrizeNoRoom,
        "LilycoveCity_DepartmentStore_1F_EventScript_NoRoomForPrize" to
            LilycoveCity_DepartmentStore_1F_EventScript_NoRoomForPrize,
    )
