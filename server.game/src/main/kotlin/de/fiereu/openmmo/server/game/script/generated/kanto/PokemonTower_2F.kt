package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonTower_2F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_RIVAL = 0

internal object PokemonTower_2F_EventScript_Channeler : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(PokemonTower_2F.SilphScopeCouldUnmaskGhosts)
}

/**
 * The rival is on his way out of the tower, which the map's two coord events fire. He fights with
 * the starter that beats the player's, as he does everywhere else.
 */
internal object PokemonTower_2F_EventScript_Rival : Script {
  override suspend fun run(ctx: ScriptContext) {
    val rival =
        when (Starter.byStarterNumber(ctx.getVar(KantoVars.VAR_STARTER_MON))?.rival) {
          Starter.BULBASAUR_BALL -> KantoTrainerIds.TRAINER_RIVAL_POKEMON_TOWER_BULBASAUR
          Starter.SQUIRTLE_BALL -> KantoTrainerIds.TRAINER_RIVAL_POKEMON_TOWER_SQUIRTLE
          Starter.CHARMANDER_BALL -> KantoTrainerIds.TRAINER_RIVAL_POKEMON_TOWER_CHARMANDER
          null -> return
        }
    // The decomp turns the two of them to face each other and puts an exclamation mark over him
    // first, neither of which has a verb.
    ctx.sayNpc(LOCALID_RIVAL, PokemonTower_2F.RivalIntro)
    // trainerbattle_no_intro: the intro box above is his.
    if (ctx.trainerBattle(rival) != BattleResult.VICTORY) return
    ctx.sayNpc(LOCALID_RIVAL, PokemonTower_2F.RivalDefeat)
    ctx.sayNpc(LOCALID_RIVAL, PokemonTower_2F.RivalPostBattle)
    ctx.removeNpc(LOCALID_RIVAL)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_POKEMON_TOWER_2F, 1)
  }
}

internal object PokemonTower_2F_EventScript_RivalTriggerDown : Script {
  override suspend fun run(ctx: ScriptContext) = PokemonTower_2F_EventScript_Rival.run(ctx)
}

internal object PokemonTower_2F_EventScript_RivalTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) = PokemonTower_2F_EventScript_Rival.run(ctx)
}

internal val PokemonTower_2FScripts: Map<String, Script> =
    mapOf(
        "PokemonTower_2F_EventScript_Channeler" to PokemonTower_2F_EventScript_Channeler,
        "PokemonTower_2F_EventScript_Rival" to PokemonTower_2F_EventScript_Rival,
        "PokemonTower_2F_EventScript_RivalTriggerDown" to
            PokemonTower_2F_EventScript_RivalTriggerDown,
        "PokemonTower_2F_EventScript_RivalTriggerRight" to
            PokemonTower_2F_EventScript_RivalTriggerRight,
    )
