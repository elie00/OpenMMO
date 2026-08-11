package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_2F_Room4
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SSAnne_2F_Room4_EventScript_Lamar : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GENTLEMAN_LAMAR,
          SSAnne_2F_Room4.LamarIntro,
          SSAnne_2F_Room4.LamarDefeat,
          SSAnne_2F_Room4.LamarPostBattle,
      )
}

internal object SSAnne_2F_Room4_EventScript_Dawn : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_DAWN,
          SSAnne_2F_Room4.DawnIntro,
          SSAnne_2F_Room4.DawnDefeat,
          SSAnne_2F_Room4.DawnPostBattle,
      )
}

internal object SSAnne_2F_Room4_EventScript_ItemXAttack : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.X_ATTACK)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_2F_ROOM4_X_ATTACK)
  }
}

internal val SSAnne_2F_Room4Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_2F_Room4_EventScript_Lamar" to SSAnne_2F_Room4_EventScript_Lamar,
        "SSAnne_2F_Room4_EventScript_Dawn" to SSAnne_2F_Room4_EventScript_Dawn,
        "SSAnne_2F_Room4_EventScript_ItemXAttack" to SSAnne_2F_Room4_EventScript_ItemXAttack,
    )
