package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_OutsideWest
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object BattleFrontier_OutsideWest_EventScript_Boy1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.BestOutOfAllMyFriends)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_OutsideWest_Text_MayISeeYourTicket, MSGBOX_DEFAULT
 * checkitem ITEM_SS_TICKET
 * goto_if_eq VAR_RESULT, FALSE, BattleFrontier_OutsideWest_EventScript_NoSSTicket
 * message BattleFrontier_OutsideWest_Text_WhereWouldYouLikeToGo
 * waitmessage
 * goto BattleFrontier_OutsideWest_EventScript_ChooseFerryDestination
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_FerryAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_FerryAttendant")
}

internal object BattleFrontier_OutsideWest_EventScript_ExpertM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.WontLetGentlemenBeatMe)
}

internal object BattleFrontier_OutsideWest_EventScript_Man1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.OnlyToughTrainersBroughtHere)
}

internal object BattleFrontier_OutsideWest_EventScript_Woman1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.FinallyArrivedAtFrontier)
}

internal object BattleFrontier_OutsideWest_EventScript_FatMan1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.SquareFilledWithToughPeople)
}

internal object BattleFrontier_OutsideWest_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.YoureOffToChallengeDome)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * goto BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Maniac1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    return BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * goto BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Maniac2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    return BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk.run(ctx)
  }
}

internal object BattleFrontier_OutsideWest_EventScript_Man2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.NothingHereNotLongAgo)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message BattleFrontier_OutsideWest_Text_ScaredOfPikeBecauseSeviper
 * waitmessage
 * call_if_eq VAR_FACING, DIR_NORTH, BattleFrontier_OutsideWest_EventScript_GirlShudderNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, BattleFrontier_OutsideWest_EventScript_GirlShudderSouth
 * call_if_eq VAR_FACING, DIR_WEST, BattleFrontier_OutsideWest_EventScript_GirlShudderWest
 * call_if_eq VAR_FACING, DIR_EAST, BattleFrontier_OutsideWest_EventScript_GirlShudderEast
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_Girl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_OutsideWest_Text_LetsPlayRockPaperScissors, MSGBOX_DEFAULT
 * random 2
 * goto_if_eq VAR_RESULT, 1, BattleFrontier_OutsideWest_EventScript_WomanWonRockPaperScissors
 * goto BattleFrontier_OutsideWest_EventScript_WomanLostRockPaperScissors
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Woman2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_Woman2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * delay 20
 * call_if_eq VAR_FACING, DIR_NORTH, BattleFrontier_OutsideWest_EventScript_CamperFaceFactory
 * call_if_eq VAR_FACING, DIR_SOUTH, BattleFrontier_OutsideWest_EventScript_CamperAlreadyFacingFactory
 * call_if_eq VAR_FACING, DIR_WEST, BattleFrontier_OutsideWest_EventScript_CamperFaceFactory
 * call_if_eq VAR_FACING, DIR_EAST, BattleFrontier_OutsideWest_EventScript_CamperFaceFactory
 * msgbox BattleFrontier_OutsideWest_Text_WhosRaisingThoseRentalMons, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Camper : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_Camper")
}

internal object BattleFrontier_OutsideWest_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.KeepBattlingUntilIGetSymbol)
}

internal object BattleFrontier_OutsideWest_EventScript_Man3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.LongDreamedAboutBattleFrontier)
}

internal object BattleFrontier_OutsideWest_EventScript_Fisherman1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.ChooseFishingOverBattling)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message BattleFrontier_OutsideWest_Text_GotSeasickOnWayHere
 * waitmessage
 * applymovement LOCALID_FRONTIER_FISHERMAN_2, Common_Movement_FaceAwayPlayer
 * waitmovement 0
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Fisherman2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_Fisherman2")
}

internal object BattleFrontier_OutsideWest_EventScript_FatMan2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.MetOlderGirlAtPike)
}

internal object BattleFrontier_OutsideWest_EventScript_Woman3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.LastTimeOurEyesMet)
}

internal object BattleFrontier_OutsideWest_EventScript_Boy2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.DomeAceLookedBecauseOfMyCheering)
}

internal object BattleFrontier_OutsideWest_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BattleFrontier_OutsideWest.DomeAceIsMine)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_OutsideWest_Text_FansOverThereUsedToBeTrainers, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_FRONTIER_MAN_4, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_Man4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_OutsideWest.FansOverThereUsedToBeTrainers)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

