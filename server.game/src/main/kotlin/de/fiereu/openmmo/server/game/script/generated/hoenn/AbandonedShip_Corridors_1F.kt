package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip_Corridors_1F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object AbandonedShip_Corridors_1F_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(AbandonedShip_Corridors_1F.IsntItFunHere)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHARLIE, AbandonedShip_Corridors_1F_Text_CharlieIntro, AbandonedShip_Corridors_1F_Text_CharlieDefeat
 * msgbox AbandonedShip_Corridors_1F_Text_CharliePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object AbandonedShip_Corridors_1F_EventScript_Charlie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CHARLIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(AbandonedShip_Corridors_1F.CharliePostBattle)
    }
    ctx.say(AbandonedShip_Corridors_1F.CharlieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(AbandonedShip_Corridors_1F.CharlieDefeat)
  }
}

internal val AbandonedShip_Corridors_1FScripts: Map<String, Script> =
    mapOf(
        "AbandonedShip_Corridors_1F_EventScript_Youngster" to
            AbandonedShip_Corridors_1F_EventScript_Youngster,
        "AbandonedShip_Corridors_1F_EventScript_Charlie" to
            AbandonedShip_Corridors_1F_EventScript_Charlie,
    )
