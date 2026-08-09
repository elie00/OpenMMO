package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RustboroCity_Flat1_2F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

internal object RustboroCity_Flat1_2F_EventScript_WaldasMom : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(RustboroCity_Flat1_2F.ComingUpWithMealsIsHard)
}

internal object RustboroCity_Flat1_2F_EventScript_PokeDoll : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(RustboroCity_Flat1_2F.ItsAPokemonPlushDoll)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * specialvar VAR_RESULT, TryBufferWaldaPhrase
 * goto_if_eq VAR_RESULT, FALSE, RustboroCity_Flat1_2F_EventScript_WaldasDadFirstPhrase
 * goto_if_eq VAR_RESULT, TRUE, RustboroCity_Flat1_2F_EventScript_WaldasDadNewPhrase
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_WaldasDad : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Flat1_2F_EventScript_WaldasDad")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_HelloDoYouKnowFunnyPhrase, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_Flat1_2F_EventScript_DeclineGivePhrase
 * msgbox RustboroCity_Flat1_2F_Text_WonderfulLetsHearSuggestion, MSGBOX_DEFAULT
 * goto RustboroCity_Flat1_2F_EventScript_GivePhrase
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_WaldasDadFirstPhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Flat1_2F_EventScript_WaldasDadFirstPhrase")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_BeenSayingXDoYouKnowBetterPhrase, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, RustboroCity_Flat1_2F_EventScript_DeclineGivePhrase
 * msgbox RustboroCity_Flat1_2F_Text_WonderfulLetsHearSuggestion, MSGBOX_DEFAULT
 * goto RustboroCity_Flat1_2F_EventScript_GivePhrase
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_WaldasDadNewPhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Flat1_2F_EventScript_WaldasDadNewPhrase")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_OhIsThatRight, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_DeclineGivePhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_Flat1_2F.OhIsThatRight)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DoWaldaNamingScreen
 * goto_if_eq VAR_0x8004, 1, RustboroCity_Flat1_2F_EventScript_CancelGivePhrase
 * goto_if_eq VAR_0x8004, 2, RustboroCity_Flat1_2F_EventScript_CancelGiveFirstPhrase
 * specialvar VAR_RESULT, TryGetWallpaperWithWaldaPhrase
 * goto_if_eq VAR_RESULT, TRUE, RustboroCity_Flat1_2F_EventScript_WaldaLikesPhrase
 * goto_if_eq VAR_RESULT, FALSE, RustboroCity_Flat1_2F_EventScript_WaldaDoesntLikePhrase
 * end
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_GivePhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Flat1_2F_EventScript_GivePhrase")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_LetsGiveItATry2, MSGBOX_DEFAULT
 * call RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda
 * msgbox RustboroCity_Flat1_2F_Text_OhShesLaughing, MSGBOX_DEFAULT
 * applymovement LOCALID_WALDAS_DAD, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox RustboroCity_Flat1_2F_Text_ThankYouIllGiveYouWallpaper, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_WaldaLikesPhrase : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Flat1_2F_EventScript_WaldaLikesPhrase")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_OhYouDontKnowAny, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_CancelGivePhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_Flat1_2F.OhYouDontKnowAny)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_ThinkOfMyOwnPhrase, MSGBOX_DEFAULT
 * call RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda
 * msgbox RustboroCity_Flat1_2F_Text_ShesNotSmilingAtAll2, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_CancelGiveFirstPhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_Flat1_2F.ThinkOfMyOwnPhrase)
    RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda.run(ctx)
    ctx.say(RustboroCity_Flat1_2F.ShesNotSmilingAtAll2)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_Flat1_2F_Text_LetsGiveItATry, MSGBOX_DEFAULT
 * call RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda
 * msgbox RustboroCity_Flat1_2F_Text_ShesNotSmilingAtAll, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_WaldaDoesntLikePhrase : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_Flat1_2F.LetsGiveItATry)
    RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda.run(ctx)
    ctx.say(RustboroCity_Flat1_2F.ShesNotSmilingAtAll)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * turnobject LOCALID_WALDAS_DAD, DIR_EAST
 * return
 * ```
 */
internal object RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda")
}

internal val RustboroCity_Flat1_2FScripts: Map<String, Script> =
    mapOf(
        "RustboroCity_Flat1_2F_EventScript_WaldasMom" to
            RustboroCity_Flat1_2F_EventScript_WaldasMom,
        "RustboroCity_Flat1_2F_EventScript_PokeDoll" to RustboroCity_Flat1_2F_EventScript_PokeDoll,
        "RustboroCity_Flat1_2F_EventScript_WaldasDad" to
            RustboroCity_Flat1_2F_EventScript_WaldasDad,
        "RustboroCity_Flat1_2F_EventScript_WaldasDadFirstPhrase" to
            RustboroCity_Flat1_2F_EventScript_WaldasDadFirstPhrase,
        "RustboroCity_Flat1_2F_EventScript_WaldasDadNewPhrase" to
            RustboroCity_Flat1_2F_EventScript_WaldasDadNewPhrase,
        "RustboroCity_Flat1_2F_EventScript_DeclineGivePhrase" to
            RustboroCity_Flat1_2F_EventScript_DeclineGivePhrase,
        "RustboroCity_Flat1_2F_EventScript_GivePhrase" to
            RustboroCity_Flat1_2F_EventScript_GivePhrase,
        "RustboroCity_Flat1_2F_EventScript_WaldaLikesPhrase" to
            RustboroCity_Flat1_2F_EventScript_WaldaLikesPhrase,
        "RustboroCity_Flat1_2F_EventScript_CancelGivePhrase" to
            RustboroCity_Flat1_2F_EventScript_CancelGivePhrase,
        "RustboroCity_Flat1_2F_EventScript_CancelGiveFirstPhrase" to
            RustboroCity_Flat1_2F_EventScript_CancelGiveFirstPhrase,
        "RustboroCity_Flat1_2F_EventScript_WaldaDoesntLikePhrase" to
            RustboroCity_Flat1_2F_EventScript_WaldaDoesntLikePhrase,
        "RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda" to
            RustboroCity_Flat1_2F_EventScript_WaldasDadFaceWalda,
    )
