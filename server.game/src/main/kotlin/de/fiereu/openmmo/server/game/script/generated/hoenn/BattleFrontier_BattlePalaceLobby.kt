package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_BattlePalaceLobby
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_FRONTIER_FACILITY, FRONTIER_FACILITY_PALACE
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES
 * goto BattleFrontier_BattlePalaceLobby_EventScript_Attendant
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_SinglesAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_SinglesAttendant")
}

internal object BattleFrontier_BattlePalaceLobby_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattlePalaceLobby.LadyCanTellWhatMonsThink)
}

internal object BattleFrontier_BattlePalaceLobby_EventScript_Maniac : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattlePalaceLobby.WhatNatureFavorsChippingAway)
}

internal object BattleFrontier_BattlePalaceLobby_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattlePalaceLobby.NatureAndMovesKeyHere)
}

internal object BattleFrontier_BattlePalaceLobby_EventScript_Beauty : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattlePalaceLobby.MonDocileButTransforms)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_FRONTIER_FACILITY, FRONTIER_FACILITY_PALACE
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_DOUBLES
 * goto BattleFrontier_BattlePalaceLobby_EventScript_Attendant
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_DoublesAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_DoublesAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FRONTIER_FACILITY_PALACE, FRONTIER_MODE_SINGLES
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_ShowSinglesResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_ShowSinglesResults")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FRONTIER_FACILITY_PALACE, FRONTIER_MODE_DOUBLES
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_ShowDoublesResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_ShowDoublesResults")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * msgbox BattleFrontier_BattlePalaceLobby_Text_RulesAreListed, MSGBOX_DEFAULT
 * goto BattleFrontier_BattlePalaceLobby_EventScript_ReadRulesBoard
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_RulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattlePalaceLobby.RulesAreListed)
    return BattleFrontier_BattlePalaceLobby_EventScript_ReadRulesBoard.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_BattlePalaceLobby_Text_ReadWhichHeading
 * waitmessage
 * multichoice 16, 0, MULTI_BATTLE_PALACE_RULES, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattlePalaceLobby_EventScript_RulesBasics
 * case 1, BattleFrontier_BattlePalaceLobby_EventScript_RulesNature
 * case 2, BattleFrontier_BattlePalaceLobby_EventScript_RulesMoves
 * case 3, BattleFrontier_BattlePalaceLobby_EventScript_RulesUnderpowered
 * case 4, BattleFrontier_BattlePalaceLobby_EventScript_RulesWhenInDanger
 * case 5, BattleFrontier_BattlePalaceLobby_EventScript_ExitRules
 * case MULTI_B_PRESSED, BattleFrontier_BattlePalaceLobby_EventScript_ExitRules
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_ReadRulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_ReadRulesBoard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * palace_get PALACE_DATA_PRIZE
 * goto_if_ne VAR_RESULT, ITEM_NONE, BattleFrontier_BattlePalaceLobby_EventScript_WonChallenge
 * special SavePlayerParty
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES, BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForSingleBattle
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_DOUBLES, BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForDoubleBattle
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES, BattleFrontier_BattlePalaceLobby_EventScript_AskTakeSingleBattleChallenge
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_DOUBLES, BattleFrontier_BattlePalaceLobby_EventScript_AskTakeDoubleBattleChallenge
 * waitmessage
 * multichoice 17, 6, MULTI_CHALLENGEINFO, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattlePalaceLobby_EventScript_TryEnterChallenge
 * case 1, BattleFrontier_BattlePalaceLobby_EventScript_ExplainChallenge
 * case 2, BattleFrontier_BattlePalaceLobby_EventScript_CancelChallenge
 * case MULTI_B_PRESSED, BattleFrontier_BattlePalaceLobby_EventScript_CancelChallenge
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_Attendant")
}

