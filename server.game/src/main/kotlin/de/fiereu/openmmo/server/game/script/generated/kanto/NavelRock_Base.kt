package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * waitse
 * delay 20
 * playse SE_THUNDERSTORM_STOP
 * setvar VAR_0x8004, 0  @ Vertical pan
 * setvar VAR_0x8005, 3  @ Horizontal pan
 * setvar VAR_0x8006, 4  @ Num shakes
 * setvar VAR_0x8007, 2  @ Shake delay
 * special ShakeScreen
 * delay 30
 * playse SE_THUNDERSTORM_STOP
 * setvar VAR_0x8004, 0  @ Vertical pan
 * setvar VAR_0x8005, 3  @ Horizontal pan
 * setvar VAR_0x8006, 4  @ Num shakes
 * setvar VAR_0x8007, 2  @ Shake delay
 * special ShakeScreen
 * delay 30
 * delay 50
 * waitse
 * playmoncry SPECIES_LUGIA, CRY_MODE_ENCOUNTER
 * waitmoncry
 * delay 20
 * seteventmon SPECIES_LUGIA, 70
 * setflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * special StartLegendaryBattle
 * waitstate
 * clearflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, NavelRock_Base_EventScript_DefeatedLugia
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, NavelRock_Base_EventScript_RanFromLugia
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, NavelRock_Base_EventScript_RanFromLugia
 * setflag FLAG_FOUGHT_LUGIA
 * release
 * end
 * ```
 */
internal object NavelRock_Base_EventScript_Lugia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port NavelRock_Base_EventScript_Lugia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SPECIES_LUGIA
 * goto EventScript_MonFlewAway
 * end
 * ```
 */
internal object NavelRock_Base_EventScript_RanFromLugia : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port NavelRock_Base_EventScript_RanFromLugia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_LUGIA_FLEW_AWAY
 * setvar VAR_0x8004, SPECIES_LUGIA
 * goto EventScript_MonFlewAway
 * end
 * ```
 */
internal object NavelRock_Base_EventScript_DefeatedLugia : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port NavelRock_Base_EventScript_DefeatedLugia")
}

internal val NavelRock_BaseScripts: Map<String, Script> =
    mapOf(
        "NavelRock_Base_EventScript_Lugia" to NavelRock_Base_EventScript_Lugia,
        "NavelRock_Base_EventScript_RanFromLugia" to NavelRock_Base_EventScript_RanFromLugia,
        "NavelRock_Base_EventScript_DefeatedLugia" to NavelRock_Base_EventScript_DefeatedLugia,
    )
