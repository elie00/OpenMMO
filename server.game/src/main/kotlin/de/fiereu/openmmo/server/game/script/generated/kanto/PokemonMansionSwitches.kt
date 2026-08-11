package de.fiereu.openmmo.server.game.script.generated.kanto

import de.fiereu.openmmo.dialog.generated.kanto.PokemonMansion
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.kanto.KantoFlags

/**
 * One of the mansion's four hidden switches, whose scripts the decomp shares in
 * data/scripts/pokemon_mansion.inc. Pressing any of them flips the whole building between its two
 * layouts, which is why they share one flag.
 *
 * The decomp moves the statues and railings with setmetatile. The generated maps already carry the
 * open layout, like the Silph Co doors, so this only records which way the switch is thrown.
 */
internal suspend fun pokemonMansionSwitch(ctx: ScriptContext) {
  if (!ctx.askYesNo(PokemonMansion.PressSecretSwitch)) {
    return ctx.sign(PokemonMansion.GaveUpOnPressingSwitch)
  }
  ctx.sign(PokemonMansion.WhoWouldnt)
  if (ctx.isFlagSet(KantoFlags.FLAG_POKEMON_MANSION_SWITCH_STATE)) {
    return ctx.clearFlag(KantoFlags.FLAG_POKEMON_MANSION_SWITCH_STATE)
  }
  ctx.setFlag(KantoFlags.FLAG_POKEMON_MANSION_SWITCH_STATE)
}
