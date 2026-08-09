package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route126
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BARRY, Route126_Text_BarryIntro, Route126_Text_BarryDefeat
 * msgbox Route126_Text_BarryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Barry : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BARRY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.BarryPostBattle)
    }
    ctx.say(Route126.BarryIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.BarryDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DEAN, Route126_Text_DeanIntro, Route126_Text_DeanDefeat
 * msgbox Route126_Text_DeanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Dean : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DEAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.DeanPostBattle)
    }
    ctx.say(Route126.DeanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.DeanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_NIKKI, Route126_Text_NikkiIntro, Route126_Text_NikkiDefeat
 * msgbox Route126_Text_NikkiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Nikki : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_NIKKI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.NikkiPostBattle)
    }
    ctx.say(Route126.NikkiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.NikkiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BRENDA, Route126_Text_BrendaIntro, Route126_Text_BrendaDefeat
 * msgbox Route126_Text_BrendaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Brenda : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BRENDA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.BrendaPostBattle)
    }
    ctx.say(Route126.BrendaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.BrendaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_GREEN_SHARD
 * end
 * ```
 */
internal object Route126_EventScript_ItemGreenShard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.GREEN_SHARD, HoennFlags.FLAG_ITEM_ROUTE_126_GREEN_SHARD, 4)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SIENNA, Route126_Text_SiennaIntro, Route126_Text_SiennaDefeat
 * msgbox Route126_Text_SiennaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Sienna : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SIENNA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.SiennaPostBattle)
    }
    ctx.say(Route126.SiennaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.SiennaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_PABLO_1, Route126_Text_PabloIntro, Route126_Text_PabloDefeat, Route126_EventScript_RegisterPablo
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route126_EventScript_RematchPablo
 * msgbox Route126_Text_PabloPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route126_EventScript_Pablo : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route126_EventScript_Pablo")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ISOBEL, Route126_Text_IsobelIntro, Route126_Text_IsobelDefeat
 * msgbox Route126_Text_IsobelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Isobel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ISOBEL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.IsobelPostBattle)
    }
    ctx.say(Route126.IsobelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.IsobelDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LEONARDO, Route126_Text_LeonardoIntro, Route126_Text_LeonardoDefeat
 * msgbox Route126_Text_LeonardoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route126_EventScript_Leonardo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_LEONARDO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route126.LeonardoPostBattle)
    }
    ctx.say(Route126.LeonardoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route126.LeonardoDefeat)
  }
}

internal val Route126Scripts: Map<String, Script> =
    mapOf(
        "Route126_EventScript_Barry" to Route126_EventScript_Barry,
        "Route126_EventScript_Dean" to Route126_EventScript_Dean,
        "Route126_EventScript_Nikki" to Route126_EventScript_Nikki,
        "Route126_EventScript_Brenda" to Route126_EventScript_Brenda,
        "Route126_EventScript_ItemGreenShard" to Route126_EventScript_ItemGreenShard,
        "Route126_EventScript_Sienna" to Route126_EventScript_Sienna,
        "Route126_EventScript_Pablo" to Route126_EventScript_Pablo,
        "Route126_EventScript_Isobel" to Route126_EventScript_Isobel,
        "Route126_EventScript_Leonardo" to Route126_EventScript_Leonardo,
    )
