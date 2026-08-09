package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FortreeCity_House2
import de.fiereu.openmmo.dialog.generated.hoenn.MoveTutor
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_TM_HIDDEN_POWER, FortreeCity_House2_EventScript_ExplainHiddenPower
 * call_if_unset FLAG_MET_HIDDEN_POWER_GIVER, FortreeCity_House2_EventScript_Greeting
 * msgbox FortreeCity_House2_Text_CoinInWhichHand, MSGBOX_DEFAULT
 * multichoice 21, 8, MULTI_RIGHTLEFT, TRUE
 * switch VAR_RESULT
 * case 1, FortreeCity_House2_EventScript_WrongGuess
 * msgbox FortreeCity_House2_Text_CorrectTryAgainWhichHand, MSGBOX_DEFAULT
 * multichoice 21, 8, MULTI_RIGHTLEFT, TRUE
 * switch VAR_RESULT
 * case 1, FortreeCity_House2_EventScript_WrongGuess
 * msgbox FortreeCity_House2_Text_CorrectTryAgainWhichHand2, MSGBOX_DEFAULT
 * multichoice 21, 8, MULTI_RIGHTLEFT, TRUE
 * switch VAR_RESULT
 * case 0, FortreeCity_House2_EventScript_WrongGuess
 * msgbox FortreeCity_House2_Text_YourHiddenPowerHasAwoken, MSGBOX_DEFAULT
 * giveitem ITEM_TM_HIDDEN_POWER
 * goto_if_eq VAR_RESULT, 0, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_TM_HIDDEN_POWER
 * msgbox FortreeCity_House2_Text_ExplainHiddenPower, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_House2_EventScript_HiddenPowerGiver : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_House2_EventScript_HiddenPowerGiver")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MOVE_TUTOR_TAUGHT_SLEEP_TALK, MoveTutor_EventScript_SleepTalkTaught
 * msgbox MoveTutor_Text_SleepTalkTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_SleepTalkDeclined
 * call MoveTutor_EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_SleepTalkDeclined
 * msgbox MoveTutor_Text_SleepTalkWhichMon, MSGBOX_DEFAULT
 * setvar VAR_0x8005, TUTOR_MOVE_SLEEP_TALK
 * call MoveTutor_EventScript_OpenPartyMenu
 * goto_if_eq VAR_RESULT, 0, MoveTutor_EventScript_SleepTalkDeclined
 * setflag FLAG_MOVE_TUTOR_TAUGHT_SLEEP_TALK
 * goto MoveTutor_EventScript_SleepTalkTaught
 * end
 * ```
 */
internal object FortreeCity_House2_EventScript_SleepTalkTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_House2_EventScript_SleepTalkTutor")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FortreeCity_House2_Text_ExplainHiddenPower, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_House2_EventScript_ExplainHiddenPower : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FortreeCity_House2.ExplainHiddenPower)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_SleepTalkDeclined, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_SleepTalkDeclined : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.SleepTalkDeclined)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_SleepTalkTaught, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_SleepTalkTaught : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.SleepTalkTaught)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FortreeCity_House2_Text_HiddenPowersArousedByNature, MSGBOX_DEFAULT
 * setflag FLAG_MET_HIDDEN_POWER_GIVER
 * return
 * ```
 */
internal object FortreeCity_House2_EventScript_Greeting : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FortreeCity_House2.HiddenPowersArousedByNature)
    ctx.setFlag(HoennFlags.FLAG_MET_HIDDEN_POWER_GIVER)
  }
}

internal val FortreeCity_House2Scripts: Map<String, Script> =
    mapOf(
        "FortreeCity_House2_EventScript_HiddenPowerGiver" to
            FortreeCity_House2_EventScript_HiddenPowerGiver,
        "FortreeCity_House2_EventScript_SleepTalkTutor" to
            FortreeCity_House2_EventScript_SleepTalkTutor,
        "FortreeCity_House2_EventScript_ExplainHiddenPower" to
            FortreeCity_House2_EventScript_ExplainHiddenPower,
        "MoveTutor_EventScript_SleepTalkDeclined" to MoveTutor_EventScript_SleepTalkDeclined,
        "MoveTutor_EventScript_SleepTalkTaught" to MoveTutor_EventScript_SleepTalkTaught,
        "FortreeCity_House2_EventScript_Greeting" to FortreeCity_House2_EventScript_Greeting,
    )
