package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.server.game.storage.CharacterStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetFlagCommand @Inject constructor(private val characterStore: CharacterStore) : ChatCommand {
  override val name = "setflag"
  override val usage = "/setflag <FLAG_NAME>"
  override val description = "sets a story flag"
  override val permission = CharacterPermissions.DEVELOPER

  override fun run(ctx: CommandContext) {
    val flag = ctx.args.firstOrNull()
    if (flag.isNullOrBlank()) {
      ctx.reply("Usage: $usage")
      return
    }
    characterStore.setStoryFlag(ctx.characterId, flag.uppercase())
    ctx.reply("Set flag $flag")
  }
}

@Singleton
class ClearFlagCommand @Inject constructor(private val characterStore: CharacterStore) :
    ChatCommand {
  override val name = "clearflag"
  override val usage = "/clearflag <FLAG_NAME>"
  override val description = "clears a story flag"
  override val permission = CharacterPermissions.DEVELOPER

  override fun run(ctx: CommandContext) {
    val flag = ctx.args.firstOrNull()
    if (flag.isNullOrBlank()) {
      ctx.reply("Usage: $usage")
      return
    }
    characterStore.clearStoryFlag(ctx.characterId, flag.uppercase())
    ctx.reply("Cleared flag $flag")
  }
}

@Singleton
class SetVarCommand @Inject constructor(private val characterStore: CharacterStore) : ChatCommand {
  override val name = "setvar"
  override val usage = "/setvar <VAR_NAME> <value>"
  override val description = "sets a story variable to an integer value"
  override val permission = CharacterPermissions.DEVELOPER

  override fun run(ctx: CommandContext) {
    val key = ctx.args.getOrNull(0)
    val value = ctx.args.getOrNull(1)?.toIntOrNull()
    if (key.isNullOrBlank() || value == null) {
      ctx.reply("Usage: $usage")
      return
    }
    characterStore.setStoryVar(ctx.characterId, key.uppercase(), value)
    ctx.reply("Set var $key = $value")
  }
}
