package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonLeague_BrunosRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_BRUNO, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * goto_if_set FLAG_DEFEATED_BRUNO, PokemonLeague_BrunosRoom_EventScript_PostBattle
 * famechecker FAMECHECKER_BRUNO, 0
 * famechecker FAMECHECKER_BRUNO, 1
 * call_if_unset FLAG_SYS_GAME_CLEAR, PokemonLeague_BrunosRoom_EventScript_Intro
 * call_if_set FLAG_SYS_GAME_CLEAR, PokemonLeague_BrunosRoom_EventScript_RematchIntro
 * setflag FLAG_TEMP_3
 * setflag FLAG_TEMP_5
 * call_if_unset FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_BrunosRoom_EventScript_Battle
 * call_if_set FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_BrunosRoom_EventScript_Rematch
 * clearflag FLAG_TEMP_5
 * goto PokemonLeague_BrunosRoom_EventScript_DefeatedBruno
 * end
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_Bruno : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_Bruno")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_DEFEATED_BRUNO
 * call PokemonLeague_EventScript_OpenDoor
 * msgbox PokemonLeague_BrunosRoom_Text_PostBattle
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayRight
 * call_if_eq VAR_FACING, DIR_SOUTH, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayLeft
 * call_if_eq VAR_FACING, DIR_WEST, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown
 * call_if_eq VAR_FACING, DIR_EAST, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown
 * release
 * end
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_DefeatedBruno : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_DefeatedBruno")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_BrunosRoom_Text_Intro
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_Intro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_BrunosRoom.Intro)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_BrunosRoom_Text_RematchIntro
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_RematchIntro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_BrunosRoom.RematchIntro)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PokemonLeague_BrunosRoom_Text_PostBattle
 * closemessage
 * call_if_eq VAR_FACING, DIR_NORTH, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayRight
 * call_if_eq VAR_FACING, DIR_SOUTH, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayLeft
 * call_if_eq VAR_FACING, DIR_WEST, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown
 * call_if_eq VAR_FACING, DIR_EAST, PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown
 * release
 * end
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_PostBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_BRUNO_2, PokemonLeague_BrunosRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_Rematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_Rematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_BRUNO, PokemonLeague_BrunosRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_Battle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_Battle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_BRUNO, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_BRUNO, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_BRUNO, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayLeft")
}

internal val PokemonLeague_BrunosRoomScripts: Map<String, Script> =
    mapOf(
        "PokemonLeague_BrunosRoom_EventScript_Bruno" to PokemonLeague_BrunosRoom_EventScript_Bruno,
        "PokemonLeague_BrunosRoom_EventScript_DefeatedBruno" to
            PokemonLeague_BrunosRoom_EventScript_DefeatedBruno,
        "PokemonLeague_BrunosRoom_EventScript_Intro" to PokemonLeague_BrunosRoom_EventScript_Intro,
        "PokemonLeague_BrunosRoom_EventScript_RematchIntro" to
            PokemonLeague_BrunosRoom_EventScript_RematchIntro,
        "PokemonLeague_BrunosRoom_EventScript_PostBattle" to
            PokemonLeague_BrunosRoom_EventScript_PostBattle,
        "PokemonLeague_BrunosRoom_EventScript_Rematch" to
            PokemonLeague_BrunosRoom_EventScript_Rematch,
        "PokemonLeague_BrunosRoom_EventScript_Battle" to
            PokemonLeague_BrunosRoom_EventScript_Battle,
        "PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayRight" to
            PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayRight,
        "PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown" to
            PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayDown,
        "PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayLeft" to
            PokemonLeague_BrunosRoom_EventScript_BrunoLookAwayLeft,
    )
