package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message Text_WhereDoYouWantToSail
 * waitmessage
 * setvar VAR_0x8004, SEAGALLOP_FIVE_ISLAND
 * goto EventScript_ChooseDestFromIsland
 * end
 * ```
 */
internal object FiveIsland_Harbor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FiveIsland_Harbor_EventScript_Sailor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_ge VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 5, EventScript_SeviiDestinationsPage1
 * goto_if_ge VAR_MAP_SCENE_CINNABAR_ISLAND, 4, EventScript_ChooseDestFromIslandVermilionAllowed
 * multichoice 19, 6, MULTICHOICE_ISLAND_12, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToOneIsland2
 * case 1, EventScript_SailToTwoIsland2
 * case 2, EventScript_CancelSail
 * case SCR_MENU_CANCEL, EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_ChooseDestFromIsland : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_ChooseDestFromIsland")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8005, 0
 * special DrawSeagallopDestinationMenu
 * waitstate
 * specialvar VAR_0x8006, GetSelectedSeagallopDestination
 * switch VAR_0x8006
 * case SEAGALLOP_VERMILION_CITY, EventScript_SailToVermilionCity
 * case SEAGALLOP_ONE_ISLAND,     EventScript_SailToOneIsland
 * case SEAGALLOP_TWO_ISLAND,     EventScript_SailToTwoIsland
 * case SEAGALLOP_THREE_ISLAND,   EventScript_SailToThreeIsland
 * case SEAGALLOP_FOUR_ISLAND,    EventScript_SailToFourIsland
 * case SEAGALLOP_MORE,           EventScript_SeviiDestinationsPage2
 * case SCR_MENU_CANCEL,          EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_SeviiDestinationsPage1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SeviiDestinationsPage1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 19, 5, MULTICHOICE_SEAGALLOP_V12, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToVermilion2
 * case 1, EventScript_SailToOneIsland2
 * case 2, EventScript_SailToTwoIsland2
 * case 3, EventScript_CancelSail
 * case SCR_MENU_CANCEL, EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_ChooseDestFromIslandVermilionAllowed : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_ChooseDestFromIslandVermilionAllowed")
}

internal val FiveIsland_HarborScripts: Map<String, Script> =
    mapOf(
        "FiveIsland_Harbor_EventScript_Sailor" to FiveIsland_Harbor_EventScript_Sailor,
        "EventScript_ChooseDestFromIsland" to EventScript_ChooseDestFromIsland,
        "EventScript_SeviiDestinationsPage1" to EventScript_SeviiDestinationsPage1,
        "EventScript_ChooseDestFromIslandVermilionAllowed" to
            EventScript_ChooseDestFromIslandVermilionAllowed,
    )
