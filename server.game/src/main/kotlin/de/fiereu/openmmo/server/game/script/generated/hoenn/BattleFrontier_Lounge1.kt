package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_Lounge1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * call_if_unset FLAG_MET_BATTLE_FRONTIER_BREEDER, BattleFrontier_Lounge1_EventScript_BreederIntro
 * call_if_set FLAG_MET_BATTLE_FRONTIER_BREEDER, BattleFrontier_Lounge1_EventScript_AlreadyMetBreeder
 * setflag FLAG_MET_BATTLE_FRONTIER_BREEDER
 * goto BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder
 * end
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_Breeder : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge1_EventScript_Breeder")
}

internal object BattleFrontier_Lounge1_EventScript_Boy1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge1.SaidMyMonIsOutstanding)
}

internal object BattleFrontier_Lounge1_EventScript_Boy2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(BattleFrontier_Lounge1.DidntDoAnythingSpecialRaisingIt)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge1_Text_PokemonBreederIntro, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_BreederIntro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge1.PokemonBreederIntro)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special ChoosePartyMon
 * goto_if_ne VAR_0x8004, PARTY_NOTHING_CHOSEN, BattleFrontier_Lounge1_EventScript_ShowMonToBreeder
 * goto_if_eq VAR_0x8004, PARTY_NOTHING_CHOSEN, BattleFrontier_Lounge1_EventScript_CancelMonSelect
 * end
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge1_Text_LetsLookAtYourPokemon, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_AlreadyMetBreeder : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge1.LetsLookAtYourPokemon)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * specialvar VAR_RESULT, ScriptGetPartyMonSpecies
 * goto_if_eq VAR_RESULT, SPECIES_EGG, BattleFrontier_Lounge1_EventScript_ShowEggToBreeder
 * special BufferVarsForIVRater
 * goto_if_le VAR_0x8005, 90, BattleFrontier_Lounge1_EventScript_AverageTotalIVs       @ Average of 15
 * goto_if_le VAR_0x8005, 120, BattleFrontier_Lounge1_EventScript_AboveAverageTotalIVs @ Average of 20
 * goto_if_le VAR_0x8005, 150, BattleFrontier_Lounge1_EventScript_HighTotalIVs         @ Average of 25
 * goto_if_ge VAR_0x8005, 151, BattleFrontier_Lounge1_EventScript_VeryHighTotalIVs     @ Average of > 25
 * end
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_ShowMonToBreeder : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_Lounge1_EventScript_ShowMonToBreeder")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge1_Text_NoTimeForMyAdvice, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_CancelMonSelect : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge1.NoTimeForMyAdvice)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox BattleFrontier_Lounge1_Text_EvenICantTell, MSGBOX_DEFAULT
 * goto BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder
 * end
 * ```
 */
internal object BattleFrontier_Lounge1_EventScript_ShowEggToBreeder : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_Lounge1.EvenICantTell)
    return BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder.run(ctx)
  }
}

internal val BattleFrontier_Lounge1Scripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_Lounge1_EventScript_Breeder" to BattleFrontier_Lounge1_EventScript_Breeder,
        "BattleFrontier_Lounge1_EventScript_Boy1" to BattleFrontier_Lounge1_EventScript_Boy1,
        "BattleFrontier_Lounge1_EventScript_Boy2" to BattleFrontier_Lounge1_EventScript_Boy2,
        "BattleFrontier_Lounge1_EventScript_BreederIntro" to
            BattleFrontier_Lounge1_EventScript_BreederIntro,
        "BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder" to
            BattleFrontier_Lounge1_EventScript_ChooseMonToShowBreeder,
        "BattleFrontier_Lounge1_EventScript_AlreadyMetBreeder" to
            BattleFrontier_Lounge1_EventScript_AlreadyMetBreeder,
        "BattleFrontier_Lounge1_EventScript_ShowMonToBreeder" to
            BattleFrontier_Lounge1_EventScript_ShowMonToBreeder,
        "BattleFrontier_Lounge1_EventScript_CancelMonSelect" to
            BattleFrontier_Lounge1_EventScript_CancelMonSelect,
        "BattleFrontier_Lounge1_EventScript_ShowEggToBreeder" to
            BattleFrontier_Lounge1_EventScript_ShowEggToBreeder,
    )
