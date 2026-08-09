package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route123_BerryMastersHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * goto_if_set FLAG_DAILY_BERRY_MASTER_RECEIVED_BERRY, Route123_BerryMastersHouse_EventScript_ReceivedBerryToday
 * msgbox Route123_BerryMastersHouse_Text_YoureDeservingOfBerry, MSGBOX_DEFAULT
 * random NUM_BERRY_MASTER_BERRIES
 * addvar VAR_RESULT, NUM_BERRY_MASTER_BERRIES_SKIPPED
 * addvar VAR_RESULT, FIRST_BERRY_INDEX
 * giveitem VAR_RESULT
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_DAILY_BERRY_MASTER_RECEIVED_BERRY
 * msgbox Route123_BerryMastersHouse_Text_WhyBeStingyTakeAnother, MSGBOX_DEFAULT
 * random NUM_BERRY_MASTER_BERRIES
 * addvar VAR_RESULT, NUM_BERRY_MASTER_BERRIES_SKIPPED
 * addvar VAR_RESULT, FIRST_BERRY_INDEX
 * giveitem VAR_RESULT
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * msgbox Route123_BerryMastersHouse_Text_VisitPrettyPetalFlowerShop, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_BerryMaster : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_BerryMaster")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * goto_if_set FLAG_DAILY_BERRY_MASTERS_WIFE, Route123_BerryMastersHouse_EventScript_ReceivedWifeBerryToday
 * msgbox Route123_BerryMastersHouse_Text_HeardAGoodSayingLately, MSGBOX_DEFAULT
 * setvar VAR_0x8004, EASY_CHAT_TYPE_GOOD_SAYING
 * call Common_ShowEasyChatScreen
 * lock
 * faceplayer
 * goto_if_eq VAR_RESULT, TRUE, Route123_BerryMastersHouse_EventScript_GavePhrase
 * goto_if_eq VAR_RESULT, FALSE, Route123_BerryMastersHouse_EventScript_CancelPhrase
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_BerryMastersWife : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_BerryMastersWife")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route123_BerryMastersHouse_Text_JoyNeverGoesOutOfMyLife, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_ReceivedWifeBerryToday : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route123_BerryMastersHouse.JoyNeverGoesOutOfMyLife)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_eq VAR_0x8004, NOT_SPECIAL_PHRASE, Route123_BerryMastersHouse_EventScript_GiveNormalBerry
 * goto_if_eq VAR_0x8004, PHRASE_GREAT_BATTLE, Route123_BerryMastersHouse_EventScript_GiveSpelonBerry
 * goto_if_eq VAR_0x8004, PHRASE_CHALLENGE_CONTEST, Route123_BerryMastersHouse_EventScript_GivePamtreBerry
 * goto_if_eq VAR_0x8004, PHRASE_OVERWHELMING_LATIAS, Route123_BerryMastersHouse_EventScript_GiveWatmelBerry
 * goto_if_eq VAR_0x8004, PHRASE_COOL_LATIOS, Route123_BerryMastersHouse_EventScript_GiveDurinBerry
 * goto_if_eq VAR_0x8004, PHRASE_SUPER_HUSTLE, Route123_BerryMastersHouse_EventScript_GiveBelueBerry
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GavePhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GavePhrase")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route123_BerryMastersHouse_Text_DoneForToday, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_ReceivedBerryToday : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route123_BerryMastersHouse.DoneForToday)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route123_BerryMastersHouse_Text_Ah, MSGBOX_DEFAULT
 * msgbox Route123_BerryMastersHouse_Text_JoyNeverGoesOutOfMyLife, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_CancelPhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route123_BerryMastersHouse.Ah)
    ctx.say(Route123_BerryMastersHouse.JoyNeverGoesOutOfMyLife)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_RECEIVED_DURIN_BERRY, Route123_BerryMastersHouse_EventScript_GiveNormalBerry
 * msgbox Route123_BerryMastersHouse_Text_InspirationalTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_DURIN_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_DURIN_BERRY
 * goto Route123_BerryMastersHouse_EventScript_GaveBerry
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GiveDurinBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GiveDurinBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Route123_BerryMastersHouse_Text_GoodSayingTakeThis, MSGBOX_DEFAULT
 * random NUM_BERRY_MASTER_WIFE_BERRIES
 * addvar VAR_RESULT, FIRST_BERRY_INDEX
 * giveitem VAR_RESULT
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * goto Route123_BerryMastersHouse_EventScript_GaveBerry
 * release
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GiveNormalBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GiveNormalBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_RECEIVED_WATMEL_BERRY, Route123_BerryMastersHouse_EventScript_GiveNormalBerry
 * msgbox Route123_BerryMastersHouse_Text_InspirationalTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_WATMEL_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_WATMEL_BERRY
 * goto Route123_BerryMastersHouse_EventScript_GaveBerry
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GiveWatmelBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GiveWatmelBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_RECEIVED_SPELON_BERRY, Route123_BerryMastersHouse_EventScript_GiveNormalBerry
 * msgbox Route123_BerryMastersHouse_Text_InspirationalTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_SPELON_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_SPELON_BERRY
 * goto Route123_BerryMastersHouse_EventScript_GaveBerry
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GiveSpelonBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GiveSpelonBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_RECEIVED_PAMTRE_BERRY, Route123_BerryMastersHouse_EventScript_GiveNormalBerry
 * msgbox Route123_BerryMastersHouse_Text_InspirationalTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_PAMTRE_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_PAMTRE_BERRY
 * goto Route123_BerryMastersHouse_EventScript_GaveBerry
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GivePamtreBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GivePamtreBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_RECEIVED_BELUE_BERRY, Route123_BerryMastersHouse_EventScript_GiveNormalBerry
 * msgbox Route123_BerryMastersHouse_Text_InspirationalTakeThis, MSGBOX_DEFAULT
 * giveitem ITEM_BELUE_BERRY
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_BELUE_BERRY
 * goto Route123_BerryMastersHouse_EventScript_GaveBerry
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GiveBelueBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GiveBelueBerry")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_DAILY_BERRY_MASTERS_WIFE
 * msgbox Route123_BerryMastersHouse_Text_JoyNeverGoesOutOfMyLife, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_BerryMastersHouse_EventScript_GaveBerry : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route123_BerryMastersHouse_EventScript_GaveBerry")
}

