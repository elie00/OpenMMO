package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.OneIsland_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * call EventScript_PkmnCenterNurse
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) {
    EventScript_PkmnCenterNurse.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * goto_if_set FLAG_SEVII_DETOUR_FINISHED, OneIsland_PokemonCenter_1F_EventScript_BillGoTakeStroll
 * msgbox OneIsland_PokemonCenter_1F_Text_HmmHowAboutLikeThis
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_Bill : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_SEVII_DETOUR_FINISHED))
        return OneIsland_PokemonCenter_1F_EventScript_BillGoTakeStroll.run(ctx)
    ctx.say(OneIsland_PokemonCenter_1F.HmmHowAboutLikeThis)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_eq VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 7, OneIsland_PokemonCenter_1F_EventScript_CelioGiveBillFact
 * goto_if_eq VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 6, OneIsland_PokemonCenter_1F_EventScript_CelioJustGivenSapphire
 * goto_if_set FLAG_RECOVERED_SAPPHIRE, OneIsland_PokemonCenter_1F_EventScript_GiveCelioSapphire
 * goto_if_eq VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 5, OneIsland_PokemonCenter_1F_EventScript_ExplainRainbowPass
 * goto_if_set FLAG_GOT_RUBY, OneIsland_PokemonCenter_1F_EventScript_GiveCelioRuby
 * goto_if_eq VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 4, OneIsland_PokemonCenter_1F_EventScript_CelioWaitingForRuby
 * specialvar VAR_RESULT, IsNationalPokedexEnabled
 * goto_if_eq VAR_RESULT, TRUE, OneIsland_PokemonCenter_1F_EventScript_CelioRequestRuby
 * goto_if_eq VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 3, OneIsland_PokemonCenter_1F_EventScript_CelioPlayerMissingNationalDex
 * msgbox OneIsland_PokemonCenter_1F_Text_SorryForBeingPoorHost
 * closemessage
 * applymovement LOCALID_CELIO, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_Celio : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_Celio")
}

internal object OneIsland_PokemonCenter_1F_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(OneIsland_PokemonCenter_1F.CameFromPalletDontKnowIt)
}

