package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_Lounge2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MET_BATTLE_FRONTIER_MANIAC, BattleFrontier_Lounge2_EventScript_AlreadyMetManiac
 * setflag FLAG_MET_BATTLE_FRONTIER_MANIAC
 * msgbox BattleFrontier_Lounge2_Text_FrontierManiacIntro, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge2_EventScript_GiveAdvice
 * end
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_FrontierManiac : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_MET_BATTLE_FRONTIER_MANIAC))
        return BattleFrontier_Lounge2_EventScript_AlreadyMetManiac.run(ctx)
    ctx.setFlag(HoennFlags.FLAG_MET_BATTLE_FRONTIER_MANIAC)
    ctx.say(BattleFrontier_Lounge2.FrontierManiacIntro)
    return BattleFrontier_Lounge2_EventScript_GiveAdvice.run(ctx)
  }
}

internal object BattleFrontier_Lounge2_EventScript_Maniac1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(BattleFrontier_Lounge2.NewsGatheringPower)
}

internal object BattleFrontier_Lounge2_EventScript_Maniac2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge2.AmazingPowersOfObservation)
}

internal object BattleFrontier_Lounge2_EventScript_TriathleteF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge2.ThisPlaceIsScaringMe)
}

internal object BattleFrontier_Lounge2_EventScript_Maniac3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge2.AmazingPowerOfPersuasion)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_TOWER_SINGLES, BattleFrontier_Lounge2_EventScript_BufferSingle
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_TOWER_DOUBLES, BattleFrontier_Lounge2_EventScript_BufferDouble
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_TOWER_MULTIS, BattleFrontier_Lounge2_EventScript_BufferMulti
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_TOWER_LINK, BattleFrontier_Lounge2_EventScript_BufferMultiLink
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_DOME, BattleFrontier_Lounge2_EventScript_BufferBattleDome
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_FACTORY, BattleFrontier_Lounge2_EventScript_BufferBattleFactory
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_PALACE, BattleFrontier_Lounge2_EventScript_BufferBattlePalace
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_ARENA, BattleFrontier_Lounge2_EventScript_BufferBattleArena
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_PIKE, BattleFrontier_Lounge2_EventScript_BufferBattlePike
 * call_if_eq VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_PYRAMID, BattleFrontier_Lounge2_EventScript_BufferBattlePyramid
 * call_if_le VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_TOWER_LINK, BattleFrontier_Lounge2_EventScript_BattleTowerNews
 * call_if_ge VAR_FRONTIER_MANIAC_FACILITY, FRONTIER_MANIAC_DOME, BattleFrontier_Lounge2_EventScript_FacilityNews
 * special ShowFrontierManiacMessage
 * waitmessage
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_GiveAdvice : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_GiveAdvice")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge2_Text_SwingByForTheLatestWord, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge2_EventScript_GiveAdvice
 * end
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_AlreadyMetManiac : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge2.SwingByForTheLatestWord)
    return BattleFrontier_Lounge2_EventScript_GiveAdvice.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_MULTI
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferMulti : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferMulti")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge2_Text_FacilityIsHottest, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_FacilityNews : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge2.FacilityIsHottest)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_BATTLE_FACTORY
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferBattleFactory : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferBattleFactory")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_SINGLE
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferSingle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferSingle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_DOUBLE
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferDouble : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferDouble")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_BATTLE_PYRAMID
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferBattlePyramid : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferBattlePyramid")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_BATTLE_DOME
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferBattleDome : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferBattleDome")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_BATTLE_PALACE
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferBattlePalace : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferBattlePalace")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_MULTI_LINK
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferMultiLink : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferMultiLink")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_BATTLE_PIKE
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferBattlePike : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferBattlePike")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * bufferstdstring STR_VAR_1, STDSTRING_BATTLE_ARENA
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BufferBattleArena : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge2_EventScript_BufferBattleArena")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge2_Text_BattleTowerIsHottest, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_Lounge2_EventScript_BattleTowerNews : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge2.BattleTowerIsHottest)
  }
}

internal val BattleFrontier_Lounge2Scripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_Lounge2_EventScript_FrontierManiac" to
            BattleFrontier_Lounge2_EventScript_FrontierManiac,
        "BattleFrontier_Lounge2_EventScript_Maniac1" to BattleFrontier_Lounge2_EventScript_Maniac1,
        "BattleFrontier_Lounge2_EventScript_Maniac2" to BattleFrontier_Lounge2_EventScript_Maniac2,
        "BattleFrontier_Lounge2_EventScript_TriathleteF" to
            BattleFrontier_Lounge2_EventScript_TriathleteF,
        "BattleFrontier_Lounge2_EventScript_Maniac3" to BattleFrontier_Lounge2_EventScript_Maniac3,
        "BattleFrontier_Lounge2_EventScript_GiveAdvice" to
            BattleFrontier_Lounge2_EventScript_GiveAdvice,
        "BattleFrontier_Lounge2_EventScript_AlreadyMetManiac" to
            BattleFrontier_Lounge2_EventScript_AlreadyMetManiac,
        "BattleFrontier_Lounge2_EventScript_BufferMulti" to
            BattleFrontier_Lounge2_EventScript_BufferMulti,
        "BattleFrontier_Lounge2_EventScript_FacilityNews" to
            BattleFrontier_Lounge2_EventScript_FacilityNews,
        "BattleFrontier_Lounge2_EventScript_BufferBattleFactory" to
            BattleFrontier_Lounge2_EventScript_BufferBattleFactory,
        "BattleFrontier_Lounge2_EventScript_BufferSingle" to
            BattleFrontier_Lounge2_EventScript_BufferSingle,
        "BattleFrontier_Lounge2_EventScript_BufferDouble" to
            BattleFrontier_Lounge2_EventScript_BufferDouble,
        "BattleFrontier_Lounge2_EventScript_BufferBattlePyramid" to
            BattleFrontier_Lounge2_EventScript_BufferBattlePyramid,
        "BattleFrontier_Lounge2_EventScript_BufferBattleDome" to
            BattleFrontier_Lounge2_EventScript_BufferBattleDome,
        "BattleFrontier_Lounge2_EventScript_BufferBattlePalace" to
            BattleFrontier_Lounge2_EventScript_BufferBattlePalace,
        "BattleFrontier_Lounge2_EventScript_BufferMultiLink" to
            BattleFrontier_Lounge2_EventScript_BufferMultiLink,
        "BattleFrontier_Lounge2_EventScript_BufferBattlePike" to
            BattleFrontier_Lounge2_EventScript_BufferBattlePike,
        "BattleFrontier_Lounge2_EventScript_BufferBattleArena" to
            BattleFrontier_Lounge2_EventScript_BufferBattleArena,
        "BattleFrontier_Lounge2_EventScript_BattleTowerNews" to
            BattleFrontier_Lounge2_EventScript_BattleTowerNews,
    )
