@import java.util.List
@import de.fiereu.openmmo.codegen.trainer.ParsedTrainer

@param String pkg
@param String objectName
@param List<ParsedTrainer> trainers
package ${pkg}

/**
 * Trainer ids generated from the GBA decomp's opponents.h. A ported `trainerbattle` hands the
 * constant of the same name to ScriptContext.trainerBattle, which looks it up in the region the
 * player is standing in. The two regions number their trainers from zero, so an id only means
 * anything together with its region. Generated, do not edit by hand.
 */
object ${objectName} {
@for(ParsedTrainer t : trainers)
  const val ${t.getConstant()} = ${t.getId()}
@endfor
}
