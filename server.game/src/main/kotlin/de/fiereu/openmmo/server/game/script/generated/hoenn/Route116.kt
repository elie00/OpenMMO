package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route116
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JOEY, Route116_Text_JoeyIntro, Route116_Text_JoeyDefeat
 * msgbox Route116_Text_JoeyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Joey : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JOEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.JoeyPostBattle)
    }
    ctx.say(Route116.JoeyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.JoeyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JOSE, Route116_Text_JoseIntro, Route116_Text_JoseDefeat
 * msgbox Route116_Text_JosePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Jose : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JOSE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.JosePostBattle)
    }
    ctx.say(Route116.JoseIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.JoseDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ETHER
 * end
 * ```
 */
internal object Route116_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ETHER, HoennFlags.FLAG_ITEM_ROUTE_116_ETHER, 6)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REPEL
 * end
 * ```
 */
internal object Route116_EventScript_ItemRepel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REPEL, HoennFlags.FLAG_ITEM_ROUTE_116_REPEL, 7)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox Route116_Text_ScoundrelMadeOffWithPeeko, MSGBOX_DEFAULT
 * setvar VAR_ROUTE116_STATE, 2
 * release
 * end
 * ```
 */
internal object Route116_EventScript_Briney : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_Briney")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CLARK, Route116_Text_ClarkIntro, Route116_Text_ClarkDefeat
 * msgbox Route116_Text_ClarkPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Clark : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CLARK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.ClarkPostBattle)
    }
    ctx.say(Route116.ClarkIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.ClarkDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HP_UP
 * end
 * ```
 */
