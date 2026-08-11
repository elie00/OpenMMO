package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity
import de.fiereu.openmmo.dialog.generated.kanto.CeruleanCity_BikeShop
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_DOWN
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_GRUNT = 1
private const val LOCALID_RIVAL = 7

internal object CeruleanCity_EventScript_Policeman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.PeopleHereWereRobbed)
}

internal object CeruleanCity_EventScript_Grunt : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_5)) {
      // trainerbattle_no_intro: the intro box is shown by the script, not by the battle.
      ctx.say(CeruleanCity.GruntIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_5) != BattleResult.VICTORY) {
        return
      }
      ctx.say(CeruleanCity.GruntDefeat)
      ctx.setVar(KantoVars.VAR_MAP_SCENE_CERULEAN_CITY_ROCKET, 1)
    }
    CeruleanCity_EventScript_GruntDefeated.run(ctx)
  }
}

/** He hands the stolen TM back and leaves town. */
internal object CeruleanCity_EventScript_GruntDefeated : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.OkayIllReturnStolenTM)
    if (!ctx.giveItem(Items.TM28)) {
      return ctx.say(CeruleanCity.MakeRoomForThisCantRun)
    }
    ctx.say(CeruleanCity.RecoveredTM28FromGrunt)
    ctx.say(CeruleanCity.BetterGetMovingBye)
    ctx.removeNpc(LOCALID_GRUNT)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM28_FROM_ROCKET)
  }
}

internal object CeruleanCity_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_SS_TICKET)) {
      return ctx.say(CeruleanCity.YouCanCutDownSmallTrees)
    }
    ctx.say(CeruleanCity.IfSlowbroWasntThereCouldCutTree)
  }
}

internal object CeruleanCity_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.PokemonEncyclopediaAmusing)
}

/**
 * The decomp picks one of four idle lines at random; there is no random verb, so it is the first.
 */
internal object CeruleanCity_EventScript_Slowbro : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.SlowbroTookSnooze)
}

/**
 * She orders her Slowbro about and it ignores her. The decomp pairs one of three orders with its
 * matching failure at random, so this is the first pair; the question mark emote over the Slowbro
 * between the two has no verb.
 */
internal object CeruleanCity_EventScript_Lass : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeruleanCity.SlowbroUseSonicboom)
    ctx.say(CeruleanCity.SlowbroPayAttention)
  }
}

internal object CeruleanCity_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.TrainerLifeIsToughIsntIt)
}

internal object CeruleanCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.WantBrightRedBicycle)
}

internal object CeruleanCity_EventScript_CeruleanCaveGuard : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(CeruleanCity.ThisIsCeruleanCave)
}

internal object CeruleanCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.CitySign)
}

internal object CeruleanCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.GymSign)
}

internal object CeruleanCity_EventScript_BikeShopSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.BikeShopSign)
}

internal object CeruleanCity_EventScript_TrainerTips : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity.TrainerTipsHeldItems)
}

internal object CeruleanCity_BikeShop_EventScript_Bicycle : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeruleanCity_BikeShop.ShinyNewBicycle)
}

/**
 * The rival drops in from the north, which the map's three coord events fire. He fights with the
 * starter that beats the player's, then leaves the Fame Checker behind.
 */
internal object CeruleanCity_EventScript_Rival : Script {
  override suspend fun run(ctx: ScriptContext) {
    val rival =
        when (Starter.byStarterNumber(ctx.getVar(KantoVars.VAR_STARTER_MON))?.rival) {
          Starter.BULBASAUR_BALL -> KantoTrainerIds.TRAINER_RIVAL_CERULEAN_BULBASAUR
          Starter.SQUIRTLE_BALL -> KantoTrainerIds.TRAINER_RIVAL_CERULEAN_SQUIRTLE
          Starter.CHARMANDER_BALL -> KantoTrainerIds.TRAINER_RIVAL_CERULEAN_CHARMANDER
          null -> return
        }
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE22, 2)
    ctx.showNpc(LOCALID_RIVAL)
    ctx.moveNpc(LOCALID_RIVAL, WALK_DOWN, WALK_DOWN, WALK_DOWN, WALK_DOWN, WALK_DOWN)
    ctx.sayNpc(LOCALID_RIVAL, CeruleanCity.RivalIntro)
    // trainerbattle_no_intro: the intro box above is his.
    if (ctx.trainerBattle(rival) != BattleResult.VICTORY) return
    ctx.sayNpc(LOCALID_RIVAL, CeruleanCity.RivalDefeat)
    ctx.sayNpc(LOCALID_RIVAL, CeruleanCity.RivalPostBattle)
    ctx.sayNpc(LOCALID_RIVAL, CeruleanCity.OhRightLittlePresentAsFavor)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_CERULEAN_CITY_RIVAL, 1)
    ctx.setFlag(KantoFlags.FLAG_GOT_FAME_CHECKER)
    ctx.giveItem(Items.FAME_CHECKER)
    ctx.sayNpc(LOCALID_RIVAL, CeruleanCity.ExplainFameCheckerSmellYa)
    ctx.removeNpc(LOCALID_RIVAL)
  }
}

