package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room2
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_1F_Room2_EventScript_Ann : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_ANN,
          SSAnne_1F_Room2.AnnIntro,
          SSAnne_1F_Room2.AnnDefeat,
          SSAnne_1F_Room2.AnnPostBattle,
      )
}

internal object SSAnne_1F_Room2_EventScript_Tyler : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_TYLER,
          SSAnne_1F_Room2.TylerIntro,
          SSAnne_1F_Room2.TylerDefeat,
          SSAnne_1F_Room2.TylerPostBattle,
      )
}

internal object SSAnne_1F_Room2_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_1F_Room2.CruisingAroundWorld)
}

internal object SSAnne_1F_Room2_EventScript_ItemTM31 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM31)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_1F_ROOM2_TM31)
  }
}

internal val SSAnne_1F_Room2Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room2_EventScript_Ann" to SSAnne_1F_Room2_EventScript_Ann,
        "SSAnne_1F_Room2_EventScript_Tyler" to SSAnne_1F_Room2_EventScript_Tyler,
        "SSAnne_1F_Room2_EventScript_Woman" to SSAnne_1F_Room2_EventScript_Woman,
        "SSAnne_1F_Room2_EventScript_ItemTM31" to SSAnne_1F_Room2_EventScript_ItemTM31,
    )
