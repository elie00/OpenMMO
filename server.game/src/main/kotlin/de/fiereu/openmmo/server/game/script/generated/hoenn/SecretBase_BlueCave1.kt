package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.SecretBase
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * special GetSecretBaseOwnerAndState
 * goto_if_eq VAR_0x8004, 0, SecretBase_EventScript_Trainer0
 * goto_if_eq VAR_0x8004, 1, SecretBase_EventScript_Trainer1
 * goto_if_eq VAR_0x8004, 2, SecretBase_EventScript_Trainer2
 * goto_if_eq VAR_0x8004, 3, SecretBase_EventScript_Trainer3
 * goto_if_eq VAR_0x8004, 4, SecretBase_EventScript_Trainer4
 * goto_if_eq VAR_0x8004, 5, SecretBase_EventScript_Trainer5
 * goto_if_eq VAR_0x8004, 6, SecretBase_EventScript_Trainer6
 * goto_if_eq VAR_0x8004, 7, SecretBase_EventScript_Trainer7
 * goto_if_eq VAR_0x8004, 8, SecretBase_EventScript_Trainer8
 * goto_if_eq VAR_0x8004, 9, SecretBase_EventScript_Trainer9
 * end
 * ```
 */
internal object SecretBase_EventScript_RecordMixTrainer : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_RecordMixTrainer")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer0PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer0PostBattle
 * msgbox SecretBase_Text_Trainer0Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer0DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer0DeclineBattle
 * msgbox SecretBase_Text_Trainer0AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer0 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer0")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer1PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer1PostBattle
 * msgbox SecretBase_Text_Trainer1Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer1DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer1DeclineBattle
 * msgbox SecretBase_Text_Trainer1AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer1 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer1")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer2PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer2PostBattle
 * msgbox SecretBase_Text_Trainer2Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer2DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer2DeclineBattle
 * msgbox SecretBase_Text_Trainer2AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer2 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer2")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer3PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer3PostBattle
 * msgbox SecretBase_Text_Trainer3Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer3DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer3DeclineBattle
 * msgbox SecretBase_Text_Trainer3AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer3 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer3")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer4PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer4PostBattle
 * msgbox SecretBase_Text_Trainer4Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer4DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer4DeclineBattle
 * msgbox SecretBase_Text_Trainer4AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer4 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer4")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer5PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer5PostBattle
 * msgbox SecretBase_Text_Trainer5Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer5DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer5DeclineBattle
 * msgbox SecretBase_Text_Trainer5AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer5 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer5")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer6PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer6PostBattle
 * msgbox SecretBase_Text_Trainer6Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer6DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer6DeclineBattle
 * msgbox SecretBase_Text_Trainer6AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer6 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer6")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer7PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer7PostBattle
 * msgbox SecretBase_Text_Trainer7Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer7DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer7DeclineBattle
 * msgbox SecretBase_Text_Trainer7AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer7 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer7")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer8PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer8PostBattle
 * msgbox SecretBase_Text_Trainer8Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer8DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer8DeclineBattle
 * msgbox SecretBase_Text_Trainer8AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer8 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer8")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_unset FLAG_SYS_GAME_CLEAR, SecretBase_EventScript_Trainer9PreChampion
 * goto_if_eq VAR_RESULT, 1, SecretBase_EventScript_Trainer9PostBattle
 * msgbox SecretBase_Text_Trainer9Intro, MSGBOX_YESNO
 * goto_if_eq VAR_RESULT, NO, SecretBase_EventScript_Trainer9DeclineBattle
 * setvar VAR_RESULT, 1
 * special SetBattledOwnerFromResult
 * call Common_EventScript_SaveGame
 * goto_if_eq VAR_RESULT, 0, SecretBase_EventScript_Trainer9DeclineBattle
 * msgbox SecretBase_Text_Trainer9AcceptBattle, MSGBOX_DEFAULT
 * goto SecretBase_EventScript_BattleTrainer
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer9 : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_Trainer9")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer7DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer7DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer7DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer8DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer8DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer8DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer9DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer9DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer9DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer6DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer6DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer6DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special PrepSecretBaseBattleFlags
 * setvar VAR_0x8004, SPECIAL_BATTLE_SECRET_BASE
 * setvar VAR_0x8005, 0
 * special DoSpecialTrainerBattle
 * call_if_eq VAR_RESULT, B_OUTCOME_DREW, SecretBase_EventScript_DrewSecretBaseBattle
 * call_if_eq VAR_RESULT, B_OUTCOME_WON, SecretBase_EventScript_WonSecretBaseBattle
 * call_if_eq VAR_RESULT, B_OUTCOME_LOST, SecretBase_EventScript_LostSecretBaseBattle
 * special HealPlayerParty
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_BattleTrainer : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port SecretBase_EventScript_BattleTrainer")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer2PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer2PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer2PreChampion)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer3DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer3DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer3DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer2DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer2DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer2DeclineBattle")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer2PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer2PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer2PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer6PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer6PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer6PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer6PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer6PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer6PostBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer4DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer4DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer4DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer5DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer5DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer5DeclineBattle")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer5PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer5PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer5PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer1PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer1PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer1PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer9PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer9PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer9PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer9PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer9PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer9PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer4PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer4PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer4PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer4PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer4PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer4PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer3PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer3PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer3PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer5PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer5PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer5PostBattle)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special SaveGame
 * return
 * ```
 */
