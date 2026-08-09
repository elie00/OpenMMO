package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SafariZone_South
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_GOOD_LUCK_SAFARI_ZONE, SafariZone_South_EventScript_GoodLuck
 * msgbox SafariZone_South_Text_StillHaveTimeExit, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, SafariZone_South_EventScript_ExitEarly
 * msgbox SafariZone_South_Text_EnjoyTheRestOfYourAdventure, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SafariZone_South_EventScript_ExitAttendant : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SafariZone_South_EventScript_ExitAttendant")
}

internal object SafariZone_South_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_South.Boy)
}

internal object SafariZone_South_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_South.Man)
}

internal object SafariZone_South_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_South.Youngster)
}

internal object SafariZone_South_EventScript_ConstructionWorker1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_South.AreaOffLimits1)
}

internal object SafariZone_South_EventScript_ConstructionWorker2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SafariZone_South.AreaOffLimits2)
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_GOOD_LUCK_SAFARI_ZONE
 * msgbox SafariZone_South_Text_GoodLuck, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SafariZone_South_EventScript_GoodLuck : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_GOOD_LUCK_SAFARI_ZONE)
    ctx.say(SafariZone_South.GoodLuck)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SafariZone_South_Text_ExitEarlyThankYouForPlaying, MSGBOX_DEFAULT
 * closemessage
 * switch VAR_FACING
 * case DIR_NORTH, SafariZone_South_EventScript_ExitEarlyNorth
 * case DIR_EAST, SafariZone_South_EventScript_ExitEarlyEast
 * end
 * ```
 */
internal object SafariZone_South_EventScript_ExitEarly : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SafariZone_South_EventScript_ExitEarly")
}

internal val SafariZone_SouthScripts: Map<String, Script> =
    mapOf(
        "SafariZone_South_EventScript_ExitAttendant" to SafariZone_South_EventScript_ExitAttendant,
        "SafariZone_South_EventScript_Boy" to SafariZone_South_EventScript_Boy,
        "SafariZone_South_EventScript_Man" to SafariZone_South_EventScript_Man,
        "SafariZone_South_EventScript_Youngster" to SafariZone_South_EventScript_Youngster,
        "SafariZone_South_EventScript_ConstructionWorker1" to
            SafariZone_South_EventScript_ConstructionWorker1,
        "SafariZone_South_EventScript_ConstructionWorker2" to
            SafariZone_South_EventScript_ConstructionWorker2,
        "SafariZone_South_EventScript_GoodLuck" to SafariZone_South_EventScript_GoodLuck,
        "SafariZone_South_EventScript_ExitEarly" to SafariZone_South_EventScript_ExitEarly,
    )
