package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_LUIS, CeruleanCity_Gym_Text_LuisIntro, CeruleanCity_Gym_Text_LuisDefeat
 * famechecker FAMECHECKER_MISTY, 2
 * msgbox CeruleanCity_Gym_Text_LuisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_Luis : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_Gym_EventScript_Luis")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_DIANA, CeruleanCity_Gym_Text_DianaIntro, CeruleanCity_Gym_Text_DianaDefeat
 * msgbox CeruleanCity_Gym_Text_DianaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_Diana : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_DIANA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CeruleanCity_Gym.DianaPostBattle)
    }
    ctx.say(CeruleanCity_Gym.DianaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CeruleanCity_Gym.DianaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_MISTY, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_MISTY, CeruleanCity_Gym_Text_MistyIntro, CeruleanCity_Gym_Text_MistyDefeat, CeruleanCity_Gym_EventScript_MistyDefeated, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM03_FROM_MISTY, CeruleanCity_Gym_EventScript_GiveTM03
 * msgbox CeruleanCity_Gym_Text_ExplainTM03
 * release
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_Misty : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_Gym_EventScript_Misty")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_MISTY, CeruleanCity_Gym_EventScript_GymGuyPostVictory
 * msgbox CeruleanCity_Gym_Text_GymGuyAdvice
 * release
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_MISTY))
        return CeruleanCity_Gym_EventScript_GymGuyPostVictory.run(ctx)
    ctx.say(CeruleanCity_Gym.GymGuyAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE02_GET, CeruleanCity_Gym_EventScript_GymStatuePostVictory
 * msgbox CeruleanCity_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_Gym_EventScript_GymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeruleanCity_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_Gym_EventScript_GymStatuePostVictory")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeruleanCity_Gym_Text_WeMakePrettyGoodTeam
 * release
 * end
 * ```
 */
internal object CeruleanCity_Gym_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_Gym_EventScript_GymGuyPostVictory")
}

internal val CeruleanCity_GymScripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_Gym_EventScript_Luis" to CeruleanCity_Gym_EventScript_Luis,
        "CeruleanCity_Gym_EventScript_Diana" to CeruleanCity_Gym_EventScript_Diana,
        "CeruleanCity_Gym_EventScript_Misty" to CeruleanCity_Gym_EventScript_Misty,
        "CeruleanCity_Gym_EventScript_GymGuy" to CeruleanCity_Gym_EventScript_GymGuy,
        "CeruleanCity_Gym_EventScript_GymStatue" to CeruleanCity_Gym_EventScript_GymStatue,
        "CeruleanCity_Gym_EventScript_GymStatuePostVictory" to
            CeruleanCity_Gym_EventScript_GymStatuePostVictory,
        "CeruleanCity_Gym_EventScript_GymGuyPostVictory" to
            CeruleanCity_Gym_EventScript_GymGuyPostVictory,
    )
