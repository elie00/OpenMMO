package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ThreeIsland_House5
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RESCUED_LOSTELLE, ThreeIsland_House5_EventScript_LittleGirlLostelleFound
 * msgbox ThreeIsland_House5_Text_ImNotLostelle
 * release
 * end
 * ```
 */
internal object ThreeIsland_House5_EventScript_LittleGirl : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_RESCUED_LOSTELLE))
        return ThreeIsland_House5_EventScript_LittleGirlLostelleFound.run(ctx)
    ctx.say(ThreeIsland_House5.ImNotLostelle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox ThreeIsland_House5_Text_IllGoPlayWithLostelle
 * release
 * end
 * ```
 */
internal object ThreeIsland_House5_EventScript_LittleGirlLostelleFound : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_House5_EventScript_LittleGirlLostelleFound")
}

internal val ThreeIsland_House5Scripts: Map<String, Script> =
    mapOf(
        "ThreeIsland_House5_EventScript_LittleGirl" to ThreeIsland_House5_EventScript_LittleGirl,
        "ThreeIsland_House5_EventScript_LittleGirlLostelleFound" to
            ThreeIsland_House5_EventScript_LittleGirlLostelleFound,
    )
