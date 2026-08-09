package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Kecleon
import de.fiereu.openmmo.dialog.generated.hoenn.Route120
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_LEFT
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_COLIN, Route120_Text_ColinIntro, Route120_Text_ColinDefeat
 * msgbox Route120_Text_ColinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Colin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_COLIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.ColinPostBattle)
    }
    ctx.say(Route120.ColinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.ColinDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_ROBERT_1, Route120_Text_RobertIntro, Route120_Text_RobertDefeat, Route120_EventScript_RegisterRobert
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route120_EventScript_RematchRobert
 * msgbox Route120_Text_RobertPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route120_EventScript_Robert : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route120_EventScript_Robert")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LORENZO, Route120_Text_LorenzoIntro, Route120_Text_LorenzoDefeat
 * msgbox Route120_Text_LorenzoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Lorenzo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LORENZO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.LorenzoPostBattle)
    }
    ctx.say(Route120.LorenzoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.LorenzoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JENNA, Route120_Text_JennaIntro, Route120_Text_JennaDefeat
 * msgbox Route120_Text_JennaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Jenna : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JENNA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.JennaPostBattle)
    }
    ctx.say(Route120.JennaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.JennaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JEFFREY_1, Route120_Text_JeffreyIntro, Route120_Text_JeffreyDefeat, Route120_EventScript_RegisterJeffrey
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route120_EventScript_RematchJeffrey
 * msgbox Route120_Text_JeffreyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route120_EventScript_Jeffrey : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route120_EventScript_Jeffrey")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NUGGET
 * end
 * ```
 */
internal object Route120_EventScript_ItemNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NUGGET, HoennFlags.FLAG_ITEM_ROUTE_120_NUGGET, 15)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_GABBY_AND_TY_3, GabbyAndTy_Text_TyIntro, GabbyAndTy_Text_TyDefeat, GabbyAndTy_Text_TyNotEnoughMons, GabbyAndTy_EventScript_RequestInterview
 * msgbox GabbyAndTy_Text_TyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object GabbyAndTy_EventScript_TyBattle3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port GabbyAndTy_EventScript_TyBattle3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_GABBY_AND_TY_3, GabbyAndTy_Text_GabbyIntro, GabbyAndTy_Text_GabbyDefeat, GabbyAndTy_Text_GabbyNotEnoughMons, GabbyAndTy_EventScript_RequestInterview
 * msgbox GabbyAndTy_Text_KeepingAnEyeOutForYou, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object GabbyAndTy_EventScript_GabbyBattle3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port GabbyAndTy_EventScript_GabbyBattle3")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_HEAL
 * end
 * ```
 */
internal object Route120_EventScript_ItemFullHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_HEAL, HoennFlags.FLAG_ITEM_ROUTE_120_FULL_HEAL, 21)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * goto_if_set FLAG_DAILY_ROUTE_120_RECEIVED_BERRY, Route120_EventScript_ReceivedBerry
 * msgbox Route120_Text_BerriesExpressionOfLoveIsntIt, MSGBOX_YESNO
 * call_if_eq VAR_RESULT, YES, Route120_EventScript_BerryLove
 * call_if_eq VAR_RESULT, NO, Route120_EventScript_BerryNotLove
 * specialvar VAR_RESULT, GetPlayerTrainerIdOnesDigit
 * switch VAR_RESULT
 * case 0, Route120_EventScript_GiveFigyBerry
 * case 5, Route120_EventScript_GiveFigyBerry
 * case 1, Route120_EventScript_GiveWikiBerry
 * case 6, Route120_EventScript_GiveWikiBerry
 * case 2, Route120_EventScript_GiveMagoBerry
 * case 7, Route120_EventScript_GiveMagoBerry
 * case 3, Route120_EventScript_GiveAguavBerry
 * case 8, Route120_EventScript_GiveAguavBerry
 * case 4, Route120_EventScript_GiveIapapaBerry
 * case 9, Route120_EventScript_GiveIapapaBerry
 * end
 * ```
 */
internal object Route120_EventScript_BerryBeauty : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route120_EventScript_BerryBeauty")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JENNIFER, Route120_Text_JenniferIntro, Route120_Text_JenniferDefeat
 * msgbox Route120_Text_JenniferPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Jennifer : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JENNIFER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.JenniferPostBattle)
    }
    ctx.say(Route120.JenniferIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.JenniferDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHIP, Route120_Text_ChipIntro, Route120_Text_ChipDefeat
 * msgbox Route120_Text_ChipPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Chip : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CHIP
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.ChipPostBattle)
    }
    ctx.say(Route120.ChipIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.ChipDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CLARISSA, Route120_Text_ClarissaIntro, Route120_Text_ClarissaDefeat
 * msgbox Route120_Text_ClarissaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Clarissa : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CLARISSA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.ClarissaPostBattle)
    }
    ctx.say(Route120.ClarissaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.ClarissaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ANGELICA, Route120_Text_AngelicaIntro, Route120_Text_AngelicaDefeat
 * msgbox Route120_Text_AngelicaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Angelica : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ANGELICA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.AngelicaPostBattle)
    }
    ctx.say(Route120.AngelicaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.AngelicaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NEST_BALL
 * end
 * ```
 */
