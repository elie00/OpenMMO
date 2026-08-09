package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ViridianCity_School
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox ViridianCity_School_Text_ReadBlackboardCarefully
 * closemessage
 * applymovement LOCALID_SCHOOL_WOMAN, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ViridianCity_School.ReadBlackboardCarefully)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox ViridianCity_School_Text_TryingToMemorizeNotes
 * closemessage
 * applymovement LOCALID_SCHOOL_LASS, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ViridianCity_School_EventScript_Lass")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * msgbox ViridianCity_School_Text_NotebookFirstPage
 * msgbox ViridianCity_School_Text_TurnThePage, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, ViridianCity_School_EventScript_StopReadingNotebook
 * msgbox ViridianCity_School_Text_NotebookSecondPage
 * msgbox ViridianCity_School_Text_TurnThePage, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, ViridianCity_School_EventScript_StopReadingNotebook
 * msgbox ViridianCity_School_Text_NotebookThirdPage
 * msgbox ViridianCity_School_Text_TurnThePage, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, ViridianCity_School_EventScript_StopReadingNotebook
 * msgbox ViridianCity_School_Text_NotebookFourthPage
 * applymovement LOCALID_SCHOOL_LASS, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * textcolor NPC_TEXT_COLOR_FEMALE
 * msgbox ViridianCity_School_Text_HeyDontLookAtMyNotes
 * releaseall
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_Notebook : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ViridianCity_School_EventScript_Notebook")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * msgbox ViridianCity_School_Text_BlackboardListsStatusProblems
 * goto ViridianCity_School_EventScript_ChooseBlackboardTopic
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_Blackboard : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ViridianCity_School.BlackboardListsStatusProblems)
    return ViridianCity_School_EventScript_ChooseBlackboardTopic.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_OAK, 3
 * famechecker FAMECHECKER_DAISY, 3
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PokemonJournal_Text_SpecialFeatureProfOak
 * release
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_PokemonJournal : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ViridianCity_School_EventScript_PokemonJournal")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message ViridianCity_School_Text_ReadWhichTopic
 * waitmessage
 * multichoicegrid 7, 1, MULTICHOICE_TRAINER_SCHOOL_WHITEBOARD, 3, FALSE
 * switch VAR_RESULT
 * case 0, ViridianCity_School_EventScript_ReadSleep
 * case 1, ViridianCity_School_EventScript_ReadPoison
 * case 2, ViridianCity_School_EventScript_ReadParalysis
 * case 3, ViridianCity_School_EventScript_ReadBurn
 * case 4, ViridianCity_School_EventScript_ReadFreeze
 * case 5, ViridianCity_School_EventScript_ExitBlackboard
 * case 127, ViridianCity_School_EventScript_ExitBlackboard
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_ChooseBlackboardTopic : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ViridianCity_School_EventScript_ChooseBlackboardTopic")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * releaseall
 * end
 * ```
 */
internal object ViridianCity_School_EventScript_StopReadingNotebook : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ViridianCity_School_EventScript_StopReadingNotebook")
}

internal val ViridianCity_SchoolScripts: Map<String, Script> =
    mapOf(
        "ViridianCity_School_EventScript_Woman" to ViridianCity_School_EventScript_Woman,
        "ViridianCity_School_EventScript_Lass" to ViridianCity_School_EventScript_Lass,
        "ViridianCity_School_EventScript_Notebook" to ViridianCity_School_EventScript_Notebook,
        "ViridianCity_School_EventScript_Blackboard" to ViridianCity_School_EventScript_Blackboard,
        "ViridianCity_School_EventScript_PokemonJournal" to
            ViridianCity_School_EventScript_PokemonJournal,
        "ViridianCity_School_EventScript_ChooseBlackboardTopic" to
            ViridianCity_School_EventScript_ChooseBlackboardTopic,
        "ViridianCity_School_EventScript_StopReadingNotebook" to
            ViridianCity_School_EventScript_StopReadingNotebook,
    )
