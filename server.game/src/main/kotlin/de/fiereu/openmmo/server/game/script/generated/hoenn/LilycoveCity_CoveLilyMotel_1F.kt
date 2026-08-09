package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_SYS_GAME_CLEAR, LilycoveCity_CoveLilyMotel_1F_EventScript_GameClear
 * goto_if_set FLAG_BADGE07_GET, LilycoveCity_CoveLilyMotel_1F_EventScript_AquaHideoutBusted
 * msgbox LilycoveCity_CoveLilyMotel_1F_Text_GuestsDoubledByMascot, MSGBOX_DEFAULT
 * applymovement LOCALID_MOTEL_OWNER, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox LilycoveCity_CoveLilyMotel_1F_Text_NoGuestsWithTeamAqua, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_MOTEL_OWNER, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_CoveLilyMotel_1F_EventScript_MotelOwner : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_CoveLilyMotel_1F_EventScript_MotelOwner")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_CoveLilyMotel_1F_Text_MonFoundLostItem, MSGBOX_DEFAULT
 * applymovement LOCALID_MOTEL_OWNER, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox LilycoveCity_CoveLilyMotel_1F_Text_HeardAquaHideoutBusted, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_MOTEL_OWNER, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_CoveLilyMotel_1F_EventScript_AquaHideoutBusted : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_CoveLilyMotel_1F_EventScript_AquaHideoutBusted")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_CoveLilyMotel_1F_Text_HouseSittingMonCaughtBurglar, MSGBOX_DEFAULT
 * applymovement LOCALID_MOTEL_OWNER, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox LilycoveCity_CoveLilyMotel_1F_Text_BetterGetWorkingOnGuestsDinner, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_MOTEL_OWNER, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_CoveLilyMotel_1F_EventScript_GameClear : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_CoveLilyMotel_1F_EventScript_GameClear")
}

internal val LilycoveCity_CoveLilyMotel_1FScripts: Map<String, Script> =
    mapOf(
        "LilycoveCity_CoveLilyMotel_1F_EventScript_MotelOwner" to
            LilycoveCity_CoveLilyMotel_1F_EventScript_MotelOwner,
        "LilycoveCity_CoveLilyMotel_1F_EventScript_AquaHideoutBusted" to
            LilycoveCity_CoveLilyMotel_1F_EventScript_AquaHideoutBusted,
        "LilycoveCity_CoveLilyMotel_1F_EventScript_GameClear" to
            LilycoveCity_CoveLilyMotel_1F_EventScript_GameClear,
    )
