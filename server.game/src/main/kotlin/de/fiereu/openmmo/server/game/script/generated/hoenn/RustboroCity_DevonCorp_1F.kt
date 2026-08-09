package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.RustboroCity_DevonCorp_1F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RETURNED_DEVON_GOODS, RustboroCity_DevonCorp_1F_EventScript_GoodsRecovered
 * goto_if_set FLAG_DEVON_GOODS_STOLEN, RustboroCity_DevonCorp_1F_EventScript_RobberWasntBright
 * msgbox RustboroCity_DevonCorp_1F_Text_ThoseShoesAreOurProduct, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_Employee : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RETURNED_DEVON_GOODS))
        return RustboroCity_DevonCorp_1F_EventScript_GoodsRecovered.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEVON_GOODS_STOLEN))
        return RustboroCity_DevonCorp_1F_EventScript_RobberWasntBright.run(ctx)
    ctx.say(RustboroCity_DevonCorp_1F.ThoseShoesAreOurProduct)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RETURNED_DEVON_GOODS, RustboroCity_DevonCorp_1F_EventScript_AlwaysWelcome
 * goto_if_set FLAG_RECOVERED_DEVON_GOODS, RustboroCity_DevonCorp_1F_EventScript_GotRobbed
 * goto_if_set FLAG_DEVON_GOODS_STOLEN, RustboroCity_DevonCorp_1F_EventScript_GotRobbed
 * msgbox RustboroCity_DevonCorp_1F_Text_OnlyAuthorizedPeopleEnter, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_StairGuard : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RETURNED_DEVON_GOODS))
        return RustboroCity_DevonCorp_1F_EventScript_AlwaysWelcome.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_RECOVERED_DEVON_GOODS))
        return RustboroCity_DevonCorp_1F_EventScript_GotRobbed.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEVON_GOODS_STOLEN))
        return RustboroCity_DevonCorp_1F_EventScript_GotRobbed.run(ctx)
    ctx.say(RustboroCity_DevonCorp_1F.OnlyAuthorizedPeopleEnter)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RETURNED_DEVON_GOODS, RustboroCity_DevonCorp_1F_EventScript_WelcomeToDevonCorp
 * goto_if_set FLAG_RECOVERED_DEVON_GOODS, RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed
 * goto_if_set FLAG_DEVON_GOODS_STOLEN, RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed
 * msgbox RustboroCity_DevonCorp_1F_Text_WelcomeToDevonCorp, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_Greeter : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_RETURNED_DEVON_GOODS))
        return RustboroCity_DevonCorp_1F_EventScript_WelcomeToDevonCorp.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_RECOVERED_DEVON_GOODS))
        return RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEVON_GOODS_STOLEN))
        return RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed.run(ctx)
    ctx.say(RustboroCity_DevonCorp_1F.WelcomeToDevonCorp)
  }
}

internal object RustboroCity_DevonCorp_1F_EventScript_ProductsDisplay : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(RustboroCity_DevonCorp_1F.ProductDisplay)
}

internal object RustboroCity_DevonCorp_1F_EventScript_RocksMetalDisplay : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.sign(RustboroCity_DevonCorp_1F.RocksMetalDisplay)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_1F_Text_StaffGotRobbed, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_1F.StaffGotRobbed)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_1F_Text_SoundsLikeStolenGoodsRecovered, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_GoodsRecovered : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_1F.SoundsLikeStolenGoodsRecovered)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_1F_Text_YoureAlwaysWelcomeHere, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_AlwaysWelcome : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_1F.YoureAlwaysWelcomeHere)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_1F_Text_HowCouldWeGetRobbed, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_GotRobbed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_1F.HowCouldWeGetRobbed)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_1F_Text_WelcomeToDevonCorp, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_WelcomeToDevonCorp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_1F.WelcomeToDevonCorp)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox RustboroCity_DevonCorp_1F_Text_RobberWasntVeryBright, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object RustboroCity_DevonCorp_1F_EventScript_RobberWasntBright : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(RustboroCity_DevonCorp_1F.RobberWasntVeryBright)
  }
}

internal val RustboroCity_DevonCorp_1FScripts: Map<String, Script> =
    mapOf(
        "RustboroCity_DevonCorp_1F_EventScript_Employee" to
            RustboroCity_DevonCorp_1F_EventScript_Employee,
        "RustboroCity_DevonCorp_1F_EventScript_StairGuard" to
            RustboroCity_DevonCorp_1F_EventScript_StairGuard,
        "RustboroCity_DevonCorp_1F_EventScript_Greeter" to
            RustboroCity_DevonCorp_1F_EventScript_Greeter,
        "RustboroCity_DevonCorp_1F_EventScript_ProductsDisplay" to
            RustboroCity_DevonCorp_1F_EventScript_ProductsDisplay,
        "RustboroCity_DevonCorp_1F_EventScript_RocksMetalDisplay" to
            RustboroCity_DevonCorp_1F_EventScript_RocksMetalDisplay,
        "RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed" to
            RustboroCity_DevonCorp_1F_EventScript_StaffGotRobbed,
        "RustboroCity_DevonCorp_1F_EventScript_GoodsRecovered" to
            RustboroCity_DevonCorp_1F_EventScript_GoodsRecovered,
        "RustboroCity_DevonCorp_1F_EventScript_AlwaysWelcome" to
            RustboroCity_DevonCorp_1F_EventScript_AlwaysWelcome,
        "RustboroCity_DevonCorp_1F_EventScript_GotRobbed" to
            RustboroCity_DevonCorp_1F_EventScript_GotRobbed,
        "RustboroCity_DevonCorp_1F_EventScript_WelcomeToDevonCorp" to
            RustboroCity_DevonCorp_1F_EventScript_WelcomeToDevonCorp,
        "RustboroCity_DevonCorp_1F_EventScript_RobberWasntBright" to
            RustboroCity_DevonCorp_1F_EventScript_RobberWasntBright,
    )
