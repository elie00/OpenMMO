package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.RocketHideout_B2F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_13, RocketHideout_B2F_Text_GruntIntro, RocketHideout_B2F_Text_GruntDefeat
 * msgbox RocketHideout_B2F_Text_GruntPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RocketHideout_B2F_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_13
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RocketHideout_B2F.GruntPostBattle)
    }
    ctx.say(RocketHideout_B2F.GruntIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RocketHideout_B2F.GruntDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_X_SPEED
 * end
 * ```
 */
internal object RocketHideout_B2F_EventScript_ItemXSpeed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.X_SPEED, KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_X_SPEED, 1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MOON_STONE
 * end
 * ```
 */
internal object RocketHideout_B2F_EventScript_ItemMoonStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MOON_STONE, KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_MOON_STONE, 2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM12
 * end
 * ```
 */
internal object RocketHideout_B2F_EventScript_ItemTM12 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM12, KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_TM12, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SUPER_POTION
 * end
 * ```
 */
internal object RocketHideout_B2F_EventScript_ItemSuperPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.SUPER_POTION, KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B2F_SUPER_POTION, 4)
  }
}

internal val RocketHideout_B2FScripts: Map<String, Script> =
    mapOf(
        "RocketHideout_B2F_EventScript_Grunt" to RocketHideout_B2F_EventScript_Grunt,
        "RocketHideout_B2F_EventScript_ItemXSpeed" to RocketHideout_B2F_EventScript_ItemXSpeed,
        "RocketHideout_B2F_EventScript_ItemMoonStone" to
            RocketHideout_B2F_EventScript_ItemMoonStone,
        "RocketHideout_B2F_EventScript_ItemTM12" to RocketHideout_B2F_EventScript_ItemTM12,
        "RocketHideout_B2F_EventScript_ItemSuperPotion" to
            RocketHideout_B2F_EventScript_ItemSuperPotion,
    )
