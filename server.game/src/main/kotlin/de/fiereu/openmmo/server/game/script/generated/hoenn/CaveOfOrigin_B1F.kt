package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.CaveOfOrigin_B1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox CaveOfOrigin_B1F_Text_WallaceStory, MSGBOX_DEFAULT
 * closemessage
 * applymovement LOCALID_CAVE_OF_ORIGIN_WALLACE, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * delay 60
 * playse SE_PIN
 * applymovement LOCALID_CAVE_OF_ORIGIN_WALLACE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_CAVE_OF_ORIGIN_WALLACE, Common_Movement_Delay48
 * waitmovement 0
 * delay 30
 * applymovement LOCALID_CAVE_OF_ORIGIN_WALLACE, Common_Movement_FacePlayer
 * waitmovement 0
 * message CaveOfOrigin_B1F_Text_WhereIsRayquaza
 * waitmessage
 * goto CaveOfOrigin_B1F_EventScript_WheresRayquaza
 * ```
 */
internal object CaveOfOrigin_B1F_EventScript_Wallace : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port CaveOfOrigin_B1F_EventScript_Wallace")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * multichoice 0, 0, MULTI_WHERES_RAYQUAZA, FALSE
 * switch VAR_RESULT
 * case 0, CaveOfOrigin_B1F_EventScript_AtCaveOfOrigin
 * case 1, CaveOfOrigin_B1F_EventScript_AtMtPyre
 * case 2, CaveOfOrigin_B1F_EventScript_AtSkyPillar
 * case 3, CaveOfOrigin_B1F_EventScript_DontRemember
 * goto CaveOfOrigin_B1F_EventScript_DontRemember
 * end
 * ```
 */
internal object CaveOfOrigin_B1F_EventScript_WheresRayquaza : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CaveOfOrigin_B1F_EventScript_WheresRayquaza")
}

/**
 * Ported from the decomp:
 * ```
 * message CaveOfOrigin_B1F_Text_CantYouRememberSomehow
 * waitmessage
 * goto CaveOfOrigin_B1F_EventScript_WheresRayquaza
 * ```
 */
internal object CaveOfOrigin_B1F_EventScript_DontRemember : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CaveOfOrigin_B1F.CantYouRememberSomehow)
    return CaveOfOrigin_B1F_EventScript_WheresRayquaza.run(ctx)
  }
}

internal val CaveOfOrigin_B1FScripts: Map<String, Script> =
    mapOf(
        "CaveOfOrigin_B1F_EventScript_Wallace" to CaveOfOrigin_B1F_EventScript_Wallace,
        "CaveOfOrigin_B1F_EventScript_WheresRayquaza" to
            CaveOfOrigin_B1F_EventScript_WheresRayquaza,
        "CaveOfOrigin_B1F_EventScript_DontRemember" to CaveOfOrigin_B1F_EventScript_DontRemember,
    )
