package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route104_PrettyPetalFlowerShop
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TEMP_1, Route104_PrettyPetalFlowerShop_EventScript_SellDecorations
 * msgbox Route104_PrettyPetalFlowerShop_Text_ThisIsPrettyPetalFlowerShop, MSGBOX_DEFAULT
 * goto_if_set FLAG_MET_PRETTY_PETAL_SHOP_OWNER, Route104_PrettyPetalFlowerShop_EventScript_AlreadyMet
 * setflag FLAG_MET_PRETTY_PETAL_SHOP_OWNER
 * msgbox Route104_PrettyPetalFlowerShop_Text_IntroLearnAboutBerries, MSGBOX_YESNO
 * call_if_eq VAR_RESULT, YES, Route104_PrettyPetalFlowerShop_EventScript_ExplainBerries
 * call_if_eq VAR_RESULT, NO, Route104_PrettyPetalFlowerShop_EventScript_DontExplainBerries
 * release
 * end
 * ```
 */
internal object Route104_PrettyPetalFlowerShop_EventScript_ShopOwner : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_PrettyPetalFlowerShop_EventScript_ShopOwner")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_RECEIVED_WAILMER_PAIL, Route104_PrettyPetalFlowerShop_EventScript_GiveWailmerPail
 * msgbox Route104_PrettyPetalFlowerShop_Text_WailmerPailExplanation, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_PrettyPetalFlowerShop_EventScript_WailmerPailGirl : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_WAILMER_PAIL))
        return Route104_PrettyPetalFlowerShop_EventScript_GiveWailmerPail.run(ctx)
    ctx.say(Route104_PrettyPetalFlowerShop.WailmerPailExplanation)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * goto_if_set FLAG_DAILY_FLOWER_SHOP_RECEIVED_BERRY, Route104_PrettyPetalFlowerShop_EventScript_AlreadyReceivedBerry
 * msgbox Route104_PrettyPetalFlowerShop_Text_ImGrowingFlowers, MSGBOX_DEFAULT
 * random 8
 * addvar VAR_RESULT, FIRST_BERRY_INDEX
 * giveitem VAR_RESULT
 * goto_if_eq VAR_RESULT, 0, Common_EventScript_ShowBagIsFull
 * setflag FLAG_DAILY_FLOWER_SHOP_RECEIVED_BERRY
 * msgbox Route104_PrettyPetalFlowerShop_Text_MachineMixesBerries, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_PrettyPetalFlowerShop_EventScript_RandomBerryGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_PrettyPetalFlowerShop_EventScript_RandomBerryGirl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_PrettyPetalFlowerShop_Text_YouCanHaveThis, MSGBOX_DEFAULT
 * giveitem ITEM_WAILMER_PAIL
 * msgbox Route104_PrettyPetalFlowerShop_Text_WailmerPailExplanation, MSGBOX_DEFAULT
 * setflag FLAG_RECEIVED_WAILMER_PAIL
 * release
 * end
 * ```
 */
internal object Route104_PrettyPetalFlowerShop_EventScript_GiveWailmerPail : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_PrettyPetalFlowerShop_EventScript_GiveWailmerPail")
}

internal val Route104_PrettyPetalFlowerShopScripts: Map<String, Script> =
    mapOf(
        "Route104_PrettyPetalFlowerShop_EventScript_ShopOwner" to
            Route104_PrettyPetalFlowerShop_EventScript_ShopOwner,
        "Route104_PrettyPetalFlowerShop_EventScript_WailmerPailGirl" to
            Route104_PrettyPetalFlowerShop_EventScript_WailmerPailGirl,
        "Route104_PrettyPetalFlowerShop_EventScript_RandomBerryGirl" to
            Route104_PrettyPetalFlowerShop_EventScript_RandomBerryGirl,
        "Route104_PrettyPetalFlowerShop_EventScript_GiveWailmerPail" to
            Route104_PrettyPetalFlowerShop_EventScript_GiveWailmerPail,
    )
