package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.dialog.generated.kanto.Route4
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_TM05_BALL = 2

internal object Route4_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route4.TrippedOverGeodude)
}

/** Crissy asks ShouldTryRematchBattle first, which only the Vs Seeker can answer TRUE. */
internal object Route4_EventScript_Crissy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_CRISSY,
          Route4.CrissyIntro,
          Route4.CrissyDefeat,
          Route4.CrissyPostBattle,
      )
}

internal object Route4_EventScript_ItemTM05 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM05)) return
    ctx.removeNpc(LOCALID_TM05_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROUTE4_TM05)
  }
}

internal object Route4_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route4.PeopleLikeAndRespectBrock)
}

internal object Route4_EventScript_MegaPunchTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      moveTutor(
          ctx,
          KantoFlags.FLAG_TUTOR_MEGA_PUNCH,
          Misc.Text_MegaPunchTeach,
          Misc.Text_MegaPunchDeclined,
          Misc.Text_MegaPunchTaught,
      )
}

internal object Route4_EventScript_MegaKickTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      moveTutor(
          ctx,
          KantoFlags.FLAG_TUTOR_MEGA_KICK,
          Misc.Text_MegaKickTeach,
          Misc.Text_MegaKickDeclined,
          Misc.Text_MegaKickTaught,
      )
}

internal object Route4_EventScript_MtMoonSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route4.MtMoonEntrance)
}

internal object Route4_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route4.RouteSign)
}

internal val Route4Scripts: Map<String, Script> =
    mapOf(
        "Route4_EventScript_Woman" to Route4_EventScript_Woman,
        "Route4_EventScript_Crissy" to Route4_EventScript_Crissy,
        "Route4_EventScript_ItemTM05" to Route4_EventScript_ItemTM05,
        "Route4_EventScript_Boy" to Route4_EventScript_Boy,
        "Route4_EventScript_MegaPunchTutor" to Route4_EventScript_MegaPunchTutor,
        "Route4_EventScript_MegaKickTutor" to Route4_EventScript_MegaKickTutor,
        "Route4_EventScript_MtMoonSign" to Route4_EventScript_MtMoonSign,
        "Route4_EventScript_RouteSign" to Route4_EventScript_RouteSign,
    )
