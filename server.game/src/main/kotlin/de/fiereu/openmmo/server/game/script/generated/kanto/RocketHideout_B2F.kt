package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.RocketHideout_B2F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object RocketHideout_B2F_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_13,
          RocketHideout_B2F.GruntIntro,
          RocketHideout_B2F.GruntDefeat,
          RocketHideout_B2F.GruntPostBattle,
      )
}

internal object RocketHideout_B2F_EventScript_ItemXSpeed : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.X_SPEED)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_X_SPEED)
  }
}

internal object RocketHideout_B2F_EventScript_ItemMoonStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MOON_STONE)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_MOON_STONE)
  }
}

internal object RocketHideout_B2F_EventScript_ItemTM12 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM12)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_TM12)
  }
}

internal object RocketHideout_B2F_EventScript_ItemSuperPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.SUPER_POTION)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_SUPER_POTION)
  }
}

internal val RocketHideout_B2FScripts: Map<String, Script> =
    mapOf(
        "RocketHideout_B2F_EventScript_Grunt" to RocketHideout_B2F_EventScript_Grunt,
        "RocketHideout_B2F_EventScript_ItemXSpeed" to RocketHideout_B2F_EventScript_ItemXSpeed,
        "RocketHideout_B2F_EventScript_ItemMoonStone" to
            RocketHideout_B2F_EventScript_ItemMoonStone,
        "RocketHideout_B2F_EventScript_ItemTM12" to RocketHideout_B2F_EventScript_ItemTM12,
        "RocketHideout_B2F_EventScript_ItemSuperPotion" to
            RocketHideout_B2F_EventScript_ItemSuperPotion,
    )
