package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room3
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_B1F_Room3_EventScript_Dylan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SAILOR_DYLAN,
          SSAnne_B1F_Room3.DylanIntro,
          SSAnne_B1F_Room3.DylanDefeat,
          SSAnne_B1F_Room3.DylanPostBattle,
      )
}

internal object SSAnne_B1F_Room3_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ETHER)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_B1F_ROOM3_ETHER)
  }
}

internal val SSAnne_B1F_Room3Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room3_EventScript_Dylan" to SSAnne_B1F_Room3_EventScript_Dylan,
        "SSAnne_B1F_Room3_EventScript_ItemEther" to SSAnne_B1F_Room3_EventScript_ItemEther,
    )
