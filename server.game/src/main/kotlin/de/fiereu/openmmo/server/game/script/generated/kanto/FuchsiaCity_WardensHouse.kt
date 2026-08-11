package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity_WardensHouse
import de.fiereu.openmmo.dialog.generated.kanto.PokemonJournal
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/** The Safari Zone warden, who trades HM04 for the gold teeth lost in the zone. */
internal object FuchsiaCity_WardensHouse_EventScript_Warden : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_HM04)) {
      return ctx.say(FuchsiaCity_WardensHouse.ExplainStrength)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_HIDE_SAFARI_ZONE_WEST_GOLD_TEETH)) {
      // Without his teeth in, nothing he says can be made out.
      return ctx.say(FuchsiaCity_WardensHouse.HifFuffHefifoo)
    }
    ctx.say(FuchsiaCity_WardensHouse.GaveGoldTeethToWarden)
    ctx.takeItem(Items.GOLD_TEETH)
    ctx.say(FuchsiaCity_WardensHouse.WardenPoppedInHisTeeth)
    ctx.say(
        if (ctx.isFemale) FuchsiaCity_WardensHouse.ThanksLassieGiveYouSomething
        else FuchsiaCity_WardensHouse.ThanksSonGiveYouSomething)
    if (!ctx.giveItem(Items.HM04)) {
      return ctx.say(FuchsiaCity_WardensHouse.YouHaveTooMuchStuff)
    }
    ctx.say(FuchsiaCity_WardensHouse.ReceivedHM04FromWarden)
    ctx.setFlag(KantoFlags.FLAG_GOT_HM04)
    ctx.say(FuchsiaCity_WardensHouse.ExplainStrength)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object FuchsiaCity_WardensHouse_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_WardensHouse_EventScript_ItemRareCandy")
}

internal object FuchsiaCity_WardensHouse_EventScript_PokemonJournalKoga : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PokemonJournal.SpecialFeatureKoga)
}

internal object FuchsiaCity_WardensHouse_EventScript_DisplaySign2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(FuchsiaCity_WardensHouse.OldMonMerchandiseOnDisplay)
}

internal object FuchsiaCity_WardensHouse_EventScript_DisplaySign1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(FuchsiaCity_WardensHouse.MonPhotosFossilsOnDisplay)
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
    )
