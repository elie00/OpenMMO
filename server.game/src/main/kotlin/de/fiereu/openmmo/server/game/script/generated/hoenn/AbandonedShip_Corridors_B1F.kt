package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip
import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip_Corridors_B1F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object AbandonedShip_Corridors_B1F_EventScript_TuberM : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(AbandonedShip_Corridors_B1F.YayItsAShip)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DUNCAN, AbandonedShip_Corridors_B1F_Text_DuncanIntro, AbandonedShip_Corridors_B1F_Text_DuncanDefeat
 * msgbox AbandonedShip_Corridors_B1F_Text_DuncanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object AbandonedShip_Corridors_B1F_EventScript_Duncan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DUNCAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(AbandonedShip_Corridors_B1F.DuncanPostBattle)
    }
    ctx.say(AbandonedShip_Corridors_B1F.DuncanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(AbandonedShip_Corridors_B1F.DuncanDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_USED_STORAGE_KEY, AbandonedShip_Corridors_B1F_EventScript_DoorIsUnlocked
 * checkitem ITEM_STORAGE_KEY
 * goto_if_eq VAR_RESULT, FALSE, AbandonedShip_Corridors_B1F_EventScript_DoorIsLocked
 * msgbox AbandonedShip_Corridors_B1F_Text_InsertedStorageKey, MSGBOX_DEFAULT
 * playse SE_PIN
 * removeitem ITEM_STORAGE_KEY
 * setflag FLAG_USED_STORAGE_KEY
 * call AbandonedShip_Corridors_B1F_EventScript_UnlockStorageRoom
 * special DrawWholeMapView
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_Corridors_B1F_EventScript_StorageRoomDoor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_Corridors_B1F_EventScript_StorageRoomDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 11, 4, METATILE_InsideShip_IntactDoor_Bottom_Unlocked, TRUE
 * return
 * ```
 */
internal object AbandonedShip_Corridors_B1F_EventScript_UnlockStorageRoom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_Corridors_B1F_EventScript_UnlockStorageRoom")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_Corridors_B1F_Text_DoorIsLocked, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_Corridors_B1F_EventScript_DoorIsLocked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip_Corridors_B1F.DoorIsLocked)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox AbandonedShip_Text_TheDoorIsOpen, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object AbandonedShip_Corridors_B1F_EventScript_DoorIsUnlocked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(AbandonedShip.TheDoorIsOpen)
  }
}

internal val AbandonedShip_Corridors_B1FScripts: Map<String, Script> =
    mapOf(
        "AbandonedShip_Corridors_B1F_EventScript_TuberM" to
            AbandonedShip_Corridors_B1F_EventScript_TuberM,
        "AbandonedShip_Corridors_B1F_EventScript_Duncan" to
            AbandonedShip_Corridors_B1F_EventScript_Duncan,
        "AbandonedShip_Corridors_B1F_EventScript_StorageRoomDoor" to
            AbandonedShip_Corridors_B1F_EventScript_StorageRoomDoor,
        "AbandonedShip_Corridors_B1F_EventScript_UnlockStorageRoom" to
            AbandonedShip_Corridors_B1F_EventScript_UnlockStorageRoom,
        "AbandonedShip_Corridors_B1F_EventScript_DoorIsLocked" to
            AbandonedShip_Corridors_B1F_EventScript_DoorIsLocked,
        "AbandonedShip_Corridors_B1F_EventScript_DoorIsUnlocked" to
            AbandonedShip_Corridors_B1F_EventScript_DoorIsUnlocked,
    )
