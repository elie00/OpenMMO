package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room7
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_1F_Room7_EventScript_Thomas : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GENTLEMAN_THOMAS,
          SSAnne_1F_Room7.ThomasIntro,
          SSAnne_1F_Room7.ThomasDefeat,
          SSAnne_1F_Room7.ThomasPostBattle,
      )
}

internal val SSAnne_1F_Room7Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room7_EventScript_Thomas" to SSAnne_1F_Room7_EventScript_Thomas,
    )
