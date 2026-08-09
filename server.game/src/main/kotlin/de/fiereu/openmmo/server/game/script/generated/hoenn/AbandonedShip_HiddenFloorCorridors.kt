package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip
import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip_HiddenFloorCorridors
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_USED_ROOM_1_KEY, AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen
 * checkitem ITEM_ROOM_1_KEY
 * goto_if_eq VAR_RESULT, FALSE, AbandonedShip_HiddenFloorCorridors_EventScript_Rm1IsLocked
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_InsertedKey, MSGBOX_DEFAULT
 * playse SE_PIN
 * removeitem ITEM_ROOM_1_KEY
 * setflag FLAG_USED_ROOM_1_KEY
 * call AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom1
 * special DrawWholeMapView
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Room1Door : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_Room1Door")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_USED_ROOM_2_KEY, AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen
 * checkitem ITEM_ROOM_2_KEY
 * goto_if_eq VAR_RESULT, FALSE, AbandonedShip_HiddenFloorCorridors_EventScript_Rm2IsLocked
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_InsertedKey, MSGBOX_DEFAULT
 * playse SE_PIN
 * removeitem ITEM_ROOM_2_KEY
 * setflag FLAG_USED_ROOM_2_KEY
 * call AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom2
 * special DrawWholeMapView
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Room2Door : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_Room2Door")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_USED_ROOM_4_KEY, AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen
 * checkitem ITEM_ROOM_4_KEY
 * goto_if_eq VAR_RESULT, FALSE, AbandonedShip_HiddenFloorCorridors_EventScript_Rm4IsLocked
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_InsertedKey, MSGBOX_DEFAULT
 * playse SE_PIN
 * removeitem ITEM_ROOM_4_KEY
 * setflag FLAG_USED_ROOM_4_KEY
 * call AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom4
 * special DrawWholeMapView
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Room4Door : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_Room4Door")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_USED_ROOM_6_KEY, AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen
 * checkitem ITEM_ROOM_6_KEY
 * goto_if_eq VAR_RESULT, FALSE, AbandonedShip_HiddenFloorCorridors_EventScript_Rm6IsLocked
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_InsertedKey, MSGBOX_DEFAULT
 * playse SE_PIN
 * removeitem ITEM_ROOM_6_KEY
 * setflag FLAG_USED_ROOM_6_KEY
 * call AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom6
 * special DrawWholeMapView
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Room6Door : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_Room6Door")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 3, 3, METATILE_InsideShip_DoorIndent_Unlocked, FALSE
 * return
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 6, 8, METATILE_InsideShip_IntactDoor_Bottom_Unlocked, TRUE
 * return
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom2")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_Rm6DoorIsLocked, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Rm6IsLocked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip_HiddenFloorCorridors.Rm6DoorIsLocked)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_Rm2DoorIsLocked, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Rm2IsLocked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip_HiddenFloorCorridors.Rm2DoorIsLocked)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 9, 3, METATILE_InsideShip_DoorIndent_Unlocked, FALSE
 * return
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom6 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom6")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_Text_TheDoorIsOpen, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip.TheDoorIsOpen)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_Rm4DoorIsLocked, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Rm4IsLocked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip_HiddenFloorCorridors.Rm4DoorIsLocked)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 3, 8, METATILE_InsideShip_IntactDoor_Bottom_Unlocked, TRUE
 * return
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom1")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_HiddenFloorCorridors_Text_Rm1DoorIsLocked, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_HiddenFloorCorridors_EventScript_Rm1IsLocked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip_HiddenFloorCorridors.Rm1DoorIsLocked)
  }
}

internal val AbandonedShip_HiddenFloorCorridorsScripts: Map<String, Script> =
    mapOf(
        "AbandonedShip_HiddenFloorCorridors_EventScript_Room1Door" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Room1Door,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Room2Door" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Room2Door,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Room4Door" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Room4Door,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Room6Door" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Room6Door,
        "AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom4" to
            AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom4,
        "AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom2" to
            AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom2,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Rm6IsLocked" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Rm6IsLocked,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Rm2IsLocked" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Rm2IsLocked,
        "AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom6" to
            AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom6,
        "AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen" to
            AbandonedShip_HiddenFloorCorridors_EventScript_TheDoorIsOpen,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Rm4IsLocked" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Rm4IsLocked,
        "AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom1" to
            AbandonedShip_HiddenFloorCorridors_EventScript_UnlockRoom1,
        "AbandonedShip_HiddenFloorCorridors_EventScript_Rm1IsLocked" to
            AbandonedShip_HiddenFloorCorridors_EventScript_Rm1IsLocked,
    )
