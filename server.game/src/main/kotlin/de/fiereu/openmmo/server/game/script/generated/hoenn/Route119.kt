package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route119
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GREG, Route119_Text_GregIntro, Route119_Text_GregDefeat
 * msgbox Route119_Text_GregPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Greg : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_GREG
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.GregPostBattle)
    }
    ctx.say(Route119.GregIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.GregDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAYLOR, Route119_Text_TaylorIntro, Route119_Text_TaylorDefeat
 * msgbox Route119_Text_TaylorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Taylor : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TAYLOR
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.TaylorPostBattle)
    }
    ctx.say(Route119.TaylorIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.TaylorDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DONALD, Route119_Text_DonaldIntro, Route119_Text_DonaldDefeat
 * msgbox Route119_Text_DonaldPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Donald : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DONALD
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.DonaldPostBattle)
    }
    ctx.say(Route119.DonaldIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.DonaldDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JACKSON_1, Route119_Text_JacksonIntro, Route119_Text_JacksonDefeat, Route119_EventScript_RegisterJackson
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route119_EventScript_RematchJackson
 * msgbox Route119_Text_JacksonPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route119_EventScript_Jackson : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route119_EventScript_Jackson")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BRENT, Route119_Text_BrentIntro, Route119_Text_BrentDefeat
 * msgbox Route119_Text_BrentPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Brent : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BRENT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.BrentPostBattle)
    }
    ctx.say(Route119.BrentIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.BrentDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_CATHERINE_1, Route119_Text_CatherineIntro, Route119_Text_CatherineDefeat, Route119_EventScript_RegisterCatherine
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route119_EventScript_RematchCatherine
 * msgbox Route119_Text_CatherinePostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route119_EventScript_Catherine : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route119_EventScript_Catherine")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DOUG, Route119_Text_DougIntro, Route119_Text_DougDefeat
 * msgbox Route119_Text_DougPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Doug : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DOUG
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.DougPostBattle)
    }
    ctx.say(Route119.DougIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.DougDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KENT, Route119_Text_KentIntro, Route119_Text_KentDefeat
 * msgbox Route119_Text_KentPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Kent : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KENT
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.KentPostBattle)
    }
    ctx.say(Route119.KentIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.KentDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YASU, Route119_Text_YasuIntro, Route119_Text_YasuDefeat
 * msgbox Route119_Text_YasuPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Yasu : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_YASU
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.YasuPostBattle)
    }
    ctx.say(Route119.YasuIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.YasuDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TAKASHI, Route119_Text_TakashiIntro, Route119_Text_TakashiDefeat
 * msgbox Route119_Text_TakashiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Takashi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_TAKASHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.TakashiPostBattle)
    }
    ctx.say(Route119.TakashiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.TakashiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HUGH, Route119_Text_HughIntro, Route119_Text_HughDefeat
 * msgbox Route119_Text_HughPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Hugh : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HUGH
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.HughPostBattle)
    }
    ctx.say(Route119.HughIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.HughDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PHIL, Route119_Text_PhilIntro, Route119_Text_PhilDefeat
 * msgbox Route119_Text_PhilPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Phil : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_PHIL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.PhilPostBattle)
    }
    ctx.say(Route119.PhilIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.PhilDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SUPER_REPEL
 * end
 * ```
 */
internal object Route119_EventScript_ItemSuperRepel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.SUPER_REPEL, HoennFlags.FLAG_ITEM_ROUTE_119_SUPER_REPEL, 16)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ZINC
 * end
 * ```
 */
internal object Route119_EventScript_ItemZinc : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ZINC, HoennFlags.FLAG_ITEM_ROUTE_119_ZINC, 17)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ELIXIR
 * end
 * ```
 */
internal object Route119_EventScript_ItemElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ELIXIR, HoennFlags.FLAG_ITEM_ROUTE_119_ELIXIR_1, 18)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_LEAF_STONE
 * end
 * ```
 */
internal object Route119_EventScript_ItemLeafStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.LEAF_STONE, HoennFlags.FLAG_ITEM_ROUTE_119_LEAF_STONE, 19)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_RARE_CANDY
 * end
 * ```
 */
internal object Route119_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.RARE_CANDY, HoennFlags.FLAG_ITEM_ROUTE_119_RARE_CANDY, 20)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HYPER_POTION
 * end
 * ```
 */
