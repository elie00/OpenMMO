package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route25
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_TM43_BALL = 9

internal object Route25_EventScript_Franklin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_FRANKLIN,
          Route25.FranklinIntro,
          Route25.FranklinDefeat,
          Route25.FranklinPostBattle,
      )
}

internal object Route25_EventScript_Joey : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_JOEY,
          Route25.JoeyIntro,
          Route25.JoeyDefeat,
          Route25.JoeyPostBattle,
      )
}

internal object Route25_EventScript_Wayne : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_WAYNE,
          Route25.WayneIntro,
          Route25.WayneDefeat,
          Route25.WaynePostBattle,
      )
}

internal object Route25_EventScript_Dan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_DAN,
          Route25.DanIntro,
          Route25.DanDefeat,
          Route25.DanPostBattle,
      )
}

internal object Route25_EventScript_Kelsey : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_KELSEY,
          Route25.KelseyIntro,
          Route25.KelseyDefeat,
          Route25.KelseyPostBattle,
      )
}

internal object Route25_EventScript_Nob : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_NOB,
          Route25.NobIntro,
          Route25.NobDefeat,
          Route25.NobPostBattle,
      )
}

internal object Route25_EventScript_Flint : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_FLINT,
          Route25.FlintIntro,
          Route25.FlintDefeat,
          Route25.FlintPostBattle,
      )
}

internal object Route25_EventScript_Chad : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_CHAD,
          Route25.ChadIntro,
          Route25.ChadDefeat,
          Route25.ChadPostBattle,
      )
}

internal object Route25_EventScript_Haley : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_HALEY,
          Route25.HaleyIntro,
          Route25.HaleyDefeat,
          Route25.HaleyPostBattle,
      )
}

internal object Route25_EventScript_ItemTM43 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM43)) return
    ctx.removeNpc(LOCALID_TM43_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE25_TM43)
  }
}

internal object Route25_EventScript_Beauty : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route25.MistyHighHopesAboutThisPlace)
}

internal object Route25_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route25.AreYouHereAlone)
}

internal object Route25_EventScript_SeaCottageSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route25.SeaCottageSign)
}

internal val Route25Scripts: Map<String, Script> =
    mapOf(
        "Route25_EventScript_Franklin" to Route25_EventScript_Franklin,
        "Route25_EventScript_Joey" to Route25_EventScript_Joey,
        "Route25_EventScript_Wayne" to Route25_EventScript_Wayne,
        "Route25_EventScript_Dan" to Route25_EventScript_Dan,
        "Route25_EventScript_Kelsey" to Route25_EventScript_Kelsey,
        "Route25_EventScript_Nob" to Route25_EventScript_Nob,
        "Route25_EventScript_Flint" to Route25_EventScript_Flint,
        "Route25_EventScript_Chad" to Route25_EventScript_Chad,
        "Route25_EventScript_Haley" to Route25_EventScript_Haley,
        "Route25_EventScript_ItemTM43" to Route25_EventScript_ItemTM43,
        "Route25_EventScript_Beauty" to Route25_EventScript_Beauty,
        "Route25_EventScript_Man" to Route25_EventScript_Man,
        "Route25_EventScript_SeaCottageSign" to Route25_EventScript_SeaCottageSign,
    )
