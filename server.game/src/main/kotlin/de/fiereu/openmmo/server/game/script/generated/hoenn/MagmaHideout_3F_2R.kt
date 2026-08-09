package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MagmaHideout_3F_2R
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_10, MagmaHideout_3F_2R_Text_Grunt10Intro, MagmaHideout_3F_2R_Text_Grunt10Defeat
 * msgbox MagmaHideout_3F_2R_Text_Grunt10PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_3F_2R_EventScript_Grunt10 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_10
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_3F_2R.Grunt10PostBattle)
    }
    ctx.say(MagmaHideout_3F_2R.Grunt10Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_3F_2R.Grunt10Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_MAX
 * end
 * ```
 */
internal object MagmaHideout_3F_2R_EventScript_ItemPPMax : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_MAX, HoennFlags.FLAG_ITEM_MAGMA_HIDEOUT_3F_2R_PP_MAX, 1)
  }
}

internal val MagmaHideout_3F_2RScripts: Map<String, Script> =
    mapOf(
        "MagmaHideout_3F_2R_EventScript_Grunt10" to MagmaHideout_3F_2R_EventScript_Grunt10,
        "MagmaHideout_3F_2R_EventScript_ItemPPMax" to MagmaHideout_3F_2R_EventScript_ItemPPMax,
    )
