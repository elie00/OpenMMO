package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_Mart
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message gText_HowMayIServeYou
 * waitmessage
 * pokemart SootopolisCity_Mart_Pokemart
 * msgbox gText_PleaseComeAgain, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Mart_EventScript_Clerk : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_Mart_EventScript_Clerk")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SKY_PILLAR_STATE, 2, SootopolisCity_Mart_EventScript_FatManNoLegendaries
 * goto_if_unset FLAG_KYOGRE_ESCAPED_SEAFLOOR_CAVERN, SootopolisCity_Mart_EventScript_FatManNoLegendaries
 * msgbox SootopolisCity_Mart_Text_TooScaryOutside, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Mart_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SootopolisCity_Mart_EventScript_FatMan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SKY_PILLAR_STATE, 2, SootopolisCity_Mart_EventScript_GentlemanNoLegendaries
 * goto_if_unset FLAG_KYOGRE_ESCAPED_SEAFLOOR_CAVERN, SootopolisCity_Mart_EventScript_GentlemanNoLegendaries
 * msgbox SootopolisCity_Mart_Text_DidSomethingAwaken, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Mart_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_Mart_EventScript_Gentleman")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Mart_Text_FullRestoreItemOfDreams, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Mart_EventScript_GentlemanNoLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_Mart.FullRestoreItemOfDreams)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_Mart_Text_PPUpIsGreat, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_Mart_EventScript_FatManNoLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_Mart.PPUpIsGreat)
  }
}

internal val SootopolisCity_MartScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_Mart_EventScript_Clerk" to SootopolisCity_Mart_EventScript_Clerk,
        "SootopolisCity_Mart_EventScript_FatMan" to SootopolisCity_Mart_EventScript_FatMan,
        "SootopolisCity_Mart_EventScript_Gentleman" to SootopolisCity_Mart_EventScript_Gentleman,
        "SootopolisCity_Mart_EventScript_GentlemanNoLegendaries" to
            SootopolisCity_Mart_EventScript_GentlemanNoLegendaries,
        "SootopolisCity_Mart_EventScript_FatManNoLegendaries" to
            SootopolisCity_Mart_EventScript_FatManNoLegendaries,
    )
