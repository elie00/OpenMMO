package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route12_FishingHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_SUPER_ROD, Route12_FishingHouse_EventScript_CheckMagikarpRecord
 * msgbox Route12_FishingHouse_Text_DoYouLikeToFish, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, Route12_FishingHouse_EventScript_GiveSuperRod
 * msgbox Route12_FishingHouse_Text_OhThatsDisappointing
 * release
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_FishingGuruBrother : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_FishingGuruBrother")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_GOT_RECORD_SETTING_MAGIKARP, Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet
 * msgbox Route12_FishingHouse_Text_BlankChartOfSomeSort
 * releaseall
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_MagikarpRecordSign : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_RECORD_SETTING_MAGIKARP))
        return Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet.run(ctx)
    ctx.say(Route12_FishingHouse.BlankChartOfSomeSort)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetMagikarpSizeRecordInfo
 * msgbox Route12_FishingHouse_Text_MostGiganticMagikarpXInches
 * releaseall
 * end
 * ```
 */
internal object Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet")
}

internal val Route12_FishingHouseScripts: Map<String, Script> =
    mapOf(
        "Route12_FishingHouse_EventScript_FishingGuruBrother" to
            Route12_FishingHouse_EventScript_FishingGuruBrother,
        "Route12_FishingHouse_EventScript_MagikarpRecordSign" to
            Route12_FishingHouse_EventScript_MagikarpRecordSign,
        "Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet" to
            Route12_FishingHouse_EventScript_MagikarpRecordSignRecordSet,
    )
