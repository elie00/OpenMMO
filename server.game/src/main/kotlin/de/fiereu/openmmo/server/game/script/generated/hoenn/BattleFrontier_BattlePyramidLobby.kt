package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_BattlePyramidLobby
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_FRONTIER_FACILITY, FRONTIER_FACILITY_PYRAMID
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES
 * special SavePlayerParty
 * msgbox BattleFrontier_BattlePyramidLobby_Text_WelcomeToBattlePyramid, MSGBOX_DEFAULT
 * message BattleFrontier_BattlePyramidLobby_Text_EmbarkOnChallenge
 * waitmessage
 * multichoice 17, 6, MULTI_CHALLENGEINFO, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattlePyramidLobby_EventScript_TryEnterChallenge
 * case 1, BattleFrontier_BattlePyramidLobby_EventScript_ExplainChallenge
 * case 2, BattleFrontier_BattlePyramidLobby_EventScript_CancelChallenge
 * case MULTI_B_PRESSED, BattleFrontier_BattlePyramidLobby_EventScript_CancelChallenge
 * ```
 */
internal object BattleFrontier_BattlePyramidLobby_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePyramidLobby_EventScript_Attendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * applymovement LOCALID_PYRAMID_LOBBY_HINT_GIVER, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox BattleFrontier_BattlePyramidLobby_Text_TellYouWhatMisfortunesAwait, MSGBOX_DEFAULT
 * call BattleFrontier_BattlePyramidLobby_EventScript_GiveHint
 * msgbox BattleFrontier_BattlePyramidLobby_Text_BelieveMyFortunesOrNot, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattlePyramidLobby_EventScript_HintGiver : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePyramidLobby_EventScript_HintGiver")
}

internal object BattleFrontier_BattlePyramidLobby_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattlePyramidLobby.TrainersNoticeRunning)
}

internal object BattleFrontier_BattlePyramidLobby_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_BattlePyramidLobby.LostLotOfItems)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * frontier_results FRONTIER_FACILITY_PYRAMID
 * waitbuttonpress
 * special RemoveRecordsWindow
 * releaseall
 * end
 * ```
 */
internal object BattleFrontier_BattlePyramidLobby_EventScript_ShowResults : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePyramidLobby_EventScript_ShowResults")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * msgbox BattleFrontier_BattlePyramidLobby_Text_RulesAreListed, MSGBOX_DEFAULT
 * goto BattleFrontier_BattlePyramidLobby_EventScript_ReadRulesBoard
 * end
 * ```
 */
internal object BattleFrontier_BattlePyramidLobby_EventScript_RulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_BattlePyramidLobby.RulesAreListed)
    return BattleFrontier_BattlePyramidLobby_EventScript_ReadRulesBoard.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_BattlePyramidLobby_Text_ReadWhichHeading
 * waitmessage
 * multichoice 15, 2, MULTI_BATTLE_PYRAMID_RULES, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_BattlePyramidLobby_EventScript_RulesPokemon
 * case 1, BattleFrontier_BattlePyramidLobby_EventScript_RulesTrainers
 * case 2, BattleFrontier_BattlePyramidLobby_EventScript_RulesMaze
 * case 3, BattleFrontier_BattlePyramidLobby_EventScript_RulesBag
 * case 4, BattleFrontier_BattlePyramidLobby_EventScript_ExitRules
 * case MULTI_B_PRESSED, BattleFrontier_BattlePyramidLobby_EventScript_ExitRules
 * end
 * ```
 */
internal object BattleFrontier_BattlePyramidLobby_EventScript_ReadRulesBoard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePyramidLobby_EventScript_ReadRulesBoard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 17, 6, MULTI_LEVEL_MODE, FALSE
 * switch VAR_RESULT
 * case FRONTIER_LVL_50, BattleFrontier_BattlePyramidLobby_EventScript_GiveHintLv50
 * case FRONTIER_LVL_OPEN, BattleFrontier_BattlePyramidLobby_EventScript_GiveHintLvOpen
 * case FRONTIER_LVL_TENT, BattleFrontier_BattlePyramidLobby_EventScript_NoHint
 * case MULTI_B_PRESSED, BattleFrontier_BattlePyramidLobby_EventScript_NoHint
 * return
 * ```
 */
internal object BattleFrontier_BattlePyramidLobby_EventScript_GiveHint : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattlePyramidLobby_EventScript_GiveHint")
}

internal val BattleFrontier_BattlePyramidLobbyScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_BattlePyramidLobby_EventScript_Attendant" to
            BattleFrontier_BattlePyramidLobby_EventScript_Attendant,
        "BattleFrontier_BattlePyramidLobby_EventScript_HintGiver" to
            BattleFrontier_BattlePyramidLobby_EventScript_HintGiver,
        "BattleFrontier_BattlePyramidLobby_EventScript_Woman" to
            BattleFrontier_BattlePyramidLobby_EventScript_Woman,
        "BattleFrontier_BattlePyramidLobby_EventScript_FatMan" to
            BattleFrontier_BattlePyramidLobby_EventScript_FatMan,
        "BattleFrontier_BattlePyramidLobby_EventScript_ShowResults" to
            BattleFrontier_BattlePyramidLobby_EventScript_ShowResults,
        "BattleFrontier_BattlePyramidLobby_EventScript_RulesBoard" to
            BattleFrontier_BattlePyramidLobby_EventScript_RulesBoard,
        "BattleFrontier_BattlePyramidLobby_EventScript_ReadRulesBoard" to
            BattleFrontier_BattlePyramidLobby_EventScript_ReadRulesBoard,
        "BattleFrontier_BattlePyramidLobby_EventScript_GiveHint" to
            BattleFrontier_BattlePyramidLobby_EventScript_GiveHint,
    )
