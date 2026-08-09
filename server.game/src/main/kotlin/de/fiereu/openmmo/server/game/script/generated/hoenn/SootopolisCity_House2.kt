package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox SootopolisCity_House2_Text_DidYouKnowAboutMtPyreOrbs, MSGBOX_YESNO
 * call_if_eq VAR_RESULT, YES, SootopolisCity_House2_EventScript_KnowAboutOrbs
 * call_if_eq VAR_RESULT, NO, SootopolisCity_House2_EventScript_DontKnowAboutOrbs
 * release
 * end
 * ```
 */
internal object SootopolisCity_House2_EventScript_ExpertF : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_House2_EventScript_ExpertF")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_House2_Text_YesTwoOrbsSideBySide, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object SootopolisCity_House2_EventScript_KnowAboutOrbs : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_House2.YesTwoOrbsSideBySide)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_House2_Text_OughtToVisitAndSee, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object SootopolisCity_House2_EventScript_DontKnowAboutOrbs : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_House2.OughtToVisitAndSee)
  }
}

internal val SootopolisCity_House2Scripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_House2_EventScript_ExpertF" to SootopolisCity_House2_EventScript_ExpertF,
        "SootopolisCity_House2_EventScript_KnowAboutOrbs" to
            SootopolisCity_House2_EventScript_KnowAboutOrbs,
        "SootopolisCity_House2_EventScript_DontKnowAboutOrbs" to
            SootopolisCity_House2_EventScript_DontKnowAboutOrbs,
    )
