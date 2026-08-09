package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MoveTutor
import de.fiereu.openmmo.dialog.generated.hoenn.SlateportCity_PokemonFanClub
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object SlateportCity_PokemonFanClub_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(SlateportCity_PokemonFanClub.PokemonDontLikeFainting)
}

internal object SlateportCity_PokemonFanClub_EventScript_Twin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(SlateportCity_PokemonFanClub.MonEnjoyedProtein)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * specialvar VAR_RESULT, IsLeadMonNicknamedOrNotEnglish
 * goto_if_eq VAR_RESULT, FALSE, SlateportCity_PokemonFanClub_EventScript_ReporterNoNickname
 * setvar VAR_0x8005, TVSHOW_PKMN_FAN_CLUB_OPINIONS
 * special InterviewBefore
 * goto_if_eq VAR_RESULT, TRUE, SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed
 * copyvar VAR_0x8009, VAR_0x8006
 * msgbox SlateportCity_PokemonFanClub_Text_InterviewRequestHasName, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, SlateportCity_PokemonFanClub_EventScript_AcceptInterview
 * goto_if_eq VAR_RESULT, NO, SlateportCity_PokemonFanClub_EventScript_DeclineInterview
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_Reporter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_Reporter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_SOOTHE_BELL, SlateportCity_PokemonFanClub_EventScript_ReceivedSootheBell
 * msgbox SlateportCity_PokemonFanClub_Text_ShowMePokemonThatLoveYou, MSGBOX_DEFAULT
 * specialvar VAR_RESULT, GetLeadMonFriendshipScore
 * goto_if_ge VAR_RESULT, FRIENDSHIP_150_TO_199, SlateportCity_PokemonFanClub_EventScript_GiveSootheBell
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_SootheBellWoman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_SootheBellWoman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_ENTERED_CONTEST, SlateportCity_PokemonFanClub_EventScript_ChairmanNotEnteredContest
 * call_if_unset FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN, SlateportCity_PokemonFanClub_EventScript_MeetChairman
 * switch VAR_SLATEPORT_FAN_CLUB_STATE
 * case 0, SlateportCity_PokemonFanClub_EventScript_ChairmanFirstAssessment
 * case 1, SlateportCity_PokemonFanClub_EventScript_ChairmanTryAssessPokemon
 * case 2, SlateportCity_PokemonFanClub_EventScript_NoMoreScarves
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_Chairman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_Chairman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_ZIGZAGOON, CRY_MODE_NORMAL
 * msgbox SlateportCity_PokemonFanClub_Text_Zigzagoon, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_Zigzagoon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_Zigzagoon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_SKITTY, CRY_MODE_NORMAL
 * msgbox SlateportCity_PokemonFanClub_Text_Skitty, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_Skitty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_Skitty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_AZUMARILL, CRY_MODE_NORMAL
 * msgbox SlateportCity_PokemonFanClub_Text_Azumarill, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_Azumarill : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_Azumarill")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MOVE_TUTOR_TAUGHT_SWAGGER, MoveTutor_EventScript_SwaggerTaught
 * msgbox MoveTutor_Text_SwaggerTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_SwaggerDeclined
 * call MoveTutor_EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_SwaggerDeclined
 * msgbox MoveTutor_Text_SwaggerWhichMon, MSGBOX_DEFAULT
 * setvar VAR_0x8005, TUTOR_MOVE_SWAGGER
 * call MoveTutor_EventScript_OpenPartyMenu
 * goto_if_eq VAR_RESULT, 0, MoveTutor_EventScript_SwaggerDeclined
 * setflag FLAG_MOVE_TUTOR_TAUGHT_SWAGGER
 * goto MoveTutor_EventScript_SwaggerTaught
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_SwaggerTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_SwaggerTutor")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_HereIfYouGetUrgeToTellMe, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_DeclineInterview : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.HereIfYouGetUrgeToTellMe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8005, TVSHOW_FAN_CLUB_LETTER
 * special InterviewBefore
 * goto_if_eq VAR_RESULT, TRUE, SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed2
 * copyvar VAR_0x8009, VAR_0x8006
 * msgbox SlateportCity_PokemonFanClub_Text_InterviewRequest, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, SlateportCity_PokemonFanClub_EventScript_AcceptInterview2
 * goto_if_eq VAR_RESULT, NO, SlateportCity_PokemonFanClub_EventScript_DeclineInterview2
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_ReporterNoNickname : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_ReporterNoNickname")
}

