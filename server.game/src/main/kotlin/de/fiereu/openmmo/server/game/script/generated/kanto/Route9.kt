package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route9
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route9_EventScript_Alicia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_ALICIA,
          Route9.AliciaIntro,
          Route9.AliciaDefeat,
          Route9.AliciaPostBattle,
      )
}

internal object Route9_EventScript_Jeremy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_JEREMY,
          Route9.JeremyIntro,
          Route9.JeremyDefeat,
          Route9.JeremyPostBattle,
      )
}

internal object Route9_EventScript_Alan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_ALAN,
          Route9.AlanIntro,
          Route9.AlanDefeat,
          Route9.AlanPostBattle,
      )
}

internal object Route9_EventScript_Chris : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_CHRIS,
          Route9.ChrisIntro,
          Route9.ChrisDefeat,
          Route9.ChrisPostBattle,
      )
}

internal object Route9_EventScript_Brent : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_BRENT,
          Route9.BrentIntro,
          Route9.BrentDefeat,
          Route9.BrentPostBattle,
      )
}

internal object Route9_EventScript_Conner : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_CONNER,
          Route9.ConnerIntro,
          Route9.ConnerDefeat,
          Route9.ConnerPostBattle,
      )
}

internal object Route9_EventScript_Brice : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_BRICE,
          Route9.BriceIntro,
          Route9.BriceDefeat,
          Route9.BricePostBattle,
      )
}

internal object Route9_EventScript_Caitlin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_CAITLIN,
          Route9.CaitlinIntro,
          Route9.CaitlinDefeat,
          Route9.CaitlinPostBattle,
      )
}

internal object Route9_EventScript_Drew : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_DREW,
          Route9.DrewIntro,
          Route9.DrewDefeat,
          Route9.DrewPostBattle,
      )
}

internal object Route9_EventScript_ItemTM40 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM40)) return
    ctx.removeNpc(10)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE9_TM40)
  }
}

internal object Route9_EventScript_ItemBurnHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.BURN_HEAL)) return
    ctx.removeNpc(11)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE9_BURN_HEAL)
  }
}

internal object Route9_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route9.RouteSign)
}

internal val Route9Scripts: Map<String, Script> =
    mapOf(
        "Route9_EventScript_Alicia" to Route9_EventScript_Alicia,
        "Route9_EventScript_Jeremy" to Route9_EventScript_Jeremy,
        "Route9_EventScript_Alan" to Route9_EventScript_Alan,
        "Route9_EventScript_Chris" to Route9_EventScript_Chris,
        "Route9_EventScript_Brent" to Route9_EventScript_Brent,
        "Route9_EventScript_Conner" to Route9_EventScript_Conner,
        "Route9_EventScript_Brice" to Route9_EventScript_Brice,
        "Route9_EventScript_Caitlin" to Route9_EventScript_Caitlin,
        "Route9_EventScript_Drew" to Route9_EventScript_Drew,
        "Route9_EventScript_ItemTM40" to Route9_EventScript_ItemTM40,
        "Route9_EventScript_ItemBurnHeal" to Route9_EventScript_ItemBurnHeal,
        "Route9_EventScript_RouteSign" to Route9_EventScript_RouteSign,
    )
