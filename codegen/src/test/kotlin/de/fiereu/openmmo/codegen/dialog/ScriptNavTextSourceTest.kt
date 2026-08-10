package de.fiereu.openmmo.codegen.dialog

import de.fiereu.openmmo.codegen.script.DialogRefIndex
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import java.io.File

/**
 * The only test that can show the navigation agrees with a real ROM, so it exists even though CI
 * never runs it: ROMs are gitignored, and the whole suite skips when none is there.
 */
class ScriptNavTextSourceTest :
    FunSpec({
      val decompDir = File("../decomp/pokefirered")
      val rom = RomIndex.find(File("../roms"), listOf("BPRF"))

      // Kotest's "!" prefix disables a test, which is how the suite reports itself as skipped.
      val prefix = if (rom == null) "!" else ""
      val source = rom?.let { ScriptNavTextSource(decompDir, it.index.bytes) }
      val offsets =
          if (source == null) emptyMap()
          else TextParser(decompDir).parseAll().associate { it.label to source.offsetOf(it) }

      test("${prefix}pairs every entry script it reaches, with no walk failing or diverging") {
        val stats = source!!.stats
        stats.walkFailures shouldBe 0
        stats.slotMismatches shouldBe 0
        stats.countMismatches shouldBe 0
        stats.paired shouldBe stats.entries
      }

      test("${prefix}resolves the kanto texts the map data can reach") {
        // Measured on the retail French ROM. A drop means an opcode size or a walk rule broke.
        offsets.count { it.value >= 0 } shouldBeGreaterThanOrEqual 3475
      }

      test("${prefix}lands on the french text a pallet town label stands for") {
        // Spot checked by decoding the ROM with the decomp charmap:
        // "CHEN: He, attends! Ne pars pas!", "BOURG PALETTE ...", "Le progres... C'est dement!".
        offsets["PalletTown_Text_OakDontGoOut"] shouldBe 0x17D580
        offsets["PalletTown_Text_TownSign"] shouldBe 0x17D711
        offsets["PalletTown_Text_CanStoreItemsAndMonsInPC"] shouldBe 0x17D673
        offsets["ViridianCity_Mart_Text_TakeThisToProfOak"] shouldBe 0x18FC80
      }

      test("${prefix}resolves every dialog line the committed scripts already reference") {
        val byEntry =
            DialogRefIndex.build(decompDir, source).entries.associate { (label, ref) ->
              "${ref.className}.${ref.entryName}" to label
            }
        val dialogClasses = byEntry.keys.mapTo(HashSet()) { it.substringBefore('.') }
        val referenced =
            references(
                    File(
                        "../server.game/src/main/kotlin/de/fiereu/openmmo/server/game/script/generated/kanto"))
                .filter { it.substringBefore('.') in dialogClasses && it in byEntry }
        // These are the lines already sent to a client, so a zero here is a visibly broken npc.
        referenced.filter { (offsets[byEntry.getValue(it)] ?: -1) < 0 } shouldBe emptyList()
        referenced.size shouldBeGreaterThanOrEqual 2000
      }
    })

/** Every `Something.Member` the committed script sources name. */
private fun references(dir: File): List<String> {
  if (!dir.isDirectory) return emptyList()
  val reference = Regex("\\b([A-Z]\\w*)\\.([A-Za-z_]\\w*)\\b")
  return dir.walkTopDown()
      .filter { it.isFile && it.extension == "kt" }
      .flatMap { file -> reference.findAll(file.readText()).map { it.value } }
      .distinct()
      .toList()
}
