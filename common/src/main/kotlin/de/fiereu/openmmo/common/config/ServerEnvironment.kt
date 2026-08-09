package de.fiereu.openmmo.common.config

enum class ServerEnvironment {
  DEVELOPMENT,
  TEST,
  PRODUCTION;

  companion object {
    fun parse(value: String): ServerEnvironment =
        entries.firstOrNull { it.name.equals(value, ignoreCase = true) }
            ?: throw IllegalArgumentException(
                "server.environment must be one of: ${entries.joinToString { it.name.lowercase() }}")
  }
}
