package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.OneIsland_KindleRoad
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object OneIsland_KindleRoad_EventScript_Maria : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_FEMALE_MARIA,
          OneIsland_KindleRoad.MariaIntro,
          OneIsland_KindleRoad.MariaDefeat,
          OneIsland_KindleRoad.MariaPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Abigail : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_FEMALE_ABIGAIL,
          OneIsland_KindleRoad.AbigailIntro,
          OneIsland_KindleRoad.AbigailDefeat,
          OneIsland_KindleRoad.AbigailPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Finn : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_MALE_FINN,
          OneIsland_KindleRoad.FinnIntro,
          OneIsland_KindleRoad.FinnDefeat,
          OneIsland_KindleRoad.FinnPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Garrett : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_MALE_GARRETT,
          OneIsland_KindleRoad.GarrettIntro,
          OneIsland_KindleRoad.GarrettDefeat,
          OneIsland_KindleRoad.GarrettPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Tommy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_FISHERMAN_TOMMY,
          OneIsland_KindleRoad.TommyIntro,
          OneIsland_KindleRoad.TommyDefeat,
          OneIsland_KindleRoad.TommyPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Sharon : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CRUSH_GIRL_SHARON,
          OneIsland_KindleRoad.SharonIntro,
          OneIsland_KindleRoad.SharonDefeat,
          OneIsland_KindleRoad.SharonPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Tanya : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CRUSH_GIRL_TANYA,
          OneIsland_KindleRoad.TanyaIntro,
          OneIsland_KindleRoad.TanyaDefeat,
          OneIsland_KindleRoad.TanyaPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Shea : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_SHEA,
          OneIsland_KindleRoad.SheaIntro,
          OneIsland_KindleRoad.SheaDefeat,
          OneIsland_KindleRoad.SheaPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Hugh : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_HUGH,
          OneIsland_KindleRoad.HughIntro,
          OneIsland_KindleRoad.HughDefeat,
          OneIsland_KindleRoad.HughPostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Bryce : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CAMPER_BRYCE,
          OneIsland_KindleRoad.BryceIntro,
          OneIsland_KindleRoad.BryceDefeat,
          OneIsland_KindleRoad.BrycePostBattle,
      )
}

internal object OneIsland_KindleRoad_EventScript_Claire : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_CLAIRE,
          OneIsland_KindleRoad.ClaireIntro,
          OneIsland_KindleRoad.ClaireDefeat,
          OneIsland_KindleRoad.ClairePostBattle,
      )
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_MIK_KIA, OneIsland_KindleRoad_Text_MikIntro, OneIsland_KindleRoad_Text_MikDefeat, OneIsland_KindleRoad_Text_MikNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_MikRematch
 * msgbox OneIsland_KindleRoad_Text_MikPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Mik : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port OneIsland_KindleRoad_EventScript_Mik")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_MIK_KIA, OneIsland_KindleRoad_Text_KiaIntro, OneIsland_KindleRoad_Text_KiaDefeat, OneIsland_KindleRoad_Text_KiaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_KiaRematch
 * msgbox OneIsland_KindleRoad_Text_KiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Kia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port OneIsland_KindleRoad_EventScript_Kia")
}

internal object OneIsland_KindleRoad_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ETHER)) return
    ctx.removeNpc(26)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ONE_ISLAND_KINDLE_ROAD_ETHER)
  }
}

internal object OneIsland_KindleRoad_EventScript_ItemMaxRepel : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_REPEL)) return
    ctx.removeNpc(27)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ONE_ISLAND_KINDLE_ROAD_MAX_REPEL)
  }
}

internal object OneIsland_KindleRoad_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CARBOS)) return
    ctx.removeNpc(28)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ONE_ISLAND_KINDLE_ROAD_CARBOS)
  }
}

internal object OneIsland_KindleRoad_EventScript_EmberSpaSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(OneIsland_KindleRoad.EmberSpaSign)
}

internal object OneIsland_KindleRoad_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(OneIsland_KindleRoad.RouteSign)
}

internal val OneIsland_KindleRoadScripts: Map<String, Script> =
    mapOf(
        "OneIsland_KindleRoad_EventScript_Maria" to OneIsland_KindleRoad_EventScript_Maria,
        "OneIsland_KindleRoad_EventScript_Abigail" to OneIsland_KindleRoad_EventScript_Abigail,
        "OneIsland_KindleRoad_EventScript_Finn" to OneIsland_KindleRoad_EventScript_Finn,
        "OneIsland_KindleRoad_EventScript_Garrett" to OneIsland_KindleRoad_EventScript_Garrett,
        "OneIsland_KindleRoad_EventScript_Tommy" to OneIsland_KindleRoad_EventScript_Tommy,
        "OneIsland_KindleRoad_EventScript_Sharon" to OneIsland_KindleRoad_EventScript_Sharon,
        "OneIsland_KindleRoad_EventScript_Tanya" to OneIsland_KindleRoad_EventScript_Tanya,
        "OneIsland_KindleRoad_EventScript_Shea" to OneIsland_KindleRoad_EventScript_Shea,
        "OneIsland_KindleRoad_EventScript_Hugh" to OneIsland_KindleRoad_EventScript_Hugh,
        "OneIsland_KindleRoad_EventScript_Bryce" to OneIsland_KindleRoad_EventScript_Bryce,
        "OneIsland_KindleRoad_EventScript_Claire" to OneIsland_KindleRoad_EventScript_Claire,
        "OneIsland_KindleRoad_EventScript_Mik" to OneIsland_KindleRoad_EventScript_Mik,
        "OneIsland_KindleRoad_EventScript_Kia" to OneIsland_KindleRoad_EventScript_Kia,
        "OneIsland_KindleRoad_EventScript_ItemEther" to OneIsland_KindleRoad_EventScript_ItemEther,
        "OneIsland_KindleRoad_EventScript_ItemMaxRepel" to
            OneIsland_KindleRoad_EventScript_ItemMaxRepel,
        "OneIsland_KindleRoad_EventScript_ItemCarbos" to
            OneIsland_KindleRoad_EventScript_ItemCarbos,
        "OneIsland_KindleRoad_EventScript_EmberSpaSign" to
            OneIsland_KindleRoad_EventScript_EmberSpaSign,
        "OneIsland_KindleRoad_EventScript_RouteSign" to OneIsland_KindleRoad_EventScript_RouteSign,
    )
