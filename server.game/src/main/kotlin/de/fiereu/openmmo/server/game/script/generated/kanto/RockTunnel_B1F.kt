package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.dialog.generated.kanto.RockTunnel_B1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

internal object RockTunnel_B1F_EventScript_Cooper : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_POKEMANIAC_COOPER,
          RockTunnel_B1F.CooperIntro,
          RockTunnel_B1F.CooperDefeat,
          RockTunnel_B1F.CooperPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Dudley : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_DUDLEY,
          RockTunnel_B1F.DudleyIntro,
          RockTunnel_B1F.DudleyDefeat,
          RockTunnel_B1F.DudleyPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Sofia : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_SOFIA,
          RockTunnel_B1F.SofiaIntro,
          RockTunnel_B1F.SofiaDefeat,
          RockTunnel_B1F.SofiaPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Allen : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_ALLEN,
          RockTunnel_B1F.AllenIntro,
          RockTunnel_B1F.AllenDefeat,
          RockTunnel_B1F.AllenPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Eric : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_ERIC,
          RockTunnel_B1F.EricIntro,
          RockTunnel_B1F.EricDefeat,
          RockTunnel_B1F.EricPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Steve : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_POKEMANIAC_STEVE,
          RockTunnel_B1F.SteveIntro,
          RockTunnel_B1F.SteveDefeat,
          RockTunnel_B1F.StevePostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Martha : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_PICNICKER_MARTHA,
          RockTunnel_B1F.MarthaIntro,
          RockTunnel_B1F.MarthaDefeat,
          RockTunnel_B1F.MarthaPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_Winston : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_POKEMANIAC_WINSTON,
          RockTunnel_B1F.WinstonIntro,
          RockTunnel_B1F.WinstonDefeat,
          RockTunnel_B1F.WinstonPostBattle,
      )
}

internal object RockTunnel_B1F_EventScript_RockSlideTutor : Script {
  override suspend fun run(ctx: ScriptContext) =
      moveTutor(
          ctx,
          KantoFlags.FLAG_TUTOR_ROCK_SLIDE,
          Misc.Text_RockSlideTeach,
          Misc.Text_RockSlideDeclined,
          Misc.Text_RockSlideTaught,
      )
}

internal object RockTunnel_B1F_EventScript_ItemRevive : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.REVIVE)) return
    ctx.removeNpc(9)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCK_TUNNEL_B1F_REVIVE)
  }
}

internal object RockTunnel_B1F_EventScript_ItemMaxEther : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_ETHER)) return
    ctx.removeNpc(10)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ROCK_TUNNEL_B1F_MAX_ETHER)
  }
}

internal val RockTunnel_B1FScripts: Map<String, Script> =
    mapOf(
        "RockTunnel_B1F_EventScript_Cooper" to RockTunnel_B1F_EventScript_Cooper,
        "RockTunnel_B1F_EventScript_Dudley" to RockTunnel_B1F_EventScript_Dudley,
        "RockTunnel_B1F_EventScript_Sofia" to RockTunnel_B1F_EventScript_Sofia,
        "RockTunnel_B1F_EventScript_Allen" to RockTunnel_B1F_EventScript_Allen,
        "RockTunnel_B1F_EventScript_Eric" to RockTunnel_B1F_EventScript_Eric,
        "RockTunnel_B1F_EventScript_Steve" to RockTunnel_B1F_EventScript_Steve,
        "RockTunnel_B1F_EventScript_Martha" to RockTunnel_B1F_EventScript_Martha,
        "RockTunnel_B1F_EventScript_Winston" to RockTunnel_B1F_EventScript_Winston,
        "RockTunnel_B1F_EventScript_RockSlideTutor" to RockTunnel_B1F_EventScript_RockSlideTutor,
        "RockTunnel_B1F_EventScript_ItemRevive" to RockTunnel_B1F_EventScript_ItemRevive,
        "RockTunnel_B1F_EventScript_ItemMaxEther" to RockTunnel_B1F_EventScript_ItemMaxEther,
    )
