package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.VerdanturfTown_WandasHouse
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_WALLY_SPEECH, VerdanturfTown_WandasHouse_EventScript_WallyShortSpeech
 * msgbox VerdanturfTown_WandasHouse_Text_StrongerSpeech, MSGBOX_DEFAULT
 * setflag FLAG_WALLY_SPEECH
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_Wally : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_WALLY_SPEECH))
        return VerdanturfTown_WandasHouse_EventScript_WallyShortSpeech.run(ctx)
    ctx.say(VerdanturfTown_WandasHouse.StrongerSpeech)
    ctx.setFlag(HoennFlags.FLAG_WALLY_SPEECH)
  }
}

internal object VerdanturfTown_WandasHouse_EventScript_WandasBoyfriend : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(VerdanturfTown_WandasHouse.CanSeeGirlfriendEveryDay)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_WALLY_VICTORY_ROAD, VerdanturfTown_WandasHouse_EventScript_WallysUncleEverGrande
 * goto_if_set FLAG_DEFEATED_LAVARIDGE_GYM, VerdanturfTown_WandasHouse_EventScript_WallysUncleSlippedOff
 * msgbox VerdanturfTown_WandasHouse_Text_WallysNextDoor, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysUncle : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_WALLY_VICTORY_ROAD))
        return VerdanturfTown_WandasHouse_EventScript_WallysUncleEverGrande.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_LAVARIDGE_GYM))
        return VerdanturfTown_WandasHouse_EventScript_WallysUncleSlippedOff.run(ctx)
    ctx.say(VerdanturfTown_WandasHouse.WallysNextDoor)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_WALLY_VICTORY_ROAD, VerdanturfTown_WandasHouse_EventScript_WallysAuntEverGrande
 * goto_if_set FLAG_DEFEATED_LAVARIDGE_GYM, VerdanturfTown_WandasHouse_EventScript_WallysAuntAnythingHappened
 * goto_if_set FLAG_RUSTURF_TUNNEL_OPENED, VerdanturfTown_WandasHouse_EventScript_WallysAuntTunnelOpen
 * msgbox VerdanturfTown_WandasHouse_Text_DaughtersBoyfriendDriven, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysAunt : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_WALLY_VICTORY_ROAD))
        return VerdanturfTown_WandasHouse_EventScript_WallysAuntEverGrande.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_LAVARIDGE_GYM))
        return VerdanturfTown_WandasHouse_EventScript_WallysAuntAnythingHappened.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_RUSTURF_TUNNEL_OPENED))
        return VerdanturfTown_WandasHouse_EventScript_WallysAuntTunnelOpen.run(ctx)
    ctx.say(VerdanturfTown_WandasHouse.DaughtersBoyfriendDriven)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_LAVARIDGE_GYM, VerdanturfTown_WandasHouse_EventScript_WandaDontWorry
 * goto_if_set FLAG_DEFEATED_WALLY_MAUVILLE, VerdanturfTown_WandasHouse_EventScript_MeetWanda
 * msgbox VerdanturfTown_WandasHouse_Text_DontWorryAboutWally, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_Wanda : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_LAVARIDGE_GYM))
        return VerdanturfTown_WandasHouse_EventScript_WandaDontWorry.run(ctx)
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_WALLY_MAUVILLE))
        return VerdanturfTown_WandasHouse_EventScript_MeetWanda.run(ctx)
    ctx.say(VerdanturfTown_WandasHouse.DontWorryAboutWally)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_WallySlippedOff, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysUncleSlippedOff : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.WallySlippedOff)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_WallyWasInEverGrande, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysAuntEverGrande : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.WallyWasInEverGrande)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_IfAnythingHappenedToWally, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysAuntAnythingHappened : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.IfAnythingHappenedToWally)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_MeetWanda, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_MeetWanda : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.MeetWanda)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_DontWorryAboutWally, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WandaDontWorry : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.DontWorryAboutWally)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_WallyGoneThatFar, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysUncleEverGrande : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.WallyGoneThatFar)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_StrongerSpeechShort, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallyShortSpeech : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.StrongerSpeechShort)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox VerdanturfTown_WandasHouse_Text_DaughtersBoyfriendWasDigging, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object VerdanturfTown_WandasHouse_EventScript_WallysAuntTunnelOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VerdanturfTown_WandasHouse.DaughtersBoyfriendWasDigging)
  }
}

internal val VerdanturfTown_WandasHouseScripts: Map<String, Script> =
    mapOf(
        "VerdanturfTown_WandasHouse_EventScript_Wally" to
            VerdanturfTown_WandasHouse_EventScript_Wally,
        "VerdanturfTown_WandasHouse_EventScript_WandasBoyfriend" to
            VerdanturfTown_WandasHouse_EventScript_WandasBoyfriend,
        "VerdanturfTown_WandasHouse_EventScript_WallysUncle" to
            VerdanturfTown_WandasHouse_EventScript_WallysUncle,
        "VerdanturfTown_WandasHouse_EventScript_WallysAunt" to
            VerdanturfTown_WandasHouse_EventScript_WallysAunt,
        "VerdanturfTown_WandasHouse_EventScript_Wanda" to
            VerdanturfTown_WandasHouse_EventScript_Wanda,
        "VerdanturfTown_WandasHouse_EventScript_WallysUncleSlippedOff" to
            VerdanturfTown_WandasHouse_EventScript_WallysUncleSlippedOff,
        "VerdanturfTown_WandasHouse_EventScript_WallysAuntEverGrande" to
            VerdanturfTown_WandasHouse_EventScript_WallysAuntEverGrande,
        "VerdanturfTown_WandasHouse_EventScript_WallysAuntAnythingHappened" to
            VerdanturfTown_WandasHouse_EventScript_WallysAuntAnythingHappened,
        "VerdanturfTown_WandasHouse_EventScript_MeetWanda" to
            VerdanturfTown_WandasHouse_EventScript_MeetWanda,
        "VerdanturfTown_WandasHouse_EventScript_WandaDontWorry" to
            VerdanturfTown_WandasHouse_EventScript_WandaDontWorry,
        "VerdanturfTown_WandasHouse_EventScript_WallysUncleEverGrande" to
            VerdanturfTown_WandasHouse_EventScript_WallysUncleEverGrande,
        "VerdanturfTown_WandasHouse_EventScript_WallyShortSpeech" to
            VerdanturfTown_WandasHouse_EventScript_WallyShortSpeech,
        "VerdanturfTown_WandasHouse_EventScript_WallysAuntTunnelOpen" to
            VerdanturfTown_WandasHouse_EventScript_WallysAuntTunnelOpen,
    )
