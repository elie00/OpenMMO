package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_OutcastIsland
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_46, SixIsland_OutcastIsland_Text_RocketIntro, SixIsland_OutcastIsland_Text_RocketDefeat
 * msgbox SixIsland_OutcastIsland_Text_RocketPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Rocket : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_46
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SixIsland_OutcastIsland.RocketPostBattle)
    }
    ctx.say(SixIsland_OutcastIsland.RocketIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_OutcastIsland.RocketDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_TYLOR, SixIsland_OutcastIsland_Text_TylorIntro, SixIsland_OutcastIsland_Text_TylorDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_TylorRematch
 * msgbox SixIsland_OutcastIsland_Text_TylorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Tylor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Tylor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_MYMO, SixIsland_OutcastIsland_Text_MymoIntro, SixIsland_OutcastIsland_Text_MymoDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_MymoRematch
 * msgbox SixIsland_OutcastIsland_Text_MymoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Mymo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Mymo")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_NICOLE, SixIsland_OutcastIsland_Text_NicoleIntro, SixIsland_OutcastIsland_Text_NicoleDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_NicoleRematch
 * msgbox SixIsland_OutcastIsland_Text_NicolePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Nicole : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Nicole")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_AVA_GEB, SixIsland_OutcastIsland_Text_AvaIntro, SixIsland_OutcastIsland_Text_AvaDefeat, SixIsland_OutcastIsland_Text_AvaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_AvaRematch
 * msgbox SixIsland_OutcastIsland_Text_AvaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Ava : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Ava")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_SIS_AND_BRO_AVA_GEB, SixIsland_OutcastIsland_Text_GebIntro, SixIsland_OutcastIsland_Text_GebDefeat, SixIsland_OutcastIsland_Text_GebNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_OutcastIsland_EventScript_GebRematch
 * msgbox SixIsland_OutcastIsland_Text_GebPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_Geb : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_OutcastIsland_EventScript_Geb")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object SixIsland_OutcastIsland_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, KantoFlags.FLAG_HIDE_SIX_ISLAND_OUTCAST_ISLAND_PP_UP, 6)
  }
}

internal val SixIsland_OutcastIslandScripts: Map<String, Script> =
    mapOf(
        "SixIsland_OutcastIsland_EventScript_Rocket" to SixIsland_OutcastIsland_EventScript_Rocket,
        "SixIsland_OutcastIsland_EventScript_Tylor" to SixIsland_OutcastIsland_EventScript_Tylor,
        "SixIsland_OutcastIsland_EventScript_Mymo" to SixIsland_OutcastIsland_EventScript_Mymo,
        "SixIsland_OutcastIsland_EventScript_Nicole" to SixIsland_OutcastIsland_EventScript_Nicole,
        "SixIsland_OutcastIsland_EventScript_Ava" to SixIsland_OutcastIsland_EventScript_Ava,
        "SixIsland_OutcastIsland_EventScript_Geb" to SixIsland_OutcastIsland_EventScript_Geb,
        "SixIsland_OutcastIsland_EventScript_ItemPPUp" to
            SixIsland_OutcastIsland_EventScript_ItemPPUp,
    )
