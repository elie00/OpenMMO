package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_5F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/** VAR_MAP_SCENE_SILPH_CO_11F once Giovanni has been driven out of the building. */
private const val ROCKETS_GONE = 1

internal object SilphCo_5F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_29,
          SilphCo_5F.Grunt2Intro,
          SilphCo_5F.Grunt2Defeat,
          SilphCo_5F.Grunt2PostBattle,
      )
}

internal object SilphCo_5F_EventScript_Dalton : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_JUGGLER_DALTON,
          SilphCo_5F.DaltonIntro,
          SilphCo_5F.DaltonDefeat,
          SilphCo_5F.DaltonPostBattle,
      )
}

internal object SilphCo_5F_EventScript_WorkerM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(
          if (ctx.getVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F) >= ROCKETS_GONE)
              SilphCo_5F.YoureOurHeroThankYou
          else SilphCo_5F.RocketsInUproarAboutIntruder)
}

internal object SilphCo_5F_EventScript_Beau : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SCIENTIST_BEAU,
          SilphCo_5F.BeauIntro,
          SilphCo_5F.BeauDefeat,
          SilphCo_5F.BeauPostBattle,
      )
}

internal object SilphCo_5F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_28,
          SilphCo_5F.Grunt1Intro,
          SilphCo_5F.Grunt1Defeat,
          SilphCo_5F.Grunt1PostBattle,
      )
}

internal object SilphCo_5F_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PROTEIN)) return
    ctx.removeNpc(5)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_5F_PROTEIN)
  }
}

internal object SilphCo_5F_EventScript_ItemTM01 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM01)) return
    ctx.removeNpc(6)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_5F_TM01)
  }
}

internal object SilphCo_5F_EventScript_ItemCardKey : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CARD_KEY)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_5F_CARD_KEY)
  }
}

internal object SilphCo_5F_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SilphCo_5F.RocketBossLookingForStrongMons)
}

internal object SilphCo_5F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_5F_DOOR_1)
}

internal object SilphCo_5F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_5F_DOOR_2)
}

internal object SilphCo_5F_EventScript_Door3 : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_5F_DOOR_3)
}

internal object SilphCo_5F_EventScript_PokemonReport3 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.SomeMonsEvolveWhenTraded)
}

internal object SilphCo_5F_EventScript_PokemonReport2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.Over350TechniquesConfirmed)
}

internal object SilphCo_5F_EventScript_PokemonReport1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.PorygonFirstVRMon)
}

internal object SilphCo_5F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.FloorSign)
}

internal val SilphCo_5FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_5F_EventScript_Grunt2" to SilphCo_5F_EventScript_Grunt2,
        "SilphCo_5F_EventScript_Dalton" to SilphCo_5F_EventScript_Dalton,
        "SilphCo_5F_EventScript_WorkerM" to SilphCo_5F_EventScript_WorkerM,
        "SilphCo_5F_EventScript_Beau" to SilphCo_5F_EventScript_Beau,
        "SilphCo_5F_EventScript_Grunt1" to SilphCo_5F_EventScript_Grunt1,
        "SilphCo_5F_EventScript_ItemProtein" to SilphCo_5F_EventScript_ItemProtein,
        "SilphCo_5F_EventScript_ItemTM01" to SilphCo_5F_EventScript_ItemTM01,
        "SilphCo_5F_EventScript_ItemCardKey" to SilphCo_5F_EventScript_ItemCardKey,
        "SilphCo_5F_EventScript_Scientist" to SilphCo_5F_EventScript_Scientist,
        "SilphCo_5F_EventScript_Door1" to SilphCo_5F_EventScript_Door1,
        "SilphCo_5F_EventScript_Door2" to SilphCo_5F_EventScript_Door2,
        "SilphCo_5F_EventScript_Door3" to SilphCo_5F_EventScript_Door3,
        "SilphCo_5F_EventScript_PokemonReport3" to SilphCo_5F_EventScript_PokemonReport3,
        "SilphCo_5F_EventScript_PokemonReport2" to SilphCo_5F_EventScript_PokemonReport2,
        "SilphCo_5F_EventScript_PokemonReport1" to SilphCo_5F_EventScript_PokemonReport1,
        "SilphCo_5F_EventScript_FloorSign" to SilphCo_5F_EventScript_FloorSign,
    )
