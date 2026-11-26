package com.github.damontecres.wholphin.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.github.damontecres.wholphin.preferences.AppThemeColors

/** Neon Chrome signature gradient: cyan -> violet -> magenta */
val NeonChromeGradientBrush: Brush =
    Brush.horizontalGradient(
        colors =
            listOf(
                Color(0xFF22D3EE),
                Color(0xFF8B5CF6),
                Color(0xFFE879F9),
            ),
    )

/** Midnight Gold signature gradient: gold -> bright gold -> amber */
val MidnightGoldGradientBrush: Brush =
    Brush.horizontalGradient(
        colors =
            listOf(
                Color(0xFFD4AF37),
                Color(0xFFF2C14E),
                Color(0xFFFF9E00),
            ),
    )

/** Retro Arcade signature gradient: hot pink -> orange -> cyan */
val RetroArcadeGradientBrush: Brush =
    Brush.horizontalGradient(
        colors =
            listOf(
                Color(0xFFFF2E88),
                Color(0xFFFF9E00),
                Color(0xFF00E5FF),
            ),
    )

/** The signature focus gradient for the custom Titanium Fin themes, or null for the stock themes */
fun AppThemeColors.focusGradientBrush(): Brush? =
    when (this) {
        AppThemeColors.TITANIUM -> NeonChromeGradientBrush
        AppThemeColors.MIDNIGHT_GOLD -> MidnightGoldGradientBrush
        AppThemeColors.RETRO_ARCADE -> RetroArcadeGradientBrush
        else -> null
    }
