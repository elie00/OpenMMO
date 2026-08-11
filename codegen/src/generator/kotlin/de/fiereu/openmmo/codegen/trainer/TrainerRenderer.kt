package de.fiereu.openmmo.codegen.trainer

import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.output.FileOutput
import gg.jte.resolve.DirectoryCodeResolver
import java.io.File

/**
 * Emits two objects per region: the registrations the [de.fiereu.openmmo.trainer.TrainerRegistry]
 * loads, and the opponents.h id constants ported scripts battle by name.
 */
class TrainerRenderer(
    private val region: String,
    private val templatesDir: File,
    private val outputDir: File,
    private val classCacheDir: File,
    private val chunkSize: Int = 25,
) {

  fun render(trainers: List<ParsedTrainer>) {
    classCacheDir.mkdirs()
    val engine =
        TemplateEngine.create(
            DirectoryCodeResolver(templatesDir.toPath()),
            classCacheDir.toPath(),
            ContentType.Plain,
        )

    val capitalizedRegion = region.replaceFirstChar { it.uppercase() }
    write(
        engine,
        "TrainerRegistry.jte",
        "Generated${capitalizedRegion}Trainers",
        mapOf("region" to region, "chunks" to trainers.chunked(chunkSize)),
    )
    write(
        engine,
        "TrainerIds.jte",
        "${capitalizedRegion}TrainerIds",
        mapOf("trainers" to trainers),
    )
  }

  private fun write(
      engine: TemplateEngine,
      template: String,
      objectName: String,
      params: Map<String, Any>,
  ) {
    val file = File(outputDir, "${BASE_PACKAGE.replace('.', '/')}/$objectName.kt")
    file.parentFile.mkdirs()
    FileOutput(file.toPath()).use { out ->
      engine.render(template, params + ("pkg" to BASE_PACKAGE) + ("objectName" to objectName), out)
    }
  }

  companion object {
    private const val BASE_PACKAGE = "de.fiereu.openmmo.trainer.generated"
  }
}
