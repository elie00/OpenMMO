package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_ScottsHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TEMP_4, BattleFrontier_ScottsHouse_EventScript_GivenBerry
 * goto_if_set FLAG_TEMP_3, BattleFrontier_ScottsHouse_EventScript_GivenShield
 * goto_if_set FLAG_TEMP_2, BattleFrontier_ScottsHouse_EventScript_GivenBattlePoints
 * goto BattleFrontier_ScottsHouse_EventScript_CheckGiveItems
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_Scott : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_Scott")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_unset FLAG_SCOTT_GIVES_BATTLE_POINTS, BattleFrontier_ScottsHouse_EventScript_WelcomeToFrontier
 * goto_if_unset FLAG_COLLECTED_ALL_SILVER_SYMBOLS, BattleFrontier_ScottsHouse_EventScript_CheckSilverSymbols
 * goto_if_unset FLAG_COLLECTED_ALL_GOLD_SYMBOLS, BattleFrontier_ScottsHouse_EventScript_CheckGoldSymbols
 * goto BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_CheckGiveItems : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(HoennFlags.FLAG_SCOTT_GIVES_BATTLE_POINTS))
        return BattleFrontier_ScottsHouse_EventScript_WelcomeToFrontier.run(ctx)
    if (!ctx.isFlagSet(HoennFlags.FLAG_COLLECTED_ALL_SILVER_SYMBOLS))
        return BattleFrontier_ScottsHouse_EventScript_CheckSilverSymbols.run(ctx)
    if (!ctx.isFlagSet(HoennFlags.FLAG_COLLECTED_ALL_GOLD_SYMBOLS))
        return BattleFrontier_ScottsHouse_EventScript_CheckGoldSymbols.run(ctx)
    return BattleFrontier_ScottsHouse_EventScript_CheckGiveShield.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_SoGladIBroughtYouHere, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_GivenBerry : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.SoGladIBroughtYouHere)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_ExpectingToHearEvenGreaterThings, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_GivenShield : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.ExpectingToHearEvenGreaterThings)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_ExpectingGreatThings, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_GivenBattlePoints : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.ExpectingGreatThings)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_SYS_TOWER_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_DOME_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_PALACE_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_ARENA_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_FACTORY_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_PIKE_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_PYRAMID_SILVER, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * msgbox BattleFrontier_ScottsHouse_Text_YouveCollectedAllSilverSymbols, MSGBOX_DEFAULT
 * giveitem ITEM_LANSAT_BERRY
 * goto_if_eq VAR_RESULT, FALSE, BattleFrontier_ScottsHouse_EventScript_BerryPocketFull
 * setflag FLAG_COLLECTED_ALL_SILVER_SYMBOLS
 * setflag FLAG_TEMP_4
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_CheckSilverSymbols : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_CheckSilverSymbols")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_SYS_TOWER_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_DOME_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_PALACE_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_ARENA_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_FACTORY_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_PIKE_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * goto_if_unset FLAG_SYS_PYRAMID_GOLD, BattleFrontier_ScottsHouse_EventScript_CheckGiveShield
 * msgbox BattleFrontier_ScottsHouse_Text_YouveCollectedAllGoldSymbols, MSGBOX_DEFAULT
 * giveitem ITEM_STARF_BERRY
 * goto_if_eq VAR_RESULT, FALSE, BattleFrontier_ScottsHouse_EventScript_BerryPocketFull
 * setflag FLAG_COLLECTED_ALL_GOLD_SYMBOLS
 * setflag FLAG_TEMP_4
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_CheckGoldSymbols : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_CheckGoldSymbols")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_unset FLAG_RECEIVED_SILVER_SHIELD, BattleFrontier_ScottsHouse_EventScript_CheckGiveSilverShield
 * goto_if_unset FLAG_RECEIVED_GOLD_SHIELD, BattleFrontier_ScottsHouse_EventScript_CheckGiveGoldShield
 * goto BattleFrontier_ScottsHouse_EventScript_RandomComment
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_CheckGiveShield : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_SILVER_SHIELD))
        return BattleFrontier_ScottsHouse_EventScript_CheckGiveSilverShield.run(ctx)
    if (!ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_GOLD_SHIELD))
        return BattleFrontier_ScottsHouse_EventScript_CheckGiveGoldShield.run(ctx)
    return BattleFrontier_ScottsHouse_EventScript_RandomComment.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_WelcomeToBattleFrontier, MSGBOX_DEFAULT
 * closemessage
 * delay 30
 * call_if_eq VAR_FACING, DIR_NORTH, BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, BattleFrontier_ScottsHouse_EventScript_ScottFaceAwaySouth
 * call_if_eq VAR_FACING, DIR_EAST, BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayEast
 * call_if_eq VAR_FACING, DIR_WEST, BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayWest
 * msgbox BattleFrontier_ScottsHouse_Text_HowMuchEffortItTookToMakeReal, MSGBOX_DEFAULT
 * applymovement LOCALID_SCOTTS_HOUSE_SCOTT, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox BattleFrontier_ScottsHouse_Text_HaveThisAsMementoOfOurPathsCrossing, MSGBOX_DEFAULT
 * goto_if_eq VAR_SCOTT_STATE, 13, BattleFrontier_ScottsHouse_EventScript_Give4BattlePoints
 * goto_if_ge VAR_SCOTT_STATE, 9, BattleFrontier_ScottsHouse_EventScript_Give3BattlePoints
 * goto_if_ge VAR_SCOTT_STATE, 6, BattleFrontier_ScottsHouse_EventScript_Give2BattlePoints
 * goto BattleFrontier_ScottsHouse_EventScript_Give1BattlePoint
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_WelcomeToFrontier : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_WelcomeToFrontier")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, 1
 * setvar VAR_0x8004, 1
 * goto BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_Give1BattlePoint : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_Give1BattlePoint")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_BerryPocketStuffed, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_BerryPocketFull : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.BerryPocketStuffed)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SCOTTS_HOUSE_SCOTT, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_ScottFaceAwaySouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_ScottFaceAwaySouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, 2
 * setvar VAR_0x8004, 2
 * goto BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_Give2BattlePoints : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_Give2BattlePoints")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SCOTTS_HOUSE_SCOTT, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * random 3
 * goto_if_eq VAR_RESULT, 1, BattleFrontier_ScottsHouse_EventScript_FrontierBrainComment
 * goto_if_eq VAR_RESULT, 2, BattleFrontier_ScottsHouse_EventScript_ArtisanCaveComment
 * msgbox BattleFrontier_ScottsHouse_Text_WhyIGoSeekingTrainers, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_RandomComment : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_RandomComment")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SCOTTS_HOUSE_SCOTT, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, 4
 * setvar VAR_0x8004, 4
 * goto BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_Give4BattlePoints : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_Give4BattlePoints")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SCOTTS_HOUSE_SCOTT, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES
 * frontier_set FRONTIER_DATA_LVL_MODE, FRONTIER_LVL_50
 * tower_get TOWER_DATA_WIN_STREAK
 * goto_if_ge VAR_RESULT, 100, BattleFrontier_ScottsHouse_EventScript_GiveGoldShield
 * frontier_set FRONTIER_DATA_LVL_MODE, FRONTIER_LVL_OPEN
 * tower_get TOWER_DATA_WIN_STREAK
 * goto_if_ge VAR_RESULT, 100, BattleFrontier_ScottsHouse_EventScript_GiveGoldShield
 * goto BattleFrontier_ScottsHouse_EventScript_RandomComment
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_CheckGiveGoldShield : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_CheckGiveGoldShield")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * buffernumberstring STR_VAR_1, 3
 * setvar VAR_0x8004, 3
 * goto BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_Give3BattlePoints : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_Give3BattlePoints")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_FRONTIER_BATTLE_MODE, FRONTIER_MODE_SINGLES
 * frontier_set FRONTIER_DATA_LVL_MODE, FRONTIER_LVL_50
 * tower_get TOWER_DATA_WIN_STREAK
 * goto_if_ge VAR_RESULT, 50, BattleFrontier_ScottsHouse_EventScript_GiveSilverShield
 * frontier_set FRONTIER_DATA_LVL_MODE, FRONTIER_LVL_OPEN
 * tower_get TOWER_DATA_WIN_STREAK
 * goto_if_ge VAR_RESULT, 50, BattleFrontier_ScottsHouse_EventScript_GiveSilverShield
 * goto BattleFrontier_ScottsHouse_EventScript_RandomComment
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_CheckGiveSilverShield : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_CheckGiveSilverShield")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GiveFrontierBattlePoints
 * msgbox BattleFrontier_ScottsHouse_Text_ObtainedXBattlePoints, MSGBOX_GETPOINTS
 * msgbox BattleFrontier_ScottsHouse_Text_ExplainBattlePoints, MSGBOX_DEFAULT
 * setflag FLAG_SCOTT_GIVES_BATTLE_POINTS
 * setflag FLAG_TEMP_2
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_Beat100TrainersInARow, MSGBOX_DEFAULT
 * givedecoration DECOR_GOLD_SHIELD
 * goto_if_eq VAR_RESULT, FALSE, BattleFrontier_ScottsHouse_EventScript_NoRoomForShield
 * setflag FLAG_RECEIVED_GOLD_SHIELD
 * setflag FLAG_TEMP_3
 * goto BattleFrontier_ScottsHouse_EventScript_GivenShield
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_GiveGoldShield : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_GiveGoldShield")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_HaveYouMetFrontierBrain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_FrontierBrainComment : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.HaveYouMetFrontierBrain)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_MayFindWildMonsInFrontier, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_ArtisanCaveComment : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.MayFindWildMonsInFrontier)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_Beat50TrainersInARow, MSGBOX_DEFAULT
 * givedecoration DECOR_SILVER_SHIELD
 * goto_if_eq VAR_RESULT, FALSE, BattleFrontier_ScottsHouse_EventScript_NoRoomForShield
 * setflag FLAG_RECEIVED_SILVER_SHIELD
 * setflag FLAG_TEMP_3
 * goto BattleFrontier_ScottsHouse_EventScript_GivenShield
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_GiveSilverShield : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ScottsHouse_EventScript_GiveSilverShield")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_ScottsHouse_Text_ComeBackForThisLater, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ScottsHouse_EventScript_NoRoomForShield : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ScottsHouse.ComeBackForThisLater)
  }
}

