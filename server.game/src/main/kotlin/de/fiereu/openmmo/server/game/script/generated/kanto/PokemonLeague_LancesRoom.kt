package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonLeague_LancesRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_LANCE, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * goto_if_set FLAG_DEFEATED_LANCE, PokemonLeague_LancesRoom_EventScript_PostBattle
 * famechecker FAMECHECKER_LANCE, 0
 * famechecker FAMECHECKER_LANCE, 1
 * call_if_unset FLAG_SYS_GAME_CLEAR, PokemonLeague_LancesRoom_EventScript_Intro
 * call_if_set FLAG_SYS_GAME_CLEAR, PokemonLeague_LancesRoom_EventScript_RematchIntro
 * setflag FLAG_TEMP_3
 * setflag FLAG_TEMP_5
 * call_if_unset FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_LancesRoom_EventScript_Battle
 * call_if_set FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_LancesRoom_EventScript_Rematch
 * clearflag FLAG_TEMP_5
 * goto PokemonLeague_LancesRoom_EventScript_DefeatedLance
 * end
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_Lance : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LancesRoom_EventScript_Lance")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_LANCE_2, PokemonLeague_LancesRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_Rematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LancesRoom_EventScript_Rematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_LANCE, PokemonLeague_LancesRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_Battle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LancesRoom_EventScript_Battle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * special Script_TryGainNewFanFromCounter
 * setflag FLAG_DEFEATED_LANCE
 * call PokemonLeague_EventScript_OpenDoorLance
 * msgbox PokemonLeague_LancesRoom_Text_PostBattle
 * closemessage
 * release
 * end
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_DefeatedLance : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LancesRoom_EventScript_DefeatedLance")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_LancesRoom_Text_RematchIntro
 * return
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_RematchIntro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_LancesRoom.RematchIntro)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_LancesRoom_Text_Intro
 * return
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_Intro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_LancesRoom.Intro)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_LancesRoom_Text_PostBattle
 * release
 * end
 * ```
 */
internal object PokemonLeague_LancesRoom_EventScript_PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_LancesRoom.PostBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_Delay32
 * waitmovement 0
 * playse SE_RS_DOOR
 * setmetatile 6, 4, METATILE_PokemonLeague_Door_Top_Open, 1
 * setmetatile 6, 5, METATILE_PokemonLeague_Door_Mid_Open, 0
 * special DrawWholeMapView
 * setflag FLAG_TEMP_4
 * return
 * ```
 */
internal object PokemonLeague_EventScript_OpenDoorLance : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_EventScript_OpenDoorLance")
}

internal val PokemonLeague_LancesRoomScripts: Map<String, Script> =
    mapOf(
        "PokemonLeague_LancesRoom_EventScript_Lance" to PokemonLeague_LancesRoom_EventScript_Lance,
        "PokemonLeague_LancesRoom_EventScript_Rematch" to
            PokemonLeague_LancesRoom_EventScript_Rematch,
        "PokemonLeague_LancesRoom_EventScript_Battle" to
            PokemonLeague_LancesRoom_EventScript_Battle,
        "PokemonLeague_LancesRoom_EventScript_DefeatedLance" to
            PokemonLeague_LancesRoom_EventScript_DefeatedLance,
        "PokemonLeague_LancesRoom_EventScript_RematchIntro" to
            PokemonLeague_LancesRoom_EventScript_RematchIntro,
        "PokemonLeague_LancesRoom_EventScript_Intro" to PokemonLeague_LancesRoom_EventScript_Intro,
        "PokemonLeague_LancesRoom_EventScript_PostBattle" to
            PokemonLeague_LancesRoom_EventScript_PostBattle,
        "PokemonLeague_EventScript_OpenDoorLance" to PokemonLeague_EventScript_OpenDoorLance,
    )
