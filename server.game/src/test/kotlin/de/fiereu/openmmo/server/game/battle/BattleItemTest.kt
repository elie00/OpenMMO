package de.fiereu.openmmo.server.game.battle

import de.fiereu.openmmo.common.Pokemon
import de.fiereu.openmmo.common.PokemonMove
import de.fiereu.openmmo.common.enums.EVs
import de.fiereu.openmmo.common.enums.IVs
import de.fiereu.openmmo.common.enums.PokemonContainer
import de.fiereu.openmmo.items.generated.Items
import de.fiereu.openmmo.pokemon.SpeciesRegistry
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import java.time.LocalDateTime
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
class BattleItemTest :
    FunSpec({
      test("Master Ball guarantees 100% catch rate") {
        val species = SpeciesRegistry()
        val def = species.get(150)!! // Mewtwo (low catch rate 3)
        val p =
            Pokemon(
                id = 1L,
                ownerId = 0,
                container = PokemonContainer.PARTY,
                containerSlot = 0,
                dexId = 150,
                seed = 0,
                ot = "",
                nickname = "",
                level = 70,
                hp = 250,
                xp = 0,
                eVs = EVs(),
                iVs = IVs(),
                moves = listOf(PokemonMove(33, 35)),
                isShiny = false,
                hasHiddenAbility = false,
                isAlpha = false,
                isSecret = false,
                isFatefulEncounter = false,
                isRaidEncounter = false,
                caughtAt = LocalDateTime.now(),
            )
        val target = BattleMonState(1L, def, null, p, StatCalculator.computeAll(def, p))

        CatchCalculator.attemptCatch(Items.MASTER_BALL, target, turn = 1, BattleRng(seed = 123))
            .shouldBeTrue()
      }

      test("Weakened and asleep Pokémon is easier to catch") {
        val species = SpeciesRegistry()
        val def = species.get(19)!! // Rattata
        val p =
            Pokemon(
                id = 1L,
                ownerId = 0,
                container = PokemonContainer.PARTY,
                containerSlot = 0,
                dexId = 19,
                seed = 0,
                ot = "",
                nickname = "",
                level = 5,
                hp = 1,
                xp = 0,
                eVs = EVs(),
                iVs = IVs(),
                moves = listOf(PokemonMove(33, 35)),
                isShiny = false,
                hasHiddenAbility = false,
                isAlpha = false,
                isSecret = false,
                isFatefulEncounter = false,
                isRaidEncounter = false,
                caughtAt = LocalDateTime.now(),
            )
        val target = BattleMonState(1L, def, null, p, StatCalculator.computeAll(def, p))
        target.currentHp = 1
        target.primaryStatus = PrimaryStatus.SLEEP

        CatchCalculator.attemptCatch(Items.POKE_BALL, target, turn = 1, BattleRng(seed = 42))
            .shouldBeTrue()
      }
    })
