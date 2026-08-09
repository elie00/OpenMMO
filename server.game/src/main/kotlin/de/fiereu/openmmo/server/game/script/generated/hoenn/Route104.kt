package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route104
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object Route104_EventScript_BugCatcher : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route104.WhatsItLikeAtBottomOfSea)
}

internal object Route104_EventScript_Girl1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route104.BrineyLivesInSeasideCottage)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_HALEY_1, Route104_Text_HaleyIntro, Route104_Text_HaleyDefeat, Route104_EventScript_TryRegisterHaleyAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route104_EventScript_RematchHaley
 * setvar VAR_0x8004, TRAINER_HALEY_1
 * specialvar VAR_RESULT, IsTrainerRegistered
 * goto_if_eq VAR_RESULT, FALSE, Route104_EventScript_TryRegisterHaley
 * msgbox Route104_Text_HaleyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_Haley : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Haley")
}

internal object Route104_EventScript_Boy1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route104.ThrowBallAtWeakenedPokemon)
}

internal object Route104_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route104.OnlyThrowBallAtWildPokemon)
}

internal object Route104_EventScript_Girl2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route104.ImNotATrainer)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_IVAN, Route104_Text_IvanIntro, Route104_Text_IvanDefeat
 * msgbox Route104_Text_IvanPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route104_EventScript_Ivan : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_IVAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route104.IvanPostBattle)
    }
    ctx.say(Route104.IvanIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route104.IvanDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_CHESTO_BERRY_ROUTE_104, Route104_EventScript_ReceivedBerry
 * msgbox Route104_Text_PlantBerriesInSoilTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_CHESTO_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_CHESTO_BERRY_ROUTE_104
 * msgbox Route104_Text_TrainersOftenMakeMonHoldBerries, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_ExpertF : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_ExpertF")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object Route104_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, HoennFlags.FLAG_ITEM_ROUTE_104_PP_UP, 20)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_WHITE_HERB, Route104_EventScript_ReceivedWhiteHerb
 * msgbox Route104_Text_DontNeedThisTakeIt, MSGBOX_DEFAULT
 * giveitem ITEM_WHITE_HERB
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_WHITE_HERB
 * release
 * end
 * ```
 */
internal object Route104_EventScript_WhiteHerbFlorist : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_WhiteHerbFlorist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_GINA_AND_MIA_1, Route104_Text_GinaIntro, Route104_Text_GinaDefeat, Route104_Text_GinaNotEnoughMons
 * special GetPlayerBigGuyGirlString
 * msgbox Route104_Text_GinaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_Gina : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Gina")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_GINA_AND_MIA_1, Route104_Text_MiaIntro, Route104_Text_MiaDefeat, Route104_Text_MiaNotEnoughMons
 * special GetPlayerBigGuyGirlString
 * msgbox Route104_Text_MiaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_Mia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Mia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_WINSTON_1, Route104_Text_WinstonIntro, Route104_Text_WinstonDefeat, Route104_EventScript_TryRegisterWinstonAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route104_EventScript_RematchWinston
 * setvar VAR_0x8004, TRAINER_WINSTON_1
 * specialvar VAR_RESULT, IsTrainerRegistered
 * goto_if_eq VAR_RESULT, FALSE, Route104_EventScript_TryRegisterWinston
 * msgbox Route104_Text_WinstonPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_Winston : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Winston")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_CINDY_1, Route104_Text_CindyIntro, Route104_Text_CindyDefeat, Route104_EventScript_TryRegisterCindyAfterBattle
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route104_EventScript_RematchCindy
 * setvar VAR_0x8004, TRAINER_CINDY_1
 * specialvar VAR_RESULT, IsTrainerRegistered
 * goto_if_eq VAR_RESULT, FALSE, Route104_EventScript_TryRegisterCindy
 * msgbox Route104_Text_CindyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_Cindy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Cindy")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_POKE_BALL
 * end
 * ```
 */
internal object Route104_EventScript_ItemPokeBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.POKE_BALL, HoennFlags.FLAG_ITEM_ROUTE_104_POKE_BALL, 26)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BILLY, Route104_Text_BillyIntro, Route104_Text_BillyDefeat
 * msgbox Route104_Text_BillyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route104_EventScript_Billy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BILLY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route104.BillyPostBattle)
    }
    ctx.say(Route104.BillyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route104.BillyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_X_ACCURACY
 * end
 * ```
 */
internal object Route104_EventScript_ItemXAccuracy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.X_ACCURACY, HoennFlags.FLAG_ITEM_ROUTE_104_X_ACCURACY, 28)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_POTION
 * end
 * ```
 */
internal object Route104_EventScript_ItemPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.POTION, HoennFlags.FLAG_ITEM_ROUTE_104_POTION, 30)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_TM_BULLET_SEED, Route104_EventScript_ReceivedBulletSeed
 * msgbox Route104_Text_LikeFillingMouthWithSeedsTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_TM_BULLET_SEED
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_TM_BULLET_SEED
 * release
 * end
 * ```
 */
internal object Route104_EventScript_Boy2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Boy2")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DARIAN, Route104_Text_DarianIntro, Route104_Text_DarianDefeat
 * msgbox Route104_Text_DarianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route104_EventScript_Darian : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DARIAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route104.DarianPostBattle)
    }
    ctx.say(Route104.DarianIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route104.DarianDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8008, 1
 * applymovement LOCALID_ROUTE104_RIVAL, Common_Movement_FacePlayer
 * waitmovement 0
 * goto Route104_EventScript_RivalEncounter
 * ```
 */
