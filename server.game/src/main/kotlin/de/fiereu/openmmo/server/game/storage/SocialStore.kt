package de.fiereu.openmmo.server.game.storage

import java.util.concurrent.ConcurrentHashMap

interface SocialStore {
  suspend fun getFriends(userId: Int): Set<String>

  suspend fun addFriend(userId: Int, name: String)

  suspend fun removeFriend(userId: Int, name: String): Boolean

  suspend fun getBlocked(userId: Int): Set<String>

  suspend fun block(userId: Int, name: String, reason: String = "")

  suspend fun unblock(userId: Int, name: String): Boolean
}

/** Fast deterministic implementation for unit tests. Production uses [JooqSocialStore]. */
class InMemorySocialStore : SocialStore {
  private val friendsByUser = ConcurrentHashMap<Int, MutableSet<String>>()
  private val blockedByUser = ConcurrentHashMap<Int, MutableSet<String>>()

  override suspend fun getFriends(userId: Int): Set<String> =
      friendsByUser.getOrPut(userId) { ConcurrentHashMap.newKeySet() }.toSet()

  override suspend fun addFriend(userId: Int, name: String) {
    friendsByUser.getOrPut(userId) { ConcurrentHashMap.newKeySet() }.add(name)
  }

  override suspend fun removeFriend(userId: Int, name: String): Boolean =
      friendsByUser.getOrPut(userId) { ConcurrentHashMap.newKeySet() }.remove(name)

  override suspend fun getBlocked(userId: Int): Set<String> =
      blockedByUser.getOrPut(userId) { ConcurrentHashMap.newKeySet() }.toSet()

  override suspend fun block(userId: Int, name: String, reason: String) {
    blockedByUser.getOrPut(userId) { ConcurrentHashMap.newKeySet() }.add(name)
  }

  override suspend fun unblock(userId: Int, name: String): Boolean =
      blockedByUser.getOrPut(userId) { ConcurrentHashMap.newKeySet() }.remove(name)
}
