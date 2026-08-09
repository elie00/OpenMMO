package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.LavenderTown_House1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RESCUED_MR_FUJI, LavenderTown_House1_EventScript_CooltrainerFGhostGone
 * msgbox LavenderTown_House1_Text_RocketsKilledCubonesMother
 * release
 * end
 * ```
 */
internal object LavenderTown_House1_EventScript_CooltrainerF : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_RESCUED_MR_FUJI))
        return LavenderTown_House1_EventScript_CooltrainerFGhostGone.run(ctx)
    ctx.say(LavenderTown_House1.RocketsKilledCubonesMother)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_CUBONE, CRY_MODE_NORMAL
 * msgbox LavenderTown_House1_Text_Cubone
 * waitmoncry
 * release
 * end
 * ```
 */
internal object LavenderTown_House1_EventScript_Cubone : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port LavenderTown_House1_EventScript_Cubone")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LavenderTown_House1_Text_GhostOfPokemonTowerIsGone
 * release
 * end
 * ```
 */
internal object LavenderTown_House1_EventScript_CooltrainerFGhostGone : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavenderTown_House1_EventScript_CooltrainerFGhostGone")
}

internal val LavenderTown_House1Scripts: Map<String, Script> =
    mapOf(
        "LavenderTown_House1_EventScript_CooltrainerF" to
            LavenderTown_House1_EventScript_CooltrainerF,
        "LavenderTown_House1_EventScript_Cubone" to LavenderTown_House1_EventScript_Cubone,
        "LavenderTown_House1_EventScript_CooltrainerFGhostGone" to
            LavenderTown_House1_EventScript_CooltrainerFGhostGone,
    )
