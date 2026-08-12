package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_TrainerTower
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Both psychics ask ShouldTryRematchBattle before their post battle line, which only the Vs Seeker
// can answer TRUE, so each takes the branch a fresh save takes.

internal object SevenIsland_TrainerTower_EventScript_Dario : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PSYCHIC_DARIO,
          SevenIsland_TrainerTower.DarioIntro,
          SevenIsland_TrainerTower.DarioDefeat,
          SevenIsland_TrainerTower.DarioPostBattle,
      )
}

internal object SevenIsland_TrainerTower_EventScript_Rodette : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PSYCHIC_RODETTE,
          SevenIsland_TrainerTower.RodetteIntro,
          SevenIsland_TrainerTower.RodetteDefeat,
          SevenIsland_TrainerTower.RodettePostBattle,
      )
}

internal object SevenIsland_TrainerTower_EventScript_TrainerTowerSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SevenIsland_TrainerTower.TrainerTowerSign)
}

internal object SevenIsland_TrainerTower_EventScript_TrainerTowerAheadSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SevenIsland_TrainerTower.TrainerTowerAhead)
}

internal val SevenIsland_TrainerTowerScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_TrainerTower_EventScript_Dario" to SevenIsland_TrainerTower_EventScript_Dario,
        "SevenIsland_TrainerTower_EventScript_Rodette" to
            SevenIsland_TrainerTower_EventScript_Rodette,
        "SevenIsland_TrainerTower_EventScript_TrainerTowerSign" to
            SevenIsland_TrainerTower_EventScript_TrainerTowerSign,
        "SevenIsland_TrainerTower_EventScript_TrainerTowerAheadSign" to
            SevenIsland_TrainerTower_EventScript_TrainerTowerAheadSign,
    )
