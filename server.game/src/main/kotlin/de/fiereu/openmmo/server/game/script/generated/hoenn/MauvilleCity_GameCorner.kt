package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MauvilleCity_GameCorner
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object MauvilleCity_GameCorner_EventScript_Woman2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(MauvilleCity_GameCorner.CoinsAreNeededToPlay)
}

internal object MauvilleCity_GameCorner_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MauvilleCity_GameCorner.RouletteOnlyLuck)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_ThisIsMauvilleGameCorner, MSGBOX_DEFAULT
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NeedCoinCase
 * message MauvilleCity_GameCorner_Text_WereYouLookingForCoins
 * waitmessage
 * showmoneybox 0, 0
 * showcoinsbox 1, 6
 * goto MauvilleCity_GameCorner_EventScript_ChooseCoinsDefault50
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_CoinsClerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_CoinsClerk")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_ExchangeCoinsForPrizes, MSGBOX_DEFAULT
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, TRUE, MauvilleCity_GameCorner_EventScript_ChooseDollPrizeMessage
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_PrizeCornerDolls : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_PrizeCornerDolls")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_STARTER_DOLL, MauvilleCity_GameCorner_EventScript_ReceivedStarterDoll
 * msgbox MauvilleCity_GameCorner_Text_GotTwoOfSameDollWantOne, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MauvilleCity_GameCorner_EventScript_DeclineStarterDoll
 * switch VAR_STARTER_MON
 * case 0, MauvilleCity_GameCorner_EventScript_GiveTreeckoDoll
 * case 1, MauvilleCity_GameCorner_EventScript_GiveTorchicDoll
 * case 2, MauvilleCity_GameCorner_EventScript_GiveMudkipDoll
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_Girl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, TRUE, MauvilleCity_GameCorner_EventScript_TryGive20Coins
 * msgbox MauvilleCity_GameCorner_Text_NeedCoinCaseGoNextDoor, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_PokefanM : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_PokefanM")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_RouletteTablesDifferentRates, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.RouletteTablesDifferentRates)
    return MauvilleCity_GameCorner_EventScript_NPCReturnToSlots.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_EasyToLoseTrackOfTime, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_Cook : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.EasyToLoseTrackOfTime)
    return MauvilleCity_GameCorner_EventScript_NPCReturnToSlots.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_ExchangeCoinsForPrizes, MSGBOX_DEFAULT
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, TRUE, MauvilleCity_GameCorner_EventScript_ChooseTMPrizeMessage
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_PrizeCornerTMs : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_PrizeCornerTMs")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_UpTo3CoinsCanBeUsed, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.UpTo3CoinsCanBeUsed)
    return MauvilleCity_GameCorner_EventScript_NPCReturnToSlots.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_DifficultToStopOn7, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_Maniac : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.DifficultToStopOn7)
    return MauvilleCity_GameCorner_EventScript_NPCReturnToSlots.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox MauvilleCity_GameCorner_Text_HeresSomeSlotsInfo, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.HeresSomeSlotsInfo)
    return MauvilleCity_GameCorner_EventScript_NPCReturnToSlots.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 0
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine0 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine0")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 1
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 2
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 3
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 4
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 5
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 6
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine6 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 7
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine7 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine7")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 8
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine8 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine8")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 9
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine9 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine9")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 10
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine10 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine10")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 11
 * specialvar VAR_RESULT, GetSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_SlotMachine11 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_SlotMachine11")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 0
 * getpokenewsactive POKENEWS_GAME_CORNER
 * goto_if_eq VAR_RESULT, FALSE, Roulette_EventScript_Play
 * addvar VAR_0x8004, ROULETTE_SPECIAL_RATE
 * goto Roulette_EventScript_Play
 * end
 * ```
 */
internal object Roulette_EventScript_Table1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Roulette_EventScript_Table1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_COIN_CASE
 * goto_if_eq VAR_RESULT, FALSE, MauvilleCity_GameCorner_EventScript_NoCoinCase
 * setvar VAR_0x8004, 1
 * getpokenewsactive POKENEWS_GAME_CORNER
 * goto_if_eq VAR_RESULT, FALSE, Roulette_EventScript_Play
 * addvar VAR_0x8004, ROULETTE_SPECIAL_RATE
 * goto Roulette_EventScript_Play
 * end
 * ```
 */
