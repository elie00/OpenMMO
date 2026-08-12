package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonLeague_LoreleisRoom
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
internal object PokemonLeague_LoreleisRoom_EventScript_Lorelei : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_LORELEI)) {
      return ctx.say(PokemonLeague_LoreleisRoom.PostBattle)
    }
    ctx.say(PokemonLeague_LoreleisRoom.Intro)
    // trainerbattle_no_intro: the intro box above is theirs.
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_ELITE_FOUR_LORELEI) != BattleResult.VICTORY)
        return
    ctx.say(PokemonLeague_LoreleisRoom.Defeat)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_LORELEI)
    ctx.say(PokemonLeague_LoreleisRoom.PostBattle)
  }
}

internal val PokemonLeague_LoreleisRoomScripts: Map<String, Script> =
    mapOf(
        "PokemonLeague_LoreleisRoom_EventScript_Lorelei" to
            PokemonLeague_LoreleisRoom_EventScript_Lorelei,
    )
