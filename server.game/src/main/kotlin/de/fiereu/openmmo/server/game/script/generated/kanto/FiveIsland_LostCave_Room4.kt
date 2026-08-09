package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FiveIsland_LostCave_Room4
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PSYCHIC_LAURA, FiveIsland_LostCave_Room4_Text_LauraIntro, FiveIsland_LostCave_Room4_Text_LauraDefeat
 * msgbox FiveIsland_LostCave_Room4_Text_LauraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_LostCave_Room4_EventScript_Laura : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PSYCHIC_LAURA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FiveIsland_LostCave_Room4.LauraPostBattle)
    }
    ctx.say(FiveIsland_LostCave_Room4.LauraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_LostCave_Room4.LauraDefeat)
  }
}

internal val FiveIsland_LostCave_Room4Scripts: Map<String, Script> =
    mapOf(
        "FiveIsland_LostCave_Room4_EventScript_Laura" to
            FiveIsland_LostCave_Room4_EventScript_Laura,
    )
