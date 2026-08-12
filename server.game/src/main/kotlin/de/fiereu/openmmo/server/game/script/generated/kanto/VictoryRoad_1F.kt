package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VictoryRoad_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object VictoryRoad_1F_EventScript_Rolando : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_ROLANDO,
          VictoryRoad_1F.RolandoIntro,
          VictoryRoad_1F.RolandoDefeat,
          VictoryRoad_1F.RolandoPostBattle,
      )
}

internal object VictoryRoad_1F_EventScript_Naomi : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_NAOMI,
          VictoryRoad_1F.NaomiIntro,
          VictoryRoad_1F.NaomiDefeat,
          VictoryRoad_1F.NaomiPostBattle,
      )
}

internal object VictoryRoad_1F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.RARE_CANDY)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_1F_RARE_CANDY)
  }
}

internal object VictoryRoad_1F_EventScript_ItemTM02 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM02)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_1F_TM02)
  }
}

internal val VictoryRoad_1FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_1F_EventScript_Rolando" to VictoryRoad_1F_EventScript_Rolando,
        "VictoryRoad_1F_EventScript_Naomi" to VictoryRoad_1F_EventScript_Naomi,
        "VictoryRoad_1F_EventScript_ItemRareCandy" to VictoryRoad_1F_EventScript_ItemRareCandy,
        "VictoryRoad_1F_EventScript_ItemTM02" to VictoryRoad_1F_EventScript_ItemTM02,
    )
