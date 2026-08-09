package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route4_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * call EventScript_PkmnCenterNurse
 * release
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_PkmnCenterNurse.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_BOUGHT_MAGIKARP, Route4_PokemonCenter_1F_EventScript_AlreadyBoughtMagikarp
 * showmoneybox 0, 0
 * checkplayergender
 * goto_if_eq VAR_RESULT, MALE, Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpMale
 * goto_if_eq VAR_RESULT, FEMALE, Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpFemale
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_MagikarpSalesman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_MagikarpSalesman")
}

internal object Route4_PokemonCenter_1F_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route4_PokemonCenter_1F.TeamRocketAttacksCerulean)
}

internal object Route4_PokemonCenter_1F_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route4_PokemonCenter_1F.CanHaveSixMonsWithYou)
}

internal object Route4_PokemonCenter_1F_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route4_PokemonCenter_1F.ShouldStoreMonsUsingPC)
}

internal object Route4_PokemonCenter_1F_EventScript_Newspaper : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route4_PokemonCenter_1F.ItsANewspaper)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route4_PokemonCenter_1F_Text_LaddieBuyMagikarpForJust500, MSGBOX_YESNO
 * goto Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpMale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route4_PokemonCenter_1F.LaddieBuyMagikarpForJust500)
    return Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route4_PokemonCenter_1F_Text_IDontGiveRefunds
 * release
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_AlreadyBoughtMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route4_PokemonCenter_1F.IDontGiveRefunds)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route4_PokemonCenter_1F_Text_SweetieBuyMagikarpForJust500, MSGBOX_YESNO
 * goto Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpFemale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route4_PokemonCenter_1F.SweetieBuyMagikarpForJust500)
    return Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_RESULT, NO, Route4_PokemonCenter_1F_EventScript_DeclineMagikarp
 * checkmoney MAGIKARP_PRICE
 * goto_if_eq VAR_RESULT, FALSE, Route4_PokemonCenter_1F_EventScript_NotEnoughMoney
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * setvar VAR_TEMP_1, SPECIES_MAGIKARP
 * givemon SPECIES_MAGIKARP, 5
 * goto_if_eq VAR_RESULT, 0, Route4_PokemonCenter_1F_EventScript_BuyMagikarpParty
 * goto_if_eq VAR_RESULT, 1, Route4_PokemonCenter_1F_EventScript_BuyMagikarpPC
 * goto_if_eq VAR_RESULT, 2, Route4_PokemonCenter_1F_EventScript_NoRoomForMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route4_PokemonCenter_1F_Text_OnlyDoingThisAsFavorToYou
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_DeclineMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_DeclineMagikarp")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route4_PokemonCenter_1F_Text_YoullNeedMoreMoney
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_NotEnoughMoney : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_NotEnoughMoney")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox Route4_PokemonCenter_1F_Text_NoRoomForMorePokemon
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_NoRoomForMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_NoRoomForMagikarp")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call Route4_PokemonCenter_1F_EventScript_PayForMagikarp
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route4_PokemonCenter_1F_EventScript_TransferMagikarpCloseMoneyBox
 * fadescreen FADE_TO_BLACK
 * hidemoneybox
 * special ChangeBoxPokemonNickname
 * waitstate
 * lock
 * faceplayer
 * goto Route4_PokemonCenter_1F_EventScript_TransferMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_BuyMagikarpPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_BuyMagikarpPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call Route4_PokemonCenter_1F_EventScript_PayForMagikarp
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp
 * call EventScript_GetGiftMonPartySlot
 * fadescreen FADE_TO_BLACK
 * hidemoneybox
 * special ChangePokemonNickname
 * waitstate
 * goto Route4_PokemonCenter_1F_EventScript_BoughtMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_BuyMagikarpParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_BuyMagikarpParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removemoney MAGIKARP_PRICE
 * updatemoneybox
 * playfanfare MUS_LEVEL_UP
 * message Route4_PokemonCenter_1F_Text_PaidOutrageouslyForMagikarp
 * waitmessage
 * waitfanfare
 * bufferspeciesname STR_VAR_1, SPECIES_MAGIKARP
 * return
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_PayForMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_PayForMagikarp")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_BOUGHT_MAGIKARP
 * release
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_BoughtMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_BOUGHT_MAGIKARP)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call EventScript_TransferredToPC
 * goto Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_TransferMagikarpCloseMoneyBox : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_TransferredToPC.run(ctx)
    return Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemoneybox
 * goto Route4_PokemonCenter_1F_EventScript_BoughtMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp")
}

