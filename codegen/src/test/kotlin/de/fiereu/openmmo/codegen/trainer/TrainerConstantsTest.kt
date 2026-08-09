package de.fiereu.openmmo.codegen.trainer

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TrainerConstantsTest :
    FunSpec({
      fun decompWith(header: String) =
          kotlin.io.path.createTempDirectory("trainers").toFile().also {
            it.resolve("include/constants").mkdirs()
            it.resolve("include/constants/opponents.h").writeText(header.trimIndent())
          }

      test("keeps only the ids the registry holds, sorted by id") {
        val decomp =
            decompWith(
                """
            #define TRAINER_NONE 0
            #define TRAINER_LASS_ROBIN 118
            #define TRAINER_YOUNGSTER_BEN 3
            #define TRAINER_UNPARSED 999
            #define MAX_TRAINERS_COUNT 743
            """)

        readTrainerConstants(decomp, setOf(3, 118)) shouldBe
            listOf(
                TrainerConstant("TRAINER_YOUNGSTER_BEN", 3),
                TrainerConstant("TRAINER_LASS_ROBIN", 118))
      }

      test("drops TRAINER_NONE because the registry never holds id zero") {
        val decomp = decompWith("#define TRAINER_NONE 0")

        readTrainerConstants(decomp, setOf(0)) shouldBe listOf(TrainerConstant("TRAINER_NONE", 0))
        readTrainerConstants(decomp, emptySet()) shouldBe emptyList()
      }

      test("returns nothing when the header is missing") {
        val decomp = kotlin.io.path.createTempDirectory("trainers").toFile()

        readTrainerConstants(decomp, setOf(1)) shouldBe emptyList()
      }
    })
