package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_BattleArenaLobby
import de.fiereu.openmmo.dialog.generated.hoenn.FallarborTown_BattleTentLobby
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * fallarbortent_getprize
 * goto_if_ne VAR_RESULT, ITEM_NONE, FallarborTown_BattleTentLobby_EventScript_PrizeWaiting
 * special SavePlayerParty
 * msgbox FallarborTown_BattleTentLobby_Text_WelcomeToBattleTent, MSGBOX_DEFAULT
 * message FallarborTown_BattleTentLobby_Text_TakeChallenge
 * waitmessage
 * multichoice 17, 6, MULTI_CHALLENGEINFO, FALSE
 * switch VAR_RESULT
 * case 0, FallarborTown_BattleTentLobby_EventScript_TryEnterChallenge
 * case 1, FallarborTown_BattleTentLobby_EventScript_ExplainChallenge
 * case 2, FallarborTown_BattleTentLobby_EventScript_CancelChallenge
 * case MULTI_B_PRESSED, FallarborTown_BattleTentLobby_EventScript_CancelChallenge
 * ```
 */
internal object FallarborTown_BattleTentLobby_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_BattleTentLobby_EventScript_Attendant")
}

internal object FallarborTown_BattleTentLobby_EventScript_Hiker : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(FallarborTown_BattleTentLobby.CameToCampOut)
}

internal object FallarborTown_BattleTentLobby_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(FallarborTown_BattleTentLobby.MakeThinkImJustKid)
}

internal object FallarborTown_BattleTentLobby_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(FallarborTown_BattleTentLobby.FallarborTentMyFavorite)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MET_SCOTT_IN_FALLARBOR, FallarborTown_BattleTentLobby_EventScript_ScottAlreadySpokenTo
 * msgbox FallarborTown_BattleTentLobby_Text_ScottLookingForSomeone, MSGBOX_DEFAULT
 * addvar VAR_SCOTT_STATE, 1
 * setflag FLAG_MET_SCOTT_IN_FALLARBOR
 * release
 * end
 * ```
 */
internal object FallarborTown_BattleTentLobby_EventScript_Scott : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_BattleTentLobby_EventScript_Scott")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * msgbox BattleFrontier_BattleArenaLobby_Text_RulesAreListed, MSGBOX_DEFAULT
 * goto FallarborTown_BattleTentLobby_EventScript_ReadRulesBoard
 * end
 * ```
 */
internal object FallarborTown_BattleTentLobby_EventScript_RulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattleArenaLobby.RulesAreListed)
    return FallarborTown_BattleTentLobby_EventScript_ReadRulesBoard.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_BattleArenaLobby_Text_ReadWhichHeading
 * waitmessage
 * multichoice 17, 0, MULTI_FALLARBOR_TENT_RULES, FALSE
 * switch VAR_RESULT
 * case 0, FallarborTown_BattleTentLobby_EventScript_RulesLevel
 * case 1, FallarborTown_BattleTentLobby_EventScript_RulesBattle
 * case 2, FallarborTown_BattleTentLobby_EventScript_RulesMind
 * case 3, FallarborTown_BattleTentLobby_EventScript_RulesSkill
 * case 4, FallarborTown_BattleTentLobby_EventScript_RulesBody
 * case 5, FallarborTown_BattleTentLobby_EventScript_ExitRules
 * case MULTI_B_PRESSED, FallarborTown_BattleTentLobby_EventScript_ExitRules
 * end
 * ```
 */
internal object FallarborTown_BattleTentLobby_EventScript_ReadRulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_BattleTentLobby_EventScript_ReadRulesBoard")
}

internal val FallarborTown_BattleTentLobbyScripts: Map<String, Script> =
    mapOf(
        "FallarborTown_BattleTentLobby_EventScript_Attendant" to
            FallarborTown_BattleTentLobby_EventScript_Attendant,
        "FallarborTown_BattleTentLobby_EventScript_Hiker" to
            FallarborTown_BattleTentLobby_EventScript_Hiker,
        "FallarborTown_BattleTentLobby_EventScript_LittleBoy" to
            FallarborTown_BattleTentLobby_EventScript_LittleBoy,
        "FallarborTown_BattleTentLobby_EventScript_Lass" to
            FallarborTown_BattleTentLobby_EventScript_Lass,
        "FallarborTown_BattleTentLobby_EventScript_Scott" to
            FallarborTown_BattleTentLobby_EventScript_Scott,
        "FallarborTown_BattleTentLobby_EventScript_RulesBoard" to
            FallarborTown_BattleTentLobby_EventScript_RulesBoard,
        "FallarborTown_BattleTentLobby_EventScript_ReadRulesBoard" to
            FallarborTown_BattleTentLobby_EventScript_ReadRulesBoard,
    )
