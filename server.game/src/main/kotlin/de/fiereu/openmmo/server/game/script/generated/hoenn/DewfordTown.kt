package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.DewfordTown
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object DewfordTown_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(DewfordTown.TinyIslandCommunity)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_DELIVERED_STEVEN_LETTER, DewfordTown_EventScript_ReturnToPetalburgPrompt
 * message DewfordTown_Text_WhereAreWeBound
 * waitmessage
 * multichoicedefault 21, 6, MULTI_BRINEY_ON_DEWFORD, 2, FALSE
 * switch VAR_RESULT
 * case 0, DewfordTown_EventScript_ChoosePetalburg
 * case 1, DewfordTown_EventScript_ChooseSlateport
 * case 2, DewfordTown_EventScript_CancelSailSelect
 * case MULTI_B_PRESSED, DewfordTown_EventScript_CancelSailSelect
 * end
 * ```
 */
internal object DewfordTown_EventScript_Briney : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_EventScript_Briney")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_OLD_ROD, DewfordTown_EventScript_HowsFishing
 * msgbox DewfordTown_Text_GettingItchToFish, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, DewfordTown_EventScript_GiveOldRod
 * goto_if_eq VAR_RESULT, NO, DewfordTown_EventScript_NotGettingItchToFish
 * end
 * ```
 */
internal object DewfordTown_EventScript_OldRodFisherman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_EventScript_OldRodFisherman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call Common_EventScript_BufferTrendyPhrase
 * msgbox DewfordTown_Text_XIsTheBiggestHappeningThingRight, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, DewfordTown_EventScript_ConfirmTrendyPhrase
 * goto_if_eq VAR_RESULT, NO, DewfordTown_EventScript_RejectTrendyPhrase
 * end
 * ```
 */
internal object DewfordTown_EventScript_TrendyPhraseBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_EventScript_TrendyPhraseBoy")
}

internal object DewfordTown_EventScript_TownSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(DewfordTown.TownSign)
}

internal object DewfordTown_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(DewfordTown.GymSign)
}

internal object DewfordTown_EventScript_HallSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(DewfordTown.HallSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DewfordTown_Text_SetSailBackToPetalburg, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, DewfordTown_EventScript_SailBackToPetalburg
 * msgbox DewfordTown_Text_GoDeliverIllBeWaiting, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_ReturnToPetalburgPrompt : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_EventScript_ReturnToPetalburgPrompt")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_YeahDefinitionOfInRightNow, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_ConfirmTrendyPhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.YeahDefinitionOfInRightNow)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message DewfordTown_Text_HowsYourFishing
 * waitmessage
 * multichoice 20, 8, MULTI_HOWS_FISHING, TRUE
 * goto_if_eq VAR_RESULT, 0, DewfordTown_EventScript_FishingExcellent
 * goto_if_eq VAR_RESULT, 1, DewfordTown_EventScript_FishingNotSoGood
 * end
 * ```
 */
internal object DewfordTown_EventScript_HowsFishing : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_EventScript_HowsFishing")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DewfordTown_Text_GiveYouOneOfMyRods, MSGBOX_DEFAULT
 * giveitem ITEM_OLD_ROD
 * setflag FLAG_RECEIVED_OLD_ROD
 * msgbox DewfordTown_Text_ThrowInFishingAdvice, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_GiveOldRod : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port DewfordTown_EventScript_GiveOldRod")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_ThatsTooBadThen, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_NotGettingItchToFish : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.ThatsTooBadThen)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DewfordTown_Text_TellMeWhatsNewAndIn, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_TRENDY_PHRASE
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, TRUE, DewfordTown_EventScript_GiveNewTrendyPhrase
 * goto_if_eq VAR_RESULT, FALSE, DewfordTown_EventScript_CancelNewTrendyPhrase
 * end
 * ```
 */
internal object DewfordTown_EventScript_RejectTrendyPhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_EventScript_RejectTrendyPhrase")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_GreatHaulInSomeBigOnes, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_FishingExcellent : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.GreatHaulInSomeBigOnes)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_FishingAdvice, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_FishingNotSoGood : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.FishingAdvice)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_HearOfAnyTrendsComeShareWithMe, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_CancelNewTrendyPhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.HearOfAnyTrendsComeShareWithMe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * incrementgamestat GAME_STAT_STARTED_TRENDS
 * goto_if_eq VAR_0x8004, FALSE, DewfordTown_EventScript_PhraseNotTrendyEnough
 * msgbox DewfordTown_Text_OfCourseIKnowAboutThat, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_GiveNewTrendyPhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_EventScript_GiveNewTrendyPhrase")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_PetalburgWereSettingSail2, MSGBOX_DEFAULT
 * closemessage
 * goto DewfordTown_EventScript_SailToPetalburg
 * end
 * ```
 */
