package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.RocketHideout_B4F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Decomp local ids of this floor's object events.
private const val LOCALID_GIOVANNI = 0
private const val LOCALID_SILPH_SCOPE = 1
private const val LOCALID_LIFT_KEY = 3

/** The boss of the hideout, whose defeat is what the Pokemon Tower is waiting on. */
internal object RocketHideout_B4F_EventScript_Giovanni : Script {
  override suspend fun run(ctx: ScriptContext) {
    // trainerbattle_no_intro: the boss gets his own message box first.
    ctx.say(RocketHideout_B4F.GiovanniIntro)
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_BOSS_GIOVANNI) != BattleResult.VICTORY) return
    ctx.say(RocketHideout_B4F.GiovanniDefeat)
    ctx.say(RocketHideout_B4F.GiovanniPostBattle)
    ctx.removeNpc(LOCALID_GIOVANNI)
    // He leaves the Silph Scope behind, and his grunts clear out of Celadon.
    ctx.showNpc(LOCALID_SILPH_SCOPE)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_SILPH_SCOPE)
    ctx.setFlag(KantoFlags.FLAG_HIDE_CELADON_ROCKETS)
  }
}

internal object RocketHideout_B4F_EventScript_SilphScope : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.SILPH_SCOPE)) return
    ctx.removeNpc(LOCALID_SILPH_SCOPE)
  }
}

internal object RocketHideout_B4F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_18,
          RocketHideout_B4F.Grunt1Intro,
          RocketHideout_B4F.Grunt1Defeat,
          RocketHideout_B4F.Grunt1PostBattle,
      )
}

internal object RocketHideout_B4F_EventScript_LiftKey : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.LIFT_KEY)) return
    ctx.removeNpc(LOCALID_LIFT_KEY)
    ctx.setFlag(KantoFlags.FLAG_CAN_USE_ROCKET_HIDEOUT_LIFT)
  }
}

internal object RocketHideout_B4F_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_17,
          RocketHideout_B4F.Grunt3Intro,
          RocketHideout_B4F.Grunt3Defeat,
          RocketHideout_B4F.Grunt3PostBattle,
      )
}

internal object RocketHideout_B4F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_16,
          RocketHideout_B4F.Grunt2Intro,
          RocketHideout_B4F.Grunt2Defeat,
          RocketHideout_B4F.Grunt2PostBattle,
      )
}

internal object RocketHideout_B4F_EventScript_ItemTM49 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM49)) return
    ctx.removeNpc(6)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B4F_TM49)
  }
}

internal object RocketHideout_B4F_EventScript_ItemMaxEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_ETHER)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B4F_MAX_ETHER)
  }
}

internal object RocketHideout_B4F_EventScript_ItemCalcium : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.CALCIUM)) return
    ctx.removeNpc(8)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCKET_HIDEOUT_B4F_CALCIUM)
  }
}

internal val RocketHideout_B4FScripts: Map<String, Script> =
    mapOf(
        "RocketHideout_B4F_EventScript_Giovanni" to RocketHideout_B4F_EventScript_Giovanni,
        "RocketHideout_B4F_EventScript_SilphScope" to RocketHideout_B4F_EventScript_SilphScope,
        "RocketHideout_B4F_EventScript_Grunt1" to RocketHideout_B4F_EventScript_Grunt1,
        "RocketHideout_B4F_EventScript_LiftKey" to RocketHideout_B4F_EventScript_LiftKey,
        "RocketHideout_B4F_EventScript_Grunt3" to RocketHideout_B4F_EventScript_Grunt3,
        "RocketHideout_B4F_EventScript_Grunt2" to RocketHideout_B4F_EventScript_Grunt2,
        "RocketHideout_B4F_EventScript_ItemTM49" to RocketHideout_B4F_EventScript_ItemTM49,
        "RocketHideout_B4F_EventScript_ItemMaxEther" to RocketHideout_B4F_EventScript_ItemMaxEther,
        "RocketHideout_B4F_EventScript_ItemCalcium" to RocketHideout_B4F_EventScript_ItemCalcium,
    )
