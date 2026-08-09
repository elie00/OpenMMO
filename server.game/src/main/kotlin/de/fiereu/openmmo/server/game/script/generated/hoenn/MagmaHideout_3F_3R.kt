package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ESCAPE_ROPE
 * end
 * ```
 */
internal object MagmaHideout_3F_3R_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ESCAPE_ROPE, HoennFlags.FLAG_ITEM_MAGMA_HIDEOUT_3F_3R_ECAPE_ROPE, 0)
  }
}

internal val MagmaHideout_3F_3RScripts: Map<String, Script> =
    mapOf(
        "MagmaHideout_3F_3R_EventScript_ItemEscapeRope" to
            MagmaHideout_3F_3R_EventScript_ItemEscapeRope,
    )
