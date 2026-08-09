package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_KEY_ITEM
 * message SixIsland_DottedHole_SapphireRoom_Text_FoundSapphire
 * waitmessage
 * waitfanfare
 * closemessage
 * setobjectxyperm LOCALID_DOTTED_HOLE_THIEF, 5, 0
 * addobject LOCALID_DOTTED_HOLE_THIEF
 * playse SE_FALL
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefFallIn
 * waitmovement 0
 * playse SE_M_STRENGTH
 * call_if_eq VAR_FACING, DIR_NORTH, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft
 * call_if_eq VAR_FACING, DIR_SOUTH, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft
 * call_if_eq VAR_FACING, DIR_EAST, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown
 * call_if_eq VAR_FACING, DIR_WEST, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown
 * setvar VAR_0x8004, 3
 * setvar VAR_0x8005, 0
 * setvar VAR_0x8006, 12
 * setvar VAR_0x8007, 3
 * special ShakeScreen
 * delay 60
 * call_if_eq VAR_FACING, DIR_NORTH, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireSouth
 * call_if_eq VAR_FACING, DIR_EAST, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireEast
 * call_if_eq VAR_FACING, DIR_WEST, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireWest
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox SixIsland_DottedHole_SapphireRoom_Text_IWasRightInTailingYou
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireSouth
 * call_if_eq VAR_FACING, DIR_EAST, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireEast
 * call_if_eq VAR_FACING, DIR_WEST, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireWest
 * removeobject LOCALID_SAPPHIRE
 * call_if_eq VAR_FACING, DIR_NORTH, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft2
 * call_if_eq VAR_FACING, DIR_SOUTH, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft2
 * call_if_eq VAR_FACING, DIR_EAST, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown2
 * call_if_eq VAR_FACING, DIR_WEST, SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown2
 * msgbox SixIsland_DottedHole_SapphireRoom_Text_SellToTeamRocketTellPassword
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitNorth
 * call_if_eq VAR_FACING, DIR_SOUTH, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitSouth
 * call_if_eq VAR_FACING, DIR_EAST, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitEast
 * call_if_eq VAR_FACING, DIR_WEST, SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitWest
 * playse SE_EXIT
 * delay 35
 * removeobject LOCALID_DOTTED_HOLE_THIEF
 * setflag FLAG_LEARNED_YES_NAH_CHANSEY
 * release
 * end
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_Sapphire : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_Sapphire")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8005, 130
 * braillemessage_wait Braille_Text_LetTheTwo
 * braillemessage_wait Braille_Text_Glittering
 * braillemessage_wait Braille_Text_Stones
 * braillemessage_wait Braille_Text_OneInRed
 * braillemessage_wait Braille_Text_OneInBlue
 * braillemessage_wait Braille_Text_ConnectThe
 * braillemessage_wait Braille_Text_Past
 * braillemessage_wait Braille_Text_TwoFriends
 * braillemessage_wait Braille_Text_Sharing
 * braillemessage_wait Braille_Text_PowerOpen
 * braillemessage_wait Braille_Text_AWindowTo
 * braillemessage_wait Braille_Text_ANewWorld
 * braillemessage_wait Braille_Text_ThatGlows
 * braillemessage_wait Braille_Text_TheNext
 * braillemessage_wait Braille_Text_WorldWaits
 * braillemessage Braille_Text_ForYou
 * waitbuttonpress
 * releaseall
 * end
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_BrailleMessage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_BrailleMessage")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefLookAtSapphireFromBelow
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefLookAtSapphireFromLeft
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, SixIsland_DottedHole_SapphireRoom_Movement_PlayerWatchThiefExit
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefExitEastWest
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefLookAtSapphireFromBelow
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, SixIsland_DottedHole_SapphireRoom_Movement_PlayerWatchThiefExit
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefExitSouth
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitSouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefGetSapphireFromLeft
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, SixIsland_DottedHole_SapphireRoom_Movement_PlayerWatchThiefExit
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefExitNorth
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, SixIsland_DottedHole_SapphireRoom_Movement_PlayerWatchThiefExit
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefExitEastWest
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefGetSapphireFromLeft
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireSouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefGetSapphireFromBelow
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefLookAtSapphireFromLeft
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireSouth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireSouth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_DOTTED_HOLE_THIEF, SixIsland_DottedHole_SapphireRoom_Movement_ThiefGetSapphireFromBelow
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * return
 * ```
 */
internal object SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireEast")
}

internal val SixIsland_DottedHole_SapphireRoomScripts: Map<String, Script> =
    mapOf(
        "SixIsland_DottedHole_SapphireRoom_EventScript_Sapphire" to
            SixIsland_DottedHole_SapphireRoom_EventScript_Sapphire,
        "SixIsland_DottedHole_SapphireRoom_EventScript_BrailleMessage" to
            SixIsland_DottedHole_SapphireRoom_EventScript_BrailleMessage,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireEast" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireEast,
        "SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown2" to
            SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown2,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireNorth" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireNorth,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitWest" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitWest,
        "SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown" to
            SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefDown,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireWest" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireWest,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitSouth" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitSouth,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireNorth" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireNorth,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitNorth" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitNorth,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitEast" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefExitEast,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireSouth" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireSouth,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireWest" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireWest,
        "SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft2" to
            SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft2,
        "SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft" to
            SixIsland_DottedHole_SapphireRoom_EventScript_PlayerFaceThiefLeft,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireSouth" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefLookAtSapphireSouth,
        "SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireEast" to
            SixIsland_DottedHole_SapphireRoom_EventScript_ThiefGetSapphireEast,
    )
