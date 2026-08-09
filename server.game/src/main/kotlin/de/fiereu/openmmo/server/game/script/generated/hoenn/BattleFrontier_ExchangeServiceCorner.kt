package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_ExchangeServiceCorner
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, EXCHANGE_CORNER_DECOR1_CLERK
 * call BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome
 * goto BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor1
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk1")
}

internal object BattleFrontier_ExchangeServiceCorner_EventScript_RichBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_ExchangeServiceCorner.WishIHadAllDolls)
}

internal object BattleFrontier_ExchangeServiceCorner_EventScript_PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_ExchangeServiceCorner.GetYouAnythingYouWant)
}

internal object BattleFrontier_ExchangeServiceCorner_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_ExchangeServiceCorner.ItemsWillGetMonTougher)
}

internal object BattleFrontier_ExchangeServiceCorner_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_ExchangeServiceCorner.GoGetYourOwnDoll)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, EXCHANGE_CORNER_DECOR2_CLERK
 * call BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome
 * goto BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor2
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, EXCHANGE_CORNER_VITAMIN_CLERK
 * call BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome
 * goto BattleFrontier_ExchangeServiceCorner_EventScript_ChooseVitamin
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_VitaminClerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_VitaminClerk")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, EXCHANGE_CORNER_HOLD_ITEM_CLERK
 * call BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome
 * goto BattleFrontier_ExchangeServiceCorner_EventScript_ChooseHoldItem
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_HoldItemClerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_HoldItemClerk")
}

