package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FourIsland_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * specialvar VAR_0x8008, StickerManGetBragFlags
 * goto_if_unset FLAG_MET_STICKER_MAN, FourIsland_House2_EventScript_MeetStickerMan
 * goto_if_set FLAG_MET_STICKER_MAN, FourIsland_House2_EventScript_StickerManAskForBrag
 * end
 * ```
 */
internal object FourIsland_House2_EventScript_StickerMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_House2_EventScript_StickerMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_MET_STICKER_MAN
 * msgbox FourIsland_House2_Text_WishICouldShowOffStickers
 * applymovement LOCALID_STICKER_MAN, Common_Movement_FacePlayer
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_STICKER_MAN, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_STICKER_MAN, Common_Movement_Delay48
 * waitmovement 0
 * goto_if_eq VAR_0x8008, 0, FourIsland_House2_EventScript_StickerManNothingToBrag
 * message FourIsland_House2_Text_GiveYouStickerIfYouBrag
 * waitmessage
 * goto FourIsland_House2_EventScript_ChooseBrag
 * end
 * ```
 */
internal object FourIsland_House2_EventScript_MeetStickerMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_House2_EventScript_MeetStickerMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_STICKER_MAN, Common_Movement_FacePlayer
 * waitmovement 0
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * goto_if_eq VAR_0x8008, 0, FourIsland_House2_EventScript_NothingToBragAbout
 * message FourIsland_House2_Text_BragAboutWhatToday
 * waitmessage
 * goto FourIsland_House2_EventScript_ChooseBrag
 * end
 * ```
 */
internal object FourIsland_House2_EventScript_StickerManAskForBrag : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_House2_EventScript_StickerManAskForBrag")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FourIsland_House2_Text_BragAboutSomethingForMe
 * release
 * end
 * ```
 */
internal object FourIsland_House2_EventScript_NothingToBragAbout : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FourIsland_House2.BragAboutSomethingForMe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * switch VAR_0x8008
 * case 1, FourIsland_House2_EventScript_ChooseBragHoF
 * case 2, FourIsland_House2_EventScript_ChooseBragEggs
 * case 4, FourIsland_House2_EventScript_ChooseBragLinkWins
 * case 3, FourIsland_House2_EventScript_ChooseBragHoFEggs
 * case 5, FourIsland_House2_EventScript_ChooseBragHoFLinkWins
 * case 6, FourIsland_House2_EventScript_ChooseBragEggsLinkWins
 * case 7, FourIsland_House2_EventScript_ChooseBragHofEggsLinkWins
 * end
 * ```
 */
internal object FourIsland_House2_EventScript_ChooseBrag : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FourIsland_House2_EventScript_ChooseBrag")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FourIsland_House2_Text_GiveYouStickerIfYouBrag
 * release
 * end
 * ```
 */
internal object FourIsland_House2_EventScript_StickerManNothingToBrag : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FourIsland_House2.GiveYouStickerIfYouBrag)
  }
}

internal val FourIsland_House2Scripts: Map<String, Script> =
    mapOf(
        "FourIsland_House2_EventScript_StickerMan" to FourIsland_House2_EventScript_StickerMan,
        "FourIsland_House2_EventScript_MeetStickerMan" to
            FourIsland_House2_EventScript_MeetStickerMan,
        "FourIsland_House2_EventScript_StickerManAskForBrag" to
            FourIsland_House2_EventScript_StickerManAskForBrag,
        "FourIsland_House2_EventScript_NothingToBragAbout" to
            FourIsland_House2_EventScript_NothingToBragAbout,
        "FourIsland_House2_EventScript_ChooseBrag" to FourIsland_House2_EventScript_ChooseBrag,
        "FourIsland_House2_EventScript_StickerManNothingToBrag" to
            FourIsland_House2_EventScript_StickerManNothingToBrag,
    )
