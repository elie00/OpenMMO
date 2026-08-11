package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object FuchsiaCity_Gym_EventScript_Kayden : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_KAYDEN,
          FuchsiaCity_Gym.KaydenIntro,
          FuchsiaCity_Gym.KaydenDefeat,
          FuchsiaCity_Gym.KaydenPostBattle,
      )
}

internal object FuchsiaCity_Gym_EventScript_Shawn : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_SHAWN,
          FuchsiaCity_Gym.ShawnIntro,
          FuchsiaCity_Gym.ShawnDefeat,
          FuchsiaCity_Gym.ShawnPostBattle,
      )
}

internal object FuchsiaCity_Gym_EventScript_Kirk : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_KIRK,
          FuchsiaCity_Gym.KirkIntro,
          FuchsiaCity_Gym.KirkDefeat,
          FuchsiaCity_Gym.KirkPostBattle,
      )
}

internal object FuchsiaCity_Gym_EventScript_Edgar : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TAMER_EDGAR,
          FuchsiaCity_Gym.EdgarIntro,
          FuchsiaCity_Gym.EdgarDefeat,
          FuchsiaCity_Gym.EdgarPostBattle,
      )
}

internal object FuchsiaCity_Gym_EventScript_Phil : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TAMER_PHIL,
          FuchsiaCity_Gym.PhilIntro,
          FuchsiaCity_Gym.PhilDefeat,
          FuchsiaCity_Gym.PhilPostBattle,
      )
}

internal object FuchsiaCity_Gym_EventScript_Nate : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_NATE,
          FuchsiaCity_Gym.NateIntro,
          FuchsiaCity_Gym.NateDefeat,
          FuchsiaCity_Gym.NatePostBattle,
      )
}

internal object FuchsiaCity_Gym_EventScript_Koga : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_KOGA)) {
      ctx.say(FuchsiaCity_Gym.KogaIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_KOGA) != BattleResult.VICTORY) return
      ctx.say(FuchsiaCity_Gym.KogaDefeat)
      return FuchsiaCity_Gym_EventScript_DefeatedKoga.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM06_FROM_KOGA)) {
      return FuchsiaCity_Gym_EventScript_GiveTM06.run(ctx)
    }
    ctx.say(FuchsiaCity_Gym.KogaPostBattle)
  }
}

internal object FuchsiaCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_KOGA)) {
      return ctx.say(FuchsiaCity_Gym.GymGuyPostVictory)
    }
    ctx.say(FuchsiaCity_Gym.GymGuyAdvice)
  }
}

internal object FuchsiaCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE05_GET)) {
      return ctx.sign(FuchsiaCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(FuchsiaCity_Gym.GymStatue)
  }
}

/** What the fifth badge changes, run straight after Koga's defeat line. */
internal object FuchsiaCity_Gym_EventScript_DefeatedKoga : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.clearFlag(KantoFlags.FLAG_HIDE_FAME_CHECKER_KOGA_JOURNAL)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_KOGA)
    ctx.setFlag(KantoFlags.FLAG_BADGE05_GET)
    // set_gym_trainers 5: this gym's six trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_TAMER_PHIL)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_TAMER_EDGAR)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_JUGGLER_KIRK)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_JUGGLER_SHAWN)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_JUGGLER_KAYDEN)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_JUGGLER_NATE)
    FuchsiaCity_Gym_EventScript_GiveTM06.run(ctx)
  }
}

internal object FuchsiaCity_Gym_EventScript_GiveTM06 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_Gym.KogaExplainSoulBadge)
    if (!ctx.giveItem(Items.TM06)) {
      return ctx.say(FuchsiaCity_Gym.MakeSpaceForThis)
    }
    ctx.say(FuchsiaCity_Gym.ReceivedTM06FromKoga)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM06_FROM_KOGA)
    ctx.say(FuchsiaCity_Gym.KogaExplainTM06)
  }
}

internal val FuchsiaCity_GymScripts: Map<String, Script> =
    mapOf(
        "FuchsiaCity_Gym_EventScript_DefeatedKoga" to FuchsiaCity_Gym_EventScript_DefeatedKoga,
        "FuchsiaCity_Gym_EventScript_GiveTM06" to FuchsiaCity_Gym_EventScript_GiveTM06,
        "FuchsiaCity_Gym_EventScript_Kayden" to FuchsiaCity_Gym_EventScript_Kayden,
        "FuchsiaCity_Gym_EventScript_Shawn" to FuchsiaCity_Gym_EventScript_Shawn,
        "FuchsiaCity_Gym_EventScript_Kirk" to FuchsiaCity_Gym_EventScript_Kirk,
        "FuchsiaCity_Gym_EventScript_Edgar" to FuchsiaCity_Gym_EventScript_Edgar,
        "FuchsiaCity_Gym_EventScript_Phil" to FuchsiaCity_Gym_EventScript_Phil,
        "FuchsiaCity_Gym_EventScript_Nate" to FuchsiaCity_Gym_EventScript_Nate,
        "FuchsiaCity_Gym_EventScript_Koga" to FuchsiaCity_Gym_EventScript_Koga,
        "FuchsiaCity_Gym_EventScript_GymGuy" to FuchsiaCity_Gym_EventScript_GymGuy,
        "FuchsiaCity_Gym_EventScript_GymStatue" to FuchsiaCity_Gym_EventScript_GymStatue,
    )
