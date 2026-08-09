package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.ThreeIsland
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * goto_if_set FLAG_GOT_FULL_RESTORE_FROM_THREE_ISLAND_DEFENDER, ThreeIsland_EventScript_AntiBiker1GotFullRestore
 * goto_if_eq VAR_MAP_SCENE_THREE_ISLAND, 4, ThreeIsland_EventScript_GiveFullRestore
 * setvar VAR_TEMP_1, 0
 * call ThreeIsland_EventScript_BikerArgumentScene
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_AntiBiker1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_EventScript_AntiBiker1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * goto_if_eq VAR_MAP_SCENE_THREE_ISLAND, 4, ThreeIsland_EventScript_AntiBiker2BikersGone
 * setvar VAR_TEMP_1, 1
 * call ThreeIsland_EventScript_BikerArgumentScene
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_AntiBiker2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_EventScript_AntiBiker2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * setvar VAR_TEMP_1, 2
 * call ThreeIsland_EventScript_BikerArgumentScene
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_Biker : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_EventScript_Biker")
}

/**
 * Ported from the decomp:
 * ```
 * finditem ITEM_ZINC
 * end
 * ```
 */
internal object ThreeIsland_EventScript_ItemZinc : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.findItem(Items.ZINC, KantoFlags.FLAG_HIDE_THREE_ISLAND_ZINC, 9)
  }
}

internal object ThreeIsland_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(ThreeIsland.WouldntWantToSeeBikersHereAgain)
}

internal object ThreeIsland_EventScript_LittleBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(ThreeIsland.WhenDodouEvolvesGoingToPlayGame)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * waitse
 * playmoncry SPECIES_DODUO, CRY_MODE_NORMAL
 * msgbox ThreeIsland_Text_Doduo
 * waitmoncry
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_Doduo : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_EventScript_Doduo")
}

internal object ThreeIsland_EventScript_Biker6 : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.say(ThreeIsland.IslandBelongsToUs)
}

internal object ThreeIsland_EventScript_IslandSign : Script {
  override suspend fun run(ctx: ScriptContext) = ctx.sign(ThreeIsland.IslandSign)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_TEMP_1, 1, ThreeIsland_EventScript_PlayerFaceLeft
 * call_if_eq VAR_TEMP_1, 2, ThreeIsland_EventScript_PlayerFaceLeft
 * applymovement LOCALID_THREE_ISLAND_ANTIBIKER1, ThreeIsland_Movement_SpeakRight
 * waitmovement 0
 * msgbox ThreeIsland_Text_GoBackToKanto
 * call_if_eq VAR_TEMP_1, 0, ThreeIsland_EventScript_PlayerFaceRight
 * call_if_eq VAR_TEMP_1, 1, ThreeIsland_EventScript_PlayerFaceRight
 * call_if_eq VAR_TEMP_1, 2, ThreeIsland_EventScript_PlayerFaceBiker
 * applymovement LOCALID_THREE_ISLAND_BIKER1, ThreeIsland_Movement_SpeakLeft
 * waitmovement 0
 * msgbox ThreeIsland_Text_BossIsOnHisWay
 * call_if_eq VAR_TEMP_1, 0, ThreeIsland_EventScript_PlayerFaceUp
 * call_if_eq VAR_TEMP_1, 1, ThreeIsland_EventScript_PlayerFaceUp
 * call_if_eq VAR_TEMP_1, 2, ThreeIsland_EventScript_PlayerFaceAntiBiker
 * applymovement LOCALID_THREE_ISLAND_ANTIBIKER2, ThreeIsland_Movement_SpeakRight
 * waitmovement 0
 * msgbox ThreeIsland_Text_GetOffIslandNow
 * call_if_eq VAR_TEMP_1, 0, ThreeIsland_EventScript_PlayerFaceRight
 * call_if_eq VAR_TEMP_1, 1, ThreeIsland_EventScript_PlayerFaceRight
 * call_if_eq VAR_TEMP_1, 2, ThreeIsland_EventScript_PlayerFaceBiker
 * applymovement LOCALID_THREE_ISLAND_BIKER3, ThreeIsland_Movement_SpeakLeft
 * waitmovement 0
 * msgbox ThreeIsland_Text_WhosGonnaMakeMe
 * return
 * ```
 */
internal object ThreeIsland_EventScript_BikerArgumentScene : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_BikerArgumentScene")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_THREE_ISLAND_ANTIBIKER1, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox ThreeIsland_Text_YouveGotImpressiveMons
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_AntiBiker1GotFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_AntiBiker1GotFullRestore")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_THREE_ISLAND_ANTIBIKER1, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox ThreeIsland_Text_ThankYouOhYourMonGotHurt
 * checkitemspace ITEM_FULL_RESTORE
 * goto_if_eq VAR_RESULT, FALSE, ThreeIsland_EventScript_NoRoomForFullRestore
 * msgreceiveditem ThreeIsland_Text_GivenFullRestore, ITEM_FULL_RESTORE
 * additem ITEM_FULL_RESTORE
 * setflag FLAG_GOT_FULL_RESTORE_FROM_THREE_ISLAND_DEFENDER
 * msgbox ThreeIsland_Text_YouveGotImpressiveMons
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_GiveFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_GiveFullRestore")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_THREE_ISLAND_ANTIBIKER2, Common_Movement_FacePlayer
 * waitmovement 0
 * msgbox ThreeIsland_Text_LostelleWentOffTowardsBondBridge
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_AntiBiker2BikersGone : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_AntiBiker2BikersGone")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterRight
 * waitmovement 0
 * return
 * ```
 */
internal object ThreeIsland_EventScript_PlayerFaceRight : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_PlayerFaceRight")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * getplayerxy VAR_0x8004, VAR_0x8005
 * goto_if_ge VAR_0x8004, 9, ThreeIsland_EventScript_PlayerFaceUp
 * goto ThreeIsland_EventScript_PlayerFaceRight
 * end
 * ```
 */
internal object ThreeIsland_EventScript_PlayerFaceBiker : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_PlayerFaceBiker")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ThreeIsland_Text_OhYourBagIsFull
 * release
 * end
 * ```
 */
internal object ThreeIsland_EventScript_NoRoomForFullRestore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ThreeIsland.OhYourBagIsFull)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * getplayerxy VAR_0x8004, VAR_0x8005
 * goto_if_ge VAR_0x8004, 9, ThreeIsland_EventScript_PlayerFaceLeft
 * goto ThreeIsland_EventScript_PlayerFaceUp
 * end
 * ```
 */
internal object ThreeIsland_EventScript_PlayerFaceAntiBiker : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ThreeIsland_EventScript_PlayerFaceAntiBiker")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterLeft
 * waitmovement 0
 * return
 * ```
 */
