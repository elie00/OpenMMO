package de.fiereu.openmmo.codegen.port

import java.io.File
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/** Where an object event sits in its map, and the flag that hides it once it is gone. */
data class MapObject(val localId: Int, val hideFlag: String)

/**
 * Maps a script label to the object event carrying it, read straight from the decomp map json.
 *
 * A `finditem` script cannot be ported without this: the item ball is an object event, and the only
 * thing that stops it coming back after a map reload is that event's own hide flag.
 */
class MapObjectIndex(decompDir: File) {

  private val byLocalId = mutableMapOf<String, Int>()

  private val byScript: Map<String, MapObject> = buildMap {
    val json = Json { ignoreUnknownKeys = true }
    File(decompDir, "data/maps").listFiles()?.sorted()?.forEach { mapDir ->
      val file = File(mapDir, "map.json")
      if (!file.isFile) return@forEach
      val events =
          runCatching {
                json.parseToJsonElement(file.readText()).jsonObject["object_events"]?.jsonArray
              }
              .getOrNull() ?: return@forEach
      events.forEachIndexed { idx, element ->
        val event = element.jsonObject
        event["local_id"]?.jsonPrimitive?.contentOrNull()?.let { symbol ->
          val previous = byLocalId.put(symbol, idx)
          if (previous != null && previous != idx) byLocalId[symbol] = AMBIGUOUS_ID
        }
        val script = event["script"]?.jsonPrimitive?.contentOrNull() ?: return@forEachIndexed
        val flag = event["flag"]?.jsonPrimitive?.contentOrNull() ?: return@forEachIndexed
        if (flag == "0") return@forEachIndexed
        // A label used by two object events cannot be resolved to one of them, so drop both.
        if (containsKey(script)) put(script, AMBIGUOUS) else put(script, MapObject(idx, flag))
      }
    }
  }

  /** The object event carrying [script], or null when there is none or more than one. */
  fun forScript(script: String): MapObject? = byScript[script]?.takeIf { it != AMBIGUOUS }

  /**
   * The index an object event's `local_id` symbol stands for, which is what the runtime calls a
   * npc's local id. Null when the symbol is unknown, or when two maps give it different indices: a
   * script names it without naming its map, so an ambiguous symbol cannot be resolved safely.
   */
  fun localId(symbol: String): Int? = byLocalId[symbol]?.takeIf { it != AMBIGUOUS_ID }

  private companion object {
    val AMBIGUOUS = MapObject(-1, "")
    const val AMBIGUOUS_ID = -1
  }
}

private fun kotlinx.serialization.json.JsonPrimitive.contentOrNull(): String? =
    if (isString) content else null
