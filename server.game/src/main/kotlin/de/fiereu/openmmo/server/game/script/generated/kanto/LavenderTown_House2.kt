package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.LavenderTown_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox LavenderTown_House2_Text_WantMeToRateNicknames, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, LavenderTown_House2_EventScript_ChooseMon
 * goto_if_eq VAR_RESULT, NO, LavenderTown_House2_EventScript_DontRateNickname
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_NameRater : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavenderTown_House2_EventScript_NameRater")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LavenderTown_House2_Text_CritiqueWhichMonsNickname
 * special ChoosePartyMon
 * waitstate
 * goto_if_lt VAR_0x8004, PARTY_SIZE, LavenderTown_House2_EventScript_CheckCanRateMon
 * goto_if_ge VAR_0x8004, PARTY_SIZE, LavenderTown_House2_EventScript_DontRateNickname
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_ChooseMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavenderTown_House2_EventScript_ChooseMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LavenderTown_House2_Text_ISeeComeVisitAgain
 * release
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_DontRateNickname : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LavenderTown_House2.ISeeComeVisitAgain)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetPartyMonSpecies
 * goto_if_eq VAR_RESULT, SPECIES_EGG, LavenderTown_House2_EventScript_CantNicknameEgg
 * special BufferMonNickname
 * special IsMonOTIDNotPlayers
 * goto_if_eq VAR_RESULT, TRUE, LavenderTown_House2_EventScript_CantNicknameTradeMon
 * specialvar VAR_RESULT, IsMonOTNameNotPlayers
 * special BufferMonNickname
 * goto_if_eq VAR_RESULT, TRUE, LavenderTown_House2_EventScript_CantNicknameTradeMon
 * msgbox LavenderTown_House2_Text_GiveItANicerName, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, LavenderTown_House2_EventScript_ChooseNewNickname
 * goto_if_eq VAR_RESULT, NO, LavenderTown_House2_EventScript_DontRateNickname
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_CheckCanRateMon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavenderTown_House2_EventScript_CheckCanRateMon")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LavenderTown_House2_Text_TrulyImpeccableName
 * release
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_CantNicknameTradeMon : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LavenderTown_House2.TrulyImpeccableName)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LavenderTown_House2_Text_ThatIsMerelyAnEgg
 * release
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_CantNicknameEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LavenderTown_House2.ThatIsMerelyAnEgg)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LavenderTown_House2_Text_WhatShallNewNicknameBe
 * call EventScript_ChangePokemonNickname
 * specialvar VAR_RESULT, NameRaterWasNicknameChanged
 * special BufferMonNickname
 * goto_if_eq VAR_RESULT, TRUE, LavenderTown_House2_EventScript_ChoseNewNickname
 * msgbox LavenderTown_House2_Text_FromNowOnShallBeKnownAsSameName
 * release
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_ChooseNewNickname : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavenderTown_House2_EventScript_ChooseNewNickname")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LavenderTown_House2_Text_FromNowOnShallBeKnownAsName
 * release
 * end
 * ```
 */
internal object LavenderTown_House2_EventScript_ChoseNewNickname : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LavenderTown_House2.FromNowOnShallBeKnownAsName)
  }
}

internal val LavenderTown_House2Scripts: Map<String, Script> =
    mapOf(
        "LavenderTown_House2_EventScript_NameRater" to LavenderTown_House2_EventScript_NameRater,
        "LavenderTown_House2_EventScript_ChooseMon" to LavenderTown_House2_EventScript_ChooseMon,
        "LavenderTown_House2_EventScript_DontRateNickname" to
            LavenderTown_House2_EventScript_DontRateNickname,
        "LavenderTown_House2_EventScript_CheckCanRateMon" to
            LavenderTown_House2_EventScript_CheckCanRateMon,
        "LavenderTown_House2_EventScript_CantNicknameTradeMon" to
            LavenderTown_House2_EventScript_CantNicknameTradeMon,
        "LavenderTown_House2_EventScript_CantNicknameEgg" to
            LavenderTown_House2_EventScript_CantNicknameEgg,
        "LavenderTown_House2_EventScript_ChooseNewNickname" to
            LavenderTown_House2_EventScript_ChooseNewNickname,
        "LavenderTown_House2_EventScript_ChoseNewNickname" to
            LavenderTown_House2_EventScript_ChoseNewNickname,
    )
