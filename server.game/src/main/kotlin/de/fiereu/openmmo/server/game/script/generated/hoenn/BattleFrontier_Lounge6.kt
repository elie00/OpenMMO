package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_Lounge6
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_BATTLE_FRONTIER_TRADE_DONE, BattleFrontier_Lounge6_EventScript_TradeCompleted
 * setvar VAR_0x8008, INGAME_TRADE_MEOWTH
 * copyvar VAR_0x8004, VAR_0x8008
 * specialvar VAR_RESULT, GetInGameTradeSpeciesInfo
 * copyvar VAR_0x8009, VAR_RESULT
 * msgbox BattleFrontier_Lounge6_Text_WouldYouLikeToTrade, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, BattleFrontier_Lounge6_EventScript_DeclineTrade
 * special ChoosePartyMon
 * copyvar VAR_0x800A, VAR_0x8004
 * goto_if_eq VAR_0x8004, PARTY_NOTHING_CHOSEN, BattleFrontier_Lounge6_EventScript_DeclineTrade
 * copyvar VAR_0x8005, VAR_0x800A
 * specialvar VAR_RESULT, GetTradeSpecies
 * copyvar VAR_0x800B, VAR_RESULT
 * goto_if_ne VAR_RESULT, VAR_0x8009, BattleFrontier_Lounge6_EventScript_NotRequestedMon
 * copyvar VAR_0x8004, VAR_0x8008
 * copyvar VAR_0x8005, VAR_0x800A
 * special CreateInGameTradePokemon
 * special DoInGameTradeScene
 * msgbox BattleFrontier_Lounge6_Text_PromiseIllBeGoodToIt, MSGBOX_DEFAULT
 * setflag FLAG_BATTLE_FRONTIER_TRADE_DONE
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge6_EventScript_Trader : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge6_EventScript_Trader")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge6_Text_WellThatsFineToo, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge6_EventScript_DeclineTrade : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge6.WellThatsFineToo)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, VAR_0x8009
 * msgbox BattleFrontier_Lounge6_Text_DontTradeForAnythingButMon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge6_EventScript_NotRequestedMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge6_EventScript_NotRequestedMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge6_Text_SkittySoMuchCuterThanImagined, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge6_EventScript_TradeCompleted : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge6.SkittySoMuchCuterThanImagined)
  }
}

internal val BattleFrontier_Lounge6Scripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_Lounge6_EventScript_Trader" to BattleFrontier_Lounge6_EventScript_Trader,
        "BattleFrontier_Lounge6_EventScript_DeclineTrade" to
            BattleFrontier_Lounge6_EventScript_DeclineTrade,
        "BattleFrontier_Lounge6_EventScript_NotRequestedMon" to
            BattleFrontier_Lounge6_EventScript_NotRequestedMon,
        "BattleFrontier_Lounge6_EventScript_TradeCompleted" to
            BattleFrontier_Lounge6_EventScript_TradeCompleted,
    )
