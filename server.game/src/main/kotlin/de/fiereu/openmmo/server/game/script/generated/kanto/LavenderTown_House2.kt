package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.LavenderTown_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * The name rater.
 *
 * TODO Rate and change a nickname The decomp picks a party member, judges its nickname and opens
 * the naming screen. There is no party picker or rename verb, so he turns every visitor away for
 * now.
 */
internal object LavenderTown_House2_EventScript_NameRater : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.askYesNo(LavenderTown_House2.WantMeToRateNicknames)
    ctx.say(LavenderTown_House2.ISeeComeVisitAgain)
  }
}

internal val LavenderTown_House2Scripts: Map<String, Script> =
    mapOf(
        "LavenderTown_House2_EventScript_NameRater" to LavenderTown_House2_EventScript_NameRater,
    )
