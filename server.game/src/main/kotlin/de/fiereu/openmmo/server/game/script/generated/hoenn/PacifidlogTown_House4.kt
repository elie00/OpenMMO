package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.PacifidlogTown_House4
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object PacifidlogTown_House4_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(PacifidlogTown_House4.PeopleSawHighFlyingPokemon)
}

internal object PacifidlogTown_House4_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(PacifidlogTown_House4.SkyPokemon)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox PacifidlogTown_House4_Text_WhereDidYouComeFrom, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, PacifidlogTown_House4_EventScript_Yes
 * goto_if_eq VAR_RESULT, NO, PacifidlogTown_House4_EventScript_No
 * end
 * ```
 */
internal object PacifidlogTown_House4_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PacifidlogTown_House4_EventScript_Boy")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PacifidlogTown_House4_Text_YesTown, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House4_EventScript_Yes : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PacifidlogTown_House4.YesTown)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PacifidlogTown_House4_Text_YouHaveToComeFromSomewhere, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object PacifidlogTown_House4_EventScript_No : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PacifidlogTown_House4.YouHaveToComeFromSomewhere)
  }
}

internal val PacifidlogTown_House4Scripts: Map<String, Script> =
    mapOf(
        "PacifidlogTown_House4_EventScript_Woman" to PacifidlogTown_House4_EventScript_Woman,
        "PacifidlogTown_House4_EventScript_LittleGirl" to
            PacifidlogTown_House4_EventScript_LittleGirl,
        "PacifidlogTown_House4_EventScript_Boy" to PacifidlogTown_House4_EventScript_Boy,
        "PacifidlogTown_House4_EventScript_Yes" to PacifidlogTown_House4_EventScript_Yes,
        "PacifidlogTown_House4_EventScript_No" to PacifidlogTown_House4_EventScript_No,
    )
