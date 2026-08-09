package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route21_South
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_CLAUDE, Route21_South_Text_ClaudeIntro, Route21_South_Text_ClaudeDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_South_EventScript_ClaudeRematch
 * msgbox Route21_South_Text_ClaudePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_South_EventScript_Claude : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_CLAUDE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route21_South_EventScript_ClaudeRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route21_South.ClaudePostBattle)
    }
    ctx.say(Route21_South.ClaudeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route21_South.ClaudeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_NOLAN, Route21_South_Text_NolanIntro, Route21_South_Text_NolanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_South_EventScript_NolanRematch
 * msgbox Route21_South_Text_NolanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_South_EventScript_Nolan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_NOLAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route21_South_EventScript_NolanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route21_South.NolanPostBattle)
    }
    ctx.say(Route21_South.NolanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route21_South.NolanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_JACK, Route21_South_Text_JackIntro, Route21_South_Text_JackDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_South_EventScript_JackRematch
 * msgbox Route21_South_Text_JackPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_South_EventScript_Jack : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_JACK
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route21_South_EventScript_JackRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route21_South.JackPostBattle)
    }
    ctx.say(Route21_South.JackIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route21_South.JackDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_JEROME, Route21_South_Text_JeromeIntro, Route21_South_Text_JeromeDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_South_EventScript_JeromeRematch
 * msgbox Route21_South_Text_JeromePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_South_EventScript_Jerome : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_JEROME
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route21_South_EventScript_JeromeRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route21_South.JeromePostBattle)
    }
    ctx.say(Route21_South.JeromeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route21_South.JeromeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_ROLAND, Route21_South_Text_RolandIntro, Route21_South_Text_RolandDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_South_EventScript_RolandRematch
 * msgbox Route21_South_Text_RolandPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_South_EventScript_Roland : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_ROLAND
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route21_South_EventScript_RolandRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route21_South.RolandPostBattle)
    }
    ctx.say(Route21_South.RolandIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route21_South.RolandDefeat)
  }
}

internal val Route21_SouthScripts: Map<String, Script> =
    mapOf(
        "Route21_South_EventScript_Claude" to Route21_South_EventScript_Claude,
        "Route21_South_EventScript_Nolan" to Route21_South_EventScript_Nolan,
        "Route21_South_EventScript_Jack" to Route21_South_EventScript_Jack,
        "Route21_South_EventScript_Jerome" to Route21_South_EventScript_Jerome,
        "Route21_South_EventScript_Roland" to Route21_South_EventScript_Roland,
    )
