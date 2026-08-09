package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route109_SeashoreHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_6_SODA_POP, Route109_SeashoreHouse_EventScript_AlreadyReceivedSodaPop
 * goto_if_set FLAG_DEFEATED_SEASHORE_HOUSE, Route109_SeashoreHouse_EventScript_DefeatedTrainers
 * goto_if_set FLAG_TEMP_2, Route109_SeashoreHouse_EventScript_AlreadyGaveIntroduction
 * msgbox Route109_SeashoreHouse_Text_SeashoreHouseIntro, MSGBOX_DEFAULT
 * setflag FLAG_TEMP_2
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_Owner : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_Owner")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_DWAYNE, Route109_SeashoreHouse_Text_DwayneIntro, Route109_SeashoreHouse_Text_DwayneDefeated, Route109_SeashoreHouse_EventScript_CheckTrainersCompletion
 * msgbox Route109_SeashoreHouse_Text_DwaynePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_Dwayne : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_Dwayne")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SIMON, Route109_SeashoreHouse_Text_SimonIntro, Route109_SeashoreHouse_Text_SimonDefeated, Route109_SeashoreHouse_EventScript_CheckTrainersCompletion
 * msgbox Route109_SeashoreHouse_Text_SimonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_Simon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_Simon")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JOHANNA, Route109_SeashoreHouse_Text_JohannaIntro, Route109_SeashoreHouse_Text_JohannaDefeated, Route109_SeashoreHouse_EventScript_CheckTrainersCompletion
 * msgbox Route109_SeashoreHouse_Text_JohannaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_Johanna : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_Johanna")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * showmoneybox 0, 0
 * msgbox Route109_SeashoreHouse_Text_WantToBuySodaPop, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route109_SeashoreHouse_EventScript_BuySodaPop
 * msgbox Route109_SeashoreHouse_Text_ThatsTooBad, MSGBOX_DEFAULT
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_AlreadyReceivedSodaPop : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_AlreadyReceivedSodaPop")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route109_SeashoreHouse_Text_ShowMeSomeHotMatches, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_AlreadyGaveIntroduction : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route109_SeashoreHouse.ShowMeSomeHotMatches)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route109_SeashoreHouse_Text_TakeTheseSodaPopBottles, MSGBOX_DEFAULT
 * giveitem ITEM_SODA_POP, 6
 * goto_if_eq VAR_RESULT, FALSE, Route109_SeashoreHouse_EventScript_BagFull
 * setflag FLAG_RECEIVED_6_SODA_POP
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_DefeatedTrainers : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_DefeatedTrainers")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkmoney 300
 * goto_if_eq VAR_RESULT, FALSE, Route109_SeashoreHouse_EventScript_NotEnoughMoney
 * checkitemspace ITEM_SODA_POP
 * goto_if_eq VAR_RESULT, FALSE, Route109_SeashoreHouse_EventScript_NotEnoughSpace
 * msgbox Route109_SeashoreHouse_Text_HereYouGo, MSGBOX_DEFAULT
 * removemoney 300
 * updatemoneybox
 * giveitem ITEM_SODA_POP
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_BuySodaPop : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_BuySodaPop")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route109_SeashoreHouse_Text_BagFull, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_BagFull : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route109_SeashoreHouse.BagFull)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox gText_TooBadBagIsFull, MSGBOX_DEFAULT
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_NotEnoughSpace : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_NotEnoughSpace")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route109_SeashoreHouse_Text_NotEnoughMoney, MSGBOX_DEFAULT
 * hidemoneybox
 * release
 * end
 * ```
 */
internal object Route109_SeashoreHouse_EventScript_NotEnoughMoney : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route109_SeashoreHouse_EventScript_NotEnoughMoney")
}

internal val Route109_SeashoreHouseScripts: Map<String, Script> =
    mapOf(
        "Route109_SeashoreHouse_EventScript_Owner" to Route109_SeashoreHouse_EventScript_Owner,
        "Route109_SeashoreHouse_EventScript_Dwayne" to Route109_SeashoreHouse_EventScript_Dwayne,
        "Route109_SeashoreHouse_EventScript_Simon" to Route109_SeashoreHouse_EventScript_Simon,
        "Route109_SeashoreHouse_EventScript_Johanna" to Route109_SeashoreHouse_EventScript_Johanna,
        "Route109_SeashoreHouse_EventScript_AlreadyReceivedSodaPop" to
            Route109_SeashoreHouse_EventScript_AlreadyReceivedSodaPop,
        "Route109_SeashoreHouse_EventScript_AlreadyGaveIntroduction" to
            Route109_SeashoreHouse_EventScript_AlreadyGaveIntroduction,
        "Route109_SeashoreHouse_EventScript_DefeatedTrainers" to
            Route109_SeashoreHouse_EventScript_DefeatedTrainers,
        "Route109_SeashoreHouse_EventScript_BuySodaPop" to
            Route109_SeashoreHouse_EventScript_BuySodaPop,
        "Route109_SeashoreHouse_EventScript_BagFull" to Route109_SeashoreHouse_EventScript_BagFull,
        "Route109_SeashoreHouse_EventScript_NotEnoughSpace" to
            Route109_SeashoreHouse_EventScript_NotEnoughSpace,
        "Route109_SeashoreHouse_EventScript_NotEnoughMoney" to
            Route109_SeashoreHouse_EventScript_NotEnoughMoney,
    )
