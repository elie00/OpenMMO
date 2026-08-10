package de.fiereu.openmmo.codegen.dialog.decomp

import java.io.File
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/**
 * A map's entry scripts as the decomp declares them, one list per event table, in table order.
 *
 * The index is the whole point: it is what lets a decomp script label be matched with the pointer
 * the ROM keeps at the same index. Entries with no script are kept as nulls so the indices still
 * line up, and a hidden item bg event is one of them, which is also why it is skipped on both sides
 * at once.
 */
data class DecompMap(
    val name: String,
    val group: Int,
    val number: Int,
    val objects: List<String?>,
    val coords: List<String?>,
    val backgrounds: List<String?>,
)

/** Reads `data/maps/map_groups.json` and every `map.json` under it. */
class DecompMapEntries(decompDir: File) {

  /** How many maps each group holds, in group order: the shape of the ROM's map group table. */
  val groupSizes: List<Int>

  val maps: List<DecompMap>

  init {
    val json = Json { ignoreUnknownKeys = true }
    val groups =
        json.parseToJsonElement(File(decompDir, "data/maps/map_groups.json").readText()).jsonObject
    val order = groups.getValue("group_order").jsonArray.map { it.jsonPrimitive.content }
    groupSizes = order.map { groups.getValue(it).jsonArray.size }

    maps = buildList {
      order.forEachIndexed { group, groupName ->
        groups.getValue(groupName).jsonArray.forEachIndexed { number, element ->
          val name = element.jsonPrimitive.content
          val file = File(decompDir, "data/maps/$name/map.json")
          if (!file.isFile) return@forEachIndexed
          val map = json.parseToJsonElement(file.readText()).jsonObject
          add(
              DecompMap(
                  name,
                  group,
                  number,
                  scripts(map, "object_events"),
                  scripts(map, "coord_events"),
                  scripts(map, "bg_events"),
              ))
        }
      }
    }
  }

  private fun scripts(map: kotlinx.serialization.json.JsonObject, key: String): List<String?> =
      map[key]?.jsonArray?.map { event ->
        val script = event.jsonObject["script"]?.jsonPrimitive?.content
        // A bg event that is a hidden item packs item data where a sign keeps its script, and
        // "0x0" is how the decomp writes "none". Neither names a script.
        if (script != null && label.matches(script)) script else null
      } ?: emptyList()

  private companion object {
    val label = Regex("[A-Za-z_]\\w*")
  }
}
