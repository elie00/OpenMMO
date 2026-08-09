package de.fiereu.openmmo.server.game.storage

import de.fiereu.openmmo.common.enums.GuildPermission
import de.fiereu.openmmo.common.enums.GuildRank
import java.time.Instant
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

data class GuildMember(
    val id: Long,
    val name: String,
    val rank: GuildRank,
    val leader: Boolean,
    val joinedAt: Int = 0,
)

// Wire codes are provisional and unverified against the real client.
enum class GuildActivityType(val code: Int) {
  FOUNDED(0),
  JOINED(1),
}

data class GuildLogEntry(
    val type: GuildActivityType,
    val actor: String,
    val target: String,
    val timestamp: Int,
)

data class Guild(
    val id: Long,
    val name: String,
    val tag: String,
    val members: MutableList<GuildMember>,
    val permissions: MutableMap<GuildRank, Set<GuildPermission>> = mutableMapOf(),
    val activityLog: MutableList<GuildLogEntry> = mutableListOf(),
    val motd: String = "",
    val foundedAt: Int = 0,
    val updatedAt: Int = 0,
    val rankLabels: MutableMap<GuildRank, String> = mutableMapOf(),
)

interface GuildStore {
  suspend fun createGuild(name: String, tag: String, leaderId: Long, leaderName: String): Guild

  suspend fun getGuildForChar(charId: Long): Guild?

  suspend fun addMember(guild: Guild, member: GuildMember): Guild

  suspend fun setMemberRank(guild: Guild, entityId: Long, rank: GuildRank): Guild

  suspend fun removeMember(guild: Guild, entityId: Long): Guild

  suspend fun transferLeadership(guild: Guild, newLeaderId: Long): Guild

  suspend fun leaveGuild(charId: Long)

  suspend fun disbandGuild(charId: Long)

  suspend fun updateMotd(guild: Guild, motd: String): Guild

  suspend fun updateRankLabel(guild: Guild, rank: GuildRank, label: String): Guild

  suspend fun updatePermissions(
      guild: Guild,
      permissions: Map<GuildRank, Set<GuildPermission>>,
  ): Guild
}

/** Fast deterministic implementation for unit tests. Production uses [JooqGuildStore]. */
class InMemoryGuildStore : GuildStore {
  private val guilds = ConcurrentHashMap<Long, Guild>()
  private val guildByChar = ConcurrentHashMap<Long, Long>()
  private val nextId = AtomicLong(1)

  override suspend fun createGuild(
      name: String,
      tag: String,
      leaderId: Long,
      leaderName: String,
  ): Guild {
    val now = now()
    val leader = GuildMember(leaderId, leaderName, GuildRank.BOSS, leader = true, joinedAt = now)
    val guild =
        Guild(
            nextId.getAndIncrement(),
            name,
            tag,
            mutableListOf(leader),
            permissions = defaultGuildPermissions(),
            foundedAt = now,
            updatedAt = now,
        )
    guild.activityLog.add(GuildLogEntry(GuildActivityType.FOUNDED, leaderName, "", now))
    guilds[guild.id] = guild
    guildByChar[leaderId] = guild.id
    return guild
  }

  override suspend fun getGuildForChar(charId: Long): Guild? =
      guildByChar[charId]?.let { guilds[it] }

  override suspend fun addMember(guild: Guild, member: GuildMember): Guild {
    guild.members.add(member)
    guildByChar[member.id] = guild.id
    guild.activityLog.add(GuildLogEntry(GuildActivityType.JOINED, member.name, "", now()))
    return guild
  }

  override suspend fun setMemberRank(guild: Guild, entityId: Long, rank: GuildRank): Guild {
    val index = guild.members.indexOfFirst { it.id == entityId }
    if (index >= 0) guild.members[index] = guild.members[index].copy(rank = rank)
    return guild
  }

  override suspend fun removeMember(guild: Guild, entityId: Long): Guild {
    guild.members.removeAll { it.id == entityId }
    guildByChar.remove(entityId)
    return guild
  }

  override suspend fun transferLeadership(guild: Guild, newLeaderId: Long): Guild {
    for (i in guild.members.indices) {
      val member = guild.members[i]
      guild.members[i] =
          when {
            member.id == newLeaderId -> member.copy(rank = GuildRank.BOSS, leader = true)
            member.leader || member.rank == GuildRank.BOSS ->
                member.copy(rank = GuildRank.EXECUTIVE, leader = false)
            else -> member
          }
    }
    return guild
  }

  override suspend fun leaveGuild(charId: Long) {
    val guildId = guildByChar.remove(charId) ?: return
    guilds[guildId]?.members?.removeAll { it.id == charId }
  }

  override suspend fun disbandGuild(charId: Long) {
    val guildId = guildByChar[charId] ?: return
    guilds.remove(guildId)
    guildByChar.entries.removeIf { it.value == guildId }
  }

  override suspend fun updateMotd(guild: Guild, motd: String): Guild =
      guild.copy(motd = motd, updatedAt = now()).also { guilds[guild.id] = it }

  override suspend fun updateRankLabel(guild: Guild, rank: GuildRank, label: String): Guild {
    guild.rankLabels[rank] = label
    return guild
  }

  override suspend fun updatePermissions(
      guild: Guild,
      permissions: Map<GuildRank, Set<GuildPermission>>,
  ): Guild {
    guild.permissions.clear()
    guild.permissions.putAll(permissions)
    return guild
  }

  private fun now(): Int = Instant.now().epochSecond.toInt()
}

internal fun defaultGuildPermissions(): MutableMap<GuildRank, Set<GuildPermission>> =
    mutableMapOf(
        GuildRank.BOSS to GuildPermission.entries.toSet(),
        GuildRank.EXECUTIVE to GuildPermission.entries.toSet(),
        GuildRank.COMMANDER to GuildPermission.entries.toSet(),
        GuildRank.OFFICER to
            setOf(GuildPermission.INVITE, GuildPermission.TEAM_LOG, GuildPermission.TEAM_MESSAGES),
        GuildRank.MEMBER to setOf(GuildPermission.TEAM_LOG, GuildPermission.TEAM_MESSAGES),
        GuildRank.GRUNT to setOf(GuildPermission.TEAM_MESSAGES),
    )
