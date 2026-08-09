package de.fiereu.openmmo.server.game.services

import de.fiereu.network.PacketEvent
import de.fiereu.openmmo.common.enums.GuildPermission
import de.fiereu.openmmo.common.enums.GuildRank
import de.fiereu.openmmo.net.game.packets.guild.GuildActivityLogEntry
import de.fiereu.openmmo.net.game.packets.guild.GuildActivityLogPacket
import de.fiereu.openmmo.net.game.packets.guild.GuildActivityLogPageRequestPacket
import de.fiereu.openmmo.net.game.packets.guild.GuildCreatePacket
import de.fiereu.openmmo.net.game.packets.guild.GuildDisbandPacket
import de.fiereu.openmmo.net.game.packets.guild.GuildInvitePacket
import de.fiereu.openmmo.net.game.packets.guild.GuildLeavePacket
import de.fiereu.openmmo.net.game.packets.guild.GuildMemberEntry
import de.fiereu.openmmo.net.game.packets.guild.GuildMemberKickPacket
import de.fiereu.openmmo.net.game.packets.guild.GuildMemberRankAssignPacket
import de.fiereu.openmmo.net.game.packets.guild.GuildMembershipPacket
import de.fiereu.openmmo.net.game.packets.guild.GuildMotdUpdatePacket
import de.fiereu.openmmo.net.game.packets.guild.GuildProfileData
import de.fiereu.openmmo.net.game.packets.guild.GuildRankLabelUpdatePacket
import de.fiereu.openmmo.net.game.packets.guild.GuildRankPermissionUpdatePacket
import de.fiereu.openmmo.net.game.packets.guild.SyncGuildMembersPacket
import de.fiereu.openmmo.server.game.session.PLAYER_STATE
import de.fiereu.openmmo.server.game.storage.CharacterStore
import de.fiereu.openmmo.server.game.storage.Guild
import de.fiereu.openmmo.server.game.storage.GuildMember
import de.fiereu.openmmo.server.game.storage.GuildStore
import io.github.oshai.kotlinlogging.KotlinLogging
import javax.inject.Inject
import javax.inject.Singleton

private val log = KotlinLogging.logger {}

private const val GUILD_FOUND_COST = 15000
private const val MAX_ACTIVITY_LOG_ENTRIES = 255

