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
 * trainerbattle_single TRAINER_BURGLAR_SIMON, PokemonMansion_1F_Text_SimonIntro, PokemonMansion_1F_Text_SimonDefeat
 * msgbox PokemonMansion_1F_Text_SimonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonMansion_3F_EventScript_Simon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BURGLAR_SIMON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonMansion_1F.SimonPostBattle)
    }
    ctx.say(PokemonMansion_1F.SimonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonMansion_1F.SimonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SCIENTIST_BRAYDON, PokemonMansion_1F_Text_BraydonIntro, PokemonMansion_1F_Text_BraydonDefeat
 * msgbox PokemonMansion_1F_Text_BraydonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object PokemonMansion_3F_EventScript_Braydon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SCIENTIST_BRAYDON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(PokemonMansion_1F.BraydonPostBattle)
    }
    ctx.say(PokemonMansion_1F.BraydonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(PokemonMansion_1F.BraydonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_POTION
 * end
 * ```
 */
internal object PokemonMansion_3F_EventScript_ItemMaxPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_POTION, KantoFlags.FLAG_HIDE_POKEMON_MANSION_3F_MAX_POTION, 2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_IRON
 * end
 * ```
 */
internal object PokemonMansion_3F_EventScript_ItemIron : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.IRON, KantoFlags.FLAG_HIDE_POKEMON_MANSION_3F_IRON, 3)
  }
}

internal object PokemonMansion_3F_EventScript_DiaryFeb6th : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PokemonMansion_1F.MewGaveBirthToMewtwo)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8004, 2
 * call PokemonMansion_EventScript_SecretSwitch
 * playse SE_UNLOCK
 * special DrawWholeMapView
 * waitse
 * releaseall
 * end
 * ```
 */
internal object PokemonMansion_3F_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PokemonMansion_3F_EventScript_Statue")
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
