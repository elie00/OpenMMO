package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_1, 1
 * bufferstdstring STR_VAR_1, STDSTRING_BOULDER_BADGE
 * goto Route22_NorthEntrance_EventScript_BadgeGuard
 * end
 * ```
 */
internal object Route22_NorthEntrance_EventScript_BoulderBadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route22_NorthEntrance_EventScript_BoulderBadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_ge VAR_MAP_SCENE_ROUTE23, VAR_TEMP_1, Route23_EventScript_AlreadyRecognizedBoulderBadge
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
internal object Route22_NorthEntrance_EventScript_BadgeGuard : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route22_NorthEntrance_EventScript_BadgeGuard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Text_OhThatsBadgeGoRightAhead
 * waitmessage
 * playfanfare MUS_LEVEL_UP
 * waitfanfare
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object Route23_EventScript_AlreadyRecognizedBoulderBadge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route23_EventScript_AlreadyRecognizedBoulderBadge")
}

internal val Route22_NorthEntranceScripts: Map<String, Script> =
    mapOf(
        "Route22_NorthEntrance_EventScript_BoulderBadgeGuard" to
            Route22_NorthEntrance_EventScript_BoulderBadgeGuard,
        "Route22_NorthEntrance_EventScript_BadgeGuard" to
            Route22_NorthEntrance_EventScript_BadgeGuard,
        "Route23_EventScript_AlreadyRecognizedBoulderBadge" to
            Route23_EventScript_AlreadyRecognizedBoulderBadge,
    )
