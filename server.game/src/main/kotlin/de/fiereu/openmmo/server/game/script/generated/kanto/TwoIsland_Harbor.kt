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
 * setvar VAR_0x8004, SEAGALLOP_TWO_ISLAND
 * goto EventScript_ChooseDestFromTwoIsland
 * end
 * ```
 */
internal object TwoIsland_Harbor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TwoIsland_Harbor_EventScript_Sailor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_ge VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 5, EventScript_SeviiDestinationsPage1
 * goto_if_ge VAR_MAP_SCENE_CINNABAR_ISLAND, 4, EventScript_ChooseDestFromTwoIslandVermilionAllowed
 * multichoice 19, 6, MULTICHOICE_ISLAND_13, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToOneIsland2
 * case 1, EventScript_SailToThreeIsland2
 * case 2, EventScript_CancelSail
 * case SCR_MENU_CANCEL, EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_ChooseDestFromTwoIsland : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_ChooseDestFromTwoIsland")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 19, 5, MULTICHOICE_SEAGALLOP_V13, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToVermilion2
 * case 1, EventScript_SailToOneIsland2
 * case 2, EventScript_SailToThreeIsland2
 * case 3, EventScript_CancelSail
 * case SCR_MENU_CANCEL, EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_ChooseDestFromTwoIslandVermilionAllowed : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_ChooseDestFromTwoIslandVermilionAllowed")
}

internal val TwoIsland_HarborScripts: Map<String, Script> =
    mapOf(
        "TwoIsland_Harbor_EventScript_Sailor" to TwoIsland_Harbor_EventScript_Sailor,
        "EventScript_ChooseDestFromTwoIsland" to EventScript_ChooseDestFromTwoIsland,
        "EventScript_ChooseDestFromTwoIslandVermilionAllowed" to
            EventScript_ChooseDestFromTwoIslandVermilionAllowed,
    )