internal val Route123_BerryMastersHouseScripts: Map<String, Script> =
    mapOf(
        "Route123_BerryMastersHouse_EventScript_BerryMaster" to
            Route123_BerryMastersHouse_EventScript_BerryMaster,
        "Route123_BerryMastersHouse_EventScript_BerryMastersWife" to
            Route123_BerryMastersHouse_EventScript_BerryMastersWife,
        "Route123_BerryMastersHouse_EventScript_ReceivedWifeBerryToday" to
            Route123_BerryMastersHouse_EventScript_ReceivedWifeBerryToday,
        "Route123_BerryMastersHouse_EventScript_GavePhrase" to
            Route123_BerryMastersHouse_EventScript_GavePhrase,
        "Route123_BerryMastersHouse_EventScript_ReceivedBerryToday" to
            Route123_BerryMastersHouse_EventScript_ReceivedBerryToday,
        "Route123_BerryMastersHouse_EventScript_CancelPhrase" to
            Route123_BerryMastersHouse_EventScript_CancelPhrase,
        "Route123_BerryMastersHouse_EventScript_GiveDurinBerry" to
            Route123_BerryMastersHouse_EventScript_GiveDurinBerry,
        "Route123_BerryMastersHouse_EventScript_GiveNormalBerry" to
            Route123_BerryMastersHouse_EventScript_GiveNormalBerry,
        "Route123_BerryMastersHouse_EventScript_GiveWatmelBerry" to
            Route123_BerryMastersHouse_EventScript_GiveWatmelBerry,
        "Route123_BerryMastersHouse_EventScript_GiveSpelonBerry" to
            Route123_BerryMastersHouse_EventScript_GiveSpelonBerry,
        "Route123_BerryMastersHouse_EventScript_GivePamtreBerry" to
            Route123_BerryMastersHouse_EventScript_GivePamtreBerry,
        "Route123_BerryMastersHouse_EventScript_GiveBelueBerry" to
            Route123_BerryMastersHouse_EventScript_GiveBelueBerry,
        "Route123_BerryMastersHouse_EventScript_GaveBerry" to
            Route123_BerryMastersHouse_EventScript_GaveBerry,
    )
