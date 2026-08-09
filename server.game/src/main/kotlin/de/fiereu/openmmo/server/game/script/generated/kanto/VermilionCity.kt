package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
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
 * Not ported yet. Decomp body:
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
  override suspend fun run(ctx: ScriptContext) = TODO("port VermilionCity_EventScript_OaksAide")
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
 * Not ported yet. Decomp body:
 * ```
 * msgbox VermilionCity_Text_SSAnneHasDepartedForYear
 * release
 * end
 * ```
 */
internal object VermilionCity_EventScript_OldMan1SSAnneLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_EventScript_OldMan1SSAnneLeft")
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
    )