internal val BattleFrontier_ScottsHouseScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_ScottsHouse_EventScript_Scott" to
            BattleFrontier_ScottsHouse_EventScript_Scott,
        "BattleFrontier_ScottsHouse_EventScript_CheckGiveItems" to
            BattleFrontier_ScottsHouse_EventScript_CheckGiveItems,
        "BattleFrontier_ScottsHouse_EventScript_GivenBerry" to
            BattleFrontier_ScottsHouse_EventScript_GivenBerry,
        "BattleFrontier_ScottsHouse_EventScript_GivenShield" to
            BattleFrontier_ScottsHouse_EventScript_GivenShield,
        "BattleFrontier_ScottsHouse_EventScript_GivenBattlePoints" to
            BattleFrontier_ScottsHouse_EventScript_GivenBattlePoints,
        "BattleFrontier_ScottsHouse_EventScript_CheckSilverSymbols" to
            BattleFrontier_ScottsHouse_EventScript_CheckSilverSymbols,
        "BattleFrontier_ScottsHouse_EventScript_CheckGoldSymbols" to
            BattleFrontier_ScottsHouse_EventScript_CheckGoldSymbols,
        "BattleFrontier_ScottsHouse_EventScript_CheckGiveShield" to
            BattleFrontier_ScottsHouse_EventScript_CheckGiveShield,
        "BattleFrontier_ScottsHouse_EventScript_WelcomeToFrontier" to
            BattleFrontier_ScottsHouse_EventScript_WelcomeToFrontier,
        "BattleFrontier_ScottsHouse_EventScript_Give1BattlePoint" to
            BattleFrontier_ScottsHouse_EventScript_Give1BattlePoint,
        "BattleFrontier_ScottsHouse_EventScript_BerryPocketFull" to
            BattleFrontier_ScottsHouse_EventScript_BerryPocketFull,
        "BattleFrontier_ScottsHouse_EventScript_ScottFaceAwaySouth" to
            BattleFrontier_ScottsHouse_EventScript_ScottFaceAwaySouth,
        "BattleFrontier_ScottsHouse_EventScript_Give2BattlePoints" to
            BattleFrontier_ScottsHouse_EventScript_Give2BattlePoints,
        "BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayWest" to
            BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayWest,
        "BattleFrontier_ScottsHouse_EventScript_RandomComment" to
            BattleFrontier_ScottsHouse_EventScript_RandomComment,
        "BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayEast" to
            BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayEast,
        "BattleFrontier_ScottsHouse_EventScript_Give4BattlePoints" to
            BattleFrontier_ScottsHouse_EventScript_Give4BattlePoints,
        "BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayNorth" to
            BattleFrontier_ScottsHouse_EventScript_ScottFaceAwayNorth,
        "BattleFrontier_ScottsHouse_EventScript_CheckGiveGoldShield" to
            BattleFrontier_ScottsHouse_EventScript_CheckGiveGoldShield,
        "BattleFrontier_ScottsHouse_EventScript_Give3BattlePoints" to
            BattleFrontier_ScottsHouse_EventScript_Give3BattlePoints,
        "BattleFrontier_ScottsHouse_EventScript_CheckGiveSilverShield" to
            BattleFrontier_ScottsHouse_EventScript_CheckGiveSilverShield,
        "BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints" to
            BattleFrontier_ScottsHouse_EventScript_GiveBattlePoints,
        "BattleFrontier_ScottsHouse_EventScript_GiveGoldShield" to
            BattleFrontier_ScottsHouse_EventScript_GiveGoldShield,
        "BattleFrontier_ScottsHouse_EventScript_FrontierBrainComment" to
            BattleFrontier_ScottsHouse_EventScript_FrontierBrainComment,
        "BattleFrontier_ScottsHouse_EventScript_ArtisanCaveComment" to
            BattleFrontier_ScottsHouse_EventScript_ArtisanCaveComment,
        "BattleFrontier_ScottsHouse_EventScript_GiveSilverShield" to
            BattleFrontier_ScottsHouse_EventScript_GiveSilverShield,
        "BattleFrontier_ScottsHouse_EventScript_NoRoomForShield" to
            BattleFrontier_ScottsHouse_EventScript_NoRoomForShield,
    )
