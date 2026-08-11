package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.CeladonCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object CeladonCity_Gym_EventScript_Kay : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_KAY,
          CeladonCity_Gym.KayIntro,
          CeladonCity_Gym.KayDefeat,
          CeladonCity_Gym.KayPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_Bridget : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_BRIDGET,
          CeladonCity_Gym.BridgetIntro,
          CeladonCity_Gym.BridgetDefeat,
          CeladonCity_Gym.BridgetPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_Tina : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_TINA,
          CeladonCity_Gym.TinaIntro,
          CeladonCity_Gym.TinaDefeat,
          CeladonCity_Gym.TinaPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_Tamia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_TAMIA,
          CeladonCity_Gym.TamiaIntro,
          CeladonCity_Gym.TamiaDefeat,
          CeladonCity_Gym.TamiaPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_Lori : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BEAUTY_LORI,
          CeladonCity_Gym.LoriIntro,
          CeladonCity_Gym.LoriDefeat,
          CeladonCity_Gym.LoriPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_Lisa : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_LISA,
          CeladonCity_Gym.LisaIntro,
          CeladonCity_Gym.LisaDefeat,
          CeladonCity_Gym.LisaPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_Erika : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_ERIKA)) {
      ctx.say(CeladonCity_Gym.ErikaIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_ERIKA) != BattleResult.VICTORY) return
      ctx.say(CeladonCity_Gym.ErikaDefeat)
      return CeladonCity_Gym_EventScript_DefeatedErika.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM19_FROM_ERIKA)) {
      return CeladonCity_Gym_EventScript_GiveTM19.run(ctx)
    }
    ctx.say(CeladonCity_Gym.ErikaPostBattle)
  }
}

internal object CeladonCity_Gym_EventScript_Mary : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_COOLTRAINER_MARY,
          CeladonCity_Gym.MaryIntro,
          CeladonCity_Gym.MaryDefeat,
          CeladonCity_Gym.MaryPostBattle,
      )
}

internal object CeladonCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE04_GET)) {
      return ctx.sign(CeladonCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(CeladonCity_Gym.GymStatue)
  }
}

/** What the fourth badge changes, run straight after Erika's defeat line. */
internal object CeladonCity_Gym_EventScript_DefeatedErika : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.clearFlag(KantoFlags.FLAG_HIDE_FAME_CHECKER_ERIKA_JOURNALS)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_ERIKA)
    ctx.setFlag(KantoFlags.FLAG_BADGE04_GET)
    // set_gym_trainers 4: this gym's seven trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_LASS_KAY)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_LASS_LISA)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_PICNICKER_TINA)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BEAUTY_BRIDGET)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BEAUTY_TAMIA)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_BEAUTY_LORI)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_COOLTRAINER_MARY)
    CeladonCity_Gym_EventScript_GiveTM19.run(ctx)
  }
}

internal object CeladonCity_Gym_EventScript_GiveTM19 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(CeladonCity_Gym.ExplainRainbowBadgeTakeThis)
    if (!ctx.giveItem(Items.TM19)) {
      return ctx.say(CeladonCity_Gym.ShouldMakeRoomForThis)
    }
    ctx.say(CeladonCity_Gym.ReceivedTM19FromErika)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM19_FROM_ERIKA)
    ctx.say(CeladonCity_Gym.ExplainTM19)
  }
}

internal val CeladonCity_GymScripts: Map<String, Script> =
    mapOf(
        "CeladonCity_Gym_EventScript_DefeatedErika" to CeladonCity_Gym_EventScript_DefeatedErika,
        "CeladonCity_Gym_EventScript_GiveTM19" to CeladonCity_Gym_EventScript_GiveTM19,
        "CeladonCity_Gym_EventScript_Kay" to CeladonCity_Gym_EventScript_Kay,
        "CeladonCity_Gym_EventScript_Bridget" to CeladonCity_Gym_EventScript_Bridget,
        "CeladonCity_Gym_EventScript_Tina" to CeladonCity_Gym_EventScript_Tina,
        "CeladonCity_Gym_EventScript_Tamia" to CeladonCity_Gym_EventScript_Tamia,
        "CeladonCity_Gym_EventScript_Lori" to CeladonCity_Gym_EventScript_Lori,
        "CeladonCity_Gym_EventScript_Lisa" to CeladonCity_Gym_EventScript_Lisa,
        "CeladonCity_Gym_EventScript_Erika" to CeladonCity_Gym_EventScript_Erika,
        "CeladonCity_Gym_EventScript_Mary" to CeladonCity_Gym_EventScript_Mary,
        "CeladonCity_Gym_EventScript_GymStatue" to CeladonCity_Gym_EventScript_GymStatue,
    )
