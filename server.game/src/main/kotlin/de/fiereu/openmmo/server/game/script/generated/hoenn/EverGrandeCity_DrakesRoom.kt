package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.EverGrandeCity_DrakesRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_ELITE_4_DRAKE, EverGrandeCity_DrakesRoom_EventScript_PostBattleSpeech
 * playbgm MUS_ENCOUNTER_ELITE_FOUR, FALSE
 * msgbox EverGrandeCity_DrakesRoom_Text_IntroSpeech, MSGBOX_DEFAULT
 * trainerbattle_no_intro TRAINER_DRAKE, EverGrandeCity_DrakesRoom_Text_Defeat
 * goto EverGrandeCity_DrakesRoom_EventScript_Defeated
 * end
 * ```
 */
internal object EverGrandeCity_DrakesRoom_EventScript_Drake : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EverGrandeCity_DrakesRoom_EventScript_Drake")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, FANCOUNTER_DEFEATED_DRAKE
 * special Script_TryGainNewFanFromCounter
 * setflag FLAG_DEFEATED_ELITE_4_DRAKE
 * call PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles
 * msgbox EverGrandeCity_DrakesRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_DrakesRoom_EventScript_Defeated : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EverGrandeCity_DrakesRoom_EventScript_Defeated")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox EverGrandeCity_DrakesRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_DrakesRoom_EventScript_PostBattleSpeech : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(EverGrandeCity_DrakesRoom.PostBattleSpeech)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_Delay32
 * waitmovement 0
 * playse SE_DOOR
 * setmetatile 6, 1, METATILE_EliteFour_OpenDoor_Frame, FALSE
 * setmetatile 6, 2, METATILE_EliteFour_OpenDoor_Opening, FALSE
 * setmetatile 0, 2, METATILE_EliteFour_RightSpotlightOff, TRUE
 * setmetatile 1, 2, METATILE_EliteFour_LeftSpotlightOff, TRUE
 * setmetatile 2, 2, METATILE_EliteFour_RightSpotlightOff, TRUE
 * setmetatile 3, 2, METATILE_EliteFour_LeftSpotlightOff, TRUE
 * setmetatile 4, 2, METATILE_EliteFour_RightSpotlightOff, TRUE
 * setmetatile 8, 2, METATILE_EliteFour_LeftSpotlightOff, TRUE
 * setmetatile 9, 2, METATILE_EliteFour_RightSpotlightOff, TRUE
 * setmetatile 10, 2, METATILE_EliteFour_LeftSpotlightOff, TRUE
 * setmetatile 11, 2, METATILE_EliteFour_RightSpotlightOff, TRUE
 * setmetatile 12, 2, METATILE_EliteFour_LeftSpotlightOff, TRUE
 * special DrawWholeMapView
 * return
 * ```
 */
internal object PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles")
}

internal val EverGrandeCity_DrakesRoomScripts: Map<String, Script> =
    mapOf(
        "EverGrandeCity_DrakesRoom_EventScript_Drake" to
            EverGrandeCity_DrakesRoom_EventScript_Drake,
        "EverGrandeCity_DrakesRoom_EventScript_Defeated" to
            EverGrandeCity_DrakesRoom_EventScript_Defeated,
        "EverGrandeCity_DrakesRoom_EventScript_PostBattleSpeech" to
            EverGrandeCity_DrakesRoom_EventScript_PostBattleSpeech,
        "PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles" to
            PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles,
    )
