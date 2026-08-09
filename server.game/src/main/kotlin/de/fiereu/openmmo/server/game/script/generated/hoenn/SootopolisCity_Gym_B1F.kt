package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_Gym_B1F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ANDREA, SootopolisCity_Gym_B1F_Text_AndreaIntro, SootopolisCity_Gym_B1F_Text_AndreaDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_AndreaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Andrea : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ANDREA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.AndreaPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.AndreaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.AndreaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CONNIE, SootopolisCity_Gym_B1F_Text_ConnieIntro, SootopolisCity_Gym_B1F_Text_ConnieDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_ConniePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Connie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CONNIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.ConniePostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.ConnieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.ConnieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BRIANNA, SootopolisCity_Gym_B1F_Text_BriannaIntro, SootopolisCity_Gym_B1F_Text_BriannaDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_BriannaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Brianna : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BRIANNA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.BriannaPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.BriannaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.BriannaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BRIDGET, SootopolisCity_Gym_B1F_Text_BridgetIntro, SootopolisCity_Gym_B1F_Text_BridgetDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_BridgetPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Bridget : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BRIDGET
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.BridgetPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.BridgetIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.BridgetDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TIFFANY, SootopolisCity_Gym_B1F_Text_TiffanyIntro, SootopolisCity_Gym_B1F_Text_TiffanyDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_TiffanyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Tiffany : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TIFFANY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.TiffanyPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.TiffanyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.TiffanyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BETHANY, SootopolisCity_Gym_B1F_Text_BethanyIntro, SootopolisCity_Gym_B1F_Text_BethanyDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_BethanyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Bethany : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BETHANY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.BethanyPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.BethanyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.BethanyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CRISSY, SootopolisCity_Gym_B1F_Text_CrissyIntro, SootopolisCity_Gym_B1F_Text_CrissyDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_CrissyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Crissy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CRISSY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.CrissyPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.CrissyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.CrissyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_OLIVIA, SootopolisCity_Gym_B1F_Text_OliviaIntro, SootopolisCity_Gym_B1F_Text_OliviaDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_OliviaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Olivia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_OLIVIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.OliviaPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.OliviaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.OliviaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DAPHNE, SootopolisCity_Gym_B1F_Text_DaphneIntro, SootopolisCity_Gym_B1F_Text_DaphneDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_DaphnePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Daphne : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DAPHNE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.DaphnePostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.DaphneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.DaphneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ANNIKA, SootopolisCity_Gym_B1F_Text_AnnikaIntro, SootopolisCity_Gym_B1F_Text_AnnikaDefeat
 * msgbox SootopolisCity_Gym_B1F_Text_AnnikaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SootopolisCity_Gym_B1F_EventScript_Annika : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ANNIKA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SootopolisCity_Gym_B1F.AnnikaPostBattle)
    }
    ctx.say(SootopolisCity_Gym_B1F.AnnikaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SootopolisCity_Gym_B1F.AnnikaDefeat)
  }
}

internal val SootopolisCity_Gym_B1FScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_Gym_B1F_EventScript_Andrea" to SootopolisCity_Gym_B1F_EventScript_Andrea,
        "SootopolisCity_Gym_B1F_EventScript_Connie" to SootopolisCity_Gym_B1F_EventScript_Connie,
        "SootopolisCity_Gym_B1F_EventScript_Brianna" to SootopolisCity_Gym_B1F_EventScript_Brianna,
        "SootopolisCity_Gym_B1F_EventScript_Bridget" to SootopolisCity_Gym_B1F_EventScript_Bridget,
        "SootopolisCity_Gym_B1F_EventScript_Tiffany" to SootopolisCity_Gym_B1F_EventScript_Tiffany,
        "SootopolisCity_Gym_B1F_EventScript_Bethany" to SootopolisCity_Gym_B1F_EventScript_Bethany,
        "SootopolisCity_Gym_B1F_EventScript_Crissy" to SootopolisCity_Gym_B1F_EventScript_Crissy,
        "SootopolisCity_Gym_B1F_EventScript_Olivia" to SootopolisCity_Gym_B1F_EventScript_Olivia,
        "SootopolisCity_Gym_B1F_EventScript_Daphne" to SootopolisCity_Gym_B1F_EventScript_Daphne,
        "SootopolisCity_Gym_B1F_EventScript_Annika" to SootopolisCity_Gym_B1F_EventScript_Annika,
    )
