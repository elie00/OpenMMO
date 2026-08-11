package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * One of the twenty card key doors in Silph Co, whose scripts the decomp shares in
 * data/scripts/silphco_doors.inc. Each floor's door only needs its own flag.
 *
 * The decomp lays the barrier in on map load and takes it back out with setmetatile. The generated
 * maps already carry the open state, so the barriers are walkable whatever the flag says and this
 * only records which doors the player has opened.
 */
internal suspend fun silphCoDoor(ctx: ScriptContext, doorFlag: String) {
  if (ctx.isFlagSet(doorFlag)) return ctx.sign(Misc.Text_TheDoorIsOpen)
  // The decomp asks whether the card key has been picked up rather than whether it is in the bag,
  // since it is a key item that is never spent.
  if (!ctx.isFlagSet(KantoFlags.FLAG_HIDE_SILPH_CO_5F_CARD_KEY)) {
    return ctx.sign(Misc.Text_ItNeedsCardKey)
  }
  ctx.sign(Misc.Text_CardKeyOpenedDoor)
  ctx.setFlag(doorFlag)
}