internal object OneIsland_PokemonCenter_1F_EventScript_Hiker : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(OneIsland_PokemonCenter_1F.EnormousVolcanoOnIsland)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_SYS_CAN_LINK_WITH_RS, OneIsland_PokemonCenter_1F_EventScript_CrushGirlHoennLinked
 * msgbox OneIsland_PokemonCenter_1F_Text_WishICouldTradeWithBoyfriend
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CrushGirl : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_CrushGirl")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_SYS_CAN_LINK_WITH_RS, OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithHoenn
 * goto_if_set FLAG_SEVII_DETOUR_FINISHED, OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithKanto
 * msgbox OneIsland_PokemonCenter_1F_Text_MachineUnderAdjustment
 * releaseall
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_NetworkMachine : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_NetworkMachine")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_TradedWithFarAwayBoyfriend
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CrushGirlHoennLinked : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.TradedWithFarAwayBoyfriend)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_ONE_ISLAND_POKEMON_CENTER_BILL, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox OneIsland_PokemonCenter_1F_Text_GotPCWorkingStrollAWhileMore
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_BillGoTakeStroll : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_BillGoTakeStroll")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_CelioHearingRumorsAboutYou
 * random 3
 * goto_if_eq VAR_RESULT, 0, OneIsland_PokemonCenter_1F_EventScript_BillFact1
 * goto_if_eq VAR_RESULT, 1, OneIsland_PokemonCenter_1F_EventScript_BillFact2
 * famechecker FAMECHECKER_BILL, 5
 * msgbox OneIsland_PokemonCenter_1F_Text_BillCantStomachMilk
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CelioGiveBillFact : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_CelioGiveBillFact")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_WishYouBestOfLuck
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CelioJustGivenSapphire : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.WishYouBestOfLuck)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_CelioCaughtMoreMonMaybeICanBeUseful
 * applymovement LOCALID_CELIO, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * msgbox OneIsland_PokemonCenter_1F_Text_YoullBeTradingFromTrainersFarAway
 * applymovement LOCALID_CELIO, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox OneIsland_PokemonCenter_1F_Text_NeedsSpecialGemstone
 * setvar VAR_MAP_SCENE_MT_EMBER_EXTERIOR, 1
 * setvar VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 4
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CelioRequestRuby : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_CelioRequestRuby")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_TMHM
 * message OneIsland_PokemonCenter_1F_Text_HandedSapphireToCelio
 * waitmessage
 * waitfanfare
 * call EventScript_RestorePrevTextColor
 * removeitem ITEM_SAPPHIRE
 * msgbox OneIsland_PokemonCenter_1F_Text_ThankYouGiveMeTime
 * closemessage
 * applymovement LOCALID_CELIO, OneIsland_PokemonCenter_1F_Movement_CelioPutGemInMachine
 * waitmovement 0
 * playse SE_CLICK
 * call OneIsland_PokemonCenter_1F_EventScript_SetSapphireMetatile
 * special DrawWholeMapView
 * msgbox OneIsland_PokemonCenter_1F_Text_OkayThisIsGood
 * closemessage
 * delay 60
 * applymovement LOCALID_CELIO, OneIsland_PokemonCenter_1F_Movement_CelioCheckMachine
 * waitmovement 0
 * delay 30
 * applymovement LOCALID_CELIO, OneIsland_PokemonCenter_1F_Movement_CelioCheckMachine
 * waitmovement 0
 * delay 40
 * playse SE_PC_ON
 * call OneIsland_PokemonCenter_1F_EventScript_SetNetworkMachineOn
 * special DrawWholeMapView
 * msgbox OneIsland_PokemonCenter_1F_Text_LinkedUpWithLanette
 * applymovement LOCALID_CELIO, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox OneIsland_PokemonCenter_1F_Text_ManagedToLinkWithHoennThankYou
 * special SetPostgameFlags
 * setflag FLAG_SYS_CAN_LINK_WITH_RS
 * setflag FLAG_HIDE_CERULEAN_CAVE_GUARD
 * setflag FLAG_HIDE_LORELEI_IN_HER_HOUSE
 * setvar VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 6
 * special InitRoamer
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_GiveCelioSapphire : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_GiveCelioSapphire")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_MachineLinkedWithKantoAndHoenn
 * releaseall
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithHoenn : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.MachineLinkedWithKantoAndHoenn)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_OhThats
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_TMHM
 * message OneIsland_PokemonCenter_1F_Text_HandedRubyToCelio
 * waitmessage
 * waitfanfare
 * call EventScript_RestorePrevTextColor
 * closemessage
 * applymovement LOCALID_CELIO, OneIsland_PokemonCenter_1F_Movement_CelioPutGemInMachine
 * waitmovement 0
 * playse SE_CLICK
 * call OneIsland_PokemonCenter_1F_EventScript_SetRubyMetatile
 * special DrawWholeMapView
 * delay 30
 * applymovement LOCALID_CELIO, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox OneIsland_PokemonCenter_1F_Text_MayIAskOneMoreFavor, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, OneIsland_PokemonCenter_1F_EventScript_DeclineHelpCelio
 * goto OneIsland_PokemonCenter_1F_EventScript_GiveRainbowPass
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_GiveCelioRuby : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_GiveCelioRuby")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_MachineLinkedWithKanto
 * releaseall
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithKanto : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.MachineLinkedWithKanto)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_PassLetYouGetToAllIslands
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_ExplainRainbowPass : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.PassLetYouGetToAllIslands)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_CelioImModifyingMyNetworkMachine
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CelioPlayerMissingNationalDex : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.CelioImModifyingMyNetworkMachine)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_TryingToFindGem
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CelioWaitingForRuby : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(OneIsland_PokemonCenter_1F.TryingToFindGem)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 13, 4, METATILE_PokemonCenter_NetworkMachine_Ruby, 1
 * return
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_SetRubyMetatile : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_SetRubyMetatile")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_PleaseINeedYourHelp, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, OneIsland_PokemonCenter_1F_EventScript_DeclineHelpCelio
 * goto OneIsland_PokemonCenter_1F_EventScript_GiveRainbowPass
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_DeclineHelpCelio : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_DeclineHelpCelio")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_AnotherGemstoneInSeviiIslands
 * removeitem ITEM_RUBY
 * removeitem ITEM_TRI_PASS
 * setvar VAR_MAP_SCENE_ONE_ISLAND_POKEMON_CENTER_1F, 5
 * additem ITEM_RAINBOW_PASS
 * setflag FLAG_SYS_SEVII_MAP_4567
 * textcolor NPC_TEXT_COLOR_NEUTRAL
 * playfanfare MUS_OBTAIN_KEY_ITEM
 * message OneIsland_PokemonCenter_1F_Text_ReturnedTriPassForRainbowPass
 * waitmessage
 * waitfanfare
 * playfanfare MUS_OBTAIN_KEY_ITEM
 * message OneIsland_PokemonCenter_1F_Text_ObtainedExtraMapPage
 * waitmessage
 * waitfanfare
 * call EventScript_RestorePrevTextColor
 * goto OneIsland_PokemonCenter_1F_EventScript_ExplainRainbowPass
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_GiveRainbowPass : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_GiveRainbowPass")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_BILL, 3
 * msgbox OneIsland_PokemonCenter_1F_Text_BillsFirstMonWasAbra
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_BillFact1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_BillFact1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setmetatile 16, 4, METATILE_PokemonCenter_NetworkMachine_Sapphire, 1
 * return
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_SetSapphireMetatile : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_SetSapphireMetatile")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * famechecker FAMECHECKER_BILL, 4
 * msgbox OneIsland_PokemonCenter_1F_Text_BillsHometownInGoldenrod
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_BillFact2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_BillFact2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call OneIsland_PokemonCenter_1F_EventScript_SetSapphireMetatile
 * setmetatile 14, 4, METATILE_PokemonCenter_NetworkMachine_ScreenLeft_On, 1
 * setmetatile 15, 4, METATILE_PokemonCenter_NetworkMachine_ScreenRight_On, 1
 * return
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_SetNetworkMachineOn : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_SetNetworkMachineOn")
}

