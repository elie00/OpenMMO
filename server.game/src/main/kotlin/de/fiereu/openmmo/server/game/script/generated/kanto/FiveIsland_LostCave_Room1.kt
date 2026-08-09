package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FiveIsland_LostCave_Room1
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_LAWSON, FiveIsland_LostCave_Room1_Text_LawsonIntro, FiveIsland_LostCave_Room1_Text_LawsonDefeat
 * msgbox FiveIsland_LostCave_Room1_Text_LawsonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_LostCave_Room1_EventScript_Lawson : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_LAWSON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FiveIsland_LostCave_Room1.LawsonPostBattle)
    }
    ctx.say(FiveIsland_LostCave_Room1.LawsonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_LostCave_Room1.LawsonDefeat)
  }
}

internal val FiveIsland_LostCave_Room1Scripts: Map<String, Script> =
    mapOf(
        "FiveIsland_LostCave_Room1_EventScript_Lawson" to
            FiveIsland_LostCave_Room1_EventScript_Lawson,
    )
