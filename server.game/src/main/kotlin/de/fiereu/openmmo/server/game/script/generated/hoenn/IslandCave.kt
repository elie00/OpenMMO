package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_REGICE, CRY_MODE_ENCOUNTER
 * delay 40
 * waitmoncry
 * setwildbattle SPECIES_REGICE, 40
 * setflag FLAG_SYS_CTRL_OBJ_DELETE
 * special StartRegiBattle
 * clearflag FLAG_SYS_CTRL_OBJ_DELETE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, IslandCave_EventScript_DefeatedRegice
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, IslandCave_EventScript_RanFromRegice
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, IslandCave_EventScript_RanFromRegice
 * setflag FLAG_DEFEATED_REGICE
 * release
 * end
 * ```
 */
internal object IslandCave_EventScript_Regice : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port IslandCave_EventScript_Regice")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * call_if_set FLAG_TEMP_REGICE_PUZZLE_FAILED, IslandCave_EventScript_ClearSteps
 * goto_if_set FLAG_SYS_BRAILLE_REGICE_COMPLETED, IslandCave_EventScript_BigHoleInWall
 * braillemessage IslandCave_Braille_RunLapAroundWall
 * setflag FLAG_TEMP_REGICE_PUZZLE_STARTED
 * special ShouldDoBrailleRegicePuzzle
 * goto IslandCave_EventScript_CloseBrailleMsg
 * end
 * ```
 */
internal object IslandCave_EventScript_CaveEntranceMiddle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port IslandCave_EventScript_CaveEntranceMiddle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * call_if_set FLAG_TEMP_REGICE_PUZZLE_FAILED, IslandCave_EventScript_ClearSteps
 * braillemessage IslandCave_Braille_RunLapAroundWall
 * goto_if_set FLAG_SYS_BRAILLE_REGICE_COMPLETED, IslandCave_EventScript_CloseBrailleMsg
 * setflag FLAG_TEMP_REGICE_PUZZLE_STARTED
 * special ShouldDoBrailleRegicePuzzle
 * goto IslandCave_EventScript_CloseBrailleMsg
 * end
 * ```
 */
internal object IslandCave_EventScript_CaveEntranceSide : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port IslandCave_EventScript_CaveEntranceSide")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_REGICE_STEPS_1, 0
 * setvar VAR_REGICE_STEPS_2, 0
 * setvar VAR_REGICE_STEPS_3, 0
 * clearflag FLAG_TEMP_REGICE_PUZZLE_FAILED
 * return
 * ```
 */
internal object IslandCave_EventScript_ClearSteps : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port IslandCave_EventScript_ClearSteps")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * waitbuttonpress
 * closebraillemessage
 * releaseall
 * end
 * ```
 */
internal object IslandCave_EventScript_CloseBrailleMsg : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port IslandCave_EventScript_CloseBrailleMsg")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox gText_BigHoleInTheWall, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object IslandCave_EventScript_BigHoleInWall : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port IslandCave_EventScript_BigHoleInWall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_DEFEATED_REGICE
 * goto Common_EventScript_RemoveStaticPokemon
 * end
 * ```
 */
internal object IslandCave_EventScript_DefeatedRegice : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port IslandCave_EventScript_DefeatedRegice")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SPECIES_REGICE
 * goto Common_EventScript_LegendaryFlewAway
 * end
 * ```
 */
internal object IslandCave_EventScript_RanFromRegice : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port IslandCave_EventScript_RanFromRegice")
}

internal val IslandCaveScripts: Map<String, Script> =
    mapOf(
        "IslandCave_EventScript_Regice" to IslandCave_EventScript_Regice,
        "IslandCave_EventScript_CaveEntranceMiddle" to IslandCave_EventScript_CaveEntranceMiddle,
        "IslandCave_EventScript_CaveEntranceSide" to IslandCave_EventScript_CaveEntranceSide,
        "IslandCave_EventScript_ClearSteps" to IslandCave_EventScript_ClearSteps,
        "IslandCave_EventScript_CloseBrailleMsg" to IslandCave_EventScript_CloseBrailleMsg,
        "IslandCave_EventScript_BigHoleInWall" to IslandCave_EventScript_BigHoleInWall,
        "IslandCave_EventScript_DefeatedRegice" to IslandCave_EventScript_DefeatedRegice,
        "IslandCave_EventScript_RanFromRegice" to IslandCave_EventScript_RanFromRegice,
    )
