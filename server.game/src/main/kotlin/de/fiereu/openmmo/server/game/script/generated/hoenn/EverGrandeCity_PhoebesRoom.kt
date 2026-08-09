package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.EverGrandeCity_PhoebesRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_ELITE_4_PHOEBE, EverGrandeCity_PhoebesRoom_EventScript_PostBattleSpeech
 * playbgm MUS_ENCOUNTER_ELITE_FOUR, FALSE
 * msgbox EverGrandeCity_PhoebesRoom_Text_IntroSpeech, MSGBOX_DEFAULT
 * trainerbattle_no_intro TRAINER_PHOEBE, EverGrandeCity_PhoebesRoom_Text_Defeat
 * goto EverGrandeCity_PhoebesRoom_EventScript_Defeated
 * end
 * ```
 */
internal object EverGrandeCity_PhoebesRoom_EventScript_Phoebe : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EverGrandeCity_PhoebesRoom_EventScript_Phoebe")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox EverGrandeCity_PhoebesRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_PhoebesRoom_EventScript_PostBattleSpeech : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(EverGrandeCity_PhoebesRoom.PostBattleSpeech)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DEFEATED_ELITE_4_PHOEBE
 * call PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles
 * msgbox EverGrandeCity_PhoebesRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_PhoebesRoom_EventScript_Defeated : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_DEFEATED_ELITE_4_PHOEBE)
    PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles.run(ctx)
    ctx.say(EverGrandeCity_PhoebesRoom.PostBattleSpeech)
  }
}

internal val EverGrandeCity_PhoebesRoomScripts: Map<String, Script> =
    mapOf(
        "EverGrandeCity_PhoebesRoom_EventScript_Phoebe" to
            EverGrandeCity_PhoebesRoom_EventScript_Phoebe,
        "EverGrandeCity_PhoebesRoom_EventScript_PostBattleSpeech" to
            EverGrandeCity_PhoebesRoom_EventScript_PostBattleSpeech,
        "EverGrandeCity_PhoebesRoom_EventScript_Defeated" to
            EverGrandeCity_PhoebesRoom_EventScript_Defeated,
    )