internal object Route119_EventScript_ItemHyperPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HYPER_POTION, HoennFlags.FLAG_ITEM_ROUTE_119_HYPER_POTION_1, 21)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox Route119_Text_StayAwayFromWeatherInstitute, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object Route119_EventScript_BridgeAquaGrunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route119.StayAwayFromWeatherInstitute)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox Route119_Text_DontGoNearWeatherInstitute, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object Route119_EventScript_BridgeAquaGrunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route119.DontGoNearWeatherInstitute)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

internal object Route119_EventScript_Boy1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route119.ThoughtFlyByCatchingBirdMons)
}

internal object Route119_EventScript_CyclingTriathleteM : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route119.TallGrassSnaresBikeTires)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HYPER_POTION
 * end
 * ```
 */
internal object Route119_EventScript_ItemHyperPotion2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HYPER_POTION, HoennFlags.FLAG_ITEM_ROUTE_119_HYPER_POTION_2, 31)
  }
}

internal object Route119_EventScript_Boy2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route119.CanYourMonMakeSecretBase)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIDEO, Route119_Text_HideoIntro, Route119_Text_HideoDefeat
 * msgbox Route119_Text_HideoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Hideo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_HIDEO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.HideoPostBattle)
    }
    ctx.say(Route119.HideoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.HideoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 6
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route119_EventScript_Kecleon1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 6)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8009, 7
 * goto EventScript_Kecleon
 * end
 * ```
 */
internal object Route119_EventScript_Kecleon2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8009, 7)
    return EventScript_Kecleon.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CHRIS, Route119_Text_ChrisIntro, Route119_Text_ChrisDefeat
 * msgbox Route119_Text_ChrisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Chris : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_CHRIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.ChrisPostBattle)
    }
    ctx.say(Route119.ChrisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.ChrisDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RACHEL, Route119_Text_RachelIntro, Route119_Text_RachelDefeat
 * msgbox Route119_Text_RachelPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Rachel : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_RACHEL
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.RachelPostBattle)
    }
    ctx.say(Route119.RachelIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.RachelDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DAYTON, Route119_Text_DaytonIntro, Route119_Text_DaytonDefeat
 * msgbox Route119_Text_DaytonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Dayton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DAYTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.DaytonPostBattle)
    }
    ctx.say(Route119.DaytonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.DaytonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FABIAN, Route119_Text_FabianIntro, Route119_Text_FabianDefeat
 * msgbox Route119_Text_FabianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_Fabian : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_FABIAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route119.FabianPostBattle)
    }
    ctx.say(Route119.FabianIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route119.FabianDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NUGGET
 * end
 * ```
 */
internal object Route119_EventScript_ItemNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NUGGET, HoennFlags.FLAG_ITEM_ROUTE_119_NUGGET, 40)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ELIXIR
 * end
 * ```
 */
internal object Route119_EventScript_ItemElixir2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ELIXIR, HoennFlags.FLAG_ITEM_ROUTE_119_ELIXIR_2, 41)
  }
}

internal object Route119_EventScript_WeatherInstituteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route119.WeatherInstitute)
}

internal object Route119_EventScript_RouteSignFortree : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route119.RouteSignFortree)
}

internal object Route119_EventScript_TrainerTipsDecoration : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route119.TrainerTipsDecoration)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_CATHERINE_1, Route119_Text_CatherineRematchIntro, Route119_Text_CatherineRematchDefeat
 * msgbox Route119_Text_CatherinePostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_RematchCatherine : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route119_EventScript_RematchCatherine")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_DEVON_SCOPE
 * goto_if_eq VAR_RESULT, TRUE, EventScript_AskUseDevonScope
 * msgbox Kecleon_Text_SomethingUnseeable, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EventScript_Kecleon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_Kecleon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_JACKSON_1, Route119_Text_JacksonRematchIntro, Route119_Text_JacksonRematchDefeat
 * msgbox Route119_Text_JacksonPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route119_EventScript_RematchJackson : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route119_EventScript_RematchJackson")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Kecleon_Text_WantToUseDevonScope, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, EventScript_BattleKecleon
 * release
 * end
 * ```
 */
internal object EventScript_AskUseDevonScope : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_AskUseDevonScope")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Kecleon_Text_UseDevonScopeMonAttacked, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FacePlayer
 * waitmovement 0
 * applymovement VAR_LAST_TALKED, Movement_KecleonAppears
 * waitmovement 0
 * waitse
 * playmoncry SPECIES_KECLEON, CRY_MODE_ENCOUNTER
 * delay 40
 * waitmoncry
 * setwildbattle SPECIES_KECLEON, 30
 * setflag FLAG_SYS_CTRL_OBJ_DELETE
 * dowildbattle
 * clearflag FLAG_SYS_CTRL_OBJ_DELETE
 * specialvar VAR_RESULT, GetBattleOutcome
 * goto_if_eq VAR_RESULT, B_OUTCOME_WON, EventScript_RemoveKecleon
 * goto_if_eq VAR_RESULT, B_OUTCOME_RAN, EventScript_RemoveKecleon
 * goto_if_eq VAR_RESULT, B_OUTCOME_PLAYER_TELEPORTED, EventScript_RemoveKecleon
 * release
 * end
 * ```
 */
