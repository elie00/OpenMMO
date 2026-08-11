package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_2F_Room1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/** The decomp holds up a Snorlax picture after the box, which showmonpic has no verb for. */
internal object SSAnne_2F_Room1_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_2F_Room1.SleepingMonLookedLikeThis)
}

internal val SSAnne_2F_Room1Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_2F_Room1_EventScript_Gentleman" to SSAnne_2F_Room1_EventScript_Gentleman,
    )
