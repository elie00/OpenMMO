package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.common.enums.Direction
import de.fiereu.openmmo.dialog.generated.hoenn.Route101
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_LEFT
import de.fiereu.openmmo.server.game.script.MovementStep.FACE_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.FAST_DOWN
import de.fiereu.openmmo.server.game.script.MovementStep.FAST_LEFT
import de.fiereu.openmmo.server.game.script.MovementStep.FAST_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.FAST_UP
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_DOWN
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_IN_PLACE_FAST_LEFT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_IN_PLACE_FAST_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_UP
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

private const val LOCALID_BIRCH = 1
private const val LOCALID_ZIGZAGOON = 3

internal object Route101_OnTransition : Script {
  override suspend fun run(ctx: ScriptContext) = Unit
}

internal object Route101_EventScript_HideMapNamePopup : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(HoennFlags.FLAG_HIDE_MAP_NAME_POPUP)
    ctx.setVar(HoennVars.VAR_ROUTE101_STATE, 1)
  }
}

internal object Route101_EventScript_StartBirchRescue : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route101.HelpMe)
    ctx.repositionNpc(LOCALID_BIRCH, 0, 15)
    ctx.repositionNpc(LOCALID_ZIGZAGOON, 0, 16)
    ctx.moveSelfAndNpcs(
        listOf(FAST_UP, FAST_UP, FAST_UP, FAST_UP, FACE_LEFT),
        LOCALID_BIRCH to listOf(FAST_RIGHT, FAST_RIGHT, FAST_RIGHT, FAST_RIGHT, FAST_UP, FAST_UP),
        LOCALID_ZIGZAGOON to
            listOf(FAST_UP, FAST_RIGHT, FAST_RIGHT, FAST_RIGHT, FAST_RIGHT, FAST_UP),
    )
    ctx.moveNpcs(
        LOCALID_BIRCH to chaseInCircles(initialUpSteps = 2),
        LOCALID_ZIGZAGOON to chaseInCircles(initialUpSteps = 3, finalLeftSteps = 2),
    )
    ctx.moveNpc(LOCALID_BIRCH, FACE_RIGHT)
    ctx.moveNpcs(
        LOCALID_ZIGZAGOON to List(4) { WALK_IN_PLACE_FAST_LEFT },
        LOCALID_BIRCH to List(4) { WALK_IN_PLACE_FAST_RIGHT },
    )
    ctx.say(Route101.PleaseHelp)
    ctx.setVar(HoennVars.VAR_ROUTE101_STATE, 2)
  }
}

internal object Route101_EventScript_PreventExitSouth : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route101.DontLeaveMe)
    ctx.moveSelf(WALK_UP)
  }
}

internal object Route101_EventScript_PreventExitWest : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route101.DontLeaveMe)
    ctx.moveSelf(WALK_RIGHT)
  }
}

internal object Route101_EventScript_PreventExitNorth : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route101.DontLeaveMe)
    ctx.moveSelf(WALK_DOWN)
  }
}

private fun chaseInCircles(initialUpSteps: Int, finalLeftSteps: Int = 3) = buildList {
  repeat(initialUpSteps) { add(FAST_UP) }
  repeat(3) { circuit ->
    repeat(3) { add(FAST_RIGHT) }
    repeat(2) { add(FAST_DOWN) }
    repeat(if (circuit == 2) finalLeftSteps else 3) { add(FAST_LEFT) }
    if (circuit < 2) repeat(2) { add(FAST_UP) }
  }
}

internal object Route101_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route101.TakeTiredPokemonToPokeCenter)
}

