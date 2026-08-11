package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.VermilionCity_Gym
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds
import kotlin.random.Random

// The two cans the switches are under this round. The decomp keeps them in VAR_TEMP_0 and
// VAR_TEMP_1, redrawn on every entry; these are story vars cleared by the transition script for the
// same effect. FOUND_FIRST_SWITCH is its FLAG_TEMP_1.
internal const val VAR_SWITCH_1 = "kanto/VERMILION_GYM_SWITCH_1"
internal const val VAR_SWITCH_2 = "kanto/VERMILION_GYM_SWITCH_2"
private const val FOUND_FIRST_SWITCH = KantoFlags.FLAG_TEMP_1

private const val TRASH_CANS = 15
private const val CANS_PER_ROW = 5

/**
 * The barrier tiles between the door and Lt. Surge. The decomp swaps their metatiles for floor;
 * only the walkable half of that is portable, so they open but stay drawn.
 */
private val BARRIER_TILES = (3..7).flatMap { x -> listOf(x to 6, x to 7) }

internal object VermilionCity_Gym_OnTransition : Script {
  override suspend fun run(ctx: ScriptContext) {
    // OnLoad in the decomp: an already opened barrier is open again on the way back in.
    if (ctx.isFlagSet(KantoFlags.FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES)) {
      return openBarrier(ctx)
    }
    ctx.clearFlag(FOUND_FIRST_SWITCH)
    hideSwitches(ctx)
  }
}

private fun openBarrier(ctx: ScriptContext) {
  BARRIER_TILES.forEach { (x, y) -> ctx.openTile(x, y) }
}

/**
 * SetVermilionTrashCans: the first switch is under any of the fifteen cans and the second under one
 * next to it, so the player who finds the first has four cans left to try.
 */
private fun hideSwitches(ctx: ScriptContext) {
  val first = Random.nextInt(TRASH_CANS) + 1
  val neighbours = buildList {
    if (first % CANS_PER_ROW != 0) add(first + 1)
    if (first % CANS_PER_ROW != 1) add(first - 1)
    if (first + CANS_PER_ROW <= TRASH_CANS) add(first + CANS_PER_ROW)
    if (first - CANS_PER_ROW >= 1) add(first - CANS_PER_ROW)
  }
  ctx.setVar(VAR_SWITCH_1, first)
  ctx.setVar(VAR_SWITCH_2, neighbours.random())
}

/**
 * One of the fifteen cans. The first switch half opens the barrier, the second opens the rest, and
 * a wrong second guess resets both and hides them somewhere else.
 *
 * The decomp's half open state swaps in another set of beam tiles that still block the way, so only
 * the second switch opens anything here.
 */
private suspend fun searchTrashCan(ctx: ScriptContext, canId: Int) {
  if (ctx.isFlagSet(KantoFlags.FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES)) {
    return ctx.sign(VermilionCity_Gym.NopeOnlyTrashHere)
  }
  if (!ctx.isFlagSet(FOUND_FIRST_SWITCH)) {
    if (canId != ctx.getVar(VAR_SWITCH_1)) {
      return ctx.sign(VermilionCity_Gym.NopeOnlyTrashHere)
    }
    ctx.sign(VermilionCity_Gym.SwitchUnderTrashFirstLockOpened)
    return ctx.setFlag(FOUND_FIRST_SWITCH)
  }
  if (canId != ctx.getVar(VAR_SWITCH_2)) {
    ctx.sign(VermilionCity_Gym.OnlyTrashLocksWereReset)
    ctx.clearFlag(FOUND_FIRST_SWITCH)
    return hideSwitches(ctx)
  }
  ctx.sign(VermilionCity_Gym.SecondLockOpened)
  ctx.setFlag(KantoFlags.FLAG_FOUND_BOTH_VERMILION_GYM_SWITCHES)
  openBarrier(ctx)
}

