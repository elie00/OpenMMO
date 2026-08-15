package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.pokemon.LearnsetRegistry
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import de.fiereu.openmmo.server.game.services.StoryPlayerService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GivePkmnCommand
@Inject
constructor(
    private val storyPlayerService: StoryPlayerService,
    private val speciesRegistry: SpeciesRegistry,
    private val learnsetRegistry: LearnsetRegistry,
) : ChatCommand {
  override val name = "givepkmn"
  override val usage = "/givepkmn <dexId|name> [level]"
  override val description = "gives a pokemon directly to your party"
  override val permission = CharacterPermissions.DEVELOPER

  override fun run(ctx: CommandContext) {
    if (ctx.args.isEmpty()) {
      ctx.reply("Usage: $usage")
      return
    }

    val arg = ctx.args[0].lowercase().replace("-", "_").replace(" ", "_")
    val dexId =
        arg.toIntOrNull()
            ?: speciesRegistry.all().find {
              val formatted = it.name.lowercase().removePrefix("species_")
              formatted == arg || formatted.replace("_", "") == arg
            }?.id

    if (dexId == null || dexId <= 0) {
      ctx.reply("Unknown Pokemon: ${ctx.args[0]}")
      return
    }

    val level = (ctx.args.getOrNull(1)?.toIntOrNull() ?: 5).coerceIn(1, 100)
    val moves = learnsetRegistry.initialMoveset(dexId, level)
    val pokemon = storyPlayerService.givePokemon(ctx.session, ctx.state, dexId, level, moves)

    if (pokemon != null) {
      val name = speciesRegistry.get(dexId)?.name?.removePrefix("SPECIES_") ?: "#$dexId"
      ctx.reply("Added Lv.$level $name to your party!")
    } else {
      ctx.reply("Failed to give Pokemon (party might be full).")
    }
  }
}
