package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FourIsland_LoreleisHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TALKED_TO_LORELEI_AFTER_WAREHOUSE, FourIsland_LoreleisHouse_EventScript_Lorelei3
 * goto_if_set FLAG_DEFEATED_ROCKETS_IN_WAREHOUSE, FourIsland_LoreleisHouse_EventScript_Lorelei2
 * msgbox FourIsland_LoreleisHouse_Text_IfAnythingWereToHappenToIsland
 * release
 * end
 * ```
 */
internal object FourIsland_LoreleisHouse_EventScript_Lorelei : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_TALKED_TO_LORELEI_AFTER_WAREHOUSE))
        return FourIsland_LoreleisHouse_EventScript_Lorelei3.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_ROCKETS_IN_WAREHOUSE))
        return FourIsland_LoreleisHouse_EventScript_Lorelei2.run(ctx)
    ctx.say(FourIsland_LoreleisHouse.IfAnythingWereToHappenToIsland)
  }
}

internal object FourIsland_LoreleisHouse_EventScript_Doll : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(FourIsland_LoreleisHouse.StuffedMonDollsGalore)
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_TALKED_TO_LORELEI_AFTER_WAREHOUSE
 * msgbox FourIsland_LoreleisHouse_Text_IllReturnToLeagueInShortWhile
 * release
 * end
 * ```
 */
internal object FourIsland_LoreleisHouse_EventScript_Lorelei2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_TALKED_TO_LORELEI_AFTER_WAREHOUSE)
    ctx.say(FourIsland_LoreleisHouse.IllReturnToLeagueInShortWhile)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FourIsland_LoreleisHouse_Text_WillDoWhatICanHereAndNow
 * release
 * end
 * ```
 */
internal object FourIsland_LoreleisHouse_EventScript_Lorelei3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FourIsland_LoreleisHouse.WillDoWhatICanHereAndNow)
  }
}

internal val FourIsland_LoreleisHouseScripts: Map<String, Script> =
    mapOf(
        "FourIsland_LoreleisHouse_EventScript_Lorelei" to
            FourIsland_LoreleisHouse_EventScript_Lorelei,
        "FourIsland_LoreleisHouse_EventScript_Doll" to FourIsland_LoreleisHouse_EventScript_Doll,
        "FourIsland_LoreleisHouse_EventScript_Lorelei2" to
            FourIsland_LoreleisHouse_EventScript_Lorelei2,
        "FourIsland_LoreleisHouse_EventScript_Lorelei3" to
            FourIsland_LoreleisHouse_EventScript_Lorelei3,
    )
