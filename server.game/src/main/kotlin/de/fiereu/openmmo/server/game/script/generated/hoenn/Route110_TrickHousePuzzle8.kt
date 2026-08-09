package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route110_TrickHousePuzzle8
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
 * trainerbattle_single TRAINER_VINCENT, Route110_TrickHousePuzzle8_Text_VincentIntro, Route110_TrickHousePuzzle8_Text_VincentDefeat
 * msgbox Route110_TrickHousePuzzle8_Text_VincentPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle8_EventScript_Vincent : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_VINCENT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle8.VincentPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle8.VincentIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle8.VincentDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LEROY, Route110_TrickHousePuzzle8_Text_LeroyIntro, Route110_TrickHousePuzzle8_Text_LeroyDefeat
 * msgbox Route110_TrickHousePuzzle8_Text_LeroyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle8_EventScript_Leroy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LEROY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle8.LeroyPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle8.LeroyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle8.LeroyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KEIRA, Route110_TrickHousePuzzle8_Text_KeiraIntro, Route110_TrickHousePuzzle8_Text_KeiraDefeat
 * msgbox Route110_TrickHousePuzzle8_Text_KeiraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle8_EventScript_Keira : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KEIRA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle8.KeiraPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle8.KeiraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle8.KeiraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BEAD_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle8_EventScript_ItemBeadMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BEAD_MAIL, HoennFlags.FLAG_ITEM_TRICK_HOUSE_PUZZLE_8_BEAD_MAIL, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_eq VAR_TRICK_HOUSE_PUZZLE_8_STATE, 0, Route110_TrickHousePuzzle8_EventScript_FoundScroll
 * goto Route110_TrickHousePuzzle_EventScript_ReadScrollAgain
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle8_EventScript_Scroll : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_TRICK_HOUSE_PUZZLE_8_STATE) == 0)
        return Route110_TrickHousePuzzle8_EventScript_FoundScroll.run(ctx)
    return Route110_TrickHousePuzzle_EventScript_ReadScrollAgain.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_TRICK_HOUSE_PUZZLE_8_STATE, 1
 * goto Route110_TrickHousePuzzle_EventScript_FoundScroll
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle8_EventScript_FoundScroll : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_TRICK_HOUSE_PUZZLE_8_STATE, 1)
    return Route110_TrickHousePuzzle_EventScript_FoundScroll.run(ctx)
  }
}

internal val Route110_TrickHousePuzzle8Scripts: Map<String, Script> =
    mapOf(
        "Route110_TrickHousePuzzle8_EventScript_Vincent" to
            Route110_TrickHousePuzzle8_EventScript_Vincent,
        "Route110_TrickHousePuzzle8_EventScript_Leroy" to
            Route110_TrickHousePuzzle8_EventScript_Leroy,
        "Route110_TrickHousePuzzle8_EventScript_Keira" to
            Route110_TrickHousePuzzle8_EventScript_Keira,
        "Route110_TrickHousePuzzle8_EventScript_ItemBeadMail" to
            Route110_TrickHousePuzzle8_EventScript_ItemBeadMail,
        "Route110_TrickHousePuzzle8_EventScript_Scroll" to
            Route110_TrickHousePuzzle8_EventScript_Scroll,
        "Route110_TrickHousePuzzle8_EventScript_FoundScroll" to
            Route110_TrickHousePuzzle8_EventScript_FoundScroll,
    )
