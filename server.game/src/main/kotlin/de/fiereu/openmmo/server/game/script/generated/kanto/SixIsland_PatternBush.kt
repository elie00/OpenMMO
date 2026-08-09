package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_PatternBush
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PKMN_BREEDER_BETHANY, SixIsland_PatternBush_Text_BethanyIntro, SixIsland_PatternBush_Text_BethanyDefeat
 * msgbox SixIsland_PatternBush_Text_BethanyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Bethany : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PKMN_BREEDER_BETHANY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.BethanyPostBattle)
    }
    ctx.say(SixIsland_PatternBush.BethanyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.BethanyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PKMN_BREEDER_ALLISON, SixIsland_PatternBush_Text_AllisonIntro, SixIsland_PatternBush_Text_AllisonDefeat
 * msgbox SixIsland_PatternBush_Text_AllisonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Allison : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PKMN_BREEDER_ALLISON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.AllisonPostBattle)
    }
    ctx.say(SixIsland_PatternBush.AllisonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.AllisonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_GARRET, SixIsland_PatternBush_Text_GarretIntro, SixIsland_PatternBush_Text_GarretDefeat
 * msgbox SixIsland_PatternBush_Text_GarretPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Garret : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_GARRET
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.GarretPostBattle)
    }
    ctx.say(SixIsland_PatternBush.GarretIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.GarretDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_JONAH, SixIsland_PatternBush_Text_JonahIntro, SixIsland_PatternBush_Text_JonahDefeat
 * msgbox SixIsland_PatternBush_Text_JonahPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Jonah : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_JONAH
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.JonahPostBattle)
    }
    ctx.say(SixIsland_PatternBush.JonahIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.JonahDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_VANCE, SixIsland_PatternBush_Text_VanceIntro, SixIsland_PatternBush_Text_VanceDefeat
 * msgbox SixIsland_PatternBush_Text_VancePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Vance : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_VANCE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.VancePostBattle)
    }
    ctx.say(SixIsland_PatternBush.VanceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.VanceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_NASH, SixIsland_PatternBush_Text_NashIntro, SixIsland_PatternBush_Text_NashDefeat
 * msgbox SixIsland_PatternBush_Text_NashPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Nash : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_NASH
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.NashPostBattle)
    }
    ctx.say(SixIsland_PatternBush.NashIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.NashDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_CORDELL, SixIsland_PatternBush_Text_CordellIntro, SixIsland_PatternBush_Text_CordellDefeat
 * msgbox SixIsland_PatternBush_Text_CordellPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Cordell : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_CORDELL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.CordellPostBattle)
    }
    ctx.say(SixIsland_PatternBush.CordellIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.CordellDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_DALIA, SixIsland_PatternBush_Text_DaliaIntro, SixIsland_PatternBush_Text_DaliaDefeat
 * msgbox SixIsland_PatternBush_Text_DaliaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Dalia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_DALIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.DaliaPostBattle)
    }
    ctx.say(SixIsland_PatternBush.DaliaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.DaliaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_JOANA, SixIsland_PatternBush_Text_JoanaIntro, SixIsland_PatternBush_Text_JoanaDefeat
 * msgbox SixIsland_PatternBush_Text_JoanaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Joana : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_JOANA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.JoanaPostBattle)
    }
    ctx.say(SixIsland_PatternBush.JoanaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.JoanaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_RILEY, SixIsland_PatternBush_Text_RileyIntro, SixIsland_PatternBush_Text_RileyDefeat
 * msgbox SixIsland_PatternBush_Text_RileyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Riley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_RILEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.RileyPostBattle)
    }
    ctx.say(SixIsland_PatternBush.RileyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.RileyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_MARCY, SixIsland_PatternBush_Text_MarcyIntro, SixIsland_PatternBush_Text_MarcyDefeat
 * msgbox SixIsland_PatternBush_Text_MarcyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Marcy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_MARCY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.MarcyPostBattle)
    }
    ctx.say(SixIsland_PatternBush.MarcyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.MarcyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_LAYTON, SixIsland_PatternBush_Text_LaytonIntro, SixIsland_PatternBush_Text_LaytonDefeat
 * msgbox SixIsland_PatternBush_Text_LaytonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_PatternBush_EventScript_Layton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_LAYTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_PatternBush.LaytonPostBattle)
    }
    ctx.say(SixIsland_PatternBush.LaytonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_PatternBush.LaytonDefeat)
  }
}

internal val SixIsland_PatternBushScripts: Map<String, Script> =
    mapOf(
        "SixIsland_PatternBush_EventScript_Bethany" to SixIsland_PatternBush_EventScript_Bethany,
        "SixIsland_PatternBush_EventScript_Allison" to SixIsland_PatternBush_EventScript_Allison,
        "SixIsland_PatternBush_EventScript_Garret" to SixIsland_PatternBush_EventScript_Garret,
        "SixIsland_PatternBush_EventScript_Jonah" to SixIsland_PatternBush_EventScript_Jonah,
        "SixIsland_PatternBush_EventScript_Vance" to SixIsland_PatternBush_EventScript_Vance,
        "SixIsland_PatternBush_EventScript_Nash" to SixIsland_PatternBush_EventScript_Nash,
        "SixIsland_PatternBush_EventScript_Cordell" to SixIsland_PatternBush_EventScript_Cordell,
        "SixIsland_PatternBush_EventScript_Dalia" to SixIsland_PatternBush_EventScript_Dalia,
        "SixIsland_PatternBush_EventScript_Joana" to SixIsland_PatternBush_EventScript_Joana,
        "SixIsland_PatternBush_EventScript_Riley" to SixIsland_PatternBush_EventScript_Riley,
        "SixIsland_PatternBush_EventScript_Marcy" to SixIsland_PatternBush_EventScript_Marcy,
        "SixIsland_PatternBush_EventScript_Layton" to SixIsland_PatternBush_EventScript_Layton,
    )
