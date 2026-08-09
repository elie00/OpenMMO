package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ViridianCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_TAKASHI, ViridianCity_Gym_Text_TakashiIntro, ViridianCity_Gym_Text_TakashiDefeat
 * msgbox ViridianCity_Gym_Text_TakashiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Takashi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_TAKASHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.TakashiPostBattle)
    }
    ctx.say(ViridianCity_Gym.TakashiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.TakashiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_COOLTRAINER_YUJI, ViridianCity_Gym_Text_YujiIntro, ViridianCity_Gym_Text_YujiDefeat
 * msgbox ViridianCity_Gym_Text_YujiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Yuji : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_COOLTRAINER_YUJI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.YujiPostBattle)
    }
    ctx.say(ViridianCity_Gym.YujiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.YujiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_ATSUSHI, ViridianCity_Gym_Text_AtsushiIntro, ViridianCity_Gym_Text_AtsushiDefeat
 * msgbox ViridianCity_Gym_Text_AtsushiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Atsushi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_ATSUSHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.AtsushiPostBattle)
    }
    ctx.say(ViridianCity_Gym.AtsushiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.AtsushiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAMER_JASON, ViridianCity_Gym_Text_JasonIntro, ViridianCity_Gym_Text_JasonDefeat
 * msgbox ViridianCity_Gym_Text_JasonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Jason : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TAMER_JASON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.JasonPostBattle)
    }
    ctx.say(ViridianCity_Gym.JasonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.JasonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAMER_COLE, ViridianCity_Gym_Text_ColeIntro, ViridianCity_Gym_Text_ColeDefeat
 * msgbox ViridianCity_Gym_Text_ColePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Cole : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TAMER_COLE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.ColePostBattle)
    }
    ctx.say(ViridianCity_Gym.ColeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.ColeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_KIYO, ViridianCity_Gym_Text_KiyoIntro, ViridianCity_Gym_Text_KiyoDefeat
 * msgbox ViridianCity_Gym_Text_KiyoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Kiyo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_KIYO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.KiyoPostBattle)
    }
    ctx.say(ViridianCity_Gym.KiyoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.KiyoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_COOLTRAINER_SAMUEL, ViridianCity_Gym_Text_SamuelIntro, ViridianCity_Gym_Text_SamuelDefeat
 * msgbox ViridianCity_Gym_Text_SamuelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Samuel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_COOLTRAINER_SAMUEL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.SamuelPostBattle)
    }
    ctx.say(ViridianCity_Gym.SamuelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.SamuelDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_GIOVANNI, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_GIOVANNI, ViridianCity_Gym_Text_GiovanniIntro, ViridianCity_Gym_Text_GiovanniDefeat, ViridianCity_Gym_EventScript_DefeatedGiovanni, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM26_FROM_GIOVANNI, ViridianCity_Gym_EventScript_GiveTM26
 * msgbox ViridianCity_Gym_Text_GiovanniPostBattle
 * closemessage
 * fadescreen FADE_TO_BLACK
 * removeobject LOCALID_VIRIDIAN_GIOVANNI
 * fadescreen FADE_FROM_BLACK
 * release
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Giovanni : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ViridianCity_Gym_EventScript_Giovanni")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_COOLTRAINER_WARREN, ViridianCity_Gym_Text_WarrenIntro, ViridianCity_Gym_Text_WarrenDefeat
 * msgbox ViridianCity_Gym_Text_WarrenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_Warren : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_COOLTRAINER_WARREN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(ViridianCity_Gym.WarrenPostBattle)
    }
    ctx.say(ViridianCity_Gym.WarrenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ViridianCity_Gym.WarrenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_LEADER_GIOVANNI, ViridianCity_Gym_EventScript_GymGuyPostVictory
 * msgbox ViridianCity_Gym_Text_GymGuyAdvice
 * release
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_LEADER_GIOVANNI))
        return ViridianCity_Gym_EventScript_GymGuyPostVictory.run(ctx)
    ctx.say(ViridianCity_Gym.GymGuyAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE08_GET, ViridianCity_Gym_EventScript_GymStatuePostVictory
 * msgbox ViridianCity_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ViridianCity_Gym_EventScript_GymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox ViridianCity_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ViridianCity_Gym_EventScript_GymStatuePostVictory")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_GIOVANNI, 4
 * msgbox ViridianCity_Gym_Text_GymGuyPostVictory
 * release
 * end
 * ```
 */
internal object ViridianCity_Gym_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ViridianCity_Gym_EventScript_GymGuyPostVictory")
}

internal val ViridianCity_GymScripts: Map<String, Script> =
    mapOf(
        "ViridianCity_Gym_EventScript_Takashi" to ViridianCity_Gym_EventScript_Takashi,
        "ViridianCity_Gym_EventScript_Yuji" to ViridianCity_Gym_EventScript_Yuji,
        "ViridianCity_Gym_EventScript_Atsushi" to ViridianCity_Gym_EventScript_Atsushi,
        "ViridianCity_Gym_EventScript_Jason" to ViridianCity_Gym_EventScript_Jason,
        "ViridianCity_Gym_EventScript_Cole" to ViridianCity_Gym_EventScript_Cole,
        "ViridianCity_Gym_EventScript_Kiyo" to ViridianCity_Gym_EventScript_Kiyo,
        "ViridianCity_Gym_EventScript_Samuel" to ViridianCity_Gym_EventScript_Samuel,
        "ViridianCity_Gym_EventScript_Giovanni" to ViridianCity_Gym_EventScript_Giovanni,
        "ViridianCity_Gym_EventScript_Warren" to ViridianCity_Gym_EventScript_Warren,
        "ViridianCity_Gym_EventScript_GymGuy" to ViridianCity_Gym_EventScript_GymGuy,
        "ViridianCity_Gym_EventScript_GymStatue" to ViridianCity_Gym_EventScript_GymStatue,
        "ViridianCity_Gym_EventScript_GymStatuePostVictory" to
            ViridianCity_Gym_EventScript_GymStatuePostVictory,
        "ViridianCity_Gym_EventScript_GymGuyPostVictory" to
            ViridianCity_Gym_EventScript_GymGuyPostVictory,
    )
