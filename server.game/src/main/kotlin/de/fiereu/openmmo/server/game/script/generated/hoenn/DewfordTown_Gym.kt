package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.DewfordTown_Gym
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BRAWLY_1, DewfordTown_Gym_Text_BrawlyIntro, DewfordTown_Gym_Text_BrawlyDefeat, DewfordTown_Gym_EventScript_BrawlyDefeated, NO_MUSIC
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, DewfordTown_Gym_EventScript_BrawlyRematch
 * goto_if_unset FLAG_RECEIVED_TM_BULK_UP, DewfordTown_Gym_EventScript_GiveBulkUp2
 * msgbox DewfordTown_Gym_Text_BrawlyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Brawly : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Brawly")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_TAKAO, DewfordTown_Gym_Text_TakaoIntro, DewfordTown_Gym_Text_TakaoDefeat, DewfordTown_Gym_EventScript_TakaoBrightenRoom
 * msgbox DewfordTown_Gym_Text_TakaoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Takao : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Takao")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JOCELYN, DewfordTown_Gym_Text_JocelynIntro, DewfordTown_Gym_Text_JocelynDefeat, DewfordTown_Gym_EventScript_JocelynBrightenRoom
 * msgbox DewfordTown_Gym_Text_JocelynPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Jocelyn : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Jocelyn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_LAURA, DewfordTown_Gym_Text_LauraIntro, DewfordTown_Gym_Text_LauraDefeat, DewfordTown_Gym_EventScript_LauraBrightenRoom
 * msgbox DewfordTown_Gym_Text_LauraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Laura : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Laura")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_DEWFORD_GYM, DewfordTown_Gym_EventScript_GymGuidePostVictory
 * msgbox DewfordTown_Gym_Text_GymGuideAdvice, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_GymGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_DEWFORD_GYM))
        return DewfordTown_Gym_EventScript_GymGuidePostVictory.run(ctx)
    ctx.say(DewfordTown_Gym.GymGuideAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_CRISTIAN, DewfordTown_Gym_Text_CristianIntro, DewfordTown_Gym_Text_CristianDefeat, DewfordTown_Gym_EventScript_CristianBrightenRoom
 * msgbox DewfordTown_Gym_Text_CristianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Cristian : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Cristian")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_LILITH, DewfordTown_Gym_Text_LilithIntro, DewfordTown_Gym_Text_LilithDefeat, DewfordTown_Gym_EventScript_LilithBrightenRoom
 * msgbox DewfordTown_Gym_Text_LilithPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Lilith : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Lilith")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BRENDEN, DewfordTown_Gym_Text_BrendenIntro, DewfordTown_Gym_Text_BrendenDefeat, DewfordTown_Gym_EventScript_BrendenBrightenRoom
 * msgbox DewfordTown_Gym_Text_BrendenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_Brenden : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_Gym_EventScript_Brenden")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE02_GET, DewfordTown_Gym_EventScript_GymStatueCertified
 * goto DewfordTown_Gym_EventScript_GymStatue
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_LeftGymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_Gym_EventScript_LeftGymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE02_GET, DewfordTown_Gym_EventScript_GymStatueCertified
 * goto DewfordTown_Gym_EventScript_GymStatue
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_RightGymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_Gym_EventScript_RightGymStatue")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Gym_Text_GymGuidePostVictory, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_GymGuidePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown_Gym.GymGuidePostVictory)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Gym_Text_GymStatueCertified, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_GymStatueCertified : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown_Gym.GymStatueCertified)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Gym_Text_GymStatue, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown_Gym.GymStatue)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_BRAWLY_1, DewfordTown_Gym_Text_BrawlyPreRematch, DewfordTown_Gym_Text_BrawlyRematchDefeat, DewfordTown_Gym_Text_BrawlyRematchNeedTwoMons
 * msgbox DewfordTown_Gym_Text_BrawlyPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object DewfordTown_Gym_EventScript_BrawlyRematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_Gym_EventScript_BrawlyRematch")
}

internal val DewfordTown_GymScripts: Map<String, Script> =
    mapOf(
        "DewfordTown_Gym_EventScript_Brawly" to DewfordTown_Gym_EventScript_Brawly,
        "DewfordTown_Gym_EventScript_Takao" to DewfordTown_Gym_EventScript_Takao,
        "DewfordTown_Gym_EventScript_Jocelyn" to DewfordTown_Gym_EventScript_Jocelyn,
        "DewfordTown_Gym_EventScript_Laura" to DewfordTown_Gym_EventScript_Laura,
        "DewfordTown_Gym_EventScript_GymGuide" to DewfordTown_Gym_EventScript_GymGuide,
        "DewfordTown_Gym_EventScript_Cristian" to DewfordTown_Gym_EventScript_Cristian,
        "DewfordTown_Gym_EventScript_Lilith" to DewfordTown_Gym_EventScript_Lilith,
        "DewfordTown_Gym_EventScript_Brenden" to DewfordTown_Gym_EventScript_Brenden,
        "DewfordTown_Gym_EventScript_LeftGymStatue" to DewfordTown_Gym_EventScript_LeftGymStatue,
        "DewfordTown_Gym_EventScript_RightGymStatue" to DewfordTown_Gym_EventScript_RightGymStatue,
        "DewfordTown_Gym_EventScript_GymGuidePostVictory" to
            DewfordTown_Gym_EventScript_GymGuidePostVictory,
        "DewfordTown_Gym_EventScript_GymStatueCertified" to
            DewfordTown_Gym_EventScript_GymStatueCertified,
        "DewfordTown_Gym_EventScript_GymStatue" to DewfordTown_Gym_EventScript_GymStatue,
        "DewfordTown_Gym_EventScript_BrawlyRematch" to DewfordTown_Gym_EventScript_BrawlyRematch,
    )
