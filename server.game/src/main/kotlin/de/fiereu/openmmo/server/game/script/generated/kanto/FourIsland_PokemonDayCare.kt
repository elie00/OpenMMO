package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.DayCare
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * lock
 * faceplayer
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_EGG_WAITING, FourIsland_PokemonDayCare_EggWaiting
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, FourIsland_PokemonDayCare_OneMonInDaycare
 * goto_if_eq VAR_RESULT, DAYCARE_TWO_MONS, FourIsland_PokemonDayCare_TwoMonsInDaycare
 * msgbox DayCare_Text_WouldYouLikeUsToRaiseMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_GiveMonToRaise
 * msgbox DayCare_Text_FineThenComeAgain
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_EventScript_DaycareWoman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_EventScript_DaycareWoman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DayCare_Text_GoodToSeeYou
 * setvar VAR_0x8004, 0
 * call FourIsland_PokemonDayCare_DisplayLevelsGained
 * setvar VAR_0x8004, 1
 * call FourIsland_PokemonDayCare_DisplayLevelsGained
 * msgbox DayCare_Text_TakeYourMonBack, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_TryRetrieveMon
 * msgbox DayCare_Text_ComeAgain
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_TwoMonsInDaycare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_TwoMonsInDaycare")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CountPartyNonEggMons
 * goto_if_eq VAR_RESULT, 1, FourIsland_PokemonDayCare_OnlyOneMonInParty
 * msgbox DayCare_Text_WhichMonShouldWeRaise
 * fadescreen FADE_TO_BLACK
 * special ChooseSendDaycareMon
 * waitstate
 * goto_if_ge VAR_0x8004, PARTY_SIZE, FourIsland_PokemonDayCare_ComeAgain
 * specialvar VAR_RESULT, CountPartyAliveNonEggMons_IgnoreVar0x8004Slot
 * goto_if_eq VAR_RESULT, 0, FourIsland_PokemonDayCare_OnlyOneAliveMonInParty
 * specialvar VAR_0x8005, GetSelectedMonNicknameAndSpecies
 * waitse
 * playmoncry VAR_0x8005, CRY_MODE_NORMAL
 * msgbox DayCare_Text_WellRaiseYourMon
 * waitmoncry
 * special StoreSelectedPokemonInDaycare
 * incrementgamestat GAME_STAT_USED_DAYCARE
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, FourIsland_PokemonDayCare_CanRaiseOneMore
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_GiveMonToRaise : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_GiveMonToRaise")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DayCare_Text_GoodToSeeYou
 * setvar VAR_0x8004, 0
 * call FourIsland_PokemonDayCare_DisplayLevelsGained
 * msgbox DayCare_Text_WeCanRaiseOneMore, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_GiveMonToRaise
 * msgbox DayCare_Text_TakeYourMonBack, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_TryRetrieveMon
 * goto FourIsland_PokemonDayCare_ComeAgain
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_OneMonInDaycare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_OneMonInDaycare")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DayCare_Text_HusbandWasLookingForYou
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_EggWaiting : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DayCare.HusbandWasLookingForYou)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DayCare_Text_YouHaveJustOneMon
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_OnlyOneMonInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DayCare.YouHaveJustOneMon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DayCare_Text_WeCanRaiseOneMore, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_GiveMonToRaise
 * goto FourIsland_PokemonDayCare_ComeAgain
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_CanRaiseOneMore : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_CanRaiseOneMore")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DayCare_Text_WhatWillYouBattleWith
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_OnlyOneAliveMonInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DayCare.WhatWillYouBattleWith)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CalculatePlayerPartyCount
 * goto_if_eq VAR_RESULT, PARTY_SIZE, FourIsland_PokemonDayCare_NoRoomInParty
 * specialvar VAR_RESULT, GetDaycareState
 * setvar VAR_0x8004, 0
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, FourIsland_PokemonDayCare_CostPrompt
 * special ShowDaycareLevelMenu
 * waitstate
 * copyvar VAR_0x8004, VAR_RESULT
 * goto_if_eq VAR_RESULT, DAYCARE_EXITED_LEVEL_MENU, FourIsland_PokemonDayCare_ComeAgain
 * goto FourIsland_PokemonDayCare_CostPrompt
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_TryRetrieveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_TryRetrieveMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DayCare_Text_ComeAgain
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_ComeAgain : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DayCare.ComeAgain)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumLevelsGainedFromDaycare
 * call_if_ne VAR_RESULT, 0, FourIsland_PokemonDayCare_MonHasGrownXLevels
 * return
 * ```
 */
internal object FourIsland_PokemonDayCare_DisplayLevelsGained : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_DisplayLevelsGained")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DayCare_Text_YourMonHasGrownXLevels
 * return
 * ```
 */
