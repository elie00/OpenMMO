package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_11F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SilphCo_11F_EventScript_President : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_MASTER_BALL_FROM_SILPH)) {
      return ctx.say(SilphCo_11F.ThatsOurSecretPrototype)
    }
    ctx.say(
        if (ctx.isFemale) SilphCo_11F.ThanksForSavingMeDearGirl
        else SilphCo_11F.ThanksForSavingMeDearBoy)
    if (!ctx.giveItem(Items.MASTER_BALL)) {
      return ctx.say(SilphCo_11F.YouHaveNoRoomForThis)
    }
    ctx.say(SilphCo_11F.ObtainedMasterBallFromPresident)
    ctx.say(SilphCo_11F.ThatsOurSecretPrototype)
    ctx.setFlag(KantoFlags.FLAG_GOT_MASTER_BALL_FROM_SILPH)
  }
}

internal object SilphCo_11F_EventScript_Secretary : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SilphCo_11F.ThanksForRescuingUs)
}

internal object SilphCo_11F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_40,
          SilphCo_11F.Grunt1Intro,
          SilphCo_11F.Grunt1Defeat,
          SilphCo_11F.Grunt1PostBattle,
      )
}

internal object SilphCo_11F_EventScript_ItemZinc : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ZINC)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_11F_ZINC)
  }
}

internal object SilphCo_11F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_41,
          SilphCo_11F.Grunt2Intro,
          SilphCo_11F.Grunt2Defeat,
          SilphCo_11F.Grunt2PostBattle,
      )
}

internal object SilphCo_11F_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_11F_DOOR)
}

internal object SilphCo_11F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_11F.FloorSign)
}

internal val SilphCo_11FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_11F_EventScript_President" to SilphCo_11F_EventScript_President,
        "SilphCo_11F_EventScript_Secretary" to SilphCo_11F_EventScript_Secretary,
        "SilphCo_11F_EventScript_Grunt1" to SilphCo_11F_EventScript_Grunt1,
        "SilphCo_11F_EventScript_ItemZinc" to SilphCo_11F_EventScript_ItemZinc,
        "SilphCo_11F_EventScript_Grunt2" to SilphCo_11F_EventScript_Grunt2,
        "SilphCo_11F_EventScript_Door" to SilphCo_11F_EventScript_Door,
        "SilphCo_11F_EventScript_FloorSign" to SilphCo_11F_EventScript_FloorSign,
    )
