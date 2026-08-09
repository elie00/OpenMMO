package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route12
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_NED, Route12_Text_NedIntro, Route12_Text_NedDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_NedRematch
 * msgbox Route12_Text_NedPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Ned : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_NED
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_NedRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.NedPostBattle)
    }
    ctx.say(Route12.NedIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.NedDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_CHIP, Route12_Text_ChipIntro, Route12_Text_ChipDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_ChipRematch
 * msgbox Route12_Text_ChipPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Chip : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_CHIP
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_ChipRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.ChipPostBattle)
    }
    ctx.say(Route12.ChipIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.ChipDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_HANK, Route12_Text_HankIntro, Route12_Text_HankDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_HankRematch
 * msgbox Route12_Text_HankPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Hank : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_HANK
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_HankRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.HankPostBattle)
    }
    ctx.say(Route12.HankIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.HankDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_ELLIOT, Route12_Text_ElliotIntro, Route12_Text_ElliotDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_ElliotRematch
 * msgbox Route12_Text_ElliotPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Elliot : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_ELLIOT
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_ElliotRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.ElliotPostBattle)
    }
    ctx.say(Route12.ElliotIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.ElliotDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_GOT_POKE_FLUTE, Route12_EventScript_SnorlaxNoPokeFlute
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * msgbox Text_WantToUsePokeFlute, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, Route12_EventScript_DontUsePokeFlute
 * call EventScript_AwakenSnorlax
 * setwildbattle SPECIES_SNORLAX, 30
 * waitse
 * playmoncry SPECIES_SNORLAX, CRY_MODE_ENCOUNTER
 * delay 40
 * waitmoncry
 * setflag FLAG_HIDE_ROUTE_12_SNORLAX
 * setflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * setflag FLAG_WOKE_UP_ROUTE_12_SNORLAX
 * dowildbattle
 * clearflag FLAG_SYS_SPECIAL_WILD_BATTLE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, Route12_EventScript_FoughtSnorlax
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, Route12_EventScript_FoughtSnorlax
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, Route12_EventScript_FoughtSnorlax
 * release
 * end
 * ```
 */
internal object Route12_EventScript_Snorlax : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_Snorlax")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ROCKER_LUCA, Route12_Text_LucaIntro, Route12_Text_LucaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_LucaRematch
 * msgbox Route12_Text_LucaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Luca : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_ROCKER_LUCA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_LucaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.LucaPostBattle)
    }
    ctx.say(Route12.LucaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.LucaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_JUSTIN, Route12_Text_JustinIntro, Route12_Text_JustinDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_JustinRematch
 * msgbox Route12_Text_JustinPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Justin : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_JUSTIN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_JustinRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.JustinPostBattle)
    }
    ctx.say(Route12.JustinIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.JustinDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_ANDREW, Route12_Text_AndrewIntro, Route12_Text_AndrewDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_AndrewRematch
 * msgbox Route12_Text_AndrewPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Andrew : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_ANDREW
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route12_EventScript_AndrewRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route12.AndrewPostBattle)
    }
    ctx.say(Route12.AndrewIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route12.AndrewDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM48
 * end
 * ```
 */
internal object Route12_EventScript_ItemTM48 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM48, KantoFlags.FLAG_HIDE_ROUTE12_TM48, 9)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_IRON
 * end
 * ```
 */
internal object Route12_EventScript_ItemIron : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.IRON, KantoFlags.FLAG_HIDE_ROUTE12_IRON, 10)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_YOUNG_COUPLE_GIA_JES, Route12_Text_GiaIntro, Route12_Text_GiaDefeat, Route12_Text_GiaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_GiaRematch
 * msgbox Route12_Text_GiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Gia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_Gia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_YOUNG_COUPLE_GIA_JES, Route12_Text_JesIntro, Route12_Text_JesDefeat, Route12_Text_JesNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route12_EventScript_JesRematch
 * msgbox Route12_Text_JesPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_Jes : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_Jes")
}

internal object Route12_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route12.RouteSign)
}

internal object Route12_EventScript_FishingSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route12.SportfishingArea)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route12_Text_MonSprawledOutInSlumber
 * release
 * end
 * ```
 */
internal object Route12_EventScript_SnorlaxNoPokeFlute : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route12.MonSprawledOutInSlumber)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_YOUNG_COUPLE_GIA_JES, Route12_Text_GiaRematchIntro, Route12_Text_GiaDefeat, Route12_Text_GiaNotEnoughMons
 * msgbox Route12_Text_GiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_GiaRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_GiaRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_YOUNG_COUPLE_GIA_JES, Route12_Text_JesRematchIntro, Route12_Text_JesDefeat, Route12_Text_JesNotEnoughMons
 * msgbox Route12_Text_JesPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route12_EventScript_JesRematch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_JesRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SnorlaxReturnedToMountains
 * release
 * end
 * ```
 */
internal object Route12_EventScript_FoughtSnorlax : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_FoughtSnorlax")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object Route12_EventScript_DontUsePokeFlute : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route12_EventScript_DontUsePokeFlute")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Text_PlayedPokeFlute
 * waitmessage
 * playfanfare MUS_POKE_FLUTE
 * waitfanfare
 * msgbox Text_SnorlaxWokeUp
 * return
 * ```
 */
internal object EventScript_AwakenSnorlax : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_AwakenSnorlax")
}

internal val Route12Scripts: Map<String, Script> =
    mapOf(
        "Route12_EventScript_Ned" to Route12_EventScript_Ned,
        "Route12_EventScript_Chip" to Route12_EventScript_Chip,
        "Route12_EventScript_Hank" to Route12_EventScript_Hank,
        "Route12_EventScript_Elliot" to Route12_EventScript_Elliot,
        "Route12_EventScript_Snorlax" to Route12_EventScript_Snorlax,
        "Route12_EventScript_Luca" to Route12_EventScript_Luca,
        "Route12_EventScript_Justin" to Route12_EventScript_Justin,
        "Route12_EventScript_Andrew" to Route12_EventScript_Andrew,
        "Route12_EventScript_ItemTM48" to Route12_EventScript_ItemTM48,
        "Route12_EventScript_ItemIron" to Route12_EventScript_ItemIron,
        "Route12_EventScript_Gia" to Route12_EventScript_Gia,
        "Route12_EventScript_Jes" to Route12_EventScript_Jes,
        "Route12_EventScript_RouteSign" to Route12_EventScript_RouteSign,
        "Route12_EventScript_FishingSign" to Route12_EventScript_FishingSign,
        "Route12_EventScript_SnorlaxNoPokeFlute" to Route12_EventScript_SnorlaxNoPokeFlute,
        "Route12_EventScript_GiaRematch" to Route12_EventScript_GiaRematch,
        "Route12_EventScript_JesRematch" to Route12_EventScript_JesRematch,
        "Route12_EventScript_FoughtSnorlax" to Route12_EventScript_FoughtSnorlax,
        "Route12_EventScript_DontUsePokeFlute" to Route12_EventScript_DontUsePokeFlute,
        "EventScript_AwakenSnorlax" to EventScript_AwakenSnorlax,
    )
