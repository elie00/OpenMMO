package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SaffronCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object SaffronCity_Gym_EventScript_Cameron : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PSYCHIC_CAMERON,
          SaffronCity_Gym.CameronIntro,
          SaffronCity_Gym.CameronDefeat,
          SaffronCity_Gym.CameronPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_Johan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PSYCHIC_JOHAN,
          SaffronCity_Gym.JohanIntro,
          SaffronCity_Gym.JohanDefeat,
          SaffronCity_Gym.JohanPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_Preston : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PSYCHIC_PRESTON,
          SaffronCity_Gym.PrestonIntro,
          SaffronCity_Gym.PrestonDefeat,
          SaffronCity_Gym.PrestonPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_Amanda : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_AMANDA,
          SaffronCity_Gym.AmandaIntro,
          SaffronCity_Gym.AmandaDefeat,
          SaffronCity_Gym.AmandaPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_Stacy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_STACY,
          SaffronCity_Gym.StacyIntro,
          SaffronCity_Gym.StacyDefeat,
          SaffronCity_Gym.StacyPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_Tasha : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_CHANNELER_TASHA,
          SaffronCity_Gym.TashaIntro,
          SaffronCity_Gym.TashaDefeat,
          SaffronCity_Gym.TashaPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_Sabrina : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_SABRINA)) {
      ctx.say(SaffronCity_Gym.SabrinaIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_SABRINA) != BattleResult.VICTORY) return
      ctx.say(SaffronCity_Gym.SabrinaDefeat)
      return SaffronCity_Gym_EventScript_DefeatedSabrina.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM04_FROM_SABRINA)) {
      return SaffronCity_Gym_EventScript_GiveTM04.run(ctx)
    }
    ctx.say(SaffronCity_Gym.SabrinaPostBattle)
  }
}

internal object SaffronCity_Gym_EventScript_Tyron : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PSYCHIC_TYRON,
          SaffronCity_Gym.TyronIntro,
          SaffronCity_Gym.TyronDefeat,
          SaffronCity_Gym.TyronPostBattle,
      )
}

internal object SaffronCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_SABRINA)) {
      return ctx.say(SaffronCity_Gym.GymGuyPostVictory)
    }
    ctx.say(SaffronCity_Gym.GymGuyAdvice)
  }
}

internal object SaffronCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE06_GET)) {
      return ctx.sign(SaffronCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(SaffronCity_Gym.GymStatue)
  }
}

/** What the sixth badge changes, run straight after Sabrina's defeat line. */
internal object SaffronCity_Gym_EventScript_DefeatedSabrina : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.clearFlag(KantoFlags.FLAG_HIDE_SAFFRON_CITY_POKECENTER_SABRINA_JOURNALS)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_SABRINA)
    ctx.setFlag(KantoFlags.FLAG_BADGE06_GET)
    // set_gym_trainers 6: this gym's seven trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_PSYCHIC_JOHAN)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_PSYCHIC_TYRON)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_PSYCHIC_CAMERON)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_PSYCHIC_PRESTON)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_CHANNELER_AMANDA)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_CHANNELER_STACY)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_CHANNELER_TASHA)
    SaffronCity_Gym_EventScript_GiveTM04.run(ctx)
  }
}

internal object SaffronCity_Gym_EventScript_GiveTM04 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SaffronCity_Gym.ExplainMarshBadgeTakeThis)
    if (!ctx.giveItem(Items.TM04)) {
      return ctx.say(SaffronCity_Gym.BagFullOfOtherItems)
    }
    ctx.say(SaffronCity_Gym.ReceivedTM04FromSabrina)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM04_FROM_SABRINA)
    ctx.say(SaffronCity_Gym.ExplainTM04)
    ctx.say(SaffronCity_Gym.SabrinaPostBattle)
  }
}

internal val SaffronCity_GymScripts: Map<String, Script> =
    mapOf(
        "SaffronCity_Gym_EventScript_DefeatedSabrina" to
            SaffronCity_Gym_EventScript_DefeatedSabrina,
        "SaffronCity_Gym_EventScript_GiveTM04" to SaffronCity_Gym_EventScript_GiveTM04,
        "SaffronCity_Gym_EventScript_Cameron" to SaffronCity_Gym_EventScript_Cameron,
        "SaffronCity_Gym_EventScript_Johan" to SaffronCity_Gym_EventScript_Johan,
        "SaffronCity_Gym_EventScript_Preston" to SaffronCity_Gym_EventScript_Preston,
        "SaffronCity_Gym_EventScript_Amanda" to SaffronCity_Gym_EventScript_Amanda,
        "SaffronCity_Gym_EventScript_Stacy" to SaffronCity_Gym_EventScript_Stacy,
        "SaffronCity_Gym_EventScript_Tasha" to SaffronCity_Gym_EventScript_Tasha,
        "SaffronCity_Gym_EventScript_Sabrina" to SaffronCity_Gym_EventScript_Sabrina,
        "SaffronCity_Gym_EventScript_Tyron" to SaffronCity_Gym_EventScript_Tyron,
        "SaffronCity_Gym_EventScript_GymGuy" to SaffronCity_Gym_EventScript_GymGuy,
        "SaffronCity_Gym_EventScript_GymStatue" to SaffronCity_Gym_EventScript_GymStatue,
    )
