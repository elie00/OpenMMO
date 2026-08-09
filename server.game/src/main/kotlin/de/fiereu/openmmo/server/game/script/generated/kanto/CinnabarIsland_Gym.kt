package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CinnabarIsland_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BURGLAR_QUINN, CinnabarIsland_Gym_Text_QuinnIntro, CinnabarIsland_Gym_Text_QuinnDefeat, CinnabarIsland_Gym_EventScript_DefeatedQuinn
 * msgbox CinnabarIsland_Gym_Text_QuinnPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quinn : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quinn")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_ERIK, CinnabarIsland_Gym_Text_ErikIntro, CinnabarIsland_Gym_Text_ErikDefeat
 * msgbox CinnabarIsland_Gym_Text_ErikPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Erik : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SUPER_NERD_ERIK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CinnabarIsland_Gym.ErikPostBattle)
    }
    ctx.say(CinnabarIsland_Gym.ErikIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CinnabarIsland_Gym.ErikDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_AVERY, CinnabarIsland_Gym_Text_AveryIntro, CinnabarIsland_Gym_Text_AveryDefeat, CinnabarIsland_Gym_EventScript_DefeatedAvery
 * msgbox CinnabarIsland_Gym_Text_AveryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Avery : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Avery")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BURGLAR_RAMON, CinnabarIsland_Gym_Text_RamonIntro, CinnabarIsland_Gym_Text_RamonDefeat, CinnabarIsland_Gym_EventScript_DefeatedRamon
 * msgbox CinnabarIsland_Gym_Text_RamonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Ramon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Ramon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_DEREK, CinnabarIsland_Gym_Text_DerekIntro, CinnabarIsland_Gym_Text_DerekDefeat, CinnabarIsland_Gym_EventScript_DefeatedDerek
 * famechecker FAMECHECKER_BLAINE, 2
 * msgbox CinnabarIsland_Gym_Text_DerekPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Derek : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Derek")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BURGLAR_DUSTY, CinnabarIsland_Gym_Text_DustyIntro, CinnabarIsland_Gym_Text_DustyDefeat, CinnabarIsland_Gym_EventScript_DefeatedDusty
 * msgbox CinnabarIsland_Gym_Text_DustyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Dusty : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Dusty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SUPER_NERD_ZAC, CinnabarIsland_Gym_Text_ZacIntro, CinnabarIsland_Gym_Text_ZacDefeat, CinnabarIsland_Gym_EventScript_DefeatedZac
 * msgbox CinnabarIsland_Gym_Text_ZacPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Zac : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Zac")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_BLAINE, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_BLAINE, CinnabarIsland_Gym_Text_BlaineIntro, CinnabarIsland_Gym_Text_BlaineDefeat, CinnabarIsland_Gym_EventScript_DefeatedBlaine, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM38_FROM_BLAINE, CinnabarIsland_Gym_EventScript_GiveTM38
 * msgbox CinnabarIsland_Gym_Text_BlainePostBattle
 * release
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Blaine : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Blaine")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_BLAINE, CinnabarIsland_Gym_EventScript_GymGuyPostVictory
 * msgbox CinnabarIsland_Gym_Text_GymGuyAdvice
 * release
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_BLAINE))
        return CinnabarIsland_Gym_EventScript_GymGuyPostVictory.run(ctx)
    ctx.say(CinnabarIsland_Gym.GymGuyAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE07_GET, CinnabarIsland_Gym_EventScript_GymStatuePostVictory
 * msgbox CinnabarIsland_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_GymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 0
 * goto CinnabarIsland_Gym_EventScript_Quiz1
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quz1Left : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quz1Left")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * goto CinnabarIsland_Gym_EventScript_Quiz1
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quz1Right : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quz1Right")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 0
 * goto CinnabarIsland_Gym_EventScript_Quiz2
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz2Left : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz2Left")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * goto CinnabarIsland_Gym_EventScript_Quiz2
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz2Right : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz2Right")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 0
 * goto CinnabarIsland_Gym_EventScript_Quiz3
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz3Left : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz3Left")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * goto CinnabarIsland_Gym_EventScript_Quiz3
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz3Right : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz3Right")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 0
 * goto CinnabarIsland_Gym_EventScript_Quiz4
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz4Left : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz4Left")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * goto CinnabarIsland_Gym_EventScript_Quiz4
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz4Right : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz4Right")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 0
 * goto CinnabarIsland_Gym_EventScript_Quiz5
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz5Left : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz5Left")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * goto CinnabarIsland_Gym_EventScript_Quiz5
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz5Right : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz5Right")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 0
 * goto CinnabarIsland_Gym_EventScript_Quiz6
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz6Left : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz6Left")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * goto CinnabarIsland_Gym_EventScript_Quiz6
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz6Right : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz6Right")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_BLAINE, 4
 * famechecker FAMECHECKER_MRFUJI, 4
 * msgbox CinnabarIsland_Gym_Text_PhotoOfBlaineAndFuji
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BlaineFujiPhoto : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BlaineFujiPhoto")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CinnabarIsland_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_Gym.GymStatuePlayerWon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_PokemonQuizRules
 * msgbox CinnabarIsland_Gym_Text_QuizQuestion6, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, CinnabarIsland_Gym_EventScript_Quiz6Incorrect
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_Gym_EventScript_Quiz6Correct
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz6 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quiz6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_PokemonQuizRules
 * msgbox CinnabarIsland_Gym_Text_QuizQuestion5, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, CinnabarIsland_Gym_EventScript_Quiz5Correct
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_Gym_EventScript_Quiz5Incorrect
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz5 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quiz5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_PokemonQuizRules
 * msgbox CinnabarIsland_Gym_Text_QuizQuestion4, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, CinnabarIsland_Gym_EventScript_Quiz4Incorrect
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_Gym_EventScript_Quiz4Correct
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz4 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quiz4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_PokemonQuizRules
 * msgbox CinnabarIsland_Gym_Text_QuizQuestion3, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, CinnabarIsland_Gym_EventScript_Quiz3Incorrect
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_Gym_EventScript_Quiz3Correct
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quiz3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_PokemonQuizRules
 * msgbox CinnabarIsland_Gym_Text_QuizQuestion2, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, CinnabarIsland_Gym_EventScript_Quiz2Incorrect
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_Gym_EventScript_Quiz2Correct
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quiz2")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CinnabarIsland_Gym_Text_GymGuyPostVictory
 * release
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_Gym.GymGuyPostVictory)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_PokemonQuizRules
 * msgbox CinnabarIsland_Gym_Text_QuizQuestion1, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, CinnabarIsland_Gym_EventScript_Quiz1Correct
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_Gym_EventScript_Quiz1Incorrect
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CinnabarIsland_Gym_EventScript_Quiz1")
}

