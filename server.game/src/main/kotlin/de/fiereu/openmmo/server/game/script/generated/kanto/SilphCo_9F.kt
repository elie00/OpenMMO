package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_9F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_9F_EventScript_Ed : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_ED,
          SilphCo_9F.EdIntro,
          SilphCo_9F.EdDefeat,
          SilphCo_9F.EdPostBattle,
      )
}

internal object SilphCo_9F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_38,
          SilphCo_9F.Grunt2Intro,
          SilphCo_9F.Grunt2Defeat,
          SilphCo_9F.Grunt2PostBattle,
      )
}

internal object SilphCo_9F_EventScript_HealWoman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_9F.ThankYouSoMuch
          else SilphCo_9F.YouShouldTakeQuickNap)
}

internal object SilphCo_9F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_37,
          SilphCo_9F.Grunt1Intro,
          SilphCo_9F.Grunt1Defeat,
          SilphCo_9F.Grunt1PostBattle,
      )
}

internal object SilphCo_9F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_9F_DOOR_1)
}

internal object SilphCo_9F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_9F_DOOR_2)
}

internal object SilphCo_9F_EventScript_Door3 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_9F_DOOR_3)
}

internal object SilphCo_9F_EventScript_Door4 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_9F_DOOR_4)
}

internal object SilphCo_9F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_9F.FloorSign)
}

internal val SilphCo_9FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_9F_EventScript_Ed" to SilphCo_9F_EventScript_Ed,
        "SilphCo_9F_EventScript_Grunt2" to SilphCo_9F_EventScript_Grunt2,
        "SilphCo_9F_EventScript_HealWoman" to SilphCo_9F_EventScript_HealWoman,
        "SilphCo_9F_EventScript_Grunt1" to SilphCo_9F_EventScript_Grunt1,
        "SilphCo_9F_EventScript_Door1" to SilphCo_9F_EventScript_Door1,
        "SilphCo_9F_EventScript_Door2" to SilphCo_9F_EventScript_Door2,
        "SilphCo_9F_EventScript_Door3" to SilphCo_9F_EventScript_Door3,
        "SilphCo_9F_EventScript_Door4" to SilphCo_9F_EventScript_Door4,
        "SilphCo_9F_EventScript_FloorSign" to SilphCo_9F_EventScript_FloorSign,
    )
