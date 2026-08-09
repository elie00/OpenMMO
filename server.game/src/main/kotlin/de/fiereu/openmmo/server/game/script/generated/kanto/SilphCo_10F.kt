package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_10F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SCIENTIST_TRAVIS, SilphCo_10F_Text_TravisIntro, SilphCo_10F_Text_TravisDefeat
 * msgbox SilphCo_10F_Text_TravisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_Travis : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SCIENTIST_TRAVIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_10F.TravisPostBattle)
    }
    ctx.say(SilphCo_10F.TravisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_10F.TravisDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_MAP_SCENE_SILPH_CO_11F, 1, SilphCo_10F_EventScript_WorkerFRocketsGone
 * msgbox SilphCo_10F_Text_WaaaImScared
 * release
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_WorkerF : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_10F_EventScript_WorkerF")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_39, SilphCo_10F_Text_GruntIntro, SilphCo_10F_Text_GruntDefeat
 * msgbox SilphCo_10F_Text_GruntPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_39
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_10F.GruntPostBattle)
    }
    ctx.say(SilphCo_10F.GruntIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_10F.GruntDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARBOS
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARBOS, KantoFlags.FLAG_HIDE_SILPH_CO_10F_CARBOS, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ULTRA_BALL
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ULTRA_BALL, KantoFlags.FLAG_HIDE_SILPH_CO_10F_ULTRA_BALL, 4)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.RARE_CANDY, KantoFlags.FLAG_HIDE_SILPH_CO_10F_RARE_CANDY, 5)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 19
 * setvar VAR_0x8004, FLAG_SILPH_10F_DOOR
 * goto_if_set FLAG_SILPH_10F_DOOR, EventScript_DoorUnlocked
 * goto EventScript_TryUnlockDoor
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_10F_EventScript_Door")
}

internal object SilphCo_10F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_10F.FloorSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_TheDoorIsOpen
 * releaseall
 * end
 * ```
 */
internal object EventScript_DoorUnlocked : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_DoorUnlocked")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SilphCo_10F_Text_KeepMeCryingASecret
 * release
 * end
 * ```
 */
internal object SilphCo_10F_EventScript_WorkerFRocketsGone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SilphCo_10F.KeepMeCryingASecret)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_HIDE_SILPH_CO_5F_CARD_KEY, EventScript_OpenDoor
 * goto EventScript_NeedCardKey
 * end
 * ```
 */
internal object EventScript_TryUnlockDoor : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_HIDE_SILPH_CO_5F_CARD_KEY))
        return EventScript_OpenDoor.run(ctx)
    return EventScript_NeedCardKey.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playfanfare MUS_LEVEL_UP
 * msgbox Text_CardKeyOpenedDoor
 * waitfanfare
 * call_if_eq VAR_TEMP_1, 1, EventScript_Open2FDoor1
 * call_if_eq VAR_TEMP_1, 2, EventScript_Open2FDoor2
 * call_if_eq VAR_TEMP_1, 3, EventScript_Open3FDoor1
 * call_if_eq VAR_TEMP_1, 4, EventScript_Open3FDoor2
 * call_if_eq VAR_TEMP_1, 5, EventScript_Open4FDoor1
 * call_if_eq VAR_TEMP_1, 6, EventScript_Open4FDoor2
 * call_if_eq VAR_TEMP_1, 7, EventScript_Open5FDoor1
 * call_if_eq VAR_TEMP_1, 8, EventScript_Open5FDoor2
 * call_if_eq VAR_TEMP_1, 9, EventScript_Open5FDoor3
 * call_if_eq VAR_TEMP_1, 10, EventScript_Open6FDoor
 * call_if_eq VAR_TEMP_1, 11, EventScript_Open7FDoor1
 * call_if_eq VAR_TEMP_1, 12, EventScript_Open7FDoor2
 * call_if_eq VAR_TEMP_1, 13, EventScript_Open7FDoor3
 * call_if_eq VAR_TEMP_1, 14, EventScript_Open8FDoor
 * call_if_eq VAR_TEMP_1, 15, EventScript_Open9FDoor1
 * call_if_eq VAR_TEMP_1, 16, EventScript_Open9FDoor2
 * call_if_eq VAR_TEMP_1, 17, EventScript_Open9FDoor3
 * call_if_eq VAR_TEMP_1, 18, EventScript_Open9FDoor4
 * call_if_eq VAR_TEMP_1, 19, EventScript_Open10FDoor
 * call_if_eq VAR_TEMP_1, 20, EventScript_Open11FDoor
 * waitse
 * playse SE_UNLOCK
 * special DrawWholeMapView
 * waitse
 * special SetHiddenItemFlag
 * releaseall
 * end
 * ```
 */
