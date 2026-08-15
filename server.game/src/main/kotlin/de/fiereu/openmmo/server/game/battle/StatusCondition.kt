package de.fiereu.openmmo.server.game.battle

enum class PrimaryStatus(val id: Byte, val displayName: String) {
  NONE(0, "None"),
  SLEEP(1, "Asleep"),
  POISON(2, "Poisoned"),
  BURN(3, "Burned"),
  FREEZE(4, "Frozen"),
  PARALYSIS(5, "Paralyzed"),
  TOXIC(6, "Badly Poisoned"),
  ;

  companion object {
    fun fromId(id: Byte): PrimaryStatus = entries.firstOrNull { it.id == id } ?: NONE
  }
}
