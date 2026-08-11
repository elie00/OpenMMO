package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.LavenderTown_VolunteerPokemonHouse
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object LavenderTown_VolunteerPokemonHouse_EventScript_MrFuji : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_POKE_FLUTE)) {
      return ctx.say(LavenderTown_VolunteerPokemonHouse.HasPokeFluteHelpedYou)
    }
    ctx.say(LavenderTown_VolunteerPokemonHouse.IdLikeYouToHaveThis)
    if (!ctx.giveItem(Items.POKE_FLUTE)) {
      return ctx.say(LavenderTown_VolunteerPokemonHouse.MustMakeRoomForThis)
    }
    ctx.setFlag(KantoFlags.FLAG_GOT_POKE_FLUTE)
    ctx.say(LavenderTown_VolunteerPokemonHouse.ReceivedPokeFluteFromMrFuji)
    ctx.say(LavenderTown_VolunteerPokemonHouse.ExplainPokeFlute)
  }
}

/** The decomp plays its cry around the box, which has no verb. */
internal object LavenderTown_VolunteerPokemonHouse_EventScript_Nidorino : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LavenderTown_VolunteerPokemonHouse.Nidorino)
}

/** The decomp plays its cry around the box, which has no verb. */
internal object LavenderTown_VolunteerPokemonHouse_EventScript_Psyduck : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(LavenderTown_VolunteerPokemonHouse.Psyduck)
}

internal object LavenderTown_VolunteerPokemonHouse_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LavenderTown_VolunteerPokemonHouse.MonsNiceToHug)
}

internal object LavenderTown_VolunteerPokemonHouse_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_RESCUED_MR_FUJI)) {
      return ctx.say(LavenderTown_VolunteerPokemonHouse.MrFujiWasPrayingForCubonesMother)
    }
    ctx.say(LavenderTown_VolunteerPokemonHouse.WhereDidMrFujiGo)
  }
}

internal object LavenderTown_VolunteerPokemonHouse_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LavenderTown_VolunteerPokemonHouse.MrFujiLooksAfterOrphanedMons)
}

internal object LavenderTown_VolunteerPokemonHouse_EventScript_PokemonFanMagazine : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LavenderTown_VolunteerPokemonHouse.GrandPrizeDrawingClipped)
}

internal object LavenderTown_VolunteerPokemonHouse_EventScript_Bookshelf : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LavenderTown_VolunteerPokemonHouse.PokemonMagazinesLineShelf)
}

internal val LavenderTown_VolunteerPokemonHouseScripts: Map<String, Script> =
    mapOf(
        "LavenderTown_VolunteerPokemonHouse_EventScript_MrFuji" to
            LavenderTown_VolunteerPokemonHouse_EventScript_MrFuji,
        "LavenderTown_VolunteerPokemonHouse_EventScript_Nidorino" to
            LavenderTown_VolunteerPokemonHouse_EventScript_Nidorino,
        "LavenderTown_VolunteerPokemonHouse_EventScript_Psyduck" to
            LavenderTown_VolunteerPokemonHouse_EventScript_Psyduck,
        "LavenderTown_VolunteerPokemonHouse_EventScript_LittleBoy" to
            LavenderTown_VolunteerPokemonHouse_EventScript_LittleBoy,
        "LavenderTown_VolunteerPokemonHouse_EventScript_Youngster" to
            LavenderTown_VolunteerPokemonHouse_EventScript_Youngster,
        "LavenderTown_VolunteerPokemonHouse_EventScript_LittleGirl" to
            LavenderTown_VolunteerPokemonHouse_EventScript_LittleGirl,
        "LavenderTown_VolunteerPokemonHouse_EventScript_PokemonFanMagazine" to
            LavenderTown_VolunteerPokemonHouse_EventScript_PokemonFanMagazine,
        "LavenderTown_VolunteerPokemonHouse_EventScript_Bookshelf" to
            LavenderTown_VolunteerPokemonHouse_EventScript_Bookshelf,
    )
