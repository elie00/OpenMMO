package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_WaterPath_House1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * setvar VAR_0x8004, SPECIES_HERACROSS
 * specialvar VAR_RESULT, DoesPlayerPartyContainSpecies
 * goto_if_eq VAR_RESULT, FALSE, SixIsland_WaterPath_House1_EventScript_NoHeracrossInParty
 * special GetHeracrossSizeRecordInfo
 * msgbox SixIsland_WaterPath_House1_Text_MayIMeasureHeracross
 * special ChoosePartyMon
 * waitstate
 * copyvar VAR_RESULT, VAR_0x8004
 * goto_if_ge VAR_RESULT, PARTY_SIZE, SixIsland_WaterPath_House1_EventScript_DontShowMon
 * special CompareHeracrossSize
 * goto_if_eq VAR_RESULT, 1, SixIsland_WaterPath_House1_EventScript_ShownNonHeracross
 * goto_if_eq VAR_RESULT, 2, SixIsland_WaterPath_House1_EventScript_ShownSmallHeracross
 * goto_if_eq VAR_RESULT, 3, SixIsland_WaterPath_House1_EventScript_ShownBigHeracross
 * goto_if_eq VAR_RESULT, 4, SixIsland_WaterPath_House1_EventScript_ShownTiedHeracross
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_Beauty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_WaterPath_House1_EventScript_Beauty")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1, SixIsland_WaterPath_House1_EventScript_SizeRecordNonEmpty
 * msgbox SixIsland_WaterPath_House1_Text_BlankChartOfSomeSort
 * releaseall
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_SizeRecord : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1))
        return SixIsland_WaterPath_House1_EventScript_SizeRecordNonEmpty.run(ctx)
    ctx.say(SixIsland_WaterPath_House1.BlankChartOfSomeSort)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetHeracrossSizeRecordInfo
 * msgbox SixIsland_WaterPath_House1_Text_BiggestHeracrossIsXInches
 * releaseall
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_SizeRecordNonEmpty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_WaterPath_House1_EventScript_SizeRecordNonEmpty")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_unset FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1, SixIsland_WaterPath_House1_EventScript_ShownBigHeracross
 * msgbox SixIsland_WaterPath_House1_Text_ItsXInchesYInchesWasBiggest
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_ShownSmallHeracross : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1))
        return SixIsland_WaterPath_House1_EventScript_ShownBigHeracross.run(ctx)
    ctx.say(SixIsland_WaterPath_House1.ItsXInchesYInchesWasBiggest)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1
 * msgbox SixIsland_WaterPath_House1_Text_ItsXInchesDeserveReward
 * giveitem ITEM_NEST_BALL
 * goto_if_eq VAR_RESULT, FALSE, SixIsland_WaterPath_House1_EventScript_NoRoomForNestBall
 * msgbox SixIsland_WaterPath_House1_Text_WantToSeeBiggerOne
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_ShownBigHeracross : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_WaterPath_House1_EventScript_ShownBigHeracross")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SixIsland_WaterPath_House1_Text_ThisWontDo
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_ShownNonHeracross : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SixIsland_WaterPath_House1.ThisWontDo)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_unset FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1, SixIsland_WaterPath_House1_EventScript_ShownBigHeracross
 * msgbox SixIsland_WaterPath_House1_Text_ItsXInchesSameAsBefore
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_ShownTiedHeracross : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_NEST_BALL_FROM_WATER_PATH_HOUSE_1))
        return SixIsland_WaterPath_House1_EventScript_ShownBigHeracross.run(ctx)
    ctx.say(SixIsland_WaterPath_House1.ItsXInchesSameAsBefore)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_DontShowMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_WaterPath_House1_EventScript_DontShowMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SixIsland_WaterPath_House1_Text_LoveItNeedItHeracross
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_NoHeracrossInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SixIsland_WaterPath_House1.LoveItNeedItHeracross)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SixIsland_WaterPath_House1_Text_YourBagIsFull
 * release
 * end
 * ```
 */
internal object SixIsland_WaterPath_House1_EventScript_NoRoomForNestBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SixIsland_WaterPath_House1.YourBagIsFull)
  }
}

internal val SixIsland_WaterPath_House1Scripts: Map<String, Script> =
    mapOf(
        "SixIsland_WaterPath_House1_EventScript_Beauty" to
            SixIsland_WaterPath_House1_EventScript_Beauty,
        "SixIsland_WaterPath_House1_EventScript_SizeRecord" to
            SixIsland_WaterPath_House1_EventScript_SizeRecord,
        "SixIsland_WaterPath_House1_EventScript_SizeRecordNonEmpty" to
            SixIsland_WaterPath_House1_EventScript_SizeRecordNonEmpty,
        "SixIsland_WaterPath_House1_EventScript_ShownSmallHeracross" to
            SixIsland_WaterPath_House1_EventScript_ShownSmallHeracross,
        "SixIsland_WaterPath_House1_EventScript_ShownBigHeracross" to
            SixIsland_WaterPath_House1_EventScript_ShownBigHeracross,
        "SixIsland_WaterPath_House1_EventScript_ShownNonHeracross" to
            SixIsland_WaterPath_House1_EventScript_ShownNonHeracross,
        "SixIsland_WaterPath_House1_EventScript_ShownTiedHeracross" to
            SixIsland_WaterPath_House1_EventScript_ShownTiedHeracross,
        "SixIsland_WaterPath_House1_EventScript_DontShowMon" to
            SixIsland_WaterPath_House1_EventScript_DontShowMon,
        "SixIsland_WaterPath_House1_EventScript_NoHeracrossInParty" to
            SixIsland_WaterPath_House1_EventScript_NoHeracrossInParty,
        "SixIsland_WaterPath_House1_EventScript_NoRoomForNestBall" to
            SixIsland_WaterPath_House1_EventScript_NoRoomForNestBall,
    )