internal object Route104_EventScript_Rival : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_Rival")
}

internal object Route104_EventScript_BrineysCottageSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route104.MrBrineysCottage)
}

internal object Route104_EventScript_RouteSignPetalburg : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route104.RouteSignPetalburg)
}

internal object Route104_EventScript_RouteSignRustboro : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route104.RouteSignRustboro)
}

internal object Route104_EventScript_FlowerShopSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route104.PrettyPetalFlowShop)
}

internal object Route104_EventScript_TrainerTipsDoubleBattles : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route104.TrainerTipsDoubleBattles)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_WINSTON_1, Route104_Text_WinstonRematchIntro, Route104_Text_WinstonRematchDefeat
 * msgbox Route104_Text_WinstonPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route104_EventScript_RematchWinston : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RematchWinston")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route104_Text_TMsAreOneTimeUse, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_ReceivedBulletSeed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route104.TMsAreOneTimeUse)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_CINDY_1, Route104_Text_CindyRematchIntro, Route104_Text_CindyRematchDefeat
 * msgbox Route104_Text_CindyPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route104_EventScript_RematchCindy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RematchCindy")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route104_Text_FlowerShopSellingSaplings, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_ReceivedWhiteHerb : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route104.FlowerShopSellingSaplings)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * goto_if_eq VAR_RESULT, MALE, Route104_EventScript_MayEncounter
 * goto_if_eq VAR_RESULT, FEMALE, Route104_EventScript_BrendanEncounter
 * end
 * ```
 */
internal object Route104_EventScript_RivalEncounter : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RivalEncounter")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_HAS_MATCH_CALL, Route104_EventScript_RegisterCindy
 * msgbox Route104_Text_CindyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_TryRegisterCindy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_HAS_MATCH_CALL))
        return Route104_EventScript_RegisterCindy.run(ctx)
    ctx.say(Route104.CindyPostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_HAS_MATCH_CALL, Route104_EventScript_RegisterWinston
 * msgbox Route104_Text_WinstonPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_TryRegisterWinston : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_HAS_MATCH_CALL))
        return Route104_EventScript_RegisterWinston.run(ctx)
    ctx.say(Route104.WinstonPostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_HAS_MATCH_CALL, Route104_EventScript_RegisterHaley
 * msgbox Route104_Text_HaleyPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_TryRegisterHaley : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_HAS_MATCH_CALL))
        return Route104_EventScript_RegisterHaley.run(ctx)
    ctx.say(Route104.HaleyPostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route104_Text_TrainersOftenMakeMonHoldBerries, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route104_EventScript_ReceivedBerry : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route104.TrainersOftenMakeMonHoldBerries)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_HALEY_1, Route104_Text_HaleyRematchIntro, Route104_Text_HaleyRematchDefeat
 * msgbox Route104_Text_HaleyPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route104_EventScript_RematchHaley : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RematchHaley")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_CindyRegister1, MSGBOX_DEFAULT
 * register_matchcall TRAINER_CINDY_1
 * release
 * end
 * ```
 */
