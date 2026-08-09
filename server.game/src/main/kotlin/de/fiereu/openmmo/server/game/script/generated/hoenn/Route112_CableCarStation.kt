package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route112_CableCarStation
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox Route112_CableCarStation_Text_CableCarReadyGetOn, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route112_CableCarStation_EventScript_RideCableCar
 * goto_if_eq VAR_RESULT, NO, Route112_CableCarStation_EventScript_DeclineRide
 * end
 * ```
 */
internal object Route112_CableCarStation_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route112_CableCarStation_EventScript_Attendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route112_CableCarStation_Text_StepThisWay, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_ROUTE112_CABLE_CAR_ATTENDANT, Route112_CableCarStation_Movement_LeadPlayerToCableCar
 * applymovement LOCALID_PLAYER, Route112_CableCarStation_Movement_BoardCableCar
 * waitmovement 0
 * setvar VAR_0x8004, FALSE  @ Going up
 * setvar VAR_CABLE_CAR_STATION_STATE, 1
 * incrementgamestat GAME_STAT_RODE_CABLE_CAR
 * special CableCarWarp
 * special CableCar
 * release
 * end
 * ```
 */
internal object Route112_CableCarStation_EventScript_RideCableCar : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route112_CableCarStation_EventScript_RideCableCar")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route112_CableCarStation_Text_RideAnotherTime, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route112_CableCarStation_EventScript_DeclineRide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route112_CableCarStation.RideAnotherTime)
  }
}

internal val Route112_CableCarStationScripts: Map<String, Script> =
    mapOf(
        "Route112_CableCarStation_EventScript_Attendant" to
            Route112_CableCarStation_EventScript_Attendant,
        "Route112_CableCarStation_EventScript_RideCableCar" to
            Route112_CableCarStation_EventScript_RideCableCar,
        "Route112_CableCarStation_EventScript_DeclineRide" to
            Route112_CableCarStation_EventScript_DeclineRide,
    )
