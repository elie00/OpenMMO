package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_2F_Corridor
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_RIVAL = 0

internal object SSAnne_2F_Corridor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_2F_Corridor.ThisShipIsLuxuryLiner)
}

/** The rival, who fights with the starter that beats the player's wherever he turns up. */
internal object SSAnne_2F_Corridor_EventScript_RivalTrigger : Script {
  override suspend fun run(ctx: ScriptContext) {
    val rival =
        when (Starter.byStarterNumber(ctx.getVar(KantoVars.VAR_STARTER_MON))?.rival) {
          Starter.BULBASAUR_BALL -> KantoTrainerIds.TRAINER_RIVAL_SS_ANNE_BULBASAUR
          Starter.SQUIRTLE_BALL -> KantoTrainerIds.TRAINER_RIVAL_SS_ANNE_SQUIRTLE
          Starter.CHARMANDER_BALL -> KantoTrainerIds.TRAINER_RIVAL_SS_ANNE_CHARMANDER
          null -> return
        }
    ctx.sayNpc(LOCALID_RIVAL, SSAnne_2F_Corridor.RivalIntro)
    // trainerbattle_no_intro: the intro box above is his.
    if (ctx.trainerBattle(rival) != BattleResult.VICTORY) return
    ctx.sayNpc(LOCALID_RIVAL, SSAnne_2F_Corridor.RivalDefeat)
    ctx.sayNpc(LOCALID_RIVAL, SSAnne_2F_Corridor.RivalPostBattle)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_S_S_ANNE_2F_CORRIDOR, 1)
  }
}

internal object SSAnne_2F_Corridor_EventScript_RivalTriggerLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      SSAnne_2F_Corridor_EventScript_RivalTrigger.run(ctx)
}

internal object SSAnne_2F_Corridor_EventScript_RivalTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) =
      SSAnne_2F_Corridor_EventScript_RivalTrigger.run(ctx)
}

internal object SSAnne_2F_Corridor_EventScript_RivalTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      SSAnne_2F_Corridor_EventScript_RivalTrigger.run(ctx)
}

internal val SSAnne_2F_CorridorScripts: Map<String, Script> =
    mapOf(
        "SSAnne_2F_Corridor_EventScript_RivalTrigger" to
            SSAnne_2F_Corridor_EventScript_RivalTrigger,
        "SSAnne_2F_Corridor_EventScript_RivalTriggerLeft" to
            SSAnne_2F_Corridor_EventScript_RivalTriggerLeft,
        "SSAnne_2F_Corridor_EventScript_RivalTriggerMid" to
            SSAnne_2F_Corridor_EventScript_RivalTriggerMid,
        "SSAnne_2F_Corridor_EventScript_RivalTriggerRight" to
            SSAnne_2F_Corridor_EventScript_RivalTriggerRight,
        "SSAnne_2F_Corridor_EventScript_Sailor" to SSAnne_2F_Corridor_EventScript_Sailor,
    )
