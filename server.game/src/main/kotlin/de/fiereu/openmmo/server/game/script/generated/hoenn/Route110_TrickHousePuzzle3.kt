package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route110_TrickHousePuzzle3
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUSTIN, Route110_TrickHousePuzzle3_Text_JustinIntro, Route110_TrickHousePuzzle3_Text_JustinDefeat
 * msgbox Route110_TrickHousePuzzle3_Text_JustinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle3_EventScript_Justin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JUSTIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle3.JustinPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle3.JustinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle3.JustinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MARTHA, Route110_TrickHousePuzzle3_Text_MarthaIntro, Route110_TrickHousePuzzle3_Text_MarthaDefeat
 * msgbox Route110_TrickHousePuzzle3_Text_MarthaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle3_EventScript_Martha : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MARTHA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle3.MarthaPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle3.MarthaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle3.MarthaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALAN, Route110_TrickHousePuzzle3_Text_AlanIntro, Route110_TrickHousePuzzle3_Text_AlanDefeat
 * msgbox Route110_TrickHousePuzzle3_Text_AlanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle3_EventScript_Alan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle3.AlanPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle3.AlanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle3.AlanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_WOOD_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle3_EventScript_ItemWoodMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.WOOD_MAIL, HoennFlags.FLAG_ITEM_TRICK_HOUSE_PUZZLE_3_WOOD_MAIL, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SHADOW_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle3_EventScript_ItemShadowMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.SHADOW_MAIL, HoennFlags.FLAG_ITEM_TRICK_HOUSE_PUZZLE_3_SHADOW_MAIL, 4)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_eq VAR_TRICK_HOUSE_PUZZLE_3_STATE, 0, Route110_TrickHousePuzzle3_EventScript_FoundScroll
 * goto Route110_TrickHousePuzzle_EventScript_ReadScrollAgain
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle3_EventScript_Scroll : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle3_EventScript_Scroll")
}

internal val Route110_TrickHousePuzzle3Scripts: Map<String, Script> =
    mapOf(
        "Route110_TrickHousePuzzle3_EventScript_Justin" to
            Route110_TrickHousePuzzle3_EventScript_Justin,
        "Route110_TrickHousePuzzle3_EventScript_Martha" to
            Route110_TrickHousePuzzle3_EventScript_Martha,
        "Route110_TrickHousePuzzle3_EventScript_Alan" to
            Route110_TrickHousePuzzle3_EventScript_Alan,
        "Route110_TrickHousePuzzle3_EventScript_ItemWoodMail" to
            Route110_TrickHousePuzzle3_EventScript_ItemWoodMail,
        "Route110_TrickHousePuzzle3_EventScript_ItemShadowMail" to
            Route110_TrickHousePuzzle3_EventScript_ItemShadowMail,
        "Route110_TrickHousePuzzle3_EventScript_Scroll" to
            Route110_TrickHousePuzzle3_EventScript_Scroll,
    )
