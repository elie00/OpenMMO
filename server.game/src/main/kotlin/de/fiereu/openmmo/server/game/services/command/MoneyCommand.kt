package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.net.game.packets.LocalCharacterDeltaPacket
import de.fiereu.openmmo.server.game.storage.CharacterStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoneyCommand @Inject constructor(private val characterStore: CharacterStore) : ChatCommand {
  override val name = "money"
  override val usage = "/money <amount>"
  override val description = "adds or subtracts pokédollars"
  override val permission = CharacterPermissions.DEVELOPER

  override fun run(ctx: CommandContext) {
    val amount = ctx.args.firstOrNull()?.toIntOrNull()
    if (amount == null) {
      ctx.reply("Usage: $usage")
      return
    }

    if (!characterStore.addMoney(ctx.characterId, amount)) {
      ctx.reply("Transaction failed: cannot reduce money below 0.")
      return
    }

    val updated = characterStore.getCharacter(ctx.characterId)?.info?.money ?: 0
    ctx.session.send(LocalCharacterDeltaPacket(money = updated))
    ctx.reply("Updated money. Current balance: ¥$updated")
  }
}
