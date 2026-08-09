package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RustboroCity_Mart
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message gText_HowMayIServeYou
 * waitmessage
 * goto_if_unset FLAG_MET_DEVON_EMPLOYEE, RustboroCity_Mart_EventScript_PokemartBasic
 * goto_if_set FLAG_MET_DEVON_EMPLOYEE, RustboroCity_Mart_EventScript_PokemartExpanded
 * end
 * ```
 */
internal object RustboroCity_Mart_EventScript_Clerk : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_Mart_EventScript_Clerk")
}

internal object RustboroCity_Mart_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(RustboroCity_Mart.ShouldBuySuperPotionsInstead)
}

internal object RustboroCity_Mart_EventScript_PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(RustboroCity_Mart.BuyingHealsInCaseOfShroomish)
}

internal object RustboroCity_Mart_EventScript_BugCatcher : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(RustboroCity_Mart.GettingEscapeRopeJustInCase)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * pokemart RustboroCity_Mart_Pokemart_Expanded
 * msgbox gText_PleaseComeAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Mart_EventScript_PokemartExpanded : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Mart_EventScript_PokemartExpanded")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * pokemart RustboroCity_Mart_Pokemart_Basic
 * msgbox gText_PleaseComeAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Mart_EventScript_PokemartBasic : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Mart_EventScript_PokemartBasic")
}

internal val RustboroCity_MartScripts: Map<String, Script> =
    mapOf(
        "RustboroCity_Mart_EventScript_Clerk" to RustboroCity_Mart_EventScript_Clerk,
        "RustboroCity_Mart_EventScript_Boy" to RustboroCity_Mart_EventScript_Boy,
        "RustboroCity_Mart_EventScript_PokefanF" to RustboroCity_Mart_EventScript_PokefanF,
        "RustboroCity_Mart_EventScript_BugCatcher" to RustboroCity_Mart_EventScript_BugCatcher,
        "RustboroCity_Mart_EventScript_PokemartExpanded" to
            RustboroCity_Mart_EventScript_PokemartExpanded,
        "RustboroCity_Mart_EventScript_PokemartBasic" to
            RustboroCity_Mart_EventScript_PokemartBasic,
    )
