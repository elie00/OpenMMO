package buildsrc

import java.io.File
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

/** Runs the installed login and game distributions as sibling processes. */
@DisableCachingByDefault(because = "Runs long-lived server processes")
abstract class RunAllTask : DefaultTask() {

  @get:InputDirectory abstract val loginInstallDir: DirectoryProperty

  @get:InputDirectory abstract val gameInstallDir: DirectoryProperty

  @TaskAction
  fun runServers() {
    val processes = mutableListOf<Process>()
    val shutdownHook = Thread { processes.forEach(::stop) }
    Runtime.getRuntime().addShutdownHook(shutdownHook)
    try {
      val login = start(loginInstallDir.get().asFile, "server.login")
      processes += login
      val game = start(gameInstallDir.get().asFile, "server.game")
      processes += game

      val first = CompletableFuture.anyOf(login.onExit(), game.onExit()).join() as Process
      if (first.exitValue() != 0) {
        throw GradleException(
            "${first.info().command().orElse("server")} exited with code ${first.exitValue()}")
      }
    } finally {
      processes.forEach(::stop)
      runCatching { Runtime.getRuntime().removeShutdownHook(shutdownHook) }
    }
  }

  private fun start(installDir: File, applicationName: String): Process {
    val windows = System.getProperty("os.name").startsWith("Windows", ignoreCase = true)
    val script = File(installDir, "bin/$applicationName${if (windows) ".bat" else ""}")
    if (!script.isFile) throw GradleException("Missing installed application script: $script")
    val command = if (windows) listOf("cmd", "/c", script.absolutePath) else listOf(script.absolutePath)
    logger.lifecycle("Starting $applicationName")
    return ProcessBuilder(command).directory(installDir).inheritIO().start()
  }

  private fun stop(process: Process) {
    if (!process.isAlive) return
    process.destroy()
    if (!process.waitFor(5, TimeUnit.SECONDS)) process.destroyForcibly()
  }
}
