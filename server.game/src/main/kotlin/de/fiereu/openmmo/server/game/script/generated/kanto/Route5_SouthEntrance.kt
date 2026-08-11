package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route5_SouthEntrance
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.MovementStep
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

internal object Route5_SouthEntrance_EventScript_Guard : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route5_SouthEntrance.HiHowsItGoing)
}

/**
 * The guard on the Saffron gate, which the map's coord events fire from each tile in front of him.
 * He is too thirsty to let anyone past until the player brings the tea from Celadon, and then he
 * shares it with the other gates.
 */
internal object Route5_SouthEntrance_EventScript_GuardTrigger : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TEA)) {
      ctx.say(Route5_SouthEntrance.ThirstyOnGuardDuty)
      // He steps into the doorway rather than letting the player through.
      return ctx.moveSelf(MovementStep.WALK_UP)
    }
    ctx.takeItem(Items.TEA)
    ctx.say(Route5_SouthEntrance.ThatTeaLooksTasty)
    ctx.say(Route5_SouthEntrance.ThanksIllShareTeaWithGuards)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE5_ROUTE6_ROUTE7_ROUTE8_GATES, 1)
  }
}

internal object Route5_SouthEntrance_EventScript_GuardTriggerLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      Route5_SouthEntrance_EventScript_GuardTrigger.run(ctx)
}

internal object Route5_SouthEntrance_EventScript_GuardTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) =
      Route5_SouthEntrance_EventScript_GuardTrigger.run(ctx)
}

internal object Route5_SouthEntrance_EventScript_GuardTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      Route5_SouthEntrance_EventScript_GuardTrigger.run(ctx)
}

internal val Route5_SouthEntranceScripts: Map<String, Script> =
    mapOf(
        "Route5_SouthEntrance_EventScript_GuardTrigger" to
            Route5_SouthEntrance_EventScript_GuardTrigger,
        "Route5_SouthEntrance_EventScript_GuardTriggerLeft" to
            Route5_SouthEntrance_EventScript_GuardTriggerLeft,
        "Route5_SouthEntrance_EventScript_GuardTriggerMid" to
            Route5_SouthEntrance_EventScript_GuardTriggerMid,
        "Route5_SouthEntrance_EventScript_GuardTriggerRight" to
            Route5_SouthEntrance_EventScript_GuardTriggerRight,
        "Route5_SouthEntrance_EventScript_Guard" to Route5_SouthEntrance_EventScript_Guard,
    )
