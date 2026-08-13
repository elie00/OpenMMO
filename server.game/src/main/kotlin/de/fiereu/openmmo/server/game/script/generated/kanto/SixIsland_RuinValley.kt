package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_RuinValley
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainerIds

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * msgbox SixIsland_RuinValley_Text_CantFigureOutHowToGetInside
 * applymovement LOCALID_RUIN_VALLEY_SCIENTIST, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox SixIsland_RuinValley_Text_IFoundThisPlace
 * applymovement LOCALID_RUIN_VALLEY_SCIENTIST, Common_Movement_FaceOriginalDirection
 * waitmovement 0
 * release
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_RuinValley_EventScript_Scientist")
}

internal object SixIsland_RuinValley_EventScript_Stanly : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_RUIN_MANIAC_STANLY,
          SixIsland_RuinValley.StanlyIntro,
          SixIsland_RuinValley.StanlyDefeat,
          SixIsland_RuinValley.StanlyPostBattle,
      )
}

internal object SixIsland_RuinValley_EventScript_Foster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_RUIN_MANIAC_FOSTER,
          SixIsland_RuinValley.FosterIntro,
          SixIsland_RuinValley.FosterDefeat,
          SixIsland_RuinValley.FosterPostBattle,
      )
}

internal object SixIsland_RuinValley_EventScript_Larry : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_RUIN_MANIAC_LARRY,
          SixIsland_RuinValley.LarryIntro,
          SixIsland_RuinValley.LarryDefeat,
          SixIsland_RuinValley.LarryPostBattle,
      )
}

internal object SixIsland_RuinValley_EventScript_Daryl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_HIKER_DARYL,
          SixIsland_RuinValley.DarylIntro,
          SixIsland_RuinValley.DarylDefeat,
          SixIsland_RuinValley.DarylPostBattle,
      )
}

internal object SixIsland_RuinValley_EventScript_Hector : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.trainerBattle(
          KantoTrainerIds.TRAINER_POKEMANIAC_HECTOR,
          SixIsland_RuinValley.HectorIntro,
          SixIsland_RuinValley.HectorDefeat,
          SixIsland_RuinValley.HectorPostBattle,
      )
}

internal object SixIsland_RuinValley_EventScript_ItemHPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.HP_UP)) return
    ctx.removeNpc(14)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SIX_ISLAND_RUIN_VALLEY_HP_UP)
  }
}

internal object SixIsland_RuinValley_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.FULL_RESTORE)) return
    ctx.removeNpc(15)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SIX_ISLAND_RUIN_VALLEY_FULL_RESTORE)
  }
}

internal object SixIsland_RuinValley_EventScript_ItemSunStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.SUN_STONE)) return
    ctx.removeNpc(16)
    ctx.setFlag(KantoFlags.FLAG_HIDE_SIX_ISLAND_RUIN_VALLEY_SUN_STONE)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_USED_CUT_ON_RUIN_VALLEY_BRAILLE, SixIsland_RuinValley_EventScript_DottedHoleDoorOpen
 * msgbox SixIsland_RuinValley_Text_CheckDoorMoreThoroughly, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SixIsland_RuinValley_EventScript_IgnoreDottedHoleDoor
 * msgbox SixIsland_RuinValley_Text_SeveralDotsOnTheDoor
 * braillemessage Braille_Text_Cut
 * waitbuttonpress
 * releaseall
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_DottedHoleDoor : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SixIsland_RuinValley_EventScript_DottedHoleDoor")
}

internal val SixIsland_RuinValleyScripts: Map<String, Script> =
    mapOf(
        "SixIsland_RuinValley_EventScript_Scientist" to SixIsland_RuinValley_EventScript_Scientist,
        "SixIsland_RuinValley_EventScript_Stanly" to SixIsland_RuinValley_EventScript_Stanly,
        "SixIsland_RuinValley_EventScript_Foster" to SixIsland_RuinValley_EventScript_Foster,
        "SixIsland_RuinValley_EventScript_Larry" to SixIsland_RuinValley_EventScript_Larry,
        "SixIsland_RuinValley_EventScript_Daryl" to SixIsland_RuinValley_EventScript_Daryl,
        "SixIsland_RuinValley_EventScript_Hector" to SixIsland_RuinValley_EventScript_Hector,
        "SixIsland_RuinValley_EventScript_ItemHPUp" to SixIsland_RuinValley_EventScript_ItemHPUp,
        "SixIsland_RuinValley_EventScript_ItemFullRestore" to
            SixIsland_RuinValley_EventScript_ItemFullRestore,
        "SixIsland_RuinValley_EventScript_ItemSunStone" to
            SixIsland_RuinValley_EventScript_ItemSunStone,
        "SixIsland_RuinValley_EventScript_DottedHoleDoor" to
            SixIsland_RuinValley_EventScript_DottedHoleDoor,
    )
