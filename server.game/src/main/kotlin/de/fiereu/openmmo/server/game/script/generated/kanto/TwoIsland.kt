package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.TwoIsland
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND, 4, TwoIsland_EventScript_ClerkShopExpanded3
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND, 3, TwoIsland_EventScript_ClerkShopExpanded2
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND, 2, TwoIsland_EventScript_ClerkShopExpanded1
 * goto TwoIsland_EventScript_ClerkShopInitial
 * end
 * ```
 */
internal object TwoIsland_EventScript_Clerk : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_EventScript_Clerk")
}

internal object TwoIsland_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(TwoIsland.ShopkeepersBrotherWorksGameCorner)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_BRUNO, 4
 * msgbox TwoIsland_Text_BrunoCameToIslandWhileBack
 * release
 * end
 * ```
 */
internal object TwoIsland_EventScript_Beauty : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_EventScript_Beauty")
}

internal object TwoIsland_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(TwoIsland.FellowMovedFromCeladonCity)
}

internal object TwoIsland_EventScript_PokeManiac : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(TwoIsland.BuyRareItemsHere)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVE
 * end
 * ```
 */
internal object TwoIsland_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVE, KantoFlags.FLAG_HIDE_TWO_ISLAND_REVIVE, 6)
  }
}

internal object TwoIsland_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(TwoIsland.HaveYouTriedJumpingGame)
}

internal object TwoIsland_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(TwoIsland.OldWomanLivesOutOnCape)
}

internal object TwoIsland_EventScript_IslandSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(TwoIsland.IslandSign)
}

internal object TwoIsland_EventScript_JoyfulGameCornerSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(TwoIsland.JoyfulGameCornerSign)
}

internal object TwoIsland_EventScript_FastCurrentSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(TwoIsland.DangerFastCurrent)
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_TWO_ISLAND_SHOP_INTRODUCED, TwoIsland_EventScript_ClerkShopSkipIntro
 * setflag FLAG_TWO_ISLAND_SHOP_INTRODUCED
 * message TwoIsland_Text_WelcomeToShopMerchandiseLimited
 * waitmessage
 * goto TwoIsland_EventScript_ShopInitial
 * end
 * ```
 */
internal object TwoIsland_EventScript_ClerkShopInitial : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_TWO_ISLAND_SHOP_INTRODUCED))
        return TwoIsland_EventScript_ClerkShopSkipIntro.run(ctx)
    ctx.setFlag(KantoFlags.FLAG_TWO_ISLAND_SHOP_INTRODUCED)
    ctx.say(TwoIsland.WelcomeToShopMerchandiseLimited)
    return TwoIsland_EventScript_ShopInitial.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_TWO_ISLAND_SHOP_EXPANDED_2, TwoIsland_EventScript_ClerkShopSkipIntro
 * setflag FLAG_TWO_ISLAND_SHOP_EXPANDED_2
 * message TwoIsland_Text_HopeYouGiveItYourBest
 * waitmessage
 * goto TwoIsland_EventScript_ShopExpanded2
 * end
 * ```
 */
internal object TwoIsland_EventScript_ClerkShopExpanded2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_TWO_ISLAND_SHOP_EXPANDED_2))
        return TwoIsland_EventScript_ClerkShopSkipIntro.run(ctx)
    ctx.setFlag(KantoFlags.FLAG_TWO_ISLAND_SHOP_EXPANDED_2)
    ctx.say(TwoIsland.HopeYouGiveItYourBest)
    return TwoIsland_EventScript_ShopExpanded2.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_TWO_ISLAND_SHOP_EXPANDED_3, TwoIsland_EventScript_ClerkShopSkipIntro
 * setflag FLAG_TWO_ISLAND_SHOP_EXPANDED_3
 * message TwoIsland_Text_BringingItemsFromDistantLands
 * waitmessage
 * goto TwoIsland_EventScript_ShopExpanded3
 * end
 * ```
 */
