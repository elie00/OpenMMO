package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route114_LanettesHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_DOLL_LANETTE, Route114_LanettesHouse_EventScript_OfferAdvice
 * setflag FLAG_SYS_PC_LANETTE
 * msgbox Route114_LanettesHouse_Text_EverythingClutteredKeepThis, MSGBOX_DEFAULT
 * givedecoration DECOR_LOTAD_DOLL
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowNoRoomForDecor
 * setflag FLAG_RECEIVED_DOLL_LANETTE
 * release
 * end
 * ```
 */
internal object Route114_LanettesHouse_EventScript_Lanette : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route114_LanettesHouse_EventScript_Lanette")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * msgbox Route114_LanettesHouse_Text_ResearchNotesPage1, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route114_LanettesHouse_EventScript_NotebookPage2
 * msgbox Route114_LanettesHouse_Text_ClosedTheNotebook, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object Route114_LanettesHouse_EventScript_Notebook : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route114_LanettesHouse_EventScript_Notebook")
}

internal object Route114_LanettesHouse_EventScript_PC : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route114_LanettesHouse.EmailFromBill)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route114_LanettesHouse_Text_ResearchNotesPage2, MSGBOX_YESNO
 * call_if_eq VAR_RESULT, YES, Route114_LanettesHouse_EventScript_NotebookPage3
 * releaseall
 * end
 * ```
 */
internal object Route114_LanettesHouse_EventScript_NotebookPage2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route114_LanettesHouse_EventScript_NotebookPage2")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route114_LanettesHouse_Text_OrganizeYourBoxes, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route114_LanettesHouse_EventScript_OfferAdvice : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route114_LanettesHouse.OrganizeYourBoxes)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route114_LanettesHouse_Text_ResearchNotesPage3, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object Route114_LanettesHouse_EventScript_NotebookPage3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route114_LanettesHouse.ResearchNotesPage3)
  }
}

internal val Route114_LanettesHouseScripts: Map<String, Script> =
    mapOf(
        "Route114_LanettesHouse_EventScript_Lanette" to Route114_LanettesHouse_EventScript_Lanette,
        "Route114_LanettesHouse_EventScript_Notebook" to
            Route114_LanettesHouse_EventScript_Notebook,
        "Route114_LanettesHouse_EventScript_PC" to Route114_LanettesHouse_EventScript_PC,
        "Route114_LanettesHouse_EventScript_NotebookPage2" to
            Route114_LanettesHouse_EventScript_NotebookPage2,
        "Route114_LanettesHouse_EventScript_OfferAdvice" to
            Route114_LanettesHouse_EventScript_OfferAdvice,
        "Route114_LanettesHouse_EventScript_NotebookPage3" to
            Route114_LanettesHouse_EventScript_NotebookPage3,
    )
