package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SouthernIsland_Interior
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8008, 12  @ Player's Y coordinate. Not read
 * goto SouthernIsland_Interior_EventScript_Lati
 * end
 * ```
 */
internal object SouthernIsland_Interior_EventScript_TryLatiEncounter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SouthernIsland_Interior_EventScript_TryLatiEncounter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_TEMP_2, SouthernIsland_Interior_EventScript_Sign
 * goto_if_set FLAG_DEFEATED_LATIAS_OR_LATIOS, SouthernIsland_Interior_EventScript_Sign
 * goto_if_set FLAG_CAUGHT_LATIAS_OR_LATIOS, SouthernIsland_Interior_EventScript_Sign
 * goto_if_unset FLAG_ENABLE_SHIP_SOUTHERN_ISLAND, SouthernIsland_Interior_EventScript_Sign
 * setflag FLAG_ENCOUNTERED_LATIAS_OR_LATIOS
 * setflag FLAG_TEMP_2
 * special SpawnCameraObject
 * applymovement LOCALID_CAMERA, SouthernIsland_Interior_Movement_CameraPanUp
 * waitmovement 0
 * delay 50
 * waitse
 * playmoncry VAR_TEMP_4, CRY_MODE_NORMAL
 * delay 30
 * waitmoncry
 * addobject LOCALID_SOUTHERN_ISLAND_LATI
 * delay 30
 * applymovement LOCALID_CAMERA, SouthernIsland_Interior_Movement_CameraPanDown
 * applymovement LOCALID_SOUTHERN_ISLAND_LATI, SouthernIsland_Interior_Movement_LatiApproach
 * waitmovement 0
 * delay 50
 * special RemoveCameraObject
 * setvar VAR_LAST_TALKED, LOCALID_SOUTHERN_ISLAND_LATI
 * call_if_eq VAR_ROAMER_POKEMON, 0, SouthernIsland_Interior_EventScript_SetLatiosBattleVars
 * call_if_ne VAR_ROAMER_POKEMON, 0, SouthernIsland_Interior_EventScript_SetLatiasBattleVars
 * setflag FLAG_SYS_CTRL_OBJ_DELETE
 * special BattleSetup_StartLatiBattle
 * clearflag FLAG_SYS_CTRL_OBJ_DELETE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, SouthernIsland_Interior_EventScript_LatiDefeated
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, SouthernIsland_Interior_EventScript_RanFromLati
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, SouthernIsland_Interior_EventScript_RanFromLati
 * setflag FLAG_CAUGHT_LATIAS_OR_LATIOS
 * releaseall
 * end
 * ```
 */
internal object SouthernIsland_Interior_EventScript_Lati : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SouthernIsland_Interior_EventScript_Lati")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SouthernIsland_Interior_Text_Sign, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SouthernIsland_Interior_EventScript_Sign : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SouthernIsland_Interior.Sign)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_DEFEATED_LATIAS_OR_LATIOS
 * copyvar VAR_0x8004, VAR_TEMP_4
 * goto Common_EventScript_LegendaryFlewAway
 * end
 * ```
 */
internal object SouthernIsland_Interior_EventScript_LatiDefeated : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SouthernIsland_Interior_EventScript_LatiDefeated")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * seteventmon SPECIES_LATIOS, 50, ITEM_SOUL_DEW
 * return
 * ```
 */
internal object SouthernIsland_Interior_EventScript_SetLatiosBattleVars : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SouthernIsland_Interior_EventScript_SetLatiosBattleVars")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * seteventmon SPECIES_LATIAS, 50, ITEM_SOUL_DEW
 * return
 * ```
 */
internal object SouthernIsland_Interior_EventScript_SetLatiasBattleVars : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SouthernIsland_Interior_EventScript_SetLatiasBattleVars")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_0x8004, VAR_TEMP_4
 * goto Common_EventScript_LegendaryFlewAway
 * end
 * ```
 */
internal object SouthernIsland_Interior_EventScript_RanFromLati : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SouthernIsland_Interior_EventScript_RanFromLati")
}

internal val SouthernIsland_InteriorScripts: Map<String, Script> =
    mapOf(
        "SouthernIsland_Interior_EventScript_TryLatiEncounter" to
            SouthernIsland_Interior_EventScript_TryLatiEncounter,
        "SouthernIsland_Interior_EventScript_Lati" to SouthernIsland_Interior_EventScript_Lati,
        "SouthernIsland_Interior_EventScript_Sign" to SouthernIsland_Interior_EventScript_Sign,
        "SouthernIsland_Interior_EventScript_LatiDefeated" to
            SouthernIsland_Interior_EventScript_LatiDefeated,
        "SouthernIsland_Interior_EventScript_SetLatiosBattleVars" to
            SouthernIsland_Interior_EventScript_SetLatiosBattleVars,
        "SouthernIsland_Interior_EventScript_SetLatiasBattleVars" to
            SouthernIsland_Interior_EventScript_SetLatiasBattleVars,
        "SouthernIsland_Interior_EventScript_RanFromLati" to
            SouthernIsland_Interior_EventScript_RanFromLati,
    )
