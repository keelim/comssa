package com.keelim.compose.material

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressDemo(){
    CircularProgressIndicator(
        progress = 0.5f,
        color = Color.Cyan,
        strokeWidth = 8.dp
    )
}

@Composable
fun ProgressDemo2(){
    LinearProgressIndicator(
        progress = 0.5f,
        color = Color.Red
    )
}

@Preview
@Composable
fun PreviewProgress(){
    ProgressDemo()
}

@Preview
@Composable
fun PreviewProgress2(){
    ProgressDemo2()
}