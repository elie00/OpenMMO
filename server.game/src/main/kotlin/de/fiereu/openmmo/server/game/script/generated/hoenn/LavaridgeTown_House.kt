package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.LavaridgeTown_House
import de.fiereu.openmmo.dialog.generated.hoenn.MoveTutor
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object LavaridgeTown_House_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LavaridgeTown_House.WifeWarmingEggInHotSprings)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_ZIGZAGOON, CRY_MODE_NORMAL
 * msgbox LavaridgeTown_House_Text_Zigzagoon, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object LavaridgeTown_House_EventScript_Zigzagoon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavaridgeTown_House_EventScript_Zigzagoon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MOVE_TUTOR_TAUGHT_MIMIC, MoveTutor_EventScript_MimicTaught
 * msgbox MoveTutor_MimicTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_MimicDeclined
 * call MoveTutor_EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_MimicDeclined
 * msgbox MoveTutor_Text_MimicWhichMon, MSGBOX_DEFAULT
 * setvar VAR_0x8005, TUTOR_MOVE_MIMIC
 * call MoveTutor_EventScript_OpenPartyMenu
 * goto_if_eq VAR_RESULT, 0, MoveTutor_EventScript_MimicDeclined
 * setflag FLAG_MOVE_TUTOR_TAUGHT_MIMIC
 * goto MoveTutor_EventScript_MimicTaught
 * end
 * ```
 */
internal object LavaridgeTown_House_EventScript_MimicTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LavaridgeTown_House_EventScript_MimicTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MoveTutor_MimicDeclined, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_MimicDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port MoveTutor_EventScript_MimicDeclined")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_MimicTaught, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_MimicTaught : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.MimicTaught)
  }
}

internal val LavaridgeTown_HouseScripts: Map<String, Script> =
    mapOf(
        "LavaridgeTown_House_EventScript_OldMan" to LavaridgeTown_House_EventScript_OldMan,
        "LavaridgeTown_House_EventScript_Zigzagoon" to LavaridgeTown_House_EventScript_Zigzagoon,
        "LavaridgeTown_House_EventScript_MimicTutor" to LavaridgeTown_House_EventScript_MimicTutor,
        "MoveTutor_EventScript_MimicDeclined" to MoveTutor_EventScript_MimicDeclined,
        "MoveTutor_EventScript_MimicTaught" to MoveTutor_EventScript_MimicTaught,
    )
