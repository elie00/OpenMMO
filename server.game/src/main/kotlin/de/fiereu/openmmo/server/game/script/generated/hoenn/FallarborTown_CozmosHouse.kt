package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FallarborTown_CozmosHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_TM_RETURN, FallarborTown_CozmosHouse_EventScript_GaveMeteorite
 * checkitem ITEM_METEORITE
 * goto_if_eq VAR_RESULT, TRUE, FallarborTown_CozmosHouse_EventScript_PlayerHasMeteorite
 * msgbox FallarborTown_CozmosHouse_Text_MeteoriteWillNeverBeMineNow, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_ProfCozmo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_CozmosHouse_EventScript_ProfCozmo")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_TM_RETURN, FallarborTown_CozmosHouse_EventScript_CozmoIsHappy
 * goto_if_set FLAG_DEFEATED_EVIL_TEAM_MT_CHIMNEY, FallarborTown_CozmosHouse_EventScript_CozmoIsSad
 * msgbox FallarborTown_CozmosHouse_Text_CozmoWentToMeteorFalls, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_CozmosWife : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_TM_RETURN))
        return FallarborTown_CozmosHouse_EventScript_CozmoIsHappy.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_EVIL_TEAM_MT_CHIMNEY))
        return FallarborTown_CozmosHouse_EventScript_CozmoIsSad.run(ctx)
    ctx.say(FallarborTown_CozmosHouse.CozmoWentToMeteorFalls)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_unset FLAG_TEMP_2, FallarborTown_CozmosHouse_EventScript_NoticeMeteorite
 * call_if_set FLAG_TEMP_2, FallarborTown_CozmosHouse_EventScript_AskForMeteorite
 * goto_if_eq VAR_RESULT, NO, FallarborTown_CozmosHouse_EventScript_DeclineGiveMeteorite
 * msgbox FallarborTown_CozmosHouse_Text_PleaseUseThisTM, MSGBOX_DEFAULT
 * giveitem ITEM_TM_RETURN
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setvar VAR_0x8004, ITEM_METEORITE
 * call Common_EventScript_PlayerHandedOverTheItem
 * setflag FLAG_RECEIVED_TM_RETURN
 * msgbox FallarborTown_CozmosHouse_Text_ReallyGoingToHelpMyResearch, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_PlayerHasMeteorite : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_CozmosHouse_EventScript_PlayerHasMeteorite")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_CozmosHouse_Text_CozmoIsSoHappy, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_CozmoIsHappy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown_CozmosHouse.CozmoIsSoHappy)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_CozmosHouse_Text_ReallyGoingToHelpMyResearch, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_GaveMeteorite : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown_CozmosHouse.ReallyGoingToHelpMyResearch)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_CozmosHouse_Text_FeelSorryForCozmo, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_CozmoIsSad : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown_CozmosHouse.FeelSorryForCozmo)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FallarborTown_CozmosHouse_Text_MayIHaveMeteorite, MSGBOX_YESNO
 * return
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_AskForMeteorite : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_CozmosHouse_EventScript_AskForMeteorite")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_TEMP_2
 * msgbox FallarborTown_CozmosHouse_Text_CrushedWithDisappointment, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_DeclineGiveMeteorite : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_CozmosHouse_EventScript_DeclineGiveMeteorite")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FallarborTown_CozmosHouse_Text_MeteoriteWillNeverBeMineNow, MSGBOX_DEFAULT
 * msgbox FallarborTown_CozmosHouse_Text_IsThatMeteoriteMayIHaveIt, MSGBOX_YESNO
 * return
 * ```
 */
internal object FallarborTown_CozmosHouse_EventScript_NoticeMeteorite : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FallarborTown_CozmosHouse_EventScript_NoticeMeteorite")
}

internal val FallarborTown_CozmosHouseScripts: Map<String, Script> =
    mapOf(
        "FallarborTown_CozmosHouse_EventScript_ProfCozmo" to
            FallarborTown_CozmosHouse_EventScript_ProfCozmo,
        "FallarborTown_CozmosHouse_EventScript_CozmosWife" to
            FallarborTown_CozmosHouse_EventScript_CozmosWife,
        "FallarborTown_CozmosHouse_EventScript_PlayerHasMeteorite" to
            FallarborTown_CozmosHouse_EventScript_PlayerHasMeteorite,
        "FallarborTown_CozmosHouse_EventScript_CozmoIsHappy" to
            FallarborTown_CozmosHouse_EventScript_CozmoIsHappy,
        "FallarborTown_CozmosHouse_EventScript_GaveMeteorite" to
            FallarborTown_CozmosHouse_EventScript_GaveMeteorite,
        "FallarborTown_CozmosHouse_EventScript_CozmoIsSad" to
            FallarborTown_CozmosHouse_EventScript_CozmoIsSad,
        "FallarborTown_CozmosHouse_EventScript_AskForMeteorite" to
            FallarborTown_CozmosHouse_EventScript_AskForMeteorite,
        "FallarborTown_CozmosHouse_EventScript_DeclineGiveMeteorite" to
            FallarborTown_CozmosHouse_EventScript_DeclineGiveMeteorite,
        "FallarborTown_CozmosHouse_EventScript_NoticeMeteorite" to
            FallarborTown_CozmosHouse_EventScript_NoticeMeteorite,
    )
