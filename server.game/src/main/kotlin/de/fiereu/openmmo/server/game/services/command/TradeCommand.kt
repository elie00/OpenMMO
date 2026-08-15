package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.server.game.services.TradeService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TradeCommand
@Inject
constructor(
    private val tradeService: TradeService,
) : ChatCommand {
  override val name = "trade"
  override val usage = "/trade <player>"
  override val description = "trade with another online player"
  override val permission = 0

  override fun run(ctx: CommandContext) {
    val target = ctx.args.firstOrNull()
    if (target.isNullOrBlank()) {
      ctx.reply("Usage: $usage")
      return
    }
    tradeService.requestTrade(ctx.session, target)
  }
}
