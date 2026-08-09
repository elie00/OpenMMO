package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message BattleFrontier_BattleTowerMultiPartnerRoom_Text_QuitLookingForPartner
 * waitmessage
 * multichoicedefault 20, 8, MULTI_YESNO, 1, FALSE
 * goto_if_eq VAR_RESULT, 0, BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_QuitChallenge
 * msgbox BattleFrontier_BattleTowerMultiPartnerRoom_Text_PleaseFindPartner2, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Attendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Attendant")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 0
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 1
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 2
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 3
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 4
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner5 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 5
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner6 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 6
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner7 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner7")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * setvar VAR_TEMP_2, 7
 * goto BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner8 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner8")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_CHOSEN_MULTI_BATTLE_NPC_PARTNER, BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_RejectPartner
 * tower_dopartnermsg PARTNER_MSGID_INTRO
 * waitmessage
 * waitbuttonpress
 * tower_dopartnermsg PARTNER_MSGID_MON1
 * waitmessage
 * waitbuttonpress
 * tower_dopartnermsg PARTNER_MSGID_MON2_ASK
 * waitmessage
 * multichoicedefault 20, 8, MULTI_YESNO, 1, FALSE
 * switch VAR_RESULT
 * case 1, BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_RejectPartner
 * case MULTI_B_PRESSED, BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_RejectPartner
 * tower_dopartnermsg PARTNER_MSGID_ACCEPT
 * waitmessage
 * waitbuttonpress
 * closemessage
 * call_if_ne VAR_FACING, DIR_SOUTH, BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_PartnerExit
 * call_if_eq VAR_FACING, DIR_SOUTH, BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_PartnerExitSouth
 * removeobject VAR_LAST_TALKED
 * setflag FLAG_CHOSEN_MULTI_BATTLE_NPC_PARTNER
 * warpsilent MAP_BATTLE_FRONTIER_BATTLE_TOWER_MULTI_PARTNER_ROOM, 10, 3
 * waitstate
 * release
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * frontier_set FRONTIER_DATA_RECORD_DISABLED, TRUE
 * goto BattleFrontier_BattleTower_EventScript_WarpToLobbyLost
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_QuitChallenge : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_QuitChallenge")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * frontier_set FRONTIER_DATA_CHALLENGE_STATUS, CHALLENGE_STATUS_LOST
 * tower_set TOWER_DATA_LVL_MODE
 * setvar VAR_0x8004, FANCOUNTER_USED_BATTLE_TOWER
 * special Script_TryGainNewFanFromCounter
 * goto BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobby
 * ```
 */
internal object BattleFrontier_BattleTower_EventScript_WarpToLobbyLost : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTower_EventScript_WarpToLobbyLost")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_RESULT, VAR_FRONTIER_BATTLE_MODE
 * goto_if_eq VAR_RESULT, FRONTIER_MODE_DOUBLES, BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyDoubles
 * goto_if_eq VAR_RESULT, FRONTIER_MODE_MULTIS, BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyMultis
 * goto_if_eq VAR_RESULT, FRONTIER_MODE_LINK_MULTIS, BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyLinkMultis
 * warp MAP_BATTLE_FRONTIER_BATTLE_TOWER_LOBBY, 6, 6
 * waitstate
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobby : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobby")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * tower_closelink
 * warp MAP_BATTLE_FRONTIER_BATTLE_TOWER_LOBBY, 18, 6
 * waitstate
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyLinkMultis : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyLinkMultis")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * warp MAP_BATTLE_FRONTIER_BATTLE_TOWER_LOBBY, 10, 6
 * waitstate
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyDoubles : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyDoubles")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * warp MAP_BATTLE_FRONTIER_BATTLE_TOWER_LOBBY, 14, 6
 * waitstate
 * end
 * ```
 */
internal object BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyMultis : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyMultis")
}

internal val BattleFrontier_BattleTowerMultiPartnerRoomScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Attendant" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Attendant,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner1" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner1,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner2" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner2,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner3" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner3,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner4" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner4,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner5" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner5,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner6" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner6,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner7" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner7,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner8" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_Partner8,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_TalkToPotentialPartner,
        "BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_QuitChallenge" to
            BattleFrontier_BattleTowerMultiPartnerRoom_EventScript_QuitChallenge,
        "BattleFrontier_BattleTower_EventScript_WarpToLobbyLost" to
            BattleFrontier_BattleTower_EventScript_WarpToLobbyLost,
        "BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobby" to
            BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobby,
        "BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyLinkMultis" to
            BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyLinkMultis,
        "BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyDoubles" to
            BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyDoubles,
        "BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyMultis" to
            BattleFrontier_BattleTowerBattleRoom_EventScript_WarpToLobbyMultis,
    )
