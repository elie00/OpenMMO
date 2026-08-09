package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FiveIsland_Meadow
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_51, FiveIsland_Meadow_Text_Rocket3Intro, FiveIsland_Meadow_Text_Rocket3Defeat
 * msgbox FiveIsland_Meadow_Text_Rocket3PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_Rocket3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_51
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FiveIsland_Meadow.Rocket3PostBattle)
    }
    ctx.say(FiveIsland_Meadow.Rocket3Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_Meadow.Rocket3Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_49, FiveIsland_Meadow_Text_Rocket1Intro, FiveIsland_Meadow_Text_Rocket1Defeat
 * msgbox FiveIsland_Meadow_Text_Rocket1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_Rocket1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_49
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FiveIsland_Meadow.Rocket1PostBattle)
    }
    ctx.say(FiveIsland_Meadow.Rocket1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_Meadow.Rocket1Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_50, FiveIsland_Meadow_Text_Rocket2Intro, FiveIsland_Meadow_Text_Rocket2Defeat
 * msgbox FiveIsland_Meadow_Text_Rocket2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_Rocket2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_50
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(FiveIsland_Meadow.Rocket2PostBattle)
    }
    ctx.say(FiveIsland_Meadow.Rocket2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(FiveIsland_Meadow.Rocket2Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_POTION
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_ItemMaxPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_POTION, KantoFlags.FLAG_HIDE_FIVE_ISLAND_MEADOW_MAX_POTION, 5)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, KantoFlags.FLAG_HIDE_FIVE_ISLAND_MEADOW_PP_UP, 6)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_UNLOCKED_ROCKET_WAREHOUSE, FiveIsland_Meadow_EventScript_WarehouseDoorAlreadyOpen
 * goto_if_set FLAG_LEARNED_YES_NAH_CHANSEY, FiveIsland_Meadow_EventScript_OpenWarehouseDoor
 * msgbox FiveIsland_Meadow_Text_EnteredPasswordAnotherNeeded
 * releaseall
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_WarehouseDoor : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_UNLOCKED_ROCKET_WAREHOUSE))
        return FiveIsland_Meadow_EventScript_WarehouseDoorAlreadyOpen.run(ctx)
    if (ctx.isFlagSet(KantoFlags.FLAG_LEARNED_YES_NAH_CHANSEY))
        return FiveIsland_Meadow_EventScript_OpenWarehouseDoor.run(ctx)
    ctx.say(FiveIsland_Meadow.EnteredPasswordAnotherNeeded)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FiveIsland_Meadow_Text_WarehouseDoorAlreadyOpen
 * releaseall
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_WarehouseDoorAlreadyOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FiveIsland_Meadow.WarehouseDoorAlreadyOpen)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setflag FLAG_UNLOCKED_ROCKET_WAREHOUSE
 * message FiveIsland_Meadow_Text_EnteredPasswordDoorOpened
 * waitmessage
 * delay 60
 * call FiveIsland_Meadow_EventScript_SetWarehouseDoorUnlocked
 * special DrawWholeMapView
 * playse SE_PIN
 * waitse
 * releaseall
 * end
 * ```
 */
internal object FiveIsland_Meadow_EventScript_OpenWarehouseDoor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_Meadow_EventScript_OpenWarehouseDoor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 12, 21, METATILE_SeviiIslands45_RocketWarehouseDoor_Unlocked, 1
 * return
 * ```
 */
internal object FiveIsland_Meadow_EventScript_SetWarehouseDoorUnlocked : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FiveIsland_Meadow_EventScript_SetWarehouseDoorUnlocked")
}

internal val FiveIsland_MeadowScripts: Map<String, Script> =
    mapOf(
        "FiveIsland_Meadow_EventScript_Rocket3" to FiveIsland_Meadow_EventScript_Rocket3,
        "FiveIsland_Meadow_EventScript_Rocket1" to FiveIsland_Meadow_EventScript_Rocket1,
        "FiveIsland_Meadow_EventScript_Rocket2" to FiveIsland_Meadow_EventScript_Rocket2,
        "FiveIsland_Meadow_EventScript_ItemMaxPotion" to
            FiveIsland_Meadow_EventScript_ItemMaxPotion,
        "FiveIsland_Meadow_EventScript_ItemPPUp" to FiveIsland_Meadow_EventScript_ItemPPUp,
        "FiveIsland_Meadow_EventScript_WarehouseDoor" to
            FiveIsland_Meadow_EventScript_WarehouseDoor,
        "FiveIsland_Meadow_EventScript_WarehouseDoorAlreadyOpen" to
            FiveIsland_Meadow_EventScript_WarehouseDoorAlreadyOpen,
        "FiveIsland_Meadow_EventScript_OpenWarehouseDoor" to
            FiveIsland_Meadow_EventScript_OpenWarehouseDoor,
        "FiveIsland_Meadow_EventScript_SetWarehouseDoorUnlocked" to
            FiveIsland_Meadow_EventScript_SetWarehouseDoorUnlocked,
    )