internal object TwoIsland_EventScript_ClerkShopExpanded3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_TWO_ISLAND_SHOP_EXPANDED_3))
        return TwoIsland_EventScript_ClerkShopSkipIntro.run(ctx)
    ctx.setFlag(KantoFlags.FLAG_TWO_ISLAND_SHOP_EXPANDED_3)
    ctx.say(TwoIsland.BringingItemsFromDistantLands)
    return TwoIsland_EventScript_ShopExpanded3.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_TWO_ISLAND_SHOP_EXPANDED_1, TwoIsland_EventScript_ClerkShopSkipIntro
 * setflag FLAG_TWO_ISLAND_SHOP_EXPANDED_1
 * message TwoIsland_Text_AddedMerchandiseForLostelle
 * waitmessage
 * goto TwoIsland_EventScript_ShopExpanded1
 * end
 * ```
 */
internal object TwoIsland_EventScript_ClerkShopExpanded1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_TWO_ISLAND_SHOP_EXPANDED_1))
        return TwoIsland_EventScript_ClerkShopSkipIntro.run(ctx)
    ctx.setFlag(KantoFlags.FLAG_TWO_ISLAND_SHOP_EXPANDED_1)
    ctx.say(TwoIsland.AddedMerchandiseForLostelle)
    return TwoIsland_EventScript_ShopExpanded1.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * pokemart TwoIsland_Items_ShopExpanded3
 * msgbox Text_PleaseComeAgain
 * release
 * end
 * ```
 */
internal object TwoIsland_EventScript_ShopExpanded3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_EventScript_ShopExpanded3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * pokemart TwoIsland_Items_ShopInitial
 * msgbox Text_PleaseComeAgain
 * release
 * end
 * ```
 */
internal object TwoIsland_EventScript_ShopInitial : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_EventScript_ShopInitial")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * pokemart TwoIsland_Items_ShopExpanded1
 * msgbox Text_PleaseComeAgain
 * release
 * end
 * ```
 */
internal object TwoIsland_EventScript_ShopExpanded1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_EventScript_ShopExpanded1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * pokemart TwoIsland_Items_ShopExpanded2
 * msgbox Text_PleaseComeAgain
 * release
 * end
 * ```
 */
internal object TwoIsland_EventScript_ShopExpanded2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_EventScript_ShopExpanded2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Text_MayIHelpYou
 * waitmessage
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND, 4, TwoIsland_EventScript_ShopExpanded3
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND, 3, TwoIsland_EventScript_ShopExpanded2
 * goto_if_eq VAR_MAP_SCENE_TWO_ISLAND, 2, TwoIsland_EventScript_ShopExpanded1
 * goto TwoIsland_EventScript_ShopInitial
 * end
 * ```
 */
internal object TwoIsland_EventScript_ClerkShopSkipIntro : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TwoIsland_EventScript_ClerkShopSkipIntro")
}

internal val TwoIslandScripts: Map<String, Script> =
    mapOf(
        "TwoIsland_EventScript_Clerk" to TwoIsland_EventScript_Clerk,
        "TwoIsland_EventScript_Woman" to TwoIsland_EventScript_Woman,
        "TwoIsland_EventScript_Beauty" to TwoIsland_EventScript_Beauty,
        "TwoIsland_EventScript_Sailor" to TwoIsland_EventScript_Sailor,
        "TwoIsland_EventScript_PokeManiac" to TwoIsland_EventScript_PokeManiac,
        "TwoIsland_EventScript_ItemRevive" to TwoIsland_EventScript_ItemRevive,
        "TwoIsland_EventScript_LittleBoy" to TwoIsland_EventScript_LittleBoy,
        "TwoIsland_EventScript_Boy" to TwoIsland_EventScript_Boy,
        "TwoIsland_EventScript_IslandSign" to TwoIsland_EventScript_IslandSign,
        "TwoIsland_EventScript_JoyfulGameCornerSign" to TwoIsland_EventScript_JoyfulGameCornerSign,
        "TwoIsland_EventScript_FastCurrentSign" to TwoIsland_EventScript_FastCurrentSign,
        "TwoIsland_EventScript_ClerkShopInitial" to TwoIsland_EventScript_ClerkShopInitial,
        "TwoIsland_EventScript_ClerkShopExpanded2" to TwoIsland_EventScript_ClerkShopExpanded2,
        "TwoIsland_EventScript_ClerkShopExpanded3" to TwoIsland_EventScript_ClerkShopExpanded3,
        "TwoIsland_EventScript_ClerkShopExpanded1" to TwoIsland_EventScript_ClerkShopExpanded1,
        "TwoIsland_EventScript_ShopExpanded3" to TwoIsland_EventScript_ShopExpanded3,
        "TwoIsland_EventScript_ShopInitial" to TwoIsland_EventScript_ShopInitial,
        "TwoIsland_EventScript_ShopExpanded1" to TwoIsland_EventScript_ShopExpanded1,
        "TwoIsland_EventScript_ShopExpanded2" to TwoIsland_EventScript_ShopExpanded2,
        "TwoIsland_EventScript_ClerkShopSkipIntro" to TwoIsland_EventScript_ClerkShopSkipIntro,
    )
