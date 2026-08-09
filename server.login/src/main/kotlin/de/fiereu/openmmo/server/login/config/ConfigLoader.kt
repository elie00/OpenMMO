package de.fiereu.openmmo.server.login.config

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import de.fiereu.openmmo.common.config.ServerEnvironment

private fun Config.stringOrNull(path: String): String? =
    if (hasPath(path)) getString(path) else null

@Suppress("kotlin:S2068")
object ConfigLoader {
  fun load(config: Config = ConfigFactory.load()): LoginServerConfig {
    val environment = ServerEnvironment.parse(config.getString("server.environment"))
    val secret = config.getString("server.sessionSecret")
    require(secret.isNotEmpty()) { "server.sessionSecret must not be empty" }
    val rememberMeMaxAge = config.getDuration("server.rememberMeMaxAge")
    require(!rememberMeMaxAge.isNegative && !rememberMeMaxAge.isZero) {
      "server.rememberMeMaxAge must be positive"
    }
    val result =
        LoginServerConfig(
            environment = environment,
            host = config.getString("server.host"),
            port = config.getInt("server.port"),
            checksumSize = config.getInt("server.checksumSize"),
            rootKeyResource = config.getString("server.rootKeyResource"),
            rootKey = config.stringOrNull("server.rootKey"),
            rootKeyFile = config.stringOrNull("server.rootKeyFile"),
            sessionSecret = secret.toByteArray(Charsets.UTF_8),
            rememberMeMaxAge = rememberMeMaxAge,
            db =
                DbConfig(
                    host = config.getString("db.host"),
                    port = config.getInt("db.port"),
                    name = config.getString("db.name"),
                    user = config.getString("db.user"),
                    password = config.getString("db.password"),
                    poolSize = config.getInt("db.poolSize"),
                    seedDev = config.getBoolean("db.seedDev"),
                ),
        )
    validateProduction(result)
    return result
  }

  private fun validateProduction(config: LoginServerConfig) {
    if (config.environment != ServerEnvironment.PRODUCTION) return
    require(!config.sessionSecret.contentEquals(DEFAULT_SESSION_SECRET.toByteArray())) {
      "Production requires OPENMMO_SESSION_SECRET to replace the development default"
    }
    require(config.db.password != DEVELOPMENT_DB_SECRET) {
      "Production requires LOGIN_DB_PASSWORD to replace the development default"
    }
    require(!config.db.seedDev) { "Production requires LOGIN_DB_SEED_DEV=false" }
    require(!config.rootKey.isNullOrBlank() || !config.rootKeyFile.isNullOrBlank()) {
      "Production requires OPENMMO_GAME_PRIVATE_KEY or OPENMMO_GAME_PRIVATE_KEY_FILE"
    }
  }
}

private const val DEFAULT_SESSION_SECRET = "dev-only-secret-do-not-use-in-production"
private const val DEVELOPMENT_DB_SECRET = "changeMe!"
