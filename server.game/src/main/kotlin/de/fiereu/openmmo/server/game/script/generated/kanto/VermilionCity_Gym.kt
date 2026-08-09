package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity_Gym
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_LTSURGE, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * trainerbattle_single TRAINER_LEADER_LT_SURGE, VermilionCity_Gym_Text_LtSurgeIntro, VermilionCity_Gym_Text_LtSurgeDefeat, VermilionCity_Gym_EventScript_DefeatedLtSurge, NO_MUSIC
 * goto_if_unset FLAG_GOT_TM34_FROM_SURGE, VermilionCity_Gym_EventScript_GiveTM34
 * msgbox VermilionCity_Gym_Text_LtSurgePostBattle
 * release
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_LtSurge : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_Gym_EventScript_LtSurge")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ENGINEER_BAILY, VermilionCity_Gym_Text_BailyIntro, VermilionCity_Gym_Text_BailyDefeat
 * msgbox VermilionCity_Gym_Text_BailyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_Baily : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_ENGINEER_BAILY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VermilionCity_Gym.BailyPostBattle)
    }
    ctx.say(VermilionCity_Gym.BailyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VermilionCity_Gym.BailyDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SAILOR_DWAYNE, VermilionCity_Gym_Text_DwayneIntro, VermilionCity_Gym_Text_DwayneDefeat
 * famechecker FAMECHECKER_LTSURGE, 4
 * msgbox VermilionCity_Gym_Text_DwaynePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_Dwayne : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_Gym_EventScript_Dwayne")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_LT_SURGE, VermilionCity_Gym_EventScript_GymGuyPostVictory
 * msgbox VermilionCity_Gym_Text_GymGuyAdvice
 * release
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_LT_SURGE))
        return VermilionCity_Gym_EventScript_GymGuyPostVictory.run(ctx)
    ctx.say(VermilionCity_Gym.GymGuyAdvice)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_GENTLEMAN_TUCKER, VermilionCity_Gym_Text_TuckerIntro, VermilionCity_Gym_Text_TuckerDefeat, VermilionCity_Gym_EventScript_DefeatedTucker
 * famechecker FAMECHECKER_LTSURGE, 3
 * msgbox VermilionCity_Gym_Text_TuckerPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_Tucker : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_Gym_EventScript_Tucker")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_BADGE03_GET, VermilionCity_Gym_EventScript_GymStatuePostVictory
 * msgbox VermilionCity_Gym_Text_GymStatue
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_GymStatue")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 1
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 2
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 3
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 4
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 5
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 6
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan6 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 7
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan7 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan7")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 8
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan8 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan8")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 9
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan9 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan9")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 10
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan10 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan10")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 11
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan11 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan11")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 12
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan12 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan12")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 13
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan13 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan13")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 14
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan14 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan14")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar TRASH_CAN_ID, 15
 * goto VermilionCity_Gym_EventScript_TrashCan
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan15 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrashCan15")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_Gym_Text_GymGuyPostVictory
 * release
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_Gym.GymGuyPostVictory)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_Gym_Text_GymStatuePlayerWon
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_GymStatuePostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_Gym.GymStatuePlayerWon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * copyvar SWITCH1_ID, VAR_TEMP_0
 * copyvar SWITCH2_ID, VAR_TEMP_1
 * goto_if_set FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES, VermilionCity_Gym_EventScript_LocksAlreadyOpen
 * goto_if_set FOUND_FIRST_SWITCH, VermilionCity_Gym_EventScript_TrySwitchTwo
 * goto_if_eq SWITCH1_ID, TRASH_CAN_ID, VermilionCity_Gym_EventScript_FoundSwitchOne
 * msgbox VermilionCity_Gym_Text_NopeOnlyTrashHere
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrashCan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_Gym_EventScript_TrashCan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox VermilionCity_Gym_Text_ExplainThunderBadgeTakeThis
 * checkitemspace ITEM_TM34
 * goto_if_eq VAR_RESULT, FALSE, VermilionCity_Gym_EventScript_NoRoomForTM34
 * giveitem_msg VermilionCity_Gym_Text_ReceivedTM34FromLtSurge, ITEM_TM34
 * setflag FLAG_GOT_TM34_FROM_SURGE
 * msgbox VermilionCity_Gym_Text_ExplainTM34
 * release
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_GiveTM34 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_Gym_EventScript_GiveTM34")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_Gym_Text_MakeRoomInYourBag
 * release
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_NoRoomForTM34 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_Gym.MakeRoomInYourBag)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox VermilionCity_Gym_Text_SwitchUnderTrashFirstLockOpened
 * playse SE_PIN
 * waitse
 * call VermilionCity_Gym_EventScript_SetOneBeamOff
 * special DrawWholeMapView
 * setflag FOUND_FIRST_SWITCH
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_FoundSwitchOne : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_FoundSwitchOne")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_Gym_Text_NopeOnlyTrashHere
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_LocksAlreadyOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_Gym.NopeOnlyTrashHere)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq SWITCH2_ID, TRASH_CAN_ID, VermilionCity_Gym_EventScript_FoundSwitchTwo
 * msgbox VermilionCity_Gym_Text_OnlyTrashLocksWereReset
 * clearflag FOUND_FIRST_SWITCH
 * special SetVermilionTrashCans
 * copyvar VAR_TEMP_0, SWITCH1_ID
 * copyvar VAR_TEMP_1, SWITCH2_ID
 * call VermilionCity_Gym_EventScript_SetBeamsOn
 * special DrawWholeMapView
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_TrySwitchTwo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_TrySwitchTwo")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 3, 6, METATILE_VermilionGym_Beam_Node_TopLeft_HalfOn, 1
 * setmetatile 4, 6, METATILE_VermilionGym_Beam_Node_TopLeft_Edge_HalfOn, 1
 * setmetatile 5, 6, METATILE_VermilionGym_Beam_MidTop_HalfOn, 1
 * setmetatile 6, 6, METATILE_VermilionGym_Beam_Node_TopRight_Edge_HalfOn, 1
 * setmetatile 7, 6, METATILE_VermilionGym_Beam_Node_TopRight_HalfOn, 1
 * setmetatile 3, 7, METATILE_VermilionGym_Beam_Node_BottomLeft_HalfOn, 1
 * setmetatile 4, 7, METATILE_VermilionGym_Beam_Node_BottomLeft_Edge_HalfOn, 1
 * setmetatile 5, 7, METATILE_VermilionGym_Beam_MidBottom_HalfOn, 1
 * setmetatile 6, 7, METATILE_VermilionGym_Beam_Node_BottomRight_Edge_HalfOn, 1
 * setmetatile 7, 7, METATILE_VermilionGym_Beam_Node_BottomRight_HalfOn, 1
 * return
 * ```
 */
internal object VermilionCity_Gym_EventScript_SetOneBeamOff : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_SetOneBeamOff")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 3, 6, METATILE_VermilionGym_Beam_Node_TopLeft_On, 1
 * setmetatile 4, 6, METATILE_VermilionGym_Beam_Node_TopLeft_Edge_On, 1
 * setmetatile 5, 6, METATILE_VermilionGym_Beam_MidTop, 1
 * setmetatile 6, 6, METATILE_VermilionGym_Beam_Node_TopRight_Edge_On, 1
 * setmetatile 7, 6, METATILE_VermilionGym_Beam_Node_TopRight_On, 1
 * setmetatile 3, 7, METATILE_VermilionGym_Beam_Node_BottomLeft_On, 1
 * setmetatile 4, 7, METATILE_VermilionGym_Beam_Node_BottomLeft_Edge_On, 1
 * setmetatile 5, 7, METATILE_VermilionGym_Beam_MidBottom, 1
 * setmetatile 6, 7, METATILE_VermilionGym_Beam_Node_BottomRight_Edge_On, 1
 * setmetatile 7, 7, METATILE_VermilionGym_Beam_Node_BottomRight_On, 1
 * return
 * ```
 */
