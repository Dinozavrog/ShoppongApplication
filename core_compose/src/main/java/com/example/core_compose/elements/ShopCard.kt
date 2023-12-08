package com.example.core_compose.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import com.example.core_compose.theme.AppTheme
import com.example.core_compose.theme.greyPrimary

@Composable
fun ShopCard(
    modifier: Modifier = Modifier,
    shape: Shape,
    onClick: (() -> Unit)? = null,
    content: @Composable() BoxScope.() -> Unit,
) {
    val mergedModifier = onClick
        ?.let {
            modifier
                .background(
                    color = AppTheme.colors.lightCardColor,
                    shape = shape
                )
                .clip(shape)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = greyPrimary),
                    onClick = it,
                )
        }
        ?: modifier
            .background(
                color = AppTheme.colors.lightCardColor,
                shape = shape
            )
            .clip(shape)

    Box(
        modifier = mergedModifier,
    ) {
        content()
    }
}