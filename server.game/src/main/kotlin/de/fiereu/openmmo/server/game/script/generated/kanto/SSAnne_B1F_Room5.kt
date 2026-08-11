package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SSAnne_B1F_Room5
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

internal object SSAnne_B1F_Room5_EventScript_Boy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(SSAnne_B1F_Room5.MachokeHasStrengthToMoveRocks)
}

/** The decomp plays its cry around the box, which has no verb. */
internal object SSAnne_B1F_Room5_EventScript_Machoke : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(SSAnne_B1F_Room5.Machoke)
}

internal object SSAnne_B1F_Room5_EventScript_ItemSuperPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.SUPER_POTION)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SSANNE_B1F_ROOM5_SUPER_POTION)
  }
}

internal val SSAnne_B1F_Room5Scripts: Map<String, Script> =
    mapOf(
        "SSAnne_B1F_Room5_EventScript_Boy" to SSAnne_B1F_Room5_EventScript_Boy,
        "SSAnne_B1F_Room5_EventScript_Machoke" to SSAnne_B1F_Room5_EventScript_Machoke,
        "SSAnne_B1F_Room5_EventScript_ItemSuperPotion" to
            SSAnne_B1F_Room5_EventScript_ItemSuperPotion,
    )
