package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_WaterPath
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AROMA_LADY_ROSE, SixIsland_WaterPath_Text_RoseIntro, SixIsland_WaterPath_Text_RoseDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_RoseRematch
 * msgbox SixIsland_WaterPath_Text_RosePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Rose : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_AROMA_LADY_ROSE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_WaterPath_EventScript_RoseRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_WaterPath.RosePostBattle)
    }
    ctx.say(SixIsland_WaterPath.RoseIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_WaterPath.RoseDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_EDWARD, SixIsland_WaterPath_Text_EdwardIntro, SixIsland_WaterPath_Text_EdwardDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_EdwardRematch
 * msgbox SixIsland_WaterPath_Text_EdwardPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Edward : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_JUGGLER_EDWARD
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_WaterPath_EventScript_EdwardRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_WaterPath.EdwardPostBattle)
    }
    ctx.say(SixIsland_WaterPath.EdwardIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_WaterPath.EdwardDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_SAMIR, SixIsland_WaterPath_Text_SamirIntro, SixIsland_WaterPath_Text_SamirDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_SamirRematch
 * msgbox SixIsland_WaterPath_Text_SamirPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Samir : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_SAMIR
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_WaterPath_EventScript_SamirRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_WaterPath.SamirPostBattle)
    }
    ctx.say(SixIsland_WaterPath.SamirIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_WaterPath.SamirDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_DENISE, SixIsland_WaterPath_Text_DeniseIntro, SixIsland_WaterPath_Text_DeniseDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_DeniseRematch
 * msgbox SixIsland_WaterPath_Text_DenisePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Denise : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_DENISE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_WaterPath_EventScript_DeniseRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_WaterPath.DenisePostBattle)
    }
    ctx.say(SixIsland_WaterPath.DeniseIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_WaterPath.DeniseDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_MIU_MIA, SixIsland_WaterPath_Text_MiuIntro, SixIsland_WaterPath_Text_MiuDefeat, SixIsland_WaterPath_Text_MiuNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_MiuRematch
 * msgbox SixIsland_WaterPath_Text_MiuPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Miu : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SixIsland_WaterPath_EventScript_Miu")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_TWINS_MIU_MIA, SixIsland_WaterPath_Text_MiaIntro, SixIsland_WaterPath_Text_MiaDefeat, SixIsland_WaterPath_Text_MiaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_MiaRematch
 * msgbox SixIsland_WaterPath_Text_MiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Mia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SixIsland_WaterPath_EventScript_Mia")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_EARL, SixIsland_WaterPath_Text_EarlIntro, SixIsland_WaterPath_Text_EarlDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_WaterPath_EventScript_EarlRematch
 * msgbox SixIsland_WaterPath_Text_EarlPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_Earl : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_EARL
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_WaterPath_EventScript_EarlRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_WaterPath.EarlPostBattle)
    }
    ctx.say(SixIsland_WaterPath.EarlIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_WaterPath.EarlDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ELIXIR
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_ItemElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ELIXIR, KantoFlags.FLAG_HIDE_SIX_ISLAND_WATER_PATH_ELIXIR, 7)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_DRAGON_SCALE
 * end
 * ```
 */
internal object SixIsland_WaterPath_EventScript_ItemDragonScale : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.DRAGON_SCALE, KantoFlags.FLAG_HIDE_SIX_ISLAND_WATER_PATH_DRAGON_SCALE, 8)
  }
}

internal object SixIsland_WaterPath_EventScript_HornWantedSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SixIsland_WaterPath.WantedUltimateHorn)
}

internal object SixIsland_WaterPath_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SixIsland_WaterPath.RouteSign)
}

internal val SixIsland_WaterPathScripts: Map<String, Script> =
    mapOf(
        "SixIsland_WaterPath_EventScript_Rose" to SixIsland_WaterPath_EventScript_Rose,
        "SixIsland_WaterPath_EventScript_Edward" to SixIsland_WaterPath_EventScript_Edward,
        "SixIsland_WaterPath_EventScript_Samir" to SixIsland_WaterPath_EventScript_Samir,
        "SixIsland_WaterPath_EventScript_Denise" to SixIsland_WaterPath_EventScript_Denise,
        "SixIsland_WaterPath_EventScript_Miu" to SixIsland_WaterPath_EventScript_Miu,
        "SixIsland_WaterPath_EventScript_Mia" to SixIsland_WaterPath_EventScript_Mia,
        "SixIsland_WaterPath_EventScript_Earl" to SixIsland_WaterPath_EventScript_Earl,
        "SixIsland_WaterPath_EventScript_ItemElixir" to SixIsland_WaterPath_EventScript_ItemElixir,
        "SixIsland_WaterPath_EventScript_ItemDragonScale" to
            SixIsland_WaterPath_EventScript_ItemDragonScale,
        "SixIsland_WaterPath_EventScript_HornWantedSign" to
            SixIsland_WaterPath_EventScript_HornWantedSign,
        "SixIsland_WaterPath_EventScript_RouteSign" to SixIsland_WaterPath_EventScript_RouteSign,
    )
