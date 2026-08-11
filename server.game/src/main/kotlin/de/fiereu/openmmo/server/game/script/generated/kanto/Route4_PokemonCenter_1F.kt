package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route4_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

private const val MAGIKARP = 129
private const val MAGIKARP_LEVEL = 5
private const val MAGIKARP_PRICE = 500

internal object Route4_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) = EventScript_PkmnCenterNurse.run(ctx)
}

internal object Route4_PokemonCenter_1F_EventScript_MagikarpSalesman : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BOUGHT_MAGIKARP)) {
      return ctx.say(Route4_PokemonCenter_1F.IDontGiveRefunds)
    }
    val offer =
        if (ctx.isFemale) Route4_PokemonCenter_1F.SweetieBuyMagikarpForJust500
        else Route4_PokemonCenter_1F.LaddieBuyMagikarpForJust500
    if (!ctx.askYesNo(offer)) {
      return ctx.say(Route4_PokemonCenter_1F.OnlyDoingThisAsFavorToYou)
    }
    if (ctx.money < MAGIKARP_PRICE) {
      return ctx.say(Route4_PokemonCenter_1F.YoullNeedMoreMoney)
    }
    // givemon answers 2 when there is no room in the party or the box, which is not modelled, so
    // this always lands in the party. NoRoomForMorePokemon is left unused for now.
    ctx.givePokemon(MAGIKARP, MAGIKARP_LEVEL)
    ctx.payMoney(MAGIKARP_PRICE)
    ctx.say(Route4_PokemonCenter_1F.PaidOutrageouslyForMagikarp)
    ctx.setFlag(KantoFlags.FLAG_BOUGHT_MAGIKARP)
    // The decomp then offers to nickname it, which needs the client's nickname screen.
  }
}

internal object Route4_PokemonCenter_1F_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route4_PokemonCenter_1F.TeamRocketAttacksCerulean)
}

internal object Route4_PokemonCenter_1F_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route4_PokemonCenter_1F.CanHaveSixMonsWithYou)
}

internal object Route4_PokemonCenter_1F_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route4_PokemonCenter_1F.ShouldStoreMonsUsingPC)
}

internal object Route4_PokemonCenter_1F_EventScript_Newspaper : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route4_PokemonCenter_1F.ItsANewspaper)
}

internal val Route4_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "Route4_PokemonCenter_1F_EventScript_Nurse" to Route4_PokemonCenter_1F_EventScript_Nurse,
        "Route4_PokemonCenter_1F_EventScript_MagikarpSalesman" to
            Route4_PokemonCenter_1F_EventScript_MagikarpSalesman,
        "Route4_PokemonCenter_1F_EventScript_Gentleman" to
            Route4_PokemonCenter_1F_EventScript_Gentleman,
        "Route4_PokemonCenter_1F_EventScript_Boy" to Route4_PokemonCenter_1F_EventScript_Boy,
        "Route4_PokemonCenter_1F_EventScript_Youngster" to
            Route4_PokemonCenter_1F_EventScript_Youngster,
        "Route4_PokemonCenter_1F_EventScript_Newspaper" to
            Route4_PokemonCenter_1F_EventScript_Newspaper,
    )
