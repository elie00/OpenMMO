package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_Gym_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JUAN_1, SootopolisCity_Gym_1F_Text_JuanIntro, SootopolisCity_Gym_1F_Text_JuanDefeat, SootopolisCity_Gym_1F_EventScript_JuanDefeated, NO_MUSIC
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SootopolisCity_Gym_1F_EventScript_JuanRematch
 * goto_if_unset FLAG_RECEIVED_TM_WATER_PULSE, SootopolisCity_Gym_1F_EventScript_GiveWaterPulse2
 * goto_if_unset FLAG_BADGE06_GET, SootopolisCity_Gym_1F_EventScript_GoGetFortreeBadge
 * msgbox SootopolisCity_Gym_1F_Text_JuanPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Gym_1F_EventScript_Juan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_Gym_1F_EventScript_Juan")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_SOOTOPOLIS_GYM, SootopolisCity_Gym_1F_EventScript_GymGuidePostVictory
 * msgbox SootopolisCity_Gym_1F_Text_GymGuideAdvice, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Gym_1F_EventScript_GymGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_SOOTOPOLIS_GYM))
        return SootopolisCity_Gym_1F_EventScript_GymGuidePostVictory.run(ctx)
    ctx.say(SootopolisCity_Gym_1F.GymGuideAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE08_GET, SootopolisCity_Gym_1F_EventScript_GymStatueCertified
 * goto SootopolisCity_Gym_1F_EventScript_GymStatue
 * end
 * ```
 */
internal object SootopolisCity_Gym_1F_EventScript_LeftGymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_Gym_1F_EventScript_LeftGymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE08_GET, SootopolisCity_Gym_1F_EventScript_GymStatueCertified
 * goto SootopolisCity_Gym_1F_EventScript_GymStatue
 * end
 * ```
 */
internal object SootopolisCity_Gym_1F_EventScript_RightGymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_Gym_1F_EventScript_RightGymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_Gym_1F_Text_GymGuidePostVictory, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Gym_1F_EventScript_GymGuidePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_Gym_1F_EventScript_GymGuidePostVictory")
}

internal val SootopolisCity_Gym_1FScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_Gym_1F_EventScript_Juan" to SootopolisCity_Gym_1F_EventScript_Juan,
        "SootopolisCity_Gym_1F_EventScript_GymGuide" to SootopolisCity_Gym_1F_EventScript_GymGuide,
        "SootopolisCity_Gym_1F_EventScript_LeftGymStatue" to
            SootopolisCity_Gym_1F_EventScript_LeftGymStatue,
        "SootopolisCity_Gym_1F_EventScript_RightGymStatue" to
            SootopolisCity_Gym_1F_EventScript_RightGymStatue,
        "SootopolisCity_Gym_1F_EventScript_GymGuidePostVictory" to
            SootopolisCity_Gym_1F_EventScript_GymGuidePostVictory,
    )
