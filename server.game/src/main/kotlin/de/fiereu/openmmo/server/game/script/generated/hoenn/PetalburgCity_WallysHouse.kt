package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.PetalburgCity_WallysHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_WALLY_VICTORY_ROAD, PetalburgCity_WallysHouse_EventScript_DefeatedWallyInVictoryRoad
 * goto_if_set FLAG_RECEIVED_HM_SURF, PetalburgCity_WallysHouse_EventScript_ReceievedHMSurf
 * goto_if_set FLAG_THANKED_FOR_PLAYING_WITH_WALLY, PetalburgCity_WallysHouse_EventScript_PlayedWithWally
 * msgbox PetalburgCity_WallysHouse_Text_ThanksForPlayingWithWally, MSGBOX_DEFAULT
 * setflag FLAG_THANKED_FOR_PLAYING_WITH_WALLY
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_WallysDad : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PetalburgCity_WallysHouse_EventScript_WallysDad")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_HM_SURF, PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf
 * msgbox PetalburgCity_WallysHouse_Text_WallyWasReallyHappy, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_WallysMom : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_HM_SURF))
        return PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf.run(ctx)
    ctx.say(PetalburgCity_WallysHouse.WallyWasReallyHappy)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PetalburgCity_WallysHouse_Text_WallyLeftWithoutTelling, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf")
}

internal val PetalburgCity_WallysHouseScripts: Map<String, Script> =
    mapOf(
        "PetalburgCity_WallysHouse_EventScript_WallysDad" to
            PetalburgCity_WallysHouse_EventScript_WallysDad,
        "PetalburgCity_WallysHouse_EventScript_WallysMom" to
            PetalburgCity_WallysHouse_EventScript_WallysMom,
        "PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf" to
            PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf,
    )
