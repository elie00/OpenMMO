package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.ShoalCave_LowTideEntranceRoom
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags
import de.fiereu.openmmo.story.generated.hoenn.HoennVars

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_BIG_PEARL
 * end
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_ItemBigPearl : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.BIG_PEARL, HoennFlags.FLAG_ITEM_SHOAL_CAVE_ENTRANCE_BIG_PEARL, 0)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * dotimebasedevents
 * call_if_set FLAG_SYS_SHOAL_ITEM, ShoalCave_LowTideEntranceRoom_EventScript_ResetShoalItems
 * checkitem ITEM_SHOAL_SALT, 4
 * goto_if_eq VAR_RESULT, FALSE, ShoalCave_LowTideEntranceRoom_EventScript_NotEnoughShoalSaltOrShells
 * checkitem ITEM_SHOAL_SHELL, 4
 * goto_if_eq VAR_RESULT, FALSE, ShoalCave_LowTideEntranceRoom_EventScript_NotEnoughShoalSaltOrShells
 * msgbox ShoalCave_LowTideEntranceRoom_Text_WouldYouLikeShellBell, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, ShoalCave_LowTideEntranceRoom_EventScript_DeclineShellBell
 * checkitemspace ITEM_SHELL_BELL
 * call_if_eq VAR_RESULT, FALSE, ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreed
 * goto_if_eq VAR_RESULT, 2, ShoalCave_LowTideEntranceRoom_EventScript_NoRoomForShellBell
 * msgbox ShoalCave_LowTideEntranceRoom_Text_MakeShellBellRightAway, MSGBOX_DEFAULT
 * removeitem ITEM_SHOAL_SALT, 4
 * removeitem ITEM_SHOAL_SHELL, 4
 * giveitem ITEM_SHELL_BELL
 * goto_if_eq VAR_RESULT, FALSE, Common_EventScript_ShowBagIsFull  @ Never FALSE, we already made sure there will be room in the bag.
 * msgbox ShoalCave_LowTideEntranceRoom_Text_ExplainShellBell, MSGBOX_DEFAULT
 * setflag FLAG_TEMP_2  @ Not read. Perhaps meant to stop him from re-explaining the Shell Bell if multiple are received in one sitting.
 * release
 * end
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_ShellBellExpert : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ShoalCave_LowTideEntranceRoom_EventScript_ShellBellExpert")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ShoalCave_LowTideEntranceRoom_Text_NoSpaceInYourBag, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_NoRoomForShellBell : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ShoalCave_LowTideEntranceRoom.NoSpaceInYourBag)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_SHOAL_SALT
 * goto_if_eq VAR_RESULT, TRUE, ShoalCave_LowTideEntranceRoom_EventScript_HasSomeShoalSaltOrShell
 * checkitem ITEM_SHOAL_SHELL
 * goto_if_eq VAR_RESULT, TRUE, ShoalCave_LowTideEntranceRoom_EventScript_HasSomeShoalSaltOrShell
 * msgbox ShoalCave_LowTideEntranceRoom_Text_AreYouPlanningOnGoingInThere, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_NotEnoughShoalSaltOrShells : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ShoalCave_LowTideEntranceRoom_EventScript_NotEnoughShoalSaltOrShells")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ShoalCave_LowTideEntranceRoom_Text_WantedToMakeShellBell, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_DeclineShellBell : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ShoalCave_LowTideEntranceRoom.WantedToMakeShellBell)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * clearflag FLAG_RECEIVED_SHOAL_SALT_1
 * clearflag FLAG_RECEIVED_SHOAL_SALT_2
 * clearflag FLAG_RECEIVED_SHOAL_SALT_3
 * clearflag FLAG_RECEIVED_SHOAL_SALT_4
 * clearflag FLAG_RECEIVED_SHOAL_SHELL_1
 * clearflag FLAG_RECEIVED_SHOAL_SHELL_2
 * clearflag FLAG_RECEIVED_SHOAL_SHELL_3
 * clearflag FLAG_RECEIVED_SHOAL_SHELL_4
 * clearflag FLAG_SYS_SHOAL_ITEM
 * return
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_ResetShoalItems : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ShoalCave_LowTideEntranceRoom_EventScript_ResetShoalItems")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_SHOAL_SALT, 5
 * goto_if_eq VAR_RESULT, TRUE, ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreedShells
 * return
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreed : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreed")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ShoalCave_LowTideEntranceRoom_Text_BringMe4ShoalSaltAndShells, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_HasSomeShoalSaltOrShell : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ShoalCave_LowTideEntranceRoom.BringMe4ShoalSaltAndShells)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * checkitem ITEM_SHOAL_SHELL, 5
 * goto_if_eq VAR_RESULT, TRUE, ShoalCave_LowTideEntranceRoom_EventScript_NoSpaceWillBeFreed
 * return
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreedShells : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreedShells")
}

/**
 * Ported from the decomp:
 * ```
 * setvar VAR_RESULT, 2
 * return
 * ```
 */
internal object ShoalCave_LowTideEntranceRoom_EventScript_NoSpaceWillBeFreed : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.setVar(HoennVars.VAR_RESULT, 2)
  }
}

internal val ShoalCave_LowTideEntranceRoomScripts: Map<String, Script> =
    mapOf(
        "ShoalCave_LowTideEntranceRoom_EventScript_ItemBigPearl" to
            ShoalCave_LowTideEntranceRoom_EventScript_ItemBigPearl,
        "ShoalCave_LowTideEntranceRoom_EventScript_ShellBellExpert" to
            ShoalCave_LowTideEntranceRoom_EventScript_ShellBellExpert,
        "ShoalCave_LowTideEntranceRoom_EventScript_NoRoomForShellBell" to
            ShoalCave_LowTideEntranceRoom_EventScript_NoRoomForShellBell,
        "ShoalCave_LowTideEntranceRoom_EventScript_NotEnoughShoalSaltOrShells" to
            ShoalCave_LowTideEntranceRoom_EventScript_NotEnoughShoalSaltOrShells,
        "ShoalCave_LowTideEntranceRoom_EventScript_DeclineShellBell" to
            ShoalCave_LowTideEntranceRoom_EventScript_DeclineShellBell,
        "ShoalCave_LowTideEntranceRoom_EventScript_ResetShoalItems" to
            ShoalCave_LowTideEntranceRoom_EventScript_ResetShoalItems,
        "ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreed" to
            ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreed,
        "ShoalCave_LowTideEntranceRoom_EventScript_HasSomeShoalSaltOrShell" to
            ShoalCave_LowTideEntranceRoom_EventScript_HasSomeShoalSaltOrShell,
        "ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreedShells" to
            ShoalCave_LowTideEntranceRoom_EventScript_CheckSpaceWillBeFreedShells,
        "ShoalCave_LowTideEntranceRoom_EventScript_NoSpaceWillBeFreed" to
            ShoalCave_LowTideEntranceRoom_EventScript_NoSpaceWillBeFreed,
    )
