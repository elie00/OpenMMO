package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_4F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_4F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_27,
          SilphCo_4F.Grunt2Intro,
          SilphCo_4F.Grunt2Defeat,
          SilphCo_4F.Grunt2PostBattle,
      )
}

internal object SilphCo_4F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_26,
          SilphCo_4F.Grunt1Intro,
          SilphCo_4F.Grunt1Defeat,
          SilphCo_4F.Grunt1PostBattle,
      )
}

internal object SilphCo_4F_EventScript_Rodney : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_RODNEY,
          SilphCo_4F.RodneyIntro,
          SilphCo_4F.RodneyDefeat,
          SilphCo_4F.RodneyPostBattle,
      )
}

internal object SilphCo_4F_EventScript_WorkerM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_4F.TeamRocketIsGone
          else SilphCo_4F.CantYouSeeImHiding)
}

internal object SilphCo_4F_EventScript_ItemMaxRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_REVIVE)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_4F_MAX_REVIVE)
  }
}

internal object SilphCo_4F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ESCAPE_ROPE)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_4F_ESCAPE_ROPE)
  }
}

internal object SilphCo_4F_EventScript_ItemFullHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_HEAL)) return
    ctx.removeNpc(6)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_4F_FULL_HEAL)
  }
}

internal object SilphCo_4F_EventScript_ItemTM41 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM41)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_4F_TM41)
  }
}

internal object SilphCo_4F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_4F_DOOR_1)
}

internal object SilphCo_4F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_4F_DOOR_2)
}

internal object SilphCo_4F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_4F.FloorSign)
}

internal val SilphCo_4FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_4F_EventScript_Grunt2" to SilphCo_4F_EventScript_Grunt2,
        "SilphCo_4F_EventScript_Grunt1" to SilphCo_4F_EventScript_Grunt1,
        "SilphCo_4F_EventScript_Rodney" to SilphCo_4F_EventScript_Rodney,
        "SilphCo_4F_EventScript_WorkerM" to SilphCo_4F_EventScript_WorkerM,
        "SilphCo_4F_EventScript_ItemMaxRevive" to SilphCo_4F_EventScript_ItemMaxRevive,
        "SilphCo_4F_EventScript_ItemEscapeRope" to SilphCo_4F_EventScript_ItemEscapeRope,
        "SilphCo_4F_EventScript_ItemFullHeal" to SilphCo_4F_EventScript_ItemFullHeal,
        "SilphCo_4F_EventScript_ItemTM41" to SilphCo_4F_EventScript_ItemTM41,
        "SilphCo_4F_EventScript_Door1" to SilphCo_4F_EventScript_Door1,
        "SilphCo_4F_EventScript_Door2" to SilphCo_4F_EventScript_Door2,
        "SilphCo_4F_EventScript_FloorSign" to SilphCo_4F_EventScript_FloorSign,
    )