internal object CeruleanCity_EventScript_RivalTriggerLeft : Script {
  override suspend fun run(ctx: ScriptContext) = CeruleanCity_EventScript_Rival.run(ctx)
}

internal object CeruleanCity_EventScript_RivalTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) = CeruleanCity_EventScript_Rival.run(ctx)
}

internal object CeruleanCity_EventScript_RivalTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) = CeruleanCity_EventScript_Rival.run(ctx)
}

/** Walking into the robbed house's doorway starts the same fight talking to the grunt does. */
internal object CeruleanCity_EventScript_GruntTrigger : Script {
  override suspend fun run(ctx: ScriptContext) = CeruleanCity_EventScript_Grunt.run(ctx)
}

internal object CeruleanCity_EventScript_GruntTriggerTop : Script {
  override suspend fun run(ctx: ScriptContext) = CeruleanCity_EventScript_GruntTrigger.run(ctx)
}

internal object CeruleanCity_EventScript_GruntTriggerBottom : Script {
  override suspend fun run(ctx: ScriptContext) = CeruleanCity_EventScript_GruntTrigger.run(ctx)
}

internal val CeruleanCityScripts: Map<String, Script> =
    mapOf(
        "CeruleanCity_EventScript_Rival" to CeruleanCity_EventScript_Rival,
        "CeruleanCity_EventScript_RivalTriggerLeft" to CeruleanCity_EventScript_RivalTriggerLeft,
        "CeruleanCity_EventScript_RivalTriggerMid" to CeruleanCity_EventScript_RivalTriggerMid,
        "CeruleanCity_EventScript_RivalTriggerRight" to CeruleanCity_EventScript_RivalTriggerRight,
        "CeruleanCity_EventScript_GruntTrigger" to CeruleanCity_EventScript_GruntTrigger,
        "CeruleanCity_EventScript_GruntTriggerTop" to CeruleanCity_EventScript_GruntTriggerTop,
        "CeruleanCity_EventScript_GruntTriggerBottom" to
            CeruleanCity_EventScript_GruntTriggerBottom,
        "CeruleanCity_EventScript_Policeman" to CeruleanCity_EventScript_Policeman,
        "CeruleanCity_EventScript_Grunt" to CeruleanCity_EventScript_Grunt,
        "CeruleanCity_EventScript_GruntDefeated" to CeruleanCity_EventScript_GruntDefeated,
        "CeruleanCity_EventScript_LittleBoy" to CeruleanCity_EventScript_LittleBoy,
        "CeruleanCity_EventScript_BaldingMan" to CeruleanCity_EventScript_BaldingMan,
        "CeruleanCity_EventScript_Slowbro" to CeruleanCity_EventScript_Slowbro,
        "CeruleanCity_EventScript_Lass" to CeruleanCity_EventScript_Lass,
        "CeruleanCity_EventScript_Youngster" to CeruleanCity_EventScript_Youngster,
        "CeruleanCity_EventScript_Woman" to CeruleanCity_EventScript_Woman,
        "CeruleanCity_EventScript_CeruleanCaveGuard" to CeruleanCity_EventScript_CeruleanCaveGuard,
        "CeruleanCity_EventScript_CitySign" to CeruleanCity_EventScript_CitySign,
        "CeruleanCity_EventScript_GymSign" to CeruleanCity_EventScript_GymSign,
        "CeruleanCity_EventScript_BikeShopSign" to CeruleanCity_EventScript_BikeShopSign,
        "CeruleanCity_EventScript_TrainerTips" to CeruleanCity_EventScript_TrainerTips,
        "CeruleanCity_BikeShop_EventScript_Bicycle" to CeruleanCity_BikeShop_EventScript_Bicycle,
    )
