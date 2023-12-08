package com.example.core_compose.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_compose.theme.AppTheme

@Preview
@Composable
fun TopBarUI(
    title: String = "Title",
    leftIcon24: ImageVector? = ImageVector.vectorResource(com.example.core.R.drawable.ic_24_arrow_left),
    onLeftIconClick: (() -> Unit)? = null,
    rightIcon24: ImageVector? = null,
    onRightIconClick: (() -> Unit)? = null

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            Text(

                text = title,
                fontFamily = FontFamily(
                    Font(resId = com.example.core.R.font.montserrat_medium)
                ),
                fontSize = 18.sp,
                color = AppTheme.colors.textPrimaryColor,
                modifier = Modifier
                    .align(Alignment.Center)
            )
            if (leftIcon24 != null) {
                Image(

                    imageVector = leftIcon24,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .clickable { onLeftIconClick?.invoke() }
                        .padding(12.dp)
                )
            }

            if (rightIcon24 != null)
                Image(
                    imageVector = rightIcon24,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .clickable { onRightIconClick?.invoke() }
                        .padding(12.dp)
                        .align(Alignment.CenterEnd)
                )
        }
    }
}