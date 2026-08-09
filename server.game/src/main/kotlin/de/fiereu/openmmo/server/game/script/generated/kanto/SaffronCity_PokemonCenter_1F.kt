package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoVars

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call EventScript_PkmnCenterNurse
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonCenter_1F_EventScript_Nurse")
}

internal object SaffronCity_PokemonCenter_1F_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(SaffronCity_PokemonCenter_1F.SilphCoVictimOfFame)
}

internal object SaffronCity_PokemonCenter_1F_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(SaffronCity_PokemonCenter_1F.GrowthRatesDifferBySpecies)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_SILPH_CO_11F, 1, SaffronCity_PokemonCenter_1F_EventScript_YoungsterRocketsGone
 * msgbox SaffronCity_PokemonCenter_1F_Text_GreatIfEliteFourCameBeatRockets
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonCenter_1F_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) == 1)
        return SaffronCity_PokemonCenter_1F_EventScript_YoungsterRocketsGone.run(ctx)
    ctx.say(SaffronCity_PokemonCenter_1F.GreatIfEliteFourCameBeatRockets)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_SABRINA, 4
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PokemonJournal_Text_SpecialFeatureSabrina
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonCenter_1F_EventScript_PokemonJournalSabrina : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonCenter_1F_EventScript_PokemonJournalSabrina")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SaffronCity_PokemonCenter_1F_Text_TeamRocketTookOff
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonCenter_1F_EventScript_YoungsterRocketsGone : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonCenter_1F_EventScript_YoungsterRocketsGone")
}

internal val SaffronCity_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "SaffronCity_PokemonCenter_1F_EventScript_Nurse" to
            SaffronCity_PokemonCenter_1F_EventScript_Nurse,
        "SaffronCity_PokemonCenter_1F_EventScript_Gentleman" to
            SaffronCity_PokemonCenter_1F_EventScript_Gentleman,
        "SaffronCity_PokemonCenter_1F_EventScript_Woman" to
            SaffronCity_PokemonCenter_1F_EventScript_Woman,
        "SaffronCity_PokemonCenter_1F_EventScript_Youngster" to
            SaffronCity_PokemonCenter_1F_EventScript_Youngster,
        "SaffronCity_PokemonCenter_1F_EventScript_PokemonJournalSabrina" to
            SaffronCity_PokemonCenter_1F_EventScript_PokemonJournalSabrina,
        "SaffronCity_PokemonCenter_1F_EventScript_YoungsterRocketsGone" to
            SaffronCity_PokemonCenter_1F_EventScript_YoungsterRocketsGone,
    )
