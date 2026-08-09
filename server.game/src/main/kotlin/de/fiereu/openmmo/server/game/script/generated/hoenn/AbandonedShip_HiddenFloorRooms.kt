package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip_HiddenFloorRooms
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_LUXURY_BALL
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorRooms_EventScript_ItemLuxuryBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(
        Items.LUXURY_BALL, HoennFlags.FLAG_ITEM_ABANDONED_SHIP_HIDDEN_FLOOR_ROOM_6_LUXURY_BALL, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SCANNER
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorRooms_EventScript_ItemScanner : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.SCANNER, HoennFlags.FLAG_ITEM_ABANDONED_SHIP_HIDDEN_FLOOR_ROOM_2_SCANNER, 1)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM_RAIN_DANCE
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorRooms_EventScript_ItemTMRainDance : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorRooms_EventScript_ItemTMRainDance")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_WATER_STONE
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorRooms_EventScript_ItemWaterStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(
        Items.WATER_STONE, HoennFlags.FLAG_ITEM_ABANDONED_SHIP_HIDDEN_FLOOR_ROOM_3_WATER_STONE, 3)
  }
}

internal object AbandonedShip_HiddenFloorRooms_EventScript_Trash : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(AbandonedShip_HiddenFloorRooms.BrightShinyTrash)
}

internal val AbandonedShip_HiddenFloorRoomsScripts: Map<String, Script> =
    mapOf(
        "AbandonedShip_HiddenFloorRooms_EventScript_ItemLuxuryBall" to
            AbandonedShip_HiddenFloorRooms_EventScript_ItemLuxuryBall,
        "AbandonedShip_HiddenFloorRooms_EventScript_ItemScanner" to
            AbandonedShip_HiddenFloorRooms_EventScript_ItemScanner,
        "AbandonedShip_HiddenFloorRooms_EventScript_ItemTMRainDance" to
            AbandonedShip_HiddenFloorRooms_EventScript_ItemTMRainDance,
        "AbandonedShip_HiddenFloorRooms_EventScript_ItemWaterStone" to
            AbandonedShip_HiddenFloorRooms_EventScript_ItemWaterStone,
        "AbandonedShip_HiddenFloorRooms_EventScript_Trash" to
            AbandonedShip_HiddenFloorRooms_EventScript_Trash,
    )
