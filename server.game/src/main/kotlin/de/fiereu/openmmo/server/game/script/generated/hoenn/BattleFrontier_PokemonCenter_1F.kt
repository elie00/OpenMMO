package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x800B, LOCALID_FRONTIER_NURSE
 * call Common_EventScript_PkmnCenterNurse
 * waitmessage
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object BattleFrontier_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_PokemonCenter_1F_EventScript_Nurse")
}

internal object BattleFrontier_PokemonCenter_1F_EventScript_SchoolKid : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_PokemonCenter_1F.NeverSeenPokemon)
}

internal object BattleFrontier_PokemonCenter_1F_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_PokemonCenter_1F.NextStopBattleArena)
}

internal object BattleFrontier_PokemonCenter_1F_EventScript_Picnicker : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_PokemonCenter_1F.GoingThroughEveryChallenge)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_SKITTY, CRY_MODE_NORMAL
 * msgbox BattleFrontier_PokemonCenter_1F_Text_Skitty, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object BattleFrontier_PokemonCenter_1F_EventScript_Skitty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_PokemonCenter_1F_EventScript_Skitty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, 0
 * specialvar VAR_RESULT, CountPlayerTrainerStars
 * goto_if_eq VAR_RESULT, 4, EventScript_PkmnCenterNurse_GoldCard
 * msgbox gText_WouldYouLikeToRestYourPkmn, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, EventScript_PkmnCenterNurse_HealPkmn
 * goto_if_eq VAR_RESULT, NO, EventScript_PkmnCenterNurse_Goodbye
 * end
 * ```
 */
internal object Common_EventScript_PkmnCenterNurse : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_PkmnCenterNurse")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message gText_WeHopeToSeeYouAgain
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_Goodbye : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_PkmnCenterNurse_Goodbye")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_NURSE_MENTIONS_GOLD_CARD, EventScript_PkmnCenterNurse_AskForUsual
 * setflag FLAG_NURSE_MENTIONS_GOLD_CARD
 * msgbox gText_WelcomeCutShort, MSGBOX_DEFAULT
 * playse SE_PIN
 * applymovement VAR_0x800B, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement VAR_0x800B, Common_Movement_Delay48
 * waitmovement 0
 * msgbox gText_NoticesGoldCard, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, EventScript_PkmnCenterNurse_GoldCardHealPkmn
 * message gText_WeHopeToSeeYouAgain2
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_GoldCard : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_PkmnCenterNurse_GoldCard")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * incrementgamestat GAME_STAT_USED_POKECENTER
 * call_if_eq VAR_0x8004, 0, EventScript_PkmnCenterNurse_IllTakeYourPkmn
 * call_if_eq VAR_0x8004, 1, EventScript_PkmnCenterNurse_IllTakeYourPkmn2
 * waitmessage
 * call EventScript_PkmnCenterNurse_TakeAndHealPkmn
 * goto_if_unset FLAG_POKERUS_EXPLAINED, EventScript_PkmnCenterNurse_CheckPokerus
 * goto EventScript_PkmnCenterNurse_CheckTrainerHillAndUnionRoom
 * end
 * ```
 */
internal object EventScript_PkmnCenterNurse_HealPkmn : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_PkmnCenterNurse_HealPkmn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message gText_IllTakeYourPkmn2
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_IllTakeYourPkmn2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_IllTakeYourPkmn2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, PlayerNotAtTrainerHillEntrance
 * goto_if_eq VAR_RESULT, 0, EventScript_PkmnCenterNurse_ReturnPkmn
 * specialvar VAR_RESULT, BufferUnionRoomPlayerName
 * copyvar VAR_0x8008, VAR_RESULT
 * goto_if_eq VAR_0x8008, 0, EventScript_PkmnCenterNurse_ReturnPkmn
 * goto_if_eq VAR_0x8008, 1, EventScript_PkmnCenterNurse_PlayerWaitingInUnionRoom
 * end
 * ```
 */
internal object EventScript_PkmnCenterNurse_CheckTrainerHillAndUnionRoom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_CheckTrainerHillAndUnionRoom")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement VAR_0x800B, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * dofieldeffect FLDEFF_POKECENTER_HEAL
 * waitfieldeffect FLDEFF_POKECENTER_HEAL
 * applymovement VAR_0x800B, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * special HealPlayerParty
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_TakeAndHealPkmn : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_TakeAndHealPkmn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, IsPokerusInParty
 * goto_if_eq VAR_RESULT, TRUE, EventScript_PkmnCenterNurse_ExplainPokerus
 * goto_if_eq VAR_RESULT, FALSE, EventScript_PkmnCenterNurse_CheckTrainerHillAndUnionRoom
 * end
 * ```
 */
