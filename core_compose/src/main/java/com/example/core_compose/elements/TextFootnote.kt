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
import com.example.core_compose.R
import com.example.core_compose.theme.AppTheme

@Composable
fun TextFootnote(
	text: String,
	modifier: Modifier = Modifier,
	color: Color = AppTheme.colors.textPrimaryColor,
	overflow: TextOverflow = TextOverflow.Ellipsis,
	maxLines: Int = Int.MAX_VALUE,
	textAlign: TextAlign? = null,
) {
	Text(
		text = text,
		fontFamily = FontFamily(
			Font(resId = com.example.core.R.font.montserrat_medium)
		),
		fontSize = 14.sp,
		color = color,
		modifier = modifier,
		style = TextStyle(
			letterSpacing = 0.25.sp,
			lineHeight = 20.sp,
			fontWeight = FontWeight(500),
		),
		maxLines = maxLines,
		overflow = overflow,
		textAlign = textAlign,
	)
}
