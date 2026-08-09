package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.TwoIsland_JoyfulGameCorner
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND_JOYFUL_GAME_CORNER, 4, JoyfulGameCorner_EventScript_MinigameAttendant
 * goto_if_set FLAG_GOT_MOON_STONE_FROM_JOYFUL_GAME_CORNER, TwoIsland_JoyfulGameCorner_EventScript_GetGameCornerRunning
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND_JOYFUL_GAME_CORNER, 3, TwoIsland_JoyfulGameCorner_EventScript_GiveDaddyMeteorite
 * msgbox TwoIsland_JoyfulGameCorner_Text_PleaseGoToThreeIsland
 * release
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_LostellesDaddy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_TWO_ISLAND_JOYFUL_GAME_CORNER) == 4)
        return JoyfulGameCorner_EventScript_MinigameAttendant.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_MOON_STONE_FROM_JOYFUL_GAME_CORNER))
        return TwoIsland_JoyfulGameCorner_EventScript_GetGameCornerRunning.run(ctx)
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_TWO_ISLAND_JOYFUL_GAME_CORNER) == 3)
        return TwoIsland_JoyfulGameCorner_EventScript_GiveDaddyMeteorite.run(ctx)
    ctx.say(TwoIsland_JoyfulGameCorner.PleaseGoToThreeIsland)
  }
}

internal object TwoIsland_JoyfulGameCorner_EventScript_Lostelle : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(TwoIsland_JoyfulGameCorner.PleaseShowMeYouBeingCool)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND_JOYFUL_GAME_CORNER, 4, JoyfulGameCorner_EventScript_InfoMan2
 * goto_if_set FLAG_RESCUED_LOSTELLE, TwoIsland_JoyfulGameCorner_EventScript_GetGamesGoingSoon
 * msgbox TwoIsland_JoyfulGameCorner_Text_NotRunningAnyGamesToday
 * release
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_InfoMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_TWO_ISLAND_JOYFUL_GAME_CORNER) == 4)
        return JoyfulGameCorner_EventScript_InfoMan2.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_RESCUED_LOSTELLE))
        return TwoIsland_JoyfulGameCorner_EventScript_GetGamesGoingSoon.run(ctx)
    ctx.say(TwoIsland_JoyfulGameCorner.NotRunningAnyGamesToday)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * lockall
 * special ShowPokemonJumpRecords
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_ShowPokemonJumpRecords : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_JoyfulGameCorner_EventScript_ShowPokemonJumpRecords")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * lockall
 * special ShowDodrioBerryPickingRecords
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_ShowDodrioBerryPickingRecords : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_JoyfulGameCorner_EventScript_ShowDodrioBerryPickingRecords")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * message Text_WelcomeCanYouWait
 * waitmessage
 * specialvar VAR_RESULT, IsWirelessAdapterConnected
 * goto_if_eq VAR_RESULT, FALSE, CableClub_EventScript_AdapterNotConnectedMinigame
 * delay 60
 * special HelpSystem_Disable
 * message Text_PlayWhichGame
 * waitmessage
 * multichoice 0, 0, MULTICHOICE_POKEJUMP_DODRIO, FALSE
 * switch VAR_RESULT
 * case 0, CableClub_EventScript_PlayPokemonJump
 * case 1, CableClub_EventScript_PlayDodrioBerryPicking
 * case 2, CableClub_EventScript_AbortMinigame
 * case SCR_MENU_CANCEL, CableClub_EventScript_AbortMinigame
 * end
 * ```
 */
internal object JoyfulGameCorner_EventScript_MinigameAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port JoyfulGameCorner_EventScript_MinigameAttendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * message Text_DescribeWhichGame
 * waitmessage
 * multichoice 0, 0, MULTICHOICE_POKEJUMP_DODRIO, FALSE
 * switch VAR_RESULT
 * case 0, CableClub_EventScript_PokemonJumpInfo
 * case 1, CableClub_EventScript_DodrioBerryPickingInfo
 * case 2, CableClub_EventScript_MinigameInfoExit
 * case SCR_MENU_CANCEL, CableClub_EventScript_MinigameInfoExit
 * end
 * ```
 */
