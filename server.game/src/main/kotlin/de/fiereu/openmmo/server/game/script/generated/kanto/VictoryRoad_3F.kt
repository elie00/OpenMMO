package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VictoryRoad_3F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** What the source game writes once the plate is held down. */
private const val PRESSED = 100

internal object VictoryRoad_3F_EventScript_George : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_GEORGE,
          VictoryRoad_3F.GeorgeIntro,
          VictoryRoad_3F.GeorgeDefeat,
          VictoryRoad_3F.GeorgePostBattle,
      )
}

internal object VictoryRoad_3F_EventScript_Alexa : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_ALEXA,
          VictoryRoad_3F.AlexaIntro,
          VictoryRoad_3F.AlexaDefeat,
          VictoryRoad_3F.AlexaPostBattle,
      )
}

internal object VictoryRoad_3F_EventScript_Colby : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_COLBY,
          VictoryRoad_3F.ColbyIntro,
          VictoryRoad_3F.ColbyDefeat,
          VictoryRoad_3F.ColbyPostBattle,
      )
}

internal object VictoryRoad_3F_EventScript_Caroline : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_CAROLINE,
          VictoryRoad_3F.CarolineIntro,
          VictoryRoad_3F.CarolineDefeat,
          VictoryRoad_3F.CarolinePostBattle,
      )
}

internal object VictoryRoad_3F_EventScript_ItemMaxRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_REVIVE)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_3F_MAX_REVIVE)
  }
}

internal object VictoryRoad_3F_EventScript_ItemTM50 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM50)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_3F_TM50)
  }
}

/** trainerbattle_double: the couple share one trainer id, fought here as a single. */
internal object VictoryRoad_3F_EventScript_Ray : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOL_COUPLE_RAY_TYRA,
          VictoryRoad_3F.RayIntro,
          VictoryRoad_3F.RayDefeat,
          VictoryRoad_3F.RayPostBattle,
      )
}

/** trainerbattle_double: the couple share one trainer id, fought here as a single. */
internal object VictoryRoad_3F_EventScript_Tyra : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOL_COUPLE_RAY_TYRA,
          VictoryRoad_3F.TyraIntro,
          VictoryRoad_3F.TyraDefeat,
          VictoryRoad_3F.TyraPostBattle,
      )
}

/**
 * A floor switch, which the map fires only while its var holds 99. The source game writes that 99
 * when a boulder is pushed onto the plate, so without a Strength verb nothing can arm it. The
 * script itself is here and correct for the day that verb exists.
 *
 * Its rock barrier is already walkable in the generated map, so opening it is belt and braces.
 */
internal object VictoryRoad_3F_EventScript_FloorSwitch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.openTile(12, 12)
    ctx.openTile(12, 13)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_VICTORY_ROAD_3F, PRESSED)
  }
}

internal val VictoryRoad_3FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_3F_EventScript_FloorSwitch" to VictoryRoad_3F_EventScript_FloorSwitch,
        "VictoryRoad_3F_EventScript_George" to VictoryRoad_3F_EventScript_George,
        "VictoryRoad_3F_EventScript_Alexa" to VictoryRoad_3F_EventScript_Alexa,
        "VictoryRoad_3F_EventScript_Colby" to VictoryRoad_3F_EventScript_Colby,
        "VictoryRoad_3F_EventScript_Caroline" to VictoryRoad_3F_EventScript_Caroline,
        "VictoryRoad_3F_EventScript_ItemMaxRevive" to VictoryRoad_3F_EventScript_ItemMaxRevive,
        "VictoryRoad_3F_EventScript_ItemTM50" to VictoryRoad_3F_EventScript_ItemTM50,
        "VictoryRoad_3F_EventScript_Ray" to VictoryRoad_3F_EventScript_Ray,
        "VictoryRoad_3F_EventScript_Tyra" to VictoryRoad_3F_EventScript_Tyra,
    )
