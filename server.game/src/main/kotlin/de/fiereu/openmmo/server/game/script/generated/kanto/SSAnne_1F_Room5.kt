package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room5
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GENTLEMAN_ARTHUR, SSAnne_1F_Room5_Text_ArthurIntro, SSAnne_1F_Room5_Text_ArthurDefeat
 * msgbox SSAnne_1F_Room5_Text_ArthurPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_1F_Room5_EventScript_Arthur : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GENTLEMAN_ARTHUR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_1F_Room5.ArthurPostBattle)
    }
    ctx.say(SSAnne_1F_Room5.ArthurIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_1F_Room5.ArthurDefeat)
  }
}

internal val SSAnne_1F_Room5Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room5_EventScript_Arthur" to SSAnne_1F_Room5_EventScript_Arthur,
    )
