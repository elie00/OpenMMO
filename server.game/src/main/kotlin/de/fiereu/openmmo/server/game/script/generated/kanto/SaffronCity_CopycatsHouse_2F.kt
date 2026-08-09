package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_CopycatsHouse_2F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_DODUO, CRY_MODE_NORMAL
 * msgbox SaffronCity_CopycatsHouse_2F_Text_Doduo
 * waitmoncry
 * release
 * end
 * ```
 */
internal object SaffronCity_CopycatsHouse_2F_EventScript_Doduo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_CopycatsHouse_2F_EventScript_Doduo")
}

internal object SaffronCity_CopycatsHouse_2F_EventScript_Doll : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(SaffronCity_CopycatsHouse_2F.RareMonOnlyDoll)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * special QuestLog_CutRecording
 * lock
 * faceplayer
 * checkitem ITEM_POKE_DOLL
 * goto_if_eq VAR_RESULT, TRUE, EventScript_MimicTutor
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerMale
 * call_if_eq VAR_RESULT, FEMALE, SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerFemale
 * release
 * end
 * ```
 */
internal object SaffronCity_CopycatsHouse_2F_EventScript_Copycat : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SaffronCity_CopycatsHouse_2F_EventScript_Copycat")
}

internal object SaffronCity_CopycatsHouse_2F_EventScript_Computer : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SaffronCity_CopycatsHouse_2F.MySecrets)
}

internal object SaffronCity_CopycatsHouse_2F_EventScript_Game : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SaffronCity_CopycatsHouse_2F.MarioWearingABucket)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_CopycatsHouse_2F_Text_MimickingFavoriteHobbyFemale
 * return
 * ```
 */
internal object SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerFemale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_CopycatsHouse_2F.MimickingFavoriteHobbyFemale)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_TUTOR_MIMIC, EventScript_MimicTaught
 * msgbox Text_MimicTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_MimicDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_MimicDeclined
 * msgbox Text_MimicWhichMon
 * setvar VAR_0x8005, MOVETUTOR_MIMIC
 * call EventScript_ChooseMoveTutorMon
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, 0, EventScript_MimicDeclined
 * removeitem ITEM_POKE_DOLL
 * setflag FLAG_TUTOR_MIMIC
 * goto EventScript_MimicTaught
 * end
 * ```
 */
internal object EventScript_MimicTutor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MimicTutor")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SaffronCity_CopycatsHouse_2F_Text_MimickingFavoriteHobbyMale
 * return
 * ```
 */
internal object SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerMale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_CopycatsHouse_2F.MimickingFavoriteHobbyMale)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MimicDeclined
 * release
 * end
 * ```
 */
internal object EventScript_MimicDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MimicDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * call_if_eq VAR_RESULT, MALE, EventScript_MimicTaughtMale
 * call_if_eq VAR_RESULT, FEMALE, EventScript_MimicTaughtFemale
 * release
 * end
 * ```
 */
internal object EventScript_MimicTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MimicTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MimicTaughtFemale
 * return
 * ```
 */
internal object EventScript_MimicTaughtFemale : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MimicTaughtFemale")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MimicTaughtMale
 * return
 * ```
 */
internal object EventScript_MimicTaughtMale : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MimicTaughtMale")
}

internal val SaffronCity_CopycatsHouse_2FScripts: Map<String, Script> =
    mapOf(
        "SaffronCity_CopycatsHouse_2F_EventScript_Doduo" to
            SaffronCity_CopycatsHouse_2F_EventScript_Doduo,
        "SaffronCity_CopycatsHouse_2F_EventScript_Doll" to
            SaffronCity_CopycatsHouse_2F_EventScript_Doll,
        "SaffronCity_CopycatsHouse_2F_EventScript_Copycat" to
            SaffronCity_CopycatsHouse_2F_EventScript_Copycat,
        "SaffronCity_CopycatsHouse_2F_EventScript_Computer" to
            SaffronCity_CopycatsHouse_2F_EventScript_Computer,
        "SaffronCity_CopycatsHouse_2F_EventScript_Game" to
            SaffronCity_CopycatsHouse_2F_EventScript_Game,
        "SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerFemale" to
            SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerFemale,
        "EventScript_MimicTutor" to EventScript_MimicTutor,
        "SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerMale" to
            SaffronCity_CopycatsHouse_2F_EventScript_MimicPlayerMale,
        "EventScript_MimicDeclined" to EventScript_MimicDeclined,
        "EventScript_MimicTaught" to EventScript_MimicTaught,
        "EventScript_MimicTaughtFemale" to EventScript_MimicTaughtFemale,
        "EventScript_MimicTaughtMale" to EventScript_MimicTaughtMale,
    )
