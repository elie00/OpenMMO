package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_GameCorner_PrizeRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object CeladonCity_GameCorner_PrizeRoom_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_GameCorner_PrizeRoom.FancyThatPorygon)
}

internal object CeladonCity_GameCorner_PrizeRoom_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_GameCorner_PrizeRoom.RakedItInToday)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase
 * goto_if_questlog EventScript_ReleaseEnd
 * showcoinsbox 0, 0
 * msgbox CeladonCity_GameCorner_PrizeRoom_Text_WeExchangeCoinsForPrizes
 * goto CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeMon
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkMons : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkMons")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase
 * goto_if_questlog EventScript_ReleaseEnd
 * showcoinsbox 0, 0
 * msgbox CeladonCity_GameCorner_PrizeRoom_Text_WeExchangeCoinsForPrizes
 * goto CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeTM
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkTMs : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkTMs")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase
 * goto_if_questlog EventScript_ReleaseEnd
 * showcoinsbox 0, 0
 * msgbox CeladonCity_GameCorner_PrizeRoom_Text_WeExchangeCoinsForPrizes
 * goto CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeItem
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkItems : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkItems")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox CeladonCity_GameCorner_PrizeRoom_Text_CoinCaseRequired
 * release
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CeladonCity_GameCorner_PrizeRoom_Text_WhichPrize
 * waitmessage
 * multichoice 10, 0, MULTICHOICE_GAME_CORNER_BATTLE_ITEM_PRIZES, FALSE
 * switch VAR_RESULT
 * case 0, CeladonCity_GameCorner_PrizeRoom_EventScript_SmokeBall
 * case 1, CeladonCity_GameCorner_PrizeRoom_EventScript_MiracleSeed
 * case 2, CeladonCity_GameCorner_PrizeRoom_EventScript_Charcoal
 * case 3, CeladonCity_GameCorner_PrizeRoom_EventScript_MysticWater
 * case 4, CeladonCity_GameCorner_PrizeRoom_EventScript_YellowFlute
 * case 5, CeladonCity_GameCorner_PrizeRoom_EventScript_EndPrizeExchange
 * case 127, CeladonCity_GameCorner_PrizeRoom_EventScript_EndPrizeExchange
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeItem : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeItem")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CeladonCity_GameCorner_PrizeRoom_Text_WhichPrize
 * waitmessage
 * multichoice 11, 0, MULTICHOICE_GAME_CORNER_TMPRIZES, FALSE
 * switch VAR_RESULT
 * case 0, CeladonCity_GameCorner_PrizeRoom_EventScript_TM13
 * case 1, CeladonCity_GameCorner_PrizeRoom_EventScript_TM23
 * case 2, CeladonCity_GameCorner_PrizeRoom_EventScript_TM24
 * case 3, CeladonCity_GameCorner_PrizeRoom_EventScript_TM30
 * case 4, CeladonCity_GameCorner_PrizeRoom_EventScript_TM35
 * case 5, CeladonCity_GameCorner_PrizeRoom_EventScript_EndPrizeExchange
 * case 127, CeladonCity_GameCorner_PrizeRoom_EventScript_EndPrizeExchange
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeTM : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeTM")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CeladonCity_GameCorner_PrizeRoom_Text_WhichPrize
 * waitmessage
 * multichoice 11, 0, MULTICHOICE_GAME_CORNER_POKEMON_PRIZES, FALSE
 * switch VAR_RESULT
 * case 0, CeladonCity_GameCorner_PrizeRoom_EventScript_Abra
 * case 1, CeladonCity_GameCorner_PrizeRoom_EventScript_Clefairy
 * case 2, CeladonCity_GameCorner_PrizeRoom_EventScript_DratiniPinsir
 * case 3, CeladonCity_GameCorner_PrizeRoom_EventScript_ScytherDratini
 * case 4, CeladonCity_GameCorner_PrizeRoom_EventScript_Porygon
 * case 5, CeladonCity_GameCorner_PrizeRoom_EventScript_EndPrizeExchange
 * case 127, CeladonCity_GameCorner_PrizeRoom_EventScript_EndPrizeExchange
 * end
 * ```
 */
internal object CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeMon")
}

internal val CeladonCity_GameCorner_PrizeRoomScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_GameCorner_PrizeRoom_EventScript_BaldingMan" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_BaldingMan,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_OldMan" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_OldMan,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkMons" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkMons,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkTMs" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkTMs,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkItems" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_PrizeClerkItems,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_NeedCoinCase,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeItem" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeItem,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeTM" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeTM,
        "CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeMon" to
            CeladonCity_GameCorner_PrizeRoom_EventScript_ChoosePrizeMon,
    )