internal object EventScript_OpenDoor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_OpenDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_ItNeedsCardKey
 * releaseall
 * end
 * ```
 */
internal object EventScript_NeedCardKey : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_NeedCardKey")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 5, 16, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 16, METATILE_SilphCo_Floor, 0
 * setmetatile 5, 17, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 17, METATILE_SilphCo_Floor, 0
 * setmetatile 6, 18, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open11FDoor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open11FDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 5, 9, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 6, 9, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 5, 10, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 10, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 5, 11, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 6, 11, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open8FDoor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open8FDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 12, 11, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 13, 11, METATILE_SilphCo_Floor, 0
 * setmetatile 12, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 13, 12, METATILE_SilphCo_Floor, 0
 * setmetatile 13, 13, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open10FDoor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open10FDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 9, 11, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 10, 11, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 9, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 10, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 9, 13, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 10, 13, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open3FDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open3FDoor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 20, 11, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 21, 11, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 20, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 21, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 20, 13, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 21, 13, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open3FDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open3FDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 21, 6, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 22, 6, METATILE_SilphCo_Floor, 0
 * setmetatile 21, 7, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 22, 7, METATILE_SilphCo_Floor, 0
 * setmetatile 22, 8, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open9FDoor3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open9FDoor3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 21, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 22, 12, METATILE_SilphCo_Floor, 0
 * setmetatile 21, 13, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 22, 13, METATILE_SilphCo_Floor, 0
 * setmetatile 22, 14, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open9FDoor4 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open9FDoor4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 7, 17, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 8, 17, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 7, 18, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 8, 18, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 7, 19, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 8, 19, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open5FDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open5FDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 5, 14, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 6, 14, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 5, 15, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 15, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 5, 16, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 6, 16, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open6FDoor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open6FDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 7, 8, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 8, 8, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 7, 9, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 8, 9, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 7, 10, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 8, 10, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open5FDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open5FDoor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 2, 9, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 3, 9, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 2, 10, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 3, 10, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 2, 11, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 3, 11, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open9FDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open9FDoor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 12, 15, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 13, 15, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 12, 16, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 13, 16, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 12, 17, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 13, 17, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open9FDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open9FDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 3, 16, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 4, 16, METATILE_SilphCo_Floor, 0
 * setmetatile 3, 17, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 4, 17, METATILE_SilphCo_Floor, 0
 * setmetatile 4, 18, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open4FDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open4FDoor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 14, 11, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 15, 11, METATILE_SilphCo_Floor, 0
 * setmetatile 14, 12, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 15, 12, METATILE_SilphCo_Floor, 0
 * setmetatile 15, 13, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open4FDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open4FDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 18, 12, METATILE_SilphCo_Wall_LeftEdge, 1
 * setmetatile 19, 12, METATILE_SilphCo_Wall_RightEdge, 1
 * setmetatile 18, 13, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 19, 13, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 18, 14, METATILE_SilphCo_Floor_WallLeftCorner, 0
 * setmetatile 19, 14, METATILE_SilphCo_Floor_WallRightCorner, 0
 * return
 * ```
 */
