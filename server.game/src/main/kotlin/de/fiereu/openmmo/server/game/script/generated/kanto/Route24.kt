package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route24
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_ROUTE24, 1, Route24_EventScript_RocketPostBattle
 * msgbox Route24_Text_JustEarnedFabulousPrize
 * checkitemspace ITEM_NUGGET
 * goto_if_eq VAR_RESULT, FALSE, Route24_EventScript_NoRoomForNugget
 * call Route24_EventScript_BattleRocket
 * release
 * end
 * ```
 */
internal object Route24_EventScript_Rocket : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route24_EventScript_Rocket")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_ETHAN, Route24_Text_EthanIntro, Route24_Text_EthanDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route24_EventScript_EthanRematch
 * msgbox Route24_Text_EthanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route24_EventScript_Ethan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_ETHAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route24_EventScript_EthanRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route24.EthanPostBattle)
    }
    ctx.say(Route24.EthanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route24.EthanDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_RELI, Route24_Text_ReliIntro, Route24_Text_ReliDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route24_EventScript_ReliRematch
 * msgbox Route24_Text_ReliPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route24_EventScript_Reli : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_RELI
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route24_EventScript_ReliRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route24.ReliPostBattle)
    }
    ctx.say(Route24.ReliIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route24.ReliDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_TIMMY, Route24_Text_TimmyIntro, Route24_Text_TimmyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route24_EventScript_TimmyRematch
 * msgbox Route24_Text_TimmyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route24_EventScript_Timmy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_TIMMY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route24_EventScript_TimmyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route24.TimmyPostBattle)
    }
    ctx.say(Route24.TimmyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route24.TimmyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_ALI, Route24_Text_AliIntro, Route24_Text_AliDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route24_EventScript_AliRematch
 * msgbox Route24_Text_AliPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route24_EventScript_Ali : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_ALI
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route24_EventScript_AliRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route24.AliPostBattle)
    }
    ctx.say(Route24.AliIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route24.AliDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BUG_CATCHER_CALE, Route24_Text_CaleIntro, Route24_Text_CaleDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route24_EventScript_CaleRematch
 * msgbox Route24_Text_CalePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route24_EventScript_Cale : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BUG_CATCHER_CALE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route24_EventScript_CaleRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route24.CalePostBattle)
    }
    ctx.say(Route24.CaleIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route24.CaleDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_SHANE, Route24_Text_ShaneIntro, Route24_Text_ShaneDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route24_EventScript_ShaneRematch
 * msgbox Route24_Text_ShanePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route24_EventScript_Shane : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_SHANE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route24_EventScript_ShaneRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route24.ShanePostBattle)
    }
    ctx.say(Route24.ShaneIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route24.ShaneDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM45
 * end
 * ```
 */
internal object Route24_EventScript_ItemTM45 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM45, KantoFlags.FLAG_HIDE_ROUTE24_TM45, 7)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route24_Text_YoudBecomeTopRocketLeader
 * release
 * end
 * ```
 */
internal object Route24_EventScript_RocketPostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route24.YoudBecomeTopRocketLeader)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route24_Text_YouDontHaveAnyRoom
 * release
 * end
 * ```
 */
internal object Route24_EventScript_NoRoomForNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route24.YouDontHaveAnyRoom)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * giveitem_msg Route24_Text_ReceivedNuggetFromMysteryTrainer, ITEM_NUGGET
 * message Route24_Text_JoinTeamRocket
 * waitmessage
 * playbgm MUS_ENCOUNTER_ROCKET, 0
 * waitbuttonpress
 * setvar VAR_LAST_TALKED, LOCALID_ROUTE24_ROCKET
 * trainerbattle_no_intro TRAINER_TEAM_ROCKET_GRUNT_6, Route24_Text_RocketDefeat
 * msgbox Route24_Text_YoudBecomeTopRocketLeader
 * setvar VAR_MAP_SCENE_ROUTE24, 1
 * return
 * ```
 */
internal object Route24_EventScript_BattleRocket : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route24_EventScript_BattleRocket")
}

internal val Route24Scripts: Map<String, Script> =
    mapOf(
        "Route24_EventScript_Rocket" to Route24_EventScript_Rocket,
        "Route24_EventScript_Ethan" to Route24_EventScript_Ethan,
        "Route24_EventScript_Reli" to Route24_EventScript_Reli,
        "Route24_EventScript_Timmy" to Route24_EventScript_Timmy,
        "Route24_EventScript_Ali" to Route24_EventScript_Ali,
        "Route24_EventScript_Cale" to Route24_EventScript_Cale,
        "Route24_EventScript_Shane" to Route24_EventScript_Shane,
        "Route24_EventScript_ItemTM45" to Route24_EventScript_ItemTM45,
        "Route24_EventScript_RocketPostBattle" to Route24_EventScript_RocketPostBattle,
        "Route24_EventScript_NoRoomForNugget" to Route24_EventScript_NoRoomForNugget,
        "Route24_EventScript_BattleRocket" to Route24_EventScript_BattleRocket,
    )
