package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.Route113_GlassWorkshop
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_GLASS_WORKSHOP_STATE, 10, Route113_GlassWorkshop_EventScript_GiveItemAfterNoRoom
 * goto_if_eq VAR_GLASS_WORKSHOP_STATE, 2, Route113_GlassWorkshop_EventScript_CheckCollectedAsh
 * goto_if_eq VAR_GLASS_WORKSHOP_STATE, 1, Route113_GlassWorkshop_EventScript_ExplainSootSack
 * msgbox Route113_GlassWorkshop_Text_GoCollectAshWithThis, MSGBOX_DEFAULT
 * giveitem ITEM_SOOT_SACK
 * setvar VAR_GLASS_WORKSHOP_STATE, 1
 * msgbox Route113_GlassWorkshop_Text_ExplainSootSack, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_GlassWorker : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route113_GlassWorkshop_EventScript_GlassWorker")
}

internal object Route113_GlassWorkshop_EventScript_NinjaBoy : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route113_GlassWorkshop.FunToBlowGlassFlute)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route113_GlassWorkshop_Text_ExplainSootSack, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_ExplainSootSack : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route113_GlassWorkshop.ExplainSootSack)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_SOOT_SACK
 * goto_if_eq VAR_RESULT, FALSE, Route113_GlassWorkshop_EventScript_SootSackNotInBag
 * msgbox Route113_GlassWorkshop_Text_LetsSeeCollectedAshes, MSGBOX_DEFAULT
 * goto_if_lt VAR_ASH_GATHER_COUNT, LOWEST_ASH_PRICE, Route113_GlassWorkshop_EventScript_NotEnoughAsh
 * message Route113_GlassWorkshop_Text_WhichGlassItemWoudYouLike
 * waitmessage
 * goto Route113_GlassWorkshop_EventScript_ChooseGlassItem
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_CheckCollectedAsh : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route113_GlassWorkshop_EventScript_CheckCollectedAsh")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * switch VAR_GLASS_WORKSHOP_STATE
 * case 10, Route113_GlassWorkshop_EventScript_GiveBlueFlute
 * case 11, Route113_GlassWorkshop_EventScript_GiveYellowFlute
 * case 12, Route113_GlassWorkshop_EventScript_GiveRedFlute
 * case 13, Route113_GlassWorkshop_EventScript_GiveWhiteFlute
 * case 14, Route113_GlassWorkshop_EventScript_GiveBlackFlute
 * case 15, Route113_GlassWorkshop_EventScript_GivePrettyChair
 * case 16, Route113_GlassWorkshop_EventScript_GivePrettyDesk
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_GiveItemAfterNoRoom : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route113_GlassWorkshop_EventScript_GiveItemAfterNoRoom")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8009, 0
 * setvar VAR_0x8004, SCROLL_MULTI_GLASS_WORKSHOP_VENDOR
 * special ShowScrollableMultichoice
 * switch VAR_RESULT
 * case 0, Route113_GlassWorkshop_EventScript_BlueFlute
 * case 1, Route113_GlassWorkshop_EventScript_YellowFlute
 * case 2, Route113_GlassWorkshop_EventScript_RedFlute
 * case 3, Route113_GlassWorkshop_EventScript_WhiteFlute
 * case 4, Route113_GlassWorkshop_EventScript_BlackFlute
 * case 5, Route113_GlassWorkshop_EventScript_PrettyChair
 * case 6, Route113_GlassWorkshop_EventScript_PrettyDesk
 * case 7, Route113_GlassWorkshop_EventScript_CancelGlassItemSelect
 * case MULTI_B_PRESSED, Route113_GlassWorkshop_EventScript_CancelGlassItemSelect
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_ChooseGlassItem : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route113_GlassWorkshop_EventScript_ChooseGlassItem")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox Route113_GlassWorkshop_Text_HaventGotYourSootSack, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_SootSackNotInBag : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(Route113_GlassWorkshop.HaventGotYourSootSack)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x800A, LOWEST_ASH_PRICE
 * subvar VAR_0x800A, VAR_ASH_GATHER_COUNT
 * buffernumberstring STR_VAR_1, VAR_0x800A
 * msgbox Route113_GlassWorkshop_Text_NotEnoughAshNeedX, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object Route113_GlassWorkshop_EventScript_NotEnoughAsh : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port Route113_GlassWorkshop_EventScript_NotEnoughAsh")
}

internal val Route113_GlassWorkshopScripts: Map<String, Script> =
    mapOf(
        "Route113_GlassWorkshop_EventScript_GlassWorker" to
            Route113_GlassWorkshop_EventScript_GlassWorker,
        "Route113_GlassWorkshop_EventScript_NinjaBoy" to
            Route113_GlassWorkshop_EventScript_NinjaBoy,
        "Route113_GlassWorkshop_EventScript_ExplainSootSack" to
            Route113_GlassWorkshop_EventScript_ExplainSootSack,
        "Route113_GlassWorkshop_EventScript_CheckCollectedAsh" to
            Route113_GlassWorkshop_EventScript_CheckCollectedAsh,
        "Route113_GlassWorkshop_EventScript_GiveItemAfterNoRoom" to
            Route113_GlassWorkshop_EventScript_GiveItemAfterNoRoom,
        "Route113_GlassWorkshop_EventScript_ChooseGlassItem" to
            Route113_GlassWorkshop_EventScript_ChooseGlassItem,
        "Route113_GlassWorkshop_EventScript_SootSackNotInBag" to
            Route113_GlassWorkshop_EventScript_SootSackNotInBag,
        "Route113_GlassWorkshop_EventScript_NotEnoughAsh" to
            Route113_GlassWorkshop_EventScript_NotEnoughAsh,
    )
