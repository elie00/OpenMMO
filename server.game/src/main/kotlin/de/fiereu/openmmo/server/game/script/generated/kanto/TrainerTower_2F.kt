package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * call TrainerTower_EventScript_SpeakToOwner
 * end
 * ```
 */
internal object TrainerTower_EventScript_Owner : Script {
  override suspend fun run(ctx: ScriptContext) {
    TrainerTower_EventScript_SpeakToOwner.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * ttower_getownerstate
 * switch VAR_RESULT
 * case 0, TrainerTower_Roof_EventScript_Arrived
 * case 1, TrainerTower_Roof_EventScript_GivePrize
 * case 2, TrainerTower_Roof_EventScript_OwnerEnd
 * ```
 */
internal object TrainerTower_EventScript_SpeakToOwner : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TrainerTower_EventScript_SpeakToOwner")
}

internal val TrainerTower_2FScripts: Map<String, Script> =
    mapOf(
        "TrainerTower_EventScript_Owner" to TrainerTower_EventScript_Owner,
        "TrainerTower_EventScript_SpeakToOwner" to TrainerTower_EventScript_SpeakToOwner,
    )