internal object Route101_EventScript_BirchsBag : Script {
  override suspend fun run(ctx: ScriptContext) {
    // Grant the starter before opening battle.
    if (!ctx.isFlagSet(HoennFlags.FLAG_SYS_POKEMON_GET)) {
      val starter = ctx.chooseHoennStarter()
      val starterIndex = STARTERS.indexOf(starter).coerceAtLeast(0)
      ctx.setVar(HoennVars.VAR_STARTER_MON, starterIndex)
      val moves = STARTER_MOVES.getValue(starter)
      checkNotNull(ctx.givePokemon(starter, level = 5, *moves.toIntArray()))
      ctx.setFlag(HoennFlags.FLAG_SYS_POKEMON_GET)
      ctx.setFlag(HoennFlags.FLAG_RESCUED_BIRCH)
    }

    val result = ctx.battle(ZIGZAGOON, 2, 33, 45)
    if (result != BattleResult.VICTORY) {
      // Restore the starter after this mandatory battle.
      ctx.healParty()
      return
    }

    ctx.setFlag(HoennFlags.FLAG_HIDE_ROUTE_101_ZIGZAGOON)
    ctx.removeNpc(LOCALID_ZIGZAGOON)
    ctx.repositionSelf(6, 13, Direction.UP)
    ctx.moveSelfAndNpcs(
        listOf(FACE_LEFT),
        LOCALID_BIRCH to listOf(WALK_RIGHT),
    )
    ctx.sayNpc(LOCALID_BIRCH, Route101.YouSavedMe)
    ctx.healParty()
    ctx.setFlag(HoennFlags.FLAG_HIDE_ROUTE_101_BIRCH_ZIGZAGOON_BATTLE)
    ctx.clearFlag(HoennFlags.FLAG_HIDE_LITTLEROOT_TOWN_BIRCHS_LAB_BIRCH)
    ctx.setFlag(HoennFlags.FLAG_HIDE_ROUTE_101_BIRCH_STARTERS_BAG)
    ctx.setVar(HoennVars.VAR_BIRCH_LAB_STATE, 2)
    ctx.setVar(HoennVars.VAR_ROUTE101_STATE, 3)
    ctx.clearFlag(HoennFlags.FLAG_HIDE_MAP_NAME_POPUP)
    if (ctx.isFemale) {
      ctx.setFlag(HoennFlags.FLAG_HIDE_LITTLEROOT_TOWN_BRENDANS_HOUSE_RIVAL_BEDROOM)
    } else {
      ctx.setFlag(HoennFlags.FLAG_HIDE_LITTLEROOT_TOWN_MAYS_HOUSE_RIVAL_BEDROOM)
    }
    ctx.warp(HOENN, LITTLEROOT_INDOOR_BANK, BIRCH_LAB_MAP, 6, 5, Direction.UP)
    LittlerootTown_ProfessorBirchsLab_EventScript_GiveStarterEvent.run(ctx)
  }
}

private val STARTERS = listOf(252, 255, 258)
private val STARTER_MOVES =
    mapOf(
        252 to listOf(1, 43), // Treecko: Pound, Leer
        255 to listOf(10, 45), // Torchic: Scratch, Growl
        258 to listOf(33, 45), // Mudkip: Tackle, Growl
    )
private const val ZIGZAGOON = 263
private const val HOENN = 1
private const val LITTLEROOT_INDOOR_BANK = 51
private const val BIRCH_LAB_MAP = 4

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_HAS_MATCH_CALL, ProfBirch_EventScript_AskRatePokedex
 * goto_if_unset FLAG_ENABLE_PROF_BIRCH_MATCH_CALL, EventScript_RegisterProfBirch
 * ```
 */
internal object ProfBirch_EventScript_RatePokedexOrRegister : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(HoennFlags.FLAG_HAS_MATCH_CALL))
        return ProfBirch_EventScript_AskRatePokedex.run(ctx)
    if (!ctx.isFlagSet(HoennFlags.FLAG_ENABLE_PROF_BIRCH_MATCH_CALL))
        return EventScript_RegisterProfBirch.run(ctx)
  }
}

internal object Route101_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route101.WildPokemonInTallGrass)
}

internal object Route101_EventScript_RouteSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(Route101.RouteSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox gBirchDexRatingText_AreYouCurious, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, ProfBirch_EventScript_DeclineRating
 * call ProfBirch_EventScript_RatePokedex
 * release
 * end
 * ```
 */
