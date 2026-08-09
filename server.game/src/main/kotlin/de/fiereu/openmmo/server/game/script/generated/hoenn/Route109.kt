package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route109
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_DELIVERED_DEVON_GOODS, Route109_EventScript_HaveNotDeliveredDevonGood
 * goto Route109_EventScript_DeliveredDevonGoods
 * end
 * ```
 */
internal object Route109_EventScript_MrBriney : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(HoennFlags.FLAG_DELIVERED_DEVON_GOODS))
        return Route109_EventScript_HaveNotDeliveredDevonGood.run(ctx)
    return Route109_EventScript_DeliveredDevonGoods.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DAVID, Route109_Text_DavidIntro, Route109_Text_DavidDefeated
 * msgbox Route109_Text_DavidPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_David : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DAVID
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.DavidPostBattle)
    }
    ctx.say(Route109.DavidIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.DavidDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALICE, Route109_Text_AliceIntro, Route109_Text_AliceDefeated
 * msgbox Route109_Text_AlicePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Alice : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALICE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.AlicePostBattle)
    }
    ctx.say(Route109.AliceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.AliceDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HUEY, Route109_Text_HueyIntro, Route109_Text_HueyDefeated
 * msgbox Route109_Text_HueyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Huey : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HUEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.HueyPostBattle)
    }
    ctx.say(Route109.HueyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.HueyDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_EDMOND, Route109_Text_EdmondIntro, Route109_Text_EdmondDefeated
 * msgbox Route109_Text_EdmondPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Edmond : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_EDMOND
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.EdmondPostBattle)
    }
    ctx.say(Route109.EdmondIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.EdmondDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_RICKY_1, Route109_Text_RickyIntro, Route109_Text_RickyDefeated, Route109_EventScript_RickyRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route109_EventScript_RickyRematch
 * msgbox Route109_Text_RickyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route109_EventScript_Ricky : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_Ricky")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_LOLA_1, Route109_Text_LolaIntro, Route109_Text_LolaDefeated, Route109_EventScript_LolaRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route109_EventScript_LolaRematch
 * msgbox Route109_Text_LolaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route109_EventScript_Lola : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_Lola")
}

internal object Route109_EventScript_SeashoreHouseGirl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route109.ChillAtMyPapasSpot)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object Route109_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, HoennFlags.FLAG_ITEM_ROUTE_109_PP_UP, 9)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GWEN, Route109_Text_GwenIntro, Route109_Text_GwenDefeated
 * msgbox Route109_Text_GwenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Gwen : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GWEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.GwenPostBattle)
    }
    ctx.say(Route109.GwenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.GwenDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AUSTINA, Route109_Text_AustinaIntro, Route109_Text_AustinaDefeated
 * msgbox Route109_Text_AustinaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Austina : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_AUSTINA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.AustinaPostBattle)
    }
    ctx.say(Route109.AustinaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.AustinaDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CARTER, Route109_Text_CarterIntro, Route109_Text_CarterDefeated
 * msgbox Route109_Text_CarterPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Carter : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CARTER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.CarterPostBattle)
    }
    ctx.say(Route109.CarterIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.CarterDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox Route109_Text_SandCastleTakingLongTime, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object Route109_EventScript_SandCastleBoy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route109.SandCastleTakingLongTime)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * special GetPlayerBigGuyGirlString
 * goto_if_set FLAG_RECEIVED_SOFT_SAND, Route109_EventScript_AlreadyReceivedSoftSand
 * msgbox Route109_Text_YouCanHaveThis, MSGBOX_DEFAULT
 * giveitem ITEM_SOFT_SAND
 * goto_if_eq VAR_RESULT, 0, Common_EventScript_ShowBagIsFull
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * setflag FLAG_RECEIVED_SOFT_SAND
 * release
 * end
 * ```
 */
internal object Route109_EventScript_SoftSandGirl : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_SoftSandGirl")
}

