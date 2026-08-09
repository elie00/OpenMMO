@import java.util.List
@import de.fiereu.openmmo.codegen.trainer.TrainerConstant

@param String pkg
@param String objectName
@param List<TrainerConstant> constants
package ${pkg}

/**
 * Trainer ids from this region's decomp opponents.h, restricted to the trainers the registry holds.
 * Scripts hand these to ScriptContext.trainerBattle.
 */
object ${objectName} {
@for(TrainerConstant c : constants)
  const val ${c.getName()} = ${c.getId()}
@endfor
}
