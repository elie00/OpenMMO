package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SafariZone_East
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_POTION
 * end
 * ```
 */
internal object SafariZone_East_EventScript_ItemMaxPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_POTION, KantoFlags.FLAG_HIDE_SAFARI_ZONE_EAST_MAX_POTION, 0)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object SafariZone_East_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_RESTORE, KantoFlags.FLAG_HIDE_SAFARI_ZONE_EAST_FULL_RESTORE, 1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM11
 * end
 * ```
 */
internal object SafariZone_East_EventScript_ItemTM11 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM11, KantoFlags.FLAG_HIDE_SAFARI_ZONE_EAST_TM11, 2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_LEAF_STONE
 * end
 * ```
 */
internal object SafariZone_East_EventScript_ItemLeafStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.LEAF_STONE, KantoFlags.FLAG_HIDE_SAFARI_ZONE_EAST_LEAF_STONE, 3)
  }
}

internal object SafariZone_East_EventScript_AreaSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_East.AreaSign)
}

internal object SafariZone_East_EventScript_RestHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SafariZone_East.RestHouse)
}

internal object SafariZone_East_EventScript_TrainerTips : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SafariZone_East.TimeDeclinesOnlyWhileYouWalk)
}

internal val SafariZone_EastScripts: Map<String, Script> =
    mapOf(
        "SafariZone_East_EventScript_ItemMaxPotion" to SafariZone_East_EventScript_ItemMaxPotion,
        "SafariZone_East_EventScript_ItemFullRestore" to
            SafariZone_East_EventScript_ItemFullRestore,
        "SafariZone_East_EventScript_ItemTM11" to SafariZone_East_EventScript_ItemTM11,
        "SafariZone_East_EventScript_ItemLeafStone" to SafariZone_East_EventScript_ItemLeafStone,
        "SafariZone_East_EventScript_AreaSign" to SafariZone_East_EventScript_AreaSign,
        "SafariZone_East_EventScript_RestHouseSign" to SafariZone_East_EventScript_RestHouseSign,
        "SafariZone_East_EventScript_TrainerTips" to SafariZone_East_EventScript_TrainerTips,
    )
