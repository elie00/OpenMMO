package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_BikeShop
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_BICYCLE, CeruleanCity_BikeShop_EventScript_AlreadyGotBicycle
 * goto_if_set FLAG_GOT_BIKE_VOUCHER, CeruleanCity_BikeShop_EventScript_ExchangeBikeVoucher
 * showmoneybox 0, 0
 * message CeruleanCity_BikeShop_Text_WelcomeToBikeShop
 * waitmessage
 * multichoice 11, 0, MULTICHOICE_BIKE_SHOP, FALSE
 * switch VAR_RESULT
 * case 0, CeruleanCity_BikeShop_EventScript_TryPurchaseBicycle
 * case 1, CeruleanCity_BikeShop_EventScript_ClerkGoodbye
 * case 127, CeruleanCity_BikeShop_EventScript_ClerkGoodbye
 * end
 * ```
 */
internal object CeruleanCity_BikeShop_EventScript_Clerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_BikeShop_EventScript_Clerk")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_BICYCLE, CeruleanCity_BikeShop_EventScript_YoungsterHaveBike
 * msgbox CeruleanCity_BikeShop_Text_BikesCoolButExpensive
 * release
 * end
 * ```
 */
internal object CeruleanCity_BikeShop_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_BICYCLE))
        return CeruleanCity_BikeShop_EventScript_YoungsterHaveBike.run(ctx)
    ctx.say(CeruleanCity_BikeShop.BikesCoolButExpensive)
  }
}

internal object CeruleanCity_BikeShop_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeruleanCity_BikeShop.CityBikeGoodEnoughForMe)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeruleanCity_BikeShop_Text_WowYourBikeIsCool
 * release
 * end
 * ```
 */
internal object CeruleanCity_BikeShop_EventScript_YoungsterHaveBike : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_BikeShop_EventScript_YoungsterHaveBike")
}

internal val CeruleanCity_BikeShopScripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_BikeShop_EventScript_Clerk" to CeruleanCity_BikeShop_EventScript_Clerk,
        "CeruleanCity_BikeShop_EventScript_Youngster" to
            CeruleanCity_BikeShop_EventScript_Youngster,
        "CeruleanCity_BikeShop_EventScript_Woman" to CeruleanCity_BikeShop_EventScript_Woman,
        "CeruleanCity_BikeShop_EventScript_YoungsterHaveBike" to
            CeruleanCity_BikeShop_EventScript_YoungsterHaveBike,
    )
