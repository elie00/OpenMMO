package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.TrainerTower_Lobby
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_DOWN
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

private const val LOCALID_RECEPTIONIST = 2

internal object TrainerTower_Lobby_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) = EventScript_PkmnCenterNurse.run(ctx)
}

internal object TrainerTower_Lobby_EventScript_MartClerk : Script {
  override suspend fun run(ctx: ScriptContext) {
    // TODO Open the tower's mart shop
    //  The decomp wraps pokemart TrainerTower_Lobby_Mart_Items in Text_MayIHelpYou and
    //  Text_PleaseComeAgain. Buying and selling needs a shop verb, and the two lines are only the
    //  frame around it.
  }
}

/**
 * ttower_getbeatchallenge is HasSpokenToOwner, which only a finished tower run can make true, so
 * this takes the branch a save that never cleared the tower takes. Her ThanksForCompeting line
 * needs the tower's challenge state.
 */
internal object TrainerTower_Lobby_EventScript_Receptionist : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(TrainerTower_Lobby.GiveItYourBest)
}

/** The receptionist greets the player the moment they step up to her counter. */
internal object TrainerTower_Lobby_EventScript_EntryTrigger : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.moveSelf(FACE_RIGHT)
    ctx.sayNpc(LOCALID_RECEPTIONIST, TrainerTower_Lobby.WelcomeToTrainerTower)
    // ttower_getnumfloors buffers the top floor of the tower's own set, which on the cartridge's
    // data is the eighth, so this branch says the same thing without a string variable to fill.
    ctx.sayNpc(LOCALID_RECEPTIONIST, TrainerTower_Lobby.TrainersUpEighthFloor)
    // TODO Offer the Trainer Tower challenge
    //  The decomp asks LikeToChallengeTrainers through MULTICHOICE_YES_NO_INFO, explains the tower
    //  on the third answer, then picks a mode through MULTICHOICE_TRAINER_TOWER_MODE and runs
    //  ttower_startchallenge. That needs a multichoice verb and the tower's own timer and floor
    //  state, so only the decline branch below is ported.
    ctx.sayNpc(LOCALID_RECEPTIONIST, TrainerTower_Lobby.PleaseVisitUsAgain)
    ctx.moveSelf(WALK_DOWN)
  }
}

internal object TrainerTower_Lobby_EventScript_CooltrainerF : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(TrainerTower_Lobby.WonderWhatKindsOfTrainers)
}

internal object TrainerTower_Lobby_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(TrainerTower_Lobby.StairsTougherThanAnyBattle)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * fadescreen FADE_TO_BLACK
 * setvar VAR_0x8004, 1
 * special ShowBattleRecords
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object TrainerTower_Lobby_EventScript_ShowRecords : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TrainerTower_Lobby_EventScript_ShowRecords")
}

internal val TrainerTower_LobbyScripts: Map<String, Script> =
    mapOf(
        "TrainerTower_Lobby_EventScript_Nurse" to TrainerTower_Lobby_EventScript_Nurse,
        "TrainerTower_Lobby_EventScript_MartClerk" to TrainerTower_Lobby_EventScript_MartClerk,
        "TrainerTower_Lobby_EventScript_Receptionist" to
            TrainerTower_Lobby_EventScript_Receptionist,
        "TrainerTower_Lobby_EventScript_CooltrainerF" to
            TrainerTower_Lobby_EventScript_CooltrainerF,
        "TrainerTower_Lobby_EventScript_BaldingMan" to TrainerTower_Lobby_EventScript_BaldingMan,
        "TrainerTower_Lobby_EventScript_ShowRecords" to TrainerTower_Lobby_EventScript_ShowRecords,
        "TrainerTower_Lobby_EventScript_EntryTrigger" to
            TrainerTower_Lobby_EventScript_EntryTrigger,
    )
