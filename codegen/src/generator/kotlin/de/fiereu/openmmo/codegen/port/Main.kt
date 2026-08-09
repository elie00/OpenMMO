@file:JvmName("Main")

package de.fiereu.openmmo.codegen.port

import java.io.File
import kotlin.system.exitProcess

/**
 * Usage: `<generated-scripts-dir> [--check] <region|decomp>...`
 *
 * Rewrites the recognised trainer battle stubs in place. With `--check` nothing is written and a
 * non-zero exit means a run would still change something, which is what makes the task safe to
 * re-run: a second pass over ported code has nothing left to match.
 */
fun main(args: Array<String>) {
  val check = args.contains("--check")
  val positional = args.filter { it != "--check" }
  require(positional.size >= 2) {
    "Usage: <generated-scripts-dir> [--check] <region|decomp>... got ${args.toList()}"
  }
  val scriptsDir = File(positional[0])
  require(scriptsDir.isDirectory) { "Not a directory: $scriptsDir" }

  var changed = 0
  for (spec in positional.drop(1)) {
    val (region, decomp) = spec.split("|")
    val dir = File(scriptsDir, region)
    if (!dir.isDirectory) {
      println("[port] $region: no generated package at $dir, skipping")
      continue
    }
    val report = TrainerBattlePorter(region, File(decomp)).portDirectory(dir, write = !check)
    changed += report.filesChanged
    println(
        "[port] $region: ported ${report.ported} in ${report.filesChanged} files " +
            "(skipped ${report.skippedShape} unsupported shapes, " +
            "${report.skippedTrainer} unknown trainers, ${report.skippedText} unknown texts, " +
            "refused ${report.filesRefused} files)")
  }
  if (check && changed > 0) {
    println("[port] --check: $changed files would change")
    exitProcess(1)
  }
  println("[port] done")
}
