package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.server.game.services.StoryPlayerService
import java.lang.reflect.Modifier
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemCommand @Inject constructor(private val storyPlayerService: StoryPlayerService) :
    ChatCommand {
  override val name = "item"
  override val usage = "/item <id|name> [amount]"
  override val description = "gives items to your bag"
  override val permission = CharacterPermissions.DEVELOPER

  private val itemNamesToId: Map<String, Int> by lazy {
    Items::class
        .java
        .declaredFields
        .filter {
          Modifier.isStatic(it.modifiers) &&
              (it.type == Int::class.javaPrimitiveType || it.type == java.lang.Integer::class.java)
        }
        .associate { field ->
          val rawName = field.name.lowercase().removePrefix("item_")
          val id = field.getInt(null)
          rawName to id
        }
  }

  override fun run(ctx: CommandContext) {
    if (ctx.args.isEmpty()) {
      ctx.reply("Usage: $usage")
      return
    }

    val itemArg = ctx.args[0].lowercase().replace("-", "_").replace(" ", "_")
    val itemId =
        itemArg.toIntOrNull()
            ?: itemNamesToId[itemArg]
            ?: itemNamesToId[itemArg.replace("_", "")]

    if (itemId == null || itemId <= 0) {
      ctx.reply("Unknown item: ${ctx.args[0]}")
      return
    }

    val amount = (ctx.args.getOrNull(1)?.toIntOrNull() ?: 1).coerceAtLeast(1)
    if (storyPlayerService.giveItem(ctx.session, ctx.state, itemId, amount)) {
      ctx.reply("Added $amount x item #$itemId to your bag.")
    } else {
      ctx.reply("Failed to add item #$itemId.")
    }
  }
}