internal object Roulette_EventScript_Table2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Roulette_EventScript_Table2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_NPCReturnToSlots : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_NPCReturnToSlots")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_CantWinJackpot, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_ReceivedStarterDoll : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.CantWinJackpot)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_RECEIVED_20_COINS, MauvilleCity_GameCorner_EventScript_PokefanMNormal
 * checkcoins VAR_TEMP_1
 * goto_if_ge VAR_TEMP_1, 1, MauvilleCity_GameCorner_EventScript_PokefanMNormal @ Only give 20 coins if player has no coins
 * setflag FLAG_RECEIVED_20_COINS
 * addcoins 20
 * msgbox MauvilleCity_GameCorner_Text_LuckOnlyLastSoLongTakeCoins, MSGBOX_DEFAULT
 * playse SE_SHOP
 * goto MauvilleCity_GameCorner_EventScript_PokefanMNormal
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_TryGive20Coins : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_TryGive20Coins")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_CantPlayWithNoCoinCase, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_NoCoinCase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.CantPlayWithNoCoinCase)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_NeedCoinCaseForCoins, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_NeedCoinCase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.NeedCoinCaseForCoins)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message MauvilleCity_GameCorner_Text_WhichPrize
 * waitmessage
 * setvar VAR_TEMP_1, 0
 * showcoinsbox 1, 1
 * goto MauvilleCity_GameCorner_EventScript_ChooseDollPrize
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_ChooseDollPrizeMessage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_ChooseDollPrizeMessage")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special PlayRoulette
 * end
 * ```
 */
internal object Roulette_EventScript_Play : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Roulette_EventScript_Play")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_DontBeNegative, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_DeclineStarterDoll : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.DontBeNegative)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoicedefault 15, 0, MULTI_GAME_CORNER_COINS, 0, FALSE
 * switch VAR_RESULT
 * case 0, MauvilleCity_GameCorner_EventScript_Buy50Coins
 * case 1, MauvilleCity_GameCorner_EventScript_Buy500Coins
 * goto MauvilleCity_GameCorner_EventScript_CancelBuyCoins
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_ChooseCoinsDefault50 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_ChooseCoinsDefault50")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message MauvilleCity_GameCorner_Text_WhichPrize
 * waitmessage
 * setvar VAR_TEMP_1, 0
 * showcoinsbox 1, 1
 * goto MauvilleCity_GameCorner_EventScript_ChooseTMPrize
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_ChooseTMPrizeMessage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_ChooseTMPrizeMessage")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_DontNeedCoinsThen, MSGBOX_DEFAULT
 * hidemoneybox
 * hidecoinsbox 0, 5
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_CancelBuyCoins : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_CancelBuyCoins")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_MauvilleSomethingForEveryone, MSGBOX_DEFAULT
 * goto MauvilleCity_GameCorner_EventScript_NPCReturnToSlots
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_PokefanMNormal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_GameCorner.MauvilleSomethingForEveryone)
    return MauvilleCity_GameCorner_EventScript_NPCReturnToSlots.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 12, 0, MULTI_GAME_CORNER_TMS, FALSE
 * switch VAR_RESULT
 * case 0, MauvilleCity_GameCorner_EventScript_TMDoubleTeam
 * case 1, MauvilleCity_GameCorner_EventScript_TMPsychic
 * case 2, MauvilleCity_GameCorner_EventScript_TMFlamethrower
 * case 3, MauvilleCity_GameCorner_EventScript_TMThunderbolt
 * case 4, MauvilleCity_GameCorner_EventScript_TMIceBeam
 * case 5, MauvilleCity_GameCorner_EventScript_CancelTMSelect
 * goto MauvilleCity_GameCorner_EventScript_CancelTMSelect
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_ChooseTMPrize : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_ChooseTMPrize")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 12, 0, MULTI_GAME_CORNER_DOLLS, FALSE
 * switch VAR_RESULT
 * case 0, MauvilleCity_GameCorner_EventScript_TreeckoDoll
 * case 1, MauvilleCity_GameCorner_EventScript_TorchicDoll
 * case 2, MauvilleCity_GameCorner_EventScript_MudkipDoll
 * case 3, MauvilleCity_GameCorner_EventScript_CancelDollSelect
 * goto MauvilleCity_GameCorner_EventScript_CancelDollSelect
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_ChooseDollPrize : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_ChooseDollPrize")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_OhIsThatSo, MSGBOX_DEFAULT
 * hidecoinsbox 0, 0
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_CancelDollSelect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_CancelDollSelect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_GameCorner_Text_OhIsThatSo, MSGBOX_DEFAULT
 * hidecoinsbox 0, 0
 * release
 * end
 * ```
 */
internal object MauvilleCity_GameCorner_EventScript_CancelTMSelect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_GameCorner_EventScript_CancelTMSelect")
}

