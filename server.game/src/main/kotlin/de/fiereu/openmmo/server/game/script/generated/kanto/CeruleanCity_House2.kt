package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_TM28_FROM_ROCKET, CeruleanCity_House2_EventScript_HikerGotTM28
 * msgbox CeruleanCity_House2_Text_RocketsStoleTMForDig
 * release
 * end
 * ```
 */
internal object CeruleanCity_House2_EventScript_Hiker : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_TM28_FROM_ROCKET))
        return CeruleanCity_House2_EventScript_HikerGotTM28.run(ctx)
    ctx.say(CeruleanCity_House2.RocketsStoleTMForDig)
  }
}

internal object CeruleanCity_House2_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeruleanCity_House2.TeamRocketTryingToDigIntoNoGood)
}

internal object CeruleanCity_House2_EventScript_WallHole : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity_House2.TeamRocketLeftWayOut)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeruleanCity_House2_Text_TeachDiglettDigWithoutTM
 * release
 * end
 * ```
 */
internal object CeruleanCity_House2_EventScript_HikerGotTM28 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeruleanCity_House2_EventScript_HikerGotTM28")
}

internal val CeruleanCity_House2Scripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_House2_EventScript_Hiker" to CeruleanCity_House2_EventScript_Hiker,
        "CeruleanCity_House2_EventScript_Lass" to CeruleanCity_House2_EventScript_Lass,
        "CeruleanCity_House2_EventScript_WallHole" to CeruleanCity_House2_EventScript_WallHole,
        "CeruleanCity_House2_EventScript_HikerGotTM28" to
            CeruleanCity_House2_EventScript_HikerGotTM28,
    )