internal object EventScript_PkmnCenterNurse_CheckPokerus : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_CheckPokerus")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_0x8004, 1
 * goto EventScript_PkmnCenterNurse_HealPkmn
 * end
 * ```
 */
internal object EventScript_PkmnCenterNurse_GoldCardHealPkmn : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_0x8004, 1)
    return EventScript_PkmnCenterNurse_HealPkmn.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox gText_YouWantTheUsual, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, EventScript_PkmnCenterNurse_GoldCardHealPkmn
 * message gText_WeHopeToSeeYouAgain2
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_AskForUsual : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_AskForUsual")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message gText_IllTakeYourPkmn
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_IllTakeYourPkmn : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_IllTakeYourPkmn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_NURSE_UNION_ROOM_REMINDER, EventScript_PkmnCenterNurse_ReturnPkmn
 * msgbox gText_RestoredPkmnToFullHealth, MSGBOX_DEFAULT
 * setflag FLAG_NURSE_UNION_ROOM_REMINDER
 * message CableClub_Text_PlayerIsWaiting
 * waitmessage
 * applymovement VAR_0x800B, Movement_PkmnCenterNurse_Bow
 * waitmovement 0
 * message gText_WeHopeToSeeYouAgain
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_PlayerWaitingInUnionRoom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_PlayerWaitingInUnionRoom")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_0x8004, 1, EventScript_PkmnCenterNurse_ReturnPkmn2
 * message gText_RestoredPkmnToFullHealth
 * waitmessage
 * applymovement VAR_0x800B, Movement_PkmnCenterNurse_Bow
 * waitmovement 0
 * message gText_WeHopeToSeeYouAgain
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_ReturnPkmn : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_PkmnCenterNurse_ReturnPkmn")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message gText_PokerusExplanation
 * setflag FLAG_POKERUS_EXPLAINED
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_ExplainPokerus : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_ExplainPokerus")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message gText_ThankYouForWaiting
 * waitmessage
 * applymovement VAR_0x800B, Movement_PkmnCenterNurse_Bow
 * waitmovement 0
 * message gText_WeHopeToSeeYouAgain2
 * return
 * ```
 */
internal object EventScript_PkmnCenterNurse_ReturnPkmn2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EventScript_PkmnCenterNurse_ReturnPkmn2")
}

internal val BattleFrontier_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_PokemonCenter_1F_EventScript_Nurse" to
            BattleFrontier_PokemonCenter_1F_EventScript_Nurse,
        "BattleFrontier_PokemonCenter_1F_EventScript_SchoolKid" to
            BattleFrontier_PokemonCenter_1F_EventScript_SchoolKid,
        "BattleFrontier_PokemonCenter_1F_EventScript_Man" to
            BattleFrontier_PokemonCenter_1F_EventScript_Man,
        "BattleFrontier_PokemonCenter_1F_EventScript_Picnicker" to
            BattleFrontier_PokemonCenter_1F_EventScript_Picnicker,
        "BattleFrontier_PokemonCenter_1F_EventScript_Skitty" to
            BattleFrontier_PokemonCenter_1F_EventScript_Skitty,
        "Common_EventScript_PkmnCenterNurse" to Common_EventScript_PkmnCenterNurse,
        "EventScript_PkmnCenterNurse_Goodbye" to EventScript_PkmnCenterNurse_Goodbye,
        "EventScript_PkmnCenterNurse_GoldCard" to EventScript_PkmnCenterNurse_GoldCard,
        "EventScript_PkmnCenterNurse_HealPkmn" to EventScript_PkmnCenterNurse_HealPkmn,
        "EventScript_PkmnCenterNurse_IllTakeYourPkmn2" to
            EventScript_PkmnCenterNurse_IllTakeYourPkmn2,
        "EventScript_PkmnCenterNurse_CheckTrainerHillAndUnionRoom" to
            EventScript_PkmnCenterNurse_CheckTrainerHillAndUnionRoom,
        "EventScript_PkmnCenterNurse_TakeAndHealPkmn" to
            EventScript_PkmnCenterNurse_TakeAndHealPkmn,
        "EventScript_PkmnCenterNurse_CheckPokerus" to EventScript_PkmnCenterNurse_CheckPokerus,
        "EventScript_PkmnCenterNurse_GoldCardHealPkmn" to
            EventScript_PkmnCenterNurse_GoldCardHealPkmn,
        "EventScript_PkmnCenterNurse_AskForUsual" to EventScript_PkmnCenterNurse_AskForUsual,
        "EventScript_PkmnCenterNurse_IllTakeYourPkmn" to
            EventScript_PkmnCenterNurse_IllTakeYourPkmn,
        "EventScript_PkmnCenterNurse_PlayerWaitingInUnionRoom" to
            EventScript_PkmnCenterNurse_PlayerWaitingInUnionRoom,
        "EventScript_PkmnCenterNurse_ReturnPkmn" to EventScript_PkmnCenterNurse_ReturnPkmn,
        "EventScript_PkmnCenterNurse_ExplainPokerus" to EventScript_PkmnCenterNurse_ExplainPokerus,
        "EventScript_PkmnCenterNurse_ReturnPkmn2" to EventScript_PkmnCenterNurse_ReturnPkmn2,
    )
