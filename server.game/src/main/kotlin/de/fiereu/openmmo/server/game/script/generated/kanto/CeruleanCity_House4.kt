package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_House4
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * specialvar REWARD_TYPE, WonderNews_GetRewardInfo
 * copyvar REWARD_ITEM, VAR_RESULT
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_NONE,       CeruleanCity_House4_EventScript_NoNews
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_RECV_SMALL, CeruleanCity_House4_EventScript_Reward_RecvSmall
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_RECV_BIG,   CeruleanCity_House4_EventScript_Reward_RecvBig
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_WAITING,    CeruleanCity_House4_EventScript_Waiting
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_SENT_SMALL, CeruleanCity_House4_EventScript_Reward_SentSmall
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_SENT_BIG,   CeruleanCity_House4_EventScript_Reward_SentBig
 * goto_if_eq REWARD_TYPE, NEWS_REWARD_AT_MAX,     CeruleanCity_House4_EventScript_AtMax
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_WonderNewsBerryMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_WonderNewsBerryMan")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_House4_Text_NothingEntertaining
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_NoNews : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity_House4.NothingEntertaining)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CeruleanCity_House4_EventScript_MovementReactionToNews
 * msgbox CeruleanCity_House4_Text_ThanksForSpreadingNewsTakeThis
 * giveitem REWARD_ITEM
 * goto_if_eq VAR_RESULT, FALSE, CeruleanCity_House4_EventScript_NoRoomForBerries
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_Reward_SentSmall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_Reward_SentSmall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CeruleanCity_House4_EventScript_MovementReactionToNews
 * msgbox CeruleanCity_House4_Text_NewNewsInformativeHaveThis
 * giveitem REWARD_ITEM
 * goto_if_eq VAR_RESULT, FALSE, CeruleanCity_House4_EventScript_NoRoomForBerries
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_Reward_RecvSmall : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_Reward_RecvSmall")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CeruleanCity_House4_EventScript_MovementReactionToNews
 * msgbox CeruleanCity_House4_Text_MagnificentNewsSpreadHaveBerries
 * giveitem REWARD_ITEM, 4
 * goto_if_eq VAR_RESULT, FALSE, CeruleanCity_House4_EventScript_NoRoomForBerries
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_Reward_SentBig : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_Reward_SentBig")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call CeruleanCity_House4_EventScript_MovementReactionToNews
 * msgbox CeruleanCity_House4_Text_IncredibleNewsHaveBerries
 * giveitem REWARD_ITEM, 4
 * goto_if_eq VAR_RESULT, FALSE, CeruleanCity_House4_EventScript_NoRoomForBerries
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_Reward_RecvBig : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_Reward_RecvBig")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_WONDER_NEWS_BERRY_MAN, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox CeruleanCity_House4_Text_WishCouldShareNewsWithOthers
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_Waiting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_Waiting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_WONDER_NEWS_BERRY_MAN, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox CeruleanCity_House4_Text_EnjoyingMyselfWithAllSortsOfNews
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_AtMax : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CeruleanCity_House4_EventScript_AtMax")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_PIN
 * applymovement LOCALID_WONDER_NEWS_BERRY_MAN, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_WONDER_NEWS_BERRY_MAN, Common_Movement_FacePlayer
 * waitmovement 0
 * applymovement LOCALID_WONDER_NEWS_BERRY_MAN, Common_Movement_Delay48
 * waitmovement 0
 * return
 * ```
 */
internal object CeruleanCity_House4_EventScript_MovementReactionToNews : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House4_EventScript_MovementReactionToNews")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeruleanCity_House4_Text_YourBerryPouchIsFull
 * release
 * end
 * ```
 */
internal object CeruleanCity_House4_EventScript_NoRoomForBerries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity_House4.YourBerryPouchIsFull)
  }
}

internal val CeruleanCity_House4Scripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_House4_EventScript_WonderNewsBerryMan" to
            CeruleanCity_House4_EventScript_WonderNewsBerryMan,
        "CeruleanCity_House4_EventScript_NoNews" to CeruleanCity_House4_EventScript_NoNews,
        "CeruleanCity_House4_EventScript_Reward_SentSmall" to
            CeruleanCity_House4_EventScript_Reward_SentSmall,
        "CeruleanCity_House4_EventScript_Reward_RecvSmall" to
            CeruleanCity_House4_EventScript_Reward_RecvSmall,
        "CeruleanCity_House4_EventScript_Reward_SentBig" to
            CeruleanCity_House4_EventScript_Reward_SentBig,
        "CeruleanCity_House4_EventScript_Reward_RecvBig" to
            CeruleanCity_House4_EventScript_Reward_RecvBig,
        "CeruleanCity_House4_EventScript_Waiting" to CeruleanCity_House4_EventScript_Waiting,
        "CeruleanCity_House4_EventScript_AtMax" to CeruleanCity_House4_EventScript_AtMax,
        "CeruleanCity_House4_EventScript_MovementReactionToNews" to
            CeruleanCity_House4_EventScript_MovementReactionToNews,
        "CeruleanCity_House4_EventScript_NoRoomForBerries" to
            CeruleanCity_House4_EventScript_NoRoomForBerries,
    )
