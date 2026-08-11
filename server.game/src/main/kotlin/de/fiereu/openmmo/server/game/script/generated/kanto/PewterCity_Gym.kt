package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PewterCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PewterCity_Gym_EventScript_Brock : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_BROCK)) {
      ctx.say(PewterCity_Gym.BrockIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_BROCK) != BattleResult.VICTORY) return
      ctx.say(PewterCity_Gym.BrockDefeat)
      return PewterCity_Gym_EventScript_DefeatedBrock.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM39_FROM_BROCK)) {
      return PewterCity_Gym_EventScript_GiveTM39.run(ctx)
    }
    ctx.say(PewterCity_Gym.BrockPostBattle)
  }
}

/** What winning the first badge changes, run straight after Brock's defeat line. */
internal object PewterCity_Gym_EventScript_DefeatedBrock : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_BROCK)
    ctx.setFlag(KantoFlags.FLAG_BADGE01_GET)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_PEWTER_CITY, 1)
    // The guide outside is done leading challengers here, and Oak's aide comes out with the shoes.
    ctx.setFlag(KantoFlags.FLAG_HIDE_PEWTER_CITY_GYM_GUIDE)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_PEWTER_CITY_RUNNING_SHOES_GUY)
    // set_gym_trainers 1: the gym's own trainer is retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_CAMPER_LIAM)
    PewterCity_Gym_EventScript_GiveTM39.run(ctx)
  }
}

internal object PewterCity_Gym_EventScript_GiveTM39 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity_Gym.TakeThisWithYou)
    if (!ctx.giveItem(Items.TM39)) {
      return ctx.say(PewterCity_Gym.DontHaveRoomForThis)
    }
    ctx.say(PewterCity_Gym.ReceivedTM39FromBrock)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM39_FROM_BROCK)
    ctx.say(PewterCity_Gym.ExplainTM39)
  }
}

internal object PewterCity_Gym_EventScript_Liam : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_LIAM,
          PewterCity_Gym.LiamIntro,
          PewterCity_Gym.LiamDefeat,
          PewterCity_Gym.LiamPostBattle,
      )
}

internal object PewterCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_BROCK)) {
      return ctx.say(PewterCity_Gym.YoureChampMaterial)
    }
    if (ctx.askYesNo(PewterCity_Gym.LetMeTakeYouToTheTop)) {
      ctx.say(PewterCity_Gym.LetsGetHappening)
    } else {
      ctx.say(PewterCity_Gym.ItsFreeLetsGetHappening)
    }
    ctx.say(PewterCity_Gym.TryDifferentPartyOrders)
  }
}

internal object PewterCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE01_GET)) {
      return ctx.sign(PewterCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(PewterCity_Gym.GymStatue)
  }
}

internal val PewterCity_GymScripts: Map<String, Script> =
    mapOf(
        "PewterCity_Gym_EventScript_Brock" to PewterCity_Gym_EventScript_Brock,
        "PewterCity_Gym_EventScript_DefeatedBrock" to PewterCity_Gym_EventScript_DefeatedBrock,
        "PewterCity_Gym_EventScript_GiveTM39" to PewterCity_Gym_EventScript_GiveTM39,
        "PewterCity_Gym_EventScript_Liam" to PewterCity_Gym_EventScript_Liam,
        "PewterCity_Gym_EventScript_GymGuy" to PewterCity_Gym_EventScript_GymGuy,
        "PewterCity_Gym_EventScript_GymStatue" to PewterCity_Gym_EventScript_GymStatue,
    )
