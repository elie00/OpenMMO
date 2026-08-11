package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route15
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route15_EventScript_Yazmin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_YAZMIN,
          Route15.YazminIntro,
          Route15.YazminDefeat,
          Route15.YazminPostBattle,
      )
}

internal object Route15_EventScript_Edwin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIRD_KEEPER_EDWIN,
          Route15.EdwinIntro,
          Route15.EdwinDefeat,
          Route15.EdwinPostBattle,
      )
}

internal object Route15_EventScript_Chester : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIRD_KEEPER_CHESTER,
          Route15.ChesterIntro,
          Route15.ChesterDefeat,
          Route15.ChesterPostBattle,
      )
}

internal object Route15_EventScript_Kindra : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_KINDRA,
          Route15.KindraIntro,
          Route15.KindraDefeat,
          Route15.KindraPostBattle,
      )
}

internal object Route15_EventScript_Olivia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_OLIVIA,
          Route15.OliviaIntro,
          Route15.OliviaDefeat,
          Route15.OliviaPostBattle,
      )
}

internal object Route15_EventScript_Alex : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_ALEX,
          Route15.AlexIntro,
          Route15.AlexDefeat,
          Route15.AlexPostBattle,
      )
}

internal object Route15_EventScript_Ernest : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_ERNEST,
          Route15.ErnestIntro,
          Route15.ErnestDefeat,
          Route15.ErnestPostBattle,
      )
}

internal object Route15_EventScript_Becky : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_BECKY,
          Route15.BeckyIntro,
          Route15.BeckyDefeat,
          Route15.BeckyPostBattle,
      )
}

internal object Route15_EventScript_Grace : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_GRACE,
          Route15.GraceIntro,
          Route15.GraceDefeat,
          Route15.GracePostBattle,
      )
}

internal object Route15_EventScript_Celia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_CELIA,
          Route15.CeliaIntro,
          Route15.CeliaDefeat,
          Route15.CeliaPostBattle,
      )
}

internal object Route15_EventScript_ItemTM18 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM18)) return
    ctx.removeNpc(10)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE15_TM18)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_RON_MYA, Route15_Text_RonIntro, Route15_Text_RonDefeat, Route15_Text_RonNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_RonRematch
 * msgbox Route15_Text_RonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Ron : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route15_EventScript_Ron")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_RON_MYA, Route15_Text_MyaIntro, Route15_Text_MyaDefeat, Route15_Text_MyaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route15_EventScript_MyaRematch
 * msgbox Route15_Text_MyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route15_EventScript_Mya : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route15_EventScript_Mya")
}

internal object Route15_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route15.RouteSign)
}

internal val Route15Scripts: Map<String, Script> =
    mapOf(
        "Route15_EventScript_Yazmin" to Route15_EventScript_Yazmin,
        "Route15_EventScript_Edwin" to Route15_EventScript_Edwin,
        "Route15_EventScript_Chester" to Route15_EventScript_Chester,
        "Route15_EventScript_Kindra" to Route15_EventScript_Kindra,
        "Route15_EventScript_Olivia" to Route15_EventScript_Olivia,
        "Route15_EventScript_Alex" to Route15_EventScript_Alex,
        "Route15_EventScript_Ernest" to Route15_EventScript_Ernest,
        "Route15_EventScript_Becky" to Route15_EventScript_Becky,
        "Route15_EventScript_Grace" to Route15_EventScript_Grace,
        "Route15_EventScript_Celia" to Route15_EventScript_Celia,
        "Route15_EventScript_ItemTM18" to Route15_EventScript_ItemTM18,
        "Route15_EventScript_Ron" to Route15_EventScript_Ron,
        "Route15_EventScript_Mya" to Route15_EventScript_Mya,
        "Route15_EventScript_RouteSign" to Route15_EventScript_RouteSign,
    )
