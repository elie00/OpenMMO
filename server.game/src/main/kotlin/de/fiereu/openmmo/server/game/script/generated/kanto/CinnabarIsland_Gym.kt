package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.common.dialog.DialogLine
import de.fiereu.openmmo.dialog.generated.kanto.CinnabarIsland_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object CinnabarIsland_Gym_EventScript_Quinn : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BURGLAR_QUINN,
          CinnabarIsland_Gym.QuinnIntro,
          CinnabarIsland_Gym.QuinnDefeat,
          CinnabarIsland_Gym.QuinnPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Erik : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_ERIK,
          CinnabarIsland_Gym.ErikIntro,
          CinnabarIsland_Gym.ErikDefeat,
          CinnabarIsland_Gym.ErikPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Avery : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_AVERY,
          CinnabarIsland_Gym.AveryIntro,
          CinnabarIsland_Gym.AveryDefeat,
          CinnabarIsland_Gym.AveryPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Ramon : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BURGLAR_RAMON,
          CinnabarIsland_Gym.RamonIntro,
          CinnabarIsland_Gym.RamonDefeat,
          CinnabarIsland_Gym.RamonPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Derek : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_DEREK,
          CinnabarIsland_Gym.DerekIntro,
          CinnabarIsland_Gym.DerekDefeat,
          CinnabarIsland_Gym.DerekPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Dusty : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BURGLAR_DUSTY,
          CinnabarIsland_Gym.DustyIntro,
          CinnabarIsland_Gym.DustyDefeat,
          CinnabarIsland_Gym.DustyPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Zac : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_ZAC,
          CinnabarIsland_Gym.ZacIntro,
          CinnabarIsland_Gym.ZacDefeat,
          CinnabarIsland_Gym.ZacPostBattle,
      )
}

internal object CinnabarIsland_Gym_EventScript_Blaine : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_BLAINE)) {
      ctx.say(CinnabarIsland_Gym.BlaineIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_BLAINE) != BattleResult.VICTORY) return
      ctx.say(CinnabarIsland_Gym.BlaineDefeat)
      return CinnabarIsland_Gym_EventScript_DefeatedBlaine.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM38_FROM_BLAINE)) {
      return CinnabarIsland_Gym_EventScript_GiveTM38.run(ctx)
    }
    ctx.say(CinnabarIsland_Gym.BlainePostBattle)
  }
}

internal object CinnabarIsland_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_BLAINE)) {
      return ctx.say(CinnabarIsland_Gym.GymGuyPostVictory)
    }
    ctx.say(CinnabarIsland_Gym.GymGuyAdvice)
  }
}

internal object CinnabarIsland_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE07_GET)) {
      return ctx.sign(CinnabarIsland_Gym.GymStatuePlayerWon)
    }
    ctx.sign(CinnabarIsland_Gym.GymStatue)
  }
}

