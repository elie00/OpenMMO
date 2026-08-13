package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_TanobyRuins
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SevenIsland_TanobyRuins_EventScript_Brandon : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_RUIN_MANIAC_BRANDON,
          SevenIsland_TanobyRuins.BrandonIntro,
          SevenIsland_TanobyRuins.BrandonDefeat,
          SevenIsland_TanobyRuins.BrandonPostBattle,
      )
}

internal object SevenIsland_TanobyRuins_EventScript_Benjamin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_RUIN_MANIAC_BENJAMIN,
          SevenIsland_TanobyRuins.BenjaminIntro,
          SevenIsland_TanobyRuins.BenjaminDefeat,
          SevenIsland_TanobyRuins.BenjaminPostBattle,
      )
}

internal object SevenIsland_TanobyRuins_EventScript_Edna : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PAINTER_EDNA,
          SevenIsland_TanobyRuins.EdnaIntro,
          SevenIsland_TanobyRuins.EdnaDefeat,
          SevenIsland_TanobyRuins.EdnaPostBattle,
      )
}

internal object SevenIsland_TanobyRuins_EventScript_Clifford : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GENTLEMAN_CLIFFORD,
          SevenIsland_TanobyRuins.CliffordIntro,
          SevenIsland_TanobyRuins.CliffordDefeat,
          SevenIsland_TanobyRuins.CliffordPostBattle,
      )
}

internal val SevenIsland_TanobyRuinsScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_TanobyRuins_EventScript_Brandon" to
            SevenIsland_TanobyRuins_EventScript_Brandon,
        "SevenIsland_TanobyRuins_EventScript_Benjamin" to
            SevenIsland_TanobyRuins_EventScript_Benjamin,
        "SevenIsland_TanobyRuins_EventScript_Edna" to SevenIsland_TanobyRuins_EventScript_Edna,
        "SevenIsland_TanobyRuins_EventScript_Clifford" to
            SevenIsland_TanobyRuins_EventScript_Clifford,
    )