internal object VermilionCity_Gym_EventScript_LtSurge : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.hasBeatenTrainer(KantoTrainerIds.TRAINER_LEADER_LT_SURGE)) {
      ctx.say(VermilionCity_Gym.LtSurgeIntro)
      if (ctx.trainerBattle(KantoTrainerIds.TRAINER_LEADER_LT_SURGE) != BattleResult.VICTORY) return
      ctx.say(VermilionCity_Gym.LtSurgeDefeat)
      return VermilionCity_Gym_EventScript_DefeatedLtSurge.run(ctx)
    }
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_TM34_FROM_SURGE)) {
      return VermilionCity_Gym_EventScript_GiveTM34.run(ctx)
    }
    ctx.say(VermilionCity_Gym.LtSurgePostBattle)
  }
}

/** What the third badge changes, run straight after Lt. Surge's defeat line. */
internal object VermilionCity_Gym_EventScript_DefeatedLtSurge : Script {
  override suspend fun run(ctx: ScriptContext) {
    // Oak's aide waits outside with HM05 until the player has this badge.
    if (!ctx.isFlagSet(KantoFlags.FLAG_GOT_HM05)) {
      ctx.clearFlag(KantoFlags.FLAG_HIDE_VERMILION_CITY_OAKS_AIDE)
    }
    ctx.clearFlag(KantoFlags.FLAG_HIDE_FAME_CHECKER_LT_SURGE_JOURNAL)
    ctx.setFlag(KantoFlags.FLAG_DEFEATED_LT_SURGE)
    ctx.setFlag(KantoFlags.FLAG_BADGE03_GET)
    // set_gym_trainers 3: this gym's three trainers are retired along with its leader.
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_SAILOR_DWAYNE)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_ENGINEER_BAILY)
    ctx.markTrainerBeaten(KantoTrainerIds.TRAINER_GENTLEMAN_TUCKER)
    VermilionCity_Gym_EventScript_GiveTM34.run(ctx)
  }
}

internal object VermilionCity_Gym_EventScript_GiveTM34 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(VermilionCity_Gym.ExplainThunderBadgeTakeThis)
    if (!ctx.giveItem(Items.TM34)) {
      return ctx.say(VermilionCity_Gym.MakeRoomInYourBag)
    }
    ctx.say(VermilionCity_Gym.ReceivedTM34FromLtSurge)
    ctx.setFlag(KantoFlags.FLAG_GOT_TM34_FROM_SURGE)
    ctx.say(VermilionCity_Gym.ExplainTM34)
  }
}

internal object VermilionCity_Gym_EventScript_Baily : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_ENGINEER_BAILY,
          VermilionCity_Gym.BailyIntro,
          VermilionCity_Gym.BailyDefeat,
          VermilionCity_Gym.BailyPostBattle,
      )
}

internal object VermilionCity_Gym_EventScript_Dwayne : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_SAILOR_DWAYNE,
          VermilionCity_Gym.DwayneIntro,
          VermilionCity_Gym.DwayneDefeat,
          VermilionCity_Gym.DwaynePostBattle,
      )
}

internal object VermilionCity_Gym_EventScript_Tucker : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_GENTLEMAN_TUCKER,
          VermilionCity_Gym.TuckerIntro,
          VermilionCity_Gym.TuckerDefeat,
          VermilionCity_Gym.TuckerPostBattle,
      )
}

internal object VermilionCity_Gym_EventScript_GymGuy : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_DEFEATED_LT_SURGE)) {
      return ctx.say(VermilionCity_Gym.GymGuyPostVictory)
    }
    ctx.say(VermilionCity_Gym.GymGuyAdvice)
  }
}

internal object VermilionCity_Gym_EventScript_GymStatue : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(KantoFlags.FLAG_BADGE03_GET)) {
      return ctx.sign(VermilionCity_Gym.GymStatuePlayerWon)
    }
    ctx.sign(VermilionCity_Gym.GymStatue)
  }
}

internal object VermilionCity_Gym_EventScript_TrashCan1 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 1)
}

internal object VermilionCity_Gym_EventScript_TrashCan2 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 2)
}

internal object VermilionCity_Gym_EventScript_TrashCan3 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 3)
}

internal object VermilionCity_Gym_EventScript_TrashCan4 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 4)
}