internal object Route109_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route109.LittleKidsDartAround)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_MEL_AND_PAUL, Route109_Text_MelIntro, Route109_Text_MelDefeated, Route109_Text_MelNotEnoughPokemon
 * msgbox Route109_Text_MelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Mel : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_Mel")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_MEL_AND_PAUL, Route109_Text_PaulIntro, Route109_Text_PaulDefeated, Route109_Text_PaulNotEnoughPokemon
 * msgbox Route109_Text_PaulPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Paul : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_Paul")
}

internal object Route109_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route109.ZigzagoonPicksUpLitter)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_ZIGZAGOON, CRY_MODE_NORMAL
 * msgbox Route109_Text_ZigzagoonCry, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object Route109_EventScript_Zigzagoon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_Zigzagoon")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HAILEY, Route109_Text_HaileyIntro, Route109_Text_HaileyDefeated
 * msgbox Route109_Text_HaileyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Hailey : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HAILEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.HaileyPostBattle)
    }
    ctx.say(Route109.HaileyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.HaileyDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANDLER, Route109_Text_ChandlerIntro, Route109_Text_ChandlerDefeated
 * msgbox Route109_Text_ChandlerPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Chandler : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CHANDLER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.ChandlerPostBattle)
    }
    ctx.say(Route109.ChandlerIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.ChandlerDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_POTION
 * end
 * ```
 */
internal object Route109_EventScript_ItemPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.POTION, HoennFlags.FLAG_ITEM_ROUTE_109_POTION, 22)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ELIJAH, Route109_Text_ElijahIntro, Route109_Text_ElijahDefeated
 * msgbox Route109_Text_ElijahPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_Elijah : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ELIJAH
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route109.ElijahPostBattle)
    }
    ctx.say(Route109.ElijahIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route109.ElijahDefeated)
  }
}

internal object Route109_EventScript_SeashoreHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route109.SeashoreHouseSign)
}

internal object Route109_EventScript_TrainerTipsSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route109.TrainerTipsSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Route109_Text_BrineyWhereAreWeBound
 * waitmessage
 * multichoicedefault 21, 8, MULTI_BRINEY_OFF_DEWFORD, 1, FALSE
 * switch VAR_RESULT
 * case 0, Route109_EventScript_SailToDewford
 * case 1, Route109_EventScript_ChoseNotToSail
 * case MULTI_B_PRESSED, Route109_EventScript_ChoseNotToSail
 * end
 * ```
 */
internal object Route109_EventScript_DeliveredDevonGoods : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_EventScript_DeliveredDevonGoods")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_RICKY_1, Route109_Text_RickyRematchIntro, Route109_Text_RickyRematchDefeated
 * msgbox Route109_Text_RickyRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_RickyRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_RickyRematch")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route109_Text_WereGoingToMakeBigCastle, MSGBOX_DEFAULT
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object Route109_EventScript_AlreadyReceivedSoftSand : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route109.WereGoingToMakeBigCastle)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_LOLA_1, Route109_Text_LolaRematchIntro, Route109_Text_LolaRematchDefeated
 * msgbox Route109_Text_LolaRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_EventScript_LolaRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route109_EventScript_LolaRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Route109_Text_BrineySailToDewfordQuestion
 * msgbox Route109_Text_BrineySailToDewfordQuestion, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route109_EventScript_StayHere
 * goto Route109_EventScript_SailToDewford
 * end
 * ```
 */
internal object Route109_EventScript_HaveNotDeliveredDevonGood : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_EventScript_HaveNotDeliveredDevonGood")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route109_Text_BrineyDewfordItIs, MSGBOX_DEFAULT
 * closemessage
 * goto Route109_EventScript_StartDepartForDewford
 * end
 * ```
 */
