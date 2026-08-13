package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_WaterPath
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SixIsland_WaterPath_EventScript_Rose : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_AROMA_LADY_ROSE,
          SixIsland_WaterPath.RoseIntro,
          SixIsland_WaterPath.RoseDefeat,
          SixIsland_WaterPath.RosePostBattle,
      )
}

internal object SixIsland_WaterPath_EventScript_Edward : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_EDWARD,
          SixIsland_WaterPath.EdwardIntro,
          SixIsland_WaterPath.EdwardDefeat,
          SixIsland_WaterPath.EdwardPostBattle,
      )
}

internal object SixIsland_WaterPath_EventScript_Samir : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_MALE_SAMIR,
          SixIsland_WaterPath.SamirIntro,
          SixIsland_WaterPath.SamirDefeat,
          SixIsland_WaterPath.SamirPostBattle,
      )
}

internal object SixIsland_WaterPath_EventScript_Denise : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_FEMALE_DENISE,
          SixIsland_WaterPath.DeniseIntro,
          SixIsland_WaterPath.DeniseDefeat,
          SixIsland_WaterPath.DenisePostBattle,
      )
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_MIU_MIA, SixIsland_WaterPath_Text_MiuIntro, SixIsland_WaterPath_Text_MiuDefeat, SixIsland_WaterPath_Text_MiuNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_MiuRematch
 * msgbox SixIsland_WaterPath_Text_MiuPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Miu : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SixIsland_WaterPath_EventScript_Miu")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_MIU_MIA, SixIsland_WaterPath_Text_MiaIntro, SixIsland_WaterPath_Text_MiaDefeat, SixIsland_WaterPath_Text_MiaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_MiaRematch
 * msgbox SixIsland_WaterPath_Text_MiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Mia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SixIsland_WaterPath_EventScript_Mia")
}

internal object SixIsland_WaterPath_EventScript_Earl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_EARL,
          SixIsland_WaterPath.EarlIntro,
          SixIsland_WaterPath.EarlDefeat,
          SixIsland_WaterPath.EarlPostBattle,
      )
}

internal object SixIsland_WaterPath_EventScript_ItemElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ELIXIR)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SIX_ISLAND_WATER_PATH_ELIXIR)
  }
}

internal object SixIsland_WaterPath_EventScript_ItemDragonScale : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.DRAGON_SCALE)) return
    ctx.removeNpc(8)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SIX_ISLAND_WATER_PATH_DRAGON_SCALE)
  }
}

internal object SixIsland_WaterPath_EventScript_HornWantedSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SixIsland_WaterPath.WantedUltimateHorn)
}

internal object SixIsland_WaterPath_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SixIsland_WaterPath.RouteSign)
}

internal val SixIsland_WaterPathScripts: Map<String, Script> =
    mapOf(
        "SixIsland_WaterPath_EventScript_Rose" to SixIsland_WaterPath_EventScript_Rose,
        "SixIsland_WaterPath_EventScript_Edward" to SixIsland_WaterPath_EventScript_Edward,
        "SixIsland_WaterPath_EventScript_Samir" to SixIsland_WaterPath_EventScript_Samir,
        "SixIsland_WaterPath_EventScript_Denise" to SixIsland_WaterPath_EventScript_Denise,
        "SixIsland_WaterPath_EventScript_Miu" to SixIsland_WaterPath_EventScript_Miu,
        "SixIsland_WaterPath_EventScript_Mia" to SixIsland_WaterPath_EventScript_Mia,
        "SixIsland_WaterPath_EventScript_Earl" to SixIsland_WaterPath_EventScript_Earl,
        "SixIsland_WaterPath_EventScript_ItemElixir" to SixIsland_WaterPath_EventScript_ItemElixir,
        "SixIsland_WaterPath_EventScript_ItemDragonScale" to
            SixIsland_WaterPath_EventScript_ItemDragonScale,
        "SixIsland_WaterPath_EventScript_HornWantedSign" to
            SixIsland_WaterPath_EventScript_HornWantedSign,
        "SixIsland_WaterPath_EventScript_RouteSign" to SixIsland_WaterPath_EventScript_RouteSign,
    )