internal object VermilionCity_Gym_EventScript_TrashCan5 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 5)
}

internal object VermilionCity_Gym_EventScript_TrashCan6 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 6)
}

internal object VermilionCity_Gym_EventScript_TrashCan7 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 7)
}

internal object VermilionCity_Gym_EventScript_TrashCan8 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 8)
}

internal object VermilionCity_Gym_EventScript_TrashCan9 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 9)
}

internal object VermilionCity_Gym_EventScript_TrashCan10 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 10)
}

internal object VermilionCity_Gym_EventScript_TrashCan11 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 11)
}

internal object VermilionCity_Gym_EventScript_TrashCan12 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 12)
}

internal object VermilionCity_Gym_EventScript_TrashCan13 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 13)
}

internal object VermilionCity_Gym_EventScript_TrashCan14 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 14)
}

internal object VermilionCity_Gym_EventScript_TrashCan15 : Script {
  override suspend fun run(ctx: ScriptContext) = searchTrashCan(ctx, 15)
}

internal val VermilionCity_GymScripts: Map<String, Script> =
    mapOf(
        "VermilionCity_Gym_OnTransition" to VermilionCity_Gym_OnTransition,
        "VermilionCity_Gym_EventScript_LtSurge" to VermilionCity_Gym_EventScript_LtSurge,
        "VermilionCity_Gym_EventScript_DefeatedLtSurge" to
            VermilionCity_Gym_EventScript_DefeatedLtSurge,
        "VermilionCity_Gym_EventScript_GiveTM34" to VermilionCity_Gym_EventScript_GiveTM34,
        "VermilionCity_Gym_EventScript_Baily" to VermilionCity_Gym_EventScript_Baily,
        "VermilionCity_Gym_EventScript_Dwayne" to VermilionCity_Gym_EventScript_Dwayne,
        "VermilionCity_Gym_EventScript_GymGuy" to VermilionCity_Gym_EventScript_GymGuy,
        "VermilionCity_Gym_EventScript_Tucker" to VermilionCity_Gym_EventScript_Tucker,
        "VermilionCity_Gym_EventScript_GymStatue" to VermilionCity_Gym_EventScript_GymStatue,
        "VermilionCity_Gym_EventScript_TrashCan1" to VermilionCity_Gym_EventScript_TrashCan1,
        "VermilionCity_Gym_EventScript_TrashCan2" to VermilionCity_Gym_EventScript_TrashCan2,
        "VermilionCity_Gym_EventScript_TrashCan3" to VermilionCity_Gym_EventScript_TrashCan3,
        "VermilionCity_Gym_EventScript_TrashCan4" to VermilionCity_Gym_EventScript_TrashCan4,
        "VermilionCity_Gym_EventScript_TrashCan5" to VermilionCity_Gym_EventScript_TrashCan5,
        "VermilionCity_Gym_EventScript_TrashCan6" to VermilionCity_Gym_EventScript_TrashCan6,
        "VermilionCity_Gym_EventScript_TrashCan7" to VermilionCity_Gym_EventScript_TrashCan7,
        "VermilionCity_Gym_EventScript_TrashCan8" to VermilionCity_Gym_EventScript_TrashCan8,
        "VermilionCity_Gym_EventScript_TrashCan9" to VermilionCity_Gym_EventScript_TrashCan9,
        "VermilionCity_Gym_EventScript_TrashCan10" to VermilionCity_Gym_EventScript_TrashCan10,
        "VermilionCity_Gym_EventScript_TrashCan11" to VermilionCity_Gym_EventScript_TrashCan11,
        "VermilionCity_Gym_EventScript_TrashCan12" to VermilionCity_Gym_EventScript_TrashCan12,
        "VermilionCity_Gym_EventScript_TrashCan13" to VermilionCity_Gym_EventScript_TrashCan13,
        "VermilionCity_Gym_EventScript_TrashCan14" to VermilionCity_Gym_EventScript_TrashCan14,
        "VermilionCity_Gym_EventScript_TrashCan15" to VermilionCity_Gym_EventScript_TrashCan15,
    )
