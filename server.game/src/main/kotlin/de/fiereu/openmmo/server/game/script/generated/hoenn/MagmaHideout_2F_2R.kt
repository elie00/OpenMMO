package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MagmaHideout_2F_2R
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_8, MagmaHideout_2F_2R_Text_Grunt8Intro, MagmaHideout_2F_2R_Text_Grunt8Defeat
 * msgbox MagmaHideout_2F_2R_Text_Grunt8PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_2R_EventScript_Grunt8 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_8
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_2R.Grunt8PostBattle)
    }
    ctx.say(MagmaHideout_2F_2R.Grunt8Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_2R.Grunt8Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_7, MagmaHideout_2F_2R_Text_Grunt7Intro, MagmaHideout_2F_2R_Text_Grunt7Defeat
 * msgbox MagmaHideout_2F_2R_Text_Grunt7PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_2R_EventScript_Grunt7 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_7
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_2R.Grunt7PostBattle)
    }
    ctx.say(MagmaHideout_2F_2R.Grunt7Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_2R.Grunt7Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_ELIXIR
 * end
 * ```
 */
internal object MagmaHideout_2F_2R_EventScript_ItemMaxElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_ELIXIR, HoennFlags.FLAG_ITEM_MAGMA_HIDEOUT_2F_2R_MAX_ELIXIR, 2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_6, MagmaHideout_2F_2R_Text_Grunt6Intro, MagmaHideout_2F_2R_Text_Grunt6Defeat
 * msgbox MagmaHideout_2F_2R_Text_Grunt6PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_2R_EventScript_Grunt6 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_6
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_2R.Grunt6PostBattle)
    }
    ctx.say(MagmaHideout_2F_2R.Grunt6Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_2R.Grunt6Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_15, MagmaHideout_2F_2R_Text_Grunt15Intro, MagmaHideout_2F_2R_Text_Grunt15Defeat
 * msgbox MagmaHideout_2F_2R_Text_Grunt15PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_2F_2R_EventScript_Grunt15 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_15
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_2F_2R.Grunt15PostBattle)
    }
    ctx.say(MagmaHideout_2F_2R.Grunt15Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_2F_2R.Grunt15Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object MagmaHideout_2F_2R_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_RESTORE, HoennFlags.FLAG_ITEM_MAGMA_HIDEOUT_2F_2R_FULL_RESTORE, 5)
  }
}

internal val MagmaHideout_2F_2RScripts: Map<String, Script> =
    mapOf(
        "MagmaHideout_2F_2R_EventScript_Grunt8" to MagmaHideout_2F_2R_EventScript_Grunt8,
        "MagmaHideout_2F_2R_EventScript_Grunt7" to MagmaHideout_2F_2R_EventScript_Grunt7,
        "MagmaHideout_2F_2R_EventScript_ItemMaxElixir" to
            MagmaHideout_2F_2R_EventScript_ItemMaxElixir,
        "MagmaHideout_2F_2R_EventScript_Grunt6" to MagmaHideout_2F_2R_EventScript_Grunt6,
        "MagmaHideout_2F_2R_EventScript_Grunt15" to MagmaHideout_2F_2R_EventScript_Grunt15,
        "MagmaHideout_2F_2R_EventScript_ItemFullRestore" to
            MagmaHideout_2F_2R_EventScript_ItemFullRestore,
    )
