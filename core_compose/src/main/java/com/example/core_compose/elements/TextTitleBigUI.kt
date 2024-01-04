package com.example.core_compose.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.core_compose.theme.AppTheme

@Composable
fun TextTitleBigUI(
	text: String,
	modifier: Modifier = Modifier,
	textAlign: TextAlign? = null
) {
	Text(
		text = text,
		fontFamily = FontFamily(
			Font(resId = com.example.core.R.font.montserrat_medium)
		),
		fontSize = 40.sp,
		color = AppTheme.colors.textPrimaryColor,
		modifier = modifier,
		textAlign = textAlign,
		style = TextStyle(
			lineHeight = 48.sp,
			fontWeight = FontWeight(400),
		)
	)
}