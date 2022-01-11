package com.keelim.compose.material

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TextDemo1(){
    Text(
        text = "Jetpack Compose",
        color = Color.Red,
        fontSize = 18.sp,
        style = TextStyle(fontSize = 28.sp),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 4.sp,
        textDecoration = TextDecoration.LineThrough,
        textAlign = TextAlign.Center,
        lineHeight = 2.sp,
        overflow = TextOverflow.Ellipsis,
        softWrap = true,
        maxLines = 1,
    )
}

@Preview
@Composable
fun PreviewTextDemo1(){
    MaterialTheme {
        TextDemo1()
    }
}