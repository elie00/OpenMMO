import buildsrc.CheckProtocolCoverageTask
import buildsrc.GenerateProtocolCoverageTask
import buildsrc.RunAllTask

plugins {
  alias(libs.plugins.dotenv)
}

val loginInstallation = project(":server.login").layout.buildDirectory.dir("install/server.login")
val gameInstallation = project(":server.game").layout.buildDirectory.dir("install/server.game")

tasks.register<RunAllTask>("runAll") {
  group = "application"
  description = "Builds and runs the login and game servers together"
  dependsOn(":server.login:installDist", ":server.game:installDist")
  loginInstallDir.set(loginInstallation)
  gameInstallDir.set(gameInstallation)
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
