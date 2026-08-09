package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_DepartmentStore_Roof
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object CeladonCity_DepartmentStore_Roof_EventScript_CooltrainerM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_DepartmentStore_Roof.MySisterIsImmature)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * call CeladonCity_DepartmentStore_Roof_EventScript_CheckPlayerHasDrinks
 * goto_if_eq VAR_TEMP_1, 0, CeladonCity_DepartmentStore_Roof_EventScript_IWantDrink
 * goto CeladonCity_DepartmentStore_Roof_EventScript_AskGiveDrink
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_ThirstyGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_ThirstyGirl")
}

internal object CeladonCity_DepartmentStore_Roof_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CeladonCity_DepartmentStore_Roof.FloorSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * message CeladonCity_DepartmentStore_Roof_Text_VendingMachineWhatDoesItHave
 * waitmessage
 * showmoneybox 0, 0
 * goto CeladonCity_DepartmentStore_Roof_EventScript_ChooseDrink
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_VendingMachine : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_VendingMachine")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeladonCity_DepartmentStore_Roof_Text_ImThirstyGiveHerDrink, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CeladonCity_DepartmentStore_Roof_EventScript_DontGiveDrink
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * message CeladonCity_DepartmentStore_Roof_Text_GiveWhichDrink
 * waitmessage
 * textcolor NPC_TEXT_COLOR_FEMALE
 * switch VAR_TEMP_1
 * case 1, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveFreshWater
 * case 2, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveSodaPop
 * case 3, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveFreshWaterSodaPop
 * case 4, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveLemonade
 * case 5, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveFreshWaterLemonade
 * case 6, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveSodaPopLemonade
 * case 7, CeladonCity_DepartmentStore_Roof_EventScript_AskGiveAllDrinks
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_AskGiveDrink : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_AskGiveDrink")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_DepartmentStore_Roof_Text_ImThirstyIWantDrink
 * release
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_IWantDrink : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_DepartmentStore_Roof.ImThirstyIWantDrink)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_TEMP_1, 0
 * checkitem ITEM_FRESH_WATER
 * call_if_eq VAR_RESULT, TRUE, CeladonCity_DepartmentStore_Roof_EventScript_SetHasFreshWater
 * checkitem ITEM_SODA_POP
 * call_if_eq VAR_RESULT, TRUE, CeladonCity_DepartmentStore_Roof_EventScript_SetHasSodaPop
 * checkitem ITEM_LEMONADE
 * call_if_eq VAR_RESULT, TRUE, CeladonCity_DepartmentStore_Roof_EventScript_SetHasLemonade
 * return
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_CheckPlayerHasDrinks : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_CheckPlayerHasDrinks")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 12, 0, MULTICHOICE_CELADON_VENDING_MACHINE, FALSE
 * copyvar VAR_TEMP_1, VAR_RESULT
 * switch VAR_TEMP_1
 * case 0, CeladonCity_DepartmentStore_Roof_EventScript_BuyFreshWater
 * case 1, CeladonCity_DepartmentStore_Roof_EventScript_BuySodaPop
 * case 2, CeladonCity_DepartmentStore_Roof_EventScript_BuyLemonade
 * msgbox CeladonCity_DepartmentStore_Roof_Text_NotThirsty
 * goto CeladonCity_DepartmentStore_Roof_EventScript_ExitVendingMachine
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_ChooseDrink : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_ChooseDrink")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_DontGiveDrink : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_DontGiveDrink")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 4
 * return
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_SetHasLemonade : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_SetHasLemonade")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 1
 * return
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_SetHasFreshWater : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_SetHasFreshWater")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemoneybox
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_ExitVendingMachine : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_ExitVendingMachine")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * addvar VAR_TEMP_1, 2
 * return
 * ```
 */
internal object CeladonCity_DepartmentStore_Roof_EventScript_SetHasSodaPop : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_DepartmentStore_Roof_EventScript_SetHasSodaPop")
}

internal val CeladonCity_DepartmentStore_RoofScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_DepartmentStore_Roof_EventScript_CooltrainerM" to
            CeladonCity_DepartmentStore_Roof_EventScript_CooltrainerM,
        "CeladonCity_DepartmentStore_Roof_EventScript_ThirstyGirl" to
            CeladonCity_DepartmentStore_Roof_EventScript_ThirstyGirl,
        "CeladonCity_DepartmentStore_Roof_EventScript_FloorSign" to
            CeladonCity_DepartmentStore_Roof_EventScript_FloorSign,
        "CeladonCity_DepartmentStore_Roof_EventScript_VendingMachine" to
            CeladonCity_DepartmentStore_Roof_EventScript_VendingMachine,
        "CeladonCity_DepartmentStore_Roof_EventScript_AskGiveDrink" to
            CeladonCity_DepartmentStore_Roof_EventScript_AskGiveDrink,
        "CeladonCity_DepartmentStore_Roof_EventScript_IWantDrink" to
            CeladonCity_DepartmentStore_Roof_EventScript_IWantDrink,
        "CeladonCity_DepartmentStore_Roof_EventScript_CheckPlayerHasDrinks" to
            CeladonCity_DepartmentStore_Roof_EventScript_CheckPlayerHasDrinks,
        "CeladonCity_DepartmentStore_Roof_EventScript_ChooseDrink" to
            CeladonCity_DepartmentStore_Roof_EventScript_ChooseDrink,
        "CeladonCity_DepartmentStore_Roof_EventScript_DontGiveDrink" to
            CeladonCity_DepartmentStore_Roof_EventScript_DontGiveDrink,
        "CeladonCity_DepartmentStore_Roof_EventScript_SetHasLemonade" to
            CeladonCity_DepartmentStore_Roof_EventScript_SetHasLemonade,
        "CeladonCity_DepartmentStore_Roof_EventScript_SetHasFreshWater" to
            CeladonCity_DepartmentStore_Roof_EventScript_SetHasFreshWater,
        "CeladonCity_DepartmentStore_Roof_EventScript_ExitVendingMachine" to
            CeladonCity_DepartmentStore_Roof_EventScript_ExitVendingMachine,
        "CeladonCity_DepartmentStore_Roof_EventScript_SetHasSodaPop" to
            CeladonCity_DepartmentStore_Roof_EventScript_SetHasSodaPop,
    )
