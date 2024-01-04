package com.example.core_compose.elements

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun RotatingImage(
    modifier: Modifier = Modifier,
    painter: Painter,
) {
    val rotationAngle = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 2000
                0f at 0 with LinearEasing
                360f at 2000 with LinearEasing
            }
        ),
        label = ""
    )

    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .size(160.dp)
                .graphicsLayer {
                    rotationZ = rotationAngle.value
                    transformOrigin = TransformOrigin.Center
                }
        )
    }
}