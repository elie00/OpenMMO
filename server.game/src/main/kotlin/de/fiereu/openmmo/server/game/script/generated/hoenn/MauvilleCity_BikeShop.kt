package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MauvilleCity_BikeShop
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_BIKE, MauvilleCity_BikeShop_EventScript_AskSwitchBikes
 * goto_if_set FLAG_DECLINED_BIKE, MauvilleCity_BikeShop_EventScript_SkipGreeting
 * msgbox MauvilleCity_BikeShop_Text_RydelGreeting, MSGBOX_DEFAULT
 * msgbox MauvilleCity_BikeShop_Text_DidYouComeFromFarAway, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, MauvilleCity_BikeShop_EventScript_YesFar
 * goto_if_eq VAR_RESULT, NO, MauvilleCity_BikeShop_EventScript_NotFar
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_Rydel : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_Rydel")
}

internal object MauvilleCity_BikeShop_EventScript_Assistant : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MauvilleCity_BikeShop.HandbooksAreInBack)
}

/**
 * Ported from the decomp:
 * ```
 * message MauvilleCity_BikeShop_Text_MachHandbookWhichPage
 * waitmessage
 * goto MauvilleCity_BikeShop_EventScript_ChooseMachHandbookPage
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_MachBikeHandbook : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_BikeShop.MachHandbookWhichPage)
    return MauvilleCity_BikeShop_EventScript_ChooseMachHandbookPage.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message MauvilleCity_BikeShop_Text_AcroHandbookWhichPage
 * waitmessage
 * goto MauvilleCity_BikeShop_EventScript_ChooseAcroHandbookPage
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_AcroBikeHandbook : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_BikeShop.AcroHandbookWhichPage)
    return MauvilleCity_BikeShop_EventScript_ChooseAcroHandbookPage.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DECLINED_BIKE
 * msgbox MauvilleCity_BikeShop_Text_GuessYouDontNeedBike, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_NotFar : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_DECLINED_BIKE)
    ctx.say(MauvilleCity_BikeShop.GuessYouDontNeedBike)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 0, 0, MULTI_ACRO_BIKE_INFO, FALSE
 * switch VAR_RESULT
 * case 0, MauvilleCity_BikeShop_EventScript_Wheelies
 * case 1, MauvilleCity_BikeShop_EventScript_BunnyHops
 * case 2, MauvilleCity_BikeShop_EventScript_Jumps
 * case 3, MauvilleCity_BikeShop_EventScript_ExitAcroHandbook
 * case MULTI_B_PRESSED, MauvilleCity_BikeShop_EventScript_ExitAcroHandbook
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_ChooseAcroHandbookPage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_ChooseAcroHandbookPage")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_RECEIVED_BIKE
 * goto MauvilleCity_BikeShop_EventScript_ChooseBike
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_YesFar : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_RECEIVED_BIKE)
    return MauvilleCity_BikeShop_EventScript_ChooseBike.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_BikeShop_Text_WantToSwitchBikes, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, MauvilleCity_BikeShop_EventScript_SwitchBikes
 * goto_if_eq VAR_RESULT, NO, MauvilleCity_BikeShop_EventScript_KeepBike
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_AskSwitchBikes : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_AskSwitchBikes")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_BikeShop_Text_DidYouComeFromFarAway, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, MauvilleCity_BikeShop_EventScript_YesFar
 * goto_if_eq VAR_RESULT, NO, MauvilleCity_BikeShop_EventScript_NotFar
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_SkipGreeting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_SkipGreeting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 0, 0, MULTI_MACH_BIKE_INFO, FALSE
 * switch VAR_RESULT
 * case 0, MauvilleCity_BikeShop_EventScript_HowToRide
 * case 1, MauvilleCity_BikeShop_EventScript_HowToTurn
 * case 2, MauvilleCity_BikeShop_EventScript_SandySlopes
 * case 3, MauvilleCity_BikeShop_EventScript_ExitMachHandbook
 * case MULTI_B_PRESSED, MauvilleCity_BikeShop_EventScript_ExitMachHandbook
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_ChooseMachHandbookPage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_ChooseMachHandbookPage")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message MauvilleCity_BikeShop_Text_ExplainBikesChooseWhichOne
 * waitmessage
 * multichoice 21, 8, MULTI_BIKE, TRUE
 * switch VAR_RESULT
 * case 0, MauvilleCity_BikeShop_EventScript_GetMachBike
 * case 1, MauvilleCity_BikeShop_EventScript_GetAcroBike
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_ChooseBike : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_ChooseBike")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MauvilleCity_BikeShop_Text_HappyYouLikeIt, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_KeepBike : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MauvilleCity_BikeShop.HappyYouLikeIt)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_BikeShop_Text_IllSwitchBikes, MSGBOX_DEFAULT
 * checkitem ITEM_ACRO_BIKE
 * goto_if_eq VAR_RESULT, TRUE, MauvilleCity_BikeShop_EventScript_SwitchAcroForMach
 * checkitem ITEM_MACH_BIKE
 * goto_if_eq VAR_RESULT, TRUE, MauvilleCity_BikeShop_EventScript_SwitchMachForAcro
 * msgbox MauvilleCity_BikeShop_Text_OhYourBikeIsInPC, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_SwitchBikes : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_SwitchBikes")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * incrementgamestat GAME_STAT_TRADED_BIKES
 * msgbox MauvilleCity_BikeShop_Text_ExchangedAcroForMach, MSGBOX_DEFAULT
 * removeitem ITEM_ACRO_BIKE
 * giveitem ITEM_MACH_BIKE
 * goto MauvilleCity_BikeShop_EventScript_ComeBackToSwitchBikes
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_SwitchAcroForMach : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_SwitchAcroForMach")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * incrementgamestat GAME_STAT_TRADED_BIKES
 * msgbox MauvilleCity_BikeShop_Text_ExchangedMachForAcro, MSGBOX_DEFAULT
 * removeitem ITEM_MACH_BIKE
 * giveitem ITEM_ACRO_BIKE
 * goto MauvilleCity_BikeShop_EventScript_ComeBackToSwitchBikes
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_SwitchMachForAcro : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_SwitchMachForAcro")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MauvilleCity_BikeShop_Text_ComeBackToSwitchBikes, MSGBOX_DEFAULT
 * special SwapRegisteredBike
 * release
 * end
 * ```
 */
