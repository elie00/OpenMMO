package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FiveIsland_WaterLabyrinth
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_TOGEPI_EGG, FiveIsland_WaterLabyrinth_EventScript_PostEggComment
 * goto_if_set FLAG_NO_ROOM_FOR_TOGEPI_EGG, FiveIsland_WaterLabyrinth_EventScript_ReturnForEgg
 * msgbox FiveIsland_WaterLabyrinth_Text_LetMeTakeLookAtMons
 * specialvar VAR_RESULT, GetLeadMonFriendship
 * goto_if_eq VAR_RESULT, 6, FiveIsland_WaterLabyrinth_EventScript_LeadMonMaxFriendship
 * msgbox FiveIsland_WaterLabyrinth_Text_HmmISeeIsee
 * release
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_EggGentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_WaterLabyrinth_EventScript_EggGentleman")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PKMN_BREEDER_ALIZE, FiveIsland_WaterLabyrinth_Text_AlizeIntro, FiveIsland_WaterLabyrinth_Text_AlizeDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_WaterLabyrinth_EventScript_AlizeRematch
 * msgbox FiveIsland_WaterLabyrinth_Text_AlizePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_Alize : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PKMN_BREEDER_ALIZE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (FiveIsland_WaterLabyrinth_EventScript_AlizeRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(FiveIsland_WaterLabyrinth.AlizePostBattle)
    }
    ctx.say(FiveIsland_WaterLabyrinth.AlizeIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_WaterLabyrinth.AlizeDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * goto FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_ReturnForEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    return FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferspeciesname STR_VAR_2, SPECIES_TOGEPI
 * setvar VAR_0x8004, SPECIES_TOGEPI
 * specialvar VAR_RESULT, PlayerPartyContainsSpeciesWithPlayerID
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_WaterLabyrinth_EventScript_MonDaisyComment
 * bufferspeciesname STR_VAR_2, SPECIES_TOGETIC
 * setvar VAR_0x8004, SPECIES_TOGETIC
 * specialvar VAR_RESULT, PlayerPartyContainsSpeciesWithPlayerID
 * goto_if_eq VAR_RESULT, TRUE, FiveIsland_WaterLabyrinth_EventScript_MonDaisyComment
 * msgbox FiveIsland_WaterLabyrinth_Text_GladIMetSomeoneLikeYou
 * release
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_PostEggComment : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_WaterLabyrinth_EventScript_PostEggComment")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FiveIsland_WaterLabyrinth_Text_TreatMonRightHaveThis
 * goto FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_LeadMonMaxFriendship : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FiveIsland_WaterLabyrinth.TreatMonRightHaveThis)
    return FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * getpartysize
 * goto_if_eq VAR_RESULT, PARTY_SIZE, FiveIsland_WaterLabyrinth_EventScript_NoRoomForEgg
 * setflag FLAG_GOT_TOGEPI_EGG
 * giveegg SPECIES_TOGEPI
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_LEVEL_UP
 * message FiveIsland_WaterLabyrinth_Text_ReceivedEggFromMan
 * waitfanfare
 * waitmessage
 * call EventScript_RestorePrevTextColor
 * goto FiveIsland_WaterLabyrinth_EventScript_PostEggComment
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_DAISY, 2
 * msgbox FiveIsland_WaterLabyrinth_Text_CuteMonRemindsMeOfDaisy
 * release
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_MonDaisyComment : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_WaterLabyrinth_EventScript_MonDaisyComment")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_NO_ROOM_FOR_TOGEPI_EGG
 * msgbox FiveIsland_WaterLabyrinth_Text_DontHaveSpaceInYourParty
 * release
 * end
 * ```
 */
internal object FiveIsland_WaterLabyrinth_EventScript_NoRoomForEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_NO_ROOM_FOR_TOGEPI_EGG)
    ctx.say(FiveIsland_WaterLabyrinth.DontHaveSpaceInYourParty)
  }
}

internal val FiveIsland_WaterLabyrinthScripts: Map<String, Script> =
    mapOf(
        "FiveIsland_WaterLabyrinth_EventScript_EggGentleman" to
            FiveIsland_WaterLabyrinth_EventScript_EggGentleman,
        "FiveIsland_WaterLabyrinth_EventScript_Alize" to
            FiveIsland_WaterLabyrinth_EventScript_Alize,
        "FiveIsland_WaterLabyrinth_EventScript_ReturnForEgg" to
            FiveIsland_WaterLabyrinth_EventScript_ReturnForEgg,
        "FiveIsland_WaterLabyrinth_EventScript_PostEggComment" to
            FiveIsland_WaterLabyrinth_EventScript_PostEggComment,
        "FiveIsland_WaterLabyrinth_EventScript_LeadMonMaxFriendship" to
            FiveIsland_WaterLabyrinth_EventScript_LeadMonMaxFriendship,
        "FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg" to
            FiveIsland_WaterLabyrinth_EventScript_TryGiveEgg,
        "FiveIsland_WaterLabyrinth_EventScript_MonDaisyComment" to
            FiveIsland_WaterLabyrinth_EventScript_MonDaisyComment,
        "FiveIsland_WaterLabyrinth_EventScript_NoRoomForEgg" to
            FiveIsland_WaterLabyrinth_EventScript_NoRoomForEgg,
    )
