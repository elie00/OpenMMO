package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MossdeepCity_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object MossdeepCity_House2_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(MossdeepCity_House2.SisterMailsBoyfriendInFortree)
}

internal object MossdeepCity_House2_EventScript_Twin : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(MossdeepCity_House2.PokemonCarriesMailBackAndForth)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_WINGULL, CRY_MODE_NORMAL
 * msgbox MossdeepCity_House2_Text_Wingull, MSGBOX_DEFAULT
 * waitmoncry
 * closemessage
 * setflag FLAG_WINGULL_DELIVERED_MAIL
 * clearflag FLAG_HIDE_FORTREE_CITY_HOUSE_4_WINGULL
 * call_if_eq VAR_FACING, DIR_NORTH, MossdeepCity_House2_EventScript_WingullExitNorth
 * call_if_eq VAR_FACING, DIR_WEST, MossdeepCity_House2_EventScript_WingullExitWest
 * removeobject LOCALID_MOSSDEEP_HOUSE_WINGULL
 * release
 * end
 * ```
 */
internal object MossdeepCity_House2_EventScript_Wingull : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_House2_EventScript_Wingull")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MOSSDEEP_HOUSE_WINGULL, MossdeepCity_House2_Movement_WingullExitNorth
 * waitmovement 0
 * return
 * ```
 */
internal object MossdeepCity_House2_EventScript_WingullExitNorth : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_House2_EventScript_WingullExitNorth")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_MOSSDEEP_HOUSE_WINGULL, MossdeepCity_House2_Movement_WingullExitEast
 * waitmovement 0
 * return
 * ```
 */
internal object MossdeepCity_House2_EventScript_WingullExitWest : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_House2_EventScript_WingullExitWest")
}

internal val MossdeepCity_House2Scripts: Map<String, Script> =
    mapOf(
        "MossdeepCity_House2_EventScript_Man" to MossdeepCity_House2_EventScript_Man,
        "MossdeepCity_House2_EventScript_Twin" to MossdeepCity_House2_EventScript_Twin,
        "MossdeepCity_House2_EventScript_Wingull" to MossdeepCity_House2_EventScript_Wingull,
        "MossdeepCity_House2_EventScript_WingullExitNorth" to
            MossdeepCity_House2_EventScript_WingullExitNorth,
        "MossdeepCity_House2_EventScript_WingullExitWest" to
            MossdeepCity_House2_EventScript_WingullExitWest,
    )
