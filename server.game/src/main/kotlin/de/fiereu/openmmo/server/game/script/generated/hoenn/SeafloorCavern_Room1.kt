package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SeafloorCavern_Room1
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_SEAFLOOR_CAVERN_1, SeafloorCavern_Room1_Text_Grunt1Intro, SeafloorCavern_Room1_Text_Grunt1Defeat
 * msgbox SeafloorCavern_Room1_Text_Grunt1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SeafloorCavern_Room1_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_SEAFLOOR_CAVERN_1
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SeafloorCavern_Room1.Grunt1PostBattle)
    }
    ctx.say(SeafloorCavern_Room1.Grunt1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SeafloorCavern_Room1.Grunt1Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_SEAFLOOR_CAVERN_2, SeafloorCavern_Room1_Text_Grunt2Intro, SeafloorCavern_Room1_Text_Grunt2Defeat
 * msgbox SeafloorCavern_Room1_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SeafloorCavern_Room1_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_SEAFLOOR_CAVERN_2
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SeafloorCavern_Room1.Grunt2PostBattle)
    }
    ctx.say(SeafloorCavern_Room1.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SeafloorCavern_Room1.Grunt2Defeat)
  }
}

internal val SeafloorCavern_Room1Scripts: Map<String, Script> =
    mapOf(
        "SeafloorCavern_Room1_EventScript_Grunt1" to SeafloorCavern_Room1_EventScript_Grunt1,
        "SeafloorCavern_Room1_EventScript_Grunt2" to SeafloorCavern_Room1_EventScript_Grunt2,
    )
