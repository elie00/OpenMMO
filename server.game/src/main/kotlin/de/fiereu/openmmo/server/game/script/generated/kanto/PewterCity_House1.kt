package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PewterCity_House1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object PewterCity_House1_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(PewterCity_House1.TradeMonsAreFinicky)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * msgbox PewterCity_House1_Text_NidoranSit
 * call PewterCity_House1_EventScript_DoNidoranCry
 * release
 * end
 * ```
 */
internal object PewterCity_House1_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity_House1.NidoranSit)
    PewterCity_House1_EventScript_DoNidoranCry.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call PewterCity_House1_EventScript_DoNidoranCry
 * applymovement LOCALID_PEWTER_HOUSE_NIDORAN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object PewterCity_House1_EventScript_Nidoran : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port PewterCity_House1_EventScript_Nidoran")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * waitse
 * playmoncry SPECIES_NIDORAN_M, CRY_MODE_NORMAL
 * msgbox PewterCity_House1_Text_Nidoran
 * waitmoncry
 * call EventScript_RestorePrevTextColor
 * return
 * ```
 */
internal object PewterCity_House1_EventScript_DoNidoranCry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_House1_EventScript_DoNidoranCry")
}

internal val PewterCity_House1Scripts: Map<String, Script> =
    mapOf(
        "PewterCity_House1_EventScript_BaldingMan" to PewterCity_House1_EventScript_BaldingMan,
        "PewterCity_House1_EventScript_LittleBoy" to PewterCity_House1_EventScript_LittleBoy,
        "PewterCity_House1_EventScript_Nidoran" to PewterCity_House1_EventScript_Nidoran,
        "PewterCity_House1_EventScript_DoNidoranCry" to PewterCity_House1_EventScript_DoNidoranCry,
    )
