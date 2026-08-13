package de.fiereu.openmmo.server.game.services

import de.fiereu.network.SessionContext
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.server.game.session.PlayerState
import de.fiereu.openmmo.server.game.storage.CharacterStore
import io.github.oshai.kotlinlogging.KotlinLogging
import javax.inject.Inject
import javax.inject.Singleton

private val log = KotlinLogging.logger {}

/**
 * What happens to a player whose party is wiped out, the decomp's `DoWhiteOut` in overworld.c: they
 * hand over some money, wake up healed at their last heal location and lose nothing else.
 *
 * The screen effect that goes with it in the source game is the client's business; the server only
 * moves the player and settles the cost.
 */
@Singleton
class WhiteoutService
@Inject
constructor(
    private val story: StoryService,
    private val player: StoryPlayerService,
    private val warpService: ScriptWarpService,
    private val characterStore: CharacterStore,
) {

  suspend fun whiteout(session: SessionContext, state: PlayerState) {
    val characterId = state.characterId ?: return
    val storyVars = characterStore.getCharacter(characterId)?.storyVars ?: return
    val respawn = RespawnPoint.of(storyVars)
    if (respawn == null) {
      // A character who has never been given a heal location has nowhere to wake up, so leave them
      // standing rather than warping them to an arbitrary map.
      log.warn { "Character $characterId whited out with no respawn point set" }
      return
    }
    player.changeMoney(session, state, -moneyLoss(characterId, state))
    player.healParty(session, state)
    warpService.warp(session, state, respawn)
  }

  /**
   * The decomp's ComputeWhiteOutMoneyLoss: four times the highest level in the party, scaled by how
   * far the player has come, and never more than they are carrying.
   */
  private fun moneyLoss(characterId: Long, state: PlayerState): Int {
    val character = characterStore.getCharacter(characterId) ?: return 0
    val topLevel = character.pokemon.maxOfOrNull { it.level.toInt() } ?: return 0
    val badges = badgeCount(characterId, state)
    return (topLevel * 4 * MONEY_LOSS_MULTIPLIERS[badges]).coerceAtMost(character.info.money)
  }

  /** Badges of the region the player is standing in, since both decomps name their flags alike. */
  private fun badgeCount(characterId: Long, state: PlayerState): Int {
    val prefix = (Region.byId(state.regionId.toInt()) ?: return 0).name.lowercase()
    return (1..BADGE_COUNT).count { story.isFlagSet(characterId, "$prefix/FLAG_BADGE0${it}_GET") }
  }

  private companion object {
    const val BADGE_COUNT = 8

    /** Indexed by badge count, so the eighth badge makes a loss fifteen times the first one's. */
    val MONEY_LOSS_MULTIPLIERS = intArrayOf(2, 4, 6, 9, 12, 16, 20, 25, 30)
  }
}
