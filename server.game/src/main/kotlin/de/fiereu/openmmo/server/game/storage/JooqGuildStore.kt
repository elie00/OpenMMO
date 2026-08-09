package de.fiereu.openmmo.server.game.storage

import de.fiereu.openmmo.common.enums.GuildPermission
import de.fiereu.openmmo.common.enums.GuildRank
import de.fiereu.openmmo.db.game.tables.references.GUILDS
import de.fiereu.openmmo.db.game.tables.references.GUILD_ACTIVITY_LOG
import de.fiereu.openmmo.db.game.tables.references.GUILD_MEMBERS
import de.fiereu.openmmo.db.game.tables.references.GUILD_RANK_LABELS
import de.fiereu.openmmo.db.game.tables.references.GUILD_RANK_PERMISSIONS
import java.time.Instant
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.jooq.DSLContext

@Singleton
class JooqGuildStore
@Inject
constructor(
    private val dsl: DSLContext,
    @param:Named("db") private val dispatcher: CoroutineDispatcher,
) : GuildStore {

  override suspend fun createGuild(
      name: String,
      tag: String,
      leaderId: Long,
      leaderName: String,
  ): Guild =
      withContext(dispatcher) {
        val guildId =
            dsl.transactionResult { configuration ->
              val tx = configuration.dsl()
              val now = now()
              val id =
                  tx.insertInto(GUILDS)
                      .set(GUILDS.NAME, name)
                      .set(GUILDS.TAG, tag)
                      .set(GUILDS.MOTD, "")
                      .set(GUILDS.FOUNDED_AT, now)
                      .set(GUILDS.UPDATED_AT, now)
                      .returning(GUILDS.ID)
                      .fetchSingle(GUILDS.ID)!!
              tx.insertInto(GUILD_MEMBERS)
                  .set(GUILD_MEMBERS.GUILD_ID, id)
                  .set(GUILD_MEMBERS.CHARACTER_ID, leaderId)
                  .set(GUILD_MEMBERS.NAME, leaderName)
                  .set(GUILD_MEMBERS.RANK, GuildRank.BOSS.name)
                  .set(GUILD_MEMBERS.LEADER, true)
                  .set(GUILD_MEMBERS.JOINED_AT, now)
                  .execute()
              writePermissions(tx, id, defaultGuildPermissions())
              insertLog(tx, id, GuildActivityType.FOUNDED, leaderName, "", now)
              id
            }
        loadGuild(guildId)!!
      }

  override suspend fun getGuildForChar(charId: Long): Guild? =
      withContext(dispatcher) {
        val guildId =
            dsl.select(GUILD_MEMBERS.GUILD_ID)
                .from(GUILD_MEMBERS)
                .where(GUILD_MEMBERS.CHARACTER_ID.eq(charId))
                .fetchOne(GUILD_MEMBERS.GUILD_ID) ?: return@withContext null
        loadGuild(guildId)
      }

  override suspend fun addMember(guild: Guild, member: GuildMember): Guild =
      withContext(dispatcher) {
        dsl.transaction { configuration ->
          val tx = configuration.dsl()
          val joinedAt = if (member.joinedAt == 0) now() else member.joinedAt
          tx.insertInto(GUILD_MEMBERS)
              .set(GUILD_MEMBERS.GUILD_ID, guild.id)
              .set(GUILD_MEMBERS.CHARACTER_ID, member.id)
              .set(GUILD_MEMBERS.NAME, member.name)
              .set(GUILD_MEMBERS.RANK, member.rank.name)
              .set(GUILD_MEMBERS.LEADER, member.leader)
              .set(GUILD_MEMBERS.JOINED_AT, joinedAt)
              .execute()
          insertLog(tx, guild.id, GuildActivityType.JOINED, member.name, "", joinedAt)
        }
        loadGuild(guild.id)!!
      }

  override suspend fun setMemberRank(guild: Guild, entityId: Long, rank: GuildRank): Guild =
      mutateAndReload(guild.id) {
        it.update(GUILD_MEMBERS)
            .set(GUILD_MEMBERS.RANK, rank.name)
            .where(GUILD_MEMBERS.GUILD_ID.eq(guild.id))
            .and(GUILD_MEMBERS.CHARACTER_ID.eq(entityId))
            .execute()
      }

  override suspend fun removeMember(guild: Guild, entityId: Long): Guild =
      mutateAndReload(guild.id) {
        it.deleteFrom(GUILD_MEMBERS)
            .where(GUILD_MEMBERS.GUILD_ID.eq(guild.id))
            .and(GUILD_MEMBERS.CHARACTER_ID.eq(entityId))
            .execute()
      }

  override suspend fun transferLeadership(guild: Guild, newLeaderId: Long): Guild =
      withContext(dispatcher) {
        dsl.transaction { configuration ->
          val tx = configuration.dsl()
          tx.update(GUILD_MEMBERS)
              .set(GUILD_MEMBERS.RANK, GuildRank.EXECUTIVE.name)
              .set(GUILD_MEMBERS.LEADER, false)
              .where(GUILD_MEMBERS.GUILD_ID.eq(guild.id))
              .and(GUILD_MEMBERS.LEADER.eq(true))
              .execute()
          tx.update(GUILD_MEMBERS)
              .set(GUILD_MEMBERS.RANK, GuildRank.BOSS.name)
              .set(GUILD_MEMBERS.LEADER, true)
              .where(GUILD_MEMBERS.GUILD_ID.eq(guild.id))
              .and(GUILD_MEMBERS.CHARACTER_ID.eq(newLeaderId))
              .execute()
        }
        loadGuild(guild.id)!!
      }

  override suspend fun leaveGuild(charId: Long) {
    withContext(dispatcher) {
      dsl.deleteFrom(GUILD_MEMBERS).where(GUILD_MEMBERS.CHARACTER_ID.eq(charId)).execute()
    }
  }

  override suspend fun disbandGuild(charId: Long) {
    withContext(dispatcher) {
      val guildId =
          dsl.select(GUILD_MEMBERS.GUILD_ID)
              .from(GUILD_MEMBERS)
              .where(GUILD_MEMBERS.CHARACTER_ID.eq(charId))
              .fetchOne(GUILD_MEMBERS.GUILD_ID) ?: return@withContext
      dsl.deleteFrom(GUILDS).where(GUILDS.ID.eq(guildId)).execute()
    }
  }

  override suspend fun updateMotd(guild: Guild, motd: String): Guild =
      mutateAndReload(guild.id) {
        it.update(GUILDS)
            .set(GUILDS.MOTD, motd)
            .set(GUILDS.UPDATED_AT, now())
            .where(GUILDS.ID.eq(guild.id))
            .execute()
      }

  override suspend fun updateRankLabel(guild: Guild, rank: GuildRank, label: String): Guild =
      mutateAndReload(guild.id) {
        it.insertInto(GUILD_RANK_LABELS)
            .set(GUILD_RANK_LABELS.GUILD_ID, guild.id)
            .set(GUILD_RANK_LABELS.RANK, rank.name)
            .set(GUILD_RANK_LABELS.LABEL, label)
            .onConflict(GUILD_RANK_LABELS.GUILD_ID, GUILD_RANK_LABELS.RANK)
            .doUpdate()
            .set(GUILD_RANK_LABELS.LABEL, label)
            .execute()
      }

  override suspend fun updatePermissions(
      guild: Guild,
      permissions: Map<GuildRank, Set<GuildPermission>>,
  ): Guild =
      withContext(dispatcher) {
        dsl.transaction { configuration ->
          val tx = configuration.dsl()
          tx.deleteFrom(GUILD_RANK_PERMISSIONS)
              .where(GUILD_RANK_PERMISSIONS.GUILD_ID.eq(guild.id))
              .execute()
          writePermissions(tx, guild.id, permissions)
        }
        loadGuild(guild.id)!!
      }

  private suspend fun mutateAndReload(guildId: Long, mutation: (DSLContext) -> Unit): Guild =
      withContext(dispatcher) {
        mutation(dsl)
        loadGuild(guildId)!!
      }

  private fun loadGuild(guildId: Long): Guild? {
    val row = dsl.selectFrom(GUILDS).where(GUILDS.ID.eq(guildId)).fetchOne() ?: return null
    val members =
        dsl.selectFrom(GUILD_MEMBERS)
            .where(GUILD_MEMBERS.GUILD_ID.eq(guildId))
            .orderBy(GUILD_MEMBERS.LEADER.desc(), GUILD_MEMBERS.JOINED_AT)
            .fetch()
            .map {
              GuildMember(
                  id = it.characterId,
                  name = it.name,
                  rank = GuildRank.valueOf(it.rank),
                  leader = it.leader ?: false,
                  joinedAt = it.joinedAt,
              )
            }
            .toMutableList()
    val permissions =
        dsl.selectFrom(GUILD_RANK_PERMISSIONS)
            .where(GUILD_RANK_PERMISSIONS.GUILD_ID.eq(guildId))
            .fetch()
            .groupBy({ GuildRank.valueOf(it.rank) }, { GuildPermission.valueOf(it.permission) })
            .mapValues { (_, values) -> values.toSet() }
            .toMutableMap()
    val labels =
        dsl.selectFrom(GUILD_RANK_LABELS)
            .where(GUILD_RANK_LABELS.GUILD_ID.eq(guildId))
            .fetch()
            .associate { GuildRank.valueOf(it.rank) to it.label }
            .toMutableMap()
    val log =
        dsl.selectFrom(GUILD_ACTIVITY_LOG)
            .where(GUILD_ACTIVITY_LOG.GUILD_ID.eq(guildId))
            .orderBy(GUILD_ACTIVITY_LOG.ID)
            .fetch()
            .map { entry ->
              GuildLogEntry(
                  GuildActivityType.entries.firstOrNull { it.code == entry.eventType }
                      ?: GuildActivityType.JOINED,
                  entry.actor,
                  entry.target ?: "",
                  entry.createdAt,
              )
            }
            .toMutableList()
    return Guild(
        id = checkNotNull(row.id),
        name = row.name,
        tag = row.tag,
        members = members,
        permissions = permissions,
        activityLog = log,
        motd = row.motd ?: "",
        foundedAt = row.foundedAt,
        updatedAt = row.updatedAt,
        rankLabels = labels,
    )
  }

  private fun writePermissions(
      tx: DSLContext,
      guildId: Long,
      permissions: Map<GuildRank, Set<GuildPermission>>,
  ) {
    for ((rank, values) in permissions) {
      for (permission in values) {
        tx.insertInto(GUILD_RANK_PERMISSIONS)
            .set(GUILD_RANK_PERMISSIONS.GUILD_ID, guildId)
            .set(GUILD_RANK_PERMISSIONS.RANK, rank.name)
            .set(GUILD_RANK_PERMISSIONS.PERMISSION, permission.name)
            .execute()
      }
    }
  }

  private fun insertLog(
      tx: DSLContext,
      guildId: Long,
      type: GuildActivityType,
      actor: String,
      target: String,
      createdAt: Int,
  ) {
    tx.insertInto(GUILD_ACTIVITY_LOG)
        .set(GUILD_ACTIVITY_LOG.GUILD_ID, guildId)
        .set(GUILD_ACTIVITY_LOG.EVENT_TYPE, type.code)
        .set(GUILD_ACTIVITY_LOG.ACTOR, actor)
        .set(GUILD_ACTIVITY_LOG.TARGET, target)
        .set(GUILD_ACTIVITY_LOG.CREATED_AT, createdAt)
        .execute()
  }

  private fun now(): Int = Instant.now().epochSecond.toInt()
}
