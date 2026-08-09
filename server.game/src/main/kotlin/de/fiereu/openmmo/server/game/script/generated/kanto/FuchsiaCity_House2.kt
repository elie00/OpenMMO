package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.FuchsiaCity_House2
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_GOOD_ROD, FuchsiaCity_House2_EventScript_AlreadyGotGoodRod
 * msgbox FuchsiaCity_House2_Text_DoYouLikeToFish, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, FuchsiaCity_House2_EventScript_GiveGoodRod
 * msgbox FuchsiaCity_House2_Text_OhThatsDisappointing
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House2_EventScript_FishingGurusBrother : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_House2_EventScript_FishingGurusBrother")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_House2_Text_HowAreTheFishBiting
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House2_EventScript_AlreadyGotGoodRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_House2.HowAreTheFishBiting)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox FuchsiaCity_House2_Text_LikeYourStyleTakeThis
 * checkitemspace ITEM_GOOD_ROD
 * goto_if_eq VAR_RESULT, FALSE, FuchsiaCity_House2_EventScript_NoRoomForGoodRod
 * giveitem_msg FuchsiaCity_House2_Text_ReceivedGoodRod, ITEM_GOOD_ROD
 * msgbox FuchsiaCity_House2_Text_GoodRodCanCatchBetterMons
 * setflag FLAG_GOT_GOOD_ROD
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House2_EventScript_GiveGoodRod : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port FuchsiaCity_House2_EventScript_GiveGoodRod")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FuchsiaCity_House2_Text_YouHaveNoRoomForGift
 * release
 * end
 * ```
 */
internal object FuchsiaCity_House2_EventScript_NoRoomForGoodRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FuchsiaCity_House2.YouHaveNoRoomForGift)
  }
}

internal val FuchsiaCity_House2Scripts: Map<String, Script> =
    mapOf(
        "FuchsiaCity_House2_EventScript_FishingGurusBrother" to
            FuchsiaCity_House2_EventScript_FishingGurusBrother,
        "FuchsiaCity_House2_EventScript_AlreadyGotGoodRod" to
            FuchsiaCity_House2_EventScript_AlreadyGotGoodRod,
        "FuchsiaCity_House2_EventScript_GiveGoodRod" to FuchsiaCity_House2_EventScript_GiveGoodRod,
        "FuchsiaCity_House2_EventScript_NoRoomForGoodRod" to
            FuchsiaCity_House2_EventScript_NoRoomForGoodRod,
    )
