package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Route25_SeaCottage
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_DOWN
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_RIGHT
import de.fiereu.openmmo.server.game.script.MovementStep.WALK_UP
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

// Decomp local ids of this map's object events.
private const val LOCALID_BILL_HUMAN = 0
private const val LOCALID_BILL_CLEFAIRY = 1

// The decomp names two FLAG_TEMP_* for this map, which the source game clears when the player
// leaves it. Story flags here are persistent, so the transition script clears them on the way in
// instead, which the player cannot tell apart.
private const val BILL_IN_TELEPORTER = KantoFlags.FLAG_TEMP_2
private const val RETURN_AFTER_SS_TICKET = KantoFlags.FLAG_TEMP_3

internal object Route25_SeaCottage_OnTransition : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.clearFlag(BILL_IN_TELEPORTER)
    ctx.clearFlag(RETURN_AFTER_SS_TICKET)
    if (!ctx.isFlagSet(KantoFlags.FLAG_HELPED_BILL_IN_SEA_COTTAGE)) {
      // He is stuck as a Clefairy until the separator runs.
      ctx.clearFlag(KantoFlags.FLAG_HIDE_BILL_CLEFAIRY)
      ctx.repositionNpc(LOCALID_BILL_HUMAN, 3, 3)
    }
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_SS_TICKET)) ctx.setFlag(RETURN_AFTER_SS_TICKET)
  }
}

internal object Route25_SeaCottage_EventScript_Bill : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(RETURN_AFTER_SS_TICKET)) {
      return ctx.say(Route25_SeaCottage.CheckOutRareMonsOnPC)
    }
    if (ctx.isFlagSet(KantoFlags.FLAG_GOT_SS_TICKET)) {
      return ctx.say(Route25_SeaCottage.SSAnnePartyYouGoInstead)
    }
    if (ctx.isFlagSet(KantoFlags.FLAG_HELPED_BILL_IN_SEA_COTTAGE)) {
      return giveSSTicket(ctx)
    }
    askForHelp(ctx)
  }
}

/** Bill the Clefairy asks to be put back through the teleporter. Saying no only delays him. */
private suspend fun askForHelp(ctx: ScriptContext) {
  val plea =
      if (ctx.isFemale) Route25_SeaCottage.ImBillHelpMeOutLady
      else Route25_SeaCottage.ImBillHelpMeOutPal
  if (!ctx.askYesNo(plea)) {
    // The decomp returns from the refusal and carries on as if the player had said yes.
    ctx.say(
        if (ctx.isFemale) Route25_SeaCottage.NoPleaseBeautiful
        else Route25_SeaCottage.NoPleaseChief)
  }
  ctx.say(Route25_SeaCottage.RunCellSeparationOnPC)
  // BillWalkToTeleporter then BillEnterTeleporter. The decomp has a longer path for a player
  // standing south of him and door animations around the last step, neither of which is portable.
  ctx.moveNpc(LOCALID_BILL_CLEFAIRY, WALK_UP, WALK_UP, WALK_UP)
  ctx.removeNpc(LOCALID_BILL_CLEFAIRY)
  ctx.setFlag(BILL_IN_TELEPORTER)
}

private suspend fun giveSSTicket(ctx: ScriptContext) {
  ctx.say(
      if (ctx.isFemale) Route25_SeaCottage.ThanksLadyTakeThis
      else Route25_SeaCottage.ThanksBudTakeThis)
  if (!ctx.giveItem(Items.SS_TICKET)) {
    return ctx.say(Route25_SeaCottage.YouveGotTooMuchStuff)
  }
  ctx.say(Route25_SeaCottage.ReceivedSSTicketFromBill)
  ctx.setFlag(KantoFlags.FLAG_GOT_SS_TICKET_DUP)
  // The Rocket at the top of Nugget Bridge packs up once the ticket is handed over.
  ctx.setFlag(KantoFlags.FLAG_HIDE_NUGGET_BRIDGE_ROCKET)
  ctx.setFlag(KantoFlags.FLAG_GOT_SS_TICKET)
  ctx.setFlag(KantoFlags.FLAG_SYS_NOT_SOMEONES_PC)
  ctx.say(Route25_SeaCottage.SSAnnePartyYouGoInstead)
}

internal object Route25_SeaCottage_EventScript_Computer : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(RETURN_AFTER_SS_TICKET)) {
      // The decomp opens Bill's own boxes here, which needs the client's PC screen.
      return ctx.sign(Route25_SeaCottage.BillsFavoriteMonList)
    }
    if (!ctx.isFlagSet(BILL_IN_TELEPORTER)) {
      return ctx.sign(Route25_SeaCottage.TeleporterIsDisplayed)
    }
    ctx.sign(Route25_SeaCottage.InitiatedTeleportersCellSeparator)
    ctx.clearFlag(BILL_IN_TELEPORTER)
    ctx.setFlag(KantoFlags.FLAG_HELPED_BILL_IN_SEA_COTTAGE)
    // The camera pan across the teleporters, the door animations and the beeps have no verbs, so
    // Bill simply steps out as himself and walks back into the room.
    ctx.showNpcAt(LOCALID_BILL_HUMAN, 3, 3)
    ctx.clearFlag(KantoFlags.FLAG_HIDE_BILL_HUMAN_SEA_COTTAGE)
    // BillExitTeleporter then BillWalkToMiddleOfRoom, which lands him on his map position.
    ctx.moveNpc(
        LOCALID_BILL_HUMAN,
        WALK_DOWN,
        WALK_RIGHT,
        WALK_RIGHT,
        WALK_RIGHT,
        WALK_RIGHT,
        WALK_DOWN,
        WALK_DOWN,
    )
  }
}

internal val Route25_SeaCottageScripts: Map<String, Script> =
    mapOf(
        "Route25_SeaCottage_OnTransition" to Route25_SeaCottage_OnTransition,
        "Route25_SeaCottage_EventScript_Bill" to Route25_SeaCottage_EventScript_Bill,
        "Route25_SeaCottage_EventScript_Computer" to Route25_SeaCottage_EventScript_Computer,
    )
