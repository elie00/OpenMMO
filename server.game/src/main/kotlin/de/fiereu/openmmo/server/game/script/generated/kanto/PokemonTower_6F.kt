package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonTower_6F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANNELER_ANGELICA, PokemonTower_6F_Text_AngelicaIntro, PokemonTower_6F_Text_AngelicaDefeat
 * msgbox PokemonTower_6F_Text_AngelicaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonTower_6F_EventScript_Angelica : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CHANNELER_ANGELICA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonTower_6F.AngelicaPostBattle)
    }
    ctx.say(PokemonTower_6F.AngelicaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonTower_6F.AngelicaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANNELER_JENNIFER, PokemonTower_6F_Text_JenniferIntro, PokemonTower_6F_Text_JenniferDefeat
 * msgbox PokemonTower_6F_Text_JenniferPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonTower_6F_EventScript_Jennifer : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CHANNELER_JENNIFER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonTower_6F.JenniferPostBattle)
    }
    ctx.say(PokemonTower_6F.JenniferIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonTower_6F.JenniferDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANNELER_EMILIA, PokemonTower_6F_Text_EmiliaIntro, PokemonTower_6F_Text_EmiliaDefeat
 * msgbox PokemonTower_6F_Text_EmiliaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonTower_6F_EventScript_Emilia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CHANNELER_EMILIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonTower_6F.EmiliaPostBattle)
    }
    ctx.say(PokemonTower_6F.EmiliaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonTower_6F.EmiliaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object PokemonTower_6F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.RARE_CANDY, KantoFlags.FLAG_HIDE_POKEMON_TOWER_6F_RARE_CANDY, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_X_ACCURACY
 * end
 * ```
 */
internal object PokemonTower_6F_EventScript_ItemXAccuracy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.X_ACCURACY, KantoFlags.FLAG_HIDE_POKEMON_TOWER_6F_X_ACCURACY, 4)
  }
}

internal val PokemonTower_6FScripts: Map<String, Script> =
    mapOf(
        "PokemonTower_6F_EventScript_Angelica" to PokemonTower_6F_EventScript_Angelica,
        "PokemonTower_6F_EventScript_Jennifer" to PokemonTower_6F_EventScript_Jennifer,
        "PokemonTower_6F_EventScript_Emilia" to PokemonTower_6F_EventScript_Emilia,
        "PokemonTower_6F_EventScript_ItemRareCandy" to PokemonTower_6F_EventScript_ItemRareCandy,
        "PokemonTower_6F_EventScript_ItemXAccuracy" to PokemonTower_6F_EventScript_ItemXAccuracy,
    )
