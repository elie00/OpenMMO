package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room7
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GENTLEMAN_THOMAS, SSAnne_1F_Room7_Text_ThomasIntro, SSAnne_1F_Room7_Text_ThomasDefeat
 * msgbox SSAnne_1F_Room7_Text_ThomasPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_1F_Room7_EventScript_Thomas : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GENTLEMAN_THOMAS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_1F_Room7.ThomasPostBattle)
    }
    ctx.say(SSAnne_1F_Room7.ThomasIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_1F_Room7.ThomasDefeat)
  }
}

internal val SSAnne_1F_Room7Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room7_EventScript_Thomas" to SSAnne_1F_Room7_EventScript_Thomas,
    )
