package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.PetalburgCity_PokemonCenter_1F
import de.fiereu.openmmo.dialog.generated.hoenn.ProfileMan
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext

/**
 * Not ported yet. Decomp body:
 * ```
 * setvar VAR_0x800B, LOCALID_PETALBURG_NURSE
 * call Common_EventScript_PkmnCenterNurse
 * waitmessage
 * waitbuttonpress
 * release
 * end
 * ```
 */
internal object PetalburgCity_PokemonCenter_1F_EventScript_Nurse : Script {
  override suspend fun run(ctx: ScriptContext) = healAtPokemonCenter(ctx)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * goto_if_set FLAG_SYS_CHAT_USED, ProfileMan_EventScript_GivenProfileBefore
 * msgbox ProfileMan_Text_CollectTrainerProfiles, MSGBOX_DEFAULT
 * goto ProfileMan_EventScript_AskToSeeProfile
 * end
 * ```
 */
internal object ProfileMan_EventScript_Man : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ProfileMan_EventScript_Man")
}

internal object PetalburgCity_PokemonCenter_1F_EventScript_FatMan : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(PetalburgCity_PokemonCenter_1F.PCStorageSystem)
}

internal object PetalburgCity_PokemonCenter_1F_EventScript_Youngster : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(PetalburgCity_PokemonCenter_1F.OranBerryRegainedHP)
}

/**
 * Not ported yet. Decomp body:
 * ```
 * lock
 * faceplayer
 * msgbox PetalburgCity_PokemonCenter_1F_Text_ManyTypesOfPokemon, MSGBOX_DEFAULT
 * specialvar VAR_RESULT, IsStarterInParty
 * goto_if_eq VAR_RESULT, TRUE, PetalburgCity_PokemonCenter_1F_EventScript_SayStarterTypeInfo
 * release
 * end
 * ```
 */
internal object PetalburgCity_PokemonCenter_1F_EventScript_Woman : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PetalburgCity_PokemonCenter_1F_EventScript_Woman")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox ProfileMan_Text_MayISeeYourProfile, MSGBOX_DEFAULT
 * multichoice 17, 6, MULTI_YESNOINFO_2, FALSE
 * switch VAR_RESULT
 * case 0, ProfileMan_EventScript_CreateProfile
 * case 1, ProfileMan_EventScript_DeclineShowProfile
 * case 2, ProfileMan_EventScript_Info
 * case MULTI_B_PRESSED, ProfileMan_EventScript_DeclineShowProfile
 * end
 * ```
 */
internal object ProfileMan_EventScript_AskToSeeProfile : Script {
  override suspend fun run(ctx: ScriptContext) = TODO("port ProfileMan_EventScript_AskToSeeProfile")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox ProfileMan_Text_YouHaveWonderfulSmile, MSGBOX_DEFAULT
 * goto ProfileMan_EventScript_AskToSeeNewProfile
 * end
 * ```
 */
internal object ProfileMan_EventScript_GivenProfileBefore : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(ProfileMan.YouHaveWonderfulSmile)
    return ProfileMan_EventScript_AskToSeeNewProfile.run(ctx)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * call_if_eq VAR_STARTER_MON, 0, PetalburgCity_PokemonCenter_1F_EventScript_SayTreeckoType
 * call_if_eq VAR_STARTER_MON, 1, PetalburgCity_PokemonCenter_1F_EventScript_SayTorchicType
 * call_if_eq VAR_STARTER_MON, 2, PetalburgCity_PokemonCenter_1F_EventScript_SayMudkipType
 * release
 * end
 * ```
 */
internal object PetalburgCity_PokemonCenter_1F_EventScript_SayStarterTypeInfo : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port PetalburgCity_PokemonCenter_1F_EventScript_SayStarterTypeInfo")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox ProfileMan_Text_MayISeeYourNewProfile, MSGBOX_DEFAULT
 * multichoice 17, 6, MULTI_YESNOINFO_2, FALSE
 * switch VAR_RESULT
 * case 0, ProfileMan_EventScript_CreateNewProfile
 * case 1, ProfileMan_EventScript_DeclineNewProfile
 * case 2, ProfileMan_EventScript_InfoNewProfile
 * case MULTI_B_PRESSED, ProfileMan_EventScript_DeclineNewProfile
 * end
 * ```
 */
internal object ProfileMan_EventScript_AskToSeeNewProfile : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port ProfileMan_EventScript_AskToSeeNewProfile")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_PokemonCenter_1F_Text_TorchicIsFireType, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object PetalburgCity_PokemonCenter_1F_EventScript_SayTorchicType : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_PokemonCenter_1F.TorchicIsFireType)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_PokemonCenter_1F_Text_MudkipIsWaterType, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object PetalburgCity_PokemonCenter_1F_EventScript_SayMudkipType : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_PokemonCenter_1F.MudkipIsWaterType)
  }
}

/**
 * Ported from the decomp:
 * ```
 * msgbox PetalburgCity_PokemonCenter_1F_Text_TreeckoIsGrassType, MSGBOX_DEFAULT
 * return
 * ```
 */
internal object PetalburgCity_PokemonCenter_1F_EventScript_SayTreeckoType : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(PetalburgCity_PokemonCenter_1F.TreeckoIsGrassType)
  }
}

internal val PetalburgCity_PokemonCenter_1FScripts: Map<String, Script> =
    mapOf(
        "PetalburgCity_PokemonCenter_1F_EventScript_Nurse" to
            PetalburgCity_PokemonCenter_1F_EventScript_Nurse,
        "ProfileMan_EventScript_Man" to ProfileMan_EventScript_Man,
        "PetalburgCity_PokemonCenter_1F_EventScript_FatMan" to
            PetalburgCity_PokemonCenter_1F_EventScript_FatMan,
        "PetalburgCity_PokemonCenter_1F_EventScript_Youngster" to
            PetalburgCity_PokemonCenter_1F_EventScript_Youngster,
        "PetalburgCity_PokemonCenter_1F_EventScript_Woman" to
            PetalburgCity_PokemonCenter_1F_EventScript_Woman,
        "ProfileMan_EventScript_AskToSeeProfile" to ProfileMan_EventScript_AskToSeeProfile,
        "ProfileMan_EventScript_GivenProfileBefore" to ProfileMan_EventScript_GivenProfileBefore,
        "PetalburgCity_PokemonCenter_1F_EventScript_SayStarterTypeInfo" to
            PetalburgCity_PokemonCenter_1F_EventScript_SayStarterTypeInfo,
        "ProfileMan_EventScript_AskToSeeNewProfile" to ProfileMan_EventScript_AskToSeeNewProfile,
        "PetalburgCity_PokemonCenter_1F_EventScript_SayTorchicType" to
            PetalburgCity_PokemonCenter_1F_EventScript_SayTorchicType,
        "PetalburgCity_PokemonCenter_1F_EventScript_SayMudkipType" to
            PetalburgCity_PokemonCenter_1F_EventScript_SayMudkipType,
        "PetalburgCity_PokemonCenter_1F_EventScript_SayTreeckoType" to
            PetalburgCity_PokemonCenter_1F_EventScript_SayTreeckoType,
    )