internal object ProfBirch_EventScript_AskRatePokedex : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ProfBirch_EventScript_AskRatePokedex")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox MatchCall_Text_BirchRegisterCall, MSGBOX_DEFAULT
 * closemessage
 * delay 30
 * playfanfare MUS_REGISTER_MATCH_CALL
 * msgbox MatchCall_Text_RegisteredBirch, MSGBOX_DEFAULT
 * waitfanfare
 * closemessage
 * delay 30
 * setflag FLAG_ENABLE_PROF_BIRCH_MATCH_CALL
 * setvar VAR_REGISTER_BIRCH_STATE, 2
 * release
 * end
 * ```
 */
internal object EventScript_RegisterProfBirch : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port EventScript_RegisterProfBirch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8004, 0
 * specialvar VAR_RESULT, ScriptGetPokedexInfo
 * copyvar VAR_0x8008, VAR_0x8005
 * copyvar VAR_0x8009, VAR_0x8006
 * copyvar VAR_0x800A, VAR_RESULT
 * buffernumberstring STR_VAR_1, VAR_0x8008  @ Num Hoenn seen
 * buffernumberstring STR_VAR_2, VAR_0x8009  @ Num Hoenn caught
 * msgbox gBirchDexRatingText_SoYouveSeenAndCaught, MSGBOX_DEFAULT
 * call ProfBirch_EventScript_ShowRatingMessage
 * goto_if_eq VAR_0x800A, 0, Common_EventScript_NopReturn  @ National dex not enabled
 * setvar VAR_0x8004, 1
 * specialvar VAR_RESULT, ScriptGetPokedexInfo
 * copyvar VAR_0x8008, VAR_0x8005
 * copyvar VAR_0x8009, VAR_0x8006
 * buffernumberstring STR_VAR_1, VAR_0x8008  @ Num National seen
 * buffernumberstring STR_VAR_2, VAR_0x8009  @ Num National caught
 * msgbox gBirchDexRatingText_OnANationwideBasis, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object ProfBirch_EventScript_RatePokedex : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ProfBirch_EventScript_RatePokedex")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox gBirchDexRatingText_Cancel, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object ProfBirch_EventScript_DeclineRating : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ProfBirch_EventScript_DeclineRating")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * copyvar VAR_0x8004, VAR_0x8009
 * special ShowPokedexRatingMessage
 * waitmessage
 * waitbuttonpress
 * return
 * ```
 */
internal object ProfBirch_EventScript_ShowRatingMessage : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ProfBirch_EventScript_ShowRatingMessage")
}

internal val Route101Scripts: Map<String, Script> =
    mapOf(
        "Route101_OnTransition" to Route101_OnTransition,
        "Route101_EventScript_HideMapNamePopup" to Route101_EventScript_HideMapNamePopup,
        "Route101_EventScript_StartBirchRescue" to Route101_EventScript_StartBirchRescue,
        "Route101_EventScript_PreventExitSouth" to Route101_EventScript_PreventExitSouth,
        "Route101_EventScript_PreventExitWest" to Route101_EventScript_PreventExitWest,
        "Route101_EventScript_PreventExitNorth" to Route101_EventScript_PreventExitNorth,
        "Route101_EventScript_Youngster" to Route101_EventScript_Youngster,
        "Route101_EventScript_BirchsBag" to Route101_EventScript_BirchsBag,
        "ProfBirch_EventScript_RatePokedexOrRegister" to
            ProfBirch_EventScript_RatePokedexOrRegister,
        "Route101_EventScript_Boy" to Route101_EventScript_Boy,
        "Route101_EventScript_RouteSign" to Route101_EventScript_RouteSign,
        "ProfBirch_EventScript_AskRatePokedex" to ProfBirch_EventScript_AskRatePokedex,
        "EventScript_RegisterProfBirch" to EventScript_RegisterProfBirch,
        "ProfBirch_EventScript_RatePokedex" to ProfBirch_EventScript_RatePokedex,
        "ProfBirch_EventScript_DeclineRating" to ProfBirch_EventScript_DeclineRating,
        "ProfBirch_EventScript_ShowRatingMessage" to ProfBirch_EventScript_ShowRatingMessage,
    )
