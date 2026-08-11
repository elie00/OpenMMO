package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route3
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Every trainer here asks ShouldTryRematchBattle before its post battle line. Rematches are armed
// by the Vs Seeker, which has no equivalent, so the special always answers FALSE and each script
// takes the branch a fresh save takes.

internal object Route3_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route3.TunnelFromCeruleanTiring)
}

internal object Route3_EventScript_Robin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_ROBIN,
          Route3.RobinIntro,
          Route3.RobinDefeat,
          Route3.RobinPostBattle,
      )
}

internal object Route3_EventScript_James : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_JAMES,
          Route3.JamesIntro,
          Route3.JamesDefeat,
          Route3.JamesPostBattle,
      )
}

internal object Route3_EventScript_Sally : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_SALLY,
          Route3.SallyIntro,
          Route3.SallyDefeat,
          Route3.SallyPostBattle,
      )
}

internal object Route3_EventScript_Greg : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_GREG,
          Route3.GregIntro,
          Route3.GregDefeat,
          Route3.GregPostBattle,
      )
}

internal object Route3_EventScript_Calvin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_CALVIN,
          Route3.CalvinIntro,
          Route3.CalvinDefeat,
          Route3.CalvinPostBattle,
      )
}

internal object Route3_EventScript_Janice : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_JANICE,
          Route3.JaniceIntro,
          Route3.JaniceDefeat,
          Route3.JanicePostBattle,
      )
}

internal object Route3_EventScript_Colton : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_COLTON,
          Route3.ColtonIntro,
          Route3.ColtonDefeat,
          Route3.ColtonPostBattle,
      )
}

internal object Route3_EventScript_Ben : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_BEN,
          Route3.BenIntro,
          Route3.BenDefeat,
          Route3.BenPostBattle,
      )
}

internal object Route3_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route3.RouteSign)
}

internal val Route3Scripts: Map<String, Script> =
    mapOf(
        "Route3_EventScript_Youngster" to Route3_EventScript_Youngster,
        "Route3_EventScript_Robin" to Route3_EventScript_Robin,
        "Route3_EventScript_James" to Route3_EventScript_James,
        "Route3_EventScript_Sally" to Route3_EventScript_Sally,
        "Route3_EventScript_Greg" to Route3_EventScript_Greg,
        "Route3_EventScript_Calvin" to Route3_EventScript_Calvin,
        "Route3_EventScript_Janice" to Route3_EventScript_Janice,
        "Route3_EventScript_Colton" to Route3_EventScript_Colton,
        "Route3_EventScript_Ben" to Route3_EventScript_Ben,
        "Route3_EventScript_RouteSign" to Route3_EventScript_RouteSign,
    )
