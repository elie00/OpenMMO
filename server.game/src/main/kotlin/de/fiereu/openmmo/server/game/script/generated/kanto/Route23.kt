package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route23
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object Route23_EventScript_CascadeBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 2, LEAGUE_BADGES[1])
}

internal object Route23_EventScript_ThunderBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 3, LEAGUE_BADGES[2])
}

internal object Route23_EventScript_RainbowBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 4, LEAGUE_BADGES[3])
}

internal object Route23_EventScript_SoulBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 5, LEAGUE_BADGES[4])
}

internal object Route23_EventScript_MarshBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 6, LEAGUE_BADGES[5])
}

internal object Route23_EventScript_VolcanoBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 7, LEAGUE_BADGES[6])
}

internal object Route23_EventScript_EarthBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = badgeGuard(ctx, 8, LEAGUE_BADGES[7])
}

internal object Route23_EventScript_VictoryRoadGateSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route23.VictoryRoadGateSign)
}

internal val Route23Scripts: Map<String, Script> =
    mapOf(
        "Route23_EventScript_CascadeBadgeGuard" to Route23_EventScript_CascadeBadgeGuard,
        "Route23_EventScript_ThunderBadgeGuard" to Route23_EventScript_ThunderBadgeGuard,
        "Route23_EventScript_RainbowBadgeGuard" to Route23_EventScript_RainbowBadgeGuard,
        "Route23_EventScript_SoulBadgeGuard" to Route23_EventScript_SoulBadgeGuard,
        "Route23_EventScript_MarshBadgeGuard" to Route23_EventScript_MarshBadgeGuard,
        "Route23_EventScript_VolcanoBadgeGuard" to Route23_EventScript_VolcanoBadgeGuard,
        "Route23_EventScript_EarthBadgeGuard" to Route23_EventScript_EarthBadgeGuard,
        "Route23_EventScript_VictoryRoadGateSign" to Route23_EventScript_VictoryRoadGateSign,
    )
