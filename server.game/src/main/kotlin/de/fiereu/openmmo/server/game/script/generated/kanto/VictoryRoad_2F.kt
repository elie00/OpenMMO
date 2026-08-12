package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.dialog.generated.kanto.VictoryRoad_2F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object VictoryRoad_2F_EventScript_Dawson : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_POKEMANIAC_DAWSON,
          VictoryRoad_2F.DawsonIntro,
          VictoryRoad_2F.DawsonDefeat,
          VictoryRoad_2F.DawsonPostBattle,
      )
}

internal object VictoryRoad_2F_EventScript_Daisuke : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_DAISUKE,
          VictoryRoad_2F.DaisukeIntro,
          VictoryRoad_2F.DaisukeDefeat,
          VictoryRoad_2F.DaisukePostBattle,
      )
}

internal object VictoryRoad_2F_EventScript_Nelson : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_NELSON,
          VictoryRoad_2F.NelsonIntro,
          VictoryRoad_2F.NelsonDefeat,
          VictoryRoad_2F.NelsonPostBattle,
      )
}

internal object VictoryRoad_2F_EventScript_Vincent : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TAMER_VINCENT,
          VictoryRoad_2F.VincentIntro,
          VictoryRoad_2F.VincentDefeat,
          VictoryRoad_2F.VincentPostBattle,
      )
}

internal object VictoryRoad_2F_EventScript_Gregory : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_GREGORY,
          VictoryRoad_2F.GregoryIntro,
          VictoryRoad_2F.GregoryDefeat,
          VictoryRoad_2F.GregoryPostBattle,
      )
}

internal object VictoryRoad_2F_EventScript_ItemGuardSpec : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.GUARD_SPEC)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_2F_GUARD_SPEC)
  }
}

internal object VictoryRoad_2F_EventScript_ItemTM07 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM07)) return
    ctx.removeNpc(6)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_2F_TM07)
  }
}

internal object VictoryRoad_2F_EventScript_ItemFullHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_HEAL)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_2F_FULL_HEAL)
  }
}

internal object VictoryRoad_2F_EventScript_ItemTM37 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM37)) return
    ctx.removeNpc(8)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_2F_TM37)
  }
}

internal object VictoryRoad_2F_EventScript_DoubleEdgeTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      moveTutor(
          ctx,
          KantoFlags.FLAG_TUTOR_DOUBLE_EDGE,
          Misc.Text_DoubleEdgeTeach,
          Misc.Text_DoubleEdgeDeclined,
          Misc.Text_DoubleEdgeTaught,
      )
}

internal val VictoryRoad_2FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_2F_EventScript_Dawson" to VictoryRoad_2F_EventScript_Dawson,
        "VictoryRoad_2F_EventScript_Daisuke" to VictoryRoad_2F_EventScript_Daisuke,
        "VictoryRoad_2F_EventScript_Nelson" to VictoryRoad_2F_EventScript_Nelson,
        "VictoryRoad_2F_EventScript_Vincent" to VictoryRoad_2F_EventScript_Vincent,
        "VictoryRoad_2F_EventScript_Gregory" to VictoryRoad_2F_EventScript_Gregory,
        "VictoryRoad_2F_EventScript_ItemGuardSpec" to VictoryRoad_2F_EventScript_ItemGuardSpec,
        "VictoryRoad_2F_EventScript_ItemTM07" to VictoryRoad_2F_EventScript_ItemTM07,
        "VictoryRoad_2F_EventScript_ItemFullHeal" to VictoryRoad_2F_EventScript_ItemFullHeal,
        "VictoryRoad_2F_EventScript_ItemTM37" to VictoryRoad_2F_EventScript_ItemTM37,
        "VictoryRoad_2F_EventScript_DoubleEdgeTutor" to VictoryRoad_2F_EventScript_DoubleEdgeTutor,
    )
