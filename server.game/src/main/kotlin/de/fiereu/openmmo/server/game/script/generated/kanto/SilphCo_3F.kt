package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_3F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_3F_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_25,
          SilphCo_3F.GruntIntro,
          SilphCo_3F.GruntDefeat,
          SilphCo_3F.GruntPostBattle,
      )
}

internal object SilphCo_3F_EventScript_WorkerM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_3F.YouAndYourMonsSavedUs
          else SilphCo_3F.WhatAmIToDo)
}

internal object SilphCo_3F_EventScript_Jose : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_JOSE,
          SilphCo_3F.JoseIntro,
          SilphCo_3F.JoseDefeat,
          SilphCo_3F.JosePostBattle,
      )
}

internal object SilphCo_3F_EventScript_ItemHyperPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.HYPER_POTION)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_3F_HYPER_POTION)
  }
}

internal object SilphCo_3F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_3F_DOOR_1)
}

internal object SilphCo_3F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_3F_DOOR_2)
}

internal object SilphCo_3F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_3F.FloorSign)
}

internal val SilphCo_3FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_3F_EventScript_Grunt" to SilphCo_3F_EventScript_Grunt,
        "SilphCo_3F_EventScript_WorkerM" to SilphCo_3F_EventScript_WorkerM,
        "SilphCo_3F_EventScript_Jose" to SilphCo_3F_EventScript_Jose,
        "SilphCo_3F_EventScript_ItemHyperPotion" to SilphCo_3F_EventScript_ItemHyperPotion,
        "SilphCo_3F_EventScript_Door1" to SilphCo_3F_EventScript_Door1,
        "SilphCo_3F_EventScript_Door2" to SilphCo_3F_EventScript_Door2,
        "SilphCo_3F_EventScript_FloorSign" to SilphCo_3F_EventScript_FloorSign,
    )