internal object Common_EventScript_SaveGame : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port Common_EventScript_SaveGame")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer7PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer7PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer7PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer8PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer8PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer8PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer1PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer1PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer1PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer8PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer8PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer8PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer3PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer3PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer3PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer0PostBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer0PostBattle : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer0PostBattle)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer0PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer0PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer0PreChampion)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox SecretBase_Text_Trainer7PreChampion, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer7PreChampion : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(SecretBase.Trainer7PreChampion)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer1DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer1DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer1DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DeclinedSecretBaseBattle
 * setvar VAR_RESULT, 0
 * special SetBattledOwnerFromResult
 * msgbox SecretBase_Text_Trainer0DeclineBattle, MSGBOX_DEFAULT
 * release
 * end
 * ```
 */
internal object SecretBase_EventScript_Trainer0DeclineBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_Trainer0DeclineBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special DrewSecretBaseBattle
 * return
 * ```
 */
internal object SecretBase_EventScript_DrewSecretBaseBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_DrewSecretBaseBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special WonSecretBaseBattle
 * return
 * ```
 */
internal object SecretBase_EventScript_WonSecretBaseBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_WonSecretBaseBattle")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * special LostSecretBaseBattle
 * return
 * ```
 */
internal object SecretBase_EventScript_LostSecretBaseBattle : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port SecretBase_EventScript_LostSecretBaseBattle")
}

