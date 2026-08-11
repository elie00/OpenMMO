package de.fiereu.openmmo.server.game.script

import de.fiereu.network.SessionContext
import de.fiereu.openmmo.common.DynamicWarp
import de.fiereu.openmmo.common.dialog.DialogLine
import de.fiereu.openmmo.common.enums.Direction
import de.fiereu.openmmo.common.enums.Region
import de.fiereu.openmmo.maps.MapManager
import de.fiereu.openmmo.net.game.packets.MapTileAttributeSetPacket
import de.fiereu.openmmo.net.game.packets.dialog.TextPokemonSpeciesArg
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.services.BattleService
import de.fiereu.openmmo.server.game.services.DialogPresentation
import de.fiereu.openmmo.server.game.services.DialogService
import de.fiereu.openmmo.server.game.services.MapEntryScripts
import de.fiereu.openmmo.server.game.services.RespawnPoint
import de.fiereu.openmmo.server.game.services.ScriptMovementService
import de.fiereu.openmmo.server.game.services.ScriptWarpService
import de.fiereu.openmmo.server.game.services.StoryClientState
import de.fiereu.openmmo.server.game.services.StoryPlayerService
import de.fiereu.openmmo.server.game.services.StoryService
import de.fiereu.openmmo.server.game.session.PlayerState
import de.fiereu.openmmo.server.game.session.openedTileKey
import de.fiereu.openmmo.server.game.storage.CharacterStore

