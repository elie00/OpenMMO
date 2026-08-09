package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ThreeIsland_BondBridge
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AROMA_LADY_NIKKI, ThreeIsland_BondBridge_Text_NikkiIntro, ThreeIsland_BondBridge_Text_NikkiDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_NikkiRematch
 * msgbox ThreeIsland_BondBridge_Text_NikkiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Nikki : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_AROMA_LADY_NIKKI
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (ThreeIsland_BondBridge_EventScript_NikkiRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(ThreeIsland_BondBridge.NikkiPostBattle)
    }
    ctx.say(ThreeIsland_BondBridge.NikkiIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ThreeIsland_BondBridge.NikkiDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AROMA_LADY_VIOLET, ThreeIsland_BondBridge_Text_VioletIntro, ThreeIsland_BondBridge_Text_VioletDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_VioletRematch
 * msgbox ThreeIsland_BondBridge_Text_VioletPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Violet : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_AROMA_LADY_VIOLET
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (ThreeIsland_BondBridge_EventScript_VioletRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(ThreeIsland_BondBridge.VioletPostBattle)
    }
    ctx.say(ThreeIsland_BondBridge.VioletIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ThreeIsland_BondBridge.VioletDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TUBER_AMIRA, ThreeIsland_BondBridge_Text_AmiraIntro, ThreeIsland_BondBridge_Text_AmiraDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_AmiraRematch
 * msgbox ThreeIsland_BondBridge_Text_AmiraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Amira : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TUBER_AMIRA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (ThreeIsland_BondBridge_EventScript_AmiraRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(ThreeIsland_BondBridge.AmiraPostBattle)
    }
    ctx.say(ThreeIsland_BondBridge.AmiraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ThreeIsland_BondBridge.AmiraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TUBER_ALEXIS, ThreeIsland_BondBridge_Text_AlexisIntro, ThreeIsland_BondBridge_Text_AlexisDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_AlexisRematch
 * msgbox ThreeIsland_BondBridge_Text_AlexisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Alexis : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TUBER_ALEXIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (ThreeIsland_BondBridge_EventScript_AlexisRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(ThreeIsland_BondBridge.AlexisPostBattle)
    }
    ctx.say(ThreeIsland_BondBridge.AlexisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ThreeIsland_BondBridge.AlexisDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_TISHA, ThreeIsland_BondBridge_Text_TishaIntro, ThreeIsland_BondBridge_Text_TishaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_TishaRematch
 * msgbox ThreeIsland_BondBridge_Text_TishaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Tisha : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_TISHA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (ThreeIsland_BondBridge_EventScript_TishaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(ThreeIsland_BondBridge.TishaPostBattle)
    }
    ctx.say(ThreeIsland_BondBridge.TishaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(ThreeIsland_BondBridge.TishaDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_JOY_MEG, ThreeIsland_BondBridge_Text_JoyIntro, ThreeIsland_BondBridge_Text_JoyDefeat, ThreeIsland_BondBridge_Text_JoyNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_JoyRematch
 * msgbox ThreeIsland_BondBridge_Text_JoyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Joy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_BondBridge_EventScript_Joy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_JOY_MEG, ThreeIsland_BondBridge_Text_MegIntro, ThreeIsland_BondBridge_Text_MegDefeat, ThreeIsland_BondBridge_Text_MegNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, ThreeIsland_BondBridge_EventScript_MegRematch
 * msgbox ThreeIsland_BondBridge_Text_MegPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object ThreeIsland_BondBridge_EventScript_Meg : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_BondBridge_EventScript_Meg")
}

internal object ThreeIsland_BondBridge_EventScript_BerryForestSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(ThreeIsland_BondBridge.BerryForestAhead)
}

internal object ThreeIsland_BondBridge_EventScript_BondBridgeSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(ThreeIsland_BondBridge.BondBridgeSign)
}

internal val ThreeIsland_BondBridgeScripts: Map<String, Script> =
    mapOf(
        "ThreeIsland_BondBridge_EventScript_Nikki" to ThreeIsland_BondBridge_EventScript_Nikki,
        "ThreeIsland_BondBridge_EventScript_Violet" to ThreeIsland_BondBridge_EventScript_Violet,
        "ThreeIsland_BondBridge_EventScript_Amira" to ThreeIsland_BondBridge_EventScript_Amira,
        "ThreeIsland_BondBridge_EventScript_Alexis" to ThreeIsland_BondBridge_EventScript_Alexis,
        "ThreeIsland_BondBridge_EventScript_Tisha" to ThreeIsland_BondBridge_EventScript_Tisha,
        "ThreeIsland_BondBridge_EventScript_Joy" to ThreeIsland_BondBridge_EventScript_Joy,
        "ThreeIsland_BondBridge_EventScript_Meg" to ThreeIsland_BondBridge_EventScript_Meg,
        "ThreeIsland_BondBridge_EventScript_BerryForestSign" to
            ThreeIsland_BondBridge_EventScript_BerryForestSign,
        "ThreeIsland_BondBridge_EventScript_BondBridgeSign" to
            ThreeIsland_BondBridge_EventScript_BondBridgeSign,
    )
