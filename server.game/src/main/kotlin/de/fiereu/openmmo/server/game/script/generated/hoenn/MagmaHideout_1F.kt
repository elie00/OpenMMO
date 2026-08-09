package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MagmaHideout_1F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_1, MagmaHideout_1F_Text_Grunt1Intro, MagmaHideout_1F_Text_Grunt1Defeat
 * msgbox MagmaHideout_1F_Text_Grunt1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_1F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_1
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_1F.Grunt1PostBattle)
    }
    ctx.say(MagmaHideout_1F.Grunt1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_1F.Grunt1Defeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object MagmaHideout_1F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MagmaHideout_1F_EventScript_ItemRareCandy")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MAGMA_HIDEOUT_2, MagmaHideout_1F_Text_Grunt2Intro, MagmaHideout_1F_Text_Grunt2Defeat
 * msgbox MagmaHideout_1F_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MagmaHideout_1F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MAGMA_HIDEOUT_2
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MagmaHideout_1F.Grunt2PostBattle)
    }
    ctx.say(MagmaHideout_1F.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MagmaHideout_1F.Grunt2Defeat)
  }
}

internal val MagmaHideout_1FScripts: Map<String, Script> =
    mapOf(
        "MagmaHideout_1F_EventScript_Grunt1" to MagmaHideout_1F_EventScript_Grunt1,
        "MagmaHideout_1F_EventScript_ItemRareCandy" to MagmaHideout_1F_EventScript_ItemRareCandy,
        "MagmaHideout_1F_EventScript_Grunt2" to MagmaHideout_1F_EventScript_Grunt2,
    )
