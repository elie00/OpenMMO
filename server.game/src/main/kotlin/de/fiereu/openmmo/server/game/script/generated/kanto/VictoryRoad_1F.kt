package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VictoryRoad_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** What the source game writes once the plate is held down. */
private const val PRESSED = 100

internal object VictoryRoad_1F_EventScript_Rolando : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_ROLANDO,
          VictoryRoad_1F.RolandoIntro,
          VictoryRoad_1F.RolandoDefeat,
          VictoryRoad_1F.RolandoPostBattle,
      )
}

internal object VictoryRoad_1F_EventScript_Naomi : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_NAOMI,
          VictoryRoad_1F.NaomiIntro,
          VictoryRoad_1F.NaomiDefeat,
          VictoryRoad_1F.NaomiPostBattle,
      )
}

internal object VictoryRoad_1F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.RARE_CANDY)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_1F_RARE_CANDY)
  }
}

internal object VictoryRoad_1F_EventScript_ItemTM02 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM02)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VICTORY_ROAD_1F_TM02)
  }
}

/**
 * A floor switch, which the map fires only while its var holds 99. The source game writes that 99
 * when a boulder is pushed onto the plate, so without a Strength verb nothing can arm it. The
 * script itself is here and correct for the day that verb exists.
 *
 * Its rock barrier is already walkable in the generated map, so opening it is belt and braces.
 */
internal object VictoryRoad_1F_EventScript_FloorSwitch : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.openTile(12, 14)
    ctx.openTile(12, 15)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_VICTORY_ROAD_1F, PRESSED)
  }
}

internal val VictoryRoad_1FScripts: Map<String, Script> =
    mapOf(
        "VictoryRoad_1F_EventScript_FloorSwitch" to VictoryRoad_1F_EventScript_FloorSwitch,
        "VictoryRoad_1F_EventScript_Rolando" to VictoryRoad_1F_EventScript_Rolando,
        "VictoryRoad_1F_EventScript_Naomi" to VictoryRoad_1F_EventScript_Naomi,
        "VictoryRoad_1F_EventScript_ItemRareCandy" to VictoryRoad_1F_EventScript_ItemRareCandy,
        "VictoryRoad_1F_EventScript_ItemTM02" to VictoryRoad_1F_EventScript_ItemTM02,
    )
