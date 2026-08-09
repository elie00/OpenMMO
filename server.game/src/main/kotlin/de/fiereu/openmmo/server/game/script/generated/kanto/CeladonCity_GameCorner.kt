package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_GameCorner
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

internal object CeladonCity_GameCorner_EventScript_InfoClerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(CeladonCity_GameCorner.CanExchangeCoinsNextDoor)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_questlog EventScript_ReleaseEnd
 * lock
 * faceplayer
 * showmoneybox 0, 0
 * showcoinsbox 0, 5
 * message CeladonCity_GameCorner_Text_WelcomeBuySomeCoins
 * waitmessage
 * multichoice 13, 0, MULTICHOICE_GAME_CORNER_COIN_PURCHASE_COUNTER, FALSE
 * copyvar VAR_0x8009, VAR_RESULT
 * switch VAR_RESULT
 * case 0, CeladonCity_GameCorner_EventScript_BuyCoins
 * case 1, CeladonCity_GameCorner_EventScript_BuyCoins
 * case 2, CeladonCity_GameCorner_EventScript_ClerkDeclineBuy
 * case 127, CeladonCity_GameCorner_EventScript_ClerkDeclineBuy
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_CoinsClerk : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_CoinsClerk")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeladonCity_GameCorner_Text_RumoredTeamRocketRunsThisPlace
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.RumoredTeamRocketRunsThisPlace)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeladonCity_GameCorner_Text_ThinkMachinesHaveDifferentOdds
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_Woman1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.ThinkMachinesHaveDifferentOdds)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_10_COINS_FROM_GAMBLER, CeladonCity_GameCorner_EventScript_FisherAlreadyGotCoins
 * msgbox CeladonCity_GameCorner_Text_DoYouWantToPlay
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_EventScript_GamblerNoCoinCase
 * checkcoins VAR_TEMP_1
 * goto_if_ge VAR_TEMP_1, (MAX_COINS + 1) - 10, CeladonCity_GameCorner_EventScript_FisherNoRoomForCoins
 * addcoins 10
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox CeladonCity_GameCorner_Text_Received10CoinsFromMan
 * playse SE_SHOP
 * waitse
 * setflag FLAG_GOT_10_COINS_FROM_GAMBLER
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_Fisher : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_Fisher")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_ERIKA, CeladonCity_GameCorner_EventScript_GymGuyPostVictory
 * msgbox CeladonCity_GameCorner_Text_GymGuyAdvice
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_ERIKA))
        return CeladonCity_GameCorner_EventScript_GymGuyPostVictory.run(ctx)
    ctx.say(CeladonCity_GameCorner.GymGuyAdvice)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeladonCity_GameCorner_Text_WinOrLoseItsOnlyLuck
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_Woman2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.WinOrLoseItsOnlyLuck)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox CeladonCity_GameCorner_Text_SoEasyToGetHooked
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.SoEasyToGetHooked)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_20_COINS_FROM_GAMBLER, CeladonCity_GameCorner_EventScript_ScientistAlreadyGotCoins
 * msgbox CeladonCity_GameCorner_Text_WantSomeCoins
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_EventScript_GamblerNoCoinCase
 * checkcoins VAR_TEMP_1
 * goto_if_ge VAR_TEMP_1, (MAX_COINS + 1) - 20, CeladonCity_GameCorner_EventScript_ScientistNoRoomForCoins
 * addcoins 20
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox CeladonCity_GameCorner_Text_Received20CoinsFromNiceGuy
 * playse SE_SHOP
 * waitse
 * setflag FLAG_GOT_20_COINS_FROM_GAMBLER
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_Scientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_20_COINS_FROM_GAMBLER_2, CeladonCity_GameCorner_EventScript_GentlemanAlreadyGotCoins
 * msgbox CeladonCity_GameCorner_Text_HereAreSomeCoinsShoo
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_EventScript_GamblerNoCoinCase
 * checkcoins VAR_TEMP_1
 * goto_if_ge VAR_TEMP_1, (MAX_COINS + 1) - 20, CeladonCity_GameCorner_EventScript_GentlemanNoRoomForCoins
 * addcoins 20
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox CeladonCity_GameCorner_Text_Received20CoinsFromMan
 * playse SE_SHOP
 * waitse
 * setflag FLAG_GOT_20_COINS_FROM_GAMBLER_2
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_Gentleman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_7, CeladonCity_GameCorner_Text_GruntIntro, CeladonCity_GameCorner_Text_GruntDefeat, CeladonCity_GameCorner_Text_DefeatedGrunt
 * msgbox CeladonCity_GameCorner_Text_GruntPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_RocketGrunt : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_RocketGrunt")
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 0
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine0 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 0)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 1
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 1)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 2
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 2)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 3
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine3 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 3)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

