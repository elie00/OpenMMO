package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_LotadAndSeedotHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetLotadSizeRecordInfo
 * lock
 * faceplayer
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_PleaseShowMeBigLotad, MSGBOX_DEFAULT
 * special ChoosePartyMon
 * copyvar VAR_RESULT, VAR_0x8004
 * goto_if_eq VAR_RESULT, PARTY_NOTHING_CHOSEN, SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowLotad
 * special CompareLotadSize
 * goto_if_eq VAR_RESULT, COMPARE_SIZE_INCORRECT_SPECIES, SootopolisCity_LotadAndSeedotHouse_EventScript_NotLotad
 * goto_if_eq VAR_RESULT, COMPARE_SIZE_SMALLER, SootopolisCity_LotadAndSeedotHouse_EventScript_SmallLotad
 * goto_if_eq VAR_RESULT, COMPARE_SIZE_LARGER, SootopolisCity_LotadAndSeedotHouse_EventScript_BigLotad
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_LotadBrother : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_LotadAndSeedotHouse_EventScript_LotadBrother")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetSeedotSizeRecordInfo
 * lock
 * faceplayer
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_PleaseShowMeBigSeedot, MSGBOX_DEFAULT
 * special ChoosePartyMon
 * copyvar VAR_RESULT, VAR_0x8004
 * goto_if_eq VAR_RESULT, PARTY_NOTHING_CHOSEN, SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowSeedot
 * special CompareSeedotSize
 * goto_if_eq VAR_RESULT, COMPARE_SIZE_INCORRECT_SPECIES, SootopolisCity_LotadAndSeedotHouse_EventScript_NotSeedot
 * goto_if_eq VAR_RESULT, COMPARE_SIZE_SMALLER, SootopolisCity_LotadAndSeedotHouse_EventScript_SmallSeedot
 * goto_if_eq VAR_RESULT, COMPARE_SIZE_LARGER, SootopolisCity_LotadAndSeedotHouse_EventScript_BigSeedot
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotBrother : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotBrother")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetSeedotSizeRecordInfo
 * lockall
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_BiggestSeedotInHistory, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotSizeRecord : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotSizeRecord")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetLotadSizeRecordInfo
 * lockall
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_BiggestLotadInHistory, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_LotadSizeRecord : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_LotadAndSeedotHouse_EventScript_LotadSizeRecord")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_SeenBiggerLotad, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_SmallLotad : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.SeenBiggerLotad)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_DontHaveBigLotad, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowLotad : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.DontHaveBigLotad)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_GoshMightBeBiggerThanLotad, MSGBOX_DEFAULT
 * giveitem ITEM_ELIXIR
 * goto_if_eq VAR_RESULT, FALSE, SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir1
 * closemessage
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_BigSeedot : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_LotadAndSeedotHouse_EventScript_BigSeedot")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_DontHaveBigSeedot, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowSeedot : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.DontHaveBigSeedot)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_ThatsNotSeedot, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_NotSeedot : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.ThatsNotSeedot)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_WowMightBeBiggerThanSeedot, MSGBOX_DEFAULT
 * giveitem ITEM_ELIXIR
 * goto_if_eq VAR_RESULT, FALSE, SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir2
 * closemessage
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_BigLotad : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_LotadAndSeedotHouse_EventScript_BigLotad")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_ThatsNotLotad, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_NotLotad : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.ThatsNotLotad)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_SeenBiggerSeedot, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_SmallSeedot : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.SeenBiggerSeedot)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_BagCrammedFull1, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.BagCrammedFull1)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_LotadAndSeedotHouse_Text_BagCrammedFull2, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_LotadAndSeedotHouse.BagCrammedFull2)
  }
}

internal val SootopolisCity_LotadAndSeedotHouseScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_LotadAndSeedotHouse_EventScript_LotadBrother" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_LotadBrother,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotBrother" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotBrother,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotSizeRecord" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_SeedotSizeRecord,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_LotadSizeRecord" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_LotadSizeRecord,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_SmallLotad" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_SmallLotad,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowLotad" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowLotad,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_BigSeedot" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_BigSeedot,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowSeedot" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_CancelShowSeedot,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_NotSeedot" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_NotSeedot,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_BigLotad" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_BigLotad,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_NotLotad" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_NotLotad,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_SmallSeedot" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_SmallSeedot,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir1" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir1,
        "SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir2" to
            SootopolisCity_LotadAndSeedotHouse_EventScript_NoRoomForElixir2,
    )