/**
 * Ported from the decomp:
 * ```
 * message BattleFrontier_BattlePalaceLobby_Text_TakeDoubleBattleChallenge
 * return
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_AskTakeDoubleBattleChallenge : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattlePalaceLobby.TakeDoubleBattleChallenge)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_isbrain
 * goto_if_eq VAR_RESULT, TRUE, BattleFrontier_BattlePalaceLobby_EventScript_DefeatedMaven
 * msgbox BattleFrontier_BattlePalaceLobby_Text_FirmTrueBondsFor7WinStreak, MSGBOX_DEFAULT
 * goto BattleFrontier_BattlePalaceLobby_EventScript_GiveBattlePoints
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_WonChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_WonChallenge")
}

/**
 * Ported from the decomp:
 * ```
 * message BattleFrontier_BattlePalaceLobby_Text_TakeSingleBattleChallenge
 * return
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_AskTakeSingleBattleChallenge : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattlePalaceLobby.TakeSingleBattleChallenge)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_BattlePalaceLobby_Text_WelcomeForSingleBattle, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForSingleBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattlePalaceLobby.WelcomeForSingleBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_BattlePalaceLobby_Text_WelcomeForDoubleBattle, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForDoubleBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattlePalaceLobby.WelcomeForDoubleBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_BattlePalaceLobby_Text_PresentYouWithBattlePoints, MSGBOX_DEFAULT
 * frontier_givepoints
 * msgbox BattleFrontier_Text_ObtainedXBattlePoints, MSGBOX_GETPOINTS
 * message BattleFrontier_BattlePalaceLobby_Text_FeatWillBeRecorded
 * waitmessage
 * call BattleFrontier_BattlePalaceLobby_EventScript_SaveAfterChallenge
 * msgbox BattleFrontier_BattlePalaceLobby_Text_ReturnWhenFortified, MSGBOX_DEFAULT
 * closemessage
 * setvar VAR_TEMP_CHALLENGE_STATUS, 255
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_GiveBattlePoints : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_GiveBattlePoints")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_BattlePalaceLobby_Text_ToDefeatMavenAnd7Trainers, MSGBOX_DEFAULT
 * msgbox BattleFrontier_BattlePalaceLobby_Text_PresentYouWithBattlePoints, MSGBOX_DEFAULT
 * frontier_givepoints
 * msgbox BattleFrontier_Text_ObtainedXBattlePoints, MSGBOX_GETPOINTS
 * message BattleFrontier_BattlePalaceLobby_Text_FeatWillBeRecorded
 * waitmessage
 * call BattleFrontier_BattlePalaceLobby_EventScript_SaveAfterChallenge
 * msgbox BattleFrontier_BattlePalaceLobby_Text_ReturnWhenFortified, MSGBOX_DEFAULT
 * closemessage
 * setvar VAR_TEMP_CHALLENGE_STATUS, 255
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_DefeatedMaven : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_DefeatedMaven")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * frontier_checkairshow
 * special LoadPlayerParty
 * special HealPlayerParty
 * palace_save 0
 * playse SE_SAVE
 * waitse
 * call BattleFrontier_EventScript_GetCantRecordBattle
 * goto_if_eq VAR_RESULT, TRUE, BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge
 * message BattleFrontier_BattlePalaceLobby_Text_LikeToRecordMatch
 * waitmessage
 * multichoicedefault 20, 8, MULTI_YESNO, 1, FALSE
 * switch VAR_RESULT
 * case 1, BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge
 * case 0, BattleFrontier_BattlePalaceLobby_EventScript_RecordMatch
 * case MULTI_B_PRESSED, BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_SaveAfterChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_SaveAfterChallenge")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * frontier_get FRONTIER_DATA_RECORD_DISABLED
 * return
 * ```
 */
internal object BattleFrontier_EventScript_GetCantRecordBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_EventScript_GetCantRecordBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * return
 * ```
 */
internal object BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge")
}

internal val BattleFrontier_BattlePalaceLobbyScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_BattlePalaceLobby_EventScript_SinglesAttendant" to
            BattleFrontier_BattlePalaceLobby_EventScript_SinglesAttendant,
        "BattleFrontier_BattlePalaceLobby_EventScript_BlackBelt" to
            BattleFrontier_BattlePalaceLobby_EventScript_BlackBelt,
        "BattleFrontier_BattlePalaceLobby_EventScript_Maniac" to
            BattleFrontier_BattlePalaceLobby_EventScript_Maniac,
        "BattleFrontier_BattlePalaceLobby_EventScript_Man" to
            BattleFrontier_BattlePalaceLobby_EventScript_Man,
        "BattleFrontier_BattlePalaceLobby_EventScript_Beauty" to
            BattleFrontier_BattlePalaceLobby_EventScript_Beauty,
        "BattleFrontier_BattlePalaceLobby_EventScript_DoublesAttendant" to
            BattleFrontier_BattlePalaceLobby_EventScript_DoublesAttendant,
        "BattleFrontier_BattlePalaceLobby_EventScript_ShowSinglesResults" to
            BattleFrontier_BattlePalaceLobby_EventScript_ShowSinglesResults,
        "BattleFrontier_BattlePalaceLobby_EventScript_ShowDoublesResults" to
            BattleFrontier_BattlePalaceLobby_EventScript_ShowDoublesResults,
        "BattleFrontier_BattlePalaceLobby_EventScript_RulesBoard" to
            BattleFrontier_BattlePalaceLobby_EventScript_RulesBoard,
        "BattleFrontier_BattlePalaceLobby_EventScript_ReadRulesBoard" to
            BattleFrontier_BattlePalaceLobby_EventScript_ReadRulesBoard,
        "BattleFrontier_BattlePalaceLobby_EventScript_Attendant" to
            BattleFrontier_BattlePalaceLobby_EventScript_Attendant,
        "BattleFrontier_BattlePalaceLobby_EventScript_AskTakeDoubleBattleChallenge" to
            BattleFrontier_BattlePalaceLobby_EventScript_AskTakeDoubleBattleChallenge,
        "BattleFrontier_BattlePalaceLobby_EventScript_WonChallenge" to
            BattleFrontier_BattlePalaceLobby_EventScript_WonChallenge,
        "BattleFrontier_BattlePalaceLobby_EventScript_AskTakeSingleBattleChallenge" to
            BattleFrontier_BattlePalaceLobby_EventScript_AskTakeSingleBattleChallenge,
        "BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForSingleBattle" to
            BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForSingleBattle,
        "BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForDoubleBattle" to
            BattleFrontier_BattlePalaceLobby_EventScript_WelcomeForDoubleBattle,
        "BattleFrontier_BattlePalaceLobby_EventScript_GiveBattlePoints" to
            BattleFrontier_BattlePalaceLobby_EventScript_GiveBattlePoints,
        "BattleFrontier_BattlePalaceLobby_EventScript_DefeatedMaven" to
            BattleFrontier_BattlePalaceLobby_EventScript_DefeatedMaven,
        "BattleFrontier_BattlePalaceLobby_EventScript_SaveAfterChallenge" to
            BattleFrontier_BattlePalaceLobby_EventScript_SaveAfterChallenge,
        "BattleFrontier_EventScript_GetCantRecordBattle" to
            BattleFrontier_EventScript_GetCantRecordBattle,
        "BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge" to
            BattleFrontier_BattlePalaceLobby_EventScript_EndSaveAfterChallenge,
    )
