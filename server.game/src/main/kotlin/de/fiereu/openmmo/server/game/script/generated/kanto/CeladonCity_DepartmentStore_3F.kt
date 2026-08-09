package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_DepartmentStore_3F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * goto EventScript_CounterTutor
 * end
 * ```
 */
internal object CeladonCity_DepartmentStore_3F_EventScript_CounterTutor : Script {
  override suspend fun run(ctx: ScriptContext) {
    return EventScript_CounterTutor.run(ctx)
  }
}

internal object CeladonCity_DepartmentStore_3F_EventScript_GBAKid1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_DepartmentStore_3F.OTStandsForOriginalTrainer)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_GBAKid3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_DepartmentStore_3F.HaunterEvolvedOnTrade)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_GBAKid2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_DepartmentStore_3F.BuddyTradingKangaskhanForHaunter)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_DepartmentStore_3F.CanIdentifyTradeMonsByID)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_DepartmentStore_3F.TVGameShop)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_TV1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_DepartmentStore_3F.AnRPG)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_TV2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_DepartmentStore_3F.SportsGame)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_TV3 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_DepartmentStore_3F.PuzzleGame)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_TV4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CeladonCity_DepartmentStore_3F.FightingGame)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_SuperNES : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CeladonCity_DepartmentStore_3F.ItsSuperNES)
}

internal object CeladonCity_DepartmentStore_3F_EventScript_Poster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(CeladonCity_DepartmentStore_3F.RedGreenBothArePokemon)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_COUNTER, EventScript_CounterTaught
 * msgbox Text_CounterTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_CounterDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_CounterDeclined
 * msgbox Text_CounterWhichMon
 * setvar VAR_0x8005, MOVETUTOR_COUNTER
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_CounterDeclined
 * setflag FLAG_TUTOR_COUNTER
 * goto EventScript_CounterTaught
 * end
 * ```
 */
internal object EventScript_CounterTutor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_CounterTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_CounterDeclined
 * release
 * end
 * ```
 */
internal object EventScript_CounterDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_CounterDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_CounterTaught
 * release
 * end
 * ```
 */
internal object EventScript_CounterTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_CounterTaught")
}

internal val CeladonCity_DepartmentStore_3FScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_DepartmentStore_3F_EventScript_CounterTutor" to
            CeladonCity_DepartmentStore_3F_EventScript_CounterTutor,
        "CeladonCity_DepartmentStore_3F_EventScript_GBAKid1" to
            CeladonCity_DepartmentStore_3F_EventScript_GBAKid1,
        "CeladonCity_DepartmentStore_3F_EventScript_GBAKid3" to
            CeladonCity_DepartmentStore_3F_EventScript_GBAKid3,
        "CeladonCity_DepartmentStore_3F_EventScript_GBAKid2" to
            CeladonCity_DepartmentStore_3F_EventScript_GBAKid2,
        "CeladonCity_DepartmentStore_3F_EventScript_LittleGirl" to
            CeladonCity_DepartmentStore_3F_EventScript_LittleGirl,
        "CeladonCity_DepartmentStore_3F_EventScript_FloorSign" to
            CeladonCity_DepartmentStore_3F_EventScript_FloorSign,
        "CeladonCity_DepartmentStore_3F_EventScript_TV1" to
            CeladonCity_DepartmentStore_3F_EventScript_TV1,
        "CeladonCity_DepartmentStore_3F_EventScript_TV2" to
            CeladonCity_DepartmentStore_3F_EventScript_TV2,
        "CeladonCity_DepartmentStore_3F_EventScript_TV3" to
            CeladonCity_DepartmentStore_3F_EventScript_TV3,
        "CeladonCity_DepartmentStore_3F_EventScript_TV4" to
            CeladonCity_DepartmentStore_3F_EventScript_TV4,
        "CeladonCity_DepartmentStore_3F_EventScript_SuperNES" to
            CeladonCity_DepartmentStore_3F_EventScript_SuperNES,
        "CeladonCity_DepartmentStore_3F_EventScript_Poster" to
            CeladonCity_DepartmentStore_3F_EventScript_Poster,
        "EventScript_CounterTutor" to EventScript_CounterTutor,
        "EventScript_CounterDeclined" to EventScript_CounterDeclined,
        "EventScript_CounterTaught" to EventScript_CounterTaught,
    )