internal val MauvilleCity_GameCornerScripts: Map<String, Script> =
    mapOf(
        "MauvilleCity_GameCorner_EventScript_Woman2" to MauvilleCity_GameCorner_EventScript_Woman2,
        "MauvilleCity_GameCorner_EventScript_Gentleman" to
            MauvilleCity_GameCorner_EventScript_Gentleman,
        "MauvilleCity_GameCorner_EventScript_CoinsClerk" to
            MauvilleCity_GameCorner_EventScript_CoinsClerk,
        "MauvilleCity_GameCorner_EventScript_PrizeCornerDolls" to
            MauvilleCity_GameCorner_EventScript_PrizeCornerDolls,
        "MauvilleCity_GameCorner_EventScript_Girl" to MauvilleCity_GameCorner_EventScript_Girl,
        "MauvilleCity_GameCorner_EventScript_PokefanM" to
            MauvilleCity_GameCorner_EventScript_PokefanM,
        "MauvilleCity_GameCorner_EventScript_OldMan" to MauvilleCity_GameCorner_EventScript_OldMan,
        "MauvilleCity_GameCorner_EventScript_Cook" to MauvilleCity_GameCorner_EventScript_Cook,
        "MauvilleCity_GameCorner_EventScript_PrizeCornerTMs" to
            MauvilleCity_GameCorner_EventScript_PrizeCornerTMs,
        "MauvilleCity_GameCorner_EventScript_Man" to MauvilleCity_GameCorner_EventScript_Man,
        "MauvilleCity_GameCorner_EventScript_Maniac" to MauvilleCity_GameCorner_EventScript_Maniac,
        "MauvilleCity_GameCorner_EventScript_Woman" to MauvilleCity_GameCorner_EventScript_Woman,
        "MauvilleCity_GameCorner_EventScript_SlotMachine0" to
            MauvilleCity_GameCorner_EventScript_SlotMachine0,
        "MauvilleCity_GameCorner_EventScript_SlotMachine1" to
            MauvilleCity_GameCorner_EventScript_SlotMachine1,
        "MauvilleCity_GameCorner_EventScript_SlotMachine2" to
            MauvilleCity_GameCorner_EventScript_SlotMachine2,
        "MauvilleCity_GameCorner_EventScript_SlotMachine3" to
            MauvilleCity_GameCorner_EventScript_SlotMachine3,
        "MauvilleCity_GameCorner_EventScript_SlotMachine4" to
            MauvilleCity_GameCorner_EventScript_SlotMachine4,
        "MauvilleCity_GameCorner_EventScript_SlotMachine5" to
            MauvilleCity_GameCorner_EventScript_SlotMachine5,
        "MauvilleCity_GameCorner_EventScript_SlotMachine6" to
            MauvilleCity_GameCorner_EventScript_SlotMachine6,
        "MauvilleCity_GameCorner_EventScript_SlotMachine7" to
            MauvilleCity_GameCorner_EventScript_SlotMachine7,
        "MauvilleCity_GameCorner_EventScript_SlotMachine8" to
            MauvilleCity_GameCorner_EventScript_SlotMachine8,
        "MauvilleCity_GameCorner_EventScript_SlotMachine9" to
            MauvilleCity_GameCorner_EventScript_SlotMachine9,
        "MauvilleCity_GameCorner_EventScript_SlotMachine10" to
            MauvilleCity_GameCorner_EventScript_SlotMachine10,
        "MauvilleCity_GameCorner_EventScript_SlotMachine11" to
            MauvilleCity_GameCorner_EventScript_SlotMachine11,
        "Roulette_EventScript_Table1" to Roulette_EventScript_Table1,
        "Roulette_EventScript_Table2" to Roulette_EventScript_Table2,
        "MauvilleCity_GameCorner_EventScript_NPCReturnToSlots" to
            MauvilleCity_GameCorner_EventScript_NPCReturnToSlots,
        "MauvilleCity_GameCorner_EventScript_ReceivedStarterDoll" to
            MauvilleCity_GameCorner_EventScript_ReceivedStarterDoll,
        "MauvilleCity_GameCorner_EventScript_TryGive20Coins" to
            MauvilleCity_GameCorner_EventScript_TryGive20Coins,
        "MauvilleCity_GameCorner_EventScript_NoCoinCase" to
            MauvilleCity_GameCorner_EventScript_NoCoinCase,
        "MauvilleCity_GameCorner_EventScript_NeedCoinCase" to
            MauvilleCity_GameCorner_EventScript_NeedCoinCase,
        "MauvilleCity_GameCorner_EventScript_ChooseDollPrizeMessage" to
            MauvilleCity_GameCorner_EventScript_ChooseDollPrizeMessage,
        "Roulette_EventScript_Play" to Roulette_EventScript_Play,
        "MauvilleCity_GameCorner_EventScript_DeclineStarterDoll" to
            MauvilleCity_GameCorner_EventScript_DeclineStarterDoll,
        "MauvilleCity_GameCorner_EventScript_ChooseCoinsDefault50" to
            MauvilleCity_GameCorner_EventScript_ChooseCoinsDefault50,
        "MauvilleCity_GameCorner_EventScript_ChooseTMPrizeMessage" to
            MauvilleCity_GameCorner_EventScript_ChooseTMPrizeMessage,
        "MauvilleCity_GameCorner_EventScript_CancelBuyCoins" to
            MauvilleCity_GameCorner_EventScript_CancelBuyCoins,
        "MauvilleCity_GameCorner_EventScript_PokefanMNormal" to
            MauvilleCity_GameCorner_EventScript_PokefanMNormal,
        "MauvilleCity_GameCorner_EventScript_ChooseTMPrize" to
            MauvilleCity_GameCorner_EventScript_ChooseTMPrize,
        "MauvilleCity_GameCorner_EventScript_ChooseDollPrize" to
            MauvilleCity_GameCorner_EventScript_ChooseDollPrize,
        "MauvilleCity_GameCorner_EventScript_CancelDollSelect" to
            MauvilleCity_GameCorner_EventScript_CancelDollSelect,
        "MauvilleCity_GameCorner_EventScript_CancelTMSelect" to
            MauvilleCity_GameCorner_EventScript_CancelTMSelect,
    )
