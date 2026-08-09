package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_2F_Room4
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GENTLEMAN_LAMAR, SSAnne_2F_Room4_Text_LamarIntro, SSAnne_2F_Room4_Text_LamarDefeat
 * msgbox SSAnne_2F_Room4_Text_LamarPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_2F_Room4_EventScript_Lamar : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GENTLEMAN_LAMAR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_2F_Room4.LamarPostBattle)
    }
    ctx.say(SSAnne_2F_Room4.LamarIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_2F_Room4.LamarDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_DAWN, SSAnne_2F_Room4_Text_DawnIntro, SSAnne_2F_Room4_Text_DawnDefeat
 * msgbox SSAnne_2F_Room4_Text_DawnPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_2F_Room4_EventScript_Dawn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_DAWN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_2F_Room4.DawnPostBattle)
    }
    ctx.say(SSAnne_2F_Room4.DawnIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_2F_Room4.DawnDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_X_ATTACK
 * end
 * ```
 */
internal object SSAnne_2F_Room4_EventScript_ItemXAttack : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SSAnne_2F_Room4_EventScript_ItemXAttack")
}

internal val SSAnne_2F_Room4Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_2F_Room4_EventScript_Lamar" to SSAnne_2F_Room4_EventScript_Lamar,
        "SSAnne_2F_Room4_EventScript_Dawn" to SSAnne_2F_Room4_EventScript_Dawn,
        "SSAnne_2F_Room4_EventScript_ItemXAttack" to SSAnne_2F_Room4_EventScript_ItemXAttack,
    )
