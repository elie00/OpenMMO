package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route103
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_DOWN
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_DOWN
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars
import de.fiereu.openmmo.trainer.generated.HoennTrainers

private const val LOCALID_RIVAL = 1

internal object Route103_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route103.ShortcutToOldale)
}

internal object Route103_EventScript_Rival : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_RIVAL_ROUTE103)) return
    val femalePlayer = ctx.isFemale
    if (femalePlayer) {
      ctx.say(Route103.BrendanRoute103Pokemon)
      ctx.say(Route103.BrendanLetsBattle)
    } else {
      ctx.say(Route103.MayRoute103Pokemon)
      ctx.say(Route103.MayLetsBattle)
    }

    val opponent =
        when (ctx.getVar(HoennVars.VAR_STARTER_MON)) {
          0 -> 255 // Treecko player -> Torchic rival
          1 -> 258 // Torchic player -> Mudkip rival
          else -> 252 // Mudkip player -> Treecko rival
        }
    val moves =
        when (opponent) {
          252 -> intArrayOf(1, 43)
          255 -> intArrayOf(10, 45)
          else -> intArrayOf(33, 45)
        }
    if (ctx.battle(opponent, 5, *moves) != BattleResult.VICTORY) return

    if (femalePlayer) {
      ctx.say(Route103.BrendanDefeated)
      ctx.say(Route103.BrendanTimeToHeadBack)
    } else {
      ctx.say(Route103.MayDefeated)
      ctx.say(Route103.MayTimeToHeadBack)
    }
    ctx.moveNpc(LOCALID_RIVAL, WALK_DOWN, WALK_DOWN, WALK_DOWN, WALK_DOWN, FACE_DOWN)
    ctx.setFlag(HoennFlags.FLAG_HIDE_ROUTE_103_RIVAL)
    ctx.setVar(HoennVars.VAR_BIRCH_LAB_STATE, 4)
    ctx.clearFlag(HoennFlags.FLAG_HIDE_LITTLEROOT_TOWN_BIRCHS_LAB_RIVAL)
    ctx.setFlag(HoennFlags.FLAG_DEFEATED_RIVAL_ROUTE103)
    ctx.setVar(HoennVars.VAR_OLDALE_RIVAL_STATE, 1)
    ctx.clearFlag(HoennFlags.FLAG_HIDE_OLDALE_TOWN_RIVAL)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DAISY, Route103_Text_DaisyIntro, Route103_Text_DaisyDefeated
 * msgbox Route103_Text_DaisyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Daisy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DAISY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route103.DaisyPostBattle)
    }
    ctx.say(Route103.DaisyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route103.DaisyDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_AMY_AND_LIV_1, Route103_Text_LivIntro, Route103_Text_LivDefeated, Route103_Text_LivNotEnoughPokemon, Route102_EventScript_LivRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route102_EventScript_LivRematch
 * msgbox Route103_Text_LivPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Liv : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route103_EventScript_Liv")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_AMY_AND_LIV_1, Route103_Text_AmyIntro, Route103_Text_AmyDefeated, Route103_Text_AmyNotEnoughPokemon, Route102_EventScript_AmyRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route102_EventScript_AmyRematch
 * msgbox Route103_Text_AmyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Amy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route103_EventScript_Amy")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ANDREW, Route103_Text_AndrewIntro, Route103_Text_AndrewDefeated
 * msgbox Route103_Text_AndrewPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Andrew : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ANDREW
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route103.AndrewPostBattle)
    }
    ctx.say(Route103.AndrewIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route103.AndrewDefeated)
  }
}

