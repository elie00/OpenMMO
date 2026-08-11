package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room5
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_1F_Room5_EventScript_Arthur : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GENTLEMAN_ARTHUR,
          SSAnne_1F_Room5.ArthurIntro,
          SSAnne_1F_Room5.ArthurDefeat,
          SSAnne_1F_Room5.ArthurPostBattle,
      )
}

internal val SSAnne_1F_Room5Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room5_EventScript_Arthur" to SSAnne_1F_Room5_EventScript_Arthur,
    )