internal object Route109_EventScript_SailToDewford : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route109.BrineyDewfordItIs)
    return Route109_EventScript_StartDepartForDewford.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route109_Text_BrineyDeliverDevonGoods, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route109_EventScript_StayHere : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route109.BrineyDeliverDevonGoods)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call EventScript_BackupMrBrineyLocation
 * setobjectsubpriority LOCALID_ROUTE109_BRINEY, MAP_ROUTE109, 0
 * setobjectsubpriority LOCALID_PLAYER, MAP_ROUTE109, 0
 * applymovement LOCALID_ROUTE109_BRINEY, Route109_Movement_BrineyEnterBoat
 * waitmovement 0
 * removeobject LOCALID_ROUTE109_BRINEY
 * switch VAR_FACING
 * case DIR_SOUTH, Route109_EventScript_EnterBoatSouth
 * case DIR_WEST, Route109_EventScript_EnterBoatWest
 * case DIR_EAST, Route109_EventScript_EnterBoatEast
 * end
 * ```
 */
internal object Route109_EventScript_StartDepartForDewford : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_EventScript_StartDepartForDewford")
}

internal val Route109Scripts: Map<String, Script> =
    mapOf(
        "Route109_EventScript_MrBriney" to Route109_EventScript_MrBriney,
        "Route109_EventScript_David" to Route109_EventScript_David,
        "Route109_EventScript_Alice" to Route109_EventScript_Alice,
        "Route109_EventScript_Huey" to Route109_EventScript_Huey,
        "Route109_EventScript_Edmond" to Route109_EventScript_Edmond,
        "Route109_EventScript_Ricky" to Route109_EventScript_Ricky,
        "Route109_EventScript_Lola" to Route109_EventScript_Lola,
        "Route109_EventScript_SeashoreHouseGirl" to Route109_EventScript_SeashoreHouseGirl,
        "Route109_EventScript_ItemPPUp" to Route109_EventScript_ItemPPUp,
        "Route109_EventScript_Gwen" to Route109_EventScript_Gwen,
        "Route109_EventScript_Austina" to Route109_EventScript_Austina,
        "Route109_EventScript_Carter" to Route109_EventScript_Carter,
        "Route109_EventScript_SandCastleBoy" to Route109_EventScript_SandCastleBoy,
        "Route109_EventScript_SoftSandGirl" to Route109_EventScript_SoftSandGirl,
        "Route109_EventScript_Woman" to Route109_EventScript_Woman,
        "Route109_EventScript_Mel" to Route109_EventScript_Mel,
        "Route109_EventScript_Paul" to Route109_EventScript_Paul,
        "Route109_EventScript_OldMan" to Route109_EventScript_OldMan,
        "Route109_EventScript_Zigzagoon" to Route109_EventScript_Zigzagoon,
        "Route109_EventScript_Hailey" to Route109_EventScript_Hailey,
        "Route109_EventScript_Chandler" to Route109_EventScript_Chandler,
        "Route109_EventScript_ItemPotion" to Route109_EventScript_ItemPotion,
        "Route109_EventScript_Elijah" to Route109_EventScript_Elijah,
        "Route109_EventScript_SeashoreHouseSign" to Route109_EventScript_SeashoreHouseSign,
        "Route109_EventScript_TrainerTipsSign" to Route109_EventScript_TrainerTipsSign,
        "Route109_EventScript_DeliveredDevonGoods" to Route109_EventScript_DeliveredDevonGoods,
        "Route109_EventScript_RickyRematch" to Route109_EventScript_RickyRematch,
        "Route109_EventScript_AlreadyReceivedSoftSand" to
            Route109_EventScript_AlreadyReceivedSoftSand,
        "Route109_EventScript_LolaRematch" to Route109_EventScript_LolaRematch,
        "Route109_EventScript_HaveNotDeliveredDevonGood" to
            Route109_EventScript_HaveNotDeliveredDevonGood,
        "Route109_EventScript_SailToDewford" to Route109_EventScript_SailToDewford,
        "Route109_EventScript_StayHere" to Route109_EventScript_StayHere,
        "Route109_EventScript_StartDepartForDewford" to Route109_EventScript_StartDepartForDewford,
    )
