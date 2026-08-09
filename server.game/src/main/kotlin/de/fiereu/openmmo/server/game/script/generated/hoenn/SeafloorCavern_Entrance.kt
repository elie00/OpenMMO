package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_eq VAR_HAS_TALKED_TO_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, 1, SeafloorCavern_Entrance_EventScript_GruntSpeechShort
 * waitse
 * playse SE_PIN
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_Delay48
 * waitmovement 0
 * delay 20
 * call_if_eq VAR_FACING, DIR_WEST, SeafloorCavern_Entrance_EventScript_GruntFacePlayerWest
 * call_if_eq VAR_FACING, DIR_EAST, SeafloorCavern_Entrance_EventScript_GruntFacePlayerEast
 * call_if_eq VAR_FACING, DIR_NORTH, SeafloorCavern_Entrance_EventScript_GruntFacePlayerNorth
 * delay 30
 * setvar VAR_HAS_TALKED_TO_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, 1
 * copyobjectxytoperm LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT
 * msgbox SeafloorCavern_Entrance_Text_HearMagmaNearMossdeep, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SeafloorCavern_Entrance_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SeafloorCavern_Entrance_EventScript_Grunt")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object SeafloorCavern_Entrance_EventScript_GruntFacePlayerEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SeafloorCavern_Entrance_EventScript_GruntFacePlayerEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_FACING, DIR_WEST, SeafloorCavern_Entrance_EventScript_GruntFacePlayerWest
 * call_if_eq VAR_FACING, DIR_EAST, SeafloorCavern_Entrance_EventScript_GruntFacePlayerEast
 * call_if_eq VAR_FACING, DIR_NORTH, SeafloorCavern_Entrance_EventScript_GruntFacePlayerNorth
 * msgbox SeafloorCavern_Entrance_Text_HearMagmaNearMossdeepShort, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object SeafloorCavern_Entrance_EventScript_GruntSpeechShort : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SeafloorCavern_Entrance_EventScript_GruntSpeechShort")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * return
 * ```
 */
internal object SeafloorCavern_Entrance_EventScript_GruntFacePlayerWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SeafloorCavern_Entrance_EventScript_GruntFacePlayerWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_SEAFLOOR_CAVERN_ENTRANCE_GRUNT, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object SeafloorCavern_Entrance_EventScript_GruntFacePlayerNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SeafloorCavern_Entrance_EventScript_GruntFacePlayerNorth")
}

internal val SeafloorCavern_EntranceScripts: Map<String, Script> =
    mapOf(
        "SeafloorCavern_Entrance_EventScript_Grunt" to SeafloorCavern_Entrance_EventScript_Grunt,
        "SeafloorCavern_Entrance_EventScript_GruntFacePlayerEast" to
            SeafloorCavern_Entrance_EventScript_GruntFacePlayerEast,
        "SeafloorCavern_Entrance_EventScript_GruntSpeechShort" to
            SeafloorCavern_Entrance_EventScript_GruntSpeechShort,
        "SeafloorCavern_Entrance_EventScript_GruntFacePlayerWest" to
            SeafloorCavern_Entrance_EventScript_GruntFacePlayerWest,
        "SeafloorCavern_Entrance_EventScript_GruntFacePlayerNorth" to
            SeafloorCavern_Entrance_EventScript_GruntFacePlayerNorth,
    )
