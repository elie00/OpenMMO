package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route17
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route17_EventScript_Virgil : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_VIRGIL,
          Route17.VirgilIntro,
          Route17.VirgilDefeat,
          Route17.VirgilPostBattle,
      )
}

internal object Route17_EventScript_Isaiah : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_ISAIAH,
          Route17.IsaiahIntro,
          Route17.IsaiahDefeat,
          Route17.IsaiahPostBattle,
      )
}

internal object Route17_EventScript_Raul : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_RAUL,
          Route17.RaulIntro,
          Route17.RaulDefeat,
          Route17.RaulPostBattle,
      )
}

internal object Route17_EventScript_Nikolas : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_NIKOLAS,
          Route17.NikolasIntro,
          Route17.NikolasDefeat,
          Route17.NikolasPostBattle,
      )
}

internal object Route17_EventScript_Billy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_BILLY,
          Route17.BillyIntro,
          Route17.BillyDefeat,
          Route17.BillyPostBattle,
      )
}

internal object Route17_EventScript_Jamal : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_JAMAL,
          Route17.JamalIntro,
          Route17.JamalDefeat,
          Route17.JamalPostBattle,
      )
}

internal object Route17_EventScript_Zeek : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_ZEEK,
          Route17.ZeekIntro,
          Route17.ZeekDefeat,
          Route17.ZeekPostBattle,
      )
}

internal object Route17_EventScript_Corey : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_COREY,
          Route17.CoreyIntro,
          Route17.CoreyDefeat,
          Route17.CoreyPostBattle,
      )
}

internal object Route17_EventScript_William : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_WILLIAM,
          Route17.WilliamIntro,
          Route17.WilliamDefeat,
          Route17.WilliamPostBattle,
      )
}

internal object Route17_EventScript_Jaxon : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_JAXON,
          Route17.JaxonIntro,
          Route17.JaxonDefeat,
          Route17.JaxonPostBattle,
      )
}

internal object Route17_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route17.RouteSign)
}

internal object Route17_EventScript_TrainerTips2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route17.PressBToStayInPlace)
}

internal object Route17_EventScript_TrainerTips1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route17.SameSpeciesGrowDifferentRates)
}

internal object Route17_EventScript_ItemsNotice : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route17.WatchOutForDiscardedItems)
}

internal object Route17_EventScript_BallsNotice : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route17.DontThrowGameThrowBalls)
}

internal object Route17_EventScript_CyclingRoadSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route17.CyclingRoadSign)
}

internal val Route17Scripts: Map<String, Script> =
    mapOf(
        "Route17_EventScript_Virgil" to Route17_EventScript_Virgil,
        "Route17_EventScript_Isaiah" to Route17_EventScript_Isaiah,
        "Route17_EventScript_Raul" to Route17_EventScript_Raul,
        "Route17_EventScript_Nikolas" to Route17_EventScript_Nikolas,
        "Route17_EventScript_Billy" to Route17_EventScript_Billy,
        "Route17_EventScript_Jamal" to Route17_EventScript_Jamal,
        "Route17_EventScript_Zeek" to Route17_EventScript_Zeek,
        "Route17_EventScript_Corey" to Route17_EventScript_Corey,
        "Route17_EventScript_William" to Route17_EventScript_William,
        "Route17_EventScript_Jaxon" to Route17_EventScript_Jaxon,
        "Route17_EventScript_RouteSign" to Route17_EventScript_RouteSign,
        "Route17_EventScript_TrainerTips2" to Route17_EventScript_TrainerTips2,
        "Route17_EventScript_TrainerTips1" to Route17_EventScript_TrainerTips1,
        "Route17_EventScript_ItemsNotice" to Route17_EventScript_ItemsNotice,
        "Route17_EventScript_BallsNotice" to Route17_EventScript_BallsNotice,
        "Route17_EventScript_CyclingRoadSign" to Route17_EventScript_CyclingRoadSign,
    )
