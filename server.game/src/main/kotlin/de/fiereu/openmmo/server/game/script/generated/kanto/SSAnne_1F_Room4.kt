package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_1F_Room4
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object SSAnne_1F_Room4_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.isFemale) SSAnne_1F_Room4.WaitressCherryPiePlease
          else SSAnne_1F_Room4.WaiterCherryPiePlease)
}

internal val SSAnne_1F_Room4Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_1F_Room4_EventScript_Woman" to SSAnne_1F_Room4_EventScript_Woman,
    )