internal object VermilionCity_Gym_EventScript_SetBeamsOn : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_SetBeamsOn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox VermilionCity_Gym_Text_SecondLockOpened
 * closemessage
 * call VermilionCity_Gym_EventScript_SetBeamsOff
 * special DrawWholeMapView
 * playse SE_UNLOCK
 * waitse
 * setflag FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_Gym_EventScript_FoundSwitchTwo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_FoundSwitchTwo")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 3, 6, METATILE_VermilionGym_Beam_Node_TopLeft_Off, 1
 * setmetatile 4, 6, METATILE_VermilionGym_Beam_Node_TopLeft_Edge_Off, 0
 * setmetatile 5, 6, METATILE_VermilionGym_Floor, 0
 * setmetatile 6, 6, METATILE_VermilionGym_Beam_Node_TopRight_Edge_Off, 0
 * setmetatile 7, 6, METATILE_VermilionGym_Beam_Node_TopRight_Off, 1
 * setmetatile 3, 7, METATILE_VermilionGym_Beam_Node_BottomLeft_Off, 1
 * setmetatile 4, 7, METATILE_VermilionGym_Beam_Node_BottomLeft_Edge_Off, 0
 * setmetatile 5, 7, METATILE_VermilionGym_Floor, 0
 * setmetatile 6, 7, METATILE_VermilionGym_Beam_Node_BottomRight_Edge_Off, 0
 * setmetatile 7, 7, METATILE_VermilionGym_Beam_Node_BottomRight_Off, 1
 * return
 * ```
 */
internal object VermilionCity_Gym_EventScript_SetBeamsOff : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_Gym_EventScript_SetBeamsOff")
}

internal val VermilionCity_GymScripts: Map<String, Script> =
    mapOf(
        "VermilionCity_Gym_EventScript_LtSurge" to VermilionCity_Gym_EventScript_LtSurge,
        "VermilionCity_Gym_EventScript_Baily" to VermilionCity_Gym_EventScript_Baily,
        "VermilionCity_Gym_EventScript_Dwayne" to VermilionCity_Gym_EventScript_Dwayne,
        "VermilionCity_Gym_EventScript_GymGuy" to VermilionCity_Gym_EventScript_GymGuy,
        "VermilionCity_Gym_EventScript_Tucker" to VermilionCity_Gym_EventScript_Tucker,
        "VermilionCity_Gym_EventScript_GymStatue" to VermilionCity_Gym_EventScript_GymStatue,
        "VermilionCity_Gym_EventScript_TrashCan1" to VermilionCity_Gym_EventScript_TrashCan1,
        "VermilionCity_Gym_EventScript_TrashCan2" to VermilionCity_Gym_EventScript_TrashCan2,
        "VermilionCity_Gym_EventScript_TrashCan3" to VermilionCity_Gym_EventScript_TrashCan3,
        "VermilionCity_Gym_EventScript_TrashCan4" to VermilionCity_Gym_EventScript_TrashCan4,
        "VermilionCity_Gym_EventScript_TrashCan5" to VermilionCity_Gym_EventScript_TrashCan5,
        "VermilionCity_Gym_EventScript_TrashCan6" to VermilionCity_Gym_EventScript_TrashCan6,
        "VermilionCity_Gym_EventScript_TrashCan7" to VermilionCity_Gym_EventScript_TrashCan7,
        "VermilionCity_Gym_EventScript_TrashCan8" to VermilionCity_Gym_EventScript_TrashCan8,
        "VermilionCity_Gym_EventScript_TrashCan9" to VermilionCity_Gym_EventScript_TrashCan9,
        "VermilionCity_Gym_EventScript_TrashCan10" to VermilionCity_Gym_EventScript_TrashCan10,
        "VermilionCity_Gym_EventScript_TrashCan11" to VermilionCity_Gym_EventScript_TrashCan11,
        "VermilionCity_Gym_EventScript_TrashCan12" to VermilionCity_Gym_EventScript_TrashCan12,
        "VermilionCity_Gym_EventScript_TrashCan13" to VermilionCity_Gym_EventScript_TrashCan13,
        "VermilionCity_Gym_EventScript_TrashCan14" to VermilionCity_Gym_EventScript_TrashCan14,
        "VermilionCity_Gym_EventScript_TrashCan15" to VermilionCity_Gym_EventScript_TrashCan15,
        "VermilionCity_Gym_EventScript_GymGuyPostVictory" to
            VermilionCity_Gym_EventScript_GymGuyPostVictory,
        "VermilionCity_Gym_EventScript_GymStatuePostVictory" to
            VermilionCity_Gym_EventScript_GymStatuePostVictory,
        "VermilionCity_Gym_EventScript_TrashCan" to VermilionCity_Gym_EventScript_TrashCan,
        "VermilionCity_Gym_EventScript_GiveTM34" to VermilionCity_Gym_EventScript_GiveTM34,
        "VermilionCity_Gym_EventScript_NoRoomForTM34" to
            VermilionCity_Gym_EventScript_NoRoomForTM34,
        "VermilionCity_Gym_EventScript_FoundSwitchOne" to
            VermilionCity_Gym_EventScript_FoundSwitchOne,
        "VermilionCity_Gym_EventScript_LocksAlreadyOpen" to
            VermilionCity_Gym_EventScript_LocksAlreadyOpen,
        "VermilionCity_Gym_EventScript_TrySwitchTwo" to VermilionCity_Gym_EventScript_TrySwitchTwo,
        "VermilionCity_Gym_EventScript_SetOneBeamOff" to
            VermilionCity_Gym_EventScript_SetOneBeamOff,
        "VermilionCity_Gym_EventScript_SetBeamsOn" to VermilionCity_Gym_EventScript_SetBeamsOn,
        "VermilionCity_Gym_EventScript_FoundSwitchTwo" to
            VermilionCity_Gym_EventScript_FoundSwitchTwo,
        "VermilionCity_Gym_EventScript_SetBeamsOff" to VermilionCity_Gym_EventScript_SetBeamsOff,
    )
