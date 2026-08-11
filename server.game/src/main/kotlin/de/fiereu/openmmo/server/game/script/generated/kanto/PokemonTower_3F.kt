package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonTower_3F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PokemonTower_3F_EventScript_Patricia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_PATRICIA,
          PokemonTower_3F.PatriciaIntro,
          PokemonTower_3F.PatriciaDefeat,
          PokemonTower_3F.PatriciaPostBattle,
      )
}

internal object PokemonTower_3F_EventScript_Carly : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_CARLY,
          PokemonTower_3F.CarlyIntro,
          PokemonTower_3F.CarlyDefeat,
          PokemonTower_3F.CarlyPostBattle,
      )
}

internal object PokemonTower_3F_EventScript_Hope : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_HOPE,
          PokemonTower_3F.HopeIntro,
          PokemonTower_3F.HopeDefeat,
          PokemonTower_3F.HopePostBattle,
      )
}

internal object PokemonTower_3F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ESCAPE_ROPE)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_TOWER_3F_ESCAPE_ROPE)
  }
}

internal val PokemonTower_3FScripts: Map<String, Script> =
    mapOf(
        "PokemonTower_3F_EventScript_Patricia" to PokemonTower_3F_EventScript_Patricia,
        "PokemonTower_3F_EventScript_Carly" to PokemonTower_3F_EventScript_Carly,
        "PokemonTower_3F_EventScript_Hope" to PokemonTower_3F_EventScript_Hope,
        "PokemonTower_3F_EventScript_ItemEscapeRope" to PokemonTower_3F_EventScript_ItemEscapeRope,
    )
