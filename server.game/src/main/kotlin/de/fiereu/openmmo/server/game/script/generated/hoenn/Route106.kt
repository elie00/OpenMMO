package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route106
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DOUGLAS, Route106_Text_DouglasIntro, Route106_Text_DouglasDefeated
 * msgbox Route106_Text_DouglasPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route106_EventScript_Douglas : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DOUGLAS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route106.DouglasPostBattle)
    }
    ctx.say(Route106.DouglasIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route106.DouglasDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KYLA, Route106_Text_KylaIntro, Route106_Text_KylaDefeated
 * msgbox Route106_Text_KylaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route106_EventScript_Kyla : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KYLA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route106.KylaPostBattle)
    }
    ctx.say(Route106.KylaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route106.KylaDefeated)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_ELLIOT_1, Route106_Text_ElliotIntro, Route106_Text_ElliotDefeated, Route106_EventScript_ElliotRegisterMatchCallAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route106_EventScript_ElliotRematch
 * msgbox Route106_Text_ElliotPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route106_EventScript_Elliot : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route106_EventScript_Elliot")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_NED, Route106_Text_NedIntro, Route106_Text_NedDefeated
 * msgbox Route106_Text_NedPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route106_EventScript_Ned : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_NED
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route106.NedPostBattle)
    }
    ctx.say(Route106.NedIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route106.NedDefeated)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PROTEIN
 * end
 * ```
 */
internal object Route106_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PROTEIN, HoennFlags.FLAG_ITEM_ROUTE_106_PROTEIN, 4)
  }
}

internal object Route106_EventScript_TrainerTipsSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route106.TrainerTips)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_ELLIOT_1, Route106_Text_ElliotRematchIntro, Route106_Text_ElliotRematchDefeated
 * msgbox Route106_Text_ElliotRematchPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route106_EventScript_ElliotRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route106_EventScript_ElliotRematch")
}

internal val Route106Scripts: Map<String, Script> =
    mapOf(
        "Route106_EventScript_Douglas" to Route106_EventScript_Douglas,
        "Route106_EventScript_Kyla" to Route106_EventScript_Kyla,
        "Route106_EventScript_Elliot" to Route106_EventScript_Elliot,
        "Route106_EventScript_Ned" to Route106_EventScript_Ned,
        "Route106_EventScript_ItemProtein" to Route106_EventScript_ItemProtein,
        "Route106_EventScript_TrainerTipsSign" to Route106_EventScript_TrainerTipsSign,
        "Route106_EventScript_ElliotRematch" to Route106_EventScript_ElliotRematch,
    )