internal object ThreeIsland_EventScript_PlayerFaceLeft : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_EventScript_PlayerFaceLeft")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * applymovement LOCALID_PLAYER, Common_Movement_WalkInPlaceFasterUp
 * waitmovement 0
 * return
 * ```
 */
internal object ThreeIsland_EventScript_PlayerFaceUp : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ThreeIsland_EventScript_PlayerFaceUp")
}

internal val ThreeIslandScripts: Map<String, Script> =
    mapOf(
        "ThreeIsland_EventScript_AntiBiker1" to ThreeIsland_EventScript_AntiBiker1,
        "ThreeIsland_EventScript_AntiBiker2" to ThreeIsland_EventScript_AntiBiker2,
        "ThreeIsland_EventScript_Biker" to ThreeIsland_EventScript_Biker,
        "ThreeIsland_EventScript_ItemZinc" to ThreeIsland_EventScript_ItemZinc,
        "ThreeIsland_EventScript_Woman" to ThreeIsland_EventScript_Woman,
        "ThreeIsland_EventScript_LittleBoy" to ThreeIsland_EventScript_LittleBoy,
        "ThreeIsland_EventScript_Doduo" to ThreeIsland_EventScript_Doduo,
        "ThreeIsland_EventScript_Biker6" to ThreeIsland_EventScript_Biker6,
        "ThreeIsland_EventScript_IslandSign" to ThreeIsland_EventScript_IslandSign,
        "ThreeIsland_EventScript_BikerArgumentScene" to ThreeIsland_EventScript_BikerArgumentScene,
        "ThreeIsland_EventScript_AntiBiker1GotFullRestore" to
            ThreeIsland_EventScript_AntiBiker1GotFullRestore,
        "ThreeIsland_EventScript_GiveFullRestore" to ThreeIsland_EventScript_GiveFullRestore,
        "ThreeIsland_EventScript_AntiBiker2BikersGone" to
            ThreeIsland_EventScript_AntiBiker2BikersGone,
        "ThreeIsland_EventScript_PlayerFaceRight" to ThreeIsland_EventScript_PlayerFaceRight,
        "ThreeIsland_EventScript_PlayerFaceBiker" to ThreeIsland_EventScript_PlayerFaceBiker,
        "ThreeIsland_EventScript_NoRoomForFullRestore" to
            ThreeIsland_EventScript_NoRoomForFullRestore,
        "ThreeIsland_EventScript_PlayerFaceAntiBiker" to
            ThreeIsland_EventScript_PlayerFaceAntiBiker,
        "ThreeIsland_EventScript_PlayerFaceLeft" to ThreeIsland_EventScript_PlayerFaceLeft,
        "ThreeIsland_EventScript_PlayerFaceUp" to ThreeIsland_EventScript_PlayerFaceUp,
    )
