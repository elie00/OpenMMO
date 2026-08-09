package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SSTidalLowerDeck
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PHILLIP, SSTidalLowerDeck_Text_PhillipIntro, SSTidalLowerDeck_Text_PhillipDefeat
 * msgbox SSTidalLowerDeck_Text_PhillipPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSTidalLowerDeck_EventScript_Phillip : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PHILLIP
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSTidalLowerDeck.PhillipPostBattle)
    }
    ctx.say(SSTidalLowerDeck.PhillipIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSTidalLowerDeck.PhillipDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LEONARD, SSTidalLowerDeck_Text_LeonardIntro, SSTidalLowerDeck_Text_LeonardDefeat
 * msgbox SSTidalLowerDeck_Text_LeonardPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSTidalLowerDeck_EventScript_Leonard : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LEONARD
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSTidalLowerDeck.LeonardPostBattle)
    }
    ctx.say(SSTidalLowerDeck.LeonardIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSTidalLowerDeck.LeonardDefeat)
  }
}

internal val SSTidalLowerDeckScripts: Map<String, Script> =
    mapOf(
        "SSTidalLowerDeck_EventScript_Phillip" to SSTidalLowerDeck_EventScript_Phillip,
        "SSTidalLowerDeck_EventScript_Leonard" to SSTidalLowerDeck_EventScript_Leonard,
    )
