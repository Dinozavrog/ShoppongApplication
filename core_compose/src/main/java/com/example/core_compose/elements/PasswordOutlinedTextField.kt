package com.example.core_compose.elements

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_compose.R
import com.example.core_compose.theme.AppTheme
import com.example.core_compose.theme.greyPrimary
import com.example.core_compose.theme.greyQuaternary
import com.example.core_compose.theme.red

@Composable
fun PasswordOutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String? = null,
    placeholderText: String? = null,
    supportingText: String? = null,
    errorText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val mergedModifier = modifier.defaultMinSize(minHeight = 56.dp)
    val isPasswordVisible = remember { mutableStateOf(false) }
    val icon = if (isPasswordVisible.value)
        painterResource(id = com.example.core.R.drawable.ic_24_eye_on)
    else
        painterResource(id = com.example.core.R.drawable.ic_24_eye_off)
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = labelText?.let {
            {
                TextCaption2(
                    text = labelText,
                )
            }
        },
        placeholder = placeholderText?.let {
            {
                TextFootnote(
                    text = placeholderText,
                    color = greyPrimary
                )
            }
        },
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
        maxLines = 1,
        shape = RoundedCornerShape(size = 10.dp),
        singleLine = true,
        modifier = mergedModifier,
        textStyle = TextStyle(
            fontFamily = FontFamily(
                Font(resId = com.example.core.R.font.montserrat_medium)
            ),
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            color = AppTheme.colors.textPrimaryColor,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = AppTheme.colors.textPrimaryColor,
            selectionColors = TextSelectionColors(
                AppTheme.colors.textPrimaryColor,
                greyQuaternary
            ),
            focusedBorderColor = AppTheme.colors.textPrimaryColor,
        ),
        isError = errorText != null,
        visualTransformation =
        if (value.text.isEmpty())
            PlaceholderTransformation(placeholderText?:"", greyPrimary)
        else if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible.value = !isPasswordVisible.value
            }) {
                Icon(painter = icon, contentDescription = "password icon")
            }
        },
    )
}