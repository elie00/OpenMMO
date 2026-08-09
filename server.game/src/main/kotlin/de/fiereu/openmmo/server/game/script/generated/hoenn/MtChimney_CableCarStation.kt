package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MtChimney_CableCarStation
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MtChimney_CableCarStation_Text_CableCarReadyGetOn, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, MtChimney_CableCarStation_EventScript_RideCableCar
 * goto_if_eq VAR_RESULT, NO, MtChimney_CableCarStation_EventScript_DeclineRide
 * end
 * ```
 */
internal object MtChimney_CableCarStation_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MtChimney_CableCarStation_EventScript_Attendant")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MtChimney_CableCarStation_Text_RideAnotherTime, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MtChimney_CableCarStation_EventScript_DeclineRide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MtChimney_CableCarStation.RideAnotherTime)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MtChimney_CableCarStation_Text_StepThisWay, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_MT_CHIMNEY_CABLE_CAR_ATTENDANT, MtChimney_CableCarStation_Movement_LeadPlayerToCableCar
 * applymovement LOCALID_PLAYER, MtChimney_CableCarStation_Movement_BoardCableCar
 * waitmovement 0
 * setvar VAR_0x8004, TRUE  @ Going down
 * setvar VAR_CABLE_CAR_STATION_STATE, 2
 * incrementgamestat GAME_STAT_RODE_CABLE_CAR
 * special CableCarWarp
 * special CableCar
 * release
 * end
 * ```
 */
internal object MtChimney_CableCarStation_EventScript_RideCableCar : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MtChimney_CableCarStation_EventScript_RideCableCar")
}

internal val MtChimney_CableCarStationScripts: Map<String, Script> =
    mapOf(
        "MtChimney_CableCarStation_EventScript_Attendant" to
            MtChimney_CableCarStation_EventScript_Attendant,
        "MtChimney_CableCarStation_EventScript_DeclineRide" to
            MtChimney_CableCarStation_EventScript_DeclineRide,
        "MtChimney_CableCarStation_EventScript_RideCableCar" to
            MtChimney_CableCarStation_EventScript_RideCableCar,
    )
