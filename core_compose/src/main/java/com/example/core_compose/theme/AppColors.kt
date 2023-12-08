package com.example.core_compose.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColors = staticCompositionLocalOf { lightColors() }

class AppColors(
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    textCaptionColor: Color,
    disabledYellowButtonColor: Color,
    lightCardColor: Color,
    greyCardColor: Color,
    greyTertiaryDarkSecondary: Color,
    greyTertiaryDarkTertiary: Color,
    greyPrimaryDarkTertiary: Color,
    greyTertiaryGreyPrimary: Color,
    greySecondaryDarkSecondary: Color,
    whiteDarkTertiary: Color,
    greySecondaryGreyTertiary: Color,
    greySecondaryGreyPrimary: Color,
    isLight: Boolean
) {
    var textPrimaryColor by mutableStateOf(textPrimaryColor)
        private set
    var textSecondaryColor by mutableStateOf(textSecondaryColor)
        private set
    var textCaptionColor by mutableStateOf(textCaptionColor)
        private set

    var disabledYellowButtonColor by mutableStateOf(disabledYellowButtonColor)
        private set

    var lightCardColor by mutableStateOf(lightCardColor)
        private set

    var greyCardColor by mutableStateOf(greyCardColor)
        private set

    var greyTertiaryDarkSecondary by mutableStateOf(greyTertiaryDarkSecondary)
        private set

    var greyTertiaryDarkTertiary by mutableStateOf(greyTertiaryDarkTertiary)
        private set

    var greyPrimaryDarkTertiary by mutableStateOf(greyPrimaryDarkTertiary)
        private set

    var greyTertiaryGreyPrimary by mutableStateOf(greyTertiaryGreyPrimary)
        private set

    var greySecondaryDarkSecondary by mutableStateOf(greySecondaryDarkSecondary)
        private set

    var whiteDarkTertiary by mutableStateOf(whiteDarkTertiary)
        private set

    var greySecondaryGreyTertiary by mutableStateOf(greySecondaryGreyTertiary)
        private set

    var greySecondaryGreyPrimary by mutableStateOf(greySecondaryGreyPrimary)
        private set


    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        textPrimaryColor: Color = this.textPrimaryColor,
        textSecondaryColor: Color = this.textSecondaryColor,
        textCaptionColor: Color = this.textCaptionColor,
        disabledYellowButtonColor: Color = this.disabledYellowButtonColor,
        lightCardColor: Color = this.lightCardColor,
        greyCardColor: Color = this.greyCardColor,
        greyTertiaryDarkSecondary: Color = this.greyTertiaryDarkSecondary,
        greyTertiaryDarkTertiary: Color = this.greyTertiaryDarkTertiary,
        greyTertiaryGreyPrimary: Color = this.greyTertiaryGreyPrimary,
        greyPrimaryDarkTertiary: Color = this.greyPrimaryDarkTertiary,
        greySecondaryDarkSecondary: Color = this.greySecondaryDarkSecondary,
        whiteDarkTertiary: Color = this.whiteDarkTertiary,
        greySecondaryGreyTertiary: Color = this.greySecondaryGreyTertiary,
        greySecondaryGreyPrimary: Color = this.greySecondaryGreyPrimary,
    ): AppColors = AppColors(
        textPrimaryColor,
        textSecondaryColor,
        textCaptionColor,
        disabledYellowButtonColor,
        lightCardColor,
        greyCardColor,
        greyTertiaryDarkSecondary,
        greyTertiaryDarkTertiary,
        greyPrimaryDarkTertiary,
        greyTertiaryGreyPrimary,
        greySecondaryDarkSecondary,
        whiteDarkTertiary,
        greySecondaryGreyTertiary,
        greySecondaryGreyPrimary,
        isLight,
    )

    fun updateColorsFrom(other: AppColors) {
        textPrimaryColor = other.textPrimaryColor
        textSecondaryColor = other.textSecondaryColor
        textCaptionColor = other.textCaptionColor
        disabledYellowButtonColor = other.disabledYellowButtonColor
        lightCardColor = other.lightCardColor
        greyCardColor = other.greyCardColor
        greyTertiaryDarkSecondary = other.greyTertiaryDarkSecondary
        greyTertiaryDarkTertiary = other.greyTertiaryDarkTertiary
        greyTertiaryGreyPrimary = other.greyTertiaryGreyPrimary
        greyPrimaryDarkTertiary = other.greyPrimaryDarkTertiary
        greySecondaryDarkSecondary = other.greySecondaryDarkSecondary
        whiteDarkTertiary = other.whiteDarkTertiary
        greySecondaryGreyTertiary = other.greySecondaryGreyTertiary
        greySecondaryGreyPrimary = other.greySecondaryGreyPrimary
    }
}