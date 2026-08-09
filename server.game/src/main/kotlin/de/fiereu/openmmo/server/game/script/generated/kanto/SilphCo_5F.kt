package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.SilphCo_5F
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags
import de.fiereu.openmmo.trainer.generated.KantoTrainers

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_29, SilphCo_5F_Text_Grunt2Intro, SilphCo_5F_Text_Grunt2Defeat
 * msgbox SilphCo_5F_Text_Grunt2PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Grunt2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_29
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_5F.Grunt2PostBattle)
    }
    ctx.say(SilphCo_5F.Grunt2Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_5F.Grunt2Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_JUGGLER_DALTON, SilphCo_5F_Text_DaltonIntro, SilphCo_5F_Text_DaltonDefeat
 * msgbox SilphCo_5F_Text_DaltonPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Dalton : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_JUGGLER_DALTON
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_5F.DaltonPostBattle)
    }
    ctx.say(SilphCo_5F.DaltonIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_5F.DaltonDefeat)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_ge VAR_MAP_SCENE_SILPH_CO_11F, 1, SilphCo_5F_EventScript_WorkerMRocketsGone
 * msgbox SilphCo_5F_Text_RocketsInUproarAboutIntruder
 * release
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_WorkerM : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_5F_EventScript_WorkerM")
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_SCIENTIST_BEAU, SilphCo_5F_Text_BeauIntro, SilphCo_5F_Text_BeauDefeat
 * msgbox SilphCo_5F_Text_BeauPostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Beau : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_SCIENTIST_BEAU
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_5F.BeauPostBattle)
    }
    ctx.say(SilphCo_5F.BeauIntro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_5F.BeauDefeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * trainerbattle_single TRAINER_TEAM_ROCKET_GRUNT_28, SilphCo_5F_Text_Grunt1Intro, SilphCo_5F_Text_Grunt1Defeat
 * msgbox SilphCo_5F_Text_Grunt1PostBattle, MSGBOX_AUTOCLOSE
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Grunt1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    val trainerId = KantoTrainers.TRAINER_TEAM_ROCKET_GRUNT_28
    if (ctx.hasBeatenTrainer(trainerId)) {
      return ctx.say(SilphCo_5F.Grunt1PostBattle)
    }
    ctx.say(SilphCo_5F.Grunt1Intro)
    if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return
    ctx.say(SilphCo_5F.Grunt1Defeat)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_PROTEIN
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_ItemProtein : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.PROTEIN, KantoFlags.FLAG_HIDE_SILPH_CO_5F_PROTEIN, 5)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_TM01
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_ItemTM01 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.TM01, KantoFlags.FLAG_HIDE_SILPH_CO_5F_TM01, 6)
  }
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_CARD_KEY
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_ItemCardKey : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.CARD_KEY, KantoFlags.FLAG_HIDE_SILPH_CO_5F_CARD_KEY, 7)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * famechecker FAMECHECKER_GIOVANNI, 1
 * msgbox SilphCo_5F_Text_RocketBossLookingForStrongMons
 * release
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Scientist : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_5F_EventScript_Scientist")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 7
 * setvar VAR_0x8004, FLAG_SILPH_5F_DOOR_1
 * goto_if_set FLAG_SILPH_5F_DOOR_1, EventScript_DoorUnlocked
 * goto EventScript_TryUnlockDoor
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Door1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_5F_EventScript_Door1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 8
 * setvar VAR_0x8004, FLAG_SILPH_5F_DOOR_2
 * goto_if_set FLAG_SILPH_5F_DOOR_2, EventScript_DoorUnlocked
 * goto EventScript_TryUnlockDoor
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Door2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_5F_EventScript_Door2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * setvar VAR_TEMP_1, 9
 * setvar VAR_0x8004, FLAG_SILPH_5F_DOOR_3
 * goto_if_set FLAG_SILPH_5F_DOOR_3, EventScript_DoorUnlocked
 * goto EventScript_TryUnlockDoor
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_Door3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SilphCo_5F_EventScript_Door3")
}

internal object SilphCo_5F_EventScript_PokemonReport3 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.SomeMonsEvolveWhenTraded)
}

internal object SilphCo_5F_EventScript_PokemonReport2 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.Over350TechniquesConfirmed)
}

internal object SilphCo_5F_EventScript_PokemonReport1 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.PorygonFirstVRMon)
}

internal object SilphCo_5F_EventScript_FloorSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(SilphCo_5F.FloorSign)
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SilphCo_5F_Text_YoureOurHeroThankYou
 * release
 * end
 * ```
 */
internal object SilphCo_5F_EventScript_WorkerMRocketsGone : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SilphCo_5F.YoureOurHeroThankYou)
  }
}

internal val SilphCo_5FScripts: Map<String, Script> =
    mapOf(
        "SilphCo_5F_EventScript_Grunt2" to SilphCo_5F_EventScript_Grunt2,
        "SilphCo_5F_EventScript_Dalton" to SilphCo_5F_EventScript_Dalton,
        "SilphCo_5F_EventScript_WorkerM" to SilphCo_5F_EventScript_WorkerM,
        "SilphCo_5F_EventScript_Beau" to SilphCo_5F_EventScript_Beau,
        "SilphCo_5F_EventScript_Grunt1" to SilphCo_5F_EventScript_Grunt1,
        "SilphCo_5F_EventScript_ItemProtein" to SilphCo_5F_EventScript_ItemProtein,
        "SilphCo_5F_EventScript_ItemTM01" to SilphCo_5F_EventScript_ItemTM01,
        "SilphCo_5F_EventScript_ItemCardKey" to SilphCo_5F_EventScript_ItemCardKey,
        "SilphCo_5F_EventScript_Scientist" to SilphCo_5F_EventScript_Scientist,
        "SilphCo_5F_EventScript_Door1" to SilphCo_5F_EventScript_Door1,
        "SilphCo_5F_EventScript_Door2" to SilphCo_5F_EventScript_Door2,
        "SilphCo_5F_EventScript_Door3" to SilphCo_5F_EventScript_Door3,
        "SilphCo_5F_EventScript_PokemonReport3" to SilphCo_5F_EventScript_PokemonReport3,
        "SilphCo_5F_EventScript_PokemonReport2" to SilphCo_5F_EventScript_PokemonReport2,
        "SilphCo_5F_EventScript_PokemonReport1" to SilphCo_5F_EventScript_PokemonReport1,
        "SilphCo_5F_EventScript_FloorSign" to SilphCo_5F_EventScript_FloorSign,
        "SilphCo_5F_EventScript_WorkerMRocketsGone" to SilphCo_5F_EventScript_WorkerMRocketsGone,
    )
