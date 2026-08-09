package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SCIENTIST_TED, PokemonMansion_1F_Text_TedIntro, PokemonMansion_1F_Text_TedDefeat
 * msgbox PokemonMansion_1F_Text_TedPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonMansion_1F_EventScript_Ted : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SCIENTIST_TED
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonMansion_1F.TedPostBattle)
    }
    ctx.say(PokemonMansion_1F.TedIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonMansion_1F.TedDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARBOS
 * end
 * ```
 */
internal object PokemonMansion_1F_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARBOS, KantoFlags.FLAG_HIDE_POKEMON_MANSION_1F_CARBOS, 1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ESCAPE_ROPE
 * end
 * ```
 */
internal object PokemonMansion_1F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ESCAPE_ROPE, KantoFlags.FLAG_HIDE_POKEMON_MANSION_1F_ESCAPE_ROPE, 2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PROTEIN
 * end
 * ```
 */
internal object PokemonMansion_1F_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PROTEIN, KantoFlags.FLAG_HIDE_POKEMON_MANSION_1F_PROTEIN, 3)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_JOHNSON, PokemonMansion_1F_Text_JohnsonIntro, PokemonMansion_1F_Text_JohnsonDefeat
 * msgbox PokemonMansion_1F_Text_JohnsonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonMansion_1F_EventScript_Johnson : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_JOHNSON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonMansion_1F.JohnsonPostBattle)
    }
    ctx.say(PokemonMansion_1F.JohnsonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonMansion_1F.JohnsonDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8004, 0
 * call PokemonMansion_EventScript_SecretSwitch
 * playse SE_UNLOCK
 * special DrawWholeMapView
 * waitse
 * releaseall
 * end
 * ```
 */
internal object PokemonMansion_1F_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PokemonMansion_1F_EventScript_Statue")
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
