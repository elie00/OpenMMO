package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object CeladonCity_EventScript_RocketGrunt1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.KeepOutOfTeamRocketsWay)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeladonCity_Text_MyTrustedPalPoliwrath
 * closemessage
 * applymovement LOCALID_CELADON_FAT_MAN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object CeladonCity_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity.MyTrustedPalPoliwrath)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_POLIWRATH, CRY_MODE_NORMAL
 * msgbox CeladonCity_Text_Poliwrath
 * closemessage
 * waitmoncry
 * applymovement LOCALID_CELADON_POLIWRATH, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object CeladonCity_EventScript_Poliwrath : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_EventScript_Poliwrath")
}

internal object CeladonCity_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.GotMyKoffingInCinnabar)
}

internal object CeladonCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.GameCornerIsBadForCitysImage)
}

internal object CeladonCity_EventScript_OldMan2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.BlewItAllAtSlots)
}

/**
 * Ported from the decomp:
 * ```
 * goto EventScript_SoftboiledTutor
 * end
 * ```
 */
internal object CeladonCity_EventScript_SoftboiledTutor : Script {
  override suspend fun run(ctx: ScriptContext) {
    return EventScript_SoftboiledTutor.run(ctx)
  }
}

internal object CeladonCity_EventScript_RocketGrunt2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.GetLostOrIllPunchYou)
}

internal object CeladonCity_EventScript_OldMan1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.GymIsGreatFullOfWomen)
}

internal object CeladonCity_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.ScaldedTongueOnTea)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ETHER
 * end
 * ```
 */
internal object CeladonCity_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ETHER, KantoFlags.FLAG_HIDE_CELADON_CITY_ETHER, 13)
  }
}

internal object CeladonCity_EventScript_SilphCoScientist : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeladonCity.SomeoneStoleSilphScope)
}

internal object CeladonCity_EventScript_TrainerTips2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.GuardSpecProtectsFromStatus)
}

internal object CeladonCity_EventScript_PrizeExchangeSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.PrizeExchangeSign)
}

internal object CeladonCity_EventScript_GameCornerSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.GameCornerSign)
}

internal object CeladonCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.CitySign)
}

internal object CeladonCity_EventScript_MansionSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.MansionSign)
}

internal object CeladonCity_EventScript_TrainerTips1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.ExplainXAccuracyDireHit)
}

internal object CeladonCity_EventScript_DeptStoreSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity.DeptStoreSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_ERIKA, 0
 * msgbox CeladonCity_Text_GymSign
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeladonCity_EventScript_GymSign")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_SOFT_BOILED, EventScript_SoftboiledTaught
 * msgbox Text_SoftboiledTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_SoftboiledDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_SoftboiledDeclined
 * msgbox Text_SoftboiledWhichMon
 * setvar VAR_0x8005, MOVETUTOR_SOFT_BOILED
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_SoftboiledDeclined
 * setflag FLAG_TUTOR_SOFT_BOILED
 * goto EventScript_SoftboiledTaught
 * end
 * ```
 */
internal object EventScript_SoftboiledTutor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SoftboiledTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SoftboiledTaught
 * release
 * end
 * ```
 */
internal object EventScript_SoftboiledTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SoftboiledTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special ChooseMonForMoveTutor
 * waitstate
 * lock
 * faceplayer
 * return
 * ```
 */
internal object EventScript_ChooseMoveTutorMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_ChooseMoveTutorMon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * special DisableMsgBoxWalkaway
 * signmsg
 * msgbox Text_MoveCanOnlyBeLearnedOnce, MSGBOX_YESNO
 * normalmsg
 * call EventScript_RestorePrevTextColor
 * return
 * ```
 */
internal object EventScript_CanOnlyBeLearnedOnce : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_CanOnlyBeLearnedOnce")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SoftboiledDeclined
 * release
 * end
 * ```
 */
internal object EventScript_SoftboiledDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SoftboiledDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_TEXT_COLOR, VAR_PREV_TEXT_COLOR
 * return
 * ```
 */
internal object EventScript_RestorePrevTextColor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RestorePrevTextColor")
}

internal val CeladonCityScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_EventScript_RocketGrunt1" to CeladonCity_EventScript_RocketGrunt1,
        "CeladonCity_EventScript_FatMan" to CeladonCity_EventScript_FatMan,
        "CeladonCity_EventScript_Poliwrath" to CeladonCity_EventScript_Poliwrath,
        "CeladonCity_EventScript_LittleGirl" to CeladonCity_EventScript_LittleGirl,
        "CeladonCity_EventScript_Woman" to CeladonCity_EventScript_Woman,
        "CeladonCity_EventScript_OldMan2" to CeladonCity_EventScript_OldMan2,
        "CeladonCity_EventScript_SoftboiledTutor" to CeladonCity_EventScript_SoftboiledTutor,
        "CeladonCity_EventScript_RocketGrunt2" to CeladonCity_EventScript_RocketGrunt2,
        "CeladonCity_EventScript_OldMan1" to CeladonCity_EventScript_OldMan1,
        "CeladonCity_EventScript_Boy" to CeladonCity_EventScript_Boy,
        "CeladonCity_EventScript_ItemEther" to CeladonCity_EventScript_ItemEther,
        "CeladonCity_EventScript_SilphCoScientist" to CeladonCity_EventScript_SilphCoScientist,
        "CeladonCity_EventScript_TrainerTips2" to CeladonCity_EventScript_TrainerTips2,
        "CeladonCity_EventScript_PrizeExchangeSign" to CeladonCity_EventScript_PrizeExchangeSign,
        "CeladonCity_EventScript_GameCornerSign" to CeladonCity_EventScript_GameCornerSign,
        "CeladonCity_EventScript_CitySign" to CeladonCity_EventScript_CitySign,
        "CeladonCity_EventScript_MansionSign" to CeladonCity_EventScript_MansionSign,
        "CeladonCity_EventScript_TrainerTips1" to CeladonCity_EventScript_TrainerTips1,
        "CeladonCity_EventScript_DeptStoreSign" to CeladonCity_EventScript_DeptStoreSign,
        "CeladonCity_EventScript_GymSign" to CeladonCity_EventScript_GymSign,
        "EventScript_SoftboiledTutor" to EventScript_SoftboiledTutor,
        "EventScript_SoftboiledTaught" to EventScript_SoftboiledTaught,
        "EventScript_ChooseMoveTutorMon" to EventScript_ChooseMoveTutorMon,
        "EventScript_CanOnlyBeLearnedOnce" to EventScript_CanOnlyBeLearnedOnce,
        "EventScript_SoftboiledDeclined" to EventScript_SoftboiledDeclined,
        "EventScript_RestorePrevTextColor" to EventScript_RestorePrevTextColor,
    )
