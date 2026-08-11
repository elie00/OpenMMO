package de.fiereu.openmmo.server.game.services

import de.fiereu.openmmo.common.DynamicWarp
import de.fiereu.openmmo.common.enums.Direction

/**
 * Where a beaten player wakes up, the decomp's `setrespawn HEAL_LOCATION_*`. A heal location is a
 * map and a tile on it; the source game always stands the player up facing down, so the facing is
 * not stored.
 *
 * This rides on the story vars rather than a column of its own, since those are already persisted
 * and a respawn point is exactly the kind of per character progress they hold. The keys are not
 * namespaced by region because a player has one respawn point across all of them, and the region is
 * part of the value.
 */
object RespawnPoint {
  private const val REGION = "RESPAWN_REGION"
  private const val BANK = "RESPAWN_BANK"
  private const val MAP = "RESPAWN_MAP"
  private const val X = "RESPAWN_X"
  private const val Y = "RESPAWN_Y"

  /** A var of 0 means unset, so the map is stored offset by one to keep map 0 usable. */
  private const val UNSET = 0

  fun of(storyVars: Map<String, Int>): DynamicWarp? {
    val map = storyVars[MAP] ?: UNSET
    if (map == UNSET) return null
    return DynamicWarp(
        regionId = (storyVars[REGION] ?: 0).toByte(),
        bankId = (storyVars[BANK] ?: 0).toByte(),
        mapId = (map - 1).toByte(),
        x = (storyVars[X] ?: 0).toShort(),
        y = (storyVars[Y] ?: 0).toShort(),
        facing = Direction.DOWN,
    )
  }

  fun vars(regionId: Int, bankId: Int, mapId: Int, x: Int, y: Int): Map<String, Int> =
      mapOf(REGION to regionId, BANK to bankId, MAP to mapId + 1, X to x, Y to y)
}