internal object BattleFrontier_ExchangeServiceCorner_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_ExchangeServiceCorner.MoreBattlePointsForRecord)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SCROLL_MULTI_BF_EXCHANGE_CORNER_DECOR_VENDOR_2
 * special ShowFrontierExchangeCornerItemIconWindow
 * special ShowScrollableMultichoice
 * special CloseFrontierExchangeCornerItemIconWindow
 * switch VAR_RESULT
 * case 0, BattleFrontier_ExchangeServiceCorner_EventScript_LaprasDoll
 * case 1, BattleFrontier_ExchangeServiceCorner_EventScript_SnorlaxDoll
 * case 2, BattleFrontier_ExchangeServiceCorner_EventScript_VenusaurDoll
 * case 3, BattleFrontier_ExchangeServiceCorner_EventScript_CharizardDoll
 * case 4, BattleFrontier_ExchangeServiceCorner_EventScript_BlastoiseDoll
 * case 5, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * case MULTI_B_PRESSED, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SCROLL_MULTI_BF_EXCHANGE_CORNER_HOLD_ITEM_VENDOR
 * special ShowFrontierExchangeCornerItemIconWindow
 * special ShowScrollableMultichoice
 * special CloseFrontierExchangeCornerItemIconWindow
 * switch VAR_RESULT
 * case 0, BattleFrontier_ExchangeServiceCorner_EventScript_Leftovers
 * case 1, BattleFrontier_ExchangeServiceCorner_EventScript_WhiteHerb
 * case 2, BattleFrontier_ExchangeServiceCorner_EventScript_QuickClaw
 * case 3, BattleFrontier_ExchangeServiceCorner_EventScript_MentalHerb
 * case 4, BattleFrontier_ExchangeServiceCorner_EventScript_Brightpowder
 * case 5, BattleFrontier_ExchangeServiceCorner_EventScript_ChoiceBand
 * case 6, BattleFrontier_ExchangeServiceCorner_EventScript_KingsRock
 * case 7, BattleFrontier_ExchangeServiceCorner_EventScript_FocusBand
 * case 8, BattleFrontier_ExchangeServiceCorner_EventScript_ScopeLens
 * case 9, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * case MULTI_B_PRESSED, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_ChooseHoldItem : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_ChooseHoldItem")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SCROLL_MULTI_BF_EXCHANGE_CORNER_DECOR_VENDOR_1
 * special ShowFrontierExchangeCornerItemIconWindow
 * special ShowScrollableMultichoice
 * special CloseFrontierExchangeCornerItemIconWindow
 * switch VAR_RESULT
 * case 0, BattleFrontier_ExchangeServiceCorner_EventScript_KissPoster
 * case 1, BattleFrontier_ExchangeServiceCorner_EventScript_KissCushion
 * case 2, BattleFrontier_ExchangeServiceCorner_EventScript_SmoochumDoll
 * case 3, BattleFrontier_ExchangeServiceCorner_EventScript_TogepiDoll
 * case 4, BattleFrontier_ExchangeServiceCorner_EventScript_MeowthDoll
 * case 5, BattleFrontier_ExchangeServiceCorner_EventScript_ClefairyDoll
 * case 6, BattleFrontier_ExchangeServiceCorner_EventScript_DittoDoll
 * case 7, BattleFrontier_ExchangeServiceCorner_EventScript_CyndaquilDoll
 * case 8, BattleFrontier_ExchangeServiceCorner_EventScript_ChikoritaDoll
 * case 9, BattleFrontier_ExchangeServiceCorner_EventScript_TotodileDoll
 * case 10, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * case MULTI_B_PRESSED, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SCROLL_MULTI_BF_EXCHANGE_CORNER_VITAMIN_VENDOR
 * special ShowFrontierExchangeCornerItemIconWindow
 * special ShowScrollableMultichoice
 * special CloseFrontierExchangeCornerItemIconWindow
 * switch VAR_RESULT
 * case 0, BattleFrontier_ExchangeServiceCorner_EventScript_Protein
 * case 1, BattleFrontier_ExchangeServiceCorner_EventScript_Calcium
 * case 2, BattleFrontier_ExchangeServiceCorner_EventScript_Iron
 * case 3, BattleFrontier_ExchangeServiceCorner_EventScript_Zinc
 * case 4, BattleFrontier_ExchangeServiceCorner_EventScript_Carbos
 * case 5, BattleFrontier_ExchangeServiceCorner_EventScript_HPUp
 * case 6, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * case MULTI_B_PRESSED, BattleFrontier_ExchangeServiceCorner_EventScript_ClerkGoodbye
 * end
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_ChooseVitamin : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_ChooseVitamin")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_ExchangeServiceCorner_Text_WelcomePleaseChoosePrize, MSGBOX_DEFAULT
 * special ShowBattlePointsWindow
 * return
 * ```
 */
internal object BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome")
}

internal val BattleFrontier_ExchangeServiceCornerScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk1" to
            BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk1,
        "BattleFrontier_ExchangeServiceCorner_EventScript_RichBoy" to
            BattleFrontier_ExchangeServiceCorner_EventScript_RichBoy,
        "BattleFrontier_ExchangeServiceCorner_EventScript_PokefanF" to
            BattleFrontier_ExchangeServiceCorner_EventScript_PokefanF,
        "BattleFrontier_ExchangeServiceCorner_EventScript_Sailor" to
            BattleFrontier_ExchangeServiceCorner_EventScript_Sailor,
        "BattleFrontier_ExchangeServiceCorner_EventScript_Man" to
            BattleFrontier_ExchangeServiceCorner_EventScript_Man,
        "BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk2" to
            BattleFrontier_ExchangeServiceCorner_EventScript_DecorClerk2,
        "BattleFrontier_ExchangeServiceCorner_EventScript_VitaminClerk" to
            BattleFrontier_ExchangeServiceCorner_EventScript_VitaminClerk,
        "BattleFrontier_ExchangeServiceCorner_EventScript_HoldItemClerk" to
            BattleFrontier_ExchangeServiceCorner_EventScript_HoldItemClerk,
        "BattleFrontier_ExchangeServiceCorner_EventScript_Girl" to
            BattleFrontier_ExchangeServiceCorner_EventScript_Girl,
        "BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor2" to
            BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor2,
        "BattleFrontier_ExchangeServiceCorner_EventScript_ChooseHoldItem" to
            BattleFrontier_ExchangeServiceCorner_EventScript_ChooseHoldItem,
        "BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor1" to
            BattleFrontier_ExchangeServiceCorner_EventScript_ChooseDecor1,
        "BattleFrontier_ExchangeServiceCorner_EventScript_ChooseVitamin" to
            BattleFrontier_ExchangeServiceCorner_EventScript_ChooseVitamin,
        "BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome" to
            BattleFrontier_ExchangeServiceCorner_EventScript_ClerkWelcome,
    )
