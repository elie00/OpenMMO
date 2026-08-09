package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.LilycoveCity_PokemonTrainerFanClub
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * goto_if_eq VAR_LILYCOVE_FAN_CLUB_STATE, 0, LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayerNotChampion
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_ICantHelpLikingBrawly, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_Lass")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER6
 * special BufferFanClubTrainerName
 * goto_if_eq VAR_LILYCOVE_FAN_CLUB_STATE, 0, LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayerNotChampion
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_TrainersPowerIsOutOfTheOrdinary, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_Man")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER2
 * special BufferFanClubTrainerName
 * goto_if_eq VAR_LILYCOVE_FAN_CLUB_STATE, 0, LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayerNotChampion
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_LongWayToGoComparedToNorman, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanM : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanM")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER3
 * special BufferFanClubTrainerName
 * goto_if_eq VAR_LILYCOVE_FAN_CLUB_STATE, 0, LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_EveryoneThinksTrainerIsCool, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER4
 * special BufferFanClubTrainerName
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_TrainerIsWickedlyCool, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER5
 * special BufferFanClubTrainerName
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_BoyPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_ThinkTrainerIsNumberOne, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_Boy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER7
 * special BufferFanClubTrainerName
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_TrainerIsStandout, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_Woman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER8
 * special BufferFanClubTrainerName
 * specialvar VAR_RESULT, IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFPlayersFan
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyNonFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_HaventRealizedPotential, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertF : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertF")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_FAN_CLUB_STRENGTH_SHARED, LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed
 * goto_if_unset FLAG_FAN_CLUB_STRENGTH_SHARED, LilycoveCity_PokemonTrainerFanClub_EventScript_Interview
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_Interviewer : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_FAN_CLUB_STRENGTH_SHARED))
        return LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed.run(ctx)
    if (!ctx.isFlagSet(HoennFlags.FLAG_FAN_CLUB_STRENGTH_SHARED))
        return LilycoveCity_PokemonTrainerFanClub_EventScript_Interview.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_TrainerIsReallyCoolItsJustMe, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.TrainerIsReallyCoolItsJustMe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_WantToBeStrongLikeYou, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_NoOneCanKnockYouButTrainerStronger, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.NoOneCanKnockYouButTrainerStronger)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YourePowerfulButNotTrueStrength, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.YourePowerfulButNotTrueStrength)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YouveSurpassedYourFather, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayersFan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YoureAmazingAfterAll, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_BoyPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_BoyPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_MyFavoriteTrainerIsBrawly, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.MyFavoriteTrainerIsBrawly)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_TrainerIsBestNoOneWantsToListen, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.TrainerIsBestNoOneWantsToListen)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_WeDiscussStrongestTrainers, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.WeDiscussStrongestTrainers)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * msgbox LilycoveCity_PokemonTrainerFanClub_HopeYouCatchTVSpecial, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_ImPullingForYou, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_HearingAboutToughNewTrainer, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.HearingAboutToughNewTrainer)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8005, TVSHOW_FAN_CLUB_SPECIAL
 * special InterviewBefore
 * goto_if_eq VAR_RESULT, TRUE, LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed2
 * copyvar VAR_0x800A, VAR_0x8006
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_WhatsYourOpinionOfTrainer, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_FAN_QUESTION
 * copyvar VAR_0x8005, VAR_0x800A
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_SubmitOpinion
 * goto_if_eq VAR_RESULT, 0, LilycoveCity_PokemonTrainerFanClub_EventScript_CancelGiveOpinion
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_Interview : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_Interview")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_OhWoweeItsPlayer, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YouChangedMyMind, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YouImpressive, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YouAndNormanAreDifferent, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.YouAndNormanAreDifferent)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_NeverGoingToStopBeingTrainersFan, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.NeverGoingToStopBeingTrainersFan)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_NobodyUnderstandsBrawly, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.NobodyUnderstandsBrawly)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YoureMaybeStrongerThanTrainer, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.YoureMaybeStrongerThanTrainer)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyFan
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YoureOneWeWantToWin, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_WishThereWasTrainerLikeThat, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion :
    Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.WishThereWasTrainerLikeThat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YouBattleAttractivelyInToughSituation, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.YouBattleAttractivelyInToughSituation)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_ImInYourCorner, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.ImInYourCorner)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_BrawlyNoImYourFan, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.BrawlyNoImYourFan)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_HaveYouForgottenTrainer, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, LilycoveCity_PokemonTrainerFanClub_EventScript_ForgetTrainer
 * goto_if_eq VAR_RESULT, NO, LilycoveCity_PokemonTrainerFanClub_EventScript_AskForOpinion
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_CancelGiveOpinion : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_CancelGiveOpinion")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_OnlyOneWhoCheersForYou, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.OnlyOneWhoCheersForYou)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_ThatsWhatYouThink, MSGBOX_DEFAULT
 * goto LilycoveCity_PokemonTrainerFanClub_EventScript_RateTrainer
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_SubmitOpinion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.ThatsWhatYouThink)
    return LilycoveCity_PokemonTrainerFanClub_EventScript_RateTrainer.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_OthersDontKnowYoureTheBest, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.OthersDontKnowYoureTheBest)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_AlwaysCheerForYou, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.AlwaysCheerForYou)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_OnlyIRecognizeYourTrueWorth, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.OnlyIRecognizeYourTrueWorth)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YourFatherNeverGaveUpSoKeepOnBattling, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_PokemonTrainerFanClub.YourFatherNeverGaveUpSoKeepOnBattling)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * message LilycoveCity_PokemonTrainerFanClub_Text_HowStrongRateTrainer
 * waitmessage
 * setvar VAR_0x8004, SCROLL_MULTI_POKEMON_FAN_CLUB_RATER
 * special ShowScrollableMultichoice
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * switch VAR_RESULT
 * case 11, LilycoveCity_PokemonTrainerFanClub_EventScript_CancelRateTrainer
 * case MULTI_B_PRESSED, LilycoveCity_PokemonTrainerFanClub_EventScript_CancelRateTrainer
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * copyvar VAR_0x8006, VAR_0x800A
 * copyvar VAR_0x8005, VAR_RESULT
 * special PutFanClubSpecialOnTheAir
 * goto LilycoveCity_PokemonTrainerFanClub_EventScript_CompleteInterview
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_RateTrainer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_RateTrainer")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_YouShouldMeetTrainer, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_ForgetTrainer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_ForgetTrainer")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_WhatsYourOpinionOfTrainer2, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_FAN_QUESTION
 * copyvar VAR_0x8005, VAR_0x800A
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, 1, LilycoveCity_PokemonTrainerFanClub_EventScript_SubmitOpinion
 * goto_if_eq VAR_RESULT, 0, LilycoveCity_PokemonTrainerFanClub_EventScript_CancelGiveOpinion
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_AskForOpinion : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_AskForOpinion")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special BufferFanClubTrainerName
 * msgbox LilycoveCity_PokemonTrainerFanClub_Text_ThankYouIllShareThisInfo, MSGBOX_DEFAULT
 * setflag FLAG_FAN_CLUB_STRENGTH_SHARED
 * release
 * end
 * ```
 */
internal object LilycoveCity_PokemonTrainerFanClub_EventScript_CompleteInterview : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_PokemonTrainerFanClub_EventScript_CompleteInterview")
}

internal val LilycoveCity_PokemonTrainerFanClubScripts: Map<String, Script> =
    mapOf(
        "LilycoveCity_PokemonTrainerFanClub_EventScript_Lass" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_Lass,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_Man" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_Man,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanM" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanM,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirl" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirl,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoy" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoy,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_Boy" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_Boy,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_Woman" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_Woman,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertF" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertF,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_Interviewer" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_Interviewer,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_BoyPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_BoyPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayerNotChampion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayerNotChampion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayerNotChampion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMPlayerNotChampion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LassPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayerNotChampion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayerNotChampion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_Interview" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_Interview,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyNonFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyNonFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayersFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ManPlayersFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_BoyOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LassOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_CancelGiveOpinion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_CancelGiveOpinion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_NinjaBoyOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_SubmitOpinion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_SubmitOpinion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ManOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ExpertFOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyFan" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_PokefanMOnlyFan,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed2" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_AlreadyInterviewed2,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_RateTrainer" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_RateTrainer,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_ForgetTrainer" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_ForgetTrainer,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_AskForOpinion" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_AskForOpinion,
        "LilycoveCity_PokemonTrainerFanClub_EventScript_CompleteInterview" to
            LilycoveCity_PokemonTrainerFanClub_EventScript_CompleteInterview,
    )
