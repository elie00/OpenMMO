package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_2F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SilphCo_2F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_24,
          SilphCo_2F.Grunt2Intro,
          SilphCo_2F.Grunt2Defeat,
          SilphCo_2F.Grunt2PostBattle,
      )
}

internal object SilphCo_2F_EventScript_Jerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_JERRY,
          SilphCo_2F.JerryIntro,
          SilphCo_2F.JerryDefeat,
          SilphCo_2F.JerryPostBattle,
      )
}

internal object SilphCo_2F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_23,
          SilphCo_2F.Grunt1Intro,
          SilphCo_2F.Grunt1Defeat,
          SilphCo_2F.Grunt1PostBattle,
      )
}

internal object SilphCo_2F_EventScript_Connor : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_CONNOR,
          SilphCo_2F.ConnorIntro,
          SilphCo_2F.ConnorDefeat,
          SilphCo_2F.ConnorPostBattle,
      )
}

internal object SilphCo_2F_EventScript_ThunderWaveTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      moveTutor(
          ctx,
          KantoFlags.FLAG_TUTOR_THUNDER_WAVE,
          Misc.Text_ThunderWaveTeach,
          Misc.Text_ThunderWaveDeclined,
          Misc.Text_ThunderWaveTaught,
      )
}

internal object SilphCo_2F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_2F_DOOR_1)
}

internal object SilphCo_2F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_2F_DOOR_2)
}

internal object SilphCo_2F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_2F.FloorSign)
}

internal val SilphCo_2FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_2F_EventScript_Grunt2" to SilphCo_2F_EventScript_Grunt2,
        "SilphCo_2F_EventScript_Jerry" to SilphCo_2F_EventScript_Jerry,
        "SilphCo_2F_EventScript_Grunt1" to SilphCo_2F_EventScript_Grunt1,
        "SilphCo_2F_EventScript_Connor" to SilphCo_2F_EventScript_Connor,
        "SilphCo_2F_EventScript_ThunderWaveTutor" to SilphCo_2F_EventScript_ThunderWaveTutor,
        "SilphCo_2F_EventScript_Door1" to SilphCo_2F_EventScript_Door1,
        "SilphCo_2F_EventScript_Door2" to SilphCo_2F_EventScript_Door2,
        "SilphCo_2F_EventScript_FloorSign" to SilphCo_2F_EventScript_FloorSign,
    )
