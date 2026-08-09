package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.OneIsland_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call EventScript_PkmnCenterNurse
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_Nurse")
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
 * Not ported yet. Decomp body:
 * ```
 * msgbox OneIsland_PokemonCenter_1F_Text_TradedWithFarAwayBoyfriend
 * release
 * end
 * ```
 */
internal object OneIsland_PokemonCenter_1F_EventScript_CrushGirlHoennLinked : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port OneIsland_PokemonCenter_1F_EventScript_CrushGirlHoennLinked")
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
    )
