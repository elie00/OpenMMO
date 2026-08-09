package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_KAY, CeladonCity_Gym_Text_KayIntro, CeladonCity_Gym_Text_KayDefeat
 * msgbox CeladonCity_Gym_Text_KayPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Kay : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_KAY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CeladonCity_Gym.KayPostBattle)
    }
    ctx.say(CeladonCity_Gym.KayIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CeladonCity_Gym.KayDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_BRIDGET, CeladonCity_Gym_Text_BridgetIntro, CeladonCity_Gym_Text_BridgetDefeat
 * msgbox CeladonCity_Gym_Text_BridgetPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Bridget : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BEAUTY_BRIDGET
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CeladonCity_Gym.BridgetPostBattle)
    }
    ctx.say(CeladonCity_Gym.BridgetIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CeladonCity_Gym.BridgetDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_TINA, CeladonCity_Gym_Text_TinaIntro, CeladonCity_Gym_Text_TinaDefeat
 * msgbox CeladonCity_Gym_Text_TinaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Tina : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_TINA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CeladonCity_Gym.TinaPostBattle)
    }
    ctx.say(CeladonCity_Gym.TinaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CeladonCity_Gym.TinaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_TAMIA, CeladonCity_Gym_Text_TamiaIntro, CeladonCity_Gym_Text_TamiaDefeat
 * famechecker FAMECHECKER_ERIKA, 3
 * msgbox CeladonCity_Gym_Text_TamiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Tamia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_Gym_EventScript_Tamia")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BEAUTY_LORI, CeladonCity_Gym_Text_LoriIntro, CeladonCity_Gym_Text_LoriDefeat
 * msgbox CeladonCity_Gym_Text_LoriPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Lori : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BEAUTY_LORI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CeladonCity_Gym.LoriPostBattle)
    }
    ctx.say(CeladonCity_Gym.LoriIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CeladonCity_Gym.LoriDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_LASS_LISA, CeladonCity_Gym_Text_LisaIntro, CeladonCity_Gym_Text_LisaDefeat
 * famechecker FAMECHECKER_ERIKA, 2
 * msgbox CeladonCity_Gym_Text_LisaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Lisa : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_Gym_EventScript_Lisa")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_ERIKA, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_ERIKA, CeladonCity_Gym_Text_ErikaIntro, CeladonCity_Gym_Text_ErikaDefeat, CeladonCity_Gym_EventScript_DefeatedErika, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM19_FROM_ERIKA, CeladonCity_Gym_EventScript_GiveTM19
 * famechecker FAMECHECKER_ERIKA, 4
 * msgbox CeladonCity_Gym_Text_ErikaPostBattle
 * release
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Erika : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_Gym_EventScript_Erika")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_COOLTRAINER_MARY, CeladonCity_Gym_Text_MaryIntro, CeladonCity_Gym_Text_MaryDefeat
 * msgbox CeladonCity_Gym_Text_MaryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_Mary : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_COOLTRAINER_MARY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(CeladonCity_Gym.MaryPostBattle)
    }
    ctx.say(CeladonCity_Gym.MaryIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(CeladonCity_Gym.MaryDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE04_GET, CeladonCity_Gym_EventScript_GymStatuePostVictory
 * msgbox CeladonCity_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_Gym_EventScript_GymStatue")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_Gym.GymStatuePlayerWon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeladonCity_Gym_Text_ExplainRainbowBadgeTakeThis
 * checkitemspace ITEM_TM19
 * goto_if_eq VAR_RESULT, FALSE, CeladonCity_Gym_EventScript_NoRoomForTM19
 * giveitem_msg CeladonCity_Gym_Text_ReceivedTM19FromErika, ITEM_TM19
 * setflag FLAG_GOT_TM19_FROM_ERIKA
 * msgbox CeladonCity_Gym_Text_ExplainTM19
 * release
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_GiveTM19 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_Gym_EventScript_GiveTM19")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_Gym_Text_ShouldMakeRoomForThis
 * release
 * end
 * ```
 */
internal object CeladonCity_Gym_EventScript_NoRoomForTM19 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_Gym.ShouldMakeRoomForThis)
  }
}

internal val CeladonCity_GymScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_Gym_EventScript_Kay" to CeladonCity_Gym_EventScript_Kay,
        "CeladonCity_Gym_EventScript_Bridget" to CeladonCity_Gym_EventScript_Bridget,
        "CeladonCity_Gym_EventScript_Tina" to CeladonCity_Gym_EventScript_Tina,
        "CeladonCity_Gym_EventScript_Tamia" to CeladonCity_Gym_EventScript_Tamia,
        "CeladonCity_Gym_EventScript_Lori" to CeladonCity_Gym_EventScript_Lori,
        "CeladonCity_Gym_EventScript_Lisa" to CeladonCity_Gym_EventScript_Lisa,
        "CeladonCity_Gym_EventScript_Erika" to CeladonCity_Gym_EventScript_Erika,
        "CeladonCity_Gym_EventScript_Mary" to CeladonCity_Gym_EventScript_Mary,
        "CeladonCity_Gym_EventScript_GymStatue" to CeladonCity_Gym_EventScript_GymStatue,
        "CeladonCity_Gym_EventScript_GymStatuePostVictory" to
            CeladonCity_Gym_EventScript_GymStatuePostVictory,
        "CeladonCity_Gym_EventScript_GiveTM19" to CeladonCity_Gym_EventScript_GiveTM19,
        "CeladonCity_Gym_EventScript_NoRoomForTM19" to CeladonCity_Gym_EventScript_NoRoomForTM19,
    )
