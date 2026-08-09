package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RustboroCity
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object RustboroCity_OnTransition : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_VISITED_RUSTBORO_CITY)
  }
}

internal object RustboroCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(RustboroCity.GymLeaderIsntEasyWithFire)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEVON_GOODS_STOLEN, RustboroCity_EventScript_FatManSawGrunt
 * msgbox RustboroCity_Text_WeShortenItToDevon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEVON_GOODS_STOLEN))
        return RustboroCity_EventScript_FatManSawGrunt.run(ctx)
    ctx.say(RustboroCity.WeShortenItToDevon)
  }
}

internal object RustboroCity_EventScript_NinjaBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(RustboroCity.CatchRarePokemonIfIGoToSchool)
}

internal object RustboroCity_EventScript_Twin : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(RustboroCity.WowYouHavePokemon)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_POKENAV, RustboroCity_EventScript_Boy2BrineyLeftTunnel
 * msgbox RustboroCity_Text_MrBrineyWalksInTheTunnel, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_Boy2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECEIVED_POKENAV))
        return RustboroCity_EventScript_Boy2BrineyLeftTunnel.run(ctx)
    ctx.say(RustboroCity.MrBrineyWalksInTheTunnel)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_BADGE01_GET, RustboroCity_EventScript_Man1HaveBadge
 * msgbox RustboroCity_Text_HaveYouChallengedGym, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_Man1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_Man1")
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox RustboroCity_Text_PokemonCanChangeLookFromExp, MSGBOX_DEFAULT
 * applymovement LOCALID_RUSTBORO_LITTLE_BOY, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity.PokemonCanChangeLookFromExp)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox RustboroCity_Text_PokemonChangeShape, MSGBOX_DEFAULT
 * applymovement LOCALID_RUSTBORO_LITTLE_GIRL, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity.PokemonChangeShape)
    // TODO Turn the npc back to the way it was facing
    //  The decomp applies Common_Movement_FaceOriginalDirection here. There is no verb
    //  for an object event's original facing, so it keeps looking at the player.
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECOVERED_DEVON_GOODS, RustboroCity_EventScript_ReturnGoodsSpokeToEmployee
 * msgbox RustboroCity_Text_ShadyCharacterTookOffTowardsTunnel, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_DevonEmployee1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RECOVERED_DEVON_GOODS))
        return RustboroCity_EventScript_ReturnGoodsSpokeToEmployee.run(ctx)
    ctx.say(RustboroCity.ShadyCharacterTookOffTowardsTunnel)
  }
}

internal object RustboroCity_EventScript_DevonEmployee2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(RustboroCity.YoureNewAroundHere)
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_X_DEFEND
 * end
 * ```
 */
internal object RustboroCity_EventScript_ItemXDefend : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.X_DEFEND, HoennFlags.FLAG_ITEM_RUSTBORO_CITY_X_DEFEND, 11)
  }
}

internal object RustboroCity_EventScript_Man2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(RustboroCity.TradePokemonGrowFast)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * call_if_unset FLAG_MET_RIVAL_RUSTBORO, RustboroCity_EventScript_PlayRivalMusic
 * applymovement LOCALID_RUSTBORO_RIVAL, Common_Movement_FacePlayer
 * waitmovement 0
 * goto RustboroCity_EventScript_RivalEncounter
 * ```
 */
internal object RustboroCity_EventScript_Rival : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_Rival")
}

internal object RustboroCity_EventScript_Boy1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(RustboroCity.YouCanHave2On2Battle)
}

internal object RustboroCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity.GymSign)
}

internal object RustboroCity_EventScript_TrainersSchoolSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity.TrainersSchoolSign)
}

internal object RustboroCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity.CitySign)
}

internal object RustboroCity_EventScript_DevonCorpSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity.DevonCorpSign)
}

internal object RustboroCity_EventScript_TunnelSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity.TunnelNearingCompletion)
}

internal object RustboroCity_EventScript_CuttersHouseSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity.CuttersHouse)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Text_MrBrineyLovesPeeko, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_Boy2BrineyLeftTunnel : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity.MrBrineyLovesPeeko)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Text_SneakyLookingManWentAroundCorner, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_FatManSawGrunt : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity.SneakyLookingManWentAroundCorner)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Text_HeyThatsRustborosGymBadge, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_EventScript_Man1HaveBadge : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity.HeyThatsRustborosGymBadge)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * waitse
 * setvar VAR_TEMP_1, 4
 * goto RustboroCity_EventScript_ReturnGoods
 * end
 * ```
 */
internal object RustboroCity_EventScript_ReturnGoodsSpokeToEmployee : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_ReturnGoodsSpokeToEmployee")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * goto_if_eq VAR_RESULT, MALE, RustboroCity_EventScript_MayEncounter
 * goto_if_eq VAR_RESULT, FEMALE, RustboroCity_EventScript_BrendanEncounter
 * end
 * ```
 */
