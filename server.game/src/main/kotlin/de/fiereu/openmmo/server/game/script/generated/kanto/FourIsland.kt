package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FourIsland
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * special GetDaycareMonNicknames
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_EGG_WAITING, FourIsland_EventScript_DaycareEggWaiting
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, FourIsland_EventScript_CheckOnOneMon
 * goto_if_eq VAR_RESULT, DAYCARE_TWO_MONS, FourIsland_EventScript_CheckOnTwoMons
 * msgbox DayCare_Text_ImDaycareManSpeakToMyWife
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_DaycareMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_EventScript_DaycareMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_SYS_CAN_LINK_WITH_RS, FourIsland_EventScript_OldWomanLoreleiLeft
 * msgbox FourIsland_Text_LoreleiHasReturned
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_OldWoman : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_EventScript_OldWoman")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_STAR_PIECE
 * end
 * ```
 */
internal object FourIsland_EventScript_ItemStarPiece : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.STAR_PIECE, KantoFlags.FLAG_HIDE_FOUR_ISLAND_STAR_PIECE, 7)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_STARDUST
 * end
 * ```
 */
internal object FourIsland_EventScript_ItemStardust : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.STARDUST, KantoFlags.FLAG_HIDE_FOUR_ISLAND_STARDUST, 8)
  }
}

internal object FourIsland_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FourIsland.MadeSlushieUsingIcefallCaveIce)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_LORELEI, 4
 * msgbox FourIsland_Text_LoreleiHasLotsOfStuffedDolls
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_EventScript_LittleGirl")
}

internal object FourIsland_EventScript_IslandSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FourIsland.IslandSign)
}

internal object FourIsland_EventScript_LoreleisHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FourIsland.LoreleisHouse)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_LORELEI, 5
 * msgbox FourIsland_Text_LoreleiMetLaprasAsChild
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_OldWomanLoreleiLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_EventScript_OldWomanLoreleiLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetDaycareMonNicknames
 * msgbox DayCare_Text_YourMonIsDoingFine
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_CheckOnOneMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_EventScript_CheckOnOneMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox DayCare_Text_DoYouWantEgg, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_EventScript_DaycareAcceptEgg
 * msgbox DayCare_Text_IWillKeepDoYouWantIt, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FourIsland_EventScript_DaycareAcceptEgg
 * msgbox DayCare_Text_IllKeepIt
 * clearflag FLAG_PENDING_DAYCARE_EGG
 * special RejectEggFromDayCare
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_DaycareEggWaiting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_EventScript_DaycareEggWaiting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetDaycareMonNicknames
 * msgbox DayCare_Text_YourMonsAreDoingFine
 * special SetDaycareCompatibilityString
 * special ShowFieldMessageStringVar4
 * waitmessage
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_CheckOnTwoMons : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FourIsland_EventScript_CheckOnTwoMons")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CalculatePlayerPartyCount
 * goto_if_ne VAR_RESULT, PARTY_SIZE, FourIsland_EventScript_DaycareReceivedEgg
 * msgbox DayCare_Text_YouHaveNoRoomForIt
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_DaycareAcceptEgg : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_EventScript_DaycareAcceptEgg")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * message DayCare_Text_ReceivedEgg
 * call EventScript_RestorePrevTextColor
 * playfanfare MUS_LEVEL_UP
 * waitfanfare
 * waitbuttonpress
 * msgbox DayCare_Text_TakeGoodCareOfIt
 * special GiveEggFromDaycare
 * clearflag FLAG_PENDING_DAYCARE_EGG
 * release
 * end
 * ```
 */
internal object FourIsland_EventScript_DaycareReceivedEgg : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_EventScript_DaycareReceivedEgg")
}

internal val FourIslandScripts: Map<String, Script> =
    mapOf(
        "FourIsland_EventScript_DaycareMan" to FourIsland_EventScript_DaycareMan,
        "FourIsland_EventScript_OldWoman" to FourIsland_EventScript_OldWoman,
        "FourIsland_EventScript_ItemStarPiece" to FourIsland_EventScript_ItemStarPiece,
        "FourIsland_EventScript_ItemStardust" to FourIsland_EventScript_ItemStardust,
        "FourIsland_EventScript_FatMan" to FourIsland_EventScript_FatMan,
        "FourIsland_EventScript_LittleGirl" to FourIsland_EventScript_LittleGirl,
        "FourIsland_EventScript_IslandSign" to FourIsland_EventScript_IslandSign,
        "FourIsland_EventScript_LoreleisHouseSign" to FourIsland_EventScript_LoreleisHouseSign,
        "FourIsland_EventScript_OldWomanLoreleiLeft" to FourIsland_EventScript_OldWomanLoreleiLeft,
        "FourIsland_EventScript_CheckOnOneMon" to FourIsland_EventScript_CheckOnOneMon,
        "FourIsland_EventScript_DaycareEggWaiting" to FourIsland_EventScript_DaycareEggWaiting,
        "FourIsland_EventScript_CheckOnTwoMons" to FourIsland_EventScript_CheckOnTwoMons,
        "FourIsland_EventScript_DaycareAcceptEgg" to FourIsland_EventScript_DaycareAcceptEgg,
        "FourIsland_EventScript_DaycareReceivedEgg" to FourIsland_EventScript_DaycareReceivedEgg,
    )
