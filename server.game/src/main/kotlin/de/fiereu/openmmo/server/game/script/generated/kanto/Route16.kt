package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.dialog.generated.kanto.Route16
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val SNORLAX = 143
private const val SNORLAX_LEVEL = 30

internal object Route16_EventScript_Lao : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_LAO,
          Route16.LaoIntro,
          Route16.LaoDefeat,
          Route16.LaoPostBattle,
      )
}

internal object Route16_EventScript_Koji : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_KOJI,
          Route16.KojiIntro,
          Route16.KojiDefeat,
          Route16.KojiPostBattle,
      )
}

internal object Route16_EventScript_Luke : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_LUKE,
          Route16.LukeIntro,
          Route16.LukeDefeat,
          Route16.LukePostBattle,
      )
}

internal object Route16_EventScript_Ruben : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_RUBEN,
          Route16.RubenIntro,
          Route16.RubenDefeat,
          Route16.RubenPostBattle,
      )
}

internal object Route16_EventScript_Hideo : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BIKER_HIDEO,
          Route16.HideoIntro,
          Route16.HideoDefeat,
          Route16.HideoPostBattle,
      )
}

internal object Route16_EventScript_Camron : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CUE_BALL_CAMRON,
          Route16.CamronIntro,
          Route16.CamronDefeat,
          Route16.CamronPostBattle,
      )
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_YOUNG_COUPLE_LEA_JED, Route16_Text_LeaIntro, Route16_Text_LeaDefeat, Route16_Text_LeaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route16_EventScript_LeaRematch
 * msgbox Route16_Text_LeaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route16_EventScript_Lea : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route16_EventScript_Lea")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_YOUNG_COUPLE_LEA_JED, Route16_Text_JedIntro, Route16_Text_JedDefeat, Route16_Text_JedNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route16_EventScript_JedRematch
 * msgbox Route16_Text_JedPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route16_EventScript_Jed : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route16_EventScript_Jed")
}

/** The Snorlax asleep across the road, which only the Poke Flute can move. */
internal object Route16_EventScript_Snorlax : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_POKE_FLUTE)) {
      return ctx.say(Route16.MonSprawledOutInSlumber)
    }
    if (!ctx.askYesNo(Misc.Text_WantToUsePokeFlute)) return
    // The decomp wakes it with the flute's animation and cry, then fights it as a wild battle that
    // is gone either way, won or fled.
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE_16_SNORLAX)
    ctx.battle(SNORLAX, SNORLAX_LEVEL)
    ctx.removeNpc(9)
    ctx.say(Misc.Text_SnorlaxReturnedToMountains)
  }
}

internal object Route16_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route16.RouteSign)
}

internal object Route16_EventScript_CyclingRoadSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route16.CyclingRoadSign)
}

internal val Route16Scripts: Map<String, Script> =
    mapOf(
        "Route16_EventScript_Lao" to Route16_EventScript_Lao,
        "Route16_EventScript_Koji" to Route16_EventScript_Koji,
        "Route16_EventScript_Luke" to Route16_EventScript_Luke,
        "Route16_EventScript_Ruben" to Route16_EventScript_Ruben,
        "Route16_EventScript_Hideo" to Route16_EventScript_Hideo,
        "Route16_EventScript_Camron" to Route16_EventScript_Camron,
        "Route16_EventScript_Lea" to Route16_EventScript_Lea,
        "Route16_EventScript_Jed" to Route16_EventScript_Jed,
        "Route16_EventScript_Snorlax" to Route16_EventScript_Snorlax,
        "Route16_EventScript_RouteSign" to Route16_EventScript_RouteSign,
        "Route16_EventScript_CyclingRoadSign" to Route16_EventScript_CyclingRoadSign,
    )
