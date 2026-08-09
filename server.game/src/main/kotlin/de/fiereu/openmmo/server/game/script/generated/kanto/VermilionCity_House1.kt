package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity_House1
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_GOT_OLD_ROD, VermilionCity_House1_EventScript_AlreadyGotOldRod
 * msgbox VermilionCity_House1_Text_ImFishingGuruDoYouLikeToFish, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, YES, VermilionCity_House1_EventScript_GiveOldRod
 * msgbox VermilionCity_House1_Text_OhThatsSoDisappointing
 * release
 * end
 * ```
 */
internal object VermilionCity_House1_EventScript_FishingGuru : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_House1_EventScript_FishingGuru")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitemspace ITEM_OLD_ROD
 * goto_if_eq VAR_RESULT, FALSE, VermilionCity_House1_EventScript_NoRoomForOldRod
 * additem ITEM_OLD_ROD
 * msgbox VermilionCity_House1_Text_TakeThisAndFish
 * msgreceiveditem VermilionCity_House1_Text_ReceivedOldRodFromFishingGuru, ITEM_OLD_ROD
 * setflag FLAG_GOT_OLD_ROD
 * msgbox VermilionCity_House1_Text_FishingIsAWayOfLife
 * release
 * end
 * ```
 */
internal object VermilionCity_House1_EventScript_GiveOldRod : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port VermilionCity_House1_EventScript_GiveOldRod")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_House1_Text_HowAreTheFishBiting
 * release
 * end
 * ```
 */
internal object VermilionCity_House1_EventScript_AlreadyGotOldRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_House1.HowAreTheFishBiting)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VermilionCity_House1_Text_NoRoomForNiceGift
 * release
 * end
 * ```
 */
internal object VermilionCity_House1_EventScript_NoRoomForOldRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_House1.NoRoomForNiceGift)
  }
}

internal val VermilionCity_House1Scripts: Map<String, Script> =
    mapOf(
        "VermilionCity_House1_EventScript_FishingGuru" to
            VermilionCity_House1_EventScript_FishingGuru,
        "VermilionCity_House1_EventScript_GiveOldRod" to
            VermilionCity_House1_EventScript_GiveOldRod,
        "VermilionCity_House1_EventScript_AlreadyGotOldRod" to
            VermilionCity_House1_EventScript_AlreadyGotOldRod,
        "VermilionCity_House1_EventScript_NoRoomForOldRod" to
            VermilionCity_House1_EventScript_NoRoomForOldRod,
    )
