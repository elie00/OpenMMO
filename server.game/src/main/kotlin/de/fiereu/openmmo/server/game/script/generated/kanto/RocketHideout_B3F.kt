package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.RocketHideout_B3F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_15, RocketHideout_B3F_Text_Grunt2Intro, RocketHideout_B3F_Text_Grunt2Defeat
 * msgbox RocketHideout_B3F_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RocketHideout_B3F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_15
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RocketHideout_B3F.Grunt2PostBattle)
    }
    ctx.say(RocketHideout_B3F.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RocketHideout_B3F.Grunt2Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_14, RocketHideout_B3F_Text_Grunt1Intro, RocketHideout_B3F_Text_Grunt1Defeat
 * msgbox RocketHideout_B3F_Text_Grunt1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RocketHideout_B3F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_14
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RocketHideout_B3F.Grunt1PostBattle)
    }
    ctx.say(RocketHideout_B3F.Grunt1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RocketHideout_B3F.Grunt1Defeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object RocketHideout_B3F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RocketHideout_B3F_EventScript_ItemRareCandy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM21
 * end
 * ```
 */
internal object RocketHideout_B3F_EventScript_ItemTM21 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RocketHideout_B3F_EventScript_ItemTM21")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_BLACK_GLASSES
 * end
 * ```
 */
internal object RocketHideout_B3F_EventScript_ItemBlackGlasses : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RocketHideout_B3F_EventScript_ItemBlackGlasses")
}

internal val RocketHideout_B3FScripts: Map<String, Script> =
    mapOf(
        "RocketHideout_B3F_EventScript_Grunt2" to RocketHideout_B3F_EventScript_Grunt2,
        "RocketHideout_B3F_EventScript_Grunt1" to RocketHideout_B3F_EventScript_Grunt1,
        "RocketHideout_B3F_EventScript_ItemRareCandy" to
            RocketHideout_B3F_EventScript_ItemRareCandy,
        "RocketHideout_B3F_EventScript_ItemTM21" to RocketHideout_B3F_EventScript_ItemTM21,
        "RocketHideout_B3F_EventScript_ItemBlackGlasses" to
            RocketHideout_B3F_EventScript_ItemBlackGlasses,
    )
