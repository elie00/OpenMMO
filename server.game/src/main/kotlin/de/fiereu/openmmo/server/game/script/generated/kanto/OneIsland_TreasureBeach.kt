package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.OneIsland_TreasureBeach
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_AMARA, OneIsland_TreasureBeach_Text_AmaraIntro, OneIsland_TreasureBeach_Text_AmaraDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_TreasureBeach_EventScript_AmaraRematch
 * msgbox OneIsland_TreasureBeach_Text_AmaraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_TreasureBeach_EventScript_Amara : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_AMARA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_TreasureBeach_EventScript_AmaraRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_TreasureBeach.AmaraPostBattle)
    }
    ctx.say(OneIsland_TreasureBeach.AmaraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_TreasureBeach.AmaraDefeat)
  }
}

internal object OneIsland_TreasureBeach_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(OneIsland_TreasureBeach.GoodThingsWashUpOnBeach)
}

internal val OneIsland_TreasureBeachScripts: Map<String, Script> =
    mapOf(
        "OneIsland_TreasureBeach_EventScript_Amara" to OneIsland_TreasureBeach_EventScript_Amara,
        "OneIsland_TreasureBeach_EventScript_Boy" to OneIsland_TreasureBeach_EventScript_Boy,
    )
