package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ULTRA_BALL
 * end
 * ```
 */
internal object CeruleanCave_B1F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ULTRA_BALL, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_B1F_ULTRA_BALL, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_REVIVE
 * end
 * ```
 */
internal object CeruleanCave_B1F_EventScript_ItemMaxRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_REVIVE, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_B1F_MAX_REVIVE, 1)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_MEWTWO, CRY_MODE_ENCOUNTER
 * message CeruleanCave_B1F_Text_Mew
 * waitmessage
 * waitmoncry
 * delay 20
 * playbgm MUS_ENCOUNTER_GYM_LEADER, 0
 * waitbuttonpress
 * setwildbattle SPECIES_MEWTWO, 70
 * setflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * special StartLegendaryBattle
 * waitstate
 * clearflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, CeruleanCave_B1F_EventScript_DefeatedMewtwo
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, CeruleanCave_B1F_EventScript_RanFromMewtwo
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, CeruleanCave_B1F_EventScript_RanFromMewtwo
 * setflag FLAG_FOUGHT_MEWTWO
 * release
 * end
 * ```
 */
internal object CeruleanCave_B1F_EventScript_Mewtwo : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCave_B1F_EventScript_Mewtwo")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_FOUGHT_MEWTWO
 * goto EventScript_RemoveStaticMon
 * end
 * ```
 */
internal object CeruleanCave_B1F_EventScript_DefeatedMewtwo : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_FOUGHT_MEWTWO)
    return EventScript_RemoveStaticMon.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SPECIES_MEWTWO
 * goto EventScript_MonFlewAway
 * end
 * ```
 */
internal object CeruleanCave_B1F_EventScript_RanFromMewtwo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCave_B1F_EventScript_RanFromMewtwo")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreen FADE_TO_BLACK
 * removeobject VAR_LAST_TALKED
 * fadescreen FADE_FROM_BLACK
 * release
 * end
 * ```
 */
internal object EventScript_RemoveStaticMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RemoveStaticMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreen FADE_TO_BLACK
 * removeobject VAR_LAST_TALKED
 * fadescreen FADE_FROM_BLACK
 * bufferspeciesname STR_VAR_1, VAR_0x8004
 * msgbox Text_MonFlewAway
 * release
 * end
 * ```
 */
internal object EventScript_MonFlewAway : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MonFlewAway")
}

internal val CeruleanCave_B1FScripts: Map<String, Script> =
    mapOf(
        "CeruleanCave_B1F_EventScript_ItemUltraBall" to CeruleanCave_B1F_EventScript_ItemUltraBall,
        "CeruleanCave_B1F_EventScript_ItemMaxRevive" to CeruleanCave_B1F_EventScript_ItemMaxRevive,
        "CeruleanCave_B1F_EventScript_Mewtwo" to CeruleanCave_B1F_EventScript_Mewtwo,
        "CeruleanCave_B1F_EventScript_DefeatedMewtwo" to
            CeruleanCave_B1F_EventScript_DefeatedMewtwo,
        "CeruleanCave_B1F_EventScript_RanFromMewtwo" to CeruleanCave_B1F_EventScript_RanFromMewtwo,
        "EventScript_RemoveStaticMon" to EventScript_RemoveStaticMon,
        "EventScript_MonFlewAway" to EventScript_MonFlewAway,
    )
