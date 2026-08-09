package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MauvilleCity_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_COIN_CASE, MauvilleCity_House2_EventScript_ReceivedCoinCase
 * msgbox MauvilleCity_House2_Text_BuyHarborMailAtSlateport, MSGBOX_DEFAULT
 * checkitem ITEM_HARBOR_MAIL
 * goto_if_eq VAR_RESULT, TRUE, MauvilleCity_House2_EventScript_AskToTradeForHarborMail
 * release
 * end
 * ```
 */
internal object MauvilleCity_House2_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MauvilleCity_House2_EventScript_Woman")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_House2_Text_UseCoinCaseAtGameCorner, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_House2_EventScript_ReceivedCoinCase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_House2.UseCoinCaseAtGameCorner)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_PIN
 * applymovement VAR_LAST_TALKED, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement VAR_LAST_TALKED, Common_Movement_Delay48
 * waitmovement 0
 * msgbox MauvilleCity_House2_Text_TradeHarborMailForCoinCase, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, MauvilleCity_House2_EventScript_AcceptTrade
 * goto_if_eq VAR_RESULT, NO, MauvilleCity_House2_EventScript_DeclineTrade
 * end
 * ```
 */
internal object MauvilleCity_House2_EventScript_AskToTradeForHarborMail : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_House2_EventScript_AskToTradeForHarborMail")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_House2_Text_IllTradeYouCoinCase, MSGBOX_DEFAULT
 * removeitem ITEM_HARBOR_MAIL
 * giveitem ITEM_COIN_CASE
 * setflag FLAG_RECEIVED_COIN_CASE
 * goto MauvilleCity_House2_EventScript_ReceivedCoinCase
 * end
 * ```
 */
internal object MauvilleCity_House2_EventScript_AcceptTrade : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_House2_EventScript_AcceptTrade")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_House2_Text_ThatsDisappointing, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_House2_EventScript_DeclineTrade : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_House2.ThatsDisappointing)
  }
}

internal val MauvilleCity_House2Scripts: Map<String, Script> =
    mapOf(
        "MauvilleCity_House2_EventScript_Woman" to MauvilleCity_House2_EventScript_Woman,
        "MauvilleCity_House2_EventScript_ReceivedCoinCase" to
            MauvilleCity_House2_EventScript_ReceivedCoinCase,
        "MauvilleCity_House2_EventScript_AskToTradeForHarborMail" to
            MauvilleCity_House2_EventScript_AskToTradeForHarborMail,
        "MauvilleCity_House2_EventScript_AcceptTrade" to
            MauvilleCity_House2_EventScript_AcceptTrade,
        "MauvilleCity_House2_EventScript_DeclineTrade" to
            MauvilleCity_House2_EventScript_DeclineTrade,
    )
