package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity
import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object FuchsiaCity_EventScript_Erik : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FuchsiaCity.WheresSara)
}

internal object FuchsiaCity_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FuchsiaCity.ItemBallInThere)
}

internal object FuchsiaCity_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FuchsiaCity.DidYouTrySafariGame)
}

internal object FuchsiaCity_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FuchsiaCity.SafariZoneZooInFront)
}

internal object FuchsiaCity_EventScript_SubstituteTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      moveTutor(
          ctx,
          KantoFlags.FLAG_TUTOR_SUBSTITUTE,
          Misc.Text_SubstituteTeach,
          Misc.Text_SubstituteDeclined,
          Misc.Text_SubstituteTaught,
      )
}

internal object FuchsiaCity_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FuchsiaCity.MyFatherIsGymLeader)
}

internal object FuchsiaCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.CitySign)
}

internal object FuchsiaCity_EventScript_SafariZoneSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.SafariZoneSign)
}

internal object FuchsiaCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.GymSign)
}

internal object FuchsiaCity_EventScript_WardensHomeSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.WardensHomeSign)
}

/** A zoo plaque. The decomp holds up the monster's picture, which has no verb. */
internal object FuchsiaCity_EventScript_VoltorbSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.VoltorbSign)
}

/** A zoo plaque. The decomp holds up the monster's picture, which has no verb. */
internal object FuchsiaCity_EventScript_SlowpokeSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.SlowpokeSign)
}

/** A zoo plaque. The decomp holds up the monster's picture, which has no verb. */
internal object FuchsiaCity_EventScript_ChanseySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.ChanseySign)
}

/** A zoo plaque. The decomp holds up the monster's picture, which has no verb. */
internal object FuchsiaCity_EventScript_KangaskhanSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.KangaskhanSign)
}

/** The pen holds whichever fossil monster the player did not take from Mount Moon. */
internal object FuchsiaCity_EventScript_FossilMonSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(
          if (ctx.isFlagSet(KantoFlags.FLAG_GOT_DOME_FOSSIL)) FuchsiaCity.OmanyteSign
          else FuchsiaCity.KabutoSign)
}

/** A zoo plaque. The decomp holds up the monster's picture, which has no verb. */
internal object FuchsiaCity_EventScript_LaprasSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.LaprasSign)
}

internal object FuchsiaCity_EventScript_SafariGameSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FuchsiaCity.SafariGameSign)
}

internal val FuchsiaCityScripts: Map<String, Script> =
    mapOf(
        "FuchsiaCity_EventScript_Erik" to FuchsiaCity_EventScript_Erik,
        "FuchsiaCity_EventScript_Youngster" to FuchsiaCity_EventScript_Youngster,
        "FuchsiaCity_EventScript_LittleBoy" to FuchsiaCity_EventScript_LittleBoy,
        "FuchsiaCity_EventScript_OldMan" to FuchsiaCity_EventScript_OldMan,
        "FuchsiaCity_EventScript_SubstituteTutor" to FuchsiaCity_EventScript_SubstituteTutor,
        "FuchsiaCity_EventScript_Lass" to FuchsiaCity_EventScript_Lass,
        "FuchsiaCity_EventScript_CitySign" to FuchsiaCity_EventScript_CitySign,
        "FuchsiaCity_EventScript_SafariZoneSign" to FuchsiaCity_EventScript_SafariZoneSign,
        "FuchsiaCity_EventScript_GymSign" to FuchsiaCity_EventScript_GymSign,
        "FuchsiaCity_EventScript_WardensHomeSign" to FuchsiaCity_EventScript_WardensHomeSign,
        "FuchsiaCity_EventScript_VoltorbSign" to FuchsiaCity_EventScript_VoltorbSign,
        "FuchsiaCity_EventScript_SlowpokeSign" to FuchsiaCity_EventScript_SlowpokeSign,
        "FuchsiaCity_EventScript_ChanseySign" to FuchsiaCity_EventScript_ChanseySign,
        "FuchsiaCity_EventScript_KangaskhanSign" to FuchsiaCity_EventScript_KangaskhanSign,
        "FuchsiaCity_EventScript_FossilMonSign" to FuchsiaCity_EventScript_FossilMonSign,
        "FuchsiaCity_EventScript_LaprasSign" to FuchsiaCity_EventScript_LaprasSign,
        "FuchsiaCity_EventScript_SafariGameSign" to FuchsiaCity_EventScript_SafariGameSign,
    )
