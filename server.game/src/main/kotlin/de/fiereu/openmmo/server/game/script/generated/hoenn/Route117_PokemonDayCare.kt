package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route117_PokemonDayCare
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_EGG_WAITING, Route117_PokemonDayCare_EventScript_EggWaiting
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, Route117_PokemonDayCare_EventScript_OneMonInDaycare
 * goto_if_eq VAR_RESULT, DAYCARE_TWO_MONS, Route117_PokemonDayCare_EventScript_TwoMonsInDaycare
 * msgbox Route117_PokemonDayCare_Text_WouldYouLikeUsToRaiseAMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_GiveMonToRaise
 * msgbox Route117_PokemonDayCare_Text_FineThenComeAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_DaycareWoman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_DaycareWoman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route117_PokemonDayCare_Text_GoodToSeeYou, MSGBOX_DEFAULT
 * setvar VAR_0x8004, 0
 * call Route117_PokemonDayCare_EventScript_DisplayLevelsGained
 * msgbox Route117_PokemonDayCare_Text_WeCanRaiseOneMore, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_GiveMonToRaise
 * msgbox Route117_PokemonDayCare_Text_TakeYourMonBack, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_TryRetrieveMon
 * goto Route117_PokemonDayCare_EventScript_ComeAgain
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_OneMonInDaycare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_OneMonInDaycare")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CountPartyNonEggMons
 * goto_if_eq VAR_RESULT, 1, Route117_PokemonDayCare_EventScript_OnlyOneMon
 * specialvar VAR_RESULT, CountPartyAliveNonEggMons
 * goto_if_eq VAR_RESULT, 2, Route117_PokemonDayCare_EventScript_OnlyTwoAliveMons
 * msgbox Route117_PokemonDayCare_Text_WhichMonShouldWeRaise, MSGBOX_DEFAULT
 * fadescreen FADE_TO_BLACK
 * special ChooseSendDaycareMon
 * goto_if_eq VAR_0x8004, PARTY_NOTHING_CHOSEN, Route117_PokemonDayCare_EventScript_ComeAgain
 * specialvar VAR_RESULT, CountPartyAliveNonEggMons_IgnoreVar0x8004Slot
 * goto_if_eq VAR_RESULT, 0, Route117_PokemonDayCare_EventScript_OnlyOneAliveMon
 * specialvar VAR_0x8005, GetSelectedMonNicknameAndSpecies
 * waitse
 * playmoncry VAR_0x8005, CRY_MODE_NORMAL
 * msgbox Route117_PokemonDayCare_Text_WellRaiseYourMon, MSGBOX_DEFAULT
 * waitmoncry
 * special StoreSelectedPokemonInDaycare
 * incrementgamestat GAME_STAT_USED_DAYCARE
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, Route117_PokemonDayCare_EventScript_CanRaiseOneMore
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_GiveMonToRaise : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_GiveMonToRaise")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_HusbandWasLookingForYou, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_EggWaiting : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.HusbandWasLookingForYou)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route117_PokemonDayCare_Text_GoodToSeeYou, MSGBOX_DEFAULT
 * setvar VAR_0x8004, 0
 * call Route117_PokemonDayCare_EventScript_DisplayLevelsGained
 * setvar VAR_0x8004, 1
 * call Route117_PokemonDayCare_EventScript_DisplayLevelsGained
 * msgbox Route117_PokemonDayCare_Text_TakeYourMonBack, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_TryRetrieveMon
 * msgbox Route117_PokemonDayCare_Text_ComeAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_TwoMonsInDaycare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_TwoMonsInDaycare")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_YoullBeLeftWithJustOne, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_OnlyTwoAliveMons : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.YoullBeLeftWithJustOne)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_WhatWillYouBattleWith, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_OnlyOneAliveMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.WhatWillYouBattleWith)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumLevelsGainedFromDaycare
 * call_if_ne VAR_RESULT, 0, Route117_PokemonDayCare_EventScript_YourMonHasGrownXLevels
 * return
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_DisplayLevelsGained : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_DisplayLevelsGained")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_ComeAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_ComeAgain : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.ComeAgain)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CalculatePlayerPartyCount
 * goto_if_eq VAR_RESULT, PARTY_SIZE, Route117_PokemonDayCare_EventScript_NoRoom
 * specialvar VAR_RESULT, GetDaycareState
 * setvar VAR_0x8004, 0
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, Route117_PokemonDayCare_EventScript_CostPrompt
 * special ShowDaycareLevelMenu
 * copyvar VAR_0x8004, VAR_RESULT
 * goto_if_eq VAR_RESULT, DAYCARE_EXITED_LEVEL_MENU, Route117_PokemonDayCare_EventScript_ComeAgain
 * goto Route117_PokemonDayCare_EventScript_CostPrompt
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_TryRetrieveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_TryRetrieveMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route117_PokemonDayCare_Text_WeCanRaiseOneMore, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_GiveMonToRaise
 * goto Route117_PokemonDayCare_EventScript_ComeAgain
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_CanRaiseOneMore : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_CanRaiseOneMore")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_YouHaveJustOneMon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_OnlyOneMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.YouHaveJustOneMon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetDaycareCostAndPrepareString
 * msgbox Route117_PokemonDayCare_Text_ItWillCostX, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_CheckEnoughMoney
 * goto Route117_PokemonDayCare_EventScript_ComeAgain
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_CostPrompt : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_CostPrompt")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_YourMonHasGrownXLevels, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_YourMonHasGrownXLevels : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.YourMonHasGrownXLevels)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_PokemonDayCare_Text_YourTeamIsFull, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_NoRoom : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117_PokemonDayCare.YourTeamIsFull)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, IsEnoughForCostInVar0x8005
 * goto_if_eq VAR_RESULT, 1, Route117_PokemonDayCare_EventScript_RetrieveMon
 * msgbox Route117_PokemonDayCare_Text_NotEnoughMoney, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_CheckEnoughMoney : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_CheckEnoughMoney")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DAYCARE_LADY, Route117_PokemonDayCare_Movement_RetrieveDaycareMon
 * waitmovement 0
 * specialvar VAR_RESULT, TakePokemonFromDaycare
 * special SubtractMoneyFromVar0x8005
 * playse SE_SHOP
 * msgbox Route117_PokemonDayCare_Text_HeresYourMon, MSGBOX_DEFAULT
 * waitse
 * playmoncry VAR_RESULT, CRY_MODE_NORMAL
 * msgbox Route117_PokemonDayCare_Text_TookBackMon, MSGBOX_DEFAULT
 * waitmoncry
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, Route117_PokemonDayCare_EventScript_AskRetrieveOtherMon
 * goto Route117_PokemonDayCare_EventScript_ComeAgain
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_RetrieveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_RetrieveMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route117_PokemonDayCare_Text_TakeOtherOneBackToo, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_PokemonDayCare_EventScript_TryRetrieveMon
 * goto Route117_PokemonDayCare_EventScript_ComeAgain
 * end
 * ```
 */
internal object Route117_PokemonDayCare_EventScript_AskRetrieveOtherMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_PokemonDayCare_EventScript_AskRetrieveOtherMon")
}

internal val Route117_PokemonDayCareScripts: Map<String, Script> =
    mapOf(
        "Route117_PokemonDayCare_EventScript_DaycareWoman" to
            Route117_PokemonDayCare_EventScript_DaycareWoman,
        "Route117_PokemonDayCare_EventScript_OneMonInDaycare" to
            Route117_PokemonDayCare_EventScript_OneMonInDaycare,
        "Route117_PokemonDayCare_EventScript_GiveMonToRaise" to
            Route117_PokemonDayCare_EventScript_GiveMonToRaise,
        "Route117_PokemonDayCare_EventScript_EggWaiting" to
            Route117_PokemonDayCare_EventScript_EggWaiting,
        "Route117_PokemonDayCare_EventScript_TwoMonsInDaycare" to
            Route117_PokemonDayCare_EventScript_TwoMonsInDaycare,
        "Route117_PokemonDayCare_EventScript_OnlyTwoAliveMons" to
            Route117_PokemonDayCare_EventScript_OnlyTwoAliveMons,
        "Route117_PokemonDayCare_EventScript_OnlyOneAliveMon" to
            Route117_PokemonDayCare_EventScript_OnlyOneAliveMon,
        "Route117_PokemonDayCare_EventScript_DisplayLevelsGained" to
            Route117_PokemonDayCare_EventScript_DisplayLevelsGained,
        "Route117_PokemonDayCare_EventScript_ComeAgain" to
            Route117_PokemonDayCare_EventScript_ComeAgain,
        "Route117_PokemonDayCare_EventScript_TryRetrieveMon" to
            Route117_PokemonDayCare_EventScript_TryRetrieveMon,
        "Route117_PokemonDayCare_EventScript_CanRaiseOneMore" to
            Route117_PokemonDayCare_EventScript_CanRaiseOneMore,
        "Route117_PokemonDayCare_EventScript_OnlyOneMon" to
            Route117_PokemonDayCare_EventScript_OnlyOneMon,
        "Route117_PokemonDayCare_EventScript_CostPrompt" to
            Route117_PokemonDayCare_EventScript_CostPrompt,
        "Route117_PokemonDayCare_EventScript_YourMonHasGrownXLevels" to
            Route117_PokemonDayCare_EventScript_YourMonHasGrownXLevels,
        "Route117_PokemonDayCare_EventScript_NoRoom" to Route117_PokemonDayCare_EventScript_NoRoom,
        "Route117_PokemonDayCare_EventScript_CheckEnoughMoney" to
            Route117_PokemonDayCare_EventScript_CheckEnoughMoney,
        "Route117_PokemonDayCare_EventScript_RetrieveMon" to
            Route117_PokemonDayCare_EventScript_RetrieveMon,
        "Route117_PokemonDayCare_EventScript_AskRetrieveOtherMon" to
            Route117_PokemonDayCare_EventScript_AskRetrieveOtherMon,
    )
