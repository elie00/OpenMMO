package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room4
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_B1F_Room4_EventScript_Duncan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SAILOR_DUNCAN,
          SSAnne_B1F_Room4.DuncanIntro,
          SSAnne_B1F_Room4.DuncanDefeat,
          SSAnne_B1F_Room4.DuncanPostBattle,
      )
}

internal object SSAnne_B1F_Room4_EventScript_Leonard : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SAILOR_LEONARD,
          SSAnne_B1F_Room4.LeonardIntro,
          SSAnne_B1F_Room4.LeonardDefeat,
          SSAnne_B1F_Room4.LeonardPostBattle,
      )
}

internal val SSAnne_B1F_Room4Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room4_EventScript_Duncan" to SSAnne_B1F_Room4_EventScript_Duncan,
        "SSAnne_B1F_Room4_EventScript_Leonard" to SSAnne_B1F_Room4_EventScript_Leonard,
    )
