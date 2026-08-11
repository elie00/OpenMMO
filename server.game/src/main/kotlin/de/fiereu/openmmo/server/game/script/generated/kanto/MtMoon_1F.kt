package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.MtMoon_1F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

// Decomp local ids of this map's item balls.
private const val LOCALID_PARALYZEHEAL_BALL = 7
private const val LOCALID_TM09_BALL = 8
private const val LOCALID_POTION_BALL = 9
private const val LOCALID_RARECANDY_BALL = 10
private const val LOCALID_ESCAPEROPE_BALL = 11
private const val LOCALID_MOONSTONE_BALL = 12

internal object MtMoon_1F_EventScript_Iris : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_IRIS,
          MtMoon_1F.IrisIntro,
          MtMoon_1F.IrisDefeat,
          MtMoon_1F.IrisPostBattle,
      )
}

internal object MtMoon_1F_EventScript_Robby : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_ROBBY,
          MtMoon_1F.RobbyIntro,
          MtMoon_1F.RobbyDefeat,
          MtMoon_1F.RobbyPostBattle,
      )
}

internal object MtMoon_1F_EventScript_Jovan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SUPER_NERD_JOVAN,
          MtMoon_1F.JovanIntro,
          MtMoon_1F.JovanDefeat,
          MtMoon_1F.JovanPostBattle,
      )
}

internal object MtMoon_1F_EventScript_Miriam : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_LASS_MIRIAM,
          MtMoon_1F.MiriamIntro,
          MtMoon_1F.MiriamDefeat,
          MtMoon_1F.MiriamPostBattle,
      )
}

internal object MtMoon_1F_EventScript_Kent : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_BUG_CATCHER_KENT,
          MtMoon_1F.KentIntro,
          MtMoon_1F.KentDefeat,
          MtMoon_1F.KentPostBattle,
      )
}

internal object MtMoon_1F_EventScript_Josh : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_YOUNGSTER_JOSH,
          MtMoon_1F.JoshIntro,
          MtMoon_1F.JoshDefeat,
          MtMoon_1F.JoshPostBattle,
      )
}

internal object MtMoon_1F_EventScript_Marcos : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_MARCOS,
          MtMoon_1F.MarcosIntro,
          MtMoon_1F.MarcosDefeat,
          MtMoon_1F.MarcosPostBattle,
      )
}

internal object MtMoon_1F_EventScript_ItemParalyzeHeal : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.PARALYZE_HEAL)) return
    ctx.removeNpc(LOCALID_PARALYZEHEAL_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_1F_PARALYZE_HEAL)
  }
}

internal object MtMoon_1F_EventScript_ItemTM09 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM09)) return
    ctx.removeNpc(LOCALID_TM09_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_1F_TM09)
  }
}

internal object MtMoon_1F_EventScript_ItemPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.POTION)) return
    ctx.removeNpc(LOCALID_POTION_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_1F_POTION)
  }
}

internal object MtMoon_1F_EventScript_ItemRareCandy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.RARE_CANDY)) return
    ctx.removeNpc(LOCALID_RARECANDY_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_1F_RARE_CANDY)
  }
}

internal object MtMoon_1F_EventScript_ItemEscapeRope : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ESCAPE_ROPE)) return
    ctx.removeNpc(LOCALID_ESCAPEROPE_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_1F_ESCAPE_ROPE)
  }
}

internal object MtMoon_1F_EventScript_ItemMoonStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MOON_STONE)) return
    ctx.removeNpc(LOCALID_MOONSTONE_BALL)
    ctx.setFlag(KantoFlags.FLAG_HIDE_MT_MOON_1F_MOON_STONE)
  }
}

internal object MtMoon_1F_EventScript_BaldingMan : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(MtMoon_1F.BrockHelpsExcavateFossils)
}

internal object MtMoon_1F_EventScript_ZubatSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(MtMoon_1F.ZubatIsABloodsucker)
}

internal val MtMoon_1FScripts: Map<String, Script> =
    mapOf(
        "MtMoon_1F_EventScript_Iris" to MtMoon_1F_EventScript_Iris,
        "MtMoon_1F_EventScript_Robby" to MtMoon_1F_EventScript_Robby,
        "MtMoon_1F_EventScript_Jovan" to MtMoon_1F_EventScript_Jovan,
        "MtMoon_1F_EventScript_Miriam" to MtMoon_1F_EventScript_Miriam,
        "MtMoon_1F_EventScript_Kent" to MtMoon_1F_EventScript_Kent,
        "MtMoon_1F_EventScript_Josh" to MtMoon_1F_EventScript_Josh,
        "MtMoon_1F_EventScript_Marcos" to MtMoon_1F_EventScript_Marcos,
        "MtMoon_1F_EventScript_ItemParalyzeHeal" to MtMoon_1F_EventScript_ItemParalyzeHeal,
        "MtMoon_1F_EventScript_ItemTM09" to MtMoon_1F_EventScript_ItemTM09,
        "MtMoon_1F_EventScript_ItemPotion" to MtMoon_1F_EventScript_ItemPotion,
        "MtMoon_1F_EventScript_ItemRareCandy" to MtMoon_1F_EventScript_ItemRareCandy,
        "MtMoon_1F_EventScript_ItemEscapeRope" to MtMoon_1F_EventScript_ItemEscapeRope,
        "MtMoon_1F_EventScript_ItemMoonStone" to MtMoon_1F_EventScript_ItemMoonStone,
        "MtMoon_1F_EventScript_BaldingMan" to MtMoon_1F_EventScript_BaldingMan,
        "MtMoon_1F_EventScript_ZubatSign" to MtMoon_1F_EventScript_ZubatSign,
    )
