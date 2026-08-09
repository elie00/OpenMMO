package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoVars

/**
 * Ported from the decomp:
 * ```
 * call TrainerTower_EventScript_SpeakToDoublesTrainer1
 * end
 * ```
 */
internal object TrainerTower_EventScript_DoublesTrainer1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    TrainerTower_EventScript_SpeakToDoublesTrainer1.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call TrainerTower_EventScript_SpeakToSinglesTrainer
 * end
 * ```
 */
internal object TrainerTower_EventScript_SinglesTrainer : Script {
  override suspend fun run(ctx: ScriptContext) {
    TrainerTower_EventScript_SpeakToSinglesTrainer.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call TrainerTower_EventScript_SpeakToKnockoutTrainer
 * end
 * ```
 */
internal object TrainerTower_EventScript_KnockoutTrainer : Script {
  override suspend fun run(ctx: ScriptContext) {
    TrainerTower_EventScript_SpeakToKnockoutTrainer.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * call TrainerTower_EventScript_SpeakToDoublesTrainer2
 * end
 * ```
 */
internal object TrainerTower_EventScript_DoublesTrainer2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    TrainerTower_EventScript_SpeakToDoublesTrainer2.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * ttower_getchallengetype
 * switch VAR_RESULT
 * case CHALLENGE_TYPE_SINGLE, TrainerTower_EventScript_DoublesTrainer1PostBattle
 * case CHALLENGE_TYPE_DOUBLE, TrainerTower_EventScript_DoublesTrainer1PostBattle
 * case CHALLENGE_TYPE_KNOCKOUT, TrainerTower_EventScript_KnockoutTrainer2PostBattle
 * ```
 */
internal object TrainerTower_EventScript_SpeakToDoublesTrainer1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TrainerTower_EventScript_SpeakToDoublesTrainer1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * ttower_getchallengetype
 * switch VAR_RESULT
 * case CHALLENGE_TYPE_SINGLE, TrainerTower_EventScript_SinglesTrainerPostBattle
 * case CHALLENGE_TYPE_DOUBLE, TrainerTower_EventScript_SinglesTrainerPostBattle
 * case CHALLENGE_TYPE_KNOCKOUT, TrainerTower_EventScript_KnockoutTrainer3PostBattle
 * ```
 */
internal object TrainerTower_EventScript_SpeakToSinglesTrainer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TrainerTower_EventScript_SpeakToSinglesTrainer")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_0x8006, 1
 * ```
 */
internal object TrainerTower_EventScript_SpeakToDoublesTrainer2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(KantoVars.VAR_0x8006, 1)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x8006, 0
 * goto TrainerTower_EventScript_DoPostBattleText
 * ```
 */
internal object TrainerTower_EventScript_SpeakToKnockoutTrainer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port TrainerTower_EventScript_SpeakToKnockoutTrainer")
}

internal val TrainerTower_1FScripts: Map<String, Script> =
    mapOf(
        "TrainerTower_EventScript_DoublesTrainer1" to TrainerTower_EventScript_DoublesTrainer1,
        "TrainerTower_EventScript_SinglesTrainer" to TrainerTower_EventScript_SinglesTrainer,
        "TrainerTower_EventScript_KnockoutTrainer" to TrainerTower_EventScript_KnockoutTrainer,
        "TrainerTower_EventScript_DoublesTrainer2" to TrainerTower_EventScript_DoublesTrainer2,
        "TrainerTower_EventScript_SpeakToDoublesTrainer1" to
            TrainerTower_EventScript_SpeakToDoublesTrainer1,
        "TrainerTower_EventScript_SpeakToSinglesTrainer" to
            TrainerTower_EventScript_SpeakToSinglesTrainer,
        "TrainerTower_EventScript_SpeakToDoublesTrainer2" to
            TrainerTower_EventScript_SpeakToDoublesTrainer2,
        "TrainerTower_EventScript_SpeakToKnockoutTrainer" to
            TrainerTower_EventScript_SpeakToKnockoutTrainer,
    )
