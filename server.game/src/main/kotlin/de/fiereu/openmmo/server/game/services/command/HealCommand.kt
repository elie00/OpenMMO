package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.server.game.services.StoryPlayerService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HealCommand @Inject constructor(private val storyPlayerService: StoryPlayerService) :
    ChatCommand {
  override val name = "heal"
  override val usage = "/heal"
  override val description = "fully heals all pokemon in your party"
  override val permission = CharacterPermissions.DEVELOPER

  override fun run(ctx: CommandContext) {
    storyPlayerService.healParty(ctx.session, ctx.state)
    ctx.reply("Party fully healed!")
  }
}
