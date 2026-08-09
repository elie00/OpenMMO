package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_House1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_POWDER_JAR, CeruleanCity_House5_EventScript_AskToExchangePowder
 * msgbox CeruleanCity_House1_Text_AnyInterestInBerries, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CeruleanCity_House5_EventScript_NoInterestInBerries
 * goto_if_unset FLAG_SYS_GOT_BERRY_POUCH, CeruleanCity_House5_EventScript_NoBerries
 * msgbox CeruleanCity_House1_Text_HaveJustTheThing
 * setflag FLAG_GOT_POWDER_JAR
 * giveitem ITEM_POWDER_JAR
 * goto_if_eq VAR_RESULT, FALSE, EventScript_BagIsFull
 * msgbox CeruleanCity_House1_Text_GoCrushBerriesAtDirectCorner
 * release
 * end
 * ```
 */
internal object CeruleanCity_House5_EventScript_BerryPowderMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House5_EventScript_BerryPowderMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_questlog EventScript_ReleaseEnd
 * special ShowBerryCrushRankings
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object CeruleanCity_House5_EventScript_BerryCrushRankings : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House5_EventScript_BerryCrushRankings")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DisplayBerryPowderVendorMenu
 * msgbox CeruleanCity_House1_Text_HaveYouBroughtBerryPowder
 * goto CeruleanCity_House5_EventScript_ChooseExchangeItem
 * end
 * ```
 */
internal object CeruleanCity_House5_EventScript_AskToExchangePowder : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House5_EventScript_AskToExchangePowder")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_House1_Text_TakeInterestInAllSortsOfThings
 * release
 * end
 * ```
 */
internal object CeruleanCity_House5_EventScript_NoInterestInBerries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity_House1.TakeInterestInAllSortsOfThings)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_House1_Text_WhyMustYouLieNoBerries
 * release
 * end
 * ```
 */
internal object CeruleanCity_House5_EventScript_NoBerries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity_House1.WhyMustYouLieNoBerries)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message CeruleanCity_House5_Text_ExchangeWithWhat
 * waitmessage
 * setvar VAR_0x8004, LISTMENU_BERRY_POWDER
 * special ListMenu
 * waitstate
 * switch VAR_RESULT
 * case 0, CeruleanCity_House5_EventScript_EnergyPowder
 * case 1, CeruleanCity_House5_EventScript_EnergyRoot
 * case 2, CeruleanCity_House5_EventScript_HealPowder
 * case 3, CeruleanCity_House5_EventScript_RevivalHerb
 * case 4, CeruleanCity_House5_EventScript_Protein
 * case 5, CeruleanCity_House5_EventScript_Iron
 * case 6, CeruleanCity_House5_EventScript_Carbos
 * case 7, CeruleanCity_House5_EventScript_Calcium
 * case 8, CeruleanCity_House5_EventScript_Zinc
 * case 9, CeruleanCity_House5_EventScript_HPUp
 * case 10, CeruleanCity_House5_EventScript_PPUp
 * case 11, CeruleanCity_House5_EventScript_ExitMenu
 * case 127, CeruleanCity_House5_EventScript_ExitMenu
 * end
 * ```
 */
internal object CeruleanCity_House5_EventScript_ChooseExchangeItem : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House5_EventScript_ChooseExchangeItem")
}

internal val CeruleanCity_House5Scripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_House5_EventScript_BerryPowderMan" to
            CeruleanCity_House5_EventScript_BerryPowderMan,
        "CeruleanCity_House5_EventScript_BerryCrushRankings" to
            CeruleanCity_House5_EventScript_BerryCrushRankings,
        "CeruleanCity_House5_EventScript_AskToExchangePowder" to
            CeruleanCity_House5_EventScript_AskToExchangePowder,
        "CeruleanCity_House5_EventScript_NoInterestInBerries" to
            CeruleanCity_House5_EventScript_NoInterestInBerries,
        "CeruleanCity_House5_EventScript_NoBerries" to CeruleanCity_House5_EventScript_NoBerries,
        "CeruleanCity_House5_EventScript_ChooseExchangeItem" to
            CeruleanCity_House5_EventScript_ChooseExchangeItem,
    )