internal object RustboroCity_EventScript_RivalEncounter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_RivalEncounter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkplayergender
 * goto_if_eq VAR_RESULT, MALE, RustboroCity_EventScript_PlayMayMusic
 * goto_if_eq VAR_RESULT, FEMALE, RustboroCity_EventScript_PlayBrendanMusic
 * return
 * ```
 */
internal object RustboroCity_EventScript_PlayRivalMusic : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_PlayRivalMusic")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 0, RustboroCity_EventScript_EmployeeFacePlayerUp2
 * call_if_eq VAR_TEMP_1, 1, RustboroCity_EventScript_EmployeeFacePlayerLeft2
 * call_if_eq VAR_TEMP_1, 2, RustboroCity_EventScript_EmployeeFacePlayerDown2
 * call_if_eq VAR_TEMP_1, 3, RustboroCity_EventScript_EmployeeApproachPlayerDown2
 * call_if_eq VAR_TEMP_1, 4, RustboroCity_EventScript_EmployeeFacePlayerRight
 * msgbox RustboroCity_Text_YouGotItThankYou, MSGBOX_DEFAULT
 * giveitem ITEM_GREAT_BALL
 * call_if_eq VAR_RESULT, FALSE, RustboroCity_EventScript_BagFull
 * msgbox RustboroCity_Text_PleaseComeWithMe, MSGBOX_DEFAULT
 * closemessage
 * setflag FLAG_RETURNED_DEVON_GOODS
 * setflag FLAG_HIDE_RUSTBORO_CITY_DEVON_EMPLOYEE_1
 * setvar VAR_RUSTBORO_CITY_STATE, 5
 * delay 30
 * warp MAP_RUSTBORO_CITY_DEVON_CORP_3F, 2, 2
 * waitstate
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_ReturnGoods : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_ReturnGoods")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_Delay48
 * waitmovement 0
 * return
 * ```
 */
internal object RustboroCity_EventScript_EmployeeFacePlayerRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_EmployeeFacePlayerRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_DEFEATED_RIVAL_RUSTBORO, RustboroCity_EventScript_MayBrineyHint
 * goto_if_set FLAG_MET_RIVAL_RUSTBORO, RustboroCity_EventScript_MayAskToBattle
 * setflag FLAG_MET_RIVAL_RUSTBORO
 * msgbox RustboroCity_Text_MayHiLetsRegister, MSGBOX_DEFAULT
 * closemessage
 * delay 30
 * playfanfare MUS_REGISTER_MATCH_CALL
 * msgbox RustboroCity_Text_RegisteredMay, MSGBOX_DEFAULT
 * waitfanfare
 * closemessage
 * delay 30
 * setflag FLAG_ENABLE_RIVAL_MATCH_CALL
 * setvar VAR_RUSTBORO_CITY_STATE, 8
 * setvar VAR_ROUTE104_STATE, 2
 * setvar VAR_0x8008, 0
 * msgbox RustboroCity_Text_MayPassedBrineyWantToBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, RustboroCity_EventScript_BattleMay
 * msgbox RustboroCity_Text_MayOhHaventRaisedPokemonEnough, MSGBOX_DEFAULT
 * call RustboroCity_EventScript_RestoreBgm
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_MayEncounter : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_MayEncounter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * goto_if_set FLAG_DEFEATED_RIVAL_RUSTBORO, RustboroCity_EventScript_BrendanBrineyHint
 * goto_if_set FLAG_MET_RIVAL_RUSTBORO, RustboroCity_EventScript_BrendanAskToBattle
 * setflag FLAG_MET_RIVAL_RUSTBORO
 * msgbox RustboroCity_Text_BrendanHiLetsRegister, MSGBOX_DEFAULT
 * closemessage
 * delay 30
 * playfanfare MUS_REGISTER_MATCH_CALL
 * msgbox RustboroCity_Text_RegisteredBrendan, MSGBOX_DEFAULT
 * waitfanfare
 * closemessage
 * delay 30
 * setflag FLAG_ENABLE_RIVAL_MATCH_CALL
 * setvar VAR_RUSTBORO_CITY_STATE, 8
 * setvar VAR_ROUTE104_STATE, 2
 * msgbox RustboroCity_Text_BrendanPassedBrineyWantToBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, RustboroCity_EventScript_BattleBrendan
 * msgbox RustboroCity_Text_BrendanNoConfidenceInPokemon, MSGBOX_DEFAULT
 * call RustboroCity_EventScript_RestoreBgm
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_BrendanEncounter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_BrendanEncounter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playbgm MUS_ENCOUNTER_BRENDAN, TRUE
 * return
 * ```
 */
internal object RustboroCity_EventScript_PlayBrendanMusic : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_PlayBrendanMusic")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Text_YoureLoadedWithItems, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object RustboroCity_EventScript_BagFull : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity.YoureLoadedWithItems)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_Delay48
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object RustboroCity_EventScript_EmployeeFacePlayerDown2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_EmployeeFacePlayerDown2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * playbgm MUS_ENCOUNTER_MAY, TRUE
 * return
 * ```
 */