internal object Route116_EventScript_ItemHPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HP_UP, HoennFlags.FLAG_ITEM_ROUTE_116_HP_UP, 14)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JANICE, Route116_Text_JaniceIntro, Route116_Text_JaniceDefeat
 * msgbox Route116_Text_JanicePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Janice : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JANICE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.JanicePostBattle)
    }
    ctx.say(Route116.JaniceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.JaniceDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_KAREN_1, Route116_Text_KarenIntro, Route116_Text_KarenDefeat, Route116_EventScript_TryRegisterKarenAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route116_EventScript_RematchKaren
 * setvar VAR_0x8004, TRAINER_KAREN_1
 * specialvar VAR_RESULT, IsTrainerRegistered
 * goto_if_eq VAR_RESULT, FALSE, Route116_EventScript_TryRegisterKaren
 * msgbox Route116_Text_KarenPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_Karen : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_Karen")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JERRY_1, Route116_Text_JerryIntro, Route116_Text_JerryDefeat, Route116_EventScript_TryRegisterJerryAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route116_EventScript_RematchJerry
 * setvar VAR_0x8004, TRAINER_JERRY_1
 * specialvar VAR_RESULT, IsTrainerRegistered
 * goto_if_eq VAR_RESULT, FALSE, Route116_EventScript_TryRegisterJerry
 * msgbox Route116_Text_JerryPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_Jerry : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_Jerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MET_DEVON_EMPLOYEE, Route116_EventScript_TryGiveRepeatBallAgain
 * msgbox Route116_Text_ThankYouTokenOfAppreciation, MSGBOX_DEFAULT
 * goto Route116_EventScript_GiveRepeatBall
 * end
 * ```
 */
internal object Route116_EventScript_DevonEmployee : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_DevonEmployee")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_X_SPECIAL
 * end
 * ```
 */
internal object Route116_EventScript_ItemXSpecial : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.X_SPECIAL, HoennFlags.FLAG_ITEM_ROUTE_116_X_SPECIAL, 19)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECOVERED_DEVON_GOODS, Route116_EventScript_BoyfriendGruntLeftTunnel
 * goto_if_set FLAG_DEVON_GOODS_STOLEN, Route116_EventScript_BoyfriendGruntInTunnel
 * msgbox Route116_Text_WantToDigTunnel, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_WandasBoyfriend : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_WandasBoyfriend")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * checkitem ITEM_BLACK_GLASSES
 * goto_if_eq VAR_RESULT, TRUE, Route116_EventScript_PlayerHasGlasses
 * specialvar VAR_RESULT, FoundBlackGlasses
 * goto_if_eq VAR_RESULT, TRUE, Route116_EventScript_FoundGlassesNotOnPlayer
 * msgbox Route116_Text_CanYouHelpMeFindGlasses, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_GlassesMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_GlassesMan")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SARAH, Route116_Text_SarahIntro, Route116_Text_SarahDefeat
 * msgbox Route116_Text_SarahPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Sarah : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SARAH
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.SarahPostBattle)
    }
    ctx.say(Route116.SarahIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.SarahDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DAWSON, Route116_Text_DawsonIntro, Route116_Text_DawsonDefeat
 * msgbox Route116_Text_DawsonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Dawson : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DAWSON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.DawsonPostBattle)
    }
    ctx.say(Route116.DawsonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.DawsonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_POTION
 * end
 * ```
 */
internal object Route116_EventScript_ItemPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.POTION, HoennFlags.FLAG_ITEM_ROUTE_116_POTION, 24)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JOHNSON, Route116_Text_JohnsonIntro, Route116_Text_JohnsonDefeat
 * msgbox Route116_Text_JohnsonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Johnson : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JOHNSON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.JohnsonPostBattle)
    }
    ctx.say(Route116.JohnsonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.JohnsonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DEVAN, Route116_Text_DevanIntro, Route116_Text_DevanDefeat
 * msgbox Route116_Text_DevanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_Devan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DEVAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route116.DevanPostBattle)
    }
    ctx.say(Route116.DevanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route116.DevanDefeat)
  }
}

internal object Route116_EventScript_RouteSignRustboro : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route116.RouteSignRustboro)
}

internal object Route116_EventScript_RusturfTunnelSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route116.RusturfTunnelSign)
}

internal object Route116_EventScript_TunnelersRestHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route116.TunnelersRestHouse)
}

internal object Route116_EventScript_TrainerTipsBToStopEvolution : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route116.TrainerTipsBToStopEvolution)
}

internal object Route116_EventScript_TrainerTipsBagHasPockets : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route116.TrainerTipsBagHasPockets)
}

internal val Route116Scripts: Map<String, Script> =
    mapOf(
        "Route116_EventScript_Joey" to Route116_EventScript_Joey,
        "Route116_EventScript_Jose" to Route116_EventScript_Jose,
        "Route116_EventScript_ItemEther" to Route116_EventScript_ItemEther,
        "Route116_EventScript_ItemRepel" to Route116_EventScript_ItemRepel,
        "Route116_EventScript_Briney" to Route116_EventScript_Briney,
        "Route116_EventScript_Clark" to Route116_EventScript_Clark,
        "Route116_EventScript_ItemHPUp" to Route116_EventScript_ItemHPUp,
        "Route116_EventScript_Janice" to Route116_EventScript_Janice,
        "Route116_EventScript_Karen" to Route116_EventScript_Karen,
        "Route116_EventScript_Jerry" to Route116_EventScript_Jerry,
        "Route116_EventScript_DevonEmployee" to Route116_EventScript_DevonEmployee,
        "Route116_EventScript_ItemXSpecial" to Route116_EventScript_ItemXSpecial,
        "Route116_EventScript_WandasBoyfriend" to Route116_EventScript_WandasBoyfriend,
        "Route116_EventScript_GlassesMan" to Route116_EventScript_GlassesMan,
        "Route116_EventScript_Sarah" to Route116_EventScript_Sarah,
        "Route116_EventScript_Dawson" to Route116_EventScript_Dawson,
        "Route116_EventScript_ItemPotion" to Route116_EventScript_ItemPotion,
        "Route116_EventScript_Johnson" to Route116_EventScript_Johnson,
        "Route116_EventScript_Devan" to Route116_EventScript_Devan,
        "Route116_EventScript_RouteSignRustboro" to Route116_EventScript_RouteSignRustboro,
        "Route116_EventScript_RusturfTunnelSign" to Route116_EventScript_RusturfTunnelSign,
        "Route116_EventScript_TunnelersRestHouseSign" to
            Route116_EventScript_TunnelersRestHouseSign,
        "Route116_EventScript_TrainerTipsBToStopEvolution" to
            Route116_EventScript_TrainerTipsBToStopEvolution,
        "Route116_EventScript_TrainerTipsBagHasPockets" to
            Route116_EventScript_TrainerTipsBagHasPockets,
    )
