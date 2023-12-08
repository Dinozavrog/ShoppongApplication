package com.example.core_compose.elements

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_compose.theme.AppTheme.colors
import com.example.core_compose.theme.greyPrimary
import com.example.core_compose.theme.greyQuaternary
import com.example.core_compose.theme.red

@Composable
fun ShopOutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String? = null,
    label: @Composable (() -> Unit)? = null,
    placeholderText: String? = null,
    supportingText: String? = null,
    errorText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    enabled: Boolean = true,
    disabledContainerColor: Color = colors.greyTertiaryDarkTertiary

) {
    val mergedModifier = modifier.defaultMinSize(minHeight = 56.dp)
    OutlinedTextField(
        value = value,
        label = label?:labelText?.let {
            {
                TextCaption2(
                    text = labelText,
                )
            }
        },
        onValueChange = onValueChange,
        enabled = enabled,
        visualTransformation = if (value.text.isEmpty())
            PlaceholderTransformation(placeholderText?:"", greyPrimary)
        else VisualTransformation.None,
        supportingText = if (errorText != null) {
            {
                TextCaption1(
                    text = errorText,
                    color = red
                )
            }
        } else {
            supportingText?.let {
                {
                    TextCaption1(
                        text = supportingText,
                        color = greyPrimary
                    )
                }
            }
        },
        keyboardOptions = keyboardOptions,
        maxLines = maxLines,
        singleLine = singleLine,
        minLines = minLines,
        modifier = mergedModifier,
        textStyle = TextStyle(
            fontFamily = FontFamily(
                Font(resId = com.example.core.R.font.montserrat_medium)
            ),
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            color = colors.textPrimaryColor,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = colors.textPrimaryColor,
            selectionColors = TextSelectionColors(
                colors.textPrimaryColor,
                greyQuaternary
            ),
            focusedBorderColor = colors.textPrimaryColor,
            disabledContainerColor = disabledContainerColor,
            disabledBorderColor = Color.Transparent,
        ),
        trailingIcon = trailingIcon,
        isError = errorText != null,
        shape = RoundedCornerShape(size = 10.dp)
    )
}

class PlaceholderTransformation(private val placeholder: String, val placeholderColor: Color) :
    VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return PlaceholderFilter(placeholder, placeholderColor)
    }
}

fun PlaceholderFilter(placeholder: String, placeholderColor: Color): TransformedText {

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return 0
        }

        override fun transformedToOriginal(offset: Int): Int {
            return 0
        }
    }

    return TransformedText(
        AnnotatedString(placeholder, spanStyle = SpanStyle(color = placeholderColor)),
        numberOffsetTranslator
    )
}
