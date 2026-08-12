package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route22
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_RIVAL = 0

internal object Route22_EventScript_LeagueGateSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route22.LeagueGateSign)
}

/** The rival waiting west of Viridian, on the way out of town. */
internal object Route22_EventScript_EarlyRival : Script {
  override suspend fun run(ctx: ScriptContext) {
    val rival =
        when (Starter.byStarterNumber(ctx.getVar(KantoVars.VAR_STARTER_MON))?.rival) {
          Starter.BULBASAUR_BALL -> KantoTrainerIds.TRAINER_RIVAL_ROUTE22_EARLY_BULBASAUR
          Starter.SQUIRTLE_BALL -> KantoTrainerIds.TRAINER_RIVAL_ROUTE22_EARLY_SQUIRTLE
          Starter.CHARMANDER_BALL -> KantoTrainerIds.TRAINER_RIVAL_ROUTE22_EARLY_CHARMANDER
          null -> return
        }
    ctx.sayNpc(LOCALID_RIVAL, Route22.EarlyRivalIntro)
    // trainerbattle_no_intro: the intro box above is his.
    if (ctx.trainerBattle(rival) != BattleResult.VICTORY) return
    ctx.sayNpc(LOCALID_RIVAL, Route22.EarlyRivalDefeat)
    ctx.sayNpc(LOCALID_RIVAL, Route22.EarlyRivalPostBattle)
    ctx.removeNpc(LOCALID_RIVAL)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE22, 2)
  }
}

internal object Route22_EventScript_EarlyRivalTriggerTop : Script {
  override suspend fun run(ctx: ScriptContext) = Route22_EventScript_EarlyRival.run(ctx)
}

internal object Route22_EventScript_EarlyRivalTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) = Route22_EventScript_EarlyRival.run(ctx)
}

internal object Route22_EventScript_EarlyRivalTriggerBottom : Script {
  override suspend fun run(ctx: ScriptContext) = Route22_EventScript_EarlyRival.run(ctx)
}

/** The rival waiting west of Viridian, on the way to the league. */
internal object Route22_EventScript_LateRival : Script {
  override suspend fun run(ctx: ScriptContext) {
    val rival =
        when (Starter.byStarterNumber(ctx.getVar(KantoVars.VAR_STARTER_MON))?.rival) {
          Starter.BULBASAUR_BALL -> KantoTrainerIds.TRAINER_RIVAL_ROUTE22_LATE_BULBASAUR
          Starter.SQUIRTLE_BALL -> KantoTrainerIds.TRAINER_RIVAL_ROUTE22_LATE_SQUIRTLE
          Starter.CHARMANDER_BALL -> KantoTrainerIds.TRAINER_RIVAL_ROUTE22_LATE_CHARMANDER
          null -> return
        }
    ctx.sayNpc(LOCALID_RIVAL, Route22.LateRivalIntro)
    // trainerbattle_no_intro: the intro box above is his.
    if (ctx.trainerBattle(rival) != BattleResult.VICTORY) return
    ctx.sayNpc(LOCALID_RIVAL, Route22.LateRivalDefeat)
    ctx.sayNpc(LOCALID_RIVAL, Route22.LateRivalPostBattle)
    ctx.removeNpc(LOCALID_RIVAL)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE22, 4)
  }
}

internal object Route22_EventScript_LateRivalTriggerTop : Script {
  override suspend fun run(ctx: ScriptContext) = Route22_EventScript_LateRival.run(ctx)
}

internal object Route22_EventScript_LateRivalTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) = Route22_EventScript_LateRival.run(ctx)
}

internal object Route22_EventScript_LateRivalTriggerBottom : Script {
  override suspend fun run(ctx: ScriptContext) = Route22_EventScript_LateRival.run(ctx)
}

internal val Route22Scripts: Map<String, Script> =
    mapOf(
        "Route22_EventScript_EarlyRival" to Route22_EventScript_EarlyRival,
        "Route22_EventScript_LateRival" to Route22_EventScript_LateRival,
        "Route22_EventScript_EarlyRivalTriggerTop" to Route22_EventScript_EarlyRivalTriggerTop,
        "Route22_EventScript_EarlyRivalTriggerMid" to Route22_EventScript_EarlyRivalTriggerMid,
        "Route22_EventScript_EarlyRivalTriggerBottom" to
            Route22_EventScript_EarlyRivalTriggerBottom,
        "Route22_EventScript_LateRivalTriggerTop" to Route22_EventScript_LateRivalTriggerTop,
        "Route22_EventScript_LateRivalTriggerMid" to Route22_EventScript_LateRivalTriggerMid,
        "Route22_EventScript_LateRivalTriggerBottom" to Route22_EventScript_LateRivalTriggerBottom,
        "Route22_EventScript_LeagueGateSign" to Route22_EventScript_LeagueGateSign,
    )
