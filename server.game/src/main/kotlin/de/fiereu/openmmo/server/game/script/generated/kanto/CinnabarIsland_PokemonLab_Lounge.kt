package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CinnabarIsland_PokemonLab_Lounge
import de.fiereu.openmmo.dialog.generated.kanto.Trade
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object CinnabarIsland_PokemonLab_Lounge_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CinnabarIsland_PokemonLab_Lounge.FoundFossilInMtMoon)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, INGAME_TRADE_ELECTRODE
 * call EventScript_GetInGameTradeSpeciesInfo
 * goto_if_set FLAG_DID_ESPHERE_TRADE, CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonAlreadyTraded
 * msgbox Trade_Text_DoYouHaveMonWouldYouTradeForMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonDeclineTrade
 * call EventScript_ChooseMonForInGameTrade
 * goto_if_ge VAR_0x8004, PARTY_SIZE, CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonDeclineTrade
 * call EventScript_GetInGameTradeSpecies
 * goto_if_ne VAR_RESULT, VAR_0x8009, CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonNotRequestedMon
 * call EventScript_DoInGameTrade
 * msgbox Trade_Text_Thanks
 * setflag FLAG_DID_ESPHERE_TRADE
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_Clifton : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_Lounge_EventScript_Clifton")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8008, INGAME_TRADE_TANGELA
 * copyvar VAR_0x8004, VAR_0x8008
 * specialvar VAR_RESULT, GetInGameTradeSpeciesInfo
 * copyvar VAR_0x8009, VAR_RESULT
 * goto_if_set FLAG_DID_TANGENY_TRADE, CinnabarIsland_PokemonLab_Lounge_EventScript_NormaAlreadyTraded
 * msgbox Trade_Text_DoYouHaveMonWantToTradeForMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CinnabarIsland_PokemonLab_Lounge_EventScript_NormaDeclineTrade
 * special ChoosePartyMon
 * waitstate
 * copyvar VAR_0x800A, VAR_0x8004
 * goto_if_ge VAR_0x8004, PARTY_SIZE, CinnabarIsland_PokemonLab_Lounge_EventScript_NormaDeclineTrade
 * copyvar VAR_0x8005, VAR_0x800A
 * specialvar VAR_RESULT, GetTradeSpecies
 * copyvar VAR_0x800B, VAR_RESULT
 * goto_if_ne VAR_RESULT, VAR_0x8009, CinnabarIsland_PokemonLab_Lounge_EventScript_NormaNotRequestedMon
 * copyvar VAR_0x8004, VAR_0x8008
 * copyvar VAR_0x8005, VAR_0x800A
 * special CreateInGameTradePokemon
 * special DoInGameTradeScene
 * waitstate
 * msgbox Trade_Text_ThanksYoureAPal
 * setflag FLAG_DID_TANGENY_TRADE
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_Norma : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_Lounge_EventScript_Norma")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Trade_Text_WellIfYouDontWantTo
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonDeclineTrade : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Trade.WellIfYouDontWantTo)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Trade_Text_HasTradedMonGrownStronger
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonAlreadyTraded : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Trade.HasTradedMonGrownStronger)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, VAR_0x8009
 * msgbox Trade_Text_ThisIsntMon
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonNotRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonNotRequestedMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Trade_Text_ThatsTooBad
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_NormaDeclineTrade : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Trade.ThatsTooBad)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Trade_Text_HowIsMyOldMon
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_NormaAlreadyTraded : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Trade.HowIsMyOldMon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, VAR_0x8009
 * msgbox Trade_Text_ThisIsNoMon
 * release
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_Lounge_EventScript_NormaNotRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CinnabarIsland_PokemonLab_Lounge_EventScript_NormaNotRequestedMon")
}

internal val CinnabarIsland_PokemonLab_LoungeScripts: Map<String, Script> =
    mapOf(
        "CinnabarIsland_PokemonLab_Lounge_EventScript_Scientist" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_Scientist,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_Clifton" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_Clifton,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_Norma" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_Norma,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonDeclineTrade" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonDeclineTrade,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonAlreadyTraded" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonAlreadyTraded,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonNotRequestedMon" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_CliftonNotRequestedMon,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_NormaDeclineTrade" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_NormaDeclineTrade,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_NormaAlreadyTraded" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_NormaAlreadyTraded,
        "CinnabarIsland_PokemonLab_Lounge_EventScript_NormaNotRequestedMon" to
            CinnabarIsland_PokemonLab_Lounge_EventScript_NormaNotRequestedMon,
    )