internal object DewfordTown_EventScript_SailBackToPetalburg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.PetalburgWereSettingSail2)
    return DewfordTown_EventScript_SailToPetalburg.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox DewfordTown_Text_XHuhIThinkYIsCool, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_PhraseNotTrendyEnough : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(DewfordTown.XHuhIThinkYIsCool)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call EventScript_BackupMrBrineyLocation
 * setobjectsubpriority LOCALID_DEWFORD_BRINEY, MAP_DEWFORD_TOWN, 0
 * setobjectsubpriority LOCALID_PLAYER, MAP_DEWFORD_TOWN, 0
 * applymovement LOCALID_DEWFORD_BRINEY, DewfordTown_Movement_BrineyBoardBoat
 * waitmovement 0
 * removeobject LOCALID_DEWFORD_BRINEY
 * applymovement LOCALID_PLAYER, DewfordTown_Movement_PlayerBoardBoat
 * waitmovement 0
 * hideobjectat LOCALID_PLAYER, MAP_DEWFORD_TOWN
 * call Common_EventScript_PlayBrineysBoatMusic
 * applymovement LOCALID_DEWFORD_BOAT, DewfordTown_Movement_SailToPetalburg
 * applymovement LOCALID_PLAYER, DewfordTown_Movement_SailToPetalburg
 * waitmovement 0
 * showobjectat LOCALID_PLAYER, MAP_ROUTE104
 * call Common_EventScript_StopBrineysBoatMusic
 * applymovement LOCALID_PLAYER, DewfordTown_Movement_ExitBoatPetalburg
 * waitmovement 0
 * showobjectat LOCALID_PLAYER, MAP_ROUTE104
 * clearflag FLAG_HIDE_BRINEYS_HOUSE_MR_BRINEY
 * clearflag FLAG_HIDE_BRINEYS_HOUSE_PEEKO
 * clearflag FLAG_HIDE_ROUTE_104_MR_BRINEY_BOAT
 * setflag FLAG_HIDE_MR_BRINEY_BOAT_DEWFORD_TOWN
 * hideobjectat LOCALID_DEWFORD_BOAT, MAP_DEWFORD_TOWN
 * setvar VAR_BOARD_BRINEY_BOAT_STATE, 2
 * resetobjectsubpriority LOCALID_PLAYER, MAP_DEWFORD_TOWN
 * warp MAP_ROUTE104_MR_BRINEYS_HOUSE, 5, 4
 * copyvar VAR_BRINEY_LOCATION, VAR_0x8008
 * waitstate
 * release
 * end
 * ```
 */
internal object DewfordTown_EventScript_SailToPetalburg : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DewfordTown_EventScript_SailToPetalburg")
}

internal val DewfordTownScripts: Map<String, Script> =
    mapOf(
        "DewfordTown_EventScript_Woman" to DewfordTown_EventScript_Woman,
        "DewfordTown_EventScript_Briney" to DewfordTown_EventScript_Briney,
        "DewfordTown_EventScript_OldRodFisherman" to DewfordTown_EventScript_OldRodFisherman,
        "DewfordTown_EventScript_TrendyPhraseBoy" to DewfordTown_EventScript_TrendyPhraseBoy,
        "DewfordTown_EventScript_TownSign" to DewfordTown_EventScript_TownSign,
        "DewfordTown_EventScript_GymSign" to DewfordTown_EventScript_GymSign,
        "DewfordTown_EventScript_HallSign" to DewfordTown_EventScript_HallSign,
        "DewfordTown_EventScript_ReturnToPetalburgPrompt" to
            DewfordTown_EventScript_ReturnToPetalburgPrompt,
        "DewfordTown_EventScript_ConfirmTrendyPhrase" to
            DewfordTown_EventScript_ConfirmTrendyPhrase,
        "DewfordTown_EventScript_HowsFishing" to DewfordTown_EventScript_HowsFishing,
        "DewfordTown_EventScript_GiveOldRod" to DewfordTown_EventScript_GiveOldRod,
        "DewfordTown_EventScript_NotGettingItchToFish" to
            DewfordTown_EventScript_NotGettingItchToFish,
        "DewfordTown_EventScript_RejectTrendyPhrase" to DewfordTown_EventScript_RejectTrendyPhrase,
        "DewfordTown_EventScript_FishingExcellent" to DewfordTown_EventScript_FishingExcellent,
        "DewfordTown_EventScript_FishingNotSoGood" to DewfordTown_EventScript_FishingNotSoGood,
        "DewfordTown_EventScript_CancelNewTrendyPhrase" to
            DewfordTown_EventScript_CancelNewTrendyPhrase,
        "DewfordTown_EventScript_GiveNewTrendyPhrase" to
            DewfordTown_EventScript_GiveNewTrendyPhrase,
        "DewfordTown_EventScript_SailBackToPetalburg" to
            DewfordTown_EventScript_SailBackToPetalburg,
        "DewfordTown_EventScript_PhraseNotTrendyEnough" to
            DewfordTown_EventScript_PhraseNotTrendyEnough,
        "DewfordTown_EventScript_SailToPetalburg" to DewfordTown_EventScript_SailToPetalburg,
    )
