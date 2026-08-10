package de.fiereu.openmmo.codegen.dialog.decomp

import java.io.File

/** One assembled line: the macro or directive name and its comma separated arguments. */
data class DecompCommand(val name: String, val args: List<String>)

/**
 * Every assembly line of the decomp as one flat stream, with labels as named positions into it.
 *
 * It is a stream rather than a label to body map on purpose: a script that runs off the end of its
 * label falls into the next one, exactly as the ROM's linear decode does, and only a flat stream
 * reproduces that. File boundaries get an [END_OF_FILE] marker so a fall through stops there.
 */
class DecompScriptStream(decompDir: File) {

  private val commands = ArrayList<DecompCommand>()
  private val labelPositions = HashMap<String, Int>()
  private val textContents = HashMap<String, StringBuilder>()

  init {
    decompDir
        .walkTopDown()
        .filter { it.isFile && (it.extension == "inc" || it.extension == "s") }
        .filterNot { it.path.contains("${File.separator}build${File.separator}") }
        .sortedBy { it.path }
        .forEach { read(it) }
  }

  val size: Int
    get() = commands.size

  fun commandAt(index: Int): DecompCommand = commands[index]

  /** Where [label] sits in the stream, or null when the decomp does not define it. */
  fun positionOf(label: String): Int? = labelPositions[label]

  /** Whether [label] names a `.string`, which is what a text pointer must land on. */
  fun isText(label: String): Boolean = label in textContents

  /**
   * The `map_script` entries of a map script table, as (type constant, target label) in table
   * order.
   */
  fun mapScriptEntries(label: String): List<Pair<String, String>> {
    var index = positionOf(label) ?: return emptyList()
    val out = ArrayList<Pair<String, String>>()
    while (index < commands.size) {
      val command = commands[index]
      when {
        command.name == "map_script" && command.args.size >= 2 ->
            out.add(command.args[0] to command.args[1])
        command.name == END_OF_FILE -> return out
        command.name == ".byte" && command.args.singleOrNull() == "0" -> return out
      }
      index++
    }
    return out
  }

  /** The script labels of a `map_script_2` sub table, in table order. */
  fun mapScriptSubEntries(label: String): List<String> {
    var index = positionOf(label) ?: return emptyList()
    val out = ArrayList<String>()
    while (index < commands.size) {
      val command = commands[index]
      when {
        command.name == "map_script_2" && command.args.size >= 3 -> out.add(command.args[2])
        command.name == END_OF_FILE -> return out
        command.name == ".2byte" && command.args.singleOrNull() == "0" -> return out
      }
      index++
    }
    return out
  }

  private fun read(file: File) {
    var current: String? = null
    commands.add(FILE_BOUNDARY)
    for (raw in file.readLines()) {
      val line = raw.substringBefore('@').trim()
      if (line.isEmpty()) continue
      val label = labelLine.matchEntire(line)
      if (label != null) {
        current = label.groupValues[1]
        labelPositions.putIfAbsent(current, commands.size)
        continue
      }
      if (line.startsWith(".string")) {
        val owner = current ?: continue
        textContents.getOrPut(owner) { StringBuilder() }.append(stringLiteral(line))
        continue
      }
      val space = line.indexOfFirst { it.isWhitespace() }
      commands.add(
          if (space < 0) DecompCommand(line, emptyList())
          else DecompCommand(line.substring(0, space), splitArgs(line.substring(space + 1))))
    }
    commands.add(FILE_BOUNDARY)
  }

  private fun splitArgs(rest: String): List<String> {
    val trimmed = rest.trim()
    return if (trimmed.isEmpty()) emptyList() else trimmed.split(',').map { it.trim() }
  }

  private fun stringLiteral(line: String): String {
    val first = line.indexOf('"')
    val last = line.lastIndexOf('"')
    return if (first in 0 until last) line.substring(first + 1, last) else ""
  }

  companion object {
    /** Name of the marker command that stands for the end of a source file. */
    const val END_OF_FILE = "__EOF__"

    private val FILE_BOUNDARY = DecompCommand(END_OF_FILE, emptyList())
    private val labelLine = Regex("^(\\w+):+\\s*$")
  }
}
