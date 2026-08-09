package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PewterCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_BROCK, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_BROCK, PewterCity_Gym_Text_BrockIntro, PewterCity_Gym_Text_BrockDefeat, PewterCity_Gym_EventScript_DefeatedBrock, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM39_FROM_BROCK, PewterCity_Gym_EventScript_GiveTM39
 * msgbox PewterCity_Gym_Text_BrockPostBattle
 * release
 * end
 * ```
 */
internal object PewterCity_Gym_EventScript_Brock : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_Gym_EventScript_Brock")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_LIAM, PewterCity_Gym_Text_LiamIntro, PewterCity_Gym_Text_LiamDefeat
 * msgbox PewterCity_Gym_Text_LiamPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PewterCity_Gym_EventScript_Liam : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_LIAM
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PewterCity_Gym.LiamPostBattle)
    }
    ctx.say(PewterCity_Gym.LiamIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PewterCity_Gym.LiamDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_BROCK, PewterCity_Gym_EventScript_GymGuyPostVictory
 * msgbox PewterCity_Gym_Text_LetMeTakeYouToTheTop, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, PewterCity_Gym_EventScript_GymGuyTakeMeToTop
 * goto_if_eq VAR_RESULT, NO, PewterCity_Gym_EventScript_GymGuyDontTakeMeToTop
 * end
 * ```
 */
internal object PewterCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_Gym_EventScript_GymGuy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE01_GET, PewterCity_Gym_EventScript_GymStatuePostVictory
 * msgbox PewterCity_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object PewterCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_Gym_EventScript_GymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PewterCity_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object PewterCity_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Gym_EventScript_GymStatuePostVictory")
}

internal val PewterCity_GymScripts: Map<String, Script> =
    mapOf(
        "PewterCity_Gym_EventScript_Brock" to PewterCity_Gym_EventScript_Brock,
        "PewterCity_Gym_EventScript_Liam" to PewterCity_Gym_EventScript_Liam,
        "PewterCity_Gym_EventScript_GymGuy" to PewterCity_Gym_EventScript_GymGuy,
        "PewterCity_Gym_EventScript_GymStatue" to PewterCity_Gym_EventScript_GymStatue,
        "PewterCity_Gym_EventScript_GymStatuePostVictory" to
            PewterCity_Gym_EventScript_GymStatuePostVictory,
    )
