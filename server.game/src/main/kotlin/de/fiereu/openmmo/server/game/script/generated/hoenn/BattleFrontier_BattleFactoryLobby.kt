package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_BattleFactoryLobby
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_FRONTIER_FACILITY, FRONTIER_FACILITY_FACTORY
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES
 * goto BattleFrontier_BattleFactoryLobby_EventScript_Attendant
 * end
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_SinglesAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleFactoryLobby_EventScript_SinglesAttendant")
}

internal object BattleFrontier_BattleFactoryLobby_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleFactoryLobby.NeedKnowledgeOfMonsMoves)
}

internal object BattleFrontier_BattleFactoryLobby_EventScript_Camper : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleFactoryLobby.SwappedForWeakMon)
}

internal object BattleFrontier_BattleFactoryLobby_EventScript_Picnicker : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleFactoryLobby.NeedToCheckOpponentsMons)
}

internal object BattleFrontier_BattleFactoryLobby_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleFactoryLobby.CantFigureOutStaffHints)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_FRONTIER_FACILITY, FRONTIER_FACILITY_FACTORY
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_DOUBLES
 * goto BattleFrontier_BattleFactoryLobby_EventScript_Attendant
 * end
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_DoublesAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleFactoryLobby_EventScript_DoublesAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FRONTIER_FACILITY_FACTORY, FRONTIER_MODE_SINGLES
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_ShowSinglesResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleFactoryLobby_EventScript_ShowSinglesResults")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FRONTIER_FACILITY_FACTORY, FRONTIER_MODE_DOUBLES
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_ShowDoublesResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleFactoryLobby_EventScript_ShowDoublesResults")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * msgbox BattleFrontier_BattleFactoryLobby_Text_RulesAreListed, MSGBOX_DEFAULT
 * goto BattleFrontier_BattleFactoryLobby_EventScript_ReadRulesBoard
 * end
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_RulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleFactoryLobby.RulesAreListed)
    return BattleFrontier_BattleFactoryLobby_EventScript_ReadRulesBoard.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_BattleFactoryLobby_Text_ReadWhichHeading
 * waitmessage
 * multichoice 17, 0, MULTI_BATTLE_FACTORY_RULES, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattleFactoryLobby_EventScript_RulesBasics
 * case 1, BattleFrontier_BattleFactoryLobby_EventScript_RulesSwapPartner
 * case 2, BattleFrontier_BattleFactoryLobby_EventScript_RulesSwapNumber
 * case 3, BattleFrontier_BattleFactoryLobby_EventScript_RulesSwapNotes
 * case 4, BattleFrontier_BattleFactoryLobby_EventScript_RulesOpenLv
 * case 5, BattleFrontier_BattleFactoryLobby_EventScript_ExitRules
 * case MULTI_B_PRESSED, BattleFrontier_BattleFactoryLobby_EventScript_ExitRules
 * end
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_ReadRulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleFactoryLobby_EventScript_ReadRulesBoard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special SavePlayerParty
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES, BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForSingleBattle
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_DOUBLES, BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForDoubleBattle
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES, BattleFrontier_BattleFactoryLobby_EventScript_TakeSinglesChallenge
 * call_if_eq VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_DOUBLES, BattleFrontier_BattleFactoryLobby_EventScript_TakeDoublesChallenge
 * waitmessage
 * multichoice 17, 6, MULTI_CHALLENGEINFO, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattleFactoryLobby_EventScript_TryEnterChallenge
 * case 1, BattleFrontier_BattleFactoryLobby_EventScript_ExplainChallenge
 * case 2, BattleFrontier_BattleFactoryLobby_EventScript_CancelChallenge
 * case MULTI_B_PRESSED, BattleFrontier_BattleFactoryLobby_EventScript_CancelChallenge
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleFactoryLobby_EventScript_Attendant")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_BattleFactoryLobby_Text_WelcomeForDoubleBattle, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForDoubleBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleFactoryLobby.WelcomeForDoubleBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message BattleFrontier_BattleFactoryLobby_Text_TakeSinglesChallenge
 * return
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_TakeSinglesChallenge : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleFactoryLobby.TakeSinglesChallenge)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message BattleFrontier_BattleFactoryLobby_Text_TakeDoublesChallenge
 * return
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_TakeDoublesChallenge : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleFactoryLobby.TakeDoublesChallenge)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_BattleFactoryLobby_Text_WelcomeForSingleBattle, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForSingleBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleFactoryLobby.WelcomeForSingleBattle)
  }
}

internal val BattleFrontier_BattleFactoryLobbyScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_BattleFactoryLobby_EventScript_SinglesAttendant" to
            BattleFrontier_BattleFactoryLobby_EventScript_SinglesAttendant,
        "BattleFrontier_BattleFactoryLobby_EventScript_Woman" to
            BattleFrontier_BattleFactoryLobby_EventScript_Woman,
        "BattleFrontier_BattleFactoryLobby_EventScript_Camper" to
            BattleFrontier_BattleFactoryLobby_EventScript_Camper,
        "BattleFrontier_BattleFactoryLobby_EventScript_Picnicker" to
            BattleFrontier_BattleFactoryLobby_EventScript_Picnicker,
        "BattleFrontier_BattleFactoryLobby_EventScript_FatMan" to
            BattleFrontier_BattleFactoryLobby_EventScript_FatMan,
        "BattleFrontier_BattleFactoryLobby_EventScript_DoublesAttendant" to
            BattleFrontier_BattleFactoryLobby_EventScript_DoublesAttendant,
        "BattleFrontier_BattleFactoryLobby_EventScript_ShowSinglesResults" to
            BattleFrontier_BattleFactoryLobby_EventScript_ShowSinglesResults,
        "BattleFrontier_BattleFactoryLobby_EventScript_ShowDoublesResults" to
            BattleFrontier_BattleFactoryLobby_EventScript_ShowDoublesResults,
        "BattleFrontier_BattleFactoryLobby_EventScript_RulesBoard" to
            BattleFrontier_BattleFactoryLobby_EventScript_RulesBoard,
        "BattleFrontier_BattleFactoryLobby_EventScript_ReadRulesBoard" to
            BattleFrontier_BattleFactoryLobby_EventScript_ReadRulesBoard,
        "BattleFrontier_BattleFactoryLobby_EventScript_Attendant" to
            BattleFrontier_BattleFactoryLobby_EventScript_Attendant,
        "BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForDoubleBattle" to
            BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForDoubleBattle,
        "BattleFrontier_BattleFactoryLobby_EventScript_TakeSinglesChallenge" to
            BattleFrontier_BattleFactoryLobby_EventScript_TakeSinglesChallenge,
        "BattleFrontier_BattleFactoryLobby_EventScript_TakeDoublesChallenge" to
            BattleFrontier_BattleFactoryLobby_EventScript_TakeDoublesChallenge,
        "BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForSingleBattle" to
            BattleFrontier_BattleFactoryLobby_EventScript_WelcomeForSingleBattle,
    )
