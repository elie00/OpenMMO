package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.AbandonedShip_Rooms_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.trainer.generated.HoennTrainers

internal object AbandonedShip_Rooms_1F_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(AbandonedShip_Rooms_1F.TakingALookAround)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HARBOR_MAIL
 * end
 * ```
 */
internal object AbandonedShip_Rooms_1F_EventScript_ItemHarborMail : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HARBOR_MAIL, HoennFlags.FLAG_ITEM_ABANDONED_SHIP_ROOMS_1F_HARBOR_MAIL, 1)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_THALIA_1, AbandonedShip_Rooms_1F_Text_ThaliaIntro, AbandonedShip_Rooms_1F_Text_ThaliaDefeat, AbandonedShip_Rooms_1F_EventScript_RegisterThalia
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, AbandonedShip_Rooms_1F_EventScript_ThaliaRematch
 * msgbox AbandonedShip_Rooms_1F_Text_ThaliaPostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object AbandonedShip_Rooms_1F_EventScript_Thalia : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port AbandonedShip_Rooms_1F_EventScript_Thalia")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_DEMETRIUS, AbandonedShip_Rooms_1F_Text_DemetriusIntro, AbandonedShip_Rooms_1F_Text_DemetriusDefeat
 * msgbox AbandonedShip_Rooms_1F_Text_DemetriusPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object AbandonedShip_Rooms_1F_EventScript_Demetrius : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = HoennTrainers.TRAINER_DEMETRIUS
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(AbandonedShip_Rooms_1F.DemetriusPostBattle)
    }
    ctx.say(AbandonedShip_Rooms_1F.DemetriusIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(AbandonedShip_Rooms_1F.DemetriusDefeat)
  }
}

internal val AbandonedShip_Rooms_1FScripts: Map<String, Script> =
    mapOf(
        "AbandonedShip_Rooms_1F_EventScript_Gentleman" to
            AbandonedShip_Rooms_1F_EventScript_Gentleman,
        "AbandonedShip_Rooms_1F_EventScript_ItemHarborMail" to
            AbandonedShip_Rooms_1F_EventScript_ItemHarborMail,
        "AbandonedShip_Rooms_1F_EventScript_Thalia" to AbandonedShip_Rooms_1F_EventScript_Thalia,
        "AbandonedShip_Rooms_1F_EventScript_Demetrius" to
            AbandonedShip_Rooms_1F_EventScript_Demetrius,
    )
