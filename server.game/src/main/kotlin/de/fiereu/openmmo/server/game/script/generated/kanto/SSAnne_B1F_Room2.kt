package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room2
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_B1F_Room2_EventScript_Huey : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SAILOR_HUEY,
          SSAnne_B1F_Room2.HueyIntro,
          SSAnne_B1F_Room2.HueyDefeat,
          SSAnne_B1F_Room2.HueyPostBattle,
      )
}

internal object SSAnne_B1F_Room2_EventScript_ItemTM44 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM44)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_B1F_ROOM2_TM44)
  }
}

internal val SSAnne_B1F_Room2Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room2_EventScript_Huey" to SSAnne_B1F_Room2_EventScript_Huey,
        "SSAnne_B1F_Room2_EventScript_ItemTM44" to SSAnne_B1F_Room2_EventScript_ItemTM44,
    )