internal object EventScript_BattleKecleon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_BattleKecleon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto Common_EventScript_RemoveStaticPokemon
 * end
 * ```
 */
internal object EventScript_RemoveKecleon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RemoveKecleon")
}

internal val Route119Scripts: Map<String, Script> =
    mapOf(
        "Route119_EventScript_Greg" to Route119_EventScript_Greg,
        "Route119_EventScript_Taylor" to Route119_EventScript_Taylor,
        "Route119_EventScript_Donald" to Route119_EventScript_Donald,
        "Route119_EventScript_Jackson" to Route119_EventScript_Jackson,
        "Route119_EventScript_Brent" to Route119_EventScript_Brent,
        "Route119_EventScript_Catherine" to Route119_EventScript_Catherine,
        "Route119_EventScript_Doug" to Route119_EventScript_Doug,
        "Route119_EventScript_Kent" to Route119_EventScript_Kent,
        "Route119_EventScript_Yasu" to Route119_EventScript_Yasu,
        "Route119_EventScript_Takashi" to Route119_EventScript_Takashi,
        "Route119_EventScript_Hugh" to Route119_EventScript_Hugh,
        "Route119_EventScript_Phil" to Route119_EventScript_Phil,
        "Route119_EventScript_ItemSuperRepel" to Route119_EventScript_ItemSuperRepel,
        "Route119_EventScript_ItemZinc" to Route119_EventScript_ItemZinc,
        "Route119_EventScript_ItemElixir" to Route119_EventScript_ItemElixir,
        "Route119_EventScript_ItemLeafStone" to Route119_EventScript_ItemLeafStone,
        "Route119_EventScript_ItemRareCandy" to Route119_EventScript_ItemRareCandy,
        "Route119_EventScript_ItemHyperPotion" to Route119_EventScript_ItemHyperPotion,
        "Route119_EventScript_BridgeAquaGrunt1" to Route119_EventScript_BridgeAquaGrunt1,
        "Route119_EventScript_BridgeAquaGrunt2" to Route119_EventScript_BridgeAquaGrunt2,
        "Route119_EventScript_Boy1" to Route119_EventScript_Boy1,
        "Route119_EventScript_CyclingTriathleteM" to Route119_EventScript_CyclingTriathleteM,
        "Route119_EventScript_ItemHyperPotion2" to Route119_EventScript_ItemHyperPotion2,
        "Route119_EventScript_Boy2" to Route119_EventScript_Boy2,
        "Route119_EventScript_Hideo" to Route119_EventScript_Hideo,
        "Route119_EventScript_Kecleon1" to Route119_EventScript_Kecleon1,
        "Route119_EventScript_Kecleon2" to Route119_EventScript_Kecleon2,
        "Route119_EventScript_Chris" to Route119_EventScript_Chris,
        "Route119_EventScript_Rachel" to Route119_EventScript_Rachel,
        "Route119_EventScript_Dayton" to Route119_EventScript_Dayton,
        "Route119_EventScript_Fabian" to Route119_EventScript_Fabian,
        "Route119_EventScript_ItemNugget" to Route119_EventScript_ItemNugget,
        "Route119_EventScript_ItemElixir2" to Route119_EventScript_ItemElixir2,
        "Route119_EventScript_WeatherInstituteSign" to Route119_EventScript_WeatherInstituteSign,
        "Route119_EventScript_RouteSignFortree" to Route119_EventScript_RouteSignFortree,
        "Route119_EventScript_TrainerTipsDecoration" to Route119_EventScript_TrainerTipsDecoration,
        "Route119_EventScript_RematchCatherine" to Route119_EventScript_RematchCatherine,
        "EventScript_Kecleon" to EventScript_Kecleon,
        "Route119_EventScript_RematchJackson" to Route119_EventScript_RematchJackson,
        "EventScript_AskUseDevonScope" to EventScript_AskUseDevonScope,
        "EventScript_BattleKecleon" to EventScript_BattleKecleon,
        "EventScript_RemoveKecleon" to EventScript_RemoveKecleon,
    )