/**
 * Ported from the decomp:
 * ```
 * call EventScript_TransferredToPC
 * goto Route4_PokemonCenter_1F_EventScript_BoughtMagikarp
 * end
 * ```
 */
internal object Route4_PokemonCenter_1F_EventScript_TransferMagikarp : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_TransferredToPC.run(ctx)
    return Route4_PokemonCenter_1F_EventScript_BoughtMagikarp.run(ctx)
  }
}

internal val Route4_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "Route4_PokemonCenter_1F_EventScript_Nurse" to Route4_PokemonCenter_1F_EventScript_Nurse,
        "Route4_PokemonCenter_1F_EventScript_MagikarpSalesman" to
            Route4_PokemonCenter_1F_EventScript_MagikarpSalesman,
        "Route4_PokemonCenter_1F_EventScript_Gentleman" to
            Route4_PokemonCenter_1F_EventScript_Gentleman,
        "Route4_PokemonCenter_1F_EventScript_Boy" to Route4_PokemonCenter_1F_EventScript_Boy,
        "Route4_PokemonCenter_1F_EventScript_Youngster" to
            Route4_PokemonCenter_1F_EventScript_Youngster,
        "Route4_PokemonCenter_1F_EventScript_Newspaper" to
            Route4_PokemonCenter_1F_EventScript_Newspaper,
        "Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpMale" to
            Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpMale,
        "Route4_PokemonCenter_1F_EventScript_AlreadyBoughtMagikarp" to
            Route4_PokemonCenter_1F_EventScript_AlreadyBoughtMagikarp,
        "Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpFemale" to
            Route4_PokemonCenter_1F_EventScript_AskBuyMagikarpFemale,
        "Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp" to
            Route4_PokemonCenter_1F_EventScript_TryBuyMagikarp,
        "Route4_PokemonCenter_1F_EventScript_DeclineMagikarp" to
            Route4_PokemonCenter_1F_EventScript_DeclineMagikarp,
        "Route4_PokemonCenter_1F_EventScript_NotEnoughMoney" to
            Route4_PokemonCenter_1F_EventScript_NotEnoughMoney,
        "Route4_PokemonCenter_1F_EventScript_NoRoomForMagikarp" to
            Route4_PokemonCenter_1F_EventScript_NoRoomForMagikarp,
        "Route4_PokemonCenter_1F_EventScript_BuyMagikarpPC" to
            Route4_PokemonCenter_1F_EventScript_BuyMagikarpPC,
        "Route4_PokemonCenter_1F_EventScript_BuyMagikarpParty" to
            Route4_PokemonCenter_1F_EventScript_BuyMagikarpParty,
        "Route4_PokemonCenter_1F_EventScript_PayForMagikarp" to
            Route4_PokemonCenter_1F_EventScript_PayForMagikarp,
        "Route4_PokemonCenter_1F_EventScript_BoughtMagikarp" to
            Route4_PokemonCenter_1F_EventScript_BoughtMagikarp,
        "Route4_PokemonCenter_1F_EventScript_TransferMagikarpCloseMoneyBox" to
            Route4_PokemonCenter_1F_EventScript_TransferMagikarpCloseMoneyBox,
        "Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp" to
            Route4_PokemonCenter_1F_EventScript_EndPurchaseMagikarp,
        "Route4_PokemonCenter_1F_EventScript_TransferMagikarp" to
            Route4_PokemonCenter_1F_EventScript_TransferMagikarp,
    )
