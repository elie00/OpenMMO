package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_Deck
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAILOR_TREVOR, SSAnne_Deck_Text_TrevorIntro, SSAnne_Deck_Text_TrevorDefeat
 * msgbox SSAnne_Deck_Text_TrevorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_Deck_EventScript_Trevor : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SAILOR_TREVOR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_Deck.TrevorPostBattle)
    }
    ctx.say(SSAnne_Deck.TrevorIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_Deck.TrevorDefeat)
  }
}

internal object SSAnne_Deck_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Deck.FeelSeasick)
}

internal object SSAnne_Deck_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Deck.ScrubbingDecksHardWork)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAILOR_EDMOND, SSAnne_Deck_Text_EdmondIntro, SSAnne_Deck_Text_EdmondDefeat
 * msgbox SSAnne_Deck_Text_EdmondPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_Deck_EventScript_Edmond : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SAILOR_EDMOND
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_Deck.EdmondPostBattle)
    }
    ctx.say(SSAnne_Deck.EdmondIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_Deck.EdmondDefeat)
  }
}

internal object SSAnne_Deck_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Deck.ShipDepartingSoon)
}

internal val SSAnne_DeckScripts: Map<String, Script> =
    mapOf(
        "SSAnne_Deck_EventScript_Trevor" to SSAnne_Deck_EventScript_Trevor,
        "SSAnne_Deck_EventScript_BaldingMan" to SSAnne_Deck_EventScript_BaldingMan,
        "SSAnne_Deck_EventScript_Sailor" to SSAnne_Deck_EventScript_Sailor,
        "SSAnne_Deck_EventScript_Edmond" to SSAnne_Deck_EventScript_Edmond,
        "SSAnne_Deck_EventScript_Youngster" to SSAnne_Deck_EventScript_Youngster,
    )
