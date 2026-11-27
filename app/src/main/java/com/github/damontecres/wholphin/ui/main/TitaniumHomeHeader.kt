package com.github.damontecres.wholphin.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.github.damontecres.wholphin.R
import com.github.damontecres.wholphin.data.model.BaseItem
import com.github.damontecres.wholphin.preferences.AppThemeColors
import com.github.damontecres.wholphin.ui.theme.LocalTheme

private val Cyan = Color(0xFF71F4FF)
private val Magenta = Color(0xFFFF58D6)
private val Ink = Color(0xFF090B17)

@Composable
internal fun TitaniumHomeHeader(item: BaseItem?) {
    val neonChrome = LocalTheme.current == AppThemeColors.TITANIUM
    val primary = if (neonChrome) Cyan else MaterialTheme.colorScheme.primary
    val secondary = if (neonChrome) Magenta else MaterialTheme.colorScheme.secondary
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 30.dp, top = 36.dp, bottom = 12.dp)
                .height(124.dp)
                .background(Ink),
    ) {
        Image(
            painter = painterResource(R.drawable.titanium_cinema),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier.matchParentSize().drawWithContent {
                    val top = Offset(size.width * .48f, 0f)
                    val bottom = Offset(size.width * .38f, size.height)
                    val edge =
                        Path().apply {
                            moveTo(top.x, top.y)
                            lineTo(size.width, 0f)
                            lineTo(size.width, size.height)
                            lineTo(bottom.x, bottom.y)
                            close()
                        }
                    clipPath(edge) { this@drawWithContent.drawContent() }
                    drawLine(
                        brush = Brush.verticalGradient(listOf(secondary, primary)),
                        start = top,
                        end = bottom,
                        strokeWidth = 2.dp.toPx(),
                    )
                },
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier =
                Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxWidth(.42f)
                    .padding(start = 18.dp, end = 16.dp),
        ) {
            Text(
                text =
                    buildAnnotatedString {
                        append("TITANIUM ")
                        withStyle(SpanStyle(color = primary)) { append("FIN") }
                    },
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                maxLines = 1,
                style = MaterialTheme.typography.headlineLarge,
            )
            item?.title?.let { title ->
                Text(
                    text = title,
                    color = Color(0xFFDAE4F4),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
        Box(
            modifier =
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Brush.horizontalGradient(listOf(primary, secondary, Color.Transparent))),
        )
    }
}
