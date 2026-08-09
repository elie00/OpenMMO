package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.LittlerootTown_ProfessorBirchsLab
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_LEFT
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_DOWN
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_UP
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

private const val LOCALID_BIRCH = 1
private const val LOCALID_RIVAL = 2
private const val TREECKO = 252
private val HOENN_STARTERS = listOf(TREECKO, 255, 258)

internal object LittlerootTown_ProfessorBirchsLab_OnTransition : Script {
  override suspend fun run(ctx: ScriptContext) = Unit
}

internal object LittlerootTown_ProfessorBirchsLab_EventScript_GiveStarterEvent : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_BIRCH_LAB_STATE) != 2) return
    val starter = HOENN_STARTERS.getOrElse(ctx.getVar(HoennVars.VAR_STARTER_MON)) { TREECKO }
    ctx.sayNpcWithSpeciesName(
        LOCALID_BIRCH,
        LittlerootTown_ProfessorBirchsLab.LikeYouToHavePokemon,
        starter,
    )

    // The captured client skips the nickname screen.
    var agreed =
        ctx.askYesNoNpc(
            LOCALID_BIRCH,
            LittlerootTown_ProfessorBirchsLab.MightBeGoodIdeaToGoSeeRival,
        )
    while (!agreed) {
      agreed =
          ctx.askYesNoNpc(
              LOCALID_BIRCH,
              LittlerootTown_ProfessorBirchsLab.DontBeThatWay,
          )
    }
    ctx.sayNpc(LOCALID_BIRCH, LittlerootTown_ProfessorBirchsLab.GetRivalToTeachYou)
    ctx.clearFlag(HoennFlags.FLAG_HIDE_ROUTE_101_BOY)
    ctx.setVar(HoennVars.VAR_BIRCH_LAB_STATE, 3)
  }
}