internal object RustboroCity_EventScript_PlayMayMusic : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_PlayMayMusic")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_Delay48
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * return
 * ```
 */
internal object RustboroCity_EventScript_EmployeeFacePlayerUp2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_EmployeeFacePlayerUp2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_WalkInPlaceFasterDown
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_Delay48
 * waitmovement 0
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, RustboroCity_Movement_EmployeeApproachPlayerDown
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object RustboroCity_EventScript_EmployeeApproachPlayerDown2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_EmployeeApproachPlayerDown2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * playse SE_PIN
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_ExclamationMark
 * waitmovement 0
 * applymovement LOCALID_RUSTBORO_DEVON_EMPLOYEE, Common_Movement_Delay48
 * waitmovement 0
 * applymovement LOCALID_PLAYER, Common_Movement_FaceLeft
 * waitmovement 0
 * return
 * ```
 */
internal object RustboroCity_EventScript_EmployeeFacePlayerLeft2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_EmployeeFacePlayerLeft2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * savebgm MUS_DUMMY
 * fadedefaultbgm
 * return
 * ```
 */
internal object RustboroCity_EventScript_RestoreBgm : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_RestoreBgm")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Text_BrendanWantToBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, RustboroCity_EventScript_BattleBrendan
 * msgbox RustboroCity_Text_BrendanNoConfidenceInPokemon, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_BrendanAskToBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_BrendanAskToBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Text_BrendanIWontGoEasy, MSGBOX_DEFAULT
 * switch VAR_STARTER_MON
 * case 0, RustboroCity_EventScript_BattleBrendanTreecko
 * case 1, RustboroCity_EventScript_BattleBrendanTorchic
 * case 2, RustboroCity_EventScript_BattleBrendanMudkip
 * end
 * ```
 */
internal object RustboroCity_EventScript_BattleBrendan : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_BattleBrendan")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Text_MayImNotGoingToLose, MSGBOX_DEFAULT
 * switch VAR_STARTER_MON
 * case 0, RustboroCity_EventScript_BattleMayTreecko
 * case 1, RustboroCity_EventScript_BattleMayTorchic
 * case 2, RustboroCity_EventScript_BattleMayMudkip
 * end
 * ```
 */
internal object RustboroCity_EventScript_BattleMay : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_BattleMay")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8008, 1
 * msgbox RustboroCity_Text_MayWantToBattle, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, RustboroCity_EventScript_BattleMay
 * msgbox RustboroCity_Text_MayOhHaventRaisedPokemonEnough, MSGBOX_DEFAULT
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_MayAskToBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_MayAskToBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Text_BrendanMrBrineyHint, MSGBOX_DEFAULT
 * call_if_eq VAR_0x8008, 0, RustboroCity_EventScript_RestoreBgm
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_BrendanBrineyHint : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_EventScript_BrendanBrineyHint")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Text_MayMrBrineyHint, MSGBOX_DEFAULT
 * call_if_eq VAR_0x8008, 0, RustboroCity_EventScript_RestoreBgm
 * releaseall
 * end
 * ```
 */
internal object RustboroCity_EventScript_MayBrineyHint : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port RustboroCity_EventScript_MayBrineyHint")
}

