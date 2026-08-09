package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.VictoryRoad_B1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SAMUEL, VictoryRoad_B1F_Text_SamuelIntro, VictoryRoad_B1F_Text_SamuelDefeat
 * msgbox VictoryRoad_B1F_Text_SamuelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_Samuel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SAMUEL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B1F.SamuelPostBattle)
    }
    ctx.say(VictoryRoad_B1F.SamuelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B1F.SamuelDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SHANNON, VictoryRoad_B1F_Text_ShannonIntro, VictoryRoad_B1F_Text_ShannonDefeat
 * msgbox VictoryRoad_B1F_Text_ShannonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_Shannon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_SHANNON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B1F.ShannonPostBattle)
    }
    ctx.say(VictoryRoad_B1F.ShannonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B1F.ShannonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MICHELLE, VictoryRoad_B1F_Text_MichelleIntro, VictoryRoad_B1F_Text_MichelleDefeat
 * msgbox VictoryRoad_B1F_Text_MichellePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_Michelle : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MICHELLE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B1F.MichellePostBattle)
    }
    ctx.say(VictoryRoad_B1F.MichelleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B1F.MichelleDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * finditem ITEM_TM_PSYCHIC
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_ItemTMPsychic : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VictoryRoad_B1F_EventScript_ItemTMPsychic")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_RESTORE, HoennFlags.FLAG_ITEM_VICTORY_ROAD_B1F_FULL_RESTORE, 18)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MITCHELL, VictoryRoad_B1F_Text_MitchellIntro, VictoryRoad_B1F_Text_MitchellDefeat
 * msgbox VictoryRoad_B1F_Text_MitchellPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_Mitchell : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MITCHELL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B1F.MitchellPostBattle)
    }
    ctx.say(VictoryRoad_B1F.MitchellIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B1F.MitchellDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HALLE, VictoryRoad_B1F_Text_HalleIntro, VictoryRoad_B1F_Text_HalleDefeat
 * msgbox VictoryRoad_B1F_Text_HallePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object VictoryRoad_B1F_EventScript_Halle : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HALLE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(VictoryRoad_B1F.HallePostBattle)
    }
    ctx.say(VictoryRoad_B1F.HalleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(VictoryRoad_B1F.HalleDefeat)
  }
}

internal val VictoryRoad_B1FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_B1F_EventScript_Samuel" to VictoryRoad_B1F_EventScript_Samuel,
        "VictoryRoad_B1F_EventScript_Shannon" to VictoryRoad_B1F_EventScript_Shannon,
        "VictoryRoad_B1F_EventScript_Michelle" to VictoryRoad_B1F_EventScript_Michelle,
        "VictoryRoad_B1F_EventScript_ItemTMPsychic" to VictoryRoad_B1F_EventScript_ItemTMPsychic,
        "VictoryRoad_B1F_EventScript_ItemFullRestore" to
            VictoryRoad_B1F_EventScript_ItemFullRestore,
        "VictoryRoad_B1F_EventScript_Mitchell" to VictoryRoad_B1F_EventScript_Mitchell,
        "VictoryRoad_B1F_EventScript_Halle" to VictoryRoad_B1F_EventScript_Halle,
    )
