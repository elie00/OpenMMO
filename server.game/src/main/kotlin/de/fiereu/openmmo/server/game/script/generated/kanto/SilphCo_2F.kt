package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_2F
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_24, SilphCo_2F_Text_Grunt2Intro, SilphCo_2F_Text_Grunt2Defeat
 * msgbox SilphCo_2F_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_24
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_2F.Grunt2PostBattle)
    }
    ctx.say(SilphCo_2F.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_2F.Grunt2Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SCIENTIST_JERRY, SilphCo_2F_Text_JerryIntro, SilphCo_2F_Text_JerryDefeat
 * msgbox SilphCo_2F_Text_JerryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_Jerry : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SCIENTIST_JERRY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_2F.JerryPostBattle)
    }
    ctx.say(SilphCo_2F.JerryIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_2F.JerryDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_23, SilphCo_2F_Text_Grunt1Intro, SilphCo_2F_Text_Grunt1Defeat
 * msgbox SilphCo_2F_Text_Grunt1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_23
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_2F.Grunt1PostBattle)
    }
    ctx.say(SilphCo_2F.Grunt1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_2F.Grunt1Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SCIENTIST_CONNOR, SilphCo_2F_Text_ConnorIntro, SilphCo_2F_Text_ConnorDefeat
 * msgbox SilphCo_2F_Text_ConnorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_Connor : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SCIENTIST_CONNOR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_2F.ConnorPostBattle)
    }
    ctx.say(SilphCo_2F.ConnorIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_2F.ConnorDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto EventScript_ThunderWaveTutor
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_ThunderWaveTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SilphCo_2F_EventScript_ThunderWaveTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 1
 * setvar VAR_0x8004, FLAG_SILPH_2F_DOOR_1
 * goto_if_set FLAG_SILPH_2F_DOOR_1, EventScript_DoorUnlocked
 * goto EventScript_TryUnlockDoor
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_2F_EventScript_Door1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 2
 * setvar VAR_0x8004, FLAG_SILPH_2F_DOOR_2
 * goto_if_set FLAG_SILPH_2F_DOOR_2, EventScript_DoorUnlocked
 * goto EventScript_TryUnlockDoor
 * end
 * ```
 */
internal object SilphCo_2F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_2F_EventScript_Door2")
}

internal object SilphCo_2F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_2F.FloorSign)
}

internal val SilphCo_2FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_2F_EventScript_Grunt2" to SilphCo_2F_EventScript_Grunt2,
        "SilphCo_2F_EventScript_Jerry" to SilphCo_2F_EventScript_Jerry,
        "SilphCo_2F_EventScript_Grunt1" to SilphCo_2F_EventScript_Grunt1,
        "SilphCo_2F_EventScript_Connor" to SilphCo_2F_EventScript_Connor,
        "SilphCo_2F_EventScript_ThunderWaveTutor" to SilphCo_2F_EventScript_ThunderWaveTutor,
        "SilphCo_2F_EventScript_Door1" to SilphCo_2F_EventScript_Door1,
        "SilphCo_2F_EventScript_Door2" to SilphCo_2F_EventScript_Door2,
        "SilphCo_2F_EventScript_FloorSign" to SilphCo_2F_EventScript_FloorSign,
    )
