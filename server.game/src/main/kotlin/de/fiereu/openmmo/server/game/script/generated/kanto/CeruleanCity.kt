package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity
import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_BikeShop
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeruleanCity_Text_PeopleHereWereRobbed
 * closemessage
 * applymovement LOCALID_CERULEAN_POLICEMAN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_Policeman : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.PeopleHereWereRobbed)
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
 * goto_if_defeated TRAINER_TEAM_ROCKET_GRUNT_5, CeruleanCity_EventScript_GruntDefeated
 * message CeruleanCity_Text_GruntIntro
 * waitmessage
 * playbgm MUS_ENCOUNTER_ROCKET, 0
 * waitbuttonpress
 * trainerbattle_no_intro TRAINER_TEAM_ROCKET_GRUNT_5, CeruleanCity_Text_GruntDefeat
 * setvar VAR_MAP_SCENE_CERULEAN_CITY_ROCKET, 1
 * goto CeruleanCity_EventScript_GruntDefeated
 * end
 * ```
 */
internal object CeruleanCity_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_EventScript_Grunt")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_SS_TICKET, CeruleanCity_EventScript_LittleBoySlowbroMoved
 * msgbox CeruleanCity_Text_IfSlowbroWasntThereCouldCutTree
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_SS_TICKET))
        return CeruleanCity_EventScript_LittleBoySlowbroMoved.run(ctx)
    ctx.say(CeruleanCity.IfSlowbroWasntThereCouldCutTree)
  }
}

internal object CeruleanCity_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.PokemonEncyclopediaAmusing)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * random 4
 * copyvar VAR_0x8008, VAR_RESULT
 * call_if_eq VAR_0x8008, 0, CeruleanCity_EventScript_SlowbroText1
 * call_if_eq VAR_0x8008, 1, CeruleanCity_EventScript_SlowbroText2
 * call_if_eq VAR_0x8008, 2, CeruleanCity_EventScript_SlowbroText3
 * call_if_eq VAR_0x8008, 3, CeruleanCity_EventScript_SlowbroText4
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_Slowbro : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_EventScript_Slowbro")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * random 3
 * copyvar VAR_0x8008, VAR_RESULT
 * call_if_eq VAR_0x8008, 0, CeruleanCity_EventScript_SlowbroCommand1
 * call_if_eq VAR_0x8008, 1, CeruleanCity_EventScript_SlowbroCommand2
 * call_if_eq VAR_0x8008, 2, CeruleanCity_EventScript_SlowbroCommand3
 * waitmessage
 * delay 40
 * playse SE_PIN
 * applymovement LOCALID_CERULEAN_SLOWBRO, Common_Movement_QuestionMark
 * waitmovement 0
 * delay 30
 * call_if_eq VAR_0x8008, 0, CeruleanCity_EventScript_SlowbroFailed1
 * call_if_eq VAR_0x8008, 1, CeruleanCity_EventScript_SlowbroFailed2
 * call_if_eq VAR_0x8008, 2, CeruleanCity_EventScript_SlowbroFailed3
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_EventScript_Lass")
}

internal object CeruleanCity_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.TrainerLifeIsToughIsntIt)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeruleanCity_Text_WantBrightRedBicycle
 * closemessage
 * applymovement LOCALID_CERULEAN_WOMAN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.WantBrightRedBicycle)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

internal object CeruleanCity_EventScript_CeruleanCaveGuard : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.ThisIsCeruleanCave)
}

internal object CeruleanCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.CitySign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_MISTY, 0
 * msgbox CeruleanCity_Text_GymSign
 * releaseall
 * end
 * ```
 */
internal object CeruleanCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_EventScript_GymSign")
}

internal object CeruleanCity_EventScript_BikeShopSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.BikeShopSign)
}

internal object CeruleanCity_EventScript_TrainerTips : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.TrainerTipsHeldItems)
}

