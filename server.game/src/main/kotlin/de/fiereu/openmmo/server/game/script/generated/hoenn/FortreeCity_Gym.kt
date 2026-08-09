package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FortreeCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_WINONA_1, FortreeCity_Gym_Text_WinonaIntro, FortreeCity_Gym_Text_WinonaDefeat, FortreeCity_Gym_EventScript_WinonaDefeated, NO_MUSIC
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FortreeCity_Gym_EventScript_WinonaRematch
 * goto_if_unset FLAG_RECEIVED_TM_AERIAL_ACE, FortreeCity_Gym_EventScript_GiveAerialAce2
 * msgbox FortreeCity_Gym_Text_WinonaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Winona : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FortreeCity_Gym_EventScript_Winona")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JARED, FortreeCity_Gym_Text_JaredIntro, FortreeCity_Gym_Text_JaredDefeat
 * msgbox FortreeCity_Gym_Text_JaredPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Jared : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JARED
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FortreeCity_Gym.JaredPostBattle)
    }
    ctx.say(FortreeCity_Gym.JaredIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FortreeCity_Gym.JaredDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FLINT, FortreeCity_Gym_Text_FlintIntro, FortreeCity_Gym_Text_FlintDefeat
 * msgbox FortreeCity_Gym_Text_FlintPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Flint : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_FLINT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FortreeCity_Gym.FlintPostBattle)
    }
    ctx.say(FortreeCity_Gym.FlintIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FortreeCity_Gym.FlintDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ASHLEY, FortreeCity_Gym_Text_AshleyIntro, FortreeCity_Gym_Text_AshleyDefeat
 * msgbox FortreeCity_Gym_Text_AshleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Ashley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ASHLEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FortreeCity_Gym.AshleyPostBattle)
    }
    ctx.say(FortreeCity_Gym.AshleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FortreeCity_Gym.AshleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_EDWARDO, FortreeCity_Gym_Text_EdwardoIntro, FortreeCity_Gym_Text_EdwardoDefeat
 * msgbox FortreeCity_Gym_Text_EdwardoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Edwardo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_EDWARDO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FortreeCity_Gym.EdwardoPostBattle)
    }
    ctx.say(FortreeCity_Gym.EdwardoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FortreeCity_Gym.EdwardoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_FORTREE_GYM, FortreeCity_Gym_EventScript_GymGuidePostVictory
 * msgbox FortreeCity_Gym_Text_GymGuideAdvice, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_GymGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_FORTREE_GYM))
        return FortreeCity_Gym_EventScript_GymGuidePostVictory.run(ctx)
    ctx.say(FortreeCity_Gym.GymGuideAdvice)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HUMBERTO, FortreeCity_Gym_Text_HumbertoIntro, FortreeCity_Gym_Text_HumbertoDefeat
 * msgbox FortreeCity_Gym_Text_HumbertoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Humberto : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HUMBERTO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FortreeCity_Gym.HumbertoPostBattle)
    }
    ctx.say(FortreeCity_Gym.HumbertoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FortreeCity_Gym.HumbertoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DARIUS, FortreeCity_Gym_Text_DariusIntro, FortreeCity_Gym_Text_DariusDefeat
 * msgbox FortreeCity_Gym_Text_DariusPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_Darius : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DARIUS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FortreeCity_Gym.DariusPostBattle)
    }
    ctx.say(FortreeCity_Gym.DariusIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FortreeCity_Gym.DariusDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE06_GET, FortreeCity_Gym_EventScript_GymStatueCertified
 * goto FortreeCity_Gym_EventScript_GymStatue
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_LeftGymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_Gym_EventScript_LeftGymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE06_GET, FortreeCity_Gym_EventScript_GymStatueCertified
 * goto FortreeCity_Gym_EventScript_GymStatue
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_RightGymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_Gym_EventScript_RightGymStatue")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FortreeCity_Gym_Text_GymGuidePostVictory, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_GymGuidePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FortreeCity_Gym.GymGuidePostVictory)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FortreeCity_Gym_Text_GymStatue, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FortreeCity_Gym.GymStatue)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_WINONA_1, FortreeCity_Gym_Text_WinonaPreRematch, FortreeCity_Gym_Text_WinonaRematchDefeat, FortreeCity_Gym_Text_WinonaRematchNeedTwoMons
 * msgbox FortreeCity_Gym_Text_WinonaPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_WinonaRematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_Gym_EventScript_WinonaRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * giveitem ITEM_TM_AERIAL_ACE
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * msgbox FortreeCity_Gym_Text_ExplainAerialAce, MSGBOX_DEFAULT
 * setflag FLAG_RECEIVED_TM_AERIAL_ACE
 * release
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_GiveAerialAce2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_Gym_EventScript_GiveAerialAce2")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FortreeCity_Gym_Text_GymStatueCertified, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object FortreeCity_Gym_EventScript_GymStatueCertified : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FortreeCity_Gym.GymStatueCertified)
  }
}

internal val FortreeCity_GymScripts: Map<String, Script> =
    mapOf(
        "FortreeCity_Gym_EventScript_Winona" to FortreeCity_Gym_EventScript_Winona,
        "FortreeCity_Gym_EventScript_Jared" to FortreeCity_Gym_EventScript_Jared,
        "FortreeCity_Gym_EventScript_Flint" to FortreeCity_Gym_EventScript_Flint,
        "FortreeCity_Gym_EventScript_Ashley" to FortreeCity_Gym_EventScript_Ashley,
        "FortreeCity_Gym_EventScript_Edwardo" to FortreeCity_Gym_EventScript_Edwardo,
        "FortreeCity_Gym_EventScript_GymGuide" to FortreeCity_Gym_EventScript_GymGuide,
        "FortreeCity_Gym_EventScript_Humberto" to FortreeCity_Gym_EventScript_Humberto,
        "FortreeCity_Gym_EventScript_Darius" to FortreeCity_Gym_EventScript_Darius,
        "FortreeCity_Gym_EventScript_LeftGymStatue" to FortreeCity_Gym_EventScript_LeftGymStatue,
        "FortreeCity_Gym_EventScript_RightGymStatue" to FortreeCity_Gym_EventScript_RightGymStatue,
        "FortreeCity_Gym_EventScript_GymGuidePostVictory" to
            FortreeCity_Gym_EventScript_GymGuidePostVictory,
        "FortreeCity_Gym_EventScript_GymStatue" to FortreeCity_Gym_EventScript_GymStatue,
        "FortreeCity_Gym_EventScript_WinonaRematch" to FortreeCity_Gym_EventScript_WinonaRematch,
        "FortreeCity_Gym_EventScript_GiveAerialAce2" to FortreeCity_Gym_EventScript_GiveAerialAce2,
        "FortreeCity_Gym_EventScript_GymStatueCertified" to
            FortreeCity_Gym_EventScript_GymStatueCertified,
    )