/**
 * Ported from the decomp:
 * ```
 * call CinnabarIsland_Gym_EventScript_CorrectAnswer
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_3, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz3Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz3Correct : Script {
  override suspend fun run(ctx: ScriptContext) {
    CinnabarIsland_Gym_EventScript_CorrectAnswer.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_3))
        return CinnabarIsland_Gym_EventScript_DoorAlreadyOpen.run(ctx)
    CinnabarIsland_Gym_EventScript_Quiz3Complete.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call CinnabarIsland_Gym_EventScript_CorrectAnswer
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_2, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz2Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz2Correct : Script {
  override suspend fun run(ctx: ScriptContext) {
    CinnabarIsland_Gym_EventScript_CorrectAnswer.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_2))
        return CinnabarIsland_Gym_EventScript_DoorAlreadyOpen.run(ctx)
    CinnabarIsland_Gym_EventScript_Quiz2Complete.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CinnabarIsland_Gym_EventScript_IncorrectAnswer
 * goto_if_not_defeated TRAINER_BURGLAR_QUINN, CinnabarIsland_Gym_EventScript_BattleQuinn
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz1Incorrect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz1Incorrect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CinnabarIsland_Gym_EventScript_IncorrectAnswer
 * goto_if_not_defeated TRAINER_SUPER_NERD_DEREK, CinnabarIsland_Gym_EventScript_BattleDerek
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz4Incorrect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz4Incorrect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_ExplainVolcanoBadge
 * checkitemspace ITEM_TM38
 * goto_if_eq VAR_RESULT, FALSE, CinnabarIsland_Gym_EventScript_NoRoomForTM38
 * giveitem_msg CinnabarIsland_Gym_Text_ReceivedTM38FromBlaine, ITEM_TM38
 * setflag FLAG_GOT_TM38_FROM_BLAINE
 * msgbox CinnabarIsland_Gym_Text_FireBlastIsUltimateFireMove
 * release
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GiveTM38 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_GiveTM38")
}

/**
 * Ported from the decomp:
 * ```
 * call CinnabarIsland_Gym_EventScript_CorrectAnswer
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_4, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz4Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz4Correct : Script {
  override suspend fun run(ctx: ScriptContext) {
    CinnabarIsland_Gym_EventScript_CorrectAnswer.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_4))
        return CinnabarIsland_Gym_EventScript_DoorAlreadyOpen.run(ctx)
    CinnabarIsland_Gym_EventScript_Quiz4Complete.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call CinnabarIsland_Gym_EventScript_CorrectAnswer
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_1, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz1Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz1Correct : Script {
  override suspend fun run(ctx: ScriptContext) {
    CinnabarIsland_Gym_EventScript_CorrectAnswer.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_1))
        return CinnabarIsland_Gym_EventScript_DoorAlreadyOpen.run(ctx)
    CinnabarIsland_Gym_EventScript_Quiz1Complete.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CinnabarIsland_Gym_EventScript_IncorrectAnswer
 * goto_if_not_defeated TRAINER_BURGLAR_DUSTY, CinnabarIsland_Gym_EventScript_BattleDusty
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz5Incorrect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz5Incorrect")
}

/**
 * Ported from the decomp:
 * ```
 * call CinnabarIsland_Gym_EventScript_CorrectAnswer
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_6, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz6Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz6Correct : Script {
  override suspend fun run(ctx: ScriptContext) {
    CinnabarIsland_Gym_EventScript_CorrectAnswer.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_6))
        return CinnabarIsland_Gym_EventScript_DoorAlreadyOpen.run(ctx)
    CinnabarIsland_Gym_EventScript_Quiz6Complete.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call CinnabarIsland_Gym_EventScript_CorrectAnswer
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_5, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz5Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz5Correct : Script {
  override suspend fun run(ctx: ScriptContext) {
    CinnabarIsland_Gym_EventScript_CorrectAnswer.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_CINNABAR_GYM_QUIZ_5))
        return CinnabarIsland_Gym_EventScript_DoorAlreadyOpen.run(ctx)
    CinnabarIsland_Gym_EventScript_Quiz5Complete.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CinnabarIsland_Gym_EventScript_IncorrectAnswer
 * goto_if_not_defeated TRAINER_SUPER_NERD_AVERY, CinnabarIsland_Gym_EventScript_BattleAvery
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz2Incorrect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz2Incorrect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CinnabarIsland_Gym_EventScript_IncorrectAnswer
 * goto_if_not_defeated TRAINER_SUPER_NERD_ZAC, CinnabarIsland_Gym_EventScript_BattleZac
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz6Incorrect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz6Incorrect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CinnabarIsland_Gym_EventScript_IncorrectAnswer
 * goto_if_not_defeated TRAINER_BURGLAR_RAMON, CinnabarIsland_Gym_EventScript_BattleRamon
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz3Incorrect : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz3Incorrect")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * waitse
 * call CinnabarIsland_Gym_EventScript_OpenDoor6
 * special DrawWholeMapView
 * setflag FLAG_CINNABAR_GYM_QUIZ_6
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz6Complete : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz6Complete")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playfanfare MUS_LEVEL_UP
 * waitfanfare
 * msgbox CinnabarIsland_Gym_Text_CorrectGoOnThrough
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_CorrectAnswer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_CorrectAnswer")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * waitse
 * call CinnabarIsland_Gym_EventScript_OpenDoor4
 * special DrawWholeMapView
 * setflag FLAG_CINNABAR_GYM_QUIZ_4
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz4Complete : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz4Complete")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * waitse
 * call CinnabarIsland_Gym_EventScript_OpenDoor5
 * special DrawWholeMapView
 * setflag FLAG_CINNABAR_GYM_QUIZ_5
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz5Complete : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz5Complete")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, CinnabarIsland_Gym_EventScript_ZacApproachLeft
 * call_if_eq VAR_TEMP_1, 1, CinnabarIsland_Gym_EventScript_ZacApproachRight
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CinnabarIsland_Gym_Text_ZacIntro
 * trainerbattle_no_intro TRAINER_SUPER_NERD_ZAC, CinnabarIsland_Gym_Text_ZacDefeat
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_6, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz6Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BattleZac : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BattleZac")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CinnabarIsland_Gym_Text_MakeSpaceForThis
 * release
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_NoRoomForTM38 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CinnabarIsland_Gym.MakeSpaceForThis)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_DoorAlreadyOpen : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_DoorAlreadyOpen")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, CinnabarIsland_Gym_EventScript_DerekApproachLeft
 * call_if_eq VAR_TEMP_1, 1, CinnabarIsland_Gym_EventScript_DerekApproachRight
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CinnabarIsland_Gym_Text_DerekIntro
 * trainerbattle_no_intro TRAINER_SUPER_NERD_DEREK, CinnabarIsland_Gym_Text_DerekDefeat
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_4, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz4Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BattleDerek : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BattleDerek")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, CinnabarIsland_Gym_EventScript_AveryApproachLeft
 * call_if_eq VAR_TEMP_1, 1, CinnabarIsland_Gym_EventScript_AveryApproachRight
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CinnabarIsland_Gym_Text_AveryIntro
 * trainerbattle_no_intro TRAINER_SUPER_NERD_AVERY, CinnabarIsland_Gym_Text_AveryDefeat
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_2, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz2Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BattleAvery : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BattleAvery")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, CinnabarIsland_Gym_EventScript_RamonApproachLeft
 * call_if_eq VAR_TEMP_1, 1, CinnabarIsland_Gym_EventScript_RamonApproachRight
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CinnabarIsland_Gym_Text_RamonIntro
 * trainerbattle_no_intro TRAINER_BURGLAR_RAMON, CinnabarIsland_Gym_Text_RamonDefeat
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_3, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz3Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BattleRamon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BattleRamon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, CinnabarIsland_Gym_EventScript_DustyApproachLeft
 * call_if_eq VAR_TEMP_1, 1, CinnabarIsland_Gym_EventScript_DustyApproachRight
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CinnabarIsland_Gym_Text_DustyIntro
 * trainerbattle_no_intro TRAINER_BURGLAR_DUSTY, CinnabarIsland_Gym_Text_DustyDefeat
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_5, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz5Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BattleDusty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BattleDusty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, CinnabarIsland_Gym_EventScript_QuinnApproachLeft
 * call_if_eq VAR_TEMP_1, 1, CinnabarIsland_Gym_EventScript_QuinnApproachRight
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CinnabarIsland_Gym_Text_QuinnIntro
 * trainerbattle_no_intro TRAINER_BURGLAR_QUINN, CinnabarIsland_Gym_Text_QuinnDefeat
 * goto_if_set FLAG_CINNABAR_GYM_QUIZ_1, CinnabarIsland_Gym_EventScript_DoorAlreadyOpen
 * call CinnabarIsland_Gym_EventScript_Quiz1Complete
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_BattleQuinn : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_BattleQuinn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * waitse
 * call CinnabarIsland_Gym_EventScript_OpenDoor1
 * special DrawWholeMapView
 * setflag FLAG_CINNABAR_GYM_QUIZ_1
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz1Complete : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz1Complete")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * waitse
 * playse SE_BOO
 * waitse
 * msgbox CinnabarIsland_Gym_Text_SorryBadCall
 * closemessage
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_IncorrectAnswer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_IncorrectAnswer")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * waitse
 * call CinnabarIsland_Gym_EventScript_OpenDoor3
 * special DrawWholeMapView
 * setflag FLAG_CINNABAR_GYM_QUIZ_3
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz3Complete : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz3Complete")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * waitse
 * call CinnabarIsland_Gym_EventScript_OpenDoor2
 * special DrawWholeMapView
 * setflag FLAG_CINNABAR_GYM_QUIZ_2
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_Quiz2Complete : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_Quiz2Complete")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_DEREK, CinnabarIsland_Gym_Movement_DerekApproachLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_DerekApproachLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_DerekApproachLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_DUSTY, CinnabarIsland_Gym_Movement_DustyApproachLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_DustyApproachLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_DustyApproachLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_QUINN, CinnabarIsland_Gym_Movement_QuinnApproachLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_QuinnApproachLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_QuinnApproachLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_RAMON, CinnabarIsland_Gym_Movement_RamonApproachLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_RamonApproachLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_RamonApproachLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_DEREK, CinnabarIsland_Gym_Movement_DerekApproachRight
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_DerekApproachRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_DerekApproachRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_DUSTY, CinnabarIsland_Gym_Movement_DustyApproachRight
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_DustyApproachRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_DustyApproachRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile  5,  8, METATILE_CinnabarGym_Floor_WallLeftCorner, 0
 * setmetatile  6,  8, METATILE_CinnabarGym_Floor_WallRightCorner, 0
 * setmetatile  5,  9, METATILE_CinnabarGym_Floor_WallLeftEdge, 0
 * setmetatile  6,  9, METATILE_CinnabarGym_Floor_WallRightEdge, 0
 * setmetatile  5, 10, METATILE_CinnabarGym_Floor_ShadeFull, 0
 * setmetatile  6, 10, METATILE_CinnabarGym_Floor, 0
 * setmetatile  7, 10, METATILE_CinnabarGym_Floor_ShadeDiagonal, 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_OpenDoor6 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_OpenDoor6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile  5, 16, METATILE_CinnabarGym_Floor_WallLeftCorner, 0
 * setmetatile  6, 16, METATILE_CinnabarGym_Floor_WallRightCorner, 0
 * setmetatile  5, 17, METATILE_CinnabarGym_Floor_WallLeftEdge, 0
 * setmetatile  6, 17, METATILE_CinnabarGym_Floor_WallRightEdge, 0
 * setmetatile  5, 18, METATILE_CinnabarGym_Floor_ShadeFull, 0
 * setmetatile  6, 18, METATILE_CinnabarGym_Floor, 0
 * setmetatile  7, 18, METATILE_CinnabarGym_Floor_ShadeDiagonal, 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_OpenDoor5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_OpenDoor5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 11, 21, METATILE_CinnabarGym_Wall_RetractedBarrier, 1
 * setmetatile 11, 22, METATILE_CinnabarGym_Floor_ShadeFull, 0
 * setmetatile 11, 23, METATILE_CinnabarGym_Floor, 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_OpenDoor4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_OpenDoor4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 17, 15, METATILE_CinnabarGym_Floor_WallLeftCorner, 0
 * setmetatile 18, 15, METATILE_CinnabarGym_Floor_WallRightCorner, 0
 * setmetatile 17, 16, METATILE_CinnabarGym_Floor_WallLeftEdge, 0
 * setmetatile 18, 16, METATILE_CinnabarGym_Floor_WallRightEdge, 0
 * setmetatile 17, 17, METATILE_CinnabarGym_Floor_ShadeFull, 0
 * setmetatile 18, 17, METATILE_CinnabarGym_Floor, 0
 * setmetatile 19, 17, METATILE_CinnabarGym_Floor_ShadeDiagonal, 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_OpenDoor3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_OpenDoor3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_ZAC, CinnabarIsland_Gym_Movement_ZacApproachLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_ZacApproachLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_ZacApproachLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 17,  8, METATILE_CinnabarGym_Floor_WallLeftCorner, 0
 * setmetatile 18,  8, METATILE_CinnabarGym_Floor_WallRightCorner, 0
 * setmetatile 17,  9, METATILE_CinnabarGym_Floor_WallLeftEdge, 0
 * setmetatile 18,  9, METATILE_CinnabarGym_Floor_WallRightEdge, 0
 * setmetatile 17, 10, METATILE_CinnabarGym_Floor_ShadeFull, 0
 * setmetatile 18, 10, METATILE_CinnabarGym_Floor, 0
 * setmetatile 19, 10, METATILE_CinnabarGym_Floor_ShadeDiagonal, 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_OpenDoor2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_OpenDoor2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 26,  8, METATILE_CinnabarGym_Floor_WallLeftCorner, 0
 * setmetatile 27,  8, METATILE_CinnabarGym_Floor_WallRightCorner, 0
 * setmetatile 26,  9, METATILE_CinnabarGym_Floor_WallLeftEdge, 0
 * setmetatile 27,  9, METATILE_CinnabarGym_Floor_WallRightEdge, 0
 * setmetatile 26, 10, METATILE_CinnabarGym_Floor_ShadeFull, 0
 * setmetatile 27, 10, METATILE_CinnabarGym_Floor, 0
 * setmetatile 28, 10, METATILE_CinnabarGym_Floor_ShadeDiagonal, 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_OpenDoor1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_OpenDoor1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, CinnabarIsland_Gym_Movement_PlayerFaceAvery
 * applymovement LOCALID_AVERY, CinnabarIsland_Gym_Movement_AveryApproachLeft
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_AveryApproachLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_AveryApproachLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_RAMON, CinnabarIsland_Gym_Movement_RamonApproachRight
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_RamonApproachRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_RamonApproachRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_QUINN, CinnabarIsland_Gym_Movement_QuinnApproachRight
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_QuinnApproachRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_QuinnApproachRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * applymovement LOCALID_ZAC, CinnabarIsland_Gym_Movement_ZacApproachRight
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_ZacApproachRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_ZacApproachRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, CinnabarIsland_Gym_Movement_PlayerFaceAvery
 * applymovement LOCALID_AVERY, CinnabarIsland_Gym_Movement_AveryApproachRight
 * waitmovement 0
 * return
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_AveryApproachRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_AveryApproachRight")
}

internal val CinnabarIsland_GymScripts: Map<String, Script> =
    mapOf(
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
        "CinnabarIsland_Gym_EventScript_GymStatuePostVictory" to
            CinnabarIsland_Gym_EventScript_GymStatuePostVictory,
        "CinnabarIsland_Gym_EventScript_Quiz6" to CinnabarIsland_Gym_EventScript_Quiz6,
        "CinnabarIsland_Gym_EventScript_Quiz5" to CinnabarIsland_Gym_EventScript_Quiz5,
        "CinnabarIsland_Gym_EventScript_Quiz4" to CinnabarIsland_Gym_EventScript_Quiz4,
        "CinnabarIsland_Gym_EventScript_Quiz3" to CinnabarIsland_Gym_EventScript_Quiz3,
        "CinnabarIsland_Gym_EventScript_Quiz2" to CinnabarIsland_Gym_EventScript_Quiz2,
        "CinnabarIsland_Gym_EventScript_GymGuyPostVictory" to
            CinnabarIsland_Gym_EventScript_GymGuyPostVictory,
        "CinnabarIsland_Gym_EventScript_Quiz1" to CinnabarIsland_Gym_EventScript_Quiz1,
        "CinnabarIsland_Gym_EventScript_Quiz3Correct" to
            CinnabarIsland_Gym_EventScript_Quiz3Correct,
        "CinnabarIsland_Gym_EventScript_Quiz2Correct" to
            CinnabarIsland_Gym_EventScript_Quiz2Correct,
        "CinnabarIsland_Gym_EventScript_Quiz1Incorrect" to
            CinnabarIsland_Gym_EventScript_Quiz1Incorrect,
        "CinnabarIsland_Gym_EventScript_Quiz4Incorrect" to
            CinnabarIsland_Gym_EventScript_Quiz4Incorrect,
        "CinnabarIsland_Gym_EventScript_GiveTM38" to CinnabarIsland_Gym_EventScript_GiveTM38,
        "CinnabarIsland_Gym_EventScript_Quiz4Correct" to
            CinnabarIsland_Gym_EventScript_Quiz4Correct,
        "CinnabarIsland_Gym_EventScript_Quiz1Correct" to
            CinnabarIsland_Gym_EventScript_Quiz1Correct,
        "CinnabarIsland_Gym_EventScript_Quiz5Incorrect" to
            CinnabarIsland_Gym_EventScript_Quiz5Incorrect,
        "CinnabarIsland_Gym_EventScript_Quiz6Correct" to
            CinnabarIsland_Gym_EventScript_Quiz6Correct,
        "CinnabarIsland_Gym_EventScript_Quiz5Correct" to
            CinnabarIsland_Gym_EventScript_Quiz5Correct,
        "CinnabarIsland_Gym_EventScript_Quiz2Incorrect" to
            CinnabarIsland_Gym_EventScript_Quiz2Incorrect,
        "CinnabarIsland_Gym_EventScript_Quiz6Incorrect" to
            CinnabarIsland_Gym_EventScript_Quiz6Incorrect,
        "CinnabarIsland_Gym_EventScript_Quiz3Incorrect" to
            CinnabarIsland_Gym_EventScript_Quiz3Incorrect,
        "CinnabarIsland_Gym_EventScript_Quiz6Complete" to
            CinnabarIsland_Gym_EventScript_Quiz6Complete,
        "CinnabarIsland_Gym_EventScript_CorrectAnswer" to
            CinnabarIsland_Gym_EventScript_CorrectAnswer,
        "CinnabarIsland_Gym_EventScript_Quiz4Complete" to
            CinnabarIsland_Gym_EventScript_Quiz4Complete,
        "CinnabarIsland_Gym_EventScript_Quiz5Complete" to
            CinnabarIsland_Gym_EventScript_Quiz5Complete,
        "CinnabarIsland_Gym_EventScript_BattleZac" to CinnabarIsland_Gym_EventScript_BattleZac,
        "CinnabarIsland_Gym_EventScript_NoRoomForTM38" to
            CinnabarIsland_Gym_EventScript_NoRoomForTM38,
        "CinnabarIsland_Gym_EventScript_DoorAlreadyOpen" to
            CinnabarIsland_Gym_EventScript_DoorAlreadyOpen,
        "CinnabarIsland_Gym_EventScript_BattleDerek" to CinnabarIsland_Gym_EventScript_BattleDerek,
        "CinnabarIsland_Gym_EventScript_BattleAvery" to CinnabarIsland_Gym_EventScript_BattleAvery,
        "CinnabarIsland_Gym_EventScript_BattleRamon" to CinnabarIsland_Gym_EventScript_BattleRamon,
        "CinnabarIsland_Gym_EventScript_BattleDusty" to CinnabarIsland_Gym_EventScript_BattleDusty,
        "CinnabarIsland_Gym_EventScript_BattleQuinn" to CinnabarIsland_Gym_EventScript_BattleQuinn,
        "CinnabarIsland_Gym_EventScript_Quiz1Complete" to
            CinnabarIsland_Gym_EventScript_Quiz1Complete,
        "CinnabarIsland_Gym_EventScript_IncorrectAnswer" to
            CinnabarIsland_Gym_EventScript_IncorrectAnswer,
        "CinnabarIsland_Gym_EventScript_Quiz3Complete" to
            CinnabarIsland_Gym_EventScript_Quiz3Complete,
        "CinnabarIsland_Gym_EventScript_Quiz2Complete" to
            CinnabarIsland_Gym_EventScript_Quiz2Complete,
        "CinnabarIsland_Gym_EventScript_DerekApproachLeft" to
            CinnabarIsland_Gym_EventScript_DerekApproachLeft,
        "CinnabarIsland_Gym_EventScript_DustyApproachLeft" to
            CinnabarIsland_Gym_EventScript_DustyApproachLeft,
        "CinnabarIsland_Gym_EventScript_QuinnApproachLeft" to
            CinnabarIsland_Gym_EventScript_QuinnApproachLeft,
        "CinnabarIsland_Gym_EventScript_RamonApproachLeft" to
            CinnabarIsland_Gym_EventScript_RamonApproachLeft,
        "CinnabarIsland_Gym_EventScript_DerekApproachRight" to
            CinnabarIsland_Gym_EventScript_DerekApproachRight,
        "CinnabarIsland_Gym_EventScript_DustyApproachRight" to
            CinnabarIsland_Gym_EventScript_DustyApproachRight,
        "CinnabarIsland_Gym_EventScript_OpenDoor6" to CinnabarIsland_Gym_EventScript_OpenDoor6,
        "CinnabarIsland_Gym_EventScript_OpenDoor5" to CinnabarIsland_Gym_EventScript_OpenDoor5,
        "CinnabarIsland_Gym_EventScript_OpenDoor4" to CinnabarIsland_Gym_EventScript_OpenDoor4,
        "CinnabarIsland_Gym_EventScript_OpenDoor3" to CinnabarIsland_Gym_EventScript_OpenDoor3,
        "CinnabarIsland_Gym_EventScript_ZacApproachLeft" to
            CinnabarIsland_Gym_EventScript_ZacApproachLeft,
        "CinnabarIsland_Gym_EventScript_OpenDoor2" to CinnabarIsland_Gym_EventScript_OpenDoor2,
        "CinnabarIsland_Gym_EventScript_OpenDoor1" to CinnabarIsland_Gym_EventScript_OpenDoor1,
        "CinnabarIsland_Gym_EventScript_AveryApproachLeft" to
            CinnabarIsland_Gym_EventScript_AveryApproachLeft,
        "CinnabarIsland_Gym_EventScript_RamonApproachRight" to
            CinnabarIsland_Gym_EventScript_RamonApproachRight,
        "CinnabarIsland_Gym_EventScript_QuinnApproachRight" to
            CinnabarIsland_Gym_EventScript_QuinnApproachRight,
        "CinnabarIsland_Gym_EventScript_ZacApproachRight" to
            CinnabarIsland_Gym_EventScript_ZacApproachRight,
        "CinnabarIsland_Gym_EventScript_AveryApproachRight" to
            CinnabarIsland_Gym_EventScript_AveryApproachRight,
    )
