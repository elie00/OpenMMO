package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MoveTutor
import de.fiereu.openmmo.dialog.generated.hoenn.SootopolisCity_PokemonCenter_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x800B, LOCALID_SOOTOPOLIS_NURSE
 * call Common_EventScript_PkmnCenterNurse
 * waitmessage
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object SootopolisCity_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_PokemonCenter_1F_EventScript_Nurse")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SKY_PILLAR_STATE, 2, SootopolisCity_PokemonCenter_1F_EventScript_GentlemanNoLegendaries
 * goto_if_unset FLAG_KYOGRE_ESCAPED_SEAFLOOR_CAVERN, SootopolisCity_PokemonCenter_1F_EventScript_GentlemanNoLegendaries
 * msgbox SootopolisCity_PokemonCenter_1F_Text_EveryoneTakenRefuge, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_PokemonCenter_1F_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_PokemonCenter_1F_EventScript_Gentleman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_SKY_PILLAR_STATE, 2, SootopolisCity_PokemonCenter_1F_EventScript_WomanNoLegendaries
 * goto_if_unset FLAG_KYOGRE_ESCAPED_SEAFLOOR_CAVERN, SootopolisCity_PokemonCenter_1F_EventScript_WomanNoLegendaries
 * msgbox SootopolisCity_PokemonCenter_1F_Text_ArentPokemonOurFriends, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_PokemonCenter_1F_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_PokemonCenter_1F_EventScript_Woman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_MOVE_TUTOR_TAUGHT_DOUBLE_EDGE, MoveTutor_EventScript_DoubleEdgeTaught
 * msgbox MoveTutor_Text_DoubleEdgeTeach, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_DoubleEdgeDeclined
 * call MoveTutor_EventScript_CanOnlyBeLearnedOnce
 * goto_if_eq VAR_RESULT, NO, MoveTutor_EventScript_DoubleEdgeDeclined
 * msgbox MoveTutor_Text_DoubleEdgeWhichMon, MSGBOX_DEFAULT
 * setvar VAR_0x8005, TUTOR_MOVE_DOUBLE_EDGE
 * call MoveTutor_EventScript_OpenPartyMenu
 * goto_if_eq VAR_RESULT, 0, MoveTutor_EventScript_DoubleEdgeDeclined
 * setflag FLAG_MOVE_TUTOR_TAUGHT_DOUBLE_EDGE
 * goto MoveTutor_EventScript_DoubleEdgeTaught
 * end
 * ```
 */
internal object SootopolisCity_PokemonCenter_1F_EventScript_DoubleEdgeTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SootopolisCity_PokemonCenter_1F_EventScript_DoubleEdgeTutor")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_PokemonCenter_1F_Text_WallaceToughestInHoenn, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_PokemonCenter_1F_EventScript_GentlemanNoLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_PokemonCenter_1F.WallaceToughestInHoenn)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SootopolisCity_PokemonCenter_1F_Text_AlwaysBeFriendsWithPokemon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SootopolisCity_PokemonCenter_1F_EventScript_WomanNoLegendaries : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SootopolisCity_PokemonCenter_1F.AlwaysBeFriendsWithPokemon)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_DoubleEdgeTaught, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_DoubleEdgeTaught : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.DoubleEdgeTaught)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MoveTutor_Text_DoubleEdgeDeclined, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MoveTutor_EventScript_DoubleEdgeDeclined : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MoveTutor.DoubleEdgeDeclined)
  }
}

internal val SootopolisCity_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "SootopolisCity_PokemonCenter_1F_EventScript_Nurse" to
            SootopolisCity_PokemonCenter_1F_EventScript_Nurse,
        "SootopolisCity_PokemonCenter_1F_EventScript_Gentleman" to
            SootopolisCity_PokemonCenter_1F_EventScript_Gentleman,
        "SootopolisCity_PokemonCenter_1F_EventScript_Woman" to
            SootopolisCity_PokemonCenter_1F_EventScript_Woman,
        "SootopolisCity_PokemonCenter_1F_EventScript_DoubleEdgeTutor" to
            SootopolisCity_PokemonCenter_1F_EventScript_DoubleEdgeTutor,
        "SootopolisCity_PokemonCenter_1F_EventScript_GentlemanNoLegendaries" to
            SootopolisCity_PokemonCenter_1F_EventScript_GentlemanNoLegendaries,
        "SootopolisCity_PokemonCenter_1F_EventScript_WomanNoLegendaries" to
            SootopolisCity_PokemonCenter_1F_EventScript_WomanNoLegendaries,
        "MoveTutor_EventScript_DoubleEdgeTaught" to MoveTutor_EventScript_DoubleEdgeTaught,
        "MoveTutor_EventScript_DoubleEdgeDeclined" to MoveTutor_EventScript_DoubleEdgeDeclined,
    )
