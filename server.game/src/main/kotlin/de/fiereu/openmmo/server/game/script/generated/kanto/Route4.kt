package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route4
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

internal object Route4_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route4.TrippedOverGeodude)
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_LASS_CRISSY, Route4_Text_CrissyIntro, Route4_Text_CrissyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, Route4_EventScript_CrissyRematch
 * msgbox Route4_Text_CrissyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object Route4_EventScript_Crissy : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_LASS_CRISSY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (Route4_EventScript_CrissyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(Route4.CrissyPostBattle)
    }
    ctx.say(Route4.CrissyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(Route4.CrissyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM05
 * end
 * ```
 */
internal object Route4_EventScript_ItemTM05 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM05, KantoFlags.FLAG_HIDE_ROUTE4_TM05, 2)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_BROCK, 3
 * msgbox Route4_Text_PeopleLikeAndRespectBrock
 * release
 * end
 * ```
 */
internal object Route4_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route4_EventScript_Boy")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_MEGA_PUNCH, EventScript_MegaPunchTaught
 * msgbox Text_MegaPunchTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_MegaPunchDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_MegaPunchDeclined
 * msgbox Text_MegaPunchWhichMon
 * setvar VAR_0x8005, MOVETUTOR_MEGA_PUNCH
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_MegaPunchDeclined
 * setflag FLAG_TUTOR_MEGA_PUNCH
 * goto EventScript_MegaPunchTaught
 * end
 * ```
 */
internal object Route4_EventScript_MegaPunchTutor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route4_EventScript_MegaPunchTutor")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_TUTOR_MEGA_KICK, EventScript_MegaKickTaught
 * msgbox Text_MegaKickTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, EventScript_MegaKickDeclined
 * call EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, EventScript_MegaKickDeclined
 * msgbox Text_MegaKickWhichMon
 * setvar VAR_0x8005, MOVETUTOR_MEGA_KICK
 * call EventScript_ChooseMoveTutorMon
 * goto_if_eq VAR_RESULT, FALSE, EventScript_MegaKickDeclined
 * setflag FLAG_TUTOR_MEGA_KICK
 * goto EventScript_MegaKickTaught
 * end
 * ```
 */
internal object Route4_EventScript_MegaKickTutor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Route4_EventScript_MegaKickTutor")
}

internal object Route4_EventScript_MtMoonSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route4.MtMoonEntrance)
}

internal object Route4_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route4.RouteSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MegaKickDeclined
 * release
 * end
 * ```
 */
internal object EventScript_MegaKickDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MegaKickDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MegaPunchTaught
 * release
 * end
 * ```
 */
internal object EventScript_MegaPunchTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MegaPunchTaught")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MegaPunchDeclined
 * release
 * end
 * ```
 */
internal object EventScript_MegaPunchDeclined : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MegaPunchDeclined")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox Text_MegaKickTaught
 * release
 * end
 * ```
 */
internal object EventScript_MegaKickTaught : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_MegaKickTaught")
}

internal val Route4Scripts: Map<String, Script> =
    mapOf(
        "Route4_EventScript_Woman" to Route4_EventScript_Woman,
        "Route4_EventScript_Crissy" to Route4_EventScript_Crissy,
        "Route4_EventScript_ItemTM05" to Route4_EventScript_ItemTM05,
        "Route4_EventScript_Boy" to Route4_EventScript_Boy,
        "Route4_EventScript_MegaPunchTutor" to Route4_EventScript_MegaPunchTutor,
        "Route4_EventScript_MegaKickTutor" to Route4_EventScript_MegaKickTutor,
        "Route4_EventScript_MtMoonSign" to Route4_EventScript_MtMoonSign,
        "Route4_EventScript_RouteSign" to Route4_EventScript_RouteSign,
        "EventScript_MegaKickDeclined" to EventScript_MegaKickDeclined,
        "EventScript_MegaPunchTaught" to EventScript_MegaPunchTaught,
        "EventScript_MegaPunchDeclined" to EventScript_MegaPunchDeclined,
        "EventScript_MegaKickTaught" to EventScript_MegaKickTaught,
    )
