package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.EverGrandeCity_SidneysRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_ELITE_4_SIDNEY, EverGrandeCity_SidneysRoom_EventScript_PostBattleSpeech
 * playbgm MUS_ENCOUNTER_ELITE_FOUR, FALSE
 * msgbox EverGrandeCity_SidneysRoom_Text_IntroSpeech, MSGBOX_DEFAULT
 * trainerbattle_no_intro TRAINER_SIDNEY, EverGrandeCity_SidneysRoom_Text_Defeat
 * goto EverGrandeCity_SidneysRoom_EventScript_Defeated
 * end
 * ```
 */
internal object EverGrandeCity_SidneysRoom_EventScript_Sidney : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EverGrandeCity_SidneysRoom_EventScript_Sidney")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DEFEATED_ELITE_4_SIDNEY
 * call PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles
 * msgbox EverGrandeCity_SidneysRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_SidneysRoom_EventScript_Defeated : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_DEFEATED_ELITE_4_SIDNEY)
    PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles.run(ctx)
    ctx.say(EverGrandeCity_SidneysRoom.PostBattleSpeech)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox EverGrandeCity_SidneysRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_SidneysRoom_EventScript_PostBattleSpeech : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(EverGrandeCity_SidneysRoom.PostBattleSpeech)
  }
}

internal val EverGrandeCity_SidneysRoomScripts: Map<String, Script> =
    mapOf(
        "EverGrandeCity_SidneysRoom_EventScript_Sidney" to
            EverGrandeCity_SidneysRoom_EventScript_Sidney,
        "EverGrandeCity_SidneysRoom_EventScript_Defeated" to
            EverGrandeCity_SidneysRoom_EventScript_Defeated,
        "EverGrandeCity_SidneysRoom_EventScript_PostBattleSpeech" to
            EverGrandeCity_SidneysRoom_EventScript_PostBattleSpeech,
    )
