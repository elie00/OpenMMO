package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PokemonMansion_3F_EventScript_Simon : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BURGLAR_SIMON,
          PokemonMansion_1F.SimonIntro,
          PokemonMansion_1F.SimonDefeat,
          PokemonMansion_1F.SimonPostBattle,
      )
}

internal object PokemonMansion_3F_EventScript_Braydon : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_BRAYDON,
          PokemonMansion_1F.BraydonIntro,
          PokemonMansion_1F.BraydonDefeat,
          PokemonMansion_1F.BraydonPostBattle,
      )
}

internal object PokemonMansion_3F_EventScript_ItemMaxPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_POTION)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_3F_MAX_POTION)
  }
}

internal object PokemonMansion_3F_EventScript_ItemIron : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.IRON)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_3F_IRON)
  }
}

internal object PokemonMansion_3F_EventScript_DiaryFeb6th : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PokemonMansion_1F.MewGaveBirthToMewtwo)
}

internal object PokemonMansion_3F_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = pokemonMansionSwitch(ctx)
}

internal val PokemonMansion_3FScripts: Map<String, Script> =
    mapOf(
        "PokemonMansion_3F_EventScript_Simon" to PokemonMansion_3F_EventScript_Simon,
        "PokemonMansion_3F_EventScript_Braydon" to PokemonMansion_3F_EventScript_Braydon,
        "PokemonMansion_3F_EventScript_ItemMaxPotion" to
            PokemonMansion_3F_EventScript_ItemMaxPotion,
        "PokemonMansion_3F_EventScript_ItemIron" to PokemonMansion_3F_EventScript_ItemIron,
        "PokemonMansion_3F_EventScript_DiaryFeb6th" to PokemonMansion_3F_EventScript_DiaryFeb6th,
        "PokemonMansion_3F_EventScript_Statue" to PokemonMansion_3F_EventScript_Statue,
    )
