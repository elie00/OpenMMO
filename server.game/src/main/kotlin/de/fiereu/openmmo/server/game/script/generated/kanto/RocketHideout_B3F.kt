package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.RocketHideout_B3F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object RocketHideout_B3F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_15,
          RocketHideout_B3F.Grunt2Intro,
          RocketHideout_B3F.Grunt2Defeat,
          RocketHideout_B3F.Grunt2PostBattle,
      )
}

internal object RocketHideout_B3F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_14,
          RocketHideout_B3F.Grunt1Intro,
          RocketHideout_B3F.Grunt1Defeat,
          RocketHideout_B3F.Grunt1PostBattle,
      )
}

internal object RocketHideout_B3F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.RARE_CANDY)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B3F_RARE_CANDY)
  }
}

internal object RocketHideout_B3F_EventScript_ItemTM21 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM21)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B3F_TM21)
  }
}

internal object RocketHideout_B3F_EventScript_ItemBlackGlasses : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.BLACK_GLASSES)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B3F_BLACK_GLASSES)
  }
}

internal val RocketHideout_B3FScripts: Map<String, Script> =
    mapOf(
        "RocketHideout_B3F_EventScript_Grunt2" to RocketHideout_B3F_EventScript_Grunt2,
        "RocketHideout_B3F_EventScript_Grunt1" to RocketHideout_B3F_EventScript_Grunt1,
        "RocketHideout_B3F_EventScript_ItemRareCandy" to
            RocketHideout_B3F_EventScript_ItemRareCandy,
        "RocketHideout_B3F_EventScript_ItemTM21" to RocketHideout_B3F_EventScript_ItemTM21,
        "RocketHideout_B3F_EventScript_ItemBlackGlasses" to
            RocketHideout_B3F_EventScript_ItemBlackGlasses,
    )