internal object Route104_EventScript_RegisterCindy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RegisterCindy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_DEFEATED_RIVAL_ROUTE_104, Route104_EventScript_BrendanDefeated
 * goto_if_set FLAG_REGISTER_RIVAL_POKENAV, Route104_EventScript_BrendanAskToBattle
 * setflag FLAG_REGISTER_RIVAL_POKENAV
 * msgbox Route104_Text_BrendanWeShouldRegister, MSGBOX_DEFAULT
 * closemessage
 * delay 30
 * playfanfare MUS_REGISTER_MATCH_CALL
 * msgbox Route104_Text_RegisteredBrendan, MSGBOX_DEFAULT
 * waitfanfare
 * closemessage
 * delay 30
 * setflag FLAG_ENABLE_RIVAL_MATCH_CALL
 * applymovement LOCALID_PLAYER, Route104_Movement_PlayerFaceRival
 * applymovement LOCALID_ROUTE104_RIVAL, Route104_Movement_RivalWalkSlowLeft
 * msgbox Route104_Text_BrendanHowsYourPokedex, MSGBOX_DEFAULT
 * closemessage
 * waitmovement 0
 * applymovement LOCALID_ROUTE104_RIVAL, Route104_Movement_RivalApproachPlayer
 * waitmovement 0
 * copyobjectxytoperm LOCALID_ROUTE104_RIVAL
 * msgbox Route104_Text_BrendanDoingGreatLetsBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route104_EventScript_BattleBrendan
 * msgbox Route104_Text_BrendanNoConfidence, MSGBOX_DEFAULT
 * call Route104_EventScript_RestoreMusic
 * releaseall
 * end
 * ```
 */
internal object Route104_EventScript_BrendanEncounter : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_BrendanEncounter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_HaleyRegister1, MSGBOX_DEFAULT
 * register_matchcall TRAINER_HALEY_1
 * release
 * end
 * ```
 */
internal object Route104_EventScript_RegisterHaley : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RegisterHaley")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_DEFEATED_RIVAL_ROUTE_104, Route104_EventScript_MayDefeated
 * goto_if_set FLAG_REGISTER_RIVAL_POKENAV, Route104_EventScript_MayAskToBattle
 * setflag FLAG_REGISTER_RIVAL_POKENAV
 * msgbox Route104_Text_MayWeShouldRegister, MSGBOX_DEFAULT
 * closemessage
 * delay 30
 * playfanfare MUS_REGISTER_MATCH_CALL
 * msgbox Route104_Text_RegisteredMay, MSGBOX_DEFAULT
 * waitfanfare
 * closemessage
 * delay 30
 * setflag FLAG_ENABLE_RIVAL_MATCH_CALL
 * applymovement LOCALID_PLAYER, Route104_Movement_PlayerFaceRival
 * applymovement LOCALID_ROUTE104_RIVAL, Route104_Movement_RivalWalkSlowLeft
 * msgbox Route104_Text_MayHowsYourPokedex, MSGBOX_DEFAULT
 * closemessage
 * waitmovement 0
 * applymovement LOCALID_ROUTE104_RIVAL, Route104_Movement_RivalApproachPlayer
 * waitmovement 0
 * copyobjectxytoperm LOCALID_ROUTE104_RIVAL
 * msgbox Route104_Text_MayMinesDecentLetsBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route104_EventScript_BattleMay
 * msgbox Route104_Text_MayHaventRaisedPokemon, MSGBOX_DEFAULT
 * call Route104_EventScript_RestoreMusic
 * releaseall
 * end
 * ```
 */
internal object Route104_EventScript_MayEncounter : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_MayEncounter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_WinstonRegister1, MSGBOX_DEFAULT
 * register_matchcall TRAINER_WINSTON_1
 * release
 * end
 * ```
 */
internal object Route104_EventScript_RegisterWinston : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RegisterWinston")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_BrendanIntro, MSGBOX_DEFAULT
 * switch VAR_STARTER_MON
 * case 0, Route104_EventScript_BattleBrendanTreecko
 * case 1, Route104_EventScript_BattleBrendanTorchic
 * case 2, Route104_EventScript_BattleBrendanMudkip
 * end
 * ```
 */
internal object Route104_EventScript_BattleBrendan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_BattleBrendan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_MayIntro, MSGBOX_DEFAULT
 * switch VAR_STARTER_MON
 * case 0, Route104_EventScript_BattleMayTreecko
 * case 1, Route104_EventScript_BattleMayTorchic
 * case 2, Route104_EventScript_BattleMayMudkip
 * end
 * ```
 */
internal object Route104_EventScript_BattleMay : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_BattleMay")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_BrendanPostBattle, MSGBOX_DEFAULT
 * call_if_eq VAR_0x8008, 0, Route104_EventScript_RestoreMusic
 * releaseall
 * end
 * ```
 */
internal object Route104_EventScript_BrendanDefeated : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_BrendanDefeated")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_BrendanLetsBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route104_EventScript_BattleBrendan
 * msgbox Route104_Text_BrendanNoConfidence, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object Route104_EventScript_BrendanAskToBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route104_EventScript_BrendanAskToBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * savebgm MUS_DUMMY
 * fadedefaultbgm
 * return
 * ```
 */
