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
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_GymStatuePostVictory")
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
 * Not ported yet. Decomp body:
 * ```
 * msgbox CinnabarIsland_Gym_Text_GymGuyPostVictory
 * release
 * end
 * ```
 */
internal object CinnabarIsland_Gym_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_Gym_EventScript_GymGuyPostVictory")
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
    )
