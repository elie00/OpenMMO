package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_ne VAR_TEMP_MIXED_RECORDS, 0, RecordCorner_EventScript_AlreadyMixed
 * special Script_FacePlayer
 * message RecordCorner_Text_TakeSeatAndWait
 * waitmessage
 * waitbuttonpress
 * special Script_ClearHeldMovement
 * closemessage
 * end
 * ```
 */
internal object RecordCorner_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RecordCorner_EventScript_Attendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special Script_FacePlayer
 * message RecordCorner_Text_ThanksForComing
 * waitmessage
 * waitbuttonpress
 * special Script_ClearHeldMovement
 * closemessage
 * end
 * ```
 */
internal object RecordCorner_EventScript_AlreadyMixed : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RecordCorner_EventScript_AlreadyMixed")
}

internal val RecordCornerScripts: Map<String, Script> =
    mapOf(
        "RecordCorner_EventScript_Attendant" to RecordCorner_EventScript_Attendant,
        "RecordCorner_EventScript_AlreadyMixed" to RecordCorner_EventScript_AlreadyMixed,
    )
