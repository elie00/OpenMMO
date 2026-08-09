package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route110_TrickHousePuzzle6
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SOPHIA, Route110_TrickHousePuzzle6_Text_SophiaIntro, Route110_TrickHousePuzzle6_Text_SophiaDefeat
 * msgbox Route110_TrickHousePuzzle6_Text_SophiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle6_EventScript_Sophia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SOPHIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle6.SophiaPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle6.SophiaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle6.SophiaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BENNY, Route110_TrickHousePuzzle6_Text_BennyIntro, Route110_TrickHousePuzzle6_Text_BennyDefeat
 * msgbox Route110_TrickHousePuzzle6_Text_BennyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle6_EventScript_Benny : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BENNY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle6.BennyPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle6.BennyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle6.BennyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SEBASTIAN, Route110_TrickHousePuzzle6_Text_SebastianIntro, Route110_TrickHousePuzzle6_Text_SebastianDefeat
 * msgbox Route110_TrickHousePuzzle6_Text_SebastianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle6_EventScript_Sebastian : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SEBASTIAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle6.SebastianPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle6.SebastianIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle6.SebastianDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_GLITTER_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle6_EventScript_ItemGlitterMail : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle6_EventScript_ItemGlitterMail")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_eq VAR_TRICK_HOUSE_PUZZLE_6_STATE, 0, Route110_TrickHousePuzzle6_EventScript_FoundScroll
 * goto Route110_TrickHousePuzzle_EventScript_ReadScrollAgain
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle6_EventScript_Scroll : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle6_EventScript_Scroll")
}

internal val Route110_TrickHousePuzzle6Scripts: Map<String, Script> =
    mapOf(
        "Route110_TrickHousePuzzle6_EventScript_Sophia" to
            Route110_TrickHousePuzzle6_EventScript_Sophia,
        "Route110_TrickHousePuzzle6_EventScript_Benny" to
            Route110_TrickHousePuzzle6_EventScript_Benny,
        "Route110_TrickHousePuzzle6_EventScript_Sebastian" to
            Route110_TrickHousePuzzle6_EventScript_Sebastian,
        "Route110_TrickHousePuzzle6_EventScript_ItemGlitterMail" to
            Route110_TrickHousePuzzle6_EventScript_ItemGlitterMail,
        "Route110_TrickHousePuzzle6_EventScript_Scroll" to
            Route110_TrickHousePuzzle6_EventScript_Scroll,
    )
