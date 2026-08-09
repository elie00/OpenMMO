package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * call EventScript_PkmnCenterNurse
 * release
 * end
 * ```
 */
internal object CeladonCity_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_PkmnCenterNurse.run(ctx)
  }
}

internal object CeladonCity_PokemonCenter_1F_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_PokemonCenter_1F.PokeFluteAwakensSleepingMons)
}

internal object CeladonCity_PokemonCenter_1F_EventScript_CooltrainerF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_PokemonCenter_1F.RodeHereFromFuchsia)
}

internal object CeladonCity_PokemonCenter_1F_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_PokemonCenter_1F.GoToCyclingRoadIfIHadBike)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * message Text_WelcomeWantToHealPkmn
 * waitmessage
 * multichoice 19, 8, MULTICHOICE_YES_NO, FALSE | (TRUE << 1)
 * switch VAR_RESULT
 * case 0, EventScript_PkmnCenterNurse_HealPkmn
 * case 1 EventScript_PkmnCenterNurse_Goodbye
 * case SCR_MENU_CANCEL, EventScript_PkmnCenterNurse_Goodbye
 * end
 * ```
 */
internal object EventScript_PkmnCenterNurse : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_PkmnCenterNurse")
}

internal val CeladonCity_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_PokemonCenter_1F_EventScript_Nurse" to
            CeladonCity_PokemonCenter_1F_EventScript_Nurse,
        "CeladonCity_PokemonCenter_1F_EventScript_Gentleman" to
            CeladonCity_PokemonCenter_1F_EventScript_Gentleman,
        "CeladonCity_PokemonCenter_1F_EventScript_CooltrainerF" to
            CeladonCity_PokemonCenter_1F_EventScript_CooltrainerF,
        "CeladonCity_PokemonCenter_1F_EventScript_Youngster" to
            CeladonCity_PokemonCenter_1F_EventScript_Youngster,
        "EventScript_PkmnCenterNurse" to EventScript_PkmnCenterNurse,
    )
