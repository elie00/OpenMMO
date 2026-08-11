package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PokemonMansion_1F_EventScript_Ted : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_TED,
          PokemonMansion_1F.TedIntro,
          PokemonMansion_1F.TedDefeat,
          PokemonMansion_1F.TedPostBattle,
      )
}

internal object PokemonMansion_1F_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CARBOS)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_1F_CARBOS)
  }
}

internal object PokemonMansion_1F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ESCAPE_ROPE)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_1F_ESCAPE_ROPE)
  }
}

internal object PokemonMansion_1F_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PROTEIN)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_1F_PROTEIN)
  }
}

internal object PokemonMansion_1F_EventScript_Johnson : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_JOHNSON,
          PokemonMansion_1F.JohnsonIntro,
          PokemonMansion_1F.JohnsonDefeat,
          PokemonMansion_1F.JohnsonPostBattle,
      )
}

internal object PokemonMansion_1F_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = pokemonMansionSwitch(ctx)
}

internal val PokemonMansion_1FScripts: Map<String, Script> =
    mapOf(
        "PokemonMansion_1F_EventScript_Ted" to PokemonMansion_1F_EventScript_Ted,
        "PokemonMansion_1F_EventScript_ItemCarbos" to PokemonMansion_1F_EventScript_ItemCarbos,
        "PokemonMansion_1F_EventScript_ItemEscapeRope" to
            PokemonMansion_1F_EventScript_ItemEscapeRope,
        "PokemonMansion_1F_EventScript_ItemProtein" to PokemonMansion_1F_EventScript_ItemProtein,
        "PokemonMansion_1F_EventScript_Johnson" to PokemonMansion_1F_EventScript_Johnson,
        "PokemonMansion_1F_EventScript_Statue" to PokemonMansion_1F_EventScript_Statue,
    )
