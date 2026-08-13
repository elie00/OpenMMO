package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_OutcastIsland
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SixIsland_OutcastIsland_EventScript_Rocket : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_46,
          SixIsland_OutcastIsland.RocketIntro,
          SixIsland_OutcastIsland.RocketDefeat,
          SixIsland_OutcastIsland.RocketPostBattle,
      )
}

internal object SixIsland_OutcastIsland_EventScript_Tylor : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_FISHERMAN_TYLOR,
          SixIsland_OutcastIsland.TylorIntro,
          SixIsland_OutcastIsland.TylorDefeat,
          SixIsland_OutcastIsland.TylorPostBattle,
      )
}

internal object SixIsland_OutcastIsland_EventScript_Mymo : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_MALE_MYMO,
          SixIsland_OutcastIsland.MymoIntro,
          SixIsland_OutcastIsland.MymoDefeat,
          SixIsland_OutcastIsland.MymoPostBattle,
      )
}

internal object SixIsland_OutcastIsland_EventScript_Nicole : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SWIMMER_FEMALE_NICOLE,
          SixIsland_OutcastIsland.NicoleIntro,
          SixIsland_OutcastIsland.NicoleDefeat,
          SixIsland_OutcastIsland.NicolePostBattle,
      )
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_AVA_GEB, SixIsland_OutcastIsland_Text_AvaIntro, SixIsland_OutcastIsland_Text_AvaDefeat, SixIsland_OutcastIsland_Text_AvaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_AvaRematch
 * msgbox SixIsland_OutcastIsland_Text_AvaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Ava : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Ava")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_AVA_GEB, SixIsland_OutcastIsland_Text_GebIntro, SixIsland_OutcastIsland_Text_GebDefeat, SixIsland_OutcastIsland_Text_GebNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_GebRematch
 * msgbox SixIsland_OutcastIsland_Text_GebPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Geb : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Geb")
}

internal object SixIsland_OutcastIsland_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PP_UP)) return
    ctx.removeNpc(6)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SIX_ISLAND_OUTCAST_ISLAND_PP_UP)
  }
}

internal val SixIsland_OutcastIslandScripts: Map<String, Script> =
    mapOf(
        "SixIsland_OutcastIsland_EventScript_Rocket" to SixIsland_OutcastIsland_EventScript_Rocket,
        "SixIsland_OutcastIsland_EventScript_Tylor" to SixIsland_OutcastIsland_EventScript_Tylor,
        "SixIsland_OutcastIsland_EventScript_Mymo" to SixIsland_OutcastIsland_EventScript_Mymo,
        "SixIsland_OutcastIsland_EventScript_Nicole" to SixIsland_OutcastIsland_EventScript_Nicole,
        "SixIsland_OutcastIsland_EventScript_Ava" to SixIsland_OutcastIsland_EventScript_Ava,
        "SixIsland_OutcastIsland_EventScript_Geb" to SixIsland_OutcastIsland_EventScript_Geb,
        "SixIsland_OutcastIsland_EventScript_ItemPPUp" to
            SixIsland_OutcastIsland_EventScript_ItemPPUp,
    )