internal object BattleFrontier_OutsideWest_EventScript_PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_OutsideWest.MonWithLongTailInFrontier)
}

internal object BattleFrontier_OutsideWest_EventScript_BattleDomeSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(BattleFrontier_OutsideWest.BattleDomeSign)
}

internal object BattleFrontier_OutsideWest_EventScript_BattlePikeSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(BattleFrontier_OutsideWest.BattlePikeSign)
}

internal object BattleFrontier_OutsideWest_EventScript_BattleFactorySign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(BattleFrontier_OutsideWest.BattleFactorySign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * script body not found
 * ```
 */
internal object Common_EventScript_ShowPokemartSign : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_ShowPokemartSign")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FRONTIER_CAMPER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_CamperFaceFactory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_CamperFaceFactory")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * return
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_CamperAlreadyFacingFactory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_CamperAlreadyFacingFactory")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FRONTIER_MANIAC_1, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * msgbox BattleFrontier_OutsideWest_Text_SureWeCanChallengeWithNoMons, MSGBOX_DEFAULT
 * applymovement LOCALID_FRONTIER_MANIAC_2, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * msgbox BattleFrontier_OutsideWest_Text_BigGuySaidIllLendYouMons, MSGBOX_DEFAULT
 * closemessage
 * delay 25
 * applymovement LOCALID_FRONTIER_MANIAC_1, Common_Movement_WalkInPlaceFasterUp
 * applymovement LOCALID_FRONTIER_MANIAC_2, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FRONTIER_GIRL, BattleFrontier_OutsideWest_Movement_GirlShudderWest
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_GirlShudderWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_GirlShudderWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FRONTIER_GIRL, BattleFrontier_OutsideWest_Movement_GirlShudderEast
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_GirlShudderEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_GirlShudderEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FRONTIER_GIRL, BattleFrontier_OutsideWest_Movement_GirlShudderNorth
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_GirlShudderNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_GirlShudderNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_FRONTIER_GIRL, BattleFrontier_OutsideWest_Movement_GirlShudderSouth
 * waitmovement 0
 * return
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_GirlShudderSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_GirlShudderSouth")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_OutsideWest_Text_WonIllTakePikeChallenge, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_WomanWonRockPaperScissors : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_OutsideWest.WonIllTakePikeChallenge)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_OutsideWest_Text_LostIllPutOffPikeChallenge, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_WomanLostRockPaperScissors : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_OutsideWest.LostIllPutOffPikeChallenge)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_OutsideWest_Text_MustHaveTicketToBoard, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_NoSSTicket : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_OutsideWest.MustHaveTicketToBoard)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoicedefault 18, 6, MULTI_SSTIDAL_BATTLE_FRONTIER, 2, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_OutsideWest_EventScript_FerryToSlateport
 * case 1, BattleFrontier_OutsideWest_EventScript_FerryToLilycove
 * case 2, BattleFrontier_OutsideWest_EventScript_CancelFerrySelect
 * case MULTI_B_PRESSED, BattleFrontier_OutsideWest_EventScript_CancelFerrySelect
 * end
 * ```
 */
internal object BattleFrontier_OutsideWest_EventScript_ChooseFerryDestination : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_OutsideWest_EventScript_ChooseFerryDestination")
}

