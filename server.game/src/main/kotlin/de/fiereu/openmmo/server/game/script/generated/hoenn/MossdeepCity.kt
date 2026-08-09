package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MossdeepCity
import de.fiereu.openmmo.dialog.generated.hoenn.MoveTutor
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_HM_DIVE, MossdeepCity_EventScript_SailorMagmaGone
 * msgbox MossdeepCity_Text_MossdeepTargetedByMagma, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_HM_DIVE))
        return MossdeepCity_EventScript_SailorMagmaGone.run(ctx)
    ctx.say(MossdeepCity.MossdeepTargetedByMagma)
  }
}

internal object MossdeepCity_EventScript_ExpertM : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MossdeepCity.LifeNeedsSeaToLive)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_HM_DIVE, MossdeepCity_EventScript_PokefanFMagmaGone
 * msgbox MossdeepCity_Text_SpaceCenterReceivedLetter, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_PokefanF : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_HM_DIVE))
        return MossdeepCity_EventScript_PokefanFMagmaGone.run(ctx)
    ctx.say(MossdeepCity.SpaceCenterReceivedLetter)
  }
}

internal object MossdeepCity_EventScript_NinjaBoy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MossdeepCity.WailmerWatching)
}

internal object MossdeepCity_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MossdeepCity.NiceIfWorldCoveredByFlowers)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_NET_BALL
 * end
 * ```
 */
internal object MossdeepCity_EventScript_ItemNetBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.NET_BALL, HoennFlags.FLAG_ITEM_MOSSDEEP_CITY_NET_BALL, 5)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox MossdeepCity_Text_SurfExhilarating, MSGBOX_DEFAULT
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity.SurfExhilarating)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

internal object MossdeepCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MossdeepCity.SpecialSpaceCenterRock)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_KINGS_ROCK, MossdeepCity_EventScript_ReceivedKingsRock
 * msgbox MossdeepCity_Text_WantKingsRockStevenGaveMe, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MossdeepCity_EventScript_DeclineKingsRock
 * msgbox MossdeepCity_Text_YouCanKeepIt, MSGBOX_DEFAULT
 * giveitem ITEM_KINGS_ROCK
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_KINGS_ROCK
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_KingsRockBoy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MossdeepCity_EventScript_KingsRockBoy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MOVE_TUTOR_TAUGHT_DYNAMICPUNCH, MoveTutor_EventScript_DynamicPunchTaught
 * msgbox MoveTutor_Text_DynamicPunchTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_DynamicPunchDeclined
 * call MoveTutor_EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_DynamicPunchDeclined
 * msgbox MoveTutor_Text_DynamicPunchWhichMon, MSGBOX_DEFAULT
 * setvar VAR_0x8005, TUTOR_MOVE_DYNAMIC_PUNCH
 * call MoveTutor_EventScript_OpenPartyMenu
 * goto_if_eq VAR_RESULT, 0, MoveTutor_EventScript_DynamicPunchDeclined
 * setflag FLAG_MOVE_TUTOR_TAUGHT_DYNAMICPUNCH
 * goto MoveTutor_EventScript_DynamicPunchTaught
 * end
 * ```
 */
internal object MossdeepCity_EventScript_DynamicPunchTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_EventScript_DynamicPunchTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MossdeepCity_Text_ScottSomethingWrongWithTown, MSGBOX_DEFAULT
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, MossdeepCity_EventScript_ScottExitNorth
 * call_if_eq VAR_FACING, DIR_EAST, MossdeepCity_EventScript_ScottExitEast
 * addvar VAR_SCOTT_STATE, 1
 * removeobject LOCALID_MOSSDEEP_SCOTT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_Scott : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MossdeepCity_EventScript_Scott")
}

internal object MossdeepCity_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MossdeepCity.SootopolisNewGymLeader)
}

internal object MossdeepCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(MossdeepCity.CitySign)
}

internal object MossdeepCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(MossdeepCity.GymSign)
}

internal object MossdeepCity_EventScript_SpaceCenterSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(MossdeepCity.SpaceCenterSign)
}

