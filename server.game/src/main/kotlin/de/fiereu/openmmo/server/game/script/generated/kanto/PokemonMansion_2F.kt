package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PokemonMansion_2F_EventScript_Arnie : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BURGLAR_ARNIE,
          PokemonMansion_1F.ArnieIntro,
          PokemonMansion_1F.ArnieDefeat,
          PokemonMansion_1F.ArniePostBattle,
      )
}

internal object PokemonMansion_2F_EventScript_ItemCalcium : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CALCIUM)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_2F_CALCIUM)
  }
}

internal object PokemonMansion_2F_EventScript_ItemZinc : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ZINC)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_2F_ZINC)
  }
}

internal object PokemonMansion_2F_EventScript_ItemHPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.HP_UP)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_2F_HP_UP)
  }
}

internal object PokemonMansion_2F_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = pokemonMansionSwitch(ctx)
}

internal object PokemonMansion_2F_EventScript_DiaryJuly10th : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(PokemonMansion_1F.ChristenedDiscoveredMonMew)
}

internal object PokemonMansion_2F_EventScript_DiaryJuly5th : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(PokemonMansion_1F.NewMonDiscoveredInGuyanaJungle)
}

internal val PokemonMansion_2FScripts: Map<String, Script> =
    mapOf(
        "PokemonMansion_2F_EventScript_Arnie" to PokemonMansion_2F_EventScript_Arnie,
        "PokemonMansion_2F_EventScript_ItemCalcium" to PokemonMansion_2F_EventScript_ItemCalcium,
        "PokemonMansion_2F_EventScript_ItemZinc" to PokemonMansion_2F_EventScript_ItemZinc,
        "PokemonMansion_2F_EventScript_ItemHPUp" to PokemonMansion_2F_EventScript_ItemHPUp,
        "PokemonMansion_2F_EventScript_Statue" to PokemonMansion_2F_EventScript_Statue,
        "PokemonMansion_2F_EventScript_DiaryJuly10th" to
            PokemonMansion_2F_EventScript_DiaryJuly10th,
        "PokemonMansion_2F_EventScript_DiaryJuly5th" to PokemonMansion_2F_EventScript_DiaryJuly5th,
    )
