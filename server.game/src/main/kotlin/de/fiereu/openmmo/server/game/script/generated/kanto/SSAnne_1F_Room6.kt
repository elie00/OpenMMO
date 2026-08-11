package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room6
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object SSAnne_1F_Room6_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.askYesNo(SSAnne_1F_Room6.TakeAShortRest)) {
      return ctx.say(
          if (ctx.isFemale) SSAnne_1F_Room6.SorryYouLookLikeMySister
          else SSAnne_1F_Room6.SorryYouLookLikeMyBrother)
    }
    ctx.healParty()
    ctx.say(SSAnne_1F_Room6.GladEveryoneIsRefreshed)
  }
}

internal val SSAnne_1F_Room6Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room6_EventScript_Woman" to SSAnne_1F_Room6_EventScript_Woman,
    )
