package de.fiereu.openmmo.server.game.storage

import de.fiereu.openmmo.common.enums.GuildPermission
import de.fiereu.openmmo.common.enums.GuildRank
import de.fiereu.openmmo.common.test.DockerAvailable
import io.kotest.core.annotation.EnabledIf
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import org.flywaydb.core.Flyway
import org.jooq.impl.DSL
import org.testcontainers.containers.PostgreSQLContainer

@EnabledIf(DockerAvailable::class)
class SocialGuildStoreIT :
    FunSpec({
      val container = PostgreSQLContainer<Nothing>("postgres:18")
      lateinit var social: JooqSocialStore
      lateinit var guilds: JooqGuildStore

      beforeSpec {
        container.start()
        Flyway.configure()
            .dataSource(container.jdbcUrl, container.username, container.password)
            .locations("classpath:db/migration", "classpath:db/dev")
            .load()
            .migrate()
        val dsl = DSL.using(container.jdbcUrl, container.username, container.password)
        social = JooqSocialStore(dsl, Dispatchers.IO)
        guilds = JooqGuildStore(dsl, Dispatchers.IO)
      }

      afterSpec { container.stop() }

      test("social relationships persist through fresh store instances") {
        social.addFriend(1, "Test2")
        social.block(1, "Spammer", "spam")

        val fresh =
            JooqSocialStore(
                DSL.using(container.jdbcUrl, container.username, container.password),
                Dispatchers.IO,
            )
        fresh.getFriends(1) shouldBe setOf("Test2")
        fresh.getBlocked(1) shouldBe setOf("Spammer")
        fresh.removeFriend(1, "Test2") shouldBe true
        fresh.unblock(1, "Spammer") shouldBe true
      }

      test("guild membership, permissions, labels, and motd persist") {
        var guild = guilds.createGuild("Knights", "KNT", 102400, "Test")
        guild = guilds.addMember(guild, GuildMember(364544, "Test2", GuildRank.GRUNT, false))
        guild = guilds.setMemberRank(guild, 364544, GuildRank.OFFICER)
        guild = guilds.updateMotd(guild, "Welcome")
        guild = guilds.updateRankLabel(guild, GuildRank.OFFICER, "Captain")
        guild =
            guilds.updatePermissions(
                guild,
                guild.permissions +
                    (GuildRank.OFFICER to setOf(GuildPermission.INVITE, GuildPermission.KICK)),
            )

        val loaded = guilds.getGuildForChar(364544)!!
        loaded.id shouldBe guild.id
        loaded.members.single { it.id == 364544L }.rank shouldBe GuildRank.OFFICER
        loaded.motd shouldBe "Welcome"
        loaded.rankLabels[GuildRank.OFFICER] shouldBe "Captain"
        loaded.permissions[GuildRank.OFFICER] shouldBe
            setOf(GuildPermission.INVITE, GuildPermission.KICK)
        loaded.activityLog.size shouldBe 2
      }
    })