internal object CeruleanCity_BikeShop_EventScript_Bicycle : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity_BikeShop.ShinyNewBicycle)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_YouCanCutDownSmallTrees
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_LittleBoySlowbroMoved : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.YouCanCutDownSmallTrees)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_SlowbroPayAttention
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroFailed1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroPayAttention)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_NoYouBlewItAgain
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroFailed2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.NoYouBlewItAgain)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_HardToControlMonsObedience
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroFailed3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.HardToControlMonsObedience)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeruleanCity_Text_OkayIllReturnStolenTM
 * checkitemspace ITEM_TM28
 * goto_if_eq VAR_RESULT, FALSE, CeruleanCity_EventScript_NoRoomForTM28
 * giveitem_msg CeruleanCity_Text_RecoveredTM28FromGrunt, ITEM_TM28
 * msgbox CeruleanCity_Text_BetterGetMovingBye
 * closemessage
 * fadescreen FADE_TO_BLACK
 * removeobject LOCALID_CERULEAN_GRUNT
 * fadescreen FADE_FROM_BLACK
 * setflag FLAG_GOT_TM28_FROM_ROCKET
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_GruntDefeated : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_EventScript_GruntDefeated")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_SlowbroIgnoredOrders
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroText4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroIgnoredOrders)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_SlowbroTookSnooze
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroText1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroTookSnooze)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message CeruleanCity_Text_SlowbroWithdraw
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroCommand3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroWithdraw)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message CeruleanCity_Text_SlowbroPunch
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroCommand2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroPunch)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_SlowbroTurnedAway
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroText3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroTurnedAway)
  }
}

/**
 * Ported from the decomp:
 * ```
 * message CeruleanCity_Text_SlowbroUseSonicboom
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroCommand1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroUseSonicboom)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_Text_SlowbroLoafingAround
 * return
 * ```
 */
internal object CeruleanCity_EventScript_SlowbroText2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroLoafingAround)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_MALE
 * msgbox CeruleanCity_Text_MakeRoomForThisCantRun
 * release
 * end
 * ```
 */
internal object CeruleanCity_EventScript_NoRoomForTM28 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_EventScript_NoRoomForTM28")
}

internal val CeruleanCityScripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_EventScript_Policeman" to CeruleanCity_EventScript_Policeman,
        "CeruleanCity_EventScript_Grunt" to CeruleanCity_EventScript_Grunt,
        "CeruleanCity_EventScript_LittleBoy" to CeruleanCity_EventScript_LittleBoy,
        "CeruleanCity_EventScript_BaldingMan" to CeruleanCity_EventScript_BaldingMan,
        "CeruleanCity_EventScript_Slowbro" to CeruleanCity_EventScript_Slowbro,
        "CeruleanCity_EventScript_Lass" to CeruleanCity_EventScript_Lass,
        "CeruleanCity_EventScript_Youngster" to CeruleanCity_EventScript_Youngster,
        "CeruleanCity_EventScript_Woman" to CeruleanCity_EventScript_Woman,
        "CeruleanCity_EventScript_CeruleanCaveGuard" to CeruleanCity_EventScript_CeruleanCaveGuard,
        "CeruleanCity_EventScript_CitySign" to CeruleanCity_EventScript_CitySign,
        "CeruleanCity_EventScript_GymSign" to CeruleanCity_EventScript_GymSign,
        "CeruleanCity_EventScript_BikeShopSign" to CeruleanCity_EventScript_BikeShopSign,
        "CeruleanCity_EventScript_TrainerTips" to CeruleanCity_EventScript_TrainerTips,
        "CeruleanCity_BikeShop_EventScript_Bicycle" to CeruleanCity_BikeShop_EventScript_Bicycle,
        "CeruleanCity_EventScript_LittleBoySlowbroMoved" to
            CeruleanCity_EventScript_LittleBoySlowbroMoved,
        "CeruleanCity_EventScript_SlowbroFailed1" to CeruleanCity_EventScript_SlowbroFailed1,
        "CeruleanCity_EventScript_SlowbroFailed2" to CeruleanCity_EventScript_SlowbroFailed2,
        "CeruleanCity_EventScript_SlowbroFailed3" to CeruleanCity_EventScript_SlowbroFailed3,
        "CeruleanCity_EventScript_GruntDefeated" to CeruleanCity_EventScript_GruntDefeated,
        "CeruleanCity_EventScript_SlowbroText4" to CeruleanCity_EventScript_SlowbroText4,
        "CeruleanCity_EventScript_SlowbroText1" to CeruleanCity_EventScript_SlowbroText1,
        "CeruleanCity_EventScript_SlowbroCommand3" to CeruleanCity_EventScript_SlowbroCommand3,
        "CeruleanCity_EventScript_SlowbroCommand2" to CeruleanCity_EventScript_SlowbroCommand2,
        "CeruleanCity_EventScript_SlowbroText3" to CeruleanCity_EventScript_SlowbroText3,
        "CeruleanCity_EventScript_SlowbroCommand1" to CeruleanCity_EventScript_SlowbroCommand1,
        "CeruleanCity_EventScript_SlowbroText2" to CeruleanCity_EventScript_SlowbroText2,
        "CeruleanCity_EventScript_NoRoomForTM28" to CeruleanCity_EventScript_NoRoomForTM28,
    )
