package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SafariZone_Southeast
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object SafariZone_Southeast_EventScript_RichBoy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_Southeast.RichBoy)
}

internal object SafariZone_Southeast_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_Southeast.FatMan)
}

internal object SafariZone_Southeast_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_Southeast.LittleGirl)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BIG_PEARL
 * end
 * ```
 */
internal object SafariZone_Southeast_EventScript_ItemBigPearl : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BIG_PEARL, HoennFlags.FLAG_ITEM_SAFARI_ZONE_SOUTH_EAST_BIG_PEARL, 3)
  }
}

internal object SafariZone_Southeast_EventScript_ExpansionZoneAttendant : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_Southeast.ExpansionIsFinished)
}

internal val SafariZone_SoutheastScripts: Map<String, Script> =
    mapOf(
        "SafariZone_Southeast_EventScript_RichBoy" to SafariZone_Southeast_EventScript_RichBoy,
        "SafariZone_Southeast_EventScript_FatMan" to SafariZone_Southeast_EventScript_FatMan,
        "SafariZone_Southeast_EventScript_LittleGirl" to
            SafariZone_Southeast_EventScript_LittleGirl,
        "SafariZone_Southeast_EventScript_ItemBigPearl" to
            SafariZone_Southeast_EventScript_ItemBigPearl,
        "SafariZone_Southeast_EventScript_ExpansionZoneAttendant" to
            SafariZone_Southeast_EventScript_ExpansionZoneAttendant,
    )
