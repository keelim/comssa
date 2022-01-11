package com.keelim.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundDemo(){
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.background(SolidColor(Color.Blue))
    )
}

@Composable
fun BackgroundDemo2(){
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.background(Color.Red, shape = RoundedCornerShape(4.dp))
    )
}

@Composable
fun BackgroundDemo3(){
    Text(
        text = "Jetpack Compose",
        modifier = Modifier.background(SolidColor(Color.Blue), alpha = 0.6f)
    )
}

@Preview
@Composable
fun PreviewBackground(){
    BackgroundDemo()
}

@Preview
@Composable
fun PreviewBackground2(){
    BackgroundDemo2()
}

@Preview
@Composable
fun PreviewBackground3(){
    BackgroundDemo3()
}