internal val BattleFrontier_OutsideWestScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_OutsideWest_EventScript_Boy1" to
            BattleFrontier_OutsideWest_EventScript_Boy1,
        "BattleFrontier_OutsideWest_EventScript_FerryAttendant" to
            BattleFrontier_OutsideWest_EventScript_FerryAttendant,
        "BattleFrontier_OutsideWest_EventScript_ExpertM" to
            BattleFrontier_OutsideWest_EventScript_ExpertM,
        "BattleFrontier_OutsideWest_EventScript_Man1" to
            BattleFrontier_OutsideWest_EventScript_Man1,
        "BattleFrontier_OutsideWest_EventScript_Woman1" to
            BattleFrontier_OutsideWest_EventScript_Woman1,
        "BattleFrontier_OutsideWest_EventScript_FatMan1" to
            BattleFrontier_OutsideWest_EventScript_FatMan1,
        "BattleFrontier_OutsideWest_EventScript_Gentleman" to
            BattleFrontier_OutsideWest_EventScript_Gentleman,
        "BattleFrontier_OutsideWest_EventScript_Maniac1" to
            BattleFrontier_OutsideWest_EventScript_Maniac1,
        "BattleFrontier_OutsideWest_EventScript_Maniac2" to
            BattleFrontier_OutsideWest_EventScript_Maniac2,
        "BattleFrontier_OutsideWest_EventScript_Man2" to
            BattleFrontier_OutsideWest_EventScript_Man2,
        "BattleFrontier_OutsideWest_EventScript_Girl" to
            BattleFrontier_OutsideWest_EventScript_Girl,
        "BattleFrontier_OutsideWest_EventScript_Woman2" to
            BattleFrontier_OutsideWest_EventScript_Woman2,
        "BattleFrontier_OutsideWest_EventScript_Camper" to
            BattleFrontier_OutsideWest_EventScript_Camper,
        "BattleFrontier_OutsideWest_EventScript_Lass" to
            BattleFrontier_OutsideWest_EventScript_Lass,
        "BattleFrontier_OutsideWest_EventScript_Man3" to
            BattleFrontier_OutsideWest_EventScript_Man3,
        "BattleFrontier_OutsideWest_EventScript_Fisherman1" to
            BattleFrontier_OutsideWest_EventScript_Fisherman1,
        "BattleFrontier_OutsideWest_EventScript_Fisherman2" to
            BattleFrontier_OutsideWest_EventScript_Fisherman2,
        "BattleFrontier_OutsideWest_EventScript_FatMan2" to
            BattleFrontier_OutsideWest_EventScript_FatMan2,
        "BattleFrontier_OutsideWest_EventScript_Woman3" to
            BattleFrontier_OutsideWest_EventScript_Woman3,
        "BattleFrontier_OutsideWest_EventScript_Boy2" to
            BattleFrontier_OutsideWest_EventScript_Boy2,
        "BattleFrontier_OutsideWest_EventScript_OldMan" to
            BattleFrontier_OutsideWest_EventScript_OldMan,
        "BattleFrontier_OutsideWest_EventScript_Man4" to
            BattleFrontier_OutsideWest_EventScript_Man4,
        "BattleFrontier_OutsideWest_EventScript_PokefanF" to
            BattleFrontier_OutsideWest_EventScript_PokefanF,
        "BattleFrontier_OutsideWest_EventScript_BattleDomeSign" to
            BattleFrontier_OutsideWest_EventScript_BattleDomeSign,
        "BattleFrontier_OutsideWest_EventScript_BattlePikeSign" to
            BattleFrontier_OutsideWest_EventScript_BattlePikeSign,
        "BattleFrontier_OutsideWest_EventScript_BattleFactorySign" to
            BattleFrontier_OutsideWest_EventScript_BattleFactorySign,
        "Common_EventScript_ShowPokemartSign" to Common_EventScript_ShowPokemartSign,
        "BattleFrontier_OutsideWest_EventScript_CamperFaceFactory" to
            BattleFrontier_OutsideWest_EventScript_CamperFaceFactory,
        "BattleFrontier_OutsideWest_EventScript_CamperAlreadyFacingFactory" to
            BattleFrontier_OutsideWest_EventScript_CamperAlreadyFacingFactory,
        "BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk" to
            BattleFrontier_OutsideWest_EventScript_FactoryChallengersTalk,
        "BattleFrontier_OutsideWest_EventScript_GirlShudderWest" to
            BattleFrontier_OutsideWest_EventScript_GirlShudderWest,
        "BattleFrontier_OutsideWest_EventScript_GirlShudderEast" to
            BattleFrontier_OutsideWest_EventScript_GirlShudderEast,
        "BattleFrontier_OutsideWest_EventScript_GirlShudderNorth" to
            BattleFrontier_OutsideWest_EventScript_GirlShudderNorth,
        "BattleFrontier_OutsideWest_EventScript_GirlShudderSouth" to
            BattleFrontier_OutsideWest_EventScript_GirlShudderSouth,
        "BattleFrontier_OutsideWest_EventScript_WomanWonRockPaperScissors" to
            BattleFrontier_OutsideWest_EventScript_WomanWonRockPaperScissors,
        "BattleFrontier_OutsideWest_EventScript_WomanLostRockPaperScissors" to
            BattleFrontier_OutsideWest_EventScript_WomanLostRockPaperScissors,
        "BattleFrontier_OutsideWest_EventScript_NoSSTicket" to
            BattleFrontier_OutsideWest_EventScript_NoSSTicket,
        "BattleFrontier_OutsideWest_EventScript_ChooseFerryDestination" to
            BattleFrontier_OutsideWest_EventScript_ChooseFerryDestination,
    )
