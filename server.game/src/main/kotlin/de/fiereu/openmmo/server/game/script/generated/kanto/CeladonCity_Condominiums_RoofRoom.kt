package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_Condominiums_RoofRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object CeladonCity_Condominiums_RoofRoom_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_Condominiums_RoofRoom.TheresNothingIDontKnow)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, SPECIES_EEVEE
 * givemon SPECIES_EEVEE, 25
 * goto_if_eq VAR_RESULT, 0, CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveeParty
 * goto_if_eq VAR_RESULT, 1, CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveePC
 * goto_if_eq VAR_RESULT, 2, EventScript_NoMoreRoomForPokemon
 * release
 * end
 * ```
 */
internal object CeladonCity_Condominiums_RoofRoom_EventScript_EeveeBall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_Condominiums_RoofRoom_EventScript_EeveeBall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * msgbox CeladonCity_Condominiums_RoofRoom_Text_WirelessAdapterLecture
 * message CeladonCity_Condominiums_RoofRoom_Text_ReadWhichHeading
 * waitmessage
 * setvar VAR_0x8004, 4
 * multichoice 0, 0, MULTICHOICE_LINKED_DIRECT_UNION, FALSE
 * switch VAR_RESULT
 * case 0, CeladonCity_Condominiums_RoofRoom_EventScript_WirelessClub
 * case 1, CeladonCity_Condominiums_RoofRoom_EventScript_DirectCorner
 * case 2, CeladonCity_Condominiums_RoofRoom_EventScript_UnionRoom
 * case 3, CeladonCity_Condominiums_RoofRoom_EventScript_ExitBlackboard
 * case 127, CeladonCity_Condominiums_RoofRoom_EventScript_ExitBlackboard
 * end
 * ```
 */
internal object CeladonCity_Condominiums_RoofRoom_EventScript_Blackboard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_Condominiums_RoofRoom_EventScript_Blackboard")
}

internal object CeladonCity_Condominiums_RoofRoom_EventScript_TMsPamphlet : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CeladonCity_Condominiums_RoofRoom.PamphletOnTMs)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removeobject LOCALID_EEVEE_POKEBALL
 * playfanfare MUS_LEVEL_UP
 * message CeladonCity_Condominiums_RoofRoom_Text_ObtainedAnEevee
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_EEVEE
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CeladonCity_Condominiums_RoofRoom_EventScript_TransferEeveeToPC
 * call EventScript_NameReceivedBoxMon
 * goto CeladonCity_Condominiums_RoofRoom_EventScript_TransferEeveeToPC
 * end
 * ```
 */
internal object CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveePC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveePC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removeobject LOCALID_EEVEE_POKEBALL
 * playfanfare MUS_LEVEL_UP
 * message CeladonCity_Condominiums_RoofRoom_Text_ObtainedAnEevee
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_EEVEE
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee
 * call EventScript_GetGiftMonPartySlot
 * call EventScript_ChangePokemonNickname
 * goto CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee
 * end
 * ```
 */
internal object CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveeParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveeParty")
}

/**
 * Ported from the decomp:
 * ```
 * call EventScript_TransferredToPC
 * goto CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee
 * end
 * ```
 */
internal object CeladonCity_Condominiums_RoofRoom_EventScript_TransferEeveeToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_TransferredToPC.run(ctx)
    return CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * getpartysize
 * subvar VAR_RESULT, 1
 * copyvar VAR_0x8004, VAR_RESULT
 * return
 * ```
 */
internal object EventScript_GetGiftMonPartySlot : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_GetGiftMonPartySlot")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreen FADE_TO_BLACK
 * special ChangeBoxPokemonNickname
 * waitstate
 * lock
 * faceplayer
 * return
 * ```
 */
internal object EventScript_NameReceivedBoxMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_NameReceivedBoxMon")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_GOT_EEVEE
 * release
 * end
 * ```
 */
internal object CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_GOT_EEVEE)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferboxname STR_VAR_1, VAR_PC_BOX_TO_SEND_MON
 * bufferspeciesname STR_VAR_2, VAR_TEMP_1
 * call_if_unset FLAG_SYS_NOT_SOMEONES_PC, EventScript_TransferredSomeonesPC
 * call_if_set FLAG_SYS_NOT_SOMEONES_PC, EventScript_TransferredBillsPC
 * return
 * ```
 */
internal object EventScript_TransferredToPC : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_TransferredToPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ShouldShowBoxWasFullMessage
 * goto_if_eq VAR_RESULT, TRUE, EventScript_TransferredSomeonesPCBoxFull
 * msgbox Text_MonSentToBoxInSomeonesPC
 * return
 * ```
 */
internal object EventScript_TransferredSomeonesPC : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_TransferredSomeonesPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ShouldShowBoxWasFullMessage
 * goto_if_eq VAR_RESULT, TRUE, EventScript_TransferredBillsPCBoxFull
 * msgbox Text_MonSentToBoxInBillsPC
 * return
 * ```
 */
internal object EventScript_TransferredBillsPC : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_TransferredBillsPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetPCBoxToSendMon
 * bufferboxname STR_VAR_3, VAR_RESULT
 * msgbox Text_MonSentToBoxSomeonesBoxFull
 * return
 * ```
 */
internal object EventScript_TransferredSomeonesPCBoxFull : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_TransferredSomeonesPCBoxFull")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetPCBoxToSendMon
 * bufferboxname STR_VAR_3, VAR_RESULT
 * msgbox Text_MonSentToBoxBillsBoxFull
 * return
 * ```
 */
internal object EventScript_TransferredBillsPCBoxFull : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_TransferredBillsPCBoxFull")
}

internal val CeladonCity_Condominiums_RoofRoomScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_Condominiums_RoofRoom_EventScript_BlackBelt" to
            CeladonCity_Condominiums_RoofRoom_EventScript_BlackBelt,
        "CeladonCity_Condominiums_RoofRoom_EventScript_EeveeBall" to
            CeladonCity_Condominiums_RoofRoom_EventScript_EeveeBall,
        "CeladonCity_Condominiums_RoofRoom_EventScript_Blackboard" to
            CeladonCity_Condominiums_RoofRoom_EventScript_Blackboard,
        "CeladonCity_Condominiums_RoofRoom_EventScript_TMsPamphlet" to
            CeladonCity_Condominiums_RoofRoom_EventScript_TMsPamphlet,
        "CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveePC" to
            CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveePC,
        "CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveeParty" to
            CeladonCity_Condominiums_RoofRoom_EventScript_GetEeveeParty,
        "CeladonCity_Condominiums_RoofRoom_EventScript_TransferEeveeToPC" to
            CeladonCity_Condominiums_RoofRoom_EventScript_TransferEeveeToPC,
        "EventScript_GetGiftMonPartySlot" to EventScript_GetGiftMonPartySlot,
        "EventScript_NameReceivedBoxMon" to EventScript_NameReceivedBoxMon,
        "CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee" to
            CeladonCity_Condominiums_RoofRoom_EventScript_SetGotEevee,
        "EventScript_TransferredToPC" to EventScript_TransferredToPC,
        "EventScript_TransferredSomeonesPC" to EventScript_TransferredSomeonesPC,
        "EventScript_TransferredBillsPC" to EventScript_TransferredBillsPC,
        "EventScript_TransferredSomeonesPCBoxFull" to EventScript_TransferredSomeonesPCBoxFull,
        "EventScript_TransferredBillsPCBoxFull" to EventScript_TransferredBillsPCBoxFull,
    )