internal object LittlerootTown_ProfessorBirchsLab_EventScript_GivePokedexEvent : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_BIRCH_LAB_STATE) != 4) return
    repeat(7) { ctx.moveSelf(WALK_UP) }
    ctx.sayNpc(LOCALID_BIRCH, LittlerootTown_ProfessorBirchsLab.HeardYouBeatRivalTakePokedex)
    ctx.sayNpc(LOCALID_BIRCH, LittlerootTown_ProfessorBirchsLab.ReceivedPokedex)
    ctx.setFlag(HoennFlags.FLAG_SYS_POKEDEX_GET)
    ctx.setFlag(HoennFlags.FLAG_RECEIVED_POKEDEX_FROM_BIRCH)
    ctx.sayNpc(LOCALID_BIRCH, LittlerootTown_ProfessorBirchsLab.ExplainPokedex)
    ctx.moveNpc(LOCALID_RIVAL, WALK_DOWN, FACE_LEFT)
    ctx.moveSelf(FACE_RIGHT)
    if (ctx.isFemale) {
      ctx.sayNpc(
          LOCALID_RIVAL,
          LittlerootTown_ProfessorBirchsLab.BrendanGotPokedexTooTakeThese,
      )
    } else {
      ctx.sayNpc(LOCALID_RIVAL, LittlerootTown_ProfessorBirchsLab.MayGotPokedexTooTakeThese)
    }
    ctx.giveItem(Items.POKE_BALL, 5)
    if (ctx.isFemale) {
      ctx.sayNpc(LOCALID_RIVAL, LittlerootTown_ProfessorBirchsLab.CatchCoolPokemonWithPokeBalls)
    } else {
      ctx.sayNpc(LOCALID_RIVAL, LittlerootTown_ProfessorBirchsLab.CatchCutePokemonWithPokeBalls)
    }
    ctx.setVar(HoennVars.VAR_BIRCH_LAB_STATE, 5)
    ctx.setFlag(HoennFlags.FLAG_ADVENTURE_STARTED)
    ctx.setVar(HoennVars.VAR_OLDALE_TOWN_STATE, 1)
    ctx.setVar(HoennVars.VAR_LITTLEROOT_RIVAL_STATE, 4)
    ctx.setVar(HoennVars.VAR_LITTLEROOT_TOWN_STATE, 3)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_BIRCH_LAB_STATE, 3, LittlerootTown_ProfessorBirchsLab_EventScript_AideReceivedStarter
 * goto_if_set FLAG_BIRCH_AIDE_MET, LittlerootTown_ProfessorBirchsLab_EventScript_AideAlreadyMet
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_BirchAwayOnFieldwork, MSGBOX_DEFAULT
 * setflag FLAG_BIRCH_AIDE_MET
 * release
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_Aide : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_BIRCH_LAB_STATE) >= 3) {
      ctx.say(LittlerootTown_ProfessorBirchsLab.BirchEnjoysRivalsHelpToo)
    } else if (ctx.isFlagSet(HoennFlags.FLAG_BIRCH_AIDE_MET)) {
      ctx.say(LittlerootTown_ProfessorBirchsLab.BirchIsntOneForDeskWork)
    } else {
      ctx.say(LittlerootTown_ProfessorBirchsLab.BirchAwayOnFieldwork)
      ctx.setFlag(HoennFlags.FLAG_BIRCH_AIDE_MET)
    }
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 5, LittlerootTown_ProfessorBirchsLab_EventScript_CanHaveAnyOneOfRarePokemon
 * goto_if_eq VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 2, LittlerootTown_ProfessorBirchsLab_EventScript_GrassyPatchWaiting
 * goto_if_unset FLAG_HAS_MATCH_CALL, LittlerootTown_ProfessorBirchsLab_EventScript_TryRatePokedexOrRegister
 * goto_if_unset FLAG_ENABLE_PROF_BIRCH_MATCH_CALL, EventScript_RegisterProfBirch
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_TryRatePokedexOrRegister
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_Birch : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.getVar(HoennVars.VAR_BIRCH_LAB_STATE) >= 5) {
      ctx.say(LittlerootTown_ProfessorBirchsLab.CountlessPokemonAwait)
    } else {
      ctx.say(LittlerootTown_ProfessorBirchsLab.BirchRivalGoneHome)
    }
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 5, LittlerootTown_ProfessorBirchsLab_EventScript_RivalFuturePlans
 * goto_if_ge VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6, LittlerootTown_ProfessorBirchsLab_EventScript_RivalHaveYouGoneToBattleFrontier
 * goto_if_ge VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 2, LittlerootTown_ProfessorBirchsLab_EventScript_RivalTakeBreakFromFieldwork
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, LittlerootTown_ProfessorBirchsLab_EventScript_MayWhereShouldIGoNext
 * call_if_eq VAR_RESULT, FEMALE, LittlerootTown_ProfessorBirchsLab_EventScript_BrendanWhereShouldIGoNext
 * release
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_Rival : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_Rival")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * goto_if_ge VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6, LittlerootTown_ProfessorBirchsLab_EventScript_AlreadyChoseJohtoStarter
 * applymovement LOCALID_BIRCHS_LAB_BIRCH, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * showmonpic SPECIES_CYNDAQUIL, 10, 3
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_YoullTakeCyndaquil, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_GiveCyndaquil
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_Cyndaquil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_Cyndaquil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * goto_if_ge VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6, LittlerootTown_ProfessorBirchsLab_EventScript_AlreadyChoseJohtoStarter
 * applymovement LOCALID_BIRCHS_LAB_BIRCH, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * showmonpic SPECIES_TOTODILE, 10, 3
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_YoullTakeTotodile, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_GiveTotodile
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_Totodile : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_Totodile")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * goto_if_ge VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6, LittlerootTown_ProfessorBirchsLab_EventScript_AlreadyChoseJohtoStarter
 * applymovement LOCALID_BIRCHS_LAB_BIRCH, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * showmonpic SPECIES_CHIKORITA, 10, 3
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_YoullTakeChikorita, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_GiveChikorita
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_Chikorita : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_Chikorita")
}

internal object LittlerootTown_ProfessorBirchsLab_EventScript_Machine : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LittlerootTown_ProfessorBirchsLab.SeriousLookingMachine)
}

internal object LittlerootTown_ProfessorBirchsLab_EventScript_Book : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LittlerootTown_ProfessorBirchsLab.BookTooHardToRead)
}

internal object LittlerootTown_ProfessorBirchsLab_EventScript_Bookshelf : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LittlerootTown_ProfessorBirchsLab.CrammedWithBooksOnPokemon)
}

