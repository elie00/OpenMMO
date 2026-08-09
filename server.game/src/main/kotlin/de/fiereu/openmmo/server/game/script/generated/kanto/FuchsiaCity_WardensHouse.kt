package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity_WardensHouse
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_HM04, FuchsiaCity_WardensHouse_EventScript_ExplainStrength
 * goto_if_set FLAG_HIDE_SAFARI_ZONE_WEST_GOLD_TEETH, FuchsiaCity_WardensHouse_EventScript_GiveGoldTeeth
 * msgbox FuchsiaCity_WardensHouse_Text_HifFuffHefifoo, MSGBOX_YESNO
 * call_if_eq VAR_RESULT, YES, FuchsiaCity_WardensHouse_EventScript_WardenYes
 * call_if_eq VAR_RESULT, NO, FuchsiaCity_WardensHouse_EventScript_WardenNo
 * release
 * end
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_Warden : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_WardensHouse_EventScript_Warden")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.RARE_CANDY, KantoFlags.FLAG_HIDE_FUCHSIA_CITY_WARDENS_HOUSE_RARE_CANDY, 2)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_KOGA, 4
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PokemonJournal_Text_SpecialFeatureKoga
 * release
 * end
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_PokemonJournalKoga : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_WardensHouse_EventScript_PokemonJournalKoga")
}

internal object FuchsiaCity_WardensHouse_EventScript_DisplaySign2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(FuchsiaCity_WardensHouse.OldMonMerchandiseOnDisplay)
}

internal object FuchsiaCity_WardensHouse_EventScript_DisplaySign1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(FuchsiaCity_WardensHouse.MonPhotosFossilsOnDisplay)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_WardensHouse_Text_ExplainStrength
 * release
 * end
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_ExplainStrength : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_WardensHouse.ExplainStrength)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_WardensHouse_Text_AhHowheeHoHoo
 * return
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_WardenYes : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_WardensHouse.AhHowheeHoHoo)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_WardensHouse_Text_HeOhayHeHaHoo
 * return
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_WardenNo : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_WardensHouse.HeOhayHeHaHoo)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_TMHM
 * message FuchsiaCity_WardensHouse_Text_GaveGoldTeethToWarden
 * waitmessage
 * waitfanfare
 * msgbox FuchsiaCity_WardensHouse_Text_WardenPoppedInHisTeeth
 * call EventScript_RestorePrevTextColor
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, FuchsiaCity_WardensHouse_EventScript_WardenThanksMale
 * call_if_eq VAR_RESULT, FEMALE, FuchsiaCity_WardensHouse_EventScript_WardenThanksFemale
 * giveitem_msg FuchsiaCity_WardensHouse_Text_ReceivedHM04FromWarden, ITEM_HM04
 * setflag FLAG_GOT_HM04
 * removeitem ITEM_GOLD_TEETH
 * release
 * end
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_GiveGoldTeeth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_WardensHouse_EventScript_GiveGoldTeeth")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_WardensHouse_Text_ThanksLassieGiveYouSomething
 * return
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_WardenThanksFemale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_WardensHouse.ThanksLassieGiveYouSomething)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_WardensHouse_Text_ThanksSonGiveYouSomething
 * return
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_WardenThanksMale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_WardensHouse.ThanksSonGiveYouSomething)
  }
}

internal val FuchsiaCity_WardensHouseScripts: Map<String, Script> =
    mapOf(
        "FuchsiaCity_WardensHouse_EventScript_Warden" to
            FuchsiaCity_WardensHouse_EventScript_Warden,
        "FuchsiaCity_WardensHouse_EventScript_ItemRareCandy" to
            FuchsiaCity_WardensHouse_EventScript_ItemRareCandy,
        "FuchsiaCity_WardensHouse_EventScript_PokemonJournalKoga" to
            FuchsiaCity_WardensHouse_EventScript_PokemonJournalKoga,
        "FuchsiaCity_WardensHouse_EventScript_DisplaySign2" to
            FuchsiaCity_WardensHouse_EventScript_DisplaySign2,
        "FuchsiaCity_WardensHouse_EventScript_DisplaySign1" to
            FuchsiaCity_WardensHouse_EventScript_DisplaySign1,
        "FuchsiaCity_WardensHouse_EventScript_ExplainStrength" to
            FuchsiaCity_WardensHouse_EventScript_ExplainStrength,
        "FuchsiaCity_WardensHouse_EventScript_WardenYes" to
            FuchsiaCity_WardensHouse_EventScript_WardenYes,
        "FuchsiaCity_WardensHouse_EventScript_WardenNo" to
            FuchsiaCity_WardensHouse_EventScript_WardenNo,
        "FuchsiaCity_WardensHouse_EventScript_GiveGoldTeeth" to
            FuchsiaCity_WardensHouse_EventScript_GiveGoldTeeth,
        "FuchsiaCity_WardensHouse_EventScript_WardenThanksFemale" to
            FuchsiaCity_WardensHouse_EventScript_WardenThanksFemale,
        "FuchsiaCity_WardensHouse_EventScript_WardenThanksMale" to
            FuchsiaCity_WardensHouse_EventScript_WardenThanksMale,
    )
