package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.BattleFrontier_ReceptionGate
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_ReceptionGate_Text_WelcomeToBattleFrontier, MSGBOX_DEFAULT
 * msgbox BattleFrontier_ReceptionGate_Text_EnjoyBattleFrontier, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_Greeter : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ReceptionGate.WelcomeToBattleFrontier)
    ctx.say(BattleFrontier_ReceptionGate.EnjoyBattleFrontier)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_ReceptionGate_Text_YourGuideToFacilities, MSGBOX_DEFAULT
 * goto BattleFrontier_ReceptionGate_EventScript_ChooseFacilityToLearnAbout
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_FacilityGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ReceptionGate.YourGuideToFacilities)
    return BattleFrontier_ReceptionGate_EventScript_ChooseFacilityToLearnAbout.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_ReceptionGate_Text_YourGuideToRules, MSGBOX_DEFAULT
 * goto BattleFrontier_ReceptionGate_EventScript_ChooseRuleToLearnAbout
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_RulesGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ReceptionGate.YourGuideToRules)
    return BattleFrontier_ReceptionGate_EventScript_ChooseRuleToLearnAbout.run(ctx)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lock
 * faceplayer
 * msgbox BattleFrontier_ReceptionGate_Text_YourGuideToFrontierPass, MSGBOX_DEFAULT
 * goto BattleFrontier_ReceptionGate_EventScript_ChooseFrontierPassInfoToLearnAbout
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_FrontierPassGuide : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(BattleFrontier_ReceptionGate.YourGuideToFrontierPass)
    return BattleFrontier_ReceptionGate_EventScript_ChooseFrontierPassInfoToLearnAbout.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_ReceptionGate_Text_LearnAboutWhat
 * waitmessage
 * multichoice 15, 0, MULTI_FRONTIER_RULES, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_ReceptionGate_EventScript_LevelMode
 * case 1, BattleFrontier_ReceptionGate_EventScript_Level50
 * case 2, BattleFrontier_ReceptionGate_EventScript_OpenLevel
 * case 3, BattleFrontier_ReceptionGate_EventScript_MonEntry
 * case 4, BattleFrontier_ReceptionGate_EventScript_HoldItems
 * case 5, BattleFrontier_ReceptionGate_EventScript_ExitRulesGuide
 * case MULTI_B_PRESSED, BattleFrontier_ReceptionGate_EventScript_ExitRulesGuide
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_ChooseRuleToLearnAbout : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ReceptionGate_EventScript_ChooseRuleToLearnAbout")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_ReceptionGate_Text_LearnAboutWhich2
 * waitmessage
 * setvar VAR_0x8004, SCROLL_MULTI_BF_RECEPTIONIST
 * special ShowScrollableMultichoice
 * switch VAR_RESULT
 * case 0, BattleFrontier_ReceptionGate_EventScript_BattleTower
 * case 1, BattleFrontier_ReceptionGate_EventScript_BattleDome
 * case 2, BattleFrontier_ReceptionGate_EventScript_BattlePalace
 * case 3, BattleFrontier_ReceptionGate_EventScript_BattleArena
 * case 4, BattleFrontier_ReceptionGate_EventScript_BattleFactory
 * case 5, BattleFrontier_ReceptionGate_EventScript_BattlePike
 * case 6, BattleFrontier_ReceptionGate_EventScript_BattlePyramid
 * case 7, BattleFrontier_ReceptionGate_EventScript_RankingHall
 * case 8, BattleFrontier_ReceptionGate_EventScript_ExchangeCorner
 * case 9, BattleFrontier_ReceptionGate_EventScript_ExitFacilityGuide
 * case MULTI_B_PRESSED, BattleFrontier_ReceptionGate_EventScript_ExitFacilityGuide
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_ChooseFacilityToLearnAbout : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ReceptionGate_EventScript_ChooseFacilityToLearnAbout")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * message BattleFrontier_ReceptionGate_Text_LearnAboutWhich1
 * waitmessage
 * multichoice 16, 4, MULTI_FRONTIER_PASS_INFO, FALSE
 * switch VAR_RESULT
 * case 0, BattleFrontier_ReceptionGate_EventScript_Symbols
 * case 1, BattleFrontier_ReceptionGate_EventScript_RecordBattle
 * case 2, BattleFrontier_ReceptionGate_EventScript_BattlePoints
 * case 3, BattleFrontier_ReceptionGate_EventScript_ExitFrontierPassGuide
 * case MULTI_B_PRESSED, BattleFrontier_ReceptionGate_EventScript_ExitFrontierPassGuide
 * end
 * ```
 */
internal object BattleFrontier_ReceptionGate_EventScript_ChooseFrontierPassInfoToLearnAbout :
    Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port BattleFrontier_ReceptionGate_EventScript_ChooseFrontierPassInfoToLearnAbout")
}

internal val BattleFrontier_ReceptionGateScripts: Map<String, Script> =
    mapOf(
        "BattleFrontier_ReceptionGate_EventScript_Greeter" to
            BattleFrontier_ReceptionGate_EventScript_Greeter,
        "BattleFrontier_ReceptionGate_EventScript_FacilityGuide" to
            BattleFrontier_ReceptionGate_EventScript_FacilityGuide,
        "BattleFrontier_ReceptionGate_EventScript_RulesGuide" to
            BattleFrontier_ReceptionGate_EventScript_RulesGuide,
        "BattleFrontier_ReceptionGate_EventScript_FrontierPassGuide" to
            BattleFrontier_ReceptionGate_EventScript_FrontierPassGuide,
        "BattleFrontier_ReceptionGate_EventScript_ChooseRuleToLearnAbout" to
            BattleFrontier_ReceptionGate_EventScript_ChooseRuleToLearnAbout,
        "BattleFrontier_ReceptionGate_EventScript_ChooseFacilityToLearnAbout" to
            BattleFrontier_ReceptionGate_EventScript_ChooseFacilityToLearnAbout,
        "BattleFrontier_ReceptionGate_EventScript_ChooseFrontierPassInfoToLearnAbout" to
            BattleFrontier_ReceptionGate_EventScript_ChooseFrontierPassInfoToLearnAbout,
    )
