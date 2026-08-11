package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_10F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_10F_EventScript_Travis : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_TRAVIS,
          SilphCo_10F.TravisIntro,
          SilphCo_10F.TravisDefeat,
          SilphCo_10F.TravisPostBattle,
      )
}

internal object SilphCo_10F_EventScript_WorkerF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_10F.KeepMeCryingASecret
          else SilphCo_10F.WaaaImScared)
}

internal object SilphCo_10F_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_39,
          SilphCo_10F.GruntIntro,
          SilphCo_10F.GruntDefeat,
          SilphCo_10F.GruntPostBattle,
      )
}

internal object SilphCo_10F_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CARBOS)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_10F_CARBOS)
  }
}

internal object SilphCo_10F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ULTRA_BALL)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_10F_ULTRA_BALL)
  }
}

internal object SilphCo_10F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.RARE_CANDY)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_10F_RARE_CANDY)
  }
}

internal object SilphCo_10F_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_10F_DOOR)
}

internal object SilphCo_10F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_10F.FloorSign)
}

internal val SilphCo_10FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_10F_EventScript_Travis" to SilphCo_10F_EventScript_Travis,
        "SilphCo_10F_EventScript_WorkerF" to SilphCo_10F_EventScript_WorkerF,
        "SilphCo_10F_EventScript_Grunt" to SilphCo_10F_EventScript_Grunt,
        "SilphCo_10F_EventScript_ItemCarbos" to SilphCo_10F_EventScript_ItemCarbos,
        "SilphCo_10F_EventScript_ItemUltraBall" to SilphCo_10F_EventScript_ItemUltraBall,
        "SilphCo_10F_EventScript_ItemRareCandy" to SilphCo_10F_EventScript_ItemRareCandy,
        "SilphCo_10F_EventScript_Door" to SilphCo_10F_EventScript_Door,
        "SilphCo_10F_EventScript_FloorSign" to SilphCo_10F_EventScript_FloorSign,
    )
