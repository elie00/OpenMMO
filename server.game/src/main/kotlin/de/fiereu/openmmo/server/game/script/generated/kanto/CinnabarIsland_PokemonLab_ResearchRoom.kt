package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CinnabarIsland_PokemonLab_ResearchRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * goto EventScript_MetronomeTutor
 * end
 * ```
 */
internal object CinnabarIsland_PokemonLab_ResearchRoom_EventScript_MetronomeTutor : Script {
  override suspend fun run(ctx: ScriptContext) {
    return EventScript_MetronomeTutor.run(ctx)
  }
}

internal object CinnabarIsland_PokemonLab_ResearchRoom_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CinnabarIsland_PokemonLab_ResearchRoom.EeveeCanEvolveIntroThreeMons)
}

internal object CinnabarIsland_PokemonLab_ResearchRoom_EventScript_AmberPipe : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CinnabarIsland_PokemonLab_ResearchRoom.AnAmberPipe)
}

internal object CinnabarIsland_PokemonLab_ResearchRoom_EventScript_Computer : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CinnabarIsland_PokemonLab_ResearchRoom.LegendaryBirdEmail)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_METRONOME, EventScript_MetronomeTaught
 * msgbox Text_MetronomeTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_MetronomeDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_MetronomeDeclined
 * msgbox Text_MetronomeWhichMon
 * setvar VAR_0x8005, MOVETUTOR_METRONOME
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_MetronomeDeclined
 * setflag FLAG_TUTOR_METRONOME
 * goto EventScript_MetronomeTaught
 * end
 * ```
 */
internal object EventScript_MetronomeTutor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MetronomeTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MetronomeDeclined
 * release
 * end
 * ```
 */
internal object EventScript_MetronomeDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MetronomeDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MetronomeTaught
 * release
 * end
 * ```
 */
internal object EventScript_MetronomeTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MetronomeTaught")
}

internal val CinnabarIsland_PokemonLab_ResearchRoomScripts: Map<String, Script> =
    mapOf(
        "CinnabarIsland_PokemonLab_ResearchRoom_EventScript_MetronomeTutor" to
            CinnabarIsland_PokemonLab_ResearchRoom_EventScript_MetronomeTutor,
        "CinnabarIsland_PokemonLab_ResearchRoom_EventScript_Scientist" to
            CinnabarIsland_PokemonLab_ResearchRoom_EventScript_Scientist,
        "CinnabarIsland_PokemonLab_ResearchRoom_EventScript_AmberPipe" to
            CinnabarIsland_PokemonLab_ResearchRoom_EventScript_AmberPipe,
        "CinnabarIsland_PokemonLab_ResearchRoom_EventScript_Computer" to
            CinnabarIsland_PokemonLab_ResearchRoom_EventScript_Computer,
        "EventScript_MetronomeTutor" to EventScript_MetronomeTutor,
        "EventScript_MetronomeDeclined" to EventScript_MetronomeDeclined,
        "EventScript_MetronomeTaught" to EventScript_MetronomeTaught,
    )
