package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.VictoryRoad_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_EDGAR, VictoryRoad_1F_Text_EdgarIntro, VictoryRoad_1F_Text_EdgarDefeat
 * msgbox VictoryRoad_1F_Text_EdgarPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_Edgar : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_EDGAR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_1F.EdgarPostBattle)
    }
    ctx.say(VictoryRoad_1F.EdgarIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_1F.EdgarDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HOPE, VictoryRoad_1F_Text_HopeIntro, VictoryRoad_1F_Text_HopeDefeat
 * msgbox VictoryRoad_1F_Text_HopePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_Hope : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HOPE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_1F.HopePostBattle)
    }
    ctx.say(VictoryRoad_1F.HopeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_1F.HopeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALBERT, VictoryRoad_1F_Text_AlbertIntro, VictoryRoad_1F_Text_AlbertDefeat
 * msgbox VictoryRoad_1F_Text_AlbertPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_Albert : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALBERT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_1F.AlbertPostBattle)
    }
    ctx.say(VictoryRoad_1F.AlbertIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_1F.AlbertDefeat)
  }
}

internal object VictoryRoad_1F_EventScript_EntranceWally : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VictoryRoad_1F.WallyPostEntranceBattle)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_ELIXIR
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_ItemMaxElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_ELIXIR, HoennFlags.FLAG_ITEM_VICTORY_ROAD_1F_MAX_ELIXIR, 4)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, HoennFlags.FLAG_ITEM_VICTORY_ROAD_1F_PP_UP, 5)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_WALLY_VR_2, VictoryRoad_1F_Text_WallyIntro, VictoryRoad_1F_Text_WallyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, VictoryRoad_1F_EventScript_RematchWally
 * msgbox VictoryRoad_1F_Text_WallyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_ExitWally : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VictoryRoad_1F_EventScript_ExitWally")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KATELYNN, VictoryRoad_1F_Text_KatelynnIntro, VictoryRoad_1F_Text_KatelynnDefeat
 * msgbox VictoryRoad_1F_Text_KatelynnPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_Katelynn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KATELYNN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_1F.KatelynnPostBattle)
    }
    ctx.say(VictoryRoad_1F.KatelynnIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_1F.KatelynnDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_QUINCY, VictoryRoad_1F_Text_QuincyIntro, VictoryRoad_1F_Text_QuincyDefeat
 * msgbox VictoryRoad_1F_Text_QuincyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_1F_EventScript_Quincy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_QUINCY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_1F.QuincyPostBattle)
    }
    ctx.say(VictoryRoad_1F.QuincyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_1F.QuincyDefeat)
  }
}

internal val VictoryRoad_1FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_1F_EventScript_Edgar" to VictoryRoad_1F_EventScript_Edgar,
        "VictoryRoad_1F_EventScript_Hope" to VictoryRoad_1F_EventScript_Hope,
        "VictoryRoad_1F_EventScript_Albert" to VictoryRoad_1F_EventScript_Albert,
        "VictoryRoad_1F_EventScript_EntranceWally" to VictoryRoad_1F_EventScript_EntranceWally,
        "VictoryRoad_1F_EventScript_ItemMaxElixir" to VictoryRoad_1F_EventScript_ItemMaxElixir,
        "VictoryRoad_1F_EventScript_ItemPPUp" to VictoryRoad_1F_EventScript_ItemPPUp,
        "VictoryRoad_1F_EventScript_ExitWally" to VictoryRoad_1F_EventScript_ExitWally,
        "VictoryRoad_1F_EventScript_Katelynn" to VictoryRoad_1F_EventScript_Katelynn,
        "VictoryRoad_1F_EventScript_Quincy" to VictoryRoad_1F_EventScript_Quincy,
    )
