package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route133
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FRANKLIN, Route133_Text_FranklinIntro, Route133_Text_FranklinDefeat
 * msgbox Route133_Text_FranklinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Franklin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_FRANKLIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.FranklinPostBattle)
    }
    ctx.say(Route133.FranklinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.FranklinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LINDA, Route133_Text_LindaIntro, Route133_Text_LindaDefeat
 * msgbox Route133_Text_LindaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Linda : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LINDA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.LindaPostBattle)
    }
    ctx.say(Route133.LindaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.LindaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DEBRA, Route133_Text_DebraIntro, Route133_Text_DebraDefeat
 * msgbox Route133_Text_DebraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Debra : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DEBRA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.DebraPostBattle)
    }
    ctx.say(Route133.DebraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.DebraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BIG_PEARL
 * end
 * ```
 */
internal object Route133_EventScript_ItemBigPearl : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BIG_PEARL, HoennFlags.FLAG_ITEM_ROUTE_133_BIG_PEARL, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_STAR_PIECE
 * end
 * ```
 */
internal object Route133_EventScript_ItemStarPiece : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.STAR_PIECE, HoennFlags.FLAG_ITEM_ROUTE_133_STAR_PIECE, 4)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BECK, Route133_Text_BeckIntro, Route133_Text_BeckDefeat
 * msgbox Route133_Text_BeckPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Beck : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BECK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.BeckPostBattle)
    }
    ctx.say(Route133.BeckIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.BeckDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_WARREN, Route133_Text_WarrenIntro, Route133_Text_WarrenDefeat
 * msgbox Route133_Text_WarrenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Warren : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_WARREN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.WarrenPostBattle)
    }
    ctx.say(Route133.WarrenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.WarrenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MOLLIE, Route133_Text_MollieIntro, Route133_Text_MollieDefeat
 * msgbox Route133_Text_MolliePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Mollie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MOLLIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.MolliePostBattle)
    }
    ctx.say(Route133.MollieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.MollieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CONOR, Route133_Text_ConorIntro, Route133_Text_ConorDefeat
 * msgbox Route133_Text_ConorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route133_EventScript_Conor : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CONOR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route133.ConorPostBattle)
    }
    ctx.say(Route133.ConorIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route133.ConorDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_REVIVE
 * end
 * ```
 */
internal object Route133_EventScript_ItemMaxRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_REVIVE, HoennFlags.FLAG_ITEM_ROUTE_133_MAX_REVIVE, 9)
  }
}

internal val Route133Scripts: Map<String, Script> =
    mapOf(
        "Route133_EventScript_Franklin" to Route133_EventScript_Franklin,
        "Route133_EventScript_Linda" to Route133_EventScript_Linda,
        "Route133_EventScript_Debra" to Route133_EventScript_Debra,
        "Route133_EventScript_ItemBigPearl" to Route133_EventScript_ItemBigPearl,
        "Route133_EventScript_ItemStarPiece" to Route133_EventScript_ItemStarPiece,
        "Route133_EventScript_Beck" to Route133_EventScript_Beck,
        "Route133_EventScript_Warren" to Route133_EventScript_Warren,
        "Route133_EventScript_Mollie" to Route133_EventScript_Mollie,
        "Route133_EventScript_Conor" to Route133_EventScript_Conor,
        "Route133_EventScript_ItemMaxRevive" to Route133_EventScript_ItemMaxRevive,
    )
