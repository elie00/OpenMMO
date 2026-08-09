package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_BattleArenaLobby
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_FRONTIER_FACILITY, FRONTIER_FACILITY_ARENA
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES
 * special SavePlayerParty
 * msgbox BattleFrontier_BattleArenaLobby_Text_WelcomeToBattleArena, MSGBOX_DEFAULT
 * message BattleFrontier_BattleArenaLobby_Text_WishToTakeChallenge
 * waitmessage
 * multichoice 17, 6, MULTI_CHALLENGEINFO, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattleArenaLobby_EventScript_TryEnterChallenge
 * case 1, BattleFrontier_BattleArenaLobby_EventScript_ExplainChallenge
 * case 2, BattleFrontier_BattleArenaLobby_EventScript_CancelChallenge
 * case MULTI_B_PRESSED, BattleFrontier_BattleArenaLobby_EventScript_CancelChallenge
 * ```
 */
internal object BattleFrontier_BattleArenaLobby_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleArenaLobby_EventScript_Attendant")
}

internal object BattleFrontier_BattleArenaLobby_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleArenaLobby.OrderOfMonsImportant)
}

internal object BattleFrontier_BattleArenaLobby_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleArenaLobby.LandingHitsWorked)
}

internal object BattleFrontier_BattleArenaLobby_EventScript_Camper : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleArenaLobby.MatchWasDeclaredDraw)
}

internal object BattleFrontier_BattleArenaLobby_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattleArenaLobby.BadIdeaToNotAttack)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FRONTIER_FACILITY_ARENA
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattleArenaLobby_EventScript_ShowResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleArenaLobby_EventScript_ShowResults")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * msgbox BattleFrontier_BattleArenaLobby_Text_RulesAreListed, MSGBOX_DEFAULT
 * goto BattleFrontier_BattleArenaLobby_EventScript_ReadRulesBoard
 * end
 * ```
 */
internal object BattleFrontier_BattleArenaLobby_EventScript_RulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleArenaLobby.RulesAreListed)
    return BattleFrontier_BattleArenaLobby_EventScript_ReadRulesBoard.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_BattleArenaLobby_Text_ReadWhichHeading
 * waitmessage
 * multichoice 17, 2, MULTI_BATTLE_ARENA_RULES, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattleArenaLobby_EventScript_BattleRules
 * case 1, BattleFrontier_BattleArenaLobby_EventScript_MindRules
 * case 2, BattleFrontier_BattleArenaLobby_EventScript_SkillRules
 * case 3, BattleFrontier_BattleArenaLobby_EventScript_BodyRules
 * case 4, BattleFrontier_BattleArenaLobby_EventScript_ExitRules
 * case MULTI_B_PRESSED, BattleFrontier_BattleArenaLobby_EventScript_ExitRules
 * end
 * ```
 */
internal object BattleFrontier_BattleArenaLobby_EventScript_ReadRulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleArenaLobby_EventScript_ReadRulesBoard")
}

internal val BattleFrontier_BattleArenaLobbyScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_BattleArenaLobby_EventScript_Attendant" to
            BattleFrontier_BattleArenaLobby_EventScript_Attendant,
        "BattleFrontier_BattleArenaLobby_EventScript_Woman" to
            BattleFrontier_BattleArenaLobby_EventScript_Woman,
        "BattleFrontier_BattleArenaLobby_EventScript_Man" to
            BattleFrontier_BattleArenaLobby_EventScript_Man,
        "BattleFrontier_BattleArenaLobby_EventScript_Camper" to
            BattleFrontier_BattleArenaLobby_EventScript_Camper,
        "BattleFrontier_BattleArenaLobby_EventScript_Youngster" to
            BattleFrontier_BattleArenaLobby_EventScript_Youngster,
        "BattleFrontier_BattleArenaLobby_EventScript_ShowResults" to
            BattleFrontier_BattleArenaLobby_EventScript_ShowResults,
        "BattleFrontier_BattleArenaLobby_EventScript_RulesBoard" to
            BattleFrontier_BattleArenaLobby_EventScript_RulesBoard,
        "BattleFrontier_BattleArenaLobby_EventScript_ReadRulesBoard" to
            BattleFrontier_BattleArenaLobby_EventScript_ReadRulesBoard,
    )
