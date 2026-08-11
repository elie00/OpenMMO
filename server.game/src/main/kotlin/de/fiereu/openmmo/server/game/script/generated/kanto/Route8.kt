package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route8
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route8_EventScript_Julia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_JULIA,
          Route8.JuliaIntro,
          Route8.JuliaDefeat,
          Route8.JuliaPostBattle,
      )
}

internal object Route8_EventScript_Rich : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GAMER_RICH,
          Route8.RichIntro,
          Route8.RichDefeat,
          Route8.RichPostBattle,
      )
}

internal object Route8_EventScript_Glenn : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_GLENN,
          Route8.GlennIntro,
          Route8.GlennDefeat,
          Route8.GlennPostBattle,
      )
}

internal object Route8_EventScript_Paige : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_PAIGE,
          Route8.PaigeIntro,
          Route8.PaigeDefeat,
          Route8.PaigePostBattle,
      )
}

internal object Route8_EventScript_Leslie : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_LESLIE,
          Route8.LeslieIntro,
          Route8.LeslieDefeat,
          Route8.LesliePostBattle,
      )
}

internal object Route8_EventScript_Andrea : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_ANDREA,
          Route8.AndreaIntro,
          Route8.AndreaDefeat,
          Route8.AndreaPostBattle,
      )
}

internal object Route8_EventScript_Megan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_MEGAN,
          Route8.MeganIntro,
          Route8.MeganDefeat,
          Route8.MeganPostBattle,
      )
}

internal object Route8_EventScript_Stan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GAMER_STAN,
          Route8.StanIntro,
          Route8.StanDefeat,
          Route8.StanPostBattle,
      )
}

internal object Route8_EventScript_Aidan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_AIDAN,
          Route8.AidanIntro,
          Route8.AidanDefeat,
          Route8.AidanPostBattle,
      )
}

/** trainerbattle_double: the twins share one trainer id, fought here as a single. */
internal object Route8_EventScript_Eli : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TWINS_ELI_ANNE,
          Route8.EliIntro,
          Route8.EliDefeat,
          Route8.EliPostBattle,
      )
}

/** trainerbattle_double: the twins share one trainer id, fought here as a single. */
internal object Route8_EventScript_Anne : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TWINS_ELI_ANNE,
          Route8.AnneIntro,
          Route8.AnneDefeat,
          Route8.AnnePostBattle,
      )
}

internal object Route8_EventScript_Ricardo : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_RICARDO,
          Route8.RicardoIntro,
          Route8.RicardoDefeat,
          Route8.RicardoPostBattle,
      )
}

internal object Route8_EventScript_Jaren : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_JAREN,
          Route8.JarenIntro,
          Route8.JarenDefeat,
          Route8.JarenPostBattle,
      )
}

internal object Route8_EventScript_UndergroundPathSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route8.UndergroundPathSign)
}

internal val Route8Scripts: Map<String, Script> =
    mapOf(
        "Route8_EventScript_Julia" to Route8_EventScript_Julia,
        "Route8_EventScript_Rich" to Route8_EventScript_Rich,
        "Route8_EventScript_Glenn" to Route8_EventScript_Glenn,
        "Route8_EventScript_Paige" to Route8_EventScript_Paige,
        "Route8_EventScript_Leslie" to Route8_EventScript_Leslie,
        "Route8_EventScript_Andrea" to Route8_EventScript_Andrea,
        "Route8_EventScript_Megan" to Route8_EventScript_Megan,
        "Route8_EventScript_Stan" to Route8_EventScript_Stan,
        "Route8_EventScript_Aidan" to Route8_EventScript_Aidan,
        "Route8_EventScript_Eli" to Route8_EventScript_Eli,
        "Route8_EventScript_Anne" to Route8_EventScript_Anne,
        "Route8_EventScript_Ricardo" to Route8_EventScript_Ricardo,
        "Route8_EventScript_Jaren" to Route8_EventScript_Jaren,
        "Route8_EventScript_UndergroundPathSign" to Route8_EventScript_UndergroundPathSign,
    )
