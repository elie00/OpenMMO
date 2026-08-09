package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SlateportCity_NameRatersHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox SlateportCity_NameRatersHouse_Text_PleasedToRateMonNickname, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, SlateportCity_NameRatersHouse_EventScript_ChooseMonToRate
 * goto_if_eq VAR_RESULT, NO, SlateportCity_NameRatersHouse_EventScript_DeclineNameRate
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_NameRater : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_NameRatersHouse_EventScript_NameRater")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_NameRatersHouse_Text_DoVisitAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_DeclineNameRate : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_NameRatersHouse.DoVisitAgain)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SlateportCity_NameRatersHouse_Text_CritiqueWhichMonNickname, MSGBOX_DEFAULT
 * special ChoosePartyMon
 * goto_if_ne VAR_0x8004, PARTY_NOTHING_CHOSEN, SlateportCity_NameRatersHouse_EventScript_RateMonNickname
 * goto_if_eq VAR_0x8004, PARTY_NOTHING_CHOSEN, SlateportCity_NameRatersHouse_EventScript_DeclineNameRate
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_ChooseMonToRate : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_NameRatersHouse_EventScript_ChooseMonToRate")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ScriptGetPartyMonSpecies
 * goto_if_eq VAR_RESULT, SPECIES_EGG, SlateportCity_NameRatersHouse_EventScript_CantRateEgg
 * special BufferMonNickname
 * special IsMonOTIDNotPlayers
 * goto_if_eq VAR_RESULT, TRUE, SlateportCity_NameRatersHouse_EventScript_PlayerNotMonsOT
 * specialvar VAR_RESULT, MonOTNameNotPlayer
 * special BufferMonNickname
 * goto_if_eq VAR_RESULT, TRUE, SlateportCity_NameRatersHouse_EventScript_PlayerNotMonsOT
 * msgbox SlateportCity_NameRatersHouse_Text_FineNameSuggestBetterOne, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, SlateportCity_NameRatersHouse_EventScript_ChangeNickname
 * goto_if_eq VAR_RESULT, NO, SlateportCity_NameRatersHouse_EventScript_DeclineNameRate
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_RateMonNickname : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_NameRatersHouse_EventScript_RateMonNickname")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_NameRatersHouse_Text_MagnificentName, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_PlayerNotMonsOT : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_NameRatersHouse.MagnificentName)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_NameRatersHouse_Text_ThatIsMerelyAnEgg, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_CantRateEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_NameRatersHouse.ThatIsMerelyAnEgg)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SlateportCity_NameRatersHouse_Text_WhatShallNewNameBe, MSGBOX_DEFAULT
 * call Common_EventScript_NameReceivedPartyMon
 * specialvar VAR_RESULT, TryPutNameRaterShowOnTheAir
 * special BufferMonNickname
 * goto_if_eq VAR_RESULT, TRUE, SlateportCity_NameRatersHouse_EventScript_NewNameDifferent
 * msgbox SlateportCity_NameRatersHouse_Text_NameNoDifferentYetSuperior, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_ChangeNickname : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_NameRatersHouse_EventScript_ChangeNickname")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_NameRatersHouse_Text_MonShallBeKnownAsName, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_NameRatersHouse_EventScript_NewNameDifferent : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_NameRatersHouse.MonShallBeKnownAsName)
  }
}

internal val SlateportCity_NameRatersHouseScripts: Map<String, Script> =
    mapOf(
        "SlateportCity_NameRatersHouse_EventScript_NameRater" to
            SlateportCity_NameRatersHouse_EventScript_NameRater,
        "SlateportCity_NameRatersHouse_EventScript_DeclineNameRate" to
            SlateportCity_NameRatersHouse_EventScript_DeclineNameRate,
        "SlateportCity_NameRatersHouse_EventScript_ChooseMonToRate" to
            SlateportCity_NameRatersHouse_EventScript_ChooseMonToRate,
        "SlateportCity_NameRatersHouse_EventScript_RateMonNickname" to
            SlateportCity_NameRatersHouse_EventScript_RateMonNickname,
        "SlateportCity_NameRatersHouse_EventScript_PlayerNotMonsOT" to
            SlateportCity_NameRatersHouse_EventScript_PlayerNotMonsOT,
        "SlateportCity_NameRatersHouse_EventScript_CantRateEgg" to
            SlateportCity_NameRatersHouse_EventScript_CantRateEgg,
        "SlateportCity_NameRatersHouse_EventScript_ChangeNickname" to
            SlateportCity_NameRatersHouse_EventScript_ChangeNickname,
        "SlateportCity_NameRatersHouse_EventScript_NewNameDifferent" to
            SlateportCity_NameRatersHouse_EventScript_NewNameDifferent,
    )
