package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_KAYDEN, FuchsiaCity_Gym_Text_KaydenIntro, FuchsiaCity_Gym_Text_KaydenDefeat
 * msgbox FuchsiaCity_Gym_Text_KaydenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Kayden : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_JUGGLER_KAYDEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FuchsiaCity_Gym.KaydenPostBattle)
    }
    ctx.say(FuchsiaCity_Gym.KaydenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FuchsiaCity_Gym.KaydenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_SHAWN, FuchsiaCity_Gym_Text_ShawnIntro, FuchsiaCity_Gym_Text_ShawnDefeat
 * msgbox FuchsiaCity_Gym_Text_ShawnPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Shawn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_JUGGLER_SHAWN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FuchsiaCity_Gym.ShawnPostBattle)
    }
    ctx.say(FuchsiaCity_Gym.ShawnIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FuchsiaCity_Gym.ShawnDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_KIRK, FuchsiaCity_Gym_Text_KirkIntro, FuchsiaCity_Gym_Text_KirkDefeat
 * famechecker FAMECHECKER_KOGA, 2
 * msgbox FuchsiaCity_Gym_Text_KirkPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Kirk : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FuchsiaCity_Gym_EventScript_Kirk")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAMER_EDGAR, FuchsiaCity_Gym_Text_EdgarIntro, FuchsiaCity_Gym_Text_EdgarDefeat
 * msgbox FuchsiaCity_Gym_Text_EdgarPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Edgar : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TAMER_EDGAR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FuchsiaCity_Gym.EdgarPostBattle)
    }
    ctx.say(FuchsiaCity_Gym.EdgarIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FuchsiaCity_Gym.EdgarDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAMER_PHIL, FuchsiaCity_Gym_Text_PhilIntro, FuchsiaCity_Gym_Text_PhilDefeat
 * msgbox FuchsiaCity_Gym_Text_PhilPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Phil : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TAMER_PHIL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FuchsiaCity_Gym.PhilPostBattle)
    }
    ctx.say(FuchsiaCity_Gym.PhilIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FuchsiaCity_Gym.PhilDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_NATE, FuchsiaCity_Gym_Text_NateIntro, FuchsiaCity_Gym_Text_NateDefeat
 * msgbox FuchsiaCity_Gym_Text_NatePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Nate : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_JUGGLER_NATE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FuchsiaCity_Gym.NatePostBattle)
    }
    ctx.say(FuchsiaCity_Gym.NateIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FuchsiaCity_Gym.NateDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_KOGA, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_KOGA, FuchsiaCity_Gym_Text_KogaIntro, FuchsiaCity_Gym_Text_KogaDefeat, FuchsiaCity_Gym_EventScript_DefeatedKoga, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM06_FROM_KOGA, FuchsiaCity_Gym_EventScript_GiveTM06
 * msgbox FuchsiaCity_Gym_Text_KogaPostBattle
 * release
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_Koga : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FuchsiaCity_Gym_EventScript_Koga")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_KOGA, FuchsiaCity_Gym_EventScript_GymGuyPostVictory
 * msgbox FuchsiaCity_Gym_Text_GymGuyAdvice
 * release
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_KOGA))
        return FuchsiaCity_Gym_EventScript_GymGuyPostVictory.run(ctx)
    ctx.say(FuchsiaCity_Gym.GymGuyAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE05_GET, FuchsiaCity_Gym_EventScript_GymStatuePostVictory
 * msgbox FuchsiaCity_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FuchsiaCity_Gym_EventScript_GymStatue")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_Gym.GymStatuePlayerWon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_Gym_Text_GymGuyPostVictory
 * release
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_Gym.GymGuyPostVictory)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FuchsiaCity_Gym_Text_KogaExplainSoulBadge
 * checkitemspace ITEM_TM06
 * goto_if_eq VAR_RESULT, FALSE, FuchsiaCity_Gym_EventScript_NoRoomForTM06
 * giveitem_msg FuchsiaCity_Gym_Text_ReceivedTM06FromKoga, ITEM_TM06
 * setflag FLAG_GOT_TM06_FROM_KOGA
 * msgbox FuchsiaCity_Gym_Text_KogaExplainTM06
 * release
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_GiveTM06 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FuchsiaCity_Gym_EventScript_GiveTM06")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_Gym_Text_MakeSpaceForThis
 * release
 * end
 * ```
 */
internal object FuchsiaCity_Gym_EventScript_NoRoomForTM06 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_Gym.MakeSpaceForThis)
  }
}

internal val FuchsiaCity_GymScripts: Map<String, Script> =
    mapOf(
        "FuchsiaCity_Gym_EventScript_Kayden" to FuchsiaCity_Gym_EventScript_Kayden,
        "FuchsiaCity_Gym_EventScript_Shawn" to FuchsiaCity_Gym_EventScript_Shawn,
        "FuchsiaCity_Gym_EventScript_Kirk" to FuchsiaCity_Gym_EventScript_Kirk,
        "FuchsiaCity_Gym_EventScript_Edgar" to FuchsiaCity_Gym_EventScript_Edgar,
        "FuchsiaCity_Gym_EventScript_Phil" to FuchsiaCity_Gym_EventScript_Phil,
        "FuchsiaCity_Gym_EventScript_Nate" to FuchsiaCity_Gym_EventScript_Nate,
        "FuchsiaCity_Gym_EventScript_Koga" to FuchsiaCity_Gym_EventScript_Koga,
        "FuchsiaCity_Gym_EventScript_GymGuy" to FuchsiaCity_Gym_EventScript_GymGuy,
        "FuchsiaCity_Gym_EventScript_GymStatue" to FuchsiaCity_Gym_EventScript_GymStatue,
        "FuchsiaCity_Gym_EventScript_GymStatuePostVictory" to
            FuchsiaCity_Gym_EventScript_GymStatuePostVictory,
        "FuchsiaCity_Gym_EventScript_GymGuyPostVictory" to
            FuchsiaCity_Gym_EventScript_GymGuyPostVictory,
        "FuchsiaCity_Gym_EventScript_GiveTM06" to FuchsiaCity_Gym_EventScript_GiveTM06,
        "FuchsiaCity_Gym_EventScript_NoRoomForTM06" to FuchsiaCity_Gym_EventScript_NoRoomForTM06,
    )
