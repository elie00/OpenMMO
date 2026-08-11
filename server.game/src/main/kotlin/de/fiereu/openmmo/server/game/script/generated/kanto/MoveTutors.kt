package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.common.dialog.DialogLine
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * The decomp's shared move tutors, one per move, scattered across the region. Their scripts live in
 * data/scripts/move_tutors.inc rather than any one map, so they are shared here too.
 *
 * The offer and both refusals are ported; teaching is not.
 *
 * TODO Teach the tutor move The decomp calls EventScript_ChooseMoveTutorMon, a party picker that
 * writes the move onto the chosen monster. There is no party menu or move writing verb, so the
 * offer ends in the decline line rather than setting FLAG_TUTOR_* on a move the player never got,
 * and it comes back once there is a way to take it.
 */
internal suspend fun moveTutor(
    ctx: ScriptContext,
    taughtFlag: String,
    offer: DialogLine,
    declined: DialogLine,
    taught: DialogLine,
) {
  if (ctx.isFlagSet(taughtFlag)) return ctx.say(taught)
  ctx.askYesNo(offer)
  ctx.say(declined)
}