internal object Route120_EventScript_ItemNestBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NEST_BALL, HoennFlags.FLAG_ITEM_ROUTE_120_NEST_BALL, 27)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HYPER_POTION
 * end
 * ```
 */
internal object Route120_EventScript_ItemHyperPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HYPER_POTION, HoennFlags.FLAG_ITEM_ROUTE_120_HYPER_POTION, 28)
  }
}

internal object Route120_EventScript_BridgeKecleon : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Kecleon.SomethingUnseeable)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_NOT_READY_FOR_BATTLE_ROUTE_120, Route120_EventScript_StevenAskReadyForBattle
 * msgbox Route120_Text_StevenGreeting, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route120_EventScript_StevenNotReady
 * goto Route120_EventScript_StevenBattleKecleon
 * end
 * ```
 */
internal object Route120_EventScript_Steven : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route120_EventScript_Steven")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KEIGO, Route120_Text_KeigoIntro, Route120_Text_KeigoDefeat
 * msgbox Route120_Text_KeigoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Keigo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KEIGO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.KeigoPostBattle)
    }
    ctx.say(Route120.KeigoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.KeigoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RILEY, Route120_Text_RileyIntro, Route120_Text_RileyDefeat
 * msgbox Route120_Text_RileyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Riley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RILEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.RileyPostBattle)
    }
    ctx.say(Route120.RileyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.RileyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 1
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route120_EventScript_Kecleon1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 1)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 2
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route120_EventScript_Kecleon2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 2)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 3
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route120_EventScript_Kecleon3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 3)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 5
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route120_EventScript_Kecleon5 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 5)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 4
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route120_EventScript_Kecleon4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 4)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CALLIE, Route120_Text_CallieIntro, Route120_Text_CallieDefeat
 * msgbox Route120_Text_CalliePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Callie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CALLIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.CalliePostBattle)
    }
    ctx.say(Route120.CallieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.CallieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LEONEL, Route120_Text_LeonelIntro, Route120_Text_LeonelDefeat
 * msgbox Route120_Text_LeonelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_Leonel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LEONEL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route120.LeonelPostBattle)
    }
    ctx.say(Route120.LeonelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route120.LeonelDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVE
 * end
 * ```
 */
internal object Route120_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVE, HoennFlags.FLAG_ITEM_ROUTE_120_REVIVE, 43)
  }
}

internal object Route120_EventScript_RouteSignFortree : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route120.RouteSignFortree)
}

internal object Route120_EventScript_RouteSign121 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route120.RouteSign121)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route120_Text_MakeYourOwnImpressions, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object Route120_EventScript_BerryNotLove : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route120.MakeYourOwnImpressions)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route120_Text_StevenReadyForBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route120_EventScript_StevenNotReady
 * goto Route120_EventScript_StevenBattleKecleon
 * end
 * ```
 */
internal object Route120_EventScript_StevenAskReadyForBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route120_EventScript_StevenAskReadyForBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route120_Text_StevenShowMeYourPower, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, Route120_EventScript_PlayerApproachKecleonNorth
 * call_if_eq VAR_FACING, DIR_WEST, Route120_EventScript_PlayerApproachKecleonWest
 * applymovement LOCALID_ROUTE120_STEVEN, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * delay 20
 * msgbox Route120_Text_StevenUsedDevonScope, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_BRIDGE_KECLEON, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * applymovement LOCALID_BRIDGE_KECLEON, Movement_KecleonAppears
 * waitmovement 0
 * waitse
 * playmoncry SPECIES_KECLEON, CRY_MODE_ENCOUNTER
 * delay 40
 * waitmoncry
 * setwildbattle SPECIES_KECLEON, 30
 * setvar VAR_0x8009, 0
 * setflag FLAG_SYS_CTRL_OBJ_DELETE
 * dowildbattle
 * clearflag FLAG_SYS_CTRL_OBJ_DELETE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, Route120_EventScript_RemoveBridgeKecleonPostBattle
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, Route120_EventScript_RemoveBridgeKecleonPostBattle
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, Route120_EventScript_RemoveBridgeKecleonPostBattle
 * goto Route120_EventScript_StevenGiveDeconScope
 * end
 * ```
 */
internal object Route120_EventScript_StevenBattleKecleon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route120_EventScript_StevenBattleKecleon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route120_Text_IllGetMoreBerriesFromBerryMaster, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route120_EventScript_ReceivedBerry : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route120.IllGetMoreBerriesFromBerryMaster)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_JEFFREY_1, Route120_Text_JeffreyRematchIntro, Route120_Text_JeffreyRematchDefeat
 * msgbox Route120_Text_JeffreyPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_RematchJeffrey : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route120_EventScript_RematchJeffrey")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_ROBERT_1, Route120_Text_RobertRematchIntro, Route120_Text_RobertRematchDefeat
 * msgbox Route120_Text_RobertPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route120_EventScript_RematchRobert : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route120_EventScript_RematchRobert")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route120_Text_YesYouUnderstand, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object Route120_EventScript_BerryLove : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route120.YesYouUnderstand)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route120_Text_StevenIllWaitHere, MSGBOX_DEFAULT
 * setflag FLAG_NOT_READY_FOR_BATTLE_ROUTE_120
 * release
 * end
 * ```
 */
internal object Route120_EventScript_StevenNotReady : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route120.StevenIllWaitHere)
    ctx.setFlag(HoennFlags.FLAG_NOT_READY_FOR_BATTLE_ROUTE_120)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreenswapbuffers FADE_TO_BLACK
 * removeobject LOCALID_BRIDGE_KECLEON
 * removeobject LOCALID_BRIDGE_KECLEON_SHADOW
 * fadescreenswapbuffers FADE_FROM_BLACK
 * goto Route120_EventScript_StevenGiveDeconScope
 * end
 * ```
 */
internal object Route120_EventScript_RemoveBridgeKecleonPostBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route120_EventScript_RemoveBridgeKecleonPostBattle")
}

/**
 * Ported from the decomp:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object Route120_EventScript_PlayerApproachKecleonNorth : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.moveSelf(FACE_LEFT)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Route120_Movement_ApproachKecleonWest
 * waitmovement 0
 * return
 * ```
 */
