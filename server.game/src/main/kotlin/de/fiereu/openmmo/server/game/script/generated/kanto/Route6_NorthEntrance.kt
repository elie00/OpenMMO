package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route6_NorthEntrance
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.MovementStep
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars

internal object Route6_NorthEntrance_EventScript_Guard : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(Route6_NorthEntrance.HiHowsItGoing)
}

/**
 * The guard on the Saffron gate, which the map's coord events fire from each tile in front of him.
 * He is too thirsty to let anyone past until the player brings the tea from Celadon, and then he
 * shares it with the other gates.
 */
internal object Route6_NorthEntrance_EventScript_GuardTrigger : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TEA)) {
      ctx.say(Route6_NorthEntrance.ThirstyOnGuardDuty)
      // He steps into the doorway rather than letting the player through.
      return ctx.moveSelf(MovementStep.WALK_UP)
    }
    ctx.takeItem(Items.TEA)
    ctx.say(Route6_NorthEntrance.ThatTeaLooksTasty)
    ctx.say(Route6_NorthEntrance.ThanksIllShareTeaWithGuards)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE5_ROUTE6_ROUTE7_ROUTE8_GATES, 1)
  }
}

internal object Route6_NorthEntrance_EventScript_GuardTriggerLeft : Script {
  override suspend fun run(ctx: ScriptContext) =
      Route6_NorthEntrance_EventScript_GuardTrigger.run(ctx)
}

internal object Route6_NorthEntrance_EventScript_GuardTriggerMid : Script {
  override suspend fun run(ctx: ScriptContext) =
      Route6_NorthEntrance_EventScript_GuardTrigger.run(ctx)
}

internal object Route6_NorthEntrance_EventScript_GuardTriggerRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      Route6_NorthEntrance_EventScript_GuardTrigger.run(ctx)
}

internal val Route6_NorthEntranceScripts: Map<String, Script> =
    mapOf(
        "Route6_NorthEntrance_EventScript_GuardTrigger" to
            Route6_NorthEntrance_EventScript_GuardTrigger,
        "Route6_NorthEntrance_EventScript_GuardTriggerLeft" to
            Route6_NorthEntrance_EventScript_GuardTriggerLeft,
        "Route6_NorthEntrance_EventScript_GuardTriggerMid" to
            Route6_NorthEntrance_EventScript_GuardTriggerMid,
        "Route6_NorthEntrance_EventScript_GuardTriggerRight" to
            Route6_NorthEntrance_EventScript_GuardTriggerRight,
        "Route6_NorthEntrance_EventScript_Guard" to Route6_NorthEntrance_EventScript_Guard,
    )
