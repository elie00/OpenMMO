package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity_House3
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox FuchsiaCity_House3_Text_WouldYouLikeToForgetMove, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FuchsiaCity_House3_EventScript_ChooseMonForMoveDeleter
 * goto FuchsiaCity_House3_EventScript_CancelForgetMove
 * end
 * ```
 */
internal object FuchsiaCity_House3_EventScript_MoveDeleter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_House3_EventScript_MoveDeleter")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_House3_Text_ComeAgainToForgetOtherMoves
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House3_EventScript_CancelForgetMove : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_House3.ComeAgainToForgetOtherMoves)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FuchsiaCity_House3_Text_WhichMonShouldForgetMove
 * special ChoosePartyMon
 * waitstate
 * goto_if_ge VAR_0x8004, PARTY_SIZE, FuchsiaCity_House3_EventScript_CancelForgetMove
 * special IsSelectedMonEgg
 * goto_if_eq VAR_RESULT, TRUE, FuchsiaCity_House3_EventScript_CantForgetMoveEgg
 * special GetNumMovesSelectedMonHas
 * goto_if_eq VAR_RESULT, 1, FuchsiaCity_House3_EventScript_CantForgetOnlyMove
 * msgbox FuchsiaCity_House3_Text_WhichMoveShouldBeForgotten
 * fadescreen FADE_TO_BLACK
 * special SelectMoveDeleterMove
 * fadescreen FADE_FROM_BLACK
 * goto_if_eq VAR_0x8005, MAX_MON_MOVES, FuchsiaCity_House3_EventScript_ChooseMonForMoveDeleter
 * special BufferMoveDeleterNicknameAndMove
 * msgbox FuchsiaCity_House3_Text_MonsMoveShouldBeForgotten, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FuchsiaCity_House3_EventScript_ForgetMove
 * goto FuchsiaCity_House3_EventScript_CancelForgetMove
 * end
 * ```
 */
internal object FuchsiaCity_House3_EventScript_ChooseMonForMoveDeleter : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_House3_EventScript_ChooseMonForMoveDeleter")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special MoveDeleterForgetMove
 * playfanfare MUS_MOVE_DELETED
 * waitfanfare
 * msgbox FuchsiaCity_House3_Text_MonHasForgottenMoveCompletely
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House3_EventScript_ForgetMove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_House3_EventScript_ForgetMove")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_House3_Text_NoEggShouldKnowMoves
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House3_EventScript_CantForgetMoveEgg : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_House3.NoEggShouldKnowMoves)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special BufferMoveDeleterNicknameAndMove
 * msgbox FuchsiaCity_House3_Text_MonOnlyKnowsOneMove
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House3_EventScript_CantForgetOnlyMove : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_House3_EventScript_CantForgetOnlyMove")
}

internal val FuchsiaCity_House3Scripts: Map<String, Script> =
    mapOf(
        "FuchsiaCity_House3_EventScript_MoveDeleter" to FuchsiaCity_House3_EventScript_MoveDeleter,
        "FuchsiaCity_House3_EventScript_CancelForgetMove" to
            FuchsiaCity_House3_EventScript_CancelForgetMove,
        "FuchsiaCity_House3_EventScript_ChooseMonForMoveDeleter" to
            FuchsiaCity_House3_EventScript_ChooseMonForMoveDeleter,
        "FuchsiaCity_House3_EventScript_ForgetMove" to FuchsiaCity_House3_EventScript_ForgetMove,
        "FuchsiaCity_House3_EventScript_CantForgetMoveEgg" to
            FuchsiaCity_House3_EventScript_CantForgetMoveEgg,
        "FuchsiaCity_House3_EventScript_CantForgetOnlyMove" to
            FuchsiaCity_House3_EventScript_CantForgetOnlyMove,
    )
