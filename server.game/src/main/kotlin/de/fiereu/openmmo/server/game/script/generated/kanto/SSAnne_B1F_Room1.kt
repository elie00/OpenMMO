package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room1
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_BARNY, SSAnne_B1F_Room1_Text_BarnyIntro, SSAnne_B1F_Room1_Text_BarnyDefeat
 * msgbox SSAnne_B1F_Room1_Text_BarnyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_B1F_Room1_EventScript_Barny : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_BARNY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_B1F_Room1.BarnyPostBattle)
    }
    ctx.say(SSAnne_B1F_Room1.BarnyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_B1F_Room1.BarnyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAILOR_PHILLIP, SSAnne_B1F_Room1_Text_PhillipIntro, SSAnne_B1F_Room1_Text_PhillipDefeat
 * msgbox SSAnne_B1F_Room1_Text_PhillipPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_B1F_Room1_EventScript_Phillip : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SAILOR_PHILLIP
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_B1F_Room1.PhillipPostBattle)
    }
    ctx.say(SSAnne_B1F_Room1.PhillipIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_B1F_Room1.PhillipDefeat)
  }
}

internal val SSAnne_B1F_Room1Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room1_EventScript_Barny" to SSAnne_B1F_Room1_EventScript_Barny,
        "SSAnne_B1F_Room1_EventScript_Phillip" to SSAnne_B1F_Room1_EventScript_Phillip,
    )
