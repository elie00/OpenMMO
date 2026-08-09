package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route116
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars
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
 * Ported from the decomp:
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
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.ScoundrelMadeOffWithPeeko)
    ctx.setVar(HoennVars.VAR_ROUTE116_STATE, 2)
  }
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
 * Ported from the decomp:
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
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_MET_DEVON_EMPLOYEE))
        return Route116_EventScript_TryGiveRepeatBallAgain.run(ctx)
    ctx.say(Route116.ThankYouTokenOfAppreciation)
    return Route116_EventScript_GiveRepeatBall.run(ctx)
  }
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
 * Ported from the decomp:
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
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECOVERED_DEVON_GOODS))
        return Route116_EventScript_BoyfriendGruntLeftTunnel.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEVON_GOODS_STOLEN))
        return Route116_EventScript_BoyfriendGruntInTunnel.run(ctx)
    ctx.say(Route116.WantToDigTunnel)
  }
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

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_KAREN_1, Route116_Text_KarenRematchIntro, Route116_Text_KarenRematchDefeat
 * msgbox Route116_Text_KarenPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_RematchKaren : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_RematchKaren")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_HAS_MATCH_CALL, Route116_EventScript_RegisterJerry
 * msgbox Route116_Text_JerryPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_TryRegisterJerry : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_HAS_MATCH_CALL))
        return Route116_EventScript_RegisterJerry.run(ctx)
    ctx.say(Route116.JerryPostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_HAS_MATCH_CALL, Route116_EventScript_RegisterKaren
 * msgbox Route116_Text_KarenPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_TryRegisterKaren : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_HAS_MATCH_CALL))
        return Route116_EventScript_RegisterKaren.run(ctx)
    ctx.say(Route116.KarenPostBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_JERRY_1, Route116_Text_JerryRematchIntro, Route116_Text_JerryRematchDefeat
 * msgbox Route116_Text_JerryPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route116_EventScript_RematchJerry : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_RematchJerry")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route116_Text_DiggingTunnelWhenGoonOrderedMeOut, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_BoyfriendGruntInTunnel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.DiggingTunnelWhenGoonOrderedMeOut)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route116_Text_CanYouHelpMeFindGlasses, MSGBOX_DEFAULT
 * msgbox Route116_Text_MayISeeThoseGlasses, MSGBOX_DEFAULT
 * specialvar VAR_RESULT, FoundBlackGlasses
 * goto_if_eq VAR_RESULT, TRUE, Route116_EventScript_FoundGlassesOnPlayer
 * msgbox Route116_Text_NotWhatImLookingFor, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_PlayerHasGlasses : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_PlayerHasGlasses")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_MET_DEVON_EMPLOYEE
 * giveitem ITEM_REPEAT_BALL
 * goto_if_eq VAR_RESULT, FALSE, Route116_EventScript_NoRoomForRepeatBall
 * msgbox Route116_Text_NewBallAvailableAtMart, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, Route116_EventScript_DevonEmployeeExit
 * call_if_eq VAR_FACING, DIR_SOUTH, Route116_EventScript_DevonEmployeeExit
 * call_if_eq VAR_FACING, DIR_WEST, Route116_EventScript_DevonEmployeeExit
 * call_if_eq VAR_FACING, DIR_EAST, Route116_EventScript_DevonEmployeeExitEast
 * removeobject VAR_LAST_TALKED
 * clearflag FLAG_HIDE_RUSTBORO_CITY_DEVON_CORP_3F_EMPLOYEE
 * setflag FLAG_RECEIVED_REPEAT_BALL
 * release
 * end
 * ```
 */
internal object Route116_EventScript_GiveRepeatBall : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_GiveRepeatBall")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route116_Text_CantFindGlassesNotHere, MSGBOX_DEFAULT
 * closemessage
 * goto Route116_EventScript_GlassesManExit
 * end
 * ```
 */
internal object Route116_EventScript_FoundGlassesNotOnPlayer : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.CantFindGlassesNotHere)
    return Route116_EventScript_GlassesManExit.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route116_Text_TokenOfAppreciation, MSGBOX_DEFAULT
 * goto Route116_EventScript_GiveRepeatBall
 * end
 * ```
 */
internal object Route116_EventScript_TryGiveRepeatBallAgain : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.TokenOfAppreciation)
    return Route116_EventScript_GiveRepeatBall.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route116_Text_GoonHightailedItOutOfTunnel, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_BoyfriendGruntLeftTunnel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.GoonHightailedItOutOfTunnel)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route116_Text_NotWhatImLookingForMaybeTheyArentHere, MSGBOX_DEFAULT
 * closemessage
 * goto Route116_EventScript_GlassesManExit
 * end
 * ```
 */
