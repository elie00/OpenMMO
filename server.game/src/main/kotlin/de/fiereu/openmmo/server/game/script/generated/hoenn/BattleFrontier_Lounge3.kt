package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_Lounge3
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MET_BATTLE_FRONTIER_GAMBLER, BattleFrontier_Lounge3_EventScript_AlreadyMetGambler
 * call BattleFrontier_Lounge3_EventScript_CountSilverSymbols
 * goto_if_le VAR_0x8004, 2, BattleFrontier_Lounge3_EventScript_NotEnoughSilverSymbols
 * setflag FLAG_MET_BATTLE_FRONTIER_GAMBLER
 * msgbox BattleFrontier_Lounge3_Text_YouLookToughExplainGambling, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge3_EventScript_AskToEnterChallenge
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_Gambler : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_Gambler")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_Lounge3_Text_TrainerGoodButRattled, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge3_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge3.TrainerGoodButRattled)
    return BattleFrontier_Lounge3_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_Lounge3_Text_BackedWrongTrainer, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge3_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge3.BackedWrongTrainer)
    return BattleFrontier_Lounge3_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_Lounge3_Text_KnowWinnerWhenISeeOne, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge3_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge3.KnowWinnerWhenISeeOne)
    return BattleFrontier_Lounge3_EventScript_FaceOriginalDirection.run(ctx)
  }
}