internal object LittlerootTown_ProfessorBirchsLab_EventScript_PC : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(LittlerootTown_ProfessorBirchsLab.PCUsedForResearch)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, SPECIES_CHIKORITA
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_CHIKORITA
 * givemon SPECIES_CHIKORITA, 5
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToPC
 * hidemonpic
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_GiveChikorita : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_GiveChikorita")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemonpic
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_TakeYourTimeAllInvaluable, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, SPECIES_TOTODILE
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_TOTODILE
 * givemon SPECIES_TOTODILE, 5
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToPC
 * hidemonpic
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_GiveTotodile : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_GiveTotodile")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, LittlerootTown_ProfessorBirchsLab_EventScript_MayTakeBreakFromFieldwork
 * call_if_eq VAR_RESULT, FEMALE, LittlerootTown_ProfessorBirchsLab_EventScript_BrendanTakeBreakFromFieldwork
 * release
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_RivalTakeBreakFromFieldwork : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_RivalTakeBreakFromFieldwork")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_BetterLeaveOthersAlone, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_AlreadyChoseJohtoStarter : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.BetterLeaveOthersAlone)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_MayWhereShouldIGoNext, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_MayWhereShouldIGoNext : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.MayWhereShouldIGoNext)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_BrendanWhereShouldIGoNext, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_BrendanWhereShouldIGoNext : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.BrendanWhereShouldIGoNext)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, LittlerootTown_ProfessorBirchsLab_EventScript_MayHaveYouGoneToBattleFrontier
 * call_if_eq VAR_RESULT, FEMALE, LittlerootTown_ProfessorBirchsLab_EventScript_BrendanHaveYouGoneToBattleFrontier
 * release
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_RivalHaveYouGoneToBattleFrontier :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_RivalHaveYouGoneToBattleFrontier")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_1, SPECIES_CYNDAQUIL
 * setvar VAR_TEMP_TRANSFERRED_SPECIES, SPECIES_CYNDAQUIL
 * givemon SPECIES_CYNDAQUIL, 5
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PARTY, LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToParty
 * goto_if_eq VAR_RESULT, MON_GIVEN_TO_PC, LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToPC
 * hidemonpic
 * goto Common_EventScript_NoMoreRoomForPokemon
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_GiveCyndaquil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_GiveCyndaquil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, LittlerootTown_ProfessorBirchsLab_EventScript_MayWhatNextImStayingHere
 * call_if_eq VAR_RESULT, FEMALE, LittlerootTown_ProfessorBirchsLab_EventScript_BrendanPreferCollectingSlowly
 * release
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_RivalFuturePlans : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_RivalFuturePlans")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter
 * removeobject LOCALID_BIRCHS_LAB_TOTODILE_BALL
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_TotodileTransferredToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_TotodileTransferredToPC
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToPC")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_BrendanHaveYouGoneToBattleFrontier, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_BrendanHaveYouGoneToBattleFrontier :
    Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.BrendanHaveYouGoneToBattleFrontier)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_MayTakeBreakFromFieldwork, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_MayTakeBreakFromFieldwork : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.MayTakeBreakFromFieldwork)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_MayWhatNextImStayingHere, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_MayWhatNextImStayingHere : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.MayWhatNextImStayingHere)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter
 * removeobject LOCALID_BIRCHS_LAB_CHIKORITA_BALL
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_ChikoritaTransferredToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ChikoritaTransferredToPC
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox gText_NoMoreRoomForPokemon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Common_EventScript_NoMoreRoomForPokemon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Common_EventScript_NoMoreRoomForPokemon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter
 * removeobject LOCALID_BIRCHS_LAB_CYNDAQUIL_BALL
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToParty")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_MayHaveYouGoneToBattleFrontier, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_MayHaveYouGoneToBattleFrontier :
    Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.MayHaveYouGoneToBattleFrontier)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_BrendanTakeBreakFromFieldwork, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_BrendanTakeBreakFromFieldwork :
    Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LittlerootTown_ProfessorBirchsLab.BrendanTakeBreakFromFieldwork)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter
 * removeobject LOCALID_BIRCHS_LAB_TOTODILE_BALL
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter
 * removeobject LOCALID_BIRCHS_LAB_CHIKORITA_BALL
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita
 * call Common_EventScript_GetGiftMonPartySlot
 * call Common_EventScript_NameReceivedPartyMon
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToParty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToParty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter
 * removeobject LOCALID_BIRCHS_LAB_CYNDAQUIL_BALL
 * msgbox gText_NicknameThisPokemon, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, LittlerootTown_ProfessorBirchsLab_EventScript_CyndaquilTransferredToPC
 * call Common_EventScript_NameReceivedBoxMon
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_CyndaquilTransferredToPC
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToPC : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemonpic
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_GrassyPatchWaiting, MSGBOX_DEFAULT
 * setvar VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6
 * releaseall
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemonpic
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_GrassyPatchWaiting, MSGBOX_DEFAULT
 * setvar VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6
 * releaseall
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playfanfare MUS_OBTAIN_ITEM
 * message LittlerootTown_ProfessorBirchsLab_Text_ReceivedJohtoStarter
 * waitmessage
 * waitfanfare
 * return
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemonpic
 * msgbox LittlerootTown_ProfessorBirchsLab_Text_GrassyPatchWaiting, MSGBOX_DEFAULT
 * setvar VAR_DEX_UPGRADE_JOHTO_STARTER_STATE, 6
 * releaseall
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil")
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_ChikoritaTransferredToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_TotodileTransferredToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * fadescreen FADE_TO_BLACK
 * special ChangeBoxPokemonNickname
 * lock
 * faceplayer
 * return
 * ```
 */
internal object Common_EventScript_NameReceivedBoxMon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_NameReceivedBoxMon")
}

/**
 * Ported from the decomp:
 * ```
 * call Common_EventScript_TransferredToPC
 * goto LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil
 * end
 * ```
 */
internal object LittlerootTown_ProfessorBirchsLab_EventScript_CyndaquilTransferredToPC : Script {
  override suspend fun run(ctx: ScriptContext) {
    Common_EventScript_TransferredToPC.run(ctx)
    return LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * getpartysize
 * subvar VAR_RESULT, 1
 * copyvar VAR_0x8004, VAR_RESULT
 * return
 * ```
 */
