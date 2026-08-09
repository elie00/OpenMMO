package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_MysteryEventsHouse_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * frontier_checkvisittrainer
 * goto_if_eq VAR_RESULT, 1, SootopolisCity_MysteryEventsHouse_1F_EventScript_InvalidVisitingTrainer
 * goto_if_eq VAR_TEMP_1, 1, SootopolisCity_MysteryEventsHouse_1F_EventScript_TrainerVisiting
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_OnlyAmusementWatchingBattles, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_OldMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special SavePlayerParty
 * special BufferEReaderTrainerName
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_ChallengeVisitingTrainer, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle
 * call SootopolisCity_MysteryEventsHouse_1F_EventScript_ChooseParty
 * goto_if_eq VAR_RESULT, 0, SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_SaveProgressBeforeBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle
 * special LoadPlayerParty
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, FALSE, SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle
 * special SavePlayerParty
 * special ReducePlayerPartyToSelectedMons
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_HopeToSeeGoodMatch, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementNorth
 * call_if_eq VAR_FACING, DIR_EAST, SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementEast
 * call_if_eq VAR_FACING, DIR_WEST, SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementWest
 * warp MAP_SOOTOPOLIS_CITY_MYSTERY_EVENTS_HOUSE_B1F, 3, 1
 * waitstate
 * release
 * end
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_TrainerVisiting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_TrainerVisiting")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_OnlyAmusementWatchingBattles, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_InvalidVisitingTrainer : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_MysteryEventsHouse_1F.OnlyAmusementWatchingBattles)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_KeepItTo3On3, MSGBOX_DEFAULT
 * fadescreen FADE_TO_BLACK
 * special ChooseHalfPartyForBattle
 * return
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_ChooseParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_ChooseParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special LoadPlayerParty
 * msgbox SootopolisCity_MysteryEventsHouse_1F_Text_YouWontBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, SootopolisCity_MysteryEventsHouse_1F_Movement_OldManMoveAsideLeft
 * applymovement LOCALID_PLAYER, SootopolisCity_MysteryEventsHouse_1F_Movement_PlayerEnterBasementNorth
 * waitmovement 0
 * return
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, SootopolisCity_MysteryEventsHouse_1F_Movement_OldManMoveAsideRight
 * applymovement LOCALID_PLAYER, SootopolisCity_MysteryEventsHouse_1F_Movement_PlayerEnterBasementEast
 * waitmovement 0
 * return
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementEast : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, SootopolisCity_MysteryEventsHouse_1F_Movement_OldManMoveAsideLeft
 * applymovement LOCALID_PLAYER, SootopolisCity_MysteryEventsHouse_1F_Movement_PlayerEnterBasementWest
 * waitmovement 0
 * return
 * ```
 */
internal object SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementWest")
}

internal val SootopolisCity_MysteryEventsHouse_1FScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_OldMan" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_OldMan,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_TrainerVisiting" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_TrainerVisiting,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_InvalidVisitingTrainer" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_InvalidVisitingTrainer,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_ChooseParty" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_ChooseParty,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_DeclineBattle,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementNorth" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementNorth,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementEast" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementEast,
        "SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementWest" to
            SootopolisCity_MysteryEventsHouse_1F_EventScript_EnterBasementWest,
    )