internal object Route120_EventScript_PlayerApproachKecleonWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route120_EventScript_PlayerApproachKecleonWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_ROUTE120_STEVEN, Common_Movement_WalkInPlaceFasterDown
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * msgbox Route120_Text_StevenGiveDevonScope, MSGBOX_DEFAULT
 * giveitem ITEM_DEVON_SCOPE
 * setflag FLAG_RECEIVED_DEVON_SCOPE
 * msgbox Route120_Text_StevenGoodbye, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_ROUTE120_STEVEN, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * delay 50
 * setfieldeffectargument 0, 1
 * dofieldeffect FLDEFF_NPCFLY_OUT
 * delay 15
 * removeobject LOCALID_ROUTE120_STEVEN
 * waitfieldeffect FLDEFF_NPCFLY_OUT
 * setmetatile 13, 15, METATILE_Fortree_WoodBridge1_Top, FALSE
 * setmetatile 12, 16, METATILE_Fortree_WoodBridge1_Bottom, FALSE
 * setmetatile 12, 17, METATILE_General_ReflectiveWater, FALSE
 * setmetatile 13, 17, METATILE_General_ReflectiveWater, FALSE
 * special DrawWholeMapView
 * release
 * end
 * ```
 */
internal object Route120_EventScript_StevenGiveDeconScope : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route120_EventScript_StevenGiveDeconScope")
}

internal val Route120Scripts: Map<String, Script> =
    mapOf(
        "Route120_EventScript_Colin" to Route120_EventScript_Colin,
        "Route120_EventScript_Robert" to Route120_EventScript_Robert,
        "Route120_EventScript_Lorenzo" to Route120_EventScript_Lorenzo,
        "Route120_EventScript_Jenna" to Route120_EventScript_Jenna,
        "Route120_EventScript_Jeffrey" to Route120_EventScript_Jeffrey,
        "Route120_EventScript_ItemNugget" to Route120_EventScript_ItemNugget,
        "GabbyAndTy_EventScript_TyBattle3" to GabbyAndTy_EventScript_TyBattle3,
        "GabbyAndTy_EventScript_GabbyBattle3" to GabbyAndTy_EventScript_GabbyBattle3,
        "Route120_EventScript_ItemFullHeal" to Route120_EventScript_ItemFullHeal,
        "Route120_EventScript_BerryBeauty" to Route120_EventScript_BerryBeauty,
        "Route120_EventScript_Jennifer" to Route120_EventScript_Jennifer,
        "Route120_EventScript_Chip" to Route120_EventScript_Chip,
        "Route120_EventScript_Clarissa" to Route120_EventScript_Clarissa,
        "Route120_EventScript_Angelica" to Route120_EventScript_Angelica,
        "Route120_EventScript_ItemNestBall" to Route120_EventScript_ItemNestBall,
        "Route120_EventScript_ItemHyperPotion" to Route120_EventScript_ItemHyperPotion,
        "Route120_EventScript_BridgeKecleon" to Route120_EventScript_BridgeKecleon,
        "Route120_EventScript_Steven" to Route120_EventScript_Steven,
        "Route120_EventScript_Keigo" to Route120_EventScript_Keigo,
        "Route120_EventScript_Riley" to Route120_EventScript_Riley,
        "Route120_EventScript_Kecleon1" to Route120_EventScript_Kecleon1,
        "Route120_EventScript_Kecleon2" to Route120_EventScript_Kecleon2,
        "Route120_EventScript_Kecleon3" to Route120_EventScript_Kecleon3,
        "Route120_EventScript_Kecleon5" to Route120_EventScript_Kecleon5,
        "Route120_EventScript_Kecleon4" to Route120_EventScript_Kecleon4,
        "Route120_EventScript_Callie" to Route120_EventScript_Callie,
        "Route120_EventScript_Leonel" to Route120_EventScript_Leonel,
        "Route120_EventScript_ItemRevive" to Route120_EventScript_ItemRevive,
        "Route120_EventScript_RouteSignFortree" to Route120_EventScript_RouteSignFortree,
        "Route120_EventScript_RouteSign121" to Route120_EventScript_RouteSign121,
        "Route120_EventScript_BerryNotLove" to Route120_EventScript_BerryNotLove,
        "Route120_EventScript_StevenAskReadyForBattle" to
            Route120_EventScript_StevenAskReadyForBattle,
        "Route120_EventScript_StevenBattleKecleon" to Route120_EventScript_StevenBattleKecleon,
        "Route120_EventScript_ReceivedBerry" to Route120_EventScript_ReceivedBerry,
        "Route120_EventScript_RematchJeffrey" to Route120_EventScript_RematchJeffrey,
        "Route120_EventScript_RematchRobert" to Route120_EventScript_RematchRobert,
        "Route120_EventScript_BerryLove" to Route120_EventScript_BerryLove,
        "Route120_EventScript_StevenNotReady" to Route120_EventScript_StevenNotReady,
        "Route120_EventScript_RemoveBridgeKecleonPostBattle" to
            Route120_EventScript_RemoveBridgeKecleonPostBattle,
        "Route120_EventScript_PlayerApproachKecleonNorth" to
            Route120_EventScript_PlayerApproachKecleonNorth,
        "Route120_EventScript_PlayerApproachKecleonWest" to
            Route120_EventScript_PlayerApproachKecleonWest,
        "Route120_EventScript_StevenGiveDeconScope" to Route120_EventScript_StevenGiveDeconScope,
    )
