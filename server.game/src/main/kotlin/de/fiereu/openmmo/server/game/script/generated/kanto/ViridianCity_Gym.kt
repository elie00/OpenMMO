package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ViridianCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.story.generated.kanto.KantoVars
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

private const val LOCALID_GIOVANNI = 7

internal object ViridianCity_Gym_EventScript_Takashi : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_TAKASHI,
          ViridianCity_Gym.TakashiIntro,
          ViridianCity_Gym.TakashiDefeat,
          ViridianCity_Gym.TakashiPostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_Yuji : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_YUJI,
          ViridianCity_Gym.YujiIntro,
          ViridianCity_Gym.YujiDefeat,
          ViridianCity_Gym.YujiPostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_Atsushi : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_ATSUSHI,
          ViridianCity_Gym.AtsushiIntro,
          ViridianCity_Gym.AtsushiDefeat,
          ViridianCity_Gym.AtsushiPostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_Jason : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TAMER_JASON,
          ViridianCity_Gym.JasonIntro,
          ViridianCity_Gym.JasonDefeat,
          ViridianCity_Gym.JasonPostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_Cole : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_TAMER_COLE,
          ViridianCity_Gym.ColeIntro,
          ViridianCity_Gym.ColeDefeat,
          ViridianCity_Gym.ColePostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_Kiyo : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BLACK_BELT_KIYO,
          ViridianCity_Gym.KiyoIntro,
          ViridianCity_Gym.KiyoDefeat,
          ViridianCity_Gym.KiyoPostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_Samuel : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_SAMUEL,
          ViridianCity_Gym.SamuelIntro,
          ViridianCity_Gym.SamuelDefeat,
          ViridianCity_Gym.SamuelPostBattle,
      )
}

/** The gym leader the whole region has been waiting on, and the Rocket boss a third time. */
internal object ViridianCity_Gym_EventScript_Giovanni : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_GIOVANNI)) {
      ctx.say(ViridianCity_Gym.GiovanniIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_GIOVANNI) != BattleResult.VICTORY) return
      ctx.say(ViridianCity_Gym.GiovanniDefeat)
      return ViridianCity_Gym_EventScript_DefeatedGiovanni.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM26_FROM_GIOVANNI)) {
      return ViridianCity_Gym_EventScript_GiveTM26.run(ctx)
    }
    ctx.say(ViridianCity_Gym.GiovanniPostBattle)
  }
}

internal object ViridianCity_Gym_EventScript_Warren : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_WARREN,
          ViridianCity_Gym.WarrenIntro,
          ViridianCity_Gym.WarrenDefeat,
          ViridianCity_Gym.WarrenPostBattle,
      )
}

internal object ViridianCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_LEADER_GIOVANNI)) {
      return ctx.say(ViridianCity_Gym.GymGuyPostVictory)
    }
    ctx.say(ViridianCity_Gym.GymGuyAdvice)
  }
}

internal object ViridianCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE08_GET)) {
      return ctx.sign(ViridianCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(ViridianCity_Gym.GymStatue)
  }
}

/** What the eighth badge changes. Giovanni disbands Team Rocket and walks out of the gym. */
internal object ViridianCity_Gym_EventScript_DefeatedGiovanni : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ViridianCity_Gym.GiovanniPostBattle)
    ctx.removeNpc(LOCALID_GIOVANNI)
    ctx.setFlag(KantoFlags.FLAG_HIDE_VIRIDIAN_GIOVANNI)
    // His men give up across the whole region.
    ctx.setFlag(KantoFlags.FLAG_HIDE_MISC_KANTO_ROCKETS)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_LEADER_GIOVANNI)
    ctx.setFlag(KantoFlags.FLAG_BADGE08_GET)
    ctx.setVar(KantoVars.VAR_MAP_SCENE_ROUTE22, 3)
    // set_gym_trainers 8: this gym's eight trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_TAMER_JASON)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_TAMER_COLE)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BLACK_BELT_ATSUSHI)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BLACK_BELT_KIYO)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BLACK_BELT_TAKASHI)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_COOLTRAINER_SAMUEL)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_COOLTRAINER_YUJI)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_COOLTRAINER_WARREN)
    ViridianCity_Gym_EventScript_GiveTM26.run(ctx)
  }
}

internal object ViridianCity_Gym_EventScript_GiveTM26 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ViridianCity_Gym.ExplainEarthBadgeTakeThis)
    if (!ctx.giveItem(Items.TM26)) {
      return ctx.say(ViridianCity_Gym.YouDoNotHaveSpace)
    }
    ctx.say(ViridianCity_Gym.ReceivedTM26FromGiovanni)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM26_FROM_GIOVANNI)
    ctx.say(ViridianCity_Gym.ExplainTM26)
  }
}

internal val ViridianCity_GymScripts: Map<String, Script> =
    mapOf(
        "ViridianCity_Gym_EventScript_DefeatedGiovanni" to
            ViridianCity_Gym_EventScript_DefeatedGiovanni,
        "ViridianCity_Gym_EventScript_GiveTM26" to ViridianCity_Gym_EventScript_GiveTM26,
        "ViridianCity_Gym_EventScript_Takashi" to ViridianCity_Gym_EventScript_Takashi,
        "ViridianCity_Gym_EventScript_Yuji" to ViridianCity_Gym_EventScript_Yuji,
        "ViridianCity_Gym_EventScript_Atsushi" to ViridianCity_Gym_EventScript_Atsushi,
        "ViridianCity_Gym_EventScript_Jason" to ViridianCity_Gym_EventScript_Jason,
        "ViridianCity_Gym_EventScript_Cole" to ViridianCity_Gym_EventScript_Cole,
        "ViridianCity_Gym_EventScript_Kiyo" to ViridianCity_Gym_EventScript_Kiyo,
        "ViridianCity_Gym_EventScript_Samuel" to ViridianCity_Gym_EventScript_Samuel,
        "ViridianCity_Gym_EventScript_Giovanni" to ViridianCity_Gym_EventScript_Giovanni,
        "ViridianCity_Gym_EventScript_Warren" to ViridianCity_Gym_EventScript_Warren,
        "ViridianCity_Gym_EventScript_GymGuy" to ViridianCity_Gym_EventScript_GymGuy,
        "ViridianCity_Gym_EventScript_GymStatue" to ViridianCity_Gym_EventScript_GymStatue,
    )
