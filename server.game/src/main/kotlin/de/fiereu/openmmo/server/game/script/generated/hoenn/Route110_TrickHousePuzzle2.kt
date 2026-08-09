package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route110_TrickHousePuzzle2
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TED, Route110_TrickHousePuzzle2_Text_TedIntro, Route110_TrickHousePuzzle2_Text_TedDefeat
 * msgbox Route110_TrickHousePuzzle2_Text_TedPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_Ted : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TED
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle2.TedPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle2.TedIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle2.TedDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAUL, Route110_TrickHousePuzzle2_Text_PaulIntro, Route110_TrickHousePuzzle2_Text_PaulDefeat
 * msgbox Route110_TrickHousePuzzle2_Text_PaulPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_Paul : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PAUL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle2.PaulPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle2.PaulIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle2.PaulDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GEORGIA, Route110_TrickHousePuzzle2_Text_GeorgiaIntro, Route110_TrickHousePuzzle2_Text_GeorgiaDefeat
 * msgbox Route110_TrickHousePuzzle2_Text_GeorgiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_Georgia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GEORGIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle2.GeorgiaPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle2.GeorgiaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle2.GeorgiaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_WAVE_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_ItemWaveMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.WAVE_MAIL, HoennFlags.FLAG_ITEM_TRICK_HOUSE_PUZZLE_2_WAVE_MAIL, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HARBOR_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_ItemHarborMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HARBOR_MAIL, HoennFlags.FLAG_ITEM_TRICK_HOUSE_PUZZLE_2_HARBOR_MAIL, 4)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_eq VAR_TRICK_HOUSE_PUZZLE_2_STATE, 0, Route110_TrickHousePuzzle2_EventScript_FoundScroll
 * goto Route110_TrickHousePuzzle_EventScript_ReadScrollAgain
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_Scroll : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_TRICK_HOUSE_PUZZLE_2_STATE) == 0)
        return Route110_TrickHousePuzzle2_EventScript_FoundScroll.run(ctx)
    return Route110_TrickHousePuzzle_EventScript_ReadScrollAgain.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_TRICK_HOUSE_PUZZLE_2_STATE, 1
 * goto Route110_TrickHousePuzzle_EventScript_FoundScroll
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle2_EventScript_FoundScroll : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_TRICK_HOUSE_PUZZLE_2_STATE, 1)
    return Route110_TrickHousePuzzle_EventScript_FoundScroll.run(ctx)
  }
}

internal val Route110_TrickHousePuzzle2Scripts: Map<String, Script> =
    mapOf(
        "Route110_TrickHousePuzzle2_EventScript_Ted" to Route110_TrickHousePuzzle2_EventScript_Ted,
        "Route110_TrickHousePuzzle2_EventScript_Paul" to
            Route110_TrickHousePuzzle2_EventScript_Paul,
        "Route110_TrickHousePuzzle2_EventScript_Georgia" to
            Route110_TrickHousePuzzle2_EventScript_Georgia,
        "Route110_TrickHousePuzzle2_EventScript_ItemWaveMail" to
            Route110_TrickHousePuzzle2_EventScript_ItemWaveMail,
        "Route110_TrickHousePuzzle2_EventScript_ItemHarborMail" to
            Route110_TrickHousePuzzle2_EventScript_ItemHarborMail,
        "Route110_TrickHousePuzzle2_EventScript_Scroll" to
            Route110_TrickHousePuzzle2_EventScript_Scroll,
        "Route110_TrickHousePuzzle2_EventScript_FoundScroll" to
            Route110_TrickHousePuzzle2_EventScript_FoundScroll,
    )
