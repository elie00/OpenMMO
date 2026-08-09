package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_House_Room1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * special ValidateEReaderTrainer
 * call_if_eq VAR_RESULT, 1, SevenIsland_House_Room1_EventScript_InvalidVisitingTrainer
 * goto_if_eq TRAINER_VISITING, TRUE, SevenIsland_House_Room1_EventScript_TrainerVisiting
 * msgbox SevenIsland_House_Room1_Text_OnlyEnjoymentWatchingBattles
 * release
 * end
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_OldWoman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_OldWoman")
}

internal object SevenIsland_House_Room1_EventScript_Box : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SevenIsland_House_Room1.SlightBreezeAroundBox)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special SavePlayerParty
 * special BufferEReaderTrainerName
 * msgbox SevenIsland_House_Room1_Text_ChallengeVisitingTrainer, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SevenIsland_House_Room1_EventScript_DeclineBattle
 * call SevenIsland_House_Room1_EventScript_ChooseParty
 * goto_if_eq VAR_RESULT, 0, SevenIsland_House_Room1_EventScript_DeclineBattle
 * msgbox SevenIsland_House_Room1_Text_SaveProgressBeforeBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SevenIsland_House_Room1_EventScript_DeclineBattle
 * special LoadPlayerParty
 * call EventScript_AskSaveGame
 * goto_if_eq VAR_RESULT, 0, SevenIsland_House_Room1_EventScript_DeclineBattle
 * special SavePlayerParty
 * special ReducePlayerPartyToThree
 * msgbox SevenIsland_House_Room1_Text_DontHoldAnythingBack
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, SevenIsland_House_Room1_EventScript_EnterBattleRoomNorth
 * call_if_eq VAR_FACING, DIR_EAST, SevenIsland_House_Room1_EventScript_EnterBattleRoomEast
 * call_if_eq VAR_FACING, DIR_WEST, SevenIsland_House_Room1_EventScript_EnterBattleRoomWest
 * warp MAP_SEVEN_ISLAND_HOUSE_ROOM2, 3, 1
 * waitstate
 * release
 * end
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_TrainerVisiting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_TrainerVisiting")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SevenIsland_House_Room1_Text_OnlyEnjoymentWatchingBattles
 * release
 * end
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_InvalidVisitingTrainer : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SevenIsland_House_Room1.OnlyEnjoymentWatchingBattles)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SevenIsland_House_Room1_Text_LimitThreeMonsPerSide
 * fadescreen FADE_TO_BLACK
 * special ChooseHalfPartyForBattle
 * waitstate
 * return
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_ChooseParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_ChooseParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, SevenIsland_House_Room1_Movement_OldWomanMoveAsideLeft
 * applymovement LOCALID_PLAYER, SevenIsland_House_Room1_Movement_PlayerEnterBattleRoomNorth
 * waitmovement 0
 * return
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_EnterBattleRoomNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_EnterBattleRoomNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, SevenIsland_House_Room1_Movement_OldWomanMoveAsideLeft
 * applymovement LOCALID_PLAYER, SevenIsland_House_Room1_Movement_PlayerEnterBattleRoomWest
 * waitmovement 0
 * return
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_EnterBattleRoomWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_EnterBattleRoomWest")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special LoadPlayerParty
 * msgbox SevenIsland_House_Room1_Text_OhYouWontBattle
 * release
 * end
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special Field_AskSaveTheGame
 * waitstate
 * return
 * ```
 */
internal object EventScript_AskSaveGame : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_AskSaveGame")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, SevenIsland_House_Room1_Movement_OldWomanMoveAsideRight
 * applymovement LOCALID_PLAYER, SevenIsland_House_Room1_Movement_PlayerEnterBattleRoomEast
 * waitmovement 0
 * return
 * ```
 */
internal object SevenIsland_House_Room1_EventScript_EnterBattleRoomEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_House_Room1_EventScript_EnterBattleRoomEast")
}

internal val SevenIsland_House_Room1Scripts: Map<String, Script> =
    mapOf(
        "SevenIsland_House_Room1_EventScript_OldWoman" to
            SevenIsland_House_Room1_EventScript_OldWoman,
        "SevenIsland_House_Room1_EventScript_Box" to SevenIsland_House_Room1_EventScript_Box,
        "SevenIsland_House_Room1_EventScript_TrainerVisiting" to
            SevenIsland_House_Room1_EventScript_TrainerVisiting,
        "SevenIsland_House_Room1_EventScript_InvalidVisitingTrainer" to
            SevenIsland_House_Room1_EventScript_InvalidVisitingTrainer,
        "SevenIsland_House_Room1_EventScript_ChooseParty" to
            SevenIsland_House_Room1_EventScript_ChooseParty,
        "SevenIsland_House_Room1_EventScript_EnterBattleRoomNorth" to
            SevenIsland_House_Room1_EventScript_EnterBattleRoomNorth,
        "SevenIsland_House_Room1_EventScript_EnterBattleRoomWest" to
            SevenIsland_House_Room1_EventScript_EnterBattleRoomWest,
        "SevenIsland_House_Room1_EventScript_DeclineBattle" to
            SevenIsland_House_Room1_EventScript_DeclineBattle,
        "EventScript_AskSaveGame" to EventScript_AskSaveGame,
        "SevenIsland_House_Room1_EventScript_EnterBattleRoomEast" to
            SevenIsland_House_Room1_EventScript_EnterBattleRoomEast,
    )