internal object Route104_EventScript_RestoreMusic : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_RestoreMusic")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_MayPostBattle, MSGBOX_DEFAULT
 * call_if_eq VAR_0x8008, 0, Route104_EventScript_RestoreMusic
 * releaseall
 * end
 * ```
 */
internal object Route104_EventScript_MayDefeated : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_MayDefeated")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route104_Text_MayLetsBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route104_EventScript_BattleMay
 * msgbox Route104_Text_MayHaventRaisedPokemon, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object Route104_EventScript_MayAskToBattle : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route104_EventScript_MayAskToBattle")
}

internal val Route104Scripts: Map<String, Script> =
    mapOf(
        "Route104_EventScript_BugCatcher" to Route104_EventScript_BugCatcher,
        "Route104_EventScript_Girl1" to Route104_EventScript_Girl1,
        "Route104_EventScript_Haley" to Route104_EventScript_Haley,
        "Route104_EventScript_Boy1" to Route104_EventScript_Boy1,
        "Route104_EventScript_Woman" to Route104_EventScript_Woman,
        "Route104_EventScript_Girl2" to Route104_EventScript_Girl2,
        "Route104_EventScript_Ivan" to Route104_EventScript_Ivan,
        "Route104_EventScript_ExpertF" to Route104_EventScript_ExpertF,
        "Route104_EventScript_ItemPPUp" to Route104_EventScript_ItemPPUp,
        "Route104_EventScript_WhiteHerbFlorist" to Route104_EventScript_WhiteHerbFlorist,
        "Route104_EventScript_Gina" to Route104_EventScript_Gina,
        "Route104_EventScript_Mia" to Route104_EventScript_Mia,
        "Route104_EventScript_Winston" to Route104_EventScript_Winston,
        "Route104_EventScript_Cindy" to Route104_EventScript_Cindy,
        "Route104_EventScript_ItemPokeBall" to Route104_EventScript_ItemPokeBall,
        "Route104_EventScript_Billy" to Route104_EventScript_Billy,
        "Route104_EventScript_ItemXAccuracy" to Route104_EventScript_ItemXAccuracy,
        "Route104_EventScript_ItemPotion" to Route104_EventScript_ItemPotion,
        "Route104_EventScript_Boy2" to Route104_EventScript_Boy2,
        "Route104_EventScript_Darian" to Route104_EventScript_Darian,
        "Route104_EventScript_Rival" to Route104_EventScript_Rival,
        "Route104_EventScript_BrineysCottageSign" to Route104_EventScript_BrineysCottageSign,
        "Route104_EventScript_RouteSignPetalburg" to Route104_EventScript_RouteSignPetalburg,
        "Route104_EventScript_RouteSignRustboro" to Route104_EventScript_RouteSignRustboro,
        "Route104_EventScript_FlowerShopSign" to Route104_EventScript_FlowerShopSign,
        "Route104_EventScript_TrainerTipsDoubleBattles" to
            Route104_EventScript_TrainerTipsDoubleBattles,
        "Route104_EventScript_RematchWinston" to Route104_EventScript_RematchWinston,
        "Route104_EventScript_ReceivedBulletSeed" to Route104_EventScript_ReceivedBulletSeed,
        "Route104_EventScript_RematchCindy" to Route104_EventScript_RematchCindy,
        "Route104_EventScript_ReceivedWhiteHerb" to Route104_EventScript_ReceivedWhiteHerb,
        "Route104_EventScript_RivalEncounter" to Route104_EventScript_RivalEncounter,
        "Route104_EventScript_TryRegisterCindy" to Route104_EventScript_TryRegisterCindy,
        "Route104_EventScript_TryRegisterWinston" to Route104_EventScript_TryRegisterWinston,
        "Route104_EventScript_TryRegisterHaley" to Route104_EventScript_TryRegisterHaley,
        "Route104_EventScript_ReceivedBerry" to Route104_EventScript_ReceivedBerry,
        "Route104_EventScript_RematchHaley" to Route104_EventScript_RematchHaley,
        "Route104_EventScript_RegisterCindy" to Route104_EventScript_RegisterCindy,
        "Route104_EventScript_BrendanEncounter" to Route104_EventScript_BrendanEncounter,
        "Route104_EventScript_RegisterHaley" to Route104_EventScript_RegisterHaley,
        "Route104_EventScript_MayEncounter" to Route104_EventScript_MayEncounter,
        "Route104_EventScript_RegisterWinston" to Route104_EventScript_RegisterWinston,
        "Route104_EventScript_BattleBrendan" to Route104_EventScript_BattleBrendan,
        "Route104_EventScript_BattleMay" to Route104_EventScript_BattleMay,
        "Route104_EventScript_BrendanDefeated" to Route104_EventScript_BrendanDefeated,
        "Route104_EventScript_BrendanAskToBattle" to Route104_EventScript_BrendanAskToBattle,
        "Route104_EventScript_RestoreMusic" to Route104_EventScript_RestoreMusic,
        "Route104_EventScript_MayDefeated" to Route104_EventScript_MayDefeated,
        "Route104_EventScript_MayAskToBattle" to Route104_EventScript_MayAskToBattle,
    )
