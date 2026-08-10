package de.fiereu.openmmo.codegen.dialog

/**
 * Finds a text by encoding it with the decomp charmap and searching the ROM for those bytes. Only
 * correct when the ROM speaks the decomp's language, since a localised ROM stores translated bytes.
 */
class EncodedTextSource(private val charmap: Charmap, private val rom: RomIndex) :
    TextOffsetSource {

  var unencodable = 0
    private set

  var notFound = 0
    private set

  override fun offsetOf(text: DecompText): Int {
    val bytes = charmap.encode(text.content)
    if (bytes == null) {
      unencodable++
      return -1
    }
    val offset = rom.offsetOf(bytes)
    if (offset < 0) notFound++
    return offset
  }
}
