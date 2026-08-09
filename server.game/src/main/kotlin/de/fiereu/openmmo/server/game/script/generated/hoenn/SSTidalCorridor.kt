package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SSTidalCorridor
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_SS_TIDAL_STATE, SS_TIDAL_LAND_LILYCOVE, SSTidalCorridor_EventScript_ExitLilycove
 * goto_if_eq VAR_SS_TIDAL_STATE, SS_TIDAL_LAND_SLATEPORT, SSTidalCorridor_EventScript_ExitSlateport
 * msgbox SSTidalCorridor_Text_CanRestInCabin2, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_ExitSailor : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SSTidalCorridor_EventScript_ExitSailor")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_SS_TIDAL_TRAINERS, SSTidalCorridor_EventScript_EnjoyYourCruise
 * call SSTidalCorridor_EventScript_CheckIfTrainersDefeated
 * msgbox SSTidalCorridor_Text_VisitOtherCabins, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_Sailor : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_SS_TIDAL_TRAINERS))
        return SSTidalCorridor_EventScript_EnjoyYourCruise.run(ctx)
    SSTidalCorridor_EventScript_CheckIfTrainersDefeated.run(ctx)
    ctx.say(SSTidalCorridor.VisitOtherCabins)
  }
}

internal object SSTidalCorridor_EventScript_Briney : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSTidalCorridor.BrineyWelcomeAboard)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_WINGULL, CRY_MODE_NORMAL
 * msgbox SSTidalCorridor_Text_Peeko, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_Peeko : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SSTidalCorridor_EventScript_Peeko")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_eq VAR_SS_TIDAL_STATE, SS_TIDAL_DEPART_SLATEPORT, SSTidalCorridor_EventScript_LookThroughPorthole
 * goto_if_eq VAR_SS_TIDAL_STATE, SS_TIDAL_HALFWAY_SLATEPORT, SSTidalCorridor_EventScript_LookThroughPorthole
 * msgbox SSTidalCorridor_Text_HorizonSpreadsBeyondPorthole, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_Porthole : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SSTidalCorridor_EventScript_Porthole")
}

internal object SSTidalCorridor_EventScript_Cabin1Sign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SSTidalCorridor.Cabin1)
}

internal object SSTidalCorridor_EventScript_Cabin2Sign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SSTidalCorridor.Cabin2)
}

internal object SSTidalCorridor_EventScript_Cabin3Sign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SSTidalCorridor.Cabin3)
}

internal object SSTidalCorridor_EventScript_Cabin4Sign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SSTidalCorridor.Cabin4)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_not_defeated TRAINER_PHILLIP, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_LEONARD, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_COLTON, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_MICAH, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_THOMAS, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_LEA_AND_JED, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_GARRET, SSTidalCorridor_EventScript_TrainerNotDefeated
 * goto_if_not_defeated TRAINER_NAOMI, SSTidalCorridor_EventScript_TrainerNotDefeated
 * setflag FLAG_DEFEATED_SS_TIDAL_TRAINERS
 * goto SSTidalCorridor_EventScript_EnjoyYourCruise
 * return
 * ```
 */
internal object SSTidalCorridor_EventScript_CheckIfTrainersDefeated : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SSTidalCorridor_EventScript_CheckIfTrainersDefeated")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setrespawn HEAL_LOCATION_LILYCOVE_CITY
 * msgbox SSTidalCorridor_Text_WeveArrived, MSGBOX_DEFAULT
 * call_if_set FLAG_RECEIVED_TM_SNATCH, SSTidalCorridor_EventScript_HideSnatchGiver
 * warp MAP_LILYCOVE_CITY_HARBOR, 8, 11
 * waitstate
 * release
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_ExitLilycove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SSTidalCorridor_EventScript_ExitLilycove")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setrespawn HEAL_LOCATION_SLATEPORT_CITY
 * msgbox SSTidalCorridor_Text_WeveArrived, MSGBOX_DEFAULT
 * call_if_set FLAG_RECEIVED_TM_SNATCH, SSTidalCorridor_EventScript_HideSnatchGiver
 * warp MAP_SLATEPORT_CITY_HARBOR, 8, 11
 * waitstate
 * release
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_ExitSlateport : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SSTidalCorridor_EventScript_ExitSlateport")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SSTidalCorridor_Text_EnjoyYourCruise, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_EnjoyYourCruise : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SSTidalCorridor.EnjoyYourCruise)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special LookThroughPorthole
 * end
 * ```
 */
internal object SSTidalCorridor_EventScript_LookThroughPorthole : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SSTidalCorridor_EventScript_LookThroughPorthole")
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_HIDE_SS_TIDAL_ROOMS_SNATCH_GIVER
 * return
 * ```
 */
internal object SSTidalCorridor_EventScript_HideSnatchGiver : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_HIDE_SS_TIDAL_ROOMS_SNATCH_GIVER)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * return
 * ```
 */
internal object SSTidalCorridor_EventScript_TrainerNotDefeated : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SSTidalCorridor_EventScript_TrainerNotDefeated")
}

internal val SSTidalCorridorScripts: Map<String, Script> =
    mapOf(
        "SSTidalCorridor_EventScript_ExitSailor" to SSTidalCorridor_EventScript_ExitSailor,
        "SSTidalCorridor_EventScript_Sailor" to SSTidalCorridor_EventScript_Sailor,
        "SSTidalCorridor_EventScript_Briney" to SSTidalCorridor_EventScript_Briney,
        "SSTidalCorridor_EventScript_Peeko" to SSTidalCorridor_EventScript_Peeko,
        "SSTidalCorridor_EventScript_Porthole" to SSTidalCorridor_EventScript_Porthole,
        "SSTidalCorridor_EventScript_Cabin1Sign" to SSTidalCorridor_EventScript_Cabin1Sign,
        "SSTidalCorridor_EventScript_Cabin2Sign" to SSTidalCorridor_EventScript_Cabin2Sign,
        "SSTidalCorridor_EventScript_Cabin3Sign" to SSTidalCorridor_EventScript_Cabin3Sign,
        "SSTidalCorridor_EventScript_Cabin4Sign" to SSTidalCorridor_EventScript_Cabin4Sign,
        "SSTidalCorridor_EventScript_CheckIfTrainersDefeated" to
            SSTidalCorridor_EventScript_CheckIfTrainersDefeated,
        "SSTidalCorridor_EventScript_ExitLilycove" to SSTidalCorridor_EventScript_ExitLilycove,
        "SSTidalCorridor_EventScript_ExitSlateport" to SSTidalCorridor_EventScript_ExitSlateport,
        "SSTidalCorridor_EventScript_EnjoyYourCruise" to
            SSTidalCorridor_EventScript_EnjoyYourCruise,
        "SSTidalCorridor_EventScript_LookThroughPorthole" to
            SSTidalCorridor_EventScript_LookThroughPorthole,
        "SSTidalCorridor_EventScript_HideSnatchGiver" to
            SSTidalCorridor_EventScript_HideSnatchGiver,
        "SSTidalCorridor_EventScript_TrainerNotDefeated" to
            SSTidalCorridor_EventScript_TrainerNotDefeated,
    )
