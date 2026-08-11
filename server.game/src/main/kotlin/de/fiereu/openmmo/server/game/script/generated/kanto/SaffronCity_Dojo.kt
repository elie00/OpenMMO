package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_Dojo
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val HITMONLEE = 106
private const val HITMONCHAN = 107
private const val DOJO_PRIZE_LEVEL = 25

/** The karate master. Beating him is what puts the two prize balls out behind him. */
internal object SaffronCity_Dojo_EventScript_MasterKoichi : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_BLACK_BELT_KOICHI)) {
      ctx.say(SaffronCity_Dojo.MasterKoichiIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_BLACK_BELT_KOICHI) != BattleResult.VICTORY) {
        return
      }
      ctx.say(SaffronCity_Dojo.MasterKoichiDefeat)
      ctx.setVar(KantoVars.VAR_MAP_SCENE_SAFFRON_CITY_DOJO, 1)
    }
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_HITMON_FROM_DOJO)) {
      return ctx.say(SaffronCity_Dojo.StayAndTrainWithUs)
    }
    ctx.say(SaffronCity_Dojo.ChoosePrizedFightingMon)
  }
}

internal object SaffronCity_Dojo_EventScript_Hitoshi : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_HITOSHI,
          SaffronCity_Dojo.HitoshiIntro,
          SaffronCity_Dojo.HitoshiDefeat,
          SaffronCity_Dojo.HitoshiPostBattle,
      )
}

internal object SaffronCity_Dojo_EventScript_Hideki : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_HIDEKI,
          SaffronCity_Dojo.HidekiIntro,
          SaffronCity_Dojo.HidekiDefeat,
          SaffronCity_Dojo.HidekiPostBattle,
      )
}

internal object SaffronCity_Dojo_EventScript_Aaron : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_AARON,
          SaffronCity_Dojo.AaronIntro,
          SaffronCity_Dojo.AaronDefeat,
          SaffronCity_Dojo.AaronPostBattle,
      )
}

internal object SaffronCity_Dojo_EventScript_Mike : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_MIKE,
          SaffronCity_Dojo.MikeIntro,
          SaffronCity_Dojo.MikeDefeat,
          SaffronCity_Dojo.MikePostBattle,
      )
}

internal object SaffronCity_Dojo_EventScript_HitmonleeBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_HITMON_FROM_DOJO)) {
      return ctx.say(SaffronCity_Dojo.BetterNotGetGreedy)
    }
    // The decomp holds up its picture first, which showmonpic has no verb for.
    if (!ctx.askYesNo(SaffronCity_Dojo.YouWantHitmonlee)) {
      return ctx.say(SaffronCity_Dojo.BetterNotGetGreedy)
    }
    ctx.givePokemon(HITMONLEE, DOJO_PRIZE_LEVEL)
    ctx.say(SaffronCity_Dojo.ReceivedMonFromKarateMaster)
    ctx.setFlag(KantoFlags.FLAG_GOT_HITMON_FROM_DOJO)
  }
}

internal object SaffronCity_Dojo_EventScript_HitmonchanBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_HITMON_FROM_DOJO)) {
      return ctx.say(SaffronCity_Dojo.BetterNotGetGreedy)
    }
    // The decomp holds up its picture first, which showmonpic has no verb for.
    if (!ctx.askYesNo(SaffronCity_Dojo.YouWantHitmonchan)) {
      return ctx.say(SaffronCity_Dojo.BetterNotGetGreedy)
    }
    ctx.givePokemon(HITMONCHAN, DOJO_PRIZE_LEVEL)
    ctx.say(SaffronCity_Dojo.ReceivedMonFromKarateMaster2)
    ctx.setFlag(KantoFlags.FLAG_GOT_HITMON_FROM_DOJO)
  }
}

internal object SaffronCity_Dojo_EventScript_Statue : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SaffronCity_Dojo.FightingDojo)
}

internal object SaffronCity_Dojo_EventScript_LeftScroll : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SaffronCity_Dojo.EnemiesOnEverySide)
}

internal object SaffronCity_Dojo_EventScript_RightScroll : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SaffronCity_Dojo.GoesAroundComesAround)
}

internal val SaffronCity_DojoScripts: Map<String, Script> =
    mapOf(
        "SaffronCity_Dojo_EventScript_Hitoshi" to SaffronCity_Dojo_EventScript_Hitoshi,
        "SaffronCity_Dojo_EventScript_Hideki" to SaffronCity_Dojo_EventScript_Hideki,
        "SaffronCity_Dojo_EventScript_Aaron" to SaffronCity_Dojo_EventScript_Aaron,
        "SaffronCity_Dojo_EventScript_Mike" to SaffronCity_Dojo_EventScript_Mike,
        "SaffronCity_Dojo_EventScript_MasterKoichi" to SaffronCity_Dojo_EventScript_MasterKoichi,
        "SaffronCity_Dojo_EventScript_HitmonleeBall" to SaffronCity_Dojo_EventScript_HitmonleeBall,
        "SaffronCity_Dojo_EventScript_HitmonchanBall" to
            SaffronCity_Dojo_EventScript_HitmonchanBall,
        "SaffronCity_Dojo_EventScript_Statue" to SaffronCity_Dojo_EventScript_Statue,
        "SaffronCity_Dojo_EventScript_LeftScroll" to SaffronCity_Dojo_EventScript_LeftScroll,
        "SaffronCity_Dojo_EventScript_RightScroll" to SaffronCity_Dojo_EventScript_RightScroll,
    )
