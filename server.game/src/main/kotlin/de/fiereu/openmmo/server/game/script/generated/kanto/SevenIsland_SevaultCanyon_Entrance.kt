package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SevenIsland_SevaultCanyon_Entrance
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_AROMA_LADY_MIAH, SevenIsland_SevaultCanyon_Entrance_Text_MiahIntro, SevenIsland_SevaultCanyon_Entrance_Text_MiahDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_Entrance_EventScript_MiahRematch
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_MiahPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_Miah : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_AROMA_LADY_MIAH
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_SevaultCanyon_Entrance_EventScript_MiahRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_SevaultCanyon_Entrance.MiahPostBattle)
    }
    ctx.say(SevenIsland_SevaultCanyon_Entrance.MiahIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_SevaultCanyon_Entrance.MiahDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_YOUNG_COUPLE_EVE_JON, SevenIsland_SevaultCanyon_Entrance_Text_EveIntro, SevenIsland_SevaultCanyon_Entrance_Text_EveDefeat, SevenIsland_SevaultCanyon_Entrance_Text_EveNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_Entrance_EventScript_EveRematch
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_EvePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_Eve : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_Entrance_EventScript_Eve")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_double TRAINER_YOUNG_COUPLE_EVE_JON, SevenIsland_SevaultCanyon_Entrance_Text_JonIntro, SevenIsland_SevaultCanyon_Entrance_Text_JonDefeat, SevenIsland_SevaultCanyon_Entrance_Text_JonNotEnoughMons
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_Entrance_EventScript_JonRematch
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_JonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_Jon : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_Entrance_EventScript_Jon")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PKMN_RANGER_NICOLAS, SevenIsland_SevaultCanyon_Entrance_Text_NicolasIntro, SevenIsland_SevaultCanyon_Entrance_Text_NicolasDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_Entrance_EventScript_NicolasRematch
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_NicolasPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_Nicolas : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PKMN_RANGER_NICOLAS
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_SevaultCanyon_Entrance_EventScript_NicolasRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_SevaultCanyon_Entrance.NicolasPostBattle)
    }
    ctx.say(SevenIsland_SevaultCanyon_Entrance.NicolasIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_SevaultCanyon_Entrance.NicolasDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_PKMN_RANGER_MADELINE, SevenIsland_SevaultCanyon_Entrance_Text_MadelineIntro, SevenIsland_SevaultCanyon_Entrance_Text_MadelineDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_Entrance_EventScript_MadelineRematch
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_MadelinePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_Madeline : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_PKMN_RANGER_MADELINE
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_SevaultCanyon_Entrance_EventScript_MadelineRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_SevaultCanyon_Entrance.MadelinePostBattle)
    }
    ctx.say(SevenIsland_SevaultCanyon_Entrance.MadelineIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_SevaultCanyon_Entrance.MadelineDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_MASON, SevenIsland_SevaultCanyon_Entrance_Text_MasonIntro, SevenIsland_SevaultCanyon_Entrance_Text_MasonDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SevenIsland_SevaultCanyon_Entrance_EventScript_MasonRematch
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_MasonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_Mason : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_JUGGLER_MASON
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SevenIsland_SevaultCanyon_Entrance_EventScript_MasonRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SevenIsland_SevaultCanyon_Entrance.MasonPostBattle)
    }
    ctx.say(SevenIsland_SevaultCanyon_Entrance.MasonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SevenIsland_SevaultCanyon_Entrance.MasonDefeat)
  }
}

internal object SevenIsland_SevaultCanyon_Entrance_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(SevenIsland_SevaultCanyon_Entrance.RouteSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_YOUNG_COUPLE_EVE_JON, SevenIsland_SevaultCanyon_Entrance_Text_JonRematchIntro, SevenIsland_SevaultCanyon_Entrance_Text_JonDefeat, SevenIsland_SevaultCanyon_Entrance_Text_JonNotEnoughMons
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_JonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_JonRematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_Entrance_EventScript_JonRematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_rematch_double TRAINER_YOUNG_COUPLE_EVE_JON, SevenIsland_SevaultCanyon_Entrance_Text_EveRematchIntro, SevenIsland_SevaultCanyon_Entrance_Text_EveDefeat, SevenIsland_SevaultCanyon_Entrance_Text_EveNotEnoughMons
 * msgbox SevenIsland_SevaultCanyon_Entrance_Text_EvePostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SevenIsland_SevaultCanyon_Entrance_EventScript_EveRematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SevenIsland_SevaultCanyon_Entrance_EventScript_EveRematch")
}

internal val SevenIsland_SevaultCanyon_EntranceScripts: Map<String, Script> =
    mapOf(
        "SevenIsland_SevaultCanyon_Entrance_EventScript_Miah" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_Miah,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_Eve" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_Eve,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_Jon" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_Jon,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_Nicolas" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_Nicolas,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_Madeline" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_Madeline,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_Mason" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_Mason,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_RouteSign" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_RouteSign,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_JonRematch" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_JonRematch,
        "SevenIsland_SevaultCanyon_Entrance_EventScript_EveRematch" to
            SevenIsland_SevaultCanyon_Entrance_EventScript_EveRematch,
    )
