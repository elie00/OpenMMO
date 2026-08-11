package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_2F_Room2
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_2F_Room2_EventScript_Dale : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_FISHERMAN_DALE,
          SSAnne_2F_Room2.DaleIntro,
          SSAnne_2F_Room2.DaleDefeat,
          SSAnne_2F_Room2.DalePostBattle,
      )
}

internal object SSAnne_2F_Room2_EventScript_Brooks : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GENTLEMAN_BROOKS,
          SSAnne_2F_Room2.BrooksIntro,
          SSAnne_2F_Room2.BrooksDefeat,
          SSAnne_2F_Room2.BrooksPostBattle,
      )
}

internal object SSAnne_2F_Room2_EventScript_ItemStardust : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.STARDUST)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_2F_ROOM2_STARDUST)
  }
}

internal val SSAnne_2F_Room2Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_2F_Room2_EventScript_Dale" to SSAnne_2F_Room2_EventScript_Dale,
        "SSAnne_2F_Room2_EventScript_Brooks" to SSAnne_2F_Room2_EventScript_Brooks,
        "SSAnne_2F_Room2_EventScript_ItemStardust" to SSAnne_2F_Room2_EventScript_ItemStardust,
    )
