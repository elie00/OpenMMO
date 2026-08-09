package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_CHOSE_ROOT_FOSSIL, DesertUnderpass_EventScript_GiveClawFossil
 * goto_if_set FLAG_CHOSE_CLAW_FOSSIL, DesertUnderpass_EventScript_GiveRootFossil
 * release
 * end
 * ```
 */
internal object DesertUnderpass_EventScript_Fossil : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_CHOSE_ROOT_FOSSIL))
        return DesertUnderpass_EventScript_GiveClawFossil.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_CHOSE_CLAW_FOSSIL))
        return DesertUnderpass_EventScript_GiveRootFossil.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * giveitem ITEM_ROOT_FOSSIL
 * removeobject LOCALID_UNDERPASS_FOSSIL
 * release
 * end
 * ```
 */
internal object DesertUnderpass_EventScript_GiveRootFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DesertUnderpass_EventScript_GiveRootFossil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * giveitem ITEM_CLAW_FOSSIL
 * removeobject LOCALID_UNDERPASS_FOSSIL
 * release
 * end
 * ```
 */
internal object DesertUnderpass_EventScript_GiveClawFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port DesertUnderpass_EventScript_GiveClawFossil")
}

internal val DesertUnderpassScripts: Map<String, Script> =
    mapOf(
        "DesertUnderpass_EventScript_Fossil" to DesertUnderpass_EventScript_Fossil,
        "DesertUnderpass_EventScript_GiveRootFossil" to DesertUnderpass_EventScript_GiveRootFossil,
        "DesertUnderpass_EventScript_GiveClawFossil" to DesertUnderpass_EventScript_GiveClawFossil,
    )
