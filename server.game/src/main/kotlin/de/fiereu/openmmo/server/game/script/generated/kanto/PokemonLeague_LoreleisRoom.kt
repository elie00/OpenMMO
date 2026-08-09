package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonLeague_LoreleisRoom
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_LORELEI, FCPICKSTATE_COLORED, UpdatePickStateFromSpecialVar8005
 * goto_if_set FLAG_DEFEATED_LORELEI, PokemonLeague_LoreleisRoom_EventScript_PostBattle
 * famechecker FAMECHECKER_LORELEI, 0
 * famechecker FAMECHECKER_LORELEI, 1
 * call_if_unset FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_LoreleisRoom_EventScript_Intro
 * call_if_set FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_LoreleisRoom_EventScript_RematchIntro
 * setflag FLAG_TEMP_3
 * setflag FLAG_TEMP_5
 * call_if_unset FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_LoreleisRoom_EventScript_Battle
 * call_if_set FLAG_SYS_CAN_LINK_WITH_RS, PokemonLeague_LoreleisRoom_EventScript_Rematch
 * clearflag FLAG_TEMP_5
 * goto PokemonLeague_LoreleisRoom_EventScript_DefeatedLorelei
 * end
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_Lorelei : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LoreleisRoom_EventScript_Lorelei")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_LoreleisRoom_Text_PostBattle
 * release
 * end
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_LoreleisRoom.PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_LoreleisRoom_Text_RematchIntro
 * return
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_RematchIntro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_LoreleisRoom.RematchIntro)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_LORELEI_2, PokemonLeague_LoreleisRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_Rematch : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LoreleisRoom_EventScript_Rematch")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * trainerbattle_no_intro TRAINER_ELITE_FOUR_LORELEI, PokemonLeague_LoreleisRoom_Text_Defeat
 * return
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_Battle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PokemonLeague_LoreleisRoom_EventScript_Battle")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PokemonLeague_LoreleisRoom_Text_Intro
 * return
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_Intro : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PokemonLeague_LoreleisRoom.Intro)
  }
}

/**
 * Ported from the decomp:
 * ```
 * setflag FLAG_DEFEATED_LORELEI
 * call PokemonLeague_EventScript_OpenDoor
 * msgbox PokemonLeague_LoreleisRoom_Text_PostBattle
 * release
 * end
 * ```
 */
internal object PokemonLeague_LoreleisRoom_EventScript_DefeatedLorelei : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_LORELEI)
    PokemonLeague_EventScript_OpenDoor.run(ctx)
    ctx.say(PokemonLeague_LoreleisRoom.PostBattle)
  }
}

internal val PokemonLeague_LoreleisRoomScripts: Map<String, Script> =
    mapOf(
        "PokemonLeague_LoreleisRoom_EventScript_Lorelei" to
            PokemonLeague_LoreleisRoom_EventScript_Lorelei,
        "PokemonLeague_LoreleisRoom_EventScript_PostBattle" to
            PokemonLeague_LoreleisRoom_EventScript_PostBattle,
        "PokemonLeague_LoreleisRoom_EventScript_RematchIntro" to
            PokemonLeague_LoreleisRoom_EventScript_RematchIntro,
        "PokemonLeague_LoreleisRoom_EventScript_Rematch" to
            PokemonLeague_LoreleisRoom_EventScript_Rematch,
        "PokemonLeague_LoreleisRoom_EventScript_Battle" to
            PokemonLeague_LoreleisRoom_EventScript_Battle,
        "PokemonLeague_LoreleisRoom_EventScript_Intro" to
            PokemonLeague_LoreleisRoom_EventScript_Intro,
        "PokemonLeague_LoreleisRoom_EventScript_DefeatedLorelei" to
            PokemonLeague_LoreleisRoom_EventScript_DefeatedLorelei,
    )