internal object MossdeepCity_EventScript_WhiteRock : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(MossdeepCity.ItsAWhiteRock)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_Text_FeelReliefOnLand, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_SailorMagmaGone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity.FeelReliefOnLand)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_Text_SpaceCenterLaunchingRockets, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_PokefanFMagmaGone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity.SpaceCenterLaunchingRockets)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, MossdeepCity_Movement_PlayerWatchScottExit
 * applymovement LOCALID_MOSSDEEP_SCOTT, MossdeepCity_Movement_ScottExitEast
 * waitmovement 0
 * return
 * ```
 */
internal object MossdeepCity_EventScript_ScottExitEast : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MossdeepCity_EventScript_ScottExitEast")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, MossdeepCity_Movement_PlayerWatchScottExit
 * applymovement LOCALID_MOSSDEEP_SCOTT, MossdeepCity_Movement_ScottExitNorth
 * waitmovement 0
 * return
 * ```
 */
internal object MossdeepCity_EventScript_ScottExitNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_EventScript_ScottExitNorth")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_Text_StevensHouseOverThere, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_ReceivedKingsRock : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity.StevensHouseOverThere)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_DynamicPunchDeclined, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_DynamicPunchDeclined : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.DynamicPunchDeclined)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_Text_WhatToDoWithWeirdRock, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_EventScript_DeclineKingsRock : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity.WhatToDoWithWeirdRock)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_DynamicPunchTaught, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_DynamicPunchTaught : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.DynamicPunchTaught)
  }
}

internal val MossdeepCityScripts: Map<String, Script> =
    mapOf(
        "MossdeepCity_EventScript_Sailor" to MossdeepCity_EventScript_Sailor,
        "MossdeepCity_EventScript_ExpertM" to MossdeepCity_EventScript_ExpertM,
        "MossdeepCity_EventScript_PokefanF" to MossdeepCity_EventScript_PokefanF,
        "MossdeepCity_EventScript_NinjaBoy" to MossdeepCity_EventScript_NinjaBoy,
        "MossdeepCity_EventScript_Girl" to MossdeepCity_EventScript_Girl,
        "MossdeepCity_EventScript_ItemNetBall" to MossdeepCity_EventScript_ItemNetBall,
        "MossdeepCity_EventScript_Man" to MossdeepCity_EventScript_Man,
        "MossdeepCity_EventScript_Woman" to MossdeepCity_EventScript_Woman,
        "MossdeepCity_EventScript_KingsRockBoy" to MossdeepCity_EventScript_KingsRockBoy,
        "MossdeepCity_EventScript_DynamicPunchTutor" to MossdeepCity_EventScript_DynamicPunchTutor,
        "MossdeepCity_EventScript_Scott" to MossdeepCity_EventScript_Scott,
        "MossdeepCity_EventScript_BlackBelt" to MossdeepCity_EventScript_BlackBelt,
        "MossdeepCity_EventScript_CitySign" to MossdeepCity_EventScript_CitySign,
        "MossdeepCity_EventScript_GymSign" to MossdeepCity_EventScript_GymSign,
        "MossdeepCity_EventScript_SpaceCenterSign" to MossdeepCity_EventScript_SpaceCenterSign,
        "MossdeepCity_EventScript_WhiteRock" to MossdeepCity_EventScript_WhiteRock,
        "MossdeepCity_EventScript_SailorMagmaGone" to MossdeepCity_EventScript_SailorMagmaGone,
        "MossdeepCity_EventScript_PokefanFMagmaGone" to MossdeepCity_EventScript_PokefanFMagmaGone,
        "MossdeepCity_EventScript_ScottExitEast" to MossdeepCity_EventScript_ScottExitEast,
        "MossdeepCity_EventScript_ScottExitNorth" to MossdeepCity_EventScript_ScottExitNorth,
        "MossdeepCity_EventScript_ReceivedKingsRock" to MossdeepCity_EventScript_ReceivedKingsRock,
        "MoveTutor_EventScript_DynamicPunchDeclined" to MoveTutor_EventScript_DynamicPunchDeclined,
        "MossdeepCity_EventScript_DeclineKingsRock" to MossdeepCity_EventScript_DeclineKingsRock,
        "MoveTutor_EventScript_DynamicPunchTaught" to MoveTutor_EventScript_DynamicPunchTaught,
    )
