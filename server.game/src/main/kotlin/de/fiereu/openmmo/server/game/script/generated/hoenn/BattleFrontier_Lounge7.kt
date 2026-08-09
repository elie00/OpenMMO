package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_Lounge7
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object BattleFrontier_Lounge7_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge7.ThinkLadiesDontGetAlong)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_C, SCROLL_MULTI_BF_MOVE_TUTOR_1
 * goto_if_set FLAG_MET_FRONTIER_BEAUTY_MOVE_TUTOR, BattleFrontier_Lounge7_EventScript_AlreadyMetLeftTutor
 * msgbox BattleFrontier_Lounge7_Text_LeftTutorIntro, MSGBOX_DEFAULT
 * setflag FLAG_MET_FRONTIER_BEAUTY_MOVE_TUTOR
 * goto BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove
 * end
 * ```
 */
internal object BattleFrontier_Lounge7_EventScript_LeftMoveTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge7_EventScript_LeftMoveTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_C, SCROLL_MULTI_BF_MOVE_TUTOR_2
 * goto_if_set FLAG_MET_FRONTIER_SWIMMER_MOVE_TUTOR, BattleFrontier_Lounge7_EventScript_AlreadyMetRightTutor
 * msgbox BattleFrontier_Lounge7_Text_RightTutorIntro, MSGBOX_DEFAULT
 * setflag FLAG_MET_FRONTIER_SWIMMER_MOVE_TUTOR
 * goto BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove
 * end
 * ```
 */
internal object BattleFrontier_Lounge7_EventScript_RightMoveTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge7_EventScript_RightMoveTutor")
}

internal object BattleFrontier_Lounge7_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge7.LadiesWereStrongAndBeautiful)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge7_Text_LeftTutorWelcomeBack, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove
 * end
 * ```
 */
internal object BattleFrontier_Lounge7_EventScript_AlreadyMetLeftTutor : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge7.LeftTutorWelcomeBack)
    return BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_Lounge7_Text_TeachWhichMove
 * waitmessage
 * special ShowBattlePointsWindow
 * setvar VAR_TEMP_FRONTIER_TUTOR_ID, 0
 * setvar VAR_0x8004, SCROLL_MULTI_BF_MOVE_TUTOR_1
 * setvar VAR_0x8006, 0
 * special ShowScrollableMultichoice
 * copyvar VAR_TEMP_FRONTIER_TUTOR_SELECTION, VAR_RESULT
 * switch VAR_RESULT
 * case 0, BattleFrontier_Lounge7_EventScript_Softboiled
 * case 1, BattleFrontier_Lounge7_EventScript_SeismicToss
 * case 2, BattleFrontier_Lounge7_EventScript_DreamEater
 * case 3, BattleFrontier_Lounge7_EventScript_MegaPunch
 * case 4, BattleFrontier_Lounge7_EventScript_MegaKick
 * case 5, BattleFrontier_Lounge7_EventScript_BodySlam
 * case 6, BattleFrontier_Lounge7_EventScript_RockSlide
 * case 7, BattleFrontier_Lounge7_EventScript_Counter
 * case 8, BattleFrontier_Lounge7_EventScript_ThunderWave
 * case 9, BattleFrontier_Lounge7_EventScript_SwordsDance
 * case 10, BattleFrontier_Lounge7_EventScript_ExitTutorMoveSelect
 * case MULTI_B_PRESSED, BattleFrontier_Lounge7_EventScript_ExitTutorMoveSelect
 * end
 * ```
 */
internal object BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge7_Text_RightTutorWelcomeBack, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove
 * end
 * ```
 */
internal object BattleFrontier_Lounge7_EventScript_AlreadyMetRightTutor : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge7.RightTutorWelcomeBack)
    return BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_Lounge7_Text_TeachWhichMove
 * waitmessage
 * special ShowBattlePointsWindow
 * setvar VAR_TEMP_FRONTIER_TUTOR_ID, 1
 * setvar VAR_0x8004, SCROLL_MULTI_BF_MOVE_TUTOR_2
 * setvar VAR_0x8006, 0
 * special ShowScrollableMultichoice
 * copyvar VAR_TEMP_FRONTIER_TUTOR_SELECTION, VAR_RESULT
 * switch VAR_RESULT
 * case 0, BattleFrontier_Lounge7_EventScript_DefenseCurl
 * case 1, BattleFrontier_Lounge7_EventScript_Snore
 * case 2, BattleFrontier_Lounge7_EventScript_MudSlap
 * case 3, BattleFrontier_Lounge7_EventScript_Swift
 * case 4, BattleFrontier_Lounge7_EventScript_IcyWind
 * case 5, BattleFrontier_Lounge7_EventScript_Endure
 * case 6, BattleFrontier_Lounge7_EventScript_PsychUp
 * case 7, BattleFrontier_Lounge7_EventScript_IcePunch
 * case 8, BattleFrontier_Lounge7_EventScript_ThunderPunch
 * case 9, BattleFrontier_Lounge7_EventScript_FirePunch
 * case 10, BattleFrontier_Lounge7_EventScript_ExitTutorMoveSelect
 * case MULTI_B_PRESSED, BattleFrontier_Lounge7_EventScript_ExitTutorMoveSelect
 * end
 * ```
 */
internal object BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove")
}

internal val BattleFrontier_Lounge7Scripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_Lounge7_EventScript_Sailor" to BattleFrontier_Lounge7_EventScript_Sailor,
        "BattleFrontier_Lounge7_EventScript_LeftMoveTutor" to
            BattleFrontier_Lounge7_EventScript_LeftMoveTutor,
        "BattleFrontier_Lounge7_EventScript_RightMoveTutor" to
            BattleFrontier_Lounge7_EventScript_RightMoveTutor,
        "BattleFrontier_Lounge7_EventScript_Gentleman" to
            BattleFrontier_Lounge7_EventScript_Gentleman,
        "BattleFrontier_Lounge7_EventScript_AlreadyMetLeftTutor" to
            BattleFrontier_Lounge7_EventScript_AlreadyMetLeftTutor,
        "BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove" to
            BattleFrontier_Lounge7_EventScript_ChooseLeftTutorMove,
        "BattleFrontier_Lounge7_EventScript_AlreadyMetRightTutor" to
            BattleFrontier_Lounge7_EventScript_AlreadyMetRightTutor,
        "BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove" to
            BattleFrontier_Lounge7_EventScript_ChooseRightTutorMove,
    )