internal val OneIsland_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "OneIsland_PokemonCenter_1F_EventScript_Nurse" to
            OneIsland_PokemonCenter_1F_EventScript_Nurse,
        "OneIsland_PokemonCenter_1F_EventScript_Bill" to
            OneIsland_PokemonCenter_1F_EventScript_Bill,
        "OneIsland_PokemonCenter_1F_EventScript_Celio" to
            OneIsland_PokemonCenter_1F_EventScript_Celio,
        "OneIsland_PokemonCenter_1F_EventScript_LittleBoy" to
            OneIsland_PokemonCenter_1F_EventScript_LittleBoy,
        "OneIsland_PokemonCenter_1F_EventScript_Hiker" to
            OneIsland_PokemonCenter_1F_EventScript_Hiker,
        "OneIsland_PokemonCenter_1F_EventScript_CrushGirl" to
            OneIsland_PokemonCenter_1F_EventScript_CrushGirl,
        "OneIsland_PokemonCenter_1F_EventScript_NetworkMachine" to
            OneIsland_PokemonCenter_1F_EventScript_NetworkMachine,
        "OneIsland_PokemonCenter_1F_EventScript_CrushGirlHoennLinked" to
            OneIsland_PokemonCenter_1F_EventScript_CrushGirlHoennLinked,
        "OneIsland_PokemonCenter_1F_EventScript_BillGoTakeStroll" to
            OneIsland_PokemonCenter_1F_EventScript_BillGoTakeStroll,
        "OneIsland_PokemonCenter_1F_EventScript_CelioGiveBillFact" to
            OneIsland_PokemonCenter_1F_EventScript_CelioGiveBillFact,
        "OneIsland_PokemonCenter_1F_EventScript_CelioJustGivenSapphire" to
            OneIsland_PokemonCenter_1F_EventScript_CelioJustGivenSapphire,
        "OneIsland_PokemonCenter_1F_EventScript_CelioRequestRuby" to
            OneIsland_PokemonCenter_1F_EventScript_CelioRequestRuby,
        "OneIsland_PokemonCenter_1F_EventScript_GiveCelioSapphire" to
            OneIsland_PokemonCenter_1F_EventScript_GiveCelioSapphire,
        "OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithHoenn" to
            OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithHoenn,
        "OneIsland_PokemonCenter_1F_EventScript_GiveCelioRuby" to
            OneIsland_PokemonCenter_1F_EventScript_GiveCelioRuby,
        "OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithKanto" to
            OneIsland_PokemonCenter_1F_EventScript_NetworkMachineLinkedWithKanto,
        "OneIsland_PokemonCenter_1F_EventScript_ExplainRainbowPass" to
            OneIsland_PokemonCenter_1F_EventScript_ExplainRainbowPass,
        "OneIsland_PokemonCenter_1F_EventScript_CelioPlayerMissingNationalDex" to
            OneIsland_PokemonCenter_1F_EventScript_CelioPlayerMissingNationalDex,
        "OneIsland_PokemonCenter_1F_EventScript_CelioWaitingForRuby" to
            OneIsland_PokemonCenter_1F_EventScript_CelioWaitingForRuby,
        "OneIsland_PokemonCenter_1F_EventScript_SetRubyMetatile" to
            OneIsland_PokemonCenter_1F_EventScript_SetRubyMetatile,
        "OneIsland_PokemonCenter_1F_EventScript_DeclineHelpCelio" to
            OneIsland_PokemonCenter_1F_EventScript_DeclineHelpCelio,
        "OneIsland_PokemonCenter_1F_EventScript_GiveRainbowPass" to
            OneIsland_PokemonCenter_1F_EventScript_GiveRainbowPass,
        "OneIsland_PokemonCenter_1F_EventScript_BillFact1" to
            OneIsland_PokemonCenter_1F_EventScript_BillFact1,
        "OneIsland_PokemonCenter_1F_EventScript_SetSapphireMetatile" to
            OneIsland_PokemonCenter_1F_EventScript_SetSapphireMetatile,
        "OneIsland_PokemonCenter_1F_EventScript_BillFact2" to
            OneIsland_PokemonCenter_1F_EventScript_BillFact2,
        "OneIsland_PokemonCenter_1F_EventScript_SetNetworkMachineOn" to
            OneIsland_PokemonCenter_1F_EventScript_SetNetworkMachineOn,
    )
