package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.EverGrandeCity_GlaciasRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_ELITE_4_GLACIA, EverGrandeCity_GlaciasRoom_EventScript_PostBattleSpeech
 * playbgm MUS_ENCOUNTER_ELITE_FOUR, FALSE
 * msgbox EverGrandeCity_GlaciasRoom_Text_IntroSpeech, MSGBOX_DEFAULT
 * trainerbattle_no_intro TRAINER_GLACIA, EverGrandeCity_GlaciasRoom_Text_Defeat
 * goto EverGrandeCity_GlaciasRoom_EventScript_Defeated
 * end
 * ```
 */
internal object EverGrandeCity_GlaciasRoom_EventScript_Glacia : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port EverGrandeCity_GlaciasRoom_EventScript_Glacia")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DEFEATED_ELITE_4_GLACIA
 * call PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles
 * msgbox EverGrandeCity_GlaciasRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_GlaciasRoom_EventScript_Defeated : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_DEFEATED_ELITE_4_GLACIA)
    PokemonLeague_EliteFour_SetAdvanceToNextRoomMetatiles.run(ctx)
    ctx.say(EverGrandeCity_GlaciasRoom.PostBattleSpeech)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox EverGrandeCity_GlaciasRoom_Text_PostBattleSpeech, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object EverGrandeCity_GlaciasRoom_EventScript_PostBattleSpeech : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(EverGrandeCity_GlaciasRoom.PostBattleSpeech)
  }
}

internal val EverGrandeCity_GlaciasRoomScripts: Map<String, Script> =
    mapOf(
        "EverGrandeCity_GlaciasRoom_EventScript_Glacia" to
            EverGrandeCity_GlaciasRoom_EventScript_Glacia,
        "EverGrandeCity_GlaciasRoom_EventScript_Defeated" to
            EverGrandeCity_GlaciasRoom_EventScript_Defeated,
        "EverGrandeCity_GlaciasRoom_EventScript_PostBattleSpeech" to
            EverGrandeCity_GlaciasRoom_EventScript_PostBattleSpeech,
    )
