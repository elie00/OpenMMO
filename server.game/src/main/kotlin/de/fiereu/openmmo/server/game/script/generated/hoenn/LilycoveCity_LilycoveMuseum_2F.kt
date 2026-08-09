package de.fiereu.openmmo.server.game.script.generated.hoenn

import de.fiereu.openmmo.dialog.generated.hoenn.LilycoveCity_LilycoveMuseum_2F
import de.fiereu.openmmo.server.game.script.Script
import de.fiereu.openmmo.server.game.script.ScriptContext
import de.fiereu.openmmo.story.generated.hoenn.HoennFlags

/**
 * Not ported yet. Decomp body:
 * ```
 * lockall
 * goto_if_set FLAG_RECEIVED_GLASS_ORNAMENT, LilycoveCity_LilycoveMuseum_2F_EventScript_ReceivedGlassOrnament
 * specialvar VAR_0x8004, CountPlayerMuseumPaintings
 * switch VAR_0x8004
 * case 1, LilycoveCity_LilycoveMuseum_2F_EventScript_AddedPainting
 * case 2, LilycoveCity_LilycoveMuseum_2F_EventScript_AddedPainting
 * case 3, LilycoveCity_LilycoveMuseum_2F_EventScript_AddedPainting
 * case 4, LilycoveCity_LilycoveMuseum_2F_EventScript_AddedPainting
 * case 5, LilycoveCity_LilycoveMuseum_2F_EventScript_ThankPlayer
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_WishToFillExhibit, MSGBOX_NPC
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_Curator : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_LilycoveMuseum_2F_EventScript_Curator")
}

internal object LilycoveCity_LilycoveMuseum_2F_EventScript_Girl : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_LilycoveMuseum_2F.NewPaintingsSurprisedMe)
}

internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ExpertM : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_LilycoveMuseum_2F.NewPaintingsRatherAmusing)
}

internal object LilycoveCity_LilycoveMuseum_2F_EventScript_RichBoy : Script {
  override suspend fun run(ctx: ScriptContext) =
      ctx.say(LilycoveCity_LilycoveMuseum_2F.ThesePaintingsOfYourPokemon)
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_CUTE_PAINTING_MADE, LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCutePainting
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsPinkPictureFrame, MSGBOX_SIGN
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_CutePainting : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_CUTE_PAINTING_MADE))
        return LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCutePainting.run(ctx)
    ctx.say(LilycoveCity_LilycoveMuseum_2F.ItsPinkPictureFrame)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_TOUGH_PAINTING_MADE, LilycoveCity_LilycoveMuseum_2F_EventScript_ShowToughPainting
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsYellowPictureFrame, MSGBOX_SIGN
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ToughPainting : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_TOUGH_PAINTING_MADE))
        return LilycoveCity_LilycoveMuseum_2F_EventScript_ShowToughPainting.run(ctx)
    ctx.say(LilycoveCity_LilycoveMuseum_2F.ItsYellowPictureFrame)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_COOL_PAINTING_MADE, LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCoolPainting
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsRedPictureFrame, MSGBOX_SIGN
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_CoolPainting : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_COOL_PAINTING_MADE))
        return LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCoolPainting.run(ctx)
    ctx.say(LilycoveCity_LilycoveMuseum_2F.ItsRedPictureFrame)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_BEAUTY_PAINTING_MADE, LilycoveCity_LilycoveMuseum_2F_EventScript_ShowBeautyPainting
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsBluePictureFrame, MSGBOX_SIGN
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_BeautyPainting : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_BEAUTY_PAINTING_MADE))
        return LilycoveCity_LilycoveMuseum_2F_EventScript_ShowBeautyPainting.run(ctx)
    ctx.say(LilycoveCity_LilycoveMuseum_2F.ItsBluePictureFrame)
  }
}

/**
 * Ported from the decomp:
 * ```
 * lockall
 * goto_if_set FLAG_SMART_PAINTING_MADE, LilycoveCity_LilycoveMuseum_2F_EventScript_ShowSmartPainting
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsGreenPictureFrame, MSGBOX_SIGN
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_SmartPainting : Script {
  override suspend fun run(ctx: ScriptContext) {
    if (ctx.isFlagSet(HoennFlags.FLAG_SMART_PAINTING_MADE))
        return LilycoveCity_LilycoveMuseum_2F_EventScript_ShowSmartPainting.run(ctx)
    ctx.say(LilycoveCity_LilycoveMuseum_2F.ItsGreenPictureFrame)
  }
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsPaintingOfPokemon, MSGBOX_SIGN
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_MUSEUM_COOL
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCoolPainting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCoolPainting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsPaintingOfPokemon, MSGBOX_SIGN
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_MUSEUM_TOUGH
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ShowToughPainting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_LilycoveMuseum_2F_EventScript_ShowToughPainting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsPaintingOfPokemon, MSGBOX_SIGN
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_MUSEUM_BEAUTY
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ShowBeautyPainting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_LilycoveMuseum_2F_EventScript_ShowBeautyPainting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsPaintingOfPokemon, MSGBOX_SIGN
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_MUSEUM_CUTE
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCutePainting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCutePainting")
}

/**
 * Not ported yet. Decomp body:
 * ```
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_ItsPaintingOfPokemon, MSGBOX_SIGN
 * fadescreen FADE_TO_BLACK
 * showcontestpainting CONTEST_WINNER_MUSEUM_SMART
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ShowSmartPainting : Script {
  override suspend fun run(ctx: ScriptContext) =
      TODO("port LilycoveCity_LilycoveMuseum_2F_EventScript_ShowSmartPainting")
}

/**
 * Ported from the decomp:
 * ```
 * msgbox LilycoveCity_LilycoveMuseum_2F_Text_HonorToHaveYouVisit, MSGBOX_NPC
 * releaseall
 * end
 * ```
 */
internal object LilycoveCity_LilycoveMuseum_2F_EventScript_ReceivedGlassOrnament : Script {
  override suspend fun run(ctx: ScriptContext) {
    ctx.say(LilycoveCity_LilycoveMuseum_2F.HonorToHaveYouVisit)
  }
}

internal val LilycoveCity_LilycoveMuseum_2FScripts: Map<String, Script> =
    mapOf(
        "LilycoveCity_LilycoveMuseum_2F_EventScript_Curator" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_Curator,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_Girl" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_Girl,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ExpertM" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ExpertM,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_RichBoy" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_RichBoy,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_CutePainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_CutePainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ToughPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ToughPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_CoolPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_CoolPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_BeautyPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_BeautyPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_SmartPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_SmartPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCoolPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCoolPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ShowToughPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ShowToughPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ShowBeautyPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ShowBeautyPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCutePainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ShowCutePainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ShowSmartPainting" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ShowSmartPainting,
        "LilycoveCity_LilycoveMuseum_2F_EventScript_ReceivedGlassOrnament" to
            LilycoveCity_LilycoveMuseum_2F_EventScript_ReceivedGlassOrnament,
    )
