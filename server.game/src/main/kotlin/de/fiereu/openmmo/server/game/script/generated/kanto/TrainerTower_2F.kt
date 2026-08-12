package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.TrainerTower_Roof
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * The tower owner, shared by every floor's object events and the roof. ttower_getownerstate answers
 * 0 until a run has been finished, so this is the first-arrival branch.
 */
internal object TrainerTower_EventScript_Owner : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TrainerTower_Roof.ImOwnerBattledPerfectly)
    // TODO Hand out the tower prize and rate the run's time
    //  ttower_giveprize takes the item the finished floor set names and ttower_checkfinaltime
    //  compares the run against the saved record, which decides between DoneItInRecordTime and
    //  TookSweetTimeGettingHere. Both need the tower's challenge state and its timer.
    ctx.say(TrainerTower_Roof.IdLikeToSeeBetterTime)
  }
}

internal val TrainerTower_2FScripts: Map<String, Script> =
    mapOf(
        "TrainerTower_EventScript_Owner" to TrainerTower_EventScript_Owner,
    )
