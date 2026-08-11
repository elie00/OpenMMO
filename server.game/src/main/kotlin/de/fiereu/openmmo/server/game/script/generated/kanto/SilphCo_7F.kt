package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_7F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

private const val LAPRAS = 131
private const val LAPRAS_LEVEL = 25

internal object SilphCo_7F_EventScript_LaprasGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_LAPRAS_FROM_SILPH)) {
      return ctx.say(SilphCo_7F.ExplainLapras)
    }
    ctx.say(SilphCo_7F.HaveMonForSavingUs)
    ctx.givePokemon(LAPRAS, LAPRAS_LEVEL)
    ctx.say(SilphCo_7F.ObtainedLaprasFromEmployee)
    ctx.setFlag(KantoFlags.FLAG_GOT_LAPRAS_FROM_SILPH)
    // The decomp then offers to nickname it, which needs the client's naming screen.
    ctx.say(SilphCo_7F.ExplainLapras)
  }
}

internal object SilphCo_7F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_33,
          SilphCo_7F.Grunt1Intro,
          SilphCo_7F.Grunt1Defeat,
          SilphCo_7F.Grunt1PostBattle,
      )
}

internal object SilphCo_7F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_34,
          SilphCo_7F.Grunt2Intro,
          SilphCo_7F.Grunt2Defeat,
          SilphCo_7F.Grunt2PostBattle,
      )
}

internal object SilphCo_7F_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_35,
          SilphCo_7F.Grunt3Intro,
          SilphCo_7F.Grunt3Defeat,
          SilphCo_7F.Grunt3PostBattle,
      )
}

internal object SilphCo_7F_EventScript_WorkerF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_7F.ThankYouSoMuch
          else SilphCo_7F.ReallyDangerousHere)
}

internal object SilphCo_7F_EventScript_WorkerM1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_7F.CanceledMasterBallProject
          else SilphCo_7F.RocketsAfterMasterBall)
}

internal object SilphCo_7F_EventScript_WorkerM2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_7F.WowYouChasedOffTeamRocket
          else SilphCo_7F.BadIfTeamRocketTookOver)
}

internal object SilphCo_7F_EventScript_Joshua : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_JOSHUA,
          SilphCo_7F.JoshuaIntro,
          SilphCo_7F.JoshuaDefeat,
          SilphCo_7F.JoshuaPostBattle,
      )
}

internal object SilphCo_7F_EventScript_ItemCalcium : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CALCIUM)) return
    ctx.removeNpc(9)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_7F_CALCIUM)
  }
}

internal object SilphCo_7F_EventScript_ItemTM08 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM08)) return
    ctx.removeNpc(10)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_7F_TM08)
  }
}

internal object SilphCo_7F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_7F_DOOR_1)
}

internal object SilphCo_7F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_7F_DOOR_2)
}

internal object SilphCo_7F_EventScript_Door3 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_7F_DOOR_3)
}

internal object SilphCo_7F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_7F.FloorSign)
}

internal val SilphCo_7FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_7F_EventScript_LaprasGuy" to SilphCo_7F_EventScript_LaprasGuy,
        "SilphCo_7F_EventScript_Grunt1" to SilphCo_7F_EventScript_Grunt1,
        "SilphCo_7F_EventScript_Grunt2" to SilphCo_7F_EventScript_Grunt2,
        "SilphCo_7F_EventScript_Grunt3" to SilphCo_7F_EventScript_Grunt3,
        "SilphCo_7F_EventScript_WorkerF" to SilphCo_7F_EventScript_WorkerF,
        "SilphCo_7F_EventScript_WorkerM1" to SilphCo_7F_EventScript_WorkerM1,
        "SilphCo_7F_EventScript_WorkerM2" to SilphCo_7F_EventScript_WorkerM2,
        "SilphCo_7F_EventScript_Joshua" to SilphCo_7F_EventScript_Joshua,
        "SilphCo_7F_EventScript_ItemCalcium" to SilphCo_7F_EventScript_ItemCalcium,
        "SilphCo_7F_EventScript_ItemTM08" to SilphCo_7F_EventScript_ItemTM08,
        "SilphCo_7F_EventScript_Door1" to SilphCo_7F_EventScript_Door1,
        "SilphCo_7F_EventScript_Door2" to SilphCo_7F_EventScript_Door2,
        "SilphCo_7F_EventScript_Door3" to SilphCo_7F_EventScript_Door3,
        "SilphCo_7F_EventScript_FloorSign" to SilphCo_7F_EventScript_FloorSign,
    )
