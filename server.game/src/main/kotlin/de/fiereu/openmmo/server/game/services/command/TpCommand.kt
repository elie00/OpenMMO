package de.fiereu.openmmo.server.game.services.command

import de.fiereu.openmmo.common.CharacterPermissions
import de.fiereu.openmmo.common.DynamicWarp
import de.fiereu.openmmo.common.enums.Direction
import de.fiereu.openmmo.server.game.services.ScriptWarpService
import de.fiereu.openmmo.server.game.session.SCRIPT_SCOPE
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@Singleton
class TpCommand @Inject constructor(private val scriptWarpService: ScriptWarpService) :
    ChatCommand {
  override val name = "tp"
  override val usage = "/tp <location_name | bank map [x] [y]>"
  override val description = "teleports to a known town or coordinates"
  override val permission = CharacterPermissions.DEVELOPER

  private val namedDestinations =
      mapOf(
          // Kanto towns (Region 0, Bank 3)
          "pallet" to DynamicWarp(0, 3, 0, 5, 6, Direction.DOWN),
          "viridian" to DynamicWarp(0, 3, 1, 23, 26, Direction.DOWN),
          "pewter" to DynamicWarp(0, 3, 2, 17, 26, Direction.DOWN),
          "cerulean" to DynamicWarp(0, 3, 3, 20, 20, Direction.DOWN),
          "lavender" to DynamicWarp(0, 3, 4, 9, 6, Direction.DOWN),
          "vermilion" to DynamicWarp(0, 3, 5, 15, 8, Direction.DOWN),
          "celadon" to DynamicWarp(0, 3, 6, 41, 10, Direction.DOWN),
          "fuchsia" to DynamicWarp(0, 3, 7, 19, 28, Direction.DOWN),
          "cinnabar" to DynamicWarp(0, 3, 8, 14, 12, Direction.DOWN),
          "indigo" to DynamicWarp(0, 3, 9, 10, 8, Direction.DOWN),
          "saffron" to DynamicWarp(0, 3, 10, 23, 22, Direction.DOWN),
          // Hoenn towns (Region 1, Bank 0)
          "littleroot" to DynamicWarp(1, 0, 9, 8, 8, Direction.DOWN),
          "oldale" to DynamicWarp(1, 0, 10, 6, 17, Direction.DOWN),
          "petalburg" to DynamicWarp(1, 0, 0, 14, 9, Direction.DOWN),
          "rustboro" to DynamicWarp(1, 0, 2, 16, 39, Direction.DOWN),
          "dewford" to DynamicWarp(1, 0, 11, 15, 14, Direction.DOWN),
          "slateport" to DynamicWarp(1, 0, 1, 19, 20, Direction.DOWN),
          "mauville" to DynamicWarp(1, 0, 4, 22, 6, Direction.DOWN),
          "verdanturf" to DynamicWarp(1, 0, 13, 14, 7, Direction.DOWN),
          "fallarbor" to DynamicWarp(1, 0, 12, 14, 8, Direction.DOWN),
          "lavaridge" to DynamicWarp(1, 0, 15, 9, 7, Direction.DOWN),
          "fortree" to DynamicWarp(1, 0, 3, 5, 7, Direction.DOWN),
          "lilycove" to DynamicWarp(1, 0, 5, 24, 15, Direction.DOWN),
          "mossdeep" to DynamicWarp(1, 0, 6, 28, 17, Direction.DOWN),
          "sootopolis" to DynamicWarp(1, 0, 7, 43, 32, Direction.DOWN),
          "pacifidlog" to DynamicWarp(1, 0, 14, 8, 16, Direction.DOWN),
          "evergrande" to DynamicWarp(1, 0, 8, 27, 47, Direction.DOWN),
      )

  override fun run(ctx: CommandContext) {
    if (ctx.args.isEmpty()) {
      ctx.reply("Usage: $usage")
      val kantoKeys =
          listOf(
              "pallet",
              "viridian",
              "pewter",
              "cerulean",
              "vermilion",
              "celadon",
              "fuchsia",
              "saffron",
              "cinnabar",
              "indigo")
      ctx.reply("Known locations: ${kantoKeys.joinToString(", ")}")
      return
    }

    val target =
        if (ctx.args.size == 1) {
          namedDestinations[ctx.args[0].lowercase()]
        } else {
          val bank = ctx.args.getOrNull(0)?.toIntOrNull()?.toByte()
          val map = ctx.args.getOrNull(1)?.toIntOrNull()?.toByte()
          val x = (ctx.args.getOrNull(2)?.toIntOrNull() ?: 5).toShort()
          val y = (ctx.args.getOrNull(3)?.toIntOrNull() ?: 5).toShort()
          if (bank != null && map != null) {
            DynamicWarp(ctx.state.regionId.toByte(), bank, map, x, y, Direction.DOWN)
          } else {
            null
          }
        }

    if (target == null) {
      ctx.reply("Unknown location or invalid coordinates: ${ctx.args.joinToString(" ")}")
      return
    }

    val scope =
        ctx.session.attributes.getOrPut(SCRIPT_SCOPE) {
          CoroutineScope(SupervisorJob() + Dispatchers.Default)
        }

    scope.launch {
      scriptWarpService.warp(ctx.session, ctx.state, target)
      ctx.reply(
          "Teleported to region ${target.regionId} bank ${target.bankId} map ${target.mapId} (${target.x}, ${target.y})")
    }
  }
}
