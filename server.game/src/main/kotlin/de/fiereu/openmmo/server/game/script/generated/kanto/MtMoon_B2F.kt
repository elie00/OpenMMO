package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.common.dialog.DialogLine
import de.fiereu.openmmo.dialog.generated.kanto.MtMoon_B2F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.MovementStep
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_UP
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Decomp local ids of this map's object events.
private const val LOCALID_DOME_FOSSIL = 0
private const val LOCALID_HELIX_FOSSIL = 1
private const val LOCALID_MIGUEL = 2
private const val LOCALID_STAR_PIECE_BALL = 7
private const val LOCALID_TM46_BALL = 8
private const val LOCALID_REVIVE_BALL = 9
private const val LOCALID_ANTIDOTE_BALL = 10

internal object MtMoon_B2F_EventScript_DomeFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      takeFossil(
          ctx,
          question = MtMoon_B2F.YouWantDomeFossil,
          obtained = MtMoon_B2F.ObtainedDomeFossil,
          itemId = Items.DOME_FOSSIL,
          takenBall = LOCALID_DOME_FOSSIL,
          gotFlag = KantoFlags.FLAG_GOT_DOME_FOSSIL,
          // Miguel steps over to the fossil the player left and keeps it.
          miguelSteps = listOf(WALK_RIGHT, WALK_UP, WALK_UP, WALK_UP),
          miguelX = 14,
          miguelY = 8,
          leftBall = LOCALID_HELIX_FOSSIL,
      )
}

internal object MtMoon_B2F_EventScript_HelixFossil : Script {
  override suspend fun run(ctx: ScriptContext) =
      takeFossil(
          ctx,
          question = MtMoon_B2F.YouWantHelixFossil,
          obtained = MtMoon_B2F.ObtainedHelixFossil,
          itemId = Items.HELIX_FOSSIL,
          takenBall = LOCALID_HELIX_FOSSIL,
          gotFlag = KantoFlags.FLAG_GOT_HELIX_FOSSIL,
          miguelSteps = listOf(WALK_UP, WALK_UP, WALK_UP),
          miguelX = 13,
          miguelY = 8,
          leftBall = LOCALID_DOME_FOSSIL,
      )
}

/**
 * One of the two fossils, which is the same scene either way: the player takes one, Miguel walks to
 * the other and claims it, and both stop being pickable.
 */
private suspend fun takeFossil(
    ctx: ScriptContext,
    question: DialogLine,
    obtained: DialogLine,
    itemId: Int,
    takenBall: Int,
    gotFlag: String,
    miguelSteps: List<MovementStep>,
    miguelX: Int,
    miguelY: Int,
    leftBall: Int,
) {
  if (!ctx.askYesNo(question)) return
  if (!ctx.giveItem(itemId)) return
  ctx.removeNpc(takenBall)
  ctx.say(obtained)
  ctx.moveNpc(LOCALID_MIGUEL, *miguelSteps.toTypedArray())
  // copyobjectxytoperm: he stays by that fossil for good, not just for this visit.
  ctx.repositionNpc(LOCALID_MIGUEL, miguelX, miguelY)
  ctx.sayNpc(LOCALID_MIGUEL, MtMoon_B2F.ThenThisFossilIsMine)
  ctx.removeNpc(leftBall)
  ctx.setFlag(gotFlag)
  ctx.setFlag(KantoFlags.FLAG_GOT_FOSSIL_FROM_MT_MOON)
}

internal object MtMoon_B2F_EventScript_Miguel : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_FOSSIL_FROM_MT_MOON)) {
      return ctx.say(MtMoon_B2F.LabOnCinnabarRegeneratesFossils)
    }
    if (ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_SUPER_NERD_MIGUEL)) {
      return ctx.say(MtMoon_B2F.WellEachTakeAFossil)
    }
    // trainerbattle_no_intro: the intro box is shown by the script, not by the battle.
    ctx.say(MtMoon_B2F.MiguelIntro)
    if (ctx.trainerBattle(KantoTrainerIds.TRAINER_SUPER_NERD_MIGUEL) != BattleResult.VICTORY) return
    ctx.say(MtMoon_B2F.MiguelDefeat)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_MT_MOON_B2F, 1)
    ctx.say(MtMoon_B2F.WellEachTakeAFossil)
  }
}

