package com.example.core_compose.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.core_compose.theme.AppTheme

@Composable
fun TextCaption1(
    text: String,
    modifier: Modifier = Modifier,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    color: Color = AppTheme.colors.textPrimaryColor,
    textAlign: TextAlign? = null,
) {
    Text(
        text = text,
        fontFamily = FontFamily(
            Font(resId = com.example.core.R.font.montserrat_medium)
        ),
        fontSize = 12.sp,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
        textAlign = textAlign,
        modifier = modifier,
        style = TextStyle(
            lineHeight = 16.sp,
            fontWeight = FontWeight(400),
        )
    )
}