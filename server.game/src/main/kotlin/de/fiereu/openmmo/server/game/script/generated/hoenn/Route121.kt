package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route121
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object Route121_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route121.AheadLoomsMtPyre)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_KATE_AND_JOY, Route121_Text_KateIntro, Route121_Text_KateDefeat, Route121_Text_KateNotEnoughMons
 * msgbox Route121_Text_KatePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Kate : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_Kate")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_KATE_AND_JOY, Route121_Text_JoyIntro, Route121_Text_JoyDefeat, Route121_Text_JoyNotEnoughMons
 * msgbox Route121_Text_JoyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Joy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_Joy")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_VANESSA, Route121_Text_VanessaIntro, Route121_Text_VanessaDefeat
 * msgbox Route121_Text_VanessaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Vanessa : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_VANESSA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route121.VanessaPostBattle)
    }
    ctx.say(Route121.VanessaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route121.VanessaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_WALTER_1, Route121_Text_WalterIntro, Route121_Text_WalterDefeat, Route121_EventScript_RegisterWalter
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route121_EventScript_RematchWalter
 * msgbox Route121_Text_WalterPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route121_EventScript_Walter : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_Walter")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAMMY, Route121_Text_TammyIntro, Route121_Text_TammyDefeat
 * msgbox Route121_Text_TammyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Tammy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TAMMY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route121.TammyPostBattle)
    }
    ctx.say(Route121.TammyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route121.TammyDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JESSICA_1, Route121_Text_JessicaIntro, Route121_Text_JessicaDefeat, Route121_EventScript_RegisterJessica
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route121_EventScript_RematchJessica
 * msgbox Route121_Text_JessicaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route121_EventScript_Jessica : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_Jessica")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARBOS
 * end
 * ```
 */
internal object Route121_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARBOS, HoennFlags.FLAG_ITEM_ROUTE_121_CARBOS, 20)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CALE, Route121_Text_CaleIntro, Route121_Text_CaleDefeat
 * msgbox Route121_Text_CalePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Cale : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CALE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route121.CalePostBattle)
    }
    ctx.say(Route121.CaleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route121.CaleDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MYLES, Route121_Text_MylesIntro, Route121_Text_MylesDefeat
 * msgbox Route121_Text_MylesPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Myles : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MYLES
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route121.MylesPostBattle)
    }
    ctx.say(Route121.MylesIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route121.MylesDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PAT, Route121_Text_PatIntro, Route121_Text_PatDefeat
 * msgbox Route121_Text_PatPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Pat : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PAT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route121.PatPostBattle)
    }
    ctx.say(Route121.PatIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route121.PatDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MARCEL, Route121_Text_MarcelIntro, Route121_Text_MarcelDefeat
 * msgbox Route121_Text_MarcelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_Marcel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MARCEL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route121.MarcelPostBattle)
    }
    ctx.say(Route121.MarcelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route121.MarcelDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_CRISTIN_1, Route121_Text_CristinIntro, Route121_Text_CristinDefeat, Route121_EventScript_RegisterCristin
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route121_EventScript_RematchCristin
 * msgbox Route121_Text_CristinPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route121_EventScript_Cristin : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_Cristin")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVE
 * end
 * ```
 */
internal object Route121_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVE, HoennFlags.FLAG_ITEM_ROUTE_121_REVIVE, 27)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ZINC
 * end
 * ```
 */
internal object Route121_EventScript_ItemZinc : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ZINC, HoennFlags.FLAG_ITEM_ROUTE_121_ZINC, 28)
  }
}

internal object Route121_EventScript_MtPyrePierSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route121.MtPyrePierSign)
}

internal object Route121_EventScript_SafariZoneSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route121.SafariZoneSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_JESSICA_1, Route121_Text_JessicaRematchIntro, Route121_Text_JessicaRematchDefeat
 * msgbox Route121_Text_JessicaPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_RematchJessica : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_RematchJessica")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_WALTER_1, Route121_Text_WalterRematchIntro, Route121_Text_WalterRematchDefeat
 * msgbox Route121_Text_WalterPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_RematchWalter : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_RematchWalter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_CRISTIN_1, Route121_Text_CristinRematchIntro, Route121_Text_CristinRematchDefeat
 * msgbox Route121_Text_CristinPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route121_EventScript_RematchCristin : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route121_EventScript_RematchCristin")
}

internal val Route121Scripts: Map<String, Script> =
    mapOf(
        "Route121_EventScript_Woman" to Route121_EventScript_Woman,
        "Route121_EventScript_Kate" to Route121_EventScript_Kate,
        "Route121_EventScript_Joy" to Route121_EventScript_Joy,
        "Route121_EventScript_Vanessa" to Route121_EventScript_Vanessa,
        "Route121_EventScript_Walter" to Route121_EventScript_Walter,
        "Route121_EventScript_Tammy" to Route121_EventScript_Tammy,
        "Route121_EventScript_Jessica" to Route121_EventScript_Jessica,
        "Route121_EventScript_ItemCarbos" to Route121_EventScript_ItemCarbos,
        "Route121_EventScript_Cale" to Route121_EventScript_Cale,
        "Route121_EventScript_Myles" to Route121_EventScript_Myles,
        "Route121_EventScript_Pat" to Route121_EventScript_Pat,
        "Route121_EventScript_Marcel" to Route121_EventScript_Marcel,
        "Route121_EventScript_Cristin" to Route121_EventScript_Cristin,
        "Route121_EventScript_ItemRevive" to Route121_EventScript_ItemRevive,
        "Route121_EventScript_ItemZinc" to Route121_EventScript_ItemZinc,
        "Route121_EventScript_MtPyrePierSign" to Route121_EventScript_MtPyrePierSign,
        "Route121_EventScript_SafariZoneSign" to Route121_EventScript_SafariZoneSign,
        "Route121_EventScript_RematchJessica" to Route121_EventScript_RematchJessica,
        "Route121_EventScript_RematchWalter" to Route121_EventScript_RematchWalter,
        "Route121_EventScript_RematchCristin" to Route121_EventScript_RematchCristin,
    )