internal val SecretBase_BlueCave1Scripts: Map<String, Script> =
    mapOf(
        "SecretBase_EventScript_RecordMixTrainer" to SecretBase_EventScript_RecordMixTrainer,
        "SecretBase_EventScript_Trainer0" to SecretBase_EventScript_Trainer0,
        "SecretBase_EventScript_Trainer1" to SecretBase_EventScript_Trainer1,
        "SecretBase_EventScript_Trainer2" to SecretBase_EventScript_Trainer2,
        "SecretBase_EventScript_Trainer3" to SecretBase_EventScript_Trainer3,
        "SecretBase_EventScript_Trainer4" to SecretBase_EventScript_Trainer4,
        "SecretBase_EventScript_Trainer5" to SecretBase_EventScript_Trainer5,
        "SecretBase_EventScript_Trainer6" to SecretBase_EventScript_Trainer6,
        "SecretBase_EventScript_Trainer7" to SecretBase_EventScript_Trainer7,
        "SecretBase_EventScript_Trainer8" to SecretBase_EventScript_Trainer8,
        "SecretBase_EventScript_Trainer9" to SecretBase_EventScript_Trainer9,
        "SecretBase_EventScript_Trainer7DeclineBattle" to
            SecretBase_EventScript_Trainer7DeclineBattle,
        "SecretBase_EventScript_Trainer8DeclineBattle" to
            SecretBase_EventScript_Trainer8DeclineBattle,
        "SecretBase_EventScript_Trainer9DeclineBattle" to
            SecretBase_EventScript_Trainer9DeclineBattle,
        "SecretBase_EventScript_Trainer6DeclineBattle" to
            SecretBase_EventScript_Trainer6DeclineBattle,
        "SecretBase_EventScript_BattleTrainer" to SecretBase_EventScript_BattleTrainer,
        "SecretBase_EventScript_Trainer2PreChampion" to SecretBase_EventScript_Trainer2PreChampion,
        "SecretBase_EventScript_Trainer3DeclineBattle" to
            SecretBase_EventScript_Trainer3DeclineBattle,
        "SecretBase_EventScript_Trainer2DeclineBattle" to
            SecretBase_EventScript_Trainer2DeclineBattle,
        "SecretBase_EventScript_Trainer2PostBattle" to SecretBase_EventScript_Trainer2PostBattle,
        "SecretBase_EventScript_Trainer6PreChampion" to SecretBase_EventScript_Trainer6PreChampion,
        "SecretBase_EventScript_Trainer6PostBattle" to SecretBase_EventScript_Trainer6PostBattle,
        "SecretBase_EventScript_Trainer4DeclineBattle" to
            SecretBase_EventScript_Trainer4DeclineBattle,
        "SecretBase_EventScript_Trainer5DeclineBattle" to
            SecretBase_EventScript_Trainer5DeclineBattle,
        "SecretBase_EventScript_Trainer5PreChampion" to SecretBase_EventScript_Trainer5PreChampion,
        "SecretBase_EventScript_Trainer1PreChampion" to SecretBase_EventScript_Trainer1PreChampion,
        "SecretBase_EventScript_Trainer9PostBattle" to SecretBase_EventScript_Trainer9PostBattle,
        "SecretBase_EventScript_Trainer9PreChampion" to SecretBase_EventScript_Trainer9PreChampion,
        "SecretBase_EventScript_Trainer4PostBattle" to SecretBase_EventScript_Trainer4PostBattle,
        "SecretBase_EventScript_Trainer4PreChampion" to SecretBase_EventScript_Trainer4PreChampion,
        "SecretBase_EventScript_Trainer3PostBattle" to SecretBase_EventScript_Trainer3PostBattle,
        "SecretBase_EventScript_Trainer5PostBattle" to SecretBase_EventScript_Trainer5PostBattle,
        "Common_EventScript_SaveGame" to Common_EventScript_SaveGame,
        "SecretBase_EventScript_Trainer7PostBattle" to SecretBase_EventScript_Trainer7PostBattle,
        "SecretBase_EventScript_Trainer8PreChampion" to SecretBase_EventScript_Trainer8PreChampion,
        "SecretBase_EventScript_Trainer1PostBattle" to SecretBase_EventScript_Trainer1PostBattle,
        "SecretBase_EventScript_Trainer8PostBattle" to SecretBase_EventScript_Trainer8PostBattle,
        "SecretBase_EventScript_Trainer3PreChampion" to SecretBase_EventScript_Trainer3PreChampion,
        "SecretBase_EventScript_Trainer0PostBattle" to SecretBase_EventScript_Trainer0PostBattle,
        "SecretBase_EventScript_Trainer0PreChampion" to SecretBase_EventScript_Trainer0PreChampion,
        "SecretBase_EventScript_Trainer7PreChampion" to SecretBase_EventScript_Trainer7PreChampion,
        "SecretBase_EventScript_Trainer1DeclineBattle" to
            SecretBase_EventScript_Trainer1DeclineBattle,
        "SecretBase_EventScript_Trainer0DeclineBattle" to
            SecretBase_EventScript_Trainer0DeclineBattle,
        "SecretBase_EventScript_DrewSecretBaseBattle" to
            SecretBase_EventScript_DrewSecretBaseBattle,
        "SecretBase_EventScript_WonSecretBaseBattle" to SecretBase_EventScript_WonSecretBaseBattle,
        "SecretBase_EventScript_LostSecretBaseBattle" to
            SecretBase_EventScript_LostSecretBaseBattle,
    )
