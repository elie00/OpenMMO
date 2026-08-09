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
    )
