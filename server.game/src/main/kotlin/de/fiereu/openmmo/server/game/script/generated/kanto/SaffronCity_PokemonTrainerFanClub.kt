package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_PokemonTrainerFanClub
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER1
 * special Script_BufferFanClubTrainerName
 * goto_if_eq VAR_MAP_SCENE_SAFFRON_CITY_POKEMON_TRAINER_FAN_CLUB, 0, SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayerNotChampion
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_WasYourFanNotAnymore
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER4
 * special Script_BufferFanClubTrainerName
 * goto_if_eq VAR_MAP_SCENE_SAFFRON_CITY_POKEMON_TRAINER_FAN_CLUB, 0, SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_WantToBeLikeSabrina
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER2
 * special Script_BufferFanClubTrainerName
 * goto_if_eq VAR_MAP_SCENE_SAFFRON_CITY_POKEMON_TRAINER_FAN_CLUB, 0, SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayerNotChampion
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_BrocksMyHero
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_Youngster")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER3
 * special Script_BufferFanClubTrainerName
 * goto_if_eq VAR_MAP_SCENE_SAFFRON_CITY_POKEMON_TRAINER_FAN_CLUB, 0, SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayerNotChampion
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_HmmAndYouAre
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_Gentleman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER6
 * special Script_BufferFanClubTrainerName
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_TrainerHasBeenOnFire
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_Woman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER5
 * special Script_BufferFanClubTrainerName
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_RockerPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_LoveWayTrainerTalks
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_Rocker : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_Rocker")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER7
 * special Script_BufferFanClubTrainerName
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_BeautyPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_WhyCantOthersSeeMastersDignity
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_Beauty : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_Beauty")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_0x8004, FANCLUB_MEMBER8
 * special Script_BufferFanClubTrainerName
 * specialvar VAR_RESULT, Script_IsFanClubMemberFanOfPlayer
 * goto_if_eq VAR_RESULT, TRUE, SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltPlayersFan
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, (NUM_TRAINER_FAN_CLUB_MEMBERS - 1), SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyNonFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_OnlyMasterHasMyRespect
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BlackBelt : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_BlackBelt")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_BRUNO, 2
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PokemonJournal_Text_SpecialFeatureBruno
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_PokemonJournalBruno : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_PokemonJournalBruno")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_TheWayYouBattleIsCool
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_RockerPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_RockerPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_WontStopBeingSabrinasFan
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.WontStopBeingSabrinasFan)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_BelieveInMasterWithAllMyHeart
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.BelieveInMasterWithAllMyHeart)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_AdoreWayYouBattle
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_BrocksFanToBitterEnd
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.BrocksFanToBitterEnd)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_YoullBeTalkedAboutIfYouKeepWinning
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.YoullBeTalkedAboutIfYouKeepWinning)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_NeverBeFanOfAnyoneButMaster
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.NeverBeFanOfAnyoneButMaster)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_AlwaysCheerForYou
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_BrocksLastWordOnCool
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.BrocksLastWordOnCool)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_CanYouAutographShorts
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_YouveStillAWaysToGo
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.YouveStillAWaysToGo)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_ImLoneTrainerFan
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.ImLoneTrainerFan)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_CanIBecomeCoolTrainerOneDay
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.CanIBecomeCoolTrainerOneDay)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_YouReallyAreAmazing
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BeautyPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_BeautyPlayersFan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_WantToBeLikeYouOneDay
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_TrainersCoolWhenBattling
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayerNotChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.TrainersCoolWhenBattling)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_EveryoneTalksAboutYou
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.EveryoneTalksAboutYou)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_EveryonesYourFanButICantBe
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyNonFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.EveryonesYourFanButICantBe)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_HadPleasureOfWatchingYouBattle
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayersFan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, Script_GetNumFansOfPlayerInTrainerFanClub
 * goto_if_eq VAR_RESULT, 1, SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyFan
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_YourBattleStyleIsEducational
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltPlayersFan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltPlayersFan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_ImYourOnlyFan
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.ImYourOnlyFan)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_CountingOnYou
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.CountingOnYou)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_ImOnlyOneLeftOfYourFans
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.ImOnlyOneLeftOfYourFans)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_IllAlwaysBelieveInYou
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.IllAlwaysBelieveInYou)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_ImYourNumberOneFan
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.ImYourNumberOneFan)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_NeverSeenTrainerOfYourMagnificence
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.NeverSeenTrainerOfYourMagnificence)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_WontStopBeingYourFan
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.WontStopBeingYourFan)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_PokemonTrainerFanClub_Text_EveryoneButMeStoppedBeingYourFan
 * release
 * end
 * ```
 */
internal object SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_PokemonTrainerFanClub.EveryoneButMeStoppedBeingYourFan)
  }
}

internal val SaffronCity_PokemonTrainerFanClubScripts: Map<String, Script> =
    mapOf(
        "SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirl" to
            SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirl,
        "SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirl" to
            SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirl,
        "SaffronCity_PokemonTrainerFanClub_EventScript_Youngster" to
            SaffronCity_PokemonTrainerFanClub_EventScript_Youngster,
        "SaffronCity_PokemonTrainerFanClub_EventScript_Gentleman" to
            SaffronCity_PokemonTrainerFanClub_EventScript_Gentleman,
        "SaffronCity_PokemonTrainerFanClub_EventScript_Woman" to
            SaffronCity_PokemonTrainerFanClub_EventScript_Woman,
        "SaffronCity_PokemonTrainerFanClub_EventScript_Rocker" to
            SaffronCity_PokemonTrainerFanClub_EventScript_Rocker,
        "SaffronCity_PokemonTrainerFanClub_EventScript_Beauty" to
            SaffronCity_PokemonTrainerFanClub_EventScript_Beauty,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BlackBelt" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BlackBelt,
        "SaffronCity_PokemonTrainerFanClub_EventScript_PokemonJournalBruno" to
            SaffronCity_PokemonTrainerFanClub_EventScript_PokemonJournalBruno,
        "SaffronCity_PokemonTrainerFanClub_EventScript_RockerPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_RockerPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_WomanPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayerNotChampion" to
            SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayerNotChampion,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayerNotChampion" to
            SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayerNotChampion,
        "SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion" to
            SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayerNotChampion,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BeautyPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BeautyPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayerNotChampion" to
            SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlPlayerNotChampion,
        "SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyNonFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyNonFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltPlayersFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltPlayersFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BeautyOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_YoungsterOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_RockerOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_CrushGirlOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_WomanOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_GentlemanOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_BlackBeltOnlyFan,
        "SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan" to
            SaffronCity_PokemonTrainerFanClub_EventScript_LittleGirlOnlyFan,
    )
