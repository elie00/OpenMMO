package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MagmaHideout_2F_1R
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_4, MagmaHideout_2F_1R_Text_Grunt4Intro, MagmaHideout_2F_1R_Text_Grunt4Defeat
 * msgbox MagmaHideout_2F_1R_Text_Grunt4PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_1R_EventScript_Grunt4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_4
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_1R.Grunt4PostBattle)
    }
    ctx.say(MagmaHideout_2F_1R.Grunt4Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_1R.Grunt4Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_5, MagmaHideout_2F_1R_Text_Grunt5Intro, MagmaHideout_2F_1R_Text_Grunt5Defeat
 * msgbox MagmaHideout_2F_1R_Text_Grunt5PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_1R_EventScript_Grunt5 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_5
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_1R.Grunt5PostBattle)
    }
    ctx.say(MagmaHideout_2F_1R.Grunt5Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_1R.Grunt5Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_14, MagmaHideout_2F_1R_Text_Grunt14Intro, MagmaHideout_2F_1R_Text_Grunt14Defeat
 * msgbox MagmaHideout_2F_1R_Text_Grunt14PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_1R_EventScript_Grunt14 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_14
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_1R.Grunt14PostBattle)
    }
    ctx.say(MagmaHideout_2F_1R.Grunt14Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_1R.Grunt14Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_3, MagmaHideout_2F_1R_Text_Grunt3Intro, MagmaHideout_2F_1R_Text_Grunt3Defeat
 * msgbox MagmaHideout_2F_1R_Text_Grunt3PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_1R_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_3
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_1R.Grunt3PostBattle)
    }
    ctx.say(MagmaHideout_2F_1R.Grunt3Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_1R.Grunt3Defeat)
  }
}

internal val MagmaHideout_2F_1RScripts: Map<String, Script> =
    mapOf(
        "MagmaHideout_2F_1R_EventScript_Grunt4" to MagmaHideout_2F_1R_EventScript_Grunt4,
        "MagmaHideout_2F_1R_EventScript_Grunt5" to MagmaHideout_2F_1R_EventScript_Grunt5,
        "MagmaHideout_2F_1R_EventScript_Grunt14" to MagmaHideout_2F_1R_EventScript_Grunt14,
        "MagmaHideout_2F_1R_EventScript_Grunt3" to MagmaHideout_2F_1R_EventScript_Grunt3,
    )
