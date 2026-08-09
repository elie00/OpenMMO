package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonLeague_AgathasRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_AGATHA, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * goto_if_set FLAG_DEFEATED_AGATHA, PokemonLeague_AgathasRoom_EventScript_PostBattle
 * famechecker FAMECHECKER_AGATHA, 0
 * famechecker FAMECHECKER_AGATHA, 4
 * famechecker FAMECHECKER_OAK, 4
 * call_if_unset FLAG_SYS_GAME_CLEAR, PokemonLeague_AgathasRoom_EventScript_Intro
 * call_if_set FLAG_SYS_GAME_CLEAR, PokemonLeague_AgathasRoom_EventScript_RematchIntro
 * setflag FLAG_TEMP_3
 * setflag FLAG_TEMP_5
 * call_if_unset FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_AgathasRoom_EventScript_Battle
 * call_if_set FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_AgathasRoom_EventScript_Rematch
 * clearflag FLAG_TEMP_5
 * goto PokemonLeague_AgathasRoom_EventScript_DefeatedAgatha
 * end
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_Agatha : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_AgathasRoom_EventScript_Agatha")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_AGATHA, PokemonLeague_AgathasRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_Battle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_AgathasRoom_EventScript_Battle")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_AgathasRoom_Text_RematchIntro
 * return
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_RematchIntro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_AgathasRoom.RematchIntro)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_AgathasRoom_Text_Intro
 * return
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_Intro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_AgathasRoom.Intro)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DEFEATED_AGATHA
 * call PokemonLeague_EventScript_OpenDoor
 * msgbox PokemonLeague_AgathasRoom_Text_PostBattle
 * release
 * end
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_DefeatedAgatha : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_AGATHA)
    PokemonLeague_EventScript_OpenDoor.run(ctx)
    ctx.say(PokemonLeague_AgathasRoom.PostBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_AGATHA_2, PokemonLeague_AgathasRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_Rematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_AgathasRoom_EventScript_Rematch")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_AgathasRoom_Text_PostBattle
 * release
 * end
 * ```
 */
internal object PokemonLeague_AgathasRoom_EventScript_PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_AgathasRoom.PostBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_Delay32
 * waitmovement 0
 * playse SE_RS_DOOR
 * call PokemonLeague_EventScript_SetDoorOpen
 * special DrawWholeMapView
 * setflag FLAG_TEMP_4
 * return
 * ```
 */
internal object PokemonLeague_EventScript_OpenDoor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PokemonLeague_EventScript_OpenDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 6, 1, METATILE_PokemonLeague_Door_Top_Open, 1
 * setmetatile 6, 2, METATILE_PokemonLeague_Door_Mid_Open, 0
 * return
 * ```
 */
internal object PokemonLeague_EventScript_SetDoorOpen : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PokemonLeague_EventScript_SetDoorOpen")
}

internal val PokemonLeague_AgathasRoomScripts: Map<String, Script> =
    mapOf(
        "PokemonLeague_AgathasRoom_EventScript_Agatha" to
            PokemonLeague_AgathasRoom_EventScript_Agatha,
        "PokemonLeague_AgathasRoom_EventScript_Battle" to
            PokemonLeague_AgathasRoom_EventScript_Battle,
        "PokemonLeague_AgathasRoom_EventScript_RematchIntro" to
            PokemonLeague_AgathasRoom_EventScript_RematchIntro,
        "PokemonLeague_AgathasRoom_EventScript_Intro" to
            PokemonLeague_AgathasRoom_EventScript_Intro,
        "PokemonLeague_AgathasRoom_EventScript_DefeatedAgatha" to
            PokemonLeague_AgathasRoom_EventScript_DefeatedAgatha,
        "PokemonLeague_AgathasRoom_EventScript_Rematch" to
            PokemonLeague_AgathasRoom_EventScript_Rematch,
        "PokemonLeague_AgathasRoom_EventScript_PostBattle" to
            PokemonLeague_AgathasRoom_EventScript_PostBattle,
        "PokemonLeague_EventScript_OpenDoor" to PokemonLeague_EventScript_OpenDoor,
        "PokemonLeague_EventScript_SetDoorOpen" to PokemonLeague_EventScript_SetDoorOpen,
    )
