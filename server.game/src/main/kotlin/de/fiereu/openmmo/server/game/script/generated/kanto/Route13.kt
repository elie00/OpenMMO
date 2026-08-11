package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route13
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route13_EventScript_Alma : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_ALMA,
          Route13.AlmaIntro,
          Route13.AlmaDefeat,
          Route13.AlmaPostBattle,
      )
}

internal object Route13_EventScript_Sebastian : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIRD_KEEPER_SEBASTIAN,
          Route13.SebastianIntro,
          Route13.SebastianDefeat,
          Route13.SebastianPostBattle,
      )
}

internal object Route13_EventScript_Susie : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_SUSIE,
          Route13.SusieIntro,
          Route13.SusieDefeat,
          Route13.SusiePostBattle,
      )
}

internal object Route13_EventScript_Sheila : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_SHEILA,
          Route13.SheilaIntro,
          Route13.SheilaDefeat,
          Route13.SheilaPostBattle,
      )
}

internal object Route13_EventScript_Lola : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_LOLA,
          Route13.LolaIntro,
          Route13.LolaDefeat,
          Route13.LolaPostBattle,
      )
}

internal object Route13_EventScript_Valerie : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_VALERIE,
          Route13.ValerieIntro,
          Route13.ValerieDefeat,
          Route13.ValeriePostBattle,
      )
}

internal object Route13_EventScript_Gwen : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_GWEN,
          Route13.GwenIntro,
          Route13.GwenDefeat,
          Route13.GwenPostBattle,
      )
}

internal object Route13_EventScript_Robert : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIRD_KEEPER_ROBERT,
          Route13.RobertIntro,
          Route13.RobertDefeat,
          Route13.RobertPostBattle,
      )
}

internal object Route13_EventScript_Perry : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIRD_KEEPER_PERRY,
          Route13.PerryIntro,
          Route13.PerryDefeat,
          Route13.PerryPostBattle,
      )
}

internal object Route13_EventScript_Jared : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_JARED,
          Route13.JaredIntro,
          Route13.JaredDefeat,
          Route13.JaredPostBattle,
      )
}

internal object Route13_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route13.RouteSign)
}

internal object Route13_EventScript_TrainerTips2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route13.SelectToSwitchItems)
}

internal object Route13_EventScript_TrainerTips1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route13.LookToLeftOfThatPost)
}

internal val Route13Scripts: Map<String, Script> =
    mapOf(
        "Route13_EventScript_Alma" to Route13_EventScript_Alma,
        "Route13_EventScript_Sebastian" to Route13_EventScript_Sebastian,
        "Route13_EventScript_Susie" to Route13_EventScript_Susie,
        "Route13_EventScript_Sheila" to Route13_EventScript_Sheila,
        "Route13_EventScript_Lola" to Route13_EventScript_Lola,
        "Route13_EventScript_Valerie" to Route13_EventScript_Valerie,
        "Route13_EventScript_Gwen" to Route13_EventScript_Gwen,
        "Route13_EventScript_Robert" to Route13_EventScript_Robert,
        "Route13_EventScript_Perry" to Route13_EventScript_Perry,
        "Route13_EventScript_Jared" to Route13_EventScript_Jared,
        "Route13_EventScript_RouteSign" to Route13_EventScript_RouteSign,
        "Route13_EventScript_TrainerTips2" to Route13_EventScript_TrainerTips2,
        "Route13_EventScript_TrainerTips1" to Route13_EventScript_TrainerTips1,
    )
