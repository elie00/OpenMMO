package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RustboroCity_DevonCorp_2F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_eq VAR_FOSSIL_RESURRECTION_STATE, 1, RustboroCity_DevonCorp_2F_EventScript_SetFossilReady
 * msgbox RustboroCity_DevonCorp_2F_Text_DeviceForTalkingToPokemon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_TalkToPokemonScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_TalkToPokemonScientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_eq VAR_FOSSIL_RESURRECTION_STATE, 1, RustboroCity_DevonCorp_2F_EventScript_SetFossilReady
 * goto_if_set FLAG_MET_DEVON_EMPLOYEE, RustboroCity_DevonCorp_2F_EventScript_DevelopedBalls
 * msgbox RustboroCity_DevonCorp_2F_Text_DevelopingNewBalls, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_BallScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_BallScientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_eq VAR_FOSSIL_RESURRECTION_STATE, 1, RustboroCity_DevonCorp_2F_EventScript_SetFossilReady
 * goto_if_set FLAG_RECEIVED_POKENAV, RustboroCity_DevonCorp_2F_EventScript_HasPokenav
 * msgbox RustboroCity_DevonCorp_2F_Text_IMadePokenav, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_PokenavScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_PokenavScientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_eq VAR_FOSSIL_RESURRECTION_STATE, 1, RustboroCity_DevonCorp_2F_EventScript_SetFossilReady
 * msgbox RustboroCity_DevonCorp_2F_Text_DeviceToVisualizePokemonDreams, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_PokemonDreamsScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_PokemonDreamsScientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_FOSSIL_RESURRECTION_STATE, 2, RustboroCity_DevonCorp_2F_EventScript_FossilMonReady
 * goto_if_eq VAR_FOSSIL_RESURRECTION_STATE, 1, RustboroCity_DevonCorp_2F_EventScript_StillRegenerating
 * msgbox RustboroCity_DevonCorp_2F_Text_DevelopDeviceToResurrectFossils, MSGBOX_DEFAULT
 * checkitem ITEM_ROOT_FOSSIL
 * goto_if_eq VAR_RESULT, TRUE, RustboroCity_DevonCorp_2F_EventScript_NoticeRootFossil
 * checkitem ITEM_CLAW_FOSSIL
 * goto_if_eq VAR_RESULT, TRUE, RustboroCity_DevonCorp_2F_EventScript_NoticeClawFossil
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_FossilScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_FossilScientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_eq VAR_FOSSIL_RESURRECTION_STATE, 1, RustboroCity_DevonCorp_2F_EventScript_SetFossilReady
 * goto_if_ge VAR_RUSTBORO_CITY_STATE, 6, RustboroCity_DevonCorp_2F_EventScript_WorkOnNext
 * msgbox RustboroCity_DevonCorp_2F_Text_DevelopNewPokenavFeature, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_MatchCallScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_MatchCallScientist")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_eq VAR_WHICH_FOSSIL_REVIVED, 1, RustboroCity_DevonCorp_2F_EventScript_LileepReady
 * goto_if_eq VAR_WHICH_FOSSIL_REVIVED, 2, RustboroCity_DevonCorp_2F_EventScript_AnorithReady
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_FossilMonReady : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_WHICH_FOSSIL_REVIVED) == 1)
        return RustboroCity_DevonCorp_2F_EventScript_LileepReady.run(ctx)
    if (ctx.getVar(HoennVars.VAR_WHICH_FOSSIL_REVIVED) == 2)
        return RustboroCity_DevonCorp_2F_EventScript_AnorithReady.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_2F_Text_WeFinallyMadeNewBalls, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_DevelopedBalls : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_2F.WeFinallyMadeNewBalls)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * playse SE_PIN
 * applymovement LOCALID_FOSSIL_SCIENTIST, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_FOSSIL_SCIENTIST, Common_Movement_Delay48
 * waitmovement 0
 * msgbox RustboroCity_DevonCorp_2F_Text_WantToBringFossilBackToLife, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_DevonCorp_2F_EventScript_DeclineGiveFossil
 * checkitem ITEM_ROOT_FOSSIL
 * goto_if_eq VAR_RESULT, TRUE, RustboroCity_DevonCorp_2F_EventScript_ChooseFossil
 * goto RustboroCity_DevonCorp_2F_EventScript_GiveClawFossil
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_NoticeClawFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_NoticeClawFossil")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_2F_Text_FossilRegeneratorTakesTime, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_StillRegenerating : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_2F.FossilRegeneratorTakesTime)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_2F_Text_WowThatsAPokenav, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_HasPokenav : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_2F.WowThatsAPokenav)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_2F_Text_WhatToWorkOnNext, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_WorkOnNext : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_2F.WhatToWorkOnNext)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * playse SE_PIN
 * applymovement LOCALID_FOSSIL_SCIENTIST, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_FOSSIL_SCIENTIST, Common_Movement_Delay48
 * waitmovement 0
 * msgbox RustboroCity_DevonCorp_2F_Text_WantToBringFossilBackToLife, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_DevonCorp_2F_EventScript_DeclineGiveFossil
 * checkitem ITEM_CLAW_FOSSIL
 * goto_if_eq VAR_RESULT, TRUE, RustboroCity_DevonCorp_2F_EventScript_ChooseFossil
 * goto RustboroCity_DevonCorp_2F_EventScript_GiveRootFossil
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_NoticeRootFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_NoticeRootFossil")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_FOSSIL_RESURRECTION_STATE, 2
 * return
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_SetFossilReady : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_FOSSIL_RESURRECTION_STATE, 2)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferitemname STR_VAR_1, ITEM_ROOT_FOSSIL
 * msgbox RustboroCity_DevonCorp_2F_Text_HandedFossilToResearcher, MSGBOX_DEFAULT
 * removeitem ITEM_ROOT_FOSSIL
 * setvar VAR_FOSSIL_RESURRECTION_STATE, 1
 * setvar VAR_WHICH_FOSSIL_REVIVED, 1
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_GiveRootFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_GiveRootFossil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message RustboroCity_DevonCorp_2F_Text_TwoFossilsPickOne
 * waitmessage
 * multichoice 17, 6, MULTI_FOSSIL, FALSE
 * switch VAR_RESULT
 * case 0, RustboroCity_DevonCorp_2F_EventScript_ChooseClawFossil
 * case 1, RustboroCity_DevonCorp_2F_EventScript_ChooseRootFossil
 * case 2, RustboroCity_DevonCorp_2F_EventScript_CancelFossilSelect
 * case MULTI_B_PRESSED, RustboroCity_DevonCorp_2F_EventScript_CancelFossilSelect
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ChooseFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ChooseFossil")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_2F_Text_OhIsThatSo, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_DeclineGiveFossil : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_2F.OhIsThatSo)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_2, SPECIES_ANORITH
 * msgbox RustboroCity_DevonCorp_2F_Text_FossilizedMonBroughtBackToLife, MSGBOX_DEFAULT
 * goto RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorith
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_AnorithReady : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_AnorithReady")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_2, SPECIES_LILEEP
 * msgbox RustboroCity_DevonCorp_2F_Text_FossilizedMonBroughtBackToLife, MSGBOX_DEFAULT
 * goto RustboroCity_DevonCorp_2F_EventScript_ReceiveLileep
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_LileepReady : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_LileepReady")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferitemname STR_VAR_1, ITEM_CLAW_FOSSIL
 * msgbox RustboroCity_DevonCorp_2F_Text_HandedFossilToResearcher, MSGBOX_DEFAULT
 * removeitem ITEM_CLAW_FOSSIL
 * setvar VAR_FOSSIL_RESURRECTION_STATE, 1
 * setvar VAR_WHICH_FOSSIL_REVIVED, 2
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_GiveClawFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_GiveClawFossil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_LILEEP
 * givemon SPECIES_LILEEP, 20
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepPC
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceiveLileep : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceiveLileep")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_ANORITH
 * givemon SPECIES_ANORITH, 20
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithPC
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorith : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorith")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call RustboroCity_DevonCorp_2F_EventScript_ReceivedAnorithFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call RustboroCity_DevonCorp_2F_EventScript_ReceivedLileepFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call RustboroCity_DevonCorp_2F_EventScript_ReceivedLileepFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_DevonCorp_2F_EventScript_TransferLileepToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto RustboroCity_DevonCorp_2F_EventScript_TransferLileepToPC
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call RustboroCity_DevonCorp_2F_EventScript_ReceivedAnorithFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_DevonCorp_2F_EventScript_TransferAnorithToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto RustboroCity_DevonCorp_2F_EventScript_TransferAnorithToPC
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_2, SPECIES_ANORITH
 * playfanfare MUS_OBTAIN_ITEM
 * message RustboroCity_DevonCorp_2F_Text_ReceivedMonFromResearcher
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_ANORITH
 * return
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceivedAnorithFanfare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceivedAnorithFanfare")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_FOSSIL_RESURRECTION_STATE, 0
 * setflag FLAG_RECEIVED_REVIVED_FOSSIL_MON
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_FOSSIL_RESURRECTION_STATE, 0)
    ctx.setFlag(HoennFlags.FLAG_RECEIVED_REVIVED_FOSSIL_MON)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_2, SPECIES_LILEEP
 * playfanfare MUS_OBTAIN_ITEM
 * message RustboroCity_DevonCorp_2F_Text_ReceivedMonFromResearcher
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_LILEEP
 * return
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_ReceivedLileepFanfare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_DevonCorp_2F_EventScript_ReceivedLileepFanfare")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_FOSSIL_RESURRECTION_STATE, 0
 * setflag FLAG_RECEIVED_REVIVED_FOSSIL_MON
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_FOSSIL_RESURRECTION_STATE, 0)
    ctx.setFlag(HoennFlags.FLAG_RECEIVED_REVIVED_FOSSIL_MON)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_TransferAnorithToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_2F_EventScript_TransferLileepToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep.run(ctx)
  }
}

