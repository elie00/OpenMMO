package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MirageTower_4F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MirageTower_4F_Text_TakeRootFossil, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MirageTower_4F_EventScript_LeaveRootFossil
 * giveitem ITEM_ROOT_FOSSIL
 * closemessage
 * setflag FLAG_HIDE_MIRAGE_TOWER_ROOT_FOSSIL
 * setflag FLAG_HIDE_MIRAGE_TOWER_CLAW_FOSSIL
 * removeobject LOCALID_MIRAGE_ROOT_FOSSIL
 * delay 30
 * setflag FLAG_CHOSE_ROOT_FOSSIL
 * goto MirageTower_4F_EventScript_CollapseMirageTower
 * end
 * ```
 */
internal object MirageTower_4F_EventScript_RootFossil : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MirageTower_4F_EventScript_RootFossil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox MirageTower_4F_Text_TakeClawFossil, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MirageTower_4F_EventScript_LeaveClawFossil
 * giveitem ITEM_CLAW_FOSSIL
 * closemessage
 * setflag FLAG_HIDE_MIRAGE_TOWER_CLAW_FOSSIL
 * setflag FLAG_HIDE_MIRAGE_TOWER_ROOT_FOSSIL
 * removeobject LOCALID_MIRAGE_CLAW_FOSSIL
 * delay 30
 * setflag FLAG_CHOSE_CLAW_FOSSIL
 * goto MirageTower_4F_EventScript_CollapseMirageTower
 * end
 * ```
 */
internal object MirageTower_4F_EventScript_ClawFossil : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MirageTower_4F_EventScript_ClawFossil")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MirageTower_4F_Text_LeftRootFossilAlone, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MirageTower_4F_EventScript_LeaveRootFossil : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MirageTower_4F.LeftRootFossilAlone)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 1   @ vertical pan
 * setvar VAR_0x8005, 1   @ horizontal pan
 * setvar VAR_0x8006, 32  @ num shakes
 * setvar VAR_0x8007, 2   @ shake delay
 * special ShakeCamera
 * waitstate
 * special DoMirageTowerCeilingCrumble
 * setvar VAR_MIRAGE_TOWER_STATE, 1
 * clearflag FLAG_LANDMARK_MIRAGE_TOWER
 * warp MAP_ROUTE111, 19, 59
 * waitstate
 * release
 * end
 * ```
 */
internal object MirageTower_4F_EventScript_CollapseMirageTower : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MirageTower_4F_EventScript_CollapseMirageTower")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MirageTower_4F_Text_LeaveClawFossilAlone, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MirageTower_4F_EventScript_LeaveClawFossil : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MirageTower_4F.LeaveClawFossilAlone)
  }
}

internal val MirageTower_4FScripts: Map<String, Script> =
    mapOf(
        "MirageTower_4F_EventScript_RootFossil" to MirageTower_4F_EventScript_RootFossil,
        "MirageTower_4F_EventScript_ClawFossil" to MirageTower_4F_EventScript_ClawFossil,
        "MirageTower_4F_EventScript_LeaveRootFossil" to MirageTower_4F_EventScript_LeaveRootFossil,
        "MirageTower_4F_EventScript_CollapseMirageTower" to
            MirageTower_4F_EventScript_CollapseMirageTower,
        "MirageTower_4F_EventScript_LeaveClawFossil" to MirageTower_4F_EventScript_LeaveClawFossil,
    )
