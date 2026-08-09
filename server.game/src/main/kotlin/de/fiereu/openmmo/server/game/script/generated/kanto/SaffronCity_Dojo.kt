package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_Dojo
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_HITOSHI, SaffronCity_Dojo_Text_HitoshiIntro, SaffronCity_Dojo_Text_HitoshiDefeat
 * msgbox SaffronCity_Dojo_Text_HitoshiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_Hitoshi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_HITOSHI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SaffronCity_Dojo.HitoshiPostBattle)
    }
    ctx.say(SaffronCity_Dojo.HitoshiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SaffronCity_Dojo.HitoshiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_HIDEKI, SaffronCity_Dojo_Text_HidekiIntro, SaffronCity_Dojo_Text_HidekiDefeat
 * msgbox SaffronCity_Dojo_Text_HidekiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_Hideki : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_HIDEKI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SaffronCity_Dojo.HidekiPostBattle)
    }
    ctx.say(SaffronCity_Dojo.HidekiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SaffronCity_Dojo.HidekiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_AARON, SaffronCity_Dojo_Text_AaronIntro, SaffronCity_Dojo_Text_AaronDefeat
 * msgbox SaffronCity_Dojo_Text_AaronPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_Aaron : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_AARON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SaffronCity_Dojo.AaronPostBattle)
    }
    ctx.say(SaffronCity_Dojo.AaronIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SaffronCity_Dojo.AaronDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_MIKE, SaffronCity_Dojo_Text_MikeIntro, SaffronCity_Dojo_Text_MikeDefeat
 * msgbox SaffronCity_Dojo_Text_MikePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_Mike : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_MIKE
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SaffronCity_Dojo.MikePostBattle)
    }
    ctx.say(SaffronCity_Dojo.MikeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SaffronCity_Dojo.MikeDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_KOICHI, SaffronCity_Dojo_Text_MasterKoichiIntro, SaffronCity_Dojo_Text_MasterKoichiDefeat, SaffronCity_Dojo_EventScript_DefeatedMasterKoichi
 * goto_if_set FLAG_GOT_HITMON_FROM_DOJO, SaffronCity_Dojo_EventScript_MasterKoichiAlreadyGotHitmon
 * msgbox SaffronCity_Dojo_Text_ChoosePrizedFightingMon, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_MasterKoichi : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_MasterKoichi")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_HITMON_FROM_DOJO, SaffronCity_Dojo_EventScript_AlreadyGotHitmon
 * showmonpic SPECIES_HITMONLEE, 10, 3
 * setvar VAR_TEMP_1, SPECIES_HITMONLEE
 * applymovement LOCALID_KARATE_MASTER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox SaffronCity_Dojo_Text_YouWantHitmonlee, MSGBOX_YESNO
 * call EventScript_RestorePrevTextColor
 * goto_if_eq VAR_RESULT, YES, SaffronCity_Dojo_EventScript_GiveHitmon
 * hidemonpic
 * release
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_HitmonleeBall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_HitmonleeBall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_HITMON_FROM_DOJO, SaffronCity_Dojo_EventScript_AlreadyGotHitmon
 * showmonpic SPECIES_HITMONCHAN, 10, 3
 * setvar VAR_TEMP_1, SPECIES_HITMONCHAN
 * applymovement LOCALID_KARATE_MASTER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox SaffronCity_Dojo_Text_YouWantHitmonchan, MSGBOX_YESNO
 * call EventScript_RestorePrevTextColor
 * goto_if_eq VAR_RESULT, YES, SaffronCity_Dojo_EventScript_GiveHitmon
 * hidemonpic
 * release
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_HitmonchanBall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_HitmonchanBall")
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

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_Dojo_Text_StayAndTrainWithUs
 * release
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_MasterKoichiAlreadyGotHitmon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_Dojo.StayAndTrainWithUs)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_Dojo_Text_BetterNotGetGreedy
 * release
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_AlreadyGotHitmon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_Dojo.BetterNotGetGreedy)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemonpic
 * givemon VAR_TEMP_1, 25
 * goto_if_eq VAR_RESULT, 0, SaffronCity_Dojo_EventScript_ReceivedHitmonParty
 * goto_if_eq VAR_RESULT, 1, SaffronCity_Dojo_EventScript_ReceivedHitmonPC
 * goto_if_eq VAR_RESULT, 2, EventScript_NoMoreRoomForPokemon
 * release
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_GiveHitmon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_GiveHitmon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removeobject VAR_LAST_TALKED
 * bufferspeciesname STR_VAR_1, VAR_TEMP_1
 * playfanfare MUS_LEVEL_UP
 * message SaffronCity_Dojo_Text_ReceivedMonFromKarateMaster
 * waitmessage
 * waitfanfare
 * setflag FLAG_GOT_HITMON_FROM_DOJO
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SaffronCity_Dojo_EventScript_TransferredHitmonToPC
 * call EventScript_NameReceivedBoxMon
 * goto SaffronCity_Dojo_EventScript_TransferredHitmonToPC
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_ReceivedHitmonPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_ReceivedHitmonPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * removeobject VAR_LAST_TALKED
 * bufferspeciesname STR_VAR_1, VAR_TEMP_1
 * playfanfare MUS_LEVEL_UP
 * message SaffronCity_Dojo_Text_ReceivedMonFromKarateMaster
 * waitmessage
 * waitfanfare
 * setflag FLAG_GOT_HITMON_FROM_DOJO
 * msgbox Text_GiveNicknameToThisMon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SaffronCity_Dojo_EventScript_EndGiveMon
 * call EventScript_GetGiftMonPartySlot
 * call EventScript_ChangePokemonNickname
 * goto SaffronCity_Dojo_EventScript_EndGiveMon
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_ReceivedHitmonParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_ReceivedHitmonParty")
}

/**
 * Ported from the decomp:
 * ```
 * call EventScript_TransferredToPC
 * goto SaffronCity_Dojo_EventScript_EndGiveMon
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_TransferredHitmonToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_TransferredToPC.run(ctx)
    return SaffronCity_Dojo_EventScript_EndGiveMon.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object SaffronCity_Dojo_EventScript_EndGiveMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_Dojo_EventScript_EndGiveMon")
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
        "SaffronCity_Dojo_EventScript_MasterKoichiAlreadyGotHitmon" to
            SaffronCity_Dojo_EventScript_MasterKoichiAlreadyGotHitmon,
        "SaffronCity_Dojo_EventScript_AlreadyGotHitmon" to
            SaffronCity_Dojo_EventScript_AlreadyGotHitmon,
        "SaffronCity_Dojo_EventScript_GiveHitmon" to SaffronCity_Dojo_EventScript_GiveHitmon,
        "SaffronCity_Dojo_EventScript_ReceivedHitmonPC" to
            SaffronCity_Dojo_EventScript_ReceivedHitmonPC,
        "SaffronCity_Dojo_EventScript_ReceivedHitmonParty" to
            SaffronCity_Dojo_EventScript_ReceivedHitmonParty,
        "SaffronCity_Dojo_EventScript_TransferredHitmonToPC" to
            SaffronCity_Dojo_EventScript_TransferredHitmonToPC,
        "SaffronCity_Dojo_EventScript_EndGiveMon" to SaffronCity_Dojo_EventScript_EndGiveMon,
    )
