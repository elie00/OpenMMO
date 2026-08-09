package de.fiereu.openmmo.server.login.config

import com.typesafe.config.ConfigFactory
import de.fiereu.openmmo.common.config.ServerEnvironment
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ConfigLoaderTest :
    FunSpec({
      fun load(overrides: String = ""): LoginServerConfig =
          ConfigLoader.load(ConfigFactory.parseString("$BASE_CONFIG\n$overrides").resolve())

      test("development accepts the documented local defaults") {
        load().environment shouldBe ServerEnvironment.DEVELOPMENT
      }

      test("production accepts explicit secrets, key, password, and disabled seeds") {
        load(VALID_PRODUCTION).environment shouldBe ServerEnvironment.PRODUCTION
      }

      test("production rejects the development session secret") {
        shouldThrow<IllegalArgumentException> {
          load("$VALID_PRODUCTION\nserver.sessionSecret=dev-only-secret-do-not-use-in-production")
        }
      }

      test("production rejects the development database password") {
        shouldThrow<IllegalArgumentException> {
          load("$VALID_PRODUCTION\ndb.password=\"changeMe!\"")
        }
      }

      test("production rejects development seed data") {
        shouldThrow<IllegalArgumentException> { load("$VALID_PRODUCTION\ndb.seedDev=true") }
      }

      test("production requires an externally supplied private key") {
        shouldThrow<IllegalArgumentException> {
          load("$VALID_PRODUCTION\nserver.rootKey=\"\"\nserver.rootKeyFile=\"\"")
        }
      }
    })

private val BASE_CONFIG =
    """
    server {
      environment=development
      host=localhost
      port=2106
      checksumSize=16
      rootKeyResource=game.private.pem
      rootKey=""
      rootKeyFile=""
      sessionSecret=dev-only-secret-do-not-use-in-production
      rememberMeMaxAge=30d
    }
    db {
      host=localhost
      port=20011
      name=openmmo_login_db
      user=openmmo_login_user
      password="changeMe!"
      poolSize=4
      seedDev=true
    }
    """
        .trimIndent()

private val VALID_PRODUCTION =
    """
    server.environment=production
    server.sessionSecret=a-long-production-session-secret
    server.rootKeyFile=/run/secrets/game-key.pem
    db.password=a-production-database-password
    db.seedDev=false
    """
        .trimIndent()
