package com.keelim.compose.basic

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp

@Composable
fun TextStyleDemo(){
    Text(text = "Font Size",
        style = TextStyle(
            fontSize = 28.sp,
            shadow = Shadow(Color.Gray),
            textDirection = TextDirection.ContentOrRtl,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic
        )
    )
}