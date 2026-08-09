package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route117
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object Route117_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route117.ArentTheseFlowersPretty)
}

internal object Route117_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route117.AirIsTastyHere)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * special GetDaycareMonNicknames
 * specialvar VAR_RESULT, GetDaycareState
 * goto_if_eq VAR_RESULT, DAYCARE_EGG_WAITING, Route117_EventScript_DaycareEggWaiting
 * goto_if_eq VAR_RESULT, DAYCARE_ONE_MON, Route117_EventScript_CheckOnOneMon
 * goto_if_eq VAR_RESULT, DAYCARE_TWO_MONS, Route117_EventScript_CheckOnTwoMons
 * msgbox Route117_Text_SeeWifeIfYoudLikeMeToRaiseMon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_DaycareMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_DaycareMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_DYLAN_1, Route117_Text_DylanIntro, Route117_Text_DylanDefeat, Route117_EventScript_RegisterDylan
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route117_EventScript_RematchDylan
 * msgbox Route117_Text_DylanPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_Dylan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_Dylan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_LYDIA_1, Route117_Text_LydiaIntro, Route117_Text_LydiaDefeat, Route117_EventScript_RegisterLydia
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route117_EventScript_RematchLydia
 * msgbox Route117_Text_LydiaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_Lydia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_Lydia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_ISAAC_1, Route117_Text_IsaacIntro, Route117_Text_IsaacDefeat, Route117_EventScript_RegisterIsaac
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route117_EventScript_RematchIsaac
 * msgbox Route117_Text_IsaacPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_Isaac : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_Isaac")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_GREAT_BALL
 * end
 * ```
 */
internal object Route117_EventScript_ItemGreatBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.GREAT_BALL, HoennFlags.FLAG_ITEM_ROUTE_117_GREAT_BALL, 13)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVE
 * end
 * ```
 */
internal object Route117_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVE, HoennFlags.FLAG_ITEM_ROUTE_117_REVIVE, 15)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_MARIA_1, Route117_Text_MariaIntro, Route117_Text_MariaDefeat, Route117_EventScript_RegisterMaria
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route117_EventScript_RematchMaria
 * msgbox Route117_Text_MariaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_Maria : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_Maria")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DEREK, Route117_Text_DerekIntro, Route117_Text_DerekDefeat
 * msgbox Route117_Text_DerekPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_Derek : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DEREK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route117.DerekPostBattle)
    }
    ctx.say(Route117.DerekIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route117.DerekDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_ANNA_AND_MEG_1, Route117_Text_MegIntro, Route117_Text_MegDefeat, Route117_Text_MegNotEnoughMons, Route117_EventScript_RegisterMeg
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route117_EventScript_RematchMeg
 * msgbox Route117_Text_MegPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_Meg : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_Meg")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_ANNA_AND_MEG_1, Route117_Text_AnnaIntro, Route117_Text_AnnaDefeat, Route117_Text_AnnaNotEnoughMons, Route117_EventScript_RegisterAnna
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route117_EventScript_RematchAnna
 * msgbox Route117_Text_AnnaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_Anna : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_Anna")
}

internal object Route117_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route117.DayCarePokemonHadNewMove)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BRANDI, Route117_Text_BrandiIntro, Route117_Text_BrandiDefeat
 * msgbox Route117_Text_BrandiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_Brandi : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BRANDI
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route117.BrandiPostBattle)
    }
    ctx.say(Route117.BrandiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route117.BrandiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AISHA, Route117_Text_AishaIntro, Route117_Text_AishaDefeat
 * msgbox Route117_Text_AishaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_Aisha : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_AISHA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route117.AishaPostBattle)
    }
    ctx.say(Route117.AishaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route117.AishaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_MELINA, Route117_Text_MelinaIntro, Route117_Text_MelinaDefeat
 * msgbox Route117_Text_MelinaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_Melina : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_MELINA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route117.MelinaPostBattle)
    }
    ctx.say(Route117.MelinaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route117.MelinaDefeat)
  }
}

internal object Route117_EventScript_RouteSignVerdanturf : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route117.RouteSignVerdanturf)
}

internal object Route117_EventScript_RouteSignMauville : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route117.RouteSignMauville)
}

internal object Route117_EventScript_DayCareSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route117.DayCareSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetDaycareMonNicknames
 * msgbox Route117_Text_YourMonIsDoingFine, MSGBOX_DEFAULT
 * setvar VAR_0x8004, 0
 * call Route117_EventScript_CheckMonReceivedMail
 * release
 * end
 * ```
 */
internal object Route117_EventScript_CheckOnOneMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_CheckOnOneMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetDaycareMonNicknames
 * msgbox Route117_Text_YourMonsAreDoingFine, MSGBOX_DEFAULT
 * special SetDaycareCompatibilityString
 * special ShowFieldMessageStringVar4
 * waitmessage
 * waitbuttonpress
 * setvar VAR_0x8004, 0
 * call Route117_EventScript_CheckMonReceivedMail
 * setvar VAR_0x8004, 1
 * call Route117_EventScript_CheckMonReceivedMail
 * release
 * end
 * ```
 */
