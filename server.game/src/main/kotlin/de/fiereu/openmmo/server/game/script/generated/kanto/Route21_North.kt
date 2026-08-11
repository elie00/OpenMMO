package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route21_North
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object Route21_North_EventScript_Ronald : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_FISHERMAN_RONALD,
          Route21_North.RonaldIntro,
          Route21_North.RonaldDefeat,
          Route21_North.RonaldPostBattle,
      )
}

internal object Route21_North_EventScript_Wade : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_FISHERMAN_WADE,
          Route21_North.WadeIntro,
          Route21_North.WadeDefeat,
          Route21_North.WadePostBattle,
      )
}

internal object Route21_North_EventScript_Spencer : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_MALE_SPENCER,
          Route21_North.SpencerIntro,
          Route21_North.SpencerDefeat,
          Route21_North.SpencerPostBattle,
      )
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_LIL_IAN, Route21_North_Text_LilIntro, Route21_North_Text_LilDefeat, Route21_North_Text_LilNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_North_EventScript_LilRematch
 * msgbox Route21_North_Text_LilPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_North_EventScript_Lil : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route21_North_EventScript_Lil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_LIL_IAN, Route21_North_Text_IanIntro, Route21_North_Text_IanDefeat, Route21_North_Text_IanNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route21_North_EventScript_IanRematch
 * msgbox Route21_North_Text_IanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route21_North_EventScript_Ian : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route21_North_EventScript_Ian")
}

internal val Route21_NorthScripts: Map<String, Script> =
    mapOf(
        "Route21_North_EventScript_Ronald" to Route21_North_EventScript_Ronald,
        "Route21_North_EventScript_Wade" to Route21_North_EventScript_Wade,
        "Route21_North_EventScript_Spencer" to Route21_North_EventScript_Spencer,
        "Route21_North_EventScript_Lil" to Route21_North_EventScript_Lil,
        "Route21_North_EventScript_Ian" to Route21_North_EventScript_Ian,
    )
