package com.github.damontecres.wholphin.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.CardBorder
import androidx.tv.material3.CardDefaults
import com.github.damontecres.wholphin.ui.theme.LocalTheme
import com.github.damontecres.wholphin.ui.theme.focusGradientBrush

/**
 * Border for cards: under the custom Titanium Fin themes, the focused card gets the theme's
 * signature gradient outline; every other theme keeps the tv-material3 defaults.
 */
@Composable
@ReadOnlyComposable
fun titaniumCardBorder(): CardBorder {
    val brush = LocalTheme.current.focusGradientBrush()
    return if (brush != null) {
        CardDefaults.border(
            focusedBorder =
                Border(
                    border = BorderStroke(3.dp, brush),
                ),
        )
    } else {
        CardDefaults.border()
    }
}
