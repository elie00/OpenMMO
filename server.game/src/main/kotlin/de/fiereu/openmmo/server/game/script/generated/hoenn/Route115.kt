package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route115
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object Route115_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(Route115.NeverKnowWhenCavePokemonWillAppear)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_TIMOTHY_1, Route115_Text_TimothyIntro, Route115_Text_TimothyDefeat, Route115_EventScript_RegisterTimothy
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route115_EventScript_RematchTimothy
 * msgbox Route115_Text_TimothyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route115_EventScript_Timothy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_Timothy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_NOB_1, Route115_Text_NobIntro, Route115_Text_NobDefeat, Route115_EventScript_RegisterNob
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route115_EventScript_RematchNob
 * msgbox Route115_Text_NobPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route115_EventScript_Nob : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_Nob")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_CYNDY_1, Route115_Text_CyndyIntro, Route115_Text_CyndyDefeat, Route115_EventScript_RegisterCyndy
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route115_EventScript_RematchCyndy
 * msgbox Route115_Text_CyndyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route115_EventScript_Cyndy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_Cyndy")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KOICHI, Route115_Text_KoichiIntro, Route115_Text_KoichiDefeat
 * msgbox Route115_Text_KoichiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Koichi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KOICHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.KoichiPostBattle)
    }
    ctx.say(Route115.KoichiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.KoichiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HECTOR, Route115_Text_HectorIntro, Route115_Text_HectorDefeat
 * msgbox Route115_Text_HectorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Hector : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HECTOR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.HectorPostBattle)
    }
    ctx.say(Route115.HectorIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.HectorDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_SUPER_POTION
 * end
 * ```
 */
internal object Route115_EventScript_ItemSuperPotion : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_ItemSuperPotion")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM_FOCUS_PUNCH
 * end
 * ```
 */
internal object Route115_EventScript_ItemTMFocusPunch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_ItemTMFocusPunch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_IRON
 * end
 * ```
 */
internal object Route115_EventScript_ItemIron : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_ItemIron")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_GREAT_BALL
 * end
 * ```
 */
internal object Route115_EventScript_ItemGreatBall : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_ItemGreatBall")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KYRA, Route115_Text_KyraIntro, Route115_Text_KyraDefeat
 * msgbox Route115_Text_KyraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Kyra : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KYRA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.KyraPostBattle)
    }
    ctx.say(Route115.KyraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.KyraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JAIDEN, Route115_Text_JaidenIntro, Route115_Text_JaidenDefeat
 * msgbox Route115_Text_JaidenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Jaiden : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JAIDEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.JaidenPostBattle)
    }
    ctx.say(Route115.JaidenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.JaidenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HELENE, Route115_Text_HeleneIntro, Route115_Text_HeleneDefeat
 * msgbox Route115_Text_HelenePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Helene : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HELENE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.HelenePostBattle)
    }
    ctx.say(Route115.HeleneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.HeleneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALIX, Route115_Text_AlixIntro, Route115_Text_AlixDefeat
 * msgbox Route115_Text_AlixPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Alix : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALIX
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.AlixPostBattle)
    }
    ctx.say(Route115.AlixIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.AlixDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MARLENE, Route115_Text_MarleneIntro, Route115_Text_MarleneDefeat
 * msgbox Route115_Text_MarlenePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route115_EventScript_Marlene : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MARLENE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route115.MarlenePostBattle)
    }
    ctx.say(Route115.MarleneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route115.MarleneDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object Route115_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_ItemPPUp")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_HEAL_POWDER
 * end
 * ```
 */
internal object Route115_EventScript_ItemHealPowder : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route115_EventScript_ItemHealPowder")
}

internal object Route115_EventScript_RouteSignRustboro : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route115.RouteSignRustboro)
}

internal object Route115_EventScript_MeteorFallsSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route115.MeteorFallsSign)
}

internal val Route115Scripts: Map<String, Script> =
    mapOf(
        "Route115_EventScript_Woman" to Route115_EventScript_Woman,
        "Route115_EventScript_Timothy" to Route115_EventScript_Timothy,
        "Route115_EventScript_Nob" to Route115_EventScript_Nob,
        "Route115_EventScript_Cyndy" to Route115_EventScript_Cyndy,
        "Route115_EventScript_Koichi" to Route115_EventScript_Koichi,
        "Route115_EventScript_Hector" to Route115_EventScript_Hector,
        "Route115_EventScript_ItemSuperPotion" to Route115_EventScript_ItemSuperPotion,
        "Route115_EventScript_ItemTMFocusPunch" to Route115_EventScript_ItemTMFocusPunch,
        "Route115_EventScript_ItemIron" to Route115_EventScript_ItemIron,
        "Route115_EventScript_ItemGreatBall" to Route115_EventScript_ItemGreatBall,
        "Route115_EventScript_Kyra" to Route115_EventScript_Kyra,
        "Route115_EventScript_Jaiden" to Route115_EventScript_Jaiden,
        "Route115_EventScript_Helene" to Route115_EventScript_Helene,
        "Route115_EventScript_Alix" to Route115_EventScript_Alix,
        "Route115_EventScript_Marlene" to Route115_EventScript_Marlene,
        "Route115_EventScript_ItemPPUp" to Route115_EventScript_ItemPPUp,
        "Route115_EventScript_ItemHealPowder" to Route115_EventScript_ItemHealPowder,
        "Route115_EventScript_RouteSignRustboro" to Route115_EventScript_RouteSignRustboro,
        "Route115_EventScript_MeteorFallsSign" to Route115_EventScript_MeteorFallsSign,
    )
