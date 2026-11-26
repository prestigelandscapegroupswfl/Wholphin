package com.github.damontecres.wholphin.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.CardBorder
import androidx.tv.material3.CardDefaults
import com.github.damontecres.wholphin.preferences.AppThemeColors
import com.github.damontecres.wholphin.ui.nav.TitaniumGradientBrush
import com.github.damontecres.wholphin.ui.theme.LocalTheme

/**
 * Border for cards: under the Titanium theme, the focused card gets the signature
 * cyan -> violet -> magenta gradient outline; every other theme keeps the tv-material3 defaults.
 */
@Composable
@ReadOnlyComposable
fun titaniumCardBorder(): CardBorder =
    if (LocalTheme.current == AppThemeColors.TITANIUM) {
        CardDefaults.border(
            focusedBorder =
                Border(
                    border = BorderStroke(3.dp, TitaniumGradientBrush),
                ),
        )
    } else {
        CardDefaults.border()
    }
