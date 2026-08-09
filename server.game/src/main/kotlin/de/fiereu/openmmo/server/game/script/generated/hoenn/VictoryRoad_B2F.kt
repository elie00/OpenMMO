package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.VictoryRoad_B2F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_VITO, VictoryRoad_B2F_Text_VitoIntro, VictoryRoad_B2F_Text_VitoDefeat
 * msgbox VictoryRoad_B2F_Text_VitoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_Vito : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_VITO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B2F.VitoPostBattle)
    }
    ctx.say(VictoryRoad_B2F.VitoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B2F.VitoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_OWEN, VictoryRoad_B2F_Text_OwenIntro, VictoryRoad_B2F_Text_OwenDefeat
 * msgbox VictoryRoad_B2F_Text_OwenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_Owen : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_OWEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B2F.OwenPostBattle)
    }
    ctx.say(VictoryRoad_B2F.OwenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B2F.OwenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAROLINE, VictoryRoad_B2F_Text_CarolineIntro, VictoryRoad_B2F_Text_CarolineDefeat
 * msgbox VictoryRoad_B2F_Text_CarolinePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_Caroline : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CAROLINE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B2F.CarolinePostBattle)
    }
    ctx.say(VictoryRoad_B2F.CarolineIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B2F.CarolineDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JULIE, VictoryRoad_B2F_Text_JulieIntro, VictoryRoad_B2F_Text_JulieDefeat
 * msgbox VictoryRoad_B2F_Text_JuliePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_Julie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JULIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B2F.JuliePostBattle)
    }
    ctx.say(VictoryRoad_B2F.JulieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B2F.JulieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_HEAL
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_ItemFullHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_HEAL, HoennFlags.FLAG_ITEM_VICTORY_ROAD_B2F_FULL_HEAL, 4)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DIANNE, VictoryRoad_B2F_Text_DianneIntro, VictoryRoad_B2F_Text_DianneDefeat
 * msgbox VictoryRoad_B2F_Text_DiannePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_Dianne : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DIANNE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B2F.DiannePostBattle)
    }
    ctx.say(VictoryRoad_B2F.DianneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B2F.DianneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FELIX, VictoryRoad_B2F_Text_FelixIntro, VictoryRoad_B2F_Text_FelixDefeat
 * msgbox VictoryRoad_B2F_Text_FelixPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B2F_EventScript_Felix : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_FELIX
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B2F.FelixPostBattle)
    }
    ctx.say(VictoryRoad_B2F.FelixIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B2F.FelixDefeat)
  }
}

internal val VictoryRoad_B2FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_B2F_EventScript_Vito" to VictoryRoad_B2F_EventScript_Vito,
        "VictoryRoad_B2F_EventScript_Owen" to VictoryRoad_B2F_EventScript_Owen,
        "VictoryRoad_B2F_EventScript_Caroline" to VictoryRoad_B2F_EventScript_Caroline,
        "VictoryRoad_B2F_EventScript_Julie" to VictoryRoad_B2F_EventScript_Julie,
        "VictoryRoad_B2F_EventScript_ItemFullHeal" to VictoryRoad_B2F_EventScript_ItemFullHeal,
        "VictoryRoad_B2F_EventScript_Dianne" to VictoryRoad_B2F_EventScript_Dianne,
        "VictoryRoad_B2F_EventScript_Felix" to VictoryRoad_B2F_EventScript_Felix,
    )
