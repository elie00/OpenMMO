package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity
import de.fiereu.openmmo.server.game.script.MovementStep
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

/** VAR_MAP_SCENE_VERMILION_CITY once the S.S. Anne has sailed. */
private const val SS_ANNE_GONE = 3

internal object VermilionCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VermilionCity.GrimerMultipliesInSludge)
}

internal object VermilionCity_EventScript_OldMan1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_VERMILION_CITY) == SS_ANNE_GONE) {
      return ctx.say(VermilionCity.SSAnneHasDepartedForYear)
    }
    ctx.say(VermilionCity.DidYouSeeSSAnneInHarbor)
  }
}

internal object VermilionCity_EventScript_OldMan2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VermilionCity.BuildingOnThisLand)
}

internal object VermilionCity_EventScript_Machop : Script {
  override suspend fun run(ctx: ScriptContext) {
    // The decomp plays Machop's cry between the two boxes, which has no verb.
    ctx.say(VermilionCity.Machop)
    ctx.say(VermilionCity.MachopStompingLandFlat)
  }
}

internal object VermilionCity_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VermilionCity.SSAnneVisitsOnceAYear)
}

internal object VermilionCity_EventScript_FerrySailor : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_VERMILION_CITY) == SS_ANNE_GONE) {
      // The decomp offers the Seagallop to the Sevii Islands here, which needs a destination menu.
      return ctx.say(VermilionCity.TheShipSetSail)
    }
    ctx.say(VermilionCity.WelcomeToTheSSAnne)
  }
}

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

internal object VermilionCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.GymSign)
}

internal object VermilionCity_EventScript_HarborSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.VermilionHarbor)
}

internal object VermilionCity_EventScript_SnorlaxNotice : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VermilionCity.SnorlaxBlockingRoute12)
}

/**
 * The pier's ticket check, which the map's coord events fire from either tile at the top of it. The
 * sailor turns a ticketless player around, so the S.S. Anne cannot be boarded early.
 */
internal object VermilionCity_EventScript_CheckTicket : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_VERMILION_CITY) == SS_ANNE_GONE) {
      ctx.say(VermilionCity.TheShipSetSail)
      return walkUpPier(ctx)
    }
    ctx.say(VermilionCity.DoYouHaveATicket)
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_SS_TICKET)) {
      ctx.say(VermilionCity.DontHaveNeededSSTicket)
      return walkUpPier(ctx)
    }
    ctx.say(VermilionCity.FlashedSSTicket)
    ctx.setVar(KantoVars.VAR_VERMILION_CITY_TICKET_CHECK_TRIGGER, 1)
  }
}

internal object VermilionCity_EventScript_CheckTicketLeft : Script {
  override suspend fun run(ctx: ScriptContext) = VermilionCity_EventScript_CheckTicket.run(ctx)
}

internal object VermilionCity_EventScript_CheckTicketRight : Script {
  override suspend fun run(ctx: ScriptContext) = VermilionCity_EventScript_CheckTicket.run(ctx)
}

/** Walking back off the pier arms the check again. */
internal object VermilionCity_EventScript_ExitedTicketCheck : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.setVar(KantoVars.VAR_VERMILION_CITY_TICKET_CHECK_TRIGGER, 0)
}

/** The sailor sends the player back up the pier rather than letting them past. */
private suspend fun walkUpPier(ctx: ScriptContext) = ctx.moveSelf(MovementStep.WALK_UP)

internal val VermilionCityScripts: Map<String, Script> =
    mapOf(
        "VermilionCity_EventScript_CheckTicket" to VermilionCity_EventScript_CheckTicket,
        "VermilionCity_EventScript_CheckTicketLeft" to VermilionCity_EventScript_CheckTicketLeft,
        "VermilionCity_EventScript_CheckTicketRight" to VermilionCity_EventScript_CheckTicketRight,
        "VermilionCity_EventScript_ExitedTicketCheck" to
            VermilionCity_EventScript_ExitedTicketCheck,
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
    )