@Singleton
class GuildService
@Inject
constructor(
    private val guildStore: GuildStore,
    private val characterStore: CharacterStore,
) {

  suspend fun onCreateGuild(event: PacketEvent<GuildCreatePacket>) {
    val ctx = event.session
    val state = ctx.attributes[PLAYER_STATE] ?: return
    val charId = state.characterId ?: return
    val stored = characterStore.getCharacter(charId) ?: return
    if (guildStore.getGuildForChar(charId) != null) return
    val packet = event.packet
    if (packet.guildName.isBlank() || packet.guildTag.isBlank()) return
    // Charge first: taking the money is itself the check, where reading the balance and spending it
    // afterwards leaves a window in which the guild gets created without ever being paid for.
    if (!characterStore.addMoney(charId, -GUILD_FOUND_COST)) {
      log.info { "Insufficient funds to found a guild (need $GUILD_FOUND_COST)" }
      return
    }
    val guild =
        runCatching {
              guildStore.createGuild(
                  packet.guildName.trim(), packet.guildTag.trim(), charId, stored.info.name)
            }
            .getOrElse {
              // The store refused after the money was taken, so hand it back.
              characterStore.addMoney(charId, GUILD_FOUND_COST)
              log.warn(it) { "Could not create guild '${packet.guildName}'" }
              return
            }
    ctx.send(buildMembership(guild))
    ctx.send(buildMemberSync(guild))
  }

  suspend fun onActivityLogPageRequest(event: PacketEvent<GuildActivityLogPageRequestPacket>) {
    val ctx = event.session
    val charId = ctx.attributes[PLAYER_STATE]?.characterId ?: return
    val guild = guildStore.getGuildForChar(charId) ?: return
    if (!can(guild, charId, GuildPermission.TEAM_LOG)) return
    ctx.send(buildActivityLog(guild))
  }

  suspend fun onGuildInvite(event: PacketEvent<GuildInvitePacket>) {
    val ctx = event.session
    val charId = ctx.attributes[PLAYER_STATE]?.characterId ?: return
    var guild = guildStore.getGuildForChar(charId) ?: return
    if (!can(guild, charId, GuildPermission.INVITE)) return
    val target = characterStore.findCharacterByName(event.packet.targetName) ?: return
    if (target.info.id == charId || guildStore.getGuildForChar(target.info.id) != null) return
    guild =
        runCatching {
              guildStore.addMember(
                  guild,
                  GuildMember(target.info.id, target.info.name, GuildRank.GRUNT, leader = false),
              )
            }
            .getOrElse {
              log.warn(it) { "Could not add '${target.info.name}' to guild ${guild.id}" }
              return
            }
    ctx.send(buildMemberSync(guild))
  }

  suspend fun onRankAssign(event: PacketEvent<GuildMemberRankAssignPacket>) {
    val ctx = event.session
    val charId = ctx.attributes[PLAYER_STATE]?.characterId ?: return
    var guild = guildStore.getGuildForChar(charId) ?: return
    if (!isBoss(guild, charId)) return
    val targetId = event.packet.memberEntityId
    if (guild.members.none { it.id == targetId }) return
    val rank = GuildRank.entries.getOrNull(event.packet.rankOrdinal) ?: return
    guild =
        if (rank == GuildRank.BOSS && targetId != charId) {
          guildStore.transferLeadership(guild, targetId)
        } else if (rank != GuildRank.BOSS) {
          guildStore.setMemberRank(guild, targetId, rank)
        } else {
          return
        }
    ctx.send(buildMemberSync(guild))
  }

  suspend fun onKick(event: PacketEvent<GuildMemberKickPacket>) {
    val ctx = event.session
    val charId = ctx.attributes[PLAYER_STATE]?.characterId ?: return
    var guild = guildStore.getGuildForChar(charId) ?: return
    if (!can(guild, charId, GuildPermission.KICK)) return
    val actor = guild.members.firstOrNull { it.id == charId } ?: return
    val target = guild.members.firstOrNull { it.id == event.packet.targetEntityId } ?: return
    if (target.leader || target.id == actor.id || target.rank.ordinal >= actor.rank.ordinal) return
    guild = guildStore.removeMember(guild, target.id)
    ctx.send(buildMemberSync(guild))
  }

  suspend fun onLeave(event: PacketEvent<GuildLeavePacket>) {
    val ctx = event.session
    val charId = ctx.attributes[PLAYER_STATE]?.characterId ?: return
    val guild = guildStore.getGuildForChar(charId) ?: return
    val member = guild.members.firstOrNull { it.id == charId } ?: return
    if (member.leader && guild.members.size > 1) return
    if (member.leader) guildStore.disbandGuild(charId) else guildStore.leaveGuild(charId)
    ctx.send(GuildMembershipPacket(inGuild = false, profile = null))
  }

  suspend fun onDisband(event: PacketEvent<GuildDisbandPacket>) {
    val ctx = event.session
    val charId = ctx.attributes[PLAYER_STATE]?.characterId ?: return
    val guild = guildStore.getGuildForChar(charId) ?: return
    if (!event.packet.initiate || !isBoss(guild, charId)) return
    guildStore.disbandGuild(charId)
    ctx.send(GuildMembershipPacket(inGuild = false, profile = null))
  }

  suspend fun onMotdUpdate(event: PacketEvent<GuildMotdUpdatePacket>) {
    val charId = event.session.attributes[PLAYER_STATE]?.characterId ?: return
    val guild = guildStore.getGuildForChar(charId) ?: return
    if (!isBoss(guild, charId)) return
    guildStore.updateMotd(guild, event.packet.motdText)
  }

  suspend fun onRankLabelUpdate(event: PacketEvent<GuildRankLabelUpdatePacket>) {
    val charId = event.session.attributes[PLAYER_STATE]?.characterId ?: return
    val guild = guildStore.getGuildForChar(charId) ?: return
    if (!isBoss(guild, charId)) return
    val rank = GuildRank.entries.getOrNull(event.packet.rankOrdinal) ?: return
    guildStore.updateRankLabel(guild, rank, event.packet.rankLabel)
  }

  suspend fun onRankPermissionUpdate(event: PacketEvent<GuildRankPermissionUpdatePacket>) {
    val charId = event.session.attributes[PLAYER_STATE]?.characterId ?: return
    val guild = guildStore.getGuildForChar(charId) ?: return
    if (!isBoss(guild, charId)) return
    val sanitized =
        event.packet.permissions.mapValues { (rank, permissions) ->
          when (rank) {
            GuildRank.BOSS -> GuildPermission.entries.toSet()
            GuildRank.GRUNT -> permissions - GuildPermission.KICK
            else -> permissions
          }
        }
    guildStore.updatePermissions(guild, sanitized)
  }

  private fun can(guild: Guild, charId: Long, permission: GuildPermission): Boolean {
    val member = guild.members.firstOrNull { it.id == charId } ?: return false
    return member.leader || permission in guild.permissions[member.rank].orEmpty()
  }

  private fun isBoss(guild: Guild, charId: Long): Boolean =
      guild.members.any { it.id == charId && it.leader && it.rank == GuildRank.BOSS }

  private fun buildMembership(guild: Guild): GuildMembershipPacket =
      GuildMembershipPacket(
          inGuild = true,
          profile =
              GuildProfileData(
                  guildId = guild.id,
                  name = guild.name,
                  tag = guild.tag,
                  foundedAt = guild.foundedAt,
                  message = guild.motd,
                  updatedAt = guild.updatedAt,
                  value1 = 5,
                  value2 = 5,
                  value3 = 5,
                  value4 = 0,
                  value5 = 0,
                  unk1 = 0,
                  rankCount = GuildRank.entries.size,
                  unk2 = 0,
                  unk3 = 0,
                  flag = 0,
              ),
      )

  private fun buildMemberSync(guild: Guild): SyncGuildMembersPacket =
      SyncGuildMembersPacket(
          replace = true,
          members =
              guild.members.map { member ->
                GuildMemberEntry(
                    entityId = member.id,
                    rank = member.rank.ordinal.toByte(),
                    joinedAt = member.joinedAt,
                    name = member.name,
                    online = true,
                    lastSeen = 0,
                    appearance = List(5) { 0 },
                    leader = member.leader,
                )
              },
      )

  private fun buildActivityLog(guild: Guild): GuildActivityLogPacket =
      GuildActivityLogPacket(
          totalCount = guild.activityLog.size.coerceAtMost(Short.MAX_VALUE.toInt()).toShort(),
          entries =
              guild.activityLog.takeLast(MAX_ACTIVITY_LOG_ENTRIES).map { entry ->
                GuildActivityLogEntry(
                    type = entry.type.code,
                    actor = entry.actor,
                    target = entry.target,
                    timestamp = entry.timestamp,
                )
              },
      )
}
