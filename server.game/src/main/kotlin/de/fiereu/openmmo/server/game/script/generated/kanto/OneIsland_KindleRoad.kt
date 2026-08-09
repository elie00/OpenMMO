package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.OneIsland_KindleRoad
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_MARIA, OneIsland_KindleRoad_Text_MariaIntro, OneIsland_KindleRoad_Text_MariaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_MariaRematch
 * msgbox OneIsland_KindleRoad_Text_MariaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Maria : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_MARIA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_MariaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.MariaPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.MariaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.MariaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_FEMALE_ABIGAIL, OneIsland_KindleRoad_Text_AbigailIntro, OneIsland_KindleRoad_Text_AbigailDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_AbigailRematch
 * msgbox OneIsland_KindleRoad_Text_AbigailPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Abigail : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_FEMALE_ABIGAIL
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_AbigailRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.AbigailPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.AbigailIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.AbigailDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_FINN, OneIsland_KindleRoad_Text_FinnIntro, OneIsland_KindleRoad_Text_FinnDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_FinnRematch
 * msgbox OneIsland_KindleRoad_Text_FinnPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Finn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_FINN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_FinnRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.FinnPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.FinnIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.FinnDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SWIMMER_MALE_GARRETT, OneIsland_KindleRoad_Text_GarrettIntro, OneIsland_KindleRoad_Text_GarrettDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_GarrettRematch
 * msgbox OneIsland_KindleRoad_Text_GarrettPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Garrett : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SWIMMER_MALE_GARRETT
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_GarrettRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.GarrettPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.GarrettIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.GarrettDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FISHERMAN_TOMMY, OneIsland_KindleRoad_Text_TommyIntro, OneIsland_KindleRoad_Text_TommyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_TommyRematch
 * msgbox OneIsland_KindleRoad_Text_TommyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Tommy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_FISHERMAN_TOMMY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_TommyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.TommyPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.TommyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.TommyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CRUSH_GIRL_SHARON, OneIsland_KindleRoad_Text_SharonIntro, OneIsland_KindleRoad_Text_SharonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_SharonRematch
 * msgbox OneIsland_KindleRoad_Text_SharonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Sharon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CRUSH_GIRL_SHARON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_SharonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.SharonPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.SharonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.SharonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CRUSH_GIRL_TANYA, OneIsland_KindleRoad_Text_TanyaIntro, OneIsland_KindleRoad_Text_TanyaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_TanyaRematch
 * msgbox OneIsland_KindleRoad_Text_TanyaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Tanya : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CRUSH_GIRL_TANYA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_TanyaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.TanyaPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.TanyaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.TanyaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_SHEA, OneIsland_KindleRoad_Text_SheaIntro, OneIsland_KindleRoad_Text_SheaDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_SheaRematch
 * msgbox OneIsland_KindleRoad_Text_SheaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Shea : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_SHEA
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_SheaRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.SheaPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.SheaIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.SheaDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BLACK_BELT_HUGH, OneIsland_KindleRoad_Text_HughIntro, OneIsland_KindleRoad_Text_HughDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_HughRematch
 * msgbox OneIsland_KindleRoad_Text_HughPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Hugh : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_BLACK_BELT_HUGH
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_HughRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.HughPostBattle)
    }
    ctx.say(OneIsland_KindleRoad.HughIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.HughDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_CAMPER_BRYCE, OneIsland_KindleRoad_Text_BryceIntro, OneIsland_KindleRoad_Text_BryceDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_BryceRematch
 * msgbox OneIsland_KindleRoad_Text_BrycePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Bryce : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_CAMPER_BRYCE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_BryceRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.BrycePostBattle)
    }
    ctx.say(OneIsland_KindleRoad.BryceIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.BryceDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PICNICKER_CLAIRE, OneIsland_KindleRoad_Text_ClaireIntro, OneIsland_KindleRoad_Text_ClaireDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_ClaireRematch
 * msgbox OneIsland_KindleRoad_Text_ClairePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Claire : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PICNICKER_CLAIRE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (OneIsland_KindleRoad_EventScript_ClaireRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(OneIsland_KindleRoad.ClairePostBattle)
    }
    ctx.say(OneIsland_KindleRoad.ClaireIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(OneIsland_KindleRoad.ClaireDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_MIK_KIA, OneIsland_KindleRoad_Text_MikIntro, OneIsland_KindleRoad_Text_MikDefeat, OneIsland_KindleRoad_Text_MikNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_MikRematch
 * msgbox OneIsland_KindleRoad_Text_MikPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Mik : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port OneIsland_KindleRoad_EventScript_Mik")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_CRUSH_KIN_MIK_KIA, OneIsland_KindleRoad_Text_KiaIntro, OneIsland_KindleRoad_Text_KiaDefeat, OneIsland_KindleRoad_Text_KiaNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_KindleRoad_EventScript_KiaRematch
 * msgbox OneIsland_KindleRoad_Text_KiaPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_Kia : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port OneIsland_KindleRoad_EventScript_Kia")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ETHER
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_ItemEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ETHER, KantoFlags.FLAG_HIDE_ONE_ISLAND_KINDLE_ROAD_ETHER, 26)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_MAX_REPEL
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_ItemMaxRepel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.MAX_REPEL, KantoFlags.FLAG_HIDE_ONE_ISLAND_KINDLE_ROAD_MAX_REPEL, 27)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARBOS
 * end
 * ```
 */
internal object OneIsland_KindleRoad_EventScript_ItemCarbos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARBOS, KantoFlags.FLAG_HIDE_ONE_ISLAND_KINDLE_ROAD_CARBOS, 28)
  }
}

internal object OneIsland_KindleRoad_EventScript_EmberSpaSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(OneIsland_KindleRoad.EmberSpaSign)
}

internal object OneIsland_KindleRoad_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(OneIsland_KindleRoad.RouteSign)
}

internal val OneIsland_KindleRoadScripts: Map<String, Script> =
    mapOf(
        "OneIsland_KindleRoad_EventScript_Maria" to OneIsland_KindleRoad_EventScript_Maria,
        "OneIsland_KindleRoad_EventScript_Abigail" to OneIsland_KindleRoad_EventScript_Abigail,
        "OneIsland_KindleRoad_EventScript_Finn" to OneIsland_KindleRoad_EventScript_Finn,
        "OneIsland_KindleRoad_EventScript_Garrett" to OneIsland_KindleRoad_EventScript_Garrett,
        "OneIsland_KindleRoad_EventScript_Tommy" to OneIsland_KindleRoad_EventScript_Tommy,
        "OneIsland_KindleRoad_EventScript_Sharon" to OneIsland_KindleRoad_EventScript_Sharon,
        "OneIsland_KindleRoad_EventScript_Tanya" to OneIsland_KindleRoad_EventScript_Tanya,
        "OneIsland_KindleRoad_EventScript_Shea" to OneIsland_KindleRoad_EventScript_Shea,
        "OneIsland_KindleRoad_EventScript_Hugh" to OneIsland_KindleRoad_EventScript_Hugh,
        "OneIsland_KindleRoad_EventScript_Bryce" to OneIsland_KindleRoad_EventScript_Bryce,
        "OneIsland_KindleRoad_EventScript_Claire" to OneIsland_KindleRoad_EventScript_Claire,
        "OneIsland_KindleRoad_EventScript_Mik" to OneIsland_KindleRoad_EventScript_Mik,
        "OneIsland_KindleRoad_EventScript_Kia" to OneIsland_KindleRoad_EventScript_Kia,
        "OneIsland_KindleRoad_EventScript_ItemEther" to OneIsland_KindleRoad_EventScript_ItemEther,
        "OneIsland_KindleRoad_EventScript_ItemMaxRepel" to
            OneIsland_KindleRoad_EventScript_ItemMaxRepel,
        "OneIsland_KindleRoad_EventScript_ItemCarbos" to
            OneIsland_KindleRoad_EventScript_ItemCarbos,
        "OneIsland_KindleRoad_EventScript_EmberSpaSign" to
            OneIsland_KindleRoad_EventScript_EmberSpaSign,
        "OneIsland_KindleRoad_EventScript_RouteSign" to OneIsland_KindleRoad_EventScript_RouteSign,
    )
