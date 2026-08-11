package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_Kitchen
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object SSAnne_Kitchen_EventScript_Chef1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Kitchen.BusyOutOfTheWay)
}

internal object SSAnne_Kitchen_EventScript_Chef2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Kitchen.SawOddBerryInTrash)
}

internal object SSAnne_Kitchen_EventScript_Chef3 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Kitchen.SoBusyImDizzy)
}

internal object SSAnne_Kitchen_EventScript_Chef4 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SSAnne_Kitchen.IAmLeChefMainCourseIs)
    // One of three main courses at random in the decomp; there is no random verb.
    ctx.say(SSAnne_Kitchen.SalmonDuSalad)
  }
}

internal object SSAnne_Kitchen_EventScript_Chef5 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Kitchen.PeelSpudsEveryDay)
}

internal object SSAnne_Kitchen_EventScript_Chef6 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Kitchen.HearAboutSnorlaxItsAGlutton)
}

internal object SSAnne_Kitchen_EventScript_Chef7 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_Kitchen.OnlyGetToPeelOnions)
}

internal object SSAnne_Kitchen_EventScript_ItemGreatBall : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.GREAT_BALL)) return
    ctx.removeNpc(7)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_KITCHEN_GREAT_BALL)
  }
}

internal val SSAnne_KitchenScripts: Map<String, Script> =
    mapOf(
        "SSAnne_Kitchen_EventScript_Chef1" to SSAnne_Kitchen_EventScript_Chef1,
        "SSAnne_Kitchen_EventScript_Chef2" to SSAnne_Kitchen_EventScript_Chef2,
        "SSAnne_Kitchen_EventScript_Chef3" to SSAnne_Kitchen_EventScript_Chef3,
        "SSAnne_Kitchen_EventScript_Chef4" to SSAnne_Kitchen_EventScript_Chef4,
        "SSAnne_Kitchen_EventScript_Chef5" to SSAnne_Kitchen_EventScript_Chef5,
        "SSAnne_Kitchen_EventScript_Chef6" to SSAnne_Kitchen_EventScript_Chef6,
        "SSAnne_Kitchen_EventScript_Chef7" to SSAnne_Kitchen_EventScript_Chef7,
        "SSAnne_Kitchen_EventScript_ItemGreatBall" to SSAnne_Kitchen_EventScript_ItemGreatBall,
    )
