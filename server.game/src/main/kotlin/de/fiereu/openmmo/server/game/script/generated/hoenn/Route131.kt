package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route131
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RICHARD, Route131_Text_RichardIntro, Route131_Text_RichardDefeat
 * msgbox Route131_Text_RichardPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Richard : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RICHARD
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route131.RichardPostBattle)
    }
    ctx.say(Route131.RichardIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route131.RichardDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HERMAN, Route131_Text_HermanIntro, Route131_Text_HermanDefeat
 * msgbox Route131_Text_HermanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Herman : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HERMAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route131.HermanPostBattle)
    }
    ctx.say(Route131.HermanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route131.HermanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SUSIE, Route131_Text_SusieIntro, Route131_Text_SusieDefeat
 * msgbox Route131_Text_SusiePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Susie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SUSIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route131.SusiePostBattle)
    }
    ctx.say(Route131.SusieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route131.SusieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KARA, Route131_Text_KaraIntro, Route131_Text_KaraDefeat
 * msgbox Route131_Text_KaraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Kara : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KARA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route131.KaraPostBattle)
    }
    ctx.say(Route131.KaraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route131.KaraDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_RELI_AND_IAN, Route131_Text_ReliIntro, Route131_Text_ReliDefeat, Route131_Text_ReliNotEnoughMons
 * msgbox Route131_Text_ReliPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Reli : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route131_EventScript_Reli")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_RELI_AND_IAN, Route131_Text_IanIntro, Route131_Text_IanDefeat, Route131_Text_IanNotEnoughMons
 * msgbox Route131_Text_IanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Ian : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route131_EventScript_Ian")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KEVIN, Route131_Text_KevinIntro, Route131_Text_KevinDefeat
 * msgbox Route131_Text_KevinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Kevin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KEVIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route131.KevinPostBattle)
    }
    ctx.say(Route131.KevinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route131.KevinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TALIA, Route131_Text_TaliaIntro, Route131_Text_TaliaDefeat
 * msgbox Route131_Text_TaliaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route131_EventScript_Talia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TALIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route131.TaliaPostBattle)
    }
    ctx.say(Route131.TaliaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route131.TaliaDefeat)
  }
}

internal val Route131Scripts: Map<String, Script> =
    mapOf(
        "Route131_EventScript_Richard" to Route131_EventScript_Richard,
        "Route131_EventScript_Herman" to Route131_EventScript_Herman,
        "Route131_EventScript_Susie" to Route131_EventScript_Susie,
        "Route131_EventScript_Kara" to Route131_EventScript_Kara,
        "Route131_EventScript_Reli" to Route131_EventScript_Reli,
        "Route131_EventScript_Ian" to Route131_EventScript_Ian,
        "Route131_EventScript_Kevin" to Route131_EventScript_Kevin,
        "Route131_EventScript_Talia" to Route131_EventScript_Talia,
    )
