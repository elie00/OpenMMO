package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route123
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_WENDY, Route123_Text_WendyIntro, Route123_Text_WendyDefeat
 * msgbox Route123_Text_WendyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Wendy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_WENDY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.WendyPostBattle)
    }
    ctx.say(Route123.WendyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.WendyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_BRAXTON, Route123_Text_BraxtonIntro, Route123_Text_BraxtonDefeat
 * msgbox Route123_Text_BraxtonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Braxton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_BRAXTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.BraxtonPostBattle)
    }
    ctx.say(Route123.BraxtonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.BraxtonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CALCIUM
 * end
 * ```
 */
internal object Route123_EventScript_ItemCalcium : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CALCIUM, HoennFlags.FLAG_ITEM_ROUTE_123_CALCIUM, 20)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_TM_GIGA_DRAIN, Route123_EventScript_ReceivedGigaDrain
 * msgbox Route123_Text_LoveGrassMonsHaveAny, MSGBOX_DEFAULT
 * special IsGrassTypeInParty
 * goto_if_eq VAR_RESULT, FALSE, Route123_EventScript_NoGrassMons
 * msgbox Route123_Text_YouLikeGrassMonsTooHaveThis, MSGBOX_DEFAULT
 * giveitem ITEM_TM_GIGA_DRAIN
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull
 * setflag FLAG_RECEIVED_TM_GIGA_DRAIN
 * msgbox Route123_Text_CheckTreesWithMyGrassMon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_EventScript_GigaDrainGirl : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_GigaDrainGirl")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_VIOLET, Route123_Text_VioletIntro, Route123_Text_VioletDefeat
 * msgbox Route123_Text_VioletPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Violet : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_VIOLET
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.VioletPostBattle)
    }
    ctx.say(Route123.VioletIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.VioletDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_MIU_AND_YUKI, Route123_Text_YukiIntro, Route123_Text_YukiDefeat, Route123_Text_YukiNotEnoughMons
 * msgbox Route123_Text_YukiPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Yuki : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_Yuki")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_MIU_AND_YUKI, Route123_Text_MiuIntro, Route123_Text_MiuDefeat, Route123_Text_MiuNotEnoughMons
 * msgbox Route123_Text_MiuPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Miu : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_Miu")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_CAMERON_1, Route123_Text_CameronIntro, Route123_Text_CameronDefeat, Route123_EventScript_RegisterCameron
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route123_EventScript_RematchCameron
 * msgbox Route123_Text_CameronPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_EventScript_Cameron : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_Cameron")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_JACKI_1, Route123_Text_JackiIntro, Route123_Text_JackiDefeat, Route123_EventScript_RegisterJacki
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route123_EventScript_RematchJacki
 * msgbox Route123_Text_JackiPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_EventScript_Jacki : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_Jacki")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KINDRA, Route123_Text_KindraIntro, Route123_Text_KindraDefeat
 * msgbox Route123_Text_KindraPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Kindra : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KINDRA
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.KindraPostBattle)
    }
    ctx.say(Route123.KindraIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.KindraDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ULTRA_BALL
 * end
 * ```
 */
internal object Route123_EventScript_ItemUltraBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ULTRA_BALL, HoennFlags.FLAG_ITEM_ROUTE_123_ULTRA_BALL, 31)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ELIXIR
 * end
 * ```
 */
internal object Route123_EventScript_ItemElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ELIXIR, HoennFlags.FLAG_ITEM_ROUTE_123_ELIXIR, 32)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JONAS, Route123_Text_JonasIntro, Route123_Text_JonasDefeat
 * msgbox Route123_Text_JonasPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Jonas : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JONAS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.JonasPostBattle)
    }
    ctx.say(Route123.JonasIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.JonasDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_KAYLEY, Route123_Text_KayleyIntro, Route123_Text_KayleyDefeat
 * msgbox Route123_Text_KayleyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Kayley : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_KAYLEY
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.KayleyPostBattle)
    }
    ctx.say(Route123.KayleyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.KayleyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ED, Route123_Text_EdIntro, Route123_Text_EdDefeat
 * msgbox Route123_Text_EdPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Ed : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ED
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.EdPostBattle)
    }
    ctx.say(Route123.EdIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.EdDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_FERNANDO_1, Route123_Text_FernandoIntro, Route123_Text_FernandoDefeat, Route123_EventScript_RegisterFernando
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route123_EventScript_RematchFernando
 * msgbox Route123_Text_FernandoPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_EventScript_Fernando : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_Fernando")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ALBERTO, Route123_Text_AlbertoIntro, Route123_Text_AlbertoDefeat
 * msgbox Route123_Text_AlbertoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Alberto : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_ALBERTO
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.AlbertoPostBattle)
    }
    ctx.say(Route123.AlbertoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.AlbertoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_FREDRICK, Route123_Text_FrederickIntro, Route123_Text_FrederickDefeat
 * msgbox Route123_Text_FrederickPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Frederick : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_FREDRICK
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.FrederickPostBattle)
    }
    ctx.say(Route123.FrederickIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.FrederickDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PP_UP
 * end
 * ```
 */
