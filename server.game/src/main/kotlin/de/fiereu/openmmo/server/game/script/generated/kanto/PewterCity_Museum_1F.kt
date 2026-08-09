package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PewterCity_Museum_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_FACING, DIR_WEST, PewterCity_Museum_1F_EventScript_Scientist1BehindCounter
 * goto_if_eq VAR_FACING, DIR_SOUTH, PewterCity_Museum_1F_EventScript_Scientist1BehindCounter
 * goto_if_eq VAR_FACING, DIR_NORTH, PewterCity_Museum_1F_EventScript_Scientist1BehindCounter
 * msgbox PewterCity_Museum_1F_Text_PleaseEnjoyYourself
 * release
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_Scientist1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_Scientist1")
}

internal object PewterCity_Museum_1F_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(PewterCity_Museum_1F.ShouldBeGratefulForLongLife)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_OLD_AMBER, PewterCity_Museum_1F_EventScript_AlreadyGotOldAmber
 * msgbox PewterCity_Museum_1F_Text_WantYouToGetAmberExamined
 * checkitemspace ITEM_OLD_AMBER
 * goto_if_eq VAR_RESULT, FALSE, PewterCity_Museum_1F_EventScript_NoRoomForOldAmber
 * setflag FLAG_GOT_OLD_AMBER
 * removeobject LOCALID_OLD_AMBER
 * giveitem_msg PewterCity_Museum_1F_Text_ReceivedOldAmberFromMan, ITEM_OLD_AMBER, 1, MUS_OBTAIN_KEY_ITEM
 * release
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_OldAmberScientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_OldAmberScientist")
}

internal object PewterCity_Museum_1F_EventScript_OldAmber : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(PewterCity_Museum_1F.BeautifulPieceOfAmber)
}

internal object PewterCity_Museum_1F_EventScript_Scientist2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(PewterCity_Museum_1F.WeHaveTwoFossilsOnExhibit)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_SEISMIC_TOSS, EventScript_SeismicTossTaught
 * msgbox Text_SeismicTossTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_SeismicTossDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_SeismicTossDeclined
 * msgbox Text_SeismicTossWhichMon
 * setvar VAR_0x8005, MOVETUTOR_SEISMIC_TOSS
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_SeismicTossDeclined
 * setflag FLAG_TUTOR_SEISMIC_TOSS
 * goto EventScript_SeismicTossTaught
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_SeismicTossTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_SeismicTossTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8004, SPECIES_AERODACTYL
 * setvar VAR_0x8005, 10
 * setvar VAR_0x8006, 3
 * special OpenMuseumFossilPic
 * msgbox PewterCity_Museum_1F_Text_AerodactylFossil
 * special CloseMuseumFossilPic
 * releaseall
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_AerodactylFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_AerodactylFossil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_0x8004, SPECIES_KABUTOPS
 * setvar VAR_0x8005, 10
 * setvar VAR_0x8006, 3
 * special OpenMuseumFossilPic
 * msgbox PewterCity_Museum_1F_Text_KabutopsFossil
 * special CloseMuseumFossilPic
 * releaseall
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_KabutopsFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_KabutopsFossil")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * famechecker FAMECHECKER_BROCK, 5
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox PokemonJournal_Text_SpecialFeatureBrock
 * releaseall
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_PokemonJournalBrock : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_PokemonJournalBrock")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PewterCity_Museum_1F_Text_GetOldAmberChecked
 * release
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_AlreadyGotOldAmber : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity_Museum_1F.GetOldAmberChecked)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SeismicTossTaught
 * release
 * end
 * ```
 */
internal object EventScript_SeismicTossTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SeismicTossTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_SeismicTossDeclined
 * release
 * end
 * ```
 */
internal object EventScript_SeismicTossDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_SeismicTossDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox PewterCity_Museum_1F_Text_DoYouKnowWhatAmberIs, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, PewterCity_Museum_1F_EventScript_AmberHasGeneticMatter
 * goto_if_eq VAR_RESULT, NO, PewterCity_Museum_1F_EventScript_ExplainAmber
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_Scientist1BehindCounter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PewterCity_Museum_1F_EventScript_Scientist1BehindCounter")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PewterCity_Museum_1F_Text_DontHaveSpaceForThis
 * release
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_NoRoomForOldAmber : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity_Museum_1F.DontHaveSpaceForThis)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PewterCity_Museum_1F_Text_AmberIsFossilizedSap
 * applymovement LOCALID_MUSEUM_SCIENTIST1, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_ExplainAmber : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity_Museum_1F.AmberIsFossilizedSap)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PewterCity_Museum_1F_Text_AmberContainsGeneticMatter
 * applymovement LOCALID_MUSEUM_SCIENTIST1, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object PewterCity_Museum_1F_EventScript_AmberHasGeneticMatter : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity_Museum_1F.AmberContainsGeneticMatter)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

internal val PewterCity_Museum_1FScripts: Map<String, Script> =
    mapOf(
        "PewterCity_Museum_1F_EventScript_Scientist1" to
            PewterCity_Museum_1F_EventScript_Scientist1,
        "PewterCity_Museum_1F_EventScript_OldMan" to PewterCity_Museum_1F_EventScript_OldMan,
        "PewterCity_Museum_1F_EventScript_OldAmberScientist" to
            PewterCity_Museum_1F_EventScript_OldAmberScientist,
        "PewterCity_Museum_1F_EventScript_OldAmber" to PewterCity_Museum_1F_EventScript_OldAmber,
        "PewterCity_Museum_1F_EventScript_Scientist2" to
            PewterCity_Museum_1F_EventScript_Scientist2,
        "PewterCity_Museum_1F_EventScript_SeismicTossTutor" to
            PewterCity_Museum_1F_EventScript_SeismicTossTutor,
        "PewterCity_Museum_1F_EventScript_AerodactylFossil" to
            PewterCity_Museum_1F_EventScript_AerodactylFossil,
        "PewterCity_Museum_1F_EventScript_KabutopsFossil" to
            PewterCity_Museum_1F_EventScript_KabutopsFossil,
        "PewterCity_Museum_1F_EventScript_PokemonJournalBrock" to
            PewterCity_Museum_1F_EventScript_PokemonJournalBrock,
        "PewterCity_Museum_1F_EventScript_AlreadyGotOldAmber" to
            PewterCity_Museum_1F_EventScript_AlreadyGotOldAmber,
        "EventScript_SeismicTossTaught" to EventScript_SeismicTossTaught,
        "EventScript_SeismicTossDeclined" to EventScript_SeismicTossDeclined,
        "PewterCity_Museum_1F_EventScript_Scientist1BehindCounter" to
            PewterCity_Museum_1F_EventScript_Scientist1BehindCounter,
        "PewterCity_Museum_1F_EventScript_NoRoomForOldAmber" to
            PewterCity_Museum_1F_EventScript_NoRoomForOldAmber,
        "PewterCity_Museum_1F_EventScript_ExplainAmber" to
            PewterCity_Museum_1F_EventScript_ExplainAmber,
        "PewterCity_Museum_1F_EventScript_AmberHasGeneticMatter" to
            PewterCity_Museum_1F_EventScript_AmberHasGeneticMatter,
    )
