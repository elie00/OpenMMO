package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

internal object VermilionCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VermilionCity.GrimerMultipliesInSludge)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_VERMILION_CITY, 3, VermilionCity_EventScript_OldMan1SSAnneLeft
 * msgbox VermilionCity_Text_DidYouSeeSSAnneInHarbor
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_OldMan1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_VERMILION_CITY) == 3)
        return VermilionCity_EventScript_OldMan1SSAnneLeft.run(ctx)
    ctx.say(VermilionCity.DidYouSeeSSAnneInHarbor)
  }
}

internal object VermilionCity_EventScript_OldMan2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VermilionCity.BuildingOnThisLand)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_MACHOP, CRY_MODE_NORMAL
 * msgbox VermilionCity_Text_Machop
 * waitmoncry
 * msgbox VermilionCity_Text_MachopStompingLandFlat
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_Machop : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_EventScript_Machop")
}

internal object VermilionCity_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VermilionCity.SSAnneVisitsOnceAYear)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_VERMILION_CITY, 3, VermilionCity_EventScript_CheckSeagallopPresent
 * msgbox VermilionCity_Text_WelcomeToTheSSAnne
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_FerrySailor : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_VERMILION_CITY) == 3)
        return VermilionCity_EventScript_CheckSeagallopPresent.run(ctx)
    ctx.say(VermilionCity.WelcomeToTheSSAnne)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setflag FLAG_TALKED_TO_OAKS_AIDE_IN_VERMILION
 * msgbox VermilionCity_Text_Route2AideHasPackageForYou
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_OaksAide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_TALKED_TO_OAKS_AIDE_IN_VERMILION)
    ctx.say(VermilionCity.Route2AideHasPackageForYou)
  }
}

internal object VermilionCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.CitySign)
}

internal object VermilionCity_EventScript_PokemonFanClubSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.PokemonFanClubSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_LTSURGE, 0
 * msgbox VermilionCity_Text_GymSign
 * releaseall
 * end
 * ```
 */
internal object VermilionCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_EventScript_GymSign")
}

internal object VermilionCity_EventScript_HarborSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.VermilionHarbor)
}

internal object VermilionCity_EventScript_SnorlaxNotice : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.SnorlaxBlockingRoute12)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_Text_SSAnneHasDepartedForYear
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_OldMan1SSAnneLeft : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity.SSAnneHasDepartedForYear)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, SEAGALLOP_VERMILION_CITY
 * goto_if_ge VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 5, VermilionCity_EventScript_ChooseSeagallopDestRainbowPass
 * goto_if_ge VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 1, VermilionCity_EventScript_ChooseSeagallopDestTriPass
 * msgbox VermilionCity_Text_TheShipSetSail
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_CheckSeagallopPresent : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_CheckSeagallopPresent")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * call VermilionCity_EventScript_CheckHasMysticTicket
 * goto_if_eq VAR_RESULT, TRUE, VermilionCity_EventScript_HasMysticTicket
 * call VermilionCity_EventScript_CheckHasAuroraTicket
 * goto_if_eq VAR_RESULT, TRUE, VermilionCity_EventScript_HasAuroraTicket
 * setvar VAR_0x8004, SEAGALLOP_VERMILION_CITY
 * message VermilionCity_Text_BoardSeagallopRainbowPass
 * waitmessage
 * goto EventScript_SeviiDestinationsPage1
 * end
 * ```
 */
internal object VermilionCity_EventScript_ChooseSeagallopDestRainbowPass : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_ChooseSeagallopDestRainbowPass")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message VermilionCity_Text_BoardSeagallopTriPass
 * waitmessage
 * setvar VAR_0x8004, SEAGALLOP_VERMILION_CITY
 * multichoice 19, 5, MULTICHOICE_SEAGALLOP_123, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToOneIsland2
 * case 1, EventScript_SailToTwoIsland2
 * case 2, EventScript_SailToThreeIsland2
 * case 3, EventScript_CancelSail
 * case 127, EventScript_CancelSail
 * end
 * ```
 */
internal object VermilionCity_EventScript_ChooseSeagallopDestTriPass : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_ChooseSeagallopDestTriPass")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_ENABLE_SHIP_BIRTH_ISLAND, EventScript_SetResultFalse
 * checkitem ITEM_AURORA_TICKET
 * goto_if_eq VAR_RESULT, FALSE, EventScript_SetResultFalse
 * goto EventScript_SetResultTrue
 * end
 * ```
 */
internal object VermilionCity_EventScript_CheckHasAuroraTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_CheckHasAuroraTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_ENABLE_SHIP_NAVEL_ROCK, EventScript_SetResultFalse
 * checkitem ITEM_MYSTIC_TICKET
 * goto_if_eq VAR_RESULT, FALSE, EventScript_SetResultFalse
 * goto EventScript_SetResultTrue
 * end
 * ```
 */
internal object VermilionCity_EventScript_CheckHasMysticTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_CheckHasMysticTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_unset FLAG_SHOWN_AURORA_TICKET, VermilionCity_EventScript_ShowAuroraTicket
 * message VermilionCity_Text_BoardSeagallopFerry
 * waitmessage
 * multichoice 13, 6, MULTICHOICE_SEVII_BIRTH, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SeviiDestinationsPage1
 * case 1, EventScript_SailToBirthIsland
 * case 2, EventScript_CancelSail
 * case 127, EventScript_CancelSail
 * end
 * ```
 */
