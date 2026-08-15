package de.fiereu.openmmo.server.game.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import de.fiereu.openmmo.server.game.services.command.CatchCommand
import de.fiereu.openmmo.server.game.services.command.ChatCommand
import de.fiereu.openmmo.server.game.services.command.ClearFlagCommand
import de.fiereu.openmmo.server.game.services.command.GivePkmnCommand
import de.fiereu.openmmo.server.game.services.command.HealCommand
import de.fiereu.openmmo.server.game.services.command.HelpCommand
import de.fiereu.openmmo.server.game.services.command.ItemCommand
import de.fiereu.openmmo.server.game.services.command.MoneyCommand
import de.fiereu.openmmo.server.game.services.command.PosCommand
import de.fiereu.openmmo.server.game.services.command.SetFlagCommand
import de.fiereu.openmmo.server.game.services.command.SetVarCommand
import de.fiereu.openmmo.server.game.services.command.TestBattleCommand
import de.fiereu.openmmo.server.game.services.command.TpCommand

/**
 * A name must not start with a client side command. The client resolves those itself and never
 * sends them, which is why there is a /pos and no /where, which /w would have swallowed.
 */
@Module
interface ChatCommandModule {
  @Binds @IntoSet fun helpCommand(command: HelpCommand): ChatCommand

  @Binds @IntoSet fun posCommand(command: PosCommand): ChatCommand

  @Binds @IntoSet fun testBattleCommand(command: TestBattleCommand): ChatCommand

  @Binds @IntoSet fun catchCommand(command: CatchCommand): ChatCommand

  @Binds @IntoSet fun healCommand(command: HealCommand): ChatCommand

  @Binds @IntoSet fun itemCommand(command: ItemCommand): ChatCommand

  @Binds @IntoSet fun givePkmnCommand(command: GivePkmnCommand): ChatCommand

  @Binds @IntoSet fun moneyCommand(command: MoneyCommand): ChatCommand

  @Binds @IntoSet fun tpCommand(command: TpCommand): ChatCommand

  @Binds @IntoSet fun setFlagCommand(command: SetFlagCommand): ChatCommand

  @Binds @IntoSet fun clearFlagCommand(command: ClearFlagCommand): ChatCommand

  @Binds @IntoSet fun setVarCommand(command: SetVarCommand): ChatCommand
}
