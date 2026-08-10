package de.fiereu.openmmo.codegen.script

import de.fiereu.openmmo.codegen.dialog.RenderUtil
import de.fiereu.openmmo.codegen.dialog.TextOffsetSource
import de.fiereu.openmmo.codegen.dialog.TextParser
import java.io.File

/**
 * Maps a decomp text label to the generated dialog enum entry it became, mirroring the dialog
 * generator so a script can reference the same entry. It takes the same [TextOffsetSource] the
 * dialog generator runs on and applies its keep and ordering rules, so the two cannot drift: only
 * the first label to claim an entry name in a location gets it, since the enum keeps one per name.
 */
object DialogRefIndex {
  fun build(decompDir: File, source: TextOffsetSource?): Map<String, DialogRef> {
    if (source == null) return emptyMap()
    val located = TextParser(decompDir).parseAll().map { it.label to source.offsetOf(it) }
    val resolved =
        (if (source.keepsUnresolved) located else located.filter { it.second >= 0 })
            .sortedBy { if (it.second >= 0) 0 else 1 }
            .map { it.first }

    val refs = HashMap<String, DialogRef>()
    resolved
        .groupBy { RenderUtil.location(it) }
        .forEach { (location, labels) ->
          val className = RenderUtil.className(location).trim('`')
          val takenNames = HashSet<String>()
          for (label in labels) {
            val entry = RenderUtil.entryName(label)
            if (takenNames.add(entry)) refs[label] = DialogRef(className, entry)
          }
        }
    return refs
  }
}
