package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_SWORDS_DANCE, EventScript_SwordsDanceTaught
 * msgbox Text_SwordsDanceTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_SwordsDanceDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_SwordsDanceDeclined
 * msgbox Text_SwordsDanceWhichMon
 * setvar VAR_0x8005, MOVETUTOR_SWORDS_DANCE
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_SwordsDanceDeclined
 * setflag FLAG_TUTOR_SWORDS_DANCE
 * goto EventScript_SwordsDanceTaught
 * end
 * ```
 */
internal object SevenIsland_EventScript_SwordsDanceTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_EventScript_SwordsDanceTutor")
}

internal object SevenIsland_EventScript_OldWoman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SevenIsland.IslandsMadeInSevenDays)
}

internal object SevenIsland_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SevenIsland.IslandVirtuallyUntouched)
}

internal object SevenIsland_EventScript_IslandSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SevenIsland.IslandSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SwordsDanceTaught
 * release
 * end
 * ```
 */
internal object EventScript_SwordsDanceTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SwordsDanceTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SwordsDanceDeclined
 * release
 * end
 * ```
 */
internal object EventScript_SwordsDanceDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SwordsDanceDeclined")
}

internal val SevenIslandScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_EventScript_SwordsDanceTutor" to SevenIsland_EventScript_SwordsDanceTutor,
        "SevenIsland_EventScript_OldWoman" to SevenIsland_EventScript_OldWoman,
        "SevenIsland_EventScript_Scientist" to SevenIsland_EventScript_Scientist,
        "SevenIsland_EventScript_IslandSign" to SevenIsland_EventScript_IslandSign,
        "EventScript_SwordsDanceTaught" to EventScript_SwordsDanceTaught,
        "EventScript_SwordsDanceDeclined" to EventScript_SwordsDanceDeclined,
    )
