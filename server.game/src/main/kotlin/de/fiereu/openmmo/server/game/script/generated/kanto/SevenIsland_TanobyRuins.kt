package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_TanobyRuins
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_BRANDON, SevenIsland_TanobyRuins_Text_BrandonIntro, SevenIsland_TanobyRuins_Text_BrandonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_TanobyRuins_EventScript_BrandonRematch
 * msgbox SevenIsland_TanobyRuins_Text_BrandonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_TanobyRuins_EventScript_Brandon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_BRANDON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_TanobyRuins_EventScript_BrandonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_TanobyRuins.BrandonPostBattle)
    }
    ctx.say(SevenIsland_TanobyRuins.BrandonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_TanobyRuins.BrandonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_BENJAMIN, SevenIsland_TanobyRuins_Text_BenjaminIntro, SevenIsland_TanobyRuins_Text_BenjaminDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_TanobyRuins_EventScript_BenjaminRematch
 * msgbox SevenIsland_TanobyRuins_Text_BenjaminPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_TanobyRuins_EventScript_Benjamin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_BENJAMIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_TanobyRuins_EventScript_BenjaminRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_TanobyRuins.BenjaminPostBattle)
    }
    ctx.say(SevenIsland_TanobyRuins.BenjaminIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_TanobyRuins.BenjaminDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAINTER_EDNA, SevenIsland_TanobyRuins_Text_EdnaIntro, SevenIsland_TanobyRuins_Text_EdnaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_TanobyRuins_EventScript_EdnaRematch
 * msgbox SevenIsland_TanobyRuins_Text_EdnaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_TanobyRuins_EventScript_Edna : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PAINTER_EDNA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_TanobyRuins_EventScript_EdnaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_TanobyRuins.EdnaPostBattle)
    }
    ctx.say(SevenIsland_TanobyRuins.EdnaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_TanobyRuins.EdnaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GENTLEMAN_CLIFFORD, SevenIsland_TanobyRuins_Text_CliffordIntro, SevenIsland_TanobyRuins_Text_CliffordDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_TanobyRuins_EventScript_CliffordRematch
 * msgbox SevenIsland_TanobyRuins_Text_CliffordPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_TanobyRuins_EventScript_Clifford : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GENTLEMAN_CLIFFORD
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_TanobyRuins_EventScript_CliffordRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_TanobyRuins.CliffordPostBattle)
    }
    ctx.say(SevenIsland_TanobyRuins.CliffordIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_TanobyRuins.CliffordDefeat)
  }
}

internal val SevenIsland_TanobyRuinsScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_TanobyRuins_EventScript_Brandon" to
            SevenIsland_TanobyRuins_EventScript_Brandon,
        "SevenIsland_TanobyRuins_EventScript_Benjamin" to
            SevenIsland_TanobyRuins_EventScript_Benjamin,
        "SevenIsland_TanobyRuins_EventScript_Edna" to SevenIsland_TanobyRuins_EventScript_Edna,
        "SevenIsland_TanobyRuins_EventScript_Clifford" to
            SevenIsland_TanobyRuins_EventScript_Clifford,
    )
