package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PewterCity
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

// Decomp local ids of this map's object events.
private const val LOCALID_MUSEUM_GUIDE = 1
private const val LOCALID_GYM_GUIDE = 4
private const val LOCALID_AIDE = 6

internal object PewterCity_OnTransition : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_WORLD_MAP_PEWTER_CITY)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_PEWTER_CITY_MUSEUM_1F, 0)
  }
}

internal object PewterCity_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(PewterCity.ClefairyCameFromMoon)
}

internal object PewterCity_EventScript_MuseumGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.askYesNo(PewterCity.DidYouCheckOutMuseum)) {
      return ctx.say(PewterCity.WerentThoseFossilsAmazing)
    }
    ctx.say(PewterCity.ReallyYouHaveToGo)
    // TODO Walk the museum guide's escort
    //  The decomp leads the player to the museum door with a movement path per facing direction,
    //  over the MUS_FOLLOW_ME track. Both need playbgm and fadedefaultbgm script verbs, and the
    //  paths are only correct from the tile the player talked from.
    ctx.say(PewterCity.ThisIsTheMuseum)
    ctx.removeNpc(LOCALID_MUSEUM_GUIDE)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_PEWTER_MUSEUM_GUIDE)
  }
}

internal object PewterCity_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(PewterCity.BrockOnlySeriousTrainerHere)
}

internal object PewterCity_EventScript_BugCatcher : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.askYesNo(PewterCity.DoYouKnowWhatImDoing)) {
      return ctx.say(PewterCity.ThatsRightItsHardWork)
    }
    ctx.say(PewterCity.SprayingRepelToKeepWildMonsOut)
  }
}

internal object PewterCity_EventScript_GymGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity.BrocksLookingForChallengersFollowMe)
    // TODO Walk the gym guide's escort
    //  Same as the museum guide: the decomp walks the player all the way to the gym door on a
    //  path chosen by facing direction, with its own music.
    ctx.say(PewterCity.GoTakeOnBrock)
    ctx.removeNpc(LOCALID_GYM_GUIDE)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_PEWTER_CITY_GYM_GUIDE)
  }
}

internal object PewterCity_EventScript_RunningShoesAide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PewterCity.OhPlayer)
    ctx.say(PewterCity.AskedToDeliverThis)
    ctx.say(PewterCity.ReceivedRunningShoesFromAide)
    ctx.say(PewterCity.SwitchedShoesWithRunningShoes)
    ctx.sign(PewterCity.ExplainRunningShoes)
    ctx.say(PewterCity.MustBeGoingBackToLab)
    ctx.say(PewterCity.RunningShoesLetterFromMom)
    ctx.removeNpc(LOCALID_AIDE)
    ctx.setFlag(KantoFlags.FLAG_SYS_B_DASH)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_PEWTER_CITY, 2)
  }
}

internal object PewterCity_EventScript_MuseumSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.MuseumOfScience)
}

internal object PewterCity_EventScript_PoliceNotice : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.CallPoliceIfInfoOnThieves)
}

internal object PewterCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.GymSign)
}

internal object PewterCity_EventScript_TrainerTips : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.TrainerTipsEarningEXP)
}

internal object PewterCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(PewterCity.CitySign)
}

// The guides call out to a player walking by, which the map's coord events fire. The decomp picks
// the escort path from which trigger fired; the escorts are not ported, so all of them lead to the
// same lines the guide gives when talked to.

internal object PewterCity_EventScript_GymGuideTrigger : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_GymGuide.run(ctx)
}

internal object PewterCity_EventScript_GymGuideTriggerTop : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_GymGuideTrigger.run(ctx)
}

internal object PewterCity_EventScript_GymGuideTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_GymGuideTrigger.run(ctx)
}

internal object PewterCity_EventScript_GymGuideTriggerBottom : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_GymGuideTrigger.run(ctx)
}

internal object PewterCity_EventScript_GymGuideTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_GymGuideTrigger.run(ctx)
}

internal object PewterCity_EventScript_RunningShoesAideTriggerTop : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_RunningShoesAide.run(ctx)
}

internal object PewterCity_EventScript_RunningShoesAideTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_RunningShoesAide.run(ctx)
}

internal object PewterCity_EventScript_RunningShoesAideTriggerBottom : Script {
  override suspend fun run(ctx: ScriptContext) = PewterCity_EventScript_RunningShoesAide.run(ctx)
}

internal val PewterCityScripts: Map<String, Script> =
    mapOf(
        "PewterCity_EventScript_GymGuideTrigger" to PewterCity_EventScript_GymGuideTrigger,
        "PewterCity_EventScript_GymGuideTriggerTop" to PewterCity_EventScript_GymGuideTriggerTop,
        "PewterCity_EventScript_GymGuideTriggerMid" to PewterCity_EventScript_GymGuideTriggerMid,
        "PewterCity_EventScript_GymGuideTriggerBottom" to
            PewterCity_EventScript_GymGuideTriggerBottom,
        "PewterCity_EventScript_GymGuideTriggerRight" to
            PewterCity_EventScript_GymGuideTriggerRight,
        "PewterCity_EventScript_RunningShoesAideTriggerTop" to
            PewterCity_EventScript_RunningShoesAideTriggerTop,
        "PewterCity_EventScript_RunningShoesAideTriggerMid" to
            PewterCity_EventScript_RunningShoesAideTriggerMid,
        "PewterCity_EventScript_RunningShoesAideTriggerBottom" to
            PewterCity_EventScript_RunningShoesAideTriggerBottom,
        "PewterCity_OnTransition" to PewterCity_OnTransition,
        "PewterCity_EventScript_Lass" to PewterCity_EventScript_Lass,
        "PewterCity_EventScript_MuseumGuide" to PewterCity_EventScript_MuseumGuide,
        "PewterCity_EventScript_FatMan" to PewterCity_EventScript_FatMan,
        "PewterCity_EventScript_BugCatcher" to PewterCity_EventScript_BugCatcher,
        "PewterCity_EventScript_GymGuide" to PewterCity_EventScript_GymGuide,
        "PewterCity_EventScript_RunningShoesAide" to PewterCity_EventScript_RunningShoesAide,
        "PewterCity_EventScript_MuseumSign" to PewterCity_EventScript_MuseumSign,
        "PewterCity_EventScript_PoliceNotice" to PewterCity_EventScript_PoliceNotice,
        "PewterCity_EventScript_GymSign" to PewterCity_EventScript_GymSign,
        "PewterCity_EventScript_TrainerTips" to PewterCity_EventScript_TrainerTips,
        "PewterCity_EventScript_CitySign" to PewterCity_EventScript_CitySign,
    )
