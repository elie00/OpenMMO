package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route11
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_EDDIE, Route11_Text_EddieIntro, Route11_Text_EddieDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_EddieRematch
 * msgbox Route11_Text_EddiePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Eddie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_EDDIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_EddieRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.EddiePostBattle)
    }
    ctx.say(Route11.EddieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.EddieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GAMER_HUGO, Route11_Text_HugoIntro, Route11_Text_HugoDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_HugoRematch
 * msgbox Route11_Text_HugoPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Hugo : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GAMER_HUGO
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_HugoRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.HugoPostBattle)
    }
    ctx.say(Route11.HugoIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.HugoDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_DILLON, Route11_Text_DillonIntro, Route11_Text_DillonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_DillonRematch
 * msgbox Route11_Text_DillonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Dillon : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_DILLON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_DillonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.DillonPostBattle)
    }
    ctx.say(Route11.DillonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.DillonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_DAVE, Route11_Text_DaveIntro, Route11_Text_DaveDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_DaveRematch
 * msgbox Route11_Text_DavePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Dave : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_DAVE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_DaveRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.DavePostBattle)
    }
    ctx.say(Route11.DaveIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.DaveDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GAMER_JASPER, Route11_Text_JasperIntro, Route11_Text_JasperDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_JasperRematch
 * msgbox Route11_Text_JasperPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Jasper : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GAMER_JASPER
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_JasperRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.JasperPostBattle)
    }
    ctx.say(Route11.JasperIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.JasperDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GAMER_DARIAN, Route11_Text_DarianIntro, Route11_Text_DarianDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_DarianRematch
 * msgbox Route11_Text_DarianPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Darian : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GAMER_DARIAN
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_DarianRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.DarianPostBattle)
    }
    ctx.say(Route11.DarianIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.DarianDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ENGINEER_BRAXTON, Route11_Text_BraxtonIntro, Route11_Text_BraxtonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_BraxtonRematch
 * msgbox Route11_Text_BraxtonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Braxton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_ENGINEER_BRAXTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_BraxtonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.BraxtonPostBattle)
    }
    ctx.say(Route11.BraxtonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.BraxtonDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_YOUNGSTER_YASU, Route11_Text_YasuIntro, Route11_Text_YasuDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_YasuRematch
 * msgbox Route11_Text_YasuPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Yasu : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_YOUNGSTER_YASU
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_YasuRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.YasuPostBattle)
    }
    ctx.say(Route11.YasuIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.YasuDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_GAMER_DIRK, Route11_Text_DirkIntro, Route11_Text_DirkDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_DirkRematch
 * msgbox Route11_Text_DirkPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Dirk : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_GAMER_DIRK
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_DirkRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.DirkPostBattle)
    }
    ctx.say(Route11.DirkIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.DirkDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_ENGINEER_BERNIE, Route11_Text_BernieIntro, Route11_Text_BernieDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route11_EventScript_BernieRematch
 * msgbox Route11_Text_BerniePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route11_EventScript_Bernie : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_ENGINEER_BERNIE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route11_EventScript_BernieRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route11.BerniePostBattle)
    }
    ctx.say(Route11.BernieIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route11.BernieDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_X_DEFEND
 * end
 * ```
 */
internal object Route11_EventScript_ItemXDefend : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.X_DEFEND, KantoFlags.FLAG_HIDE_ROUTE11_X_DEFEND, 10)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_GREAT_BALL
 * end
 * ```
 */
internal object Route11_EventScript_ItemGreatBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.GREAT_BALL, KantoFlags.FLAG_HIDE_ROUTE11_GREAT_BALL, 11)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_AWAKENING
 * end
 * ```
 */
internal object Route11_EventScript_ItemAwakening : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.AWAKENING, KantoFlags.FLAG_HIDE_ROUTE11_AWAKENING, 12)
  }
}

internal object Route11_EventScript_DiglettsCaveSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route11.DiglettsCave)
}

internal val Route11Scripts: Map<String, Script> =
    mapOf(
        "Route11_EventScript_Eddie" to Route11_EventScript_Eddie,
        "Route11_EventScript_Hugo" to Route11_EventScript_Hugo,
        "Route11_EventScript_Dillon" to Route11_EventScript_Dillon,
        "Route11_EventScript_Dave" to Route11_EventScript_Dave,
        "Route11_EventScript_Jasper" to Route11_EventScript_Jasper,
        "Route11_EventScript_Darian" to Route11_EventScript_Darian,
        "Route11_EventScript_Braxton" to Route11_EventScript_Braxton,
        "Route11_EventScript_Yasu" to Route11_EventScript_Yasu,
        "Route11_EventScript_Dirk" to Route11_EventScript_Dirk,
        "Route11_EventScript_Bernie" to Route11_EventScript_Bernie,
        "Route11_EventScript_ItemXDefend" to Route11_EventScript_ItemXDefend,
        "Route11_EventScript_ItemGreatBall" to Route11_EventScript_ItemGreatBall,
        "Route11_EventScript_ItemAwakening" to Route11_EventScript_ItemAwakening,
        "Route11_EventScript_DiglettsCaveSign" to Route11_EventScript_DiglettsCaveSign,
    )