internal object Common_EventScript_GetGiftMonPartySlot : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_GetGiftMonPartySlot")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferboxname STR_VAR_1, VAR_PC_BOX_TO_SEND_MON
 * bufferspeciesname STR_VAR_2, VAR_TEMP_TRANSFERRED_SPECIES
 * call_if_unset FLAG_SYS_PC_LANETTE, EventScript_TransferredSomeonesPC
 * call_if_set FLAG_SYS_PC_LANETTE, EventScript_TransferredLanettesPC
 * return
 * ```
 */
internal object Common_EventScript_TransferredToPC : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_TransferredToPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ShouldShowBoxWasFullMessage
 * goto_if_eq VAR_RESULT, TRUE, EventScript_LanettesPCBoxFull
 * msgbox gText_PkmnTransferredLanettesPC, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object EventScript_TransferredLanettesPC : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_TransferredLanettesPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ShouldShowBoxWasFullMessage
 * goto_if_eq VAR_RESULT, TRUE, EventScript_SomeonesPCBoxFull
 * msgbox gText_PkmnTransferredSomeonesPC, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object EventScript_TransferredSomeonesPC : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_TransferredSomeonesPC")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetPCBoxToSendMon
 * bufferboxname STR_VAR_3, VAR_RESULT
 * msgbox gText_PkmnTransferredLanettesPCBoxFull, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object EventScript_LanettesPCBoxFull : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_LanettesPCBoxFull")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, GetPCBoxToSendMon
 * bufferboxname STR_VAR_3, VAR_RESULT
 * msgbox gText_PkmnTransferredSomeonesPCBoxFull, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object EventScript_SomeonesPCBoxFull : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SomeonesPCBoxFull")
}

internal val LittlerootTown_ProfessorBirchsLabScripts: Map<String, Script> =
    mapOf(
        "LittlerootTown_ProfessorBirchsLab_OnTransition" to
            LittlerootTown_ProfessorBirchsLab_OnTransition,
        "LittlerootTown_ProfessorBirchsLab_EventScript_GiveStarterEvent" to
            LittlerootTown_ProfessorBirchsLab_EventScript_GiveStarterEvent,
        "LittlerootTown_ProfessorBirchsLab_EventScript_GivePokedexEvent" to
            LittlerootTown_ProfessorBirchsLab_EventScript_GivePokedexEvent,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Aide" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Aide,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Birch" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Birch,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Rival" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Rival,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Cyndaquil" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Cyndaquil,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Totodile" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Totodile,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Chikorita" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Chikorita,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Machine" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Machine,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Book" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Book,
        "LittlerootTown_ProfessorBirchsLab_EventScript_Bookshelf" to
            LittlerootTown_ProfessorBirchsLab_EventScript_Bookshelf,
        "LittlerootTown_ProfessorBirchsLab_EventScript_PC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_PC,
        "LittlerootTown_ProfessorBirchsLab_EventScript_GiveChikorita" to
            LittlerootTown_ProfessorBirchsLab_EventScript_GiveChikorita,
        "LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime" to
            LittlerootTown_ProfessorBirchsLab_EventScript_TakeYourTime,
        "LittlerootTown_ProfessorBirchsLab_EventScript_GiveTotodile" to
            LittlerootTown_ProfessorBirchsLab_EventScript_GiveTotodile,
        "LittlerootTown_ProfessorBirchsLab_EventScript_RivalTakeBreakFromFieldwork" to
            LittlerootTown_ProfessorBirchsLab_EventScript_RivalTakeBreakFromFieldwork,
        "LittlerootTown_ProfessorBirchsLab_EventScript_AlreadyChoseJohtoStarter" to
            LittlerootTown_ProfessorBirchsLab_EventScript_AlreadyChoseJohtoStarter,
        "LittlerootTown_ProfessorBirchsLab_EventScript_MayWhereShouldIGoNext" to
            LittlerootTown_ProfessorBirchsLab_EventScript_MayWhereShouldIGoNext,
        "LittlerootTown_ProfessorBirchsLab_EventScript_BrendanWhereShouldIGoNext" to
            LittlerootTown_ProfessorBirchsLab_EventScript_BrendanWhereShouldIGoNext,
        "LittlerootTown_ProfessorBirchsLab_EventScript_RivalHaveYouGoneToBattleFrontier" to
            LittlerootTown_ProfessorBirchsLab_EventScript_RivalHaveYouGoneToBattleFrontier,
        "LittlerootTown_ProfessorBirchsLab_EventScript_GiveCyndaquil" to
            LittlerootTown_ProfessorBirchsLab_EventScript_GiveCyndaquil,
        "LittlerootTown_ProfessorBirchsLab_EventScript_RivalFuturePlans" to
            LittlerootTown_ProfessorBirchsLab_EventScript_RivalFuturePlans,
        "LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToPC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToPC,
        "LittlerootTown_ProfessorBirchsLab_EventScript_BrendanHaveYouGoneToBattleFrontier" to
            LittlerootTown_ProfessorBirchsLab_EventScript_BrendanHaveYouGoneToBattleFrontier,
        "LittlerootTown_ProfessorBirchsLab_EventScript_MayTakeBreakFromFieldwork" to
            LittlerootTown_ProfessorBirchsLab_EventScript_MayTakeBreakFromFieldwork,
        "LittlerootTown_ProfessorBirchsLab_EventScript_MayWhatNextImStayingHere" to
            LittlerootTown_ProfessorBirchsLab_EventScript_MayWhatNextImStayingHere,
        "LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToPC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToPC,
        "Common_EventScript_NoMoreRoomForPokemon" to Common_EventScript_NoMoreRoomForPokemon,
        "LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToParty" to
            LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToParty,
        "LittlerootTown_ProfessorBirchsLab_EventScript_MayHaveYouGoneToBattleFrontier" to
            LittlerootTown_ProfessorBirchsLab_EventScript_MayHaveYouGoneToBattleFrontier,
        "LittlerootTown_ProfessorBirchsLab_EventScript_BrendanTakeBreakFromFieldwork" to
            LittlerootTown_ProfessorBirchsLab_EventScript_BrendanTakeBreakFromFieldwork,
        "LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToParty" to
            LittlerootTown_ProfessorBirchsLab_EventScript_SendTotodileToParty,
        "LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToParty" to
            LittlerootTown_ProfessorBirchsLab_EventScript_SendChikoritaToParty,
        "LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToPC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_SendCyndaquilToPC,
        "LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile" to
            LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedTotodile,
        "LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita" to
            LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedChikorita,
        "LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter" to
            LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedJohtoStarter,
        "LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil" to
            LittlerootTown_ProfessorBirchsLab_EventScript_ReceivedCyndaquil,
        "LittlerootTown_ProfessorBirchsLab_EventScript_ChikoritaTransferredToPC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_ChikoritaTransferredToPC,
        "LittlerootTown_ProfessorBirchsLab_EventScript_TotodileTransferredToPC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_TotodileTransferredToPC,
        "Common_EventScript_NameReceivedBoxMon" to Common_EventScript_NameReceivedBoxMon,
        "LittlerootTown_ProfessorBirchsLab_EventScript_CyndaquilTransferredToPC" to
            LittlerootTown_ProfessorBirchsLab_EventScript_CyndaquilTransferredToPC,
        "Common_EventScript_GetGiftMonPartySlot" to Common_EventScript_GetGiftMonPartySlot,
        "Common_EventScript_TransferredToPC" to Common_EventScript_TransferredToPC,
        "EventScript_TransferredLanettesPC" to EventScript_TransferredLanettesPC,
        "EventScript_TransferredSomeonesPC" to EventScript_TransferredSomeonesPC,
        "EventScript_LanettesPCBoxFull" to EventScript_LanettesPCBoxFull,
        "EventScript_SomeonesPCBoxFull" to EventScript_SomeonesPCBoxFull,
    )
