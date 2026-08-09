package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ThreeIsland_DunsparceTunnel
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_NUGGET_FROM_DUNSPARCE_TUNNEL, ThreeIsland_DunsparceTunnel_EventScript_ProspectorAlreadyGaveNugget
 * specialvar VAR_RESULT, IsNationalPokedexEnabled
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_DunsparceTunnel_EventScript_ProspectorStruckGold
 * msgbox ThreeIsland_DunsparceTunnel_Text_ProspectingForGold
 * closemessage
 * applymovement LOCALID_PROSPECTOR, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object ThreeIsland_DunsparceTunnel_EventScript_Prospector : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_DunsparceTunnel_EventScript_Prospector")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ThreeIsland_DunsparceTunnel_Text_ThatsANugget
 * release
 * end
 * ```
 */
internal object ThreeIsland_DunsparceTunnel_EventScript_ProspectorAlreadyGaveNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ThreeIsland_DunsparceTunnel.ThatsANugget)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox ThreeIsland_DunsparceTunnel_Text_StruckGoldThisIsForYou
 * giveitem ITEM_NUGGET
 * goto_if_eq VAR_RESULT, FALSE, ThreeIsland_DunsparceTunnel_EventScript_NoRoomForNugget
 * setflag FLAG_GOT_NUGGET_FROM_DUNSPARCE_TUNNEL
 * goto ThreeIsland_DunsparceTunnel_EventScript_ProspectorAlreadyGaveNugget
 * end
 * ```
 */
internal object ThreeIsland_DunsparceTunnel_EventScript_ProspectorStruckGold : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_DunsparceTunnel_EventScript_ProspectorStruckGold")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ThreeIsland_DunsparceTunnel_Text_WhoopsBagCrammedFull
 * release
 * end
 * ```
 */
internal object ThreeIsland_DunsparceTunnel_EventScript_NoRoomForNugget : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ThreeIsland_DunsparceTunnel.WhoopsBagCrammedFull)
  }
}

internal val ThreeIsland_DunsparceTunnelScripts: Map<String, Script> =
    mapOf(
        "ThreeIsland_DunsparceTunnel_EventScript_Prospector" to
            ThreeIsland_DunsparceTunnel_EventScript_Prospector,
        "ThreeIsland_DunsparceTunnel_EventScript_ProspectorAlreadyGaveNugget" to
            ThreeIsland_DunsparceTunnel_EventScript_ProspectorAlreadyGaveNugget,
        "ThreeIsland_DunsparceTunnel_EventScript_ProspectorStruckGold" to
            ThreeIsland_DunsparceTunnel_EventScript_ProspectorStruckGold,
        "ThreeIsland_DunsparceTunnel_EventScript_NoRoomForNugget" to
            ThreeIsland_DunsparceTunnel_EventScript_NoRoomForNugget,
    )
