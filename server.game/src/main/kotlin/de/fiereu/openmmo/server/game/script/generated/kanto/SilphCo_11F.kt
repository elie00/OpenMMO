package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_11F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Decomp local ids of this floor's object events.
private const val LOCALID_GIOVANNI = 2
private const val LOCALID_GRUNT1 = 3
private const val LOCALID_GRUNT2 = 5

internal object SilphCo_11F_EventScript_President : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_MASTER_BALL_FROM_SILPH)) {
      return ctx.say(SilphCo_11F.ThatsOurSecretPrototype)
    }
    ctx.say(
        if (ctx.isFemale) SilphCo_11F.ThanksForSavingMeDearGirl
        else SilphCo_11F.ThanksForSavingMeDearBoy)
    if (!ctx.giveItem(Items.MASTER_BALL)) {
      return ctx.say(SilphCo_11F.YouHaveNoRoomForThis)
    }
    ctx.say(SilphCo_11F.ObtainedMasterBallFromPresident)
    ctx.say(SilphCo_11F.ThatsOurSecretPrototype)
    ctx.setFlag(KantoFlags.FLAG_GOT_MASTER_BALL_FROM_SILPH)
  }
}

internal object SilphCo_11F_EventScript_Secretary : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SilphCo_11F.ThanksForRescuingUs)
}

internal object SilphCo_11F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_40,
          SilphCo_11F.Grunt1Intro,
          SilphCo_11F.Grunt1Defeat,
          SilphCo_11F.Grunt1PostBattle,
      )
}

internal object SilphCo_11F_EventScript_ItemZinc : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ZINC)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SILPH_CO_11F_ZINC)
  }
}

internal object SilphCo_11F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_41,
          SilphCo_11F.Grunt2Intro,
          SilphCo_11F.Grunt2Defeat,
          SilphCo_11F.Grunt2PostBattle,
      )
}

internal object SilphCo_11F_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = silphCoDoor(ctx, KantoFlags.FLAG_SILPH_11F_DOOR)
}

internal object SilphCo_11F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_11F.FloorSign)
}

/**
 * The Rocket boss on the top floor, which the map's two coord events fire as the player steps out
 * of the lift. Beating him here empties the whole building and puts Saffron's people back on its
 * streets.
 */
internal object SilphCo_11F_EventScript_BattleGiovanni : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.sayNpc(LOCALID_GIOVANNI, SilphCo_11F.GiovanniIntro)
    // trainerbattle_no_intro: the intro box above is his.
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_BOSS_GIOVANNI_2) != BattleResult.VICTORY) return
    ctx.sayNpc(LOCALID_GIOVANNI, SilphCo_11F.GiovanniDefeat)
    ctx.sayNpc(LOCALID_GIOVANNI, SilphCo_11F.GiovanniPostBattle)
    ctx.removeNpc(LOCALID_GIOVANNI)
    ctx.removeNpc(LOCALID_GRUNT1)
    ctx.removeNpc(LOCALID_GRUNT2)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_SILPH_CO_11F, 1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SAFFRON_ROCKETS)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_SAFFRON_CIVILIANS)
  }
}

internal object SilphCo_11F_EventScript_GiovanniTriggerLeft : Script {
  override suspend fun run(ctx: ScriptContext) = SilphCo_11F_EventScript_BattleGiovanni.run(ctx)
}

internal object SilphCo_11F_EventScript_GiovanniTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) = SilphCo_11F_EventScript_BattleGiovanni.run(ctx)
}

internal val SilphCo_11FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_11F_EventScript_BattleGiovanni" to SilphCo_11F_EventScript_BattleGiovanni,
        "SilphCo_11F_EventScript_GiovanniTriggerLeft" to
            SilphCo_11F_EventScript_GiovanniTriggerLeft,
        "SilphCo_11F_EventScript_GiovanniTriggerRight" to
            SilphCo_11F_EventScript_GiovanniTriggerRight,
        "SilphCo_11F_EventScript_President" to SilphCo_11F_EventScript_President,
        "SilphCo_11F_EventScript_Secretary" to SilphCo_11F_EventScript_Secretary,
        "SilphCo_11F_EventScript_Grunt1" to SilphCo_11F_EventScript_Grunt1,
        "SilphCo_11F_EventScript_ItemZinc" to SilphCo_11F_EventScript_ItemZinc,
        "SilphCo_11F_EventScript_Grunt2" to SilphCo_11F_EventScript_Grunt2,
        "SilphCo_11F_EventScript_Door" to SilphCo_11F_EventScript_Door,
        "SilphCo_11F_EventScript_FloorSign" to SilphCo_11F_EventScript_FloorSign,
    )