internal object EventScript_Open5FDoor3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open5FDoor3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 5, 8, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 8, METATILE_SilphCo_Floor, 0
 * setmetatile 5, 9, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 9, METATILE_SilphCo_Floor, 0
 * setmetatile 6, 10, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open2FDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open2FDoor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 5, 15, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 15, METATILE_SilphCo_Floor, 0
 * setmetatile 5, 16, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 6, 16, METATILE_SilphCo_Floor, 0
 * setmetatile 6, 17, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open2FDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open2FDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 25, 13, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 26, 13, METATILE_SilphCo_Floor, 0
 * setmetatile 25, 14, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 26, 14, METATILE_SilphCo_Floor, 0
 * setmetatile 26, 15, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open7FDoor3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open7FDoor3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 24, 7, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 25, 7, METATILE_SilphCo_Floor, 0
 * setmetatile 24, 8, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 25, 8, METATILE_SilphCo_Floor, 0
 * setmetatile 25, 9, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open7FDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open7FDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 11, 8, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 12, 8, METATILE_SilphCo_Floor, 0
 * setmetatile 11, 9, METATILE_SilphCo_Floor_ShadeFull, 0
 * setmetatile 12, 9, METATILE_SilphCo_Floor, 0
 * setmetatile 12, 10, METATILE_SilphCo_Floor, 0
 * return
 * ```
 */
internal object EventScript_Open7FDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Open7FDoor1")
}

internal val SilphCo_10FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_10F_EventScript_Travis" to SilphCo_10F_EventScript_Travis,
        "SilphCo_10F_EventScript_WorkerF" to SilphCo_10F_EventScript_WorkerF,
        "SilphCo_10F_EventScript_Grunt" to SilphCo_10F_EventScript_Grunt,
        "SilphCo_10F_EventScript_ItemCarbos" to SilphCo_10F_EventScript_ItemCarbos,
        "SilphCo_10F_EventScript_ItemUltraBall" to SilphCo_10F_EventScript_ItemUltraBall,
        "SilphCo_10F_EventScript_ItemRareCandy" to SilphCo_10F_EventScript_ItemRareCandy,
        "SilphCo_10F_EventScript_Door" to SilphCo_10F_EventScript_Door,
        "SilphCo_10F_EventScript_FloorSign" to SilphCo_10F_EventScript_FloorSign,
        "EventScript_DoorUnlocked" to EventScript_DoorUnlocked,
        "SilphCo_10F_EventScript_WorkerFRocketsGone" to SilphCo_10F_EventScript_WorkerFRocketsGone,
        "EventScript_TryUnlockDoor" to EventScript_TryUnlockDoor,
        "EventScript_OpenDoor" to EventScript_OpenDoor,
        "EventScript_NeedCardKey" to EventScript_NeedCardKey,
        "EventScript_Open11FDoor" to EventScript_Open11FDoor,
        "EventScript_Open8FDoor" to EventScript_Open8FDoor,
        "EventScript_Open10FDoor" to EventScript_Open10FDoor,
        "EventScript_Open3FDoor1" to EventScript_Open3FDoor1,
        "EventScript_Open3FDoor2" to EventScript_Open3FDoor2,
        "EventScript_Open9FDoor3" to EventScript_Open9FDoor3,
        "EventScript_Open9FDoor4" to EventScript_Open9FDoor4,
        "EventScript_Open5FDoor2" to EventScript_Open5FDoor2,
        "EventScript_Open6FDoor" to EventScript_Open6FDoor,
        "EventScript_Open5FDoor1" to EventScript_Open5FDoor1,
        "EventScript_Open9FDoor1" to EventScript_Open9FDoor1,
        "EventScript_Open9FDoor2" to EventScript_Open9FDoor2,
        "EventScript_Open4FDoor1" to EventScript_Open4FDoor1,
        "EventScript_Open4FDoor2" to EventScript_Open4FDoor2,
        "EventScript_Open5FDoor3" to EventScript_Open5FDoor3,
        "EventScript_Open2FDoor1" to EventScript_Open2FDoor1,
        "EventScript_Open2FDoor2" to EventScript_Open2FDoor2,
        "EventScript_Open7FDoor3" to EventScript_Open7FDoor3,
        "EventScript_Open7FDoor2" to EventScript_Open7FDoor2,
        "EventScript_Open7FDoor1" to EventScript_Open7FDoor1,
    )