internal object Route117_EventScript_CheckOnTwoMons : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_CheckOnTwoMons")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_DYLAN_1, Route117_Text_DylanRematchIntro, Route117_Text_DylanRematchDefeat
 * msgbox Route117_Text_DylanPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_RematchDylan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_RematchDylan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_ISAAC_1, Route117_Text_IsaacRematchIntro, Route117_Text_IsaacRematchDefeat
 * msgbox Route117_Text_IsaacPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_RematchIsaac : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_RematchIsaac")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_ANNA_AND_MEG_1, Route117_Text_AnnaRematchIntro, Route117_Text_AnnaRematchDefeat, Route117_Text_AnnaRematchNotEnoughMons
 * msgbox Route117_Text_AnnaPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_RematchAnna : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_RematchAnna")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_LYDIA_1, Route117_Text_LydiaRematchIntro, Route117_Text_LydiaRematchDefeat
 * msgbox Route117_Text_LydiaPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_RematchLydia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_RematchLydia")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_ANNA_AND_MEG_1, Route117_Text_MegRematchIntro, Route117_Text_MegRematchDefeat, Route117_Text_MegRematchNotEnoughMons
 * msgbox Route117_Text_MegPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_RematchMeg : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_RematchMeg")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route117_Text_DoYouWantEgg, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_EventScript_DaycareAcceptEgg
 * msgbox Route117_Text_IWillKeepDoYouWantIt, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route117_EventScript_DaycareAcceptEgg
 * msgbox Route117_Text_IllKeepIt, MSGBOX_DEFAULT
 * clearflag FLAG_PENDING_DAYCARE_EGG
 * special RejectEggFromDayCare
 * release
 * end
 * ```
 */
internal object Route117_EventScript_DaycareEggWaiting : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_DaycareEggWaiting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_MARIA_1, Route117_Text_MariaRematchIntro, Route117_Text_MariaRematchDefeat
 * msgbox Route117_Text_MariaPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route117_EventScript_RematchMaria : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_RematchMaria")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CalculatePlayerPartyCount
 * goto_if_ne VAR_RESULT, PARTY_SIZE, Route117_EventScript_DaycareReceiveEgg
 * msgbox Route117_Text_YouHaveNoRoomForIt, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route117_EventScript_DaycareAcceptEgg : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_DaycareAcceptEgg")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, CheckDaycareMonReceivedMail
 * call_if_eq VAR_RESULT, 1, Route117_EventScript_MonReceivedMail
 * return
 * ```
 */
internal object Route117_EventScript_CheckMonReceivedMail : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route117_EventScript_CheckMonReceivedMail")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message Route117_Text_ReceivedEgg
 * playfanfare MUS_LEVEL_UP
 * waitfanfare
 * waitbuttonpress
 * msgbox Route117_Text_TakeGoodCareOfIt, MSGBOX_DEFAULT
 * special GiveEggFromDaycare
 * clearflag FLAG_PENDING_DAYCARE_EGG
 * release
 * end
 * ```
 */
internal object Route117_EventScript_DaycareReceiveEgg : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route117_EventScript_DaycareReceiveEgg")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route117_Text_FriendlyWithOtherTrainersMon, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object Route117_EventScript_MonReceivedMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route117.FriendlyWithOtherTrainersMon)
  }
}

internal val Route117Scripts: Map<String, Script> =
    mapOf(
        "Route117_EventScript_Woman" to Route117_EventScript_Woman,
        "Route117_EventScript_LittleBoy" to Route117_EventScript_LittleBoy,
        "Route117_EventScript_DaycareMan" to Route117_EventScript_DaycareMan,
        "Route117_EventScript_Dylan" to Route117_EventScript_Dylan,
        "Route117_EventScript_Lydia" to Route117_EventScript_Lydia,
        "Route117_EventScript_Isaac" to Route117_EventScript_Isaac,
        "Route117_EventScript_ItemGreatBall" to Route117_EventScript_ItemGreatBall,
        "Route117_EventScript_ItemRevive" to Route117_EventScript_ItemRevive,
        "Route117_EventScript_Maria" to Route117_EventScript_Maria,
        "Route117_EventScript_Derek" to Route117_EventScript_Derek,
        "Route117_EventScript_Meg" to Route117_EventScript_Meg,
        "Route117_EventScript_Anna" to Route117_EventScript_Anna,
        "Route117_EventScript_Girl" to Route117_EventScript_Girl,
        "Route117_EventScript_Brandi" to Route117_EventScript_Brandi,
        "Route117_EventScript_Aisha" to Route117_EventScript_Aisha,
        "Route117_EventScript_Melina" to Route117_EventScript_Melina,
        "Route117_EventScript_RouteSignVerdanturf" to Route117_EventScript_RouteSignVerdanturf,
        "Route117_EventScript_RouteSignMauville" to Route117_EventScript_RouteSignMauville,
        "Route117_EventScript_DayCareSign" to Route117_EventScript_DayCareSign,
        "Route117_EventScript_CheckOnOneMon" to Route117_EventScript_CheckOnOneMon,
        "Route117_EventScript_CheckOnTwoMons" to Route117_EventScript_CheckOnTwoMons,
        "Route117_EventScript_RematchDylan" to Route117_EventScript_RematchDylan,
        "Route117_EventScript_RematchIsaac" to Route117_EventScript_RematchIsaac,
        "Route117_EventScript_RematchAnna" to Route117_EventScript_RematchAnna,
        "Route117_EventScript_RematchLydia" to Route117_EventScript_RematchLydia,
        "Route117_EventScript_RematchMeg" to Route117_EventScript_RematchMeg,
        "Route117_EventScript_DaycareEggWaiting" to Route117_EventScript_DaycareEggWaiting,
        "Route117_EventScript_RematchMaria" to Route117_EventScript_RematchMaria,
        "Route117_EventScript_DaycareAcceptEgg" to Route117_EventScript_DaycareAcceptEgg,
        "Route117_EventScript_CheckMonReceivedMail" to Route117_EventScript_CheckMonReceivedMail,
        "Route117_EventScript_DaycareReceiveEgg" to Route117_EventScript_DaycareReceiveEgg,
        "Route117_EventScript_MonReceivedMail" to Route117_EventScript_MonReceivedMail,
    )
