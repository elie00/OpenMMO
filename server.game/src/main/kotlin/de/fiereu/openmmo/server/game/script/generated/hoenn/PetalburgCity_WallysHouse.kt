package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.PetalburgCity_WallysHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
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
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_WALLY_VICTORY_ROAD))
        return PetalburgCity_WallysHouse_EventScript_DefeatedWallyInVictoryRoad.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_HM_SURF))
        return PetalburgCity_WallysHouse_EventScript_ReceievedHMSurf.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_THANKED_FOR_PLAYING_WITH_WALLY))
        return PetalburgCity_WallysHouse_EventScript_PlayedWithWally.run(ctx)
    ctx.say(PetalburgCity_WallysHouse.ThanksForPlayingWithWally)
    ctx.setFlag(HoennFlags.FLAG_THANKED_FOR_PLAYING_WITH_WALLY)
  }
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
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_WallysHouse_Text_WallyLeftWithoutTelling, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_WallysHouse.WallyLeftWithoutTelling)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_WallysHouse_Text_WallyIsComingHomeSoon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_ReceievedHMSurf : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_WallysHouse.WallyIsComingHomeSoon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_WallysHouse_Text_YouMetWallyInEverGrandeCity, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_DefeatedWallyInVictoryRoad : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_WallysHouse.YouMetWallyInEverGrandeCity)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_WallysHouse_Text_WonderHowWallyIsDoing, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PetalburgCity_WallysHouse_EventScript_PlayedWithWally : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_WallysHouse.WonderHowWallyIsDoing)
  }
}

internal val PetalburgCity_WallysHouseScripts: Map<String, Script> =
    mapOf(
        "PetalburgCity_WallysHouse_EventScript_WallysDad" to
            PetalburgCity_WallysHouse_EventScript_WallysDad,
        "PetalburgCity_WallysHouse_EventScript_WallysMom" to
            PetalburgCity_WallysHouse_EventScript_WallysMom,
        "PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf" to
            PetalburgCity_WallysHouse_EventScript_ReceivedHMSurf,
        "PetalburgCity_WallysHouse_EventScript_ReceievedHMSurf" to
            PetalburgCity_WallysHouse_EventScript_ReceievedHMSurf,
        "PetalburgCity_WallysHouse_EventScript_DefeatedWallyInVictoryRoad" to
            PetalburgCity_WallysHouse_EventScript_DefeatedWallyInVictoryRoad,
        "PetalburgCity_WallysHouse_EventScript_PlayedWithWally" to
            PetalburgCity_WallysHouse_EventScript_PlayedWithWally,
    )
