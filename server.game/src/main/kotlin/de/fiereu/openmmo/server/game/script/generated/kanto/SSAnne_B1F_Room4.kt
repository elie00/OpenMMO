package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room4
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAILOR_DUNCAN, SSAnne_B1F_Room4_Text_DuncanIntro, SSAnne_B1F_Room4_Text_DuncanDefeat
 * msgbox SSAnne_B1F_Room4_Text_DuncanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_B1F_Room4_EventScript_Duncan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SAILOR_DUNCAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_B1F_Room4.DuncanPostBattle)
    }
    ctx.say(SSAnne_B1F_Room4.DuncanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_B1F_Room4.DuncanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAILOR_LEONARD, SSAnne_B1F_Room4_Text_LeonardIntro, SSAnne_B1F_Room4_Text_LeonardDefeat
 * msgbox SSAnne_B1F_Room4_Text_LeonardPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_B1F_Room4_EventScript_Leonard : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SAILOR_LEONARD
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_B1F_Room4.LeonardPostBattle)
    }
    ctx.say(SSAnne_B1F_Room4.LeonardIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_B1F_Room4.LeonardDefeat)
  }
}

internal val SSAnne_B1F_Room4Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room4_EventScript_Duncan" to SSAnne_B1F_Room4_EventScript_Duncan,
        "SSAnne_B1F_Room4_EventScript_Leonard" to SSAnne_B1F_Room4_EventScript_Leonard,
    )
