package com.example.core_compose.elements

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_compose.theme.AppTheme
import com.example.core_compose.theme.darkPrimary
import com.example.core_compose.theme.greyPrimary
import com.example.core_compose.theme.yellowPrimary

@Composable
fun YellowButton(
	text: String,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	enabled:Boolean = true,
	textSize: TextUnit = 18.sp
) {
	val mergedModifier = modifier.defaultMinSize(minHeight = 56.dp)
	Button(
		onClick = onClick,
		shape = RoundedCornerShape(10.dp),
		modifier = mergedModifier,
		colors = ButtonDefaults.buttonColors(
			containerColor = yellowPrimary,
			disabledContainerColor = AppTheme.colors.disabledYellowButtonColor,
			contentColor = darkPrimary,
			disabledContentColor = greyPrimary
		),
		enabled = enabled
	)
	{
		Text(
			text = text,
			fontFamily = FontFamily(
				Font(resId = com.example.core.R.font.montserrat_medium)
			),
			fontSize = textSize,
		)
	}
}