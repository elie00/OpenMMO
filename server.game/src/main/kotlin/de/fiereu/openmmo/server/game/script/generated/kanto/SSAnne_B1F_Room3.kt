package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room3
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAILOR_DYLAN, SSAnne_B1F_Room3_Text_DylanIntro, SSAnne_B1F_Room3_Text_DylanDefeat
 * msgbox SSAnne_B1F_Room3_Text_DylanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_B1F_Room3_EventScript_Dylan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SAILOR_DYLAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_B1F_Room3.DylanPostBattle)
    }
    ctx.say(SSAnne_B1F_Room3.DylanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_B1F_Room3.DylanDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_ETHER
 * end
 * ```
 */
internal object SSAnne_B1F_Room3_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SSAnne_B1F_Room3_EventScript_ItemEther")
}

internal val SSAnne_B1F_Room3Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room3_EventScript_Dylan" to SSAnne_B1F_Room3_EventScript_Dylan,
        "SSAnne_B1F_Room3_EventScript_ItemEther" to SSAnne_B1F_Room3_EventScript_ItemEther,
    )