internal object Route116_EventScript_FoundGlassesOnPlayer : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.NotWhatImLookingForMaybeTheyArentHere)
    return Route116_EventScript_GlassesManExit.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route116_Text_JerryRegister1, MSGBOX_DEFAULT
 * register_matchcall TRAINER_JERRY_1
 * release
 * end
 * ```
 */
internal object Route116_EventScript_RegisterJerry : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_RegisterJerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Route116_Movement_DevonEmployeeExit
 * waitmovement 0
 * return
 * ```
 */
internal object Route116_EventScript_DevonEmployeeExit : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_DevonEmployeeExit")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Route116_Movement_DevonEmployeeExitEast
 * waitmovement 0
 * return
 * ```
 */
internal object Route116_EventScript_DevonEmployeeExitEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route116_EventScript_DevonEmployeeExitEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * delay 20
 * call_if_eq VAR_FACING, DIR_NORTH, Route116_EventScript_GlassesManExitNormal
 * call_if_eq VAR_FACING, DIR_SOUTH, Route116_EventScript_GlassesManExitNormal
 * call_if_eq VAR_FACING, DIR_WEST, Route116_EventScript_GlassesManExitNormal
 * call_if_eq VAR_FACING, DIR_EAST, Route116_EventScript_GlassesManExitEast
 * removeobject VAR_LAST_TALKED
 * release
 * end
 * ```
 */
internal object Route116_EventScript_GlassesManExit : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_GlassesManExit")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route116_Text_BagIsJamPacked, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route116_EventScript_NoRoomForRepeatBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route116.BagIsJamPacked)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route116_Text_KarenRegister1, MSGBOX_DEFAULT
 * register_matchcall TRAINER_KAREN_1
 * release
 * end
 * ```
 */
internal object Route116_EventScript_RegisterKaren : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route116_EventScript_RegisterKaren")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Route116_Movement_GlassesManExit
 * waitmovement 0
 * return
 * ```
 */
internal object Route116_EventScript_GlassesManExitNormal : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route116_EventScript_GlassesManExitNormal")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Route116_Movement_GlassesManExitEast
 * waitmovement 0
 * return
 * ```
 */
internal object Route116_EventScript_GlassesManExitEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route116_EventScript_GlassesManExitEast")
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
        "Route116_EventScript_RematchKaren" to Route116_EventScript_RematchKaren,
        "Route116_EventScript_TryRegisterJerry" to Route116_EventScript_TryRegisterJerry,
        "Route116_EventScript_TryRegisterKaren" to Route116_EventScript_TryRegisterKaren,
        "Route116_EventScript_RematchJerry" to Route116_EventScript_RematchJerry,
        "Route116_EventScript_BoyfriendGruntInTunnel" to
            Route116_EventScript_BoyfriendGruntInTunnel,
        "Route116_EventScript_PlayerHasGlasses" to Route116_EventScript_PlayerHasGlasses,
        "Route116_EventScript_GiveRepeatBall" to Route116_EventScript_GiveRepeatBall,
        "Route116_EventScript_FoundGlassesNotOnPlayer" to
            Route116_EventScript_FoundGlassesNotOnPlayer,
        "Route116_EventScript_TryGiveRepeatBallAgain" to
            Route116_EventScript_TryGiveRepeatBallAgain,
        "Route116_EventScript_BoyfriendGruntLeftTunnel" to
            Route116_EventScript_BoyfriendGruntLeftTunnel,
        "Route116_EventScript_FoundGlassesOnPlayer" to Route116_EventScript_FoundGlassesOnPlayer,
        "Route116_EventScript_RegisterJerry" to Route116_EventScript_RegisterJerry,
        "Route116_EventScript_DevonEmployeeExit" to Route116_EventScript_DevonEmployeeExit,
        "Route116_EventScript_DevonEmployeeExitEast" to Route116_EventScript_DevonEmployeeExitEast,
        "Route116_EventScript_GlassesManExit" to Route116_EventScript_GlassesManExit,
        "Route116_EventScript_NoRoomForRepeatBall" to Route116_EventScript_NoRoomForRepeatBall,
        "Route116_EventScript_RegisterKaren" to Route116_EventScript_RegisterKaren,
        "Route116_EventScript_GlassesManExitNormal" to Route116_EventScript_GlassesManExitNormal,
        "Route116_EventScript_GlassesManExitEast" to Route116_EventScript_GlassesManExitEast,
    )
