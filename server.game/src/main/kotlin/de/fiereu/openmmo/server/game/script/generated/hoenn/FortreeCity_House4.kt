package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FortreeCity_House4
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object FortreeCity_House4_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(FortreeCity_House4.BringsWorldCloserTogether)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_RECEIVED_MENTAL_HERB, FortreeCity_House4_EventScript_ReceivedMentalHerb
 * goto_if_set FLAG_WINGULL_DELIVERED_MAIL, FortreeCity_House4_EventScript_WingullReturned
 * goto_if_set FLAG_WINGULL_SENT_ON_ERRAND, FortreeCity_House4_EventScript_WingullOnErrand
 * msgbox FortreeCity_House4_Text_GoBirdPokemon, MSGBOX_DEFAULT
 * closemessage
 * setflag FLAG_WINGULL_SENT_ON_ERRAND
 * clearflag FLAG_HIDE_MOSSDEEP_CITY_HOUSE_2_WINGULL
 * applymovement LOCALID_FORTREE_HOUSE_WINGULL, FortreeCity_House4_Movement_WingullExit
 * waitmovement 0
 * removeobject LOCALID_FORTREE_HOUSE_WINGULL
 * releaseall
 * end
 * ```
 */
internal object FortreeCity_House4_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FortreeCity_House4_EventScript_Boy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_WINGULL, CRY_MODE_NORMAL
 * msgbox FortreeCity_House4_Text_Wingull, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object FortreeCity_House4_EventScript_Wingull : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FortreeCity_House4_EventScript_Wingull")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox FortreeCity_House4_Text_FriendsFarAwayThanksToWingull, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object FortreeCity_House4_EventScript_ReceivedMentalHerb : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_House4_EventScript_ReceivedMentalHerb")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox FortreeCity_House4_Text_WelcomeWingullTakeMentalHerb, MSGBOX_DEFAULT
 * giveitem ITEM_MENTAL_HERB
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_MENTAL_HERB
 * releaseall
 * end
 * ```
 */
internal object FortreeCity_House4_EventScript_WingullReturned : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_House4_EventScript_WingullReturned")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_LAST_TALKED, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox FortreeCity_House4_Text_AskedWingullToRunErrand, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object FortreeCity_House4_EventScript_WingullOnErrand : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_House4_EventScript_WingullOnErrand")
}

internal val FortreeCity_House4Scripts: Map<String, Script> =
    mapOf(
        "FortreeCity_House4_EventScript_Woman" to FortreeCity_House4_EventScript_Woman,
        "FortreeCity_House4_EventScript_Boy" to FortreeCity_House4_EventScript_Boy,
        "FortreeCity_House4_EventScript_Wingull" to FortreeCity_House4_EventScript_Wingull,
        "FortreeCity_House4_EventScript_ReceivedMentalHerb" to
            FortreeCity_House4_EventScript_ReceivedMentalHerb,
        "FortreeCity_House4_EventScript_WingullReturned" to
            FortreeCity_House4_EventScript_WingullReturned,
        "FortreeCity_House4_EventScript_WingullOnErrand" to
            FortreeCity_House4_EventScript_WingullOnErrand,
    )
