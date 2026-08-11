package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route6
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route6_EventScript_Keigo : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_KEIGO,
          Route6.KeigoIntro,
          Route6.KeigoDefeat,
          Route6.KeigoPostBattle,
      )
}

internal object Route6_EventScript_Ricky : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_RICKY,
          Route6.RickyIntro,
          Route6.RickyDefeat,
          Route6.RickyPostBattle,
      )
}

internal object Route6_EventScript_Nancy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_NANCY,
          Route6.NancyIntro,
          Route6.NancyDefeat,
          Route6.NancyPostBattle,
      )
}

internal object Route6_EventScript_Elijah : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_ELIJAH,
          Route6.ElijahIntro,
          Route6.ElijahDefeat,
          Route6.ElijahPostBattle,
      )
}

internal object Route6_EventScript_Isabelle : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_ISABELLE,
          Route6.IsabelleIntro,
          Route6.IsabelleDefeat,
          Route6.IsabellePostBattle,
      )
}

internal object Route6_EventScript_Jeff : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_JEFF,
          Route6.JeffIntro,
          Route6.JeffDefeat,
          Route6.JeffPostBattle,
      )
}

internal object Route6_EventScript_UndergroundPathSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route6.UndergroundPathSign)
}

internal val Route6Scripts: Map<String, Script> =
    mapOf(
        "Route6_EventScript_Keigo" to Route6_EventScript_Keigo,
        "Route6_EventScript_Ricky" to Route6_EventScript_Ricky,
        "Route6_EventScript_Nancy" to Route6_EventScript_Nancy,
        "Route6_EventScript_Elijah" to Route6_EventScript_Elijah,
        "Route6_EventScript_Isabelle" to Route6_EventScript_Isabelle,
        "Route6_EventScript_Jeff" to Route6_EventScript_Jeff,
        "Route6_EventScript_UndergroundPathSign" to Route6_EventScript_UndergroundPathSign,
    )