internal object CinnabarIsland_Gym_EventScript_Quz1Left : Script {
  override suspend fun run(ctx: ScriptContext) = quiz1(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quz1Right : Script {
  override suspend fun run(ctx: ScriptContext) = quiz1(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz2Left : Script {
  override suspend fun run(ctx: ScriptContext) = quiz2(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz2Right : Script {
  override suspend fun run(ctx: ScriptContext) = quiz2(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz3Left : Script {
  override suspend fun run(ctx: ScriptContext) = quiz3(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz3Right : Script {
  override suspend fun run(ctx: ScriptContext) = quiz3(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz4Left : Script {
  override suspend fun run(ctx: ScriptContext) = quiz4(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz4Right : Script {
  override suspend fun run(ctx: ScriptContext) = quiz4(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz5Left : Script {
  override suspend fun run(ctx: ScriptContext) = quiz5(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz5Right : Script {
  override suspend fun run(ctx: ScriptContext) = quiz5(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz6Left : Script {
  override suspend fun run(ctx: ScriptContext) = quiz6(ctx)
}

internal object CinnabarIsland_Gym_EventScript_Quiz6Right : Script {
  override suspend fun run(ctx: ScriptContext) = quiz6(ctx)
}

internal object CinnabarIsland_Gym_EventScript_BlaineFujiPhoto : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CinnabarIsland_Gym.PhotoOfBlaineAndFuji)
}

/** Quiz 1. Getting it wrong means fighting the trainer behind the door instead. */
private suspend fun quiz1(ctx: ScriptContext) {
  ctx.sign(CinnabarIsland_Gym.PokemonQuizRules)
  if (ctx.askYesNo(CinnabarIsland_Gym.QuizQuestion1)) {
    return wrongAnswer(
        ctx,
        KantoTrainerIds.TRAINER_BURGLAR_QUINN,
        CinnabarIsland_Gym.QuinnIntro,
        CinnabarIsland_Gym.QuinnDefeat)
  }
  ctx.sign(CinnabarIsland_Gym.CorrectGoOnThrough)
  ctx.setFlag(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_1)
}

/** Quiz 2. Getting it wrong means fighting the trainer behind the door instead. */
private suspend fun quiz2(ctx: ScriptContext) {
  ctx.sign(CinnabarIsland_Gym.PokemonQuizRules)
  if (!ctx.askYesNo(CinnabarIsland_Gym.QuizQuestion2)) {
    return wrongAnswer(
        ctx,
        KantoTrainerIds.TRAINER_SUPER_NERD_AVERY,
        CinnabarIsland_Gym.AveryIntro,
        CinnabarIsland_Gym.AveryDefeat)
  }
  ctx.sign(CinnabarIsland_Gym.CorrectGoOnThrough)
  ctx.setFlag(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_2)
}

/** Quiz 3. Getting it wrong means fighting the trainer behind the door instead. */
private suspend fun quiz3(ctx: ScriptContext) {
  ctx.sign(CinnabarIsland_Gym.PokemonQuizRules)
  if (!ctx.askYesNo(CinnabarIsland_Gym.QuizQuestion3)) {
    return wrongAnswer(
        ctx,
        KantoTrainerIds.TRAINER_BURGLAR_RAMON,
        CinnabarIsland_Gym.RamonIntro,
        CinnabarIsland_Gym.RamonDefeat)
  }
  ctx.sign(CinnabarIsland_Gym.CorrectGoOnThrough)
  ctx.setFlag(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_3)
}

/** Quiz 4. Getting it wrong means fighting the trainer behind the door instead. */
private suspend fun quiz4(ctx: ScriptContext) {
  ctx.sign(CinnabarIsland_Gym.PokemonQuizRules)
  if (!ctx.askYesNo(CinnabarIsland_Gym.QuizQuestion4)) {
    return wrongAnswer(
        ctx,
        KantoTrainerIds.TRAINER_SUPER_NERD_DEREK,
        CinnabarIsland_Gym.DerekIntro,
        CinnabarIsland_Gym.DerekDefeat)
  }
  ctx.sign(CinnabarIsland_Gym.CorrectGoOnThrough)
  ctx.setFlag(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_4)
}

/** Quiz 5. Getting it wrong means fighting the trainer behind the door instead. */
private suspend fun quiz5(ctx: ScriptContext) {
  ctx.sign(CinnabarIsland_Gym.PokemonQuizRules)
  if (ctx.askYesNo(CinnabarIsland_Gym.QuizQuestion5)) {
    return wrongAnswer(
        ctx,
        KantoTrainerIds.TRAINER_BURGLAR_DUSTY,
        CinnabarIsland_Gym.DustyIntro,
        CinnabarIsland_Gym.DustyDefeat)
  }
  ctx.sign(CinnabarIsland_Gym.CorrectGoOnThrough)
  ctx.setFlag(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_5)
}

/** Quiz 6. Getting it wrong means fighting the trainer behind the door instead. */
private suspend fun quiz6(ctx: ScriptContext) {
  ctx.sign(CinnabarIsland_Gym.PokemonQuizRules)
  if (!ctx.askYesNo(CinnabarIsland_Gym.QuizQuestion6)) {
    return wrongAnswer(
        ctx,
        KantoTrainerIds.TRAINER_SUPER_NERD_ZAC,
        CinnabarIsland_Gym.ZacIntro,
        CinnabarIsland_Gym.ZacDefeat)
  }
  ctx.sign(CinnabarIsland_Gym.CorrectGoOnThrough)
  ctx.setFlag(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_6)
}

/**
 * A wrong answer, which puts the quiz's trainer in the player's way once. The decomp walks him over
 * from whichever side the question was asked, which is presentation this cannot follow.
 */
private suspend fun wrongAnswer(
    ctx: ScriptContext,
    trainerId: Int,
    intro: DialogLine,
    defeat: DialogLine,
) {
  ctx.sign(CinnabarIsland_Gym.SorryBadCall)
  if (ctx.hasBeatenTrainer(trainerId)) return
  ctx.trainerBattle(trainerId, intro, defeat)
}

/** What the seventh badge changes, run straight after Blaine's defeat line. */
internal object CinnabarIsland_Gym_EventScript_DefeatedBlaine : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_BLAINE)
    ctx.setFlag(KantoFlags.FLAG_BADGE07_GET)
    // Bill turns up on the island once the badge is won.
    ctx.clearFlag(KantoFlags.FLAG_HIDE_CINNABAR_BILL)
    // set_gym_trainers 7: this gym's seven trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_SUPER_NERD_ERIK)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_SUPER_NERD_AVERY)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_SUPER_NERD_DEREK)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_SUPER_NERD_ZAC)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BURGLAR_QUINN)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BURGLAR_RAMON)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BURGLAR_DUSTY)
    CinnabarIsland_Gym_EventScript_GiveTM38.run(ctx)
  }
}

internal object CinnabarIsland_Gym_EventScript_GiveTM38 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_Gym.ExplainVolcanoBadge)
    if (!ctx.giveItem(Items.TM38)) {
      return ctx.say(CinnabarIsland_Gym.MakeSpaceForThis)
    }
    ctx.say(CinnabarIsland_Gym.ReceivedTM38FromBlaine)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM38_FROM_BLAINE)
    ctx.say(CinnabarIsland_Gym.FireBlastIsUltimateFireMove)
  }
}

internal val CinnabarIsland_GymScripts: Map<String, Script> =
    mapOf(
        "CinnabarIsland_Gym_EventScript_DefeatedBlaine" to
            CinnabarIsland_Gym_EventScript_DefeatedBlaine,
        "CinnabarIsland_Gym_EventScript_GiveTM38" to CinnabarIsland_Gym_EventScript_GiveTM38,
        "CinnabarIsland_Gym_EventScript_Quinn" to CinnabarIsland_Gym_EventScript_Quinn,
        "CinnabarIsland_Gym_EventScript_Erik" to CinnabarIsland_Gym_EventScript_Erik,
        "CinnabarIsland_Gym_EventScript_Avery" to CinnabarIsland_Gym_EventScript_Avery,
        "CinnabarIsland_Gym_EventScript_Ramon" to CinnabarIsland_Gym_EventScript_Ramon,
        "CinnabarIsland_Gym_EventScript_Derek" to CinnabarIsland_Gym_EventScript_Derek,
        "CinnabarIsland_Gym_EventScript_Dusty" to CinnabarIsland_Gym_EventScript_Dusty,
        "CinnabarIsland_Gym_EventScript_Zac" to CinnabarIsland_Gym_EventScript_Zac,
        "CinnabarIsland_Gym_EventScript_Blaine" to CinnabarIsland_Gym_EventScript_Blaine,
        "CinnabarIsland_Gym_EventScript_GymGuy" to CinnabarIsland_Gym_EventScript_GymGuy,
        "CinnabarIsland_Gym_EventScript_GymStatue" to CinnabarIsland_Gym_EventScript_GymStatue,
        "CinnabarIsland_Gym_EventScript_Quz1Left" to CinnabarIsland_Gym_EventScript_Quz1Left,
        "CinnabarIsland_Gym_EventScript_Quz1Right" to CinnabarIsland_Gym_EventScript_Quz1Right,
        "CinnabarIsland_Gym_EventScript_Quiz2Left" to CinnabarIsland_Gym_EventScript_Quiz2Left,
        "CinnabarIsland_Gym_EventScript_Quiz2Right" to CinnabarIsland_Gym_EventScript_Quiz2Right,
        "CinnabarIsland_Gym_EventScript_Quiz3Left" to CinnabarIsland_Gym_EventScript_Quiz3Left,
        "CinnabarIsland_Gym_EventScript_Quiz3Right" to CinnabarIsland_Gym_EventScript_Quiz3Right,
        "CinnabarIsland_Gym_EventScript_Quiz4Left" to CinnabarIsland_Gym_EventScript_Quiz4Left,
        "CinnabarIsland_Gym_EventScript_Quiz4Right" to CinnabarIsland_Gym_EventScript_Quiz4Right,
        "CinnabarIsland_Gym_EventScript_Quiz5Left" to CinnabarIsland_Gym_EventScript_Quiz5Left,
        "CinnabarIsland_Gym_EventScript_Quiz5Right" to CinnabarIsland_Gym_EventScript_Quiz5Right,
        "CinnabarIsland_Gym_EventScript_Quiz6Left" to CinnabarIsland_Gym_EventScript_Quiz6Left,
        "CinnabarIsland_Gym_EventScript_Quiz6Right" to CinnabarIsland_Gym_EventScript_Quiz6Right,
        "CinnabarIsland_Gym_EventScript_BlaineFujiPhoto" to
            CinnabarIsland_Gym_EventScript_BlaineFujiPhoto,
    )
