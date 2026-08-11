package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.Misc
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * The decomp's shared `EventScript_PkmnCenterNurse`, which every Pokemon Center's nurse calls. It
 * lives in data/scripts rather than any one map, so it is a shared object here too.
 *
 * The source game asks with a two entry multichoice, which is what [ScriptContext.askYesNo] is. The
 * ball tray field effect and the nurse's bow are presentation the runtime has no verb for, so the
 * party is simply healed between the two boxes.
 */
internal object EventScript_PkmnCenterNurse : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (!ctx.askYesNo(Misc.Text_WelcomeWantToHealPkmn)) {
      return ctx.say(Misc.Text_WeHopeToSeeYouAgain)
    }
    ctx.say(Misc.Text_TakeYourPkmnForFewSeconds)
    ctx.healParty()
    ctx.say(Misc.Text_RestoredPkmnToFullHealth)
    ctx.say(Misc.Text_WeHopeToSeeYouAgain)
  }
}
