package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RS_MysteryEventsHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto MossdeepCity_GameCorner_1F_EventScript_OldMan2
 * release
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_OldMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    return MossdeepCity_GameCorner_1F_EventScript_OldMan2.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto MossdeepCity_GameCorner_1F_EventScript_InfoMan2
 * release
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_InfoMan : Script {
  override suspend fun run(ctx: ScriptContext) {
    return MossdeepCity_GameCorner_1F_EventScript_InfoMan2.run(ctx)
  }
}

internal object RS_MysteryEventsHouse_EventScript_Door : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RS_MysteryEventsHouse.DoorIsLocked)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * special ShowDodrioBerryPickingRecords
 * releaseall
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_DodrioBerryPickingRecords : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_GameCorner_1F_EventScript_DodrioBerryPickingRecords")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * special ShowPokemonJumpRecords
 * releaseall
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_PokemonJumpRecords : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_GameCorner_1F_EventScript_PokemonJumpRecords")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message MossdeepCity_GameCorner_1F_Text_WelcomeCanYouWait
 * waitmessage
 * specialvar VAR_RESULT, IsWirelessAdapterConnected
 * goto_if_eq VAR_RESULT, FALSE, MossdeepCity_GameCorner_1F_EventScript_AdapterNotConnected
 * delay 60
 * message MossdeepCity_GameCorner_1F_Text_PlayWhichGame
 * waitmessage
 * multichoice 0, 0, MULTI_WIRELESS_MINIGAME, FALSE
 * switch VAR_RESULT
 * case 0, MossdeepCity_GameCorner_1F_EventScript_PlayPokemonJump
 * case 1, MossdeepCity_GameCorner_1F_EventScript_PlayDodrioBerryPicking
 * case 2, MossdeepCity_GameCorner_1F_EventScript_AbortMinigame
 * case MULTI_B_PRESSED, MossdeepCity_GameCorner_1F_EventScript_AbortMinigame
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_OldMan2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_GameCorner_1F_EventScript_OldMan2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * message MossdeepCity_GameCorner_1F_Text_DescribeWhichGame
 * waitmessage
 * multichoice 0, 0, MULTI_WIRELESS_MINIGAME, FALSE
 * switch VAR_RESULT
 * case 0, MossdeepCity_GameCorner_1F_EventScript_PokemonJumpInfo
 * case 1, MossdeepCity_GameCorner_1F_EventScript_DodrioBerryPickingInfo
 * case 2, MossdeepCity_GameCorner_1F_EventScript_MinigameInfoExit
 * case MULTI_B_PRESSED, MossdeepCity_GameCorner_1F_EventScript_MinigameInfoExit
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_InfoMan2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_GameCorner_1F_EventScript_InfoMan2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * delay 60
 * msgbox MossdeepCity_GameCorner_1F_Text_AdapterNotConnected, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_GameCorner_1F_EventScript_AdapterNotConnected : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_GameCorner_1F_EventScript_AdapterNotConnected")
}

internal val MossdeepCity_GameCorner_1FScripts: Map<String, Script> =
    mapOf(
        "MossdeepCity_GameCorner_1F_EventScript_OldMan" to
            MossdeepCity_GameCorner_1F_EventScript_OldMan,
        "MossdeepCity_GameCorner_1F_EventScript_InfoMan" to
            MossdeepCity_GameCorner_1F_EventScript_InfoMan,
        "RS_MysteryEventsHouse_EventScript_Door" to RS_MysteryEventsHouse_EventScript_Door,
        "MossdeepCity_GameCorner_1F_EventScript_DodrioBerryPickingRecords" to
            MossdeepCity_GameCorner_1F_EventScript_DodrioBerryPickingRecords,
        "MossdeepCity_GameCorner_1F_EventScript_PokemonJumpRecords" to
            MossdeepCity_GameCorner_1F_EventScript_PokemonJumpRecords,
        "MossdeepCity_GameCorner_1F_EventScript_OldMan2" to
            MossdeepCity_GameCorner_1F_EventScript_OldMan2,
        "MossdeepCity_GameCorner_1F_EventScript_InfoMan2" to
            MossdeepCity_GameCorner_1F_EventScript_InfoMan2,
        "MossdeepCity_GameCorner_1F_EventScript_AdapterNotConnected" to
            MossdeepCity_GameCorner_1F_EventScript_AdapterNotConnected,
    )
