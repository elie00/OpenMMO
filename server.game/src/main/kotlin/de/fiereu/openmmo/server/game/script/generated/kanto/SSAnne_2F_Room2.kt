package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_2F_Room2
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_DALE, SSAnne_2F_Room2_Text_DaleIntro, SSAnne_2F_Room2_Text_DaleDefeat
 * msgbox SSAnne_2F_Room2_Text_DalePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_2F_Room2_EventScript_Dale : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_DALE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_2F_Room2.DalePostBattle)
    }
    ctx.say(SSAnne_2F_Room2.DaleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_2F_Room2.DaleDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GENTLEMAN_BROOKS, SSAnne_2F_Room2_Text_BrooksIntro, SSAnne_2F_Room2_Text_BrooksDefeat
 * msgbox SSAnne_2F_Room2_Text_BrooksPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SSAnne_2F_Room2_EventScript_Brooks : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GENTLEMAN_BROOKS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SSAnne_2F_Room2.BrooksPostBattle)
    }
    ctx.say(SSAnne_2F_Room2.BrooksIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SSAnne_2F_Room2.BrooksDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_STARDUST
 * end
 * ```
 */
internal object SSAnne_2F_Room2_EventScript_ItemStardust : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.STARDUST, KantoFlags.FLAG_HIDE_SSANNE_2F_ROOM2_STARDUST, 2)
  }
}

internal val SSAnne_2F_Room2Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_2F_Room2_EventScript_Dale" to SSAnne_2F_Room2_EventScript_Dale,
        "SSAnne_2F_Room2_EventScript_Brooks" to SSAnne_2F_Room2_EventScript_Brooks,
        "SSAnne_2F_Room2_EventScript_ItemStardust" to SSAnne_2F_Room2_EventScript_ItemStardust,
    )
