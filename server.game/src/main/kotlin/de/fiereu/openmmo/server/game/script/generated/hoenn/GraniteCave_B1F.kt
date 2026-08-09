package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_POKE_BALL
 * end
 * ```
 */
internal object GraniteCave_B1F_EventScript_ItemPokeBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.POKE_BALL, HoennFlags.FLAG_ITEM_GRANITE_CAVE_B1F_POKE_BALL, 0)
  }
}

internal val GraniteCave_B1FScripts: Map<String, Script> =
    mapOf(
        "GraniteCave_B1F_EventScript_ItemPokeBall" to GraniteCave_B1F_EventScript_ItemPokeBall,
    )
