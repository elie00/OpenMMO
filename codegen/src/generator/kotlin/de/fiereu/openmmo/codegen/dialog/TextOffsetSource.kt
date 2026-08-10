package de.fiereu.openmmo.codegen.dialog

/**
 * Resolves a decomp text label to its file offset in the ROM being built against.
 *
 * Two ROMs of the same game in different languages share every structure but not a single byte of
 * text, so there are two ways to find a text: search for its bytes (only possible when the decomp
 * language matches the ROM), or walk the maps the way the game does.
 */
interface TextOffsetSource {

  /** The offset of [text] in the ROM, or -1 when this source cannot place it. */
  fun offsetOf(text: DecompText): Int

  /**
   * Whether a label this source could not place should still get an enum entry with a zero textId.
   * True for sources that structurally cannot see every text, so the enums keep the shape committed
   * scripts import.
   */
  val keepsUnresolved: Boolean
    get() = false
}
