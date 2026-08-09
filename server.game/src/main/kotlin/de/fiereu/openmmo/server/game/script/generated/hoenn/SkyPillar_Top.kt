package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * waitse
 * playmoncry SPECIES_RAYQUAZA, CRY_MODE_ENCOUNTER
 * delay 40
 * waitmoncry
 * setwildbattle SPECIES_RAYQUAZA, 70
 * setflag FLAG_SYS_CTRL_OBJ_DELETE
 * special BattleSetup_StartLegendaryBattle
 * clearflag FLAG_SYS_CTRL_OBJ_DELETE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, SkyPillar_Top_EventScript_DefeatedRayquaza
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, SkyPillar_Top_EventScript_RanFromRayquaza
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, SkyPillar_Top_EventScript_RanFromRayquaza
 * setflag FLAG_DEFEATED_RAYQUAZA
 * releaseall
 * end
 * ```
 */
internal object SkyPillar_Top_EventScript_Rayquaza : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SkyPillar_Top_EventScript_Rayquaza")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DEFEATED_RAYQUAZA
 * goto SkyPillar_Top_EventScript_DefeatedRayquaza2
 * end
 * ```
 */
internal object SkyPillar_Top_EventScript_DefeatedRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_DEFEATED_RAYQUAZA)
    return SkyPillar_Top_EventScript_DefeatedRayquaza2.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SPECIES_RAYQUAZA
 * goto SkyPillar_Top_EventScript_RanFromRayquaza2
 * end
 * ```
 */
internal object SkyPillar_Top_EventScript_RanFromRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SkyPillar_Top_EventScript_RanFromRayquaza")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreenswapbuffers FADE_TO_BLACK
 * removeobject VAR_LAST_TALKED
 * fadescreenswapbuffers FADE_FROM_BLACK
 * releaseall
 * end
 * ```
 */
internal object SkyPillar_Top_EventScript_DefeatedRayquaza2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SkyPillar_Top_EventScript_DefeatedRayquaza2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreenswapbuffers FADE_TO_BLACK
 * removeobject VAR_LAST_TALKED
 * fadescreenswapbuffers FADE_FROM_BLACK
 * bufferspeciesname STR_VAR_1, VAR_0x8004
 * msgbox gText_LegendaryFlewAway, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SkyPillar_Top_EventScript_RanFromRayquaza2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SkyPillar_Top_EventScript_RanFromRayquaza2")
}

internal val SkyPillar_TopScripts: Map<String, Script> =
    mapOf(
        "SkyPillar_Top_EventScript_Rayquaza" to SkyPillar_Top_EventScript_Rayquaza,
        "SkyPillar_Top_EventScript_DefeatedRayquaza" to SkyPillar_Top_EventScript_DefeatedRayquaza,
        "SkyPillar_Top_EventScript_RanFromRayquaza" to SkyPillar_Top_EventScript_RanFromRayquaza,
        "SkyPillar_Top_EventScript_DefeatedRayquaza2" to
            SkyPillar_Top_EventScript_DefeatedRayquaza2,
        "SkyPillar_Top_EventScript_RanFromRayquaza2" to SkyPillar_Top_EventScript_RanFromRayquaza2,
    )
