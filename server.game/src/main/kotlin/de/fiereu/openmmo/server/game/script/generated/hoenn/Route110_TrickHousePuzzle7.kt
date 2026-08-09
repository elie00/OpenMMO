package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route110_TrickHousePuzzle7
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JOSHUA, Route110_TrickHousePuzzle7_Text_JoshuaIntro, Route110_TrickHousePuzzle7_Text_JoshuaDefeat
 * msgbox Route110_TrickHousePuzzle7_Text_JoshuaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Joshua : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JOSHUA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle7.JoshuaPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle7.JoshuaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle7.JoshuaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALEXIS, Route110_TrickHousePuzzle7_Text_AlexisIntro, Route110_TrickHousePuzzle7_Text_AlexisDefeat
 * msgbox Route110_TrickHousePuzzle7_Text_AlexisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Alexis : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALEXIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle7.AlexisPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle7.AlexisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle7.AlexisDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PATRICIA, Route110_TrickHousePuzzle7_Text_PatriciaIntro, Route110_TrickHousePuzzle7_Text_PatriciaDefeat
 * msgbox Route110_TrickHousePuzzle7_Text_PatriciaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Patricia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PATRICIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle7.PatriciaPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle7.PatriciaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle7.PatriciaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TROPIC_MAIL
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_ItemTropicMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TROPIC_MAIL, HoennFlags.FLAG_ITEM_TRICK_HOUSE_PUZZLE_7_TROPIC_MAIL, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALVARO, Route110_TrickHousePuzzle7_Text_AlvaroIntro, Route110_TrickHousePuzzle7_Text_AlvaroDefeat
 * msgbox Route110_TrickHousePuzzle7_Text_AlvaroPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Alvaro : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALVARO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle7.AlvaroPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle7.AlvaroIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle7.AlvaroDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MARIELA, Route110_TrickHousePuzzle7_Text_MarielaIntro, Route110_TrickHousePuzzle7_Text_MarielaDefeat
 * msgbox Route110_TrickHousePuzzle7_Text_MarielaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Mariela : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MARIELA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle7.MarielaPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle7.MarielaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle7.MarielaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_EVERETT, Route110_TrickHousePuzzle7_Text_EverettIntro, Route110_TrickHousePuzzle7_Text_EverettDefeat
 * msgbox Route110_TrickHousePuzzle7_Text_EverettPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Everett : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_EVERETT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route110_TrickHousePuzzle7.EverettPostBattle)
    }
    ctx.say(Route110_TrickHousePuzzle7.EverettIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route110_TrickHousePuzzle7.EverettDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_eq VAR_TRICK_HOUSE_PUZZLE_7_STATE, 0, Route110_TrickHousePuzzle7_EventScript_FoundScroll
 * goto Route110_TrickHousePuzzle_EventScript_ReadScrollAgain
 * end
 * ```
 */
internal object Route110_TrickHousePuzzle7_EventScript_Scroll : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route110_TrickHousePuzzle7_EventScript_Scroll")
}

internal val Route110_TrickHousePuzzle7Scripts: Map<String, Script> =
    mapOf(
        "Route110_TrickHousePuzzle7_EventScript_Joshua" to
            Route110_TrickHousePuzzle7_EventScript_Joshua,
        "Route110_TrickHousePuzzle7_EventScript_Alexis" to
            Route110_TrickHousePuzzle7_EventScript_Alexis,
        "Route110_TrickHousePuzzle7_EventScript_Patricia" to
            Route110_TrickHousePuzzle7_EventScript_Patricia,
        "Route110_TrickHousePuzzle7_EventScript_ItemTropicMail" to
            Route110_TrickHousePuzzle7_EventScript_ItemTropicMail,
        "Route110_TrickHousePuzzle7_EventScript_Alvaro" to
            Route110_TrickHousePuzzle7_EventScript_Alvaro,
        "Route110_TrickHousePuzzle7_EventScript_Mariela" to
            Route110_TrickHousePuzzle7_EventScript_Mariela,
        "Route110_TrickHousePuzzle7_EventScript_Everett" to
            Route110_TrickHousePuzzle7_EventScript_Everett,
        "Route110_TrickHousePuzzle7_EventScript_Scroll" to
            Route110_TrickHousePuzzle7_EventScript_Scroll,
    )
