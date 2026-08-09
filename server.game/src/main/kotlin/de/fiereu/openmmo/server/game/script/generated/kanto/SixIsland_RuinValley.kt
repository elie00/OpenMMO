package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SixIsland_RuinValley
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

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

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_STANLY, SixIsland_RuinValley_Text_StanlyIntro, SixIsland_RuinValley_Text_StanlyDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_RuinValley_EventScript_StanlyRematch
 * msgbox SixIsland_RuinValley_Text_StanlyPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_Stanly : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_STANLY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_RuinValley_EventScript_StanlyRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_RuinValley.StanlyPostBattle)
    }
    ctx.say(SixIsland_RuinValley.StanlyIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_RuinValley.StanlyDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_FOSTER, SixIsland_RuinValley_Text_FosterIntro, SixIsland_RuinValley_Text_FosterDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_RuinValley_EventScript_FosterRematch
 * msgbox SixIsland_RuinValley_Text_FosterPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_Foster : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_FOSTER
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_RuinValley_EventScript_FosterRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_RuinValley.FosterPostBattle)
    }
    ctx.say(SixIsland_RuinValley.FosterIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_RuinValley.FosterDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_RUIN_MANIAC_LARRY, SixIsland_RuinValley_Text_LarryIntro, SixIsland_RuinValley_Text_LarryDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_RuinValley_EventScript_LarryRematch
 * msgbox SixIsland_RuinValley_Text_LarryPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_Larry : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_RUIN_MANIAC_LARRY
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_RuinValley_EventScript_LarryRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_RuinValley.LarryPostBattle)
    }
    ctx.say(SixIsland_RuinValley.LarryIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_RuinValley.LarryDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_HIKER_DARYL, SixIsland_RuinValley_Text_DarylIntro, SixIsland_RuinValley_Text_DarylDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_RuinValley_EventScript_DarylRematch
 * msgbox SixIsland_RuinValley_Text_DarylPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_Daryl : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_HIKER_DARYL
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_RuinValley_EventScript_DarylRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_RuinValley.DarylPostBattle)
    }
    ctx.say(SixIsland_RuinValley.DarylIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_RuinValley.DarylDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_POKEMANIAC_HECTOR, SixIsland_RuinValley_Text_HectorIntro, SixIsland_RuinValley_Text_HectorDefeat
 * specialvar VAR_RESULT, ShouldTryRematchBattle
 * goto_if_eq VAR_RESULT, TRUE, SixIsland_RuinValley_EventScript_HectorRematch
 * msgbox SixIsland_RuinValley_Text_HectorPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_Hector : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_POKEMANIAC_HECTOR
    if (ctx.hasBeatenTrainer(trainerId)) {
      // TODO Offer the rematch (SixIsland_RuinValley_EventScript_HectorRematch)
      //  The decomp asks ShouldTryRematchBattle here. There is no rematch model and
      //  no VS Seeker, so this takes the branch a fresh save takes.
      return ctx.say(SixIsland_RuinValley.HectorPostBattle)
    }
    ctx.say(SixIsland_RuinValley.HectorIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SixIsland_RuinValley.HectorDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_HP_UP
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_ItemHPUp : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.HP_UP, KantoFlags.FLAG_HIDE_SIX_ISLAND_RUIN_VALLEY_HP_UP, 14)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_FULL_RESTORE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_ItemFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.FULL_RESTORE, KantoFlags.FLAG_HIDE_SIX_ISLAND_RUIN_VALLEY_FULL_RESTORE, 15)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_SUN_STONE
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_ItemSunStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.SUN_STONE, KantoFlags.FLAG_HIDE_SIX_ISLAND_RUIN_VALLEY_SUN_STONE, 16)
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

/**
 * Ported from the decomp:
 * ```
 * msgbox SixIsland_RuinValley_Text_LeftDoorAlone
 * releaseall
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_IgnoreDottedHoleDoor : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SixIsland_RuinValley.LeftDoorAlone)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SixIsland_RuinValley_Text_DoorIsOpen
 * releaseall
 * end
 * ```
 */
internal object SixIsland_RuinValley_EventScript_DottedHoleDoorOpen : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SixIsland_RuinValley.DoorIsOpen)
  }
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
        "SixIsland_RuinValley_EventScript_IgnoreDottedHoleDoor" to
            SixIsland_RuinValley_EventScript_IgnoreDottedHoleDoor,
        "SixIsland_RuinValley_EventScript_DottedHoleDoorOpen" to
            SixIsland_RuinValley_EventScript_DottedHoleDoorOpen,
    )
