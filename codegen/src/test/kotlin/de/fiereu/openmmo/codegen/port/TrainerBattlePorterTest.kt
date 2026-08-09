package de.fiereu.openmmo.codegen.port

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import java.io.File
import kotlin.io.path.createTempDirectory

/**
 * Runs against the real FireRed decomp, because what the porter has to get right is exactly the
 * agreement between a decomp body, the trainer table, and the labels the dialog generator emitted.
 * A hand written fixture would only prove the porter agrees with itself.
 */
class TrainerBattlePorterTest :
    FunSpec({
      val decomp = File("../decomp/pokefirered")

      fun stubFile(body: String): Pair<File, File> {
        val dir = createTempDirectory("port").toFile()
        val region = File(dir, "kanto").also { it.mkdirs() }
        val file = File(region, "Route3.kt")
        file.writeText(
            """
            |package de.fiereu.openmmo.server.game.script.generated.kanto
            |
            |import de.fiereu.openmmo.server.game.script.Script
            |import de.fiereu.openmmo.server.game.script.ScriptContext
            |
            |$body
            |
            |internal val Route3Scripts: Map<String, Script> = mapOf()
            |"""
                .trimMargin())
        return dir to file
      }

      val canonicalStub =
          """
          |/**
          | * Not ported yet. Decomp body:
          | * ```
          | * trainerbattle_single TRAINER_LASS_ROBIN, Route3_Text_RobinIntro, Route3_Text_RobinDefeat
          | * msgbox Route3_Text_RobinPostBattle, MSGBOX_AUTOCLOSE
          | * end
          | * ```
          | */
          |internal object Route3_EventScript_Robin : Script {
          |  override suspend fun run(ctx: ScriptContext) = TODO("port Route3_EventScript_Robin")
          |}"""
              .trimMargin()

      test("ports the canonical stub, guarding on the trainer already being beaten") {
        val (dir, file) = stubFile(canonicalStub)

        val report = TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true)

        report.ported shouldBe 1
        report.filesChanged shouldBe 1
        val text = file.readText()
        text shouldContain "val trainerId = KantoTrainers.TRAINER_LASS_ROBIN"
        text shouldContain "if (ctx.hasBeatenTrainer(trainerId)) {"
        text shouldContain "return ctx.say(Route3.RobinPostBattle)"
        text shouldContain "ctx.say(Route3.RobinIntro)"
        text shouldContain "if (ctx.trainerBattle(trainerId) != BattleResult.VICTORY) return"
        text shouldContain "ctx.say(Route3.RobinDefeat)"
        text.contains("""TODO("port""") shouldBe false
        // The provenance stays, so the next reader can still diff against the decomp.
        text shouldContain "Ported from the decomp:"
      }

      test("adds the imports it needs and leaves the rest of the file untouched") {
        val (dir, file) = stubFile(canonicalStub)
        val before = file.readText()

        TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true)

        val text = file.readText()
        text shouldContain "import de.fiereu.openmmo.dialog.generated.kanto.Route3"
        text shouldContain "import de.fiereu.openmmo.server.game.battle.BattleResult"
        text shouldContain "import de.fiereu.openmmo.trainer.generated.KantoTrainers"
        // Imports stay sorted, which is what keeps ktfmt from rewriting the block afterwards.
        val imports = text.lines().filter { it.startsWith("import ") }
        imports shouldBe imports.sorted()
        // Everything that is not the stub or the import block survives byte for byte.
        text.lines().last { it.isNotBlank() } shouldBe before.lines().last { it.isNotBlank() }
        text shouldContain "package de.fiereu.openmmo.server.game.script.generated.kanto"
      }

      test("running twice changes nothing the second time") {
        val (dir, file) = stubFile(canonicalStub)
        val porter = TrainerBattlePorter("kanto", decomp)

        porter.portDirectory(File(dir, "kanto"), true)
        val afterFirst = file.readText()
        val second = porter.portDirectory(File(dir, "kanto"), true)

        second.ported shouldBe 0
        second.filesChanged shouldBe 0
        file.readText() shouldBe afterFirst
      }

      test("handles the body ktfmt wrapped onto its own line") {
        val (dir, file) =
            stubFile(
                canonicalStub.replace(
                    """  override suspend fun run(ctx: ScriptContext) = TODO("port Route3_EventScript_Robin")""",
                    "  override suspend fun run(ctx: ScriptContext) =\n" +
                        """      TODO("port Route3_EventScript_Robin")"""))

        TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true).ported shouldBe
            1

        file.readText() shouldContain "val trainerId = KantoTrainers.TRAINER_LASS_ROBIN"
      }

      test("leaves a stub whose text label the decomp does not define") {
        val (dir, file) =
            stubFile(canonicalStub.replace("Route3_Text_RobinPostBattle", "gStringVar4"))
        val before = file.readText()

        val report = TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true)

        report.ported shouldBe 0
        report.skippedText shouldBe 1
        file.readText() shouldBe before
      }

      test("leaves a stub whose trainer the registry does not hold") {
        val (dir, file) = stubFile(canonicalStub.replace("TRAINER_LASS_ROBIN", "TRAINER_NONE"))
        val before = file.readText()

        val report = TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true)

        report.ported shouldBe 0
        report.skippedTrainer shouldBe 1
        file.readText() shouldBe before
      }

      test("never touches a hand written port that kept its stale KDoc") {
        val ported =
            canonicalStub.replace(
                """  override suspend fun run(ctx: ScriptContext) = TODO("port Route3_EventScript_Robin")""",
                "  override suspend fun run(ctx: ScriptContext) = ctx.say(Route3.RobinIntro)")
        val (dir, file) = stubFile(ported)
        val before = file.readText()

        TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true).ported shouldBe
            0

        file.readText() shouldBe before
      }

      test("ports a map item to the pickup verb with its own hide flag and local id") {
        val (dir, file) =
            stubFile(
                """
                |/**
                | * Not ported yet. Decomp body:
                | * ```
                | * finditem ITEM_PP_UP
                | * end
                | * ```
                | */
                |internal object CeruleanCave_2F_EventScript_ItemPPUp : Script {
                |  override suspend fun run(ctx: ScriptContext) =
                |      TODO("port CeruleanCave_2F_EventScript_ItemPPUp")
                |}"""
                    .trimMargin())

        val report = TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true)

        report.ported shouldBe 1
        val text = file.readText()
        // The flag is the object event's own, which is what NpcService checks before spawning it.
        text shouldContain "ctx.findItem(Items.PP_UP, KantoFlags.FLAG_HIDE_CERULEAN_CAVE_2F_PP_UP, "
        text shouldContain "import de.fiereu.openmmo.items.generated.Items"
        text shouldContain "import de.fiereu.openmmo.story.generated.kanto.KantoFlags"
      }

      test("leaves an item script that belongs to no object event") {
        val (dir, file) =
            stubFile(
                """
                |/**
                | * Not ported yet. Decomp body:
                | * ```
                | * finditem ITEM_PP_UP
                | * end
                | * ```
                | */
                |internal object Nowhere_EventScript_ItemGhost : Script {
                |  override suspend fun run(ctx: ScriptContext) =
                |      TODO("port Nowhere_EventScript_ItemGhost")
                |}"""
                    .trimMargin())
        val before = file.readText()

        val report = TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), true)

        report.ported shouldBe 0
        report.skippedItem shouldBe 1
        file.readText() shouldBe before
      }

      test("check mode reports without writing") {
        val (dir, file) = stubFile(canonicalStub)
        val before = file.readText()

        val report = TrainerBattlePorter("kanto", decomp).portDirectory(File(dir, "kanto"), false)

        report.ported shouldBe 1
        report.filesChanged shouldBe 1
        file.readText() shouldBe before
      }
    })
