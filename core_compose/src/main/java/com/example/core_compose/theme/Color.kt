package com.example.core_compose.theme

import androidx.compose.ui.graphics.Color


val darkPrimary = Color(0xFF232323)
val darkSecondary = Color(0xFF333333)
val darkTertiary = Color(0xFF4F4F4F)

val yellowPrimary = Color(0xFFFFD600)
val greySecondary = Color(0xFFE9E9E9)
val greyTertiary = Color(0xFFF6F6F6)

val greyPrimary = Color(0xFF9F9F9F)
val greyQuaternary = Color(0xFFC1C1C1)
val grey = Color(0xFF676767)
val red = Color(0xFFE64646)
val white = Color(0xFFFFFFFF)

val green = Color(0xFF32A143)


fun lightColors(
    textPrimaryColor: Color = darkPrimary,
    textSecondaryColor: Color = greyPrimary,
    textCaptionColor: Color = darkSecondary,
    disabledYellowButtonColor: Color = greySecondary,
    lightCardColor: Color = white,
    greyCardColor: Color = greyTertiary,
    greyTertiaryDarkSecondary: Color = greyTertiary,
    greyTertiaryDarkTertiary: Color = greyTertiary,
    greyTertiaryGreyPrimary: Color = greyTertiary,
    greyPrimaryDarkTertiary: Color = greyPrimary,
    greySecondaryDarkSecondary: Color = greySecondary,
    whiteDarkTertiary: Color = white,
    greySecondaryGreyTertiary: Color = greySecondary,
    greySecondaryGreyPrimary: Color = greySecondary
): AppColors = AppColors(
    textPrimaryColor = textPrimaryColor,
    textSecondaryColor = textSecondaryColor,
    textCaptionColor = textCaptionColor,
    disabledYellowButtonColor = disabledYellowButtonColor,
    lightCardColor = lightCardColor,
    greyCardColor = greyCardColor,
    greyTertiaryDarkSecondary = greyTertiaryDarkSecondary,
    greyTertiaryDarkTertiary = greyTertiaryDarkTertiary,
    greyTertiaryGreyPrimary = greyTertiaryGreyPrimary,
    greyPrimaryDarkTertiary = greyPrimaryDarkTertiary,
    greySecondaryDarkSecondary = greySecondaryDarkSecondary,
    whiteDarkTertiary = whiteDarkTertiary,
    greySecondaryGreyTertiary = greySecondaryGreyTertiary,
    greySecondaryGreyPrimary = greySecondaryGreyPrimary,
    isLight = true
)

fun darkColors(
    textPrimaryColor: Color = white,
    textSecondaryColor: Color = greySecondary,
    textCaptionColor: Color = greySecondary,
    disabledYellowButtonColor: Color = darkTertiary,
    lightCardColor: Color = darkSecondary,
    greyCardColor: Color = darkSecondary,
    greyTertiaryDarkSecondary: Color = darkSecondary,
    greyTertiaryDarkTertiary: Color = darkTertiary,
    greyTertiaryGreyPrimary: Color = greyPrimary,
    greyPrimaryDarkTertiary: Color = darkTertiary,
    greySecondaryDarkSecondary: Color = darkSecondary,
    whiteDarkTertiary: Color = darkTertiary,
    greySecondaryGreyTertiary: Color = greyTertiary,
    greySecondaryGreyPrimary: Color = greyPrimary
): AppColors = AppColors(
    textPrimaryColor = textPrimaryColor,
    textSecondaryColor = textSecondaryColor,
    textCaptionColor = textCaptionColor,
    disabledYellowButtonColor = disabledYellowButtonColor,
    lightCardColor = lightCardColor,
    greyCardColor = greyCardColor,
    greyTertiaryDarkSecondary = greyTertiaryDarkSecondary,
    greyTertiaryDarkTertiary = greyTertiaryDarkTertiary,
    greyPrimaryDarkTertiary = greyPrimaryDarkTertiary,
    greyTertiaryGreyPrimary = greyTertiaryGreyPrimary,
    greySecondaryDarkSecondary = greySecondaryDarkSecondary,
    whiteDarkTertiary = whiteDarkTertiary,
    greySecondaryGreyTertiary = greySecondaryGreyTertiary,
    greySecondaryGreyPrimary = greySecondaryGreyPrimary,
    isLight = false
)