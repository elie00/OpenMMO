package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonTower_3F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANNELER_PATRICIA, PokemonTower_3F_Text_PatriciaIntro, PokemonTower_3F_Text_PatriciaDefeat
 * msgbox PokemonTower_3F_Text_PatriciaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonTower_3F_EventScript_Patricia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CHANNELER_PATRICIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonTower_3F.PatriciaPostBattle)
    }
    ctx.say(PokemonTower_3F.PatriciaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonTower_3F.PatriciaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANNELER_CARLY, PokemonTower_3F_Text_CarlyIntro, PokemonTower_3F_Text_CarlyDefeat
 * msgbox PokemonTower_3F_Text_CarlyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonTower_3F_EventScript_Carly : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CHANNELER_CARLY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonTower_3F.CarlyPostBattle)
    }
    ctx.say(PokemonTower_3F.CarlyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonTower_3F.CarlyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHANNELER_HOPE, PokemonTower_3F_Text_HopeIntro, PokemonTower_3F_Text_HopeDefeat
 * msgbox PokemonTower_3F_Text_HopePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonTower_3F_EventScript_Hope : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CHANNELER_HOPE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonTower_3F.HopePostBattle)
    }
    ctx.say(PokemonTower_3F.HopeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonTower_3F.HopeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ESCAPE_ROPE
 * end
 * ```
 */
internal object PokemonTower_3F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ESCAPE_ROPE, KantoFlags.FLAG_HIDE_POKEMON_TOWER_3F_ESCAPE_ROPE, 3)
  }
}

internal val PokemonTower_3FScripts: Map<String, Script> =
    mapOf(
        "PokemonTower_3F_EventScript_Patricia" to PokemonTower_3F_EventScript_Patricia,
        "PokemonTower_3F_EventScript_Carly" to PokemonTower_3F_EventScript_Carly,
        "PokemonTower_3F_EventScript_Hope" to PokemonTower_3F_EventScript_Hope,
        "PokemonTower_3F_EventScript_ItemEscapeRope" to PokemonTower_3F_EventScript_ItemEscapeRope,
    )
