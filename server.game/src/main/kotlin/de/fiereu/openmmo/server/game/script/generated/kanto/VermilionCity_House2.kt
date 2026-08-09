package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, INGAME_TRADE_FARFETCHD
 * call EventScript_GetInGameTradeSpeciesInfo
 * goto_if_set FLAG_DID_CH_DING_TRADE, VermilionCity_House2_EventScript_AlreadyTraded
 * msgbox VermilionCity_House2_Text_DoYouHaveMonWantToTradeForMyMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, VermilionCity_House2_EventScript_DeclineTrade
 * call EventScript_ChooseMonForInGameTrade
 * goto_if_ge VAR_0x8004, PARTY_SIZE, VermilionCity_House2_EventScript_DeclineTrade
 * call EventScript_GetInGameTradeSpecies
 * goto_if_ne VAR_RESULT, VAR_0x8009, VermilionCity_House2_EventScript_NotRequestedMon
 * call EventScript_DoInGameTrade
 * msgbox VermilionCity_House2_Text_ThankYou
 * setflag FLAG_DID_CH_DING_TRADE
 * release
 * end
 * ```
 */
internal object VermilionCity_House2_EventScript_Elyssa : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_House2_EventScript_Elyssa")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, VAR_0x8009
 * msgbox VermilionCity_House2_Text_ThisIsNoMon
 * release
 * end
 * ```
 */
internal object VermilionCity_House2_EventScript_NotRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_House2_EventScript_NotRequestedMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_House2_Text_HowIsMyOldMon
 * release
 * end
 * ```
 */
internal object VermilionCity_House2_EventScript_AlreadyTraded : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_House2.HowIsMyOldMon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_House2_Text_ThatsTooBad
 * release
 * end
 * ```
 */
internal object VermilionCity_House2_EventScript_DeclineTrade : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_House2.ThatsTooBad)
  }
}

internal val VermilionCity_House2Scripts: Map<String, Script> =
    mapOf(
        "VermilionCity_House2_EventScript_Elyssa" to VermilionCity_House2_EventScript_Elyssa,
        "VermilionCity_House2_EventScript_NotRequestedMon" to
            VermilionCity_House2_EventScript_NotRequestedMon,
        "VermilionCity_House2_EventScript_AlreadyTraded" to
            VermilionCity_House2_EventScript_AlreadyTraded,
        "VermilionCity_House2_EventScript_DeclineTrade" to
            VermilionCity_House2_EventScript_DeclineTrade,
    )
