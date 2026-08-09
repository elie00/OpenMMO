package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MtPyre_Summit
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_SOOTOPOLIS_ARCHIE_MAXIE_LEAVE, MtPyre_Summit_EventScript_OldManAfterRayquaza
 * msgbox MtPyre_Summit_Text_WillYouHearOutMyTale, MSGBOX_YESNO
 * call_if_eq VAR_RESULT, YES, MtPyre_Summit_EventScript_OldManTale
 * call_if_eq VAR_RESULT, NO, MtPyre_Summit_EventScript_DeclineOldManTale
 * release
 * end
 * ```
 */
internal object MtPyre_Summit_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_Summit_EventScript_OldMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RETURNED_RED_OR_BLUE_ORB, MtPyre_Summit_EventScript_OldLadyAfterOrbsReturned
 * call_if_ge VAR_MT_PYRE_STATE, 3, MtPyre_Summit_EventScript_OldLadyOrbsReturned
 * goto_if_set FLAG_KYOGRE_ESCAPED_SEAFLOOR_CAVERN, MtPyre_Summit_EventScript_OldLadyLegendariesAwake
 * msgbox MtPyre_Summit_Text_OrbsHaveBeenTaken, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MtPyre_Summit_EventScript_OldLady : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MtPyre_Summit_EventScript_OldLady")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MT_PYRE_1, MtPyre_Summit_Text_Grunt1Intro, MtPyre_Summit_Text_Grunt1Defeat
 * msgbox MtPyre_Summit_Text_Grunt1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_Summit_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MT_PYRE_1
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_Summit.Grunt1PostBattle)
    }
    ctx.say(MtPyre_Summit.Grunt1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_Summit.Grunt1Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MT_PYRE_2, MtPyre_Summit_Text_Grunt2Intro, MtPyre_Summit_Text_Grunt2Defeat
 * msgbox MtPyre_Summit_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_Summit_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MT_PYRE_2
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_Summit.Grunt2PostBattle)
    }
    ctx.say(MtPyre_Summit.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_Summit.Grunt2Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MT_PYRE_3, MtPyre_Summit_Text_Grunt3Intro, MtPyre_Summit_Text_Grunt3Defeat
 * msgbox MtPyre_Summit_Text_Grunt3PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_Summit_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MT_PYRE_3
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_Summit.Grunt3PostBattle)
    }
    ctx.say(MtPyre_Summit.Grunt3Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_Summit.Grunt3Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_MT_PYRE_4, MtPyre_Summit_Text_Grunt4Intro, MtPyre_Summit_Text_Grunt4Defeat
 * msgbox MtPyre_Summit_Text_Grunt4PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object MtPyre_Summit_EventScript_Grunt4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_MT_PYRE_4
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(MtPyre_Summit.Grunt4PostBattle)
    }
    ctx.say(MtPyre_Summit.Grunt4Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(MtPyre_Summit.Grunt4Defeat)
  }
}

internal val MtPyre_SummitScripts: Map<String, Script> =
    mapOf(
        "MtPyre_Summit_EventScript_OldMan" to MtPyre_Summit_EventScript_OldMan,
        "MtPyre_Summit_EventScript_OldLady" to MtPyre_Summit_EventScript_OldLady,
        "MtPyre_Summit_EventScript_Grunt1" to MtPyre_Summit_EventScript_Grunt1,
        "MtPyre_Summit_EventScript_Grunt2" to MtPyre_Summit_EventScript_Grunt2,
        "MtPyre_Summit_EventScript_Grunt3" to MtPyre_Summit_EventScript_Grunt3,
        "MtPyre_Summit_EventScript_Grunt4" to MtPyre_Summit_EventScript_Grunt4,
    )
