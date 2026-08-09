package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.MossdeepCity_House3
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_RECEIVED_SUPER_ROD, MossdeepCity_House3_EventScript_ReceivedSuperRod
 * msgbox MossdeepCity_House3_Text_YouWantSuperRod, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, MossdeepCity_House3_EventScript_DeclineSuperRod
 * msgbox MossdeepCity_House3_Text_SuperRodIsSuper, MSGBOX_DEFAULT
 * giveitem ITEM_SUPER_ROD
 * setflag FLAG_RECEIVED_SUPER_ROD
 * msgbox MossdeepCity_House3_Text_TryDroppingRodInWater, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_House3_EventScript_SuperRodFisherman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port MossdeepCity_House3_EventScript_SuperRodFisherman")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_House3_Text_DontYouLikeToFish, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_House3_EventScript_DeclineSuperRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity_House3.DontYouLikeToFish)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox MossdeepCity_House3_Text_GoAfterSeafloorPokemon, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object MossdeepCity_House3_EventScript_ReceivedSuperRod : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(MossdeepCity_House3.GoAfterSeafloorPokemon)
  }
}

internal val MossdeepCity_House3Scripts: Map<String, Script> =
    mapOf(
        "MossdeepCity_House3_EventScript_SuperRodFisherman" to
            MossdeepCity_House3_EventScript_SuperRodFisherman,
        "MossdeepCity_House3_EventScript_DeclineSuperRod" to
            MossdeepCity_House3_EventScript_DeclineSuperRod,
        "MossdeepCity_House3_EventScript_ReceivedSuperRod" to
            MossdeepCity_House3_EventScript_ReceivedSuperRod,
    )