internal object BattleFrontier_Lounge3_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge3.ShouldBeTakingChallenges)
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
internal object BattleFrontier_Lounge3_EventScript_FaceOriginalDirection : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_FaceOriginalDirection")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_Lounge3_Text_Oh, MSGBOX_DEFAULT
 * goto_if_ge VAR_FRONTIER_GAMBLER_STATE, FRONTIER_GAMBLER_PLACED_BET, BattleFrontier_Lounge3_EventScript_CheckBetResults
 * goto BattleFrontier_Lounge3_EventScript_AskToEnterChallenge
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_AlreadyMetGambler : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_AlreadyMetGambler")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge3_Text_CantYouSeeWereBusyHere, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge3_EventScript_FaceOriginalDirection
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_NotEnoughSilverSymbols : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge3.CantYouSeeWereBusyHere)
    return BattleFrontier_Lounge3_EventScript_FaceOriginalDirection.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special ShowFrontierGamblerLookingMessage
 * waitmessage
 * waitbuttonpress
 * msgbox BattleFrontier_Lounge3_Text_HowAboutEnteringEventForMe, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, BattleFrontier_Lounge3_EventScript_DeclineChallenge
 * msgbox BattleFrontier_Lounge3_Text_SpotMeSomeBattlePoints, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, BattleFrontier_Lounge3_EventScript_DeclineChallenge
 * message BattleFrontier_Lounge3_Text_HowMuchCanYouSpot
 * waitmessage
 * special ShowBattlePointsWindow
 * goto BattleFrontier_Lounge3_EventScript_ChooseBetAmount
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_AskToEnterChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_AskToEnterChallenge")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * call_if_set FLAG_SYS_TOWER_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * call_if_set FLAG_SYS_DOME_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * call_if_set FLAG_SYS_PALACE_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * call_if_set FLAG_SYS_ARENA_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * call_if_set FLAG_SYS_FACTORY_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * call_if_set FLAG_SYS_PIKE_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * call_if_set FLAG_SYS_PYRAMID_SILVER, BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount
 * return
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_CountSilverSymbols : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_CountSilverSymbols")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 20, 4, MULTI_FRONTIER_GAMBLER_BET, FALSE
 * copyvar VAR_FRONTIER_GAMBLER_AMOUNT_BET, VAR_RESULT
 * switch VAR_RESULT
 * case FRONTIER_GAMBLER_BET_5, BattleFrontier_Lounge3_EventScript_Bet5
 * case FRONTIER_GAMBLER_BET_10, BattleFrontier_Lounge3_EventScript_Bet10
 * case FRONTIER_GAMBLER_BET_15, BattleFrontier_Lounge3_EventScript_Bet15
 * case FRONTIER_GAMBLER_BET_CANCEL, BattleFrontier_Lounge3_EventScript_CancelBet
 * case MULTI_B_PRESSED, BattleFrontier_Lounge3_EventScript_CancelBet
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_ChooseBetAmount : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_ChooseBetAmount")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge3_Text_NotInterested, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_DeclineChallenge : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge3.NotInterested)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_0x8004, 1
 * return
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_FRONTIER_GAMBLER_STATE, FRONTIER_GAMBLER_PLACED_BET, BattleFrontier_Lounge3_EventScript_ChallengeNotAttempted
 * goto_if_eq VAR_FRONTIER_GAMBLER_STATE, FRONTIER_GAMBLER_WON, BattleFrontier_Lounge3_EventScript_WonChallenge
 * goto BattleFrontier_Lounge3_EventScript_LostChallenge
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_CheckBetResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_CheckBetResults")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_Lounge3_Text_HelloChampHeresYourPoints, MSGBOX_DEFAULT
 * call_if_eq VAR_FRONTIER_GAMBLER_AMOUNT_BET, FRONTIER_GAMBLER_BET_5, BattleFrontier_Lounge3_EventScript_RewardBet5
 * call_if_eq VAR_FRONTIER_GAMBLER_AMOUNT_BET, FRONTIER_GAMBLER_BET_10, BattleFrontier_Lounge3_EventScript_RewardBet10
 * call_if_eq VAR_FRONTIER_GAMBLER_AMOUNT_BET, FRONTIER_GAMBLER_BET_15, BattleFrontier_Lounge3_EventScript_RewardBet15
 * msgbox BattleFrontier_Lounge3_Text_ObtainedBattlePoints, MSGBOX_GETPOINTS
 * special GiveFrontierBattlePoints
 * msgbox BattleFrontier_Lounge3_Text_ThinkOfMeForAnotherChallenge, MSGBOX_DEFAULT
 * setvar VAR_FRONTIER_GAMBLER_STATE, FRONTIER_GAMBLER_WAITING
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_WonChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_WonChallenge")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_Lounge3_Text_NiceTryCantReturnPoints, MSGBOX_DEFAULT
 * setvar VAR_FRONTIER_GAMBLER_STATE, FRONTIER_GAMBLER_WAITING
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_LostChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_LostChallenge")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special ShowFrontierGamblerGoMessage
 * waitmessage
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_ChallengeNotAttempted : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_ChallengeNotAttempted")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, (BET_AMOUNT_5 * 2)
 * setvar VAR_0x8004, (BET_AMOUNT_5 * 2)
 * return
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_RewardBet5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_RewardBet5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, (BET_AMOUNT_10 * 2)
 * setvar VAR_0x8004, (BET_AMOUNT_10 * 2)
 * return
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_RewardBet10 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_RewardBet10")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, (BET_AMOUNT_15 * 2)
 * setvar VAR_0x8004, (BET_AMOUNT_15 * 2)
 * return
 * ```
 */
internal object BattleFrontier_Lounge3_EventScript_RewardBet15 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge3_EventScript_RewardBet15")
}

internal val BattleFrontier_Lounge3Scripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_Lounge3_EventScript_Gambler" to BattleFrontier_Lounge3_EventScript_Gambler,
        "BattleFrontier_Lounge3_EventScript_FatMan" to BattleFrontier_Lounge3_EventScript_FatMan,
        "BattleFrontier_Lounge3_EventScript_Woman" to BattleFrontier_Lounge3_EventScript_Woman,
        "BattleFrontier_Lounge3_EventScript_PokefanF" to
            BattleFrontier_Lounge3_EventScript_PokefanF,
        "BattleFrontier_Lounge3_EventScript_Man" to BattleFrontier_Lounge3_EventScript_Man,
        "BattleFrontier_Lounge3_EventScript_FaceOriginalDirection" to
            BattleFrontier_Lounge3_EventScript_FaceOriginalDirection,
        "BattleFrontier_Lounge3_EventScript_AlreadyMetGambler" to
            BattleFrontier_Lounge3_EventScript_AlreadyMetGambler,
        "BattleFrontier_Lounge3_EventScript_NotEnoughSilverSymbols" to
            BattleFrontier_Lounge3_EventScript_NotEnoughSilverSymbols,
        "BattleFrontier_Lounge3_EventScript_AskToEnterChallenge" to
            BattleFrontier_Lounge3_EventScript_AskToEnterChallenge,
        "BattleFrontier_Lounge3_EventScript_CountSilverSymbols" to
            BattleFrontier_Lounge3_EventScript_CountSilverSymbols,
        "BattleFrontier_Lounge3_EventScript_ChooseBetAmount" to
            BattleFrontier_Lounge3_EventScript_ChooseBetAmount,
        "BattleFrontier_Lounge3_EventScript_DeclineChallenge" to
            BattleFrontier_Lounge3_EventScript_DeclineChallenge,
        "BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount" to
            BattleFrontier_Lounge3_EventScript_AddSilverSymbolCount,
        "BattleFrontier_Lounge3_EventScript_CheckBetResults" to
            BattleFrontier_Lounge3_EventScript_CheckBetResults,
        "BattleFrontier_Lounge3_EventScript_WonChallenge" to
            BattleFrontier_Lounge3_EventScript_WonChallenge,
        "BattleFrontier_Lounge3_EventScript_LostChallenge" to
            BattleFrontier_Lounge3_EventScript_LostChallenge,
        "BattleFrontier_Lounge3_EventScript_ChallengeNotAttempted" to
            BattleFrontier_Lounge3_EventScript_ChallengeNotAttempted,
        "BattleFrontier_Lounge3_EventScript_RewardBet5" to
            BattleFrontier_Lounge3_EventScript_RewardBet5,
        "BattleFrontier_Lounge3_EventScript_RewardBet10" to
            BattleFrontier_Lounge3_EventScript_RewardBet10,
        "BattleFrontier_Lounge3_EventScript_RewardBet15" to
            BattleFrontier_Lounge3_EventScript_RewardBet15,
    )
