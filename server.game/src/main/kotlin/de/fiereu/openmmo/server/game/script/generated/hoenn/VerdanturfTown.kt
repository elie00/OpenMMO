package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.VerdanturfTown
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object VerdanturfTown_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VerdanturfTown.AirCleanHere)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RUSTURF_TUNNEL_OPENED, VerdanturfTown_EventScript_TwinTunnelOpen
 * msgbox VerdanturfTown_Text_ManTryingToDigTunnel, MSGBOX_DEFAULT
 * applymovement LOCALID_VERDANTURF_TWIN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object VerdanturfTown_EventScript_Twin : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port VerdanturfTown_EventScript_Twin")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RUSTURF_TUNNEL_OPENED, VerdanturfTown_EventScript_BoyTunnelOpen
 * msgbox VerdanturfTown_Text_GuyTryingToBustThroughCave, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RUSTURF_TUNNEL_OPENED))
        return VerdanturfTown_EventScript_BoyTunnelOpen.run(ctx)
    ctx.say(VerdanturfTown.GuyTryingToBustThroughCave)
  }
}

internal object VerdanturfTown_EventScript_Camper : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(VerdanturfTown.MakeBattleTentDebut)
}

internal object VerdanturfTown_EventScript_TownSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VerdanturfTown.TownSign)
}

internal object VerdanturfTown_EventScript_WandasHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VerdanturfTown.WandasHouse)
}

internal object VerdanturfTown_EventScript_BattleTentSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VerdanturfTown.BattleTentSign)
}

internal object VerdanturfTown_EventScript_RusturfTunnelSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(VerdanturfTown.RusturfTunnelSign)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_Text_EasyToGetToRustboroNow, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_EventScript_BoyTunnelOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown.EasyToGetToRustboroNow)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_Text_ManDugTunnelForLove, MSGBOX_DEFAULT
 * applymovement LOCALID_VERDANTURF_TWIN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object VerdanturfTown_EventScript_TwinTunnelOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown.ManDugTunnelForLove)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

internal val VerdanturfTownScripts: Map<String, Script> =
    mapOf(
        "VerdanturfTown_EventScript_Man" to VerdanturfTown_EventScript_Man,
        "VerdanturfTown_EventScript_Twin" to VerdanturfTown_EventScript_Twin,
        "VerdanturfTown_EventScript_Boy" to VerdanturfTown_EventScript_Boy,
        "VerdanturfTown_EventScript_Camper" to VerdanturfTown_EventScript_Camper,
        "VerdanturfTown_EventScript_TownSign" to VerdanturfTown_EventScript_TownSign,
        "VerdanturfTown_EventScript_WandasHouseSign" to VerdanturfTown_EventScript_WandasHouseSign,
        "VerdanturfTown_EventScript_BattleTentSign" to VerdanturfTown_EventScript_BattleTentSign,
        "VerdanturfTown_EventScript_RusturfTunnelSign" to
            VerdanturfTown_EventScript_RusturfTunnelSign,
        "VerdanturfTown_EventScript_BoyTunnelOpen" to VerdanturfTown_EventScript_BoyTunnelOpen,
        "VerdanturfTown_EventScript_TwinTunnelOpen" to VerdanturfTown_EventScript_TwinTunnelOpen,
    )
