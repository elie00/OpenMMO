package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FortreeCity
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object FortreeCity_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FortreeCity.SawGiganticPokemonInSky)
}

internal object FortreeCity_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FortreeCity.TreesGrowByDrinkingRainwater)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_KECLEON_FLED_FORTREE, FortreeCity_EventScript_WomanGymAccessible
 * msgbox FortreeCity_Text_SomethingBlockingGym, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_KECLEON_FLED_FORTREE))
        return FortreeCity_EventScript_WomanGymAccessible.run(ctx)
    ctx.say(FortreeCity.SomethingBlockingGym)
  }
}

internal object FortreeCity_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FortreeCity.BugPokemonComeThroughWindow)
}

internal object FortreeCity_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FortreeCity.EveryoneHealthyAndLively)
}

internal object FortreeCity_EventScript_GameboyKid : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FortreeCity.PokemonThatEvolveWhenTraded)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * checkitem ITEM_DEVON_SCOPE
 * goto_if_eq VAR_RESULT, TRUE, FortreeCity_EventScript_AskUseDevonScope
 * msgbox FortreeCity_Text_SomethingUnseeable, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_EventScript_Kecleon : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FortreeCity_EventScript_Kecleon")
}

internal object FortreeCity_EventScript_CitySign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FortreeCity.CitySign)
}

internal object FortreeCity_EventScript_GymSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FortreeCity.GymSign)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FortreeCity_Text_ThisTimeIllBeatWinona, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FortreeCity_EventScript_WomanGymAccessible : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FortreeCity.ThisTimeIllBeatWinona)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FortreeCity_Text_UnseeableUseDevonScope, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FortreeCity_EventScript_UseDevonScope
 * release
 * end
 * ```
 */
internal object FortreeCity_EventScript_AskUseDevonScope : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FortreeCity_EventScript_AskUseDevonScope")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FortreeCity_Text_UsedDevonScopePokemonFled, MSGBOX_DEFAULT
 * closemessage
 * applymovement VAR_LAST_TALKED, Movement_KecleonAppears
 * waitmovement 0
 * waitse
 * playmoncry SPECIES_KECLEON, CRY_MODE_ENCOUNTER
 * delay 40
 * waitmoncry
 * applymovement VAR_LAST_TALKED, FortreeCity_Movement_KecleonFlee
 * waitmovement 0
 * removeobject VAR_LAST_TALKED
 * setflag FLAG_KECLEON_FLED_FORTREE
 * release
 * end
 * ```
 */
internal object FortreeCity_EventScript_UseDevonScope : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FortreeCity_EventScript_UseDevonScope")
}

internal val FortreeCityScripts: Map<String, Script> =
    mapOf(
        "FortreeCity_EventScript_Man" to FortreeCity_EventScript_Man,
        "FortreeCity_EventScript_Girl" to FortreeCity_EventScript_Girl,
        "FortreeCity_EventScript_Woman" to FortreeCity_EventScript_Woman,
        "FortreeCity_EventScript_Boy" to FortreeCity_EventScript_Boy,
        "FortreeCity_EventScript_OldMan" to FortreeCity_EventScript_OldMan,
        "FortreeCity_EventScript_GameboyKid" to FortreeCity_EventScript_GameboyKid,
        "FortreeCity_EventScript_Kecleon" to FortreeCity_EventScript_Kecleon,
        "FortreeCity_EventScript_CitySign" to FortreeCity_EventScript_CitySign,
        "FortreeCity_EventScript_GymSign" to FortreeCity_EventScript_GymSign,
        "FortreeCity_EventScript_WomanGymAccessible" to FortreeCity_EventScript_WomanGymAccessible,
        "FortreeCity_EventScript_AskUseDevonScope" to FortreeCity_EventScript_AskUseDevonScope,
        "FortreeCity_EventScript_UseDevonScope" to FortreeCity_EventScript_UseDevonScope,
    )
