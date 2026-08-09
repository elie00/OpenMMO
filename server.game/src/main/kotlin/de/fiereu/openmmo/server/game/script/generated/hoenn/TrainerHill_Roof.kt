package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.TrainerHill_Roof
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerhill_settrainerflags
 * lock
 * faceplayer
 * trainerhill_getownerstate
 * switch VAR_RESULT
 * case 0, TrainerHill_Roof_EventScript_Arrived
 * case 1, TrainerHill_Roof_EventScript_GivePrize
 * case 2, TrainerHill_Roof_EventScript_AlreadyReceivedPrize
 * msgbox TrainerHill_Roof_Text_YouFinallyCameBravo, MSGBOX_DEFAULT
 * trainerhill_giveprize
 * switch VAR_RESULT
 * case 0, TrainerHill_Roof_EventScript_ReceivePrize
 * case 1, TrainerHill_Roof_EventScript_NoRoomForPrize
 * case 2, TrainerHill_Roof_EventScript_CheckFinalTime
 * msgbox TrainerHill_Roof_Text_HaveTheMostMarvelousGift, MSGBOX_DEFAULT
 * playfanfare MUS_LEVEL_UP
 * message gText_ObtainedTheItem
 * waitfanfare
 * waitmessage
 * goto TrainerHill_Roof_EventScript_CheckFinalTime
 * ```
 */
internal object TrainerHill_Roof_EventScript_Owner : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port TrainerHill_Roof_EventScript_Owner")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerhill_finaltime
 * switch VAR_RESULT
 * case 0, TrainerHill_Roof_EventScript_NewRecord
 * case 1, TrainerHill_Roof_EventScript_NoNewRecord
 * case 2, TrainerHill_Roof_EventScript_EndSpeakToOwner
 * msgbox TrainerHill_Roof_Text_GotHereMarvelouslyQuickly, MSGBOX_DEFAULT
 * goto TrainerHill_Roof_EventScript_EndSpeakToOwner
 * end
 * ```
 */
internal object TrainerHill_Roof_EventScript_CheckFinalTime : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TrainerHill_Roof_EventScript_CheckFinalTime")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox TrainerHill_Roof_Text_ArriveZippierNextTime, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object TrainerHill_Roof_EventScript_EndSpeakToOwner : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(TrainerHill_Roof.ArriveZippierNextTime)
  }
}

internal val TrainerHill_RoofScripts: Map<String, Script> =
    mapOf(
        "TrainerHill_Roof_EventScript_Owner" to TrainerHill_Roof_EventScript_Owner,
        "TrainerHill_Roof_EventScript_CheckFinalTime" to
            TrainerHill_Roof_EventScript_CheckFinalTime,
        "TrainerHill_Roof_EventScript_EndSpeakToOwner" to
            TrainerHill_Roof_EventScript_EndSpeakToOwner,
    )
