package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FiveIsland_ResortGorgeous_House
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * goto_if_set SHOWN_REQUESTED_MON, FiveIsland_ResortGorgeous_House_EventScript_JustFulfilledRequest
 * goto_if_eq VAR_RESORT_GORGEOUS_REQUESTED_MON, 0xFFFF, FiveIsland_ResortGorgeous_House_EventScript_RequestTookTooLong
 * goto_if_ne VAR_RESORT_GORGEOUS_REQUESTED_MON, SPECIES_NONE, FiveIsland_ResortGorgeous_House_EventScript_CheckForRequestedMon
 * msgbox FiveIsland_ResortGorgeous_House_Text_PleaseHearMyWish
 * goto FiveIsland_ResortGorgeous_House_EventScript_RequestMon
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_Selphy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_Selphy")
}

internal object FiveIsland_ResortGorgeous_House_EventScript_Butler : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(FiveIsland_ResortGorgeous_House.LadySelphySmileHasBrillianceOfSun)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_BLAINE, 5
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PokemonJournal_Text_SpecialFeatureBlaine
 * releaseall
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_PokemonJournal : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_PokemonJournal")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special SampleResortGorgeousMonAndReward
 * msgbox FiveIsland_ResortGorgeous_House_Text_WishToSeeMonPlease
 * release
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_RequestMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_RequestMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FiveIsland_ResortGorgeous_House_Text_SelphyWishYouBestOfLuck
 * release
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_JustFulfilledRequest : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FiveIsland_ResortGorgeous_House.SelphyWishYouBestOfLuck)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_0x8004, VAR_RESORT_GORGEOUS_REQUESTED_MON
 * specialvar VAR_RESULT, DoesPlayerPartyContainSpecies
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_ResortGorgeous_House_EventScript_ShowRequestedMon
 * goto FiveIsland_ResortGorgeous_House_EventScript_RequestMon
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_CheckForRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_CheckForRequestedMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FiveIsland_ResortGorgeous_House_Text_OhImTiredOfWaiting
 * goto FiveIsland_ResortGorgeous_House_EventScript_RequestMon
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_RequestTookTooLong : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FiveIsland_ResortGorgeous_House.OhImTiredOfWaiting)
    return FiveIsland_ResortGorgeous_House_EventScript_RequestMon.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special SampleResortGorgeousMonAndReward
 * msgbox FiveIsland_ResortGorgeous_House_Text_MonYouCaughtForMeThankYou
 * addobject LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER, FiveIsland_ResortGorgeous_House_Movement_ButlerEnter
 * waitmovement 0
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox FiveIsland_ResortGorgeous_House_Text_ButlerYesMyLady
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_SELPHY, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * textcolor NPC_TEXT_COLOR_FEMALE
 * msgbox FiveIsland_ResortGorgeous_House_Text_SelphyGiveTokenOfAppreciation
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox FiveIsland_ResortGorgeous_House_Text_ButlerIShallDoAsYouBid
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerSouth
 * call_if_eq VAR_FACING, DIR_EAST, FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerEast
 * call_if_eq VAR_FACING, DIR_WEST, FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerWest
 * copyobjectxytoperm LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER
 * msgbox FiveIsland_ResortGorgeous_House_Text_ButlerPleaseAcceptThisAsHerThanks
 * giveitem VAR_RESORT_GORGEOUS_REWARD
 * goto_if_eq VAR_RESULT, FALSE, FiveIsland_ResortGorgeous_House_EventScript_NoRoomForReward
 * setflag SHOWN_REQUESTED_MON
 * setvar VAR_RESORT_GORGEOUS_REQUESTED_MON, SPECIES_NONE
 * release
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_ShowRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_ShowRequestedMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_SELPHY, Common_Movement_WalkInPlaceFasterLeft
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER, FiveIsland_ResortGorgeous_House_Movement_ButlerApproachPlayerEast
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox FiveIsland_ResortGorgeous_House_Text_ButlerBagAppearsToBeFull
 * textcolor NPC_TEXT_COLOR_FEMALE
 * msgbox FiveIsland_ResortGorgeous_House_Text_OhHowDisappointing
 * setflag SHOWN_REQUESTED_MON
 * setvar VAR_RESORT_GORGEOUS_REQUESTED_MON, SPECIES_NONE
 * release
 * end
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_NoRoomForReward : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_NoRoomForReward")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_SELPHY, Common_Movement_WalkInPlaceFasterDown
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER, FiveIsland_ResortGorgeous_House_Movement_ButlerApproachPlayerNorth
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER, FiveIsland_ResortGorgeous_House_Movement_ButlerApproachPlayerSouth
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerSouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RESORT_GORGEOUS_HOUSE_BUTLER, FiveIsland_ResortGorgeous_House_Movement_ButlerApproachPlayerWest
 * waitmovement 0
 * return
 * ```
 */
internal object FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerWest")
}

internal val FiveIsland_ResortGorgeous_HouseScripts: Map<String, Script> =
    mapOf(
        "FiveIsland_ResortGorgeous_House_EventScript_Selphy" to
            FiveIsland_ResortGorgeous_House_EventScript_Selphy,
        "FiveIsland_ResortGorgeous_House_EventScript_Butler" to
            FiveIsland_ResortGorgeous_House_EventScript_Butler,
        "FiveIsland_ResortGorgeous_House_EventScript_PokemonJournal" to
            FiveIsland_ResortGorgeous_House_EventScript_PokemonJournal,
        "FiveIsland_ResortGorgeous_House_EventScript_RequestMon" to
            FiveIsland_ResortGorgeous_House_EventScript_RequestMon,
        "FiveIsland_ResortGorgeous_House_EventScript_JustFulfilledRequest" to
            FiveIsland_ResortGorgeous_House_EventScript_JustFulfilledRequest,
        "FiveIsland_ResortGorgeous_House_EventScript_CheckForRequestedMon" to
            FiveIsland_ResortGorgeous_House_EventScript_CheckForRequestedMon,
        "FiveIsland_ResortGorgeous_House_EventScript_RequestTookTooLong" to
            FiveIsland_ResortGorgeous_House_EventScript_RequestTookTooLong,
        "FiveIsland_ResortGorgeous_House_EventScript_ShowRequestedMon" to
            FiveIsland_ResortGorgeous_House_EventScript_ShowRequestedMon,
        "FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerEast" to
            FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerEast,
        "FiveIsland_ResortGorgeous_House_EventScript_NoRoomForReward" to
            FiveIsland_ResortGorgeous_House_EventScript_NoRoomForReward,
        "FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerNorth" to
            FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerNorth,
        "FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerSouth" to
            FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerSouth,
        "FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerWest" to
            FiveIsland_ResortGorgeous_House_EventScript_ButlerApproachPlayerWest,
    )
