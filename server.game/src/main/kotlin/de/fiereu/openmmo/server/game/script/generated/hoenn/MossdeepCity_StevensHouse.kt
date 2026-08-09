package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MossdeepCity_StevensHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object MossdeepCity_StevensHouse_EventScript_Steven : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(MossdeepCity_StevensHouse.UnderwateCavernBetweenMossdeepSootopolis)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * msgbox MossdeepCity_StevensHouse_Text_TakeBallContainingBeldum, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MossdeepCity_StevensHouse_EventScript_LeaveBeldum
 * goto MossdeepCity_StevensHouse_EventScript_GiveBeldum
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_BeldumPokeball : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_StevensHouse_EventScript_BeldumPokeball")
}

internal object MossdeepCity_StevensHouse_EventScript_Letter : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MossdeepCity_StevensHouse.LetterFromSteven)
}

internal object MossdeepCity_StevensHouse_EventScript_RockDisplay : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(MossdeepCity_StevensHouse.CollectionOfRareRocks)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_StevensHouse_Text_LeftPokeBallWhereItWas, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_LeaveBeldum : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity_StevensHouse.LeftPokeBallWhereItWas)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_BELDUM
 * givemon SPECIES_BELDUM, 5
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, MossdeepCity_StevensHouse_EventScript_SendBeldumParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, MossdeepCity_StevensHouse_EventScript_SendBeldumPC
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_GiveBeldum : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_StevensHouse_EventScript_GiveBeldum")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call MossdeepCity_StevensHouse_EventScript_ReceivedBeldumFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MossdeepCity_StevensHouse_EventScript_ReceivedBeldum
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto MossdeepCity_StevensHouse_EventScript_ReceivedBeldum
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_SendBeldumParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_StevensHouse_EventScript_SendBeldumParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call MossdeepCity_StevensHouse_EventScript_ReceivedBeldumFanfare
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MossdeepCity_StevensHouse_EventScript_BeldumTransferredToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto MossdeepCity_StevensHouse_EventScript_BeldumTransferredToPC
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_SendBeldumPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_StevensHouse_EventScript_SendBeldumPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_2, SPECIES_BELDUM
 * removeobject LOCALID_STEVENS_HOUSE_BALL
 * playfanfare MUS_OBTAIN_ITEM
 * message MossdeepCity_StevensHouse_Text_ObtainedBeldum
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_BELDUM
 * return
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_ReceivedBeldumFanfare : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_StevensHouse_EventScript_ReceivedBeldumFanfare")
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto MossdeepCity_StevensHouse_EventScript_ReceivedBeldum
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_BeldumTransferredToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return MossdeepCity_StevensHouse_EventScript_ReceivedBeldum.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_HIDE_MOSSDEEP_CITY_STEVENS_HOUSE_BELDUM_POKEBALL
 * setflag FLAG_RECEIVED_BELDUM
 * releaseall
 * end
 * ```
 */
internal object MossdeepCity_StevensHouse_EventScript_ReceivedBeldum : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_HIDE_MOSSDEEP_CITY_STEVENS_HOUSE_BELDUM_POKEBALL)
    ctx.setFlag(HoennFlags.FLAG_RECEIVED_BELDUM)
  }
}

internal val MossdeepCity_StevensHouseScripts: Map<String, Script> =
    mapOf(
        "MossdeepCity_StevensHouse_EventScript_Steven" to
            MossdeepCity_StevensHouse_EventScript_Steven,
        "MossdeepCity_StevensHouse_EventScript_BeldumPokeball" to
            MossdeepCity_StevensHouse_EventScript_BeldumPokeball,
        "MossdeepCity_StevensHouse_EventScript_Letter" to
            MossdeepCity_StevensHouse_EventScript_Letter,
        "MossdeepCity_StevensHouse_EventScript_RockDisplay" to
            MossdeepCity_StevensHouse_EventScript_RockDisplay,
        "MossdeepCity_StevensHouse_EventScript_LeaveBeldum" to
            MossdeepCity_StevensHouse_EventScript_LeaveBeldum,
        "MossdeepCity_StevensHouse_EventScript_GiveBeldum" to
            MossdeepCity_StevensHouse_EventScript_GiveBeldum,
        "MossdeepCity_StevensHouse_EventScript_SendBeldumParty" to
            MossdeepCity_StevensHouse_EventScript_SendBeldumParty,
        "MossdeepCity_StevensHouse_EventScript_SendBeldumPC" to
            MossdeepCity_StevensHouse_EventScript_SendBeldumPC,
        "MossdeepCity_StevensHouse_EventScript_ReceivedBeldumFanfare" to
            MossdeepCity_StevensHouse_EventScript_ReceivedBeldumFanfare,
        "MossdeepCity_StevensHouse_EventScript_BeldumTransferredToPC" to
            MossdeepCity_StevensHouse_EventScript_BeldumTransferredToPC,
        "MossdeepCity_StevensHouse_EventScript_ReceivedBeldum" to
            MossdeepCity_StevensHouse_EventScript_ReceivedBeldum,
    )
