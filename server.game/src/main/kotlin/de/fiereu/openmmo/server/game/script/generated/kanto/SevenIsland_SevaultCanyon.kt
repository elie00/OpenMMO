package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_SevaultCanyon
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SevenIsland_SevaultCanyon_EventScript_Cyndy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CRUSH_GIRL_CYNDY,
          SevenIsland_SevaultCanyon.CyndyIntro,
          SevenIsland_SevaultCanyon.CyndyDefeat,
          SevenIsland_SevaultCanyon.CyndyPostBattle,
      )
}

internal object SevenIsland_SevaultCanyon_EventScript_Evan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TAMER_EVAN,
          SevenIsland_SevaultCanyon.EvanIntro,
          SevenIsland_SevaultCanyon.EvanDefeat,
          SevenIsland_SevaultCanyon.EvanPostBattle,
      )
}

internal object SevenIsland_SevaultCanyon_EventScript_Jackson : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PKMN_RANGER_JACKSON,
          SevenIsland_SevaultCanyon.JacksonIntro,
          SevenIsland_SevaultCanyon.JacksonDefeat,
          SevenIsland_SevaultCanyon.JacksonPostBattle,
      )
}

internal object SevenIsland_SevaultCanyon_EventScript_Katelyn : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PKMN_RANGER_KATELYN,
          SevenIsland_SevaultCanyon.KatelynIntro,
          SevenIsland_SevaultCanyon.KatelynDefeat,
          SevenIsland_SevaultCanyon.KatelynPostBattle,
      )
}

internal object SevenIsland_SevaultCanyon_EventScript_Leroy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_LEROY,
          SevenIsland_SevaultCanyon.LeroyIntro,
          SevenIsland_SevaultCanyon.LeroyDefeat,
          SevenIsland_SevaultCanyon.LeroyPostBattle,
      )
}

internal object SevenIsland_SevaultCanyon_EventScript_Michelle : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_MICHELLE,
          SevenIsland_SevaultCanyon.MichelleIntro,
          SevenIsland_SevaultCanyon.MichelleDefeat,
          SevenIsland_SevaultCanyon.MichellePostBattle,
      )
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_COOL_COUPLE_LEX_NYA, SevenIsland_SevaultCanyon_Text_LexIntro, SevenIsland_SevaultCanyon_Text_LexDefeat, SevenIsland_SevaultCanyon_Text_LexNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_EventScript_LexRematch
 * msgbox SevenIsland_SevaultCanyon_Text_LexPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_EventScript_Lex : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_EventScript_Lex")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_COOL_COUPLE_LEX_NYA, SevenIsland_SevaultCanyon_Text_NyaIntro, SevenIsland_SevaultCanyon_Text_NyaDefeat, SevenIsland_SevaultCanyon_Text_NyaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_EventScript_NyaRematch
 * msgbox SevenIsland_SevaultCanyon_Text_NyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_EventScript_Nya : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_EventScript_Nya")
}

internal object SevenIsland_SevaultCanyon_EventScript_ItemKingsRock : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.KINGS_ROCK)) return
    ctx.removeNpc(16)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEVEN_ISLAND_SEVAULT_CANYON_KINGS_ROCK)
  }
}

internal object SevenIsland_SevaultCanyon_EventScript_ItemMaxElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_ELIXIR)) return
    ctx.removeNpc(17)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEVEN_ISLAND_SEVAULT_CANYON_MAX_ELIXIR)
  }
}

internal object SevenIsland_SevaultCanyon_EventScript_ItemNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.NUGGET)) return
    ctx.removeNpc(18)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SEVEN_ISLAND_SEVAULT_CANYON_NUGGET)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_BRUNO, 5
 * msgbox SevenIsland_SevaultCanyon_Text_BrunoTrainedWithBrawly
 * release
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_EventScript_BlackBelt")
}

internal object SevenIsland_SevaultCanyon_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SevenIsland_SevaultCanyon.RouteSign)
}

internal val SevenIsland_SevaultCanyonScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_SevaultCanyon_EventScript_Cyndy" to
            SevenIsland_SevaultCanyon_EventScript_Cyndy,
        "SevenIsland_SevaultCanyon_EventScript_Evan" to SevenIsland_SevaultCanyon_EventScript_Evan,
        "SevenIsland_SevaultCanyon_EventScript_Jackson" to
            SevenIsland_SevaultCanyon_EventScript_Jackson,
        "SevenIsland_SevaultCanyon_EventScript_Katelyn" to
            SevenIsland_SevaultCanyon_EventScript_Katelyn,
        "SevenIsland_SevaultCanyon_EventScript_Leroy" to
            SevenIsland_SevaultCanyon_EventScript_Leroy,
        "SevenIsland_SevaultCanyon_EventScript_Michelle" to
            SevenIsland_SevaultCanyon_EventScript_Michelle,
        "SevenIsland_SevaultCanyon_EventScript_Lex" to SevenIsland_SevaultCanyon_EventScript_Lex,
        "SevenIsland_SevaultCanyon_EventScript_Nya" to SevenIsland_SevaultCanyon_EventScript_Nya,
        "SevenIsland_SevaultCanyon_EventScript_ItemKingsRock" to
            SevenIsland_SevaultCanyon_EventScript_ItemKingsRock,
        "SevenIsland_SevaultCanyon_EventScript_ItemMaxElixir" to
            SevenIsland_SevaultCanyon_EventScript_ItemMaxElixir,
        "SevenIsland_SevaultCanyon_EventScript_ItemNugget" to
            SevenIsland_SevaultCanyon_EventScript_ItemNugget,
        "SevenIsland_SevaultCanyon_EventScript_BlackBelt" to
            SevenIsland_SevaultCanyon_EventScript_BlackBelt,
        "SevenIsland_SevaultCanyon_EventScript_RouteSign" to
            SevenIsland_SevaultCanyon_EventScript_RouteSign,
    )