internal object CeladonCity_GameCorner_EventScript_UnusableSlotMachine1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_GameCorner.OutOfOrder)
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 5
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine5 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 5)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 6
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine6 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 6)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 7
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine7 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 7)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 8
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine8 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 8)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 9
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine9 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 9)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 10
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine10 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 10)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 11
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine11 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 11)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 12
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine12 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 12)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 13
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine13 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 13)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 14
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine14 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 14)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

internal object CeladonCity_GameCorner_EventScript_UnusableSlotMachine2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_GameCorner.OutToLunch)
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 16
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine16 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 16)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 17
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine17 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 17)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

internal object CeladonCity_GameCorner_EventScript_UnusableSlotMachine3 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(CeladonCity_GameCorner.SomeonesKeys)
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 19
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine19 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 19)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 20
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine20 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 20)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * setvar VAR_0x8004, 21
 * goto CeladonCity_GameCorner_EventScript_SlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine21 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8004, 21)
    return CeladonCity_GameCorner_EventScript_SlotMachine.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * msgbox CeladonCity_GameCorner_Text_SwitchBehindPosterPushIt
 * call_if_unset FLAG_OPENED_ROCKET_HIDEOUT, CeladonCity_GameCorner_EventScript_OpenRocketHideout
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_Poster : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_Poster")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * showmoneybox 0, 0
 * msgbox CeladonCity_GameCorner_Text_TryPokemonPrinter, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CeladonCity_GameCorner_EventScript_DeclinePhoto
 * checkmoney 50
 * goto_if_eq VAR_RESULT, FALSE, CeladonCity_GameCorner_EventScript_NotEnoughMoneyForPhoto
 * playse SE_SHOP
 * removemoney 50
 * updatemoneybox
 * waitse
 * message CeladonCity_GameCorner_Text_ChoosePrintType
 * waitmessage
 * multichoice 21, 0, MULTICHOICE_TRAINER_CARD_ICON_TINT, TRUE
 * switch VAR_RESULT
 * case 0, CeladonCity_GameCorner_EventScript_PrintTypeNormal
 * case 1, CeladonCity_GameCorner_EventScript_PrintTypeBlack
 * case 2, CeladonCity_GameCorner_EventScript_PrintTypePink
 * case 3, CeladonCity_GameCorner_EventScript_PrintTypeSepia
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_PhotoPrinter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_PhotoPrinter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * closemessage
 * applymovement VAR_LAST_TALKED, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_FaceSlotMachine : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_FaceSlotMachine")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * msgbox CeladonCity_GameCorner_Text_DontHaveCoinCase
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_GamblerNoCoinCase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_GamblerNoCoinCase")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_YouHaveLotsOfCoins
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_ScientistNoRoomForCoins : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.YouHaveLotsOfCoins)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_unset FLAG_GOT_COIN_CASE, CeladonCity_GameCorner_EventScript_SlotMachineNoCoinCase
 * msgbox CeladonCity_GameCorner_Text_SlotMachineWantToPlay, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, CeladonCity_GameCorner_EventScript_DontPlaySlotMachine
 * setfieldeffectargument 0, LOCALID_PLAYER
 * .ifdef BUGFIX
 * setfieldeffectargument 1, MAP_NUM(MAP_CELADON_CITY_GAME_CORNER)
 * setfieldeffectargument 2, MAP_GROUP(MAP_CELADON_CITY_GAME_CORNER)
 * .else
 * setfieldeffectargument 1, MAP_GROUP(MAP_CELADON_CITY_GAME_CORNER)
 * setfieldeffectargument 2, MAP_NUM(MAP_CELADON_CITY_GAME_CORNER)
 * .endif
 * dofieldeffect FLDEFF_SMILEY_FACE_ICON
 * waitfieldeffect FLDEFF_SMILEY_FACE_ICON
 * specialvar VAR_RESULT, GetRandomSlotMachineId
 * playslotmachine VAR_RESULT
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachine : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_SlotMachine")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_WinsComeAndGo
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_FisherAlreadyGotCoins : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.WinsComeAndGo)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * hidemoneybox
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_DeclinePhoto : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_DeclinePhoto")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_WatchReelsClosely
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_GentlemanAlreadyGotCoins : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.WatchReelsClosely)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_RareMonsForCoins
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_GymGuyPostVictory : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.RareMonsForCoins)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_DontNeedMyCoins
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_FisherNoRoomForCoins : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.DontNeedMyCoins)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playse SE_UNLOCK
 * setmetatile 15, 2, METATILE_GameCorner_Floor_StairsTop, 0
 * setmetatile 16, 2, METATILE_GameCorner_StairsTop, 1
 * setmetatile 17, 2, METATILE_GameCorner_StairsBottom, 1
 * setmetatile 16, 3, METATILE_GameCorner_PurpleWall_StairsTop, 1
 * setmetatile 17, 3, METATILE_GameCorner_PurpleWall_stairsBottom, 1
 * special DrawWholeMapView
 * setflag FLAG_OPENED_ROCKET_HIDEOUT
 * return
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_OpenRocketHideout : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_OpenRocketHideout")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox CeladonCity_GameCorner_Text_DontHaveEnoughMoney
 * hidemoneybox
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_NotEnoughMoneyForPhoto : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_NotEnoughMoneyForPhoto")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_NeedMoreCoinsForMonIWant
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_ScientistAlreadyGotCoins : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.NeedMoreCoinsForMonIWant)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_YouveGotPlentyCoins
 * goto CeladonCity_GameCorner_EventScript_FaceSlotMachine
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_GentlemanNoRoomForCoins : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.YouveGotPlentyCoins)
    return CeladonCity_GameCorner_EventScript_FaceSlotMachine.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox CeladonCity_GameCorner_Text_CoinCaseIsRequired
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_SlotMachineNoCoinCase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_GameCorner.CoinCaseIsRequired)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * releaseall
 * end
 * ```
 */
internal object CeladonCity_GameCorner_EventScript_DontPlaySlotMachine : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port CeladonCity_GameCorner_EventScript_DontPlaySlotMachine")
}

internal val CeladonCity_GameCornerScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_GameCorner_EventScript_InfoClerk" to
            CeladonCity_GameCorner_EventScript_InfoClerk,
        "CeladonCity_GameCorner_EventScript_CoinsClerk" to
            CeladonCity_GameCorner_EventScript_CoinsClerk,
        "CeladonCity_GameCorner_EventScript_BaldingMan" to
            CeladonCity_GameCorner_EventScript_BaldingMan,
        "CeladonCity_GameCorner_EventScript_Woman1" to CeladonCity_GameCorner_EventScript_Woman1,
        "CeladonCity_GameCorner_EventScript_Fisher" to CeladonCity_GameCorner_EventScript_Fisher,
        "CeladonCity_GameCorner_EventScript_GymGuy" to CeladonCity_GameCorner_EventScript_GymGuy,
        "CeladonCity_GameCorner_EventScript_Woman2" to CeladonCity_GameCorner_EventScript_Woman2,
        "CeladonCity_GameCorner_EventScript_OldMan" to CeladonCity_GameCorner_EventScript_OldMan,
        "CeladonCity_GameCorner_EventScript_Scientist" to
            CeladonCity_GameCorner_EventScript_Scientist,
        "CeladonCity_GameCorner_EventScript_Gentleman" to
            CeladonCity_GameCorner_EventScript_Gentleman,
        "CeladonCity_GameCorner_EventScript_RocketGrunt" to
            CeladonCity_GameCorner_EventScript_RocketGrunt,
        "CeladonCity_GameCorner_EventScript_SlotMachine0" to
            CeladonCity_GameCorner_EventScript_SlotMachine0,
        "CeladonCity_GameCorner_EventScript_SlotMachine1" to
            CeladonCity_GameCorner_EventScript_SlotMachine1,
        "CeladonCity_GameCorner_EventScript_SlotMachine2" to
            CeladonCity_GameCorner_EventScript_SlotMachine2,
        "CeladonCity_GameCorner_EventScript_SlotMachine3" to
            CeladonCity_GameCorner_EventScript_SlotMachine3,
        "CeladonCity_GameCorner_EventScript_UnusableSlotMachine1" to
            CeladonCity_GameCorner_EventScript_UnusableSlotMachine1,
        "CeladonCity_GameCorner_EventScript_SlotMachine5" to
            CeladonCity_GameCorner_EventScript_SlotMachine5,
        "CeladonCity_GameCorner_EventScript_SlotMachine6" to
            CeladonCity_GameCorner_EventScript_SlotMachine6,
        "CeladonCity_GameCorner_EventScript_SlotMachine7" to
            CeladonCity_GameCorner_EventScript_SlotMachine7,
        "CeladonCity_GameCorner_EventScript_SlotMachine8" to
            CeladonCity_GameCorner_EventScript_SlotMachine8,
        "CeladonCity_GameCorner_EventScript_SlotMachine9" to
            CeladonCity_GameCorner_EventScript_SlotMachine9,
        "CeladonCity_GameCorner_EventScript_SlotMachine10" to
            CeladonCity_GameCorner_EventScript_SlotMachine10,
        "CeladonCity_GameCorner_EventScript_SlotMachine11" to
            CeladonCity_GameCorner_EventScript_SlotMachine11,
        "CeladonCity_GameCorner_EventScript_SlotMachine12" to
            CeladonCity_GameCorner_EventScript_SlotMachine12,
        "CeladonCity_GameCorner_EventScript_SlotMachine13" to
            CeladonCity_GameCorner_EventScript_SlotMachine13,
        "CeladonCity_GameCorner_EventScript_SlotMachine14" to
            CeladonCity_GameCorner_EventScript_SlotMachine14,
        "CeladonCity_GameCorner_EventScript_UnusableSlotMachine2" to
            CeladonCity_GameCorner_EventScript_UnusableSlotMachine2,
        "CeladonCity_GameCorner_EventScript_SlotMachine16" to
            CeladonCity_GameCorner_EventScript_SlotMachine16,
        "CeladonCity_GameCorner_EventScript_SlotMachine17" to
            CeladonCity_GameCorner_EventScript_SlotMachine17,
        "CeladonCity_GameCorner_EventScript_UnusableSlotMachine3" to
            CeladonCity_GameCorner_EventScript_UnusableSlotMachine3,
        "CeladonCity_GameCorner_EventScript_SlotMachine19" to
            CeladonCity_GameCorner_EventScript_SlotMachine19,
        "CeladonCity_GameCorner_EventScript_SlotMachine20" to
            CeladonCity_GameCorner_EventScript_SlotMachine20,
        "CeladonCity_GameCorner_EventScript_SlotMachine21" to
            CeladonCity_GameCorner_EventScript_SlotMachine21,
        "CeladonCity_GameCorner_EventScript_Poster" to CeladonCity_GameCorner_EventScript_Poster,
        "CeladonCity_GameCorner_EventScript_PhotoPrinter" to
            CeladonCity_GameCorner_EventScript_PhotoPrinter,
        "CeladonCity_GameCorner_EventScript_FaceSlotMachine" to
            CeladonCity_GameCorner_EventScript_FaceSlotMachine,
        "CeladonCity_GameCorner_EventScript_GamblerNoCoinCase" to
            CeladonCity_GameCorner_EventScript_GamblerNoCoinCase,
        "CeladonCity_GameCorner_EventScript_ScientistNoRoomForCoins" to
            CeladonCity_GameCorner_EventScript_ScientistNoRoomForCoins,
        "CeladonCity_GameCorner_EventScript_SlotMachine" to
            CeladonCity_GameCorner_EventScript_SlotMachine,
        "CeladonCity_GameCorner_EventScript_FisherAlreadyGotCoins" to
            CeladonCity_GameCorner_EventScript_FisherAlreadyGotCoins,
        "CeladonCity_GameCorner_EventScript_DeclinePhoto" to
            CeladonCity_GameCorner_EventScript_DeclinePhoto,
        "CeladonCity_GameCorner_EventScript_GentlemanAlreadyGotCoins" to
            CeladonCity_GameCorner_EventScript_GentlemanAlreadyGotCoins,
        "CeladonCity_GameCorner_EventScript_GymGuyPostVictory" to
            CeladonCity_GameCorner_EventScript_GymGuyPostVictory,
        "CeladonCity_GameCorner_EventScript_FisherNoRoomForCoins" to
            CeladonCity_GameCorner_EventScript_FisherNoRoomForCoins,
        "CeladonCity_GameCorner_EventScript_OpenRocketHideout" to
            CeladonCity_GameCorner_EventScript_OpenRocketHideout,
        "CeladonCity_GameCorner_EventScript_NotEnoughMoneyForPhoto" to
            CeladonCity_GameCorner_EventScript_NotEnoughMoneyForPhoto,
        "CeladonCity_GameCorner_EventScript_ScientistAlreadyGotCoins" to
            CeladonCity_GameCorner_EventScript_ScientistAlreadyGotCoins,
        "CeladonCity_GameCorner_EventScript_GentlemanNoRoomForCoins" to
            CeladonCity_GameCorner_EventScript_GentlemanNoRoomForCoins,
        "CeladonCity_GameCorner_EventScript_SlotMachineNoCoinCase" to
            CeladonCity_GameCorner_EventScript_SlotMachineNoCoinCase,
        "CeladonCity_GameCorner_EventScript_DontPlaySlotMachine" to
            CeladonCity_GameCorner_EventScript_DontPlaySlotMachine,
    )
