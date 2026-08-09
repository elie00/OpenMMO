package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion
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

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PokemonMansion_Text_PressSecretSwitch, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, PokemonMansion_EventScript_DontPressSwitch
 * msgbox PokemonMansion_Text_WhoWouldnt
 * goto_if_set FLAG_POKEMON_MANSION_SWITCH_STATE, PokemonMansion_EventScript_ResetSwitch
 * setflag FLAG_POKEMON_MANSION_SWITCH_STATE
 * switch VAR_0x8004
 * case 0, PokemonMansion_EventScript_PressSwitch_1F
 * case 1, PokemonMansion_EventScript_PressSwitch_2F
 * case 2, PokemonMansion_EventScript_PressSwitch_3F
 * case 3, PokemonMansion_EventScript_PressSwitch_B1F
 * end
 * ```
 */
internal object PokemonMansion_EventScript_SecretSwitch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonMansion_EventScript_SecretSwitch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * clearflag FLAG_POKEMON_MANSION_SWITCH_STATE
 * switch VAR_0x8004
 * case 0, PokemonMansion_EventScript_ResetSwitch_1F
 * case 1, PokemonMansion_EventScript_ResetSwitch_2F
 * case 2, PokemonMansion_EventScript_ResetSwitch_3F
 * case 3, PokemonMansion_EventScript_ResetSwitch_B1F
 * end
 * ```
 */
internal object PokemonMansion_EventScript_ResetSwitch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PokemonMansion_EventScript_ResetSwitch")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonMansion_Text_NotQuiteYet
 * releaseall
 * end
 * ```
 */
internal object PokemonMansion_EventScript_DontPressSwitch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonMansion.NotQuiteYet)
  }
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
        "PokemonMansion_EventScript_SecretSwitch" to PokemonMansion_EventScript_SecretSwitch,
        "PokemonMansion_EventScript_ResetSwitch" to PokemonMansion_EventScript_ResetSwitch,
        "PokemonMansion_EventScript_DontPressSwitch" to PokemonMansion_EventScript_DontPressSwitch,
    )
