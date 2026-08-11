package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route24
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_TM45_BALL = 7

// The six trainers up the bridge each ask ShouldTryRematchBattle before their post battle line,
// which only the Vs Seeker can answer TRUE, so each takes the branch a fresh save takes.

/** The prize at the top of Nugget Bridge, which turns out to be a Rocket recruiter. */
internal object Route24_EventScript_Rocket : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_ROUTE24) == 1) {
      return ctx.say(Route24.YoudBecomeTopRocketLeader)
    }
    ctx.say(Route24.JustEarnedFabulousPrize)
    if (!ctx.giveItem(Items.NUGGET)) {
      return ctx.say(Route24.YouDontHaveAnyRoom)
    }
    ctx.say(Route24.ReceivedNuggetFromMysteryTrainer)
    // trainerbattle_no_intro: the recruitment pitch is the intro box.
    ctx.say(Route24.JoinTeamRocket)
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_6) != BattleResult.VICTORY) {
      return
    }
    ctx.say(Route24.RocketDefeat)
    ctx.say(Route24.YoudBecomeTopRocketLeader)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE24, 1)
  }
}

internal object Route24_EventScript_Ethan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_ETHAN,
          Route24.EthanIntro,
          Route24.EthanDefeat,
          Route24.EthanPostBattle,
      )
}

internal object Route24_EventScript_Reli : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_RELI,
          Route24.ReliIntro,
          Route24.ReliDefeat,
          Route24.ReliPostBattle,
      )
}

internal object Route24_EventScript_Timmy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_TIMMY,
          Route24.TimmyIntro,
          Route24.TimmyDefeat,
          Route24.TimmyPostBattle,
      )
}

internal object Route24_EventScript_Ali : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_ALI,
          Route24.AliIntro,
          Route24.AliDefeat,
          Route24.AliPostBattle,
      )
}

internal object Route24_EventScript_Cale : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_CALE,
          Route24.CaleIntro,
          Route24.CaleDefeat,
          Route24.CalePostBattle,
      )
}

internal object Route24_EventScript_Shane : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_SHANE,
          Route24.ShaneIntro,
          Route24.ShaneDefeat,
          Route24.ShanePostBattle,
      )
}

internal object Route24_EventScript_ItemTM45 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM45)) return
    ctx.removeNpc(LOCALID_TM45_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE24_TM45)
  }
}

/** The recruiter blocks the top of the bridge, which the map's two coord events fire. */
internal object Route24_EventScript_RocketTrigger : Script {
  override suspend fun run(ctx: ScriptContext) = Route24_EventScript_Rocket.run(ctx)
}

internal object Route24_EventScript_RocketTriggerLeft : Script {
  override suspend fun run(ctx: ScriptContext) = Route24_EventScript_RocketTrigger.run(ctx)
}

internal object Route24_EventScript_RocketTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) = Route24_EventScript_RocketTrigger.run(ctx)
}

internal val Route24Scripts: Map<String, Script> =
    mapOf(
        "Route24_EventScript_RocketTrigger" to Route24_EventScript_RocketTrigger,
        "Route24_EventScript_RocketTriggerLeft" to Route24_EventScript_RocketTriggerLeft,
        "Route24_EventScript_RocketTriggerRight" to Route24_EventScript_RocketTriggerRight,
        "Route24_EventScript_Rocket" to Route24_EventScript_Rocket,
        "Route24_EventScript_Ethan" to Route24_EventScript_Ethan,
        "Route24_EventScript_Reli" to Route24_EventScript_Reli,
        "Route24_EventScript_Timmy" to Route24_EventScript_Timmy,
        "Route24_EventScript_Ali" to Route24_EventScript_Ali,
        "Route24_EventScript_Cale" to Route24_EventScript_Cale,
        "Route24_EventScript_Shane" to Route24_EventScript_Shane,
        "Route24_EventScript_ItemTM45" to Route24_EventScript_ItemTM45,
    )
