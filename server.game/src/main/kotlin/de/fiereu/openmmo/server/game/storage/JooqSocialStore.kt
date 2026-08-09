package de.fiereu.openmmo.server.game.storage

import de.fiereu.openmmo.db.game.tables.references.SOCIAL_BLOCKS
import de.fiereu.openmmo.db.game.tables.references.SOCIAL_FRIENDS
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.jooq.DSLContext

@Singleton
class JooqSocialStore
@Inject
constructor(
    private val dsl: DSLContext,
    @param:Named("db") private val dispatcher: CoroutineDispatcher,
) : SocialStore {

  override suspend fun getFriends(userId: Int): Set<String> =
      withContext(dispatcher) {
        dsl.select(SOCIAL_FRIENDS.FRIEND_NAME)
            .from(SOCIAL_FRIENDS)
            .where(SOCIAL_FRIENDS.USER_ID.eq(userId))
            .orderBy(SOCIAL_FRIENDS.FRIEND_NAME)
            .fetchSet(SOCIAL_FRIENDS.FRIEND_NAME)
            .filterNotNull()
            .toSet()
      }

  override suspend fun addFriend(userId: Int, name: String) =
      withContext(dispatcher) {
        dsl.insertInto(SOCIAL_FRIENDS)
            .set(SOCIAL_FRIENDS.USER_ID, userId)
            .set(SOCIAL_FRIENDS.FRIEND_NAME, name)
            .onConflictDoNothing()
            .execute()
        Unit
      }

  override suspend fun removeFriend(userId: Int, name: String): Boolean =
      withContext(dispatcher) {
        dsl.deleteFrom(SOCIAL_FRIENDS)
            .where(SOCIAL_FRIENDS.USER_ID.eq(userId))
            .and(SOCIAL_FRIENDS.FRIEND_NAME.eq(name))
            .execute() > 0
      }

  override suspend fun getBlocked(userId: Int): Set<String> =
      withContext(dispatcher) {
        dsl.select(SOCIAL_BLOCKS.BLOCKED_NAME)
            .from(SOCIAL_BLOCKS)
            .where(SOCIAL_BLOCKS.USER_ID.eq(userId))
            .orderBy(SOCIAL_BLOCKS.BLOCKED_NAME)
            .fetchSet(SOCIAL_BLOCKS.BLOCKED_NAME)
            .filterNotNull()
            .toSet()
      }

  override suspend fun block(userId: Int, name: String, reason: String) =
      withContext(dispatcher) {
        dsl.insertInto(SOCIAL_BLOCKS)
            .set(SOCIAL_BLOCKS.USER_ID, userId)
            .set(SOCIAL_BLOCKS.BLOCKED_NAME, name)
            .set(SOCIAL_BLOCKS.REASON, reason)
            .onConflict(SOCIAL_BLOCKS.USER_ID, SOCIAL_BLOCKS.BLOCKED_NAME)
            .doUpdate()
            .set(SOCIAL_BLOCKS.REASON, reason)
            .execute()
        Unit
      }

  override suspend fun unblock(userId: Int, name: String): Boolean =
      withContext(dispatcher) {
        dsl.deleteFrom(SOCIAL_BLOCKS)
            .where(SOCIAL_BLOCKS.USER_ID.eq(userId))
            .and(SOCIAL_BLOCKS.BLOCKED_NAME.eq(name))
            .execute() > 0
      }
}
