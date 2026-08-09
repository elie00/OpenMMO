package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MagmaHideout_3F_1R
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_9, MagmaHideout_3F_1R_Text_Grunt9Intro, MagmaHideout_3F_1R_Text_Grunt9Defeat
 * msgbox MagmaHideout_3F_1R_Text_Grunt9PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_3F_1R_EventScript_Grunt9 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_9
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_3F_1R.Grunt9PostBattle)
    }
    ctx.say(MagmaHideout_3F_1R.Grunt9Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_3F_1R.Grunt9Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_16, MagmaHideout_3F_1R_Text_Grunt16Intro, MagmaHideout_3F_1R_Text_Grunt16Defeat
 * msgbox MagmaHideout_3F_1R_Text_Grunt16PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_3F_1R_EventScript_Grunt16 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_16
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_3F_1R.Grunt16PostBattle)
    }
    ctx.say(MagmaHideout_3F_1R.Grunt16Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_3F_1R.Grunt16Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NUGGET
 * end
 * ```
 */
internal object MagmaHideout_3F_1R_EventScript_ItemNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NUGGET, HoennFlags.FLAG_ITEM_MAGMA_HIDEOUT_3F_1R_NUGGET, 2)
  }
}

internal val MagmaHideout_3F_1RScripts: Map<String, Script> =
    mapOf(
        "MagmaHideout_3F_1R_EventScript_Grunt9" to MagmaHideout_3F_1R_EventScript_Grunt9,
        "MagmaHideout_3F_1R_EventScript_Grunt16" to MagmaHideout_3F_1R_EventScript_Grunt16,
        "MagmaHideout_3F_1R_EventScript_ItemNugget" to MagmaHideout_3F_1R_EventScript_ItemNugget,
    )
