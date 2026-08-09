package de.fiereu.openmmo.codegen.port

import java.io.File

/**
 * The decomp's named movement templates, expanded into the runtime's small [MovementStep]
 * vocabulary.
 *
 * Only steps with an exact equivalent are kept. A template holding anything else resolves to null
 * and its script is refused, rather than being approximated: `walk_in_place_faster_up` looks like a
 * walk but does not move the npc at all, so emitting WALK_UP for it would teleport them a tile.
 */
class MovementTemplates(decompDir: File) {

  private val templates: Map<String, List<String>?> = buildMap {
    val file = File(decompDir, "data/scripts/movement.inc")
    if (!file.isFile) return@buildMap
    var label: String? = null
    var steps = mutableListOf<String>()
    var usable = true
    for (raw in file.readLines()) {
      val line = raw.trim()
      val header = LABEL.matchEntire(line)
      when {
        header != null -> {
          label?.let { put(it, if (usable) steps.toList() else null) }
          label = header.groupValues[1]
          steps = mutableListOf()
          usable = true
        }
        line == "step_end" -> {
          label?.let { put(it, if (usable) steps.toList() else null) }
          label = null
        }
        label != null && line.isNotEmpty() && !line.startsWith("@") -> {
          val step = STEPS[line]
          if (step == null) usable = false else steps += step
        }
      }
    }
  }

  /** The steps of [template], or null when it is unknown or holds a step with no equivalent. */
  fun stepsOf(template: String): List<String>? = templates[template]

  private companion object {
    val LABEL = Regex("""^(\w+)::?$""")

    /**
     * The decomp step names this maps onto. The walk-in-place family turns the npc without moving
     * it, so it lands on FACE_*, not WALK_*. Speed variants collapse, the runtime does not model
     * animation speed.
     */
    val STEPS = buildMap {
      for (direction in listOf("up", "down", "left", "right")) {
        val upper = direction.uppercase()
        put("walk_$direction", "WALK_$upper")
        put("walk_fast_$direction", "WALK_$upper")
        put("walk_faster_$direction", "WALK_$upper")
        put("walk_slow_$direction", "WALK_$upper")
        put("face_$direction", "FACE_$upper")
        put("walk_in_place_$direction", "FACE_$upper")
        put("walk_in_place_fast_$direction", "FACE_$upper")
        put("walk_in_place_faster_$direction", "FACE_$upper")
        put("walk_in_place_slow_$direction", "FACE_$upper")
      }
      put("set_invisible", "SET_INVISIBLE")
    }
  }
}
