package com.keelim.compose.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BorderDemo() {
    Card(
        border = BorderStroke(2.dp, SolidColor(Color.Red))) {
        Text(text = "Jetpack Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewBorder() {

}