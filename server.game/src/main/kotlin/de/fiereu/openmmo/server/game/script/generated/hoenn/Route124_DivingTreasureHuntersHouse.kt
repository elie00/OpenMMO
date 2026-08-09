package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route124_DivingTreasureHuntersHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MET_DIVING_TREASURE_HUNTER, Route124_DivingTreasureHuntersHouse_EventScript_SkipGreeting
 * msgbox Route124_DivingTreasureHuntersHouse_Text_Greeting, MSGBOX_DEFAULT
 * setflag FLAG_MET_DIVING_TREASURE_HUNTER
 * goto Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_TreasureHunter : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_MET_DIVING_TREASURE_HUNTER))
        return Route124_DivingTreasureHuntersHouse_EventScript_SkipGreeting.run(ctx)
    ctx.say(Route124_DivingTreasureHuntersHouse.Greeting)
    ctx.setFlag(HoennFlags.FLAG_MET_DIVING_TREASURE_HUNTER)
    return Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route124_DivingTreasureHuntersHouse_Text_ShardTradeBoard, MSGBOX_SIGN
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_ShardTradeBoard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.sign(Route124_DivingTreasureHuntersHouse.ShardTradeBoard)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route124_DivingTreasureHuntersHouse_Text_HaveYouSeenAnyShards, MSGBOX_DEFAULT
 * goto Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_SkipGreeting : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route124_DivingTreasureHuntersHouse.HaveYouSeenAnyShards)
    return Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call Route124_DivingTreasureHuntersHouse_EventScript_GetPlayersShards
 * goto_if_eq VAR_TEMP_1, 0, Route124_DivingTreasureHuntersHouse_EventScript_NoShards
 * goto Route124_DivingTreasureHuntersHouse_EventScript_HasShard
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, 0
 * checkitem ITEM_RED_SHARD
 * call_if_eq VAR_RESULT, TRUE, Route124_DivingTreasureHuntersHouse_EventScript_HasRedShard
 * checkitem ITEM_YELLOW_SHARD
 * call_if_eq VAR_RESULT, TRUE, Route124_DivingTreasureHuntersHouse_EventScript_HasYellowShard
 * checkitem ITEM_BLUE_SHARD
 * call_if_eq VAR_RESULT, TRUE, Route124_DivingTreasureHuntersHouse_EventScript_HasBlueShard
 * checkitem ITEM_GREEN_SHARD
 * call_if_eq VAR_RESULT, TRUE, Route124_DivingTreasureHuntersHouse_EventScript_HasGreenShard
 * return
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_GetPlayersShards : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_GetPlayersShards")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route124_DivingTreasureHuntersHouse_Text_YouHaventGotAnyShards, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_NoShards : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route124_DivingTreasureHuntersHouse.YouHaventGotAnyShards)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route124_DivingTreasureHuntersHouse_Text_ThatsAShardIllTradeYou, MSGBOX_DEFAULT
 * goto Route124_DivingTreasureHuntersHouse_EventScript_ShowTradeOptions
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_HasShard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route124_DivingTreasureHuntersHouse.ThatsAShardIllTradeYou)
    return Route124_DivingTreasureHuntersHouse_EventScript_ShowTradeOptions.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Route124_DivingTreasureHuntersHouse_Text_WhatDoYouWantToTrade
 * waitmessage
 * switch VAR_TEMP_1
 * case 1,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsR
 * case 2,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsY
 * case 3,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRY
 * case 4,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsB
 * case 5,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRB
 * case 6,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsYB
 * case 7,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRYB
 * case 8,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsG
 * case 9,  Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRG
 * case 10, Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsYG
 * case 11, Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRYG
 * case 12, Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsBG
 * case 13, Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRBG
 * case 14, Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsYBG
 * case 15, Route124_DivingTreasureHuntersHouse_EventScript_ShardOptionsRYBG
 * end
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_ShowTradeOptions : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_ShowTradeOptions")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 2
 * return
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_HasYellowShard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_HasYellowShard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 4
 * return
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_HasBlueShard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_HasBlueShard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 8
 * return
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_HasGreenShard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_HasGreenShard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 1
 * return
 * ```
 */
internal object Route124_DivingTreasureHuntersHouse_EventScript_HasRedShard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route124_DivingTreasureHuntersHouse_EventScript_HasRedShard")
}

internal val Route124_DivingTreasureHuntersHouseScripts: Map<String, Script> =
    mapOf(
        "Route124_DivingTreasureHuntersHouse_EventScript_TreasureHunter" to
            Route124_DivingTreasureHuntersHouse_EventScript_TreasureHunter,
        "Route124_DivingTreasureHuntersHouse_EventScript_ShardTradeBoard" to
            Route124_DivingTreasureHuntersHouse_EventScript_ShardTradeBoard,
        "Route124_DivingTreasureHuntersHouse_EventScript_SkipGreeting" to
            Route124_DivingTreasureHuntersHouse_EventScript_SkipGreeting,
        "Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard" to
            Route124_DivingTreasureHuntersHouse_EventScript_CheckPlayerHasShard,
        "Route124_DivingTreasureHuntersHouse_EventScript_GetPlayersShards" to
            Route124_DivingTreasureHuntersHouse_EventScript_GetPlayersShards,
        "Route124_DivingTreasureHuntersHouse_EventScript_NoShards" to
            Route124_DivingTreasureHuntersHouse_EventScript_NoShards,
        "Route124_DivingTreasureHuntersHouse_EventScript_HasShard" to
            Route124_DivingTreasureHuntersHouse_EventScript_HasShard,
        "Route124_DivingTreasureHuntersHouse_EventScript_ShowTradeOptions" to
            Route124_DivingTreasureHuntersHouse_EventScript_ShowTradeOptions,
        "Route124_DivingTreasureHuntersHouse_EventScript_HasYellowShard" to
            Route124_DivingTreasureHuntersHouse_EventScript_HasYellowShard,
        "Route124_DivingTreasureHuntersHouse_EventScript_HasBlueShard" to
            Route124_DivingTreasureHuntersHouse_EventScript_HasBlueShard,
        "Route124_DivingTreasureHuntersHouse_EventScript_HasGreenShard" to
            Route124_DivingTreasureHuntersHouse_EventScript_HasGreenShard,
        "Route124_DivingTreasureHuntersHouse_EventScript_HasRedShard" to
            Route124_DivingTreasureHuntersHouse_EventScript_HasRedShard,
    )
