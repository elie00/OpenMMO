package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MtPyre_3F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_WILLIAM, MtPyre_3F_Text_WilliamIntro, MtPyre_3F_Text_WilliamDefeat
 * msgbox MtPyre_3F_Text_WilliamPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_3F_EventScript_William : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_WILLIAM
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_3F.WilliamPostBattle)
    }
    ctx.say(MtPyre_3F.WilliamIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_3F.WilliamDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KAYLA, MtPyre_3F_Text_KaylaIntro, MtPyre_3F_Text_KaylaDefeat
 * msgbox MtPyre_3F_Text_KaylaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_3F_EventScript_Kayla : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KAYLA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_3F.KaylaPostBattle)
    }
    ctx.say(MtPyre_3F.KaylaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_3F.KaylaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SUPER_REPEL
 * end
 * ```
 */
internal object MtPyre_3F_EventScript_ItemSuperRepel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.SUPER_REPEL, HoennFlags.FLAG_ITEM_MT_PYRE_3F_SUPER_REPEL, 2)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_GABRIELLE_1, MtPyre_3F_Text_GabrielleIntro, MtPyre_3F_Text_GabrielleDefeat, MtPyre_3F_EventScript_RegisterGabrielle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, MtPyre_3F_EventScript_RematchGabrielle
 * msgbox MtPyre_3F_Text_GabriellePostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MtPyre_3F_EventScript_Gabrielle : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_3F_EventScript_Gabrielle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_GABRIELLE_1, MtPyre_3F_Text_GabrielleRematchIntro, MtPyre_3F_Text_GabrielleRematchDefeat
 * msgbox MtPyre_3F_Text_GabriellePostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_3F_EventScript_RematchGabrielle : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_3F_EventScript_RematchGabrielle")
}

internal val MtPyre_3FScripts: Map<String, Script> =
    mapOf(
        "MtPyre_3F_EventScript_William" to MtPyre_3F_EventScript_William,
        "MtPyre_3F_EventScript_Kayla" to MtPyre_3F_EventScript_Kayla,
        "MtPyre_3F_EventScript_ItemSuperRepel" to MtPyre_3F_EventScript_ItemSuperRepel,
        "MtPyre_3F_EventScript_Gabrielle" to MtPyre_3F_EventScript_Gabrielle,
        "MtPyre_3F_EventScript_RematchGabrielle" to MtPyre_3F_EventScript_RematchGabrielle,
    )
