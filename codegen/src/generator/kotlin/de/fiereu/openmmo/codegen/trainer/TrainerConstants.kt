package de.fiereu.openmmo.codegen.trainer

import de.fiereu.openmmo.codegen.defineTable
import java.io.File

/** A `TRAINER_*` define from a decomp, paired with the id the registry knows it by. */
data class TrainerConstant(val name: String, val id: Int)

/**
 * The `TRAINER_*` defines of a decomp, keeping only the ids that survived party parsing. A constant
 * can therefore never name a trainer [TrainerRegistry] does not hold, which is what makes
 * `ctx.trainerBattle(SomeTrainers.TRAINER_X)` safe to emit.
 */
fun readTrainerConstants(decompDir: File, registered: Set<Int>): List<TrainerConstant> =
    defineTable(File(decompDir, "include/constants/opponents.h"), "TRAINER_")
        .filter { (_, id) -> id in registered }
        .map { (name, id) -> TrainerConstant(name, id) }
        .sortedBy { it.id }
