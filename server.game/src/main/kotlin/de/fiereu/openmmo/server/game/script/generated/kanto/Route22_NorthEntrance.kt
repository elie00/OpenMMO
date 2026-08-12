package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object Route22_NorthEntrance_EventScript_BoulderBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 1, LEAGUE_BADGES[0])
}

internal object Route22_NorthEntrance_EventScript_BoulderBadgeGuardTrigger : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 1, LEAGUE_BADGES[0])
}

internal val Route22_NorthEntranceScripts: Map<String, Script> =
    mapOf(
        "Route22_NorthEntrance_EventScript_BoulderBadgeGuardTrigger" to
            Route22_NorthEntrance_EventScript_BoulderBadgeGuardTrigger,
        "Route22_NorthEntrance_EventScript_BoulderBadgeGuard" to
            Route22_NorthEntrance_EventScript_BoulderBadgeGuard,
    )
