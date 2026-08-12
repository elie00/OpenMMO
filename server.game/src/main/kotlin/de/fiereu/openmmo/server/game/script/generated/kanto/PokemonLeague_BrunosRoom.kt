package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonLeague_BrunosRoom
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/**
 * One of the Elite Four. The decomp seals the room behind the player on the way in and opens the
 * far door on the win, both with setmetatile; the generated maps carry the open layout, so only the
 * flag moves.
 *
 * Its rematch team is gated on a link with Ruby or Sapphire, which the player cannot have here.
 */
internal object PokemonLeague_BrunosRoom_EventScript_Bruno : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_BRUNO)) {
      return ctx.say(PokemonLeague_BrunosRoom.PostBattle)
    }
    ctx.say(PokemonLeague_BrunosRoom.Intro)
    // trainerbattle_no_intro: the intro box above is theirs.
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_ELITE_FOUR_BRUNO) != BattleResult.VICTORY) return
    ctx.say(PokemonLeague_BrunosRoom.Defeat)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_BRUNO)
    ctx.say(PokemonLeague_BrunosRoom.PostBattle)
  }
}

internal val PokemonLeague_BrunosRoomScripts: Map<String, Script> =
    mapOf(
        "PokemonLeague_BrunosRoom_EventScript_Bruno" to PokemonLeague_BrunosRoom_EventScript_Bruno,
    )