internal object Route103_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route103.ShouldHaveBroughtPotion)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_MIGUEL_1, Route103_Text_MiguelIntro, Route103_Text_MiguelDefeated, Route102_EventScript_MiguelRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route103_EventScript_MiguelRematch
 * msgbox Route103_Text_MiguelPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route103_EventScript_Miguel : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route103_EventScript_Miguel")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_GUARD_SPEC
 * end
 * ```
 */
internal object Route103_EventScript_ItemGuardSpec : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.GUARD_SPEC, HoennFlags.FLAG_ITEM_ROUTE_103_GUARD_SPEC, 12)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RHETT, Route103_Text_RhettIntro, Route103_Text_RhettDefeated
 * msgbox Route103_Text_RhettPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Rhett : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RHETT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route103.RhettPostBattle)
    }
    ctx.say(Route103.RhettIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route103.RhettDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MARCOS, Route103_Text_MarcosIntro, Route103_Text_MarcosDefeated
 * msgbox Route103_Text_MarcosPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Marcos : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MARCOS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route103.MarcosPostBattle)
    }
    ctx.say(Route103.MarcosIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route103.MarcosDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ISABELLE, Route103_Text_IsabelleIntro, Route103_Text_IsabelleDefeated
 * msgbox Route103_Text_IsabellePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Isabelle : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ISABELLE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route103.IsabellePostBattle)
    }
    ctx.say(Route103.IsabelleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route103.IsabelleDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PETE, Route103_Text_PeteIntro, Route103_Text_PeteDefeated
 * msgbox Route103_Text_PetePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_Pete : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PETE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route103.PetePostBattle)
    }
    ctx.say(Route103.PeteIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route103.PeteDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object Route103_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, HoennFlags.FLAG_ITEM_ROUTE_103_PP_UP, 19)
  }
}

internal object Route103_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route103.RouteSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_MIGUEL_1, Route103_Text_MiguelRematchIntro, Route103_Text_MiguelRematchDefeated
 * msgbox Route103_Text_MiguelRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route103_EventScript_MiguelRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route103_EventScript_MiguelRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_AMY_AND_LIV_1, Route103_Text_LivRematchIntro, Route103_Text_LivRematchDefeated, Route103_Text_LivRematchNotEnoughPokemon
 * msgbox Route103_Text_LivRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route102_EventScript_LivRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route102_EventScript_LivRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_AMY_AND_LIV_1, Route103_Text_AmyRematchIntro, Route103_Text_AmyRematchDefeated, Route103_Text_AmyRematchNotEnoughPokemon
 * msgbox Route103_Text_AmyRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route102_EventScript_AmyRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route102_EventScript_AmyRematch")
}

internal val Route103Scripts: Map<String, Script> =
    mapOf(
        "Route103_EventScript_Man" to Route103_EventScript_Man,
        "Route103_EventScript_Rival" to Route103_EventScript_Rival,
        "Route103_EventScript_Daisy" to Route103_EventScript_Daisy,
        "Route103_EventScript_Liv" to Route103_EventScript_Liv,
        "Route103_EventScript_Amy" to Route103_EventScript_Amy,
        "Route103_EventScript_Andrew" to Route103_EventScript_Andrew,
        "Route103_EventScript_Boy" to Route103_EventScript_Boy,
        "Route103_EventScript_Miguel" to Route103_EventScript_Miguel,
        "Route103_EventScript_ItemGuardSpec" to Route103_EventScript_ItemGuardSpec,
        "Route103_EventScript_Rhett" to Route103_EventScript_Rhett,
        "Route103_EventScript_Marcos" to Route103_EventScript_Marcos,
        "Route103_EventScript_Isabelle" to Route103_EventScript_Isabelle,
        "Route103_EventScript_Pete" to Route103_EventScript_Pete,
        "Route103_EventScript_ItemPPUp" to Route103_EventScript_ItemPPUp,
        "Route103_EventScript_RouteSign" to Route103_EventScript_RouteSign,
        "Route103_EventScript_MiguelRematch" to Route103_EventScript_MiguelRematch,
        "Route102_EventScript_LivRematch" to Route102_EventScript_LivRematch,
        "Route102_EventScript_AmyRematch" to Route102_EventScript_AmyRematch,
    )
