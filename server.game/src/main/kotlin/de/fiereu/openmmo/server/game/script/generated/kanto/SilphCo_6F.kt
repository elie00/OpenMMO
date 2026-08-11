package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_6F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_6F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_30,
          SilphCo_6F.Grunt1Intro,
          SilphCo_6F.Grunt1Defeat,
          SilphCo_6F.Grunt1PostBattle,
      )
}

internal object SilphCo_6F_EventScript_WorkerM1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_6F.WeGotEngaged
          else SilphCo_6F.HelpMePlease)
}

internal object SilphCo_6F_EventScript_WorkerF1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_6F.NeedsMeToLookAfterHim
          else SilphCo_6F.ThatManIsSuchACoward)
}

internal object SilphCo_6F_EventScript_WorkerM2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_6F.ComeWorkForSilphWhenYoureOlder
          else SilphCo_6F.TargetedSilphForOurMonProducts)
}

internal object SilphCo_6F_EventScript_WorkerM3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_6F.BetterGetBackToWork
          else SilphCo_6F.RocketsTookOverBuilding)
}

internal object SilphCo_6F_EventScript_WorkerF2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_6F.RocketsRanAwayBecauseOfYou
          else SilphCo_6F.RocketsTryingToConquerWorld)
}

internal object SilphCo_6F_EventScript_Taylor : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_TAYLOR,
          SilphCo_6F.TaylorIntro,
          SilphCo_6F.TaylorDefeat,
          SilphCo_6F.TaylorPostBattle,
      )
}

internal object SilphCo_6F_EventScript_ItemHPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.HP_UP)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_6F_HP_UP)
  }
}

internal object SilphCo_6F_EventScript_ItemXSpecial : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.X_SPECIAL)) return
    ctx.removeNpc(8)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_6F_X_SPECIAL)
  }
}

internal object SilphCo_6F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_31,
          SilphCo_6F.Grunt2Intro,
          SilphCo_6F.Grunt2Defeat,
          SilphCo_6F.Grunt2PostBattle,
      )
}

internal object SilphCo_6F_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_6F_DOOR)
}

internal object SilphCo_6F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_6F.FloorSign)
}

internal val SilphCo_6FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_6F_EventScript_Grunt1" to SilphCo_6F_EventScript_Grunt1,
        "SilphCo_6F_EventScript_WorkerM1" to SilphCo_6F_EventScript_WorkerM1,
        "SilphCo_6F_EventScript_WorkerF1" to SilphCo_6F_EventScript_WorkerF1,
        "SilphCo_6F_EventScript_WorkerM2" to SilphCo_6F_EventScript_WorkerM2,
        "SilphCo_6F_EventScript_WorkerM3" to SilphCo_6F_EventScript_WorkerM3,
        "SilphCo_6F_EventScript_WorkerF2" to SilphCo_6F_EventScript_WorkerF2,
        "SilphCo_6F_EventScript_Taylor" to SilphCo_6F_EventScript_Taylor,
        "SilphCo_6F_EventScript_ItemHPUp" to SilphCo_6F_EventScript_ItemHPUp,
        "SilphCo_6F_EventScript_ItemXSpecial" to SilphCo_6F_EventScript_ItemXSpecial,
        "SilphCo_6F_EventScript_Grunt2" to SilphCo_6F_EventScript_Grunt2,
        "SilphCo_6F_EventScript_Door" to SilphCo_6F_EventScript_Door,
        "SilphCo_6F_EventScript_FloorSign" to SilphCo_6F_EventScript_FloorSign,
    )
