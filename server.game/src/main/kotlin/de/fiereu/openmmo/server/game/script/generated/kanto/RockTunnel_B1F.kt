package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.RockTunnel_B1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_POKEMANIAC_COOPER, RockTunnel_B1F_Text_CooperIntro, RockTunnel_B1F_Text_CooperDefeat
 * msgbox RockTunnel_B1F_Text_CooperPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Cooper : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_POKEMANIAC_COOPER
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.CooperPostBattle)
    }
    ctx.say(RockTunnel_B1F.CooperIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.CooperDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_DUDLEY, RockTunnel_B1F_Text_DudleyIntro, RockTunnel_B1F_Text_DudleyDefeat
 * msgbox RockTunnel_B1F_Text_DudleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Dudley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_DUDLEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.DudleyPostBattle)
    }
    ctx.say(RockTunnel_B1F.DudleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.DudleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_SOFIA, RockTunnel_B1F_Text_SofiaIntro, RockTunnel_B1F_Text_SofiaDefeat
 * msgbox RockTunnel_B1F_Text_SofiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Sofia : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_SOFIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.SofiaPostBattle)
    }
    ctx.say(RockTunnel_B1F.SofiaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.SofiaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_ALLEN, RockTunnel_B1F_Text_AllenIntro, RockTunnel_B1F_Text_AllenDefeat
 * msgbox RockTunnel_B1F_Text_AllenPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Allen : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_ALLEN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.AllenPostBattle)
    }
    ctx.say(RockTunnel_B1F.AllenIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.AllenDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_ERIC, RockTunnel_B1F_Text_EricIntro, RockTunnel_B1F_Text_EricDefeat
 * msgbox RockTunnel_B1F_Text_EricPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Eric : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_ERIC
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.EricPostBattle)
    }
    ctx.say(RockTunnel_B1F.EricIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.EricDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_POKEMANIAC_STEVE, RockTunnel_B1F_Text_SteveIntro, RockTunnel_B1F_Text_SteveDefeat
 * msgbox RockTunnel_B1F_Text_StevePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Steve : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_POKEMANIAC_STEVE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.StevePostBattle)
    }
    ctx.say(RockTunnel_B1F.SteveIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.SteveDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_MARTHA, RockTunnel_B1F_Text_MarthaIntro, RockTunnel_B1F_Text_MarthaDefeat
 * msgbox RockTunnel_B1F_Text_MarthaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Martha : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_MARTHA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.MarthaPostBattle)
    }
    ctx.say(RockTunnel_B1F.MarthaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.MarthaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_POKEMANIAC_WINSTON, RockTunnel_B1F_Text_WinstonIntro, RockTunnel_B1F_Text_WinstonDefeat
 * msgbox RockTunnel_B1F_Text_WinstonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_Winston : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_POKEMANIAC_WINSTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(RockTunnel_B1F.WinstonPostBattle)
    }
    ctx.say(RockTunnel_B1F.WinstonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(RockTunnel_B1F.WinstonDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_ROCK_SLIDE, EventScript_RockSlideTaught
 * msgbox Text_RockSlideTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_RockSlideDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_RockSlideDeclined
 * msgbox Text_RockSlideWhichMon
 * setvar VAR_0x8005, MOVETUTOR_ROCK_SLIDE
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_RockSlideDeclined
 * setflag FLAG_TUTOR_ROCK_SLIDE
 * goto EventScript_RockSlideTaught
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_RockSlideTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RockTunnel_B1F_EventScript_RockSlideTutor")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVE
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVE, KantoFlags.FLAG_HIDE_ROCK_TUNNEL_B1F_REVIVE, 9)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_ETHER
 * end
 * ```
 */
internal object RockTunnel_B1F_EventScript_ItemMaxEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_ETHER, KantoFlags.FLAG_HIDE_ROCK_TUNNEL_B1F_MAX_ETHER, 10)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_RockSlideTaught
 * release
 * end
 * ```
 */
internal object EventScript_RockSlideTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RockSlideTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_RockSlideDeclined
 * release
 * end
 * ```
 */
internal object EventScript_RockSlideDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RockSlideDeclined")
}

internal val RockTunnel_B1FScripts: Map<String, Script> =
    mapOf(
        "RockTunnel_B1F_EventScript_Cooper" to RockTunnel_B1F_EventScript_Cooper,
        "RockTunnel_B1F_EventScript_Dudley" to RockTunnel_B1F_EventScript_Dudley,
        "RockTunnel_B1F_EventScript_Sofia" to RockTunnel_B1F_EventScript_Sofia,
        "RockTunnel_B1F_EventScript_Allen" to RockTunnel_B1F_EventScript_Allen,
        "RockTunnel_B1F_EventScript_Eric" to RockTunnel_B1F_EventScript_Eric,
        "RockTunnel_B1F_EventScript_Steve" to RockTunnel_B1F_EventScript_Steve,
        "RockTunnel_B1F_EventScript_Martha" to RockTunnel_B1F_EventScript_Martha,
        "RockTunnel_B1F_EventScript_Winston" to RockTunnel_B1F_EventScript_Winston,
        "RockTunnel_B1F_EventScript_RockSlideTutor" to RockTunnel_B1F_EventScript_RockSlideTutor,
        "RockTunnel_B1F_EventScript_ItemRevive" to RockTunnel_B1F_EventScript_ItemRevive,
        "RockTunnel_B1F_EventScript_ItemMaxEther" to RockTunnel_B1F_EventScript_ItemMaxEther,
        "EventScript_RockSlideTaught" to EventScript_RockSlideTaught,
        "EventScript_RockSlideDeclined" to EventScript_RockSlideDeclined,
    )