internal val RustboroCityScripts: Map<String, Script> =
    mapOf(
        "RustboroCity_OnTransition" to RustboroCity_OnTransition,
        "RustboroCity_EventScript_Woman" to RustboroCity_EventScript_Woman,
        "RustboroCity_EventScript_FatMan" to RustboroCity_EventScript_FatMan,
        "RustboroCity_EventScript_NinjaBoy" to RustboroCity_EventScript_NinjaBoy,
        "RustboroCity_EventScript_Twin" to RustboroCity_EventScript_Twin,
        "RustboroCity_EventScript_Boy2" to RustboroCity_EventScript_Boy2,
        "RustboroCity_EventScript_Man1" to RustboroCity_EventScript_Man1,
        "RustboroCity_EventScript_LittleBoy" to RustboroCity_EventScript_LittleBoy,
        "RustboroCity_EventScript_LittleGirl" to RustboroCity_EventScript_LittleGirl,
        "RustboroCity_EventScript_DevonEmployee1" to RustboroCity_EventScript_DevonEmployee1,
        "RustboroCity_EventScript_DevonEmployee2" to RustboroCity_EventScript_DevonEmployee2,
        "RustboroCity_EventScript_ItemXDefend" to RustboroCity_EventScript_ItemXDefend,
        "RustboroCity_EventScript_Man2" to RustboroCity_EventScript_Man2,
        "RustboroCity_EventScript_Rival" to RustboroCity_EventScript_Rival,
        "RustboroCity_EventScript_Boy1" to RustboroCity_EventScript_Boy1,
        "RustboroCity_EventScript_GymSign" to RustboroCity_EventScript_GymSign,
        "RustboroCity_EventScript_TrainersSchoolSign" to
            RustboroCity_EventScript_TrainersSchoolSign,
        "RustboroCity_EventScript_CitySign" to RustboroCity_EventScript_CitySign,
        "RustboroCity_EventScript_DevonCorpSign" to RustboroCity_EventScript_DevonCorpSign,
        "RustboroCity_EventScript_TunnelSign" to RustboroCity_EventScript_TunnelSign,
        "RustboroCity_EventScript_CuttersHouseSign" to RustboroCity_EventScript_CuttersHouseSign,
        "RustboroCity_EventScript_Boy2BrineyLeftTunnel" to
            RustboroCity_EventScript_Boy2BrineyLeftTunnel,
        "RustboroCity_EventScript_FatManSawGrunt" to RustboroCity_EventScript_FatManSawGrunt,
        "RustboroCity_EventScript_Man1HaveBadge" to RustboroCity_EventScript_Man1HaveBadge,
        "RustboroCity_EventScript_ReturnGoodsSpokeToEmployee" to
            RustboroCity_EventScript_ReturnGoodsSpokeToEmployee,
        "RustboroCity_EventScript_RivalEncounter" to RustboroCity_EventScript_RivalEncounter,
        "RustboroCity_EventScript_PlayRivalMusic" to RustboroCity_EventScript_PlayRivalMusic,
        "RustboroCity_EventScript_ReturnGoods" to RustboroCity_EventScript_ReturnGoods,
        "RustboroCity_EventScript_EmployeeFacePlayerRight" to
            RustboroCity_EventScript_EmployeeFacePlayerRight,
        "RustboroCity_EventScript_MayEncounter" to RustboroCity_EventScript_MayEncounter,
        "RustboroCity_EventScript_BrendanEncounter" to RustboroCity_EventScript_BrendanEncounter,
        "RustboroCity_EventScript_PlayBrendanMusic" to RustboroCity_EventScript_PlayBrendanMusic,
        "RustboroCity_EventScript_BagFull" to RustboroCity_EventScript_BagFull,
        "RustboroCity_EventScript_EmployeeFacePlayerDown2" to
            RustboroCity_EventScript_EmployeeFacePlayerDown2,
        "RustboroCity_EventScript_PlayMayMusic" to RustboroCity_EventScript_PlayMayMusic,
        "RustboroCity_EventScript_EmployeeFacePlayerUp2" to
            RustboroCity_EventScript_EmployeeFacePlayerUp2,
        "RustboroCity_EventScript_EmployeeApproachPlayerDown2" to
            RustboroCity_EventScript_EmployeeApproachPlayerDown2,
        "RustboroCity_EventScript_EmployeeFacePlayerLeft2" to
            RustboroCity_EventScript_EmployeeFacePlayerLeft2,
        "RustboroCity_EventScript_RestoreBgm" to RustboroCity_EventScript_RestoreBgm,
        "RustboroCity_EventScript_BrendanAskToBattle" to
            RustboroCity_EventScript_BrendanAskToBattle,
        "RustboroCity_EventScript_BattleBrendan" to RustboroCity_EventScript_BattleBrendan,
        "RustboroCity_EventScript_BattleMay" to RustboroCity_EventScript_BattleMay,
        "RustboroCity_EventScript_MayAskToBattle" to RustboroCity_EventScript_MayAskToBattle,
        "RustboroCity_EventScript_BrendanBrineyHint" to RustboroCity_EventScript_BrendanBrineyHint,
        "RustboroCity_EventScript_MayBrineyHint" to RustboroCity_EventScript_MayBrineyHint,
    )
