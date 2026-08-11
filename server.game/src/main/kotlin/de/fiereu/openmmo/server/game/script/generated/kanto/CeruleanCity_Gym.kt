package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object CeruleanCity_Gym_EventScript_Luis : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_MALE_LUIS,
          CeruleanCity_Gym.LuisIntro,
          CeruleanCity_Gym.LuisDefeat,
          CeruleanCity_Gym.LuisPostBattle,
      )
}

internal object CeruleanCity_Gym_EventScript_Diana : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_DIANA,
          CeruleanCity_Gym.DianaIntro,
          CeruleanCity_Gym.DianaDefeat,
          CeruleanCity_Gym.DianaPostBattle,
      )
}

internal object CeruleanCity_Gym_EventScript_Misty : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_MISTY)) {
      ctx.say(CeruleanCity_Gym.MistyIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_MISTY) != BattleResult.VICTORY) return
      ctx.say(CeruleanCity_Gym.MistyDefeat)
      return CeruleanCity_Gym_EventScript_MistyDefeated.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM03_FROM_MISTY)) {
      return CeruleanCity_Gym_EventScript_GiveTM03.run(ctx)
    }
    ctx.say(CeruleanCity_Gym.ExplainTM03)
  }
}

/** What the second badge changes, run straight after Misty's defeat line. */
internal object CeruleanCity_Gym_EventScript_MistyDefeated : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_MISTY)
    ctx.setFlag(KantoFlags.FLAG_BADGE02_GET)
    // TODO Move the respawn point to Cerulean City
    //  The decomp's setrespawn sends a whiteout here instead of back to Pewter. There is no
    //  respawn verb, so a beaten player still wakes up wherever they started.
    // set_gym_trainers 2: this gym's two trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_PICNICKER_DIANA)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_SWIMMER_MALE_LUIS)
    CeruleanCity_Gym_EventScript_GiveTM03.run(ctx)
  }
}

internal object CeruleanCity_Gym_EventScript_GiveTM03 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity_Gym.ExplainCascadeBadge)
    if (!ctx.giveItem(Items.TM03)) {
      return ctx.say(CeruleanCity_Gym.BetterMakeRoomForThis)
    }
    ctx.say(CeruleanCity_Gym.ReceivedTM03FromMisty)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM03_FROM_MISTY)
    ctx.say(CeruleanCity_Gym.ExplainTM03)
  }
}

internal object CeruleanCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_MISTY)) {
      return ctx.say(CeruleanCity_Gym.WeMakePrettyGoodTeam)
    }
    ctx.say(CeruleanCity_Gym.GymGuyAdvice)
  }
}

internal object CeruleanCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE02_GET)) {
      return ctx.sign(CeruleanCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(CeruleanCity_Gym.GymStatue)
  }
}

internal val CeruleanCity_GymScripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_Gym_EventScript_Luis" to CeruleanCity_Gym_EventScript_Luis,
        "CeruleanCity_Gym_EventScript_Diana" to CeruleanCity_Gym_EventScript_Diana,
        "CeruleanCity_Gym_EventScript_Misty" to CeruleanCity_Gym_EventScript_Misty,
        "CeruleanCity_Gym_EventScript_MistyDefeated" to CeruleanCity_Gym_EventScript_MistyDefeated,
        "CeruleanCity_Gym_EventScript_GiveTM03" to CeruleanCity_Gym_EventScript_GiveTM03,
        "CeruleanCity_Gym_EventScript_GymGuy" to CeruleanCity_Gym_EventScript_GymGuy,
        "CeruleanCity_Gym_EventScript_GymStatue" to CeruleanCity_Gym_EventScript_GymStatue,
    )
