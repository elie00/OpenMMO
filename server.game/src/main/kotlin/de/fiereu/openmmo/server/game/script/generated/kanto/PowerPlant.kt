package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.battle.BattleResult
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

private const val ZAPDOS = 145
private const val ZAPDOS_LEVEL = 50
private const val ELECTRODE = 101
private const val ELECTRODE_LEVEL = 34

// Decomp local ids of this map's object events.
private const val LOCALID_ZAPDOS = 5
private const val LOCALID_ELECTRODE2 = 6
private const val LOCALID_ELECTRODE1 = 7

internal object PowerPlant_EventScript_ItemMaxPotion : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.MAX_POTION)) return
    ctx.removeNpc(0)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_MAX_POTION)
  }
}

internal object PowerPlant_EventScript_ItemTM17 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM17)) return
    ctx.removeNpc(1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_TM17)
  }
}

internal object PowerPlant_EventScript_ItemTM25 : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.TM25)) return
    ctx.removeNpc(2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_TM25)
  }
}

internal object PowerPlant_EventScript_ItemThunderStone : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.THUNDER_STONE)) return
    ctx.removeNpc(3)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_THUNDER_STONE)
  }
}

internal object PowerPlant_EventScript_ItemElixir : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.giveItem(Items.ELIXIR)) return
    ctx.removeNpc(4)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_ELIXIR)
  }
}

/**
 * The bird at the back of the plant. StartLegendaryBattle is a wild battle the player may catch or
 * run from, which is what [ScriptContext.legendaryBattle] is, and either way it leaves the room.
 */
internal object PowerPlant_EventScript_Zapdos : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.sign(Misc.Text_Gyaoo)
    val outcome = ctx.legendaryBattle(ZAPDOS, ZAPDOS_LEVEL)
    ctx.removeNpc(LOCALID_ZAPDOS)
    ctx.setFlag(KantoFlags.FLAG_HIDE_ZAPDOS)
    if (outcome == BattleResult.VICTORY || outcome == BattleResult.CAUGHT) {
      return ctx.setFlag(KantoFlags.FLAG_FOUGHT_ZAPDOS)
    }
    // Running from it, or blacking out, and it is gone from the room all the same.
    ctx.sign(Misc.Text_MonFlewAway)
  }
}

/** One of the two Electrode posing as machinery, catchable like the bird. */
internal object PowerPlant_EventScript_Electrode2 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.legendaryBattle(ELECTRODE, ELECTRODE_LEVEL)
    ctx.removeNpc(LOCALID_ELECTRODE2)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_ELECTRODE_2)
  }
}

/** One of the two Electrode posing as machinery, catchable like the bird. */
internal object PowerPlant_EventScript_Electrode1 : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.legendaryBattle(ELECTRODE, ELECTRODE_LEVEL)
    ctx.removeNpc(LOCALID_ELECTRODE1)
    ctx.setFlag(KantoFlags.FLAG_HIDE_POWER_PLANT_ELECTRODE_1)
  }
}

internal val PowerPlantScripts: Map<String, Script> =
    mapOf(
        "PowerPlant_EventScript_ItemMaxPotion" to PowerPlant_EventScript_ItemMaxPotion,
        "PowerPlant_EventScript_ItemTM17" to PowerPlant_EventScript_ItemTM17,
        "PowerPlant_EventScript_ItemTM25" to PowerPlant_EventScript_ItemTM25,
        "PowerPlant_EventScript_ItemThunderStone" to PowerPlant_EventScript_ItemThunderStone,
        "PowerPlant_EventScript_ItemElixir" to PowerPlant_EventScript_ItemElixir,
        "PowerPlant_EventScript_Zapdos" to PowerPlant_EventScript_Zapdos,
        "PowerPlant_EventScript_Electrode2" to PowerPlant_EventScript_Electrode2,
        "PowerPlant_EventScript_Electrode1" to PowerPlant_EventScript_Electrode1,
    )
