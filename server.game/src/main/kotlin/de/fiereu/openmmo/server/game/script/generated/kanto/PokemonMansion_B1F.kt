package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion_B1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object PokemonMansion_B1F_EventScript_ItemTM22 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM22)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_B1F_TM22)
  }
}

internal object PokemonMansion_B1F_EventScript_Lewis : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BURGLAR_LEWIS,
          PokemonMansion_B1F.LewisIntro,
          PokemonMansion_B1F.LewisDefeat,
          PokemonMansion_B1F.LewisPostBattle,
      )
}

internal object PokemonMansion_B1F_EventScript_Ivan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_IVAN,
          PokemonMansion_B1F.IvanIntro,
          PokemonMansion_B1F.IvanDefeat,
          PokemonMansion_B1F.IvanPostBattle,
      )
}

internal object PokemonMansion_B1F_EventScript_ItemTM14 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM14)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_B1F_TM14)
  }
}

internal object PokemonMansion_B1F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_RESTORE)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_B1F_FULL_RESTORE)
  }
}

internal object PokemonMansion_B1F_EventScript_ItemSecretKey : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.SECRET_KEY)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POKEMON_MANSION_B1F_SECRET_KEY)
  }
}

internal object PokemonMansion_B1F_EventScript_DiarySep1st : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PokemonMansion_B1F.MewtwoIsFarTooPowerful)
}

internal object PokemonMansion_B1F_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = pokemonMansionSwitch(ctx)
}

internal val PokemonMansion_B1FScripts: Map<String, Script> =
    mapOf(
        "PokemonMansion_B1F_EventScript_ItemTM22" to PokemonMansion_B1F_EventScript_ItemTM22,
        "PokemonMansion_B1F_EventScript_Lewis" to PokemonMansion_B1F_EventScript_Lewis,
        "PokemonMansion_B1F_EventScript_Ivan" to PokemonMansion_B1F_EventScript_Ivan,
        "PokemonMansion_B1F_EventScript_ItemTM14" to PokemonMansion_B1F_EventScript_ItemTM14,
        "PokemonMansion_B1F_EventScript_ItemFullRestore" to
            PokemonMansion_B1F_EventScript_ItemFullRestore,
        "PokemonMansion_B1F_EventScript_ItemSecretKey" to
            PokemonMansion_B1F_EventScript_ItemSecretKey,
        "PokemonMansion_B1F_EventScript_DiarySep1st" to PokemonMansion_B1F_EventScript_DiarySep1st,
        "PokemonMansion_B1F_EventScript_Statue" to PokemonMansion_B1F_EventScript_Statue,
    )
