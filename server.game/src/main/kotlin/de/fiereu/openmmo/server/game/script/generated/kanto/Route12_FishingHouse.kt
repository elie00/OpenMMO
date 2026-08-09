package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route12_FishingHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_SUPER_ROD, Route12_FishingHouse_EventScript_CheckMagikarpRecord
 * msgbox Route12_FishingHouse_Text_DoYouLikeToFish, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route12_FishingHouse_EventScript_GiveSuperRod
 * msgbox Route12_FishingHouse_Text_OhThatsDisappointing
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_FishingGuruBrother : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_FishingGuruBrother")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_GOT_RECORD_SETTING_MAGIKARP, Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet
 * msgbox Route12_FishingHouse_Text_BlankChartOfSomeSort
 * releaseall
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_MagikarpRecordSign : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_RECORD_SETTING_MAGIKARP))
        return Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet.run(ctx)
    ctx.say(Route12_FishingHouse.BlankChartOfSomeSort)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetMagikarpSizeRecordInfo
 * msgbox Route12_FishingHouse_Text_MostGiganticMagikarpXInches
 * releaseall
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * setvar VAR_0x8004, SPECIES_MAGIKARP
 * specialvar VAR_RESULT, DoesPlayerPartyContainSpecies
 * goto_if_eq VAR_RESULT, FALSE, Route12_FishingHouse_EventScript_NoMagikarpInParty
 * special GetMagikarpSizeRecordInfo
 * msgbox Route12_FishingHouse_Text_OhMagikarpAllowMeToSee
 * special ChoosePartyMon
 * waitstate
 * copyvar VAR_RESULT, VAR_0x8004
 * goto_if_ge VAR_RESULT, PARTY_SIZE, Route12_FishingHouse_EventScript_CancelShowMon
 * special CompareMagikarpSize
 * goto_if_eq VAR_RESULT, 1, Route12_FishingHouse_EventScript_NotMagikarp
 * goto_if_eq VAR_RESULT, 2, Route12_FishingHouse_EventScript_NotRecordMagikarp
 * goto_if_eq VAR_RESULT, 3, Route12_FishingHouse_EventScript_NewRecordMagikarp
 * goto_if_eq VAR_RESULT, 4, Route12_FishingHouse_EventScript_TieRecordMagikarp
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_CheckMagikarpRecord : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_CheckMagikarpRecord")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitemspace ITEM_SUPER_ROD
 * goto_if_eq VAR_RESULT, FALSE, Route12_FishingHouse_EventScript_NoRoomForSuperRod
 * additem ITEM_SUPER_ROD
 * msgbox Route12_FishingHouse_Text_TakeThisAndFish
 * msgreceiveditem Route12_FishingHouse_Text_ReceivedSuperRod, ITEM_SUPER_ROD
 * setflag FLAG_GOT_SUPER_ROD
 * msgbox Route12_FishingHouse_Text_IfYouCatchBigMagikarpShowMe
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_GiveSuperRod : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_GiveSuperRod")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route12_FishingHouse_Text_NoRoomForGift
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_NoRoomForSuperRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route12_FishingHouse.NoRoomForGift)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_CancelShowMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_CancelShowMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route12_FishingHouse_Text_DoesntLookLikeMagikarp
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_NotMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route12_FishingHouse.DoesntLookLikeMagikarp)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_unset FLAG_GOT_RECORD_SETTING_MAGIKARP, Route12_FishingHouse_EventScript_NewRecordMagikarp
 * msgbox Route12_FishingHouse_Text_HmmXInchesDoesntMeasureUp
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_NotRecordMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_RECORD_SETTING_MAGIKARP))
        return Route12_FishingHouse_EventScript_NewRecordMagikarp.run(ctx)
    ctx.say(Route12_FishingHouse.HmmXInchesDoesntMeasureUp)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_unset FLAG_GOT_RECORD_SETTING_MAGIKARP, Route12_FishingHouse_EventScript_NewRecordMagikarp
 * msgbox Route12_FishingHouse_Text_HuhXInchesSameSizeAsLast
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_TieRecordMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_RECORD_SETTING_MAGIKARP))
        return Route12_FishingHouse_EventScript_NewRecordMagikarp.run(ctx)
    ctx.say(Route12_FishingHouse.HuhXInchesSameSizeAsLast)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_GOT_RECORD_SETTING_MAGIKARP
 * msgbox Route12_FishingHouse_Text_WhoaXInchesTakeThis
 * giveitem ITEM_NET_BALL
 * goto_if_eq VAR_RESULT, FALSE, Route12_FishingHouse_EventScript_NoRoomForNetBall
 * msgbox Route12_FishingHouse_Text_LookForwardToGreaterRecords
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_NewRecordMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_NewRecordMagikarp")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route12_FishingHouse_Text_TryFishingBringMeMagikarp
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_NoMagikarpInParty : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route12_FishingHouse.TryFishingBringMeMagikarp)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route12_FishingHouse_Text_NoRoomForGift
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_NoRoomForNetBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route12_FishingHouse.NoRoomForGift)
  }
}

internal val Route12_FishingHouseScripts: Map<String, Script> =
    mapOf(
        "Route12_FishingHouse_EventScript_FishingGuruBrother" to
            Route12_FishingHouse_EventScript_FishingGuruBrother,
        "Route12_FishingHouse_EventScript_MagikarpRecordSign" to
            Route12_FishingHouse_EventScript_MagikarpRecordSign,
        "Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet" to
            Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet,
        "Route12_FishingHouse_EventScript_CheckMagikarpRecord" to
            Route12_FishingHouse_EventScript_CheckMagikarpRecord,
        "Route12_FishingHouse_EventScript_GiveSuperRod" to
            Route12_FishingHouse_EventScript_GiveSuperRod,
        "Route12_FishingHouse_EventScript_NoRoomForSuperRod" to
            Route12_FishingHouse_EventScript_NoRoomForSuperRod,
        "Route12_FishingHouse_EventScript_CancelShowMon" to
            Route12_FishingHouse_EventScript_CancelShowMon,
        "Route12_FishingHouse_EventScript_NotMagikarp" to
            Route12_FishingHouse_EventScript_NotMagikarp,
        "Route12_FishingHouse_EventScript_NotRecordMagikarp" to
            Route12_FishingHouse_EventScript_NotRecordMagikarp,
        "Route12_FishingHouse_EventScript_TieRecordMagikarp" to
            Route12_FishingHouse_EventScript_TieRecordMagikarp,
        "Route12_FishingHouse_EventScript_NewRecordMagikarp" to
            Route12_FishingHouse_EventScript_NewRecordMagikarp,
        "Route12_FishingHouse_EventScript_NoMagikarpInParty" to
            Route12_FishingHouse_EventScript_NoMagikarpInParty,
        "Route12_FishingHouse_EventScript_NoRoomForNetBall" to
            Route12_FishingHouse_EventScript_NoRoomForNetBall,
    )
