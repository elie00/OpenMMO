package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.FallarborTown
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

internal object FallarborTown_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FallarborTown.MyPreciousAzurill)
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_DEFEATED_EVIL_TEAM_MT_CHIMNEY, FallarborTown_EventScript_ExpertMNormal
 * msgbox FallarborTown_Text_ShadyCharactersCozmosHome, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_EventScript_ExpertM : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_DEFEATED_EVIL_TEAM_MT_CHIMNEY))
        return FallarborTown_EventScript_ExpertMNormal.run(ctx)
    ctx.say(FallarborTown.ShadyCharactersCozmosHome)
  }
}

internal object FallarborTown_EventScript_Gentleman : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(FallarborTown.HaveYouChallengedFlannery)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_AZURILL, CRY_MODE_NORMAL
 * msgbox FallarborTown_Text_Azurill, MSGBOX_DEFAULT
 * waitmoncry
 * release
 * end
 * ```
 */
internal object FallarborTown_EventScript_Azurill : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port FallarborTown_EventScript_Azurill")
}

internal object FallarborTown_EventScript_BattleTentSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FallarborTown.BattleTentSign)
}

internal object FallarborTown_EventScript_TownSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FallarborTown.TownSign)
}

internal object FallarborTown_EventScript_MoveTutorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(FallarborTown.MoveTutorSign)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox FallarborTown_Text_RegionKnownForMeteors, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object FallarborTown_EventScript_ExpertMNormal : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(FallarborTown.RegionKnownForMeteors)
  }
}

internal val FallarborTownScripts: Map<String, Script> =
    mapOf(
        "FallarborTown_EventScript_Girl" to FallarborTown_EventScript_Girl,
        "FallarborTown_EventScript_ExpertM" to FallarborTown_EventScript_ExpertM,
        "FallarborTown_EventScript_Gentleman" to FallarborTown_EventScript_Gentleman,
        "FallarborTown_EventScript_Azurill" to FallarborTown_EventScript_Azurill,
        "FallarborTown_EventScript_BattleTentSign" to FallarborTown_EventScript_BattleTentSign,
        "FallarborTown_EventScript_TownSign" to FallarborTown_EventScript_TownSign,
        "FallarborTown_EventScript_MoveTutorSign" to FallarborTown_EventScript_MoveTutorSign,
        "FallarborTown_EventScript_ExpertMNormal" to FallarborTown_EventScript_ExpertMNormal,
    )
