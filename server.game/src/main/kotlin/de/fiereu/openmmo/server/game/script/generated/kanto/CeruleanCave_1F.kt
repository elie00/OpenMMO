package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NUGGET
 * end
 * ```
 */
internal object CeruleanCave_1F_EventScript_ItemNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NUGGET, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_1F_NUGGET, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object CeruleanCave_1F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_RESTORE, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_1F_FULL_RESTORE, 1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_ELIXIR
 * end
 * ```
 */
internal object CeruleanCave_1F_EventScript_ItemMaxElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_ELIXIR, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_1F_MAX_ELIXIR, 2)
  }
}

internal val CeruleanCave_1FScripts: Map<String, Script> =
    mapOf(
        "CeruleanCave_1F_EventScript_ItemNugget" to CeruleanCave_1F_EventScript_ItemNugget,
        "CeruleanCave_1F_EventScript_ItemFullRestore" to
            CeruleanCave_1F_EventScript_ItemFullRestore,
        "CeruleanCave_1F_EventScript_ItemMaxElixir" to CeruleanCave_1F_EventScript_ItemMaxElixir,
    )