/** What a [Script] uses to talk to the player it interacted with and read or write story state. */
class ScriptContext
internal constructor(
    internal val session: SessionContext,
    internal val state: PlayerState,
    /** The npc the player talked to, or -1 for a sign. */
    val entityId: Long,
    internal val dialog: DialogService,
    internal val story: StoryService,
    private val movement: ScriptMovementService,
    private val warp: ScriptWarpService? = null,
    internal val player: StoryPlayerService? = null,
    private val battles: BattleService? = null,
    internal val characters: CharacterStore? = null,
    private val maps: MapManager? = null,
    private val entryScripts: MapEntryScripts? = null,
) {
  private val characterId: Long?
    get() = state.characterId

  val facingDirection: Direction
    get() = state.facingDirection

  val isFemale: Boolean
    get() = movement.playerGender(state) == FEMALE

  internal val playerEntityId: Long
    get() = checkNotNull(state.characterId) { "Scene has no selected character" }

  internal val playerName: String
    get() = state.characterId?.let { characters?.getCharacter(it)?.info?.name }.orEmpty()

  internal fun send(packet: Any) = session.send(packet)

  /** Show [line] as a sign and wait for the player to close it. */
  suspend fun sign(line: DialogLine) = dialog.showAndWait(session, state, line.textId, SIGN, -1)

  /** Show [line] from the interacted entity and wait for the player to go on. */
  suspend fun say(line: DialogLine) = dialog.showAndWait(session, state, line.textId, NPC, entityId)

  /** Show [line] from a cutscene npc addressed by its decomp local id. */
  suspend fun sayNpc(localId: Int, line: DialogLine) =
      dialog.showAndWait(
          session,
          state,
          line.textId,
          NPC,
          movement.npcEntityId(state, localId) ?: -1,
      )

  /** Shows dialog with a species-name variable. */
  suspend fun sayNpcWithSpeciesName(localId: Int, line: DialogLine, speciesId: Int) =
      dialog.showAndWait(
          session,
          state,
          line.textId,
          NPC,
          movement.npcEntityId(state, localId) ?: -1,
          DialogPresentation(
              messageArgs =
                  listOf(
                      TextPokemonSpeciesArg(
                          partySlot = 1,
                          stringVariable = 1,
                          speciesId = speciesId.toShort(),
                      ))),
      )

  /** Opens the Emerald starter picker. */
  suspend fun chooseHoennStarter(): Int = dialog.chooseHoennStarter(session, state)

  /** Ask a ROM-backed yes/no question from the interacted entity. */
  suspend fun askYesNo(line: DialogLine): Boolean =
      dialog.askYesNo(session, state, line.textId, entityId)

  /** Ask a ROM-backed yes/no question from a cutscene npc. */
  suspend fun askYesNoNpc(localId: Int, line: DialogLine): Boolean =
      dialog.askYesNo(
          session,
          state,
          line.textId,
          movement.npcEntityId(state, localId) ?: -1,
      )

  /** True if the story [flag] is set. Keys come from the content layer, for example HoennFlags. */
  fun isFlagSet(flag: String): Boolean = characterId?.let { story.isFlagSet(it, flag) } ?: false

  fun setFlag(flag: String) {
    characterId?.let {
      story.setFlag(it, flag)
      StoryClientState.flagUpdate(state.regionId.toByte(), flag, enabled = true)?.let(session::send)
    }
  }

  fun clearFlag(flag: String) {
    characterId?.let {
      story.clearFlag(it, flag)
      StoryClientState.flagUpdate(state.regionId.toByte(), flag, enabled = false)
          ?.let(session::send)
    }
  }

  /** The story var [key], or 0 if it was never set. */
  fun getVar(key: String): Int = characterId?.let { story.getVar(it, key) } ?: 0

  fun setVar(key: String, value: Int) {
    characterId?.let { story.setVar(it, key, value) }
  }

  fun givePokemon(dexId: Int, level: Int, vararg moveIds: Int) =
      checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }
          .givePokemon(session, state, dexId, level, moveIds.toList())

  fun healParty() = checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }.healParty(session, state)

  fun giveItem(itemId: Int, quantity: Int = 1): Boolean =
      checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }.giveItem(session, state, itemId, quantity)

  /** Take an item back out of the bag, the decomp removeitem. False when the bag lacks it. */
  fun takeItem(itemId: Int, quantity: Int = 1): Boolean = giveItem(itemId, -quantity)

  /** The decomp checkitem: true when the bag holds at least one of [itemId]. */
  fun hasItem(itemId: Int): Boolean =
      checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }.itemCount(state, itemId) > 0

  /** What the player is carrying, the decomp checkmoney. */
  val money: Int
    get() = checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }.money(state)

  /** The decomp givemoney. */
  fun giveMoney(amount: Int) {
    checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }.changeMoney(session, state, amount)
  }

  /** The decomp paymoney. False when the player cannot afford it, and then nothing is taken. */
  fun payMoney(amount: Int): Boolean =
      checkNotNull(player) { STORY_PLAYER_UNAVAILABLE }.changeMoney(session, state, -amount)

  /** Run a non-catchable, non-escapable story battle and wait for its result. */
  suspend fun battle(dexId: Int, level: Int, vararg moveIds: Int): BattleResult =
      checkNotNull(battles) { "Battle service is unavailable" }
          .startScriptedBattle(session, dexId, level, moveIds.toList())

  /**
   * Fight the decomp trainer with this id, using the region the player is standing in. A win marks
   * them beaten, the way the source game's engine sets the trainer's flag rather than the script.
   */
  suspend fun trainerBattle(trainerId: Int): BattleResult {
    val region = region()
    val result =
        checkNotNull(battles) { "Battle service is unavailable" }
            .startTrainerBattle(session, region, trainerId)
    if (result == BattleResult.VICTORY) setFlag(trainerFlag(region, trainerId))
    return result
  }

  /**
   * The decomp's `trainerbattle_single`: [intro] and the fight the first time, [defeat] once the
   * player wins, and nothing at all afterwards. Pair it with [hasBeatenTrainer] when the script
   * ends in a post battle line, since the source game only shows that line on a later talk.
   */
  suspend fun trainerBattle(trainerId: Int, intro: DialogLine, defeat: DialogLine) {
    say(intro)
    if (trainerBattle(trainerId) != BattleResult.VICTORY) return
    say(defeat)
  }

  /**
   * A `trainerbattle_single` whose script goes straight on to the trainer's post battle box, which
   * is most of them. The source game only falls through to that box when the trainer was already
   * beaten, so [postBattle] is what a later talk shows and never follows the win.
   */
  suspend fun trainerBattle(
      trainerId: Int,
      intro: DialogLine,
      defeat: DialogLine,
      postBattle: DialogLine,
  ) {
    if (hasBeatenTrainer(trainerId)) return say(postBattle)
    trainerBattle(trainerId, intro, defeat)
  }

  /**
   * True once the player has beaten this decomp trainer. The source game keeps one flag per trainer
   * in a block that flags.h leaves unnamed, so the key is stored server side only and never reaches
   * the client's flag table.
   */
  fun hasBeatenTrainer(trainerId: Int): Boolean = isFlagSet(trainerFlag(region(), trainerId))

  /**
   * The decomp's `settrainerflag`: count this trainer as beaten without fighting them, the way
   * winning a gym retires the trainers the player walked past.
   */
  fun markTrainerBeaten(trainerId: Int) = setFlag(trainerFlag(region(), trainerId))

  private fun region(): Region =
      checkNotNull(Region.byWireValue(state.regionId.toByte())) {
        "Scene ran in unknown region ${state.regionId}"
      }

  /**
   * Walk the map npc with decomp local id [localId] (its entityIdx) through [steps] and wait for
   * the whole path to finish. This is applymovement plus waitmovement for an npc.
   */
  suspend fun moveNpc(localId: Int, vararg steps: MovementStep) =
      movement.moveNpc(session, state, localId, steps.toList())

  /** Starts concurrent NPC movement paths. */
  suspend fun moveNpcs(vararg paths: Pair<Int, List<MovementStep>>) =
      movement.moveNpcs(session, state, paths.toList())

  /** Starts player and NPC paths together. */
  suspend fun moveSelfAndNpcs(
      selfSteps: List<MovementStep>,
      vararg paths: Pair<Int, List<MovementStep>>,
  ) = movement.moveSelfAndNpcs(session, state, selfSteps, paths.toList())

  /** Walk the player's own avatar through [steps] and wait for it to finish. */
  suspend fun moveSelf(vararg steps: MovementStep) =
      movement.moveSelf(session, state, steps.toList())

  /** Show a normally hidden map npc (its decomp local id) to this player, the decomp addobject. */
  fun showNpc(localId: Int) = movement.showNpc(session, state, localId)

  /** Shows a hidden NPC at a new position. */
  fun showNpcAt(localId: Int, x: Int, y: Int) = movement.showNpcAt(session, state, localId, x, y)

  /** Repositions an existing NPC. */
  fun repositionNpc(localId: Int, x: Int, y: Int) =
      movement.repositionNpc(session, state, localId, x, y)

  /** Relocate the player's overworld entity as part of a cutscene. */
  fun repositionSelf(x: Int, y: Int, facing: Direction) =
      movement.repositionSelf(session, state, x, y, facing)

  /** Remove a cutscene npc and its collision (`removeobject`). */
  fun removeNpc(localId: Int) = movement.removeNpc(session, state, localId)

  /**
   * The decomp `setrespawn`: where this player wakes up after a whiteout. Gyms set it as the badge
   * is won, so it follows the player forward through the region.
   *
   * TODO Send the player here when they lose Losing a battle currently just ends it, so the point
   * is recorded and persisted but nothing acts on it yet. Making it real means healing the party
   * and warping on BattleResult.DEFEAT, which needs a coroutine scope in BattleService and a look
   * at what the client expects after the battle end packet.
   */
  fun setRespawn(regionId: Int, bankId: Int, mapId: Int, x: Int, y: Int) {
    RespawnPoint.vars(regionId, bankId, mapId, x, y).forEach { (key, value) -> setVar(key, value) }
  }

  /**
   * The walkable half of the decomp's `setmetatile`: let this player through [x], [y] on the map
   * they are standing on, and tell the client so its own collision agrees. The tile keeps its
   * graphics, since no packet carries a new metatile id, so an opened gym barrier is still drawn
   * closed.
   */
  fun openTile(x: Int, y: Int) {
    state.openedTiles.add(openedTileKey(state.regionId, state.bankId, state.mapId, x, y))
    session.send(
        MapTileAttributeSetPacket(
            blockX = x.toByte(),
            blockY = y.toByte(),
            blockZ = state.elevation.toByte(),
            attribute = WALKABLE_TILE,
        ))
  }

  /** Set where a MAP_DYNAMIC warp sends this player (the decomp setdynamicwarp). */
  fun setDynamicWarp(regionId: Int, bankId: Int, mapId: Int, x: Int, y: Int, facing: Direction) =
      movement.setDynamicWarp(
          state,
          DynamicWarp(
              regionId.toByte(), bankId.toByte(), mapId.toByte(), x.toShort(), y.toShort(), facing))

  /**
   * Warps the player without door movement, then runs the destination map's entry scripts on this
   * same coroutine, the way the decomp's warp continues into the new map's scripts.
   */
  suspend fun warp(regionId: Int, bankId: Int, mapId: Int, x: Int, y: Int, facing: Direction) {
    val warpService = checkNotNull(warp) { "Script warp service is unavailable" }
    state.scriptOwnsMapEntry = true
    try {
      warpService.warp(
          session,
          state,
          DynamicWarp(
              regionId.toByte(),
              bankId.toByte(),
              mapId.toByte(),
              x.toShort(),
              y.toShort(),
              facing,
          ),
      )
      val destination = maps?.getMap(regionId, bankId, mapId) ?: return
      val scripts = entryScripts ?: return
      scripts.onEntry(state, destination).forEach { it.run(this) }
      state.characterId?.let { charId ->
        scripts.atCoordinate(charId, destination, state.x.toInt(), state.y.toInt())?.run(this)
      }
    } finally {
      state.scriptOwnsMapEntry = false
    }
  }

  private companion object {
    // Sign boxes have no speaker, npc boxes point at the entity.
    const val SIGN = 3
    const val NPC = 4
    const val FEMALE: Byte = 1
    const val STORY_PLAYER_UNAVAILABLE = "Story player service is unavailable"

    /**
     * The tile attribute byte for "nothing blocks this square". [de.fiereu.openmmo.common.Tile2D]
     * reads the low two bits of the same field as the collision, so zero is walkable.
     */
    const val WALKABLE_TILE: Byte = 0

    /** Region namespaced like the generated story keys, since ids repeat across the two games. */
    fun trainerFlag(region: Region, trainerId: Int) =
        "${region.name.lowercase()}/TRAINER_BEATEN_$trainerId"
  }
}
