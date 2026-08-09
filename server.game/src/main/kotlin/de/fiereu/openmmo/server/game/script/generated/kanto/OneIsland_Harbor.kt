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
 * setvar VAR_0x8004, SEAGALLOP_ONE_ISLAND
 * goto EventScript_ChooseDestFromOneIsland
 * end
 * ```
 */
internal object OneIsland_Harbor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port OneIsland_Harbor_EventScript_Sailor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_ge VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 5, EventScript_SeviiDestinationsPage1
 * goto_if_ge VAR_MAP_SCENE_CINNABAR_ISLAND, 4, EventScript_ChooseDestFromOneIslandVermilionAllowed
 * multichoice 19, 6, MULTICHOICE_ISLAND_23, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToTwoIsland2
 * case 1, EventScript_SailToThreeIsland2
 * case 2, EventScript_CancelSail
 * case SCR_MENU_CANCEL, EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_ChooseDestFromOneIsland : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_ChooseDestFromOneIsland")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 19, 5, MULTICHOICE_SEAGALLOP_V23, FALSE
 * switch VAR_RESULT
 * case 0, EventScript_SailToVermilion2
 * case 1, EventScript_SailToTwoIsland2
 * case 2, EventScript_SailToThreeIsland2
 * case 3, EventScript_CancelSail
 * case SCR_MENU_CANCEL, EventScript_CancelSail
 * end
 * ```
 */
internal object EventScript_ChooseDestFromOneIslandVermilionAllowed : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_ChooseDestFromOneIslandVermilionAllowed")
}

internal val OneIsland_HarborScripts: Map<String, Script> =
    mapOf(
        "OneIsland_Harbor_EventScript_Sailor" to OneIsland_Harbor_EventScript_Sailor,
        "EventScript_ChooseDestFromOneIsland" to EventScript_ChooseDestFromOneIsland,
        "EventScript_ChooseDestFromOneIslandVermilionAllowed" to
            EventScript_ChooseDestFromOneIslandVermilionAllowed,
    )
