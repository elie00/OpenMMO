package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.server.game.script.MovementStep
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

/**
 * The eight guards on the way to the league, whose scripts the decomp shares in
 * data/scripts/route23.inc. Each asks for one badge and steps aside for good once he has seen it,
 * which VAR_MAP_SCENE_ROUTE23 remembers as the highest badge shown so far.
 */
internal suspend fun badgeGuard(ctx: ScriptContext, badgeNumber: Int, badgeFlag: String) {
  if (ctx.getVar(KantoVars.VAR_MAP_SCENE_ROUTE23) >= badgeNumber) {
    return ctx.say(Misc.Text_OnlyPassWithBadgeOhGoAhead)
  }
  if (!ctx.isFlagSet(badgeFlag)) {
    ctx.say(Misc.Text_OnlyPassWithBadgeDontHaveYet)
    // He steps back into the road rather than letting the player through.
    return ctx.moveSelf(MovementStep.WALK_DOWN)
  }
  ctx.say(Misc.Text_OnlyPassWithBadgeOhGoAhead)
  ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE23, badgeNumber)
}

/** The badge each guard on the way up asks for, in the order they stand. */
internal val LEAGUE_BADGES =
    listOf(
        KantoFlags.FLAG_BADGE01_GET,
        KantoFlags.FLAG_BADGE02_GET,
        KantoFlags.FLAG_BADGE03_GET,
        KantoFlags.FLAG_BADGE04_GET,
        KantoFlags.FLAG_BADGE05_GET,
        KantoFlags.FLAG_BADGE06_GET,
        KantoFlags.FLAG_BADGE07_GET,
        KantoFlags.FLAG_BADGE08_GET,
    )