internal object MtMoon_B2F_EventScript_Grunt4 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_4,
          MtMoon_B2F.Grunt4Intro,
          MtMoon_B2F.Grunt4Defeat,
          MtMoon_B2F.Grunt4PostBattle,
      )
}

internal object MtMoon_B2F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT,
          MtMoon_B2F.Grunt1Intro,
          MtMoon_B2F.Grunt1Defeat,
          MtMoon_B2F.Grunt1PostBattle,
      )
}

internal object MtMoon_B2F_EventScript_Grunt3 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_3,
          MtMoon_B2F.Grunt3Intro,
          MtMoon_B2F.Grunt3Defeat,
          MtMoon_B2F.Grunt3PostBattle,
      )
}

internal object MtMoon_B2F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TEAM_ROCKET_GRUNT_2,
          MtMoon_B2F.Grunt2Intro,
          MtMoon_B2F.Grunt2Defeat,
          MtMoon_B2F.Grunt2PostBattle,
      )
}

internal object MtMoon_B2F_EventScript_ItemStarPiece : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.STAR_PIECE)) return
    ctx.removeNpc(LOCALID_STAR_PIECE_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_B2F_STAR_PIECE)
  }
}

internal object MtMoon_B2F_EventScript_ItemTM46 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM46)) return
    ctx.removeNpc(LOCALID_TM46_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_B2F_TM46)
  }
}

internal object MtMoon_B2F_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.REVIVE)) return
    ctx.removeNpc(LOCALID_REVIVE_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_B2F_REVIVE)
  }
}

internal object MtMoon_B2F_EventScript_ItemAntidote : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ANTIDOTE)) return
    ctx.removeNpc(LOCALID_ANTIDOTE_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_B2F_ANTIDOTE)
  }
}

/** Walking into his line of sight, which the map's coord event fires. */
internal object MtMoon_B2F_EventScript_MiguelTrigger : Script {
  override suspend fun run(ctx: ScriptContext) = MtMoon_B2F_EventScript_Miguel.run(ctx)
}

internal val MtMoon_B2FScripts: Map<String, Script> =
    mapOf(
        "MtMoon_B2F_EventScript_MiguelTrigger" to MtMoon_B2F_EventScript_MiguelTrigger,
        "MtMoon_B2F_EventScript_DomeFossil" to MtMoon_B2F_EventScript_DomeFossil,
        "MtMoon_B2F_EventScript_HelixFossil" to MtMoon_B2F_EventScript_HelixFossil,
        "MtMoon_B2F_EventScript_Miguel" to MtMoon_B2F_EventScript_Miguel,
        "MtMoon_B2F_EventScript_Grunt4" to MtMoon_B2F_EventScript_Grunt4,
        "MtMoon_B2F_EventScript_Grunt1" to MtMoon_B2F_EventScript_Grunt1,
        "MtMoon_B2F_EventScript_Grunt3" to MtMoon_B2F_EventScript_Grunt3,
        "MtMoon_B2F_EventScript_Grunt2" to MtMoon_B2F_EventScript_Grunt2,
        "MtMoon_B2F_EventScript_ItemStarPiece" to MtMoon_B2F_EventScript_ItemStarPiece,
        "MtMoon_B2F_EventScript_ItemTM46" to MtMoon_B2F_EventScript_ItemTM46,
        "MtMoon_B2F_EventScript_ItemRevive" to MtMoon_B2F_EventScript_ItemRevive,
        "MtMoon_B2F_EventScript_ItemAntidote" to MtMoon_B2F_EventScript_ItemAntidote,
    )
