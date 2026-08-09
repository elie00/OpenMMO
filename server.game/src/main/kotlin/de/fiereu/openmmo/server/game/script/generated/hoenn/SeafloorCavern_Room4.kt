package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SeafloorCavern_Room4
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_SEAFLOOR_CAVERN_3, SeafloorCavern_Room4_Text_Grunt3Intro, SeafloorCavern_Room4_Text_Grunt3Defeat
 * msgbox SeafloorCavern_Room4_Text_Grunt3PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SeafloorCavern_Room4_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_SEAFLOOR_CAVERN_3
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SeafloorCavern_Room4.Grunt3PostBattle)
    }
    ctx.say(SeafloorCavern_Room4.Grunt3Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SeafloorCavern_Room4.Grunt3Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GRUNT_SEAFLOOR_CAVERN_4, SeafloorCavern_Room4_Text_Grunt4Intro, SeafloorCavern_Room4_Text_Grunt4Defeat
 * msgbox SeafloorCavern_Room4_Text_Grunt4PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SeafloorCavern_Room4_EventScript_Grunt4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GRUNT_SEAFLOOR_CAVERN_4
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SeafloorCavern_Room4.Grunt4PostBattle)
    }
    ctx.say(SeafloorCavern_Room4.Grunt4Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SeafloorCavern_Room4.Grunt4Defeat)
  }
}

internal val SeafloorCavern_Room4Scripts: Map<String, Script> =
    mapOf(
        "SeafloorCavern_Room4_EventScript_Grunt3" to SeafloorCavern_Room4_EventScript_Grunt3,
        "SeafloorCavern_Room4_EventScript_Grunt4" to SeafloorCavern_Room4_EventScript_Grunt4,
    )
