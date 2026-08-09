package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object CeruleanCave_2F_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_PP_UP, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ULTRA_BALL
 * end
 * ```
 */
internal object CeruleanCave_2F_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ULTRA_BALL, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_ULTRA_BALL, 1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object CeruleanCave_2F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_RESTORE, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_FULL_RESTORE, 2)
  }
}

internal val CeruleanCave_2FScripts: Map<String, Script> =
    mapOf(
        "CeruleanCave_2F_EventScript_ItemPPUp" to CeruleanCave_2F_EventScript_ItemPPUp,
        "CeruleanCave_2F_EventScript_ItemUltraBall" to CeruleanCave_2F_EventScript_ItemUltraBall,
        "CeruleanCave_2F_EventScript_ItemFullRestore" to
            CeruleanCave_2F_EventScript_ItemFullRestore,
    )