internal object VermilionCity_EventScript_HasAuroraTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_HasAuroraTicket")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call VermilionCity_EventScript_CheckHasAuroraTicket
 * goto_if_eq VAR_RESULT, TRUE, VermilionCity_EventScript_HasMysticAndAuroraTickets
 * call_if_unset FLAG_SHOWN_MYSTIC_TICKET, VermilionCity_EventScript_ShowMysticTicket
 * message VermilionCity_Text_BoardSeagallopFerry
 * waitmessage
 * multichoice 17, 6, MULTICHOICE_SEVII_NAVEL, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SeviiDestinationsPage1
 * case 1, EventScript_SailToNavelRock
 * case 2, EventScript_CancelSail
 * case 127, EventScript_CancelSail
 * end
 * ```
 */
internal object VermilionCity_EventScript_HasMysticTicket : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_HasMysticTicket")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_SHOWN_AURORA_TICKET
 * msgbox VermilionCity_Text_OhAuroraTicketTakeYouToBirthIsland
 * return
 * ```
 */
internal object VermilionCity_EventScript_ShowAuroraTicket : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_SHOWN_AURORA_TICKET)
    ctx.say(VermilionCity.OhAuroraTicketTakeYouToBirthIsland)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_SHOWN_MYSTIC_TICKET
 * msgbox VermilionCity_Text_OhMysticTicketTakeYouToNavelRock
 * return
 * ```
 */
internal object VermilionCity_EventScript_ShowMysticTicket : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_SHOWN_MYSTIC_TICKET)
    ctx.say(VermilionCity.OhMysticTicketTakeYouToNavelRock)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_unset FLAG_SHOWN_MYSTIC_TICKET, VermilionCity_EventScript_ShowMysticTicket
 * call_if_unset FLAG_SHOWN_AURORA_TICKET, VermilionCity_EventScript_ShowAuroraTicket
 * message VermilionCity_Text_BoardSeagallopFerry
 * waitmessage
 * multichoice 13, 5, MULTICHOICE_SEVII_NAVEL_BIRTH, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SeviiDestinationsPage1
 * case 1, EventScript_SailToNavelRock
 * case 2, EventScript_SailToBirthIsland
 * case 3, EventScript_CancelSail
 * case 127, EventScript_CancelSail
 * end
 * ```
 */
internal object VermilionCity_EventScript_HasMysticAndAuroraTickets : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_HasMysticAndAuroraTickets")
}

internal val VermilionCityScripts: Map<String, Script> =
    mapOf(
        "VermilionCity_EventScript_Woman" to VermilionCity_EventScript_Woman,
        "VermilionCity_EventScript_OldMan1" to VermilionCity_EventScript_OldMan1,
        "VermilionCity_EventScript_OldMan2" to VermilionCity_EventScript_OldMan2,
        "VermilionCity_EventScript_Machop" to VermilionCity_EventScript_Machop,
        "VermilionCity_EventScript_Sailor" to VermilionCity_EventScript_Sailor,
        "VermilionCity_EventScript_FerrySailor" to VermilionCity_EventScript_FerrySailor,
        "VermilionCity_EventScript_OaksAide" to VermilionCity_EventScript_OaksAide,
        "VermilionCity_EventScript_CitySign" to VermilionCity_EventScript_CitySign,
        "VermilionCity_EventScript_PokemonFanClubSign" to
            VermilionCity_EventScript_PokemonFanClubSign,
        "VermilionCity_EventScript_GymSign" to VermilionCity_EventScript_GymSign,
        "VermilionCity_EventScript_HarborSign" to VermilionCity_EventScript_HarborSign,
        "VermilionCity_EventScript_SnorlaxNotice" to VermilionCity_EventScript_SnorlaxNotice,
        "VermilionCity_EventScript_OldMan1SSAnneLeft" to
            VermilionCity_EventScript_OldMan1SSAnneLeft,
        "VermilionCity_EventScript_CheckSeagallopPresent" to
            VermilionCity_EventScript_CheckSeagallopPresent,
        "VermilionCity_EventScript_ChooseSeagallopDestRainbowPass" to
            VermilionCity_EventScript_ChooseSeagallopDestRainbowPass,
        "VermilionCity_EventScript_ChooseSeagallopDestTriPass" to
            VermilionCity_EventScript_ChooseSeagallopDestTriPass,
        "VermilionCity_EventScript_CheckHasAuroraTicket" to
            VermilionCity_EventScript_CheckHasAuroraTicket,
        "VermilionCity_EventScript_CheckHasMysticTicket" to
            VermilionCity_EventScript_CheckHasMysticTicket,
        "VermilionCity_EventScript_HasAuroraTicket" to VermilionCity_EventScript_HasAuroraTicket,
        "VermilionCity_EventScript_HasMysticTicket" to VermilionCity_EventScript_HasMysticTicket,
        "VermilionCity_EventScript_ShowAuroraTicket" to VermilionCity_EventScript_ShowAuroraTicket,
        "VermilionCity_EventScript_ShowMysticTicket" to VermilionCity_EventScript_ShowMysticTicket,
        "VermilionCity_EventScript_HasMysticAndAuroraTickets" to
            VermilionCity_EventScript_HasMysticAndAuroraTickets,
    )