internal object FourIsland_PokemonDayCare_MonHasGrownXLevels : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DayCare.YourMonHasGrownXLevels)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetDaycareCost
 * msgbox DayCare_Text_ItWillCostX, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_CheckEnoughMoney
 * goto FourIsland_PokemonDayCare_ComeAgain
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_CostPrompt : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_PokemonDayCare_CostPrompt")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DayCare_Text_YourPartyIsFull
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_NoRoomInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DayCare.YourPartyIsFull)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, IsEnoughForCostInVar0x8005
 * goto_if_eq VAR_RESULT, TRUE, FourIsland_PokemonDayCare_RetrieveMon
 * msgbox DayCare_Text_NotEnoughMoney
 * release
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_CheckEnoughMoney : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_CheckEnoughMoney")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FOUR_ISLAND_DAYCARE_WOMAN, FourIsland_PokemonDayCare_Movement_RetrieveMon
 * waitmovement 0
 * specialvar VAR_RESULT, TakePokemonFromDaycare
 * special SubtractMoneyFromVar0x8005
 * playse SE_RS_SHOP
 * msgbox DayCare_Text_HeresYourMon
 * waitse
 * playmoncry VAR_RESULT, CRY_MODE_NORMAL
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox DayCare_Text_TookBackMon
 * call EventScript_RestorePrevTextColor
 * waitmoncry
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, FourIsland_PokemonDayCare_AskRetrieveOtherMon
 * goto FourIsland_PokemonDayCare_ComeAgain
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_RetrieveMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_PokemonDayCare_RetrieveMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DayCare_Text_TakeOtherOneBackToo, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_PokemonDayCare_TryRetrieveMon
 * goto FourIsland_PokemonDayCare_ComeAgain
 * end
 * ```
 */
internal object FourIsland_PokemonDayCare_AskRetrieveOtherMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_PokemonDayCare_AskRetrieveOtherMon")
}

internal val FourIsland_PokemonDayCareScripts: Map<String, Script> =
    mapOf(
        "FourIsland_PokemonDayCare_EventScript_DaycareWoman" to
            FourIsland_PokemonDayCare_EventScript_DaycareWoman,
        "FourIsland_PokemonDayCare_TwoMonsInDaycare" to FourIsland_PokemonDayCare_TwoMonsInDaycare,
        "FourIsland_PokemonDayCare_GiveMonToRaise" to FourIsland_PokemonDayCare_GiveMonToRaise,
        "FourIsland_PokemonDayCare_OneMonInDaycare" to FourIsland_PokemonDayCare_OneMonInDaycare,
        "FourIsland_PokemonDayCare_EggWaiting" to FourIsland_PokemonDayCare_EggWaiting,
        "FourIsland_PokemonDayCare_OnlyOneMonInParty" to
            FourIsland_PokemonDayCare_OnlyOneMonInParty,
        "FourIsland_PokemonDayCare_CanRaiseOneMore" to FourIsland_PokemonDayCare_CanRaiseOneMore,
        "FourIsland_PokemonDayCare_OnlyOneAliveMonInParty" to
            FourIsland_PokemonDayCare_OnlyOneAliveMonInParty,
        "FourIsland_PokemonDayCare_TryRetrieveMon" to FourIsland_PokemonDayCare_TryRetrieveMon,
        "FourIsland_PokemonDayCare_ComeAgain" to FourIsland_PokemonDayCare_ComeAgain,
        "FourIsland_PokemonDayCare_DisplayLevelsGained" to
            FourIsland_PokemonDayCare_DisplayLevelsGained,
        "FourIsland_PokemonDayCare_MonHasGrownXLevels" to
            FourIsland_PokemonDayCare_MonHasGrownXLevels,
        "FourIsland_PokemonDayCare_CostPrompt" to FourIsland_PokemonDayCare_CostPrompt,
        "FourIsland_PokemonDayCare_NoRoomInParty" to FourIsland_PokemonDayCare_NoRoomInParty,
        "FourIsland_PokemonDayCare_CheckEnoughMoney" to FourIsland_PokemonDayCare_CheckEnoughMoney,
        "FourIsland_PokemonDayCare_RetrieveMon" to FourIsland_PokemonDayCare_RetrieveMon,
        "FourIsland_PokemonDayCare_AskRetrieveOtherMon" to
            FourIsland_PokemonDayCare_AskRetrieveOtherMon,
    )
