import buildsrc.CheckProtocolCoverageTask
import buildsrc.GenerateProtocolCoverageTask
import buildsrc.RunAllTask

plugins {
  alias(libs.plugins.dotenv)
}

val loginInstallation = project(":server.login").layout.buildDirectory.dir("install/server.login")
val gameInstallation = project(":server.game").layout.buildDirectory.dir("install/server.game")
val devPrivateKey = project(":keys").layout.buildDirectory.file("game.private.pem")

// A bare `KEY=` line in .env reads back as an empty string. Passing that on would define the
// variable and override the application.conf default with nothing, so drop blanks here.
fun dotenv(vararg keys: String): Map<String, String> =
    keys.mapNotNull { key -> env.fetchOrNull(key)?.takeIf(String::isNotBlank)?.let { key to it } }
        .toMap()

val privateKeyEnvironment =
    dotenv("OPENMMO_GAME_PRIVATE_KEY", "OPENMMO_GAME_PRIVATE_KEY_FILE").ifEmpty {
      // The distributions exclude the generated key, so point them at the one on disk. The
      // installed scripts run from their own directory, hence the absolute path.
      mapOf("OPENMMO_GAME_PRIVATE_KEY_FILE" to devPrivateKey.get().asFile.absolutePath)
    }

val sharedEnvironment =
    dotenv("OPENMMO_ENVIRONMENT", "OPENMMO_SESSION_SECRET") + privateKeyEnvironment

tasks.register<RunAllTask>("runAll") {
  group = "application"
  description = "Builds and runs the login and game servers together"
  dependsOn(":server.login:installDist", ":server.game:installDist", ":keys:generateGame")
  loginInstallDir.set(loginInstallation)
  gameInstallDir.set(gameInstallation)
  loginEnvironment.set(
      sharedEnvironment +
          dotenv(
              "OPENMMO_REMEMBER_ME_MAX_AGE",
              "LOGIN_DB_HOST",
              "LOGIN_DB_PORT",
              "LOGIN_DB_NAME",
              "LOGIN_DB_USER",
              "LOGIN_DB_PASSWORD",
              "LOGIN_DB_SEED_DEV"))
  gameEnvironment.set(
      sharedEnvironment +
          dotenv(
              "OPENMMO_SESSION_TOKEN_MAX_AGE",
              "GAME_DB_HOST",
              "GAME_DB_PORT",
              "GAME_DB_NAME",
              "GAME_DB_USER",
              "GAME_DB_PASSWORD",
              "GAME_DB_SEED_DEV"))
}

val gameProtocol =
    layout.projectDirectory.file(
        "protocols.game/src/main/kotlin/de/fiereu/openmmo/net/game/GameProtocol.kt")
val gameHandler =
    layout.projectDirectory.file(
        "server.game/src/main/kotlin/de/fiereu/openmmo/server/game/handler/GameAppHandler.kt")
val protocolCoverage =
    layout.projectDirectory.file("docs/src/content/docs/reference/protocol-coverage.md")

tasks.register<GenerateProtocolCoverageTask>("generateProtocolCoverage") {
  group = "documentation"
  description = "Regenerates the client-to-server game protocol coverage matrix"
  protocolSource.set(gameProtocol)
  handlerSource.set(gameHandler)
  outputFile.set(protocolCoverage)
}

val checkProtocolCoverage =
    tasks.register<CheckProtocolCoverageTask>("checkProtocolCoverage") {
      group = "verification"
      description = "Checks that the committed game protocol coverage matrix is current"
      protocolSource.set(gameProtocol)
      handlerSource.set(gameHandler)
      coverageFile.set(protocolCoverage)
    }

subprojects {
  tasks.matching { it.name == "check" }.configureEach { dependsOn(checkProtocolCoverage) }
}