/**
 * Ported from the decomp:
 * ```
 * goto_if_set FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN, SlateportCity_PokemonFanClub_EventScript_ChairmanEnterContest
 * msgbox SlateportCity_PokemonFanClub_Text_MeetChairman, MSGBOX_DEFAULT
 * setflag FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_ChairmanNotEnteredContest : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN))
        return SlateportCity_PokemonFanClub_EventScript_ChairmanEnterContest.run(ctx)
    ctx.say(SlateportCity_PokemonFanClub.MeetChairman)
    ctx.setFlag(HoennFlags.FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_MeetChairman, MSGBOX_DEFAULT
 * setflag FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN
 * return
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_MeetChairman : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.MeetChairman)
    ctx.setFlag(HoennFlags.FLAG_MET_SLATEPORT_FANCLUB_CHAIRMAN)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_HereGoesQuickAnswers, MSGBOX_DEFAULT
 * random 3
 * copyvar VAR_0x800A, VAR_RESULT
 * switch VAR_RESULT
 * case 0, SlateportCity_PokemonFanClub_EventScript_RandomQuestion1
 * case 1, SlateportCity_PokemonFanClub_EventScript_RandomQuestion2
 * case 2, SlateportCity_PokemonFanClub_EventScript_RandomQuestion3
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_AcceptInterview : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_AcceptInterview")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_SwaggerDeclined, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_SwaggerDeclined : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.SwaggerDeclined)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_EnjoyDoingInterviews, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.EnjoyDoingInterviews)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_PIN
 * applymovement VAR_LAST_TALKED, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement VAR_LAST_TALKED, Common_Movement_Delay48
 * waitmovement 0
 * msgbox SlateportCity_PokemonFanClub_Text_PokemonAdoresYou, MSGBOX_DEFAULT
 * giveitem ITEM_SOOTHE_BELL
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_SOOTHE_BELL
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_GiveSootheBell : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_GiveSootheBell")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_TreatPokemonWithLove, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_ReceivedSootheBell : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.TreatPokemonWithLove)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_SwaggerTaught, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_SwaggerTaught : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.SwaggerTaught)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_LikeToSeeEnteredContestPokemon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_ChairmanEnterContest : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.LikeToSeeEnteredContestPokemon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_EnjoyDoingInterviews, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.EnjoyDoingInterviews)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_TellMeAnythingAboutYourMon, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_INTERVIEW
 * copyvar VAR_0x8005, VAR_0x8009
 * setvar VAR_0x8006, EASY_CHAT_PERSON_REPORTER_FEMALE
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, 1, SlateportCity_PokemonFanClub_EventScript_SubmitResponse2
 * goto_if_eq VAR_RESULT, 0, SlateportCity_PokemonFanClub_EventScript_DeclineInterview2
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_AcceptInterview2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_AcceptInterview2")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_HereIfYouGetUrgeToTellMe, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_DeclineInterview2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SlateportCity_PokemonFanClub.HereIfYouGetUrgeToTellMe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SlateportCity_PokemonFanClub_Text_ThatsAllForInterview2, MSGBOX_DEFAULT
 * setvar VAR_0x8005, TVSHOW_FAN_CLUB_LETTER
 * goto Interview_EventScript_EndInterview
 * end
 * ```
 */
internal object SlateportCity_PokemonFanClub_EventScript_SubmitResponse2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SlateportCity_PokemonFanClub_EventScript_SubmitResponse2")
}

internal val SlateportCity_PokemonFanClubScripts: Map<String, Script> =
    mapOf(
        "SlateportCity_PokemonFanClub_EventScript_Man" to
            SlateportCity_PokemonFanClub_EventScript_Man,
        "SlateportCity_PokemonFanClub_EventScript_Twin" to
            SlateportCity_PokemonFanClub_EventScript_Twin,
        "SlateportCity_PokemonFanClub_EventScript_Reporter" to
            SlateportCity_PokemonFanClub_EventScript_Reporter,
        "SlateportCity_PokemonFanClub_EventScript_SootheBellWoman" to
            SlateportCity_PokemonFanClub_EventScript_SootheBellWoman,
        "SlateportCity_PokemonFanClub_EventScript_Chairman" to
            SlateportCity_PokemonFanClub_EventScript_Chairman,
        "SlateportCity_PokemonFanClub_EventScript_Zigzagoon" to
            SlateportCity_PokemonFanClub_EventScript_Zigzagoon,
        "SlateportCity_PokemonFanClub_EventScript_Skitty" to
            SlateportCity_PokemonFanClub_EventScript_Skitty,
        "SlateportCity_PokemonFanClub_EventScript_Azumarill" to
            SlateportCity_PokemonFanClub_EventScript_Azumarill,
        "SlateportCity_PokemonFanClub_EventScript_SwaggerTutor" to
            SlateportCity_PokemonFanClub_EventScript_SwaggerTutor,
        "SlateportCity_PokemonFanClub_EventScript_DeclineInterview" to
            SlateportCity_PokemonFanClub_EventScript_DeclineInterview,
        "SlateportCity_PokemonFanClub_EventScript_ReporterNoNickname" to
            SlateportCity_PokemonFanClub_EventScript_ReporterNoNickname,
        "SlateportCity_PokemonFanClub_EventScript_ChairmanNotEnteredContest" to
            SlateportCity_PokemonFanClub_EventScript_ChairmanNotEnteredContest,
        "SlateportCity_PokemonFanClub_EventScript_MeetChairman" to
            SlateportCity_PokemonFanClub_EventScript_MeetChairman,
        "SlateportCity_PokemonFanClub_EventScript_AcceptInterview" to
            SlateportCity_PokemonFanClub_EventScript_AcceptInterview,
        "MoveTutor_EventScript_SwaggerDeclined" to MoveTutor_EventScript_SwaggerDeclined,
        "SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed" to
            SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed,
        "SlateportCity_PokemonFanClub_EventScript_GiveSootheBell" to
            SlateportCity_PokemonFanClub_EventScript_GiveSootheBell,
        "SlateportCity_PokemonFanClub_EventScript_ReceivedSootheBell" to
            SlateportCity_PokemonFanClub_EventScript_ReceivedSootheBell,
        "MoveTutor_EventScript_SwaggerTaught" to MoveTutor_EventScript_SwaggerTaught,
        "SlateportCity_PokemonFanClub_EventScript_ChairmanEnterContest" to
            SlateportCity_PokemonFanClub_EventScript_ChairmanEnterContest,
        "SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed2" to
            SlateportCity_PokemonFanClub_EventScript_AlreadyInterviewed2,
        "SlateportCity_PokemonFanClub_EventScript_AcceptInterview2" to
            SlateportCity_PokemonFanClub_EventScript_AcceptInterview2,
        "SlateportCity_PokemonFanClub_EventScript_DeclineInterview2" to
            SlateportCity_PokemonFanClub_EventScript_DeclineInterview2,
        "SlateportCity_PokemonFanClub_EventScript_SubmitResponse2" to
            SlateportCity_PokemonFanClub_EventScript_SubmitResponse2,
    )