internal val RustboroCity_DevonCorp_2FScripts: Map<String, Script> =
    mapOf(
        "RustboroCity_DevonCorp_2F_EventScript_TalkToPokemonScientist" to
            RustboroCity_DevonCorp_2F_EventScript_TalkToPokemonScientist,
        "RustboroCity_DevonCorp_2F_EventScript_BallScientist" to
            RustboroCity_DevonCorp_2F_EventScript_BallScientist,
        "RustboroCity_DevonCorp_2F_EventScript_PokenavScientist" to
            RustboroCity_DevonCorp_2F_EventScript_PokenavScientist,
        "RustboroCity_DevonCorp_2F_EventScript_PokemonDreamsScientist" to
            RustboroCity_DevonCorp_2F_EventScript_PokemonDreamsScientist,
        "RustboroCity_DevonCorp_2F_EventScript_FossilScientist" to
            RustboroCity_DevonCorp_2F_EventScript_FossilScientist,
        "RustboroCity_DevonCorp_2F_EventScript_MatchCallScientist" to
            RustboroCity_DevonCorp_2F_EventScript_MatchCallScientist,
        "RustboroCity_DevonCorp_2F_EventScript_FossilMonReady" to
            RustboroCity_DevonCorp_2F_EventScript_FossilMonReady,
        "RustboroCity_DevonCorp_2F_EventScript_DevelopedBalls" to
            RustboroCity_DevonCorp_2F_EventScript_DevelopedBalls,
        "RustboroCity_DevonCorp_2F_EventScript_NoticeClawFossil" to
            RustboroCity_DevonCorp_2F_EventScript_NoticeClawFossil,
        "RustboroCity_DevonCorp_2F_EventScript_StillRegenerating" to
            RustboroCity_DevonCorp_2F_EventScript_StillRegenerating,
        "RustboroCity_DevonCorp_2F_EventScript_HasPokenav" to
            RustboroCity_DevonCorp_2F_EventScript_HasPokenav,
        "RustboroCity_DevonCorp_2F_EventScript_WorkOnNext" to
            RustboroCity_DevonCorp_2F_EventScript_WorkOnNext,
        "RustboroCity_DevonCorp_2F_EventScript_NoticeRootFossil" to
            RustboroCity_DevonCorp_2F_EventScript_NoticeRootFossil,
        "RustboroCity_DevonCorp_2F_EventScript_SetFossilReady" to
            RustboroCity_DevonCorp_2F_EventScript_SetFossilReady,
        "RustboroCity_DevonCorp_2F_EventScript_GiveRootFossil" to
            RustboroCity_DevonCorp_2F_EventScript_GiveRootFossil,
        "RustboroCity_DevonCorp_2F_EventScript_ChooseFossil" to
            RustboroCity_DevonCorp_2F_EventScript_ChooseFossil,
        "RustboroCity_DevonCorp_2F_EventScript_DeclineGiveFossil" to
            RustboroCity_DevonCorp_2F_EventScript_DeclineGiveFossil,
        "RustboroCity_DevonCorp_2F_EventScript_AnorithReady" to
            RustboroCity_DevonCorp_2F_EventScript_AnorithReady,
        "RustboroCity_DevonCorp_2F_EventScript_LileepReady" to
            RustboroCity_DevonCorp_2F_EventScript_LileepReady,
        "RustboroCity_DevonCorp_2F_EventScript_GiveClawFossil" to
            RustboroCity_DevonCorp_2F_EventScript_GiveClawFossil,
        "RustboroCity_DevonCorp_2F_EventScript_ReceiveLileep" to
            RustboroCity_DevonCorp_2F_EventScript_ReceiveLileep,
        "RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorith" to
            RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorith,
        "RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithParty" to
            RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithParty,
        "RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepParty" to
            RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepParty,
        "RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepPC" to
            RustboroCity_DevonCorp_2F_EventScript_ReceiveLileepPC,
        "RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithPC" to
            RustboroCity_DevonCorp_2F_EventScript_ReceiveAnorithPC,
        "RustboroCity_DevonCorp_2F_EventScript_ReceivedAnorithFanfare" to
            RustboroCity_DevonCorp_2F_EventScript_ReceivedAnorithFanfare,
        "RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep" to
            RustboroCity_DevonCorp_2F_EventScript_FinishReceivingLileep,
        "RustboroCity_DevonCorp_2F_EventScript_ReceivedLileepFanfare" to
            RustboroCity_DevonCorp_2F_EventScript_ReceivedLileepFanfare,
        "RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith" to
            RustboroCity_DevonCorp_2F_EventScript_FinishReceivingAnorith,
        "RustboroCity_DevonCorp_2F_EventScript_TransferAnorithToPC" to
            RustboroCity_DevonCorp_2F_EventScript_TransferAnorithToPC,
        "RustboroCity_DevonCorp_2F_EventScript_TransferLileepToPC" to
            RustboroCity_DevonCorp_2F_EventScript_TransferLileepToPC,
    )