internal object MauvilleCity_BikeShop_EventScript_ComeBackToSwitchBikes : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MauvilleCity_BikeShop_EventScript_ComeBackToSwitchBikes")
}

internal val MauvilleCity_BikeShopScripts: Map<String, Script> =
    mapOf(
        "MauvilleCity_BikeShop_EventScript_Rydel" to MauvilleCity_BikeShop_EventScript_Rydel,
        "MauvilleCity_BikeShop_EventScript_Assistant" to
            MauvilleCity_BikeShop_EventScript_Assistant,
        "MauvilleCity_BikeShop_EventScript_MachBikeHandbook" to
            MauvilleCity_BikeShop_EventScript_MachBikeHandbook,
        "MauvilleCity_BikeShop_EventScript_AcroBikeHandbook" to
            MauvilleCity_BikeShop_EventScript_AcroBikeHandbook,
        "MauvilleCity_BikeShop_EventScript_NotFar" to MauvilleCity_BikeShop_EventScript_NotFar,
        "MauvilleCity_BikeShop_EventScript_ChooseAcroHandbookPage" to
            MauvilleCity_BikeShop_EventScript_ChooseAcroHandbookPage,
        "MauvilleCity_BikeShop_EventScript_YesFar" to MauvilleCity_BikeShop_EventScript_YesFar,
        "MauvilleCity_BikeShop_EventScript_AskSwitchBikes" to
            MauvilleCity_BikeShop_EventScript_AskSwitchBikes,
        "MauvilleCity_BikeShop_EventScript_SkipGreeting" to
            MauvilleCity_BikeShop_EventScript_SkipGreeting,
        "MauvilleCity_BikeShop_EventScript_ChooseMachHandbookPage" to
            MauvilleCity_BikeShop_EventScript_ChooseMachHandbookPage,
        "MauvilleCity_BikeShop_EventScript_ChooseBike" to
            MauvilleCity_BikeShop_EventScript_ChooseBike,
        "MauvilleCity_BikeShop_EventScript_KeepBike" to MauvilleCity_BikeShop_EventScript_KeepBike,
        "MauvilleCity_BikeShop_EventScript_SwitchBikes" to
            MauvilleCity_BikeShop_EventScript_SwitchBikes,
        "MauvilleCity_BikeShop_EventScript_SwitchAcroForMach" to
            MauvilleCity_BikeShop_EventScript_SwitchAcroForMach,
        "MauvilleCity_BikeShop_EventScript_SwitchMachForAcro" to
            MauvilleCity_BikeShop_EventScript_SwitchMachForAcro,
        "MauvilleCity_BikeShop_EventScript_ComeBackToSwitchBikes" to
            MauvilleCity_BikeShop_EventScript_ComeBackToSwitchBikes,
    )
