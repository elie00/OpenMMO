package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route5_PokemonDayCare
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * lock
 * faceplayer
 * showmoneybox 0, 0
 * specialvar VAR_RESULT, IsThereMonInRoute5Daycare
 * goto_if_eq VAR_RESULT, TRUE, Route5_PokemonDayCare_EventScript_CheckOnMon
 * msgbox Route5_PokemonDayCare_Text_WantMeToRaiseMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route5_PokemonDayCare_EventScript_TryGiveMon
 * msgbox Route5_PokemonDayCare_Text_ComeAgain
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_DaycareMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route5_PokemonDayCare_EventScript_DaycareMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * specialvar VAR_RESULT, GetNumLevelsGainedForRoute5DaycareMon
 * call_if_ne VAR_RESULT, 0, Route5_PokemonDayCare_EventScript_MonHasGrownByXLevels
 * call_if_eq VAR_RESULT, 0, Route5_PokemonDayCare_EventScript_NotEnoughTime
 * special GetCostToWithdrawRoute5DaycareMon
 * msgbox Route5_PokemonDayCare_Text_OweMeXForMonsReturn, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route5_PokemonDayCare_EventScript_TryRetrieveMon
 * goto Route5_PokemonDayCare_EventScript_ComeAgain
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_CheckOnMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route5_PokemonDayCare_EventScript_CheckOnMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CountPartyNonEggMons
 * goto_if_eq VAR_RESULT, 1, Route5_PokemonDayCare_EventScript_OnlyOneMonInParty
 * msgbox Route5_PokemonDayCare_Text_WhichMonShouldIRaise
 * fadescreen FADE_TO_BLACK
 * hidemoneybox
 * special ChooseSendDaycareMon
 * waitstate
 * showmoneybox 0, 0
 * goto_if_ge VAR_0x8004, PARTY_SIZE, Route5_PokemonDayCare_EventScript_ComeAgain
 * specialvar VAR_RESULT, CountPartyAliveNonEggMons_IgnoreVar0x8004Slot
 * goto_if_eq VAR_RESULT, 0, Route5_PokemonDayCare_EventScript_OnlyOneAliveMonInParty
 * specialvar VAR_0x8005, GetSelectedMonNicknameAndSpecies
 * msgbox Route5_PokemonDayCare_Text_LookAfterMonForAWhile
 * waitse
 * playmoncry VAR_0x8005, CRY_MODE_NORMAL
 * msgbox Route5_PokemonDayCare_Text_ComeSeeMeInAWhile
 * waitmoncry
 * special PutMonInRoute5Daycare
 * incrementgamestat GAME_STAT_USED_DAYCARE
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_TryGiveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route5_PokemonDayCare_EventScript_TryGiveMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_CloseMoneyBox : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route5_PokemonDayCare_EventScript_CloseMoneyBox")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route5_PokemonDayCare_Text_MonNeedsToSpendMoreTime
 * return
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_NotEnoughTime : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route5_PokemonDayCare.MonNeedsToSpendMoreTime)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route5_PokemonDayCare_Text_MonHasGrownByXLevels
 * return
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_MonHasGrownByXLevels : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route5_PokemonDayCare.MonHasGrownByXLevels)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route5_PokemonDayCare_Text_OnlyHaveOneMonWithYou
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_OnlyOneMonInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route5_PokemonDayCare.OnlyHaveOneMonWithYou)
    return Route5_PokemonDayCare_EventScript_CloseMoneyBox.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route5_PokemonDayCare_Text_WhatWillYouBattleWith
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_OnlyOneAliveMonInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route5_PokemonDayCare.WhatWillYouBattleWith)
    return Route5_PokemonDayCare_EventScript_CloseMoneyBox.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CalculatePlayerPartyCount
 * goto_if_eq VAR_RESULT, PARTY_SIZE, Route5_PokemonDayCare_EventScript_NoRoomInParty
 * specialvar VAR_RESULT, IsEnoughForCostInVar0x8005
 * goto_if_eq VAR_RESULT, TRUE, Route5_PokemonDayCare_EventScript_RetrieveMon
 * msgbox Route5_PokemonDayCare_Text_DontHaveEnoughMoney
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_TryRetrieveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route5_PokemonDayCare_EventScript_TryRetrieveMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route5_PokemonDayCare_Text_ComeAnytimeYouLike
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_ComeAgain : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route5_PokemonDayCare.ComeAnytimeYouLike)
    return Route5_PokemonDayCare_EventScript_CloseMoneyBox.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * specialvar VAR_RESULT, TakePokemonFromRoute5Daycare
 * special SubtractMoneyFromVar0x8005
 * updatemoneybox
 * copyvar VAR_0x8008, VAR_RESULT
 * getpartysize
 * subvar VAR_RESULT, 1
 * bufferpartymonnick STR_VAR_1, VAR_RESULT
 * copyvar VAR_RESULT, VAR_0x8008
 * msgbox Route5_PokemonDayCare_Text_ThankYouHeresMon
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * waitse
 * playmoncry VAR_RESULT, CRY_MODE_NORMAL
 * msgbox Route5_PokemonDayCare_Text_PlayerGotMonBack
 * call EventScript_RestorePrevTextColor
 * waitmoncry
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_RetrieveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route5_PokemonDayCare_EventScript_RetrieveMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route5_PokemonDayCare_Text_YouveGotNoRoomForIt
 * goto Route5_PokemonDayCare_EventScript_CloseMoneyBox
 * end
 * ```
 */
internal object Route5_PokemonDayCare_EventScript_NoRoomInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route5_PokemonDayCare.YouveGotNoRoomForIt)
    return Route5_PokemonDayCare_EventScript_CloseMoneyBox.run(ctx)
  }
}

internal val Route5_PokemonDayCareScripts: Map<String, Script> =
    mapOf(
        "Route5_PokemonDayCare_EventScript_DaycareMan" to
            Route5_PokemonDayCare_EventScript_DaycareMan,
        "Route5_PokemonDayCare_EventScript_CheckOnMon" to
            Route5_PokemonDayCare_EventScript_CheckOnMon,
        "Route5_PokemonDayCare_EventScript_TryGiveMon" to
            Route5_PokemonDayCare_EventScript_TryGiveMon,
        "Route5_PokemonDayCare_EventScript_CloseMoneyBox" to
            Route5_PokemonDayCare_EventScript_CloseMoneyBox,
        "Route5_PokemonDayCare_EventScript_NotEnoughTime" to
            Route5_PokemonDayCare_EventScript_NotEnoughTime,
        "Route5_PokemonDayCare_EventScript_MonHasGrownByXLevels" to
            Route5_PokemonDayCare_EventScript_MonHasGrownByXLevels,
        "Route5_PokemonDayCare_EventScript_OnlyOneMonInParty" to
            Route5_PokemonDayCare_EventScript_OnlyOneMonInParty,
        "Route5_PokemonDayCare_EventScript_OnlyOneAliveMonInParty" to
            Route5_PokemonDayCare_EventScript_OnlyOneAliveMonInParty,
        "Route5_PokemonDayCare_EventScript_TryRetrieveMon" to
            Route5_PokemonDayCare_EventScript_TryRetrieveMon,
        "Route5_PokemonDayCare_EventScript_ComeAgain" to
            Route5_PokemonDayCare_EventScript_ComeAgain,
        "Route5_PokemonDayCare_EventScript_RetrieveMon" to
            Route5_PokemonDayCare_EventScript_RetrieveMon,
        "Route5_PokemonDayCare_EventScript_NoRoomInParty" to
            Route5_PokemonDayCare_EventScript_NoRoomInParty,
    )
