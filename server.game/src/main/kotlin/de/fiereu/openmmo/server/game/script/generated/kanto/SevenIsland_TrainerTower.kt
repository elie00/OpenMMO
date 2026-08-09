package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_TrainerTower
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PSYCHIC_DARIO, SevenIsland_TrainerTower_Text_DarioIntro, SevenIsland_TrainerTower_Text_DarioDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_TrainerTower_EventScript_DarioRematch
 * msgbox SevenIsland_TrainerTower_Text_DarioPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_TrainerTower_EventScript_Dario : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PSYCHIC_DARIO
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_TrainerTower_EventScript_DarioRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_TrainerTower.DarioPostBattle)
    }
    ctx.say(SevenIsland_TrainerTower.DarioIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_TrainerTower.DarioDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PSYCHIC_RODETTE, SevenIsland_TrainerTower_Text_RodetteIntro, SevenIsland_TrainerTower_Text_RodetteDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_TrainerTower_EventScript_RodetteRematch
 * msgbox SevenIsland_TrainerTower_Text_RodettePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_TrainerTower_EventScript_Rodette : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PSYCHIC_RODETTE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_TrainerTower_EventScript_RodetteRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_TrainerTower.RodettePostBattle)
    }
    ctx.say(SevenIsland_TrainerTower.RodetteIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_TrainerTower.RodetteDefeat)
  }
}

internal object SevenIsland_TrainerTower_EventScript_TrainerTowerSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SevenIsland_TrainerTower.TrainerTowerSign)
}

internal object SevenIsland_TrainerTower_EventScript_TrainerTowerAheadSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SevenIsland_TrainerTower.TrainerTowerAhead)
}

internal val SevenIsland_TrainerTowerScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_TrainerTower_EventScript_Dario" to SevenIsland_TrainerTower_EventScript_Dario,
        "SevenIsland_TrainerTower_EventScript_Rodette" to
            SevenIsland_TrainerTower_EventScript_Rodette,
        "SevenIsland_TrainerTower_EventScript_TrainerTowerSign" to
            SevenIsland_TrainerTower_EventScript_TrainerTowerSign,
        "SevenIsland_TrainerTower_EventScript_TrainerTowerAheadSign" to
            SevenIsland_TrainerTower_EventScript_TrainerTowerAheadSign,
    )
