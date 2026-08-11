package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonTower_4F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PokemonTower_4F_EventScript_Laurel : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_LAUREL,
          PokemonTower_4F.LaurelIntro,
          PokemonTower_4F.LaurelDefeat,
          PokemonTower_4F.LaurelPostBattle,
      )
}

internal object PokemonTower_4F_EventScript_Jody : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_JODY,
          PokemonTower_4F.JodyIntro,
          PokemonTower_4F.JodyDefeat,
          PokemonTower_4F.JodyPostBattle,
      )
}

internal object PokemonTower_4F_EventScript_Paula : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_PAULA,
          PokemonTower_4F.PaulaIntro,
          PokemonTower_4F.PaulaDefeat,
          PokemonTower_4F.PaulaPostBattle,
      )
}

internal object PokemonTower_4F_EventScript_ItemElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ELIXIR)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_TOWER_4F_ELIXIR)
  }
}

internal object PokemonTower_4F_EventScript_ItemAwakening : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.AWAKENING)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_TOWER_4F_AWAKENING)
  }
}

internal object PokemonTower_4F_EventScript_ItemGreatBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.GREAT_BALL)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_TOWER_4F_GREAT_BALL)
  }
}

internal val PokemonTower_4FScripts: Map<String, Script> =
    mapOf(
        "PokemonTower_4F_EventScript_Laurel" to PokemonTower_4F_EventScript_Laurel,
        "PokemonTower_4F_EventScript_Jody" to PokemonTower_4F_EventScript_Jody,
        "PokemonTower_4F_EventScript_Paula" to PokemonTower_4F_EventScript_Paula,
        "PokemonTower_4F_EventScript_ItemElixir" to PokemonTower_4F_EventScript_ItemElixir,
        "PokemonTower_4F_EventScript_ItemAwakening" to PokemonTower_4F_EventScript_ItemAwakening,
        "PokemonTower_4F_EventScript_ItemGreatBall" to PokemonTower_4F_EventScript_ItemGreatBall,
    )