internal object JoyfulGameCorner_EventScript_InfoMan2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port JoyfulGameCorner_EventScript_InfoMan2")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox TwoIsland_JoyfulGameCorner_Text_GetGamesGoingSoon
 * release
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_GetGamesGoingSoon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TwoIsland_JoyfulGameCorner.GetGamesGoingSoon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox TwoIsland_JoyfulGameCorner_Text_IllGetGameCornerRunning
 * release
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_GetGameCornerRunning : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TwoIsland_JoyfulGameCorner.IllGetGameCornerRunning)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_NO_ROOM_FOR_JOYFUL_GAME_CORNER_MOON_STONE, TwoIsland_JoyfulGameCorner_EventScript_ReceiveMoonStone
 * msgbox TwoIsland_JoyfulGameCorner_Text_ThisIsForMe
 * setvar VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 2
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_TMHM
 * message TwoIsland_JoyfulGameCorner_Text_HandedMeteoriteToLostellesDaddy
 * waitmessage
 * waitfanfare
 * call EventScript_RestorePrevTextColor
 * removeitem ITEM_METEORITE
 * msgbox TwoIsland_JoyfulGameCorner_Text_OhThisIsFromBill
 * goto TwoIsland_JoyfulGameCorner_EventScript_ReceiveMoonStone
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_GiveDaddyMeteorite : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_JoyfulGameCorner_EventScript_GiveDaddyMeteorite")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitemspace ITEM_MOON_STONE
 * goto_if_eq VAR_RESULT, FALSE, TwoIsland_JoyfulGameCorner_EventScript_NoRoomForMoonStone
 * additem ITEM_MOON_STONE
 * setflag FLAG_GOT_MOON_STONE_FROM_JOYFUL_GAME_CORNER
 * msgreceiveditem TwoIsland_JoyfulGameCorner_Text_ReceivedMoonStoneFromLostellesDaddy, ITEM_MOON_STONE
 * release
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_ReceiveMoonStone : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_JoyfulGameCorner_EventScript_ReceiveMoonStone")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_AdapterNotConnectedMinigame
 * release
 * end
 * ```
 */
internal object CableClub_EventScript_AdapterNotConnectedMinigame : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CableClub_EventScript_AdapterNotConnectedMinigame")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_NO_ROOM_FOR_JOYFUL_GAME_CORNER_MOON_STONE
 * msgbox TwoIsland_JoyfulGameCorner_Text_NotGoingToFitInBag
 * release
 * end
 * ```
 */
internal object TwoIsland_JoyfulGameCorner_EventScript_NoRoomForMoonStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_NO_ROOM_FOR_JOYFUL_GAME_CORNER_MOON_STONE)
    ctx.say(TwoIsland_JoyfulGameCorner.NotGoingToFitInBag)
  }
}

internal val TwoIsland_JoyfulGameCornerScripts: Map<String, Script> =
    mapOf(
        "TwoIsland_JoyfulGameCorner_EventScript_LostellesDaddy" to
            TwoIsland_JoyfulGameCorner_EventScript_LostellesDaddy,
        "TwoIsland_JoyfulGameCorner_EventScript_Lostelle" to
            TwoIsland_JoyfulGameCorner_EventScript_Lostelle,
        "TwoIsland_JoyfulGameCorner_EventScript_InfoMan" to
            TwoIsland_JoyfulGameCorner_EventScript_InfoMan,
        "TwoIsland_JoyfulGameCorner_EventScript_ShowPokemonJumpRecords" to
            TwoIsland_JoyfulGameCorner_EventScript_ShowPokemonJumpRecords,
        "TwoIsland_JoyfulGameCorner_EventScript_ShowDodrioBerryPickingRecords" to
            TwoIsland_JoyfulGameCorner_EventScript_ShowDodrioBerryPickingRecords,
        "JoyfulGameCorner_EventScript_MinigameAttendant" to
            JoyfulGameCorner_EventScript_MinigameAttendant,
        "JoyfulGameCorner_EventScript_InfoMan2" to JoyfulGameCorner_EventScript_InfoMan2,
        "TwoIsland_JoyfulGameCorner_EventScript_GetGamesGoingSoon" to
            TwoIsland_JoyfulGameCorner_EventScript_GetGamesGoingSoon,
        "TwoIsland_JoyfulGameCorner_EventScript_GetGameCornerRunning" to
            TwoIsland_JoyfulGameCorner_EventScript_GetGameCornerRunning,
        "TwoIsland_JoyfulGameCorner_EventScript_GiveDaddyMeteorite" to
            TwoIsland_JoyfulGameCorner_EventScript_GiveDaddyMeteorite,
        "TwoIsland_JoyfulGameCorner_EventScript_ReceiveMoonStone" to
            TwoIsland_JoyfulGameCorner_EventScript_ReceiveMoonStone,
        "CableClub_EventScript_AdapterNotConnectedMinigame" to
            CableClub_EventScript_AdapterNotConnectedMinigame,
        "TwoIsland_JoyfulGameCorner_EventScript_NoRoomForMoonStone" to
            TwoIsland_JoyfulGameCorner_EventScript_NoRoomForMoonStone,
    )
