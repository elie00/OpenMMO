package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.common.enums.Direction
import de.fiereu.openmmo.dialog.generated.kanto.PokemonTower_7F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Decomp local ids of this floor's object events.
private const val LOCALID_GRUNT1 = 1
private const val LOCALID_GRUNT2 = 2
private const val LOCALID_GRUNT3 = 3

private const val KANTO = 0
private const val POKEHOUSE_BANK = 8
private const val POKEHOUSE_MAP = 2

internal object PokemonTower_7F_EventScript_MrFuji : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_HIDE_TOWER_FUJI)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_POKEHOUSE_FUJI)
    ctx.setFlag(KantoFlags.FLAG_RESCUED_MR_FUJI)
    ctx.say(PokemonTower_7F.MrFujiThankYouFollowMe)
    // He walks the player home, which the decomp does with a plain warp.
    ctx.warp(KANTO, POKEHOUSE_BANK, POKEHOUSE_MAP, x = 4, y = 7, facing = Direction.DOWN)
  }
}

internal object PokemonTower_7F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_19)) {
      return ctx.say(PokemonTower_7F.Grunt1PostBattle)
    }
    ctx.say(PokemonTower_7F.Grunt1Intro)
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_19) != BattleResult.VICTORY)
        return
    ctx.say(PokemonTower_7F.Grunt1Defeat)
    ctx.say(PokemonTower_7F.Grunt1PostBattle)
    // He clears out rather than standing there beaten. The decomp picks his way to the stairs from
    // where the player is standing, which is presentation this cannot follow.
    ctx.removeNpc(LOCALID_GRUNT1)
  }
}

internal object PokemonTower_7F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_20)) {
      return ctx.say(PokemonTower_7F.Grunt2PostBattle)
    }
    ctx.say(PokemonTower_7F.Grunt2Intro)
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_20) != BattleResult.VICTORY)
        return
    ctx.say(PokemonTower_7F.Grunt2Defeat)
    ctx.say(PokemonTower_7F.Grunt2PostBattle)
    // He clears out rather than standing there beaten. The decomp picks his way to the stairs from
    // where the player is standing, which is presentation this cannot follow.
    ctx.removeNpc(LOCALID_GRUNT2)
  }
}

internal object PokemonTower_7F_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_21)) {
      return ctx.say(PokemonTower_7F.Grunt3PostBattle)
    }
    ctx.say(PokemonTower_7F.Grunt3Intro)
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_21) != BattleResult.VICTORY)
        return
    ctx.say(PokemonTower_7F.Grunt3Defeat)
    ctx.say(PokemonTower_7F.Grunt3PostBattle)
    // He clears out rather than standing there beaten. The decomp picks his way to the stairs from
    // where the player is standing, which is presentation this cannot follow.
    ctx.removeNpc(LOCALID_GRUNT3)
  }
}

internal val PokemonTower_7FScripts: Map<String, Script> =
    mapOf(
        "PokemonTower_7F_EventScript_MrFuji" to PokemonTower_7F_EventScript_MrFuji,
        "PokemonTower_7F_EventScript_Grunt1" to PokemonTower_7F_EventScript_Grunt1,
        "PokemonTower_7F_EventScript_Grunt2" to PokemonTower_7F_EventScript_Grunt2,
        "PokemonTower_7F_EventScript_Grunt3" to PokemonTower_7F_EventScript_Grunt3,
    )
