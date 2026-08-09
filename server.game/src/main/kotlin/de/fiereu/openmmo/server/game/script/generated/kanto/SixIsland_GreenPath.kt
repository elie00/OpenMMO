package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_GreenPath
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PSYCHIC_JACLYN, SixIsland_GreenPath_Text_JaclynIntro, SixIsland_GreenPath_Text_JaclynDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_GreenPath_EventScript_JaclynRematch
 * msgbox SixIsland_GreenPath_Text_JaclynPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_GreenPath_EventScript_Jaclyn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PSYCHIC_JACLYN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_GreenPath_EventScript_JaclynRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_GreenPath.JaclynPostBattle)
    }
    ctx.say(SixIsland_GreenPath.JaclynIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_GreenPath.JaclynDefeat)
  }
}

internal object SixIsland_GreenPath_EventScript_LeftRouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SixIsland_GreenPath.RightRouteSign)
}

internal object SixIsland_GreenPath_EventScript_RightRouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SixIsland_GreenPath.LeftRouteSign)
}

internal val SixIsland_GreenPathScripts: Map<String, Script> =
    mapOf(
        "SixIsland_GreenPath_EventScript_Jaclyn" to SixIsland_GreenPath_EventScript_Jaclyn,
        "SixIsland_GreenPath_EventScript_LeftRouteSign" to
            SixIsland_GreenPath_EventScript_LeftRouteSign,
        "SixIsland_GreenPath_EventScript_RightRouteSign" to
            SixIsland_GreenPath_EventScript_RightRouteSign,
    )
