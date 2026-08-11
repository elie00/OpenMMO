package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_8F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_8F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_32,
          SilphCo_8F.Grunt1Intro,
          SilphCo_8F.Grunt1Defeat,
          SilphCo_8F.Grunt1PostBattle,
      )
}

internal object SilphCo_8F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_36,
          SilphCo_8F.Grunt2Intro,
          SilphCo_8F.Grunt2Defeat,
          SilphCo_8F.Grunt2PostBattle,
      )
}

internal object SilphCo_8F_EventScript_Parker : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_PARKER,
          SilphCo_8F.ParkerIntro,
          SilphCo_8F.ParkerDefeat,
          SilphCo_8F.ParkerPostBattle,
      )
}

internal object SilphCo_8F_EventScript_WorkerM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_8F.ThanksForSavingUs
          else SilphCo_8F.WonderIfSilphIsFinished)
}

internal object SilphCo_8F_EventScript_ItemIron : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.IRON)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_8F_IRON)
  }
}

internal object SilphCo_8F_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SilphCo_8F.ToRocketBossMonsAreTools)
}

internal object SilphCo_8F_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_8F_DOOR)
}

internal object SilphCo_8F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_8F.FloorSign)
}

internal val SilphCo_8FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_8F_EventScript_Grunt1" to SilphCo_8F_EventScript_Grunt1,
        "SilphCo_8F_EventScript_Grunt2" to SilphCo_8F_EventScript_Grunt2,
        "SilphCo_8F_EventScript_Parker" to SilphCo_8F_EventScript_Parker,
        "SilphCo_8F_EventScript_WorkerM" to SilphCo_8F_EventScript_WorkerM,
        "SilphCo_8F_EventScript_ItemIron" to SilphCo_8F_EventScript_ItemIron,
        "SilphCo_8F_EventScript_Scientist" to SilphCo_8F_EventScript_Scientist,
        "SilphCo_8F_EventScript_Door" to SilphCo_8F_EventScript_Door,
        "SilphCo_8F_EventScript_FloorSign" to SilphCo_8F_EventScript_FloorSign,
    )
