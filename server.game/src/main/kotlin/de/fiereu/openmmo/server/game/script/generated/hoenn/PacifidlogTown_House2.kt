package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.PacifidlogTown_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * call PacifidlogTown_House2_EventScript_UpdateFanClubTMFlag
 * goto_if_set FLAG_RECEIVED_FANCLUB_TM_THIS_WEEK, PacifidlogTown_House2_EventScript_ComeBackInXDays
 * call_if_set FLAG_MET_FANCLUB_YOUNGER_BROTHER, PacifidlogTown_House2_EventScript_MonAssessment
 * call_if_unset FLAG_MET_FANCLUB_YOUNGER_BROTHER, PacifidlogTown_House2_EventScript_FirstMonAssessment
 * setflag FLAG_MET_FANCLUB_YOUNGER_BROTHER
 * specialvar VAR_RESULT, GetLeadMonFriendshipScore
 * goto_if_ge VAR_RESULT, FRIENDSHIP_150_TO_199, PacifidlogTown_House2_EventScript_GiveReturn
 * specialvar VAR_RESULT, GetLeadMonFriendshipScore
 * goto_if_ge VAR_RESULT, FRIENDSHIP_50_TO_99, PacifidlogTown_House2_EventScript_PutInEffort
 * goto PacifidlogTown_House2_EventScript_GiveFrustration
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_FanClubYoungerBrother : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_FanClubYoungerBrother")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_AZURILL, CRY_MODE_NORMAL
 * msgbox PacifidlogTown_House2_Text_Rurii, MSGBOX_DEFAULT
 * waitmoncry
 * msgbox PacifidlogTown_House2_Text_VeryFriendlyWithTrainer, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_HappyAzurill : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_HappyAzurill")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_AZURILL, CRY_MODE_ENCOUNTER
 * msgbox PacifidlogTown_House2_Text_Rururi, MSGBOX_DEFAULT
 * waitmoncry
 * msgbox PacifidlogTown_House2_Text_DoesntLikeTrainerVeryMuch, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_UnhappyAzurill : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_UnhappyAzurill")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PacifidlogTown_House2_Text_ChairmansYoungerBrotherOnVacation, MSGBOX_DEFAULT
 * msgbox PacifidlogTown_House2_Text_AhYourPokemon, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object PacifidlogTown_House2_EventScript_FirstMonAssessment : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PacifidlogTown_House2.ChairmansYoungerBrotherOnVacation)
    ctx.say(PacifidlogTown_House2.AhYourPokemon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PacifidlogTown_House2_Text_AdoringPokemonTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_TM_RETURN
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_FANCLUB_TM_THIS_WEEK
 * special SetPacifidlogTMReceivedDay
 * msgbox PacifidlogTown_House2_Text_ExplainReturnFrustration, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_GiveReturn : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_GiveReturn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetDaysUntilPacifidlogTMAvailable
 * buffernumberstring STR_VAR_1, VAR_RESULT
 * msgbox PacifidlogTown_House2_Text_GetGoodTMInXDays, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_ComeBackInXDays : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_ComeBackInXDays")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_RECEIVED_FANCLUB_TM_THIS_WEEK, Common_EventScript_NopReturn
 * specialvar VAR_RESULT, GetDaysUntilPacifidlogTMAvailable
 * call_if_eq VAR_RESULT, 0, PacifidlogTown_House2_EventScript_ClearReceivedFanClubTM
 * return
 * ```
 */
internal object PacifidlogTown_House2_EventScript_UpdateFanClubTMFlag : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_UpdateFanClubTMFlag")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PacifidlogTown_House2_Text_PutInSomeMoreEffort, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_PutInEffort : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PacifidlogTown_House2.PutInSomeMoreEffort)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PacifidlogTown_House2_Text_ViciousPokemonTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_TM_FRUSTRATION
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_FANCLUB_TM_THIS_WEEK
 * special SetPacifidlogTMReceivedDay
 * msgbox PacifidlogTown_House2_Text_ExplainReturnFrustration, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House2_EventScript_GiveFrustration : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PacifidlogTown_House2_EventScript_GiveFrustration")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PacifidlogTown_House2_Text_AhYourPokemon, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object PacifidlogTown_House2_EventScript_MonAssessment : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PacifidlogTown_House2.AhYourPokemon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * clearflag FLAG_RECEIVED_FANCLUB_TM_THIS_WEEK
 * return
 * ```
 */
internal object PacifidlogTown_House2_EventScript_ClearReceivedFanClubTM : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.clearFlag(HoennFlags.FLAG_RECEIVED_FANCLUB_TM_THIS_WEEK)
  }
}

internal val PacifidlogTown_House2Scripts: Map<String, Script> =
    mapOf(
        "PacifidlogTown_House2_EventScript_FanClubYoungerBrother" to
            PacifidlogTown_House2_EventScript_FanClubYoungerBrother,
        "PacifidlogTown_House2_EventScript_HappyAzurill" to
            PacifidlogTown_House2_EventScript_HappyAzurill,
        "PacifidlogTown_House2_EventScript_UnhappyAzurill" to
            PacifidlogTown_House2_EventScript_UnhappyAzurill,
        "PacifidlogTown_House2_EventScript_FirstMonAssessment" to
            PacifidlogTown_House2_EventScript_FirstMonAssessment,
        "PacifidlogTown_House2_EventScript_GiveReturn" to
            PacifidlogTown_House2_EventScript_GiveReturn,
        "PacifidlogTown_House2_EventScript_ComeBackInXDays" to
            PacifidlogTown_House2_EventScript_ComeBackInXDays,
        "PacifidlogTown_House2_EventScript_UpdateFanClubTMFlag" to
            PacifidlogTown_House2_EventScript_UpdateFanClubTMFlag,
        "PacifidlogTown_House2_EventScript_PutInEffort" to
            PacifidlogTown_House2_EventScript_PutInEffort,
        "PacifidlogTown_House2_EventScript_GiveFrustration" to
            PacifidlogTown_House2_EventScript_GiveFrustration,
        "PacifidlogTown_House2_EventScript_MonAssessment" to
            PacifidlogTown_House2_EventScript_MonAssessment,
        "PacifidlogTown_House2_EventScript_ClearReceivedFanClubTM" to
            PacifidlogTown_House2_EventScript_ClearReceivedFanClubTM,
    )
