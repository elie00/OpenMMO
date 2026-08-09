package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route23
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 2
 * bufferstdstring STR_VAR_1, STDSTRING_CASCADE_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_CascadeBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_CascadeBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 3
 * bufferstdstring STR_VAR_1, STDSTRING_THUNDER_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_ThunderBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_ThunderBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 4
 * bufferstdstring STR_VAR_1, STDSTRING_RAINBOW_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_RainbowBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_RainbowBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 5
 * bufferstdstring STR_VAR_1, STDSTRING_SOUL_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_SoulBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_SoulBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 6
 * bufferstdstring STR_VAR_1, STDSTRING_MARSH_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_MarshBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_MarshBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 7
 * bufferstdstring STR_VAR_1, STDSTRING_VOLCANO_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_VolcanoBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_VolcanoBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 8
 * bufferstdstring STR_VAR_1, STDSTRING_EARTH_BADGE
 * goto Route23_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route23_EventScript_EarthBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_EarthBadgeGuard")
}

internal object Route23_EventScript_VictoryRoadGateSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route23.VictoryRoadGateSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_ge VAR_MAP_SCENE_ROUTE23, VAR_TEMP_1, Route23_EventScript_AlreadyRecognizedBadge
 * switch VAR_TEMP_1
 * case 1, Route23_EventScript_CheckBoulderBadge
 * case 2, Route23_EventScript_CheckCascadeBadge
 * case 3, Route23_EventScript_CheckThunderBadge
 * case 4, Route23_EventScript_CheckRainbowBadge
 * case 5, Route23_EventScript_CheckSoulBadge
 * case 6, Route23_EventScript_CheckMarshBadge
 * case 7, Route23_EventScript_CheckVolcanoBadge
 * case 8, Route23_EventScript_CheckEarthBadge
 * end
 * ```
 */
internal object Route23_EventScript_BadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route23_EventScript_BadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_OnlyPassWithBadgeOhGoAhead
 * release
 * end
 * ```
 */
internal object Route23_EventScript_AlreadyRecognizedBadge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route23_EventScript_AlreadyRecognizedBadge")
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
        "Route23_EventScript_BadgeGuard" to Route23_EventScript_BadgeGuard,
        "Route23_EventScript_AlreadyRecognizedBadge" to Route23_EventScript_AlreadyRecognizedBadge,
    )
