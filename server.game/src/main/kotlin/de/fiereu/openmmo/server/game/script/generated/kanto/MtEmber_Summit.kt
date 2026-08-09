package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * setwildbattle SPECIES_MOLTRES, 50
 * waitse
 * playmoncry SPECIES_MOLTRES, CRY_MODE_ENCOUNTER
 * message Text_Gyaoo
 * waitmessage
 * waitmoncry
 * delay 10
 * playbgm MUS_ENCOUNTER_GYM_LEADER, 0
 * waitbuttonpress
 * setflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * special StartLegendaryBattle
 * waitstate
 * clearflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, MtEmber_Summit_EventScript_DefeatedMoltres
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, MtEmber_Summit_EventScript_RanFromMoltres
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, MtEmber_Summit_EventScript_RanFromMoltres
 * setflag FLAG_FOUGHT_MOLTRES
 * release
 * end
 * ```
 */
internal object MtEmber_Summit_EventScript_Moltres : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtEmber_Summit_EventScript_Moltres")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_FOUGHT_MOLTRES
 * goto EventScript_RemoveStaticMon
 * end
 * ```
 */
internal object MtEmber_Summit_EventScript_DefeatedMoltres : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_FOUGHT_MOLTRES)
    return EventScript_RemoveStaticMon.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SPECIES_MOLTRES
 * goto EventScript_MonFlewAway
 * end
 * ```
 */
internal object MtEmber_Summit_EventScript_RanFromMoltres : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MtEmber_Summit_EventScript_RanFromMoltres")
}

internal val MtEmber_SummitScripts: Map<String, Script> =
    mapOf(
        "MtEmber_Summit_EventScript_Moltres" to MtEmber_Summit_EventScript_Moltres,
        "MtEmber_Summit_EventScript_DefeatedMoltres" to MtEmber_Summit_EventScript_DefeatedMoltres,
        "MtEmber_Summit_EventScript_RanFromMoltres" to MtEmber_Summit_EventScript_RanFromMoltres,
    )