internal object Route123_EventScript_ItemPPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PP_UP, HoennFlags.FLAG_ITEM_ROUTE_123_PP_UP, 39)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JAZMYN, Route123_Text_JazmynIntro, Route123_Text_JazmynDefeat
 * msgbox Route123_Text_JazmynPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Jazmyn : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_JAZMYN
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.JazmynPostBattle)
    }
    ctx.say(Route123.JazmynIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.JazmynDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DAVIS, Route123_Text_DavisIntro, Route123_Text_DavisDefeat
 * msgbox Route123_Text_DavisPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_Davis : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DAVIS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(Route123.DavisPostBattle)
    }
    ctx.say(Route123.DavisIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route123.DavisDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_REVIVAL_HERB
 * end
 * ```
 */
internal object Route123_EventScript_ItemRevivalHerb : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.REVIVAL_HERB, HoennFlags.FLAG_ITEM_ROUTE_123_REVIVAL_HERB, 42)
  }
}

internal object Route123_EventScript_RouteSignMtPyre : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route123.RouteSignMtPyre)
}

internal object Route123_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route123.RouteSign)
}

internal object Route123_EventScript_BerryMastersHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route123.BerryMastersHouse)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_CAMERON_1, Route123_Text_CameronRematchIntro, Route123_Text_CameronRematchDefeat
 * msgbox Route123_Text_CameronPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_RematchCameron : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_RematchCameron")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * release
 * end
 * ```
 */
internal object Route123_EventScript_NoGrassMons : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_NoGrassMons")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_FERNANDO_1, Route123_Text_FernandoRematchIntro, Route123_Text_FernandoRematchDefeat
 * msgbox Route123_Text_FernandoPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_RematchFernando : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_RematchFernando")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch TRAINER_JACKI_1, Route123_Text_JackiRematchIntro, Route123_Text_JackiRematchDefeat
 * msgbox Route123_Text_JackiPostRematch, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route123_EventScript_RematchJacki : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route123_EventScript_RematchJacki")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route123_Text_CheckTreesWithMyGrassMon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route123_EventScript_ReceivedGigaDrain : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route123.CheckTreesWithMyGrassMon)
  }
}

internal val Route123Scripts: Map<String, Script> =
    mapOf(
        "Route123_EventScript_Wendy" to Route123_EventScript_Wendy,
        "Route123_EventScript_Braxton" to Route123_EventScript_Braxton,
        "Route123_EventScript_ItemCalcium" to Route123_EventScript_ItemCalcium,
        "Route123_EventScript_GigaDrainGirl" to Route123_EventScript_GigaDrainGirl,
        "Route123_EventScript_Violet" to Route123_EventScript_Violet,
        "Route123_EventScript_Yuki" to Route123_EventScript_Yuki,
        "Route123_EventScript_Miu" to Route123_EventScript_Miu,
        "Route123_EventScript_Cameron" to Route123_EventScript_Cameron,
        "Route123_EventScript_Jacki" to Route123_EventScript_Jacki,
        "Route123_EventScript_Kindra" to Route123_EventScript_Kindra,
        "Route123_EventScript_ItemUltraBall" to Route123_EventScript_ItemUltraBall,
        "Route123_EventScript_ItemElixir" to Route123_EventScript_ItemElixir,
        "Route123_EventScript_Jonas" to Route123_EventScript_Jonas,
        "Route123_EventScript_Kayley" to Route123_EventScript_Kayley,
        "Route123_EventScript_Ed" to Route123_EventScript_Ed,
        "Route123_EventScript_Fernando" to Route123_EventScript_Fernando,
        "Route123_EventScript_Alberto" to Route123_EventScript_Alberto,
        "Route123_EventScript_Frederick" to Route123_EventScript_Frederick,
        "Route123_EventScript_ItemPPUp" to Route123_EventScript_ItemPPUp,
        "Route123_EventScript_Jazmyn" to Route123_EventScript_Jazmyn,
        "Route123_EventScript_Davis" to Route123_EventScript_Davis,
        "Route123_EventScript_ItemRevivalHerb" to Route123_EventScript_ItemRevivalHerb,
        "Route123_EventScript_RouteSignMtPyre" to Route123_EventScript_RouteSignMtPyre,
        "Route123_EventScript_RouteSign" to Route123_EventScript_RouteSign,
        "Route123_EventScript_BerryMastersHouseSign" to Route123_EventScript_BerryMastersHouseSign,
        "Route123_EventScript_RematchCameron" to Route123_EventScript_RematchCameron,
        "Route123_EventScript_NoGrassMons" to Route123_EventScript_NoGrassMons,
        "Route123_EventScript_RematchFernando" to Route123_EventScript_RematchFernando,
        "Route123_EventScript_RematchJacki" to Route123_EventScript_RematchJacki,
        "Route123_EventScript_ReceivedGigaDrain" to Route123_EventScript_ReceivedGigaDrain,
    )
